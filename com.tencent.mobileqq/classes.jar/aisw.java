import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;

public class aisw
  implements View.OnTouchListener
{
  public aisw(TribeVideoPreviewFragment paramTribeVideoPreviewFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.getActivity().finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisw
 * JD-Core Version:    0.7.0.1
 */