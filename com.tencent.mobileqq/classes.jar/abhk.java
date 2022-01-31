import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARMapEngine;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;

public class abhk
  implements Runnable
{
  public abhk(ARMapPOIStarDialog paramARMapPOIStarDialog, ItemInfo paramItemInfo) {}
  
  public void run()
  {
    ARMapEngine.removePOITask(this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhk
 * JD-Core Version:    0.7.0.1
 */