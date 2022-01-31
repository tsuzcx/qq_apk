import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aliu
  extends Handler
{
  aliu(alis paramalis, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        paramMessage = new ArrayList(this.a.jdField_a_of_type_JavaUtilArrayList.size());
        paramMessage.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
        this.a.a(paramMessage);
      }
    }
    Object localObject;
    String str;
    do
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.removeAll(paramMessage);
      for (;;)
      {
        return;
        if (paramMessage.what == 1002) {
          try
          {
            localObject = (Bundle)paramMessage.obj;
            paramMessage = (Bitmap)((Bundle)localObject).getParcelable("bmp");
            str = ((Bundle)localObject).getString("uin");
            localObject = ((Bundle)localObject).getString("path");
            if (paramMessage != null) {
              this.a.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, paramMessage);
            }
            Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              aliw localaliw = (aliw)localIterator.next();
              if (localaliw != null) {
                localaliw.a(str, (String)localObject, paramMessage);
              }
            }
            if (!QLog.isColorLevel()) {}
          }
          catch (Exception paramMessage) {}
        }
      }
      QLog.e("NonMainAppHeadLoader", 2, "refreshImg, exception:" + paramMessage.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("NonMainAppHeadLoader", 2, "refreshImg, uin:" + str + ", path=" + (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aliu
 * JD-Core Version:    0.7.0.1
 */