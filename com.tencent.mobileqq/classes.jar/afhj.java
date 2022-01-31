import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import java.lang.ref.WeakReference;

public class afhj
  extends Handler
{
  public WeakReference<TroopView> a;
  
  public afhj(TroopView paramTroopView)
  {
    this.a = new WeakReference(paramTroopView);
  }
  
  private void a()
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {}
    do
    {
      return;
      if (TroopView.a(localTroopView) != null) {
        TroopView.a(localTroopView).setRefreshing(false);
      }
    } while (TroopView.a(localTroopView) == null);
    TroopView.a(localTroopView).setRefresh(false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {
      return;
    }
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      TroopView.c(localTroopView);
      TroopView.a(localTroopView, 1, 2131694610);
      return;
    case 4: 
      TroopView.a(localTroopView, true);
      return;
    case 5: 
      TroopView.a(localTroopView, false);
      return;
    case 13: 
      TroopView.a(localTroopView, 1, 2131694610);
      a();
      return;
    case 14: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label178;
        }
        TroopView.d(localTroopView);
        if (TroopView.a(localTroopView) == null) {
          break;
        }
        TroopView.a(localTroopView).a(0);
        TroopView.a(localTroopView).sendEmptyMessageDelayed(15, 800L);
        return;
      }
      label178:
      a();
      TroopView.a(localTroopView, 1, 2131719799);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */