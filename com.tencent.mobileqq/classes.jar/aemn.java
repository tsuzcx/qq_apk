import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public final class aemn
  implements Runnable
{
  public aemn(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = (FriendsManager)this.a.getManager(50);
    Object localObject1 = ((FriendsManager)localObject2).b(this.a.getCurrentAccountUin());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((FriendsManager)localObject2).a((Card)localObject1);
    }
    localObject2 = this.a.getEntityManagerFactory().createEntityManager();
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.likeCountInc > 0))
    {
      localNearbyPeopleCard.likeCountInc = 0;
      ((EntityManager)localObject2).a(localNearbyPeopleCard);
    }
    ((EntityManager)localObject2).a();
    localObject2 = this.a.getAccount();
    long l;
    if (localObject1 == null)
    {
      l = 0L;
      NearbySPUtil.a((String)localObject2, l, 0);
      this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
      if (!ConnectNearbyProcService.a()) {
        break label211;
      }
      NearbyProxy.a(this.a.a(), 4117);
    }
    label211:
    do
    {
      return;
      l = ((Card)localObject1).lVoteCount;
      break;
      localObject1 = NearbyMineHelper.a(this.a);
    } while (localObject1 == null);
    ((NearbyMyTabCard)localObject1).newLikeNum = 0;
    NearbyMineHelper.a(this.a, (NearbyMyTabCard)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemn
 * JD-Core Version:    0.7.0.1
 */