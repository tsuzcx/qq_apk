import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForStarLeague;

class aeay
  implements View.OnClickListener
{
  aeay(aeax paramaeax) {}
  
  public void onClick(View paramView)
  {
    MessageForStarLeague localMessageForStarLeague = (MessageForStarLeague)((aeaz)actj.a(paramView)).a;
    if (!asjk.a((BaseActivity)paramView.getContext(), localMessageForStarLeague.actionUrl, localMessageForStarLeague))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", localMessageForStarLeague.actionUrl);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeay
 * JD-Core Version:    0.7.0.1
 */