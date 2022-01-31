import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class acrs
  implements Runnable
{
  acrs(acrr paramacrr, HashMap paramHashMap) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acrr.a.a.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localList.size() != 0) {
        this.jdField_a_of_type_Acrr.a.a.put(str, localList);
      }
    }
    this.jdField_a_of_type_Acrr.a.i();
    this.jdField_a_of_type_Acrr.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrs
 * JD-Core Version:    0.7.0.1
 */