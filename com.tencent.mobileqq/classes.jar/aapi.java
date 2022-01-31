import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aapi
  implements CompoundButton.OnCheckedChangeListener
{
  public aapi(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c)
    {
      paramCompoundButton = this.a.getString(2131627560);
      DiscussionInfoCardActivity.b(this.a).setContentDescription(paramCompoundButton);
    }
    boolean bool = DiscussionInfoCardActivity.a(this.a).a(this.a.a);
    paramCompoundButton = DiscussionInfoCardActivity.a(this.a);
    Object localObject = this.a.a;
    if (!bool)
    {
      paramBoolean = true;
      paramCompoundButton.a((DiscussionInfo)localObject, paramBoolean);
      localObject = new awrb(this.a.app).a("dc00899").b("Grp_Dis_set").c("Dis_info");
      if (!bool) {
        break label128;
      }
    }
    label128:
    for (paramCompoundButton = "Clk_unstick";; paramCompoundButton = "Clk_stick")
    {
      ((awrb)localObject).d(paramCompoundButton).a();
      return;
      paramBoolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapi
 * JD-Core Version:    0.7.0.1
 */