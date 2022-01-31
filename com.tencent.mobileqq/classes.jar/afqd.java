import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import mqq.os.MqqHandler;

class afqd
  implements Handler.Callback
{
  afqd(afqc paramafqc) {}
  
  private void a()
  {
    if (afqc.a(this.a) != null) {
      afqc.a(this.a).setRefreshing(false);
    }
    if (afqc.a(this.a) != null) {
      afqc.a(this.a).setRefresh(false);
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
        bcql.a(this.a.a(), 1, 2131719799, 0).b(afqc.a(this.a));
        a();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          afqc.a(this.a);
          if (afqc.a(this.a) == null) {
            break;
          }
          afqc.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        a();
        bcql.a(this.a.a(), 1, 2131719799, 0).b(afqc.a(this.a));
        return false;
        a();
        return false;
        afqc.a(this.a, true, true);
        return false;
      } while ((afqc.a(this.a) == null) || (afqc.a(this.a) == null));
      afqc.a(this.a).a(afqc.a(this.a).getScrollY(), afqc.a(this.a).a());
      return false;
    }
    this.a.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqd
 * JD-Core Version:    0.7.0.1
 */