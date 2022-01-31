import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aibq
  implements DialogInterface.OnClickListener
{
  aibq(aibm paramaibm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (badq.d(aibm.a(this.a)))
    {
      awqx.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      aibm.b(this.a);
      this.a.a.a().a().f();
      ((FriendListHandler)this.a.a.a(1)).i();
      return;
    }
    bbmy.a(aibm.a(this.a), 2131628956, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibq
 * JD-Core Version:    0.7.0.1
 */