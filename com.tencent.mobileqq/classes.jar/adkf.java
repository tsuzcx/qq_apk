import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.RspBody;

public final class adkf
  extends ProtoUtils.TroopProtocolObserver
{
  public adkf(TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback paramTroopFileWhiteListCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      paramBundle = new oidb_0x6e7.RspBody();
    }
    do
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "is_white = " + paramBundle.uint32_is_white.get() + ", req_interval = " + paramBundle.uint32_interval.get());
        }
        if (this.a != null) {
          this.a.a(paramBundle.uint32_is_white.get(), paramBundle.uint32_interval.get());
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(paramArrayOfByte));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "requestWhiteList() errorCode = " + paramInt);
      }
    } while (this.a == null);
    this.a.a(0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adkf
 * JD-Core Version:    0.7.0.1
 */