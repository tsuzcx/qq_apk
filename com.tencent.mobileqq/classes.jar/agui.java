import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class agui
  implements agvc
{
  private BaseChatPie a;
  
  public agui(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.a != null)) {
      ((axqb)this.a.a.getManager(324)).onDestroy();
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agui
 * JD-Core Version:    0.7.0.1
 */