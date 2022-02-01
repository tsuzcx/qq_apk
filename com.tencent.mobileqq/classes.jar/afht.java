import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public final class afht
  implements ajvc
{
  private WeakReference<alrb> a;
  
  public afht(alrb paramalrb)
  {
    this.a = new WeakReference(paramalrb);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    alrb localalrb = (alrb)this.a.get();
    if (localalrb != null) {
      localalrb.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afht
 * JD-Core Version:    0.7.0.1
 */