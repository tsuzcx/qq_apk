import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.smtt.sdk.TbsReaderView;

class acrx
  implements DialogInterface.OnClickListener
{
  acrx(acrv paramacrv, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalTbsViewManager.a(this.jdField_a_of_type_Acrv.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).userStatistics(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_Acrv.jdField_a_of_type_AndroidAppActivity.getString(2131435091));
    Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
    localIntent.putExtra("param", paramDialogInterface);
    localIntent.putExtra("url", this.b);
    this.jdField_a_of_type_Acrv.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrx
 * JD-Core Version:    0.7.0.1
 */