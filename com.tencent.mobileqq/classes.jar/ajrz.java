import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.qphone.base.util.QLog;

public final class ajrz
  extends MessageObserver
{
  public void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramStatictisInfo.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramStatictisInfo.b);
      localStringBuilder.append("retryCount: " + paramStatictisInfo.c);
      localStringBuilder.append("detailErrorReason: " + paramStatictisInfo.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramStatictisInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */