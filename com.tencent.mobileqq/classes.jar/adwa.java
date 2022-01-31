import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

public class adwa
  implements View.OnClickListener
{
  public adwa(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    int i = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).getIntExtra("key_team_work_edit_type", -1);
    if ((i != 1) && (i != 2)) {
      i = this.a.a;
    }
    paramView = this.a.f();
    String str = this.a.a().b();
    Intent localIntent = new Intent(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a), TeamWorkAuthorizeSettingFragment.class);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("team_work_name", str);
    }
    localIntent.putExtra("team_work_pad_url", paramView);
    localIntent.putExtra("team_work_pad_list_type", this.a.d);
    PublicFragmentActivity.a(this.a.getActivity(), localIntent, TeamWorkAuthorizeSettingFragment.class);
    this.a.a(14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwa
 * JD-Core Version:    0.7.0.1
 */