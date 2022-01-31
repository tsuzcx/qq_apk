import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aifw
  extends bdvu
{
  public aifw(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambdvv.a() + ",errCode=" + parambdvv.jdField_a_of_type_Int);
    }
    int i = parambdvv.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambdvv.jdField_a_of_type_JavaLangString;
      if (!bdbg.jdField_a_of_type_JavaLangString.equals(str)) {
        break label290;
      }
      if ((parambdvv.jdField_a_of_type_Int != 0) || (parambdvv.f != 200)) {
        break label237;
      }
      str = bdbg.b + "/icon.zip";
      localFile = new File(bdbg.c);
      if (bdvx.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambdvv.f + ", url: " + parambdvv.jdField_a_of_type_JavaLangString);
      }
      bdcs.a(bdbg.b);
    }
    label215:
    label237:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambdvv.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      AvatarPendantActivity.b(this.a);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambdvv.f + ", url: " + parambdvv.jdField_a_of_type_JavaLangString);
      }
      bdcs.a(bdbg.b);
      return;
    }
    label290:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambdvv.jdField_a_of_type_JavaLangString + ",errCode:" + parambdvv.jdField_a_of_type_Int + ",httpCode:" + parambdvv.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifw
 * JD-Core Version:    0.7.0.1
 */