import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class adot
  extends ClickableSpan
{
  adot(adop paramadop) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.d(this.a.a))
    {
      bcql.a(this.a.a, ajya.a(2131703235), 2000).a();
      return;
    }
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adot
 * JD-Core Version:    0.7.0.1
 */