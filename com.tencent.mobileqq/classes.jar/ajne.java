import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqResendFileObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;

public class ajne
  extends TroopFileProtocol.ReqResendFileObserver
{
  public ajne(TroopFileUploadWorker paramTroopFileUploadWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (this.a.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileUploadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult.but stoped");
      return;
    }
    if ((paramResendRspBody == null) || (!paramBoolean))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult isSuccess:false  errCode:" + paramInt);
      paramResendRspBody = new TroopFileError.SimpleErrorInfo(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.a.jdField_a_of_type_Long, 3, 207);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = paramInt;
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.z, paramResendRspBody);
      return;
    }
    int i = paramResendRspBody.int32_ret_code.get();
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      switch (paramResendRspBody.int32_ret_code.get())
      {
      default: 
        paramInt = 1;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.c = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = i;
        if (paramInt != 206) {
          break;
        }
        TroopFileDataCenter.b(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, paramInt);
        this.a.a(false, TroopTechReportUtils.TroopFileReportResultCode.c, i);
        return;
        paramInt = 101;
        continue;
        paramInt = 102;
        continue;
        paramInt = 206;
        continue;
        paramInt = -136;
        continue;
        paramInt = -138;
      }
      this.a.a(true, TroopTechReportUtils.TroopFileReportResultCode.c, i, paramInt);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = paramResendRspBody.str_upload_ip.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = paramResendRspBody.bytes_check_key.get().toByteArray();
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult fileid:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " UploadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " busId:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajne
 * JD-Core Version:    0.7.0.1
 */