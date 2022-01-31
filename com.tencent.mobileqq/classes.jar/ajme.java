import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

public class ajme
  extends TroopFileProtocol.ReqDownloadFileObserver
{
  public ajme(TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    boolean bool;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("itemKey");
      } while ((str == null) || (!UUID.fromString(str).equals(this.a.a())) || (this.a.jdField_a_of_type_Boolean));
      i = paramBundle.getInt("thumbNail");
      bool = paramBundle.getBoolean("isPreview", false);
    } while ((i == 0) || (bool) || (i != this.a.jdField_a_of_type_Int));
    if ((paramDownloadFileRspBody == null) || (!paramBoolean))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult isSuccess:false  errCode:" + paramInt);
      this.a.d(TroopTechReportUtils.TroopFileReportResultCode.z);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      if ((i != -103) && (i != -302) && (i != -301)) {
        break label733;
      }
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult  file is not exsit. retCode:" + i);
      this.a.jdField_a_of_type_Boolean = true;
      this.a.b(4);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
      TroopFileDataCenter.a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerThumbnailTroopFileThumbnailFetchWorker$ITroopFileThumbFetchWorkerListener.a(this.a.a(), false, i, this.a);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = HexUtil.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue.toLowerCase();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl = HexUtil.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp))
      {
        TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult DownloadIp is null");
        TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
      }
      paramInt = paramDownloadFileRspBody.uint32_preview_port.get();
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult DownloadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " DownloadDNS:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + " videoPort:" + paramInt + " DownloadUrl:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + " cookieValue:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
      this.a.c(paramInt);
      return;
      label733:
      this.a.d(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajme
 * JD-Core Version:    0.7.0.1
 */