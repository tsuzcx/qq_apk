import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aioj
  implements DialogInterface.OnClickListener
{
  aioj(aiof paramaiof) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (bbev.d(aiof.a(this.a)))
    {
      axqw.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      aiof.b(this.a);
      this.a.a.a().a().f();
      ((FriendListHandler)this.a.a.a(1)).i();
      return;
    }
    bcpw.a(aiof.a(this.a), 2131694620, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aioj
 * JD-Core Version:    0.7.0.1
 */