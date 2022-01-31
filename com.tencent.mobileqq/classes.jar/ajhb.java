import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class ajhb
  implements CompoundButton.OnCheckedChangeListener
{
  public ajhb(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("口算开关状态改变 ");
      if (!paramBoolean) {
        break label71;
      }
    }
    label71:
    for (paramCompoundButton = "on";; paramCompoundButton = "off")
    {
      QLog.d("PublishHomeWorkFragment", 2, paramCompoundButton);
      PublishHomeWorkFragment.c(this.a, paramBoolean);
      if (PublishHomeWorkFragment.e(this.a)) {
        PublishHomeWorkFragment.a(this.a).setChecked(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhb
 * JD-Core Version:    0.7.0.1
 */