import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class acki
  implements DialogInterface.OnClickListener
{
  public acki(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a = false;
    this.a.doOnBackPressed();
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_quit", 0, 0, this.a.d, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acki
 * JD-Core Version:    0.7.0.1
 */