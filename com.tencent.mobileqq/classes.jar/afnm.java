import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afnm
  implements View.OnClickListener
{
  public afnm(ShowReactiveActivity paramShowReactiveActivity, arnb paramarnb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Arnb.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnm
 * JD-Core Version:    0.7.0.1
 */