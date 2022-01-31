import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager.ReqNowLiveStatusCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class agew
  implements BusinessObserver
{
  public agew(NowAnswerPreloadManager.ReqNowLiveStatusCallback paramReqNowLiveStatusCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      try
      {
        QLog.i("NowAnswerPreloadManager", 3, "reqNowLiveStatusAndOpenRoom----SSO request Success");
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new WebSsoBody.WebSsoResponseBody();
          paramBundle.mergeFrom((byte[])localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", paramBundle.data.get());
          ((JSONObject)localObject).put("retcode", paramBundle.ret.get());
          ((JSONObject)localObject).put("cret", 0);
          NowAnswerPreloadManager.a((JSONObject)localObject, this.a);
          return;
        }
        if (this.a == null) {
          return;
        }
        this.a.a(false);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.i("NowAnswerPreloadManager", 3, "reqNowLiveStatusAndOpenRoom----SSO request Exception e = " + paramBundle.getMessage());
        if (this.a == null) {
          return;
        }
      }
      this.a.a(false);
    }
    else
    {
      QLog.i("NowAnswerPreloadManager", 3, "reqNowLiveStatusAndOpenRoom----SSO requset Error");
      if (this.a != null) {
        this.a.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agew
 * JD-Core Version:    0.7.0.1
 */