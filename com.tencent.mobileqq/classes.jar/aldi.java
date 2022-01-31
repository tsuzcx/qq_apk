import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.MyAppApi;
import mqq.os.MqqHandler;

public final class aldi
  implements Runnable
{
  public aldi(String paramString1, String paramString2, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (MyAppApi.a().b())
    {
      Bundle localBundle = new Bundle();
      String str = DownloadConstants.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_JavaLangString)
      {
        localBundle.putString(str, (String)localObject);
        localBundle.putString(DownloadConstants.b, "");
        localBundle.putString(DownloadConstants.c, "");
        localBundle.putString(DownloadConstants.e, this.b);
        localBundle.putInt(DownloadConstants.d, 0);
        localBundle.putString(DownloadConstants.h, "ANDROIDQQ.SHARESOURCE");
        ThreadManager.getSubThreadHandler().post(new aldj(this, localBundle));
        return;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", "");
    ((Bundle)localObject).putString("sid", "");
    ((Bundle)localObject).putString("via", "ANDROIDQQ.SHARESOURCE");
    ((Bundle)localObject).putBoolean("autoDownload", false);
    ((Bundle)localObject).putString("packageName", this.b);
    ((Bundle)localObject).putString("subpagetype", "SHARESOURCE");
    AppClient.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 2462, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aldi
 * JD-Core Version:    0.7.0.1
 */