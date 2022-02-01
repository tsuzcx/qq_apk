import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;

public class acmn
  implements DialogInterface.OnClickListener
{
  public acmn(TestAppFragment paramTestAppFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmn
 * JD-Core Version:    0.7.0.1
 */