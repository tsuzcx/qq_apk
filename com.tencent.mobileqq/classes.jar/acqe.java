import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class acqe
  implements Runnable
{
  public acqe(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      String str = QfileTimeUtils.b(localWeiYunFileInfo.b);
      if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localWeiYunFileInfo);
    }
    this.a.i();
    this.a.setSelect(0);
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqe
 * JD-Core Version:    0.7.0.1
 */