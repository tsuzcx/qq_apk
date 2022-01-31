import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public final class aeua
  implements Runnable
{
  public aeua(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.a(this.a.getCurrentAccountUin(), 200, true);
    long l1 = ((Long)NearbySPUtil.a(this.a.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    EntityManager localEntityManager;
    if (l1 == 0L)
    {
      localEntityManager = this.a.getEntityManagerFactory(this.a.getAccount()).createEntityManager();
      l2 = l1;
      if (localEntityManager != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
        if (localNearbyPeopleCard == null) {
          break label143;
        }
        l1 = localNearbyPeopleCard.tinyId;
      }
    }
    label143:
    for (;;)
    {
      localEntityManager.a();
      l2 = l1;
      if (l2 != 0L) {
        this.a.a(String.valueOf(l2), 202, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeua
 * JD-Core Version:    0.7.0.1
 */