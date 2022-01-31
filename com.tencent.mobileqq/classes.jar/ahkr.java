import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import java.util.HashMap;

public class ahkr
  implements View.OnClickListener
{
  public ahkr(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      this.a.b();
      return;
    case 2131368613: 
    case 2131368961: 
    case 2131378562: 
      if (this.a.a != null)
      {
        paramView = new Intent();
        if (!this.a.a.isEmpty()) {
          bool = true;
        }
        paramView.putExtra("isDataChanged", bool);
        this.a.setResult(-1, paramView);
      }
      this.a.onBackPressed();
      return;
    }
    azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
    if (this.a.a())
    {
      this.a.b();
      return;
    }
    azmj.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */