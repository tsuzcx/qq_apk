import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class aecq
  extends beip
{
  WeakReference<aexr> a;
  WeakReference<View> b;
  
  aecq(aexr paramaexr, View paramView)
  {
    this.a = new WeakReference(paramaexr);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    aexr localaexr = (aexr)this.a.get();
    View localView = (View)this.b.get();
    if ((localaexr != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localaexr, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecq
 * JD-Core Version:    0.7.0.1
 */