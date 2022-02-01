import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class aahh
  extends ntf
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    b(paramInt, paramArrayOfByte, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt);
  
  protected void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      a(false, 0L, 0L, 0);
      return;
    }
    paramBundle = new oidb_0x6d8.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (!paramBundle.group_space_rsp.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtocol", 2, "no group_space_rsp rsp.");
        }
        a(false, 0L, 0L, 0);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, 0L, 0L, 0);
      return;
    }
    paramArrayOfByte = (oidb_0x6d8.GetSpaceRspBody)paramBundle.group_space_rsp.get();
    a(true, paramArrayOfByte.uint64_total_space.get(), paramArrayOfByte.uint64_used_space.get(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahh
 * JD-Core Version:    0.7.0.1
 */