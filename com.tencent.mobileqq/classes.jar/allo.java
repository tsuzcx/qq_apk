import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class allo
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  allo(alln paramalln, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Alln.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Alln.a, DynamicGridView.a(this.jdField_a_of_type_Alln.a) + alln.a(this.jdField_a_of_type_Alln));
    DynamicGridView.b(this.jdField_a_of_type_Alln.a, DynamicGridView.b(this.jdField_a_of_type_Alln.a) + alln.b(this.jdField_a_of_type_Alln));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Alln.a, this.jdField_a_of_type_Alln.a.a(DynamicGridView.a(this.jdField_a_of_type_Alln.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Alln.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Alln.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Alln.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     allo
 * JD-Core Version:    0.7.0.1
 */