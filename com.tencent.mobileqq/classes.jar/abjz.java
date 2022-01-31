import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class abjz
  extends Handler
{
  public abjz(NonMainAppHeadLoader paramNonMainAppHeadLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {}
    try
    {
      paramMessage = (ArrayList)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          String str1 = (String)paramMessage.next();
          String str2 = (String)this.a.b.get(str1);
          Bitmap localBitmap = BitmapFactory.decodeFile(str2);
          if (localBitmap != null)
          {
            localBitmap = this.a.a(localBitmap);
            if (localBitmap != null)
            {
              Message localMessage = Message.obtain();
              Bundle localBundle = new Bundle();
              localBundle.putParcelable("bmp", localBitmap);
              localBundle.putString("uin", str1);
              localBundle.putString("path", str2);
              localMessage.obj = localBundle;
              localMessage.what = 1002;
              this.a.a.sendMessage(localMessage);
              if (QLog.isColorLevel()) {
                QLog.d("NonMainAppHeadLoader", 2, "decodeFile, uin:" + str1);
              }
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError paramMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NonMainAppHeadLoader", 2, "decodeFile, OutOfMemoryError");
      }
      return;
    }
    catch (Exception paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NonMainAppHeadLoader", 2, "decodeFile, exception:" + paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abjz
 * JD-Core Version:    0.7.0.1
 */