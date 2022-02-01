import android.widget.EditText;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class afnj
  extends aohf
{
  public afnj(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void a(int paramInt)
  {
    this.a.b();
    SendBirthdayWishesActivity.a(this.a, paramInt);
    this.a.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.a);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (paramInt != 2)
    {
      SendBirthdayWishesActivity.a(this.a).removeCallbacks(SendBirthdayWishesActivity.a(this.a));
      SendBirthdayWishesActivity.a(this.a).postDelayed(SendBirthdayWishesActivity.a(this.a), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnj
 * JD-Core Version:    0.7.0.1
 */