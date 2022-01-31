import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class agdu
  implements ValueAnimation.AnimationUpdateListener
{
  public agdu(ProfileTagView paramProfileTagView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramTransformation = this.a.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getLayoutParams();
    if (paramTransformation != null)
    {
      paramTransformation.height = paramInteger.intValue();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setLayoutParams(paramTransformation);
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramInteger = (FrameLayout)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if ((paramInteger != null) && (paramInteger.getChildCount() > 0))
        {
          paramInteger = paramInteger.getChildAt(0);
          if (paramInteger != null)
          {
            paramInteger = paramInteger.getBackground();
            if ((paramInteger instanceof BitmapDrawable))
            {
              int j = (int)(255.0F * paramFloat);
              int i = j;
              if (paramValueAnimation == this.a.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation) {
                i = 255 - j;
              }
              paramInteger.setAlpha(i);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdu
 * JD-Core Version:    0.7.0.1
 */