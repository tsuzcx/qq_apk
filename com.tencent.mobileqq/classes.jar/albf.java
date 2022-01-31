import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

public class albf
  implements Runnable
{
  public albf(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if (this.a.a == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.a.a, 2130840643);
        if (localBitmap == null) {
          continue;
        }
        localBitmap = AuthorityUtil.a(this.a, localBitmap, 50, 50);
        if (localBitmap == null) {
          continue;
        }
        this.a.runOnUiThread(new albg(this, localBitmap));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     albf
 * JD-Core Version:    0.7.0.1
 */