import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.TroopInfo;

class adsf
  implements View.OnClickListener
{
  adsf(adse paramadse) {}
  
  public void onClick(View paramView)
  {
    adsg localadsg = (adsg)aciy.a(paramView);
    MessageForTroopFee localMessageForTroopFee = (MessageForTroopFee)localadsg.a;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", localMessageForTroopFee.actionUrl);
    paramView.getContext().startActivity(localIntent);
    paramView = ((TroopManager)this.a.a.getManager(52)).b(localadsg.b);
    int i;
    if (paramView != null)
    {
      if (!paramView.isTroopOwner(this.a.a.getCurrentAccountUin())) {
        break label150;
      }
      i = 0;
    }
    for (;;)
    {
      awqx.b(this.a.a, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, localadsg.b, i + "", "", "");
      return;
      label150:
      if (paramView.isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsf
 * JD-Core Version:    0.7.0.1
 */