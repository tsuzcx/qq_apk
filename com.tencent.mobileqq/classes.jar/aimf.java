import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;

public class aimf
  extends MqqHandler
{
  private WeakReference<ContactListView> a;
  
  public aimf(ContactListView paramContactListView)
  {
    this.a = new WeakReference(paramContactListView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ContactListView localContactListView = (ContactListView)this.a.get();
    if (localContactListView == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ContactListView", 2, "UiHandler() handleMessage a == null");
      }
    }
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 3: 
        case 7: 
        default: 
          throw new RuntimeException("Unknown message: " + paramMessage.what);
        case 1: 
          if ((ContactListView.a(localContactListView)) && (!localContactListView.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e()))
          {
            localContactListView.g();
            ContactListView.a(localContactListView, false);
          }
          localContactListView.j();
          return;
        case 2: 
          localContactListView.j();
        }
      } while (bdin.d(localContactListView.getContext()));
      localContactListView.i();
      localContactListView.b(alud.a(2131702889));
      return;
      localContactListView.b = ((List)paramMessage.obj);
      localContactListView.jdField_a_of_type_Akif.a(localContactListView.b);
      localContactListView.jdField_a_of_type_Akif.notifyDataSetChanged();
      return;
      paramMessage = ContactListView.a(localContactListView).getAccount();
      localObject = (TicketManagerImpl)ContactListView.a(localContactListView).getManager(2);
    } while (localObject == null);
    Object localObject = ((TicketManagerImpl)localObject).getA2(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "a2 = " + (String)localObject);
    }
    QQPimGetTipsInfoIPC.a().a(ContactListView.a(localContactListView), ContactListView.a(localContactListView), paramMessage, (String)localObject);
    return;
    ContactListView.a(localContactListView, (QQPimTipsInfo)paramMessage.obj);
    return;
    localContactListView.i();
    localContactListView.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */