import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aebx
  implements CompoundButton.OnCheckedChangeListener
{
  public aebx(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c)
    {
      localObject = this.a.getString(2131691621);
      DiscussionInfoCardActivity.a(this.a).setContentDescription((CharSequence)localObject);
    }
    Object localObject = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a), this.a.app.getCurrentAccountUin());
    int i = ((DiscussionMemberInfo)localObject).flag;
    label182:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag | 0x1));
      if (i != ((DiscussionMemberInfo)localObject).flag)
      {
        byte b = (byte)(((DiscussionMemberInfo)localObject).flag & 0x1);
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag changed save now:" + ((DiscussionMemberInfo)localObject).flag + " flag:" + b);
        }
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), b, ((DiscussionMemberInfo)localObject).flag);
        if (!paramBoolean) {
          break label367;
        }
        localObject = "msg_open";
        bgjt.a("Grp_Dis_set", "Dis_info", (String)localObject, 0, 0, new String[] { DiscussionInfoCardActivity.a(this.a), bgjt.a(this.a.app, this.a.a) });
      }
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label374;
      }
      localObject = "1";
      label244:
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label381;
      }
    }
    label367:
    label374:
    label381:
    for (localObject = "1";; localObject = "0")
    {
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, (String)localObject, "", "", "");
      bcst.b(this.a.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag & 0xFFFFFFFE));
      break;
      localObject = "msg_close";
      break label182;
      localObject = "0";
      break label244;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebx
 * JD-Core Version:    0.7.0.1
 */