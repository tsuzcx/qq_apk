import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ahxs
  implements DialogInterface.OnClickListener
{
  public ahxs(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ThreadManager.post(new ClassificationSearchActivity.15.1(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxs
 * JD-Core Version:    0.7.0.1
 */