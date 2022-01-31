import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class abju
  implements View.OnTouchListener
{
  public abju(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.a.jdField_d_of_type_Boolean) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramView == this.a.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress)) {}
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        this.a.c.setVisibility(4);
        this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
        this.a.e.setVisibility(4);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a = System.currentTimeMillis();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
        if (this.a.jdField_a_of_type_Int == 1) {}
        for (int i = 0;; i = 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X8007106", "0X8007106", i, 0, "", "", "", "");
          return true;
        }
      }
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DynamicAvatarRecordActivity", 2, "ACTION_UP, current state is already preview!");
    return true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    }
    if (System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a < 500L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      DynamicAvatarRecordActivity.a(this.a);
      return true;
    }
    DynamicAvatarRecordActivity.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abju
 * JD-Core Version:    0.7.0.1
 */