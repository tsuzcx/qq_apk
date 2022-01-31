import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;

public class alux
  implements Runnable
{
  public alux(QidianPubAccountBigDataHandler paramQidianPubAccountBigDataHandler, PubAccountNavigationMenu paramPubAccountNavigationMenu) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	alux:jdField_a_of_type_ComTencentQidianControllerQidianPubAccountBigDataHandler	Lcom/tencent/qidian/controller/QidianPubAccountBigDataHandler;
    //   4: getfield 28	com/tencent/qidian/controller/QidianPubAccountBigDataHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +22 -> 37
    //   18: aload_0
    //   19: getfield 15	alux:jdField_a_of_type_ComTencentQidianDataPubAccountNavigationMenu	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   22: ifnull +16 -> 38
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 15	alux:jdField_a_of_type_ComTencentQidianDataPubAccountNavigationMenu	Lcom/tencent/qidian/data/PubAccountNavigationMenu;
    //   30: invokevirtual 45	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   33: aload_1
    //   34: invokevirtual 47	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   37: return
    //   38: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq -8 -> 33
    //   44: ldc 55
    //   46: iconst_2
    //   47: ldc 57
    //   49: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: goto -19 -> 33
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   60: aload_1
    //   61: invokevirtual 47	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   64: return
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 47	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	alux
    //   13	54	1	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   55	2	2	localException	java.lang.Exception
    //   65	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	33	55	java/lang/Exception
    //   38	52	55	java/lang/Exception
    //   18	33	65	finally
    //   38	52	65	finally
    //   56	60	65	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alux
 * JD-Core Version:    0.7.0.1
 */