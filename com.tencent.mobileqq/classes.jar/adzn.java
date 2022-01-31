import android.graphics.Bitmap;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class adzn
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public adzn(NearbyProxy paramNearbyProxy) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    synchronized (this.a.a)
    {
      if (this.a.a.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProxy", 2, "onDecodeTaskCompleted: reqUin=" + paramString + ", avatar=" + paramBitmap);
        }
        this.a.a.remove(paramString);
        NearbyProxy.a(this.a, 4154, new Object[] { Integer.valueOf(paramInt2), paramString, paramBitmap });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adzn
 * JD-Core Version:    0.7.0.1
 */