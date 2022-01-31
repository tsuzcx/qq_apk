import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteAioScript.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class ajer
  implements aivp
{
  protected int a;
  public ajez a;
  protected ajfe a;
  protected ajfi a;
  protected String a;
  protected boolean a;
  protected String b;
  
  public ajer(int paramInt, ajez paramajez)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_Ajez = paramajez;
    if ((paramajez != null) && (paramajez.a() != null)) {
      this.jdField_a_of_type_Ajfe = ((ajfe)paramajez.a().getManager(249));
    }
    QLog.i("cmshow_scripted_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.b);
  }
  
  private void b(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    String str = ajki.b(paramString, paramQQAppInterface);
    if (TextUtils.isEmpty(str))
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeFaceDress faceData:", str });
    }
    ajfa.a(paramQQAppInterface, str, new ajeu(this, paramBoolean, paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2));
  }
  
  public int a()
  {
    return 300;
  }
  
  public aiuz a()
  {
    if (this.jdField_a_of_type_Ajez == null) {
      return null;
    }
    return this.jdField_a_of_type_Ajez.a();
  }
  
  public aivv a(long paramLong, String paramString1, String paramString2)
  {
    return null;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_Ajez == null) {
      return null;
    }
    return this.jdField_a_of_type_Ajez.a();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ajms.av).append(this.b);
    return localStringBuilder.toString();
  }
  
  public void a() {}
  
  public void a(ajfi paramajfi)
  {
    this.jdField_a_of_type_Ajfi = paramajfi;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(String paramString)
  {
    a(paramString, 0, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Ajez == null)) {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "[execScriptInRenderThread], script is null.");
    }
    aiuz localaiuz;
    do
    {
      return;
      localaiuz = this.jdField_a_of_type_Ajez.a();
    } while (localaiuz == null);
    localaiuz.runRenderTask(new SpriteAioScript.1(this, paramString, localaiuz, paramInt, paramBoolean));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("cmshow_scripted_SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
    }
    label15:
    QQAppInterface localQQAppInterface;
    Object localObject;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            break label15;
            break label15;
            do
            {
              return;
            } while ((TextUtils.isEmpty(paramString)) || ("0".equals(paramString)));
            localQQAppInterface = a();
          } while (localQQAppInterface == null);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[checkDressRsc], uin:", paramString, ",notifyIfExist:", Boolean.valueOf(paramBoolean) });
          }
          localObject = ajki.a(paramString, a(), false);
        } while ((localObject == null) || (localObject.length != 2));
        i = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
      } while ((localObject == null) || (localObject.length == 0));
      if (2 != ((airx)localQQAppInterface.getManager(153)).b(paramString)) {
        break;
      }
    } while (!paramBoolean);
    a(localQQAppInterface, paramString, i, (int[])localObject, 0);
    return;
    ajfa.a(localQQAppInterface, paramString, i, (int[])localObject, new ajes(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = airx.a(a(), paramString);
    if (i != 2)
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    Object localObject = ajki.a(paramString, i, a(), false);
    i = ((Integer)localObject[0]).intValue();
    if (localObject[1] == null) {}
    for (localObject = null;; localObject = (int[])localObject[1])
    {
      if ((i > 0) && (localObject != null) && (localObject.length != 0)) {
        break label116;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
    label116:
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeDress roleId:", Integer.valueOf(paramInt1), ", dressIds:", Arrays.toString((int[])localObject) });
    }
    ajfa.b(paramQQAppInterface, paramString, i, (int[])localObject, new ajet(this, paramBoolean, paramInt1, paramArrayOfInt));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "script is already read, scriptName:" + this.b);
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
    if (!new ajov(paramString + ".sig", paramString).a(1))
    {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "verify fails, path:" + paramString);
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
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(airx.e)))
      {
        this.jdField_a_of_type_JavaLangString = airx.e;
        QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script 0 from cache");
        return true;
      }
      String str = a();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      localFile = new File(str);
      if (!localFile.exists())
      {
        QLog.w("cmshow_scripted_SpriteAioScript", 1, "Fail to read script file. " + localFile.getAbsolutePath());
        f();
        if (TextUtils.isEmpty(ajms.au)) {
          ajlo.a(this.jdField_a_of_type_Ajez.a(), 300, 202, new Object[] { "Fail to read script file:", str });
        } else {
          ajlo.a(this.jdField_a_of_type_Ajez.a(), 300, 200, new Object[] { "Fail to read script file:", str });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
      ajlo.a(this.jdField_a_of_type_Ajez.a(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
      return false;
      if (!a(localOutOfMemoryError))
      {
        ajlo.a(this.jdField_a_of_type_Ajez.a(), 300, 201, new Object[] { "Fail to verify script file:", localOutOfMemoryError });
        return false;
      }
      this.jdField_a_of_type_JavaLangString = bbdx.b(localFile);
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.jdField_a_of_type_Int);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript]:", localThrowable);
      ajlo.a(this.jdField_a_of_type_Ajez.a(), 300, 30, new Object[] { "loadScript:", localThrowable });
      return false;
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          QLog.d("cmshow_scripted_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          a(this.jdField_a_of_type_JavaLangString, 3, false);
        }
        for (;;)
        {
          b();
          return;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("(function(){").append(this.jdField_a_of_type_JavaLangString).append(";registerFunction(\"playAction_bid_").append(this.jdField_a_of_type_Int).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.jdField_a_of_type_Int).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.jdField_a_of_type_Int).append("\", stopSpriteAction);").append("})();");
          a(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(ajms.au)) {}
    while (new File(ajms.av + "cm3d.js").exists()) {
      return true;
    }
    return false;
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    ApolloCmdChannel.getChannel(localQQAppInterface).addCmdHandler(this);
  }
  
  public void e()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    akvi.a(a());
  }
  
  public void f()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    akvi.a(a());
  }
  
  public void g()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
    if (localObject != null) {
      ((ApolloCmdChannel)localObject).removeCmdHandler(this);
    }
    this.jdField_a_of_type_Ajfi = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajer
 * JD-Core Version:    0.7.0.1
 */