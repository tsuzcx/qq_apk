import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.widget.QQBlurView;

class ahqb
  implements View.OnAttachStateChangeListener
{
  ahqb(ahqa paramahqa) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (ahqa.a(this.a) != null) {
      ahqa.a(this.a).destory();
    }
    if (ahqa.a(this.a) != null)
    {
      ahqa.a(this.a).c();
      ahqa.a(this.a, null);
    }
    ahqa.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqb
 * JD-Core Version:    0.7.0.1
 */