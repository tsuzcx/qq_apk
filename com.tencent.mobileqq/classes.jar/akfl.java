import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class akfl
  extends BroadcastReceiver
{
  public akfl(SnapshotService paramSnapshotService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("id", -1L);
    int i = paramIntent.getIntExtra("action", -1);
    if ((l == 0L) && (i == 1) && (SnapshotService.a(this.a) > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i(SnapshotService.a(), 2, "receive broadcast: destroy snapshot service");
      }
      SnapshotService.a(false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfl
 * JD-Core Version:    0.7.0.1
 */