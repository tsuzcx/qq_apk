import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

class aday
  implements Runnable
{
  aday(adax paramadax, List paramList) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB addAll");
    }
    if (this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB end size[" + this.jdField_a_of_type_Adax.a.jdField_a_of_type_JavaUtilList.size() + "]");
    }
    this.jdField_a_of_type_Adax.a.a();
    SharedPreferences localSharedPreferences = QfileBaseRecentFileTabView.d(this.jdField_a_of_type_Adax.a).getApplication().getSharedPreferences("OfflineFileMerge" + QfileBaseRecentFileTabView.c(this.jdField_a_of_type_Adax.a).c(), 0);
    long l1 = localSharedPreferences.getLong("LastRequestTime", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) > 86400000L)
    {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "updata offlineList");
      QfileBaseRecentFileTabView.a(this.jdField_a_of_type_Adax.a);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " queryFileEntitiesFromDB -> getRecentFileRecords ");
      }
      return;
      localSharedPreferences.edit().putLong("LastRequestTime", l2).commit();
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "updata last process time");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aday
 * JD-Core Version:    0.7.0.1
 */