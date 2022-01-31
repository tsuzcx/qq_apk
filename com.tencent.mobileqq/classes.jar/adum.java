import com.tencent.mobileqq.model.EmoticonManager;
import java.util.List;

public class adum
  implements Runnable
{
  public adum(EmoticonManager paramEmoticonManager, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	adum:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   4: getfield 27	com/tencent/mobileqq/model/EmoticonManager:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: invokevirtual 32	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 36	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   15: aload_0
    //   16: getfield 15	adum:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   19: invokeinterface 42 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 48 1 0
    //   31: ifeq +113 -> 144
    //   34: aload_2
    //   35: invokeinterface 52 1 0
    //   40: checkcast 54	com/tencent/mobileqq/data/Emoticon
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull -20 -> 25
    //   48: aload_0
    //   49: getfield 13	adum:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   52: aload_3
    //   53: invokestatic 57	com/tencent/mobileqq/model/EmoticonManager:a	(Lcom/tencent/mobileqq/model/EmoticonManager;Lcom/tencent/mobileqq/data/Emoticon;)V
    //   56: aload_0
    //   57: getfield 13	adum:jdField_a_of_type_ComTencentMobileqqModelEmoticonManager	Lcom/tencent/mobileqq/model/EmoticonManager;
    //   60: aload_3
    //   61: invokestatic 60	com/tencent/mobileqq/model/EmoticonManager:a	(Lcom/tencent/mobileqq/model/EmoticonManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   64: ifne -39 -> 25
    //   67: ldc 62
    //   69: iconst_1
    //   70: new 64	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   77: ldc 67
    //   79: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: getfield 75	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   86: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 77
    //   91: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: getfield 80	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   98: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: goto -82 -> 25
    //   110: astore_2
    //   111: ldc 62
    //   113: iconst_1
    //   114: new 64	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   121: ldc 92
    //   123: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: invokevirtual 95	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: invokevirtual 98	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   143: return
    //   144: aload_1
    //   145: invokevirtual 101	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   148: aload_1
    //   149: invokevirtual 98	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   152: return
    //   153: astore_2
    //   154: aload_1
    //   155: invokevirtual 98	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	adum
    //   10	145	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   24	11	2	localIterator	java.util.Iterator
    //   110	17	2	localException	java.lang.Exception
    //   153	6	2	localObject	Object
    //   43	52	3	localEmoticon	com.tencent.mobileqq.data.Emoticon
    // Exception table:
    //   from	to	target	type
    //   11	25	110	java/lang/Exception
    //   25	44	110	java/lang/Exception
    //   48	107	110	java/lang/Exception
    //   144	148	110	java/lang/Exception
    //   11	25	153	finally
    //   25	44	153	finally
    //   48	107	153	finally
    //   111	139	153	finally
    //   144	148	153	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adum
 * JD-Core Version:    0.7.0.1
 */