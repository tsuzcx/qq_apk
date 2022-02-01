import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import java.util.Iterator;
import java.util.List;

class acaw
  implements DialogInterface.OnDismissListener
{
  acaw(acav paramacav) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    acav.a(this.a).a();
    this.a.jdField_a_of_type_Acbf.d();
    this.a.jdField_a_of_type_Acat.c();
    paramDialogInterface = acav.a(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramDialogInterface.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    acav.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaw
 * JD-Core Version:    0.7.0.1
 */