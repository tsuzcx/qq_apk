import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ManageInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class aale
  implements View.OnClickListener
{
  public aale(ChatSettingForTroop paramChatSettingForTroop, oidb_0xaf4.RspBody paramRspBody) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_TencentImOidbCmd0xaf4Oidb_0xaf4$RspBody.manage_info.url.get();
    Intent localIntent;
    String str;
    if ((paramView.startsWith("http")) || (paramView.startsWith("https")))
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, QQBrowserActivity.class);
      str = paramView.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin);
      paramView = null;
      int i = 0;
      while (i < ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop).size())
      {
        Object localObject = paramView;
        if (paramView == null) {
          localObject = new StringBuilder("&mini_appids=");
        }
        ((StringBuilder)localObject).append(ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop).get(i));
        if (i != ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop).size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i += 1;
        paramView = (View)localObject;
      }
      if (paramView == null) {
        break label233;
      }
    }
    label233:
    for (paramView = str + paramView.toString();; paramView = str)
    {
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.startActivity(localIntent);
      MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "click_set", this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aale
 * JD-Core Version:    0.7.0.1
 */