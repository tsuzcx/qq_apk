import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;

public class accb
  implements View.OnClickListener
{
  public accb(ShowReactiveActivity paramShowReactiveActivity, amzl paramamzl) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Amzl.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     accb
 * JD-Core Version:    0.7.0.1
 */