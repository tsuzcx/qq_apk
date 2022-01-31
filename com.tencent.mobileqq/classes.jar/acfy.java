import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class acfy
  implements bfux
{
  public acfy(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bfuw parambfuw)
  {
    boolean bool = false;
    switch (parambfuw.a)
    {
    default: 
      return;
    case 0: 
      parambfuw = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambfuw.d = bool;
      asfd.a().b(this.a.app, this.a.d);
      return;
    }
    parambfuw = new Intent(this.a, TroopAssisSettingActivity.class);
    parambfuw.setFlags(67108864);
    this.a.startActivity(parambfuw);
    axqy.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfy
 * JD-Core Version:    0.7.0.1
 */