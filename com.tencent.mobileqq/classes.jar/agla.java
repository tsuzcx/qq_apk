import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2;
import com.tencent.mobileqq.app.ThreadManager;

public class agla
  implements agin
{
  private BaseChatPie a;
  
  public agla(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.getIfOnShowDone()) && (this.a.getCurType() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.1(this), 8, null, true);
    }
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.getCurType() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.2(this), 8, null, true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      a();
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 6, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agla
 * JD-Core Version:    0.7.0.1
 */