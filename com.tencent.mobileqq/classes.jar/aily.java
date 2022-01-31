import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class aily
  implements View.OnClickListener
{
  private WeakReference<ailu> a;
  
  public aily(ailu paramailu)
  {
    this.a = new WeakReference(paramailu);
  }
  
  public void onClick(View paramView)
  {
    ailu localailu = (ailu)this.a.get();
    if (localailu != null) {
      localailu.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aily
 * JD-Core Version:    0.7.0.1
 */