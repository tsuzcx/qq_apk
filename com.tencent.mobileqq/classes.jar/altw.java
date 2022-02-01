import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.qphone.base.util.QLog;

public class altw
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, true);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a = paramInt5;
    b = paramInt6;
    try
    {
      paramInt1 = TrimNative.prepare(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return paramInt1;
    }
    catch (Throwable paramString)
    {
      QLog.e("ThumbnailUtils", 1, "init failed:" + Log.getStackTraceString(paramString));
    }
    return -444;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c = paramInt1;
    d = paramInt2;
    if (paramBoolean)
    {
      if (c <= d) {
        break label55;
      }
      c = 480;
      d = (int)(d / (paramInt1 * 1.0D / 480.0D));
    }
    for (;;)
    {
      return TrimNative.initGetFrame(paramString, c, d);
      label55:
      d = 480;
      c = (int)(c / (paramInt2 * 1.0D / 480.0D));
    }
  }
  
  public static Bitmap a(long paramLong1, long paramLong2)
  {
    if ((c <= 0) || (d <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(c, d, Bitmap.Config.ARGB_8888);
      if (TrimNative.getFrame(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
  
  public static Bitmap b(long paramLong1, long paramLong2)
  {
    if ((a <= 0) || (b <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
      if (TrimNative.getThumbnail(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altw
 * JD-Core Version:    0.7.0.1
 */