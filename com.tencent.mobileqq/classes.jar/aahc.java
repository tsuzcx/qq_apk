import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.qphone.base.util.QLog;

public class aahc
  implements Runnable
{
  public aahc(AREngine paramAREngine) {}
  
  public void run()
  {
    QLog.i("AREngine_AREngine", 1, "uninit run. mIsInited = " + AREngine.e(this.a));
    AREngine.b(this.a);
    AREngine.b(this.a, 0);
    AREngine.b(this.a, false);
    QLog.i("AREngine_AREngine", 1, "uninit end. mIsInited = " + AREngine.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahc
 * JD-Core Version:    0.7.0.1
 */