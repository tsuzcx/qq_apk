import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class akkh
  implements DialogInterface.OnClickListener
{
  akkh(akkd paramakkd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (bdin.d(akkd.a(this.a)))
    {
      azqs.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      akkd.b(this.a);
      this.a.a.a().a().f();
      ((FriendListHandler)this.a.a.a(1)).j();
      return;
    }
    QQToast.a(akkd.a(this.a), 2131694779, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akkh
 * JD-Core Version:    0.7.0.1
 */