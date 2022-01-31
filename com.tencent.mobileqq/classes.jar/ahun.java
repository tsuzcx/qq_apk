import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.ISameStatusListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class ahun
  extends StatusObserver
{
  public ahun(StatusManager paramStatusManager) {}
  
  @TargetApi(9)
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new ahuo(this, paramBoolean, paramBundle));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label83:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.c(this.a, 0L);
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.a(i, paramBoolean2);
      break label83;
      StatusManager.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + paramBoolean1 + " " + paramBoolean2 + " " + paramInt + " " + paramArrayList.size());
    }
    if (paramBoolean1) {
      StatusManager.a(this.a, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (StatusManager.a(this.a) != null)
          {
            StatusManager.a(this.a, paramArrayList);
            return;
            if (!paramBoolean2) {
              continue;
            }
            StatusManager.a(this.a, null);
            continue;
          }
          if (StatusManager.b(this.a) == null) {
            StatusManager.b(this.a, new ArrayList());
          }
          paramArrayOfByte = this.a.a(StatusManager.b(this.a), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label165:
      if ((StatusManager.a(this.a) != null) && (StatusManager.a(this.a).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (StatusManager.c(this.a) == null) {
          break label264;
        }
        paramArrayList = StatusManager.c(this.a).iterator();
        while (paramArrayList.hasNext()) {
          ((ISameStatusListener)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.a.a(paramArrayList);
        break label165;
      }
      label264:
      break;
      paramArrayOfByte = paramArrayList;
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    StatusManager.a(this.a, null);
    if (StatusManager.b(this.a) != null)
    {
      paramBundle = StatusManager.b(this.a).iterator();
      if (paramBundle.hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)paramBundle.next();
        if (paramBoolean) {}
        for (int i = 100;; i = -1)
        {
          localIStatusListener.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label74:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label134;
      }
    }
    label134:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.b(i, paramBoolean2);
      break label74;
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahun
 * JD-Core Version:    0.7.0.1
 */