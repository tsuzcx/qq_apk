package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TPHeadsetPluginDetector
{
  private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
  private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
  private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
  private static final int AUDIO_TYPE_HEADPHONES = 1;
  private static final String TAG = "TPHeadsetPluginDetector";
  private static boolean hasRegisterReceiver;
  private static boolean isInitted;
  private static List<HeadsetPluginListener> listeners;
  private static WeakReference<Context> mContextRef;
  private static Set<Integer> mCurOutputs;
  private static BroadcastReceiver mReceiver;
  
  static
  {
    AppMethodBeat.i(227860);
    isInitted = false;
    hasRegisterReceiver = false;
    mContextRef = null;
    mReceiver = null;
    listeners = new LinkedList();
    mCurOutputs = null;
    AppMethodBeat.o(227860);
  }
  
  public static void addHeadsetPluginListener(HeadsetPluginListener paramHeadsetPluginListener)
  {
    AppMethodBeat.i(227777);
    try
    {
      if ((listeners.add(paramHeadsetPluginListener)) && (!hasRegisterReceiver))
      {
        registerReceiver();
        hasRegisterReceiver = true;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(227777);
    }
  }
  
  public static void deinit()
  {
    AppMethodBeat.i(227748);
    try
    {
      if ((!isInitted) || (mContextRef == null)) {
        return;
      }
      mContextRef.clear();
      isInitted = false;
      TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "HeadsetPluginDetector deinit succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(227748);
    }
  }
  
  private static AudioManager getAudioManager()
  {
    AppMethodBeat.i(227827);
    if ((!isInitted) || (mContextRef == null))
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, HeadsetPluginDetector is not init yet!");
      AppMethodBeat.o(227827);
      return null;
    }
    Object localObject = (Context)mContextRef.get();
    if (localObject == null)
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, context is null, maybe is invalid!");
      AppMethodBeat.o(227827);
      return null;
    }
    localObject = (AudioManager)((Context)localObject).getApplicationContext().getSystemService("audio");
    if (localObject == null)
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, audioMgr is null!");
      AppMethodBeat.o(227827);
      return null;
    }
    AppMethodBeat.o(227827);
    return localObject;
  }
  
  private static Set<Integer> getAudioOutputs()
  {
    AppMethodBeat.i(227800);
    HashSet localHashSet = new HashSet();
    Object localObject1 = getAudioManager();
    if (localObject1 == null)
    {
      AppMethodBeat.o(227800);
      return localHashSet;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = ((AudioManager)localObject1).getDevices(2);
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getType() == 2) {
            localHashSet.add(Integer.valueOf(0));
          }
          for (;;)
          {
            i += 1;
            break;
            if (localObject2.getType() == 8) {
              localHashSet.add(Integer.valueOf(2));
            } else if (localObject2.getType() == 3) {
              localHashSet.add(Integer.valueOf(1));
            }
          }
        }
      }
    }
    else
    {
      localHashSet.add(Integer.valueOf(0));
      if (isHeadsetPlugin()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (isBluetoothPlugin()) {
        localHashSet.add(Integer.valueOf(2));
      }
    }
    AppMethodBeat.o(227800);
    return localHashSet;
  }
  
  public static Set<Integer> getCurrentRoutes()
  {
    return mCurOutputs;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(227738);
    try
    {
      if (isInitted) {
        return;
      }
      mContextRef = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      initCurrentOutputs();
      TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "HeadsetPluginDetector init succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(227738);
    }
  }
  
  private static void initCurrentOutputs()
  {
    AppMethodBeat.i(227794);
    mCurOutputs = getAudioOutputs();
    AppMethodBeat.o(227794);
  }
  
  public static boolean isAudioRouteTypeOn(int paramInt)
  {
    AppMethodBeat.i(227765);
    if (mCurOutputs == null)
    {
      AppMethodBeat.o(227765);
      return false;
    }
    boolean bool = mCurOutputs.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(227765);
    return bool;
  }
  
  public static boolean isBluetoothPlugin()
  {
    AppMethodBeat.i(227757);
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null)
    {
      AppMethodBeat.o(227757);
      return false;
    }
    boolean bool = localAudioManager.isBluetoothA2dpOn();
    AppMethodBeat.o(227757);
    return bool;
  }
  
  public static boolean isHeadsetPlugin()
  {
    AppMethodBeat.i(227753);
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null)
    {
      AppMethodBeat.o(227753);
      return false;
    }
    boolean bool = localAudioManager.isWiredHeadsetOn();
    AppMethodBeat.o(227753);
    return bool;
  }
  
  private static void notifyAudioOutputStateChange(Set<Integer> paramSet1, Set<Integer> paramSet2)
  {
    AppMethodBeat.i(227821);
    int j = 1;
    int i = j;
    if (paramSet1 != null)
    {
      i = j;
      if (paramSet2 != null)
      {
        i = j;
        if (paramSet1.size() == paramSet2.size())
        {
          i = j;
          if (paramSet2.containsAll(paramSet1)) {
            i = 0;
          }
        }
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(227821);
      return;
    }
    mCurOutputs = paramSet2;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((HeadsetPluginListener)localIterator.next()).onHeadsetPlugin(paramSet1, paramSet2);
      }
    }
    finally
    {
      AppMethodBeat.o(227821);
    }
    AppMethodBeat.o(227821);
  }
  
  private static boolean registerDeviceCallback()
  {
    AppMethodBeat.i(227802);
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null)
    {
      AppMethodBeat.o(227802);
      return false;
    }
    localAudioManager.registerAudioDeviceCallback(new AudioDeviceCallback()
    {
      public final void onAudioDevicesAdded(AudioDeviceInfo[] paramAnonymousArrayOfAudioDeviceInfo)
      {
        AppMethodBeat.i(227667);
        TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onAudioDevicesAdded!");
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
        AppMethodBeat.o(227667);
      }
      
      public final void onAudioDevicesRemoved(AudioDeviceInfo[] paramAnonymousArrayOfAudioDeviceInfo)
      {
        AppMethodBeat.i(227680);
        TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onAudioDevicesRemoved!");
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
        AppMethodBeat.o(227680);
      }
    }, null);
    AppMethodBeat.o(227802);
    return true;
  }
  
  private static void registerReceiver()
  {
    AppMethodBeat.i(227806);
    if ((Build.VERSION.SDK_INT >= 23) && (registerDeviceCallback()))
    {
      AppMethodBeat.o(227806);
      return;
    }
    if (mReceiver == null) {
      mReceiver = new HeadsetPluginReceiver(null);
    }
    if ((!isInitted) || (mContextRef == null))
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
      AppMethodBeat.o(227806);
      return;
    }
    Context localContext = (Context)mContextRef.get();
    if (localContext == null)
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
      AppMethodBeat.o(227806);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
    localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    localContext.registerReceiver(mReceiver, localIntentFilter);
    AppMethodBeat.o(227806);
  }
  
  public static void removeHeadsetPluginListener(HeadsetPluginListener paramHeadsetPluginListener)
  {
    AppMethodBeat.i(227785);
    try
    {
      listeners.remove(paramHeadsetPluginListener);
      if ((listeners.isEmpty()) && (hasRegisterReceiver))
      {
        unregisterReceiver();
        hasRegisterReceiver = false;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(227785);
    }
  }
  
  private static void unregisterReceiver()
  {
    AppMethodBeat.i(227813);
    if ((!isInitted) || (mContextRef == null))
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, HeadsetPluginDetector is not init yet!");
      AppMethodBeat.o(227813);
      return;
    }
    Context localContext = (Context)mContextRef.get();
    if (localContext == null)
    {
      TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
      AppMethodBeat.o(227813);
      return;
    }
    localContext.unregisterReceiver(mReceiver);
    AppMethodBeat.o(227813);
  }
  
  static abstract interface HeadsetPluginListener
  {
    public abstract void onHeadsetPlugin(Set<Integer> paramSet1, Set<Integer> paramSet2);
  }
  
  static class HeadsetPluginReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = 0;
      AppMethodBeat.i(227814);
      TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onReceive: " + paramIntent.getAction());
      paramContext = TPHeadsetPluginDetector.access$100();
      if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
      {
        if (paramIntent.hasExtra("state")) {
          i = paramIntent.getIntExtra("state", 0);
        }
        if (paramContext != null)
        {
          if (i != 0) {
            break label97;
          }
          paramContext.remove(Integer.valueOf(1));
        }
        for (;;)
        {
          TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, paramContext);
          AppMethodBeat.o(227814);
          return;
          label97:
          if (i == 1) {
            paramContext.add(Integer.valueOf(1));
          }
        }
      }
      if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
      {
        if (paramContext != null) {
          paramContext.remove(Integer.valueOf(1));
        }
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, paramContext);
        AppMethodBeat.o(227814);
        return;
      }
      if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        if (paramContext != null)
        {
          if (i != 2) {
            break label209;
          }
          paramContext.add(Integer.valueOf(2));
        }
      }
      for (;;)
      {
        TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.mCurOutputs, paramContext);
        AppMethodBeat.o(227814);
        return;
        label209:
        if (i == 0) {
          paramContext.remove(Integer.valueOf(2));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector
 * JD-Core Version:    0.7.0.1
 */