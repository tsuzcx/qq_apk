import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqFeedsObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;

public class ajmp
  extends TroopFileProtocol.ReqFeedsObserver
{
  public ajmp(TroopFileUploadFeedsSender paramTroopFileUploadFeedsSender) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.FeedsRspBody paramFeedsRspBody, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    int i;
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = paramBundle.getString("itemKey");
        } while (localObject == null);
        localObject = UUID.fromString((String)localObject);
      } while (!((UUID)localObject).equals(this.a.a()));
      i = paramFeedsRspBody.int32_ret_code.get();
      TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult errCode:" + paramInt + " retCode:" + i);
      paramFeedsRspBody = paramBundle.getString("fileId");
      paramBundle = TroopFileTransferUtil.a(this.a.jdField_a_of_type_Long);
      if (paramBundle == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramBundle = paramBundle.a((UUID)localObject);
      if (paramBundle == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (i != 0);
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    TroopFileProtocol.a(TroopFileTransferUtil.a(), this.a.jdField_a_of_type_Long, paramBundle.a, paramBundle.b, this.a.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetOneFileInfoObserver);
    ThreadManager.executeOnSubThread(new ajmq(this, paramFeedsRspBody, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmp
 * JD-Core Version:    0.7.0.1
 */