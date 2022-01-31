import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.test.MapTestHelper;

public class abax
  implements View.OnClickListener
{
  public abax(ARMapActivity paramARMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper = new MapTestHelper(this.a, this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView, new abay(this));
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abax
 * JD-Core Version:    0.7.0.1
 */