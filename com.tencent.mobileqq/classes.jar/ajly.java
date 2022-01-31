import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class ajly
  extends TroopFileProtocol.ReqCopyToObserver
{
  public ajly(TroopFileFromTroopForwarder paramTroopFileFromTroopForwarder) {}
  
  public void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId != 25));
    TroopFileFromTroopForwarder.a(this.a, paramBoolean, paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajly
 * JD-Core Version:    0.7.0.1
 */