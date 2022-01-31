import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class aeyk
  implements View.OnAttachStateChangeListener
{
  aeyk(aeyj paramaeyj) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (aeyj.a(this.a) != null) {
      aeyj.a(this.a).d();
    }
    if (aeyj.a(this.a) != null)
    {
      aeyj.a(this.a).c();
      aeyj.a(this.a, null);
    }
    aeyj.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyk
 * JD-Core Version:    0.7.0.1
 */