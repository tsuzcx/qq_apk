import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ailx
  implements View.OnLongClickListener
{
  private WeakReference<ails> a;
  
  public ailx(ails paramails)
  {
    this.a = new WeakReference(paramails);
  }
  
  public boolean onLongClick(View paramView)
  {
    ails localails = (ails)this.a.get();
    if (localails != null) {
      return localails.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailx
 * JD-Core Version:    0.7.0.1
 */