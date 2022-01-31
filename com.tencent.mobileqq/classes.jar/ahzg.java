import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ahzg
  implements View.OnLongClickListener
{
  private WeakReference<ahzb> a;
  
  public ahzg(ahzb paramahzb)
  {
    this.a = new WeakReference(paramahzb);
  }
  
  public boolean onLongClick(View paramView)
  {
    ahzb localahzb = (ahzb)this.a.get();
    if (localahzb != null) {
      return localahzb.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzg
 * JD-Core Version:    0.7.0.1
 */