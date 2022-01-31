import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.51;
import com.tencent.qphone.base.util.QLog;

public class acqj
  implements DialogInterface.OnClickListener
{
  public acqj(ChatSettingForTroop.51 param51) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      return;
    }
    try
    {
      asdb.a(this.a.this$0, true, "action_game_join_group", Long.valueOf(this.a.this$0.d).longValue(), -1, this.a.a);
      this.a.this$0.a.cancel();
      this.a.this$0.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("Q.chatopttroop", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqj
 * JD-Core Version:    0.7.0.1
 */