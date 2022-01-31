import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import mqq.os.MqqHandler;

class ajbs
  implements DialogInterface.OnClickListener
{
  ajbs(ajbr paramajbr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (akty.a() != null) {
      akro.a();
    }
    paramDialogInterface = akro.a();
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
 * Qualified Name:     ajbs
 * JD-Core Version:    0.7.0.1
 */