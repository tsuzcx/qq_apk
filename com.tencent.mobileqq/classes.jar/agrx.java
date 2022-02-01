import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class agrx
  extends ClickableSpan
{
  agrx(agrt paramagrt) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a.a))
    {
      QQToast.a(this.a.a, anvx.a(2131702709), 2000).a();
      return;
    }
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrx
 * JD-Core Version:    0.7.0.1
 */