import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;

class alfc
  implements DialogInterface.OnClickListener
{
  alfc(alfa paramalfa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      DownloadNativeApi.a(this.a.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi).d(this.a.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfc
 * JD-Core Version:    0.7.0.1
 */