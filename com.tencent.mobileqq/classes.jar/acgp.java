import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class acgp
  implements Runnable
{
  acgp(acgo paramacgo, HashMap paramHashMap) {}
  
  public void run()
  {
    QfileLocalFileDelPicTabView.a(this.jdField_a_of_type_Acgo.a).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localList.size() != 0) {
        QfileLocalFileDelPicTabView.b(this.jdField_a_of_type_Acgo.a).put(str, localList);
      }
    }
    this.jdField_a_of_type_Acgo.a.i();
    this.jdField_a_of_type_Acgo.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acgp
 * JD-Core Version:    0.7.0.1
 */