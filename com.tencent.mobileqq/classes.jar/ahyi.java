import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDisc;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahyi
  extends FileTransferObserver
{
  public ahyi(TeamWorkFileImportJobForDisc paramTeamWorkFileImportJobForDisc) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    paramInt2 = 0;
    paramString2 = new JSONObject();
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJobForDisc", 2, "---OnDiscDownloadInfo retCode: " + paramLong1 + ",retMsg: " + paramString1 + ",strCookie: " + paramString5 + ",host: " + paramString3 + ",port: " + paramInt1);
      }
      paramString1 = new StringBuilder("http://");
      paramString1.append(paramString3).append(":").append(paramInt1).append("/ftn_handler/").append(paramString4);
    }
    for (;;)
    {
      try
      {
        paramString3 = new JSONArray();
        paramString3.put(0, paramString1.toString());
        paramString2.put("urls", paramString3);
        paramString2.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
        paramString2.put("cookie", paramString5);
        paramInt1 = 1;
      }
      catch (Exception paramString1)
      {
        paramInt1 = 0;
        QLog.e("TeamWorkFileImportJobForDisc", 2, "OnDiscDownloadInfo exception: " + paramString1.toString());
        continue;
      }
      paramInt2 = 0;
      try
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          if (paramInt1 == 0) {
            paramString2.put("filename", this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
          }
          paramString2.put("filetype", 2);
          paramString2.put("fileid", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
          paramString2.put("discussuin", Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin));
          paramString2.put("md5", this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5);
          paramInt2 = 1;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("TeamWorkFileImportJobForDisc", 2, "put fileid exception: " + paramString1.toString());
        paramInt2 = 0;
        continue;
        this.a.a(true);
      }
      if (((paramInt2 == 0) && (paramInt1 == 0)) || (paramString2 == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler.a(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
      return;
      QLog.e("TeamWorkFileImportJobForDisc", 1, "---OnDiscDownloadInfo retCode: " + paramLong1 + ",fileName: " + this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b + "----");
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyi
 * JD-Core Version:    0.7.0.1
 */