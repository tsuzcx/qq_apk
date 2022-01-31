import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.os.MqqHandler;

public final class abiy
  implements Runnable
{
  public abiy(String paramString, Context paramContext, ImageView paramImageView) {}
  
  public void run()
  {
    ??? = (String)SplashBitmapUtils.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    ??? = String.format("%s/%s%s", new Object[] { SplashBitmapUtils.a(), ???, ".png" });
    Object localObject2 = SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)???, 0);
    if (localObject2 != null)
    {
      ThreadManager.getUIHandler().post(new abiz(this, (Drawable)localObject2));
      synchronized (SplashBitmapUtils.jdField_a_of_type_JavaLangObject)
      {
        localObject2 = new WeakReference(localObject2);
        SplashBitmapUtils.c.remove(this.jdField_a_of_type_JavaLangString);
        SplashBitmapUtils.c.put(this.jdField_a_of_type_JavaLangString, localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKeyAsync add to cache. key=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abiy
 * JD-Core Version:    0.7.0.1
 */