import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

public class aibo
  extends aibw
{
  protected final BaseChatPie a;
  
  public aibo(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  void a(bblr parambblr, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((parambblr != null) && (parambblr.a() > 0))
    {
      if (this.a == null) {
        break label43;
      }
      if (this.a.g() < 8) {
        a(paramView, paramInt1, paramInt2, parambblr, paramInt3, false);
      }
    }
    return;
    label43:
    a(paramView, paramInt1, paramInt2, parambblr, paramInt3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibo
 * JD-Core Version:    0.7.0.1
 */