import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class aanu
  implements aanv
{
  private aanu(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAppModuleReg.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, "permission.CONNECTION_TYPE")) {
      return false;
    }
    if (!AppNetConnInfo.isNetSupport()) {
      paramVariantWrapper.SetString("none");
    }
    for (;;)
    {
      return true;
      if (AppNetConnInfo.isWifiConn())
      {
        paramVariantWrapper.SetString("wifi");
      }
      else if (AppNetConnInfo.isMobileConn())
      {
        int i = AppNetConnInfo.getMobileInfo();
        if (i == 0) {
          paramVariantWrapper.SetString("none");
        } else if (-1 == i) {
          paramVariantWrapper.SetString("other");
        } else {
          paramVariantWrapper.SetString("cellular");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aanu
 * JD-Core Version:    0.7.0.1
 */