import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class acsq
  implements Runnable
{
  public acsq(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB thread start");
    }
    if ((this.a.b != null) && (this.a.b.trim().length() != 0)) {}
    for (List localList = QfileBaseRecentFileTabView.a(this.a).a().a(this.a.b);; localList = QfileBaseRecentFileTabView.b(this.a).a().a())
    {
      Collections.sort(localList, this.a.jdField_a_of_type_JavaUtilComparator);
      if (localList != null) {
        QfileBaseRecentFileTabView.a(this.a, new acsr(this, localList));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsq
 * JD-Core Version:    0.7.0.1
 */