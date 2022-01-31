import com.tencent.mobileqq.model.EmoticonManager;
import java.util.List;

public class aeid
  implements Runnable
{
  public aeid(EmoticonManager paramEmoticonManager, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 13	aeid:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   8: getfield 33	com/tencent/mobileqq/model/EmoticonManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 38	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 42	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   19: aload_0
    //   20: getfield 15	aeid:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   23: invokeinterface 48 1 0
    //   28: astore 4
    //   30: aload 4
    //   32: invokeinterface 54 1 0
    //   37: ifeq +99 -> 136
    //   40: aload 4
    //   42: invokeinterface 58 1 0
    //   47: checkcast 60	com/tencent/mobileqq/data/EmotionKeyword
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 13	aeid:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   56: aload 5
    //   58: invokestatic 63	com/tencent/mobileqq/model/EmoticonManager:a	(Lcom/tencent/mobileqq/model/EmoticonManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   61: pop
    //   62: goto -32 -> 30
    //   65: astore 4
    //   67: ldc 65
    //   69: iconst_1
    //   70: new 67	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   77: ldc 70
    //   79: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 4
    //   84: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +32 -> 135
    //   106: ldc 65
    //   108: iconst_2
    //   109: new 67	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   116: ldc 95
    //   118: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   124: lload_1
    //   125: lsub
    //   126: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: return
    //   136: aload_3
    //   137: invokevirtual 104	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   140: aload_3
    //   141: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   144: goto -44 -> 100
    //   147: astore 4
    //   149: aload_3
    //   150: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   153: aload 4
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	aeid
    //   3	122	1	l	long
    //   14	136	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   28	13	4	localIterator	java.util.Iterator
    //   65	18	4	localException	java.lang.Exception
    //   147	7	4	localObject	Object
    //   50	7	5	localEmotionKeyword	com.tencent.mobileqq.data.EmotionKeyword
    // Exception table:
    //   from	to	target	type
    //   15	30	65	java/lang/Exception
    //   30	62	65	java/lang/Exception
    //   136	140	65	java/lang/Exception
    //   15	30	147	finally
    //   30	62	147	finally
    //   67	96	147	finally
    //   136	140	147	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeid
 * JD-Core Version:    0.7.0.1
 */