import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class agli
  extends Animation
{
  private float jdField_a_of_type_Float;
  private float b;
  
  agli(agle paramagle) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f2 = 1.5F;
    float f1 = 0.0F;
    if (paramFloat < this.jdField_a_of_type_Agle.jdField_a_of_type_Float * 5.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      paramTransformation.setAlpha(f1);
      paramTransformation.getMatrix().setScale(paramFloat, paramFloat, this.jdField_a_of_type_Float, this.b);
      return;
      if (paramFloat < 13.0F * this.jdField_a_of_type_Agle.jdField_a_of_type_Float)
      {
        f1 = 0.5F - (paramFloat - this.jdField_a_of_type_Agle.jdField_a_of_type_Float * 5.0F) / (this.jdField_a_of_type_Agle.jdField_a_of_type_Float * 8.0F) * 0.5F;
        paramFloat = 1.5F + (paramFloat - this.jdField_a_of_type_Agle.jdField_a_of_type_Float * 5.0F) / (this.jdField_a_of_type_Agle.jdField_a_of_type_Float * 8.0F) * 0.5F;
      }
      else
      {
        paramFloat = 2.0F;
      }
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (paramInt1 * 0.5F);
    this.b = (paramInt2 * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agli
 * JD-Core Version:    0.7.0.1
 */