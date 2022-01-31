import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.model.CameraProxy.1;
import com.tencent.mobileqq.ar.model.CameraProxy.2;
import com.tencent.mobileqq.ar.model.CameraProxy.3;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class akwj
  implements akrb, Camera.PreviewCallback
{
  public static HandlerThread a;
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private akqy jdField_a_of_type_Akqy;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WeakReference<akwm> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<WeakReference<akrb>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private volatile byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 1;
  private ArrayList<WeakReference<akwk>> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private ArrayList<WeakReference<akwm>> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  private int e = 17;
  private int f = 10;
  private int g;
  
  private akwj()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    this.jdField_a_of_type_Akqy = new akqy();
    if (Build.MODEL.equalsIgnoreCase("Redmi Note 3")) {}
    for (this.jdField_a_of_type_Long = 500L;; this.jdField_a_of_type_Long = 300L)
    {
      this.f = 0;
      return;
    }
  }
  
  public static akwj a()
  {
    return akwl.a();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        i = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            break label102;
          }
          if (paramBoolean) {
            ((akwk)localWeakReference.get()).b();
          } else {
            ((akwk)localWeakReference.get()).b(paramInt1, paramInt2);
          }
        }
      }
      return;
      label102:
      i -= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String a()
  {
    String str = null;
    int i = this.g;
    if (Build.MODEL.equalsIgnoreCase("M1 E")) {
      i = 90;
    }
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      str = atet.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.d, this.e, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraProxy", 2, String.format("getLastPreviewFrame, path: %s, rotation: %s", new Object[] { str, Integer.valueOf(i) }));
    }
    return str;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.c();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      QLog.i("CameraProxy", 2, "openCamera mCurCameraState = " + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.f = 0;
    a(new CameraProxy.1(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(akrb paramakrb)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramakrb) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramakrb));
  }
  
  public void a(akwk paramakwk)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramakwk) {
          return;
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(new WeakReference(paramakwk));
      return;
    }
  }
  
  public void a(akwm paramakwm)
  {
    if (paramakwm == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakwm);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean))
    {
      QLog.i("CameraProxy", 2, "startCameraPreview return now");
      return;
    }
    a(new CameraProxy.2(this, paramSurfaceTexture));
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (jdField_a_of_type_AndroidOsHandlerThread)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((akrb)localWeakReference.get()).a(paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akqy != null) {
      return this.jdField_a_of_type_Akqy.a(paramFloat, paramBoolean);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.jdField_a_of_type_Akqy.a(paramBoolean);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.d();
    }
  }
  
  public void b(akrb paramakrb)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j) {
      if (((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get() != paramakrb) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void b(akwk paramakwk)
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        int j = this.jdField_b_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if (((WeakReference)this.jdField_b_of_type_JavaUtilArrayList.get(i)).get() != paramakwk) {
            break label71;
          }
          if (i != -1) {
            this.jdField_b_of_type_JavaUtilArrayList.remove(i);
          }
          return;
        }
      }
      int i = -1;
      continue;
      label71:
      i += 1;
    }
  }
  
  public void b(akwm paramakwm)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramakwm) {
          return;
        }
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(new WeakReference(paramakwm));
      return;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.b();
    }
  }
  
  public void c(akwm paramakwm)
  {
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int j = this.jdField_c_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if (((WeakReference)this.jdField_c_of_type_JavaUtilArrayList.get(i)).get() != paramakwm) {
            break label71;
          }
          if (i != -1) {
            this.jdField_c_of_type_JavaUtilArrayList.remove(i);
          }
          return;
        }
      }
      int i = -1;
      continue;
      label71:
      i += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akqy != null) {
      this.jdField_a_of_type_Akqy.e();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.i("CameraProxy", 2, "closeCamera mCurCameraState = " + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Int = 3;
    a(new CameraProxy.3(this));
  }
  
  public void f()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        int i = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label172;
        }
        WeakReference localWeakReference = (WeakReference)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        if (localWeakReference.get() != null)
        {
          bool2 = ((akwm)localWeakReference.get()).a(paramArrayOfByte);
          bool1 = bool2;
          if (bool2)
          {
            if ((!bool2) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
              ((akwm)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramArrayOfByte);
            }
            if (this.jdField_a_of_type_Int != 2) {
              break label164;
            }
            this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            if (this.jdField_a_of_type_Akqy != null) {
              this.g = this.jdField_a_of_type_Akqy.d();
            }
            paramCamera.addCallbackBuffer(paramArrayOfByte);
            return;
          }
        }
        i -= 1;
        continue;
        this.jdField_a_of_type_ArrayOfByte = null;
      }
      finally {}
      label164:
      continue;
      label172:
      boolean bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akwj
 * JD-Core Version:    0.7.0.1
 */