import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.OrientationCallback;

class aany
  implements ArkAppEventObserverManager.OrientationCallback
{
  aany(aanw paramaanw, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_Aanw.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArkAppDeviceModule.a(this.jdField_a_of_type_Aanw.a, this.jdField_a_of_type_Long, paramBoolean, "Orientation", paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aany
 * JD-Core Version:    0.7.0.1
 */