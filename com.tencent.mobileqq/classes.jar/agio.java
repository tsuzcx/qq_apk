import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agio
  extends Animation
{
  float jdField_a_of_type_Float;
  float b;
  
  public agio(ScanTorchActivity paramScanTorchActivity) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat < 0.382F) {}
    for (float f = 1.0F + paramFloat / 0.382F * 0.382F;; f = 1.382F - (paramFloat - 0.382F) / 0.618F * 0.382F)
    {
      paramTransformation.getMatrix().setScale(f, f, this.jdField_a_of_type_Float / 2.0F, this.b / 2.0F);
      super.applyTransformation(paramFloat, paramTransformation);
      return;
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agio
 * JD-Core Version:    0.7.0.1
 */