import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.OfflineWebResManager.1;
import com.tencent.biz.webviewplugin.OfflineWebResManager.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class abfm
{
  public static ConcurrentLinkedQueue<String> a;
  public static boolean a;
  public static boolean b;
  public final long a;
  public AppInterface a;
  public EntityManager a;
  public String a;
  public AtomicBoolean a;
  final long b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_b_of_type_Boolean = true;
  }
  
  public abfm(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = 86400000L;
    this.jdField_b_of_type_Long = 5242880L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory();
    if (paramAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.createEntityManager();
    }
  }
  
  /* Error */
  private JSONObject a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 73	nmp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 81	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   23: aload_3
    //   24: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_3
    //   35: new 92	java/io/File
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 99	java/io/File:exists	()Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 102	abfm:c	(Ljava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: getstatic 107	nmj:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +42 -> 101
    //   62: getstatic 107	nmj:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: aload_1
    //   66: invokevirtual 113	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +32 -> 101
    //   72: getstatic 107	nmj:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: aload_1
    //   76: invokevirtual 117	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 119	java/lang/String
    //   82: astore_3
    //   83: aload_3
    //   84: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +194 -> 281
    //   90: new 121	org/json/JSONObject
    //   93: dup
    //   94: aload_3
    //   95: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 124	java/io/BufferedInputStream
    //   104: dup
    //   105: new 126	java/io/FileInputStream
    //   108: dup
    //   109: new 81	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   116: aload_3
    //   117: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 128
    //   122: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   131: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   134: astore 4
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokestatic 137	nnz:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: getstatic 107	nmj:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   151: aload_1
    //   152: aload_2
    //   153: invokevirtual 141	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: ifnull -78 -> 83
    //   164: aload 4
    //   166: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   169: aload_2
    //   170: astore_3
    //   171: goto -88 -> 83
    //   174: astore_3
    //   175: aload_3
    //   176: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   179: aload_2
    //   180: astore_3
    //   181: goto -98 -> 83
    //   184: astore 5
    //   186: aconst_null
    //   187: astore 4
    //   189: ldc 38
    //   191: astore_2
    //   192: aload 4
    //   194: astore_3
    //   195: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +16 -> 214
    //   201: aload 4
    //   203: astore_3
    //   204: ldc 154
    //   206: iconst_2
    //   207: ldc 38
    //   209: aload 5
    //   211: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload_2
    //   215: astore_3
    //   216: aload 4
    //   218: ifnull -135 -> 83
    //   221: aload 4
    //   223: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   226: aload_2
    //   227: astore_3
    //   228: goto -145 -> 83
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   236: aload_2
    //   237: astore_3
    //   238: goto -155 -> 83
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore_2
    //   253: aload_2
    //   254: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   257: goto -7 -> 250
    //   260: astore_1
    //   261: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +12 -> 276
    //   267: ldc 154
    //   269: iconst_2
    //   270: ldc 38
    //   272: aload_1
    //   273: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -179 -> 99
    //   281: aload_0
    //   282: aload_1
    //   283: invokevirtual 102	abfm:c	(Ljava/lang/String;)V
    //   286: getstatic 107	nmj:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   289: aload_1
    //   290: invokevirtual 161	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: aconst_null
    //   295: areturn
    //   296: astore_1
    //   297: aload_3
    //   298: astore_2
    //   299: goto -57 -> 242
    //   302: astore 5
    //   304: ldc 38
    //   306: astore_2
    //   307: goto -115 -> 192
    //   310: astore 5
    //   312: goto -120 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	abfm
    //   0	315	1	paramString	String
    //   1	246	2	str1	String
    //   252	2	2	localIOException1	java.io.IOException
    //   298	9	2	localObject1	Object
    //   6	165	3	localObject2	Object
    //   174	2	3	localIOException2	java.io.IOException
    //   180	48	3	localObject3	Object
    //   231	2	3	localIOException3	java.io.IOException
    //   237	61	3	str2	String
    //   134	88	4	localBufferedInputStream	java.io.BufferedInputStream
    //   184	26	5	localException1	Exception
    //   302	1	5	localException2	Exception
    //   310	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   164	169	174	java/io/IOException
    //   101	136	184	java/lang/Exception
    //   221	226	231	java/io/IOException
    //   101	136	241	finally
    //   246	250	252	java/io/IOException
    //   90	99	260	java/lang/Exception
    //   139	145	296	finally
    //   148	157	296	finally
    //   195	201	296	finally
    //   204	214	296	finally
    //   139	145	302	java/lang/Exception
    //   148	157	310	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramString)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramString);
    }
  }
  
  public static void c()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), bhwl.e.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(bhmi.a((File)localObject));
        if (((JSONObject)localObject).has("offinePkgReadFromDataCache")) {
          jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("offinePkgReadFromDataCache");
        }
      }
      if (!jdField_b_of_type_Boolean) {
        QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OfflineWebResManager", 2, "parse offline globle config error!", localException);
        }
      }
    }
  }
  
  public OfflineWebRes a(String paramString)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (OfflineWebRes)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(OfflineWebRes.class, paramString);
  }
  
  public void a()
  {
    BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("OfflineWebResManager", 4);
    long l = localSharedPreferences.getLong("Last_Check_Cache", 0L);
    if (System.currentTimeMillis() - l < 86400000L) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    ThreadManager.post(new OfflineWebResManager.1(this, localSharedPreferences), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    while ((paramInt > 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now check update url, deley: " + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.post(new OfflineWebResManager.2(this, paramInt), 5, null, false);
  }
  
  public void a(OfflineWebRes paramOfflineWebRes)
  {
    if (paramOfflineWebRes == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        if (paramOfflineWebRes.getStatus() == 1000)
        {
          localObject1 = nmp.a(paramOfflineWebRes.bid);
          Object localObject2 = (String)localObject1 + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName;
          localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            bhmi.a((File)localObject1, new File((File)localObject2, paramOfflineWebRes.hashName));
            if (QLog.isColorLevel()) {
              QLog.i("OfflineWebResManager", 2, "now copy " + paramOfflineWebRes.fileName + " into /data");
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramOfflineWebRes);
            return;
          }
          QLog.e("OfflineWebResManager", 2, "bid not exit! " + (String)localObject2);
          return;
        }
      } while ((paramOfflineWebRes.getStatus() != 1001) && (paramOfflineWebRes.getStatus() != 1002));
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    } while (!((File)localObject1).exists());
    if (new File((File)localObject1, paramOfflineWebRes.hashName).exists())
    {
      paramOfflineWebRes.hitCount += 1;
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "fileName: " + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName + ", hitcount: " + paramOfflineWebRes.hitCount);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramOfflineWebRes);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramOfflineWebRes);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete  record for bid: " + paramString2 + ", fileName: " + paramString1);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now begin check cache size!");
    }
    File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    if ((!localFile1.exists()) || (!localFile1.isDirectory()))
    {
      break label49;
      break label49;
      break label49;
      break label49;
    }
    label49:
    while (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(OfflineWebRes.class.getSimpleName())) {
      return;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject1 = localFile1.listFiles();
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break label49;
        }
        j = localObject1.length;
        i = 0;
        l1 = 0L;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if (!((File)localObject2).isDirectory()) {
            l1 += ((File)localObject2).length();
          } else {
            ((File)localObject2).delete();
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (l1 < 4194304.0D)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, "now /data cache size :" + l1);
        return;
      }
      OfflineWebRes localOfflineWebRes;
      File localFile2;
      if ((l1 >= 4194304.0D) && (l1 < 5242880L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
        }
        localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " where hitcount=1 limit 100";
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject1, null);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject1 = new StringBuilder(((List)localObject2).size() * 64);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          localFile2 = new File(localException, localOfflineWebRes.hashName);
          if (localFile2.exists())
          {
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject1).append("delete file: ").append(localFile2.getPath()).append("\n");
            }
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
        }
        if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(((StringBuilder)localObject1).toString()))) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      long l2 = (l1 - 4194304.0D);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "cache data size exceed cache max value " + l2);
      }
      Object localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " order by hitcount";
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject1, null);
      localObject1 = new StringBuilder("");
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          l1 = l2;
          if (!((Iterator)localObject2).hasNext()) {
            break label791;
          }
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          if (l1 > 0L) {
            break label683;
          }
        }
      }
      label791:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (l1 <= 0L) {
          break;
        }
        QLog.w("OfflineWebResManager", 1, "cache data size still exceed cache max value " + l1 + ", now delete folder and database!");
        File[] arrayOfFile = localException.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
          break;
        }
        j = arrayOfFile.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
            continue;
            label683:
            localFile2 = new File(arrayOfFile, localOfflineWebRes.hashName);
            l2 = l1;
            if (localFile2.exists())
            {
              ((StringBuilder)localObject1).append("delete file: " + localFile2.getPath() + "\n");
              l2 = l1 - localFile2.length();
              localFile2.delete();
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
            l1 = l2;
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(OfflineWebRes.class.getSimpleName());
        return;
      }
      i += 1;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          l = System.currentTimeMillis();
          localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = this.jdField_a_of_type_JavaLangString;
          }
        } while (TextUtils.isEmpty((CharSequence)localObject2));
        localObject1 = nmj.d(paramString);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject3 = a((String)localObject2);
    } while (localObject3 == null);
    String str1 = ((JSONObject)localObject3).optString((String)localObject1);
    OfflineWebRes localOfflineWebRes;
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      localOfflineWebRes = a(str1);
      if (localOfflineWebRes != null) {
        break label441;
      }
      str2 = nmj.d(paramString);
      a(str2, (String)localObject2);
      localObject1 = str2 + String.valueOf(System.currentTimeMillis()) + str1;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject3 = MessageDigest.getInstance("SHA1");
          ((MessageDigest)localObject3).update(((String)localObject1).getBytes());
          localObject1 = nnz.a(((MessageDigest)localObject3).digest());
          localObject3 = localObject1;
        }
        catch (Exception localException1)
        {
          localObject1 = "";
        }
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("OfflineWebResManager", 2, "now filePath " + str2 + ", hashName: " + (String)localObject1);
            localObject3 = localObject1;
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label441;
          }
          localObject1 = new OfflineWebRes();
          ((OfflineWebRes)localObject1).fileName = str2;
          ((OfflineWebRes)localObject1).hashName = ((String)localObject3);
          ((OfflineWebRes)localObject1).md5 = str1;
          ((OfflineWebRes)localObject1).bid = ((String)localObject2);
          a((OfflineWebRes)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("OfflineWebResManager", 2, "add or update url " + nmj.d(paramString) + ", cost: " + (System.currentTimeMillis() - l));
          return;
        }
        catch (Exception localException2)
        {
          label384:
          Object localObject4;
          break label384;
        }
      }
      paramString = nmj.d(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "now md5 not exits, fileName:" + paramString);
      }
      a(paramString, (String)localObject2);
      return;
      QLog.e("OfflineWebResManager", 1, "add offline res error! " + paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        c((String)localObject2);
      }
      localException1.printStackTrace();
      localObject4 = localObject1;
      continue;
      label441:
      localObject1 = localOfflineWebRes;
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid=?", new String[] { paramString }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes, "bid=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete all record of bid: " + paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfm
 * JD-Core Version:    0.7.0.1
 */