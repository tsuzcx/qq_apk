import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.util;

class alio
  implements Runnable
{
  alio(alin paramalin, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenBaseTicketUtils.a();
    for (;;)
    {
      boolean bool3;
      try
      {
        Object localObject = this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Alin.jdField_a_of_type_AndroidOsBundle);
        ThreadManager.getSubThreadHandler().post(new alip(this, (DownloadInfo)localObject));
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0))
        {
          localObject = new StringBuilder();
          this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin = (this.jdField_a_of_type_JavaLangString + "&identity=" + util.buf_to_string(this.jdField_a_of_type_ArrayOfByte));
          this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d = this.jdField_a_of_type_Alin.jdField_a_of_type_Long;
        }
        LogUtility.a("MyAppApi", "OpenSDK startToAppDetail param SNGAppId=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.jdField_a_of_type_Alin.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Alin.jdField_a_of_type_Boolean, this.jdField_a_of_type_Alin.b);
          return;
        }
        int i = this.jdField_a_of_type_Alin.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.j);
        int j = this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_Alin.jdField_a_of_type_AndroidOsBundle);
        boolean bool1 = this.jdField_a_of_type_Alin.jdField_a_of_type_Boolean;
        bool3 = this.jdField_a_of_type_Alin.b;
        if (i == 3)
        {
          bool1 = false;
          ((TMAssistantCallYYB_V2)this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a()).startToAppDetail(this.jdField_a_of_type_Alin.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Alin.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
      bool2 = bool3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alio
 * JD-Core Version:    0.7.0.1
 */