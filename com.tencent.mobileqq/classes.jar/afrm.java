import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class afrm
  implements blop
{
  public afrm(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bloo parambloo)
  {
    boolean bool = false;
    switch (parambloo.a)
    {
    default: 
      return;
    case 0: 
      parambloo = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambloo.d = bool;
      axan.a().b(this.a.app, this.a.d);
      return;
    }
    parambloo = new Intent(this.a, TroopAssisSettingActivity.class);
    parambloo.setFlags(67108864);
    this.a.startActivity(parambloo);
    bdll.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrm
 * JD-Core Version:    0.7.0.1
 */