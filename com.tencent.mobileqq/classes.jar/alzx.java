import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.qphone.base.util.QLog;

public class alzx
{
  public static int a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever;
    if (Build.VERSION.SDK_INT >= 14)
    {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        paramString = localMediaMetadataRetriever.extractMetadata(12);
        QLog.i("FormatDetector", 1, "detectFormatSupport: mimeType=" + paramString);
        if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("video/")))
        {
          QLog.e("FormatDetector", 1, "detectFormatSupport: wrong mimeType=" + paramString);
          return -1;
        }
        paramString = localMediaMetadataRetriever.extractMetadata(17);
        QLog.i("FormatDetector", 1, "detectFormatSupport: hasVideo=" + paramString);
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase("yes")))
        {
          QLog.e("FormatDetector", 1, "detectFormatSupport: no video content!");
          return -1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("FormatDetector", 1, "detectFormatSupport:", paramString);
          localMediaMetadataRetriever.release();
        }
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      return 0;
    }
    return TrimNative.detect(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzx
 * JD-Core Version:    0.7.0.1
 */