import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi;
import com.tencent.open.downloadnew.DownloadConstants;

class akpg
  implements DialogInterface.OnClickListener
{
  akpg(akpf paramakpf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(DownloadConstants.q, false);
    DownloadJSApi.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.b);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akpg
 * JD-Core Version:    0.7.0.1
 */