import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class ajuc
  implements View.OnClickListener
{
  public ajuc(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c) {
      azmj.b(this.a.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      azmj.b(this.a.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_cancel", 0, 0, "", "" + this.a.h, "", "");
      this.a.finish();
      return;
      azmj.b(this.a.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuc
 * JD-Core Version:    0.7.0.1
 */