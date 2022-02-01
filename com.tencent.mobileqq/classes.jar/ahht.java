import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahht
  implements View.OnClickListener
{
  ahht(ahhs paramahhs) {}
  
  public void onClick(View paramView)
  {
    MessageForStarLeague localMessageForStarLeague = (MessageForStarLeague)((ahhu)AIOUtils.getHolder(paramView)).a;
    if (!awyd.a((BaseActivity)paramView.getContext(), localMessageForStarLeague.actionUrl, localMessageForStarLeague))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", localMessageForStarLeague.actionUrl);
      paramView.getContext().startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahht
 * JD-Core Version:    0.7.0.1
 */