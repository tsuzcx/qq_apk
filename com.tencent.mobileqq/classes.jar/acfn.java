import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public final class acfn
  implements agby
{
  private WeakReference<aico> a;
  
  public acfn(aico paramaico)
  {
    this.a = new WeakReference(paramaico);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    aico localaico = (aico)this.a.get();
    if (localaico != null) {
      localaico.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfn
 * JD-Core Version:    0.7.0.1
 */