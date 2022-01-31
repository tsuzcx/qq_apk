import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class ahzf
  implements View.OnClickListener
{
  private WeakReference<ahzb> a;
  
  public ahzf(ahzb paramahzb)
  {
    this.a = new WeakReference(paramahzb);
  }
  
  public void onClick(View paramView)
  {
    ahzb localahzb = (ahzb)this.a.get();
    if (localahzb != null) {
      localahzb.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzf
 * JD-Core Version:    0.7.0.1
 */