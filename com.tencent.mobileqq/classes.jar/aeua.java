import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;

public class aeua
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public aeua(NowShortVideoProtoManager paramNowShortVideoProtoManager, NowShortVideoProtoManager.Callback paramCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager$Callback.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeua
 * JD-Core Version:    0.7.0.1
 */