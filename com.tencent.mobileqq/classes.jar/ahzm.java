import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class ahzm
  implements DialogInterface.OnClickListener
{
  ahzm(ahzc paramahzc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((amme)this.a.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(this.a.sessionInfo.curFriendUin, 319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzm
 * JD-Core Version:    0.7.0.1
 */