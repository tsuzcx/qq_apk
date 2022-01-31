import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class akfi
  extends Animation
{
  akfi(akfe paramakfe, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramFloat = (float)(paramFloat * (0.5D + Math.sqrt(paramFloat) / 2.0D));
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = (this.jdField_a_of_type_Int - (int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
    if (paramFloat <= 0.4F) {
      this.jdField_a_of_type_AndroidViewView.setAlpha((0.4F - Math.min(paramFloat, 0.4F)) / 0.4F);
    }
    do
    {
      do
      {
        return;
        if (paramFloat > 0.99F) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      return;
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */