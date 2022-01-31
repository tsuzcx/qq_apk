import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;

public class akxx
  implements Runnable
{
  public akxx(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.a(MsfSdkUtils.insertMtype("Web", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.jdField_a_of_type_JavaLangString), 0);
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.i, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.jdField_a_of_type_JavaLangString);
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putString(DownloadConstants.k, this.b);
    localBundle.putBoolean(DownloadConstants.q, false);
    localBundle.putBoolean(DownloadConstants.w, false);
    localBundle.putString(DownloadConstants.l, "_" + this.jdField_a_of_type_JavaLangString);
    DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, localBundle, 0, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxx
 * JD-Core Version:    0.7.0.1
 */