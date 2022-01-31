import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class aipe
  implements BitmapDecoder
{
  public aipe(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    LocalMediaInfo localLocalMediaInfo = this.a.a(paramURL);
    if (localLocalMediaInfo == null) {}
    for (;;)
    {
      return null;
      paramURL = new BitmapFactory.Options();
      paramURL.inDensity = 160;
      paramURL.inTargetDensity = 160;
      paramURL.inScreenDensity = 160;
      try
      {
        paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.path, paramURL);
        if (paramURL == null) {
          continue;
        }
        return ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.thumbWidth, localLocalMediaInfo.thumbHeight, 2);
      }
      catch (OutOfMemoryError paramURL)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
          }
          paramURL = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipe
 * JD-Core Version:    0.7.0.1
 */