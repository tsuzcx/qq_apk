import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import mqq.os.MqqHandler;

class ahkj
  implements DialogInterface.OnClickListener
{
  ahkj(ahki paramahki) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ajcm.a() != null) {
      ajac.a();
    }
    paramDialogInterface = ajac.a();
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getHandler(Conversation.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(1134052));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */