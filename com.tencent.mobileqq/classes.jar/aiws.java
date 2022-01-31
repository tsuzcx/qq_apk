import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class aiws
{
  static aiws jdField_a_of_type_Aiws;
  int jdField_a_of_type_Int = 0;
  private aixe jdField_a_of_type_Aixe = new aiwz(this);
  aixi jdField_a_of_type_Aixi;
  public Context a;
  public bdby a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new aiwy(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private aiws()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aiws a()
  {
    if (jdField_a_of_type_Aiws == null) {
      jdField_a_of_type_Aiws = new aiws();
    }
    return jdField_a_of_type_Aiws;
  }
  
  private void d()
  {
    aixj.a().a(this.jdField_a_of_type_Aixi, new aiwt(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a();
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aixi = new aixi(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, aixh.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Aixe);
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new aixc();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bdby parambdby)
  {
    this.jdField_a_of_type_Bdby = parambdby;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    aixa.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new aiwu(this));
  }
  
  public void a(boolean paramBoolean)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new aiww(this));
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
    aixa.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bdbz.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new aiwv(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new aiwx(this));
  }
  
  public void c()
  {
    aixa.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiws
 * JD-Core Version:    0.7.0.1
 */