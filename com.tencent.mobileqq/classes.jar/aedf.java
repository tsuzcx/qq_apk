import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class aedf
  implements View.OnClickListener
{
  public aedf(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, AccountDetailActivity.class);
    paramView.putExtra("uin", this.a.a.req_uin.get() + "");
    paramView.putExtra("source", 112);
    this.a.startActivity(paramView);
    azmj.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "Clk_invite", 0, 0, "", "", "", this.a.a.req_uin.get() + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedf
 * JD-Core Version:    0.7.0.1
 */