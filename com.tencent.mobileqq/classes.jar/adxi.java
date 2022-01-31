import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class adxi
  implements bhvu
{
  public adxi(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bhvt parambhvt)
  {
    boolean bool = false;
    switch (parambhvt.a)
    {
    default: 
      return;
    case 0: 
      parambhvt = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambhvt.d = bool;
      atwd.a().b(this.a.app, this.a.d);
      return;
    }
    parambhvt = new Intent(this.a, TroopAssisSettingActivity.class);
    parambhvt.setFlags(67108864);
    this.a.startActivity(parambhvt);
    azmj.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxi
 * JD-Core Version:    0.7.0.1
 */