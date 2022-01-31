import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;

public class addn
  implements DialogInterface.OnClickListener
{
  public addn(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (DoodlePanel.a(this.a) != null) {
      DoodlePanel.a(this.a).a(false, false);
    }
    DoodlePanel.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addn
 * JD-Core Version:    0.7.0.1
 */