import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class afah
  implements NowShortVideoProtoManager.Callback
{
  public afah(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("PlayOperationViewModel", 2, "queryVideoState err_msg:   " + paramBundle.err_msg.get());
      }
      if (paramBundle.busi_buf.has())
      {
        paramArrayOfByte = new ilive_short_video_label.GetShortVideoVideoLabelRsp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        this.a.a(paramArrayOfByte);
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
 * Qualified Name:     afah
 * JD-Core Version:    0.7.0.1
 */