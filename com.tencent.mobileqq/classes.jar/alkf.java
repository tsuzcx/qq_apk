import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import mqq.os.MqqHandler;

class alkf
  implements DialogInterface.OnClickListener
{
  alkf(alke paramalke) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (andl.a() != null) {
      anbd.a();
    }
    paramDialogInterface = anbd.a();
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getHandler(Conversation.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(1134052));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkf
 * JD-Core Version:    0.7.0.1
 */