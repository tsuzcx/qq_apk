import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.POIExtarData;

public class abgr
  implements Runnable
{
  public abgr(ARGridMapViewDialog paramARGridMapViewDialog, ARGridMapViewDialog.POIExtarData paramPOIExtarData) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a.addObserver(ARGridMapViewDialog.a(this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog));
    ((ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog$POIExtarData.b, this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog$POIExtarData.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgr
 * JD-Core Version:    0.7.0.1
 */