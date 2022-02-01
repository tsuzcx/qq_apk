import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class alwp
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private alwg a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof alwg)) {
        return (alwg)paramView.getParent();
      }
    } while (!(paramView instanceof alwg));
    return (alwg)paramView;
  }
  
  void a(View paramView, alvy paramalvy)
  {
    alwg localalwg = a(paramView);
    if (localalwg == null) {}
    alwi localalwi;
    do
    {
      return;
      localalwi = localalwg.delegate();
    } while ((localalwi == null) || (!localalwi.b()) || (localalwg.hasSelected()));
    if (this.a == 2)
    {
      localalwi.c(d);
      localalwi.b(e);
    }
    for (;;)
    {
      localalwi.a(paramalvy);
      localalwg.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localalwi.c(b);
        localalwi.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131167001).getDefaultColor();
        int j = paramView.getColorStateList(2131167003).getDefaultColor();
        localalwi.c(i);
        localalwi.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwp
 * JD-Core Version:    0.7.0.1
 */