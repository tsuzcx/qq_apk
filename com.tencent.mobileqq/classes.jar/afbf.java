import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel.OnDataComeListener;
import com.tencent.mobileqq.nearby.now.model.PlayListDataModel;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class afbf
  implements NowShortVideoProtoManager.Callback
{
  public afbf(PlayListDataModel paramPlayListDataModel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i(PlayListDataModel.a(this.a), 2, "errorCode:   " + paramInt);
    }
    if (paramArrayOfByte != null) {
      paramBundle = new oidb_0xada.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i(PlayListDataModel.a(this.a), 2, "err_msg:   " + paramBundle.err_msg.get());
      }
      if (paramBundle.busi_buf.has())
      {
        paramArrayOfByte = new FeedsProtocol.GetMediaDetailRsp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i(PlayListDataModel.a(this.a), 2, "GetMediaDetailRsp  error_code:   " + paramArrayOfByte.err_code.get() + ",err_msg:     " + paramArrayOfByte.err_msg.get().toStringUtf8() + ",total:  " + paramArrayOfByte.total.get());
        }
        paramBundle = this.a;
        if (paramArrayOfByte.is_end.get() == 0) {
          break label309;
        }
      }
      for (;;)
      {
        paramBundle.jdField_a_of_type_Boolean = bool;
        this.a.jdField_a_of_type_Int = paramArrayOfByte.total.get();
        PlayListDataModel.a(this.a, paramArrayOfByte);
        PlayListDataModel.a(this.a, PlayListDataModel.a(this.a) + 10);
        paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel$OnDataComeListener;
        paramInt = i;
        if (paramArrayOfByte.err_code.has()) {
          paramInt = paramArrayOfByte.err_code.get();
        }
        paramBundle.a(1, paramInt);
        return;
        label309:
        bool = false;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbf
 * JD-Core Version:    0.7.0.1
 */