import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ajjd
  implements View.OnLongClickListener
{
  private WeakReference<ajiy> a;
  
  public ajjd(ajiy paramajiy)
  {
    this.a = new WeakReference(paramajiy);
  }
  
  public boolean onLongClick(View paramView)
  {
    ajiy localajiy = (ajiy)this.a.get();
    if (localajiy != null) {
      return localajiy.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjd
 * JD-Core Version:    0.7.0.1
 */