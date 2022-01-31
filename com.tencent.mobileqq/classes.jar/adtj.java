import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;

public class adtj
  implements View.OnClickListener
{
  public adtj(ShowReactiveActivity paramShowReactiveActivity, aoqs paramaoqs) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_Aoqs.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtj
 * JD-Core Version:    0.7.0.1
 */