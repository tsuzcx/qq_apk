import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.qphone.base.util.QLog;

class ajlg
  implements begt
{
  ajlg(ajlf paramajlf, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e(ajlf.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onError  identifier=" + this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((ajkr)this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((ajkr)this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + this.jdField_a_of_type_ArrayOfByte.length + ", s info=" + paramString);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onError(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.e(ajlf.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onSuccess  startParam_.identifier=" + this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((ajkr)this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((ajkr)this.jdField_a_of_type_Ajlf.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + paramArrayOfByte.length + ", bytes.length=" + this.jdField_a_of_type_ArrayOfByte.length);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlg
 * JD-Core Version:    0.7.0.1
 */