import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahqd
  implements View.OnClickListener
{
  ahqd(ahqc paramahqc) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ahqc.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", ahqc.a(this.a));
    ahqc.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqd
 * JD-Core Version:    0.7.0.1
 */