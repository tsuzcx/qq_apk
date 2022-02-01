import android.view.View;

public class aazx
  implements abab
{
  private float jdField_a_of_type_Float = 0.8F;
  private aazv jdField_a_of_type_Aazv = aazv.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private aazv jdField_b_of_type_Aazv = aazv.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Aazv.a(paramView);
    this.jdField_b_of_type_Aazv.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazx
 * JD-Core Version:    0.7.0.1
 */