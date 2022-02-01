import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class alra
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private alqr a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof alqr)) {
        return (alqr)paramView.getParent();
      }
    } while (!(paramView instanceof alqr));
    return (alqr)paramView;
  }
  
  void a(View paramView, alqj paramalqj)
  {
    alqr localalqr = a(paramView);
    if (localalqr == null) {}
    alqt localalqt;
    do
    {
      return;
      localalqt = localalqr.delegate();
    } while ((localalqt == null) || (!localalqt.b()) || (localalqr.hasSelected()));
    if (this.a == 2)
    {
      localalqt.c(d);
      localalqt.b(e);
    }
    for (;;)
    {
      localalqt.a(paramalqj);
      localalqr.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localalqt.c(b);
        localalqt.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166963).getDefaultColor();
        int j = paramView.getColorStateList(2131166965).getDefaultColor();
        localalqt.c(i);
        localalqt.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alra
 * JD-Core Version:    0.7.0.1
 */