import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import org.json.JSONObject;

public class aimh
  implements Runnable
{
  public aimh(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b == null) {}
    label141:
    for (;;)
    {
      return;
      Object localObject = TeamWorkHttpUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b.getCurrentAccountUin());
      if (localObject != null) {}
      for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b((String)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);; bool = false)
      {
        if (bool) {
          break label141;
        }
        if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c))
        {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
          ((TeamWorkFileImportInfo)localObject).a = false;
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.a((TeamWorkFileImportInfo)localObject);
          return;
        }
        if (TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler) == null) {
          break;
        }
        localObject = TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler).obtainMessage(8002);
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
        TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler).sendMessage((Message)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimh
 * JD-Core Version:    0.7.0.1
 */