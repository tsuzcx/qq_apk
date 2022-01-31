import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter.WeiyunCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;

public class adag
  implements IWeiyunCallback
{
  public adag(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunLogicCenter.WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Failed errorCode=" + paramInt + "; errorMsg=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter$WeiyunCallback.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Success");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter$WeiyunCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adag
 * JD-Core Version:    0.7.0.1
 */