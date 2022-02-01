import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aexm
  implements View.OnClickListener
{
  public aexm(ShowReactiveActivity paramShowReactiveActivity, arkh paramarkh) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Arkh.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexm
 * JD-Core Version:    0.7.0.1
 */