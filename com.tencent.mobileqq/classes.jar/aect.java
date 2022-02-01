import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.1;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.2;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.3;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity.2.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aect
  implements avho
{
  public aect(GesturePWDCreateActivity paramGesturePWDCreateActivity) {}
  
  public void a() {}
  
  public void a(List<avhn> paramList)
  {
    if (paramList != null) {
      switch (this.a.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      return;
      if ((paramList != null) && (paramList.size() >= 3))
      {
        this.a.a(paramList);
        this.a.jdField_a_of_type_JavaLangString = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692780);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new GesturePWDCreateActivity.2.1(this), 500L);
        this.a.jdField_a_of_type_Int = 1;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(2);
      QQToast.a(this.a, 1, this.a.getString(2131692800), 0).b(this.a.getTitleBarHeight());
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new GesturePWDCreateActivity.2.2(this), 500L);
      return;
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.a.app.getCurrentAccountUin());
      if ((this.a.jdField_a_of_type_JavaLangString == null) || (paramList == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramList))) {
        break;
      }
      GesturePWDUtils.setGesturePWD(this.a, this.a.app.getCurrentAccountUin(), this.a.jdField_a_of_type_JavaLangString);
      GesturePWDUtils.setGesturePWDState(this.a, this.a.app.getCurrentAccountUin(), 2);
      bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Gesture_password", 0, 1, "", "", "", "");
      QQToast.a(this.a, 2, this.a.getString(2131692782), 0).b(this.a.getTitleBarHeight());
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new GesturePWDCreateActivity.2.3(this), 300L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.gesturelock.creat", 2, "gesture lock create success...");
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(2);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new GesturePWDCreateActivity.2.4(this), 500L);
    QQToast.a(this.a, 1, this.a.getString(2131692781), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b() {}
  
  public void b(List<avhn> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.creat", 2, "celladd.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aect
 * JD-Core Version:    0.7.0.1
 */