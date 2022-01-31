import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.mobileqq.widget.QQToast;

public class aaof
  implements Runnable
{
  public aaof(ARMarkerResourceManager paramARMarkerResourceManager) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "物体识别不支持特征追踪！", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaof
 * JD-Core Version:    0.7.0.1
 */