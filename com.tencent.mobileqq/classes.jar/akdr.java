import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class akdr
  implements View.OnClickListener
{
  public akdr(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.a(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdr
 * JD-Core Version:    0.7.0.1
 */