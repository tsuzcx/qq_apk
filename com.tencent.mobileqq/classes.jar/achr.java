import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import java.util.List;

public class achr
  implements Runnable
{
  public achr(FavroamingDBManager paramFavroamingDBManager, List paramList, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 14	achr:jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager	Lcom/tencent/mobileqq/emosm/favroaming/FavroamingDBManager;
    //   6: getfield 30	com/tencent/mobileqq/emosm/favroaming/FavroamingDBManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 36	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 42	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload 7
    //   25: invokevirtual 47	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   28: astore 5
    //   30: aload 5
    //   32: astore 4
    //   34: aload 5
    //   36: invokevirtual 51	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   39: iconst_0
    //   40: istore_2
    //   41: aload 5
    //   43: astore 4
    //   45: iload_1
    //   46: aload_0
    //   47: getfield 16	achr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   50: invokeinterface 57 1 0
    //   55: if_icmpge +166 -> 221
    //   58: aload 5
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 16	achr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: iload_1
    //   67: invokeinterface 61 2 0
    //   72: checkcast 63	com/tencent/mobileqq/data/CustomEmotionData
    //   75: astore 6
    //   77: aload 5
    //   79: astore 4
    //   81: aload_0
    //   82: getfield 18	achr:jdField_a_of_type_Int	I
    //   85: tableswitch	default:+300 -> 385, 1:+76->161, 2:+102->187, 3:+31->116, 4:+119->204
    //   117: iconst_2
    //   118: astore 4
    //   120: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +265 -> 388
    //   126: aload 5
    //   128: astore 4
    //   130: ldc 71
    //   132: iconst_2
    //   133: new 73	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   140: ldc 76
    //   142: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 18	achr:jdField_a_of_type_Int	I
    //   149: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: goto +230 -> 388
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: sipush 1000
    //   170: invokevirtual 95	com/tencent/mobileqq/data/CustomEmotionData:setStatus	(I)V
    //   173: aload 5
    //   175: astore 4
    //   177: aload 7
    //   179: aload 6
    //   181: invokevirtual 98	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   184: goto +204 -> 388
    //   187: aload 5
    //   189: astore 4
    //   191: aload 7
    //   193: aload 6
    //   195: invokevirtual 101	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   198: istore_3
    //   199: iload_3
    //   200: istore_2
    //   201: goto +187 -> 388
    //   204: aload 5
    //   206: astore 4
    //   208: aload 7
    //   210: aload 6
    //   212: invokevirtual 104	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   215: istore_3
    //   216: iload_3
    //   217: istore_2
    //   218: goto +170 -> 388
    //   221: aload 5
    //   223: astore 4
    //   225: aload 5
    //   227: invokevirtual 107	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: aload 7
    //   242: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   245: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -226 -> 22
    //   251: ldc 71
    //   253: iconst_2
    //   254: new 73	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   261: ldc 112
    //   263: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: getfield 18	achr:jdField_a_of_type_Int	I
    //   270: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: ldc 114
    //   275: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 16	achr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   282: invokeinterface 57 1 0
    //   287: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc 116
    //   292: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_2
    //   296: invokevirtual 119	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: return
    //   306: astore 6
    //   308: aconst_null
    //   309: astore 5
    //   311: iconst_0
    //   312: istore_2
    //   313: aload 5
    //   315: astore 4
    //   317: ldc 71
    //   319: iconst_1
    //   320: ldc 121
    //   322: aload 6
    //   324: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload 5
    //   329: ifnull +8 -> 337
    //   332: aload 5
    //   334: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   337: aload 7
    //   339: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   342: goto -97 -> 245
    //   345: astore 5
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 4
    //   352: ifnull +8 -> 360
    //   355: aload 4
    //   357: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   360: aload 7
    //   362: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   365: aload 5
    //   367: athrow
    //   368: astore 5
    //   370: goto -20 -> 350
    //   373: astore 6
    //   375: iconst_0
    //   376: istore_2
    //   377: goto -64 -> 313
    //   380: astore 6
    //   382: goto -69 -> 313
    //   385: goto -269 -> 116
    //   388: iload_1
    //   389: iconst_1
    //   390: iadd
    //   391: istore_1
    //   392: goto -351 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	achr
    //   1	391	1	i	int
    //   40	337	2	bool1	boolean
    //   198	19	3	bool2	boolean
    //   32	324	4	localEntityTransaction1	com.tencent.mobileqq.persistence.EntityTransaction
    //   28	305	5	localEntityTransaction2	com.tencent.mobileqq.persistence.EntityTransaction
    //   345	21	5	localObject1	Object
    //   368	1	5	localObject2	Object
    //   75	136	6	localCustomEmotionData	com.tencent.mobileqq.data.CustomEmotionData
    //   306	17	6	localException1	java.lang.Exception
    //   373	1	6	localException2	java.lang.Exception
    //   380	1	6	localException3	java.lang.Exception
    //   15	346	7	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    // Exception table:
    //   from	to	target	type
    //   23	30	306	java/lang/Exception
    //   23	30	345	finally
    //   34	39	368	finally
    //   45	58	368	finally
    //   62	77	368	finally
    //   81	116	368	finally
    //   120	126	368	finally
    //   130	158	368	finally
    //   165	173	368	finally
    //   177	184	368	finally
    //   191	199	368	finally
    //   208	216	368	finally
    //   225	230	368	finally
    //   317	327	368	finally
    //   34	39	373	java/lang/Exception
    //   45	58	380	java/lang/Exception
    //   62	77	380	java/lang/Exception
    //   81	116	380	java/lang/Exception
    //   120	126	380	java/lang/Exception
    //   130	158	380	java/lang/Exception
    //   165	173	380	java/lang/Exception
    //   177	184	380	java/lang/Exception
    //   191	199	380	java/lang/Exception
    //   208	216	380	java/lang/Exception
    //   225	230	380	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achr
 * JD-Core Version:    0.7.0.1
 */