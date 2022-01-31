import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class aipf
  implements BitmapDecoder
{
  public aipf(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    if (paramURL == null) {
      paramURL = null;
    }
    for (;;)
    {
      return paramURL;
      String str = paramURL.path;
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = this.a.a(str);
        paramURL = localBitmap;
        if (localBitmap == null)
        {
          paramURL = this.a.b(str);
          return paramURL;
        }
      }
      catch (Throwable paramURL)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipf
 * JD-Core Version:    0.7.0.1
 */