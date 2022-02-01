package mqq.app;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

class MobileQQ$2
  implements Runnable
{
  MobileQQ$2(MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        i = MobileQQ.access$500(this.this$0).size();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("closeAllActivitys...BaseActivity count: ");
        ((StringBuilder)localObject1).append(i);
        QLog.d("mqq", 1, ((StringBuilder)localObject1).toString());
        i -= 1;
        localObject1 = null;
        Object localObject3;
        if (i >= 0)
        {
          localObject3 = (WeakReference)MobileQQ.access$500(this.this$0).get(i);
          if (localObject3 != null) {
            localObject1 = (BaseActivity)((WeakReference)localObject3).get();
          }
          if (localObject1 == null) {
            MobileQQ.access$500(this.this$0).remove(i);
          } else if (!((Activity)localObject1).isFinishing()) {
            ((Activity)localObject1).finish();
          } else {
            MobileQQ.access$500(this.this$0).remove(i);
          }
        }
        else
        {
          i = this.this$0.appActivities.size();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("closeAllActivitys...AppActivity count: ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("mqq", 1, ((StringBuilder)localObject1).toString());
          i -= 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)this.this$0.appActivities.get(i);
            if (localObject1 == null) {
              break label444;
            }
            localObject1 = (AppActivity)((WeakReference)localObject1).get();
            if (localObject1 == null)
            {
              this.this$0.appActivities.remove(i);
              break label449;
            }
            if (!((Activity)localObject1).isFinishing())
            {
              ((Activity)localObject1).finish();
              break label449;
            }
            this.this$0.appActivities.remove(i);
            break label449;
          }
          i = this.this$0.otherTypeActivitys.size();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("closeAllActivitys...other Activity count: ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("mqq", 1, ((StringBuilder)localObject1).toString());
          i -= 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)this.this$0.otherTypeActivitys.get(i);
            if (localObject1 == null) {
              break label456;
            }
            localObject1 = (Activity)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              this.this$0.otherTypeActivitys.remove(i);
            } else if (!((Activity)localObject1).isFinishing()) {
              ((Activity)localObject1).finish();
            } else {
              this.this$0.otherTypeActivitys.remove(i);
            }
            i -= 1;
            continue;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("closeAllActivitys: ");
          ((StringBuilder)localObject3).append(localException.getMessage());
          QLog.d("mqq", 2, ((StringBuilder)localObject3).toString());
        }
      }
      i -= 1;
      continue;
      label444:
      Object localObject2 = null;
      continue;
      label449:
      i -= 1;
      continue;
      label456:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MobileQQ.2
 * JD-Core Version:    0.7.0.1
 */