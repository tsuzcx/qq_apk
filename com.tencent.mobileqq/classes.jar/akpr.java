import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.qphone.base.util.QLog;

public class akpr
  implements Animation.AnimationListener
{
  public akpr(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->on hideAnimationEnd!");
    }
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpr
 * JD-Core Version:    0.7.0.1
 */