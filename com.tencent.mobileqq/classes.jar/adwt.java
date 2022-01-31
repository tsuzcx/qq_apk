import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public final class adwt
  implements ahzz
{
  private WeakReference<ajtw> a;
  
  public adwt(ajtw paramajtw)
  {
    this.a = new WeakReference(paramajtw);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    ajtw localajtw = (ajtw)this.a.get();
    if (localajtw != null) {
      localajtw.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwt
 * JD-Core Version:    0.7.0.1
 */