import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class ajsu
  implements Handler.Callback
{
  ajsu(ajst paramajst) {}
  
  private void a()
  {
    if (ajst.a(this.a) != null) {
      ajst.a(this.a).setRefreshing(false);
    }
    if (ajst.a(this.a) != null) {
      ajst.a(this.a).setRefresh(false);
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
        QQToast.a(this.a.a(), 1, 2131718362, 0).b(ajst.a(this.a));
        a();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          ajst.a(this.a);
          if (ajst.a(this.a) == null) {
            break;
          }
          ajst.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        a();
        QQToast.a(this.a.a(), 1, 2131718362, 0).b(ajst.a(this.a));
        return false;
        a();
        return false;
        ajst.a(this.a, true, true);
        return false;
      } while ((ajst.a(this.a) == null) || (ajst.a(this.a) == null));
      ajst.a(this.a).a(ajst.a(this.a).getScrollY(), ajst.a(this.a).a());
      return false;
    }
    this.a.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsu
 * JD-Core Version:    0.7.0.1
 */