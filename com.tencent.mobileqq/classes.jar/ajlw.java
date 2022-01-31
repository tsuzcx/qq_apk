import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.MayknowRecommendManager.7.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ajlw
  extends BroadcastReceiver
{
  ajlw(ajls paramajls) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "Broadcast onReceive " + paramContext);
      }
    } while ((!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) || (ajls.a(this.a) == null));
    ajls.a(this.a).post(new MayknowRecommendManager.7.1(this));
    ContactReportUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlw
 * JD-Core Version:    0.7.0.1
 */