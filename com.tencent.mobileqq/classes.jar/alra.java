import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class alra
  implements View.OnTouchListener
{
  public alra(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    long l2 = 0L;
    if (!this.a.w) {
      return false;
    }
    if ((!this.a.n) && (!this.a.u)) {
      return false;
    }
    if (this.a.o)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch mIsShootingPhoto= " + this.a.o);
      }
      return false;
    }
    NewFlowCameraActivity.f(this.a);
    this.a.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (((paramMotionEvent.getAction() & 0xFF) == 5) && (!this.a.G))
    {
      int[] arrayOfInt = new int[2];
      this.a.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen(arrayOfInt);
      int i = paramMotionEvent.getActionIndex();
      this.a.a(paramMotionEvent, i, arrayOfInt[0], arrayOfInt[1]);
    }
    if (paramView.getId() == 2131366963)
    {
      NewFlowCameraActivity.a(this.a).a(paramMotionEvent, true);
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4) || (NewFlowCameraActivity.a(this.a) == null) || (!NewFlowCameraActivity.a(this.a).isShown())) {}
    }
    try
    {
      if (GLGestureProxy.getInstance().checkSecendFinger(paramMotionEvent))
      {
        paramView = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
        NewFlowCameraActivity.a(this.a).onTouchEvent(paramView);
        paramView.recycle();
      }
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return true;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        continue;
        if (NewFlowCameraActivity.a(this.a) != null) {
          NewFlowCameraActivity.a(this.a).c();
        }
        anqn.a(this.a.jdField_f_of_type_AndroidViewView);
        if ((NewFlowCameraActivity.f(this.a)) && (NewFlowCameraActivity.g(this.a)))
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          label395:
          if (NewFlowCameraActivity.h(this.a)) {
            break label545;
          }
          if (this.a.r != 10017) {
            break label535;
          }
          if (bdax.a().g()) {
            this.a.c();
          }
        }
        for (;;)
        {
          this.a.D = false;
          this.a.E = true;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_DOWN isTemplateMode " + this.a.jdField_f_of_type_Boolean);
          break;
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          break label395;
          label535:
          this.a.c();
          continue;
          label545:
          if (this.a.t) {
            this.a.b();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent + " , recordFinish---startEdit");
        }
        if (NewFlowCameraActivity.h(this.a)) {
          if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (this.a.h) {
              this.a.a("612", "3", "0", true);
            }
            long l3 = System.currentTimeMillis();
            long l1 = l2;
            if (NewFlowCameraActivity.b(this.a) > 0L)
            {
              l1 = l2;
              if (l3 - NewFlowCameraActivity.b(this.a) > 0L) {
                l1 = l3 - NewFlowCameraActivity.b(this.a);
              }
            }
            NewFlowCameraActivity.a(this.a).put("captureDuration", String.valueOf(l1));
            NewFlowCameraActivity.g(this.a);
            if (this.a.r == 10004) {
              ykv.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "2", "", "", "" });
            }
          }
          else
          {
            this.a.c();
            if (this.a.r == 10002) {
              ykv.a("video_shoot", "clk_shoot", 0, 0, new String[] { "2" });
            } else if (this.a.r == 10004) {
              ykv.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "1", "", "", "" });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alra
 * JD-Core Version:    0.7.0.1
 */