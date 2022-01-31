import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;

public class airf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public airf(QzoneGameFloatView paramQzoneGameFloatView, View paramView, DisplayMetrics paramDisplayMetrics) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_ComTencentBizWebviewpluginHole.setHole((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.getLeft() + this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.getRight()) / 2 - 1, (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_AndroidViewView.getBottom()) / 2 - 1, (int)(30.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView.jdField_a_of_type_ComTencentBizWebviewpluginHole.invalidate();
      return;
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airf
 * JD-Core Version:    0.7.0.1
 */