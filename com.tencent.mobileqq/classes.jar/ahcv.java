import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;

class ahcv
  extends ClickableSpan
{
  ahcv(ahcr paramahcr) {}
  
  public void onClick(View paramView)
  {
    if (!bhnv.d(this.a.a))
    {
      QQToast.a(this.a.a, anzj.a(2131702123), 2000).a();
      return;
    }
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcv
 * JD-Core Version:    0.7.0.1
 */