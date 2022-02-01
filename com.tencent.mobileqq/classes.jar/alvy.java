import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class alvy
  extends GestureDetector.SimpleOnGestureListener
{
  float jdField_a_of_type_Float;
  
  public alvy(NewFlowCameraActivity paramNewFlowCameraActivity, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.r == 10002) {
      yup.a("video_shoot", "camera_clkdouble", 0, 0, new String[0]);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.i) {}
    do
    {
      do
      {
        return true;
        if (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) != null) {
          NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).c();
        }
      } while (!bdaw.c());
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, -1, false);
    } while ((aluf.a != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a != null));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.D();
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.t) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    if (Math.abs(f) > this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a(f);
      if (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) != null) {
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).c();
      }
      return true;
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, paramMotionEvent);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvy
 * JD-Core Version:    0.7.0.1
 */