import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ConnectionCallback;

class aaoh
  implements ArkAppEventObserverManager.ConnectionCallback
{
  aaoh(aanw paramaanw, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_Aanw.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ArkAppDeviceModule.a(this.jdField_a_of_type_Aanw.a, this.jdField_a_of_type_Long, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoh
 * JD-Core Version:    0.7.0.1
 */