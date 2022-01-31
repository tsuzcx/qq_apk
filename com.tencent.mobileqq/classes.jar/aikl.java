import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aikl
  extends bead
{
  public aikl(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambeae.a() + ",errCode=" + parambeae.jdField_a_of_type_Int);
    }
    int i = parambeae.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambeae.jdField_a_of_type_JavaLangString;
      if (!bdfp.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambeae.jdField_a_of_type_Int != 0) || (parambeae.f != 200)) {
        break label237;
      }
      str = bdfp.b + "/icon.zip";
      localFile = new File(bdfp.c);
      if (beag.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambeae.f + ", url: " + parambeae.jdField_a_of_type_JavaLangString);
      }
      bdhb.a(bdfp.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambeae.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambeae.f + ", url: " + parambeae.jdField_a_of_type_JavaLangString);
      }
      bdhb.a(bdfp.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambeae.jdField_a_of_type_JavaLangString + ",errCode:" + parambeae.jdField_a_of_type_Int + ",httpCode:" + parambeae.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikl
 * JD-Core Version:    0.7.0.1
 */