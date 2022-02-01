import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajkp
  extends bgod
{
  public ajkp(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambgoe.a() + ",errCode=" + parambgoe.jdField_a_of_type_Int);
    }
    int i = parambgoe.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambgoe.jdField_a_of_type_JavaLangString;
      if (!bfua.jdField_a_of_type_JavaLangString.equals(str)) {
        break label297;
      }
      if ((parambgoe.jdField_a_of_type_Int != 0) || (parambgoe.f != 200)) {
        break label244;
      }
      str = bfua.b + "/icon.zip";
      localFile = new File(bfua.c);
      if (bgog.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambgoe.f + ", url: " + parambgoe.jdField_a_of_type_JavaLangString);
      }
      FileUtils.deleteDirectory(bfua.b);
    }
    label215:
    label244:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambgoe.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      this.a.a.sendEmptyMessage(1001);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambgoe.f + ", url: " + parambgoe.jdField_a_of_type_JavaLangString);
      }
      FileUtils.deleteDirectory(bfua.b);
      return;
    }
    label297:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambgoe.jdField_a_of_type_JavaLangString + ",errCode:" + parambgoe.jdField_a_of_type_Int + ",httpCode:" + parambgoe.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkp
 * JD-Core Version:    0.7.0.1
 */