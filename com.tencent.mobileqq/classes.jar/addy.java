import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x48.RecommendDeviceLock;

public class addy
  implements adci
{
  private static void a(adan paramadan, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x48");
    }
    RecommendDeviceLock localRecommendDeviceLock = new RecommendDeviceLock();
    try
    {
      localRecommendDeviceLock.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new Intent();
      paramMsgType0x210.putExtra("canCancel", localRecommendDeviceLock.canCancel.get());
      paramMsgType0x210.putExtra("tipMsg", localRecommendDeviceLock.wording.get());
      paramMsgType0x210.putExtra("title", localRecommendDeviceLock.str_title.get());
      paramMsgType0x210.putExtra("secondTitle", localRecommendDeviceLock.str_second_title.get());
      paramMsgType0x210.putExtra("thirdTitle", localRecommendDeviceLock.str_third_title.get());
      List localList = localRecommendDeviceLock.str_wording_list.get();
      ArrayList localArrayList = new ArrayList();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      paramMsgType0x210.putStringArrayListExtra("wordsList", localArrayList);
      paramadan.a().setDevLockIntent(paramMsgType0x210);
      paramadan.a(8007, true, new Object[] { Boolean.valueOf(localRecommendDeviceLock.canCancel.get()), localRecommendDeviceLock.wording.get(), localRecommendDeviceLock.str_title.get(), localRecommendDeviceLock.str_second_title.get(), localRecommendDeviceLock.str_third_title.get(), localArrayList });
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x48");
      }
      paramadan.a(8007, false, new Object[] { Boolean.valueOf(true), "" });
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addy
 * JD-Core Version:    0.7.0.1
 */