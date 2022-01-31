import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class aakh
  extends BroadcastReceiver
{
  public aakh(WorldCupMgr paramWorldCupMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    while ((!"tencent.businessnotify.qq.to.subprocess".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("bussinessType", 0) != 2)) {
      return;
    }
    switch (paramIntent.getIntExtra("event", 0))
    {
    default: 
      return;
    case 1: 
      int i = paramIntent.getIntExtra("download_Index", 0);
      int j = paramIntent.getIntExtra("download_Progress", 0);
      if (AudioHelper.e()) {
        QLog.w("WorldCupMgr", 1, "receive notify, index[" + i + "], progress[" + j + "]");
      }
      this.a.a(i, j);
      return;
    }
    paramContext = paramIntent.getStringExtra("config_Content");
    this.a.c(paramContext);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakh
 * JD-Core Version:    0.7.0.1
 */