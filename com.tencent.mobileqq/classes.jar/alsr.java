import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.redtouch.RedTouch;

public class alsr
  implements View.OnTouchListener
{
  public alsr(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return false;
      } while (!bacu.c(this.a.getActivity().app, false));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(13, 200L);
      return false;
      if (!this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(13)) {
        break;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
      if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.clearAnimation();
      }
    } while (this.a.jdField_a_of_type_AndroidWidgetImageView == null);
    this.a.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    return false;
    FrameHelperActivity.b(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsr
 * JD-Core Version:    0.7.0.1
 */