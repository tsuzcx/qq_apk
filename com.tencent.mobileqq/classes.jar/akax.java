import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.ScreenShotCallback;
import java.io.File;

public class akax
  implements Runnable
{
  public akax(SwiftBrowserMiscHandler paramSwiftBrowserMiscHandler, Bitmap paramBitmap, SwiftBrowserMiscHandler.ScreenShotCallback paramScreenShotCallback) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/ShareScreenShots");
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = ScreenShotUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject, str);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler.a = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler$ScreenShotCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserMiscHandler$ScreenShotCallback.a((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akax
 * JD-Core Version:    0.7.0.1
 */