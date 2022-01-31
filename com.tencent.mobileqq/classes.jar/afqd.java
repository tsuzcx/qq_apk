import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class afqd
  implements URLDrawable.URLDrawableListener
{
  public afqd(SearchSougouResultItemBuilder paramSearchSougouResultItemBuilder) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((this.a.a == null) || (paramURLDrawable == null) || (paramURLDrawable.getURL() == null)) {}
    do
    {
      return;
      paramThrowable = this.a.a.findViewWithTag(paramURLDrawable.getURL().toString());
      if ((paramThrowable != null) && ((paramThrowable instanceof ImageView))) {
        paramThrowable.post(new afqe(this, paramThrowable));
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "UrlDownloadListener image fail," + paramURLDrawable.getURL());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqd
 * JD-Core Version:    0.7.0.1
 */