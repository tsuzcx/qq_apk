import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class ajlz
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajlz(TroopFileMultiForwarder paramTroopFileMultiForwarder) {}
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getString("itemKey");
      } while (paramBundle == null);
      paramBundle = UUID.fromString(paramBundle);
      paramBundle = (TroopFileTransferManager.Item)this.a.jdField_a_of_type_JavaUtilMap.get(paramBundle);
    } while (paramBundle == null);
    TroopFileMultiForwarder.a(this.a, paramBundle, paramBoolean, paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlz
 * JD-Core Version:    0.7.0.1
 */