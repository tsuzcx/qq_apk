import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

public class abrl
  implements VerticalGallery.OnEndMovementListener
{
  private int jdField_a_of_type_Int;
  
  public abrl(IphonePickerView paramIphonePickerView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    int i = IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView)[this.jdField_a_of_type_Int].getSelectedItemPosition();
    if (IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView) != null) {
      IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).onItemSelected(this.jdField_a_of_type_Int, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abrl
 * JD-Core Version:    0.7.0.1
 */