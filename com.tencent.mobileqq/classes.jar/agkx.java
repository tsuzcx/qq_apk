import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class agkx
  extends mwq
{
  agkx(agkw paramagkw) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (agkw.a(this.a).a.equals(paramString1)))
    {
      paramString1 = (mwd)agkw.a(this.a).getManager(373);
      if (paramString1 != null) {
        paramString1.a(agkw.a(this.a).a, 0);
      }
    }
  }
  
  public void a(int paramInt, String paramString, mwr parammwr)
  {
    ThreadManager.getUIHandler().post(new AVGameHelper.1.1(this, parammwr));
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (agkw.a(this.a).a.equals(paramString2)) && (agkw.a(this.a) != null)) {
      ThreadManager.getUIHandler().post(new AVGameHelper.1.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkx
 * JD-Core Version:    0.7.0.1
 */