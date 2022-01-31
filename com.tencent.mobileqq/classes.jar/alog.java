import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import cooperation.wadl.ipc.WadlParams;

public class alog
  implements DialogInterface.OnClickListener
{
  public alog(ArkAppDownloadModule.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    axqy.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", this.a.a.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alog
 * JD-Core Version:    0.7.0.1
 */