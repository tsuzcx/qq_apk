import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;

public class ajhd
  implements CompoundButton.OnCheckedChangeListener
{
  public ajhd(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    PublishHomeWorkFragment.a(this.a, paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhd
 * JD-Core Version:    0.7.0.1
 */