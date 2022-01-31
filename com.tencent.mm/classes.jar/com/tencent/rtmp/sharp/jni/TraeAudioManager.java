package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
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
  public static boolean IsMusicScene = false;
  public static boolean IsUpdateSceneFlag = false;
  public static final int MODE_MUSIC_PLAYBACK = 2;
  public static final int MODE_MUSIC_PLAY_RECORD = 1;
  public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
  public static final int MODE_VOICE_CHAT = 0;
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
  static int _gHostProcessId = -1;
  static TraeAudioManager _ginstance;
  static ReentrantLock _glock = new ReentrantLock();
  static final String[] forceName = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  boolean IsBluetoothA2dpExisted = true;
  int _activeMode = 0;
  AudioManager _am = null;
  TraeAudioSessionHost _audioSessionHost = null;
  TraeAudioManager.d _bluetoothCheck = null;
  Context _context = null;
  TraeAudioManager.e _deviceConfigManager = null;
  ReentrantLock _lock = new ReentrantLock();
  int _modePolicy = -1;
  int _prevMode = 0;
  int _streamType = 0;
  TraeAudioManager.k _switchThread = null;
  TraeAudioManager.f mTraeAudioManagerLooper = null;
  String sessionConnectedDev = "DEVICE_NONE";
  
  static
  {
    _ginstance = null;
  }
  
  TraeAudioManager(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManager.f(this, this);
    AudioDeviceInterface.LogTraceExit();
  }
  
  static boolean IsEabiLowVersion()
  {
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      }
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return IsEabiLowVersionByAbi(str2);
    }
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return true;
      if (paramString.contains("x86")) {
        return false;
      }
      if (paramString.contains("mips")) {
        return false;
      }
    } while ((paramString.equalsIgnoreCase("armeabi")) || (!paramString.equalsIgnoreCase("armeabi-v7a")));
    return false;
  }
  
  public static int SetSpeakerForTest(Context paramContext, boolean paramBoolean)
  {
    int j = -1;
    _glock.lock();
    int i;
    if (_ginstance != null) {
      i = _ginstance.InternalSetSpeaker(paramContext, paramBoolean);
    }
    for (;;)
    {
      _glock.unlock();
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
    if (paramString == null) {}
    while ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    return sendMessage(32775, localHashMap);
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32789, localHashMap);
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return sendMessage(32776, localHashMap);
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    Class localClass = Integer.TYPE;
    paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
    }
  }
  
  static int getAudioSource(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (IsMusicScene) {}
    do
    {
      do
      {
        return j;
        if (!IsEabiLowVersion()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:0");
      return 0;
      j = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
        }
        return paramInt;
      }
      if (j >= 11) {
        i = 7;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    return i;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    if (IsMusicScene) {
      j = i;
    }
    do
    {
      return j;
      if (!IsEabiLowVersion()) {
        break;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:3");
    return 3;
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (IsMusicScene) {}
    do
    {
      do
      {
        return j;
        if (!IsEabiLowVersion()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:0");
      return 0;
      j = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
        }
        return paramInt;
      }
      if (j >= 11) {
        i = 3;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
    return i;
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32778, localHashMap);
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32779, localHashMap);
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32774, localHashMap);
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
    Object localObject = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localObject });
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + getForceConfigName(((Integer)localObject).intValue()));
      }
      return ((Integer)localObject).intValue();
    }
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32784, localHashMap);
  }
  
  public static int init(Context paramContext)
  {
    TXCLog.w("TRAE", "TraeAudioManager init _ginstance:" + _ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramString)
    {
      do
      {
        paramObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "invokeMethod Exception:" + paramString.getMessage());
    }
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return false;
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
          break;
        }
        if (Build.MODEL.equals("MI 2")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2A")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2S")) {
          return true;
        }
      } while (!Build.MODEL.equals("MI 2SC"));
      return true;
    } while ((!Build.MANUFACTURER.equals("samsung")) || (!Build.MODEL.equals("SCH-I959")));
    return true;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32777, localHashMap);
  }
  
  public static boolean isHandfree(String paramString)
  {
    if (!checkDevName(paramString)) {}
    while (!"DEVICE_SPEAKERPHONE".equals(paramString)) {
      return false;
    }
    return true;
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32791, localHashMap);
  }
  
  public static int registerAudioSession(boolean paramBoolean, long paramLong, Context paramContext)
  {
    int i = -1;
    _glock.lock();
    if (_ginstance != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      _ginstance._audioSessionHost.add(paramLong, paramContext);
    }
    for (;;)
    {
      i = 0;
      _glock.unlock();
      return i;
      label42:
      _ginstance._audioSessionHost.remove(paramLong);
    }
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32790, localHashMap);
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    return i;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    Object localObject = Integer.TYPE;
    Class localClass = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, new Class[] { localObject, localClass });
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    }
  }
  
  static void setParameters(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setParameters  :" + paramString);
    }
    invokeStaticMethod("android.media.AudioSystem", "setParameters", new Object[] { paramString }, new Class[] { String.class });
  }
  
  static void setPhoneState(int paramInt)
  {
    Class localClass = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[] { Integer.valueOf(paramInt) }, new Class[] { localClass });
  }
  
  static int startRing(String paramString1, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
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
    return sendMessage(32782, localHashMap);
  }
  
  static int startService(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2.length() <= 0) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    return sendMessage(32772, localHashMap);
  }
  
  static int stopRing(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32783, localHashMap);
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32773, localHashMap);
  }
  
  public static void uninit()
  {
    TXCLog.w("TRAE", "TraeAudioManager uninit _ginstance:" + _ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance != null)
    {
      _ginstance.release();
      _ginstance = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32788, localHashMap);
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32781, localHashMap);
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32780, localHashMap);
  }
  
  public TraeAudioManager.d CreateBluetoothCheck(Context paramContext, TraeAudioManager.e parame)
  {
    Object localObject1;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = new TraeAudioManager.a(this);
      localObject2 = localObject1;
      if (!((TraeAudioManager.d)localObject1).a(paramContext, parame)) {
        localObject2 = new TraeAudioManager.b(this);
      }
      if (QLog.isColorLevel())
      {
        parame = new StringBuilder("CreateBluetoothCheck:").append(((TraeAudioManager.d)localObject2).c()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label132;
        }
      }
    }
    label132:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
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
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if ((!IsMusicScene) || (!paramString.equals("DEVICE_EARPHONE"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("TRAE", 2, "MusicScene, Connect device:" + paramString + " failed");
        return -1;
        if ((!paramBoolean) && (!this._deviceConfigManager.h().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.h()))) {
          return 0;
        }
        if ((checkDevName(paramString) == true) && (this._deviceConfigManager.c(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 2, " checkDevName fail");
      return -1;
      if (InternalIsDeviceChangeable() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
    return -1;
    if (this._switchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.b());
      }
      this._switchThread.f();
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
      return 0;
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        this._switchThread = new TraeAudioManager.j(this);
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        this._switchThread = new TraeAudioManager.i(this);
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        this._switchThread = new TraeAudioManager.g(this);
      }
    }
  }
  
  boolean InternalIsDeviceChangeable()
  {
    String str = this._deviceConfigManager.g();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    if (this._context == null) {
      return -1;
    }
    final boolean bool = InternalIsDeviceChangeable();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
        localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", bool);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
      }
    });
    return 0;
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null) {
      return -1;
    }
    Object localObject = this._deviceConfigManager.j();
    final ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    final String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
        localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
        localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
        localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", this.c);
        localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", TraeAudioManager.this._deviceConfigManager.d());
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
      }
    });
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null)) {
      return -1;
    }
    if (IsMusicScene)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
      }
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    TXCLog.w("TRAE", "ConnectDevice: " + str);
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
          break label247;
        }
      }
      label247:
      for (Object localObject = "Y";; localObject = "N")
      {
        QLog.w("TRAE", 2, (String)localObject + " err:" + i);
        if (i == 0) {
          break label255;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return -1;
        if (!this._deviceConfigManager.c(str))
        {
          i = 8;
          break;
        }
        if (bool) {
          break label353;
        }
        i = 9;
        break;
      }
      label255:
      if (str.equals(this._deviceConfigManager.h()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " --has connected!");
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " --connecting...");
      }
      InternalConnectDevice(str, paramHashMap, false);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      label353:
      i = 0;
    }
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.h());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.g());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "SetMode entry:" + paramInt);
    }
    if (this._am == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setMode:" + paramInt + " fail am=null");
      }
    }
    do
    {
      return;
      this._am.setMode(paramInt);
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder("setMode:").append(paramInt);
    if (this._am.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      QLog.w("TRAE", 2, str);
      return;
    }
  }
  
  int InternalSetSpeaker(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
      }
    }
    AudioManager localAudioManager;
    do
    {
      return -1;
      localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      if (localAudioManager != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
    return -1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("InternalSetSpeaker entry:speaker:");
      if (!localAudioManager.isSpeakerphoneOn()) {
        break label151;
      }
      paramContext = "Y";
      localStringBuilder = localStringBuilder.append(paramContext).append("-->:");
      if (!paramBoolean) {
        break label158;
      }
    }
    label151:
    label158:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if ((!isCloseSystemAPM(this._modePolicy)) || (this._activeMode == 2)) {
        break label165;
      }
      return InternalSetSpeakerSpe(localAudioManager, paramBoolean);
      paramContext = "N";
      break;
    }
    label165:
    if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
      localAudioManager.setSpeakerphoneOn(paramBoolean);
    }
    if (localAudioManager.isSpeakerphoneOn() == paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + paramBoolean + " res:" + i + " mode:" + localAudioManager.getMode());
      }
      return i;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    }
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label172;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      break;
      label172:
      i = -1;
    }
  }
  
  void _updateEarphoneVisable()
  {
    if (this._deviceConfigManager.c("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
      }
      this._deviceConfigManager.a("DEVICE_EARPHONE", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
    }
    this._deviceConfigManager.a("DEVICE_EARPHONE", true);
  }
  
  void checkAutoDeviceListUpdate()
  {
    if (this._deviceConfigManager.b() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
      }
      _updateEarphoneVisable();
      this._deviceConfigManager.c();
      internalSendMessage(32785, new HashMap());
    }
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this._deviceConfigManager.b() == true) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label114;
        }
      }
    }
    label114:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TRAE", 2, (String)localObject + " connectedDev:" + this._deviceConfigManager.h());
      _updateEarphoneVisable();
      this._deviceConfigManager.c();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32786, (HashMap)localObject);
      return;
    }
    localObject = this._deviceConfigManager.h();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    internalSendMessage(32785, new HashMap());
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    if (this.mTraeAudioManagerLooper != null) {
      i = this.mTraeAudioManagerLooper.a(paramInt, paramHashMap);
    }
    return i;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
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
          break label253;
        }
        paramContext = "Y";
        label168:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this._deviceConfigManager;
      if (1 != i) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      paramContext.a("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      label253:
      paramContext = "unkown";
      break label168;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "onReceive intent or context is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
        }
        if (this._deviceConfigManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "_deviceConfigManager null!");
          }
        }
        else
        {
          boolean bool1 = this._deviceConfigManager.c("DEVICE_WIREDHEADSET");
          boolean bool2 = this._deviceConfigManager.c("DEVICE_BLUETOOTHHEADSET");
          if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
          {
            onHeadsetPlug(paramContext, paramIntent);
            if ((!bool1) && (this._deviceConfigManager.c("DEVICE_WIREDHEADSET") == true)) {
              checkDevicePlug("DEVICE_WIREDHEADSET", true);
            }
            if ((bool1 == true) && (!this._deviceConfigManager.c("DEVICE_WIREDHEADSET"))) {
              checkDevicePlug("DEVICE_WIREDHEADSET", false);
            }
          }
          else if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
          {
            if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "   OPERATION:" + str1);
              }
              if ("OPERATION_REGISTERAUDIOSESSION".equals(str1))
              {
                registerAudioSession(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
                return;
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                startService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              int i;
              int j;
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
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
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                stopRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
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
              if ((bool2 == true) && (!this._deviceConfigManager.c("DEVICE_BLUETOOTHHEADSET")))
              {
                checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  void printDevices()
  {
    int j = 0;
    AudioDeviceInterface.LogTraceEntry("");
    int k = this._deviceConfigManager.e();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.h());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.g());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.i());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.f());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   deviceNamber:" + k);
    }
    int i = 0;
    while (i < k)
    {
      localObject = this._deviceConfigManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "      " + i + " devName:" + (String)localObject + " Visible:" + this._deviceConfigManager.c((String)localObject) + " Priority:" + this._deviceConfigManager.d((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this._deviceConfigManager.k().toArray(new String[0]);
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
        QLog.w("TRAE", 2, "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.c(str) + " Priority:" + this._deviceConfigManager.d(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mTraeAudioManagerLooper != null)
    {
      this.mTraeAudioManagerLooper.a();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  int sendResBroadcast(final Intent paramIntent, final HashMap<String, Object> paramHashMap, final int paramInt)
  {
    if (this._context == null) {
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
      return -1;
    }
    localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    paramHashMap = (String)paramHashMap.get("PARAM_OPERATION");
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
        paramIntent.putExtra("PARAM_SESSIONID", localLong);
        paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
        paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(paramIntent);
        }
      }
    });
    return 0;
  }
  
  void updateDeviceStatus()
  {
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
        if ((bool == true) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 2, "pollUpdateDevice dev:" + str + " Visible:" + this._deviceConfigManager.c(str));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */