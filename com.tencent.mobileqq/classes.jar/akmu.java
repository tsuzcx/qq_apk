import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;

public class akmu
  implements ValueAnimation.AnimationUpdateListener
{
  public akmu(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.a.b(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmu
 * JD-Core Version:    0.7.0.1
 */