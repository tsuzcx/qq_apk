import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class acpu
  implements Runnable
{
  public acpu(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView != null) && (QfileBaseCloudFileTabView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(QfileBaseCloudFileTabView.jdField_a_of_type_JavaLangString, 2, "setSelect[" + this.jdField_a_of_type_Int + "] success mFileListView");
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpu
 * JD-Core Version:    0.7.0.1
 */