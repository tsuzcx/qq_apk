import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;

public class agcs
  implements DialogInterface.OnClickListener
{
  public agcs(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bdla.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 0, "", "", "", "");
      return;
    }
    bdla.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 1, "", "", "", "");
    DoodlePanel.a(this.a).finish(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcs
 * JD-Core Version:    0.7.0.1
 */