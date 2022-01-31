import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AddFrdStateMng.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class ajeb
{
  private static final String jdField_a_of_type_JavaLangString = ajeb.class.getSimpleName();
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  boolean b = false;
  public volatile boolean c = false;
  
  public ajeb()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("checkAndSave [change: %s, save: %s]", new Object[] { Boolean.valueOf(this.b), Boolean.valueOf(this.c) }));
    }
    if ((this.b) && (!this.c))
    {
      this.c = true;
      ThreadManager.excute(new AddFrdStateMng.1(this), 16, null, false);
    }
  }
  
  private void b()
  {
    int i = 0;
    if (!this.b) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "save cache no change");
      }
    }
    do
    {
      return;
      SharedPreferences localSharedPreferences = a();
      if (localSharedPreferences != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "save cache pref is null");
    return;
    Map.Entry localEntry;
    try
    {
      this.b = false;
      localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if ((localEntry != null) && (localEntry.getValue() != null) && (((Long)localEntry.getValue()).longValue() != 0L)) {
          ((ArrayList)localObject1).add(localEntry);
        }
      }
      if (((ArrayList)localObject1).size() <= 100) {
        break label176;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    Collections.sort((List)localObject1, new ajec(this));
    label176:
    Object localObject2 = new StringBuilder(200);
    Object localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append((String)localEntry.getKey()).append("|").append(localEntry.getValue());
        i += 1;
        if (i < 100) {}
      }
      else
      {
        localThrowable.edit().putString("add_frd_state_list", ((StringBuilder)localObject2).toString()).apply();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("saveCache %s", new Object[] { ((StringBuilder)localObject2).toString() }));
        return;
      }
    }
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    int i = 3;
    long l = System.currentTimeMillis();
    try
    {
      localObject2 = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Long.valueOf(0L);
      }
      localObject2 = localObject1;
      if (((Long)localObject1).longValue() != 0L)
      {
        localObject2 = localObject1;
        if (Math.abs(l - ((Long)localObject1).longValue()) >= 604800000L)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("getAddFrdState long time ago [time:%s, cur: %s, du: %s]", new Object[] { localObject1, Long.valueOf(l), Long.valueOf(Math.abs(l - ((Long)localObject1).longValue())) }));
          }
          localObject2 = Long.valueOf(0L);
          b(paramString);
        }
      }
      if (((Long)localObject2).longValue() != 0L) {
        i = 2;
      }
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString))) {
          return 0;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
      if (((ajjj)paramQQAppInterface.getManager(51)).b(paramString))
      {
        b(paramString);
        return 1;
      }
    }
    return i;
  }
  
  public SharedPreferences a()
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label63;
      }
      localQQAppInterface = null;
      if (localQQAppInterface == null) {
        break label77;
      }
      String str = localQQAppInterface.getCurrentAccountUin();
      str = "add_frd_state_" + str;
      this.jdField_a_of_type_AndroidContentSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences(str, 0);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidContentSharedPreferences;
      label63:
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      label77:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "getPref app is null");
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	ajeb:jdField_a_of_type_Boolean	Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifne +199 -> 209
    //   13: aload_1
    //   14: ifnull +15 -> 29
    //   17: aload_0
    //   18: new 247	java/lang/ref/WeakReference
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 255	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   26: putfield 232	ajeb:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   29: aload_0
    //   30: invokevirtual 87	ajeb:a	()Landroid/content/SharedPreferences;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +64 -> 99
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +187 -> 228
    //   44: aload_1
    //   45: invokevirtual 188	java/lang/String:length	()I
    //   48: ifle +180 -> 228
    //   51: aload_1
    //   52: ldc 152
    //   54: invokevirtual 259	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 10
    //   59: aload 10
    //   61: arraylength
    //   62: ifle +166 -> 228
    //   65: aload 10
    //   67: arraylength
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +155 -> 228
    //   76: aload 10
    //   78: iload_2
    //   79: aaload
    //   80: astore 11
    //   82: aload 11
    //   84: ifnull +189 -> 273
    //   87: aload 11
    //   89: invokevirtual 188	java/lang/String:length	()I
    //   92: iconst_3
    //   93: if_icmpge +21 -> 114
    //   96: goto +177 -> 273
    //   99: aload_1
    //   100: ldc 172
    //   102: ldc_w 261
    //   105: invokeinterface 265 3 0
    //   110: astore_1
    //   111: goto -71 -> 40
    //   114: aload 11
    //   116: ldc 161
    //   118: invokevirtual 269	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   121: istore 4
    //   123: iload 4
    //   125: ifle +148 -> 273
    //   128: aload 11
    //   130: invokevirtual 188	java/lang/String:length	()I
    //   133: istore 5
    //   135: iload 4
    //   137: iload 5
    //   139: iconst_1
    //   140: isub
    //   141: if_icmpge +132 -> 273
    //   144: aload 11
    //   146: iconst_0
    //   147: iload 4
    //   149: invokevirtual 273	java/lang/String:substring	(II)Ljava/lang/String;
    //   152: astore 9
    //   154: aload 11
    //   156: iload 4
    //   158: iconst_1
    //   159: iadd
    //   160: invokevirtual 276	java/lang/String:substring	(I)Ljava/lang/String;
    //   163: invokestatic 280	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   166: lstore 7
    //   168: aload 9
    //   170: ifnull +103 -> 273
    //   173: aload 9
    //   175: invokevirtual 188	java/lang/String:length	()I
    //   178: ifle +95 -> 273
    //   181: aload_0
    //   182: getfield 43	ajeb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   185: aload 9
    //   187: lload 7
    //   189: invokestatic 200	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: invokevirtual 284	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: goto +77 -> 273
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   204: aload_0
    //   205: iconst_1
    //   206: putfield 32	ajeb:jdField_a_of_type_Boolean	Z
    //   209: aload_0
    //   210: monitorexit
    //   211: return
    //   212: astore 9
    //   214: aload 9
    //   216: invokevirtual 133	java/lang/Throwable:printStackTrace	()V
    //   219: lconst_0
    //   220: lstore 7
    //   222: aconst_null
    //   223: astore 9
    //   225: goto -57 -> 168
    //   228: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -27 -> 204
    //   234: getstatic 24	ajeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc_w 286
    //   241: iconst_2
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_1
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: aload_0
    //   252: getfield 43	ajeb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   255: invokevirtual 287	java/util/concurrent/ConcurrentHashMap:toString	()Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 63	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   262: invokestatic 67	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: goto -61 -> 204
    //   268: astore_1
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: iload_2
    //   274: iconst_1
    //   275: iadd
    //   276: istore_2
    //   277: goto -206 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ajeb
    //   0	280	1	paramQQAppInterface	QQAppInterface
    //   70	207	2	i	int
    //   68	6	3	j	int
    //   121	39	4	k	int
    //   133	8	5	m	int
    //   6	3	6	bool	boolean
    //   166	55	7	l	long
    //   152	34	9	str1	String
    //   212	3	9	localThrowable	Throwable
    //   223	1	9	localObject	Object
    //   57	20	10	arrayOfString	String[]
    //   80	75	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   17	29	199	java/lang/Throwable
    //   29	34	199	java/lang/Throwable
    //   44	69	199	java/lang/Throwable
    //   87	96	199	java/lang/Throwable
    //   99	111	199	java/lang/Throwable
    //   114	123	199	java/lang/Throwable
    //   128	135	199	java/lang/Throwable
    //   173	196	199	java/lang/Throwable
    //   214	219	199	java/lang/Throwable
    //   228	265	199	java/lang/Throwable
    //   144	168	212	java/lang/Throwable
    //   2	8	268	finally
    //   17	29	268	finally
    //   29	34	268	finally
    //   44	69	268	finally
    //   87	96	268	finally
    //   99	111	268	finally
    //   114	123	268	finally
    //   128	135	268	finally
    //   144	168	268	finally
    //   173	196	268	finally
    //   200	204	268	finally
    //   204	209	268	finally
    //   214	219	268	finally
    //   228	265	268	finally
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
        this.b = true;
        a();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("markSendAddFrd uin:%s, time:%s", new Object[] { paramString, Long.valueOf(l) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        Long localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localLong != null) {
          this.b = true;
        }
        a();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("removeFromCache uin:%s, change: %s", new Object[] { paramString, Boolean.valueOf(this.b) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajeb
 * JD-Core Version:    0.7.0.1
 */