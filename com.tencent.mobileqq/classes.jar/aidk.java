import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.LogTag;

public class aidk
  extends MessageObserver
{
  public aidk(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    LogTag.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aidk
 * JD-Core Version:    0.7.0.1
 */