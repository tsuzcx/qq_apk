import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.qphone.base.util.QLog;

public class aafy
  implements Runnable
{
  public aafy(AREngine paramAREngine) {}
  
  public void run()
  {
    QLog.i("AREngine_AREngine", 1, "processCloudSceneRecogResult. download resource timeout.");
    AREngine.a(this.a).a();
    this.a.d(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafy
 * JD-Core Version:    0.7.0.1
 */