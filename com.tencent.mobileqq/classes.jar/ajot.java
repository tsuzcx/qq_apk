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

public class ajot
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajot(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    UUID localUUID;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a.get(Long.valueOf(l));
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
        paramBundle = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localUUID);
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
              this.a.c.remove(localUUID);
              if (this.a.c.size() != 0) {
                break label332;
              }
              paramRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.f, 5, 604);
              this.a.a(paramBundle, 5, paramRspBody);
              return;
            }
          }
          finally {}
          this.a.c.put(localUUID, Integer.valueOf(i));
          continue;
          label332:
          paramRspBody = this.a.c.keySet().iterator();
          do
          {
            if (!paramRspBody.hasNext()) {
              break;
            }
            localObject = (UUID)paramRspBody.next();
          } while (((Integer)this.a.c.get(localObject)).intValue() != 2147483647);
          for (i = 0;; i = 1)
          {
            if (i == 0) {
              break label443;
            }
            paramRspBody = new TroopFileError.SimpleErrorInfo(paramBundle.FileName, this.a.f, 5, 605);
            this.a.a(paramBundle, 5, paramRspBody);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajot
 * JD-Core Version:    0.7.0.1
 */