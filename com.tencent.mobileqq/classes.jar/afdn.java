import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class afdn
  implements View.OnLongClickListener
{
  private WeakReference<afdi> a;
  
  public afdn(afdi paramafdi)
  {
    this.a = new WeakReference(paramafdi);
  }
  
  public boolean onLongClick(View paramView)
  {
    afdi localafdi = (afdi)this.a.get();
    if (localafdi != null) {
      return localafdi.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afdn
 * JD-Core Version:    0.7.0.1
 */