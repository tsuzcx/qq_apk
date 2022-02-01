import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class alkn
  implements DialogInterface.OnClickListener
{
  alkn(alkj paramalkj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (NetworkUtil.isNetSupport(alkj.a(this.a)))
    {
      bcef.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      alkj.b(this.a);
      this.a.a.getMsgHandler().a().f();
      ((FriendListHandler)this.a.a.getBusinessHandler(1)).deleteAllSuspiciousMsg();
      return;
    }
    QQToast.a(alkj.a(this.a), 2131694073, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkn
 * JD-Core Version:    0.7.0.1
 */