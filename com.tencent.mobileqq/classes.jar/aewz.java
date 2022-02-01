import com.tencent.biz.qcircleshadow.local.requests.QCircleTroopRedDotRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.1;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.2;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.3;
import com.tencent.mobileqq.activity.aio.QcircleRedDotEntity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class aewz
{
  private static aewz jdField_a_of_type_Aewz;
  private static boolean jdField_a_of_type_Boolean = true;
  private int jdField_a_of_type_Int;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private int b;
  
  private aewz()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        this.jdField_a_of_type_Int = 90000;
        this.b = 50;
        QQEntityManagerFactory localQQEntityManagerFactory = new QQEntityManagerFactory(apth.a());
        localQQEntityManagerFactory.verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = localQQEntityManagerFactory;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createEntityManager();
      }
      return;
    }
    finally {}
  }
  
  public static aewz a()
  {
    try
    {
      if (jdField_a_of_type_Aewz == null) {
        jdField_a_of_type_Aewz = new aewz();
      }
      aewz localaewz = jdField_a_of_type_Aewz;
      return localaewz;
    }
    finally {}
  }
  
  private static Entity a(EntityManager paramEntityManager, String paramString)
  {
    if (paramEntityManager != null) {
      return paramEntityManager.find(QcircleRedDotEntity.class, paramString);
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private void a(List<ChatMessage> paramList, TroopChatPie paramTroopChatPie, ArrayMap<String, Boolean> paramArrayMap)
  {
    if (paramArrayMap.size() == 0) {
      return;
    }
    QCircleTroopRedDotRequest localQCircleTroopRedDotRequest = new QCircleTroopRedDotRequest(paramArrayMap);
    localQCircleTroopRedDotRequest.setEnableCache(false);
    paramList = new aexa(this, paramArrayMap, paramTroopChatPie, paramList);
    VSNetworkHelper.getInstance().sendRequest(localQCircleTroopRedDotRequest, paramList);
  }
  
  public static boolean a()
  {
    return (QzoneConfig.isQQCircleShowTroopUnreadRedDot()) && (pay.n() == 0) && (!bbyp.b());
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private static void b(EntityManager paramEntityManager, Entity paramEntity)
  {
    if (paramEntityManager != null) {
      paramEntityManager.getTransaction().begin();
    }
    try
    {
      paramEntityManager.persistOrReplace(paramEntity);
      paramEntityManager.getTransaction().commit();
      paramEntityManager.getTransaction().end();
      return;
    }
    catch (Exception paramEntity)
    {
      for (;;)
      {
        paramEntity.printStackTrace();
      }
    }
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramTroopChatPie == null) || (paramTroopChatPie.listAdapter == null)) {
      return;
    }
    jdField_a_of_type_Boolean = false;
    Object localObject1 = new ArrayMap();
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      if ((((ChatMessage)localObject3).senderuin != null) && (!((ChatMessage)localObject3).senderuin.equals(((ChatMessage)localObject3).selfuin))) {
        ((ArrayMap)localObject1).put(((ChatMessage)localObject3).senderuin, Boolean.valueOf(false));
      }
    }
    localObject1 = ((ArrayMap)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject2);
      if (localObject3 != null)
      {
        long l = ((QcircleRedDotEntity)localObject3).timeStamp;
        if (System.currentTimeMillis() - l >= this.jdField_a_of_type_Int) {
          localArrayMap2.put(localObject2, Boolean.valueOf(((QcircleRedDotEntity)localObject3).isShowRedDot));
        } else {
          localArrayMap1.put(localObject2, Boolean.valueOf(((QcircleRedDotEntity)localObject3).isShowRedDot));
        }
      }
      else
      {
        localArrayMap2.put(localObject2, Boolean.valueOf(false));
      }
    }
    a(paramList, paramTroopChatPie, localArrayMap2);
    ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.1(this, paramList, localArrayMap1, localArrayMap2, paramTroopChatPie));
  }
  
  public void a(List<ChatMessage> paramList, String paramString)
  {
    if ((paramString != null) && (paramList != null))
    {
      ThreadManager.excute(new AIOTroopQcircleRedDotManager.3(this, paramString), 32, null, true);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (paramString.equals(localChatMessage.senderuin)) {
          localChatMessage.setQcircleRedDotFlag(false);
        }
      }
    }
  }
  
  public void b(TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramTroopChatPie == null) || (paramTroopChatPie.listAdapter == null)) {
      return;
    }
    jdField_a_of_type_Boolean = false;
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ChatMessage)localIterator.next();
      if ((((ChatMessage)localObject).senderuin != null) && (!((ChatMessage)localObject).senderuin.equals(((ChatMessage)localObject).selfuin)) && (!((ChatMessage)localObject).getQcircleRedDotPulledFlag())) {
        localArrayMap.put(((ChatMessage)localObject).senderuin, Boolean.valueOf(false));
      }
    }
    if (localArrayMap.size() >= this.b)
    {
      a(paramList, paramTroopChatPie, localArrayMap);
      bool1 = true;
    }
    do
    {
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.2(this, paramList, localArrayMap, bool1, paramTroopChatPie));
      return;
      localIterator = localArrayMap.keySet().iterator();
      bool1 = bool2;
    } while (!localIterator.hasNext());
    Object localObject = (String)localIterator.next();
    QcircleRedDotEntity localQcircleRedDotEntity = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject);
    if ((localQcircleRedDotEntity != null) && (localQcircleRedDotEntity.isShowRedDot)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localArrayMap.put(localObject, Boolean.valueOf(bool1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewz
 * JD-Core Version:    0.7.0.1
 */