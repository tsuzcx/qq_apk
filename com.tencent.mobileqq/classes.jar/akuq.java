import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class akuq
  implements aepr, Handler.Callback, bdmd, bipp
{
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  public static String d;
  private int jdField_a_of_type_Int;
  public long a;
  private akus jdField_a_of_type_Akus;
  private akuu jdField_a_of_type_Akuu;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public WeakReference<akut> a;
  private int b;
  public WeakReference<akuv> b;
  private WeakReference<agoe> jdField_c_of_type_JavaLangRefWeakReference;
  boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private String jdField_e_of_type_JavaLangString = "";
  private volatile boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String g;
  private String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "1400035750";
    jdField_b_of_type_JavaLangString = "5d3728db75adf458";
    jdField_c_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
    jdField_d_of_type_JavaLangString = "105d1e43c456bc800b4adacd57ac1199";
  }
  
  public akuq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Akus = new akus(paramQQAppInterface);
    ((aknx)paramQQAppInterface.getManager(153)).a().a(this.jdField_a_of_type_Akus);
    bipn.a().a(this);
    a();
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[onReportRecordInfoResp] upload record succ.");
        }
        ((akuv)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
      }
    }
    else {
      return;
    }
    ((akuv)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramInt);
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[onReportRecordInfoResp] uploadError,retcode:" + paramInt);
  }
  
  public int a()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderStart");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((akut)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onBeginReceiveData");
    return this.jdField_b_of_type_Int * 1000;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitSuccess");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderVolumeStateChanged");
    }
  }
  
  public void a(int paramInt, akut paramakut)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakut);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      paramakut = new QQRecorder.RecorderParam(bdml.jdField_a_of_type_Int, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramakut);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    paramakut = new File(aliu.p);
    if (!paramakut.exists()) {
      paramakut.mkdirs();
    }
    paramakut = b();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramakut, true);
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] start record");
  }
  
  public void a(agoe paramagoe)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramagoe);
  }
  
  public void a(Bundle paramBundle)
  {
    int i = 2;
    String str = paramBundle.getString("gmesdk_event_key");
    int j = paramBundle.getInt("gmesdk_event_ret");
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j);
    if ("gmesdk_event_key_enterroom".equals(str))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "key:" + str + ",ret:" + j + ",roomId:" + this.h);
      if ((j == 0) || (j == 1003))
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_e_of_type_JavaLangString = this.g;
        this.jdField_f_of_type_JavaLangString = this.h;
        ((aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_e_of_type_JavaLangString, true, this.jdField_a_of_type_Int);
        a(true, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 319) {
          i = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 0, new String[0]);
      }
    }
    while (!"gmesdk_event_key_exit_room".equals(str))
    {
      return;
      ((aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
      a(false, this.jdField_e_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 319) {
        i = 1;
      }
      VipUtils.a(null, "cmshow", "Apollo", "turnOnAudio", i, 1, new String[0]);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    ((aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.jdField_e_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
    a(false, this.jdField_e_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Int == 319) {
      i = 1;
    }
    VipUtils.a(null, "cmshow", "Apollo", "turnOffAudio", i, 0, new String[0]);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[AudioPlayerListener] onError:" + paramInt);
  }
  
  public void a(String paramString)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderNotReady");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[audioSwitch] friUin:" + paramString + ",from:" + paramInt + ",mCurrentFriUin:" + this.jdField_e_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (!a());
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      if (paramString.equals(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
      if (paramInt == 318)
      {
        paramString = new Bundle();
        paramString.putString("key_game_friUin", this.jdField_e_of_type_JavaLangString);
        paramString.putString("key_dialog_type", "dialog_type_confirm");
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", paramString, null);
        return;
      }
    } while ((this.jdField_c_of_type_JavaLangRefWeakReference == null) || (this.jdField_c_of_type_JavaLangRefWeakReference.get() == null));
    ((agoe)this.jdField_c_of_type_JavaLangRefWeakReference.get()).g("dialog_type_confirm");
    return;
    b(paramString, paramInt);
  }
  
  public void a(String paramString, akuv paramakuv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[uploadFile] uploadFile:" + paramString);
    }
    if (this.jdField_a_of_type_Akuu == null) {
      this.jdField_a_of_type_Akuu = new akuu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramakuv);
    if (localbayf != null)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Akuu.addFilter(new Class[] { baqy.class });
        localbayf.a(this.jdField_a_of_type_Akuu);
        this.jdField_c_of_type_Boolean = true;
      }
      paramakuv = new bayk();
      paramakuv.jdField_b_of_type_Int = 24;
      paramakuv.jdField_c_of_type_Int = 36;
      paramakuv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      paramakuv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      paramakuv.jdField_a_of_type_Boolean = true;
      paramakuv.j = ((int)new File(paramString).length());
      paramakuv.i = paramString;
      localbayf.a(paramakuv);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderPrepare");
    byte[] arrayOfByte = bdml.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    while (i == 0)
    {
      azuj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      azuj.a(paramString, arrayOfByte, arrayOfByte.length, (short)0);
      return;
      i = 0;
    }
    awxp.a(paramString);
    awxp.a(paramString, arrayOfByte, arrayOfByte.length);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderEnd,totalTime:" + paramDouble);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((akut)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    }
    int i;
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label107;
      }
      i = 1;
      if (i != 0) {
        break label113;
      }
      azuj.a(paramString, false);
      azuj.a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = (paramDouble);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      }
      return;
      label107:
      i = 0;
      break;
      label113:
      awxp.b(paramString);
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderError");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((akut)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[enterRoom] friUin:" + paramString1 + ",roomId:" + paramString2 + ",from:" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[enterRoom] uin or roomId is empty");
      return;
    }
    Bundle localBundle;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseActivity.sTopActivity != null) && (BaseActivity.sTopActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      if (paramInt != 318) {
        break label225;
      }
      localBundle = new Bundle();
      localBundle.putString("key_dialog_type", "dialog_type_permission");
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_show_audio_dialog", localBundle, null);
    }
    for (;;)
    {
      localBundle = new Bundle();
      localBundle.putString("uin", paramString1);
      localBundle.putString("friUin", paramString1);
      localBundle.putString("roomId", paramString2);
      localBundle.putInt("from", paramInt);
      paramString1 = Message.obtain();
      paramString1.setData(localBundle);
      paramString1.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
      label225:
      if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null)) {
        ((agoe)this.jdField_c_of_type_JavaLangRefWeakReference.get()).g("dialog_type_permission");
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[QQRecorder] onRecorderSilceEnd size：" + paramInt1);
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      azuj.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    awxp.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_c_of_type_JavaLangRefWeakReference != null)
    {
      agoe localagoe = (agoe)this.jdField_c_of_type_JavaLangRefWeakReference.get();
      if ((localagoe != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localagoe.a()))) {
        localagoe.t(paramBoolean);
      }
    }
    akvv.a().a(paramBoolean, paramString);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    if (this.jdField_f_of_type_Boolean) {
      return true;
    }
    boolean bool1;
    if (alit.d != null)
    {
      jdField_a_of_type_JavaLangString = alit.d.optString("appid", "1400035750");
      jdField_b_of_type_JavaLangString = alit.d.optString("key", "5d3728db75adf458");
      jdField_c_of_type_JavaLangString = alit.d.optString("url", "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip");
      jdField_d_of_type_JavaLangString = alit.d.optString("md5", "105d1e43c456bc800b4adacd57ac1199");
      if (alit.d.optInt("openAudio", 0) != 0)
      {
        bool1 = true;
        jdField_a_of_type_Boolean = bool1;
        bool1 = bool2;
        if (alit.d.optInt("display", 0) != 0) {
          bool1 = true;
        }
        jdField_b_of_type_Boolean = bool1;
        QLog.i("CmGameTemp_CmGameAudioManager", 1, "[initParams] appId:" + jdField_a_of_type_JavaLangString + ",key:" + jdField_b_of_type_JavaLangString + ",url:" + jdField_c_of_type_JavaLangString + ",md5:" + jdField_d_of_type_JavaLangString + ",OPEN_AUDIO:" + jdField_a_of_type_Boolean + ",sDISPLAY:" + jdField_b_of_type_Boolean);
        bipn.a().a(jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString);
      }
    }
    for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = false)
    {
      return this.jdField_f_of_type_Boolean;
      bool1 = false;
      break;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[initParams] gameAudioConfig is null");
    }
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equals(paramString)) && (this.jdField_e_of_type_Boolean);
  }
  
  public String b()
  {
    return aliu.p + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".amr";
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[queryRoomAndEnter] friUin:" + paramString + ",currentRoom:" + this.jdField_f_of_type_JavaLangString);
    }
    if (!a()) {
      return;
    }
    aknx localaknx = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    localaknx.a().b(paramString, paramInt);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onRecorderAbnormal");
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[playUserRecord] play record:" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
        {
          if (QLog.isColorLevel()) {
            QLog.i("CmGameTemp_CmGameAudioManager", 0, "record is playing");
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        if (TextUtils.isEmpty(paramString))
        {
          if (!new File(b()).exists())
          {
            QLog.e("CmGameTemp_CmGameAudioManager", 1, "audio file not exist.");
            return false;
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(b());
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return true;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return true;
      }
      catch (IOException paramString)
      {
        QLog.e("CmGameTemp_CmGameAudioManager", 1, paramString.getMessage());
        return false;
      }
    }
  }
  
  public void c()
  {
    ((aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(this.jdField_a_of_type_Akus);
    bipn.a().a();
    bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localbayf != null)
    {
      localbayf.b(this.jdField_a_of_type_Akuu);
      this.jdField_a_of_type_Akuu = null;
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c(String paramString, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameAudioManager", 0, "[exitRoom] uin:" + paramString + ",from:" + paramInt + ",mCurrentUin:" + this.jdField_e_of_type_JavaLangString + ",mCurrentRoomId:" + this.jdField_f_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!paramString.equals(this.jdField_e_of_type_JavaLangString)));
      if (paramInt != 318) {
        break;
      }
      paramInt = i;
      if (this.jdField_c_of_type_JavaLangRefWeakReference != null)
      {
        paramInt = i;
        if (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null) {
          paramInt = 1;
        }
      }
    } while ((paramInt != 0) && (this.jdField_e_of_type_JavaLangString.equals(((agoe)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a())));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return;
    if (akwd.a(BaseApplicationImpl.getContext()))
    {
      paramString = new akur(this);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", this.jdField_e_of_type_JavaLangString);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_running", localBundle, paramString);
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[exitRoom] game is not exist. exit room");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[QQRecorder] onInitFailed");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((akut)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(-1);
    }
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[startRecord] stop record");
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      bool = true;
    }
    return bool;
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public boolean d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "[stopUserRecord] stop record:");
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        return true;
      }
      return false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] exitRoom,roomId:" + this.jdField_f_of_type_JavaLangString);
      bipn.a().a(false);
      bipn.a().b(false);
      bipn.a().a(this.jdField_f_of_type_JavaLangString);
      return false;
    }
    paramMessage = paramMessage.getData();
    String str1 = paramMessage.getString("uin");
    String str2 = paramMessage.getString("roomId");
    int i = paramMessage.getInt("from");
    QLog.i("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] enterRoom,uin:" + str1 + ",roomId:" + str2 + ",from:" + i);
    this.g = str1;
    this.h = str2;
    this.jdField_a_of_type_Int = i;
    bipn.a().a(this.jdField_f_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      bipn.a().a(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), jdField_b_of_type_JavaLangString, str2, true, true);
      return false;
    }
    QLog.e("CmGameTemp_CmGameAudioManager", 0, "[handleMessage] appid or key is null!enter room failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuq
 * JD-Core Version:    0.7.0.1
 */