import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class acmm
  implements DialogInterface.OnClickListener
{
  acmm(acmj paramacmj, String paramString, UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str2 = "http://" + this.jdField_a_of_type_Acmj.a.h + ":" + this.jdField_a_of_type_Acmj.a.i + "/ftn_compress_getfile/rkey=" + this.jdField_a_of_type_Acmj.a.f + "&filetype=" + this.jdField_a_of_type_Acmj.a.b + "&path=";
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, str2);
    }
    paramDialogInterface = this.jdField_a_of_type_JavaLangString;
    try
    {
      String str1 = URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf8");
      paramDialogInterface = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    paramDialogInterface = str2 + paramDialogInterface + "&";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.b(paramDialogInterface, this.jdField_a_of_type_AndroidOsBundle);
    FileManagerReporter.a("0X80052CE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmm
 * JD-Core Version:    0.7.0.1
 */