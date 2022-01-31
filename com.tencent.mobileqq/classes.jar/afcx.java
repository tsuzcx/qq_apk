import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

public class afcx
  implements Runnable
{
  public afcx(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!StringUtil.a(NearbyPeopleProfileActivity.a(this.a).uin)) {
      this.a.app.a(NearbyPeopleProfileActivity.a(this.a).uin, 200, false);
    }
    if (this.a.a > 0L) {
      this.a.app.a(String.valueOf(this.a.a), 202, false);
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
      } while (StringUtil.a(NearbyPeopleProfileActivity.a(this.a).uin));
      localEntityManager = this.a.app.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.a).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.a.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcx
 * JD-Core Version:    0.7.0.1
 */