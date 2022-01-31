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

public class ajsb
{
  private static final String jdField_a_of_type_JavaLangString = ajsb.class.getSimpleName();
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  boolean b = false;
  public volatile boolean c = false;
  
  public ajsb()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
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
    Collections.sort((List)localObject1, new ajsc(this));
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
      if (((ajxl)paramQQAppInterface.getManager(51)).b(paramString))
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
    //   3: getfield 32	ajsb:jdField_a_of_type_Boolean	Z
    //   6: istore 6
    //   8: iload 6
    //   10: ifne +198 -> 208
    //   13: aload_1
    //   14: ifnull +15 -> 29
    //   17: aload_0
    //   18: new 240	java/lang/ref/WeakReference
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 248	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   26: putfield 225	ajsb:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   29: aload_0
    //   30: invokevirtual 73	ajsb:a	()Landroid/content/SharedPreferences;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +64 -> 99
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +186 -> 227
    //   44: aload_1
    //   45: invokevirtual 180	java/lang/String:length	()I
    //   48: ifle +179 -> 227
    //   51: aload_1
    //   52: ldc 138
    //   54: invokevirtual 252	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 10
    //   59: aload 10
    //   61: arraylength
    //   62: ifle +165 -> 227
    //   65: aload 10
    //   67: arraylength
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +154 -> 227
    //   76: aload 10
    //   78: iload_2
    //   79: aaload
    //   80: astore 11
    //   82: aload 11
    //   84: ifnull +188 -> 272
    //   87: aload 11
    //   89: invokevirtual 180	java/lang/String:length	()I
    //   92: iconst_3
    //   93: if_icmpge +20 -> 113
    //   96: goto +176 -> 272
    //   99: aload_1
    //   100: ldc 160
    //   102: ldc 254
    //   104: invokeinterface 258 3 0
    //   109: astore_1
    //   110: goto -70 -> 40
    //   113: aload 11
    //   115: ldc 149
    //   117: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   120: istore 4
    //   122: iload 4
    //   124: ifle +148 -> 272
    //   127: aload 11
    //   129: invokevirtual 180	java/lang/String:length	()I
    //   132: istore 5
    //   134: iload 4
    //   136: iload 5
    //   138: iconst_1
    //   139: isub
    //   140: if_icmpge +132 -> 272
    //   143: aload 11
    //   145: iconst_0
    //   146: iload 4
    //   148: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   151: astore 9
    //   153: aload 11
    //   155: iload 4
    //   157: iconst_1
    //   158: iadd
    //   159: invokevirtual 269	java/lang/String:substring	(I)Ljava/lang/String;
    //   162: invokestatic 273	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   165: lstore 7
    //   167: aload 9
    //   169: ifnull +103 -> 272
    //   172: aload 9
    //   174: invokevirtual 180	java/lang/String:length	()I
    //   177: ifle +95 -> 272
    //   180: aload_0
    //   181: getfield 43	ajsb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   184: aload 9
    //   186: lload 7
    //   188: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: invokevirtual 277	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: goto +77 -> 272
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   203: aload_0
    //   204: iconst_1
    //   205: putfield 32	ajsb:jdField_a_of_type_Boolean	Z
    //   208: aload_0
    //   209: monitorexit
    //   210: return
    //   211: astore 9
    //   213: aload 9
    //   215: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   218: lconst_0
    //   219: lstore 7
    //   221: aconst_null
    //   222: astore 9
    //   224: goto -57 -> 167
    //   227: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -27 -> 203
    //   233: getstatic 24	ajsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: iconst_2
    //   237: ldc_w 279
    //   240: iconst_2
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_1
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload_0
    //   251: getfield 43	ajsb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   254: invokevirtual 280	java/util/concurrent/ConcurrentHashMap:toString	()Ljava/lang/String;
    //   257: aastore
    //   258: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: goto -61 -> 203
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: iload_2
    //   273: iconst_1
    //   274: iadd
    //   275: istore_2
    //   276: goto -205 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ajsb
    //   0	279	1	paramQQAppInterface	QQAppInterface
    //   70	206	2	i	int
    //   68	6	3	j	int
    //   120	39	4	k	int
    //   132	8	5	m	int
    //   6	3	6	bool	boolean
    //   165	55	7	l	long
    //   151	34	9	str1	String
    //   211	3	9	localThrowable	Throwable
    //   222	1	9	localObject	Object
    //   57	20	10	arrayOfString	String[]
    //   80	74	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   17	29	198	java/lang/Throwable
    //   29	34	198	java/lang/Throwable
    //   44	69	198	java/lang/Throwable
    //   87	96	198	java/lang/Throwable
    //   99	110	198	java/lang/Throwable
    //   113	122	198	java/lang/Throwable
    //   127	134	198	java/lang/Throwable
    //   172	195	198	java/lang/Throwable
    //   213	218	198	java/lang/Throwable
    //   227	264	198	java/lang/Throwable
    //   143	167	211	java/lang/Throwable
    //   2	8	267	finally
    //   17	29	267	finally
    //   29	34	267	finally
    //   44	69	267	finally
    //   87	96	267	finally
    //   99	110	267	finally
    //   113	122	267	finally
    //   127	134	267	finally
    //   143	167	267	finally
    //   172	195	267	finally
    //   199	203	267	finally
    //   203	208	267	finally
    //   213	218	267	finally
    //   227	264	267	finally
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
 * Qualified Name:     ajsb
 * JD-Core Version:    0.7.0.1
 */