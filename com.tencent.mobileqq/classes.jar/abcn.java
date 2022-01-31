import android.view.animation.Transformation;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class abcn
  implements ValueAnimation.AnimationUpdateListener
{
  public abcn(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.b = paramFloat1.floatValue();
    this.a.jdField_a_of_type_Float = (1.1F - (paramFloat1.floatValue() - 1.0F));
    if (!this.a.jdField_a_of_type_Boolean) {
      this.a.b((int)(this.a.jdField_a_of_type_Int * paramFloat1.floatValue()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcn
 * JD-Core Version:    0.7.0.1
 */