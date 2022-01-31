import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.1;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.2;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.3;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aljn
  extends aljg
  implements aljm, asjt
{
  public static boolean d = true;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  alji jdField_a_of_type_Alji;
  public aljo a;
  Context jdField_a_of_type_AndroidContentContext;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Handler jdField_a_of_type_AndroidOsHandler;
  asjp jdField_a_of_type_Asjp;
  public volatile boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  public boolean b;
  int jdField_c_of_type_Int = -2147483648;
  boolean jdField_c_of_type_Boolean = false;
  
  public aljn(Handler paramHandler, Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    boolean bool1;
    if (!alji.a()) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      long l = System.currentTimeMillis();
      paramArrayOfByte = this.jdField_a_of_type_Alji.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
      bool2 = alji.a(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("------>recognizeDecode Mini suc=%b result=%s minicode_timecost=%d", new Object[] { Boolean.valueOf(bool2), paramArrayOfByte, Long.valueOf(System.currentTimeMillis() - l) }));
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_Aljo == null);
    this.jdField_a_of_type_Aljo.a(bool2, paramArrayOfByte, paramBoolean);
    return bool2;
  }
  
  public int a()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Alji = alji.a();
    this.jdField_a_of_type_Alji.a(this);
    this.jdField_a_of_type_Alji.a(this);
    this.jdField_a_of_type_Alji.a(this.jdField_a_of_type_AndroidContentContext, hashCode(), "MiniRecog");
    this.jdField_c_of_type_Int = asjn.a();
    if (this.jdField_c_of_type_Int >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return 0;
    }
  }
  
  public long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    boolean bool1 = this.jdField_a_of_type_Alji.b();
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (!bool1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini exec=return bDetectReady=%b mIsDetecting=%b mIsSupportDetecting=%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
      }
      return -1L;
    }
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, paramRect.height(), paramRect.width());
      this.jdField_a_of_type_AndroidGraphicsRect.offset(paramRect.top, paramRect.left);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect, this.jdField_a_of_type_AndroidGraphicsRect }));
      }
    }
    long l = System.currentTimeMillis();
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (paramArrayOfByte == null) {
        return 0L;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QRSession.MiniRecog", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      boolean bool2 = false;
      bool1 = bool2;
      try
      {
        paramRect = Bitmap.createBitmap(paramArrayOfByte, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
        bool1 = bool2;
        paramArrayOfByte.recycle();
        bool1 = bool2;
        this.jdField_a_of_type_Long = l;
        bool1 = bool2;
        bool2 = this.jdField_a_of_type_Alji.a(paramRect, this.jdField_a_of_type_Long);
        bool3 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          paramRect.recycle();
          bool3 = bool2;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          boolean bool3 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect exception", paramArrayOfByte);
            bool3 = bool1;
          }
        }
      }
      if (bool3) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini exec=%b ts=%s minicode_timecost=%d", new Object[] { Boolean.valueOf(bool3), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (bool3) {
        return this.jdField_a_of_type_Long;
      }
    }
    return 0L;
  }
  
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((AppSetting.jdField_b_of_type_Boolean) && (bfnz.h()))
    {
      if (this.jdField_a_of_type_Asjp == null) {
        this.jdField_a_of_type_Asjp = new asjp(BaseApplication.getContext());
      }
      localObject1 = this.jdField_a_of_type_Asjp.a(paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return localObject1;
      if (AppSetting.jdField_b_of_type_Boolean) {
        return YuvProxy.a(paramArrayOfByte, paramInt1, paramInt2);
      }
      if (this.jdField_a_of_type_ArrayOfInt == null) {}
      try
      {
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt1 * paramInt2];
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ArrayOfInt == null) {
          continue;
        }
        localObject1 = localObject2;
        if (alji.a(this.jdField_a_of_type_ArrayOfInt, paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int) != 0) {
          continue;
        }
        return Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect OutOfMemoryError e");
          }
          System.gc();
          try
          {
            this.jdField_a_of_type_ArrayOfInt = new int[paramInt1 * paramInt2];
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}
          if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect OutOfMemoryError e2");
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alji != null)
    {
      this.jdField_a_of_type_Alji.c(this);
      this.jdField_a_of_type_Alji.b(this);
      this.jdField_a_of_type_Alji.a(hashCode(), "MiniRecog");
    }
  }
  
  public void a(int paramInt)
  {
    long l = SystemClock.uptimeMillis() - this.jdField_b_of_type_Long;
    if ((QLog.isColorLevel()) || (alju.a())) {
      QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", new Object[] { Long.valueOf(l) }));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.3(this));
    alju.d(this.jdField_c_of_type_Int, (int)l);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.2(this, paramLong));
  }
  
  public void a(aljh paramaljh)
  {
    this.jdField_a_of_type_Aljo = ((aljo)paramaljh);
  }
  
  public void a(List<alje> paramList, long paramLong)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if ((((alje)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect.width() > 0) && (((alje)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect.height() > 0))
      {
        Rect localRect = new Rect(((alje)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect);
        localRect.offset(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
        alje localalje = new alje();
        localalje.jdField_a_of_type_AndroidGraphicsRect.set(localRect);
        localalje.jdField_a_of_type_Int = ((alje)paramList.get(i)).jdField_a_of_type_Int;
        localalje.jdField_a_of_type_Float = ((alje)paramList.get(i)).jdField_a_of_type_Float;
        localArrayList.add(localalje);
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.1(this, localArrayList, paramLong));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Alji.b()) && (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, paramBoolean);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljn
 * JD-Core Version:    0.7.0.1
 */