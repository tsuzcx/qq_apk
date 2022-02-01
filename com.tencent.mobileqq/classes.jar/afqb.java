import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class afqb
  implements Handler.Callback
{
  public afqb(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 2: 
      if ((this.a.mSwiftTitleUI.c != null) && (!this.a.mSwiftTitleUI.c.isEnabled())) {
        this.a.mSwiftTitleUI.c.setEnabled(true);
      }
      Object localObject = (String)paramMessage.obj;
      if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a))
      {
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, 1);
        this.a.getActivity().finish();
        paramMessage = new Bundle();
        paramMessage.putString("savedUrl", (String)localObject);
        localObject = (TeamWorkFileImportInfo)this.a.getIntent().getParcelableExtra("key_team_work_file_import_info");
        if (((TeamWorkFileImportInfo)localObject).e != 3) {
          break label226;
        }
        paramMessage.putInt("editType", 1);
      }
      for (;;)
      {
        if (this.a.getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
          paramMessage.putParcelable("key_team_work_file_import_info", this.a.getIntent().getParcelableExtra("key_team_work_file_import_info"));
        }
        paramMessage = asev.a("ipc_save_team_work", "", -1, paramMessage);
        asjw.a().a(paramMessage);
        return true;
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, 0);
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a, (String)localObject);
        break;
        label226:
        if (((TeamWorkFileImportInfo)localObject).e == 6) {
          paramMessage.putInt("editType", 2);
        }
      }
    }
    if ((this.a.mSwiftTitleUI.c != null) && (!this.a.mSwiftTitleUI.c.isEnabled())) {
      this.a.mSwiftTitleUI.c.setEnabled(true);
    }
    QQToast.a(this.a.getActivity(), anzj.a(2131713548), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqb
 * JD-Core Version:    0.7.0.1
 */