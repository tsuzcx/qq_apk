import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;

public class alst
  implements DialogInterface.OnClickListener
{
  public alst(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("608", "7", "2", true);
    EditLocalVideoActivity.a(this.a, "an_yuanshipin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alst
 * JD-Core Version:    0.7.0.1
 */