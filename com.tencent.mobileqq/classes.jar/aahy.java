import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter.1;
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter.2;
import java.util.Map;

public final class aahy
  implements AdThreadManagerAdapter
{
  public boolean postDelayed(Runnable paramRunnable, int paramInt, long paramLong)
  {
    GdtThreadManagerAdapter.1 local1 = new GdtThreadManagerAdapter.1(this);
    if (paramInt == 0) {
      return new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
    }
    if (local1.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)local1.get(Integer.valueOf(paramInt))).intValue();
      return new Handler(Looper.getMainLooper()).postDelayed(new GdtThreadManagerAdapter.2(this, paramRunnable, paramInt), paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahy
 * JD-Core Version:    0.7.0.1
 */