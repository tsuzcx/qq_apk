import com.tencent.mobileqq.richmedia.capture.view.FilterProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahmh
  implements Runnable
{
  public ahmh(FilterProviderView paramFilterProviderView) {}
  
  public void run()
  {
    FilterProviderView.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderView", 2, "FilterProviderView onCaptureVideoFilterRefresh size=" + this.a.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */