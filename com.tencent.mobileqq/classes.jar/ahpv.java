import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class ahpv
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private ahpm a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof ahpm)) {
        return (ahpm)paramView.getParent();
      }
    } while (!(paramView instanceof ahpm));
    return (ahpm)paramView;
  }
  
  void a(View paramView, ahpe paramahpe)
  {
    ahpm localahpm = a(paramView);
    if (localahpm == null) {}
    ahpo localahpo;
    do
    {
      return;
      localahpo = localahpm.a();
    } while ((localahpo == null) || (!localahpo.b()) || (localahpm.h()));
    if (this.a == 2)
    {
      localahpo.c(d);
      localahpo.b(e);
    }
    for (;;)
    {
      localahpo.a(paramahpe);
      localahpm.a(null);
      return;
      if (this.a == 1)
      {
        localahpo.c(b);
        localahpo.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131101237).getDefaultColor();
        int j = paramView.getColorStateList(2131101239).getDefaultColor();
        localahpo.c(i);
        localahpo.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpv
 * JD-Core Version:    0.7.0.1
 */