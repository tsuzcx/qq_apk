import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class ajbs
  extends ProtoUtils.AppProtocolObserver
{
  public ajbs(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0x962.RspBody();
    if (paramArrayOfByte != null) {}
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, paramBundle);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_oidb_0x962. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbs
 * JD-Core Version:    0.7.0.1
 */