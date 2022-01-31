import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.widget.DynamicGridView;

class ambg
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  ambg(ambf paramambf, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Ambf.a.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.jdField_a_of_type_Ambf.a, DynamicGridView.a(this.jdField_a_of_type_Ambf.a) + ambf.a(this.jdField_a_of_type_Ambf));
    DynamicGridView.b(this.jdField_a_of_type_Ambf.a, DynamicGridView.b(this.jdField_a_of_type_Ambf.a) + ambf.b(this.jdField_a_of_type_Ambf));
    if (DynamicGridView.a(this.jdField_a_of_type_Ambf.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Ambf.a).setVisibility(0);
    }
    DynamicGridView.a(this.jdField_a_of_type_Ambf.a, this.jdField_a_of_type_Ambf.a.a(DynamicGridView.a(this.jdField_a_of_type_Ambf.a)));
    if (DynamicGridView.a(this.jdField_a_of_type_Ambf.a) != null) {
      DynamicGridView.a(this.jdField_a_of_type_Ambf.a).setVisibility(4);
    }
    DynamicGridView.a(this.jdField_a_of_type_Ambf.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambg
 * JD-Core Version:    0.7.0.1
 */