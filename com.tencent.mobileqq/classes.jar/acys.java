import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class acys
  extends bakk
{
  WeakReference<adto> a;
  WeakReference<View> b;
  
  acys(adto paramadto, View paramView)
  {
    this.a = new WeakReference(paramadto);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    adto localadto = (adto)this.a.get();
    View localView = (View)this.b.get();
    if ((localadto != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localadto, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acys
 * JD-Core Version:    0.7.0.1
 */