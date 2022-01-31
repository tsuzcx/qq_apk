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

public class ahvg
  implements View.OnTouchListener
{
  public ahvg(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    long l2 = 0L;
    if (!this.a.x) {
      return false;
    }
    if ((!this.a.o) && (!this.a.v)) {
      return false;
    }
    if (this.a.p)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch mIsShootingPhoto= " + this.a.p);
      }
      return false;
    }
    NewFlowCameraActivity.f(this.a);
    this.a.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (((paramMotionEvent.getAction() & 0xFF) == 5) && (!this.a.H))
    {
      int[] arrayOfInt = new int[2];
      this.a.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen(arrayOfInt);
      int i = paramMotionEvent.getActionIndex();
      this.a.a(paramMotionEvent, i, arrayOfInt[0], arrayOfInt[1]);
    }
    if (paramView.getId() == 2131366393)
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
        ajsi.a(this.a.f);
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
          if (axhr.a().g()) {
            this.a.i();
          }
        }
        for (;;)
        {
          this.a.E = false;
          this.a.F = true;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_DOWN isTemplateMode " + this.a.g);
          break;
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          break label395;
          label535:
          this.a.i();
          continue;
          label545:
          if (this.a.u) {
            this.a.h();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent + " , recordFinish---startEdit");
        }
        if (NewFlowCameraActivity.h(this.a)) {
          if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (this.a.i) {
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
              vei.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "2", "", "", "" });
            }
          }
          else
          {
            this.a.i();
            if (this.a.r == 10002) {
              vei.a("video_shoot", "clk_shoot", 0, 0, new String[] { "2" });
            } else if (this.a.r == 10004) {
              vei.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "1", "", "", "" });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahvg
 * JD-Core Version:    0.7.0.1
 */