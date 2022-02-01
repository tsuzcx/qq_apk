import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajip
  implements View.OnLongClickListener
{
  private WeakReference<ajik> a;
  
  public ajip(ajik paramajik)
  {
    this.a = new WeakReference(paramajik);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajik localajik = (ajik)this.a.get();
    if (localajik != null) {
      return localajik.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajip
 * JD-Core Version:    0.7.0.1
 */