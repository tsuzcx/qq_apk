import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class aexp
  implements DialogInterface.OnClickListener
{
  public aexp(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexp
 * JD-Core Version:    0.7.0.1
 */