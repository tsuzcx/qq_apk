import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

class ahjw
  implements odm
{
  ahjw(ahiu paramahiu) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.b();
    if (!paramBoolean)
    {
      this.a.b(2131694775);
      return;
    }
    EntityManager localEntityManager = this.a.app.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localEntityManager.find(AccountDetail.class, this.a.sessionInfo.curFriendUin);
    if (localAccountDetail != null) {
      localEntityManager.remove(localAccountDetail);
    }
    localEntityManager.close();
    this.a.app.getMessageFacade().clearHistory(this.a.sessionInfo.curFriendUin, 1008);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjw
 * JD-Core Version:    0.7.0.1
 */