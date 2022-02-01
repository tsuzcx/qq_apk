import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

class aled
  implements View.OnClickListener
{
  aled(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aldh.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("uin", ((QQAppInterface)aldh.a(this.a).getAppRuntime()).getCurrentAccountUin());
    Pair localPair = (Pair)paramView.getTag();
    if (localPair != null) {
      aldh.a(this.a).startActivity(localIntent.putExtra("url", "https://qzs.qq.com/iot/mobile/xiaowei-qq-proxy/index.html?din=" + ((Long)localPair.first).longValue() + "&deviceRemark=" + (String)localPair.second));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aled
 * JD-Core Version:    0.7.0.1
 */