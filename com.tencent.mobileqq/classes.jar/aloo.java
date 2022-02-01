import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aloo
  implements DialogInterface.OnClickListener
{
  public aloo(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditLocalVideoActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloo
 * JD-Core Version:    0.7.0.1
 */