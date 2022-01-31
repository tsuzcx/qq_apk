import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

public class aabk
  implements Runnable
{
  public aabk(AREngine paramAREngine) {}
  
  public void run()
  {
    if ((AREngine.d(this.a)) && (AREngine.e(this.a) == 2) && (AREngine.a(this.a) != null)) {
      AREngine.a(this.a).a(0, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabk
 * JD-Core Version:    0.7.0.1
 */