import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity;

public class abpv
  implements CompoundButton.OnCheckedChangeListener
{
  public abpv(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.a);
    if (paramBoolean) {}
    for (paramCompoundButton = paramCompoundButton.getColorStateList(2131493375);; paramCompoundButton = paramCompoundButton.getColorStateList(2131493372))
    {
      localTextView.setTextColor(paramCompoundButton);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpv
 * JD-Core Version:    0.7.0.1
 */