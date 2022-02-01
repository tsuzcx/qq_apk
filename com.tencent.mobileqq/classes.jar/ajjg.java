import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class ajjg
  implements Handler.Callback
{
  ajjg(ajjf paramajjf) {}
  
  private void a()
  {
    if (ajjf.a(this.a) != null) {
      ajjf.a(this.a).setRefreshing(false);
    }
    if (ajjf.a(this.a) != null) {
      ajjf.a(this.a).setRefresh(false);
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
        QQToast.a(this.a.a(), 1, 2131718993, 0).b(ajjf.a(this.a));
        a();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          ajjf.a(this.a);
          if (ajjf.a(this.a) == null) {
            break;
          }
          ajjf.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        a();
        QQToast.a(this.a.a(), 1, 2131718993, 0).b(ajjf.a(this.a));
        return false;
        a();
        return false;
        ajjf.a(this.a, true, true);
        return false;
      } while ((ajjf.a(this.a) == null) || (ajjf.a(this.a) == null));
      ajjf.a(this.a).a(ajjf.a(this.a).getScrollY(), ajjf.a(this.a).a());
      return false;
    }
    this.a.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjg
 * JD-Core Version:    0.7.0.1
 */