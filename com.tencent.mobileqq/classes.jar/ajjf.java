import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;

public class ajjf
  implements DialogInterface.OnClickListener
{
  public ajjf(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c();
    if (ReciteRecordLayout.a(this.a) != null) {
      ReciteRecordLayout.a(this.a).d();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjf
 * JD-Core Version:    0.7.0.1
 */