import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.channel.KSAppChannel;
import com.tencent.TMG.sdk.AVContext.StartParam;

public class ajlh
  extends KSAppChannel
{
  public static String a;
  public AVContext.StartParam a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "SSOChannel";
  }
  
  public long getTinyId()
  {
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier).longValue();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public boolean loginWithParam(AVContext.StartParam paramStartParam)
  {
    this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam = paramStartParam;
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.e(jdField_a_of_type_JavaLangString, 1, "requestAppCmd enter");
      if ((this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam instanceof ajkt))
      {
        begb.a().a(paramArrayOfByte, "", this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier, this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId, ((ajkt)this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int, ((ajkt)this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long, new ajli(this, paramArrayOfByte, paramCsCmdCallback));
        return true;
      }
      return false;
    }
    catch (NumberFormatException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("0", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramString.equals("VideoCCSvc.opensdk")) {
      return super.requestCmd(paramString, paramArrayOfByte, paramCsCmdCallback);
    }
    return super.requestCmd(paramString, paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("1", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramArrayOfByte.length >= 0) {
      return requestCmd("3", nativeConvertToIMReportData(paramArrayOfByte, paramInt, this.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId, getTinyId(), (int)System.currentTimeMillis() / 1000), paramCsCmdCallback);
    }
    com.tencent.TMG.utils.QLog.e(jdField_a_of_type_JavaLangString, 0, "requestReportCmd reportData == NULL");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajlh
 * JD-Core Version:    0.7.0.1
 */