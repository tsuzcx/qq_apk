import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

public class aibm
  extends aibu
{
  protected final BaseChatPie a;
  
  public aibm(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  void a(bbmf parambbmf, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((parambbmf != null) && (parambbmf.a() > 0))
    {
      if (this.a == null) {
        break label43;
      }
      if (this.a.g() < 8) {
        a(paramView, paramInt1, paramInt2, parambbmf, paramInt3, false);
      }
    }
    return;
    label43:
    a(paramView, paramInt1, paramInt2, parambbmf, paramInt3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibm
 * JD-Core Version:    0.7.0.1
 */