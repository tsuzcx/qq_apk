import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeim
  implements DialogInterface.OnClickListener
{
  public aeim(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = MoveToGroupActivity.a(this.a).getInputValue();
    if (paramDialogInterface.equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131692955);
    }
    for (;;)
    {
      if (MoveToGroupActivity.a(this.a).size() > 0) {}
      for (byte b = (byte)(((Groups)MoveToGroupActivity.a(this.a).get(MoveToGroupActivity.a(this.a).size() - 1)).seqid + 1);; b = 1)
      {
        MoveToGroupActivity.b(this.a, this.a.a(b, paramDialogInterface));
        if (QLog.isColorLevel()) {
          QLog.d("MoveToGroupActivity", 2, "AddFriendGroup needShowDialog = " + MoveToGroupActivity.a(this.a));
        }
        if (MoveToGroupActivity.a(this.a)) {
          this.a.a(2131692989);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeim
 * JD-Core Version:    0.7.0.1
 */