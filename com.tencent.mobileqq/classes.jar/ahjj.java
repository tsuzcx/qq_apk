import android.text.TextUtils;
import com.qq.wx.voice.embed.recognizer.GrammarNative;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;

public class ahjj
{
  private static volatile ahjj jdField_a_of_type_Ahjj;
  private int jdField_a_of_type_Int = -1;
  
  public static ahjj a()
  {
    if (jdField_a_of_type_Ahjj == null) {}
    try
    {
      if (jdField_a_of_type_Ahjj == null) {
        jdField_a_of_type_Ahjj = new ahjj();
      }
      return jdField_a_of_type_Ahjj;
    }
    finally {}
  }
  
  public float a()
  {
    try
    {
      float f = GrammarNative.getResultCfd();
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 1.0F;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      do
      {
        try
        {
          paramInt = GrammarNative.recognize(paramArrayOfByte, paramInt);
          if (paramInt < 0)
          {
            i = -1;
            return i;
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return -1;
        }
        int i = paramInt;
      } while (paramInt != 1);
      this.jdField_a_of_type_Int = 0;
      return 1;
    }
    return 0;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramAppRuntime = ((PreloadManager)paramAppRuntime.getManager(151)).b("2017112200");
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.getResList();
        if (paramAppRuntime != null)
        {
          int i = 0;
          while (i < paramAppRuntime.size())
          {
            PreloadResource localPreloadResource = (PreloadResource)paramAppRuntime.get(i);
            if (i != 0) {
              localStringBuilder.append("&");
            }
            localStringBuilder.append(localPreloadResource.mResId);
            i += 1;
          }
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      try
      {
        int i = GrammarNative.begin();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = GrammarNative.update(paramString.getBytes("GBK"));
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    File localFile = null;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRecognizer", 2, "init is call" + this.jdField_a_of_type_Int);
        }
        int i = this.jdField_a_of_type_Int;
        boolean bool;
        if (i != -1)
        {
          bool = true;
          return bool;
        }
        if (paramAppRuntime == null)
        {
          bool = false;
        }
        else
        {
          PreloadManager localPreloadManager = (PreloadManager)paramAppRuntime.getManager(151);
          Object localObject = localPreloadManager.a("2018011001");
          String str = localPreloadManager.a("2018011002");
          paramAppRuntime = localFile;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAppRuntime = localFile;
            if (!TextUtils.isEmpty(str))
            {
              localFile = new File((String)localObject, "libwxvoiceembed.so");
              localObject = new File(str, "libwxvoiceembed.bin");
              paramAppRuntime = localFile;
              if (localFile.exists())
              {
                paramAppRuntime = localFile;
                if (((File)localObject).exists())
                {
                  i = 1;
                  paramAppRuntime = localFile;
                  if (i == 0)
                  {
                    localPreloadManager.a("2017112200");
                    bool = false;
                    continue;
                  }
                  try
                  {
                    System.load(paramAppRuntime.getAbsolutePath());
                    i = GrammarNative.init(str.getBytes(), "libwxvoiceembed.bin".getBytes(), null);
                    if (i >= 0) {
                      continue;
                    }
                    bool = false;
                  }
                  catch (Throwable paramAppRuntime)
                  {
                    paramAppRuntime.printStackTrace();
                    bool = false;
                  }
                  continue;
                  this.jdField_a_of_type_Int = 0;
                  bool = true;
                  continue;
                }
              }
            }
          }
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 0;
      try
      {
        int i = GrammarNative.end();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 108
    //   10: iconst_2
    //   11: new 36	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   18: ldc 168
    //   20: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 13	ahjj:jdField_a_of_type_Int	I
    //   27: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 13	ahjj:jdField_a_of_type_Int	I
    //   40: istore_1
    //   41: iload_1
    //   42: iconst_m1
    //   43: if_icmpeq +25 -> 68
    //   46: invokestatic 171	com/qq/wx/voice/embed/recognizer/GrammarNative:destroy	()I
    //   49: ifne +19 -> 68
    //   52: aload_0
    //   53: iconst_m1
    //   54: putfield 13	ahjj:jdField_a_of_type_Int	I
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -11 -> 59
    //   73: astore_3
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ahjj
    //   40	4	1	i	int
    //   58	12	2	bool	boolean
    //   63	2	3	localException	java.lang.Exception
    //   73	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	57	63	java/lang/Exception
    //   2	36	73	finally
    //   36	41	73	finally
    //   46	57	73	finally
    //   64	68	73	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahjj
 * JD-Core Version:    0.7.0.1
 */