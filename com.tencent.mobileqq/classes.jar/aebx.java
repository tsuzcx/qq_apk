import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class aebx
  implements biab
{
  public aebx(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(biaa parambiaa)
  {
    boolean bool = false;
    switch (parambiaa.a)
    {
    default: 
      return;
    case 0: 
      parambiaa = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambiaa.d = bool;
      auam.a().b(this.a.app, this.a.d);
      return;
    }
    parambiaa = new Intent(this.a, TroopAssisSettingActivity.class);
    parambiaa.setFlags(67108864);
    this.a.startActivity(parambiaa);
    azqs.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebx
 * JD-Core Version:    0.7.0.1
 */