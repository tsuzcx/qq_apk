import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;

public class adus
  implements Runnable
{
  public adus(EmoticonManager paramEmoticonManager, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.a(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
    if (localEmoticonTab != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localEmoticonTab.aioHave = false;
      }
      if (this.b) {
        localEmoticonTab.kandianHave = false;
      }
      if ((!localEmoticonTab.aioHave) && (!localEmoticonTab.kandianHave)) {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a.b(localEmoticonTab);
      }
    }
    else
    {
      return;
    }
    EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager, localEmoticonTab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adus
 * JD-Core Version:    0.7.0.1
 */