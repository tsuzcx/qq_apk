import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class aipj
  implements View.OnLongClickListener
{
  private WeakReference<aipe> a;
  
  public aipj(aipe paramaipe)
  {
    this.a = new WeakReference(paramaipe);
  }
  
  public boolean onLongClick(View paramView)
  {
    aipe localaipe = (aipe)this.a.get();
    if (localaipe != null) {
      return localaipe.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipj
 * JD-Core Version:    0.7.0.1
 */