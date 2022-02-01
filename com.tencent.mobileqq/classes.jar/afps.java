import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class afps
  extends mya
{
  afps(afpr paramafpr) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (afpr.a(this.a).curFriendUin.equals(paramString1)))
    {
      paramString1 = (mxn)afpr.a(this.a).getManager(373);
      if (paramString1 != null) {
        paramString1.a(afpr.a(this.a).curFriendUin, 0, 1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, myb parammyb)
  {
    ThreadManager.getUIHandler().post(new AVGameHelper.1.1(this, parammyb));
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (afpr.a(this.a).curFriendUin.equals(paramString2)) && (afpr.a(this.a) != null)) {
      ThreadManager.getUIHandler().post(new AVGameHelper.1.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afps
 * JD-Core Version:    0.7.0.1
 */