import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aeyk
  implements View.OnClickListener
{
  aeyk(aeyj paramaeyj) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aeyj.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", aeyj.a(this.a));
    aeyj.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyk
 * JD-Core Version:    0.7.0.1
 */