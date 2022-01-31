import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class akhw
  implements View.OnClickListener
{
  private WeakReference<akhs> a;
  
  public akhw(akhs paramakhs)
  {
    this.a = new WeakReference(paramakhs);
  }
  
  public void onClick(View paramView)
  {
    akhs localakhs = (akhs)this.a.get();
    if (localakhs != null) {
      localakhs.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhw
 * JD-Core Version:    0.7.0.1
 */