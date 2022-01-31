import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.ContainerView;

public class akte
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public akte(ContainerView paramContainerView) {}
  
  public void onGlobalLayout()
  {
    if (!ContainerView.a(this.a))
    {
      ContainerView.a(this.a, ContainerView.a);
      ContainerView.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akte
 * JD-Core Version:    0.7.0.1
 */