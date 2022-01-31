import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ARWorldCupCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.10;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.12;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.15;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.18;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.4;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.6;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.8;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.9;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.youtu.arsdk.ARShell;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class akma
  implements akjo, akju, aklr, Handler.Callback, View.OnTouchListener, ARNativeBridge.ARWorldCupCallback
{
  public volatile int a;
  volatile long jdField_a_of_type_Long = -1L;
  private akjn jdField_a_of_type_Akjn = new akjn(this, 1);
  private akjp jdField_a_of_type_Akjp;
  private akjs jdField_a_of_type_Akjs;
  private akjt jdField_a_of_type_Akjt;
  private akjv jdField_a_of_type_Akjv;
  private aklt jdField_a_of_type_Aklt;
  private akmc jdField_a_of_type_Akmc;
  private akqs jdField_a_of_type_Akqs;
  private aljf jdField_a_of_type_Aljf;
  private aljj jdField_a_of_type_Aljj = new akmb(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public beez a;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ARTransferPromotionRenderable.2(this);
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public volatile int b;
  private boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private volatile int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  private volatile int i;
  
  public akma(aklt paramaklt, akmc paramakmc)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Aklt = paramaklt;
    this.jdField_a_of_type_Akmc = paramakmc;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Aklt.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)paramaklt.a(0));
    this.jdField_a_of_type_Akjt = ((akjt)paramaklt.a(8));
    boolean bool = akmu.a();
    int j;
    long l;
    if (this.jdField_a_of_type_Boolean)
    {
      paramaklt = this.jdField_a_of_type_AndroidContentContext;
      if (bool)
      {
        j = 5;
        this.jdField_a_of_type_Aljf = new aljf(paramaklt, j);
      }
    }
    else
    {
      this.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_Beez = new beez(ThreadManager.getSubThreadLooper(), this);
      this.jdField_c_of_type_Boolean = akmu.jdField_a_of_type_Boolean;
      l = System.currentTimeMillis();
      if (!ARShell.loadArCoreNativeLibrary()) {
        break label304;
      }
    }
    label304:
    for (paramaklt = akqo.a().a((Activity)this.jdField_a_of_type_AndroidContentContext);; paramaklt = null)
    {
      this.jdField_a_of_type_Akqs = paramaklt;
      if (this.jdField_a_of_type_Akqs != null)
      {
        this.jdField_a_of_type_Akjn.a();
        this.jdField_a_of_type_Akqs.a(this.jdField_a_of_type_AndroidContentContext);
        akjk.jdField_a_of_type_Int = 9;
      }
      QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable init arcore cost:" + (System.currentTimeMillis() - l));
      ThreadManager.post(new ARTransferPromotionRenderable.4(this), 8, null, true);
      return;
      j = 4;
      break;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(paramInt) }));
    }
    this.jdField_d_of_type_Int = paramInt;
    switch (this.jdField_d_of_type_Int)
    {
    case 5: 
    default: 
    case 2: 
    case 3: 
    case 6: 
      do
      {
        return;
        ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.jdField_c_of_type_Int, "test.scene", this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_Akmc.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, 88);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setPreLoadTransferDoorFlags();
        if (this.jdField_a_of_type_Akqs != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(1);
        }
        for (;;)
        {
          a(3);
          return;
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.jdField_c_of_type_Int);
        a(5);
        this.jdField_e_of_type_Int = 0;
        return;
        this.jdField_a_of_type_Aklt.a(new ARTransferPromotionRenderable.11(this));
      } while (!QLog.isColorLevel());
      QLog.d("ARTransferPromotionRenderable", 2, "enter STATE_ENGINE_DRAW status");
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
  }
  
  private void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int k = 1;
    QLog.d("ARTransferPromotionRenderable", 1, "tryPlayGameVideoAndSwitchStatus  " + paramInt1 + "|" + paramString);
    File localFile = new File(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      j = k;
      if (!paramString.startsWith("http")) {
        if (!paramString.startsWith("https")) {
          break label119;
        }
      }
    }
    label119:
    for (int j = k;; j = 0)
    {
      if ((localFile.exists()) || (j != 0))
      {
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Akjn.a(paramString, 123456L, paramBoolean1, paramInt2, paramBoolean2);
      }
      return;
    }
  }
  
  private void a(float[] arg1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (paramArrayOfFloat5 != null) && (this.jdField_b_of_type_Int < 6))
    {
      if (this.jdField_a_of_type_Akqs != null) {
        break label157;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat5[0], paramArrayOfFloat5[1], paramArrayOfFloat5[2], paramArrayOfFloat5[3]);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        paramArrayOfFloat3 = (Runnable)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (paramArrayOfFloat3 == null) {
          continue;
        }
        long l1 = System.currentTimeMillis();
        paramArrayOfFloat3.run();
        long l2 = System.currentTimeMillis();
        if (l2 - l1 < 200L) {
          continue;
        }
        QLog.d("ARTransferPromotionRenderable", 1, "event queue cost too long: " + (l2 - l1));
      }
      label157:
      a(paramArrayOfFloat5);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_c_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_e_of_type_Boolean)
    {
      int j = this.i + 1;
      this.i = j;
      if (j >= 1)
      {
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.9(this));
        this.jdField_a_of_type_Akjt.b(true);
        ??? = this.jdField_a_of_type_Akjt;
        this.jdField_a_of_type_Akjt.getClass();
        ???.c(6);
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.10(this));
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  private boolean a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_Akqs == null) {}
    while ((!this.jdField_a_of_type_Akqs.a()) || (this.jdField_a_of_type_Aklt.a() == null)) {
      return false;
    }
    paramArrayOfFloat = new float[4];
    float[] arrayOfFloat = new float[3];
    int j = this.jdField_a_of_type_Aklt.a().a();
    FloatBuffer localFloatBuffer = this.jdField_a_of_type_Akqs.a(j, paramArrayOfFloat, arrayOfFloat);
    if ((j == -1) || (localFloatBuffer == null))
    {
      a(-1.0F, -1.0F, -1.0F);
      return false;
    }
    this.jdField_a_of_type_Aklt.a().a(j);
    this.jdField_a_of_type_Aklt.a().a(localFloatBuffer, this.jdField_a_of_type_Akqs.a());
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
    if ((this.jdField_b_of_type_Int <= 5) && (this.jdField_b_of_type_Int >= 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.updateCameraTranslate(arrayOfFloat, paramArrayOfFloat);
      a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    }
    return true;
  }
  
  private void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      return;
    }
  }
  
  private int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_getNativeGameStatus();
    }
    return this.jdField_b_of_type_Int;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Akqs != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "tryCreatARCore ");
      b(new ARTransferPromotionRenderable.15(this));
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Akqs != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "checkAndStartARCore ");
      akwj.a().e();
      this.jdField_a_of_type_Akqs.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      this.jdField_a_of_type_Akqs.c();
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Beez != null) && (!this.jdField_a_of_type_Beez.hasMessages(1105))) {
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1105, 200L);
    }
    QLog.d("ARTransferPromotionRenderable", 2, "startMediaTimeListener ");
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Beez != null)
    {
      this.jdField_a_of_type_Beez.removeMessages(1105);
      this.jdField_a_of_type_Akjt.a(false, "");
    }
    QLog.d("ARTransferPromotionRenderable", 2, "stopMediaTimeListener ");
  }
  
  public int a()
  {
    if (this.jdField_d_of_type_Int != 6) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus status " + paramInt);
    }
    b(new ARTransferPromotionRenderable.13(this, paramInt));
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Akmc.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "directlyEnterTransferDoor");
    }
    this.jdField_a_of_type_Akjt.f();
    this.jdField_a_of_type_Akjt.a(false, "");
    awqx.b(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, this.jdField_a_of_type_Akmc.jdField_a_of_type_JavaLangString, "0", "0", "");
    b(new ARTransferPromotionRenderable.12(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Akqs != null) {
      b(new ARTransferPromotionRenderable.8(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange mCurrentPrePareChangeStatus " + this.jdField_a_of_type_Int + "|" + paramInt1 + "|" + this.jdField_b_of_type_Int + "|status" + paramInt2);
    b(new ARTransferPromotionRenderable.14(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b(new ARTransferPromotionRenderable.19(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(aklz paramaklz)
  {
    a((float[])paramaklz.a("TARGET_SIZE"), (float[])paramaklz.a("POSE"), (float[])paramaklz.a("CAMERA_MATRIX"), (float[])paramaklz.a("CAMERA_POSITION"), paramaklz.a);
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setOnTouchListener(this);
      QLog.d("ARTransferPromotionRenderable", 2, "setContainer  success");
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Aklt != null) {
      this.jdField_a_of_type_Aklt.a(paramRunnable);
    }
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    b(new ARTransferPromotionRenderable.20(this, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3));
  }
  
  public boolean a()
  {
    return (this.jdField_d_of_type_Int == 6) && (this.jdField_c_of_type_Int != 0);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Akmc.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Akmc.c;
  }
  
  public void b()
  {
    b(new ARTransferPromotionRenderable.21(this));
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Akmc.jdField_b_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Akmc.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "init test start +" + this);
    this.jdField_a_of_type_Long = Thread.currentThread().getId();
    this.jdField_a_of_type_Akjt.a(this);
    if (!this.jdField_a_of_type_Akmc.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_a_of_type_Akjt.e();
    }
    if ((this.jdField_a_of_type_Aljf != null) && (this.jdField_a_of_type_Boolean)) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Aljf.a(this.jdField_a_of_type_Aljj)) }));
    }
  }
  
  public boolean c()
  {
    return !this.jdField_a_of_type_Akmc.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void d()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "start from this cluase second");
    if (1 == this.jdField_d_of_type_Int) {
      a(2);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_d_of_type_Int == 6) && (this.jdField_c_of_type_Int != 0);
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Int == 5)
    {
      int j = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = j;
      if (j >= 2) {
        a(6);
      }
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if (this.jdField_a_of_type_Beez != null) {
      this.jdField_a_of_type_Beez.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.6(this));
    ARTransferPromotionRenderable.7 local7 = new ARTransferPromotionRenderable.7(this);
    if (this.jdField_a_of_type_Long == Thread.currentThread().getId())
    {
      local7.run();
      QLog.e("ARTransferPromotionRenderable", 1, "onDestroy in GLThread.");
      return;
    }
    if (this.jdField_a_of_type_Aklt != null) {
      this.jdField_a_of_type_Aklt.a(local7);
    }
    QLog.e("ARTransferPromotionRenderable", 1, "onDestroy not in GLThread.");
  }
  
  public void g()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "startCameraAniamtion ");
    b(new ARTransferPromotionRenderable.18(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Akjn != null) && (this.jdField_a_of_type_Akjn.a()) && (this.jdField_a_of_type_Akjv != null))
    {
      long l = this.jdField_a_of_type_Akjn.a();
      paramMessage = this.jdField_a_of_type_Akjv.a(l);
      if (paramMessage != null) {
        break label98;
      }
      this.jdField_a_of_type_Akjt.a(false, "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1105, 200L);
      return false;
      label98:
      this.jdField_a_of_type_Akjt.a(true, paramMessage.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void nativeCallBack(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "nativeCallBack  " + paramInt1 + "|" + paramInt2);
    b(new ARTransferPromotionRenderable.16(this, paramInt1));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onTouch mNativeGameStatus=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    paramView.getWidth();
    new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 2: 
    default: 
      return false;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      g();
      paramView.setVisibility(8);
      QLog.d("ARTransferPromotionRenderable", 2, "start cameraAnimation here");
      return false;
    }
    if (this.jdField_b_of_type_Int == 4)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        QLog.d("ARTransferPromotionRenderable", 2, "onTouch event not deal ready");
        return false;
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Aklt != null) && (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null)) {
        this.jdField_a_of_type_Aklt.a(new ARTransferPromotionRenderable.17(this, paramView));
      }
      QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER click operation");
      return false;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "onTouch doNothing");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akma
 * JD-Core Version:    0.7.0.1
 */