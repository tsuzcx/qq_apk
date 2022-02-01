import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class acbb
  implements AdExposureChecker.ExposureCallback
{
  acbb(acav paramacav) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    paramWeakReference = (View)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      QLog.i("GdtAdBoxDialog", 1, "onExposure view == null");
      return;
    }
    this.a.a(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbb
 * JD-Core Version:    0.7.0.1
 */