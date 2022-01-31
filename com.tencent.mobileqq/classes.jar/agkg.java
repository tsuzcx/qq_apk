import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.entity.ThirdPartyApp;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class agkg
  extends MessageObserver
{
  public agkg(OpenApiManager paramOpenApiManager) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    a(false, paramString1, paramLong2);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    Intent localIntent;
    if (OpenApiManager.access$300(this.a).containsKey(Long.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Manager", 2, "onSendResult, isSuccess = " + paramBoolean + ", uniseq = " + paramLong);
      }
      paramString = (String)OpenApiManager.access$300(this.a).remove(Long.valueOf(paramLong));
      paramString = (ThirdPartyApp)OpenApiManager.access$200(this.a).get(paramString);
      if (paramString != null)
      {
        localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + paramString.b);
        localIntent.putExtra("msgid", paramString.a(String.valueOf(paramLong)));
        if (!paramBoolean) {
          break label171;
        }
      }
    }
    label171:
    for (int i = 0;; i = -9)
    {
      localIntent.putExtra("rs_code", i);
      BaseApplicationImpl.sApplication.sendBroadcast(localIntent, paramString.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agkg
 * JD-Core Version:    0.7.0.1
 */