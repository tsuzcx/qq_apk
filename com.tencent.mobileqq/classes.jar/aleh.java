import android.view.View;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class aleh
  implements alec
{
  public View a;
  public TabDragAnimationView a;
  private boolean a;
  
  public aleh(TabDragAnimationView paramTabDragAnimationView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = paramTabDragAnimationView;
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView == null) || (this.jdField_a_of_type_AndroidViewView == null) || (!this.jdField_a_of_type_AndroidViewView.equals(paramView))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TabDragListener", 2, "drag detect x=" + paramFloat1 + ",y=" + paramFloat2 + ",dragType=" + paramInt);
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c();
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.a(paramFloat1, paramFloat2, false);
        return;
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleh
 * JD-Core Version:    0.7.0.1
 */