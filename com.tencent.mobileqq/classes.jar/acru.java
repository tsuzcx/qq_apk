import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;

public final class acru
  implements View.OnClickListener
{
  public acru(FileManagerEntity paramFileManagerEntity, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      ReportController.b(paramView, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
      new Intent(this.jdField_a_of_type_AndroidAppActivity, TeamWorkDocEditBrowserActivity.class);
      localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
      localTeamWorkFileImportInfo.jdField_c_of_type_Int = 2;
      localTeamWorkFileImportInfo.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {
        break label382;
      }
      bool2 = ((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).c();
      if ((((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).b()) && (!bool2))
      {
        bool1 = true;
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = bool1;
      }
    }
    label382:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131439110), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
        return;
        bool1 = false;
        break;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin))
      {
        localTeamWorkFileImportInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
        localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        localTeamWorkFileImportInfo.e = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
        localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
        localTeamWorkFileImportInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
        localTeamWorkFileImportInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
          localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
        }
      }
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidAppActivity, paramView, localTeamWorkFileImportInfo.jdField_c_of_type_Int);
      return;
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131439111), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acru
 * JD-Core Version:    0.7.0.1
 */