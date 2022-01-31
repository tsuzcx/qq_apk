import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

public class aenf
  implements GestureDetector.OnDoubleTapListener
{
  public aenf(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - PlayOperationViewModel.a(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      ((LikeAniView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370438)).a(i, j);
      if (!PlayOperationViewModel.a(this.a)) {
        break label73;
      }
    }
    for (;;)
    {
      PlayOperationViewModel.a(this.a, System.currentTimeMillis());
      return true;
      label73:
      if ((!PlayOperationViewModel.b(this.a)) && (this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370438).getVisibility() == 0))
      {
        PlayOperationViewModel.a(this.a, false);
        this.a.c(null);
        new NowVideoReporter().h("video").i("playpage_double_click").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aenf
 * JD-Core Version:    0.7.0.1
 */