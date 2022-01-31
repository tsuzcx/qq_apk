import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;
import com.tencent.open.appcommon.now.download.local.DownloadTaskInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

public class alms
  implements Runnable
{
  public alms(DownloadNativeApi paramDownloadNativeApi, DownloadInfo paramDownloadInfo, DownloadTaskInfo paramDownloadTaskInfo, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new almt(this);
    almu localalmu = new almu(this);
    LogUtility.b("DownloadNativeApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131428555)).setPositiveButton(2131428552, localalmu).setNegativeButton(2131428553, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alms
 * JD-Core Version:    0.7.0.1
 */