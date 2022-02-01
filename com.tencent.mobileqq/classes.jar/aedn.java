import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aedn
  extends bggc
{
  public aedn(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void handlePendantAuth(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("pendantId");
    String str = paramObject.getString("uin");
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "handlePendantAuth isSuccess:" + paramBoolean + " pendantId:" + l + " uin:" + str);
    }
    if ((l == -1L) || (str == null)) {
      return;
    }
    if (paramBoolean)
    {
      amsw localamsw = (amsw)this.a.app.getManager(51);
      ExtensionInfo localExtensionInfo = localamsw.a(str);
      paramObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramObject = new ExtensionInfo();
        paramObject.uin = str;
      }
      paramObject.pendantId = l;
      paramObject.timestamp = System.currentTimeMillis();
      localamsw.a(paramObject);
      if (!TextUtils.isEmpty(this.a.f)) {
        QQToast.a(this.a.app.getApp(), 2, this.a.f, 0).a();
      }
      this.a.finish();
      return;
    }
    int i = paramObject.getInt("result");
    if (NetworkUtil.isNetSupport(this.a))
    {
      paramObject = "4";
      switch (i)
      {
      default: 
        label225:
        i = -1;
      }
    }
    for (;;)
    {
      if ((i != -1) && (QLog.isColorLevel())) {
        QLog.e("Q.BabyQ", 2, "handlePendantAuth error:" + i + paramObject);
      }
      QQToast.a(this.a.app.getApp(), 1, amtj.a(2131712558), 0).a();
      break;
      paramObject = "3";
      break label225;
      i = 2131716359;
      continue;
      paramObject = "0";
      i = 2131716360;
      continue;
      paramObject = "1";
      i = 2131716361;
      continue;
      paramObject = "2";
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedn
 * JD-Core Version:    0.7.0.1
 */