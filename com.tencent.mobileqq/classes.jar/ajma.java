import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class ajma
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajma(TroopFileToTroopForwarder paramTroopFileToTroopForwarder) {}
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != TroopFileToTroopForwarder.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if ((!paramBoolean) || (paramRspBody == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + TroopFileToTroopForwarder.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
      TroopFileToTroopForwarder.a(this.a, paramRspBody);
      return;
    }
    TroopFileToTroopForwarder.a(this.a, paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajma
 * JD-Core Version:    0.7.0.1
 */