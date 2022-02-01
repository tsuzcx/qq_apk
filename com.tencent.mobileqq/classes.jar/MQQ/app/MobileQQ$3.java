package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

class MobileQQ$3
  implements Runnable
{
  MobileQQ$3(MobileQQ paramMobileQQ) {}
  
  private boolean isAllActEmpty()
  {
    Iterator localIterator;
    WeakReference localWeakReference;
    if (!MobileQQ.access$500(this.this$0).isEmpty())
    {
      localIterator = MobileQQ.access$500(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((BaseActivity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    if (!this.this$0.appActivities.isEmpty())
    {
      localIterator = this.this$0.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((AppActivity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    if (!this.this$0.otherTypeActivitys.isEmpty())
    {
      localIterator = this.this$0.otherTypeActivitys.iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((Activity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void run()
  {
    if (isAllActEmpty())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mqq.intent.action.EXIT_");
      ((StringBuilder)localObject1).append(MobileQQ.processName);
      localObject1 = new Intent(((StringBuilder)localObject1).toString());
      this.this$0.sendBroadcast((Intent)localObject1);
      if (this.this$0.getQQProcessName().endsWith(":video"))
      {
        MobileQQ.access$100(this.this$0).msfSub.unbindMsfService();
        MobileQQ.access$000(this.this$0).onDestroy();
      }
      this.this$0.mHandler.postDelayed(new MobileQQ.3.1(this), 300L);
      return;
    }
    Object localObject1 = new StringBuffer();
    Object localObject2 = MobileQQ.access$500(this.this$0).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BaseActivity)((WeakReference)((Iterator)localObject2).next()).get();
      if (localObject3 != null)
      {
        ((StringBuffer)localObject1).append(localObject3.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localObject2 = this.this$0.appActivities.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AppActivity)((WeakReference)((Iterator)localObject2).next()).get();
      if (localObject3 != null)
      {
        ((StringBuffer)localObject1).append(localObject3.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localObject2 = this.this$0.otherTypeActivitys.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Activity)((WeakReference)((Iterator)localObject2).next()).get();
      if (localObject3 != null)
      {
        ((StringBuffer)localObject1).append(localObject3.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    if ((!MobileQQ.access$700()) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("do exit ->");
      ((StringBuilder)localObject2).append(((StringBuffer)localObject1).toString());
      QLog.i("mqq", 2, ((StringBuilder)localObject2).toString());
      MobileQQ.access$702(true);
    }
    ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
    this.this$0.mHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MobileQQ.3
 * JD-Core Version:    0.7.0.1
 */