import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import mqq.os.MqqHandler;

class ajgh
  implements DialogInterface.OnClickListener
{
  ajgh(ajgg paramajgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (akyn.a() != null) {
      akwd.a();
    }
    paramDialogInterface = akwd.a();
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getHandler(Conversation.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(1134052));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgh
 * JD-Core Version:    0.7.0.1
 */