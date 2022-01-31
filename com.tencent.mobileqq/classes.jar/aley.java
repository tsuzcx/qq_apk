import android.text.TextUtils;
import com.tencent.open.appcommon.now.download.js.DownloadWebInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class aley
  implements Runnable
{
  public aley(DownloadWebInterface paramDownloadWebInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsDownloadWebInterface.webview != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsDownloadWebInterface.webview.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsDownloadWebInterface.TAG, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aley
 * JD-Core Version:    0.7.0.1
 */