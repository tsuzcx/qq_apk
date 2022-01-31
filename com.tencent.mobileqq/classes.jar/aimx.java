import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

class aimx
  implements DialogInterface.OnClickListener
{
  aimx(aimv paramaimv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.b == 1) {
      ReportController.b(TeamWorkAuthorizeSettingFragment.a(this.a.a), "dc00898", "", "", "0x8007CFE", "0x8007CFE", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimx
 * JD-Core Version:    0.7.0.1
 */