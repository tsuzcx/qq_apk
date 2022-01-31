import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class alce
{
  static alce jdField_a_of_type_Alce;
  int jdField_a_of_type_Int = 0;
  private alcq jdField_a_of_type_Alcq = new alcl(this);
  alcu jdField_a_of_type_Alcu;
  public Context a;
  public bggp a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new alck(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private alce()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static alce a()
  {
    if (jdField_a_of_type_Alce == null) {
      jdField_a_of_type_Alce = new alce();
    }
    return jdField_a_of_type_Alce;
  }
  
  private void d()
  {
    alcv.a().a(this.jdField_a_of_type_Alcu, new alcf(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a();
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Alcu = new alcu(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, alct.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Alcq);
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new alco();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bggp parambggp)
  {
    this.jdField_a_of_type_Bggp = parambggp;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    alcm.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new alcg(this));
  }
  
  public void a(boolean paramBoolean)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new alci(this));
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
    alcm.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bggq.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new alch(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new alcj(this));
  }
  
  public void c()
  {
    alcm.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */