import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class adlk
  extends bdbp
{
  WeakReference<aegj> a;
  WeakReference<View> b;
  
  adlk(aegj paramaegj, View paramView)
  {
    this.a = new WeakReference(paramaegj);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    aegj localaegj = (aegj)this.a.get();
    View localView = (View)this.b.get();
    if ((localaegj != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localaegj, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlk
 * JD-Core Version:    0.7.0.1
 */