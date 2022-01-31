import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class afhv
  implements View.OnClickListener
{
  public afhv(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (aknx.a(this.a.a.getApplication()))
    {
      ApolloUtil.a(paramView.getContext(), null, "aio", aliu.ah, null);
      return;
    }
    if (!aknx.b(this.a.a.getApplication())) {}
    for (String str = aliu.U;; str = aliu.V + bimq.b)
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), str, -1L, localIntent, false, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhv
 * JD-Core Version:    0.7.0.1
 */