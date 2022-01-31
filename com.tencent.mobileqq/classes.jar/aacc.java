import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

public class aacc
  implements Runnable
{
  public aacc(AREngine paramAREngine) {}
  
  public void run()
  {
    if (AREngine.a(this.a) != null) {
      AREngine.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aacc
 * JD-Core Version:    0.7.0.1
 */