import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class affi
  implements Runnable
{
  public affi(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.a.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.a(NearbyProfileDisplayTribePanel.a(this.a));
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affi
 * JD-Core Version:    0.7.0.1
 */