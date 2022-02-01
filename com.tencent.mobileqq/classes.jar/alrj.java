import android.net.Uri;
import android.os.Build;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class alrj
  implements xvq, xvr, xvs, xvt
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "N1T", "ZTE A2015", "MI 1S", "GT-S7568I", "ZTE N909" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "SM-A7000", "HM NOTE 1S", "MI 2S" };
  private static final String[] c = { "vivo X6D" };
  private static final String[] d = { "MI 4" };
  private static final String[] e = { "Nexus 5" };
  private static final String[] f = { "Nexus 5" };
  private static final String[] g = { "OPPO R7sm" };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private alrk jdField_a_of_type_Alrk;
  private Uri jdField_a_of_type_AndroidNetUri;
  private TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "handleError");
    }
    if (this.jdField_a_of_type_Alrk != null) {
      this.jdField_a_of_type_Alrk.a();
    }
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "isNotSupportLoopVideo model=" + str);
    }
    boolean bool1 = bool2;
    int j;
    int i;
    if (str != null)
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a(xvo paramxvo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onCompletion has been called.   at " + paramxvo.b() + " mIsPause" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Int = paramxvo.b();
    if (!this.jdField_a_of_type_Boolean)
    {
      paramxvo.c();
      paramxvo.a(true);
    }
    if ((a(c)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoURI(this.jdField_a_of_type_AndroidNetUri);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
    }
  }
  
  public boolean a(xvo paramxvo, int paramInt1, int paramInt2)
  {
    paramxvo = new StringBuilder(64);
    paramxvo.append("bgVideo error-- what=");
    paramxvo.append(paramInt1);
    paramxvo.append(" extra=");
    paramxvo.append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, paramxvo.toString());
    }
    a();
    paramxvo = Build.MODEL;
    if (paramxvo != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("crashModel", paramxvo);
      bdmc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).a(null, "newHandGuide_error", true, 0L, 0L, localHashMap, "", false);
    }
    return true;
  }
  
  public void a_(xvo paramxvo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.F();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "MediaPlayer onPrepared has been called. talkback=" + AppSetting.c + " videoPrepareTime=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public boolean a_(xvo paramxvo, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.GuideVideoHandler", 2, "onInfo what===>" + paramInt1);
      }
      if (a(f)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrj
 * JD-Core Version:    0.7.0.1
 */