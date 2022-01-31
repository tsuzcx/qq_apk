import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.RspBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.TinyInfo;

public class aeue
  extends ProtoUtils.AppProtocolObserver
{
  public aeue(NearbyFaceScoreManager paramNearbyFaceScoreManager, FaceScoreCallBack paramFaceScoreCallBack) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramBundle = new oidb_0x8da.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle.rpt_msg_tiny_info.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          paramBundle = (oidb_0x8da.TinyInfo)paramArrayOfByte.next();
          if (paramBundle.uint32_result.get() == 0) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(paramBundle.uint64_uin.get(), paramBundle.uint64_tinyid.get());
          }
        }
        else
        {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      QLog.e("Q..troop.faceScore", 2, "getTinyIdByUin oidb_0x8da onResult  uin=" + paramBundle.uint64_uin.get() + " tinyid=" + paramBundle.uint64_tinyid.get() + " result=" + paramBundle.uint32_result.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeue
 * JD-Core Version:    0.7.0.1
 */