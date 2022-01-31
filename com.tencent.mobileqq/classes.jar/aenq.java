import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class aenq
  implements View.OnClickListener
{
  aenq(aenp paramaenp) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aenp.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", aenp.a(this.a));
    aenp.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenq
 * JD-Core Version:    0.7.0.1
 */