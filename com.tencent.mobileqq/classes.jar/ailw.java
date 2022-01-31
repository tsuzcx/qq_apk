import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class ailw
  implements View.OnClickListener
{
  private WeakReference<ails> a;
  
  public ailw(ails paramails)
  {
    this.a = new WeakReference(paramails);
  }
  
  public void onClick(View paramView)
  {
    ails localails = (ails)this.a.get();
    if (localails != null) {
      localails.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailw
 * JD-Core Version:    0.7.0.1
 */