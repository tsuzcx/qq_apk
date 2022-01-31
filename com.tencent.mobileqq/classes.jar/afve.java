import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class afve
  implements Runnable
{
  public afve(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "res/redpack/rank_dialog_bg.png";
    arrayOfString[1] = "res/redpack/cup.png";
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
        Bitmap localBitmap = ScanTorchActivity.a(this.a, str, false);
        if (localBitmap != null) {
          BaseApplicationImpl.sImageCache.put(str, localBitmap);
        }
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label97;
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
    label97:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afve
 * JD-Core Version:    0.7.0.1
 */