import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.10;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.11;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class alaw
  implements alad, ARNativeBridge.ActionCallback
{
  private volatile int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private akxq jdField_a_of_type_Akxq;
  private alaf jdField_a_of_type_Alaf;
  private alax jdField_a_of_type_Alax;
  private Context jdField_a_of_type_AndroidContentContext;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private volatile int c = 1;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public alaw(alaf paramalaf, alax paramalax, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Alaf = paramalaf;
    this.jdField_a_of_type_Alax = paramalax;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Alaf.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.jdField_a_of_type_Alaf.a(0));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "setNativeState, mCurState=" + this.jdField_a_of_type_Int + ", new State=" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 11: 
    default: 
      return;
    case 2: 
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.b = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.b, this.jdField_a_of_type_Alax.b, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_Alax.c, this.d, this.e, 100);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(this);
      a(7);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeonSurfaceChanged(this.b, this.d, this.e);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.b);
      this.c = 0;
      a(11);
      return;
    case 9: 
      this.jdField_a_of_type_Alaf.a(new Interactive3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.b);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.b);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.b = 0;
    if (this.jdField_a_of_type_Akxq != null)
    {
      this.jdField_a_of_type_Akxq.b();
      this.jdField_a_of_type_Akxq.c();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(alal paramalal)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.b, paramalal.a, (float[])paramalal.a("CAMERA_POSITION"));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "playEffectMusic, " + paramString);
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.10(this, paramString));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Alax.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "playBgMusic, " + paramString);
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.11(this, paramString));
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Alax.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "init");
    }
  }
  
  public void callback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    if (this.jdField_a_of_type_Alaf == null) {}
    do
    {
      return;
      switch (paramInt1)
      {
      case 57: 
      default: 
        this.jdField_a_of_type_Alaf.a(this, this.jdField_a_of_type_Alax.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, paramInt1, 0, paramString2);
        return;
      }
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 300L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a("res/music/fudai_click.mp3");
    return;
    a("res/music/fudai_explode.mp3");
    return;
    a("res/music/fudai_appear.mp3");
    b("res/music/fudai_background.mp3");
    return;
    b("res/music/gameing_background.mp3");
    return;
    b("res/music/gameend_background.mp3");
    return;
    a("res/music/redpack_get.mp3");
    return;
    a("res/music/aimed.mp3");
    return;
    this.g += 1;
    this.f += paramInt2;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "start");
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      String str = this.jdField_a_of_type_Alax.c;
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = (str + "res/music/loading.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[1] = (str + "res/music/321ready.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[2] = (str + "res/music/redpack_open.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[3] = (str + "res/music/fudai_click.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[4] = (str + "res/music/fudai_explode.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[5] = (str + "res/music/fudai_appear.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[6] = (str + "res/music/redpack_get.mp3");
      this.jdField_a_of_type_ArrayOfJavaLangString[7] = (str + "res/music/aimed.mp3");
      this.jdField_a_of_type_Akxq = new akxq(1, this.jdField_a_of_type_ArrayOfJavaLangString);
      a(2);
      this.g = 0;
      this.f = 0;
    }
    if (this.jdField_a_of_type_Alaf != null) {
      this.jdField_a_of_type_Alaf.a(this, this.jdField_a_of_type_Alax.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 100, 0, null);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 9) && (this.b != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 11)
    {
      int i = this.c + 1;
      this.c = i;
      if (i >= 2) {
        a(9);
      }
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, " + this);
    }
    if (this.jdField_a_of_type_Int == 9)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, queueEvent, " + this);
      }
      if ((this.jdField_a_of_type_Alaf != null) && (this.jdField_a_of_type_Boolean == true))
      {
        this.jdField_a_of_type_Alaf.b(1, 0);
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Alaf != null)
      {
        this.jdField_a_of_type_Alaf.a(this.jdField_a_of_type_Alax.jdField_a_of_type_JavaLangString);
        QLog.d("AREngine_Interactive3DRenderable", 2, "onDestroy, remove hsRender here, " + this);
        this.jdField_a_of_type_Alaf.a(this, this.jdField_a_of_type_Alax.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 101, 0, null);
      }
      if (this.jdField_a_of_type_Int == 9) {
        a(10);
      }
    }
    if (this.g > 0)
    {
      float f1 = this.f * 1.0F / this.g;
      HashMap localHashMap = new HashMap();
      localHashMap.put("fps_total", String.valueOf(this.f));
      localHashMap.put("fps_count", String.valueOf(this.g));
      localHashMap.put("fps_avg", String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(f1) }));
      axrl.a(BaseApplicationImpl.getContext()).a(BaseActivity.sTopActivity.getCurrentAccountUin(), "binhai_fps", true, 0L, 0L, localHashMap, "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alaw
 * JD-Core Version:    0.7.0.1
 */