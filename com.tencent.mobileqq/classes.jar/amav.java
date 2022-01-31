import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.QQAppInterface;

public final class amav
  implements Runnable
{
  public amav(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    HtmlOffline.b("2036", this.a, true, new amaw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amav
 * JD-Core Version:    0.7.0.1
 */