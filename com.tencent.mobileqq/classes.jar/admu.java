import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.widget.QQToast;

public class admu
  extends TeamWorkFileImportObserver
{
  public admu(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (this.a.a != null) {
      this.a.a.d();
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.d)) {
      QQToast.a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getApp(), 1, 2131439161, 0).a();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    if (this.a.a != null) {
      this.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admu
 * JD-Core Version:    0.7.0.1
 */