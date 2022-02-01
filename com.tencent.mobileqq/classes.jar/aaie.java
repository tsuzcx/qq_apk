import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class aaie
  implements ViewTreeObserver.OnPreDrawListener
{
  aaie(aaid paramaaid) {}
  
  public boolean onPreDraw()
  {
    aaid.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    aaid.a(this.a, aaid.a(this.a).getLeft(), aaid.a(this.a).getTop(), aaid.a(this.a).getWidth(), aaid.a(this.a).getHeight());
    QLog.d("TransitionAnimHelper", 4, new Object[] { "initImageEnterAnimation left:" + aaid.a(this.a).getLeft(), ",top:", Integer.valueOf(aaid.a(this.a).getTop()), ",width:", Integer.valueOf(aaid.a(this.a).getWidth()), ",height:", Integer.valueOf(aaid.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaie
 * JD-Core Version:    0.7.0.1
 */