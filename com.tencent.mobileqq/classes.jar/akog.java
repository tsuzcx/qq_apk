import android.os.Message;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimTipsInfo;

public class akog
  implements bmny
{
  public akog(ContactListView paramContactListView) {}
  
  public void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {
      return;
    }
    QLog.i("ContactListView", 2, "getQQPimTips() callback ");
    bmof.b(this.a.getContext(), paramQQPimTipsInfo);
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = paramQQPimTipsInfo;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akog
 * JD-Core Version:    0.7.0.1
 */