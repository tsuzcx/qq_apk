import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.OnReciteListener;

class ajqw
  implements DialogInterface.OnClickListener
{
  ajqw(ajqu paramajqu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.c();
    if (ReciteRecordLayout.a(this.a.a) != null) {
      ReciteRecordLayout.a(this.a.a).c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqw
 * JD-Core Version:    0.7.0.1
 */