import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class aicu
  implements View.OnClickListener
{
  public aicu(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c) {
      axqw.b(this.a.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      axqw.b(this.a.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_cancel", 0, 0, "", "" + this.a.h, "", "");
      this.a.finish();
      return;
      axqw.b(this.a.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */