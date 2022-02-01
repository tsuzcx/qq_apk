import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

public class aecr
  implements DialogInterface.OnClickListener
{
  public aecr(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.setEnabled(true);
    this.a.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecr
 * JD-Core Version:    0.7.0.1
 */