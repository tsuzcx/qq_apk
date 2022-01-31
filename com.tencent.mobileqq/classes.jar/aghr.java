import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aghr
  extends bbwt
{
  public aghr(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambbwu.a() + ",errCode=" + parambbwu.jdField_a_of_type_Int);
    }
    int i = parambbwu.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambbwu.jdField_a_of_type_JavaLangString;
      if (!bbcm.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambbwu.jdField_a_of_type_Int != 0) || (parambbwu.f != 200)) {
        break label237;
      }
      str = bbcm.b + "/icon.zip";
      localFile = new File(bbcm.c);
      if (bbww.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambbwu.f + ", url: " + parambbwu.jdField_a_of_type_JavaLangString);
      }
      bbdx.a(bbcm.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambbwu.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambbwu.f + ", url: " + parambbwu.jdField_a_of_type_JavaLangString);
      }
      bbdx.a(bbcm.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambbwu.jdField_a_of_type_JavaLangString + ",errCode:" + parambbwu.jdField_a_of_type_Int + ",httpCode:" + parambbwu.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghr
 * JD-Core Version:    0.7.0.1
 */