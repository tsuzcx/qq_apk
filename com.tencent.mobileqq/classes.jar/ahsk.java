import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.search.activity.VADActivity;

public class ahsk
  implements DialogInterface.OnClickListener
{
  public ahsk(VADActivity paramVADActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahsk
 * JD-Core Version:    0.7.0.1
 */