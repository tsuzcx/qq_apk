import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class aivq
  implements View.OnAttachStateChangeListener
{
  aivq(aivp paramaivp) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (aivp.a(this.a) != null) {
      aivp.a(this.a).d();
    }
    if (aivp.a(this.a) != null)
    {
      aivp.a(this.a).c();
      aivp.a(this.a, null);
    }
    aivp.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivq
 * JD-Core Version:    0.7.0.1
 */