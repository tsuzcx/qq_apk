import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class ahnz
  implements View.OnTouchListener
{
  public ahnz(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0)
      {
        EffectsCameraCaptureFragment.a(this.a).setAlpha(0.5F);
        EffectsCameraCaptureFragment.a(this.a).setAlpha(0.5F);
        EffectsCameraCaptureFragment.f(this.a).setAlpha(0.5F);
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        EffectsCameraCaptureFragment.a(this.a).setAlpha(1.0F);
        EffectsCameraCaptureFragment.a(this.a).setAlpha(1.0F);
        EffectsCameraCaptureFragment.f(this.a).setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnz
 * JD-Core Version:    0.7.0.1
 */