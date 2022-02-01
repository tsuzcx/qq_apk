import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afll
  implements View.OnClickListener
{
  public afll(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == 15) && (TroopMemberListActivity.a(this.a).size() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("param_deleted_uins", TroopMemberListActivity.a(this.a));
      this.a.setResult(-1, localIntent);
      if ((this.a.e == null) || (!this.a.e.equals(this.a.app.getCurrentAccountUin()))) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = 1)
    {
      bcst.b(this.a.app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.a.b, "" + i, "1", TroopMemberListActivity.a(this.a).toString());
      this.a.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afll
 * JD-Core Version:    0.7.0.1
 */