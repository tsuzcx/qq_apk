import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abpy
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public abpy(ARMapSplashView paramARMapSplashView1, Looper paramLooper, ARMapSplashView paramARMapSplashView2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARMapSplashView2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ARMapSplashView localARMapSplashView = (ARMapSplashView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localARMapSplashView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("handleMessage msg=%s", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ARMapSplashView.a(localARMapSplashView);
      return;
    }
    ARMapSplashView.b(localARMapSplashView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpy
 * JD-Core Version:    0.7.0.1
 */