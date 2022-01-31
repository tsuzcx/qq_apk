import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public class adbh
  implements FMDialogUtil.FMDialogInterface
{
  public adbh(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView, Intent paramIntent) {}
  
  public void a()
  {
    QfileBaseRecentFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView).startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 102);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbh
 * JD-Core Version:    0.7.0.1
 */