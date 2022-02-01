import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;

public class adtx
  implements DialogInterface.OnClickListener
{
  public adtx(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    paramDialogInterface = this.a;
    if (paramInt == 1) {}
    for (;;)
    {
      AddRequestActivity.b(paramDialogInterface, bool);
      bdll.b(this.a.app, "dc00898", "", "", "0X800B084", "0X800B084", 0, 0, "", "", "", "");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtx
 * JD-Core Version:    0.7.0.1
 */