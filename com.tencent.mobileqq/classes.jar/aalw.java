import android.view.View;

public class aalw
  implements aama
{
  private float jdField_a_of_type_Float = 0.8F;
  private aalu jdField_a_of_type_Aalu = aalu.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private aalu jdField_b_of_type_Aalu = aalu.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Aalu.a(paramView);
    this.jdField_b_of_type_Aalu.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalw
 * JD-Core Version:    0.7.0.1
 */