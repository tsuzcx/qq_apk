import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.DataMigrationService;

public class ajuv
  extends Handler
{
  public ajuv(DataMigrationService paramDataMigrationService) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    paramMessage = (Intent)paramMessage.obj;
    if (paramMessage == null)
    {
      this.a.stopSelf(i);
      return;
    }
    if ("com.tencent.mobileqq.action.MIGRATION_DATA".equals(paramMessage.getAction()))
    {
      DataMigrationService.a(this.a, paramMessage, i);
      return;
    }
    this.a.stopSelf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajuv
 * JD-Core Version:    0.7.0.1
 */