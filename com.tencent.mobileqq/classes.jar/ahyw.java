import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

public class ahyw
  implements DialogInterface.OnClickListener
{
  public ahyw(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyw
 * JD-Core Version:    0.7.0.1
 */