import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afvu
  extends batl
{
  public afvu(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambatm.a() + ",errCode=" + parambatm.jdField_a_of_type_Int);
    }
    int i = parambatm.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambatm.jdField_a_of_type_JavaLangString;
      if (!baau.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambatm.jdField_a_of_type_Int != 0) || (parambatm.f != 200)) {
        break label237;
      }
      str = baau.b + "/icon.zip";
      localFile = new File(baau.c);
      if (bato.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambatm.f + ", url: " + parambatm.jdField_a_of_type_JavaLangString);
      }
      bace.a(baau.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambatm.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambatm.f + ", url: " + parambatm.jdField_a_of_type_JavaLangString);
      }
      bace.a(baau.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambatm.jdField_a_of_type_JavaLangString + ",errCode:" + parambatm.jdField_a_of_type_Int + ",httpCode:" + parambatm.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvu
 * JD-Core Version:    0.7.0.1
 */