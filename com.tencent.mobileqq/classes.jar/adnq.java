import MQQ.PayRuleCfg;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;

public class adnq
  extends baum
{
  public adnq(QQSettingMe paramQQSettingMe, TextView paramTextView) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("QQSettingRedesign", 1, "VipInfoHandler updateVipItemView onLoadFialed: ", paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "VipInfoHandler onLoadSuccessed: " + QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).iconUrl);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).iconText);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).iconTextCol));
      return;
    }
    catch (Exception paramURLDrawable)
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler setTextColor: " + QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).iconTextCol, paramURLDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnq
 * JD-Core Version:    0.7.0.1
 */