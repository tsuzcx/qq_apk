import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acub
  implements View.OnClickListener
{
  public acub(AuthDevEnableCompleteActivity paramAuthDevEnableCompleteActivity) {}
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131368367);
    if (localImageView != null)
    {
      int i = 0;
      if (localImageView.getVisibility() == 0) {
        i = 4;
      }
      localImageView.setVisibility(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acub
 * JD-Core Version:    0.7.0.1
 */