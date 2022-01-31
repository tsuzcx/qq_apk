import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class aavn
  implements aaup
{
  private aavn(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAppModuleReg.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, "permission.DEVICE_INFORMATION")) {}
    do
    {
      return false;
      if ("GetModelName".equals(paramString))
      {
        paramVariantWrapper.SetString(Build.MODEL);
        return true;
      }
      if ("GetScreenWidth".equals(paramString))
      {
        paramString = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
        paramVariantWrapper.SetInt((int)(paramString.widthPixels / paramString.density));
        return true;
      }
      if ("GetScreenHeight".equals(paramString))
      {
        paramString = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
        paramVariantWrapper.SetInt((int)(paramString.heightPixels / paramString.density));
        return true;
      }
      if ("GetPixelRatio".equals(paramString))
      {
        paramVariantWrapper.SetDouble(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density);
        return true;
      }
    } while (!"GetIdentifier".equals(paramString));
    paramArrayOfVariantWrapper = DeviceInfoUtil.a();
    paramString = paramArrayOfVariantWrapper;
    if (this.a.jdField_a_of_type_Long != 0L) {
      paramString = MD5Coding.encodeHexStr(paramArrayOfVariantWrapper);
    }
    paramVariantWrapper.SetString(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavn
 * JD-Core Version:    0.7.0.1
 */