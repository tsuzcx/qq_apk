import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class aamf
  implements ViewTreeObserver.OnPreDrawListener
{
  aamf(aame paramaame) {}
  
  public boolean onPreDraw()
  {
    aame.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    aame.a(this.a, aame.a(this.a).getLeft(), aame.a(this.a).getTop(), aame.a(this.a).getWidth(), aame.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + aame.a(this.a).getLeft(), ",top:", Integer.valueOf(aame.a(this.a).getTop()), ",width:", Integer.valueOf(aame.a(this.a).getWidth()), ",height:", Integer.valueOf(aame.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamf
 * JD-Core Version:    0.7.0.1
 */