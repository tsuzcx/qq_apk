import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.qphone.base.util.QLog;

public class aaca
  implements Runnable
{
  public aaca(AREngine paramAREngine) {}
  
  public void run()
  {
    QLog.i("AREngine_AREngine", 1, "uninit run. mIsInited = " + AREngine.d(this.a));
    AREngine.b(this.a);
    AREngine.b(this.a, 0);
    AREngine.b(this.a, false);
    QLog.i("AREngine_AREngine", 1, "uninit end. mIsInited = " + AREngine.d(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaca
 * JD-Core Version:    0.7.0.1
 */