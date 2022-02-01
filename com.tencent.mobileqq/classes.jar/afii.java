import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class afii
  implements bknm
{
  public afii(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(bknl parambknl)
  {
    boolean bool = false;
    switch (parambknl.a)
    {
    default: 
      return;
    case 0: 
      parambknl = this.a;
      if (!this.a.d) {
        bool = true;
      }
      parambknl.d = bool;
      awhv.a().b(this.a.app, this.a.d);
      return;
    }
    parambknl = new Intent(this.a, TroopAssisSettingActivity.class);
    parambknl.setFlags(67108864);
    this.a.startActivity(parambknl);
    bcst.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afii
 * JD-Core Version:    0.7.0.1
 */