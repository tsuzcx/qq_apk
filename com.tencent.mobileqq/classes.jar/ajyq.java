import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.troop.utils.TroopNativeUtils;

public final class ajyq
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = paramDownloadParams.tag;
    if ((TroopNativeUtils.a().a) && ((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 1))
    {
      int i = ((int[])(int[])paramDownloadParams)[0];
      TroopNativeUtils.a().a(paramBitmap, i);
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyq
 * JD-Core Version:    0.7.0.1
 */