import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class agid
  implements Runnable
{
  agid(aghz paramaghz) {}
  
  public void run()
  {
    String[] arrayOfString = new String[15];
    arrayOfString[0] = "res/redpack/redpack_bg.png";
    arrayOfString[1] = "res/redpack/redpack_left.png";
    arrayOfString[2] = "res/redpack/redpack_right.png";
    arrayOfString[3] = "res/redpack/catch_icon.png";
    arrayOfString[4] = String.format(Locale.getDefault(), "res/redpack/time_%d.png", new Object[] { Integer.valueOf(0) });
    arrayOfString[5] = String.format(Locale.getDefault(), "res/redpack/time_%d.png", new Object[] { Integer.valueOf(1) });
    arrayOfString[6] = String.format(Locale.getDefault(), "res/redpack/time_%d.png", new Object[] { Integer.valueOf(2) });
    arrayOfString[7] = String.format(Locale.getDefault(), "res/redpack/time_%d.png", new Object[] { Integer.valueOf(3) });
    arrayOfString[8] = "res/redpack/catchCount_bg.png";
    arrayOfString[9] = String.format(Locale.getDefault(), "res/redpack/loading_0%d.png", new Object[] { Integer.valueOf(1) });
    arrayOfString[10] = String.format(Locale.getDefault(), "res/redpack/loading_0%d.png", new Object[] { Integer.valueOf(2) });
    arrayOfString[11] = String.format(Locale.getDefault(), "res/redpack/loading_0%d.png", new Object[] { Integer.valueOf(3) });
    arrayOfString[12] = "res/redpack/catch_anim.png";
    arrayOfString[13] = "res/redpack/raise.png";
    arrayOfString[14] = "res/redpack/raisetips.png";
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      String str = arrayOfString[i];
      try
      {
        Bitmap localBitmap = ScanTorchActivity.a(this.a.a.a, str, false);
        if (localBitmap != null) {
          BaseApplicationImpl.sImageCache.put(str, localBitmap);
        }
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label297;
        }
        QLog.e("ScanTorchActivity", 2, "binhai preload img throwable", localThrowable);
        while ((localThrowable instanceof OutOfMemoryError))
        {
          System.gc();
          break;
          QLog.d("ScanTorchActivity", 1, "binhai preload img t=" + localThrowable.getMessage());
        }
      }
      i += 1;
    }
    label297:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */