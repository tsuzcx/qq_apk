import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;

public class aimg
  implements Runnable
{
  public aimg(TeamWorkFileImportHandler paramTeamWorkFileImportHandler, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c))) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.a(TeamWorkHttpUtils.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c), this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo));
      localObject = TeamWorkHttpUtils.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b.getCurrentAccountUin());
      bool = false;
      if (localObject != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.b((String)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      }
    } while ((bool) || (TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler) == null));
    Object localObject = TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler).obtainMessage(8002);
    ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
    TeamWorkFileImportHandler.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimg
 * JD-Core Version:    0.7.0.1
 */