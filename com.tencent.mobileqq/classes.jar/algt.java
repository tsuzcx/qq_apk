import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class algt
{
  static algt jdField_a_of_type_Algt;
  int jdField_a_of_type_Int = 0;
  private alhf jdField_a_of_type_Alhf = new alha(this);
  alhj jdField_a_of_type_Alhj;
  public Context a;
  public bgkw a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new algz(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private algt()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static algt a()
  {
    if (jdField_a_of_type_Algt == null) {
      jdField_a_of_type_Algt = new algt();
    }
    return jdField_a_of_type_Algt;
  }
  
  private void d()
  {
    alhk.a().a(this.jdField_a_of_type_Alhj, new algu(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a();
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Alhj = new alhj(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, alhi.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Alhf);
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new alhd();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bgkw parambgkw)
  {
    this.jdField_a_of_type_Bgkw = parambgkw;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    alhb.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new algv(this));
  }
  
  public void a(boolean paramBoolean)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new algx(this));
  }
  
  boolean a()
  {
    try
    {
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      int i = localGraphicRendererMgr.getRecvDecoderFrameFunctionptr();
      QLog.e("AVEngineWalper", 1, "mgr=" + String.valueOf(localGraphicRendererMgr) + ", nFunID=" + String.valueOf(i));
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AVEngineWalper", 1, "CheckGraphicMgrStart stack=" + QLog.getStackTraceString(localThrowable));
    }
    return false;
  }
  
  public void b()
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bgkx.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new algw(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new algy(this));
  }
  
  public void c()
  {
    alhb.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algt
 * JD-Core Version:    0.7.0.1
 */