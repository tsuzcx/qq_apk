import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.qphone.base.util.QLog;

public class aedq
  implements Runnable
{
  public aedq(PngGifEngine paramPngGifEngine) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func run begins.");
    }
    Object localObject1 = this.a.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    long l2 = SystemClock.uptimeMillis();
    Object localObject2 = PngGifEngine.a((String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func run, bitmap:" + localObject2);
    }
    localObject1 = this.a;
    if (localObject2 != null) {}
    for (;;)
    {
      long l1;
      try
      {
        if ((!((Bitmap)localObject2).isRecycled()) && (this.a.jdField_a_of_type_AndroidOsHandler != null))
        {
          l1 = SystemClock.uptimeMillis();
          l2 += this.a.jdField_a_of_type_Aedr.b;
          localObject2 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localObject2);
          if (l1 > l2) {
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedq
 * JD-Core Version:    0.7.0.1
 */