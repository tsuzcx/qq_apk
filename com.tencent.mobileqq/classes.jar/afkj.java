import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class afkj
  implements DialogInterface.OnClickListener
{
  public afkj(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    String str2 = this.a.a.troopUin;
    if (this.a.a.bOwner) {}
    for (String str1 = "0";; str1 = "1")
    {
      bcst.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_clk", 0, 0, str2, str1, "1", "");
      paramDialogInterface.dismiss();
      this.a.j();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkj
 * JD-Core Version:    0.7.0.1
 */