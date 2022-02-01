import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advc
  implements CompoundButton.OnCheckedChangeListener
{
  public advc(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c)
    {
      localObject1 = this.a.getString(2131692964);
      DiscussionInfoCardActivity.b(this.a).setContentDescription((CharSequence)localObject1);
    }
    boolean bool2 = DiscussionInfoCardActivity.a(this.a).a(this.a.a);
    Object localObject1 = DiscussionInfoCardActivity.a(this.a);
    Object localObject2 = this.a.a;
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      ((antl)localObject1).a((DiscussionInfo)localObject2, bool1);
      localObject2 = new bdlf(this.a.app).a("dc00899").b("Grp_Dis_set").c("Dis_info");
      if (!bool2) {
        break label145;
      }
    }
    label145:
    for (localObject1 = "Clk_unstick";; localObject1 = "Clk_stick")
    {
      ((bdlf)localObject2).d((String)localObject1).a();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advc
 * JD-Core Version:    0.7.0.1
 */