import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aidh
  extends ntf
{
  aidh(aidd paramaidd) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyChatPie", 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    if (paramInt == 0) {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = paramBundle.ret_code.get();
      paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
      int i = paramBundle.status.get();
      QLog.i("NearbyChatPie", 1, "ret_code: " + paramInt + ", err_msg: " + paramArrayOfByte + ", status: " + i);
      if (paramInt == 0)
      {
        paramArrayOfByte = this.a;
        if (i == 0) {
          bool = false;
        }
        paramArrayOfByte.h = bool;
      }
      this.a.a().post(new NearbyChatPie.14.1(this));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e(this.a.tag, 1, "pb parse error: " + paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidh
 * JD-Core Version:    0.7.0.1
 */