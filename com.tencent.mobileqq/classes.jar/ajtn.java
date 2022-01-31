import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public abstract class ajtn
  extends mxj
{
  public abstract void a(int paramInt, List<NowLiveGallary.RspBody.PhotoInfo> paramList);
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramArrayOfByte == null) {
      a(-1, null);
    }
    do
    {
      return;
      try
      {
        paramBundle = new NowLiveGallary.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle.photo_info_list.get();
        a(paramBundle.errCode.get(), paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "getNowOnliveGallary exception, e:" + paramArrayOfByte.getStackTrace());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtn
 * JD-Core Version:    0.7.0.1
 */