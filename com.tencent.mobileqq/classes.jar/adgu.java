import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adgu
  implements View.OnClickListener
{
  public adgu(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.app != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(this.a.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_uin", this.a.app.getAccount());
      localIntent.putExtra("extra_choose_friend_name", this.a.app.getCurrentNickname());
      this.a.setResult(-1, localIntent);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgu
 * JD-Core Version:    0.7.0.1
 */