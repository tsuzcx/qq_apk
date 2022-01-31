import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class acgc
  implements bfug
{
  public acgc(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bfuf parambfuf)
  {
    boolean bool = false;
    switch (parambfuf.a)
    {
    default: 
      return;
    case 0: 
      parambfuf = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambfuf.d = bool;
      asfb.a().b(this.a.app, this.a.d);
      return;
    }
    parambfuf = new Intent(this.a, TroopAssisSettingActivity.class);
    parambfuf.setFlags(67108864);
    this.a.startActivity(parambfuf);
    axqw.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgc
 * JD-Core Version:    0.7.0.1
 */