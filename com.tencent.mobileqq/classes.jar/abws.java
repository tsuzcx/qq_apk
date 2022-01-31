import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class abws
  implements DialogInterface.OnCancelListener
{
  public abws(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onCancle from dialog %b", new Object[] { Boolean.valueOf(this.a.a) }));
    }
    if (this.a.a) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abws
 * JD-Core Version:    0.7.0.1
 */