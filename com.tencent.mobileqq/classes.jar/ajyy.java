import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

public final class ajyy
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    return URLDrawableDecodeHandler.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyy
 * JD-Core Version:    0.7.0.1
 */