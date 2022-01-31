import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimTipsInfo;

public class agjh
  implements bgte
{
  public agjh(ContactListView paramContactListView) {}
  
  public void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {
      return;
    }
    QLog.i("ContactListView", 2, "getQQPimTips() callback ");
    bgtl.b(this.a.getContext(), paramQQPimTipsInfo);
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = paramQQPimTipsInfo;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjh
 * JD-Core Version:    0.7.0.1
 */