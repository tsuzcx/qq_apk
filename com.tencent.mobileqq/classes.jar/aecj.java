import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager;
import com.tencent.mobileqq.persistence.EntityManager;

public class aecj
  implements Runnable
{
  public aecj(WerewolvesDataManager paramWerewolvesDataManager, RecentInviteUser paramRecentInviteUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentInviteUser.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentInviteUser);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.a.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentInviteUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecj
 * JD-Core Version:    0.7.0.1
 */