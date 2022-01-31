import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x938.cmd0x938.ClientConfig;
import tencent.im.oidb.cmd0x938.cmd0x938.DataCardConfig;
import tencent.im.oidb.cmd0x938.cmd0x938.RspBody;

public class aelt
  extends ProtoUtils.AppProtocolObserver
{
  public aelt(NearbyFaceScoreManager paramNearbyFaceScoreManager, FaceScoreCallBack paramFaceScoreCallBack) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = true;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new cmd0x938.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (cmd0x938.ClientConfig)paramBundle.msg_client_config.get();
      boolean bool1;
      if (paramArrayOfByte.uint32_show_card.get() == 1)
      {
        bool1 = true;
        if (paramArrayOfByte.uint32_show_list.get() != 1) {
          break label208;
        }
      }
      for (;;)
      {
        long l = paramArrayOfByte.uint64_next_time.get();
        if (paramBundle.msg_datacard_config.has()) {
          ((cmd0x938.DataCardConfig)paramBundle.msg_datacard_config.get()).uint32_entry_ability.get();
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q..troop.faceScore", 2, "fetchGrayAbility onResult isShowCard=" + bool1 + "  isShowList=" + bool2 + "  expireTime=" + l);
        }
        paramArrayOfByte = new FaceScoreConfig(bool1, bool2, l, paramArrayOfByte.bytes_list_jump_url.get().toStringUtf8(), paramArrayOfByte.bytes_card_url_h.get().toStringUtf8(), paramArrayOfByte.bytes_card_url_g.get().toStringUtf8());
        this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(paramArrayOfByte);
        return;
        bool1 = false;
        break;
        label208:
        bool2 = false;
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
 * Qualified Name:     aelt
 * JD-Core Version:    0.7.0.1
 */