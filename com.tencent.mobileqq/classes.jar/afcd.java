import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afcd
  implements bemm
{
  public afcd(TroopActivity paramTroopActivity) {}
  
  public void a(beml parambeml)
  {
    switch (parambeml.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        awqx.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        awqx.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parambeml = (aynk)this.a.app.getManager(32);
      } while (parambeml == null);
      parambeml.a(this.a, 0);
      return;
    case 1: 
      awqx.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      awqx.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      awqx.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      awqx.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parambeml = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(parambeml);
      return;
    }
    TroopActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afcd
 * JD-Core Version:    0.7.0.1
 */