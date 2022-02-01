import android.os.Handler;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akgd
  extends bhyn
{
  public akgd(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "download onDone status=" + parambhyo.a() + ",errCode=" + parambhyo.jdField_a_of_type_Int);
    }
    int i = parambhyo.jdField_a_of_type_JavaLangString.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambhyo.jdField_a_of_type_JavaLangString;
      if (!bhcs.jdField_a_of_type_JavaLangString.equals(str)) {
        break label297;
      }
      if ((parambhyo.jdField_a_of_type_Int != 0) || (parambhyo.f != 200)) {
        break label244;
      }
      str = bhcs.b + "/icon.zip";
      localFile = new File(bhcs.c);
      if (bhyq.a(new File(str), localFile, false)) {
        break label215;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "unzip avatarPendantMarketIcon fail: " + parambhyo.f + ", url: " + parambhyo.jdField_a_of_type_JavaLangString);
      }
      FileUtils.deleteDirectory(bhcs.b);
    }
    label215:
    label244:
    while (!QLog.isColorLevel())
    {
      File localFile;
      return;
      str = parambhyo.jdField_a_of_type_JavaLangString.substring(0, i);
      break;
      this.a.a.sendEmptyMessage(1001);
      this.a.a.sendEmptyMessage(1000);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "download avatarPendantMarketIcon fail: " + parambhyo.f + ", url: " + parambhyo.jdField_a_of_type_JavaLangString);
      }
      FileUtils.deleteDirectory(bhcs.b);
      return;
    }
    label297:
    QLog.e("AvatarPendantActivity", 2, "onDone unkonw url: " + parambhyo.jdField_a_of_type_JavaLangString + ",errCode:" + parambhyo.jdField_a_of_type_Int + ",httpCode:" + parambhyo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akgd
 * JD-Core Version:    0.7.0.1
 */