import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.qphone.base.util.QLog;

class alcs
  implements bggr
{
  alcs(alcr paramalcr, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e(alcr.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onError  identifier=" + this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((alcd)this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((alcd)this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + this.jdField_a_of_type_ArrayOfByte.length + ", s info=" + paramString);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onError(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.e(alcr.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onSuccess  startParam_.identifier=" + this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((alcd)this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((alcd)this.jdField_a_of_type_Alcr.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + paramArrayOfByte.length + ", bytes.length=" + this.jdField_a_of_type_ArrayOfByte.length);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcs
 * JD-Core Version:    0.7.0.1
 */