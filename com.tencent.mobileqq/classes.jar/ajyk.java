import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class ajyk
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private ajyb a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof ajyb)) {
        return (ajyb)paramView.getParent();
      }
    } while (!(paramView instanceof ajyb));
    return (ajyb)paramView;
  }
  
  void a(View paramView, ajxt paramajxt)
  {
    ajyb localajyb = a(paramView);
    if (localajyb == null) {}
    ajyd localajyd;
    do
    {
      return;
      localajyd = localajyb.delegate();
    } while ((localajyd == null) || (!localajyd.b()) || (localajyb.hasSelected()));
    if (this.a == 2)
    {
      localajyd.c(d);
      localajyd.b(e);
    }
    for (;;)
    {
      localajyd.a(paramajxt);
      localajyb.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localajyd.c(b);
        localajyd.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166880).getDefaultColor();
        int j = paramView.getColorStateList(2131166882).getDefaultColor();
        localajyd.c(i);
        localajyd.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyk
 * JD-Core Version:    0.7.0.1
 */