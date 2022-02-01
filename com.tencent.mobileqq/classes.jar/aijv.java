import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class aijv
  implements DialogInterface.OnClickListener
{
  aijv(aijr paramaijr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (ncz)aijr.a(this.a).getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (paramDialogInterface != null) {
      paramDialogInterface.a(aijr.a(this.a).curFriendUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijv
 * JD-Core Version:    0.7.0.1
 */