import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import mqq.os.MqqHandler;

class afqf
  implements Handler.Callback
{
  afqf(afqe paramafqe) {}
  
  private void a()
  {
    if (afqe.a(this.a) != null) {
      afqe.a(this.a).setRefreshing(false);
    }
    if (afqe.a(this.a) != null) {
      afqe.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      label146:
      do
      {
        return false;
        bcpw.a(this.a.a(), 1, 2131719788, 0).b(afqe.a(this.a));
        a();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          afqe.a(this.a);
          if (afqe.a(this.a) == null) {
            break;
          }
          afqe.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        a();
        bcpw.a(this.a.a(), 1, 2131719788, 0).b(afqe.a(this.a));
        return false;
        a();
        return false;
        afqe.a(this.a, true, true);
        return false;
      } while ((afqe.a(this.a) == null) || (afqe.a(this.a) == null));
      afqe.a(this.a).a(afqe.a(this.a).getScrollY(), afqe.a(this.a).a());
      return false;
    }
    this.a.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqf
 * JD-Core Version:    0.7.0.1
 */