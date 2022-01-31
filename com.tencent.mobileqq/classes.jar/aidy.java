import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class aidy
  implements BitmapDecoder
{
  public aidy(VideoCoverDownloader paramVideoCoverDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    return ShortVideoUtils.a(null, paramURL.getPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aidy
 * JD-Core Version:    0.7.0.1
 */