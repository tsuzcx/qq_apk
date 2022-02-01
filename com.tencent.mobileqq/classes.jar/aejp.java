import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public final class aejp
  implements ajbl
{
  private WeakReference<akyu> a;
  
  public aejp(akyu paramakyu)
  {
    this.a = new WeakReference(paramakyu);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    akyu localakyu = (akyu)this.a.get();
    if (localakyu != null) {
      localakyu.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejp
 * JD-Core Version:    0.7.0.1
 */