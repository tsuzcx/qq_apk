import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahiy
  implements ahvv
{
  public ahiy(TroopView paramTroopView) {}
  
  public void a()
  {
    if (babd.a())
    {
      localMessage = TroopView.a(this.a).obtainMessage(15);
      TroopView.a(this.a).sendMessage(localMessage);
    }
    do
    {
      return;
      if (!bdin.g(BaseApplication.getContext())) {
        break label105;
      }
      if (this.a.a.size() <= 0) {
        break;
      }
    } while ((TroopView.a(this.a) == null) || (TroopView.a(this.a) == null));
    TroopView.a(this.a).b(TroopView.a(this.a).getCurrentItem());
    return;
    TroopView.b(this.a);
    return;
    label105:
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "refresh falied. network unavailable");
    }
    Message localMessage = TroopView.a(this.a).obtainMessage(13);
    TroopView.a(this.a).sendMessageDelayed(localMessage, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiy
 * JD-Core Version:    0.7.0.1
 */