import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class akyt
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private akyk a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof akyk)) {
        return (akyk)paramView.getParent();
      }
    } while (!(paramView instanceof akyk));
    return (akyk)paramView;
  }
  
  void a(View paramView, akyc paramakyc)
  {
    akyk localakyk = a(paramView);
    if (localakyk == null) {}
    akym localakym;
    do
    {
      return;
      localakym = localakyk.delegate();
    } while ((localakym == null) || (!localakym.b()) || (localakyk.hasSelected()));
    if (this.a == 2)
    {
      localakym.c(d);
      localakym.b(e);
    }
    for (;;)
    {
      localakym.a(paramakyc);
      localakyk.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localakym.c(b);
        localakym.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166987).getDefaultColor();
        int j = paramView.getColorStateList(2131166989).getDefaultColor();
        localakym.c(i);
        localakym.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyt
 * JD-Core Version:    0.7.0.1
 */