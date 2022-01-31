import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import mqq.os.MqqHandler;

public class aksd
  implements TicketUtils.TicketCallback
{
  public aksd(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle, long paramLong, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    ThreadManager.getSubThreadHandler().post(new aksf(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1");
    ThreadManager.getSubThreadHandler().post(new akse(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aksd
 * JD-Core Version:    0.7.0.1
 */