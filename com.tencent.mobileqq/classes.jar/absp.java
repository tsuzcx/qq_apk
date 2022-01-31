import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class absp
  implements Runnable
{
  public absp(FavroamingDBManager paramFavroamingDBManager, List paramList, int paramInt) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a.getEntityManagerFactory().createEntityManager();
    if (localEntityManager == null) {}
    boolean bool2;
    do
    {
      return;
      int i = 0;
      bool2 = false;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)this.jdField_a_of_type_JavaUtilList.get(i);
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
          i += 1;
          bool2 = bool1;
          break;
          localCustomEmotionData.setStatus(1000);
          localEntityManager.a(localCustomEmotionData);
          bool1 = bool2;
          continue;
          bool1 = localEntityManager.a(localCustomEmotionData);
          continue;
          bool1 = localEntityManager.b(localCustomEmotionData);
        }
      }
      localEntityManager.a();
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "updateFavEmotionDataListInDB type:" + this.jdField_a_of_type_Int + ",data size:" + this.jdField_a_of_type_JavaUtilList.size() + " save result: " + bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absp
 * JD-Core Version:    0.7.0.1
 */