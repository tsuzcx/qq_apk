import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class agty
  extends mxp
{
  agty(agtx paramagtx) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (agtx.a(this.a).a.equals(paramString1)))
    {
      paramString1 = (mxc)agtx.a(this.a).getManager(373);
      if (paramString1 != null) {
        paramString1.a(agtx.a(this.a).a, 0, 1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, mxq parammxq)
  {
    ThreadManager.getUIHandler().post(new AVGameHelper.1.1(this, parammxq));
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (agtx.a(this.a).a.equals(paramString2)) && (agtx.a(this.a) != null)) {
      ThreadManager.getUIHandler().post(new AVGameHelper.1.2(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agty
 * JD-Core Version:    0.7.0.1
 */