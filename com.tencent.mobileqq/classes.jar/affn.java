import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

class affn
  implements DialogInterface.OnClickListener
{
  affn(affm paramaffm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQIdentiferActivity.a(this.a.a, 205, anzj.a(2131709240));
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affn
 * JD-Core Version:    0.7.0.1
 */