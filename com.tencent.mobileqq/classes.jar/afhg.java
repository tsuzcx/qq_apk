import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afhg
  implements aftq
{
  public afhg(TroopView paramTroopView) {}
  
  public void a()
  {
    if (bbev.g(BaseApplication.getContext()))
    {
      if (this.a.a.size() > 0)
      {
        if ((TroopView.a(this.a) != null) && (TroopView.a(this.a) != null)) {
          TroopView.a(this.a).b(TroopView.a(this.a).getCurrentItem());
        }
        return;
      }
      TroopView.b(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "refresh falied. network unavailable");
    }
    Message localMessage = TroopView.a(this.a).obtainMessage(13);
    TroopView.a(this.a).sendMessageDelayed(localMessage, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhg
 * JD-Core Version:    0.7.0.1
 */