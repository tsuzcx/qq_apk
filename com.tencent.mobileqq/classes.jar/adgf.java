import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adgf
  implements View.OnClickListener
{
  public adgf(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AddFriendVerifyActivity.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgf
 * JD-Core Version:    0.7.0.1
 */