import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abbj
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public abbj(ARMapLoadingActivity paramARMapLoadingActivity1, Looper paramLooper, ARMapLoadingActivity paramARMapLoadingActivity2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARMapLoadingActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ARMapLoadingActivity localARMapLoadingActivity = (ARMapLoadingActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localARMapLoadingActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("handleMessage msg=%s", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ARMapLoadingActivity.e(localARMapLoadingActivity);
      return;
    case 101: 
      ARMapLoadingActivity.f(localARMapLoadingActivity);
      return;
    case 102: 
      ARMapLoadingActivity.g(localARMapLoadingActivity);
      return;
    case 110: 
      ARMapLoadingActivity.h(localARMapLoadingActivity);
      return;
    case 103: 
      ARMapLoadingActivity.i(localARMapLoadingActivity);
      return;
    case 104: 
      String str = null;
      Object localObject = paramMessage.getData();
      if (localObject != null) {
        str = (String)((Bundle)localObject).get("failInfo");
      }
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      ARMapLoadingActivity.a(localARMapLoadingActivity, paramMessage.arg1, paramMessage.arg2, (String)localObject);
      return;
    case 106: 
      ARMapLoadingActivity.j(localARMapLoadingActivity);
      return;
    case 107: 
      ARMapLoadingActivity.k(localARMapLoadingActivity);
      return;
    case 105: 
      ARMapLoadingActivity.l(localARMapLoadingActivity);
      return;
    case 108: 
      ARMapLoadingActivity.m(localARMapLoadingActivity);
      return;
    case 109: 
      ARMapLoadingActivity.n(localARMapLoadingActivity);
      return;
    case 111: 
      ARMapLoadingActivity.o(localARMapLoadingActivity);
      return;
    }
    ARMapLoadingActivity.p(localARMapLoadingActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbj
 * JD-Core Version:    0.7.0.1
 */