import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2;
import com.tencent.mobileqq.app.ThreadManager;

public class adjq
  implements adih
{
  private BaseChatPie a;
  
  public adjq(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.z()) && (this.a.b() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.1(this), 8, null, true);
    }
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.b() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.2(this), 8, null, true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 4, 9 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjq
 * JD-Core Version:    0.7.0.1
 */