import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class afdp
  implements BusinessObserver
{
  public afdp(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        ((NearbyCardManager)this.a.a.app.getManager(105)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label581;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (QLog.isColorLevel()) {
          QLog.i("NearbyProfileDisplayPanel", 2, "retCode = [" + paramInt + "]");
        }
        if (paramInt == 0) {
          break label296;
        }
        paramBundle = paramBundle.optString("msg");
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.a.a, 1, "" + paramBundle, 1).a();
          return;
        }
        QQToast.a(this.a.a, 1, "操作失败，请稍后重试", 1).a();
        return;
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this.a.a, 1, "未知异常，请稍后重试", 1).a();
        if (!QLog.isColorLevel()) {
          break label618;
        }
      }
      QLog.e("NearbyProfileDisplayPanel", 2, "未知异常，请稍后重试", paramBundle);
      return;
      label296:
      if (paramBundle.optInt("retcode") == 0)
      {
        paramBundle = this.a;
        if (NearbyProfileDisplayPanel.a(this.a)) {
          break label619;
        }
        paramBoolean = true;
        NearbyProfileDisplayPanel.a(paramBundle, paramBoolean);
        localObject = this.a.a;
        if (!NearbyProfileDisplayPanel.a(this.a)) {
          break label624;
        }
      }
    }
    label581:
    label618:
    label619:
    label624:
    for (paramBundle = "关注成功";; paramBundle = "已取消关注")
    {
      QQToast.a((Context)localObject, 2, paramBundle, 1).a();
      ((NowSmallVideoHandler)this.a.a.app.a(119)).a(1000, true, new Object[] { Boolean.valueOf(NearbyProfileDisplayPanel.a(this.a)), NearbyProfileDisplayPanel.a(this.a).uin });
      NearbyProfileDisplayPanel.a(this.a, 1, 60);
      if ((!NearbyProfileDisplayPanel.a(this.a)) && (NearbyProfileDisplayPanel.b(this.a).getChildAt(2).getVisibility() != 0))
      {
        paramBundle = (Button)NearbyProfileDisplayPanel.b(this.a).getChildAt(1).findViewById(2131365251);
        paramBundle.setTextColor(this.a.a.getResources().getColor(2131494236));
        paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130842852));
      }
      if (NearbyProfileDisplayPanel.a(this.a))
      {
        paramBundle = (Button)NearbyProfileDisplayPanel.b(this.a).getChildAt(1).findViewById(2131365251);
        paramBundle.setTextColor(this.a.a.getResources().getColor(2131494238));
        paramBundle.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130838525));
        return;
        QQToast.a(this.a.a, 1, "操作失败，请稍后重试", 1).a();
        return;
        QQToast.a(this.a.a, 1, "操作失败，请稍后重试", 1).a();
      }
      return;
      paramBoolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdp
 * JD-Core Version:    0.7.0.1
 */