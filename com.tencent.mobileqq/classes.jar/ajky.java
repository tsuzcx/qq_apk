import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajky
  implements View.OnLongClickListener
{
  private WeakReference<ajkt> a;
  
  public ajky(ajkt paramajkt)
  {
    this.a = new WeakReference(paramajkt);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajkt localajkt = (ajkt)this.a.get();
    if (localajkt != null) {
      return localajkt.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */