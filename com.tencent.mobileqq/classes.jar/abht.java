import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class abht
  implements Runnable
{
  public abht(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine.updateLocationNative(this.a.jdField_a_of_type_Double, this.a.b, "", 0.0D, 1, "", 0, "");
    ARMapEngine localARMapEngine = this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine;
    ARMapEngine.nativeRequestPOIList();
    localARMapEngine = this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine;
    ARMapEngine.nativeRequestLbsPOIListByPid("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abht
 * JD-Core Version:    0.7.0.1
 */