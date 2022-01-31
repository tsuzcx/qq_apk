import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class akdx
  extends BroadcastReceiver
{
  public akdx(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.l) {
      QLog.i("QQAppInterface", 1, "qzoneBrocastReceiver release() has been called  ,return ", null);
    }
    do
    {
      int i;
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (!"com.tencent.qzone.cleanunreadcount".equals(paramContext)) {
          break;
        }
        i = paramIntent.getIntExtra("clean_unread_feed_type", -1);
        paramContext = (axcj)this.a.getManager(10);
      } while ((paramContext == null) || (i == -1));
      paramContext.a(i, 0L, new ArrayList(), null, false, false, "");
      return;
    } while (!"com.tecent.qzone.clearAlbumRedTouch".equals(paramContext));
    ((avfc)this.a.getManager(104)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akdx
 * JD-Core Version:    0.7.0.1
 */