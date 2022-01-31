import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public final class acfj
  implements agbw
{
  private WeakReference<aicm> a;
  
  public acfj(aicm paramaicm)
  {
    this.a = new WeakReference(paramaicm);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    aicm localaicm = (aicm)this.a.get();
    if (localaicm != null) {
      localaicm.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfj
 * JD-Core Version:    0.7.0.1
 */