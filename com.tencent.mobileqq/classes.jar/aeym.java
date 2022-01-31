import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aeym
  implements View.OnClickListener
{
  aeym(aeyl paramaeyl) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aeyl.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", aeyl.a(this.a));
    aeyl.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeym
 * JD-Core Version:    0.7.0.1
 */