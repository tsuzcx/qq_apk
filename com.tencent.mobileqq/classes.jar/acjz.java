import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class acjz
  implements Manager
{
  private static int[] jdField_a_of_type_ArrayOfInt = { -1034, -2015, -2060, -2062, -2061, -7007, -2074 };
  private final int jdField_a_of_type_Int = 10000;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
  private Map<String, Map<Integer, BeancurdMsg>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 3;
  private Map<String, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public acjz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private int a(int paramInt)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < jdField_a_of_type_ArrayOfInt.length)
      {
        if (jdField_a_of_type_ArrayOfInt[i] == paramInt) {
          j = i + 1;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private MessageRecord a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str = "";
    if ((paramString2 instanceof String)) {
      str = paramString2;
    }
    int i = b(paramInt2);
    MessageRecord localMessageRecord = awbi.a(i);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt1);
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = 1L + ((MessageRecord)localList.get(localList.size() - 1)).time;; l = awao.a())
    {
      localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString1, paramString1, str, l, i, paramInt1, l);
      localMessageRecord.isread = true;
      localMessageRecord.msg = paramString2;
      if (paramInt2 == 5) {}
      try
      {
        localMessageRecord.msg = null;
        localMessageRecord.msgData = paramString2.getBytes("ISO_8859_1");
        ((MessageForQQStoryFeed)localMessageRecord).mergeFrom(localMessageRecord.msgData);
        return localMessageRecord;
      }
      catch (Exception paramString1) {}
    }
    return localMessageRecord;
  }
  
  private List<MessageRecord> a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, null);
  }
  
  private void a()
  {
    Object localObject2 = null;
    Object localObject3 = baig.a();
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
    }
    a((String)localObject1);
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject1 = localatmp.a(BeancurdMsg.class, new BeancurdMsg().getTableName(), false, null, null, null, null, null, null);
    if (localObject1 != null) {
      b(String.format("init.beancurd table count = %d", new Object[] { Integer.valueOf(((List)localObject1).size()) }));
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 10000))
    {
      ((List)localObject1).clear();
      localatmp.a(BeancurdMsg.class);
    }
    BeancurdMsg localBeancurdMsg;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      b(String.format("init: has BeancurdMsg  size = %d ", new Object[] { Integer.valueOf(((List)localObject1).size()) }));
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localBeancurdMsg = (BeancurdMsg)localIterator.next();
        b(" the table pending show msg :" + localBeancurdMsg);
        if (!c(localBeancurdMsg))
        {
          b(String.format("init: has invalid msg  ", new Object[0]));
          if (localObject1 != null) {
            break label387;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label387:
    for (;;)
    {
      ((List)localObject1).add(localBeancurdMsg);
      break;
      String str = localBeancurdMsg.frienduin;
      localObject3 = (Map)this.jdField_a_of_type_JavaUtilMap.get(str);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ConcurrentHashMap(6);
      }
      ((Map)localObject2).put(Integer.valueOf(localBeancurdMsg.busiid), localBeancurdMsg);
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject2);
      break;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localatmp.b((BeancurdMsg)((Iterator)localObject1).next());
          continue;
          b(String.format("init: has no BeancurdMsg  ", new Object[0]));
        }
      }
      localatmp.a();
      return;
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.msgtype, paramMessageRecord.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = a(paramString1, paramInt1, paramInt2, paramString2);
    paramString1.isread = true;
    if (!ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString1.selfuin);
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = arrayOfInt[i];
        if (paramChatMessage.msgtype == k) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return false;
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((!localQQMessageFacade.a()) || (!paramString.equals(localQQMessageFacade.a())) || (localQQMessageFacade.a() != paramInt));
    return true;
  }
  
  private int b(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt > 0)
    {
      i = j;
      if (paramInt <= jdField_a_of_type_ArrayOfInt.length) {
        i = jdField_a_of_type_ArrayOfInt[(paramInt - 1)];
      }
    }
    return i;
  }
  
  private void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Boolean)) {
      QLog.d("BeancurdManager", 2, "fight: " + paramString);
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, new int[] { b(paramInt2) });
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if (localMessageRecord != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  private boolean b(BeancurdMsg paramBeancurdMsg)
  {
    String str1 = paramBeancurdMsg.frienduin;
    int i = paramBeancurdMsg.busiid;
    boolean bool1 = paramBeancurdMsg.ispush;
    boolean bool2 = paramBeancurdMsg.isNeedDelHistory;
    String str2 = paramBeancurdMsg.buffer;
    long l1 = paramBeancurdMsg.startTime;
    long l2 = paramBeancurdMsg.validTime;
    long l3 = paramBeancurdMsg.originTime;
    Object localObject = (Map)this.jdField_a_of_type_JavaUtilMap.get(str1);
    if (localObject == null) {
      localObject = new ConcurrentHashMap(6);
    }
    for (;;)
    {
      BeancurdMsg localBeancurdMsg2 = (BeancurdMsg)((Map)localObject).get(Integer.valueOf(i));
      BeancurdMsg localBeancurdMsg1 = localBeancurdMsg2;
      if (localBeancurdMsg2 == null) {
        localBeancurdMsg1 = new BeancurdMsg();
      }
      localBeancurdMsg1.busiid = i;
      localBeancurdMsg1.frienduin = str1;
      localBeancurdMsg1.ispush = bool1;
      localBeancurdMsg1.isNeedDelHistory = bool2;
      localBeancurdMsg1.buffer = str2;
      localBeancurdMsg1.startTime = l1;
      localBeancurdMsg1.validTime = l2;
      localBeancurdMsg1.originTime = l3;
      localBeancurdMsg1.token = paramBeancurdMsg.token;
      ((Map)localObject).put(Integer.valueOf(i), localBeancurdMsg1);
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().b(localBeancurdMsg1);
      return true;
    }
  }
  
  private boolean c(BeancurdMsg paramBeancurdMsg)
  {
    long l = awao.a();
    if (l > paramBeancurdMsg.startTime + paramBeancurdMsg.validTime) {}
    for (boolean bool = false;; bool = true)
    {
      b(String.format("busiID:%d,now:%d,BeancurdMsg.startTime:%d,validTime:%d", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid), Long.valueOf(l), Long.valueOf(paramBeancurdMsg.startTime), Long.valueOf(paramBeancurdMsg.validTime) }));
      return bool;
    }
  }
  
  public long a(String paramString)
  {
    b(String.format(" blockBeancurdForQZone ", new Object[0]));
    long l = SystemClock.uptimeMillis() + 5000L;
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    return l;
  }
  
  public BeancurdMsg a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (BeancurdMsg)paramString.get(Integer.valueOf(paramInt2));
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", Integer.toString(paramInt2), "", "");
      return;
      str = "0x8009431";
      continue;
      str = "0x8009432";
      continue;
      str = "0x8009433";
      continue;
      str = "0x8009434";
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("priority"))
        {
          JSONObject localJSONObject = paramString.getJSONObject("priority");
          if ((localJSONObject != null) && (localJSONObject.length() > 0))
          {
            Iterator localIterator = localJSONObject.keys();
            while (localIterator.hasNext())
            {
              String str = localIterator.next().toString();
              int i = localJSONObject.optInt(str);
              this.jdField_a_of_type_AndroidUtilSparseArray.append(Integer.parseInt(str), Integer.valueOf(i));
            }
          }
        }
        if (!paramString.has("interval")) {}
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        b("parseConfig.error:" + paramString.getMessage());
        return;
      }
    }
    this.jdField_b_of_type_Int = paramString.optInt("interval");
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2 = null;
    boolean bool;
    Map localMap;
    try
    {
      bool = TextUtils.isEmpty(paramString);
      if (bool) {}
      for (;;)
      {
        return;
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaUtilMap.remove(paramString);
          b(String.format("triggerInfsert: start   ", new Object[0]));
          localMap = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
          if (localMap != null) {
            break;
          }
          b(String.format("triggerInsert: no beancurd  ", new Object[0]));
        }
      }
      localObject1 = a(paramString, paramInt);
    }
    finally {}
    Object localObject1;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      if ((i > 0) && (i > this.jdField_b_of_type_Int)) {
        localObject1 = ((List)localObject1).subList(i - this.jdField_b_of_type_Int, i);
      }
    }
    for (;;)
    {
      label167:
      MessageRecord localMessageRecord;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = ((List)localObject1).size() - 1;
        if (i >= 0)
        {
          localMessageRecord = (MessageRecord)((List)localObject1).get(i);
          if (a(localMessageRecord.msgtype) <= 0) {}
        }
      }
      for (;;)
      {
        Iterator localIterator = localMap.keySet().iterator();
        localObject1 = null;
        label213:
        Object localObject3;
        if (localIterator.hasNext())
        {
          localObject3 = (BeancurdMsg)localMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
          if (!c((BeancurdMsg)localObject3))
          {
            if (localObject2 != null) {
              break label683;
            }
            localObject2 = new ArrayList();
          }
        }
        label683:
        for (;;)
        {
          ((List)localObject2).add(localObject3);
          break label213;
          i -= 1;
          break label167;
          if (localObject1 == null) {}
          for (;;)
          {
            localObject1 = localObject3;
            break;
            try
            {
              int j = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(((BeancurdMsg)localObject1).busiid)).intValue();
              int k = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(((BeancurdMsg)localObject3).busiid)).intValue();
              i = j;
              if (((BeancurdMsg)localObject1).ispush) {
                i = j * 100;
              }
              bool = ((BeancurdMsg)localObject3).ispush;
              j = k;
              if (bool) {
                j = k * 100;
              }
              if (i > j) {
                continue;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b("trigger 2 mPriorityMap null..." + localException.getMessage());
              }
            }
            localObject3 = localObject1;
          }
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              BeancurdMsg localBeancurdMsg = (BeancurdMsg)((Iterator)localObject2).next();
              a(localBeancurdMsg.frienduin, 0, localBeancurdMsg.busiid);
            }
          }
          if (localObject1 == null) {
            break;
          }
          b(String.format("triggerInsert: best beancurd id = %d ", new Object[] { Integer.valueOf(((BeancurdMsg)localObject1).busiid) }));
          bool = ((BeancurdMsg)localObject1).isNeedDelHistory;
          i = ((BeancurdMsg)localObject1).busiid;
          localObject2 = ((BeancurdMsg)localObject1).buffer;
          if (localMessageRecord == null)
          {
            if (bool) {
              b(paramString, paramInt, i);
            }
            a(paramString, paramInt, i);
            a(paramString, paramInt, i, (String)localObject2);
            bool = true;
          }
          for (;;)
          {
            if ((bool) && (((BeancurdMsg)localObject1).ispush)) {
              a(1, i);
            }
            b(String.format("triggerInsert: is inserted = %b ", new Object[] { Boolean.valueOf(bool) }));
            break;
            if ((localMessageRecord.msgtype == b(i)) || (((BeancurdMsg)localObject1).ispush))
            {
              a(localMessageRecord);
              if (bool) {
                b(paramString, paramInt, i);
              }
              a(paramString, paramInt, i);
              a(paramString, paramInt, i, (String)localObject2);
              bool = true;
            }
            else
            {
              bool = false;
            }
          }
        }
        localMessageRecord = null;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localMap != null)
    {
      BeancurdMsg localBeancurdMsg = (BeancurdMsg)localMap.get(Integer.valueOf(paramInt2));
      if (localBeancurdMsg != null)
      {
        localMap.remove(Integer.valueOf(paramInt2));
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localMap);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().b(localBeancurdMsg);
      }
    }
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    for (;;)
    {
      boolean bool1;
      String str1;
      int j;
      boolean bool2;
      String str2;
      boolean bool3;
      Object localObject;
      int i;
      try
      {
        bool1 = this.jdField_b_of_type_Boolean;
        if (bool1)
        {
          bool1 = false;
          return bool1;
        }
        if (paramBeancurdMsg == null)
        {
          bool1 = false;
          continue;
        }
        str1 = paramBeancurdMsg.frienduin;
        j = paramBeancurdMsg.busiid;
        bool1 = paramBeancurdMsg.ispush;
        bool2 = paramBeancurdMsg.isNeedDelHistory;
        str2 = paramBeancurdMsg.buffer;
        a(3, j);
        bool3 = a(str1, 0);
        if (this.jdField_b_of_type_JavaUtilMap.containsKey(str1))
        {
          if (((Long)this.jdField_b_of_type_JavaUtilMap.get(str1)).longValue() >= SystemClock.uptimeMillis())
          {
            b(String.format(" receiveBeancurd blocking status ", new Object[0]));
            if (j == 2)
            {
              this.jdField_b_of_type_JavaUtilMap.remove(str1);
              a(a(str1, 0), true);
              if (bool2) {
                b(str1, 0, j);
              }
              a(str1, 0, j);
              a(str1, 0, j, str2);
              bool1 = true;
              continue;
            }
            b(paramBeancurdMsg);
            bool1 = false;
            continue;
          }
          this.jdField_b_of_type_JavaUtilMap.remove(str1);
        }
        if (TextUtils.isEmpty(str2))
        {
          a(str1, 0, j);
          if (!bool2) {
            break label643;
          }
          b(str1, 0, j);
          break label643;
        }
        b(String.format("receiveBeancurd: msg:%s ", new Object[] { paramBeancurdMsg.toString() }));
        localObject = a(str1, 0);
        if (localObject == null) {
          break label640;
        }
        i = ((List)localObject).size();
        if ((i <= 0) || (i <= this.jdField_b_of_type_Int)) {
          break label640;
        }
        localObject = ((List)localObject).subList(i - this.jdField_b_of_type_Int, i);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label634;
        }
        i = ((List)localObject).size() - 1;
        if (i < 0) {
          break label634;
        }
        MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if (a(localMessageRecord.msgtype) > 0)
        {
          localObject = localMessageRecord;
          if (localObject != null) {
            break label487;
          }
          b(String.format("receiveBeancurd: lastBean == null ", new Object[0]));
          if (bool2) {
            b(str1, 0, j);
          }
          a(str1, 0, j);
          a(str1, 0, j, str2);
          bool1 = true;
          if ((paramBeancurdMsg.ispush) && (bool1)) {
            a(1, j);
          }
          b(String.format("receiveBeancurd: isInsert = %b ", new Object[] { Boolean.valueOf(bool1) }));
          continue;
        }
        i -= 1;
      }
      finally {}
      continue;
      label487:
      b(String.format("receiveBeancurd: isAIOFront:%b", new Object[] { Boolean.valueOf(bool3) }));
      if (bool3)
      {
        b(paramBeancurdMsg);
        bool1 = false;
      }
      else
      {
        i = ((MessageRecord)localObject).msgtype;
        int k = b(j);
        b(String.format("receiveBeancurd: lastBeanMsgType = %d,newBeanMsgType= %d ", new Object[] { Integer.valueOf(i), Integer.valueOf(k) }));
        if ((i == k) || (bool1))
        {
          a((MessageRecord)localObject);
          if (bool2) {
            b(str1, 0, j);
          }
          a(str1, 0, j);
          a(str1, 0, j, str2);
          bool1 = true;
        }
        else
        {
          b(paramBeancurdMsg);
          bool1 = false;
          continue;
          label634:
          localObject = null;
          continue;
          label640:
          continue;
          label643:
          bool1 = true;
        }
      }
    }
  }
  
  public boolean a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int j = this.jdField_b_of_type_Int;
    int k = paramList.size();
    int i;
    if ((j > 0) && (k > 0))
    {
      i = 0;
      if ((i >= Math.min(j, k)) || (a(((MessageRecord)paramList.get(k - i - 1)).msgtype) > 0))
      {
        if (i >= Math.min(j, k)) {
          break label178;
        }
        paramList = (MessageRecord)paramList.remove(k - i - 1);
        if ((paramList != null) && (paramBoolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList.frienduin, paramList.istroop, paramList.msgtype, paramList.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramList.frienduin, paramList.istroop, paramList.uniseq);
        }
      }
    }
    label178:
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(String.format(" filter beancurd is = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
      return paramBoolean;
      i += 1;
      break;
    }
  }
  
  public void onDestroy()
  {
    b(" onDestory...");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acjz
 * JD-Core Version:    0.7.0.1
 */