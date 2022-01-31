import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;

public class aehw
  implements Runnable
{
  public aehw(EmoticonManager paramEmoticonManager, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.aioHave = true;; localEmoticonTab.aioHave = true)
    {
      EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehw
 * JD-Core Version:    0.7.0.1
 */