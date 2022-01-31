import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;

public class ajhg
  implements View.OnFocusChangeListener
{
  public ajhg(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      PublishHomeWorkFragment.b(paramView, bool);
      if (paramBoolean) {
        PublishHomeWorkFragment.a(this.a, PublishHomeWorkFragment.a(this.a).a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhg
 * JD-Core Version:    0.7.0.1
 */