import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alww
  implements View.OnClickListener
{
  public alww(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c) {
      bdla.b(this.a.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(2130771988, 2130771989);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(this.a.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alww
 * JD-Core Version:    0.7.0.1
 */