import android.content.Context;
import android.view.View;

public abstract class ajfb<T>
  extends ajdm<T>
  implements blfg
{
  protected ajdz a;
  protected int d = -1;
  
  public ajfb(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new ajdz(paramContext);
  }
  
  public void a_(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.d = i;
      return;
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfb
 * JD-Core Version:    0.7.0.1
 */