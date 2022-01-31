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

public class ajlc
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  bank jdField_a_of_type_Bank;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ajkz> b;
  
  public ajlc(ajkz paramajkz, QQAppInterface paramQQAppInterface, bank parambank)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramajkz);
    this.jdField_a_of_type_Bank = parambank;
  }
  
  public void a()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ajkz localajkz = (ajkz)this.b.get();
    if ((localObject == null) || (localajkz == null) || (localajkz.c.get())) {
      QLog.d(ajkz.b(), 1, "preCreatePersonalFontImg return!");
    }
    while (localajkz.b().getBoolean("font_precreate_finish", false)) {
      return;
    }
    QLog.d(ajkz.b(), 1, "preCreatePersonalFontImg start!");
    int i = localajkz.b().getInt("font_precreate_index", 0);
    localObject = localajkz.a.obtainMessage();
    ((Message)localObject).what = i;
    localajkz.a.sendMessage((Message)localObject);
  }
  
  void a(int paramInt)
  {
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ajkz localajkz = (ajkz)this.b.get();
    if ((localObject2 == null) || (localajkz == null)) {}
    Object localObject1;
    do
    {
      return;
      str = this.jdField_a_of_type_Bank.a();
      if (paramInt >= str.length())
      {
        localObject1 = new File(ajkz.a(4)).listFiles();
        localObject2 = localajkz.b().edit();
        if ((localObject1 != null) && (localObject1.length >= str.length())) {
          ((SharedPreferences.Editor)localObject2).putBoolean("font_precreate_finish", true);
        }
        for (;;)
        {
          paramInt = localajkz.b().getInt("font_precreate_count", 0);
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_count", paramInt + 1);
          ((SharedPreferences.Editor)localObject2).commit();
          QLog.d(ajkz.b(), 1, "preCreatePersonalFontImg create count = " + paramInt);
          return;
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_index", 0);
        }
      }
      localObject1 = "0";
      if (localajkz.a()) {
        localObject1 = "1";
      }
    } while ((localajkz.e.get()) || (Thread.currentThread().isInterrupted()));
    String str = str.substring(paramInt, paramInt + 1);
    if (new File(ajkz.a("", str, 4, 0, 0)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e(ajkz.b(), 2, "preCreatePersonalFontImg exists : " + str + " address = " + ajkz.a("", str, 4, 0, 0));
      }
      localajkz.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      localObject1 = localajkz.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localajkz.a.sendMessageDelayed((Message)localObject1, 500L);
      return;
    }
    long l1 = System.currentTimeMillis();
    Bitmap localBitmap = localajkz.a(str, true);
    long l2;
    if (localBitmap != null)
    {
      this.jdField_a_of_type_Int = 0;
      l2 = System.currentTimeMillis();
      localajkz.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      if (paramInt % 100 == 0) {
        awqx.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "1", String.valueOf(l2 - l1), str);
      }
      if (!localBitmap.isRecycled()) {
        localBitmap.recycle();
      }
    }
    do
    {
      localObject1 = localajkz.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localajkz.a.sendMessageDelayed((Message)localObject1, 5000L);
      return;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(ajkz.b(), 2, "preCreatePersonalFontImg " + str + "fail");
      }
      if (paramInt % 100 == 0) {
        awqx.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "0", String.valueOf(l2 - l1), str);
      }
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int < this.jdField_a_of_type_Bank.b);
    QLog.e(ajkz.b(), 1, "preCreatePersonalFontImg fail count = " + this.jdField_a_of_type_Int + " max failcount = " + this.jdField_a_of_type_Bank.b);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    a(paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlc
 * JD-Core Version:    0.7.0.1
 */