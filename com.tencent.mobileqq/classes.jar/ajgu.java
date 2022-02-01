import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajgu
  implements View.OnLongClickListener
{
  private WeakReference<ajgp> a;
  
  public ajgu(ajgp paramajgp)
  {
    this.a = new WeakReference(paramajgp);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajgp localajgp = (ajgp)this.a.get();
    if (localajgp != null) {
      return localajgp.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgu
 * JD-Core Version:    0.7.0.1
 */