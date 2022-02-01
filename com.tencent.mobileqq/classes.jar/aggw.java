import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aggw
  extends ndm
{
  aggw(aggv paramaggv) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (aggv.a(this.a).curFriendUin.equals(paramString1)))
    {
      paramString1 = (ncz)aggv.a(this.a).getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (paramString1 != null) {
        paramString1.a(aggv.a(this.a).curFriendUin, 0, 1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, ndn paramndn)
  {
    ThreadManager.getUIHandler().post(new AVGameHelper.1.1(this, paramndn));
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (aggv.a(this.a).curFriendUin.equals(paramString2)) && (aggv.a(this.a) != null)) {
      ThreadManager.getUIHandler().post(new AVGameHelper.1.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggw
 * JD-Core Version:    0.7.0.1
 */