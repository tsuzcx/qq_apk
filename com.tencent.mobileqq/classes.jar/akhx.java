import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import mqq.os.MqqHandler;

class akhx
  implements DialogInterface.OnClickListener
{
  akhx(akhw paramakhw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (alyf.a() != null) {
      alvx.a();
    }
    paramDialogInterface = alvx.a();
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
 * Qualified Name:     akhx
 * JD-Core Version:    0.7.0.1
 */