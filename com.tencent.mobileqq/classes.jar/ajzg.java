import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class ajzg
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  bbpu jdField_a_of_type_Bbpu;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ajzd> b;
  
  public ajzg(ajzd paramajzd, QQAppInterface paramQQAppInterface, bbpu parambbpu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramajzd);
    this.jdField_a_of_type_Bbpu = parambbpu;
  }
  
  public void a()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ajzd localajzd = (ajzd)this.b.get();
    if ((localObject == null) || (localajzd == null) || (localajzd.c.get())) {
      QLog.d(ajzd.b(), 1, "preCreatePersonalFontImg return!");
    }
    while (localajzd.b().getBoolean("font_precreate_finish", false)) {
      return;
    }
    QLog.d(ajzd.b(), 1, "preCreatePersonalFontImg start!");
    int i = localajzd.b().getInt("font_precreate_index", 0);
    localObject = localajzd.a.obtainMessage();
    ((Message)localObject).what = i;
    localajzd.a.sendMessage((Message)localObject);
  }
  
  void a(int paramInt)
  {
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ajzd localajzd = (ajzd)this.b.get();
    if ((localObject2 == null) || (localajzd == null)) {}
    Object localObject1;
    do
    {
      return;
      str = this.jdField_a_of_type_Bbpu.a();
      if (paramInt >= str.length())
      {
        localObject1 = new File(ajzd.a(4)).listFiles();
        localObject2 = localajzd.b().edit();
        if ((localObject1 != null) && (localObject1.length >= str.length())) {
          ((SharedPreferences.Editor)localObject2).putBoolean("font_precreate_finish", true);
        }
        for (;;)
        {
          paramInt = localajzd.b().getInt("font_precreate_count", 0);
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_count", paramInt + 1);
          ((SharedPreferences.Editor)localObject2).commit();
          QLog.d(ajzd.b(), 1, "preCreatePersonalFontImg create count = " + paramInt);
          return;
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_index", 0);
        }
      }
      localObject1 = "0";
      if (localajzd.a()) {
        localObject1 = "1";
      }
    } while ((localajzd.e.get()) || (Thread.currentThread().isInterrupted()));
    String str = str.substring(paramInt, paramInt + 1);
    if (new File(ajzd.a("", str, 4, 0, 0)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e(ajzd.b(), 2, "preCreatePersonalFontImg exists : " + str + " address = " + ajzd.a("", str, 4, 0, 0));
      }
      localajzd.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      localObject1 = localajzd.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localajzd.a.sendMessageDelayed((Message)localObject1, 500L);
      return;
    }
    long l1 = System.currentTimeMillis();
    Bitmap localBitmap = localajzd.a(str, true);
    long l2;
    if (localBitmap != null)
    {
      this.jdField_a_of_type_Int = 0;
      l2 = System.currentTimeMillis();
      localajzd.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      if (paramInt % 100 == 0) {
        axqy.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "1", String.valueOf(l2 - l1), str);
      }
      if (!localBitmap.isRecycled()) {
        localBitmap.recycle();
      }
    }
    do
    {
      localObject1 = localajzd.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localajzd.a.sendMessageDelayed((Message)localObject1, 5000L);
      return;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(ajzd.b(), 2, "preCreatePersonalFontImg " + str + "fail");
      }
      if (paramInt % 100 == 0) {
        axqy.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "0", String.valueOf(l2 - l1), str);
      }
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int < this.jdField_a_of_type_Bbpu.b);
    QLog.e(ajzd.b(), 1, "preCreatePersonalFontImg fail count = " + this.jdField_a_of_type_Int + " max failcount = " + this.jdField_a_of_type_Bbpu.b);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    a(paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzg
 * JD-Core Version:    0.7.0.1
 */