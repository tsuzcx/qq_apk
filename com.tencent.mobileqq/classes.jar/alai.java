import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alai
  implements View.OnClickListener
{
  alai(alag paramalag) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)alag.a(this.a));
    bcef.b(alag.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alai
 * JD-Core Version:    0.7.0.1
 */