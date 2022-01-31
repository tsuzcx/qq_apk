import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.concurrent.ConcurrentHashMap;

class algd
  implements View.OnClickListener
{
  algd(algb paramalgb) {}
  
  public void onClick(View paramView)
  {
    algb.a(this.a).put(algb.a(this.a).a, Integer.valueOf(1));
    paramView = algb.a(this.a).a();
    if (!bady.a(paramView, algb.a(this.a).c))
    {
      if (!TextUtils.isEmpty(algb.a(this.a).g))
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", algb.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        paramView.startActivity(localIntent);
      }
      zva.a(algb.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      algb.a(this.a).a();
      algb.a(this.a).dismiss();
      algb.a(this.a, null);
      return;
      algb.a(this.a, algb.a(this.a).a, algb.a(this.a).b, algb.a(this.a).c, algb.a(this.a).d, algb.a(this.a).e, algb.a(this.a).f);
      zva.a(algb.a(this.a), zrv.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     algd
 * JD-Core Version:    0.7.0.1
 */