import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class acir
  implements Runnable
{
  public acir(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.f()) && (this.a.jdField_a_of_type_JavaUtilLinkedHashMap != null) && (this.a.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0))
    {
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((FileManagerEntity)((Iterator)localObject).next()).sendCloudUnsuccessful()) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acir
 * JD-Core Version:    0.7.0.1
 */