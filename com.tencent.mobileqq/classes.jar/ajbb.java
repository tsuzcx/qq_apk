import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqFeedsObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;

public class ajbb
  extends TroopFileProtocol.ReqFeedsObserver
{
  public ajbb(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.FeedsRspBody paramFeedsRspBody, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        paramInt = paramFeedsRspBody.int32_ret_code.get();
        paramFeedsRspBody = paramBundle.getString("itemKey");
      } while (paramFeedsRspBody == null);
      paramFeedsRspBody = UUID.fromString(paramFeedsRspBody);
      paramBundle = paramBundle.getString("fileId");
      paramFeedsRspBody = (TroopFileInfo)this.a.a().b.get(paramFeedsRspBody);
    } while ((paramFeedsRspBody == null) || (paramInt != 0));
    TroopFileProtocol.a(this.a.a, this.a.f, paramFeedsRspBody.a, paramFeedsRspBody.b, TroopFileTransferManager.a(this.a));
    ThreadManager.executeOnSubThread(new ajbc(this, paramBundle, paramFeedsRspBody));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbb
 * JD-Core Version:    0.7.0.1
 */