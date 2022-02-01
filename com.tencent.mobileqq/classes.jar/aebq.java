import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;

class aebq
  implements DialogInterface.OnClickListener
{
  aebq(aebp paramaebp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.a.a != null) && (this.a.a.a.isShowing()) && (this.a.a.a.getWindow() != null)) {
      this.a.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebq
 * JD-Core Version:    0.7.0.1
 */