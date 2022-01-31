import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.concurrent.ConcurrentHashMap;

class aluq
  implements View.OnClickListener
{
  aluq(aluo paramaluo) {}
  
  public void onClick(View paramView)
  {
    aluo.a(this.a).put(aluo.a(this.a).a, Integer.valueOf(1));
    paramView = aluo.a(this.a).a();
    if (!bbfr.a(paramView, aluo.a(this.a).c))
    {
      if (!TextUtils.isEmpty(aluo.a(this.a).g))
      {
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", aluo.a(this.a).g);
        localIntent.putExtra("fromArkAppDownload", true);
        paramView.startActivity(localIntent);
      }
      aaep.a(aluo.a(this.a), -4, "need to download");
    }
    for (;;)
    {
      aluo.a(this.a).a();
      aluo.a(this.a).dismiss();
      aluo.a(this.a, null);
      return;
      aluo.a(this.a, aluo.a(this.a).a, aluo.a(this.a).b, aluo.a(this.a).c, aluo.a(this.a).d, aluo.a(this.a).e, aluo.a(this.a).f);
      aaep.a(aluo.a(this.a), aabk.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aluq
 * JD-Core Version:    0.7.0.1
 */