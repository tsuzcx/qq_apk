import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afnt
  implements bfug
{
  public afnt(TroopActivity paramTroopActivity) {}
  
  public void a(bfuf parambfuf)
  {
    switch (parambfuf.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        axqw.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parambfuf = (azoa)this.a.app.getManager(32);
      } while (parambfuf == null);
      parambfuf.a(this.a, 0);
      return;
    case 1: 
      axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      axqw.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      axqw.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parambfuf = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(parambfuf);
      return;
    }
    TroopActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnt
 * JD-Core Version:    0.7.0.1
 */