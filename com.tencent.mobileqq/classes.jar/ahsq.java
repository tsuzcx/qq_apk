import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahsq
  implements View.OnClickListener
{
  ahsq(ahsp paramahsp) {}
  
  public void onClick(View paramView)
  {
    MessageForStarLeague localMessageForStarLeague = (MessageForStarLeague)((ahsr)agej.a(paramView)).a;
    if (!axev.a((BaseActivity)paramView.getContext(), localMessageForStarLeague.actionUrl, localMessageForStarLeague))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", localMessageForStarLeague.actionUrl);
      paramView.getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsq
 * JD-Core Version:    0.7.0.1
 */