import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ahrn
  implements View.OnLongClickListener
{
  private WeakReference<ahri> a;
  
  public ahrn(ahri paramahri)
  {
    this.a = new WeakReference(paramahri);
  }
  
  public boolean onLongClick(View paramView)
  {
    ahri localahri = (ahri)this.a.get();
    if (localahri != null) {
      return localahri.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrn
 * JD-Core Version:    0.7.0.1
 */