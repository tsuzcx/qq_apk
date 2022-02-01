import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class afbm
  implements blel
{
  public afbm(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(blek paramblek)
  {
    boolean bool = false;
    switch (paramblek.a)
    {
    default: 
      return;
    case 0: 
      paramblek = this.a;
      if (!this.a.d) {
        bool = true;
      }
      paramblek.d = bool;
      awtz.a().b(this.a.app, this.a.d);
      return;
    }
    paramblek = new Intent(this.a, TroopAssisSettingActivity.class);
    paramblek.setFlags(67108864);
    this.a.startActivity(paramblek);
    bdla.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbm
 * JD-Core Version:    0.7.0.1
 */