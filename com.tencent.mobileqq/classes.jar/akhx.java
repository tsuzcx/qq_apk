import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class akhx
  implements View.OnLongClickListener
{
  private WeakReference<akhs> a;
  
  public akhx(akhs paramakhs)
  {
    this.a = new WeakReference(paramakhs);
  }
  
  public boolean onLongClick(View paramView)
  {
    akhs localakhs = (akhs)this.a.get();
    if (localakhs != null) {
      return localakhs.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhx
 * JD-Core Version:    0.7.0.1
 */