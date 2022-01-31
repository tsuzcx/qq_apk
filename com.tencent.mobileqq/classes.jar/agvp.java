import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class agvp
  implements View.OnClickListener
{
  agvp(agvo paramagvo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(agvo.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", agvo.a(this.a));
    agvo.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvp
 * JD-Core Version:    0.7.0.1
 */