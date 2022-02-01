import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class ailw
  implements View.OnAttachStateChangeListener
{
  ailw(ailv paramailv) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (ailv.a(this.a) != null) {
      ailv.a(this.a).d();
    }
    if (ailv.a(this.a) != null)
    {
      ailv.a(this.a).c();
      ailv.a(this.a, null);
    }
    ailv.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailw
 * JD-Core Version:    0.7.0.1
 */