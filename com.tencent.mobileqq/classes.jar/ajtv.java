import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class ajtv
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private ajtm a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof ajtm)) {
        return (ajtm)paramView.getParent();
      }
    } while (!(paramView instanceof ajtm));
    return (ajtm)paramView;
  }
  
  void a(View paramView, ajte paramajte)
  {
    ajtm localajtm = a(paramView);
    if (localajtm == null) {}
    ajto localajto;
    do
    {
      return;
      localajto = localajtm.delegate();
    } while ((localajto == null) || (!localajto.b()) || (localajtm.hasSelected()));
    if (this.a == 2)
    {
      localajto.c(d);
      localajto.b(e);
    }
    for (;;)
    {
      localajto.a(paramajte);
      localajtm.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localajto.c(b);
        localajto.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166878).getDefaultColor();
        int j = paramView.getColorStateList(2131166880).getDefaultColor();
        localajto.c(i);
        localajto.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtv
 * JD-Core Version:    0.7.0.1
 */