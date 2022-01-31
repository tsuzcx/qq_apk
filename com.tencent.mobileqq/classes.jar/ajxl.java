import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

public class ajxl
  extends ajxt
{
  protected final BaseChatPie a;
  
  public ajxl(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  void a(bdpi parambdpi, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((parambdpi != null) && (parambdpi.a() > 0))
    {
      if (this.a == null) {
        break label43;
      }
      if (this.a.g() < 8) {
        a(paramView, paramInt1, paramInt2, parambdpi, paramInt3, false);
      }
    }
    return;
    label43:
    a(paramView, paramInt1, paramInt2, parambdpi, paramInt3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxl
 * JD-Core Version:    0.7.0.1
 */