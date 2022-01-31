import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2;
import com.tencent.mobileqq.minicode.DecodeProxy;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class akux
  implements arnn
{
  private static long jdField_a_of_type_Long;
  public static volatile akux a;
  private static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private int jdField_a_of_type_Int = -1;
  private akou jdField_a_of_type_Akou;
  private arnk jdField_a_of_type_Arnk;
  private Set<Long> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private CopyOnWriteArrayList<WeakReference<arnn>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private CopyOnWriteArrayList<WeakReference<akvb>> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = akpb.a().f;
  private boolean l = akpb.a().g;
  
  private akux()
  {
    if (arni.a())
    {
      this.l = false;
      this.k = false;
    }
    if ((!g) || (arni.a(false) > 0))
    {
      g = true;
      ThreadManager.post(new MiniCodeController.2(this), 5, null, true);
    }
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!e) {}
    do
    {
      return -1;
      try
      {
        YuvProxy.Yuv2Rgba(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
        return 0;
      }
      catch (Throwable paramArrayOfInt) {}
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, "Yuv2Rgba exception", paramArrayOfInt);
    return -1;
  }
  
  private akou a()
  {
    try
    {
      if (this.jdField_a_of_type_Akou == null) {
        this.jdField_a_of_type_Akou = new akou();
      }
      akou localakou = this.jdField_a_of_type_Akou;
      return localakou;
    }
    finally {}
  }
  
  public static akux a()
  {
    if (jdField_a_of_type_Akux == null) {}
    try
    {
      if (jdField_a_of_type_Akux == null) {
        jdField_a_of_type_Akux = new akux();
      }
      return jdField_a_of_type_Akux;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return d;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!paramString.equals("____JAVA_EXCEPTION____")) && (!paramString.equals("____NATIVE_ERROR____")) && (!paramString.equals("____NATIVE_EXCEPTION____")) && (!paramString.startsWith("____NATIVE_ERROR____")) && (!paramString.startsWith("____NATIVE_EXCEPTION____"));
  }
  
  private void c()
  {
    if (d)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        akvb localakvb = (akvb)((WeakReference)localIterator.next()).get();
        if (localakvb != null) {
          localakvb.b();
        }
      }
    }
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (!d) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) }));
    }
    try
    {
      if (!f)
      {
        String str = DecodeProxy.getVersion();
        QLog.i("MiniRecog.MiniCodeController", 1, "call nativeDecode version = " + str);
        if (QLog.isColorLevel()) {
          DecodeProxy.setLogSwitch(true);
        }
        f = true;
      }
      paramArrayOfByte = DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", paramArrayOfByte);
    }
    return "____JAVA_EXCEPTION____";
  }
  
  public void a()
  {
    boolean bool1;
    boolean bool2;
    label47:
    Object localObject3;
    String str1;
    label91:
    label114:
    try
    {
      if ((this.k) && (!d))
      {
        bool1 = akvg.a();
        if (!bool1) {}
      }
      try
      {
        if (akvg.b("minicode") != 0) {
          break label522;
        }
        bool1 = true;
        d = bool1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Object localObject1;
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", localThrowable1);
        }
      }
      if (this.jdField_a_of_type_Int < 0) {
        break label550;
      }
      bool2 = true;
      if ((!this.l) || (!bool2)) {
        break label629;
      }
      localObject3 = akvi.b("QMCF_qr");
      str1 = akvh.b();
      if ((TextUtils.isEmpty(str1)) || (!str1.equalsIgnoreCase((String)localObject3))) {
        break label556;
      }
      bool1 = true;
      if (!QLog.isColorLevel()) {
        break label651;
      }
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label634;
      }
      localObject1 = "null";
    }
    finally {}
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("loadSoAndModel detectSoMd5=%s modelNeedMd5=%s bMatch=%b", new Object[] { localObject1, localObject3, Boolean.valueOf(bool1) }));
    label522:
    label651:
    for (;;)
    {
      boolean bool3;
      if ((this.l) && (bool2) && (!e) && (bool1))
      {
        bool3 = akvi.a();
        if (!bool3) {}
      }
      for (;;)
      {
        try
        {
          int m = akvi.b("QMCF_qr");
          int n = akvi.b("yuvutil");
          if ((m != 0) || (n != 0)) {
            continue;
          }
          bool3 = true;
          e = bool3;
        }
        catch (Throwable localThrowable2)
        {
          label550:
          label556:
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", localThrowable2);
          continue;
          jdField_a_of_type_Long = 0L;
          continue;
          arnk localarnk = this.jdField_a_of_type_Arnk;
          if (localarnk == null) {
            continue;
          }
          bool1 = true;
          continue;
          bool1 = false;
          continue;
        }
        if ((!this.l) || (!bool2) || (!e) || (!bool1) || (this.jdField_a_of_type_Arnk != null)) {
          continue;
        }
        bool1 = akvh.a();
        if (!bool1) {
          continue;
        }
        try
        {
          if (jdField_a_of_type_Long != 0L) {
            continue;
          }
          jdField_a_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_Arnk = new arnk(null, this.jdField_a_of_type_Int, 0, 0);
          this.jdField_a_of_type_Arnk.a(this);
          localObject1 = akvh.a() + File.separator + akvh.a("qr_detection_model.bin");
          localObject3 = akvh.a() + File.separator + akvh.a("qr_detection_model.txt");
          str1 = akvh.a() + File.separator + akvh.a("qr_anchor.bin");
          String str2 = arni.b();
          File localFile = new File(str2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          this.jdField_a_of_type_Arnk.a((String)localObject1, (String)localObject3, str1, str2);
          bool1 = true;
        }
        catch (Throwable localThrowable3)
        {
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", localThrowable3);
          bool1 = false;
          continue;
        }
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d", new Object[] { Boolean.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(bool2), Boolean.valueOf(this.k), Boolean.valueOf(this.l), Boolean.valueOf(bool1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        c();
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label47;
        bool1 = false;
        break label91;
        bool3 = false;
      }
      label629:
      bool1 = false;
      continue;
      label634:
      localObject3 = str1;
      if (str1 != null) {
        break label114;
      }
      localObject3 = "null";
      break label114;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      arnn localarnn = (arnn)((WeakReference)localIterator.next()).get();
      if (localarnn != null) {
        localarnn.a(paramInt);
      }
    }
    long l1;
    if (jdField_a_of_type_Long > 0L)
    {
      l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
      jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      ThreadManager.post(new MiniCodeController.1(this, paramInt, l1), 5, null, true);
      return;
      l1 = 0L;
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      arnn localarnn = (arnn)((WeakReference)localIterator.next()).get();
      if (localarnn != null) {
        localarnn.a(paramLong);
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong));
    }
    boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(bool) }));
    }
    if (bool) {
      try
      {
        if (this.jdField_a_of_type_Arnk != null)
        {
          this.jdField_a_of_type_Arnk.a();
          this.jdField_a_of_type_Arnk = null;
        }
        if (this.jdField_a_of_type_Akou != null) {
          this.jdField_a_of_type_Akou.a();
        }
        this.i = false;
        this.j = false;
        jdField_a_of_type_Akux = null;
        return;
      }
      finally {}
    }
  }
  
  public void a(akvb paramakvb)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      akvb localakvb = (akvb)((WeakReference)localIterator.next()).get();
      if ((localakvb != null) && (localakvb == paramakvb)) {
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramakvb));
  }
  
  public void a(Context paramContext, long paramLong, String paramString)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getApplicationContext();
        boolean bool = this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong));
        if ((bool) && (QLog.isColorLevel())) {
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("init busiHash=%d desc=%s", new Object[] { Long.valueOf(paramLong), paramString }));
        }
        if (!bool) {
          return;
        }
        paramString = a();
        if ((!this.i) && (!this.j))
        {
          this.j = true;
          paramString.a(paramContext, new akuz(this, paramString), new akva(this));
          if (d) {
            c();
          }
          a();
        }
        else
        {
          b();
        }
      }
      finally {}
    }
  }
  
  public void a(arnn paramarnn)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      arnn localarnn = (arnn)((WeakReference)localIterator.next()).get();
      if ((localarnn != null) && (localarnn == paramarnn)) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramarnn));
  }
  
  public void a(List<akut> paramList, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      arnn localarnn = (arnn)((WeakReference)localIterator.next()).get();
      if (localarnn != null) {
        localarnn.a(paramList, paramLong);
      }
    }
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    arnk localarnk = this.jdField_a_of_type_Arnk;
    boolean bool1;
    if ((!e) || (!this.h) || (localarnk == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localarnk.a(paramBitmap, paramLong);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("detect async exec=%b ts=%d", new Object[] { Boolean.valueOf(bool2), Long.valueOf(paramLong) }));
    return bool2;
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong, Rect paramRect)
  {
    arnk localarnk = this.jdField_a_of_type_Arnk;
    if ((!e) || (localarnk == null) || (paramRect == null)) {
      return false;
    }
    Object localObject = new Object();
    boolean bool2 = this.h;
    int m;
    if (bool2) {
      m = 3000;
    }
    for (;;)
    {
      boolean[] arrayOfBoolean = new boolean[1];
      arrayOfBoolean[0] = false;
      paramRect = new akuy(this, paramRect, paramLong, localObject, localarnk, arrayOfBoolean, paramBitmap);
      boolean bool1;
      if ((bool2) && (localarnk.a(paramBitmap, paramLong)))
      {
        bool1 = true;
        label97:
        arrayOfBoolean[0] = bool1;
        if ((bool2) && ((!bool2) || (arrayOfBoolean[0] == 0))) {
          break label232;
        }
        bool1 = true;
        label123:
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync needWait=%b bReady=%b exec=%b ts=%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(arrayOfBoolean[0]), Long.valueOf(paramLong) }));
        }
        if (bool1)
        {
          localarnk.a(paramRect);
          paramLong = m;
        }
      }
      try
      {
        localObject.wait(paramLong);
        localarnk.b(paramRect);
        return arrayOfBoolean[0];
        m = 5000;
        continue;
        bool1 = false;
        break label97;
        label232:
        bool1 = false;
        break label123;
      }
      catch (InterruptedException paramBitmap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, "detectSync wait InterruptedException", paramBitmap);
          }
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    int m = 1;
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          localStringBuilder = new StringBuilder("requestDownloadResourceIfNeed");
        }
        if ((!d) && (!this.jdField_a_of_type_Boolean))
        {
          if (!akvg.a()) {
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" decode 0");
          }
        }
        if (this.jdField_a_of_type_Int >= 0)
        {
          if ((this.l) && (m != 0) && (!e) && (!this.jdField_b_of_type_Boolean))
          {
            if (!akvi.a()) {
              break label232;
            }
            this.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" detect 0");
            }
          }
          if ((this.l) && (m != 0) && (this.jdField_a_of_type_Arnk == null) && (!this.c))
          {
            if (!akvh.a()) {
              break label264;
            }
            this.c = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" model 0");
            }
          }
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            QLog.i("MiniRecog.MiniCodeController", 2, localStringBuilder.toString());
          }
          return;
          if (this.jdField_a_of_type_Akou != null) {
            this.jdField_a_of_type_Akou.c(0);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder.append(" decode 1");
          continue;
        }
        m = 0;
      }
      finally {}
      continue;
      label232:
      if (this.jdField_a_of_type_Akou != null) {
        this.jdField_a_of_type_Akou.c(1);
      }
      if (QLog.isColorLevel())
      {
        localObject.append(" detect 1");
        continue;
        label264:
        if (this.jdField_a_of_type_Akou != null) {
          this.jdField_a_of_type_Akou.c(2);
        }
        if (QLog.isColorLevel()) {
          localObject.append(" model 1");
        }
      }
    }
  }
  
  public void b(arnn paramarnn)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      arnn localarnn = (arnn)localWeakReference.get();
      if ((localarnn != null) && (localarnn == paramarnn)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public void c(arnn paramarnn)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      akvb localakvb = (akvb)localWeakReference.get();
      if ((localakvb != null) && (localakvb == paramarnn)) {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akux
 * JD-Core Version:    0.7.0.1
 */