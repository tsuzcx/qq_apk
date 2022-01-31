import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class allq
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  allq(allp paramallp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Allp.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Allp.a, DynamicGridView.a(this.jdField_a_of_type_Allp.a) + allp.a(this.jdField_a_of_type_Allp));
    DynamicGridView.b(this.jdField_a_of_type_Allp.a, DynamicGridView.b(this.jdField_a_of_type_Allp.a) + allp.b(this.jdField_a_of_type_Allp));
    if (DynamicGridView.a(this.jdField_a_of_type_Allp.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Allp.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Allp.a, this.jdField_a_of_type_Allp.a.a(DynamicGridView.a(this.jdField_a_of_type_Allp.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Allp.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Allp.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Allp.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     allq
 * JD-Core Version:    0.7.0.1
 */