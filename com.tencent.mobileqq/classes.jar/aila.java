import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.widget.QQBlurView;

class aila
  implements View.OnAttachStateChangeListener
{
  aila(aikz paramaikz) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (aikz.a(this.a) != null) {
      aikz.a(this.a).destory();
    }
    if (aikz.a(this.a) != null)
    {
      aikz.a(this.a).c();
      aikz.a(this.a, null);
    }
    aikz.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aila
 * JD-Core Version:    0.7.0.1
 */