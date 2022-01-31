import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.lyric.util.Singleton;

public final class aecp
  extends Singleton
{
  protected Handler a(Void paramVoid)
  {
    return new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecp
 * JD-Core Version:    0.7.0.1
 */