import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aivs
  implements View.OnClickListener
{
  aivs(aivr paramaivr) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aivr.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", aivr.a(this.a));
    aivr.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivs
 * JD-Core Version:    0.7.0.1
 */