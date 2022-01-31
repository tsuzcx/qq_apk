import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

public class ahir
  implements ahfl
{
  public ahir(TroopView paramTroopView) {}
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "AddContactTroopClassifyAdapter.onItemClickListener onItemClick. position:" + paramInt);
    }
    TroopView.a(this.a, TroopView.a(this.a).getCurrentItem());
    TroopView.b(this.a, paramInt);
    TroopView.a(this.a).setCurrentItem(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahir
 * JD-Core Version:    0.7.0.1
 */