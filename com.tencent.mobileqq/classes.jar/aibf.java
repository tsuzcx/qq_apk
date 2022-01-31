import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class aibf
  implements BitmapDecoder
{
  public aibf(FileAssistantDownloader paramFileAssistantDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    if (paramURL == null) {
      return null;
    }
    return ShortVideoUtils.a(null, paramURL.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aibf
 * JD-Core Version:    0.7.0.1
 */