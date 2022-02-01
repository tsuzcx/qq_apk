import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper;
import java.lang.ref.WeakReference;

public class afpt
  implements ViewTreeObserver.OnPreDrawListener
{
  private WeakReference<AioPaiYiPaiHelper> a;
  
  public afpt(AioPaiYiPaiHelper paramAioPaiYiPaiHelper)
  {
    this.a = new WeakReference(paramAioPaiYiPaiHelper);
  }
  
  public boolean onPreDraw()
  {
    AioPaiYiPaiHelper localAioPaiYiPaiHelper = (AioPaiYiPaiHelper)this.a.get();
    if (localAioPaiYiPaiHelper != null) {
      AioPaiYiPaiHelper.a(localAioPaiYiPaiHelper);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpt
 * JD-Core Version:    0.7.0.1
 */