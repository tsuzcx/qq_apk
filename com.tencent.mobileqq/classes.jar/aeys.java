import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SpaceLowNoticeActiviy;
import com.tencent.mobileqq.app.QQAppInterface;

public class aeys
  implements DialogInterface.OnClickListener
{
  public aeys(SpaceLowNoticeActiviy paramSpaceLowNoticeActiviy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.a.app, "dc00898", "", "", "0X8007547", "0X8007547", 0, 0, this.a.app.getCurrentAccountUin(), "", "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeys
 * JD-Core Version:    0.7.0.1
 */