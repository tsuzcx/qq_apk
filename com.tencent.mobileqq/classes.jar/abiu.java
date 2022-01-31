import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity;

public class abiu
  implements CompoundButton.OnCheckedChangeListener
{
  public abiu(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.a);
    if (paramBoolean) {}
    for (paramCompoundButton = paramCompoundButton.getColorStateList(2131493372);; paramCompoundButton = paramCompoundButton.getColorStateList(2131493369))
    {
      localTextView.setTextColor(paramCompoundButton);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abiu
 * JD-Core Version:    0.7.0.1
 */