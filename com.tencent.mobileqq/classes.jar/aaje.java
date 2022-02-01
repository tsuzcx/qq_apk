import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.1;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.2;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.4;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.Pair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class aaje
{
  private static aaje jdField_a_of_type_Aaje;
  public static String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String b = anhk.cY;
  private String c = anhk.cZ;
  private String d = ".draft";
  
  static
  {
    jdField_a_of_type_JavaLangString = "SubscribeDraftManager";
  }
  
  private aaje()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("SubscribeDraftManager", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static aaje a()
  {
    try
    {
      if (jdField_a_of_type_Aaje == null) {
        jdField_a_of_type_Aaje = new aaje();
      }
      aaje localaaje = jdField_a_of_type_Aaje;
      return localaaje;
    }
    finally {}
  }
  
  private Pair<String, String> a(String paramString)
  {
    String str = bita.d(paramString);
    paramString = this.b + str;
    str = this.c + str;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "createDraftDirectory currentFolder:" + paramString + " currentSimpleFolder:" + str);
    try
    {
      bgmg.b(paramString);
      bgmg.b(str);
      paramString = new Pair(paramString, str);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private Pair<String, String> a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft failed UID is empty");
      return null;
    }
    Pair localPair = a(paramString1);
    if (localPair != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft id:" + paramString2 + "\n,mUid =" + paramString1 + ", md5 = " + Md5Utils.getMD5(paramString1));
      return new Pair((String)localPair.first + "/" + paramString2 + this.d, (String)localPair.second + "/" + paramString2 + this.d);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "generate draft failed UID ,SDCARD generate folder failed");
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new FileReader(new File(paramString)));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    for (;;)
    {
      paramString.close();
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, aaji paramaaji)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = aoqb.a(paramActivity);
    }
    if (!bool)
    {
      bglp.b(paramActivity);
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.1(this, paramString1, paramString2, paramString3, paramString4, paramaaji));
      return;
    }
    if (paramaaji != null) {
      paramaaji.a(3, false, paramString2, new Object[0]);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "modifyDraft failed because something is empty");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, aajp paramaajp)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = bkho.a(paramContext);
      paramContext.a(paramInt, 3);
      paramContext.c(2131690582);
      paramContext.a(new aajf(this, paramaajp, paramString1, paramContext));
      paramContext.a(new aajg(this, paramString1, paramString2, paramaajp, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public void a(String paramString, aaji paramaaji)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "qureyAllSimpleDraft failed because uin is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.2(this, paramString, paramaaji));
  }
  
  public void a(String paramString1, String paramString2, aaji paramaaji)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.4(this, paramString1, paramString2, paramaaji));
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = new File((String)paramString.second);
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles();
        return (paramString != null) && (paramString.length > 0);
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 155	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 259	java/io/File:exists	()Z
    //   18: ifne +35 -> 53
    //   21: aload_1
    //   22: invokevirtual 274	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 276	java/io/FileWriter
    //   29: dup
    //   30: aload_1
    //   31: iconst_0
    //   32: invokespecial 279	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   35: astore_1
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 282	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 285	java/io/FileWriter:flush	()V
    //   45: aload_1
    //   46: invokevirtual 286	java/io/FileWriter:close	()V
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_3
    //   52: ireturn
    //   53: aload_1
    //   54: invokevirtual 289	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 274	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: goto -37 -> 26
    //   66: astore_1
    //   67: aload 4
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -20 -> 51
    //   74: aload_1
    //   75: invokevirtual 286	java/io/FileWriter:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_1
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_2
    //   84: goto -14 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	aaje
    //   0	87	1	paramString1	String
    //   0	87	2	paramString2	String
    //   1	51	3	bool	boolean
    //   3	65	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	66	java/lang/Throwable
    //   26	36	66	java/lang/Throwable
    //   53	63	66	java/lang/Throwable
    //   74	78	80	java/io/IOException
    //   36	49	83	java/lang/Throwable
  }
  
  public void b(String paramString1, String paramString2, aaji paramaaji)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "deletDraft failed because uin or draftID is empty");
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeDraftManager.5(this, paramString1, paramString2, paramaaji));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaje
 * JD-Core Version:    0.7.0.1
 */