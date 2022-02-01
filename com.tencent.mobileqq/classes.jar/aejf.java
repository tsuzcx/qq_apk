import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class aejf
  extends bdpx
{
  WeakReference<afen> a;
  WeakReference<View> b;
  
  aejf(afen paramafen, View paramView)
  {
    this.a = new WeakReference(paramafen);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    afen localafen = (afen)this.a.get();
    View localView = (View)this.b.get();
    if ((localafen != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localafen, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejf
 * JD-Core Version:    0.7.0.1
 */