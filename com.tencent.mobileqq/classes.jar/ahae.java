import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ahae
  implements View.OnClickListener
{
  ahae(ahad paramahad) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ahad.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", ahad.a(this.a));
    ahad.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahae
 * JD-Core Version:    0.7.0.1
 */