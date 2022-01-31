import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class abvq
  implements bemm
{
  public abvq(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(beml parambeml)
  {
    boolean bool = false;
    switch (parambeml.a)
    {
    default: 
      return;
    case 0: 
      parambeml = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambeml.d = bool;
      ariz.a().b(this.a.app, this.a.d);
      return;
    }
    parambeml = new Intent(this.a, TroopAssisSettingActivity.class);
    parambeml.setFlags(67108864);
    this.a.startActivity(parambeml);
    awqx.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvq
 * JD-Core Version:    0.7.0.1
 */