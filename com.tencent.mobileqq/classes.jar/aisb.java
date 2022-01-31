import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class aisb
  implements BitmapDecoder
{
  public aisb(VideoCoverDownloader paramVideoCoverDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    return ShortVideoUtils.a(null, paramURL.getPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisb
 * JD-Core Version:    0.7.0.1
 */