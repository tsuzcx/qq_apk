import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akbe
  extends bhhe
{
  public akbe(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambhhf.a() + ",errCode=" + parambhhf.jdField_a_of_type_Int);
    }
    int i = parambhhf.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambhhf.jdField_a_of_type_JavaLangString;
      if (!bgks.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambhhf.jdField_a_of_type_Int != 0) || (parambhhf.f != 200)) {
        break label237;
      }
      str = bgks.b + "/icon.zip";
      localFile = new File(bgks.c);
      if (bhhh.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambhhf.f + ", url: " + parambhhf.jdField_a_of_type_JavaLangString);
      }
      bgmg.a(bgks.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambhhf.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.c(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambhhf.f + ", url: " + parambhhf.jdField_a_of_type_JavaLangString);
      }
      bgmg.a(bgks.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambhhf.jdField_a_of_type_JavaLangString + ",errCode:" + parambhhf.jdField_a_of_type_Int + ",httpCode:" + parambhhf.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbe
 * JD-Core Version:    0.7.0.1
 */