import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class aaxz
  extends axmg
{
  WeakReference<abry> a;
  WeakReference<View> b;
  
  aaxz(abry paramabry, View paramView)
  {
    this.a = new WeakReference(paramabry);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    abry localabry = (abry)this.a.get();
    View localView = (View)this.b.get();
    if ((localabry != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localabry, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaxz
 * JD-Core Version:    0.7.0.1
 */