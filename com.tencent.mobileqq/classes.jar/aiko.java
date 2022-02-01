import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiko
  implements View.OnClickListener
{
  aiko(aikn paramaikn) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aikn.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://openmobile.qq.com/TeamGame/index.html?_wv=1031&uin=%s&team_id=%s&srcSessionType=%d&srcSessionUin=%s", new Object[] { aikn.a(this.a).getAccount(), aikn.a(this.a), Integer.valueOf(avhf.a(aikn.a(this.a).curType)), aikn.a(this.a).curFriendUin }));
    aikn.a(this.a).startActivity(localIntent);
    bjgx.a().a(aikn.a(this.a).getCurrentAccountUin(), "", "", "2000", "2016", "0", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiko
 * JD-Core Version:    0.7.0.1
 */