import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class ajyq
  implements ValueAnimation.AnimationUpdateListener
{
  public ajyq(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI, View paramView, int paramInt) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.s) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInteger.intValue());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.d = paramInteger.intValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.d != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.s = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajyq
 * JD-Core Version:    0.7.0.1
 */