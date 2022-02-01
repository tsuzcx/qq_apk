import android.graphics.Bitmap;
import android.graphics.Matrix;

public class abbd
{
  private static float a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      return 1.0F;
    }
    return 1.0F * paramInt2 / paramInt1;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i;
    int j;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((i > 0) && (j > 0)) {}
    }
    else
    {
      return paramBitmap;
    }
    int k = ((Long)abac.a().a("SmartCutPicWidth", Long.valueOf(224L))).intValue();
    if (i <= j) {}
    for (float f = a(i, k);; f = a(j, k))
    {
      k = (int)f;
      int m = (int)f;
      azpw.a("Q.videostory", "Q.videostory.capture", "resizeImage", k * i + " " + m * j);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbd
 * JD-Core Version:    0.7.0.1
 */