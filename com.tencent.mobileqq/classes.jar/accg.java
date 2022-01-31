import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class accg
  extends TeamWorkFileImportObserver
{
  public accg(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.a) != null) && (FilePreviewActivity.a(this.a).isShowing())) {
      FilePreviewActivity.a(this.a).dismiss();
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.d)) {
      QQToast.a(this.a.app.getApp(), 1, 2131439106, 0).a();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.a) != null) && (FilePreviewActivity.a(this.a).isShowing())) {
      FilePreviewActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accg
 * JD-Core Version:    0.7.0.1
 */