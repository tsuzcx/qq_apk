import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class acsx
  implements ActionSheet.OnButtonClickListener
{
  acsx(acsw paramacsw, FileManagerEntity paramFileManagerEntity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QfileBaseRecentFileTabView.o(this.jdField_a_of_type_Acsw.a.a).a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)) {}
    this.jdField_a_of_type_Acsw.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) && (3000 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType)) {
      QfileBaseRecentFileTabView.p(this.jdField_a_of_type_Acsw.a.a).a().a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = true;
    QfileBaseRecentFileTabView.q(this.jdField_a_of_type_Acsw.a.a).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_Acsw.a.a.e();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsx
 * JD-Core Version:    0.7.0.1
 */