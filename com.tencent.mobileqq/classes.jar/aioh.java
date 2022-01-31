import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aioh
  implements DialogInterface.OnClickListener
{
  aioh(aiod paramaiod) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (bbfj.d(aiod.a(this.a)))
    {
      axqy.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      aiod.b(this.a);
      this.a.a.a().a().f();
      ((FriendListHandler)this.a.a.a(1)).i();
      return;
    }
    bcql.a(aiod.a(this.a), 2131694621, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aioh
 * JD-Core Version:    0.7.0.1
 */