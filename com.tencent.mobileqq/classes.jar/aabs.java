import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

class aabs
  implements Runnable
{
  aabs(aabq paramaabq) {}
  
  @TargetApi(11)
  public void run()
  {
    try
    {
      aabq.a(this.a).updateTexImage();
      aabq.a(this.a).getTransformMatrix(aabq.a(this.a));
      if (ScanTorchActivity.i)
      {
        aabq localaabq = this.a;
        localaabq.b += 1L;
        if (this.a.b >= 30L)
        {
          this.a.b = 0L;
          long l = System.currentTimeMillis();
          float f = 30000.0F / (float)(l - this.a.a);
          this.a.a = l;
          QLog.d("render", 2, "video fetch=" + f);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabs
 * JD-Core Version:    0.7.0.1
 */