import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlurView;

class ahac
  implements View.OnAttachStateChangeListener
{
  ahac(ahab paramahab) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (ahab.a(this.a) != null) {
      ahab.a(this.a).d();
    }
    if (ahab.a(this.a) != null)
    {
      ahab.a(this.a).c();
      ahab.a(this.a, null);
    }
    ahab.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahac
 * JD-Core Version:    0.7.0.1
 */