import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;

public class akbj
  implements Runnable
{
  public akbj(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString);
    File localFile = new File(str1);
    Object localObject = localFile.getParent();
    localObject = new File((String)localObject + "/download" + this.jdField_a_of_type_JavaLangString + ".xml");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("QPSingle", this.b), (File)localObject))
    {
      String str2 = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
      if (!this.c.equalsIgnoreCase(str2)) {
        AntiFraudConfigFileUtil.b(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 2);
      }
    }
    else
    {
      return;
    }
    if (((File)localObject).renameTo(localFile))
    {
      AntiFraudConfigFileUtil.b(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 3);
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil.a(this.jdField_a_of_type_JavaLangString, this.c);
      AntiFraudConfigFileUtil.b(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil, str1);
      return;
    }
    AntiFraudConfigFileUtil.b(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil).putInt(this.c, 2);
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbj
 * JD-Core Version:    0.7.0.1
 */