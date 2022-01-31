import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;

public class ackp
  implements UniformDownloadUtil.GetFileInfoCallBack
{
  public ackp(UniformDownload paramUniformDownload, Bundle paramBundle, String paramString, long paramLong1, long paramLong2) {}
  
  public void a(String paramString, long paramLong)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "nofilename.x";
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppUniformDownload.a.runOnUiThread(new ackq(this, str, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ackp
 * JD-Core Version:    0.7.0.1
 */