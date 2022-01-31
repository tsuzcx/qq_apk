import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aegb
  implements URLDrawable.URLDrawableListener
{
  aegb(aega paramaega, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("AioPanelMiniAppManager", 1, "onLoadFialed: failed. ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioPanelMiniAppManager", 2, "onLoadSuccessed: invoked.  url: " + this.jdField_a_of_type_JavaLangString);
    }
    aega.a(this.jdField_a_of_type_Aega).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegb
 * JD-Core Version:    0.7.0.1
 */