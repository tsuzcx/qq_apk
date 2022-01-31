import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;

public class adsx
  implements DialogInterface.OnClickListener
{
  public adsx(ForwardFileBaseOption paramForwardFileBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardFileBaseOption.a(this.a, false);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adsx
 * JD-Core Version:    0.7.0.1
 */