import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aech
  implements Runnable
{
  public aech(WerewolvesDataManager paramWerewolvesDataManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecentInviteUser.class);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.jdField_a_of_type_JavaLangObject;
    if (localObject2 != null) {
      try
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentInviteUser localRecentInviteUser = (RecentInviteUser)((Iterator)localObject2).next();
          this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.jdField_a_of_type_JavaUtilMap.put(localRecentInviteUser.uniKey, localRecentInviteUser);
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aech
 * JD-Core Version:    0.7.0.1
 */