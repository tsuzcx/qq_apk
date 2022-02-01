package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TPAudioPassThroughPluginDetector
{
  private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
  private static final String TAG = "TPAudioPassThroughPluginDetector";
  private static boolean hasRegisterReceiver;
  private static boolean isInitted;
  private static List<AudioPassThroughPluginListener> listeners;
  private static TPAudioPassThroughCapabilities mAudioPassThroughCapabilities;
  private static WeakReference<Context> mContextRef;
  private static Handler mHandler;
  private static boolean mIsAudioPassThroughPlugin;
  private static BroadcastReceiver mReceiver;
  
  static
  {
    AppMethodBeat.i(189693);
    isInitted = false;
    hasRegisterReceiver = false;
    mContextRef = null;
    mReceiver = null;
    listeners = new LinkedList();
    mIsAudioPassThroughPlugin = false;
    mAudioPassThroughCapabilities = null;
    AppMethodBeat.o(189693);
  }
  
  public static void addListener(AudioPassThroughPluginListener paramAudioPassThroughPluginListener)
  {
    AppMethodBeat.i(189684);
    try
    {
      if ((listeners.add(paramAudioPassThroughPluginListener)) && (!hasRegisterReceiver))
      {
        registerReceiver();
        hasRegisterReceiver = true;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(189684);
    }
  }
  
  public static void deinit()
  {
    AppMethodBeat.i(189683);
    try
    {
      if ((!isInitted) || (mContextRef == null)) {
        return;
      }
      mContextRef.clear();
      isInitted = false;
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector deinit succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(189683);
    }
  }
  
  private static Looper getLooper()
  {
    AppMethodBeat.i(189681);
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      AppMethodBeat.o(189681);
      return localLooper;
    }
    localLooper = Looper.getMainLooper();
    AppMethodBeat.o(189681);
    return localLooper;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(189682);
    try
    {
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector init enter!");
      if (isInitted) {
        return;
      }
      mContextRef = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      mHandler = new Handler(getLooper());
      registerReceiver();
      hasRegisterReceiver = true;
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector init succeed!");
      return;
    }
    finally
    {
      AppMethodBeat.o(189682);
    }
  }
  
  public static boolean isAudioPassThroughPlugin()
  {
    try
    {
      boolean bool = mIsAudioPassThroughPlugin;
      return bool;
    }
    finally {}
  }
  
  public static boolean isAudioPassThroughSupport(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189686);
    if (mAudioPassThroughCapabilities != null)
    {
      if ((mAudioPassThroughCapabilities.supportsEncoding(paramInt1)) && (paramInt2 <= mAudioPassThroughCapabilities.getMaxChannelCount()))
      {
        AppMethodBeat.o(189686);
        return true;
      }
      AppMethodBeat.o(189686);
      return false;
    }
    TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "isAudioPassThroughSupport failed, mAudioPassThroughCapabilities is not init yet!");
    AppMethodBeat.o(189686);
    return false;
  }
  
  private static void notifyAudioPassThroughStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(189690);
    int i = 1;
    if (mIsAudioPassThroughPlugin == paramBoolean) {
      i = 0;
    }
    if (i == 0)
    {
      AppMethodBeat.o(189690);
      return;
    }
    mIsAudioPassThroughPlugin = paramBoolean;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((AudioPassThroughPluginListener)localIterator.next()).onAudioPassThroughPlugin(paramBoolean);
      }
    }
    finally
    {
      AppMethodBeat.o(189690);
    }
    AppMethodBeat.o(189690);
  }
  
  private static void onUpdateAudioCapabilities(TPAudioPassThroughCapabilities paramTPAudioPassThroughCapabilities)
  {
    AppMethodBeat.i(189689);
    if (!paramTPAudioPassThroughCapabilities.equals(mAudioPassThroughCapabilities))
    {
      mAudioPassThroughCapabilities = paramTPAudioPassThroughCapabilities;
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "onUpdateAudioCapabilities AudioCapabilities:" + mAudioPassThroughCapabilities.toString());
    }
    AppMethodBeat.o(189689);
  }
  
  private static void registerReceiver()
  {
    Object localObject = null;
    AppMethodBeat.i(189687);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "registerReceiver enter");
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(189687);
      return;
    }
    if ((!isInitted) || (mContextRef == null))
    {
      TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
      AppMethodBeat.o(189687);
      return;
    }
    if (mReceiver == null) {
      mReceiver = new HdmiAudioPlugBroadcastReceiver(null);
    }
    Context localContext = (Context)mContextRef.get();
    if (localContext == null)
    {
      TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
      AppMethodBeat.o(189687);
      return;
    }
    if (mReceiver != null)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.media.action.HDMI_AUDIO_PLUG");
      localObject = localContext.registerReceiver(mReceiver, (IntentFilter)localObject, null, mHandler);
    }
    mAudioPassThroughCapabilities = TPAudioPassThroughCapabilities.getCapabilities(localContext, (Intent)localObject);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "registerReceiver leave");
    AppMethodBeat.o(189687);
  }
  
  public static void removeListener(AudioPassThroughPluginListener paramAudioPassThroughPluginListener)
  {
    AppMethodBeat.i(189685);
    try
    {
      listeners.remove(paramAudioPassThroughPluginListener);
      if ((listeners.isEmpty()) && (hasRegisterReceiver))
      {
        unregisterReceiver();
        hasRegisterReceiver = false;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(189685);
    }
  }
  
  private static void unregisterReceiver()
  {
    AppMethodBeat.i(189688);
    if ((!isInitted) || (mContextRef == null))
    {
      TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
      AppMethodBeat.o(189688);
      return;
    }
    Context localContext = (Context)mContextRef.get();
    if (localContext == null)
    {
      TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
      AppMethodBeat.o(189688);
      return;
    }
    localContext.unregisterReceiver(mReceiver);
    AppMethodBeat.o(189688);
  }
  
  static abstract interface AudioPassThroughPluginListener
  {
    public abstract void onAudioPassThroughPlugin(boolean paramBoolean);
  }
  
  static class HdmiAudioPlugBroadcastReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = false;
      AppMethodBeat.i(189680);
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "HdmiAudioPlugBroadcastReceiver onReceive: " + paramIntent.getAction());
      int i;
      if (paramIntent != null)
      {
        i = paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0);
        if (i != 0) {
          break label116;
        }
      }
      for (;;)
      {
        TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "HdmiAudioPlugBroadcastReceiver audioPassThroughState:" + i + " bPlugin:" + bool);
        TPAudioPassThroughPluginDetector.access$100(new TPAudioPassThroughCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)));
        TPAudioPassThroughPluginDetector.access$200(bool);
        AppMethodBeat.o(189680);
        return;
        label116:
        if (i == 1) {
          bool = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector
 * JD-Core Version:    0.7.0.1
 */