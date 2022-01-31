import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.widget.QQToast;

public class aafd
  implements Runnable
{
  public aafd(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "开始选图", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafd
 * JD-Core Version:    0.7.0.1
 */