import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class abhs
  extends aymo
{
  WeakReference<accg> a;
  WeakReference<View> b;
  
  abhs(accg paramaccg, View paramView)
  {
    this.a = new WeakReference(paramaccg);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    accg localaccg = (accg)this.a.get();
    View localView = (View)this.b.get();
    if ((localaccg != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localaccg, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhs
 * JD-Core Version:    0.7.0.1
 */