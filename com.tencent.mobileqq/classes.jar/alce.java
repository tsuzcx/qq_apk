import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowSpriteAioScript.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class alce
  implements akrq
{
  protected int a;
  protected albj a;
  protected alcc a;
  public alcg a;
  protected String a;
  protected boolean a;
  protected String b;
  
  public alce(int paramInt, alcg paramalcg, alcc paramalcc)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_Alcg = paramalcg;
    this.jdField_a_of_type_Alcc = paramalcc;
    QLog.i("CmShow_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.b);
  }
  
  public alce(int paramInt, String paramString, alcg paramalcg, alcc paramalcc)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString;
    this.jdField_a_of_type_Alcg = paramalcg;
    this.jdField_a_of_type_Alcc = paramalcc;
    QLog.i("CmShow_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.b);
  }
  
  public int a()
  {
    return 300;
  }
  
  public akra a()
  {
    if (this.jdField_a_of_type_Alcg == null) {
      return null;
    }
    return this.jdField_a_of_type_Alcg.a();
  }
  
  public akrw a(long paramLong, String paramString1, String paramString2)
  {
    return null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aliu.av).append(this.b);
    return localStringBuilder.toString();
  }
  
  public void a() {}
  
  public void a(albj paramalbj)
  {
    this.jdField_a_of_type_Albj = paramalbj;
  }
  
  public void a(String paramString)
  {
    a(paramString, 0, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Alcg == null)) {
      QLog.w("CmShow_SpriteAioScript", 1, "[execScriptInRenderThread], script is null.");
    }
    akra localakra;
    do
    {
      return;
      localakra = this.jdField_a_of_type_Alcg.a();
    } while (localakra == null);
    localakra.runRenderTask(new CmShowSpriteAioScript.1(this, paramString, localakra, paramInt, paramBoolean));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("CmShow_SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
    }
    while ((TextUtils.isEmpty(paramString)) || (!"0".equals(paramString))) {
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("CmShow_SpriteAioScript", 1, "script is already read, scriptName:" + this.b);
      return true;
    }
    this.jdField_a_of_type_Boolean = b();
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = true;
    if (!new alkx(paramString + ".sig", paramString).a(1))
    {
      QLog.w("CmShow_SpriteAioScript", 1, "verify fails, path:" + paramString);
      e();
      bool = false;
    }
    return bool;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public boolean b()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(aknx.e)))
      {
        this.jdField_a_of_type_JavaLangString = aknx.e;
        QLog.i("CmShow_SpriteAioScript", 1, "Succeed to read script 0 from cache");
        return true;
      }
      String str = a();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      localFile = new File(str);
      if (!localFile.exists())
      {
        QLog.w("CmShow_SpriteAioScript", 1, "Fail to read script file. " + localFile.getAbsolutePath());
        f();
        if (TextUtils.isEmpty(aliu.au)) {
          alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 202, new Object[] { "Fail to read script file:", str });
        } else {
          alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 200, new Object[] { "Fail to read script file:", str });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("CmShow_SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
      alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
      return false;
      if (!a(localOutOfMemoryError))
      {
        alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 201, new Object[] { "Fail to verify script file:", localOutOfMemoryError });
        return false;
      }
      this.jdField_a_of_type_JavaLangString = bdhb.b(localFile);
      QLog.i("CmShow_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.jdField_a_of_type_Int);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteAioScript", 1, "[loadScript]:", localThrowable);
      alhp.a(this.jdField_a_of_type_Alcg.a(), 300, 30, new Object[] { "loadScript:", localThrowable });
      return false;
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        if (100 == this.jdField_a_of_type_Int)
        {
          QLog.d("CmShow_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          a(this.jdField_a_of_type_JavaLangString, 5, false);
          b();
          return;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          QLog.d("CmShow_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          a(this.jdField_a_of_type_JavaLangString, 3, false);
          continue;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmShow_SpriteAioScript", 1, localThrowable, new Object[0]);
        return;
      }
      StringBuilder localStringBuilder;
      localStringBuilder.append("(function(){").append(this.jdField_a_of_type_JavaLangString).append(";registerFunction(\"playAction_bid_").append(this.jdField_a_of_type_Int).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.jdField_a_of_type_Int).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.jdField_a_of_type_Int).append("\", stopSpriteAction);").append("})();");
      a(localStringBuilder.toString());
    }
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(aliu.au)) {}
    while (new File(aliu.av + "cm3d.js").exists()) {
      return true;
    }
    return false;
  }
  
  public void d()
  {
    ApolloCmdChannel.getChannelFromOtherProcess(ApolloUtil.a()).addCmdHandler(this);
  }
  
  public void e()
  {
    QLog.w("CmShow_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    QQAppInterface localQQAppInterface = ApolloUtil.a();
    if (localQQAppInterface != null)
    {
      amqn.a(localQQAppInterface);
      return;
    }
    QLog.e("CmShow_SpriteAioScript", 1, "onVerifyFailure app is null");
  }
  
  public void f()
  {
    QLog.w("CmShow_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    QQAppInterface localQQAppInterface = ApolloUtil.a();
    if (localQQAppInterface != null)
    {
      amqn.a(localQQAppInterface);
      return;
    }
    QLog.e("CmShow_SpriteAioScript", 1, "onVerifyFailure app is null");
  }
  
  public void g()
  {
    ApolloCmdChannel localApolloCmdChannel = ApolloCmdChannel.getChannelFromOtherProcess(ApolloUtil.a());
    if (localApolloCmdChannel != null) {
      localApolloCmdChannel.removeCmdHandler(this);
    }
    this.jdField_a_of_type_Albj = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */