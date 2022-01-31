import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.persistence.EntityManager;

public class adsc
  implements Runnable
{
  public adsc(TroopAssistantManager paramTroopAssistantManager, TroopAssistantData paramTroopAssistantData, EntityManager paramEntityManager) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adsc
 * JD-Core Version:    0.7.0.1
 */