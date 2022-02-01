import android.support.v4.util.ArraySet;
import com.tencent.biz.qcircleshadow.local.requests.QCircleTroopGreyRequest;
import com.tencent.biz.qcircleshadow.local.requests.QCircleTroopRedDotRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.1;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.2;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.3;
import com.tencent.mobileqq.activity.aio.QcircleRedDotEntity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class afok
{
  private static afok jdField_a_of_type_Afok;
  private static boolean jdField_a_of_type_Boolean = true;
  private long jdField_a_of_type_Long;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long b;
  private long c;
  private long d;
  
  private afok()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        this.jdField_a_of_type_Long = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_grey_time_threshold", 90000L);
        this.b = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_pull_amount_threshold", 50L);
        this.c = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_grey_time_threshold", 90000L);
        this.d = LocalMultiProcConfig.getLong("qcircle_troop_redpoint_grey_last_timestamp", -1L);
        QQEntityManagerFactory localQQEntityManagerFactory = new QQEntityManagerFactory(aqwk.a());
        localQQEntityManagerFactory.verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = localQQEntityManagerFactory;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createEntityManager();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = a();
      }
      return;
    }
    finally {}
  }
  
  public static afok a()
  {
    try
    {
      if (jdField_a_of_type_Afok == null) {
        jdField_a_of_type_Afok = new afok();
      }
      afok localafok = jdField_a_of_type_Afok;
      return localafok;
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
  
  private ConcurrentHashMap<String, Integer> a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (localObject != null)
    {
      localObject = LocalMultiProcConfig.getString4Uin("qcircle_redpoint_grey_troop_uin", "", ((QQAppInterface)localObject).getLongAccountUin());
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localConcurrentHashMap.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private void a(EntityManager paramEntityManager, Collection<QcircleRedDotEntity> paramCollection)
  {
    if (paramEntityManager != null)
    {
      paramEntityManager.getTransaction().begin();
      try
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          QcircleRedDotEntity localQcircleRedDotEntity = (QcircleRedDotEntity)paramCollection.next();
          paramEntityManager.persistOrReplace(localQcircleRedDotEntity);
          if (localQcircleRedDotEntity.isShowRedDot) {
            QCircleLpReportDc05504.report(localQcircleRedDotEntity.uin, 61, 1, 1);
          }
        }
        return;
      }
      catch (Exception paramCollection)
      {
        paramCollection.printStackTrace();
        paramEntityManager.getTransaction().commit();
        paramEntityManager.getTransaction().end();
      }
    }
  }
  
  private void a(List<ChatMessage> paramList, TroopChatPie paramTroopChatPie, ArrayMap<String, QcircleRedDotEntity> paramArrayMap)
  {
    if ((paramArrayMap == null) || (paramArrayMap.size() == 0)) {
      return;
    }
    QCircleTroopRedDotRequest localQCircleTroopRedDotRequest = new QCircleTroopRedDotRequest(paramArrayMap.keySet());
    localQCircleTroopRedDotRequest.setEnableCache(false);
    paramList = new afol(this, paramArrayMap, paramTroopChatPie, paramList);
    VSNetworkHelper.getInstance().sendRequest(localQCircleTroopRedDotRequest, paramList);
  }
  
  private void a(Set<String> paramSet)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramSet == null) || (paramSet.size() == 0) || (localQQAppInterface == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      localStringBuilder.append((String)paramSet.next());
      localStringBuilder.append(',');
    }
    LocalMultiProcConfig.putString4Uin("qcircle_redpoint_grey_troop_uin", localStringBuilder.toString(), localQQAppInterface.getLongAccountUin());
  }
  
  public static boolean a()
  {
    return (QzoneConfig.isQQCircleShowTroopUnreadRedDot()) && (pkh.c() == 0) && (!bdfk.b());
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
  
  public void a(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.listAdapter == null) || (paramString == null) || (!a(paramString))) {
      return;
    }
    Object localObject1 = new ArraySet();
    paramString = new ArrayMap();
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      if ((((ChatMessage)localObject3).senderuin != null) && (!((ChatMessage)localObject3).senderuin.equals(((ChatMessage)localObject3).selfuin))) {
        ((ArraySet)localObject1).add(((ChatMessage)localObject3).senderuin);
      }
    }
    localObject1 = ((ArraySet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject2);
      long l = System.currentTimeMillis();
      if (localObject3 != null)
      {
        if (l - ((QcircleRedDotEntity)localObject3).timeStamp >= this.jdField_a_of_type_Long) {
          localArrayMap.put(localObject2, localObject3);
        } else {
          paramString.put(localObject2, localObject3);
        }
      }
      else {
        localArrayMap.put(localObject2, new QcircleRedDotEntity((String)localObject2, false, l, ""));
      }
    }
    a(paramList, paramTroopChatPie, localArrayMap);
    ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.1(this, paramList, paramString, localArrayMap, paramTroopChatPie));
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
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString));
  }
  
  public void b(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramList == null) || (paramTroopChatPie == null) || (paramTroopChatPie.listAdapter == null) || (paramString == null) || (!a(paramString))) {
      return;
    }
    paramString = new ArrayMap();
    Iterator localIterator = paramList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (ChatMessage)localIterator.next();
      if ((((ChatMessage)localObject).senderuin != null) && (!((ChatMessage)localObject).senderuin.equals(((ChatMessage)localObject).selfuin)) && (!((ChatMessage)localObject).getQcircleRedDotPulledFlag()))
      {
        long l = System.currentTimeMillis();
        paramString.put(((ChatMessage)localObject).senderuin, new QcircleRedDotEntity(((ChatMessage)localObject).senderuin, false, l, ""));
      }
    }
    if (paramString.size() >= this.b) {
      a(paramList, paramTroopChatPie, paramString);
    }
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.getUIHandler().post(new AIOTroopQcircleRedDotManager.2(this, paramList, paramString, bool, paramTroopChatPie));
      return;
      localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        QcircleRedDotEntity localQcircleRedDotEntity = (QcircleRedDotEntity)a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (String)localObject);
        if (localQcircleRedDotEntity != null) {
          paramString.put(localObject, localQcircleRedDotEntity);
        }
      }
    }
  }
  
  public void c(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    long l = System.currentTimeMillis();
    jdField_a_of_type_Boolean = false;
    if ((this.d == -1L) || (l - this.d >= this.c))
    {
      d(paramString, paramTroopChatPie, paramList);
      return;
    }
    a(paramString, paramTroopChatPie, paramList);
  }
  
  public void d(String paramString, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QCircleTroopGreyRequest localQCircleTroopGreyRequest = null;
    QZLog.d("AIOTroopQcircleRedDotManager", 2, "first into AIO, try to pull grey info and reddot info");
    Object localObject1 = localQCircleTroopGreyRequest;
    if (localObject2 != null)
    {
      localObject2 = (TroopManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = localQCircleTroopGreyRequest;
      if (localObject2 != null) {
        localObject1 = ((TroopManager)localObject2).c();
      }
    }
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      a(paramString, paramTroopChatPie, paramList);
      return;
    }
    localQCircleTroopGreyRequest = new QCircleTroopGreyRequest((List)localObject1);
    localQCircleTroopGreyRequest.setEnableCache(false);
    paramString = new afom(this, (List)localObject1, paramString, paramTroopChatPie, paramList);
    VSNetworkHelper.getInstance().sendRequest(localQCircleTroopGreyRequest, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afok
 * JD-Core Version:    0.7.0.1
 */