import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agrv
  implements View.OnClickListener
{
  agrv(agru paramagru) {}
  
  public void onClick(View paramView)
  {
    agrw localagrw = (agrw)AIOUtils.getHolder(paramView);
    Object localObject = (MessageForTroopFee)localagrw.a;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", ((MessageForTroopFee)localObject).actionUrl);
    paramView.getContext().startActivity(localIntent);
    localObject = ((TroopManager)this.a.a.getManager(52)).b(localagrw.b);
    int i;
    if (localObject != null)
    {
      if (!((TroopInfo)localObject).isTroopOwner(this.a.a.getCurrentAccountUin())) {
        break label160;
      }
      i = 0;
    }
    for (;;)
    {
      bcef.b(this.a.a, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, localagrw.b, i + "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label160:
      if (((TroopInfo)localObject).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrv
 * JD-Core Version:    0.7.0.1
 */