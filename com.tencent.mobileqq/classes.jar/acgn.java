import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class acgn
  implements Runnable
{
  acgn(acgm paramacgm, HashMap paramHashMap) {}
  
  public void run()
  {
    QfileLocalFileDelMediaTabView.a(this.jdField_a_of_type_Acgm.a).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localList.size() != 0) {
        QfileLocalFileDelMediaTabView.b(this.jdField_a_of_type_Acgm.a).put(str, localList);
      }
    }
    this.jdField_a_of_type_Acgm.a.i();
    this.jdField_a_of_type_Acgm.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgn
 * JD-Core Version:    0.7.0.1
 */