import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;

public class aanp
  implements Runnable
{
  public aanp(AREngine paramAREngine) {}
  
  public void run()
  {
    QLog.i("AREngine_AREngine", 2, "downloadWorldCupIdx1Res. download timeout.");
    WorldCupMgr.a(AREngine.a(this.a)).b(this.a.a);
    if ((AREngine.e(this.a)) && (AREngine.e(this.a) == 2) && (AREngine.a(this.a) != null)) {
      AREngine.b(this.a, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aanp
 * JD-Core Version:    0.7.0.1
 */