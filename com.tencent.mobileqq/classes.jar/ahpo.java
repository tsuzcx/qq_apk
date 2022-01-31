import com.tencent.mobileqq.shortvideo.util.NativeSoLoader;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ahpo
  implements Runnable
{
  public void run()
  {
    if (!NativeSoLoader.a().get())
    {
      boolean bool = NativeSoLoader.a("TKGLRenderer");
      NativeSoLoader.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpo
 * JD-Core Version:    0.7.0.1
 */