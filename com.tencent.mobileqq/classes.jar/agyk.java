import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;

class agyk
  implements View.OnClickListener
{
  agyk(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(agxq.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("uin", ((QQAppInterface)agxq.a(this.a).getAppRuntime()).getCurrentAccountUin());
    paramView = (Pair)paramView.getTag();
    if (paramView != null) {
      agxq.a(this.a).startActivity(localIntent.putExtra("url", "https://qzs.qq.com/iot/mobile/xiaowei-qq-proxy/index.html?din=" + ((Long)paramView.first).longValue() + "&deviceRemark=" + (String)paramView.second));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyk
 * JD-Core Version:    0.7.0.1
 */