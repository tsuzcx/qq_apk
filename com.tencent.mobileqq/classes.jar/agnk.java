import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agnk
  implements View.OnClickListener
{
  public agnk(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (amme.a(this.a.a.getApplication()))
    {
      ApolloUtil.a(paramView.getContext(), null, "aio", anka.u, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (!amme.c(this.a.a.getApplication())) {}
    for (String str = anka.h;; str = anka.i + blqp.b)
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), str, -1L, localIntent, false, -1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnk
 * JD-Core Version:    0.7.0.1
 */