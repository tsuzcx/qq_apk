import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

public class alqb
  extends alqj
{
  protected final BaseChatPie a;
  
  public alqb(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  void a(bguh parambguh, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((parambguh != null) && (parambguh.a() > 0))
    {
      if (this.a == null) {
        break label43;
      }
      if (this.a.h() < 8) {
        a(paramView, paramInt1, paramInt2, parambguh, paramInt3, false);
      }
    }
    return;
    label43:
    a(paramView, paramInt1, paramInt2, parambguh, paramInt3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqb
 * JD-Core Version:    0.7.0.1
 */