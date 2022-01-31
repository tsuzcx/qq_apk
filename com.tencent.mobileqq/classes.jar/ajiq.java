import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class ajiq
  implements DialogInterface.OnClickListener
{
  public ajiq(ReciteFragment paramReciteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReciteFragment.a(this.a, false);
    ReciteFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiq
 * JD-Core Version:    0.7.0.1
 */