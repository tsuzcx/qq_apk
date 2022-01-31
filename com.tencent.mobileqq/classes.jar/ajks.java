import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class ajks
{
  static ajks jdField_a_of_type_Ajks;
  int jdField_a_of_type_Int = 0;
  private ajle jdField_a_of_type_Ajle = new ajkz(this);
  ajli jdField_a_of_type_Ajli;
  public Context a;
  public begr a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new ajky(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private ajks()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static ajks a()
  {
    if (jdField_a_of_type_Ajks == null) {
      jdField_a_of_type_Ajks = new ajks();
    }
    return jdField_a_of_type_Ajks;
  }
  
  private void d()
  {
    ajlj.a().a(this.jdField_a_of_type_Ajli, new ajkt(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a();
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ajli = new ajli(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, ajlh.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ajle);
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new ajlc();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(begr parambegr)
  {
    this.jdField_a_of_type_Begr = parambegr;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    ajla.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new ajku(this));
  }
  
  public void a(boolean paramBoolean)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new ajkw(this));
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
    ajla.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    begs.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new ajkv(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new ajkx(this));
  }
  
  public void c()
  {
    ajla.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajks
 * JD-Core Version:    0.7.0.1
 */