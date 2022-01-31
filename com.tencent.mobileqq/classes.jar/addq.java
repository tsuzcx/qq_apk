import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;

public class addq
  implements DialogInterface.OnClickListener
{
  public addq(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      axqy.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 0, "", "", "", "");
      return;
    }
    axqy.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 1, "", "", "", "");
    DoodlePanel.a(this.a).b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addq
 * JD-Core Version:    0.7.0.1
 */