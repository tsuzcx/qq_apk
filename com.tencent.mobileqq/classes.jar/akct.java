import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;

public class akct
  implements ValueAnimation.AnimationUpdateListener
{
  public akct(WebViewTitlerBar paramWebViewTitlerBar, int paramInt) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInteger.intValue());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Int = paramInteger.intValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Int != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akct
 * JD-Core Version:    0.7.0.1
 */