import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajsd
  implements View.OnLongClickListener
{
  private WeakReference<ajry> a;
  
  public ajsd(ajry paramajry)
  {
    this.a = new WeakReference(paramajry);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajry localajry = (ajry)this.a.get();
    if (localajry != null) {
      return localajry.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsd
 * JD-Core Version:    0.7.0.1
 */