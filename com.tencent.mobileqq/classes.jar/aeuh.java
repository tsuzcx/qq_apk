import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;

public class aeuh
  implements View.OnClickListener
{
  public aeuh(SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new NowProxy();
    if (paramView.a())
    {
      paramView.a(null);
      return;
    }
    Object localObject = this.a.getActivity().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_startLive", "");
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "https://now.qq.com/qq/nearby/live.html?_wv=16777219&_bid=2452&from=50036";
    }
    localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    ((Intent)localObject).putExtra("reqType", 1);
    this.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeuh
 * JD-Core Version:    0.7.0.1
 */