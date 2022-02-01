import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajum
  implements View.OnLongClickListener
{
  private WeakReference<ajuh> a;
  
  public ajum(ajuh paramajuh)
  {
    this.a = new WeakReference(paramajuh);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajuh localajuh = (ajuh)this.a.get();
    if (localajuh != null) {
      return localajuh.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajum
 * JD-Core Version:    0.7.0.1
 */