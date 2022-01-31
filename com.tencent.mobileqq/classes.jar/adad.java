import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class adad
  implements Runnable
{
  adad(adac paramadac, ArrayList paramArrayList, HashMap paramHashMap1, HashMap paramHashMap2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if ((QfileLocalFileMediaTabView.a(this.jdField_a_of_type_Adac.a) & 0x2) > 0) {
      this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("Camera", new ArrayList());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的视频")) {
        this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的视频", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的视频")).addAll((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey("已下载的音乐")) {
        this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("已下载的音乐", new ArrayList());
      }
      ((List)this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.get("已下载的音乐")).addAll((Collection)this.b.get(str));
    }
    this.jdField_a_of_type_Adac.a.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_Adac.a.i();
    this.jdField_a_of_type_Adac.a.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adad
 * JD-Core Version:    0.7.0.1
 */