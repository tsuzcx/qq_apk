import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;

class ajgv
  implements View.OnClickListener
{
  ajgv(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ajgb.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("uin", ((QQAppInterface)ajgb.a(this.a).getAppRuntime()).getCurrentAccountUin());
    paramView = (Pair)paramView.getTag();
    if (paramView != null) {
      ajgb.a(this.a).startActivity(localIntent.putExtra("url", "https://qzs.qq.com/iot/mobile/xiaowei-qq-proxy/index.html?din=" + ((Long)paramView.first).longValue() + "&deviceRemark=" + (String)paramView.second));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgv
 * JD-Core Version:    0.7.0.1
 */