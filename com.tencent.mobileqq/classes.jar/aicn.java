import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class aicn
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private aice a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof aice)) {
        return (aice)paramView.getParent();
      }
    } while (!(paramView instanceof aice));
    return (aice)paramView;
  }
  
  void a(View paramView, aibw paramaibw)
  {
    aice localaice = a(paramView);
    if (localaice == null) {}
    aicg localaicg;
    do
    {
      return;
      localaicg = localaice.delegate();
    } while ((localaicg == null) || (!localaicg.b()) || (localaice.hasSelected()));
    if (this.a == 2)
    {
      localaicg.c(d);
      localaicg.b(e);
    }
    for (;;)
    {
      localaicg.a(paramaibw);
      localaice.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localaicg.c(b);
        localaicg.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166831).getDefaultColor();
        int j = paramView.getColorStateList(2131166833).getDefaultColor();
        localaicg.c(i);
        localaicg.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aicn
 * JD-Core Version:    0.7.0.1
 */