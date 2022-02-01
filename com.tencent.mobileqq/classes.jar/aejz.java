import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class aejz
  extends ClickableSpan
{
  public aejz(NotificationActivity paramNotificationActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, "dc00898", "", NotificationActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
    }
    NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, "0X800B656");
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.getActivity(), QQBrowserActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(paramView.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"));
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aejz
 * JD-Core Version:    0.7.0.1
 */