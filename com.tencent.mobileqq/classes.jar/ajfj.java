import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class ajfj
  implements blel
{
  public ajfj(TroopActivity paramTroopActivity) {}
  
  public void a(blek paramblek)
  {
    switch (paramblek.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        bdla.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        bdla.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        paramblek = (bfgz)this.a.app.getManager(QQManagerFactory.MGR_TROOP_CREATE);
      } while (paramblek == null);
      paramblek.a(this.a, 0);
      return;
    case 1: 
      bdla.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      bdla.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      bdla.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      bdla.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      paramblek = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(paramblek);
      return;
    }
    TroopActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfj
 * JD-Core Version:    0.7.0.1
 */