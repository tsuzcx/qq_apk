import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advb
  implements CompoundButton.OnCheckedChangeListener
{
  public advb(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c)
    {
      localObject = this.a.getString(2131691753);
      DiscussionInfoCardActivity.a(this.a).setContentDescription((CharSequence)localObject);
    }
    Object localObject = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a), this.a.app.getCurrentAccountUin());
    label187:
    QQAppInterface localQQAppInterface;
    if (localObject != null)
    {
      int i = ((DiscussionMemberInfo)localObject).flag;
      if (!paramBoolean) {
        break label355;
      }
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag | 0x1));
      if (i != ((DiscussionMemberInfo)localObject).flag)
      {
        byte b = (byte)(((DiscussionMemberInfo)localObject).flag & 0x1);
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag changed save now:" + ((DiscussionMemberInfo)localObject).flag + " flag:" + b);
        }
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), b, ((DiscussionMemberInfo)localObject).flag);
        if (!paramBoolean) {
          break label372;
        }
        localObject = "msg_open";
        bhbu.a("Grp_Dis_set", "Dis_info", (String)localObject, 0, 0, new String[] { DiscussionInfoCardActivity.a(this.a), bhbu.a(this.a.app, this.a.a) });
      }
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label379;
      }
      localObject = "1";
      label249:
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label386;
      }
    }
    label386:
    for (localObject = "1";; localObject = "0")
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, (String)localObject, "", "", "");
      bdla.b(this.a.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label355:
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag & 0xFFFFFFFE));
      break;
      label372:
      localObject = "msg_close";
      break label187;
      label379:
      localObject = "0";
      break label249;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advb
 * JD-Core Version:    0.7.0.1
 */