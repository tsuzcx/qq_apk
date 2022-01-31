import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class acrg
  implements ActionSheet.OnButtonClickListener
{
  acrg(acrf paramacrf, FileInfo paramFileInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (FileUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Acrf.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Acrf.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Acrf.a.a.d();
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      FMToastUtil.a(2131428144);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrg
 * JD-Core Version:    0.7.0.1
 */