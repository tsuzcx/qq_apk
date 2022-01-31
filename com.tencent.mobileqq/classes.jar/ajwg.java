import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class ajwg
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajwg(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    UUID localUUID;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a().get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      localObject = paramBundle.getString("itemKey");
      if (localObject == null) {
        return;
      }
      localUUID = UUID.fromString((String)localObject);
      try
      {
        paramBundle = (TroopFileTransferManager.Item)localTroopFileTransferManager.a.get(localUUID);
        if (paramBundle == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + (String)localObject);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if ((paramBoolean) && (paramRspBody != null))
    {
      int i = paramRspBody.int32_ret_code.get();
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", new Object[] { Integer.valueOf(i) }));
      }
      if (paramBundle.BusId == 25) {
        label443:
        for (;;)
        {
          try
          {
            ResponseHandler.a(i);
            if (i == 0)
            {
              this.a.b.remove(localUUID);
              if (this.a.b.size() != 0) {
                break label332;
              }
              paramRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.e, 5, 604);
              this.a.a(paramBundle, 5, paramRspBody);
              return;
            }
          }
          finally {}
          this.a.b.put(localUUID, Integer.valueOf(i));
          continue;
          label332:
          paramRspBody = this.a.b.keySet().iterator();
          do
          {
            if (!paramRspBody.hasNext()) {
              break;
            }
            localObject = (UUID)paramRspBody.next();
          } while (((Integer)this.a.b.get(localObject)).intValue() != 2147483647);
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label443;
            }
            paramRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.e, 5, 605);
            this.a.a(paramBundle, 5, paramRspBody);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwg
 * JD-Core Version:    0.7.0.1
 */