import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class aeke
  implements bjsz
{
  public aeke(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bjsy parambjsy)
  {
    boolean bool = false;
    switch (parambjsy.a)
    {
    default: 
      return;
    case 0: 
      parambjsy = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambjsy.d = bool;
      avnu.a().b(this.a.app, this.a.d);
      return;
    }
    parambjsy = new Intent(this.a, TroopAssisSettingActivity.class);
    parambjsy.setFlags(67108864);
    this.a.startActivity(parambjsy);
    bcef.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeke
 * JD-Core Version:    0.7.0.1
 */