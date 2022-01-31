import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForStarLeague;

class afxm
  implements View.OnClickListener
{
  afxm(afxl paramafxl) {}
  
  public void onClick(View paramView)
  {
    MessageForStarLeague localMessageForStarLeague = (MessageForStarLeague)((afxn)aekt.a(paramView)).a;
    if (!auak.a((BaseActivity)paramView.getContext(), localMessageForStarLeague.actionUrl, localMessageForStarLeague))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", localMessageForStarLeague.actionUrl);
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxm
 * JD-Core Version:    0.7.0.1
 */