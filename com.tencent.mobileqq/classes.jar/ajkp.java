import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

public final class ajkp
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramDownloadParams;
        localObject = paramDownloadParams.tag;
        paramDownloadParams = paramBitmap;
      } while (!(localObject instanceof int[]));
      paramDownloadParams = paramBitmap;
    } while (((int[])localObject).length != 3);
    paramDownloadParams = (int[])localObject;
    return ImageUtil.d(paramBitmap, paramDownloadParams[2], paramDownloadParams[0], paramDownloadParams[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajkp
 * JD-Core Version:    0.7.0.1
 */