package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int s_nSessionIdAllocator = 0;
  final String TRAE_ACTION_PHONE_STATE;
  private boolean _canSwtich2Earphone;
  private String _connectedDev;
  private TraeAudioSession.a mCallback;
  private Context mContext;
  private boolean mIsHostside;
  private long mSessionId;
  
  public TraeAudioSession(Context paramContext, TraeAudioSession.a parama)
  {
    AppMethodBeat.i(65801);
    this.mIsHostside = false;
    this.mSessionId = -9223372036854775808L;
    this._connectedDev = "DEVICE_NONE";
    this._canSwtich2Earphone = true;
    this.TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    if (Process.myPid() == TraeAudioManager._gHostProcessId) {
      bool = true;
    }
    this.mIsHostside = bool;
    this.mSessionId = requestSessionId();
    this.mCallback = parama;
    this.mContext = paramContext;
    StringBuilder localStringBuilder;
    Object localObject;
    if (paramContext == null)
    {
      a.dUd();
      localStringBuilder = new StringBuilder("AudioSession | Invalid parameters: ctx = ");
      if (paramContext != null) {
        break label207;
      }
      localObject = "null";
    }
    for (;;)
    {
      localObject = localStringBuilder.append((String)localObject).append("; cb = ");
      if (parama == null)
      {
        parama = "null";
        a.iP("TRAE", parama);
        parama = new IntentFilter();
        parama.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
        parama.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        if (paramContext == null) {}
      }
      try
      {
        paramContext.registerReceiver(this, parama);
        registerAudioSession(this, true);
        a.dUd();
        a.iP("TRAE", "TraeAudioSession create, mSessionId: " + this.mSessionId);
        AppMethodBeat.o(65801);
        return;
        label207:
        localObject = "{object}";
        continue;
        parama = "{object}";
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          a.dUd();
          a.iO("TRAE", "registerReceiver Exception: " + paramContext.getMessage());
        }
      }
    }
  }
  
  public static void ExConnectDevice(Context paramContext, String paramString)
  {
    AppMethodBeat.i(65800);
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(65800);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", -9223372036854775808L);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65800);
  }
  
  private int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean)
  {
    AppMethodBeat.i(146901);
    if (this.mContext == null)
    {
      AppMethodBeat.o(146901);
      return -1;
    }
    int i = TraeAudioManager.registerAudioSession(paramTraeAudioSession, paramBoolean, this.mSessionId, this.mContext);
    AppMethodBeat.o(146901);
    return i;
  }
  
  public static long requestSessionId()
  {
    AppMethodBeat.i(65799);
    long l1 = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    long l2 = i;
    AppMethodBeat.o(65799);
    return (l1 << 32) + l2;
  }
  
  public int EarAction(int paramInt)
  {
    AppMethodBeat.i(65810);
    if (this.mIsHostside)
    {
      paramInt = TraeAudioManager.earAction("OPERATION_EARACTION", this.mSessionId, this.mIsHostside, paramInt);
      AppMethodBeat.o(65810);
      return paramInt;
    }
    if ((this.mContext == null) || ((paramInt != 0) && (paramInt != 1)))
    {
      AppMethodBeat.o(65810);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
    localIntent.putExtra("EXTRA_EARACTION", paramInt);
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65810);
    return 0;
  }
  
  public int connectDevice(String paramString)
  {
    AppMethodBeat.i(65808);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.connectDevice("OPERATION_CONNECTDEVICE", this.mSessionId, this.mIsHostside, paramString);
      AppMethodBeat.o(65808);
      return i;
    }
    if ((this.mContext == null) || (paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(65808);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65808);
    return 0;
  }
  
  public int connectHighestPriorityDevice()
  {
    AppMethodBeat.i(65809);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65809);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65809);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65809);
    return 0;
  }
  
  public int disableDeviceSwitch()
  {
    AppMethodBeat.i(146902);
    int i = TraeAudioManager.disableDeviceSwitch();
    AppMethodBeat.o(146902);
    return i;
  }
  
  public int getConnectedDevice()
  {
    AppMethodBeat.i(65812);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getConnectedDevice("OPERATION_GETCONNECTEDDEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65812);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65812);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65812);
    return 0;
  }
  
  public int getConnectingDevice()
  {
    AppMethodBeat.i(65813);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getConnectingDevice("OPERATION_GETCONNECTINGDEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65813);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65813);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65813);
    return 0;
  }
  
  public int getDeviceList()
  {
    AppMethodBeat.i(65806);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65806);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65806);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65806);
    return 0;
  }
  
  public int getStreamType()
  {
    AppMethodBeat.i(65807);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65807);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65807);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65807);
    return 0;
  }
  
  public int isDeviceChangabled()
  {
    AppMethodBeat.i(65811);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.isDeviceChangabled("OPERATION_ISDEVICECHANGABLED", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65811);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65811);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65811);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(65823);
    if (paramIntent == null) {}
    Object localObject;
    try
    {
      a.dUd();
      a.iP("TRAE", "[ERROR] intent = null!!");
      AppMethodBeat.o(65823);
      return;
    }
    catch (Exception paramContext)
    {
      a.dUd();
      a.iO("TRAE", "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
      AppMethodBeat.o(65823);
      return;
    }
    long l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
    int j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    String str1;
    String str2;
    String str3;
    int i;
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction()))
    {
      if ("NOTIFY_SERVICE_STATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
        a.dUd();
        localObject = new StringBuilder("AudioSession|[onServiceStateUpdate]");
        if (bool1) {}
        for (paramContext = "on";; paramContext = "off")
        {
          a.iP("TRAE", paramContext);
          if (this.mCallback != null) {
            this.mCallback.a(bool1);
          }
          AppMethodBeat.o(65823);
          return;
        }
      }
      if ("NOTIFY_DEVICELISTUPDATE".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        if (i < localObject.length)
        {
          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label1704;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1707;
          }
          break label1704;
        }
        paramContext = paramContext + "\n";
        a.dUd();
        a.iP("TRAE", "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        if (this.mCallback != null) {
          this.mCallback.a((String[])localObject, str1, str2, str3);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
        a.dUd();
        a.iP("TRAE", "AudioSession|[onDeviceChangabledUpdate]".concat(String.valueOf(bool1)));
        if (this.mCallback != null) {
          this.mCallback.b(bool1);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("NOTIFY_STREAMTYPE_UPDATE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        a.dUd();
        a.iP("TRAE", "AudioSession|[onStreamTypeUpdate] err:" + j + " st:" + i);
        if (this.mCallback != null) {
          this.mCallback.a(i);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("NOTIFY_ROUTESWITCHSTART".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
        localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
        if ((this.mCallback != null) && (paramContext != null) && (localObject != null)) {
          this.mCallback.a(paramContext, (String)localObject);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("NOTIFY_ROUTESWITCHEND".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
        l1 = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
        if ((this.mCallback != null) && (paramContext != null) && (l1 != -1L)) {
          this.mCallback.a(paramContext, l1);
        }
        AppMethodBeat.o(65823);
      }
    }
    else if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      long l2 = this.mSessionId;
      if (l2 != l1)
      {
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_GETDEVICELIST".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        bool1 = bool3;
        label859:
        if (i < localObject.length)
        {
          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label1714;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1717;
          }
          break label1714;
        }
        paramContext = paramContext + "\n";
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        a.dUd();
        a.iP("TRAE", "AudioSession|[onGetDeviceListRes] err:" + j + " connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        if (this.mCallback != null) {
          this.mCallback.a(j, (String[])localObject, str1, str2, str3);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_CONNECTDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        a.dUd();
        a.iP("TRAE", "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        if (this.mCallback != null)
        {
          localObject = this.mCallback;
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
          ((TraeAudioSession.a)localObject).a(j, paramContext, bool1);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_EARACTION".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
        a.dUd();
        a.iP("TRAE", "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
        a.dUd();
        localObject = new StringBuilder("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
        if (!bool1) {
          break label1724;
        }
      }
    }
    label1704:
    label1707:
    label1714:
    label1717:
    label1724:
    for (paramContext = "Y";; paramContext = "N")
    {
      a.iP("TRAE", paramContext);
      if (this.mCallback != null) {
        this.mCallback.a(j, bool1);
      }
      AppMethodBeat.o(65823);
      return;
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
        a.dUd();
        a.iP("TRAE", "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
        if (this.mCallback != null) {
          this.mCallback.a(j, paramContext);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
        a.dUd();
        a.iP("TRAE", "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
        if (this.mCallback != null) {
          this.mCallback.b(j, paramContext);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        a.dUd();
        a.iP("TRAE", "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
        if (this.mCallback != null) {
          this.mCallback.a(j, i);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("NOTIFY_RING_COMPLETION".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        a.dUd();
        a.iP("TRAE", "AudioSession|[onRingCompletion] err:" + j + " userData:" + paramContext);
        if (this.mCallback != null) {
          this.mCallback.c(j, paramContext);
        }
        AppMethodBeat.o(65823);
        return;
      }
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramContext))
      {
        a.dUd();
        a.iP("TRAE", "AudioSession|[onVoicecallPreprocess] err:".concat(String.valueOf(j)));
        if (this.mCallback != null) {
          this.mCallback.b(j);
        }
      }
      AppMethodBeat.o(65823);
      return;
      bool1 = false;
      i += 1;
      break;
      bool1 = false;
      i += 1;
      break label859;
    }
  }
  
  public void onReceiveCallback(Intent paramIntent)
  {
    AppMethodBeat.i(146903);
    if (paramIntent == null) {}
    try
    {
      a.dUd();
      a.iP("TRAE", "[ERROR] intent = null!!");
      AppMethodBeat.o(146903);
      return;
    }
    catch (Exception localException)
    {
      long l1;
      String str;
      int i;
      long l2;
      a.dUd();
      a.iO("TRAE", "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + localException.getMessage());
      AppMethodBeat.o(146903);
    }
    l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    str = paramIntent.getStringExtra("PARAM_OPERATION");
    i = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      l2 = this.mSessionId;
      if (l2 != l1)
      {
        AppMethodBeat.o(146903);
        return;
      }
      if ("OPERATION_VOICECALL_PREPROCESS".equals(str))
      {
        a.dUd();
        a.iP("TRAE", "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:".concat(String.valueOf(i)));
        if (this.mCallback != null) {
          this.mCallback.b(i);
        }
      }
    }
    AppMethodBeat.o(146903);
    return;
  }
  
  public int recoverAudioFocus()
  {
    AppMethodBeat.i(65822);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.recoverAudioFocus("OPERATION_RECOVER_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65822);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65822);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65822);
    return 0;
  }
  
  public void release()
  {
    AppMethodBeat.i(65802);
    a.dUd();
    a.iP("TRAE", "TraeAudioSession release, mSessionId: " + this.mSessionId);
    if (this.mContext != null) {}
    try
    {
      this.mContext.unregisterReceiver(this);
      label50:
      registerAudioSession(this, false);
      this.mContext = null;
      this.mCallback = null;
      AppMethodBeat.o(65802);
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }
  
  public int requestReleaseAudioFocus()
  {
    AppMethodBeat.i(65821);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.requestReleaseAudioFocus("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65821);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65821);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65821);
    return 0;
  }
  
  public void setCallback(TraeAudioSession.a parama)
  {
    this.mCallback = parama;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(65817);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
      AppMethodBeat.o(65817);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65817);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65817);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(65818);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
      AppMethodBeat.o(65818);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65818);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65818);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(65819);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
      AppMethodBeat.o(65819);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65819);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65819);
    return 0;
  }
  
  public int startService(String paramString)
  {
    AppMethodBeat.i(65804);
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0) {}
    }
    else
    {
      str = "internal_disable_dev_switch";
    }
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.startService("OPERATION_STARTSERVICE", this.mSessionId, this.mIsHostside, str);
      AppMethodBeat.o(65804);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65804);
      return -1;
    }
    paramString = new Intent();
    paramString.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    paramString.putExtra("PARAM_SESSIONID", this.mSessionId);
    paramString.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    paramString.putExtra("EXTRA_DATA_DEVICECONFIG", str);
    this.mContext.sendBroadcast(paramString);
    AppMethodBeat.o(65804);
    return 0;
  }
  
  public int stopRing()
  {
    AppMethodBeat.i(65820);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.stopRing("OPERATION_STOPRING", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65820);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65820);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65820);
    return 0;
  }
  
  public int stopService()
  {
    AppMethodBeat.i(65805);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65805);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65805);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65805);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65816);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.voiceCallAudioParamChanged("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
      AppMethodBeat.o(65816);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65816);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65816);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    AppMethodBeat.i(65815);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(65815);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65815);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65815);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65814);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
      AppMethodBeat.o(65814);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(65814);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(65814);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */