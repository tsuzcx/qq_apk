import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import mqq.os.MqqHandler;

public class akce
  implements URLDrawable.URLDrawableListener
{
  public akce(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a.sendMessage(this.a.a.obtainMessage(103, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akce
 * JD-Core Version:    0.7.0.1
 */