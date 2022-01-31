import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.concurrent.ConcurrentHashMap;

class alur
  implements View.OnClickListener
{
  alur(alup paramalup) {}
  
  public void onClick(View paramView)
  {
    alup.a(this.a).put(alup.a(this.a).a, Integer.valueOf(1));
    paramView = alup.a(this.a).a();
    if (!bbfd.a(paramView, alup.a(this.a).c))
    {
      if (!TextUtils.isEmpty(alup.a(this.a).g))
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", alup.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        paramView.startActivity(localIntent);
      }
      aaet.a(alup.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      alup.a(this.a).a();
      alup.a(this.a).dismiss();
      alup.a(this.a, null);
      return;
      alup.a(this.a, alup.a(this.a).a, alup.a(this.a).b, alup.a(this.a).c, alup.a(this.a).d, alup.a(this.a).e, alup.a(this.a).f);
      aaet.a(alup.a(this.a), aabo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alur
 * JD-Core Version:    0.7.0.1
 */