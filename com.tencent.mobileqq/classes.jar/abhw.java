import android.view.View;
import com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback.1;
import mqq.util.WeakReference;

public class abhw
  extends aymm
{
  WeakReference<acck> a;
  WeakReference<View> b;
  
  abhw(acck paramacck, View paramView)
  {
    this.a = new WeakReference(paramacck);
    this.b = new WeakReference(paramView);
  }
  
  public boolean a(int paramInt)
  {
    acck localacck = (acck)this.a.get();
    View localView = (View)this.b.get();
    if ((localacck != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localacck, localView));
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhw
 * JD-Core Version:    0.7.0.1
 */