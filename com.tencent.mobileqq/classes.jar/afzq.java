import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.TroopInfo;

class afzq
  implements View.OnClickListener
{
  afzq(afzp paramafzp) {}
  
  public void onClick(View paramView)
  {
    afzr localafzr = (afzr)aekt.a(paramView);
    MessageForTroopFee localMessageForTroopFee = (MessageForTroopFee)localafzr.a;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", localMessageForTroopFee.actionUrl);
    paramView.getContext().startActivity(localIntent);
    paramView = ((TroopManager)this.a.a.getManager(52)).b(localafzr.b);
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
      azmj.b(this.a.a, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, localafzr.b, i + "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzq
 * JD-Core Version:    0.7.0.1
 */