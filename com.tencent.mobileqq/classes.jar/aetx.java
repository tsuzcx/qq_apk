import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.qphone.base.util.QLog;

public class aetx
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public aetx(NowShortVideoProtoManager paramNowShortVideoProtoManager, NowShortVideoProtoManager.Callback paramCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportPlay", 1, " reportPlay code:" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager$Callback.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetx
 * JD-Core Version:    0.7.0.1
 */