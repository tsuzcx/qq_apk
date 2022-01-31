import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahkx
  implements bhvu
{
  public ahkx(TroopActivity paramTroopActivity) {}
  
  public void a(bhvt parambhvt)
  {
    switch (parambhvt.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        azmj.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parambhvt = (bbml)this.a.app.getManager(32);
      } while (parambhvt == null);
      parambhvt.a(this.a, 0);
      return;
    case 1: 
      azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      azmj.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      azmj.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parambhvt = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(parambhvt);
      return;
    }
    TroopActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkx
 * JD-Core Version:    0.7.0.1
 */