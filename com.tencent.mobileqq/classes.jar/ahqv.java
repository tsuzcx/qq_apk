import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class ahqv
  implements Runnable
{
  public ahqv(FunctionModuleConfigManager paramFunctionModuleConfigManager, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject != null)
      {
        localObject = FunctionModuleConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqSearchFunctionModuleConfigManager, (byte[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchFunctionModuleConfigManager.a((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqSearchFunctionModuleConfigManager.c(this.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.uniteSearch.FunctionModuleConfigManager", 2, localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahqv
 * JD-Core Version:    0.7.0.1
 */