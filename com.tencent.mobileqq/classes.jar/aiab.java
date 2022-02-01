import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aiab
  implements DialogInterface.OnClickListener
{
  aiab(ahzx paramahzx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    abht.a(this.a.app, this.a.mActivity, this.a.sessionInfo.curFriendUin, this.a.b);
    this.a.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiab
 * JD-Core Version:    0.7.0.1
 */