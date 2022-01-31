import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class achs
  implements Runnable
{
  public achs(FavroamingDBManager paramFavroamingDBManager, int paramInt, CustomEmotionData paramCustomEmotionData) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a.getEntityManagerFactory().createEntityManager();
    if (localEntityManager == null) {
      return;
    }
    boolean bool2 = false;
    boolean bool1;
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("FavroamingDBManager", 2, "can not save fav emoticon data, type:" + this.jdField_a_of_type_Int);
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      localEntityManager.a();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "updateFavEmotionDataListInDB type:" + this.jdField_a_of_type_Int + "save result: " + bool1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.setStatus(1000);
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      bool1 = bool2;
      continue;
      bool1 = localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      continue;
      bool1 = localEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achs
 * JD-Core Version:    0.7.0.1
 */