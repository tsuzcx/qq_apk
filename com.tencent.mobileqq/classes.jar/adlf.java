import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

public class adlf
  implements DialogInterface.OnClickListener
{
  public adlf(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(false);
    com.tencent.mobileqq.app.PhoneContactManagerImp.g = false;
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlf
 * JD-Core Version:    0.7.0.1
 */