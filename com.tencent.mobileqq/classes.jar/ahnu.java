import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class ahnu
  implements Handler.Callback
{
  ahnu(ahnt paramahnt) {}
  
  private void a()
  {
    if (ahnt.a(this.a) != null) {
      ahnt.a(this.a).setRefreshing(false);
    }
    if (ahnt.a(this.a) != null) {
      ahnt.a(this.a).setRefresh(false);
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
        QQToast.a(this.a.a(), 1, 2131720325, 0).b(ahnt.a(this.a));
        a();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          ahnt.a(this.a);
          if (ahnt.a(this.a) == null) {
            break;
          }
          ahnt.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        a();
        QQToast.a(this.a.a(), 1, 2131720325, 0).b(ahnt.a(this.a));
        return false;
        a();
        return false;
        ahnt.a(this.a, true, true);
        return false;
      } while ((ahnt.a(this.a) == null) || (ahnt.a(this.a) == null));
      ahnt.a(this.a).a(ahnt.a(this.a).getScrollY(), ahnt.a(this.a).a());
      return false;
    }
    this.a.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnu
 * JD-Core Version:    0.7.0.1
 */