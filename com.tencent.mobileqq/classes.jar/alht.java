import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import mqq.os.MqqHandler;

public class alht
  implements TicketUtils.TicketCallback
{
  public alht(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle, long paramLong, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    ThreadManager.getSubThreadHandler().post(new alhv(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1");
    ThreadManager.getSubThreadHandler().post(new alhu(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alht
 * JD-Core Version:    0.7.0.1
 */