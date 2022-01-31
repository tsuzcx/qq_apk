import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahpm
  implements biab
{
  public ahpm(TroopActivity paramTroopActivity) {}
  
  public void a(biaa parambiaa)
  {
    switch (parambiaa.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        azqs.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        azqs.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parambiaa = (bbqu)this.a.app.getManager(32);
      } while (parambiaa == null);
      parambiaa.a(this.a, 0);
      return;
    case 1: 
      azqs.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      azqs.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      azqs.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      azqs.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parambiaa = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(parambiaa);
      return;
    }
    TroopActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpm
 * JD-Core Version:    0.7.0.1
 */