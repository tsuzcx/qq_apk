import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acxd
  implements View.OnClickListener
{
  public acxd(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.app != null)
    {
      paramView = new Intent();
      paramView.putExtras(this.a.getIntent().getExtras());
      paramView.putExtra("extra_choose_friend_uin", this.a.app.getAccount());
      paramView.putExtra("extra_choose_friend_name", this.a.app.getCurrentNickname());
      this.a.setResult(-1, paramView);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxd
 * JD-Core Version:    0.7.0.1
 */