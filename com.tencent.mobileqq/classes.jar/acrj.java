import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;

public class acrj
  implements DialogInterface.OnClickListener
{
  public acrj(Conversation paramConversation) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
    azqs.b(this.a.a, "CliOper", "", "", "0X800815E", "0X800815E", 0, 0, "", "", "", "");
    azqs.b(this.a.a, "CliOper", "", "", "0X8008656", "0X8008656", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrj
 * JD-Core Version:    0.7.0.1
 */