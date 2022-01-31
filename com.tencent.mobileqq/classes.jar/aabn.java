import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;

public class aabn
  implements Runnable
{
  public aabn(AREngine paramAREngine) {}
  
  public void run()
  {
    if ((AREngine.a(this.a) != null) && (!AREngine.a(this.a).c()))
    {
      if (AREngine.a(this.a).i()) {
        AREngine.d(this.a);
      }
      if (AREngine.a(this.a) != 1L) {
        break label78;
      }
      this.a.b(1L);
      AREngine.c(this.a);
    }
    for (;;)
    {
      this.a.j();
      return;
      label78:
      if (AREngine.a(this.a) == 2L) {
        this.a.l();
      } else if (AREngine.a(this.a) == 2048L) {
        this.a.n();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabn
 * JD-Core Version:    0.7.0.1
 */