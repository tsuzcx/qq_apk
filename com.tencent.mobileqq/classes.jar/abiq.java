import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class abiq
  implements DialogInterface.OnCancelListener
{
  public abiq(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abiq
 * JD-Core Version:    0.7.0.1
 */