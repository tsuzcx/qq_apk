import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.PositionCallback;

class aaof
  implements ArkAppEventObserverManager.PositionCallback
{
  aaof(aaoe paramaaoe) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.a.a.a.jdField_a_of_type_Aanw.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ArkAppDeviceModule.a(this.a.a.a.jdField_a_of_type_Aanw.a, this.a.a.a.jdField_a_of_type_Long, paramBoolean, paramDouble1, paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaof
 * JD-Core Version:    0.7.0.1
 */