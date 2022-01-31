import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.qphone.base.util.QLog;

public class aans
  implements Runnable
{
  public aans(AREngine paramAREngine) {}
  
  public void run()
  {
    this.a.j();
    AREngine.b(this.a, 0);
    QLog.i("AREngine_AREngine", 1, "stop end. mCurEngineState = " + AREngine.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aans
 * JD-Core Version:    0.7.0.1
 */