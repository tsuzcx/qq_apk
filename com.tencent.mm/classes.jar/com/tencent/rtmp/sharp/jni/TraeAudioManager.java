package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
  TraeAudioManager.d _bluetoothCheck;
  Context _context;
  e _deviceConfigManager;
  ReentrantLock _lock;
  int _modePolicy;
  int _prevMode;
  int _streamType;
  TraeAudioManager.k _switchThread;
  TraeAudioManager.f mTraeAudioManagerLooper;
  String sessionConnectedDev;
  
  static
  {
    AppMethodBeat.i(65758);
    IsMusicScene = false;
    IsEarPhoneSupported = false;
    IsUpdateSceneFlag = false;
    enableDeviceSwitchFlag = true;
    _glock = new ReentrantLock();
    _ginstance = null;
    _gHostProcessId = -1;
    forceName = new String[] { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
    AppMethodBeat.o(65758);
  }
  
  TraeAudioManager(Context paramContext)
  {
    AppMethodBeat.i(65719);
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
      AppMethodBeat.o(65719);
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManager.f(this, this);
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65719);
  }
  
  static boolean IsEabiLowVersion()
  {
    AppMethodBeat.i(65703);
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      a.dUd();
      a.iP("TRAE", "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1)))
      {
        AppMethodBeat.o(65703);
        return true;
      }
    }
    catch (Exception localException)
    {
      if (IsEabiLowVersionByAbi(str2))
      {
        AppMethodBeat.o(65703);
        return true;
      }
      AppMethodBeat.o(65703);
      return false;
    }
    AppMethodBeat.o(65703);
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    AppMethodBeat.i(65702);
    if (paramString == null)
    {
      AppMethodBeat.o(65702);
      return true;
    }
    if (paramString.contains("x86"))
    {
      AppMethodBeat.o(65702);
      return false;
    }
    if (paramString.contains("mips"))
    {
      AppMethodBeat.o(65702);
      return false;
    }
    if (paramString.equalsIgnoreCase("armeabi"))
    {
      AppMethodBeat.o(65702);
      return true;
    }
    if (paramString.equalsIgnoreCase("armeabi-v7a"))
    {
      AppMethodBeat.o(65702);
      return false;
    }
    if (paramString.equalsIgnoreCase("arm64-v8a"))
    {
      AppMethodBeat.o(65702);
      return false;
    }
    AppMethodBeat.o(65702);
    return true;
  }
  
  public static int SetSpeakerForTest(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(65711);
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.InternalSetSpeaker(paramContext, paramBoolean);
    }
    for (;;)
    {
      _glock.unlock();
      AppMethodBeat.o(65711);
      return i;
      a.dUd();
      a.iP("TRAE", "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
    }
  }
  
  public static boolean checkDevName(String paramString)
  {
    AppMethodBeat.i(65698);
    if (paramString == null)
    {
      AppMethodBeat.o(65698);
      return false;
    }
    if ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString)))
    {
      AppMethodBeat.o(65698);
      return false;
    }
    AppMethodBeat.o(65698);
    return true;
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(65728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(65728);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    int i = sendMessage(32775, localHashMap);
    AppMethodBeat.o(65728);
    return i;
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65729);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32789, localHashMap);
    AppMethodBeat.o(65729);
    return i;
  }
  
  static int disableDeviceSwitch()
  {
    enableDeviceSwitchFlag = false;
    return 0;
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(65730);
    if ((paramInt != 0) && (paramInt != 1))
    {
      AppMethodBeat.o(65730);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    paramInt = sendMessage(32776, localHashMap);
    AppMethodBeat.o(65730);
    return paramInt;
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    AppMethodBeat.i(65757);
    if (Build.MANUFACTURER.equals("Google"))
    {
      a.dUd();
      a.iP("TRAE", "forceVolumeControlStream, Google phone nothing to do");
      AppMethodBeat.o(65757);
      return;
    }
    Class localClass = Integer.TYPE;
    paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    a.dUd();
    a.iP("TRAE", "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
    AppMethodBeat.o(65757);
  }
  
  static int getAudioSource(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(65704);
    if (IsMusicScene)
    {
      AppMethodBeat.o(65704);
      return 0;
    }
    if (IsEabiLowVersion())
    {
      a.dUd();
      a.iP("TRAE", "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:0");
      AppMethodBeat.o(65704);
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      a.dUd();
      a.iP("TRAE", "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
      AppMethodBeat.o(65704);
      return paramInt;
    }
    if (j >= 11) {
      i = 7;
    }
    a.dUd();
    a.iP("TRAE", "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    AppMethodBeat.o(65704);
    return i;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(65705);
    if (IsMusicScene)
    {
      AppMethodBeat.o(65705);
      return 3;
    }
    if (IsEabiLowVersion())
    {
      a.dUd();
      a.iP("TRAE", "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:3");
      AppMethodBeat.o(65705);
      return 3;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      a.dUd();
      a.iP("TRAE", "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      AppMethodBeat.o(65705);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(65706);
    if (IsMusicScene)
    {
      AppMethodBeat.o(65706);
      return 0;
    }
    if (IsEabiLowVersion())
    {
      a.dUd();
      a.iP("TRAE", "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:0");
      AppMethodBeat.o(65706);
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      a.dUd();
      a.iP("TRAE", "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
      AppMethodBeat.o(65706);
      return paramInt;
    }
    if (j >= 11) {
      i = 3;
    }
    a.dUd();
    a.iP("TRAE", "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
    AppMethodBeat.o(65706);
    return i;
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65732);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32778, localHashMap);
    AppMethodBeat.o(65732);
    return i;
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65733);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32779, localHashMap);
    AppMethodBeat.o(65733);
    return i;
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65724);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32774, localHashMap);
    AppMethodBeat.o(65724);
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
    AppMethodBeat.i(65756);
    Object localObject = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localObject });
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      a.dUd();
      a.iP("TRAE", "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + getForceConfigName(((Integer)localObject).intValue()));
      paramInt = ((Integer)localObject).intValue();
      AppMethodBeat.o(65756);
      return paramInt;
    }
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65725);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32784, localHashMap);
    AppMethodBeat.o(65725);
    return i;
  }
  
  public static int init(Context paramContext)
  {
    AppMethodBeat.i(65717);
    new StringBuilder("TraeAudioManager init _ginstance:").append(_ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65717);
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(65751);
    Object localObject = null;
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      AppMethodBeat.o(65751);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "invokeMethod Exception:" + paramObject.getMessage());
        paramObject = localObject;
      }
    }
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    localObject = null;
    AppMethodBeat.i(65752);
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      paramString1 = paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "ClassNotFound:".concat(String.valueOf(paramString1)));
        paramString1 = localObject;
      }
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "NoSuchMethod:".concat(String.valueOf(paramString2)));
        paramString1 = localObject;
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "IllegalArgument:".concat(String.valueOf(paramString2)));
        paramString1 = localObject;
      }
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "IllegalAccess:".concat(String.valueOf(paramString2)));
        paramString1 = localObject;
      }
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "InvocationTarget:".concat(String.valueOf(paramString2)));
        paramString1 = localObject;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "invokeStaticMethod Exception:" + paramString1.getMessage());
        paramString1 = localObject;
      }
    }
    AppMethodBeat.o(65752);
    return paramString1;
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    AppMethodBeat.i(65701);
    if (paramInt != -1)
    {
      AppMethodBeat.o(65701);
      return false;
    }
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 2"))
      {
        AppMethodBeat.o(65701);
        return true;
      }
      if (Build.MODEL.equals("MI 2A"))
      {
        AppMethodBeat.o(65701);
        return true;
      }
      if (Build.MODEL.equals("MI 2S"))
      {
        AppMethodBeat.o(65701);
        return true;
      }
      if (Build.MODEL.equals("MI 2SC"))
      {
        AppMethodBeat.o(65701);
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SCH-I959")))
    {
      AppMethodBeat.o(65701);
      return true;
    }
    AppMethodBeat.o(65701);
    return false;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65731);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32777, localHashMap);
    AppMethodBeat.o(65731);
    return i;
  }
  
  public static boolean isHandfree(String paramString)
  {
    AppMethodBeat.i(65699);
    if (!checkDevName(paramString))
    {
      AppMethodBeat.o(65699);
      return false;
    }
    if ("DEVICE_SPEAKERPHONE".equals(paramString))
    {
      AppMethodBeat.o(65699);
      return true;
    }
    AppMethodBeat.o(65699);
    return false;
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65740);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32791, localHashMap);
    AppMethodBeat.o(65740);
    return i;
  }
  
  public static int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean, long paramLong, Context paramContext)
  {
    AppMethodBeat.i(146904);
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
      AppMethodBeat.o(146904);
      return i;
      label56:
      _ginstance._audioSessionHost.remove(paramLong);
    }
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65739);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32790, localHashMap);
    AppMethodBeat.o(65739);
    return i;
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65716);
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    AppMethodBeat.o(65716);
    return i;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65755);
    Object localObject = Integer.TYPE;
    Class localClass = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, new Class[] { localObject, localClass });
    a.dUd();
    a.iP("TRAE", "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    AppMethodBeat.o(65755);
  }
  
  static void setParameters(String paramString)
  {
    AppMethodBeat.i(65753);
    a.dUd();
    a.iP("TRAE", "setParameters  :".concat(String.valueOf(paramString)));
    invokeStaticMethod("android.media.AudioSystem", "setParameters", new Object[] { paramString }, new Class[] { String.class });
    AppMethodBeat.o(65753);
  }
  
  static void setPhoneState(int paramInt)
  {
    AppMethodBeat.i(65754);
    Class localClass = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    AppMethodBeat.o(65754);
  }
  
  static int startRing(String paramString1, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    AppMethodBeat.i(65737);
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
    AppMethodBeat.o(65737);
    return paramInt1;
  }
  
  static int startService(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(65726);
    if (paramString2.length() <= 0)
    {
      AppMethodBeat.o(65726);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    int i = sendMessage(32772, localHashMap);
    AppMethodBeat.o(65726);
    return i;
  }
  
  static int stopRing(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65738);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32783, localHashMap);
    AppMethodBeat.o(65738);
    return i;
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65727);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32773, localHashMap);
    AppMethodBeat.o(65727);
    return i;
  }
  
  public static void uninit()
  {
    AppMethodBeat.i(65718);
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
    AppMethodBeat.o(65718);
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65736);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    paramInt1 = sendMessage(32788, localHashMap);
    AppMethodBeat.o(65736);
    return paramInt1;
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(65735);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    int i = sendMessage(32781, localHashMap);
    AppMethodBeat.o(65735);
    return i;
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65734);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    paramInt1 = sendMessage(32780, localHashMap);
    AppMethodBeat.o(65734);
    return paramInt1;
  }
  
  public TraeAudioManager.d CreateBluetoothCheck(Context paramContext, e parame)
  {
    AppMethodBeat.i(65750);
    Object localObject1;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = new TraeAudioManager.a(this);
      localObject2 = localObject1;
      if (!((TraeAudioManager.d)localObject1).a(paramContext, parame)) {
        localObject2 = new TraeAudioManager.b(this);
      }
      a.dUd();
      parame = new StringBuilder("CreateBluetoothCheck:").append(((TraeAudioManager.d)localObject2).c()).append(" skip android4.3:");
      if (Build.VERSION.SDK_INT != 18) {
        break label141;
      }
    }
    label141:
    for (paramContext = "Y";; paramContext = "N")
    {
      a.iP("TRAE", paramContext);
      AppMethodBeat.o(65750);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new TraeAudioManager.c(this);
        break;
      }
      localObject1 = new TraeAudioManager.b(this);
      break;
    }
  }
  
  int InternalConnectDevice(String paramString, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(65742);
    AudioDeviceInterface.LogTraceEntry(" devName:".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(65742);
      return -1;
    }
    if ((IsMusicScene) && (paramString.equals("DEVICE_EARPHONE")))
    {
      a.dUd();
      a.iO("TRAE", "MusicScene, Connect device:" + paramString + " failed");
      AppMethodBeat.o(65742);
      return -1;
    }
    if ((!IsEarPhoneSupported) && (paramString.equals("DEVICE_EARPHONE")))
    {
      a.dUd();
      a.iO("TRAE", "IsEarPhoneSupported = false, Connect device:" + paramString + " failed");
      AppMethodBeat.o(65742);
      return -1;
    }
    if ((!paramBoolean) && (!this._deviceConfigManager.h().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.h())))
    {
      AppMethodBeat.o(65742);
      return 0;
    }
    if ((checkDevName(paramString) != true) || (this._deviceConfigManager.c(paramString) != true))
    {
      a.dUd();
      a.iO("TRAE", " checkDevName fail");
      AppMethodBeat.o(65742);
      return -1;
    }
    if (InternalIsDeviceChangeable() != true)
    {
      a.dUd();
      a.iO("TRAE", " InternalIsDeviceChangeable fail");
      AppMethodBeat.o(65742);
      return -1;
    }
    if (this._switchThread != null)
    {
      a.dUd();
      a.iP("TRAE", "_switchThread:" + this._switchThread.b());
      this._switchThread.g();
      this._switchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this._switchThread = new TraeAudioManager.h(this);
    }
    for (;;)
    {
      if (this._switchThread != null)
      {
        this._switchThread.a(paramHashMap);
        this._switchThread.start();
      }
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65742);
      return 0;
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        this._switchThread = new TraeAudioManager.j(this);
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        this._switchThread = new TraeAudioManager.i(this);
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        this._switchThread = new g();
      }
    }
  }
  
  boolean InternalIsDeviceChangeable()
  {
    AppMethodBeat.i(65744);
    String str = this._deviceConfigManager.g();
    if ((str == null) || (str.equals("DEVICE_NONE")) || (str.equals("")))
    {
      AppMethodBeat.o(65744);
      return true;
    }
    AppMethodBeat.o(65744);
    return false;
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    AppMethodBeat.i(65749);
    if (this._context == null)
    {
      AppMethodBeat.o(65749);
      return -1;
    }
    boolean bool = InternalIsDeviceChangeable();
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.3(this, bool));
    AppMethodBeat.o(65749);
    return 0;
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AppMethodBeat.i(65748);
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null)
    {
      AppMethodBeat.o(65748);
      return -1;
    }
    Object localObject = this._deviceConfigManager.j();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str1 = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    String str2 = this._deviceConfigManager.d();
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.2(this, localArrayList, str1, (String)localObject, str2));
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65748);
    return 0;
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65741);
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null))
    {
      AppMethodBeat.o(65741);
      return -1;
    }
    if (IsMusicScene)
    {
      a.dUd();
      a.iP("TRAE", "MusicScene: InternalSessionConnectDevice failed");
      AppMethodBeat.o(65741);
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    if ((!IsEarPhoneSupported) && (str.equals("DEVICE_EARPHONE")))
    {
      a.dUd();
      a.iO("TRAE", "InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:" + str + " failed");
      AppMethodBeat.o(65741);
      return -1;
    }
    boolean bool = InternalIsDeviceChangeable();
    int i;
    if (checkDevName(str) != true) {
      i = 7;
    }
    for (;;)
    {
      a.dUd();
      StringBuilder localStringBuilder = new StringBuilder("sessonID:").append((Long)paramHashMap.get("PARAM_SESSIONID")).append(" devName:").append(str).append(" bChangabled:");
      if (bool) {}
      for (Object localObject = "Y";; localObject = "N")
      {
        a.iP("TRAE", (String)localObject + " err:" + i);
        if (i == 0) {
          break label307;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        AppMethodBeat.o(65741);
        return -1;
        if (!this._deviceConfigManager.c(str))
        {
          i = 8;
          break;
        }
        if (bool) {
          break label411;
        }
        i = 9;
        break;
      }
      label307:
      if (str.equals(this._deviceConfigManager.h()))
      {
        a.dUd();
        a.iO("TRAE", " --has connected!");
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        AppMethodBeat.o(65741);
        return 0;
      }
      a.dUd();
      a.iP("TRAE", " --connecting...");
      InternalConnectDevice(str, paramHashMap, false);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65741);
      return 0;
      label411:
      i = 0;
    }
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65745);
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.h());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(65745);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65746);
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.g());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(65746);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65743);
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    AppMethodBeat.o(65743);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    AppMethodBeat.i(65714);
    a.dUd();
    a.iP("TRAE", "SetMode entry:".concat(String.valueOf(paramInt)));
    if (this._am == null)
    {
      a.dUd();
      a.iP("TRAE", "setMode:" + paramInt + " fail am=null");
      AppMethodBeat.o(65714);
      return;
    }
    this._am.setMode(paramInt);
    a.dUd();
    StringBuilder localStringBuilder = new StringBuilder("setMode:").append(paramInt);
    if (this._am.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      a.iP("TRAE", str);
      AppMethodBeat.o(65714);
      return;
    }
  }
  
  int InternalSetSpeaker(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(65712);
    if (paramContext == null)
    {
      a.dUd();
      a.iO("TRAE", "Could not InternalSetSpeaker - no context");
      AppMethodBeat.o(65712);
      return -1;
    }
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager == null)
    {
      a.dUd();
      a.iO("TRAE", "Could not InternalSetSpeaker - no audio manager");
      AppMethodBeat.o(65712);
      return -1;
    }
    a.dUd();
    StringBuilder localStringBuilder = new StringBuilder("InternalSetSpeaker entry:speaker:");
    if (localAudioManager.isSpeakerphoneOn())
    {
      paramContext = "Y";
      localStringBuilder = localStringBuilder.append(paramContext).append("-->:");
      if (!paramBoolean) {
        break label175;
      }
    }
    label175:
    for (paramContext = "Y";; paramContext = "N")
    {
      a.iP("TRAE", paramContext);
      if ((!isCloseSystemAPM(this._modePolicy)) || (this._activeMode == 2)) {
        break label182;
      }
      i = InternalSetSpeakerSpe(localAudioManager, paramBoolean);
      AppMethodBeat.o(65712);
      return i;
      paramContext = "N";
      break;
    }
    label182:
    if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
      localAudioManager.setSpeakerphoneOn(paramBoolean);
    }
    if (localAudioManager.isSpeakerphoneOn() == paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      a.dUd();
      a.iP("TRAE", "InternalSetSpeaker exit:" + paramBoolean + " res:" + i + " mode:" + localAudioManager.getMode());
      AppMethodBeat.o(65712);
      return i;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(65713);
    a.dUd();
    a.iP("TRAE", "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label178;
      }
    }
    for (;;)
    {
      a.dUd();
      a.iP("TRAE", "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      AppMethodBeat.o(65713);
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      break;
      label178:
      i = -1;
    }
  }
  
  void _updateEarphoneVisable()
  {
    AppMethodBeat.i(65708);
    if (this._deviceConfigManager.c("DEVICE_WIREDHEADSET"))
    {
      a.dUd();
      a.iP("TRAE", " detected headset plugin,so disable earphone");
      this._deviceConfigManager.a("DEVICE_EARPHONE", false);
      AppMethodBeat.o(65708);
      return;
    }
    a.dUd();
    a.iP("TRAE", " detected headset plugout,so enable earphone");
    this._deviceConfigManager.a("DEVICE_EARPHONE", true);
    AppMethodBeat.o(65708);
  }
  
  void checkAutoDeviceListUpdate()
  {
    AppMethodBeat.i(65709);
    if (this._deviceConfigManager.b() == true)
    {
      a.dUd();
      a.iP("TRAE", "checkAutoDeviceListUpdate got update!");
      _updateEarphoneVisable();
      this._deviceConfigManager.c();
      internalSendMessage(32785, new HashMap());
    }
    AppMethodBeat.o(65709);
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(65710);
    if (this._deviceConfigManager.b() == true)
    {
      a.dUd();
      StringBuilder localStringBuilder = new StringBuilder("checkDevicePlug got update dev:").append(paramString);
      if (paramBoolean) {}
      for (Object localObject = " piugin";; localObject = " plugout")
      {
        a.iP("TRAE", (String)localObject + " connectedDev:" + this._deviceConfigManager.h());
        _updateEarphoneVisable();
        this._deviceConfigManager.c();
        if (!paramBoolean) {
          break;
        }
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_DEVICE", paramString);
        internalSendMessage(32786, (HashMap)localObject);
        AppMethodBeat.o(65710);
        return;
      }
      localObject = this._deviceConfigManager.h();
      if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_DEVICE", paramString);
        internalSendMessage(32787, (HashMap)localObject);
        AppMethodBeat.o(65710);
        return;
      }
      a.dUd();
      a.iP("TRAE", " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
      internalSendMessage(32785, new HashMap());
    }
    AppMethodBeat.o(65710);
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65723);
    int i = -1;
    if (this.mTraeAudioManagerLooper != null) {
      i = this.mTraeAudioManagerLooper.a(paramInt, paramHashMap);
    }
    AppMethodBeat.o(65723);
    return i;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(65722);
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
          break label252;
        }
        paramContext = "Y";
        label174:
        paramContext = paramContext;
      }
      a.dUd();
      a.iP("TRAE", "onHeadsetPlug:: ".concat(String.valueOf(paramContext)));
      paramContext = this._deviceConfigManager;
      if (1 != i) {
        break label259;
      }
    }
    label259:
    for (boolean bool = true;; bool = false)
    {
      paramContext.a("DEVICE_WIREDHEADSET", bool);
      a.dUd();
      a.iP("TRAE", "onHeadsetPlug exit");
      AppMethodBeat.o(65722);
      return;
      paramContext = "plugged";
      break;
      label252:
      paramContext = "unkown";
      break label174;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(65721);
    if ((paramIntent == null) || (paramContext == null))
    {
      a.dUd();
      a.iQ("TRAE", "onReceive intent or context is null!");
      AppMethodBeat.o(65721);
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
      a.dUd();
      a.iP("TRAE", "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
      if (this._deviceConfigManager == null)
      {
        a.dUd();
        a.iQ("TRAE", "_deviceConfigManager null!");
        AppMethodBeat.o(65721);
        return;
      }
      bool1 = this._deviceConfigManager.c("DEVICE_WIREDHEADSET");
      bool2 = this._deviceConfigManager.c("DEVICE_BLUETOOTHHEADSET");
      if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
      {
        onHeadsetPlug(paramContext, paramIntent);
        if ((!bool1) && (this._deviceConfigManager.c("DEVICE_WIREDHEADSET") == true)) {
          checkDevicePlug("DEVICE_WIREDHEADSET", true);
        }
        if ((bool1 != true) || (this._deviceConfigManager.c("DEVICE_WIREDHEADSET"))) {
          break label970;
        }
        checkDevicePlug("DEVICE_WIREDHEADSET", false);
        AppMethodBeat.o(65721);
        return;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(65721);
      return;
    }
    if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction())) {
      if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
      {
        a.dUd();
        a.iP("TRAE", "   OPERATION:".concat(String.valueOf(str1)));
        if ("OPERATION_STARTSERVICE".equals(str1))
        {
          startService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"));
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_STOPSERVICE".equals(str1))
        {
          stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_GETDEVICELIST".equals(str1))
        {
          getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_GETSTREAMTYPE".equals(str1))
        {
          getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_CONNECTDEVICE".equals(str1))
        {
          connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
        {
          connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_EARACTION".equals(str1))
        {
          earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
        {
          isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
        {
          getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
        {
          getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        int i;
        int j;
        if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
        {
          i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
          j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
          voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
        {
          voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
        {
          i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
          j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
          voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
          AppMethodBeat.o(65721);
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
          AppMethodBeat.o(65721);
          return;
        }
        if ("OPERATION_STOPRING".equals(str1))
        {
          stopRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
          AppMethodBeat.o(65721);
        }
      }
      else if (this._deviceConfigManager != null)
      {
        if (this._bluetoothCheck != null) {
          this._bluetoothCheck.a(paramContext, paramIntent, this._deviceConfigManager);
        }
        if ((!bool2) && (this._deviceConfigManager.c("DEVICE_BLUETOOTHHEADSET") == true)) {
          checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
        if ((bool2 == true) && (!this._deviceConfigManager.c("DEVICE_BLUETOOTHHEADSET"))) {
          checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
      }
    }
    label970:
    AppMethodBeat.o(65721);
  }
  
  void printDevices()
  {
    int j = 0;
    AppMethodBeat.i(65700);
    AudioDeviceInterface.LogTraceEntry("");
    int k = this._deviceConfigManager.e();
    a.dUd();
    a.iP("TRAE", "   ConnectedDevice:" + this._deviceConfigManager.h());
    a.dUd();
    a.iP("TRAE", "   ConnectingDevice:" + this._deviceConfigManager.g());
    a.dUd();
    a.iP("TRAE", "   prevConnectedDevice:" + this._deviceConfigManager.i());
    a.dUd();
    a.iP("TRAE", "   AHPDevice:" + this._deviceConfigManager.f());
    a.dUd();
    a.iP("TRAE", "   deviceNamber:".concat(String.valueOf(k)));
    int i = 0;
    while (i < k)
    {
      localObject = this._deviceConfigManager.a(i);
      a.dUd();
      a.iP("TRAE", "      " + i + " devName:" + (String)localObject + " Visible:" + this._deviceConfigManager.c((String)localObject) + " Priority:" + this._deviceConfigManager.d((String)localObject));
      i += 1;
    }
    Object localObject = (String[])this._deviceConfigManager.k().toArray(new String[0]);
    a.dUd();
    a.iP("TRAE", "   AvailableNamber:" + localObject.length);
    i = j;
    while (i < localObject.length)
    {
      String str = localObject[i];
      a.dUd();
      a.iP("TRAE", "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.c(str) + " Priority:" + this._deviceConfigManager.d(str));
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65700);
  }
  
  public void release()
  {
    AppMethodBeat.i(65720);
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mTraeAudioManagerLooper != null)
    {
      this.mTraeAudioManagerLooper.a();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65720);
  }
  
  int sendResBroadcast(final Intent paramIntent, final HashMap<String, Object> paramHashMap, final int paramInt)
  {
    AppMethodBeat.i(65747);
    if (this._context == null)
    {
      AppMethodBeat.o(65747);
      return -1;
    }
    final Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    a.dUd();
    a.iP("TRAE", " sessonID:" + localLong + " " + (String)paramHashMap.get("PARAM_OPERATION"));
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      InternalNotifyDeviceListUpdate();
      a.dUd();
      a.iO("TRAE", "sendResBroadcast sid null,don't send res");
      AppMethodBeat.o(65747);
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
      AppMethodBeat.o(65747);
      return 0;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(65697);
          paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
          paramIntent.putExtra("PARAM_SESSIONID", localLong);
          paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
          paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
          if (TraeAudioManager.this._context != null) {
            TraeAudioManager.this._context.sendBroadcast(paramIntent);
          }
          AppMethodBeat.o(65697);
        }
      });
    }
  }
  
  void updateDeviceStatus()
  {
    AppMethodBeat.i(65707);
    int j = this._deviceConfigManager.e();
    int i = 0;
    if (i < j)
    {
      String str = this._deviceConfigManager.a(i);
      boolean bool;
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTHHEADSET")) {
          if (this._bluetoothCheck == null) {
            bool = this._deviceConfigManager.a(str, false);
          }
        }
      }
      for (;;)
      {
        if (bool == true)
        {
          a.dUd();
          a.iP("TRAE", "pollUpdateDevice dev:" + str + " Visible:" + this._deviceConfigManager.c(str));
        }
        i += 1;
        break;
        bool = this._deviceConfigManager.a(str, this._bluetoothCheck.b());
        continue;
        if (str.equals("DEVICE_WIREDHEADSET"))
        {
          bool = this._deviceConfigManager.a(str, this._am.isWiredHeadsetOn());
        }
        else
        {
          if (str.equals("DEVICE_SPEAKERPHONE")) {
            this._deviceConfigManager.a(str, true);
          }
          bool = false;
        }
      }
    }
    checkAutoDeviceListUpdate();
    AppMethodBeat.o(65707);
  }
  
  class e
  {
    HashMap<String, TraeAudioManager.e.a> a;
    String b;
    String c;
    String d;
    ReentrantLock e;
    boolean f;
    String g;
    
    public e()
    {
      AppMethodBeat.i(65625);
      this.a = new HashMap();
      this.b = "DEVICE_NONE";
      this.c = "DEVICE_NONE";
      this.d = "DEVICE_NONE";
      this.e = new ReentrantLock();
      this.f = false;
      this.g = "unknow";
      AppMethodBeat.o(65625);
    }
    
    public String a(int paramInt)
    {
      AppMethodBeat.i(65636);
      this.e.lock();
      Object localObject = this.a.entrySet().iterator();
      int i = 0;
      Map.Entry localEntry;
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i != paramInt) {}
      }
      for (localObject = (TraeAudioManager.e.a)localEntry.getValue();; localObject = null)
      {
        if (localObject != null) {}
        for (localObject = ((TraeAudioManager.e.a)localObject).a();; localObject = "DEVICE_NONE")
        {
          this.e.unlock();
          AppMethodBeat.o(65636);
          return localObject;
          i += 1;
          break;
        }
      }
    }
    
    public void a()
    {
      AppMethodBeat.i(65628);
      this.e.lock();
      this.a.clear();
      this.b = "DEVICE_NONE";
      this.c = "DEVICE_NONE";
      this.d = "DEVICE_NONE";
      this.e.unlock();
      AppMethodBeat.o(65628);
    }
    
    public boolean a(String paramString)
    {
      AppMethodBeat.i(65626);
      AudioDeviceInterface.LogTraceEntry(" strConfigs:".concat(String.valueOf(paramString)));
      if ((paramString == null) || (paramString.length() <= 0))
      {
        AppMethodBeat.o(65626);
        return false;
      }
      String str = paramString.replace("\n", "").replace("\r", "");
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(65626);
        return false;
      }
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
      if ((paramString == null) || (1 > paramString.length))
      {
        AppMethodBeat.o(65626);
        return false;
      }
      this.e.lock();
      int i = 0;
      while (i < paramString.length)
      {
        a(paramString[i], i);
        i += 1;
      }
      this.e.unlock();
      TraeAudioManager.this.printDevices();
      AppMethodBeat.o(65626);
      return true;
    }
    
    boolean a(String paramString, int paramInt)
    {
      AppMethodBeat.i(65627);
      AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
      TraeAudioManager.e.a locala = new TraeAudioManager.e.a(this);
      if (locala.a(paramString, paramInt))
      {
        if (this.a.containsKey(paramString))
        {
          a.dUd();
          a.iO("TRAE", "err dev exist!");
          AppMethodBeat.o(65627);
          return false;
        }
        this.a.put(paramString, locala);
        this.f = true;
        a.dUd();
        a.iP("TRAE", " n" + e() + " 0:" + a(0));
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65627);
        return true;
      }
      a.dUd();
      a.iO("TRAE", " err dev init!");
      AppMethodBeat.o(65627);
      return false;
    }
    
    public boolean a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(65631);
      this.e.lock();
      Object localObject = (TraeAudioManager.e.a)this.a.get(paramString);
      if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b() != paramBoolean))
      {
        ((TraeAudioManager.e.a)localObject).a(paramBoolean);
        this.f = true;
        a.dUd();
        localObject = new StringBuilder(" ++setVisible:").append(paramString);
        if (paramBoolean)
        {
          paramString = " Y";
          a.iP("TRAE", paramString);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.e.unlock();
        AppMethodBeat.o(65631);
        return paramBoolean;
        paramString = " N";
        break;
      }
    }
    
    public void b(String paramString)
    {
      AppMethodBeat.i(65632);
      if (paramString == null)
      {
        this.g = "unknow";
        AppMethodBeat.o(65632);
        return;
      }
      if (paramString.isEmpty())
      {
        this.g = "unknow";
        AppMethodBeat.o(65632);
        return;
      }
      this.g = paramString;
      AppMethodBeat.o(65632);
    }
    
    public boolean b()
    {
      AppMethodBeat.i(65629);
      this.e.lock();
      boolean bool = this.f;
      this.e.unlock();
      AppMethodBeat.o(65629);
      return bool;
    }
    
    public void c()
    {
      AppMethodBeat.i(65630);
      this.e.lock();
      this.f = false;
      this.e.unlock();
      AppMethodBeat.o(65630);
    }
    
    public boolean c(String paramString)
    {
      AppMethodBeat.i(65633);
      this.e.lock();
      paramString = (TraeAudioManager.e.a)this.a.get(paramString);
      if (paramString != null) {}
      for (boolean bool = paramString.b();; bool = false)
      {
        this.e.unlock();
        AppMethodBeat.o(65633);
        return bool;
      }
    }
    
    public int d(String paramString)
    {
      AppMethodBeat.i(65634);
      this.e.lock();
      paramString = (TraeAudioManager.e.a)this.a.get(paramString);
      if (paramString != null) {}
      for (int i = paramString.c();; i = -1)
      {
        this.e.unlock();
        AppMethodBeat.o(65634);
        return i;
      }
    }
    
    public String d()
    {
      return this.g;
    }
    
    public int e()
    {
      AppMethodBeat.i(65635);
      this.e.lock();
      int i = this.a.size();
      this.e.unlock();
      AppMethodBeat.o(65635);
      return i;
    }
    
    public String e(String paramString)
    {
      AppMethodBeat.i(65637);
      this.e.lock();
      Iterator localIterator = this.a.entrySet().iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (TraeAudioManager.e.a)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((TraeAudioManager.e.a)localObject2).b()) && (!((TraeAudioManager.e.a)localObject2).a().equals(paramString))) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            if (((TraeAudioManager.e.a)localObject2).c() < localObject1.c()) {
              break label151;
            }
            localObject1 = localObject2;
          }
        }
      }
      label151:
      for (;;)
      {
        break;
        this.e.unlock();
        if (localObject1 != null)
        {
          paramString = localObject1.a();
          AppMethodBeat.o(65637);
          return paramString;
        }
        AppMethodBeat.o(65637);
        return "DEVICE_SPEAKERPHONE";
      }
    }
    
    public String f()
    {
      AppMethodBeat.i(65638);
      this.e.lock();
      Iterator localIterator = this.a.entrySet().iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (TraeAudioManager.e.a)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((TraeAudioManager.e.a)localObject2).b())) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            if (((TraeAudioManager.e.a)localObject2).c() < ((TraeAudioManager.e.a)localObject1).c()) {
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
        this.e.unlock();
        if (localObject1 != null)
        {
          localObject1 = ((TraeAudioManager.e.a)localObject1).a();
          AppMethodBeat.o(65638);
          return localObject1;
        }
        AppMethodBeat.o(65638);
        return "DEVICE_SPEAKERPHONE";
      }
    }
    
    public boolean f(String paramString)
    {
      AppMethodBeat.i(65642);
      this.e.lock();
      TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(paramString);
      if ((locala != null) && (locala.b())) {
        this.d = paramString;
      }
      for (boolean bool = true;; bool = false)
      {
        this.e.unlock();
        AppMethodBeat.o(65642);
        return bool;
      }
    }
    
    public String g()
    {
      AppMethodBeat.i(65639);
      this.e.lock();
      Object localObject = (TraeAudioManager.e.a)this.a.get(this.d);
      if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b())) {}
      for (localObject = this.d;; localObject = null)
      {
        this.e.unlock();
        AppMethodBeat.o(65639);
        return localObject;
      }
    }
    
    public boolean g(String paramString)
    {
      AppMethodBeat.i(65643);
      this.e.lock();
      TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(paramString);
      if ((locala != null) && (locala.b()))
      {
        if ((this.c != null) && (!this.c.equals(paramString))) {
          this.b = this.c;
        }
        this.c = paramString;
        this.d = "";
      }
      for (boolean bool = true;; bool = false)
      {
        this.e.unlock();
        AppMethodBeat.o(65643);
        return bool;
      }
    }
    
    public String h()
    {
      AppMethodBeat.i(65640);
      this.e.lock();
      String str = m();
      this.e.unlock();
      AppMethodBeat.o(65640);
      return str;
    }
    
    public String i()
    {
      AppMethodBeat.i(65641);
      this.e.lock();
      String str = n();
      this.e.unlock();
      AppMethodBeat.o(65641);
      return str;
    }
    
    public HashMap<String, Object> j()
    {
      AppMethodBeat.i(65644);
      HashMap localHashMap = new HashMap();
      this.e.lock();
      localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", l());
      localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", m());
      localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", n());
      this.e.unlock();
      AppMethodBeat.o(65644);
      return localHashMap;
    }
    
    public ArrayList<String> k()
    {
      AppMethodBeat.i(65645);
      new ArrayList();
      this.e.lock();
      ArrayList localArrayList = l();
      this.e.unlock();
      AppMethodBeat.o(65645);
      return localArrayList;
    }
    
    ArrayList<String> l()
    {
      AppMethodBeat.i(65646);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        TraeAudioManager.e.a locala = (TraeAudioManager.e.a)((Map.Entry)localIterator.next()).getValue();
        if ((locala != null) && (locala.b())) {
          localArrayList.add(locala.a());
        }
      }
      AppMethodBeat.o(65646);
      return localArrayList;
    }
    
    String m()
    {
      AppMethodBeat.i(65647);
      Object localObject = (TraeAudioManager.e.a)this.a.get(this.c);
      if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b())) {}
      for (localObject = this.c;; localObject = "DEVICE_NONE")
      {
        AppMethodBeat.o(65647);
        return localObject;
      }
    }
    
    String n()
    {
      AppMethodBeat.i(65648);
      Object localObject = (TraeAudioManager.e.a)this.a.get(this.b);
      if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b())) {}
      for (localObject = this.b;; localObject = "DEVICE_NONE")
      {
        AppMethodBeat.o(65648);
        return localObject;
      }
    }
  }
  
  class g
    extends TraeAudioManager.k
  {
    g()
    {
      super();
    }
    
    public void a()
    {
      AppMethodBeat.i(65650);
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        a.dUd();
        a.iP("TRAE", "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
        f();
        AppMethodBeat.o(65650);
        return;
      }
      if (!TraeAudioManager.enableDeviceSwitchFlag)
      {
        a.dUd();
        a.iP("TRAE", "connect bluetoothHeadset: disableDeviceSwitchFlag");
        AppMethodBeat.o(65650);
        return;
      }
      try
      {
        Thread.sleep(1000L);
        label94:
        d();
        int i = 0;
        for (;;)
        {
          int j;
          StringBuilder localStringBuilder;
          if (this.b == true)
          {
            j = i + 1;
            if (i < 10)
            {
              a.dUd();
              localStringBuilder = new StringBuilder("bluetoothHeadsetSwitchThread i:").append(j).append(" sco:");
              if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                break label266;
              }
            }
          }
          label266:
          for (String str = "Y";; str = "N")
          {
            a.iP("TRAE", str + " :" + TraeAudioManager.this._deviceConfigManager.d());
            if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
              break;
            }
            f();
            if (!TraeAudioManager.this._am.isBluetoothScoOn())
            {
              a.dUd();
              a.iO("TRAE", "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
              TraeAudioManager.this._deviceConfigManager.a(b(), false);
              a(10);
              TraeAudioManager.this.checkAutoDeviceListUpdate();
            }
            AppMethodBeat.o(65650);
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
        break label94;
      }
    }
    
    public String b()
    {
      return "DEVICE_BLUETOOTHHEADSET";
    }
    
    @TargetApi(8)
    public void c()
    {
      AppMethodBeat.i(65651);
      if (TraeAudioManager.this._am == null)
      {
        AppMethodBeat.o(65651);
        return;
      }
      e();
      AppMethodBeat.o(65651);
    }
    
    @TargetApi(8)
    void d()
    {
      AppMethodBeat.i(65652);
      TraeAudioManager.this._am.setBluetoothScoOn(true);
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.startBluetoothSco();
      }
      AppMethodBeat.o(65652);
    }
    
    @TargetApi(8)
    void e()
    {
      AppMethodBeat.i(146979);
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.stopBluetoothSco();
      }
      TraeAudioManager.this._am.setBluetoothScoOn(false);
      AppMethodBeat.o(146979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */