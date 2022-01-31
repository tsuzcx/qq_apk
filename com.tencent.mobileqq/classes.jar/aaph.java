import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class aaph
  implements CompoundButton.OnCheckedChangeListener
{
  public aaph(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c)
    {
      paramCompoundButton = this.a.getString(2131626293);
      DiscussionInfoCardActivity.a(this.a).setContentDescription(paramCompoundButton);
    }
    paramCompoundButton = DiscussionInfoCardActivity.a(this.a).a(DiscussionInfoCardActivity.a(this.a), this.a.app.getCurrentAccountUin());
    int i = paramCompoundButton.flag;
    label171:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      paramCompoundButton.flag = ((byte)(paramCompoundButton.flag | 0x1));
      if (i != paramCompoundButton.flag)
      {
        byte b = (byte)(paramCompoundButton.flag & 0x1);
        if (QLog.isDevelopLevel()) {
          QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag changed save now:" + paramCompoundButton.flag + " flag:" + b);
        }
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), b, paramCompoundButton.flag);
        if (!paramBoolean) {
          break label341;
        }
        paramCompoundButton = "msg_open";
        azzx.a("Grp_Dis_set", "Dis_info", paramCompoundButton, 0, 0, new String[] { DiscussionInfoCardActivity.a(this.a), azzx.a(this.a.app, this.a.a) });
      }
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label347;
      }
      paramCompoundButton = "1";
      label231:
      awqx.b(localQQAppInterface, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, paramCompoundButton, "", "", "");
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label353;
      }
    }
    label341:
    label347:
    label353:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      awqx.b(localQQAppInterface, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, paramCompoundButton, "", "", "");
      awqx.b(this.a.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
      return;
      paramCompoundButton.flag = ((byte)(paramCompoundButton.flag & 0xFFFFFFFE));
      break;
      paramCompoundButton = "msg_close";
      break label171;
      paramCompoundButton = "0";
      break label231;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaph
 * JD-Core Version:    0.7.0.1
 */