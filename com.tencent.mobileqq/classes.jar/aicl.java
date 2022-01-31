import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class aicl
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private aicc a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof aicc)) {
        return (aicc)paramView.getParent();
      }
    } while (!(paramView instanceof aicc));
    return (aicc)paramView;
  }
  
  void a(View paramView, aibu paramaibu)
  {
    aicc localaicc = a(paramView);
    if (localaicc == null) {}
    aice localaice;
    do
    {
      return;
      localaice = localaicc.delegate();
    } while ((localaice == null) || (!localaice.b()) || (localaicc.hasSelected()));
    if (this.a == 2)
    {
      localaice.c(d);
      localaice.b(e);
    }
    for (;;)
    {
      localaice.a(paramaibu);
      localaicc.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localaice.c(b);
        localaice.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166831).getDefaultColor();
        int j = paramView.getColorStateList(2131166833).getDefaultColor();
        localaice.c(i);
        localaice.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aicl
 * JD-Core Version:    0.7.0.1
 */