import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ahmy
  implements View.OnLongClickListener
{
  private WeakReference<ahmt> a;
  
  public ahmy(ahmt paramahmt)
  {
    this.a = new WeakReference(paramahmt);
  }
  
  public boolean onLongClick(View paramView)
  {
    ahmt localahmt = (ahmt)this.a.get();
    if (localahmt != null) {
      return localahmt.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmy
 * JD-Core Version:    0.7.0.1
 */