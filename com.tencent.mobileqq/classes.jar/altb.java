import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class altb
  implements DialogInterface.OnClickListener
{
  public altb(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditLocalVideoActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altb
 * JD-Core Version:    0.7.0.1
 */