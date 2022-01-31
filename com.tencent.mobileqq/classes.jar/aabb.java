import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.qphone.base.util.QLog;

public class aabb
  implements Runnable
{
  public aabb(AREngine paramAREngine) {}
  
  public void run()
  {
    QLog.i("AREngine_AREngine", 1, "processCloudObjectClassifyResult. download resource timeout.");
    AREngine.a(this.a).a();
    this.a.c(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabb
 * JD-Core Version:    0.7.0.1
 */