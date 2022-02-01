package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int s_nSessionIdAllocator = 0;
  final String TRAE_ACTION_PHONE_STATE;
  private boolean _canSwtich2Earphone;
  private String _connectedDev;
  private ITraeAudioCallback mCallback;
  private Context mContext;
  private boolean mIsHostside;
  private long mSessionId;
  
  public TraeAudioSession(Context paramContext, ITraeAudioCallback paramITraeAudioCallback)
  {
    AppMethodBeat.i(13664);
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
    this.mCallback = paramITraeAudioCallback;
    this.mContext = paramContext;
    StringBuilder localStringBuilder;
    Object localObject;
    if ((paramContext == null) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder("AudioSession | Invalid parameters: ctx = ");
      if (paramContext != null) {
        break label215;
      }
      localObject = "null";
    }
    for (;;)
    {
      localObject = localStringBuilder.append((String)localObject).append("; cb = ");
      if (paramITraeAudioCallback == null)
      {
        paramITraeAudioCallback = "null";
        QLog.w("TRAE", 2, paramITraeAudioCallback);
        paramITraeAudioCallback = new IntentFilter();
        paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
        paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        if (paramContext == null) {}
      }
      try
      {
        paramContext.registerReceiver(this, paramITraeAudioCallback);
        registerAudioSession(this, true);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "TraeAudioSession create, mSessionId: " + this.mSessionId);
        }
        AppMethodBeat.o(13664);
        return;
        label215:
        localObject = "{object}";
        continue;
        paramITraeAudioCallback = "{object}";
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "registerReceiver Exception: " + paramContext.getMessage());
          }
        }
      }
    }
  }
  
  public static void ExConnectDevice(Context paramContext, String paramString)
  {
    AppMethodBeat.i(13663);
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13663);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", -9223372036854775808L);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13663);
  }
  
  private int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean)
  {
    AppMethodBeat.i(13666);
    if (this.mContext == null)
    {
      AppMethodBeat.o(13666);
      return -1;
    }
    int i = TraeAudioManager.registerAudioSession(paramTraeAudioSession, paramBoolean, this.mSessionId, this.mContext);
    AppMethodBeat.o(13666);
    return i;
  }
  
  public static long requestSessionId()
  {
    AppMethodBeat.i(13662);
    long l1 = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    long l2 = i;
    AppMethodBeat.o(13662);
    return (l1 << 32) + l2;
  }
  
  public int EarAction(int paramInt)
  {
    AppMethodBeat.i(13674);
    if (this.mIsHostside)
    {
      paramInt = TraeAudioManager.earAction("OPERATION_EARACTION", this.mSessionId, this.mIsHostside, paramInt);
      AppMethodBeat.o(13674);
      return paramInt;
    }
    if ((this.mContext == null) || ((paramInt != 0) && (paramInt != 1)))
    {
      AppMethodBeat.o(13674);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
    localIntent.putExtra("EXTRA_EARACTION", paramInt);
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13674);
    return 0;
  }
  
  public int connectDevice(String paramString)
  {
    AppMethodBeat.i(13672);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.connectDevice("OPERATION_CONNECTDEVICE", this.mSessionId, this.mIsHostside, paramString);
      AppMethodBeat.o(13672);
      return i;
    }
    if ((this.mContext == null) || (paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13672);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13672);
    return 0;
  }
  
  public int connectHighestPriorityDevice()
  {
    AppMethodBeat.i(13673);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13673);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13673);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13673);
    return 0;
  }
  
  public int disableDeviceSwitch()
  {
    AppMethodBeat.i(13668);
    int i = TraeAudioManager.disableDeviceSwitch();
    AppMethodBeat.o(13668);
    return i;
  }
  
  public int getConnectedDevice()
  {
    AppMethodBeat.i(13676);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getConnectedDevice("OPERATION_GETCONNECTEDDEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13676);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13676);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13676);
    return 0;
  }
  
  public int getConnectingDevice()
  {
    AppMethodBeat.i(13677);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getConnectingDevice("OPERATION_GETCONNECTINGDEVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13677);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13677);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13677);
    return 0;
  }
  
  public int getDeviceList()
  {
    AppMethodBeat.i(13670);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13670);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13670);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13670);
    return 0;
  }
  
  public int getStreamType()
  {
    AppMethodBeat.i(13671);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13671);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13671);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13671);
    return 0;
  }
  
  public int isDeviceChangabled()
  {
    AppMethodBeat.i(13675);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.isDeviceChangabled("OPERATION_ISDEVICECHANGABLED", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13675);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13675);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13675);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(13688);
    if (paramIntent == null) {}
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[ERROR] intent = null!!");
      }
      AppMethodBeat.o(13688);
      return;
    }
    catch (Exception paramContext)
    {
      if (!QLog.isColorLevel()) {
        break label238;
      }
      QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
      AppMethodBeat.o(13688);
      return;
    }
    long l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
    int j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    label238:
    label245:
    String str1;
    String str2;
    String str3;
    int i;
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction()))
    {
      if ("NOTIFY_SERVICE_STATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("AudioSession|[onServiceStateUpdate]");
          if (!bool1) {
            break label245;
          }
        }
        for (paramContext = "on";; paramContext = "off")
        {
          QLog.w("TRAE", 2, paramContext);
          if (this.mCallback != null) {
            this.mCallback.onServiceStateUpdate(bool1);
          }
          AppMethodBeat.o(13688);
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
            break label1767;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1770;
          }
          break label1767;
        }
        paramContext = paramContext + "\n";
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        }
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        if (this.mCallback != null) {
          this.mCallback.onDeviceListUpdate((String[])localObject, str1, str2, str3);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]".concat(String.valueOf(bool1)));
        }
        if (this.mCallback != null) {
          this.mCallback.onDeviceChangabledUpdate(bool1);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("NOTIFY_STREAMTYPE_UPDATE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + j + " st:" + i);
        }
        if (this.mCallback != null) {
          this.mCallback.onStreamTypeUpdate(i);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("NOTIFY_ROUTESWITCHSTART".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
        localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
        if ((this.mCallback != null) && (paramContext != null) && (localObject != null)) {
          this.mCallback.onAudioRouteSwitchStart(paramContext, (String)localObject);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("NOTIFY_ROUTESWITCHEND".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
        l1 = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
        if ((this.mCallback != null) && (paramContext != null) && (l1 != -1L)) {
          this.mCallback.onAudioRouteSwitchEnd(paramContext, l1);
        }
        AppMethodBeat.o(13688);
      }
    }
    else if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      long l2 = this.mSessionId;
      if (l2 != l1)
      {
        AppMethodBeat.o(13688);
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
        label886:
        if (i < localObject.length)
        {
          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label1777;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1780;
          }
          break label1777;
        }
        paramContext = paramContext + "\n";
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + j + " connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        }
        if (this.mCallback != null) {
          this.mCallback.onGetDeviceListRes(j, (String[])localObject, str1, str2, str3);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_CONNECTDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.mCallback != null)
        {
          localObject = this.mCallback;
          bool1 = bool2;
          if (j == 0) {
            bool1 = true;
          }
          ((ITraeAudioCallback)localObject).onConnectDeviceRes(j, paramContext, bool1);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_EARACTION".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
          if (!bool1) {
            break label1787;
          }
        }
      }
    }
    label1767:
    label1770:
    label1777:
    label1780:
    label1787:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if (this.mCallback != null) {
        this.mCallback.onIsDeviceChangabledRes(j, bool1);
      }
      AppMethodBeat.o(13688);
      return;
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.mCallback != null) {
          this.mCallback.onGetConnectedDeviceRes(j, paramContext);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.mCallback != null) {
          this.mCallback.onGetConnectingDeviceRes(j, paramContext);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
        }
        if (this.mCallback != null) {
          this.mCallback.onGetStreamTypeRes(j, i);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("NOTIFY_RING_COMPLETION".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + j + " userData:" + paramContext);
        }
        if (this.mCallback != null) {
          this.mCallback.onRingCompletion(j, paramContext);
        }
        AppMethodBeat.o(13688);
        return;
      }
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:".concat(String.valueOf(j)));
        }
        if (this.mCallback != null) {
          this.mCallback.onVoicecallPreprocessRes(j);
        }
      }
      AppMethodBeat.o(13688);
      return;
      bool1 = false;
      i += 1;
      break;
      bool1 = false;
      i += 1;
      break label886;
    }
  }
  
  public void onReceiveCallback(Intent paramIntent)
  {
    AppMethodBeat.i(13687);
    if (paramIntent == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[ERROR] intent = null!!");
      }
      AppMethodBeat.o(13687);
      return;
    }
    catch (Exception localException)
    {
      long l1;
      String str;
      int i;
      long l2;
      if (!QLog.isColorLevel()) {
        break label220;
      }
      QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + localException.getMessage());
      AppMethodBeat.o(13687);
    }
    l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    str = paramIntent.getStringExtra("PARAM_OPERATION");
    i = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      l2 = this.mSessionId;
      if (l2 != l1)
      {
        AppMethodBeat.o(13687);
        return;
      }
      if ("OPERATION_VOICECALL_PREPROCESS".equals(str))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:".concat(String.valueOf(i)));
        }
        if (this.mCallback != null) {
          this.mCallback.onVoicecallPreprocessRes(i);
        }
      }
    }
    AppMethodBeat.o(13687);
    return;
    label220:
  }
  
  public int recoverAudioFocus()
  {
    AppMethodBeat.i(13686);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.recoverAudioFocus("OPERATION_RECOVER_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13686);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13686);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13686);
    return 0;
  }
  
  public void release()
  {
    AppMethodBeat.i(13665);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "TraeAudioSession release, mSessionId: " + this.mSessionId);
    }
    if (this.mContext != null) {}
    try
    {
      this.mContext.unregisterReceiver(this);
      label53:
      registerAudioSession(this, false);
      this.mContext = null;
      this.mCallback = null;
      AppMethodBeat.o(13665);
      return;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }
  
  public int requestReleaseAudioFocus()
  {
    AppMethodBeat.i(13685);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.requestReleaseAudioFocus("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13685);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13685);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13685);
    return 0;
  }
  
  public void setCallback(ITraeAudioCallback paramITraeAudioCallback)
  {
    this.mCallback = paramITraeAudioCallback;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13681);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
      AppMethodBeat.o(13681);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13681);
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
    AppMethodBeat.o(13681);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(13682);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
      AppMethodBeat.o(13682);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13682);
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
    AppMethodBeat.o(13682);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(13683);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
      AppMethodBeat.o(13683);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13683);
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
    AppMethodBeat.o(13683);
    return 0;
  }
  
  public int startService(String paramString)
  {
    AppMethodBeat.i(13667);
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
      AppMethodBeat.o(13667);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13667);
      return -1;
    }
    paramString = new Intent();
    paramString.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    paramString.putExtra("PARAM_SESSIONID", this.mSessionId);
    paramString.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    paramString.putExtra("EXTRA_DATA_DEVICECONFIG", str);
    this.mContext.sendBroadcast(paramString);
    AppMethodBeat.o(13667);
    return 0;
  }
  
  public int stopRing()
  {
    AppMethodBeat.i(13684);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.stopRing("OPERATION_STOPRING", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13684);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13684);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13684);
    return 0;
  }
  
  public int stopService()
  {
    AppMethodBeat.i(13669);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13669);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13669);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13669);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13680);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.voiceCallAudioParamChanged("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
      AppMethodBeat.o(13680);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13680);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13680);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    AppMethodBeat.i(13679);
    if (this.mIsHostside)
    {
      int i = TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, this.mIsHostside);
      AppMethodBeat.o(13679);
      return i;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13679);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13679);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13678);
    if (this.mIsHostside)
    {
      paramInt1 = TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
      AppMethodBeat.o(13678);
      return paramInt1;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13678);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    AppMethodBeat.o(13678);
    return 0;
  }
  
  public static abstract interface ITraeAudioCallback
  {
    public abstract void onAudioRouteSwitchEnd(String paramString, long paramLong);
    
    public abstract void onAudioRouteSwitchStart(String paramString1, String paramString2);
    
    public abstract void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void onDeviceChangabledUpdate(boolean paramBoolean);
    
    public abstract void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void onGetConnectedDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetConnectingDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void onGetStreamTypeRes(int paramInt1, int paramInt2);
    
    public abstract void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean);
    
    public abstract void onRingCompletion(int paramInt, String paramString);
    
    public abstract void onServiceStateUpdate(boolean paramBoolean);
    
    public abstract void onStreamTypeUpdate(int paramInt);
    
    public abstract void onVoicecallPreprocessRes(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */