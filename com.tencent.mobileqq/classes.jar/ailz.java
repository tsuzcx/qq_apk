import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ailz
  implements View.OnLongClickListener
{
  private WeakReference<ailu> a;
  
  public ailz(ailu paramailu)
  {
    this.a = new WeakReference(paramailu);
  }
  
  public boolean onLongClick(View paramView)
  {
    ailu localailu = (ailu)this.a.get();
    if (localailu != null) {
      return localailu.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailz
 * JD-Core Version:    0.7.0.1
 */