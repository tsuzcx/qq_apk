import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class abiu
  implements URLDrawable.URLDrawableListener
{
  public abiu(ARMapSplashView paramARMapSplashView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("onLoadProgressed i=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "onLoadSuccessed");
    }
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {
      ARMapSplashView.a(this.a).e = paramURLDrawable.getAbsolutePath();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abiu
 * JD-Core Version:    0.7.0.1
 */