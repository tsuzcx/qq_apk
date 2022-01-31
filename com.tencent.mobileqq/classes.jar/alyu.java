import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import com.tencent.sharp.jni.TraeAudioSessionHost;
import com.tencent.sharp.jni.TraeMediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;

public class alyu
  extends Thread
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  final boolean[] jdField_a_of_type_ArrayOfBoolean = { false };
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = -1L;
  String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = "";
  String d = "";
  
  public alyu(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager = paramTraeAudioManager2;
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
    }
    start();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      label152:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - l) + "ms");
      }
      return;
      paramTraeAudioManager2 = finally;
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label152;
    }
  }
  
  int a()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 0;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_b_of_type_Int != -1) {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_b_of_type_Int);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("PARAM_OPERATION", this.d);
    Intent localIntent = new Intent();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 6);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
    localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
    try
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "InternalNotifyStreamTypeUpdate e = " + localException);
        }
      }
    }
  }
  
  public int a(int paramInt, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
      if (this.jdField_a_of_type_Boolean) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int + " msg:" + paramInt);
        return -1;
      }
    }
    paramHashMap = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramHashMap);
    if (this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHashMap)) {}
    for (paramInt = 0;; paramInt = -1) {
      return paramInt;
    }
  }
  
  int a(HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    Object localObject = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 1) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait(10000L);
      label58:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label58;
    }
  }
  
  @TargetApi(8)
  void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener != null);
        this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new alyx(this);
      } while (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null);
      int i = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, paramInt, 1);
      if ((i != 1) && (QLog.isColorLevel())) {
        QLog.e("TRAE", 2, "request audio focus fail. " + i + " mode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode());
      }
      this.jdField_c_of_type_Int = paramInt;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.jdField_c_of_type_Int);
  }
  
  void a(HashMap paramHashMap)
  {
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "Y";
      AudioDeviceInterface.LogTraceEntry((String)localObject + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int + " cfg:" + str);
      if ((str != null) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)) {
        break label94;
      }
    }
    label94:
    while ((str.length() <= 0) || ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_JavaLangString.equals(str))) || (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int != 0))
    {
      return;
      localObject = "N";
      break;
    }
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    d();
    Object localObject = (AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str);
    this.jdField_c_of_type_JavaLangString = str;
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, new alyv(this));
    }
    paramHashMap = (String)paramHashMap.get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(paramHashMap);
    a(this.jdField_a_of_type_Boolean);
    AudioDeviceInterface.LogTraceExit();
  }
  
  int b()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int + " _preRingMode:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " interruptRing am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("interruptRing");
    g();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("PARAM_OPERATION", this.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 4);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int b(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int);
    if (paramHashMap == null) {
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 1)
    {
      localObject = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 2);
      return -1;
    }
    this.jdField_b_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.d = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_b_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.d = -1;
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  _modePolicy:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.d);
      }
      localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
      if (localObject != null) {
        break label375;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_c_of_type_Int = 0;
      label271:
      if ((!TraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.d)) || (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 2) || (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager == null)) {
        break label405;
      }
      if (!this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d().equals("DEVICE_SPEAKERPHONE")) {
        break label389;
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(0);
      a(3);
    }
    for (;;)
    {
      localObject = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.d = ((Integer)localObject).intValue();
      break;
      label375:
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_c_of_type_Int = ((Integer)localObject).intValue();
      break label271;
      label389:
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(3);
      a(0);
      continue;
      label405:
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(TraeAudioManager.c(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.d));
      a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_c_of_type_Int);
    }
  }
  
  void b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "Y";; str = "N")
    {
      AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 1) {
      a();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alzc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "_switchThread:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alzc.a());
        }
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alzc.f();
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alzc = null;
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("stopService");
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Boolean);
      if ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)) {}
      try
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(0);
        QLog.w("TRAE", 2, "NeedForceVolumeType: -1");
        TraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager, -1);
        label233:
        e();
        AudioDeviceInterface.LogTraceExit();
        return;
        if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int != 2) {
          continue;
        }
        b();
      }
      catch (Exception localException)
      {
        break label233;
      }
    }
  }
  
  int c(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
      }
      localIntent = new Intent();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 3);
      return -1;
    }
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 0;
    g();
    Intent localIntent = new Intent();
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void c()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioSessionHost = new TraeAudioSessionHost();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = new TraeAudioManager.DeviceConfigManager(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager);
      TraeAudioManager.e = Process.myPid();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "======7");
        }
      }
    }
  }
  
  int d(HashMap paramHashMap)
  {
    boolean bool1 = true;
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStartRing am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 2) {
      b();
    }
    String str1 = "";
    for (;;)
    {
      try
      {
        if (paramHashMap.containsKey("PARAM_From")) {
          str1 = "" + paramHashMap.get("PARAM_From");
        }
        str1 = str1 + "_InternalStartRing";
        this.jdField_a_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
        this.jdField_a_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_OPERATION"));
        this.jdField_b_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
        int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "  dataSource:" + i);
        }
        int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
        Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
        String str2 = (String)paramHashMap.get("PARAM_RING_FILEPATH");
        boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
        int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
        boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
        if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int != 1) {
          this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 2;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
        this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.getMode();
        paramHashMap = this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer;
        if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 1)
        {
          paramHashMap.a(str1, i, j, localUri, str2, bool2, k, bool3, bool1, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_c_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " _ringUserdata:" + this.jdField_b_of_type_JavaLangString + " DurationMS:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.b());
          }
          if (!this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a()) {
            a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a());
          }
          a(this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a());
          AudioDeviceInterface.LogTraceExit();
          return 0;
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " startRing err params");
        }
        return -1;
      }
      bool1 = false;
    }
  }
  
  void d()
  {
    try
    {
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt == null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager);
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  int e(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int + " _preRingMode:" + this.jdField_b_of_type_Int);
    if ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    String str = "";
    Object localObject = str;
    if (paramHashMap != null)
    {
      localObject = str;
      if (paramHashMap.containsKey("PARAM_From")) {
        localObject = "" + paramHashMap.get("PARAM_From");
      }
    }
    localObject = (String)localObject + "_InternalStopRing";
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a((String)localObject);
    if ((!this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a()) && (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 2))
    {
      g();
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int = 0;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a((Intent)localObject, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void e()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt = null;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  int f(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int + " _preRingMode:" + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Int == 2) {}
    for (int i = this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a();; i = this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_c_of_type_Int)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
  }
  
  void f()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      b();
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Alyt = null;
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext != null)
      {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext = null;
      }
      if (this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null) {
        this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
      }
      this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
      label97:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  @TargetApi(8)
  void g()
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    while ((this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.jdField_c_of_type_Int);
    }
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  }
  
  void h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentSharpJniTraeAudioManager.a(localIntent, localHashMap, 0);
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry("");
    Looper.prepare();
    this.jdField_a_of_type_AndroidOsHandler = new alyw(this);
    c();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      Looper.loop();
      f();
    }
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyu
 * JD-Core Version:    0.7.0.1
 */