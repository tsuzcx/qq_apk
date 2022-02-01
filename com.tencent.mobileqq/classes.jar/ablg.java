import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import java.util.Iterator;
import java.util.List;

class ablg
  implements DialogInterface.OnDismissListener
{
  ablg(ablf paramablf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ablf.a(this.a).a();
    this.a.jdField_a_of_type_Ablp.d();
    this.a.jdField_a_of_type_Abld.c();
    paramDialogInterface = ablf.a(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramDialogInterface.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    ablf.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ablg
 * JD-Core Version:    0.7.0.1
 */