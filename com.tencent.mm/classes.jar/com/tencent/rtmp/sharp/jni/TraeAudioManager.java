package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager
  extends BroadcastReceiver
{
  public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
  public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
  public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
  static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
  static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
  public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
  public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
  public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
  static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
  public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
  public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
  public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
  public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
  public static final String DEVICE_NONE = "DEVICE_NONE";
  public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
  public static final int DEVICE_STATUS_CONNECTED = 2;
  public static final int DEVICE_STATUS_CONNECTING = 1;
  public static final int DEVICE_STATUS_DISCONNECTED = 0;
  public static final int DEVICE_STATUS_DISCONNECTING = 3;
  public static final int DEVICE_STATUS_ERROR = -1;
  public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
  public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
  public static final int EARACTION_AWAY = 0;
  public static final int EARACTION_CLOSE = 1;
  public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
  public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
  public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
  public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
  public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
  public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
  public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
  public static final int FORCE_ANALOG_DOCK = 8;
  public static final int FORCE_BT_A2DP = 4;
  public static final int FORCE_BT_CAR_DOCK = 6;
  public static final int FORCE_BT_DESK_DOCK = 7;
  public static final int FORCE_BT_SCO = 3;
  public static final int FORCE_DEFAULT = 0;
  public static final int FORCE_DIGITAL_DOCK = 9;
  public static final int FORCE_HEADPHONES = 2;
  public static final int FORCE_NONE = 0;
  public static final int FORCE_NO_BT_A2DP = 10;
  public static final int FORCE_SPEAKER = 1;
  public static final int FORCE_WIRED_ACCESSORY = 5;
  public static final int FOR_COMMUNICATION = 0;
  public static final int FOR_DOCK = 3;
  public static final int FOR_MEDIA = 1;
  public static final int FOR_RECORD = 2;
  public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
  public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
  public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
  public static boolean IsEarPhoneSupported = false;
  public static boolean IsMusicScene = false;
  public static boolean IsUpdateSceneFlag = false;
  public static final int MODE_MUSIC_PLAYBACK = 2;
  public static final int MODE_MUSIC_PLAY_RECORD = 1;
  public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
  public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
  public static final int MODE_VOICE_CHAT = 0;
  public static final int MODE_VOICE_PLAYBACK = 4;
  public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
  public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
  public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
  public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
  public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
  public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
  public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
  public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
  private static final int NUM_FORCE_CONFIG = 11;
  private static final int NUM_FORCE_USE = 4;
  public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
  public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
  public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
  public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
  public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
  public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
  public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
  public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
  public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
  public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
  public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
  public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
  public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
  public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
  public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
  public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
  public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
  public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
  public static final String PARAM_DEVICE = "PARAM_DEVICE";
  public static final String PARAM_ERROR = "PARAM_ERROR";
  public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
  public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
  public static final String PARAM_OPERATION = "PARAM_OPERATION";
  public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
  public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
  public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
  public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
  public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
  public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
  public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
  public static final String PARAM_RING_URI = "PARAM_RING_URI";
  public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
  public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
  public static final String PARAM_STATUS = "PARAM_STATUS";
  public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
  public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
  public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
  public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
  public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
  public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
  public static final int RES_ERRCODE_NONE = 0;
  public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
  public static final int RES_ERRCODE_SERVICE_OFF = 1;
  public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
  public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
  public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
  public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
  public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  static int _gHostProcessId;
  static TraeAudioManager _ginstance;
  static ReentrantLock _glock;
  public static boolean enableDeviceSwitchFlag;
  static final String[] forceName;
  boolean IsBluetoothA2dpExisted;
  int _activeMode;
  AudioManager _am;
  TraeAudioSessionHost _audioSessionHost;
  BluetoohHeadsetCheckInterface _bluetoothCheck;
  Context _context;
  DeviceConfigManager _deviceConfigManager;
  ReentrantLock _lock;
  int _modePolicy;
  int _prevMode;
  int _streamType;
  switchThread _switchThread;
  TraeAudioManagerLooper mTraeAudioManagerLooper;
  String sessionConnectedDev;
  
  static
  {
    AppMethodBeat.i(13761);
    IsMusicScene = false;
    IsEarPhoneSupported = false;
    IsUpdateSceneFlag = false;
    enableDeviceSwitchFlag = true;
    _glock = new ReentrantLock();
    _ginstance = null;
    _gHostProcessId = -1;
    forceName = new String[] { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
    AppMethodBeat.o(13761);
  }
  
  TraeAudioManager(Context paramContext)
  {
    AppMethodBeat.i(13722);
    this._am = null;
    this._context = null;
    this._activeMode = 0;
    this._prevMode = 0;
    this._streamType = 0;
    this._modePolicy = -1;
    this.IsBluetoothA2dpExisted = true;
    this._audioSessionHost = null;
    this._deviceConfigManager = null;
    this._bluetoothCheck = null;
    this.sessionConnectedDev = "DEVICE_NONE";
    this.mTraeAudioManagerLooper = null;
    this._lock = new ReentrantLock();
    this._switchThread = null;
    AudioDeviceInterface.LogTraceEntry(" context:".concat(String.valueOf(paramContext)));
    if (paramContext == null)
    {
      AppMethodBeat.o(13722);
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManagerLooper(this);
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13722);
  }
  
  static boolean IsEabiLowVersion()
  {
    AppMethodBeat.i(13706);
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      }
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1)))
      {
        AppMethodBeat.o(13706);
        return true;
      }
    }
    catch (Exception localException)
    {
      if (IsEabiLowVersionByAbi(str2))
      {
        AppMethodBeat.o(13706);
        return true;
      }
      AppMethodBeat.o(13706);
      return false;
    }
    AppMethodBeat.o(13706);
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    AppMethodBeat.i(13705);
    if (paramString == null)
    {
      AppMethodBeat.o(13705);
      return true;
    }
    if (paramString.contains("x86"))
    {
      AppMethodBeat.o(13705);
      return false;
    }
    if (paramString.contains("mips"))
    {
      AppMethodBeat.o(13705);
      return false;
    }
    if (paramString.equalsIgnoreCase("armeabi"))
    {
      AppMethodBeat.o(13705);
      return true;
    }
    if (paramString.equalsIgnoreCase("armeabi-v7a"))
    {
      AppMethodBeat.o(13705);
      return false;
    }
    if (paramString.equalsIgnoreCase("arm64-v8a"))
    {
      AppMethodBeat.o(13705);
      return false;
    }
    AppMethodBeat.o(13705);
    return true;
  }
  
  public static int SetSpeakerForTest(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(13714);
    int j = -1;
    _glock.lock();
    int i;
    if (_ginstance != null) {
      i = _ginstance.InternalSetSpeaker(paramContext, paramBoolean);
    }
    for (;;)
    {
      _glock.unlock();
      AppMethodBeat.o(13714);
      return i;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
        i = j;
      }
    }
  }
  
  public static boolean checkDevName(String paramString)
  {
    AppMethodBeat.i(13701);
    if (paramString == null)
    {
      AppMethodBeat.o(13701);
      return false;
    }
    if ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString)))
    {
      AppMethodBeat.o(13701);
      return false;
    }
    AppMethodBeat.o(13701);
    return true;
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(13731);
    if (paramString2 == null)
    {
      AppMethodBeat.o(13731);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    int i = sendMessage(32775, localHashMap);
    AppMethodBeat.o(13731);
    return i;
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13732);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32789, localHashMap);
    AppMethodBeat.o(13732);
    return i;
  }
  
  static int disableDeviceSwitch()
  {
    enableDeviceSwitchFlag = false;
    return 0;
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(13733);
    if ((paramInt != 0) && (paramInt != 1))
    {
      AppMethodBeat.o(13733);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    paramInt = sendMessage(32776, localHashMap);
    AppMethodBeat.o(13733);
    return paramInt;
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    AppMethodBeat.i(13760);
    if (Build.MANUFACTURER.equals("Google"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "forceVolumeControlStream, Google phone nothing to do");
      }
      AppMethodBeat.o(13760);
      return;
    }
    Class localClass = Integer.TYPE;
    paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
    }
    AppMethodBeat.o(13760);
  }
  
  static int getAudioSource(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(13707);
    if (IsMusicScene)
    {
      AppMethodBeat.o(13707);
      return 0;
    }
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:0");
      }
      AppMethodBeat.o(13707);
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
      }
      AppMethodBeat.o(13707);
      return paramInt;
    }
    if (j >= 11) {
      i = 7;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    }
    AppMethodBeat.o(13707);
    return i;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(13708);
    if (IsMusicScene)
    {
      AppMethodBeat.o(13708);
      return 3;
    }
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:3");
      }
      AppMethodBeat.o(13708);
      return 3;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      }
      AppMethodBeat.o(13708);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(13709);
    if (IsMusicScene)
    {
      AppMethodBeat.o(13709);
      return 0;
    }
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:0");
      }
      AppMethodBeat.o(13709);
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
      }
      AppMethodBeat.o(13709);
      return paramInt;
    }
    if (j >= 11) {
      i = 3;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
    }
    AppMethodBeat.o(13709);
    return i;
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13735);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32778, localHashMap);
    AppMethodBeat.o(13735);
    return i;
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13736);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32779, localHashMap);
    AppMethodBeat.o(13736);
    return i;
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13727);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32774, localHashMap);
    AppMethodBeat.o(13727);
    return i;
  }
  
  static String getForceConfigName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < forceName.length)) {
      return forceName[paramInt];
    }
    return "unknow";
  }
  
  static int getForceUse(int paramInt)
  {
    AppMethodBeat.i(13759);
    Object localObject = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localObject });
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + getForceConfigName(((Integer)localObject).intValue()));
      }
      paramInt = ((Integer)localObject).intValue();
      AppMethodBeat.o(13759);
      return paramInt;
    }
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13728);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32784, localHashMap);
    AppMethodBeat.o(13728);
    return i;
  }
  
  public static int init(Context paramContext)
  {
    AppMethodBeat.i(13720);
    new StringBuilder("TraeAudioManager init _ginstance:").append(_ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13720);
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(13754);
    Object localObject = null;
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      AppMethodBeat.o(13754);
      return paramObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "invokeMethod Exception:" + paramString.getMessage());
          paramObject = localObject;
        }
      }
    }
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    AppMethodBeat.i(13755);
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      AppMethodBeat.o(13755);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "ClassNotFound:".concat(String.valueOf(paramString1)));
          paramArrayOfObject = localObject;
        }
      }
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "NoSuchMethod:".concat(String.valueOf(paramString2)));
          paramArrayOfObject = localObject;
        }
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "IllegalArgument:".concat(String.valueOf(paramString2)));
          paramArrayOfObject = localObject;
        }
      }
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "IllegalAccess:".concat(String.valueOf(paramString2)));
          paramArrayOfObject = localObject;
        }
      }
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "InvocationTarget:".concat(String.valueOf(paramString2)));
          paramArrayOfObject = localObject;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramArrayOfObject = localObject;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
          paramArrayOfObject = localObject;
        }
      }
    }
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    AppMethodBeat.i(13704);
    if (paramInt != -1)
    {
      AppMethodBeat.o(13704);
      return false;
    }
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 2"))
      {
        AppMethodBeat.o(13704);
        return true;
      }
      if (Build.MODEL.equals("MI 2A"))
      {
        AppMethodBeat.o(13704);
        return true;
      }
      if (Build.MODEL.equals("MI 2S"))
      {
        AppMethodBeat.o(13704);
        return true;
      }
      if (Build.MODEL.equals("MI 2SC"))
      {
        AppMethodBeat.o(13704);
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SCH-I959")))
    {
      AppMethodBeat.o(13704);
      return true;
    }
    AppMethodBeat.o(13704);
    return false;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13734);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32777, localHashMap);
    AppMethodBeat.o(13734);
    return i;
  }
  
  public static boolean isHandfree(String paramString)
  {
    AppMethodBeat.i(13702);
    if (!checkDevName(paramString))
    {
      AppMethodBeat.o(13702);
      return false;
    }
    if ("DEVICE_SPEAKERPHONE".equals(paramString))
    {
      AppMethodBeat.o(13702);
      return true;
    }
    AppMethodBeat.o(13702);
    return false;
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13743);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32791, localHashMap);
    AppMethodBeat.o(13743);
    return i;
  }
  
  public static int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean, long paramLong, Context paramContext)
  {
    AppMethodBeat.i(13718);
    int i = -1;
    _glock.lock();
    if (_ginstance != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      _ginstance._audioSessionHost.add(paramTraeAudioSession, paramLong, paramContext);
    }
    for (;;)
    {
      i = 0;
      _glock.unlock();
      AppMethodBeat.o(13718);
      return i;
      label56:
      _ginstance._audioSessionHost.remove(paramLong);
    }
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13742);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32790, localHashMap);
    AppMethodBeat.o(13742);
    return i;
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13719);
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    AppMethodBeat.o(13719);
    return i;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13758);
    Object localObject = Integer.TYPE;
    Class localClass = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, new Class[] { localObject, localClass });
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    }
    AppMethodBeat.o(13758);
  }
  
  static void setParameters(String paramString)
  {
    AppMethodBeat.i(13756);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setParameters  :".concat(String.valueOf(paramString)));
    }
    invokeStaticMethod("android.media.AudioSystem", "setParameters", new Object[] { paramString }, new Class[] { String.class });
    AppMethodBeat.o(13756);
  }
  
  static void setPhoneState(int paramInt)
  {
    AppMethodBeat.i(13757);
    Class localClass = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    AppMethodBeat.o(13757);
  }
  
  static int startRing(String paramString1, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    AppMethodBeat.i(13740);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    paramInt1 = sendMessage(32782, localHashMap);
    AppMethodBeat.o(13740);
    return paramInt1;
  }
  
  static int startService(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(13729);
    if (paramString2.length() <= 0)
    {
      AppMethodBeat.o(13729);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    int i = sendMessage(32772, localHashMap);
    AppMethodBeat.o(13729);
    return i;
  }
  
  static int stopRing(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13741);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32783, localHashMap);
    AppMethodBeat.o(13741);
    return i;
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13730);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32773, localHashMap);
    AppMethodBeat.o(13730);
    return i;
  }
  
  public static void uninit()
  {
    AppMethodBeat.i(13721);
    new StringBuilder("TraeAudioManager uninit _ginstance:").append(_ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance != null)
    {
      _ginstance.release();
      _ginstance = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13721);
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13739);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    paramInt1 = sendMessage(32788, localHashMap);
    AppMethodBeat.o(13739);
    return paramInt1;
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(13738);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32781, localHashMap);
    AppMethodBeat.o(13738);
    return i;
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13737);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    paramInt1 = sendMessage(32780, localHashMap);
    AppMethodBeat.o(13737);
    return paramInt1;
  }
  
  public BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context paramContext, DeviceConfigManager paramDeviceConfigManager)
  {
    AppMethodBeat.i(13753);
    Object localObject1;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = new BluetoohHeadsetCheck();
      localObject2 = localObject1;
      if (!((BluetoohHeadsetCheckInterface)localObject1).init(paramContext, paramDeviceConfigManager)) {
        localObject2 = new BluetoohHeadsetCheckFake();
      }
      if (QLog.isColorLevel())
      {
        paramDeviceConfigManager = new StringBuilder("CreateBluetoothCheck:").append(((BluetoohHeadsetCheckInterface)localObject2).interfaceDesc()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label144;
        }
      }
    }
    label144:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      AppMethodBeat.o(13753);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new BluetoohHeadsetCheckFor2x();
        break;
      }
      localObject1 = new BluetoohHeadsetCheckFake();
      break;
    }
  }
  
  int InternalConnectDevice(String paramString, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(13745);
    AudioDeviceInterface.LogTraceEntry(" devName:".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(13745);
      return -1;
    }
    if ((IsMusicScene) && (paramString.equals("DEVICE_EARPHONE")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "MusicScene, Connect device:" + paramString + " failed");
      }
      AppMethodBeat.o(13745);
      return -1;
    }
    if ((!IsEarPhoneSupported) && (paramString.equals("DEVICE_EARPHONE")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "IsEarPhoneSupported = false, Connect device:" + paramString + " failed");
      }
      AppMethodBeat.o(13745);
      return -1;
    }
    if ((!paramBoolean) && (!this._deviceConfigManager.getConnectedDevice().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.getConnectedDevice())))
    {
      AppMethodBeat.o(13745);
      return 0;
    }
    if ((checkDevName(paramString) != true) || (this._deviceConfigManager.getVisible(paramString) != true))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " checkDevName fail");
      }
      AppMethodBeat.o(13745);
      return -1;
    }
    if (InternalIsDeviceChangeable() != true)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
      }
      AppMethodBeat.o(13745);
      return -1;
    }
    if (this._switchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.getDeviceName());
      }
      this._switchThread.quit();
      this._switchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this._switchThread = new earphoneSwitchThread();
    }
    for (;;)
    {
      if (this._switchThread != null)
      {
        this._switchThread.setDeviceConnectParam(paramHashMap);
        this._switchThread.start();
      }
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13745);
      return 0;
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        this._switchThread = new speakerSwitchThread();
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        this._switchThread = new headsetSwitchThread();
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        this._switchThread = new bluetoothHeadsetSwitchThread();
      }
    }
  }
  
  boolean InternalIsDeviceChangeable()
  {
    AppMethodBeat.i(13747);
    String str = this._deviceConfigManager.getConnectingDevice();
    if ((str == null) || (str.equals("DEVICE_NONE")) || (str.equals("")))
    {
      AppMethodBeat.o(13747);
      return true;
    }
    AppMethodBeat.o(13747);
    return false;
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    AppMethodBeat.i(13752);
    if (this._context == null)
    {
      AppMethodBeat.o(13752);
      return -1;
    }
    final boolean bool = InternalIsDeviceChangeable();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13655);
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
        localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", bool);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
        AppMethodBeat.o(13655);
      }
    });
    AppMethodBeat.o(13752);
    return 0;
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AppMethodBeat.i(13751);
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null)
    {
      AppMethodBeat.o(13751);
      return -1;
    }
    Object localObject = this._deviceConfigManager.getSnapParams();
    final ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    final String str1 = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    final String str2 = this._deviceConfigManager.getBluetoothName();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(13935);
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
        localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
        localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str1);
        localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", this.val$prevCon);
        localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", str2);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
        AppMethodBeat.o(13935);
      }
    });
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13751);
    return 0;
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13744);
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null))
    {
      AppMethodBeat.o(13744);
      return -1;
    }
    if (IsMusicScene)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
      }
      AppMethodBeat.o(13744);
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    if ((!IsEarPhoneSupported) && (str.equals("DEVICE_EARPHONE")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:" + str + " failed");
      }
      AppMethodBeat.o(13744);
      return -1;
    }
    boolean bool = InternalIsDeviceChangeable();
    int i;
    if (checkDevName(str) != true) {
      i = 7;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("sessonID:").append((Long)paramHashMap.get("PARAM_SESSIONID")).append(" devName:").append(str).append(" bChangabled:");
        if (!bool) {
          break label309;
        }
      }
      label309:
      for (Object localObject = "Y";; localObject = "N")
      {
        QLog.w("TRAE", 2, (String)localObject + " err:" + i);
        if (i == 0) {
          break label317;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        AppMethodBeat.o(13744);
        return -1;
        if (!this._deviceConfigManager.getVisible(str))
        {
          i = 8;
          break;
        }
        if (bool) {
          break label427;
        }
        i = 9;
        break;
      }
      label317:
      if (str.equals(this._deviceConfigManager.getConnectedDevice()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " --has connected!");
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        AppMethodBeat.o(13744);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " --connecting...");
      }
      InternalConnectDevice(str, paramHashMap, false);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13744);
      return 0;
      label427:
      i = 0;
    }
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13748);
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.getConnectedDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(13748);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13749);
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.getConnectingDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(13749);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13746);
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(13746);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    AppMethodBeat.i(13717);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "SetMode entry:".concat(String.valueOf(paramInt)));
    }
    if (this._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setMode:" + paramInt + " fail am=null");
      }
      AppMethodBeat.o(13717);
      return;
    }
    this._am.setMode(paramInt);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("setMode:").append(paramInt);
      if (this._am.getMode() == paramInt) {
        break label145;
      }
    }
    label145:
    for (String str = "fail";; str = "success")
    {
      QLog.w("TRAE", 2, str);
      AppMethodBeat.o(13717);
      return;
    }
  }
  
  int InternalSetSpeaker(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(13715);
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
      }
      AppMethodBeat.o(13715);
      return -1;
    }
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
      }
      AppMethodBeat.o(13715);
      return -1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("InternalSetSpeaker entry:speaker:");
      if (!localAudioManager.isSpeakerphoneOn()) {
        break label177;
      }
      paramContext = "Y";
      localStringBuilder = localStringBuilder.append(paramContext).append("-->:");
      if (!paramBoolean) {
        break label184;
      }
    }
    label177:
    label184:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if ((!isCloseSystemAPM(this._modePolicy)) || (this._activeMode == 2)) {
        break label191;
      }
      i = InternalSetSpeakerSpe(localAudioManager, paramBoolean);
      AppMethodBeat.o(13715);
      return i;
      paramContext = "N";
      break;
    }
    label191:
    if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
      localAudioManager.setSpeakerphoneOn(paramBoolean);
    }
    if (localAudioManager.isSpeakerphoneOn() == paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + paramBoolean + " res:" + i + " mode:" + localAudioManager.getMode());
      }
      AppMethodBeat.o(13715);
      return i;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(13716);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    }
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label184;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      AppMethodBeat.o(13716);
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      break;
      label184:
      i = -1;
    }
  }
  
  void _updateEarphoneVisable()
  {
    AppMethodBeat.i(13711);
    if (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
      }
      this._deviceConfigManager.setVisible("DEVICE_EARPHONE", false);
      AppMethodBeat.o(13711);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
    }
    this._deviceConfigManager.setVisible("DEVICE_EARPHONE", true);
    AppMethodBeat.o(13711);
  }
  
  void checkAutoDeviceListUpdate()
  {
    AppMethodBeat.i(13712);
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
      }
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      internalSendMessage(32785, new HashMap());
    }
    AppMethodBeat.o(13712);
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13713);
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label126;
        }
      }
      label126:
      for (Object localObject = " piugin";; localObject = " plugout")
      {
        QLog.w("TRAE", 2, (String)localObject + " connectedDev:" + this._deviceConfigManager.getConnectedDevice());
        _updateEarphoneVisable();
        this._deviceConfigManager.resetVisiableUpdateFlag();
        if (!paramBoolean) {
          break;
        }
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_DEVICE", paramString);
        internalSendMessage(32786, (HashMap)localObject);
        AppMethodBeat.o(13713);
        return;
      }
      localObject = this._deviceConfigManager.getConnectedDevice();
      if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_DEVICE", paramString);
        internalSendMessage(32787, (HashMap)localObject);
        AppMethodBeat.o(13713);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
      }
      internalSendMessage(32785, new HashMap());
    }
    AppMethodBeat.o(13713);
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(13726);
    int i = -1;
    if (this.mTraeAudioManagerLooper != null) {
      i = this.mTraeAudioManagerLooper.sendMessage(paramInt, paramHashMap);
    }
    AppMethodBeat.o(13726);
    return i;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(13725);
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = "" + " [" + paramContext + "] ";
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      localObject = new StringBuilder().append((String)localObject);
      if (i == 0)
      {
        paramContext = "unplugged";
        paramContext = paramContext;
      }
    }
    else
    {
      localObject = paramContext + " mic:";
      int j = paramIntent.getIntExtra("microphone", -1);
      paramContext = (Context)localObject;
      if (j != -1)
      {
        paramIntent = new StringBuilder().append((String)localObject);
        if (j != 1) {
          break label258;
        }
        paramContext = "Y";
        label174:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug:: ".concat(String.valueOf(paramContext)));
      }
      paramContext = this._deviceConfigManager;
      if (1 != i) {
        break label265;
      }
    }
    label258:
    label265:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug exit");
      }
      AppMethodBeat.o(13725);
      return;
      paramContext = "plugged";
      break;
      paramContext = "unkown";
      break label174;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(13724);
    if ((paramIntent == null) || (paramContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "onReceive intent or context is null!");
      }
      AppMethodBeat.o(13724);
      return;
    }
    String str2;
    String str1;
    boolean bool1;
    boolean bool2;
    try
    {
      str2 = paramIntent.getAction();
      str1 = paramIntent.getStringExtra("PARAM_OPERATION");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
      }
      if (this._deviceConfigManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TRAE", 2, "_deviceConfigManager null!");
        }
        AppMethodBeat.o(13724);
        return;
      }
      bool1 = this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET");
      bool2 = this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET");
      if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
      {
        onHeadsetPlug(paramContext, paramIntent);
        if ((!bool1) && (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET") == true)) {
          checkDevicePlug("DEVICE_WIREDHEADSET", true);
        }
        if ((bool1 != true) || (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))) {
          break label1040;
        }
        checkDevicePlug("DEVICE_WIREDHEADSET", false);
        AppMethodBeat.o(13724);
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "deal with receiver failed." + paramContext.getMessage());
      }
      AppMethodBeat.o(13724);
      return;
    }
    if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction())) {
      if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   OPERATION:".concat(String.valueOf(str1)));
        }
        if ("OPERATION_STARTSERVICE".equals(str1))
        {
          startService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"));
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_STOPSERVICE".equals(str1))
        {
          stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_GETDEVICELIST".equals(str1))
        {
          getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_GETSTREAMTYPE".equals(str1))
        {
          getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_CONNECTDEVICE".equals(str1))
        {
          connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
        {
          connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_EARACTION".equals(str1))
        {
          earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
        {
          isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
        {
          getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
        {
          getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        int i;
        int j;
        if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
        {
          i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
          j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
          voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
        {
          voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
        {
          i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
          j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
          voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_STARTRING".equals(str1))
        {
          i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
          j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
          paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
          str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
          bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
          String str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
          int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
          bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
          startRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
          AppMethodBeat.o(13724);
          return;
        }
        if ("OPERATION_STOPRING".equals(str1))
        {
          stopRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(13724);
        }
      }
      else if (this._deviceConfigManager != null)
      {
        if (this._bluetoothCheck != null) {
          this._bluetoothCheck.onReceive(paramContext, paramIntent, this._deviceConfigManager);
        }
        if ((!bool2) && (this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET") == true)) {
          checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
        if ((bool2 == true) && (!this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET"))) {
          checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
      }
    }
    label1040:
    AppMethodBeat.o(13724);
  }
  
  void printDevices()
  {
    int j = 0;
    AppMethodBeat.i(13703);
    AudioDeviceInterface.LogTraceEntry("");
    int k = this._deviceConfigManager.getDeviceNumber();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.getConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.getConnectingDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.getPrevConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.getAvailabledHighestPriorityDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   deviceNamber:".concat(String.valueOf(k)));
    }
    int i = 0;
    while (i < k)
    {
      localObject = this._deviceConfigManager.getDeviceName(i);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "      " + i + " devName:" + (String)localObject + " Visible:" + this._deviceConfigManager.getVisible((String)localObject) + " Priority:" + this._deviceConfigManager.getPriority((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this._deviceConfigManager.getAvailableDeviceList().toArray(new String[0]);
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, "   AvailableNamber:" + localObject.length);
      i = j;
    }
    while (i < localObject.length)
    {
      String str = localObject[i];
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.getVisible(str) + " Priority:" + this._deviceConfigManager.getPriority(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13703);
  }
  
  public void release()
  {
    AppMethodBeat.i(13723);
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mTraeAudioManagerLooper != null)
    {
      this.mTraeAudioManagerLooper.quit();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(13723);
  }
  
  int sendResBroadcast(final Intent paramIntent, final HashMap<String, Object> paramHashMap, final int paramInt)
  {
    AppMethodBeat.i(13750);
    if (this._context == null)
    {
      AppMethodBeat.o(13750);
      return -1;
    }
    final Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " sessonID:" + localLong + " " + (String)paramHashMap.get("PARAM_OPERATION"));
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      InternalNotifyDeviceListUpdate();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
      }
      AppMethodBeat.o(13750);
      return -1;
    }
    localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    paramHashMap = (String)paramHashMap.get("PARAM_OPERATION");
    if ("OPERATION_VOICECALL_PREPROCESS".equals(paramHashMap))
    {
      paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      paramIntent.putExtra("PARAM_SESSIONID", localLong);
      paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
      paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
      if (this._audioSessionHost != null) {
        this._audioSessionHost.sendToAudioSessionMessage(paramIntent);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13750);
      return 0;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13779);
          paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
          paramIntent.putExtra("PARAM_SESSIONID", localLong);
          paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
          paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
          if (TraeAudioManager.this._context != null) {
            TraeAudioManager.this._context.sendBroadcast(paramIntent);
          }
          AppMethodBeat.o(13779);
        }
      });
    }
  }
  
  void updateDeviceStatus()
  {
    AppMethodBeat.i(13710);
    int j = this._deviceConfigManager.getDeviceNumber();
    int i = 0;
    if (i < j)
    {
      String str = this._deviceConfigManager.getDeviceName(i);
      boolean bool;
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTHHEADSET")) {
          if (this._bluetoothCheck == null) {
            bool = this._deviceConfigManager.setVisible(str, false);
          }
        }
      }
      for (;;)
      {
        if ((bool == true) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 2, "pollUpdateDevice dev:" + str + " Visible:" + this._deviceConfigManager.getVisible(str));
        }
        i += 1;
        break;
        bool = this._deviceConfigManager.setVisible(str, this._bluetoothCheck.isConnected());
        continue;
        if (str.equals("DEVICE_WIREDHEADSET"))
        {
          bool = this._deviceConfigManager.setVisible(str, this._am.isWiredHeadsetOn());
        }
        else
        {
          if (str.equals("DEVICE_SPEAKERPHONE")) {
            this._deviceConfigManager.setVisible(str, true);
          }
          bool = false;
        }
      }
    }
    checkAutoDeviceListUpdate();
    AppMethodBeat.o(13710);
  }
  
  @TargetApi(11)
  class BluetoohHeadsetCheck
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
    implements BluetoothProfile.ServiceListener
  {
    BluetoothAdapter _adapter;
    Context _ctx;
    TraeAudioManager.DeviceConfigManager _devCfg;
    BluetoothProfile _profile;
    private final ReentrantLock _profileLock;
    
    BluetoohHeadsetCheck()
    {
      super();
      AppMethodBeat.i(13806);
      this._ctx = null;
      this._devCfg = null;
      this._adapter = null;
      this._profile = null;
      this._profileLock = new ReentrantLock();
      AppMethodBeat.o(13806);
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      AppMethodBeat.i(13812);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
      paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
      AppMethodBeat.o(13812);
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(13813);
      int i;
      int j;
      if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
        paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("    EXTRA_DEVICE ").append(paramIntent).append(" ");
          if (paramIntent != null)
          {
            paramContext = paramIntent.getName();
            QLog.w("TRAE", 2, paramContext);
          }
        }
        else
        {
          if (i != 2) {
            break label252;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   dev:" + paramIntent.getName() + " connected,start sco...");
          }
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          localObject = this._devCfg;
          if (paramIntent == null) {
            break label246;
          }
        }
        label246:
        for (paramContext = paramIntent.getName();; paramContext = "unkown")
        {
          ((TraeAudioManager.DeviceConfigManager)localObject).setBluetoothName(paramContext);
          AppMethodBeat.o(13813);
          return;
          paramContext = " ";
          break;
        }
        label252:
        if (i == 0)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          AppMethodBeat.o(13813);
        }
      }
      else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:".concat(String.valueOf(paramContext)));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i));
        }
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
          AppMethodBeat.o(13813);
        }
      }
      else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        paramContext = BluetoothAdapter.getDefaultAdapter();
      }
      switch (paramContext.getProfileConnectionState(2))
      {
      case 1: 
      default: 
        QLog.w("TRAE", 2, "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
        AppMethodBeat.o(13813);
        return;
      case 2: 
        QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
        TraeAudioManager.this.IsBluetoothA2dpExisted = true;
        AppMethodBeat.o(13813);
        return;
      }
      QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
      TraeAudioManager.this.IsBluetoothA2dpExisted = false;
      AppMethodBeat.o(13813);
    }
    
    @TargetApi(11)
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AppMethodBeat.i(13807);
      AudioDeviceInterface.LogTraceEntry("");
      if ((paramContext == null) || (paramDeviceConfigManager == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
        }
        AppMethodBeat.o(13807);
        return false;
      }
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      this._adapter = BluetoothAdapter.getDefaultAdapter();
      if (this._adapter == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
        }
        AppMethodBeat.o(13807);
        return false;
      }
      this._profileLock.lock();
      try
      {
        if ((this._adapter.isEnabled()) && (this._profile == null) && (!this._adapter.getProfileProxy(this._ctx, this, 1)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
          }
          return false;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13807);
        return true;
      }
      finally
      {
        this._profileLock.unlock();
        AppMethodBeat.o(13807);
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheck";
    }
    
    public boolean isConnected()
    {
      boolean bool2 = false;
      AppMethodBeat.i(13809);
      this._profileLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this._profile != null)
        {
          List localList = this._profile.getConnectedDevices();
          if (localList == null) {
            return false;
          }
          int i = localList.size();
          bool1 = bool2;
          if (i > 0) {
            bool1 = true;
          }
        }
        return bool1;
      }
      finally
      {
        this._profileLock.unlock();
        AppMethodBeat.o(13809);
      }
    }
    
    @TargetApi(11)
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      AppMethodBeat.i(13810);
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
      if (paramInt == 1) {
        this._profileLock.lock();
      }
      for (;;)
      {
        try
        {
          if ((this._profile != null) && (this._profile != paramBluetoothProfile))
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
            }
            this._adapter.closeProfileProxy(1, this._profile);
            this._profile = null;
          }
          this._profile = paramBluetoothProfile;
          if (this._profile == null) {
            break label500;
          }
          paramBluetoothProfile = this._profile.getConnectedDevices();
          if ((paramBluetoothProfile != null) && (this._profile != null))
          {
            if (!QLog.isColorLevel()) {
              break label505;
            }
            QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this._profile);
            break label505;
            if (paramInt < paramBluetoothProfile.size())
            {
              BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramBluetoothProfile.get(paramInt);
              try
              {
                if (this._profile != null)
                {
                  i = this._profile.getConnectionState(localBluetoothDevice);
                  if (i == 2) {
                    this._devCfg.setBluetoothName(localBluetoothDevice.getName());
                  }
                  if (!QLog.isColorLevel()) {
                    break label510;
                  }
                  QLog.w("TRAE", 2, "   " + paramInt + " " + localBluetoothDevice.getName() + " ConnectionState:" + i);
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "get bluetooth connection state failed." + localException.getMessage());
                }
                int i = 0;
                continue;
              }
            }
          }
          this._profileLock.unlock();
          if (this._devCfg != null)
          {
            if (TraeAudioManager.this._deviceConfigManager == null) {
              break label495;
            }
            paramBluetoothProfile = TraeAudioManager.this._deviceConfigManager.getBluetoothName();
            if (TextUtils.isEmpty(paramBluetoothProfile)) {
              this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
            }
          }
          else
          {
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13810);
            return;
          }
        }
        finally
        {
          this._profileLock.unlock();
          AppMethodBeat.o(13810);
        }
        if (isConnected())
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
        else
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          continue;
          label495:
          paramBluetoothProfile = null;
          continue;
          label500:
          paramBluetoothProfile = null;
          continue;
          label505:
          paramInt = 0;
          continue;
          label510:
          paramInt += 1;
        }
      }
    }
    
    @TargetApi(11)
    public void onServiceDisconnected(int paramInt)
    {
      AppMethodBeat.i(13811);
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
        }
        if (isConnected()) {
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
        this._profileLock.lock();
      }
      try
      {
        if (this._profile != null)
        {
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13811);
        return;
      }
      finally
      {
        this._profileLock.unlock();
        AppMethodBeat.o(13811);
      }
    }
    
    public void release()
    {
      AppMethodBeat.i(13808);
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
      this._profileLock.lock();
      try
      {
        if (this._adapter != null)
        {
          if (this._profile != null) {
            this._adapter.closeProfileProxy(1, this._profile);
          }
          this._profile = null;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " closeProfileProxy:e:" + localException.getMessage());
          }
          this._profileLock.unlock();
        }
      }
      finally
      {
        this._profileLock.unlock();
        AppMethodBeat.o(13808);
      }
      AppMethodBeat.o(13808);
    }
  }
  
  class BluetoohHeadsetCheckFake
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckFake()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter) {}
    
    void _onReceive(Context paramContext, Intent paramIntent) {}
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFake";
    }
    
    public boolean isConnected()
    {
      return false;
    }
    
    public void release() {}
  }
  
  class BluetoohHeadsetCheckFor2x
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
    public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
    public static final int AUDIO_STATE_CONNECTED = 1;
    public static final int AUDIO_STATE_DISCONNECTED = 0;
    static final int STATE_CONNECTED = 2;
    static final int STATE_DISCONNECTED = 0;
    Class<?> BluetoothHeadsetClass = null;
    Object BluetoothHeadsetObj = null;
    Class<?> ListenerClass = null;
    Context _ctx = null;
    TraeAudioManager.DeviceConfigManager _devCfg = null;
    Method getCurrentHeadsetMethod = null;
    
    BluetoohHeadsetCheckFor2x()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      AppMethodBeat.i(13794);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
      AppMethodBeat.o(13794);
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(13795);
      int i;
      int j;
      int k;
      if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(j)));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(k)));
        }
        if (k == 2)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          AppMethodBeat.o(13795);
          return;
        }
        if (k == 0)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          AppMethodBeat.o(13795);
        }
      }
      else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(j)));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(k)));
        }
        if (k == 2)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          AppMethodBeat.o(13795);
          return;
        }
        if (k == 0) {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        }
      }
      AppMethodBeat.o(13795);
    }
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AppMethodBeat.i(13791);
      AudioDeviceInterface.LogTraceEntry("");
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      if ((this._ctx == null) || (this._devCfg == null))
      {
        AppMethodBeat.o(13791);
        return false;
      }
      try
      {
        this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
        if (this.BluetoothHeadsetClass == null)
        {
          AppMethodBeat.o(13791);
          return false;
        }
      }
      catch (Exception paramDeviceConfigManager)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
          }
        }
        try
        {
          this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
        }
        catch (Exception paramDeviceConfigManager)
        {
          try
          {
            for (;;)
            {
              this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
              if (this.getCurrentHeadsetMethod != null) {
                break;
              }
              AppMethodBeat.o(13791);
              return false;
              paramDeviceConfigManager = paramDeviceConfigManager;
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:".concat(String.valueOf(paramDeviceConfigManager)));
              }
            }
          }
          catch (NoSuchMethodException paramDeviceConfigManager)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
              }
            }
            try
            {
              this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
              if (this.BluetoothHeadsetObj == null)
              {
                AppMethodBeat.o(13791);
                return false;
              }
            }
            catch (IllegalArgumentException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
              }
            }
            catch (InstantiationException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
              }
            }
            catch (IllegalAccessException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
              }
            }
            catch (InvocationTargetException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
              }
            }
            catch (NoSuchMethodException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                }
              }
              this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
              if (!isConnected()) {
                break label369;
              }
            }
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
            TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
          }
        }
      }
      for (;;)
      {
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13791);
        return true;
        label369:
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFor2x";
    }
    
    public boolean isConnected()
    {
      AppMethodBeat.i(13793);
      String str4 = null;
      if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null))
      {
        AppMethodBeat.o(13793);
        return false;
      }
      try
      {
        Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
          if (localObject != null)
          {
            str4 = " Y";
            QLog.w("TRAE", 2, str4);
          }
        }
        else
        {
          if (localObject == null) {
            break label167;
          }
          AppMethodBeat.o(13793);
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          String str1 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
            str1 = str4;
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          String str2 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
            str2 = str4;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          String str3 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
            str3 = str4;
            continue;
            str4 = "N";
          }
        }
        label167:
        AppMethodBeat.o(13793);
      }
      return false;
    }
    
    public void release()
    {
      AppMethodBeat.i(13792);
      AudioDeviceInterface.LogTraceEntry("");
      if (this.BluetoothHeadsetObj == null)
      {
        AppMethodBeat.o(13792);
        return;
      }
      Object localObject;
      try
      {
        Method localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
        if (localMethod == null)
        {
          AppMethodBeat.o(13792);
          return;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
          }
          localObject = null;
        }
      }
      try
      {
        localObject.invoke(this.BluetoothHeadsetObj, new Object[0]);
        this.BluetoothHeadsetClass = null;
        this.ListenerClass = null;
        this.BluetoothHeadsetObj = null;
        this.getCurrentHeadsetMethod = null;
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13792);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "close bluetooth headset failed." + localException.getMessage());
          }
        }
      }
    }
  }
  
  abstract class BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckInterface() {}
    
    abstract void _addAction(IntentFilter paramIntentFilter);
    
    abstract void _onReceive(Context paramContext, Intent paramIntent);
    
    public void addAction(IntentFilter paramIntentFilter)
    {
      paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
      _addAction(paramIntentFilter);
    }
    
    String getBTActionStateChangedExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_OFF";
        continue;
        str = "STATE_TURNING_ON";
        continue;
        str = "STATE_ON";
        continue;
        str = "STATE_TURNING_OFF";
      }
    }
    
    String getBTAdapterConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getBTHeadsetAudioState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      case 11: 
      default: 
        str = "unknow:".concat(String.valueOf(paramInt));
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_AUDIO_CONNECTED";
        continue;
        str = "STATE_AUDIO_DISCONNECTED";
      }
    }
    
    String getBTHeadsetConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getSCOAudioStateExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "SCO_AUDIO_STATE_DISCONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTING";
        continue;
        str = "SCO_AUDIO_STATE_ERROR";
      }
    }
    
    public abstract boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
    
    public abstract String interfaceDesc();
    
    public abstract boolean isConnected();
    
    public void onReceive(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(j));
        }
        if (i == 10) {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "    BT off");
          }
        }
      }
      while ((("android.bluetooth.device.action.ACL_CONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) || (("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)))
      {
        int i;
        int j;
        paramDeviceConfigManager.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        do
        {
          return;
        } while ((i != 12) || (!QLog.isColorLevel()));
        QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
        return;
      }
      _onReceive(paramContext, paramIntent);
    }
    
    public abstract void release();
  }
  
  class DeviceConfigManager
  {
    String _bluetoothDevName;
    String connectedDevice;
    String connectingDevice;
    HashMap<String, DeviceConfig> deviceConfigs;
    ReentrantLock mLock;
    String prevConnectedDevice;
    boolean visiableUpdate;
    
    public DeviceConfigManager()
    {
      AppMethodBeat.i(13864);
      this.deviceConfigs = new HashMap();
      this.prevConnectedDevice = "DEVICE_NONE";
      this.connectedDevice = "DEVICE_NONE";
      this.connectingDevice = "DEVICE_NONE";
      this.mLock = new ReentrantLock();
      this.visiableUpdate = false;
      this._bluetoothDevName = "unknow";
      AppMethodBeat.o(13864);
    }
    
    boolean _addConfig(String paramString, int paramInt)
    {
      AppMethodBeat.i(13866);
      AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
      DeviceConfig localDeviceConfig = new DeviceConfig();
      if (localDeviceConfig.init(paramString, paramInt))
      {
        if (this.deviceConfigs.containsKey(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "err dev exist!");
          }
          AppMethodBeat.o(13866);
          return false;
        }
        this.deviceConfigs.put(paramString, localDeviceConfig);
        this.visiableUpdate = true;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " n" + getDeviceNumber() + " 0:" + getDeviceName(0));
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13866);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err dev init!");
      }
      AppMethodBeat.o(13866);
      return false;
    }
    
    ArrayList<String> _getAvailableDeviceList()
    {
      AppMethodBeat.i(13886);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DeviceConfig localDeviceConfig = (DeviceConfig)((Map.Entry)localIterator.next()).getValue();
        if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
          localArrayList.add(localDeviceConfig.getDeviceName());
        }
      }
      AppMethodBeat.o(13886);
      return localArrayList;
    }
    
    String _getConnectedDevice()
    {
      AppMethodBeat.i(13887);
      Object localObject = (DeviceConfig)this.deviceConfigs.get(this.connectedDevice);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible())) {}
      for (localObject = this.connectedDevice;; localObject = "DEVICE_NONE")
      {
        AppMethodBeat.o(13887);
        return localObject;
      }
    }
    
    String _getPrevConnectedDevice()
    {
      AppMethodBeat.i(13888);
      Object localObject = (DeviceConfig)this.deviceConfigs.get(this.prevConnectedDevice);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible())) {}
      for (localObject = this.prevConnectedDevice;; localObject = "DEVICE_NONE")
      {
        AppMethodBeat.o(13888);
        return localObject;
      }
    }
    
    public void clearConfig()
    {
      AppMethodBeat.i(13867);
      this.mLock.lock();
      this.deviceConfigs.clear();
      this.prevConnectedDevice = "DEVICE_NONE";
      this.connectedDevice = "DEVICE_NONE";
      this.connectingDevice = "DEVICE_NONE";
      this.mLock.unlock();
      AppMethodBeat.o(13867);
    }
    
    public ArrayList<String> getAvailableDeviceList()
    {
      AppMethodBeat.i(13885);
      new ArrayList();
      this.mLock.lock();
      ArrayList localArrayList = _getAvailableDeviceList();
      this.mLock.unlock();
      AppMethodBeat.o(13885);
      return localArrayList;
    }
    
    public String getAvailabledHighestPriorityDevice()
    {
      AppMethodBeat.i(13877);
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((DeviceConfig)localObject2).getVisible())) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            if (((DeviceConfig)localObject2).getPriority() < ((DeviceConfig)localObject1).getPriority()) {
              break label140;
            }
            localObject1 = localObject2;
          }
        }
      }
      label140:
      for (;;)
      {
        break;
        this.mLock.unlock();
        if (localObject1 != null)
        {
          localObject1 = ((DeviceConfig)localObject1).getDeviceName();
          AppMethodBeat.o(13877);
          return localObject1;
        }
        AppMethodBeat.o(13877);
        return "DEVICE_SPEAKERPHONE";
      }
    }
    
    public String getAvailabledHighestPriorityDevice(String paramString)
    {
      AppMethodBeat.i(13876);
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((DeviceConfig)localObject2).getVisible()) && (!((DeviceConfig)localObject2).getDeviceName().equals(paramString))) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            if (((DeviceConfig)localObject2).getPriority() < localObject1.getPriority()) {
              break label154;
            }
            localObject1 = localObject2;
          }
        }
      }
      label154:
      for (;;)
      {
        break;
        this.mLock.unlock();
        if (localObject1 != null)
        {
          paramString = localObject1.getDeviceName();
          AppMethodBeat.o(13876);
          return paramString;
        }
        AppMethodBeat.o(13876);
        return "DEVICE_SPEAKERPHONE";
      }
    }
    
    public String getBluetoothName()
    {
      return this._bluetoothDevName;
    }
    
    public String getConnectedDevice()
    {
      AppMethodBeat.i(13879);
      this.mLock.lock();
      String str = _getConnectedDevice();
      this.mLock.unlock();
      AppMethodBeat.o(13879);
      return str;
    }
    
    public String getConnectingDevice()
    {
      AppMethodBeat.i(13878);
      this.mLock.lock();
      Object localObject = (DeviceConfig)this.deviceConfigs.get(this.connectingDevice);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible())) {}
      for (localObject = this.connectingDevice;; localObject = null)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13878);
        return localObject;
      }
    }
    
    public String getDeviceName(int paramInt)
    {
      AppMethodBeat.i(13875);
      this.mLock.lock();
      Object localObject = this.deviceConfigs.entrySet().iterator();
      int i = 0;
      Map.Entry localEntry;
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i != paramInt) {}
      }
      for (localObject = (DeviceConfig)localEntry.getValue();; localObject = null)
      {
        if (localObject != null) {}
        for (localObject = ((DeviceConfig)localObject).getDeviceName();; localObject = "DEVICE_NONE")
        {
          this.mLock.unlock();
          AppMethodBeat.o(13875);
          return localObject;
          i += 1;
          break;
        }
      }
    }
    
    public int getDeviceNumber()
    {
      AppMethodBeat.i(13874);
      this.mLock.lock();
      int i = this.deviceConfigs.size();
      this.mLock.unlock();
      AppMethodBeat.o(13874);
      return i;
    }
    
    public String getPrevConnectedDevice()
    {
      AppMethodBeat.i(13880);
      this.mLock.lock();
      String str = _getPrevConnectedDevice();
      this.mLock.unlock();
      AppMethodBeat.o(13880);
      return str;
    }
    
    public int getPriority(String paramString)
    {
      AppMethodBeat.i(13873);
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (int i = paramString.getPriority();; i = -1)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13873);
        return i;
      }
    }
    
    public HashMap<String, Object> getSnapParams()
    {
      AppMethodBeat.i(13884);
      HashMap localHashMap = new HashMap();
      this.mLock.lock();
      localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
      localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
      localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
      this.mLock.unlock();
      AppMethodBeat.o(13884);
      return localHashMap;
    }
    
    public boolean getVisiableUpdateFlag()
    {
      AppMethodBeat.i(13868);
      this.mLock.lock();
      boolean bool = this.visiableUpdate;
      this.mLock.unlock();
      AppMethodBeat.o(13868);
      return bool;
    }
    
    public boolean getVisible(String paramString)
    {
      AppMethodBeat.i(13872);
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (boolean bool = paramString.getVisible();; bool = false)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13872);
        return bool;
      }
    }
    
    public boolean init(String paramString)
    {
      AppMethodBeat.i(13865);
      AudioDeviceInterface.LogTraceEntry(" strConfigs:".concat(String.valueOf(paramString)));
      if ((paramString == null) || (paramString.length() <= 0))
      {
        AppMethodBeat.o(13865);
        return false;
      }
      String str = paramString.replace("\n", "").replace("\r", "");
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(13865);
        return false;
      }
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
      if ((paramString == null) || (1 > paramString.length))
      {
        AppMethodBeat.o(13865);
        return false;
      }
      this.mLock.lock();
      int i = 0;
      while (i < paramString.length)
      {
        _addConfig(paramString[i], i);
        i += 1;
      }
      this.mLock.unlock();
      TraeAudioManager.this.printDevices();
      AppMethodBeat.o(13865);
      return true;
    }
    
    public boolean isConnected(String paramString)
    {
      AppMethodBeat.i(13883);
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {}
      for (boolean bool = this.connectedDevice.equals(paramString);; bool = false)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13883);
        return bool;
      }
    }
    
    public void resetVisiableUpdateFlag()
    {
      AppMethodBeat.i(13869);
      this.mLock.lock();
      this.visiableUpdate = false;
      this.mLock.unlock();
      AppMethodBeat.o(13869);
    }
    
    public void setBluetoothName(String paramString)
    {
      AppMethodBeat.i(13871);
      if (paramString == null)
      {
        this._bluetoothDevName = "unknow";
        AppMethodBeat.o(13871);
        return;
      }
      if (paramString.isEmpty())
      {
        this._bluetoothDevName = "unknow";
        AppMethodBeat.o(13871);
        return;
      }
      this._bluetoothDevName = paramString;
      AppMethodBeat.o(13871);
    }
    
    public boolean setConnected(String paramString)
    {
      AppMethodBeat.i(13882);
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
      {
        if ((this.connectedDevice != null) && (!this.connectedDevice.equals(paramString))) {
          this.prevConnectedDevice = this.connectedDevice;
        }
        this.connectedDevice = paramString;
        this.connectingDevice = "";
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13882);
        return bool;
      }
    }
    
    public boolean setConnecting(String paramString)
    {
      AppMethodBeat.i(13881);
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        this.connectingDevice = paramString;
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13881);
        return bool;
      }
    }
    
    public boolean setVisible(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(13870);
      this.mLock.lock();
      Object localObject = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible() != paramBoolean))
      {
        ((DeviceConfig)localObject).setVisible(paramBoolean);
        this.visiableUpdate = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(" ++setVisible:").append(paramString);
          if (!paramBoolean) {
            break label107;
          }
          paramString = " Y";
          QLog.w("TRAE", 2, paramString);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.mLock.unlock();
        AppMethodBeat.o(13870);
        return paramBoolean;
        label107:
        paramString = " N";
        break;
      }
    }
    
    public class DeviceConfig
    {
      String deviceName = "DEVICE_NONE";
      int priority = 0;
      boolean visible = false;
      
      public DeviceConfig() {}
      
      public String getDeviceName()
      {
        return this.deviceName;
      }
      
      public int getPriority()
      {
        return this.priority;
      }
      
      public boolean getVisible()
      {
        return this.visible;
      }
      
      public boolean init(String paramString, int paramInt)
      {
        AppMethodBeat.i(13656);
        if ((paramString == null) || (paramString.length() <= 0))
        {
          AppMethodBeat.o(13656);
          return false;
        }
        if (TraeAudioManager.checkDevName(paramString) != true)
        {
          AppMethodBeat.o(13656);
          return false;
        }
        this.deviceName = paramString;
        this.priority = paramInt;
        AppMethodBeat.o(13656);
        return true;
      }
      
      public void setVisible(boolean paramBoolean)
      {
        this.visible = paramBoolean;
      }
    }
  }
  
  class TraeAudioManagerLooper
    extends Thread
  {
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE = 32786;
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE = 32787;
    public static final int MESSAGE_AUTO_DEVICELIST_UPDATE = 32785;
    public static final int MESSAGE_BEGIN = 32768;
    public static final int MESSAGE_CONNECTDEVICE = 32775;
    public static final int MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE = 32789;
    public static final int MESSAGE_DISABLE = 32773;
    public static final int MESSAGE_EARACTION = 32776;
    public static final int MESSAGE_ENABLE = 32772;
    public static final int MESSAGE_GETCONNECTEDDEVICE = 32778;
    public static final int MESSAGE_GETCONNECTINGDEVICE = 32779;
    public static final int MESSAGE_GETDEVICELIST = 32774;
    public static final int MESSAGE_GETSTREAMTYPE = 32784;
    public static final int MESSAGE_ISDEVICECHANGABLED = 32777;
    public static final int MESSAGE_RECOVER_AUDIO_FOCUS = 32791;
    public static final int MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS = 32790;
    public static final int MESSAGE_STARTRING = 32782;
    public static final int MESSAGE_STOPRING = 32783;
    public static final int MESSAGE_VOICECALLPOSTPROCESS = 32781;
    public static final int MESSAGE_VOICECALLPREPROCESS = 32780;
    public static final int MESSAGE_VOICECALL_AUIDOPARAM_CHANGED = 32788;
    boolean _enabled;
    int _focusSteamType;
    String _lastCfg;
    TraeAudioManager _parent;
    int _preRingMode;
    int _preServiceMode;
    String _ringOperation;
    TraeMediaPlayer _ringPlayer;
    long _ringSessionID;
    String _ringUserdata;
    final boolean[] _started;
    String _voiceCallOperation;
    long _voiceCallSessionID;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    Handler mMsgHandler;
    
    /* Error */
    public TraeAudioManagerLooper(TraeAudioManager paramTraeAudioManager)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 86	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:this$0	Lcom/tencent/rtmp/sharp/jni/TraeAudioManager;
      //   5: aload_0
      //   6: invokespecial 89	java/lang/Thread:<init>	()V
      //   9: sipush 13911
      //   12: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   15: aload_0
      //   16: aconst_null
      //   17: putfield 97	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mMsgHandler	Landroid/os/Handler;
      //   20: aload_0
      //   21: aconst_null
      //   22: putfield 99	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringPlayer	Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;
      //   25: aload_0
      //   26: ldc2_w 100
      //   29: putfield 103	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringSessionID	J
      //   32: aload_0
      //   33: ldc 105
      //   35: putfield 107	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringOperation	Ljava/lang/String;
      //   38: aload_0
      //   39: ldc 105
      //   41: putfield 109	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringUserdata	Ljava/lang/String;
      //   44: aload_0
      //   45: iconst_1
      //   46: newarray boolean
      //   48: dup
      //   49: iconst_0
      //   50: iconst_0
      //   51: bastore
      //   52: putfield 111	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   55: aload_0
      //   56: iconst_0
      //   57: putfield 113	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_enabled	Z
      //   60: aload_0
      //   61: aconst_null
      //   62: putfield 115	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/rtmp/sharp/jni/TraeAudioManager;
      //   65: aload_0
      //   66: ldc 105
      //   68: putfield 117	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_lastCfg	Ljava/lang/String;
      //   71: aload_0
      //   72: iconst_0
      //   73: putfield 119	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preServiceMode	I
      //   76: aload_0
      //   77: iconst_0
      //   78: putfield 121	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preRingMode	I
      //   81: aload_0
      //   82: ldc2_w 100
      //   85: putfield 123	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallSessionID	J
      //   88: aload_0
      //   89: ldc 105
      //   91: putfield 125	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallOperation	Ljava/lang/String;
      //   94: aload_0
      //   95: aconst_null
      //   96: putfield 127	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
      //   99: aload_0
      //   100: iconst_0
      //   101: putfield 129	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_focusSteamType	I
      //   104: aload_0
      //   105: aload_2
      //   106: putfield 115	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/rtmp/sharp/jni/TraeAudioManager;
      //   109: invokestatic 135	android/os/SystemClock:elapsedRealtime	()J
      //   112: lstore_3
      //   113: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
      //   116: ifeq +11 -> 127
      //   119: ldc 143
      //   121: iconst_2
      //   122: ldc 145
      //   124: invokestatic 149	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   127: aload_0
      //   128: invokevirtual 152	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:start	()V
      //   131: aload_0
      //   132: getfield 111	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   135: astore_1
      //   136: aload_1
      //   137: monitorenter
      //   138: aload_0
      //   139: getfield 111	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   142: iconst_0
      //   143: baload
      //   144: istore 5
      //   146: iload 5
      //   148: ifne +13 -> 161
      //   151: aload_0
      //   152: getfield 111	com/tencent/rtmp/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   155: ldc2_w 153
      //   158: invokevirtual 160	java/lang/Object:wait	(J)V
      //   161: aload_1
      //   162: monitorexit
      //   163: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
      //   166: ifeq +34 -> 200
      //   169: ldc 143
      //   171: iconst_2
      //   172: new 162	java/lang/StringBuilder
      //   175: dup
      //   176: ldc 164
      //   178: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   181: invokestatic 135	android/os/SystemClock:elapsedRealtime	()J
      //   184: lload_3
      //   185: lsub
      //   186: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   189: ldc 173
      //   191: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   194: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   197: invokestatic 149	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   200: sipush 13911
      //   203: invokestatic 183	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: return
      //   207: astore_2
      //   208: aload_1
      //   209: monitorexit
      //   210: sipush 13911
      //   213: invokestatic 183	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   216: aload_2
      //   217: athrow
      //   218: astore_2
      //   219: goto -58 -> 161
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	222	0	this	TraeAudioManagerLooper
      //   0	222	1	this$1	TraeAudioManager
      //   0	222	2	paramTraeAudioManager	TraeAudioManager
      //   112	73	3	l	long
      //   144	3	5	i	int
      // Exception table:
      //   from	to	target	type
      //   138	146	207	finally
      //   151	161	207	finally
      //   161	163	207	finally
      //   208	210	207	finally
      //   151	161	218	java/lang/InterruptedException
    }
    
    int InternalGetStreamType(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13931);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " InternalStopRing am==null!!");
        }
        AppMethodBeat.o(13931);
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {}
      for (int i = this._ringPlayer.getStreamType();; i = TraeAudioManager.this._streamType)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13931);
        return 0;
      }
    }
    
    int InternalNotifyStreamTypeUpdate(final int paramInt)
    {
      AppMethodBeat.i(13932);
      if (TraeAudioManager.this._context == null)
      {
        AppMethodBeat.o(13932);
        return -1;
      }
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222659);
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
          localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
          localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
          if (TraeAudioManager.this._context != null) {
            TraeAudioManager.this._context.sendBroadcast(localIntent);
          }
          AppMethodBeat.o(222659);
        }
      });
      AppMethodBeat.o(13932);
      return 0;
    }
    
    int InternalSessionGetDeviceList(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13923);
      Intent localIntent = new Intent();
      Object localObject = TraeAudioManager.this._deviceConfigManager.getSnapParams();
      ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
      String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
      localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
      localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
      localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
      localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
      localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", TraeAudioManager.this._deviceConfigManager.getBluetoothName());
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      AppMethodBeat.o(13923);
      return 0;
    }
    
    int InternalStartRing(HashMap<String, Object> paramHashMap)
    {
      boolean bool1 = true;
      AppMethodBeat.i(13929);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " InternalStartRing am==null!!");
        }
        AppMethodBeat.o(13929);
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {
        interruptRing();
      }
      for (;;)
      {
        try
        {
          this._ringSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
          this._ringOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
          this._ringUserdata = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
          int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "  dataSource:".concat(String.valueOf(i)));
          }
          int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
          Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
          String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
          boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
          int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
          boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
          if (TraeAudioManager.this._activeMode != 1) {
            TraeAudioManager.this._activeMode = 2;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
          TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
          this._preRingMode = TraeAudioManager.this._am.getMode();
          paramHashMap = this._ringPlayer;
          if (TraeAudioManager.this._activeMode == 1)
          {
            paramHashMap.playRing(i, j, localUri, str, bool2, k, bool3, bool1, TraeAudioManager.this._streamType);
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, " _ringUserdata:" + this._ringUserdata + " DurationMS:" + this._ringPlayer.getDuration());
            }
            InternalNotifyStreamTypeUpdate(this._ringPlayer.getStreamType());
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(13929);
            return 0;
          }
        }
        catch (Exception paramHashMap)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, " startRing err params");
          }
          AppMethodBeat.o(13929);
          return -1;
        }
        bool1 = false;
      }
    }
    
    int InternalStopRing(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13930);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if ((TraeAudioManager.this._am == null) || (this._ringPlayer == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " InternalStopRing am==null!!");
        }
        AppMethodBeat.o(13930);
        return -1;
      }
      this._ringPlayer.stopRing();
      if ((!this._ringPlayer.hasCall()) && (TraeAudioManager.this._activeMode == 2))
      {
        abandonAudioFocus();
        TraeAudioManager.this._activeMode = 0;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13930);
      return 0;
    }
    
    int InternalVoicecallPostprocess(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13927);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
        }
        AppMethodBeat.o(13927);
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
        }
        Intent localIntent = new Intent();
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 3);
        AppMethodBeat.o(13927);
        return -1;
      }
      TraeAudioManager.this._activeMode = 0;
      abandonAudioFocus();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13927);
      return 0;
    }
    
    int InternalVoicecallPreprocess(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13926);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (paramHashMap == null)
      {
        AppMethodBeat.o(13926);
        return -1;
      }
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
        }
        AppMethodBeat.o(13926);
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 1)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 2);
        AppMethodBeat.o(13926);
        return -1;
      }
      this._voiceCallSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
      this._voiceCallOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
      TraeAudioManager.this._activeMode = 1;
      TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
      Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
        }
        TraeAudioManager.this._modePolicy = -1;
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
        }
        localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
        if (localObject != null) {
          break label386;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
        }
        TraeAudioManager.this._streamType = 0;
        label281:
        if ((!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy)) || (TraeAudioManager.this._activeMode == 2) || (TraeAudioManager.this._deviceConfigManager == null)) {
          break label411;
        }
        if (!TraeAudioManager.this._deviceConfigManager.getConnectedDevice().equals("DEVICE_SPEAKERPHONE")) {
          break label400;
        }
        TraeAudioManager.this.InternalSetMode(0);
      }
      for (;;)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13926);
        return 0;
        TraeAudioManager.this._modePolicy = ((Integer)localObject).intValue();
        break;
        label386:
        TraeAudioManager.this._streamType = ((Integer)localObject).intValue();
        break label281;
        label400:
        TraeAudioManager.this.InternalSetMode(3);
        continue;
        label411:
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
      }
    }
    
    void _init()
    {
      AppMethodBeat.i(13919);
      AudioDeviceInterface.LogTraceEntry("");
      try
      {
        TraeAudioManager.this._audioSessionHost = new TraeAudioSessionHost();
        TraeAudioManager.this._deviceConfigManager = new TraeAudioManager.DeviceConfigManager(TraeAudioManager.this);
        TraeAudioManager._gHostProcessId = Process.myPid();
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13919);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "======7");
          }
        }
      }
    }
    
    void _post_stopService()
    {
      AppMethodBeat.i(13921);
      try
      {
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        }
        AppMethodBeat.o(13921);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "stop service failed." + localException.getMessage());
        }
        AppMethodBeat.o(13921);
      }
    }
    
    void _prev_startService()
    {
      AppMethodBeat.i(13920);
      try
      {
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        if (TraeAudioManager.this._bluetoothCheck == null) {
          TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        }
        TraeAudioManager.this._context.unregisterReceiver(this._parent);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        AppMethodBeat.o(13920);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "======7");
        }
        AppMethodBeat.o(13920);
      }
    }
    
    void _uninit()
    {
      AppMethodBeat.i(13922);
      AudioDeviceInterface.LogTraceEntry("");
      try
      {
        stopService();
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          TraeAudioManager.this._context = null;
        }
        if (TraeAudioManager.this._deviceConfigManager != null) {
          TraeAudioManager.this._deviceConfigManager.clearConfig();
        }
        TraeAudioManager.this._deviceConfigManager = null;
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "uninit failed." + localException.getMessage());
          }
        }
      }
      AppMethodBeat.o(13922);
    }
    
    @TargetApi(8)
    void abandonAudioFocus()
    {
      AppMethodBeat.i(13925);
      AppMethodBeat.o(13925);
    }
    
    int interruptRing()
    {
      AppMethodBeat.i(13933);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " interruptRing am==null!!");
        }
        AppMethodBeat.o(13933);
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " not ACTIVE_RING!!");
        }
        AppMethodBeat.o(13933);
        return -1;
      }
      this._ringPlayer.stopRing();
      abandonAudioFocus();
      TraeAudioManager.this._activeMode = 0;
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
      localHashMap.put("PARAM_OPERATION", this._ringOperation);
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 4);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13933);
      return 0;
    }
    
    int interruptVoicecallPostprocess()
    {
      AppMethodBeat.i(13928);
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " am==null!!");
        }
        AppMethodBeat.o(13928);
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " not ACTIVE_RING!!");
        }
        AppMethodBeat.o(13928);
        return -1;
      }
      TraeAudioManager.this._activeMode = 0;
      if (TraeAudioManager.this._prevMode != -1) {
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._voiceCallSessionID));
      localHashMap.put("PARAM_OPERATION", this._voiceCallOperation);
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 6);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13928);
      return 0;
    }
    
    boolean isNeedForceVolumeType()
    {
      AppMethodBeat.i(13915);
      if (Build.MANUFACTURER.equals("Xiaomi"))
      {
        if (Build.MODEL.equals("MI 5"))
        {
          AppMethodBeat.o(13915);
          return true;
        }
        if (Build.MODEL.equals("MI 5s"))
        {
          AppMethodBeat.o(13915);
          return true;
        }
        if (Build.MODEL.equals("MI 5s Plus"))
        {
          AppMethodBeat.o(13915);
          return true;
        }
      }
      AppMethodBeat.o(13915);
      return false;
    }
    
    void notifyRingCompletion()
    {
      AppMethodBeat.i(13934);
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
      localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 0);
      AppMethodBeat.o(13934);
    }
    
    int notifyServiceState(boolean paramBoolean)
    {
      AppMethodBeat.i(13917);
      if (TraeAudioManager.this._context == null)
      {
        AppMethodBeat.o(13917);
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
      localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
      if (TraeAudioManager.this._context != null) {
        TraeAudioManager.this._context.sendBroadcast(localIntent);
      }
      AppMethodBeat.o(13917);
      return 0;
    }
    
    public void quit()
    {
      AppMethodBeat.i(13912);
      AudioDeviceInterface.LogTraceEntry("");
      if (this.mMsgHandler == null)
      {
        AppMethodBeat.o(13912);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      this.mMsgHandler.getLooper().quit();
      synchronized (this._started)
      {
        int i = this._started[0];
        if (i != 1) {}
      }
      try
      {
        this._started.wait(10000L);
        label70:
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
        }
        this.mMsgHandler = null;
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13912);
        return;
        localObject = finally;
        AppMethodBeat.o(13912);
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label70;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(13918);
      AudioDeviceInterface.LogTraceEntry("");
      Looper.prepare();
      this.mMsgHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(13790);
          Object localObject;
          try
          {
            HashMap localHashMap = (HashMap)paramAnonymousMessage.obj;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder("TraeAudioManagerLooper msg:").append(paramAnonymousMessage.what).append(" _enabled:");
              if (TraeAudioManager.TraeAudioManagerLooper.this._enabled)
              {
                str = "Y";
                QLog.w("TRAE", 2, str);
              }
            }
            else
            {
              if (paramAnonymousMessage.what != 32772) {
                break label107;
              }
              TraeAudioManager.TraeAudioManagerLooper.this.startService(localHashMap);
              AppMethodBeat.o(13790);
              return;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject = null;
              continue;
              String str = "N";
            }
            label107:
            if (!TraeAudioManager.TraeAudioManagerLooper.this._enabled)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "******* disabled ,skip msg******");
              }
              paramAnonymousMessage = new Intent();
              TraeAudioManager.this.sendResBroadcast(paramAnonymousMessage, (HashMap)localObject, 1);
              AppMethodBeat.o(13790);
              return;
            }
            switch (paramAnonymousMessage.what)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.TraeAudioManagerLooper.this.stopService();
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.TraeAudioManagerLooper.this.InternalSessionGetDeviceList((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.this.InternalSessionIsDeviceChangabled((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.this.InternalSessionGetConnectedDevice((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.this.InternalSessionGetConnectingDevice((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.TraeAudioManagerLooper.this.InternalVoicecallPreprocess((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            TraeAudioManager.TraeAudioManagerLooper.this.InternalVoicecallPostprocess((HashMap)localObject);
            AppMethodBeat.o(13790);
            return;
            paramAnonymousMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
            if (paramAnonymousMessage == null)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                AppMethodBeat.o(13790);
              }
            }
            else
            {
              TraeAudioManager.this._streamType = paramAnonymousMessage.intValue();
              TraeAudioManager.TraeAudioManagerLooper.this.InternalNotifyStreamTypeUpdate(paramAnonymousMessage.intValue());
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.TraeAudioManagerLooper.this.InternalStartRing((HashMap)localObject);
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.TraeAudioManagerLooper.this.InternalStopRing((HashMap)localObject);
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.TraeAudioManagerLooper.this.abandonAudioFocus();
              AppMethodBeat.o(13790);
              return;
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.TraeAudioManagerLooper.this.InternalGetStreamType((HashMap)localObject);
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.this.InternalSessionConnectDevice((HashMap)localObject);
              AppMethodBeat.o(13790);
              return;
              TraeAudioManager.this.InternalSessionEarAction((HashMap)localObject);
              AppMethodBeat.o(13790);
              return;
              paramAnonymousMessage = TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice();
              localObject = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramAnonymousMessage);
              }
              if (TraeAudioManager.IsUpdateSceneFlag)
              {
                if ((TraeAudioManager.IsMusicScene) && (!TraeAudioManager.this.IsBluetoothA2dpExisted))
                {
                  TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null, true);
                  AppMethodBeat.o(13790);
                  return;
                }
                TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, true);
                AppMethodBeat.o(13790);
                return;
              }
              if (!paramAnonymousMessage.equals(localObject))
              {
                TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, false);
                AppMethodBeat.o(13790);
                return;
              }
              TraeAudioManager.this.InternalNotifyDeviceListUpdate();
              AppMethodBeat.o(13790);
              return;
              paramAnonymousMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
              if (TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, false) != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 2, " plugin dev:" + paramAnonymousMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                }
                TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
                AppMethodBeat.o(13790);
                return;
                if (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, null, false) != 0)
                {
                  paramAnonymousMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
                  if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " plugout dev:" + paramAnonymousMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                  }
                  TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
                }
              }
            }
          }
        }
      };
      _init();
      synchronized (this._started)
      {
        this._started[0] = true;
        this._started.notifyAll();
        Looper.loop();
        _uninit();
      }
      synchronized (this._started)
      {
        this._started[0] = false;
        this._started.notifyAll();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13918);
        return;
        localObject1 = finally;
        AppMethodBeat.o(13918);
        throw localObject1;
      }
    }
    
    public int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13913);
      if (this.mMsgHandler == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(" fail mMsgHandler==null _enabled:");
        if (this._enabled) {}
        for (paramHashMap = "Y";; paramHashMap = "N")
        {
          AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + paramInt);
          AppMethodBeat.o(13913);
          return -1;
        }
      }
      paramHashMap = Message.obtain(this.mMsgHandler, paramInt, paramHashMap);
      if (this.mMsgHandler.sendMessage(paramHashMap))
      {
        AppMethodBeat.o(13913);
        return 0;
      }
      AppMethodBeat.o(13913);
      return -1;
    }
    
    void startService(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(13914);
      String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
      StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
      if (this._enabled) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " cfg:" + str);
        if (TraeAudioManager.this._context != null) {
          break;
        }
        AppMethodBeat.o(13914);
        return;
      }
      QLog.w("TRAE", 2, "   startService:".concat(String.valueOf(str)));
      if (((this._enabled) && (this._lastCfg.equals(str))) || (TraeAudioManager.this._activeMode != 0))
      {
        AppMethodBeat.o(13914);
        return;
      }
      if (this._enabled) {
        stopService();
      }
      _prev_startService();
      TraeAudioManager.this._context.getSystemService("audio");
      TraeAudioManager.this._deviceConfigManager.clearConfig();
      TraeAudioManager.this._deviceConfigManager.init(str);
      this._lastCfg = str;
      if (TraeAudioManager.this._am != null) {
        this._preServiceMode = TraeAudioManager.this._am.getMode();
      }
      this._enabled = true;
      if (this._ringPlayer == null) {
        this._ringPlayer = new TraeMediaPlayer(TraeAudioManager.this._context, new TraeMediaPlayer.OnCompletionListener()
        {
          public void onCompletion()
          {
            AppMethodBeat.i(13892);
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + TraeAudioManager.TraeAudioManagerLooper.this._preRingMode);
            }
            HashMap localHashMap = new HashMap();
            localHashMap.put("PARAM_ISHOSTSIDE", Boolean.TRUE);
            TraeAudioManager.TraeAudioManagerLooper.this.sendMessage(32783, localHashMap);
            TraeAudioManager.TraeAudioManagerLooper.this.notifyRingCompletion();
            AppMethodBeat.o(13892);
          }
        });
      }
      notifyServiceState(this._enabled);
      TraeAudioManager.this.updateDeviceStatus();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13914);
    }
    
    void stopService()
    {
      AppMethodBeat.i(13916);
      StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
      if (this._enabled) {}
      for (String str = "Y";; str = "N")
      {
        AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + TraeAudioManager.this._activeMode);
        if (this._enabled) {
          break;
        }
        AppMethodBeat.o(13916);
        return;
      }
      if (TraeAudioManager.this._activeMode == 1) {
        interruptVoicecallPostprocess();
      }
      for (;;)
      {
        if (TraeAudioManager.this._switchThread != null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "_switchThread:" + TraeAudioManager.this._switchThread.getDeviceName());
          }
          TraeAudioManager.this._switchThread.quit();
          TraeAudioManager.this._switchThread = null;
        }
        if (this._ringPlayer != null) {
          this._ringPlayer.stopRing();
        }
        this._ringPlayer = null;
        this._enabled = false;
        notifyServiceState(this._enabled);
        if ((TraeAudioManager.this._am != null) && (TraeAudioManager.this._context != null)) {}
        try
        {
          TraeAudioManager.this.InternalSetMode(0);
          if (isNeedForceVolumeType())
          {
            QLog.w("TRAE", 2, "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
            TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, 3);
          }
          _post_stopService();
          AudioDeviceInterface.LogTraceExit();
          AppMethodBeat.o(13916);
          return;
          if (TraeAudioManager.this._activeMode != 2) {
            continue;
          }
          interruptRing();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "set mode failed." + localException.getMessage());
            }
          }
        }
      }
    }
  }
  
  class bluetoothHeadsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    bluetoothHeadsetSwitchThread()
    {
      super();
    }
    
    @TargetApi(8)
    public void _quit()
    {
      AppMethodBeat.i(13690);
      if (TraeAudioManager.this._am == null)
      {
        AppMethodBeat.o(13690);
        return;
      }
      _stopBluetoothSco();
      AppMethodBeat.o(13690);
    }
    
    public void _run()
    {
      AppMethodBeat.i(13689);
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
        }
        updateStatus();
        AppMethodBeat.o(13689);
        return;
      }
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect bluetoothHeadset: disableDeviceSwitchFlag");
        }
        AppMethodBeat.o(13689);
        return;
      }
      try
      {
        Thread.sleep(1000L);
        label103:
        _startBluetoothSco();
        int i = 0;
        for (;;)
        {
          int j;
          StringBuilder localStringBuilder;
          if (this._running == true)
          {
            j = i + 1;
            if (i < 10) {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder("bluetoothHeadsetSwitchThread i:").append(j).append(" sco:");
                if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                  break label282;
                }
              }
            }
          }
          label282:
          for (String str = "Y";; str = "N")
          {
            QLog.w("TRAE", 2, str + " :" + TraeAudioManager.this._deviceConfigManager.getBluetoothName());
            if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
              break;
            }
            updateStatus();
            if (!TraeAudioManager.this._am.isBluetoothScoOn())
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
              }
              TraeAudioManager.this._deviceConfigManager.setVisible(getDeviceName(), false);
              processDeviceConnectRes(10);
              TraeAudioManager.this.checkAutoDeviceListUpdate();
            }
            AppMethodBeat.o(13689);
            return;
          }
          try
          {
            Thread.sleep(1000L);
            i = j;
          }
          catch (InterruptedException localInterruptedException1)
          {
            i = j;
          }
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label103;
      }
    }
    
    @TargetApi(8)
    void _startBluetoothSco()
    {
      AppMethodBeat.i(13691);
      TraeAudioManager.this._am.setBluetoothScoOn(true);
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.startBluetoothSco();
      }
      AppMethodBeat.o(13691);
    }
    
    @TargetApi(8)
    void _stopBluetoothSco()
    {
      AppMethodBeat.i(13692);
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.stopBluetoothSco();
      }
      TraeAudioManager.this._am.setBluetoothScoOn(false);
      AppMethodBeat.o(13692);
    }
    
    public String getDeviceName()
    {
      return "DEVICE_BLUETOOTHHEADSET";
    }
  }
  
  class earphoneSwitchThread
    extends TraeAudioManager.switchThread
  {
    earphoneSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      AppMethodBeat.i(13634);
      if ((TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag)) {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
      }
      updateStatus();
      if (!TraeAudioManager.IsUpdateSceneFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect earphone: do nothing");
        }
        AppMethodBeat.o(13634);
        return;
      }
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect earphone: disableDeviceSwitchFlag");
        }
        AppMethodBeat.o(13634);
        return;
      }
      for (;;)
      {
        long l;
        if (this._running == true)
        {
          if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
          }
          if (i < 5) {
            l = 1000L;
          }
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label142:
            i += 1;
            break;
            l = 4000L;
          }
          AppMethodBeat.o(13634);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label142;
        }
        int i = 0;
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_EARPHONE";
    }
  }
  
  class headsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    headsetSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      AppMethodBeat.i(13903);
      if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
      {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
        TraeAudioManager.this._am.setWiredHeadsetOn(true);
      }
      updateStatus();
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect headset: do nothing");
        }
        AppMethodBeat.o(13903);
        return;
      }
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect headset: disableDeviceSwitchFlag");
        }
        AppMethodBeat.o(13903);
        return;
      }
      for (;;)
      {
        long l;
        if (this._running == true)
        {
          if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
          }
          if (i < 5) {
            l = 1000L;
          }
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label165:
            i += 1;
            break;
            l = 4000L;
          }
          AppMethodBeat.o(13903);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label165;
        }
        int i = 0;
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_WIREDHEADSET";
    }
  }
  
  class speakerSwitchThread
    extends TraeAudioManager.switchThread
  {
    speakerSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      AppMethodBeat.i(13649);
      int j = 0;
      if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag)) {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
      }
      updateStatus();
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
        }
        AppMethodBeat.o(13649);
        return;
      }
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "connect speakerPhone: disableDeviceSwitchFlag");
        }
        AppMethodBeat.o(13649);
        return;
      }
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, " _run:" + getDeviceName() + " _running:" + this._running);
        i = j;
      }
      for (;;)
      {
        long l;
        if (this._running == true)
        {
          if (TraeAudioManager.this._am.isSpeakerphoneOn() != true) {
            TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
          }
          if (i < 5) {
            l = 1000L;
          }
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label204:
            i += 1;
            break;
            l = 4000L;
          }
          AppMethodBeat.o(13649);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label204;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  abstract class switchThread
    extends Thread
  {
    boolean[] _exited = { false };
    HashMap<String, Object> _params = null;
    boolean _running = true;
    long _usingtime = 0L;
    
    switchThread()
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " ++switchThread:" + getDeviceName());
      }
    }
    
    public abstract void _quit();
    
    public abstract void _run();
    
    public abstract String getDeviceName();
    
    void processDeviceConnectRes(int paramInt)
    {
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + paramInt);
      if (this._params == null) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      do
      {
        return;
        TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
        localObject = (Long)this._params.get("PARAM_SESSIONID");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " sessonID:".concat(String.valueOf(localObject)));
        }
        if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
          break;
        }
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
      if (TraeAudioManager.this.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void quit()
    {
      AudioDeviceInterface.LogTraceEntry(getDeviceName());
      this._running = false;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " quit:" + getDeviceName() + " _running:" + this._running);
      }
      interrupt();
      _quit();
      synchronized (this._exited)
      {
        int i = this._exited[0];
        if (i != 0) {}
      }
      try
      {
        this._exited.wait(10000L);
        label91:
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label91;
      }
    }
    
    public void run()
    {
      AudioDeviceInterface.LogTraceEntry(getDeviceName());
      TraeAudioManager.this._deviceConfigManager.setConnecting(getDeviceName());
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      _run();
      synchronized (this._exited)
      {
        this._exited[0] = true;
        this._exited.notifyAll();
        AudioDeviceInterface.LogTraceExit();
        return;
      }
    }
    
    public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
    {
      this._params = paramHashMap;
    }
    
    void updateStatus()
    {
      TraeAudioManager.this._deviceConfigManager.setConnected(getDeviceName());
      processDeviceConnectRes(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */