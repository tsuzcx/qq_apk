import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class aina
  implements View.OnLongClickListener
{
  private WeakReference<aimv> a;
  
  public aina(aimv paramaimv)
  {
    this.a = new WeakReference(paramaimv);
  }
  
  public boolean onLongClick(View paramView)
  {
    aimv localaimv = (aimv)this.a.get();
    if (localaimv != null) {
      return localaimv.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aina
 * JD-Core Version:    0.7.0.1
 */