import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class addh
  extends baot
{
  WeakReference<adyd> a;
  WeakReference<View> b;
  
  addh(adyd paramadyd, View paramView)
  {
    this.a = new WeakReference(paramadyd);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    adyd localadyd = (adyd)this.a.get();
    View localView = (View)this.b.get();
    if ((localadyd != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localadyd, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addh
 * JD-Core Version:    0.7.0.1
 */