import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;

public class ajxb
  implements DialogInterface.OnClickListener
{
  public ajxb(Conversation paramConversation) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
    bdla.b(this.a.a, "CliOper", "", "", "0X800815E", "0X800815E", 0, 0, "", "", "", "");
    bdla.b(this.a.a, "CliOper", "", "", "0X8008656", "0X8008656", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxb
 * JD-Core Version:    0.7.0.1
 */