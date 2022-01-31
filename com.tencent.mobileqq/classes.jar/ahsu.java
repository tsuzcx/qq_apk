import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class ahsu
  implements DialogInterface.OnClickListener
{
  public ahsu(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditLocalVideoActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */