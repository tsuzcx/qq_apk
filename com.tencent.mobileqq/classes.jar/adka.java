import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adka
  implements View.OnClickListener
{
  public adka(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    AuthDevActivity.h(this.a);
    Intent localIntent = new Intent(this.a, AuthDevOpenUgActivity.class);
    localIntent.putExtra("DevlockInfo", AuthDevActivity.a(this.a));
    this.a.startActivityForResult(localIntent, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adka
 * JD-Core Version:    0.7.0.1
 */