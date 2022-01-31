import android.view.View;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.IFocusChangeListener;

public class aitd
  implements XMediaEditor.IFocusChangeListener
{
  public aitd(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      PublishHomeWorkFragment.a(this.a, PublishHomeWorkFragment.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aitd
 * JD-Core Version:    0.7.0.1
 */