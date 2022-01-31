import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class akdi
  implements View.OnLongClickListener
{
  private WeakReference<akdd> a;
  
  public akdi(akdd paramakdd)
  {
    this.a = new WeakReference(paramakdd);
  }
  
  public boolean onLongClick(View paramView)
  {
    akdd localakdd = (akdd)this.a.get();
    if (localakdd != null) {
      return localakdd.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */