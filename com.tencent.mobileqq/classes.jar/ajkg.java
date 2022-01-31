import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public final class ajkg
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 2))
    {
      paramDownloadParams = (int[])paramDownloadParams;
      float f2 = DeviceInfoUtil.a();
      float f1 = f2;
      if (f2 < 0.01F) {
        f1 = 1.0F;
      }
      paramDownloadParams[0] = ((int)(paramDownloadParams[0] / f1));
      paramDownloadParams[1] = ((int)(paramDownloadParams[1] / f1));
      return ImageUtil.c(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
    }
    return ImageUtil.c(paramBitmap, 50, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajkg
 * JD-Core Version:    0.7.0.1
 */