import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class agvn
  implements View.OnAttachStateChangeListener
{
  agvn(agvm paramagvm) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (agvm.a(this.a) != null) {
      agvm.a(this.a).d();
    }
    if (agvm.a(this.a) != null)
    {
      agvm.a(this.a).c();
      agvm.a(this.a, null);
    }
    agvm.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvn
 * JD-Core Version:    0.7.0.1
 */