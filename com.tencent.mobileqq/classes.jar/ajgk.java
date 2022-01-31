import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.WheelPickListener;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

public class ajgk
  implements VerticalGallery.OnEndMovementListener
{
  private int jdField_a_of_type_Int;
  
  public ajgk(WheelPickerLayout paramWheelPickerLayout, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    int i = WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout)[this.jdField_a_of_type_Int].getSelectedItemPosition();
    if (WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout) != null) {
      WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).a(this.jdField_a_of_type_Int, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajgk
 * JD-Core Version:    0.7.0.1
 */