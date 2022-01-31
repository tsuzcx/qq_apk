import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class akda
  implements Runnable
{
  public akda(WebSoService paramWebSoService, File paramFile, String paramString, WebSoService.CallBack paramCallBack, Uri paramUri) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      String str = FileUtils.b(this.jdField_a_of_type_JavaIoFile);
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "readFileToString cost=" + (System.currentTimeMillis() - l));
      }
      if (!TextUtils.isEmpty(str))
      {
        l = System.currentTimeMillis();
        if (SHA1Util.a(str).equals(this.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "verify html success cost=" + (System.currentTimeMillis() - l));
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a(str);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "verify html fail cost=" + (System.currentTimeMillis() - l));
        }
        WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a("");
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "deal eTag exception=" + localIOException.getMessage());
      }
      WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a("");
      localIOException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "verify load data exception=" + localOutOfMemoryError.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a("");
      localOutOfMemoryError.printStackTrace();
      VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 1, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akda
 * JD-Core Version:    0.7.0.1
 */