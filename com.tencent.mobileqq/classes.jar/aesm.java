import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager;
import com.tencent.mobileqq.nearby.now.location.LocationDataManager.UiUpdate;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LogUtil;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class aesm
  implements NowShortVideoProtoManager.Callback
{
  public aesm(LocationDataManager paramLocationDataManager, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0) {
      if (paramArrayOfByte != null) {
        paramBundle = new oidb_0xada.RspBody();
      }
    }
    do
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i("LocationDataManager", 1, "err_msg:   " + paramBundle.err_msg.get());
        }
        if (paramBundle.busi_buf.has()) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager.a(paramBundle.busi_buf.get().toByteArray(), this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        do
        {
          LogUtil.e("LocationDataManager", "InvalidProtocolBufferMicroException", paramArrayOfByte);
        } while (LocationDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager) == null);
        paramArrayOfByte = LocationDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager);
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      }
      for (;;)
      {
        paramArrayOfByte.a(bool1);
        return;
        bool1 = false;
      }
      LogUtil.i("LocationDataManager", "sendCsTask onError: " + paramInt);
    } while (LocationDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager) == null);
    paramArrayOfByte = LocationDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramArrayOfByte.a(bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aesm
 * JD-Core Version:    0.7.0.1
 */