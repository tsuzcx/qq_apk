import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afnr
  implements bfux
{
  public afnr(TroopActivity paramTroopActivity) {}
  
  public void a(bfuw parambfuw)
  {
    switch (parambfuw.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        axqy.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        axqy.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parambfuw = (azoc)this.a.app.getManager(32);
      } while (parambfuw == null);
      parambfuw.a(this.a, 0);
      return;
    case 1: 
      axqy.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      axqy.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      axqy.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      axqy.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parambfuw = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(parambfuw);
      return;
    }
    TroopActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnr
 * JD-Core Version:    0.7.0.1
 */