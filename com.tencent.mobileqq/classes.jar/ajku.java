import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class ajku
{
  static ajku jdField_a_of_type_Ajku;
  int jdField_a_of_type_Int = 0;
  private ajlg jdField_a_of_type_Ajlg = new ajlb(this);
  ajlk jdField_a_of_type_Ajlk;
  public Context a;
  public bega a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new ajla(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private ajku()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static ajku a()
  {
    if (jdField_a_of_type_Ajku == null) {
      jdField_a_of_type_Ajku = new ajku();
    }
    return jdField_a_of_type_Ajku;
  }
  
  private void d()
  {
    ajll.a().a(this.jdField_a_of_type_Ajlk, new ajkv(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a();
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ajlk = new ajlk(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, ajlj.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ajlg);
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new ajle();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bega parambega)
  {
    this.jdField_a_of_type_Bega = parambega;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new ajkw(this));
  }
  
  public void a(boolean paramBoolean)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new ajky(this));
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
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    begb.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new ajkx(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new ajkz(this));
  }
  
  public void c()
  {
    ajlc.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajku
 * JD-Core Version:    0.7.0.1
 */