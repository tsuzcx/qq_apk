import com.tencent.mobileqq.activity.contact.addcontact.TroopView;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.qphone.base.util.QLog;

public class aheh
  implements ahoj
{
  public aheh(TroopView paramTroopView) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = TroopView.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(14, paramInt, i);
      TroopView.a(this.a).sendMessage(paramObject);
      return;
    }
  }
  
  public void au_()
  {
    if ((TroopView.a(this.a) != null) && (!TroopView.a(this.a).a())) {
      TroopView.a(this.a).scrollTo(0, TroopView.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheh
 * JD-Core Version:    0.7.0.1
 */