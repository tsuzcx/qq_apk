import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public final class akgd
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length > 0)) {}
    for (int i = ((int[])(int[])paramDownloadParams)[0];; i = 0)
    {
      int j;
      int k;
      boolean bool;
      if (i != 0)
      {
        paramDownloadParams = new Matrix();
        paramDownloadParams.postRotate(i);
        j = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        if (i % 90 != 0) {
          bool = true;
        }
      }
      label84:
      for (paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, paramDownloadParams, bool);; paramDownloadParams = paramBitmap)
      {
        localObject = paramDownloadParams;
        if (paramDownloadParams == paramBitmap) {
          break;
        }
        paramBitmap.recycle();
        return paramDownloadParams;
        bool = false;
        break label84;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgd
 * JD-Core Version:    0.7.0.1
 */