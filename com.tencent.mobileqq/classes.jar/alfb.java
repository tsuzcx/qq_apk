import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;

class alfb
  implements DialogInterface.OnClickListener
{
  alfb(alfa paramalfa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadCenterImpl.a().a(this.a.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    DownloadNativeApi.a(this.a.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi).a(this.a.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadTaskInfo);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfb
 * JD-Core Version:    0.7.0.1
 */