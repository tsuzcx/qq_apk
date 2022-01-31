import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.qphone.base.util.QLog;

public class aciy
  extends TeamWorkFileImportObserver
{
  public aciy(MessengerService paramMessengerService) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.a.a != null)
    {
      paramTeamWorkFileImportInfo = new Bundle();
      paramTeamWorkFileImportInfo.putString("url", null);
      this.a.a.putBundle("response", paramTeamWorkFileImportInfo);
      this.a.a(this.a.a);
      this.a.a = null;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
    }
    if (this.a.a != null)
    {
      paramTeamWorkFileImportInfo = new Bundle();
      paramTeamWorkFileImportInfo.putString("url", paramString);
      this.a.a.putBundle("response", paramTeamWorkFileImportInfo);
      this.a.a(this.a.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aciy
 * JD-Core Version:    0.7.0.1
 */