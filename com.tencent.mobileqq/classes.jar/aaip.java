import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import java.util.HashMap;
import java.util.Locale;
import oicq.wlogin_sdk.tools.util;

class aaip
  implements Runnable
{
  aaip(aaio paramaaio, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, String paramString) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper1 = this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.a(this.jdField_a_of_type_Aaio.jdField_a_of_type_Long);
    if (localVariantWrapper1 == null)
    {
      ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ, null);
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = util.buf_to_string(this.jdField_a_of_type_ArrayOfByte);
      String str1 = util.buf_to_string(this.b);
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"openid\":\"%s\",\"token\":\"%s\"}", new Object[] { localObject, str1 }));
      String str2 = this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long + "_" + this.jdField_a_of_type_JavaLangString;
      ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ).put(str2, localObject);
      ArkAppModuleReg.ModuleQQ.b(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ).put(str2, str1);
      ArkAppModuleReg.ModuleQQ.c(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ).put(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Long));
    }
    for (;;)
    {
      localObject = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, (ark.VariantWrapper)localObject);
      ((ark.VariantWrapper)localObject).Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_Aaio.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ, null);
      return;
      localVariantWrapper2.SetNull();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaip
 * JD-Core Version:    0.7.0.1
 */