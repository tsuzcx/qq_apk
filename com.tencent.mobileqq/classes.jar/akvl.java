import android.os.Handler;
import com.tencent.qbar.QbarNative.QbarPossibleInfo;
import com.tencent.qphone.base.util.QLog;

public class akvl
  extends akuv
{
  akur jdField_a_of_type_Akur;
  Handler jdField_a_of_type_AndroidOsHandler;
  boolean jdField_a_of_type_Boolean = false;
  
  public akvl(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public int a()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 0;
      int i = bcof.b(2, 0, "ANY", "UTF-8");
      int j = bcof.b((int[])localObject, localObject.length);
      localObject = bcof.a();
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), localObject }));
      }
      this.jdField_a_of_type_Boolean = true;
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, "initQbar fail!", localException);
      }
    }
    return -1;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bcof.b();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", localException);
    }
  }
  
  public void a(akuw paramakuw)
  {
    this.jdField_a_of_type_Akur = ((akur)paramakuw);
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool3 = false;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    boolean bool2 = false;
    float f2 = 0.0F;
    long l = System.currentTimeMillis();
    boolean bool1;
    float f1;
    if (bcof.b(paramArrayOfByte, paramInt1, paramInt2, 0) == 1)
    {
      bcof.b(localStringBuilder1, localStringBuilder2);
      bool1 = true;
      f1 = f2;
      if (this.jdField_a_of_type_Akur != null)
      {
        if (!bool1) {
          break label211;
        }
        this.jdField_a_of_type_Akur.a(localStringBuilder1.toString(), localStringBuilder2.toString(), false);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (!bool1) {
          break label227;
        }
        QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. type=%s data=%s qrRecog minicode_timecost=%d", new Object[] { localStringBuilder1, localStringBuilder2, Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return bool1;
      f1 = f2;
      bool1 = bool3;
      if (bcof.c() != 1) {
        break;
      }
      if (bcof.a.hasQrcode == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        f1 = f2;
        bool2 = paramBoolean;
        bool1 = bool3;
        if (!paramBoolean) {
          break;
        }
        f1 = bcof.a.qrcodeAreaRatio;
        bool2 = paramBoolean;
        bool1 = bool3;
        break;
      }
      label211:
      this.jdField_a_of_type_Akur.a(bool2, f1);
    }
    label227:
    QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", new Object[] { Boolean.valueOf(bool2), Float.valueOf(f1), Long.valueOf(System.currentTimeMillis() - l) }));
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akvl
 * JD-Core Version:    0.7.0.1
 */