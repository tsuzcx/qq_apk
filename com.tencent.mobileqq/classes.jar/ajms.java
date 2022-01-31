import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;

public class ajms
  implements Runnable
{
  public ajms(TroopFileUploadMgr paramTroopFileUploadMgr) {}
  
  public void run()
  {
    if (this.a.a) {
      return;
    }
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.a);
      this.a.a = true;
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajms
 * JD-Core Version:    0.7.0.1
 */