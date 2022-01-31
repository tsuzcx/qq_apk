import android.os.Environment;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import java.io.File;

public class akpd
  implements Runnable
{
  public akpd(SwiftBrowserMiscHandler paramSwiftBrowserMiscHandler) {}
  
  public void run()
  {
    FileUtil.a(new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/ShareScreenShots"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpd
 * JD-Core Version:    0.7.0.1
 */