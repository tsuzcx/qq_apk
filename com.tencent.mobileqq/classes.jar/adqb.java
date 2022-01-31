import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

class adqb
  implements DialogInterface.OnClickListener
{
  adqb(adqa paramadqa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQIdentiferActivity.a(this.a.a, 205, alud.a(2131710755));
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqb
 * JD-Core Version:    0.7.0.1
 */