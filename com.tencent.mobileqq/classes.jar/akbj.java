import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.commonsdk.util.LargerInteger;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxy.1;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class akbj
  extends akej
{
  private static int jdField_a_of_type_Int = 1;
  private static int b;
  protected atmx a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public akbj(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private int a(String paramString, int paramInt)
  {
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      List localList = d(paramString, paramInt);
      int i = 0;
      if (localList != null)
      {
        i = localList.size();
        localList.clear();
      }
      if (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(a(paramString, paramInt))) {
        akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt));
      }
      return i;
    }
  }
  
  private QQMessageFacade.Message a(String paramString, atmp paramatmp, int paramInt1, int paramInt2)
  {
    if (a(paramString, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramatmp);
    }
    int i;
    String str;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      str = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + akbm.a() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
      if (!bool) {
        break label177;
      }
      if (i == 0) {
        break label171;
      }
      paramatmp = "longMsgIndex asc , shmsgseq desc , _id desc";
    }
    for (;;)
    {
      paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramatmp });
      paramString = a().a(QQMessageFacade.Message.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label183;
      }
      return (QQMessageFacade.Message)paramString.get(0);
      i = 0;
      break;
      label171:
      paramatmp = "longMsgIndex asc , time desc , _id desc";
      continue;
      label177:
      paramatmp = "_id desc";
    }
    label183:
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    if (paramMessageRecord1 == null) {}
    do
    {
      do
      {
        do
        {
          return paramMessageRecord2;
          if (!akbm.a(paramMessageRecord1, paramMessageRecord2)) {
            break;
          }
        } while (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex);
        return paramMessageRecord1;
        if (!paramBoolean) {
          break;
        }
      } while (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq);
      return paramMessageRecord1;
    } while (paramMessageRecord2.time > paramMessageRecord1.time);
    return paramMessageRecord1;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(akbm.a((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(akbm.a((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time >= paramLong) {
        localArrayList.add(localMessageRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt)
  {
    List localList = d(paramString, paramInt);
    if ((localList != null) && (localList.size() == 0))
    {
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().remove(a(paramString, paramInt));
      b(paramString, paramInt, b(paramString, paramInt, new awrt()));
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2;
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
    {
      localObject2 = d(paramString, paramInt1);
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return;
      }
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((!localMessageRecord.isread) && (localMessageRecord.getConfessTopicId() == paramInt2)) {
          localMessageRecord.isread = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).getBaseInfoString());
    }
    paramString = f(paramString, paramInt1);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (MessageRecord)paramString.next();
      if ((!((MessageRecord)localObject2).isread) && (((MessageRecord)localObject2).getConfessTopicId() == paramInt2)) {
        ((MessageRecord)localObject2).isread = true;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1) || (paramInt == 1026);
  }
  
  /* Error */
  private void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 266	akdn:jdField_a_of_type_Boolean	Z
    //   5: ifeq +26 -> 31
    //   8: aload_0
    //   9: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 36	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   15: invokestatic 41	akbi:a	(Ljava/lang/String;)Lakbi;
    //   18: invokevirtual 269	akbi:a	()Lcom/tencent/mobileqq/app/msgcache/MsgLruCache;
    //   21: aload_1
    //   22: iload_2
    //   23: aload_3
    //   24: invokevirtual 275	com/tencent/mobileqq/app/msgcache/MsgLruCache:put	(Ljava/lang/String;ILjava/util/List;)Ljava/util/List;
    //   27: pop
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: invokevirtual 36	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   38: invokestatic 41	akbi:a	(Ljava/lang/String;)Lakbi;
    //   41: invokevirtual 211	akbi:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   44: invokevirtual 276	java/util/concurrent/ConcurrentHashMap:size	()I
    //   47: istore 4
    //   49: getstatic 279	akbm:a	[Ljava/lang/String;
    //   52: arraylength
    //   53: istore 5
    //   55: getstatic 281	akbm:b	[Ljava/lang/String;
    //   58: arraylength
    //   59: istore 6
    //   61: iload 4
    //   63: iload 5
    //   65: bipush 40
    //   67: iadd
    //   68: iload 6
    //   70: iadd
    //   71: if_icmple +50 -> 121
    //   74: iconst_0
    //   75: istore 8
    //   77: aload_0
    //   78: invokevirtual 283	akbj:a	()Z
    //   81: istore 7
    //   83: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +35 -> 121
    //   89: iload 7
    //   91: ifne +30 -> 121
    //   94: ldc 248
    //   96: iconst_2
    //   97: new 103	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 285
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 7
    //   112: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   115: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: invokevirtual 36	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   128: invokestatic 41	akbi:a	(Ljava/lang/String;)Lakbi;
    //   131: invokevirtual 211	akbi:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   134: aload_0
    //   135: aload_1
    //   136: iload_2
    //   137: invokevirtual 63	akbj:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   140: aload_3
    //   141: invokevirtual 291	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: goto -117 -> 28
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: astore 9
    //   155: iload 8
    //   157: istore 7
    //   159: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -79 -> 83
    //   165: ldc 248
    //   167: iconst_2
    //   168: ldc_w 293
    //   171: aload 9
    //   173: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: iload 8
    //   178: istore 7
    //   180: goto -97 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	akbj
    //   0	183	1	paramString	String
    //   0	183	2	paramInt	int
    //   0	183	3	paramList	List<MessageRecord>
    //   47	25	4	i	int
    //   53	15	5	j	int
    //   59	12	6	k	int
    //   81	98	7	bool1	boolean
    //   75	102	8	bool2	boolean
    //   153	19	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	28	148	finally
    //   31	61	148	finally
    //   77	83	148	finally
    //   83	89	148	finally
    //   94	121	148	finally
    //   121	145	148	finally
    //   159	176	148	finally
    //   77	83	153	java/lang/Exception
  }
  
  private void b(List<MessageRecord> paramList, akes paramakes)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "proxy addSync id=" + localMessageRecord.vipBubbleID);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(localMessageRecord.frienduin, localMessageRecord.istroop, MessageRecord.getTableName(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramakes);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
  }
  
  private List<MessageRecord> c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    String str1;
    String str2;
    if (paramInt2 > 0)
    {
      str1 = "limit " + paramInt2;
      str2 = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where time<%d %s order by time desc, _id desc %s";
      if (paramString2 != null) {
        break label272;
      }
    }
    label272:
    for (paramString2 = "";; paramString2 = "and " + paramString2)
    {
      paramString2 = String.format(str2, new Object[] { Long.valueOf(paramLong), paramString2, str1 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      paramString2 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramString2 != null) {
        Collections.reverse(paramString2);
      }
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      str1 = "";
      break;
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  private List<MessageRecord> f(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = new StringBuilder();
    if (a(paramString, paramInt1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(MessageRecord.getTableName(paramString, paramInt1));
    ((StringBuilder)localObject2).append(" where _id in ");
    ((StringBuilder)localObject2).append("(select _id from ");
    ((StringBuilder)localObject2).append(MessageRecord.getTableName(paramString, paramInt1));
    int i;
    if (paramInt2 > 0)
    {
      i = alyc.a(paramInt1, paramInt2);
      ((StringBuilder)localObject2).append(" where (extLong & 4194296)=");
      ((StringBuilder)localObject2).append(i << 3);
    }
    ((StringBuilder)localObject2).append(" order by time desc limit ");
    ((StringBuilder)localObject2).append(40);
    ((StringBuilder)localObject2).append(")");
    ((StringBuilder)localObject2).append(" order by time desc, _id desc");
    Object localObject1 = c(paramString, paramInt1, paramInt2);
    paramString = a().a(((StringBuilder)localObject2).toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramString != null) {
        break label295;
      }
    }
    label295:
    for (paramInt1 = 0;; paramInt1 = paramString.size())
    {
      QLog.i("Q.msg.MsgProxy", 2, String.format("getMsgList_confess sql:%s listSize:%d", new Object[] { localObject2, Integer.valueOf(paramInt1) }));
      if (paramString == null) {
        break label346;
      }
      i = paramString.size() / 2;
      paramInt1 = paramString.size();
      paramInt2 = 0;
      paramInt1 -= 1;
      while (paramInt2 < i)
      {
        localObject2 = (MessageRecord)paramString.get(paramInt2);
        paramString.set(paramInt2, paramString.get(paramInt1));
        paramString.set(paramInt1, localObject2);
        paramInt2 += 1;
        paramInt1 -= 1;
      }
    }
    for (;;)
    {
      localObject1 = akbm.a(paramString, (List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        akbm.a(paramString, (MessageRecord)((Iterator)localObject1).next(), true);
      }
      label346:
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  private MessageRecord j(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).getId() != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.getId() != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(ajed.X, paramInt))
      {
        Object localObject2 = d(ajed.X, 4001);
        if (localObject2 != null)
        {
          int k = ((List)localObject2).size() - 1;
          i = j;
          j = k;
          if (j >= 0)
          {
            if (((MessageRecord)((List)localObject2).get(j)).msgtype == paramInt)
            {
              ((List)localObject2).remove(j);
              i += 1;
            }
          }
          else {
            a(String.valueOf(ajed.X), 4001, MessageRecord.getTableName(String.valueOf(ajed.X), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
          }
        }
        else
        {
          if ((localObject2 != null) && (((List)localObject2).size() == 0) && (axcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            RecentUser localRecentUser = ((akeu)localObject2).a(ajed.V, 9000);
            if (localRecentUser != null) {
              ((akeu)localObject2).b(localRecentUser);
            }
          }
          return i;
        }
      }
      j -= 1;
    }
  }
  
  public int a(int paramInt, QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    String str = String.valueOf(ajed.X);
    label312:
    label315:
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(str, 4001))
      {
        localObject2 = d(str, 4001);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          return 0;
        }
        localObject2 = ((List)localObject2).iterator();
        MessageRecord localMessageRecord;
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "setRecommendMsgReaded " + localMessageRecord.getBaseInfoString());
          }
          if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
            break label312;
          }
          localMessageRecord.isread = true;
          i += 1;
          break label315;
        }
        localObject2 = f(str, 4001);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if ((localMessageRecord.msgtype != paramInt) || (localMessageRecord.isread)) {
              continue;
            }
            localMessageRecord.isread = true;
          }
        }
      }
      Object localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
      a(str, 4001, paramMessage.versionCode, (ContentValues)localObject2, "msgtype=? and isread=?", new String[] { String.valueOf(paramInt), "0" }, null);
      return i;
    }
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "--->deleteC2CMsgByMessageRecord : peerUin:" + paramMessageRecord.frienduin + " type:" + paramMessageRecord.istroop + " uniseq:" + paramMessageRecord.uniseq + " mr:" + paramMessageRecord + " dbid:" + paramMessageRecord.getId());
    }
    if (aqay.a(paramMessageRecord)) {
      return b(paramMessageRecord, paramBoolean);
    }
    if (paramBoolean)
    {
      j(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
      label125:
      long l = paramMessageRecord.getId();
      if (l <= 0L) {
        break label203;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (paramMessageRecord.isread) {
        break label256;
      }
      return 2;
      e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      break label125;
      label203:
      if (paramMessageRecord.uniseq == 0L) {
        break;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    label256:
    a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
  }
  
  public int a(String paramString, int paramInt, long paramLong)
  {
    String str = MessageRecord.getTableName(paramString, paramInt);
    boolean bool = a(paramInt);
    Object localObject2;
    if (bool)
    {
      ??? = "shmsgseq desc , _id desc";
      if (!bool) {
        break label191;
      }
      localObject2 = "shmsgseq";
      localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b)
      {
        if (a(paramString, paramInt, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
        }
        localObject2 = a().a(QQMessageFacade.Message.class, (String)localObject2, null);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          i = ((QQMessageFacade.Message)((List)localObject2).get(0)).unReadNum;
          paramInt = b(paramString, paramInt, paramLong);
          return i + paramInt;
          ??? = "time desc , _id desc";
          break;
          label191:
          localObject2 = "time";
        }
      }
      int i = 0;
    }
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    String str1 = null;
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    paramString = str1;
    if (akbm.c(paramInt))
    {
      paramString = a();
      str1 = "( msgtype " + akbm.b() + " and isValid=1 ) and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = paramString.a(false, str2, new String[] { "_id" }, str1, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = a(paramString, paramInt);
    atob localatob;
    if (paramBoolean)
    {
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), null, null, null);
      a(paramString, paramInt, MessageRecord.getOldTableName(paramString, paramInt), null, null, null);
      localatob = (atob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201);
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break label93;
      }
      ThreadManager.post(new MsgProxy.1(this, localatob, paramString, paramInt), 10, null, false);
    }
    label93:
    while (localatob == null) {
      return i;
    }
    localatob.a(MessageRecord.getTableName(paramString, paramInt), null, null);
    return i;
  }
  
  protected int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int i = paramList.size();
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    String str = ((MessageRecord)localObject1).frienduin;
    int j = ((MessageRecord)localObject1).istroop;
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (paramBoolean)
      {
        j(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getId());
        label124:
        if (localMessageRecord.getId() <= 0L) {
          break label176;
        }
        ((List)localObject2).add(String.valueOf(localMessageRecord.getId()));
      }
      for (;;)
      {
        break;
        e(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        break label124;
        label176:
        if (localMessageRecord.uniseq != 0L) {
          ((List)localObject1).add(String.valueOf(localMessageRecord.uniseq));
        } else {
          i -= 1;
        }
      }
    }
    if (((List)localObject2).size() > 100)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        a(str, j, MessageRecord.getTableName(str, j), "_id=?", new String[] { localObject2 }, null);
      }
    }
    int k;
    if (((List)localObject2).size() != 0)
    {
      k = ((List)localObject2).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "_id IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, MessageRecord.getTableName(str, j), paramList, (String[])((List)localObject2).toArray(new String[k]), null);
    }
    if (((List)localObject1).size() > 100)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        a(str, j, MessageRecord.getTableName(str, j), "uniseq=?", new String[] { localObject1 }, null);
      }
    }
    if (((List)localObject1).size() != 0)
    {
      k = ((List)localObject1).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "uniseq IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, MessageRecord.getTableName(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
    }
    a(str, j);
    return i;
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    int j = 0;
    List localList = b(paramString, paramInt);
    if (paramString.equals(String.valueOf(ajed.G)))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(localList.get(localList.size() - i - 1));
        i += 1;
      }
      new ArrayList();
      paramString = d(paramString, paramInt, 2147483647);
      if (paramString != null)
      {
        paramInt = j;
        while (paramInt < paramString.size())
        {
          localArrayList.add(paramString.get(paramString.size() - paramInt - 1));
          paramInt += 1;
        }
      }
      return new akbk(this, localArrayList);
    }
    return new akbk(this, (List)((ArrayList)localList).clone());
  }
  
  protected atmx a()
  {
    if ((this.jdField_a_of_type_Atmx == null) || (!this.jdField_a_of_type_Atmx.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Atmx == null) || (!this.jdField_a_of_type_Atmx.a())) {
        this.jdField_a_of_type_Atmx = ((atmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_Atmx;
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem a(String paramString1, int paramInt1, String paramString2, int paramInt2, ajym paramajym)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 664	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: aload_1
    //   13: iload_2
    //   14: iconst_1
    //   15: invokevirtual 209	akbj:a	(Ljava/lang/String;IZ)Z
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: getfield 81	akbj:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   25: invokevirtual 328	com/tencent/mobileqq/app/proxy/ProxyManager:d	()V
    //   28: invokestatic 669	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   31: lstore 6
    //   33: getstatic 673	ajyr:jdField_a_of_type_Long	J
    //   36: lstore 8
    //   38: aload_1
    //   39: iload_2
    //   40: invokestatic 322	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore 10
    //   45: aload_0
    //   46: invokevirtual 134	akbj:a	()Latmx;
    //   49: iconst_0
    //   50: aload 10
    //   52: aconst_null
    //   53: ldc_w 675
    //   56: iconst_4
    //   57: anewarray 90	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: sipush -1000
    //   65: invokestatic 425	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: sipush -1035
    //   74: invokestatic 425	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: sipush -2011
    //   83: invokestatic 425	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: lload 6
    //   91: lload 8
    //   93: lsub
    //   94: invokestatic 507	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: aastore
    //   98: aconst_null
    //   99: aconst_null
    //   100: ldc_w 677
    //   103: iload 4
    //   105: invokestatic 425	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: invokevirtual 545	atmx:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore 10
    //   113: aload_0
    //   114: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   117: aload_0
    //   118: getfield 647	akbj:jdField_a_of_type_Atmx	Latmx;
    //   121: aload 10
    //   123: aload_1
    //   124: iload_2
    //   125: aload_3
    //   126: aload 5
    //   128: invokestatic 682	ajyo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Latmp;Landroid/database/Cursor;Ljava/lang/String;ILjava/lang/String;Lajym;)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult$SearchResultItem;
    //   131: astore_3
    //   132: aload_3
    //   133: astore_1
    //   134: aload 10
    //   136: ifnull -127 -> 9
    //   139: aload 10
    //   141: invokeinterface 553 1 0
    //   146: aload_3
    //   147: areturn
    //   148: astore_1
    //   149: aload 10
    //   151: ifnull +10 -> 161
    //   154: aload 10
    //   156: invokeinterface 553 1 0
    //   161: aconst_null
    //   162: areturn
    //   163: astore_1
    //   164: aload 10
    //   166: ifnull +10 -> 176
    //   169: aload 10
    //   171: invokeinterface 553 1 0
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	akbj
    //   0	178	1	paramString1	String
    //   0	178	2	paramInt1	int
    //   0	178	3	paramString2	String
    //   0	178	4	paramInt2	int
    //   0	178	5	paramajym	ajym
    //   31	59	6	l1	long
    //   36	56	8	l2	long
    //   43	127	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   113	132	148	java/lang/Exception
    //   113	132	163	finally
  }
  
  public QQMessageFacade.Message a(String paramString, atmp paramatmp)
  {
    return a(paramString, paramatmp, 0);
  }
  
  protected QQMessageFacade.Message a(String paramString, atmp paramatmp, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b)
      {
        if (a(paramString, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramatmp);
        }
        if (paramString.startsWith("mr_discusssion")) {
          break label502;
        }
        if (!paramString.startsWith("mr_troop")) {
          break label517;
        }
        break label502;
        boolean bool2 = paramString.endsWith("_New");
        localObject1 = new StringBuilder(1024);
        ((StringBuilder)localObject1).append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
        ((StringBuilder)localObject1).append(akbm.a());
        ((StringBuilder)localObject1).append(" order by %s limit 1");
        Object localObject5 = ((StringBuilder)localObject1).toString();
        if (!bool2) {
          break label531;
        }
        if (!bool1) {
          break label523;
        }
        localObject1 = "shmsgseq desc , _id desc";
        localObject1 = String.format((String)localObject5, new Object[] { paramString, paramString, paramString, localObject1 });
        localObject5 = a().a(QQMessageFacade.Message.class, (String)localObject1, null);
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (!((List)localObject5).isEmpty())
          {
            i = ((List)localObject5).size() - 1;
            localObject2 = localObject3;
            if (i >= 0)
            {
              if ((paramInt != 0) && (((QQMessageFacade.Message)((List)localObject5).get(i)).getConfessTopicId() != paramInt)) {
                break label538;
              }
              localObject2 = (QQMessageFacade.Message)((List)localObject5).get(i);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject2).isLongMsg())
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject2).longMsgIndex > 0) {
                  localObject1 = a(paramString, paramatmp, ((QQMessageFacade.Message)localObject2).longMsgId, ((QQMessageFacade.Message)localObject2).issend);
                }
              }
            }
          }
        }
        paramString = a(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          i = paramString.size() - 1;
          if (i >= 0)
          {
            if ((paramInt <= 0) || (((MessageRecord)paramString.get(i)).getConfessTopicId() == paramInt)) {
              break label508;
            }
            paramString.remove(i);
            break label508;
          }
        }
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label496;
        }
        if (localObject1 == null)
        {
          paramInt = 0;
          paramString = paramString.iterator();
          paramatmp = (atmp)localObject1;
          if (paramString.hasNext())
          {
            localObject2 = (MessageRecord)paramString.next();
            if (!((MessageRecord)localObject2).isread) {
              break label547;
            }
            i = 0;
            paramatmp = a(paramatmp, (MessageRecord)localObject2, bool1);
            paramInt = i + paramInt;
            continue;
          }
        }
        else
        {
          paramInt = ((QQMessageFacade.Message)localObject1).unReadNum;
          continue;
        }
        if (localObject1 == null)
        {
          paramString = new QQMessageFacade.Message();
          MessageRecord.copyMessageRecordBaseField(paramString, paramatmp);
          paramString.unReadNum = paramInt;
          return paramString;
        }
      }
      paramString = (String)localObject1;
      continue;
      label496:
      paramString = (String)localObject1;
      continue;
      label502:
      boolean bool1 = true;
      continue;
      label508:
      i -= 1;
      continue;
      label517:
      bool1 = false;
      continue;
      label523:
      Object localObject1 = "time desc , _id desc";
      continue;
      label531:
      localObject1 = "_id desc";
      continue;
      label538:
      i -= 1;
      continue;
      label547:
      int i = 1;
    }
  }
  
  protected ChatHistorySearchData a(Cursor paramCursor, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str2 = paramString.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString = new HashSet();
    a(paramSessionInfo, str1, j, paramString);
    HashSet localHashSet = new HashSet();
    paramString = paramString.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      str1 = (String)paramString.next();
      if (str1 != null)
      {
        localObject = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), str1);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).toLowerCase(Locale.US).contains(str2))) {
          localHashSet.add(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getSearchResult, keyuins = " + localHashSet.toString());
    }
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    if (!paramCursor.isAfterLast())
    {
      paramString = a(paramCursor, paramSessionInfo, j);
      if ((TextUtils.isEmpty(paramString)) || (!localHashSet.contains(paramString))) {
        break label468;
      }
    }
    label465:
    label468:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        str1 = "";
        paramString = str1;
        if (localObject != null) {
          paramString = str1;
        }
      }
      for (;;)
      {
        try
        {
          if (localObject.length > 0) {
            paramString = new String((byte[])localObject, "utf-8");
          }
          if (!paramString.toLowerCase(Locale.US).contains(str2)) {
            break label465;
          }
          i = 1;
          if (i != 0)
          {
            if (localArrayList1.size() >= 50) {
              continue;
            }
            paramString = (MessageRecord)a().a(MessageRecord.class, null, paramCursor);
            if (paramString != null) {
              localArrayList1.add(paramString);
            }
          }
          paramCursor.moveToNext();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = "";
          continue;
          localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
          continue;
        }
        if (localArrayList1.size() > 0)
        {
          paramCursor = new ChatHistorySearchData();
          paramCursor.mSearchData1 = localArrayList1;
          paramCursor.mSearchData2 = localArrayList2;
          return paramCursor;
        }
        return null;
      }
    }
  }
  
  /* Error */
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +26 -> 33
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: getfield 719	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 664	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +13 -> 33
    //   23: aload_2
    //   24: invokestatic 664	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +8 -> 35
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: areturn
    //   35: aload_1
    //   36: getfield 719	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: aload_1
    //   40: getfield 720	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   43: invokestatic 322	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_0
    //   48: invokevirtual 134	akbj:a	()Latmx;
    //   51: iconst_0
    //   52: aload_3
    //   53: aconst_null
    //   54: ldc_w 801
    //   57: iconst_1
    //   58: anewarray 90	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: sipush -1000
    //   66: invokestatic 425	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: ldc_w 677
    //   75: aconst_null
    //   76: invokevirtual 545	atmx:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 5
    //   81: aload_0
    //   82: aload 5
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual 803	akbj:a	(Landroid/database/Cursor;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)Lcom/tencent/mobileqq/data/ChatHistorySearchData;
    //   89: astore_1
    //   90: aload_1
    //   91: astore_3
    //   92: aload 5
    //   94: ifnull -61 -> 33
    //   97: aload 5
    //   99: invokeinterface 553 1 0
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: ifnull -79 -> 33
    //   115: aload 5
    //   117: invokeinterface 553 1 0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload 5
    //   127: ifnull +10 -> 137
    //   130: aload 5
    //   132: invokeinterface 553 1 0
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	akbj
    //   0	139	1	paramSessionInfo	SessionInfo
    //   0	139	2	paramString	String
    //   5	105	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   79	52	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   81	90	106	java/lang/Exception
    //   81	90	124	finally
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt;
      localContentValues = new ContentValues();
      localContentValues.put("msgtype", Integer.valueOf(paramInt));
      if (localMessageRecord == null) {
        break label180;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label137;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
      break;
      label137:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label180:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean1;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.isValid = paramBoolean1;
      localContentValues = new ContentValues();
      localContentValues.put("isValid", Boolean.valueOf(paramBoolean1));
      if (localMessageRecord == null) {
        break label196;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label153;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      label116:
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).reParse();
      }
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
      break;
      label153:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      break label116;
      label196:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0);
  }
  
  protected MessageRecord a(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
      {
        localObject1 = c(paramString, paramInt1);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label253;
        }
        i = ((List)localObject1).size() - 1;
        if (i >= 0)
        {
          if ((paramInt2 != 0) && (((MessageRecord)((List)localObject1).get(i)).getConfessTopicId() != paramInt2)) {
            break label259;
          }
          localObject1 = (MessageRecord)((List)localObject1).get(i);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("getLastMsgFromList mr = ");
            if (localObject1 == null)
            {
              localObject2 = "null";
              QLog.d("Q.msg.MsgProxy", 2, (String)localObject2);
              localObject2 = localObject1;
            }
          }
          else
          {
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              QLog.e("Q.msg.MsgProxy", 1, new Object[] { "getLastMsgFromList no cache", paramString, ",", Integer.valueOf(paramInt1), ",", Integer.valueOf(paramInt2) });
              akbf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt1);
              localObject1 = b(paramString, paramInt1, paramInt2);
            }
            return localObject1;
          }
          localObject2 = ((MessageRecord)localObject1).getBaseInfoString();
        }
      }
      Object localObject1 = null;
      continue;
      label253:
      Object localObject2 = null;
      continue;
      label259:
      i -= 1;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Iterator localIterator = b(paramString, paramInt).iterator();
    MessageRecord localMessageRecord1;
    do
    {
      localMessageRecord1 = localMessageRecord2;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord1 = (MessageRecord)localIterator.next();
    } while (localMessageRecord1.uniseq != paramLong);
    if (localMessageRecord1 == null)
    {
      paramString = e(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localMessageRecord2 = (MessageRecord)paramString.next();
          if (localMessageRecord2.uniseq == paramLong) {
            return localMessageRecord2;
          }
        }
      }
    }
    return localMessageRecord1;
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
      {
        paramString = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt1));
        if (paramString != null)
        {
          Iterator localIterator = paramString.iterator();
          if (localIterator.hasNext())
          {
            paramString = (MessageRecord)localIterator.next();
            if ((paramString.shmsgseq != paramLong) || (paramString.msgtype != paramInt2)) {
              continue;
            }
            return paramString;
          }
        }
      }
      paramString = null;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt1, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extraflag", Integer.valueOf(paramInt2));
    localContentValues.put("sendFailCode", Integer.valueOf(paramInt3));
    if (localMessageRecord != null)
    {
      localMessageRecord.extraflag = paramInt2;
      localMessageRecord.sendFailCode = paramInt3;
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    a(paramString, paramInt1, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      f(paramString, paramInt, paramLong1);
      a(paramString, paramInt, localMessageRecord);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    localContentValues.put("shmsgseq", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Object localObject = a(paramString1, paramInt, paramLong1);
    if ((localObject == null) && (paramString2 != null)) {}
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        paramLong1 = l;
        if (QLog.isColorLevel())
        {
          paramLong1 = l;
          QLog.i("Q.msg.MsgProxy", 2, "can't find message by uniseq, try filename");
        }
        paramLong1 = l;
        paramString2 = a(paramString1, paramInt, l);
        paramLong1 = l;
      }
      catch (NumberFormatException paramString2)
      {
        int i;
        paramString2 = (String)localObject;
        continue;
        a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
        return paramString2;
      }
      if (paramString2 != null)
      {
        paramString2.time = paramLong2;
        i = paramString2.versionCode;
        if ((paramString2.extraflag == 32772) || (paramString2.extraflag == 32768))
        {
          paramString2.extraflag = 0;
          paramString2.sendFailCode = 0;
        }
        f(paramString1, paramInt, paramLong1);
        a(paramString1, paramInt, paramString2);
        if (paramString2.msgtype == -2005) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.uniseq, paramString2.frienduin, paramString2.istroop, paramLong2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + paramString2.getBaseInfoString());
        }
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("time", Long.valueOf(paramLong2));
      if ((paramString2 != null) && (paramString2.extraflag == 0))
      {
        ((ContentValues)localObject).put("extraflag", Integer.valueOf(0));
        ((ContentValues)localObject).put("sendFailCode", Integer.valueOf(0));
      }
      if (paramString2 != null) {
        if (paramString2.getId() > 0L)
        {
          a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(paramString2.getId()) }, null);
          return paramString2;
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return paramString2;
      paramString2 = (String)localObject;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if ((localMessageRecord == null) || (localMessageRecord.versionCode > 0)) {}
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
      label54:
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgData = paramString2.getBytes();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        label149:
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
      }
      for (;;)
      {
        return localMessageRecord;
        localContentValues.put("msg", paramString2);
        break;
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        break label149;
        try
        {
          localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
          label228:
          a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        }
        catch (UnsupportedEncodingException paramString2)
        {
          break label228;
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label54;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    try
    {
      localObject = MessageRecord.class.getDeclaredField(paramString2);
      localClass = ((Field)localObject).getType();
      ((Field)localObject).setAccessible(true);
      if (localMessageRecord != null) {
        ((Field)localObject).set(localMessageRecord, paramObject);
      }
      if (Modifier.isStatic(((Field)localObject).getModifiers())) {
        break label476;
      }
      if (((Field)localObject).isAnnotationPresent(atnz.class)) {
        return localMessageRecord;
      }
      localObject = new ContentValues();
      if (localClass != Long.TYPE) {
        break label189;
      }
      ((ContentValues)localObject).put(paramString2, (Long)paramObject);
    }
    catch (Exception paramString1)
    {
      Object localObject;
      for (;;)
      {
        Class localClass;
        paramString1.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", paramString1);
        return localMessageRecord;
        label189:
        if (localClass == Integer.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Integer)paramObject);
        }
        else if (localClass == String.class)
        {
          ((ContentValues)localObject).put(paramString2, (String)paramObject);
        }
        else if (localClass == Byte.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Byte)paramObject);
        }
        else if (localClass == [B.class)
        {
          ((ContentValues)localObject).put(paramString2, (byte[])paramObject);
        }
        else if (localClass == Short.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Short)paramObject);
        }
        else if (localClass == Boolean.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Boolean)paramObject);
        }
        else if (localClass == Float.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Float)paramObject);
        }
        else if (localClass == Double.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Double)paramObject);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
          continue;
          a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    if (localMessageRecord != null) {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        if (!(localMessageRecord instanceof ChatMessage)) {
          break label476;
        }
        ((ChatMessage)localMessageRecord).reParse();
        return localMessageRecord;
      }
    }
    label476:
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString2 = String.format("select * from " + MessageRecord.getTableName(paramString1, paramInt) + " where time=%d and senderuin=%s", new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt);
    }
    paramString1 = a().a(paramString2, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (MessageRecord)paramString1.next();
        if (paramString2.msg.equals(paramString3)) {
          return paramString2;
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord != null)
    {
      paramString3 = axwb.b(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
      localMessageRecord.msg = paramString3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentToForward: set msg =" + localMessageRecord.getBaseInfoString());
      }
      paramString2 = new ContentValues();
      if ((localMessageRecord.versionCode <= 0) || (paramString3 == null)) {
        break label174;
      }
    }
    try
    {
      paramString2.put("msgData", paramString3.getBytes("UTF-8"));
      label113:
      if (localMessageRecord.getId() > 0L) {
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        label174:
        paramString2.put("msg", paramString3);
        break;
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    catch (UnsupportedEncodingException paramString3)
    {
      break label113;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if (paramArrayOfByte != null) {
      localContentValues.put("msgData", paramArrayOfByte);
    }
    if (localMessageRecord != null)
    {
      localMessageRecord.msgData = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg = " + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    paramString1 = c(paramString1, paramInt);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString1.next();
        if (((localMessageRecord instanceof MessageForTroopFile)) && (paramString2.equals(((MessageForTroopFile)localMessageRecord).url))) {
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    if (bado.a(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    return paramSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    return akbm.a(paramString, paramInt);
  }
  
  protected List<MessageRecord> a(String paramString)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aker localaker = (aker)((Iterator)localObject2).next();
        if ((localaker.jdField_a_of_type_Atmo instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localaker.jdField_a_of_type_Atmo;
          if ((TextUtils.equals(paramString, localaker.jdField_b_of_type_JavaLangString)) && (localaker.jdField_b_of_type_Int == 0)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue tableName=", paramString, ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    return a(b(paramString, paramInt));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1);
      if (i == 0) {}
      try
      {
        for (paramString = d(paramString, paramInt1); paramString != null; paramString = b(paramString, paramInt1, paramInt2))
        {
          paramString = (List)((ArrayList)paramString).clone();
          return paramString;
        }
        return paramString;
      }
      finally {}
    }
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList_confess peerUin: " + paramString + " type: " + paramInt1 + " , autoInit = " + paramBoolean + ", topicId=" + paramInt2);
    }
    Object localObject2;
    List localList;
    Object localObject4;
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
    {
      localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt1));
      int k = 0;
      int i = 0;
      int j = k;
      if (localObject1 != null)
      {
        j = k;
        if (((List)localObject1).size() > 0) {
          if (paramInt2 > 0)
          {
            localObject2 = ((List)localObject1).iterator();
            j = i;
            if (((Iterator)localObject2).hasNext())
            {
              if (((MessageRecord)((Iterator)localObject2).next()).getConfessTopicId() != paramInt2) {
                break label783;
              }
              i += 1;
              break label783;
            }
          }
          else
          {
            j = ((List)localObject1).size();
          }
        }
      }
      if (j != 0) {
        break label742;
      }
      if (!paramBoolean) {
        break label698;
      }
      localList = b(paramString, paramInt1, paramInt2);
      localObject2 = null;
      localObject1 = localObject2;
      if (localList == null) {
        break label575;
      }
      localObject1 = localObject2;
      if (localList.isEmpty()) {
        break label575;
      }
      if ((!QLog.isColorLevel()) || (!baio.a())) {
        break label411;
      }
      localObject1 = new StringBuilder(localList.size() * 48 + 28);
      ((StringBuilder)localObject1).append("getAIOMsgList_confess, msgInfoList: ");
      localObject2 = localList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject4).time).append(",").append(((MessageRecord)localObject4).shmsgseq).append(",").append(((MessageRecord)localObject4).msgtype).append(") ");
      }
    }
    QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    label411:
    Object localObject1 = new ArrayList();
    if (localList.size() > 15)
    {
      localObject2 = new HashMap();
      paramInt2 = localList.size() - 1;
    }
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        localObject4 = akbm.a((MessageRecord)localList.get(paramInt2));
        if (((Map)localObject2).containsKey(localObject4))
        {
          if (((Integer)((Map)localObject2).get(localObject4)).intValue() >= 15) {
            localList.remove(paramInt2);
          } else {
            ((Map)localObject2).put(localObject4, Integer.valueOf(((Integer)((Map)localObject2).get(localObject4)).intValue() + 1));
          }
        }
        else {
          ((Map)localObject2).put(localObject4, Integer.valueOf(1));
        }
      }
      else
      {
        ((List)localObject1).addAll(localList);
        label575:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess continuedList :" + ((List)localObject2).size());
        }
        akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt1), localObject2);
        for (;;)
        {
          return (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt1));
          ((List)localObject1).addAll(localList);
          break;
          label698:
          akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt1));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAIOMsgList_confess().remove");
          }
          return localObject1;
          label742:
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess from aioPool size = " + ((List)localObject1).size());
          }
        }
        label783:
        break;
      }
      paramInt2 -= 1;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + paramString + " , type = " + paramInt1 + " , customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL！ ");
      }
      localObject1 = b(paramString, paramInt1);
    }
    for (;;)
    {
      long l1 = 9223372036854775807L;
      long l4 = 9223372036854775807L;
      HashSet localHashSet = new HashSet();
      int i;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        i = 0;
        while (i < paramArrayOfInt.length)
        {
          localHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
          i += 1;
        }
      }
      long l3;
      long l2;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((((List)localObject1).size() >= paramInt2) && (localHashSet.isEmpty()))
        {
          localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
        }
        l3 = l1;
        Object localObject2;
        if (a(paramInt1))
        {
          localObject2 = ((List)localObject1).iterator();
          for (;;)
          {
            l3 = l1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if (localMessageRecord.shmsgseq < l1) {
              l1 = localMessageRecord.shmsgseq;
            }
          }
        }
        localObject1 = ((List)localObject1).iterator();
        i = 3;
        l2 = 9223372036854775807L;
        l1 = l4;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((!a(paramInt1)) || (((MessageRecord)localObject2).versionCode != 3) || (((MessageRecord)localObject2).shmsgseq != l3) || (l3 == 0L)) {
            for (;;)
            {
              int j;
              long l5;
              if (!localHashSet.contains(Integer.valueOf(((MessageRecord)localObject2).msgtype)))
              {
                j = i;
                l5 = l1;
                l4 = l2;
                if (!localHashSet.isEmpty()) {}
              }
              else
              {
                j = i;
                if (((MessageRecord)localObject2).versionCode < i) {
                  j = ((MessageRecord)localObject2).versionCode;
                }
                l4 = l2;
                if (((MessageRecord)localObject2).getId() > 0L)
                {
                  l4 = l2;
                  if (((MessageRecord)localObject2).getId() < l2) {
                    l4 = ((MessageRecord)localObject2).getId();
                  }
                }
                l2 = l1;
                if (((MessageRecord)localObject2).time < l1) {
                  l2 = ((MessageRecord)localObject2).time;
                }
                localArrayList.add(localObject2);
                l5 = l2;
              }
              i = j;
              l1 = l5;
              l2 = l4;
            }
          }
        }
        if (localArrayList.size() >= paramInt2) {
          return localArrayList.subList(localArrayList.size() - paramInt2, localArrayList.size());
        }
        l4 = l3;
        l3 = l1;
        l1 = l4;
      }
      for (;;)
      {
        if (a(paramInt1)) {
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l1, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        l3 = 9223372036854775807L;
        i = 3;
        l1 = 9223372036854775807L;
        l2 = 9223372036854775807L;
      }
    }
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + apck.e(paramString) + "] type[" + paramInt + "] uniseq[" + paramLong + "]");
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    Object localObject;
    do
    {
      return paramString;
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where uniseq=?";
      localObject = a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = ((atmx)localObject).a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
      paramString = (String)localObject;
    } while (localObject != null);
    return new ArrayList();
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList, jump to peerUin: " + paramString + " type: " + paramInt1 + " , from = " + paramLong);
    }
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
    {
      if (a(paramInt1))
      {
        localList = d(paramString, paramInt1, paramLong, 2147483647L);
        Object localObject1 = localList;
        if (localList == null) {
          localObject1 = new ArrayList();
        }
        akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt1), localObject1);
        return localObject1;
      }
      List localList = a(paramString, paramInt1, paramLong, 2147483647L, paramInt2);
    }
  }
  
  protected List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + paramString1 + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",whrere = " + paramString2);
    }
    paramString2 = badk.a(MessageRecord.getOldTableName(paramString1, paramInt1), MessageRecord.getTableName(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), paramString2);
    if (paramString2 != null)
    {
      if (a(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      paramString1 = a().a(paramString2.toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("QQMessageFacade", 2, paramString2.toString());
      }
      if (paramString1 != null)
      {
        Collections.reverse(paramString1);
        paramString2 = paramString1.iterator();
        while (paramString2.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
          if (QLog.isColorLevel()) {
            QLog.i("QQMessageFacade", 2, "queryTimedMessageDBUnion " + localMessageRecord.time + ", " + localMessageRecord.getId() + ", " + localMessageRecord.getLogColorContent());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    Object localObject2 = null;
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt1);
    }
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(") ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, (String)localObject1);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    boolean bool = a(paramInt1);
    if (badk.a(MessageRecord.getTableName(paramString1, paramInt1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b()))
    {
      if (bool) {}
      for (paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2); paramString1 != null; paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2)) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = g(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange, peerUin = " + paramString + ", type " + paramInt1 + ",beginTime = " + paramLong1 + ",endTime = " + paramLong2 + ",topicId=" + paramInt2);
    }
    Object localObject1 = b(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).time >= paramLong1) && (((MessageRecord)localObject2).time <= paramLong2) && ((paramInt2 <= 0) || (((MessageRecord)localObject2).getConfessTopicId() == paramInt2))) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).time == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    if ((paramInt2 > 0) && ((paramInt1 == 1033) || (paramInt1 == 1034))) {}
    for (int i = alyc.a(paramInt1, paramInt2) << 3;; i = 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ");
      ((StringBuilder)localObject1).append(MessageRecord.getTableName(paramString, paramInt1));
      ((StringBuilder)localObject1).append(" where time>=? and time<=?");
      if (i != 0) {
        ((StringBuilder)localObject1).append(" and (extLong & 4194296)=?");
      }
      ((StringBuilder)localObject1).append(" order by time asc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange " + ((StringBuilder)localObject1).toString());
      }
      if (localArrayList.size() > 0) {
        paramLong2 = ((MessageRecord)localArrayList.get(0)).time;
      }
      paramLong1 = Math.min(paramLong1, paramLong2);
      Object localObject3;
      if (localArrayList != null)
      {
        localObject2 = localArrayList.iterator();
        do
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label466;
            }
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if (((MessageRecord)localObject3).time != paramLong2) {
              break;
            }
            ((Iterator)localObject2).remove();
          }
        } while (((MessageRecord)localObject3).time <= paramLong2);
      }
      label466:
      if (i == 0)
      {
        localObject2 = a();
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ((atmx)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt1).append(",queryBeginTime = ").append(paramLong1).append(",queryEndTime = ").append(paramLong2).append(",resultSize=");
          if (localObject1 != null) {
            break label692;
          }
        }
      }
      label692:
      for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1 + ",topicId=" + paramInt2);
        if (localObject1 != null) {
          localArrayList.addAll(0, (Collection)localObject1);
        }
        return localArrayList;
        localObject2 = a();
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ((atmx)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i) }, (QQAppInterface)localObject3);
        break;
      }
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, Map<String, MessageRecord> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + paramString + ", type " + paramInt + ", seq = " + paramLong + ", filterMsgSet.size = " + ((Map)localObject1).size() + ",filterMsgSet = " + ((Map)localObject1).keySet());
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + paramString);
    }
    paramMap = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramMap = paramMap.a(paramString, new String[] { String.valueOf(paramLong) }, (QQAppInterface)localObject2);
    if (paramMap == null) {
      return new ArrayList();
    }
    paramString = new ArrayList();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (MessageRecord)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + ((MessageRecord)localObject2).shmsgseq + " ,id = " + ((MessageRecord)localObject2).getId() + ",uniseq=" + ((MessageRecord)localObject2).uniseq);
      }
      if ((!((Map)localObject1).containsKey("id&" + ((MessageRecord)localObject2).getId() + "&" + ((MessageRecord)localObject2).shmsgseq)) && (!((Map)localObject1).containsKey("uniseq&" + ((MessageRecord)localObject2).uniseq + "&" + ((MessageRecord)localObject2).shmsgseq))) {
        paramString.add(localObject2);
      }
    }
    return paramString;
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, awrt paramawrt)
  {
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        String str = a(paramString, paramInt);
        List localList2 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(str);
        List localList1 = localList2;
        if (localList2 == null)
        {
          long l = System.nanoTime();
          localList1 = b(paramString, paramInt, paramawrt);
          b(paramString, paramInt, localList1);
          if (!baio.a()) {
            break label294;
          }
          paramawrt = (awaq)awao.b.get(str);
          if (paramawrt == null)
          {
            paramawrt = new awaq();
            paramawrt.jdField_a_of_type_JavaLangString = paramString;
            paramawrt.jdField_a_of_type_Boolean = false;
            if (localList1.isEmpty()) {
              break label297;
            }
            bool = true;
            paramawrt.b = bool;
            paramawrt.jdField_a_of_type_Long = ((System.nanoTime() - l) / 1000000L);
            awao.b.put(str, paramawrt);
            break label294;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramawrt = new StringBuilder();
            paramawrt.append("getMsgList2 uin ").append(paramString).append(" , type = ").append(paramInt).append(" itemList size=").append(localList1.size());
            if ((jdField_b_of_type_Int % 20 == 0) && (jdField_b_of_type_Int > 100)) {
              paramawrt.append("\n").append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
            }
            QLog.d("Q.msg.MsgProxy", 2, paramawrt.toString());
            jdField_b_of_type_Int += 1;
          }
          return localList1;
        }
      }
      continue;
      label294:
      continue;
      label297:
      boolean bool = false;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    if ((paramList == null) || (paramString == null) || (paramString.length() == 0) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < paramList.size())
      {
        localMessageRecord = a(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord != null) {}
      }
      else
      {
        if (i < paramList.size() - 1) {
          localArrayList.addAll(b(paramString, paramInt, paramList.subList(i, paramList.size())));
        }
        return localArrayList;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    int i;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label1158;
        }
        if (!paramBoolean1) {
          break label1115;
        }
        localObject1 = new awrt();
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          i = 1;
          ((awrt)localObject1).jdField_a_of_type_Int = i;
          ((awrt)localObject1).jdField_a_of_type_JavaLangString = "select";
          ((awrt)localObject1).jdField_b_of_type_JavaLangString = "AIO";
          localObject2 = a(paramString, paramInt, (awrt)localObject1);
          if ((((awrt)localObject1).jdField_b_of_type_Int != 0) && (awrn.a()) && (awrn.a(1)))
          {
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("param_IsMainThread", String.valueOf(((awrt)localObject1).jdField_a_of_type_Int));
            ((HashMap)localObject4).put("param_OptType", ((awrt)localObject1).jdField_a_of_type_JavaLangString);
            ((HashMap)localObject4).put("param_OptTotalCost", String.valueOf(((awrt)localObject1).jdField_a_of_type_Long));
            ((HashMap)localObject4).put("param_OptCount", String.valueOf(((awrt)localObject1).jdField_b_of_type_Int));
            ((HashMap)localObject4).put("param_OptMsgCount", String.valueOf(((awrt)localObject1).c));
            ((HashMap)localObject4).put("param_OptOneCost", String.valueOf(((awrt)localObject1).jdField_b_of_type_Long));
            ((HashMap)localObject4).put("param_OptScene", ((awrt)localObject1).jdField_b_of_type_JavaLangString);
            ((HashMap)localObject4).put("param_WalSwitch", String.valueOf(ajrl.jdField_a_of_type_Boolean));
            awrn.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, ((awrt)localObject1).c, 0L, (HashMap)localObject4, null, false);
          }
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break label1102;
          }
          if ((!QLog.isColorLevel()) || (!baio.a())) {
            break label541;
          }
          localObject1 = new StringBuilder(((List)localObject2).size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
          localObject4 = ((List)localObject2).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (MessageRecord)((Iterator)localObject4).next();
          ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject5).time).append(",").append(((MessageRecord)localObject5).shmsgseq).append(",").append(((MessageRecord)localObject5).msgtype).append(") ");
        }
      }
      i = 0;
    }
    QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
    label541:
    Object localObject1 = new ArrayList();
    if ((paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1044))
    {
      if (((List)localObject2).size() > 15)
      {
        ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 15, ((List)localObject2).size()));
        if (akbm.a(paramString, paramInt, (List)localObject1)) {
          break label1202;
        }
        if (!akbm.c((List)localObject1)) {
          break label1208;
        }
        break label1202;
        if ((((List)localObject2).size() > 15) && (i != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
          }
          ((List)localObject1).clear();
          if (((List)localObject2).size() <= 30) {
            break label901;
          }
          ((List)localObject1).addAll(((List)localObject2).subList(((List)localObject2).size() - 30, ((List)localObject2).size()));
        }
      }
      for (;;)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
        if (localObject2 == null) {
          break label1199;
        }
        localObject2 = a((List)localObject1, ((Long)((Pair)localObject2).first).longValue());
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label1199;
        }
        localObject1 = localObject2;
        label778:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + ((List)localObject2).size());
        }
        akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString, paramInt), localObject2);
        label859:
        return (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        ((List)localObject1).addAll((Collection)localObject2);
        break;
        label901:
        ((List)localObject1).addAll((Collection)localObject2);
      }
      label914:
      if (((List)localObject2).size() > 15)
      {
        localObject4 = new HashMap();
        i = ((List)localObject2).size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        localObject5 = akbm.a((MessageRecord)((List)localObject2).get(i));
        if (((Map)localObject4).containsKey(localObject5))
        {
          if (((Integer)((Map)localObject4).get(localObject5)).intValue() >= 15) {
            ((List)localObject2).remove(i);
          } else {
            ((Map)localObject4).put(localObject5, Integer.valueOf(((Integer)((Map)localObject4).get(localObject5)).intValue() + 1));
          }
        }
        else {
          ((Map)localObject4).put(localObject5, Integer.valueOf(1));
        }
      }
      else
      {
        ((List)localObject1).addAll((Collection)localObject2);
        break label778;
        ((List)localObject1).addAll((Collection)localObject2);
        break label778;
        label1102:
        label1115:
        do
        {
          ((List)localObject1).addAll((Collection)localObject2);
          break label778;
          localObject1 = d(paramString, paramInt, 15);
          break label778;
          akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(a(paramString, paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAioMsgPool().remove");
          }
          return null;
          if (!QLog.isColorLevel()) {
            break label859;
          }
          QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aioPool size = " + ((List)localObject1).size());
          break label859;
          break label778;
          i = 1;
          break;
          i = 0;
          break;
          if (paramInt == 1033) {
            break label914;
          }
        } while (paramInt != 1034);
        label1158:
        label1199:
        label1202:
        label1208:
        break label914;
      }
      i -= 1;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = e(paramString, paramInt);
    paramString = new HashSet();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramString.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
    long l;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramString.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
        }
        return localArrayList;
      }
      paramArrayOfInt = ((List)localObject).iterator();
      l = 9223372036854775807L;
      if (paramArrayOfInt.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfInt.next();
        if (localMessageRecord.shmsgseq >= l) {
          break label282;
        }
        l = localMessageRecord.shmsgseq;
      }
    }
    label282:
    for (;;)
    {
      break;
      paramArrayOfInt = ((List)localObject).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (MessageRecord)paramArrayOfInt.next();
        if (((!a(paramInt)) || (((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty()))) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      paramString = akbm.a(paramString, paramInt);
      akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().remove(paramString);
      paramString = (agjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      paramString.e = null;
      paramString.f = null;
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set<String> paramSet)
  {
    paramSet.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramSet.add(paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, akes paramakes)
  {
    if (paramInt2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramakes);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt1, MessageRecord.getOldTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramakes);
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    if (a(paramInt)) {}
    String str2;
    String str3;
    for (String str1 = "shmsgseq";; str1 = "time")
    {
      str2 = String.valueOf(paramLong);
      str3 = MessageRecord.getTableName(paramString, paramInt);
      if ((!akbm.a(paramInt)) || (akbm.d() == null)) {
        break;
      }
      a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=? and " + akbm.d(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    String str = a(paramString, paramInt);
    for (;;)
    {
      List localList;
      int i;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        if (!akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().containsKey(str)) {
          break label415;
        }
        localList = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(str);
        int k = 0;
        i = 0;
        int j = k;
        Object localObject2;
        if (i < localList.size())
        {
          localObject2 = (MessageRecord)localList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "find cache " + ((MessageRecord)localObject2).getBaseInfoString());
          }
          if (((MessageRecord)localObject2).uniseq != paramLong) {
            break label419;
          }
          j = i;
        }
        if ((j > 0) && (j < localList.size()))
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < j)
          {
            MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "removeList " + localMessageRecord.getBaseInfoString());
            }
            ((List)localObject2).add(localMessageRecord);
            i += 1;
            continue;
          }
          localList.removeAll((Collection)localObject2);
          ((List)localObject2).clear();
          localList.addAll(0, paramList);
          if (localList.size() <= 40) {
            break label407;
          }
          i = localList.size() - 40;
          if (i > 0)
          {
            localList.remove(0);
            i -= 1;
            continue;
          }
        }
        else
        {
          if (j != 0) {
            continue;
          }
          localList.addAll(0, paramList);
        }
      }
      paramList = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a();
      if ((akdn.jdField_a_of_type_Boolean) && (paramList.getCacheType(str) == akdn.d)) {
        paramList.changeCacheType(str, akdn.c);
      }
      label407:
      b(paramString, paramInt, localList);
      label415:
      return;
      label419:
      i += 1;
    }
  }
  
  protected void a(String paramString, int paramInt, atmo paramatmo, akes paramakes)
  {
    if (((paramatmo instanceof MessageRecord)) && (((MessageRecord)paramatmo).versionCode > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramatmo, 0, paramakes);
    }
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      List localList = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (localList != null)
      {
        akbm.a(localList, paramMessageRecord, true);
        if (localList.size() > 40)
        {
          localList.remove(0);
          paramMessageRecord = a(paramString, paramInt);
          MsgLruCache localMsgLruCache = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a();
          if ((akdn.jdField_a_of_type_Boolean) && (localMsgLruCache.getCacheType(paramMessageRecord) == akdn.d)) {
            localMsgLruCache.changeCacheType(paramMessageRecord, akdn.c);
          }
        }
        b(paramString, paramInt, localList);
      }
      return;
    }
  }
  
  protected void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str;
    if (((paramInt1 == 1001) || (paramInt1 == 10002)) && (paramMessageRecord.msgtype != -1003) && (paramMessageRecord.msgtype != -1031) && (paramMessageRecord.msgtype != -1032) && (paramMessageRecord.msgtype != 201)) {
      if (paramMessageRecord.versionCode > 0)
      {
        str = MessageRecord.getTableName(String.valueOf(ajed.H), 1001);
        a(paramString, paramInt1, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
    label316:
    do
    {
      for (;;)
      {
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
        return;
        str = MessageRecord.getOldTableName(String.valueOf(ajed.H), 1001);
        break;
        if (paramInt1 == 1009)
        {
          a(paramString, paramInt1, MessageRecord.getTableName(ajed.w, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
        else if (paramInt1 == 1010)
        {
          a(paramString, paramInt1, MessageRecord.getTableName(ajed.aa, 1010), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
        else
        {
          if ((paramInt1 != 0) || (!TextUtils.equals(paramString, ajed.M))) {
            break label316;
          }
          a(paramString, paramInt1, MessageRecord.getTableName(ajed.M, 0), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
      }
      if ((paramInt1 == 1032) && (TextUtils.equals(paramString, ajed.aL)))
      {
        a(paramString, paramInt1, MessageRecord.getTableName(paramString, paramInt1), localContentValues, "isread=?", new String[] { "0" }, null);
        return;
      }
    } while ((paramInt1 != 1033) && (paramInt1 != 1034));
    paramInt2 = alyc.a(paramInt1, paramInt2) << 3;
    a(paramString, paramInt1, MessageRecord.getTableName(ajed.aL, 1032), localContentValues, "senderuin=? and isread=? and (extLong & 4194296)=? ", new String[] { paramString, "0", Integer.toString(paramInt2) }, null);
    a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=? and (extLong & 4194296)=?", new String[] { "0", Integer.toString(paramInt2) }, null);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, akes paramakes)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), paramMessageRecord, 0, paramakes);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, akes paramakes, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((akbm.n(paramMessageRecord.msgtype)) && (!akbm.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {}
    while (!paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramString, paramInt, paramMessageRecord, paramakes);
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramakes);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, akes paramakes, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    a(paramString, paramInt, paramMessageRecord, paramakes, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    label388:
    label393:
    for (;;)
    {
      Object localObject1;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = a(paramString, paramInt);
        a(paramString, paramInt, (String)localObject1, (List)localObject3);
        akbm.a((List)localObject3, paramMessageRecord, true);
        if ((localObject3 != null) && (((List)localObject3).size() > 40) && (!akbm.a(paramString)))
        {
          ((List)localObject3).remove(0);
          localObject3 = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a();
          if ((akdn.jdField_a_of_type_Boolean) && (((MsgLruCache)localObject3).getCacheType(localObject1) == akdn.d)) {
            ((MsgLruCache)localObject3).changeCacheType(localObject1, akdn.c);
          }
        }
        if ((akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(localObject1)) && (paramBoolean))
        {
          localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(localObject1);
          if (localObject1 != null) {
            break label393;
          }
          localObject1 = new ArrayList();
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != 3211265)) {
            break label388;
          }
          paramInt = 1;
          if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != 655392)) {
            break label382;
          }
          i = 1;
          if (paramString.equals(ajed.G)) {
            ((List)localObject1).add(0, paramMessageRecord);
          }
        }
        else
        {
          return;
          QLog.d("Q.msg.MsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
          continue;
        }
        if ((paramMessageRecord.msgtype == -4021) || (paramInt != 0) || (i != 0)) {
          akbm.a((List)localObject1, paramMessageRecord, true);
        }
      }
      ((List)localObject1).add(paramMessageRecord);
      continue;
      label382:
      int i = 0;
      continue;
      paramInt = 0;
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramakes);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    for (;;)
    {
      List localList;
      ArrayList localArrayList;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString1, paramInt1))
      {
        localList = d(paramString1, paramInt1);
        localArrayList = new ArrayList();
        if (localList == null) {
          break label161;
        }
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord.senderuin == null) || (localMessageRecord.selfuin == null) || (!localMessageRecord.senderuin.equals(paramString2)) || (!localMessageRecord.selfuin.equals(paramString3))) {
            continue;
          }
          if ((paramInt2 == 0) || (paramInt2 != localMessageRecord.getExtraKey())) {
            break label250;
          }
          localArrayList.add(localMessageRecord);
        }
      }
      localList.removeAll(localArrayList);
      label161:
      if (paramInt2 == 0L) {
        a(paramString1, paramInt1, MessageRecord.getTableName(paramString1, paramInt1), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
      }
      for (;;)
      {
        localArrayList.clear();
        return;
        if (paramInt1 == 1032)
        {
          paramString1 = localArrayList.iterator();
          while (paramString1.hasNext()) {
            a((MessageRecord)paramString1.next(), false);
          }
        }
      }
      label250:
      if (paramInt2 != 0) {}
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramakes);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    label217:
    label221:
    for (;;)
    {
      Object localObject1;
      List localList;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        if (!akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(a(paramString, paramInt))) {
          break label217;
        }
        localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().get(a(paramString, paramInt));
        if (localObject1 != null) {
          break label221;
        }
        localObject1 = new ArrayList();
        localList = akbm.a((List)localObject1, paramList);
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (MessageRecord)localIterator.next();
          if (!(localObject3 instanceof MessageForPoke)) {
            continue;
          }
          localObject3 = (MessageForPoke)localObject3;
          if (((MessageForPoke)localObject3).isPlayed) {
            continue;
          }
          ((MessageForPoke)localObject3).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if (agjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString)) {
        ajzy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList, localList, true, false);
      }
      ((List)localObject1).addAll(0, localList);
      paramList.clear();
      paramList.addAll(localList);
      return;
    }
  }
  
  public void a(List<MessageRecord> paramList, akes paramakes)
  {
    b(akbm.a(paramList), paramakes);
  }
  
  public boolean a()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().keySet().iterator();
        Object localObject1 = null;
        if (!localIterator.hasNext()) {
          break label430;
        }
        String str = (String)localIterator.next();
        if (((str != null) && (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().keySet().contains(str))) || ((str != null) && (akbm.b(str)))) {
          continue;
        }
        if (str != null)
        {
          List localList = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(str);
          localObject5 = str;
          localObject6 = localList;
          if (localList != null)
          {
            localObject5 = str;
            localObject6 = localList;
            if (localList.size() > 0)
            {
              localObject5 = (MessageRecord)localList.get(0);
              if (a(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop, true)) {
                continue;
              }
              localObject5 = str;
              localObject6 = localList;
              if (localObject1 == null) {
                break label410;
              }
              if (localObject1.size() == 0)
              {
                localObject5 = str;
                localObject6 = localList;
                break label410;
              }
              if ((localList == null) || (localList.size() <= 0)) {
                break label420;
              }
              localObject5 = str;
              localObject6 = localList;
              if (((MessageRecord)localList.get(localList.size() - 1)).time < ((MessageRecord)localObject1.get(localObject1.size() - 1)).time) {
                break label410;
              }
              break label420;
            }
          }
          if (localObject5 != null)
          {
            awao.jdField_a_of_type_Boolean = true;
            akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().remove(localObject5);
            if (QLog.isColorLevel())
            {
              if ((localObject6 == null) || (((List)localObject6).size() <= 0)) {
                continue;
              }
              l = ((MessageRecord)((List)localObject6).get(((List)localObject6).size() - 1)).time;
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "MsgPool.getPoolInstance().getMsgPool().remove:", localObject5, ",time=", Long.valueOf(l) });
            }
          }
          return true;
          long l = 0L;
          continue;
          localObject4 = localObject5;
        }
      }
      finally {}
      label410:
      Object localObject3;
      for (;;)
      {
        localObject3 = localObject6;
        break;
        label420:
        localObject5 = localObject4;
        localObject6 = localObject3;
      }
      label430:
      Object localObject5 = localObject4;
      Object localObject6 = localObject3;
    }
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if (a(paramInt)) {
      if (paramLong < paramMessageRecord.shmsgseq) {}
    }
    while (paramLong >= paramMessageRecord.time)
    {
      return true;
      return false;
    }
    return false;
  }
  
  boolean a(String paramString, int paramInt)
  {
    return (paramString != null) && (paramString.length() >= 6) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000));
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList)
  {
    avau localavau = (avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    if ((!akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().containsKey(paramString2)) && (localavau.a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "insertToAioMsgPool because of orderMediaMsgSending " + paramString1);
      }
      paramString2 = new ArrayList();
      if (paramList.size() > 15) {
        paramString2.addAll(paramList.subList(paramList.size() - 15, paramList.size()));
      }
      for (;;)
      {
        akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().put(a(paramString1, paramInt), paramString2);
        return true;
        paramString2.addAll(paramList);
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.jdField_a_of_type_JavaLangObject)
      {
        Vector localVector = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
        i = 0;
        if (i < localVector.size())
        {
          aker localaker = (aker)localVector.get(i);
          if ((akbm.a(localaker.jdField_a_of_type_JavaLangString, paramString, localaker.jdField_a_of_type_Int, paramInt)) && ((localaker.jdField_b_of_type_Int == 1) || (localaker.jdField_b_of_type_Int == 2) || ((paramBoolean) && (localaker.jdField_b_of_type_Int == 0))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase uin=", paramString, ", type=", LargerInteger.valueOf(paramInt), ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
            }
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().iterator();
      while (localIterator.hasNext())
      {
        aker localaker = (aker)localIterator.next();
        if (TextUtils.isEmpty(localaker.jdField_b_of_type_JavaLangString)) {
          return true;
        }
        if ((paramString.equals(localaker.jdField_b_of_type_JavaLangString)) && ((localaker.jdField_b_of_type_Int == 1) || (localaker.jdField_b_of_type_Int == 2) || ((paramBoolean) && (localaker.jdField_b_of_type_Int == 0))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase tableName=", paramString, ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
          }
          return true;
        }
      }
      return false;
    }
  }
  
  protected int b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {}
    for (paramMessageRecord = a(paramMessageRecord, false, paramBoolean); paramMessageRecord == null; paramMessageRecord = a(paramMessageRecord, -2006, paramBoolean)) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  protected int b(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().iterator();
        if (localIterator.hasNext())
        {
          aker localaker = (aker)localIterator.next();
          if ((localaker.jdField_a_of_type_Atmo instanceof MessageRecord))
          {
            MessageRecord localMessageRecord = (MessageRecord)localaker.jdField_a_of_type_Atmo;
            if ((akbm.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt)) && (localaker.jdField_b_of_type_Int == 0) && (localMessageRecord.time > paramLong) && (!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
              i += 1;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getUnreadCountFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", lastRead=", Integer.valueOf(i) });
          }
          return i;
        }
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    String str1 = MessageRecord.getTableName(paramString, paramInt);
    if (a(str1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(this.jdField_a_of_type_Atmx);
    }
    String str2 = akbm.b();
    if (a(paramInt)) {}
    for (paramString = "shmsgseq asc , _id desc";; paramString = "time asc , _id desc")
    {
      paramString = String.format("select * from %s m where m.isValid=1 and m.msgtype %s order by %s limit 1", new Object[] { str1, str2, paramString });
      paramString = a().a(MessageRecord.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break;
      }
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  protected MessageRecord b(String paramString, int paramInt1, int paramInt2)
  {
    String str1 = MessageRecord.getTableName(paramString, paramInt1);
    if (a(str1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(this.jdField_a_of_type_Atmx);
    }
    paramString = new StringBuilder(512);
    paramString.append("select * from %s m where m.isValid=1");
    paramString.append(" order by %s limit 1");
    String str2 = paramString.toString();
    if (a(paramInt1))
    {
      paramString = "shmsgseq desc , _id desc";
      paramString = String.format(str2, new Object[] { str1, paramString });
      paramString = a().a(MessageRecord.class, paramString, null);
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramInt1 = paramString.size() - 1;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 < 0) {
          break label171;
        }
        if (((MessageRecord)paramString.get(paramInt1)).getConfessTopicId() == paramInt2)
        {
          return (MessageRecord)paramString.get(paramInt1);
          paramString = "time desc , _id desc";
          break;
        }
        paramInt1 -= 1;
      }
    }
    label171:
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = c(paramString, paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramString = a(paramString, paramInt, paramLong);
      localObject2 = localObject1;
      if (paramString == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.isEmpty()) {
        break;
      }
      return (MessageRecord)paramString.get(0);
      localObject1 = null;
    }
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + paramString1 + ", type " + paramInt);
    }
    if (a(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    if (a(paramInt))
    {
      localStringBuilder = new StringBuilder().append("select * from ").append(MessageRecord.getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(akbm.a()).append(" ");
      if (paramString2 != null) {}
      for (paramString1 = "and " + paramString2;; paramString1 = "")
      {
        paramString1 = paramString1 + " order by shmsgseq desc , _id desc limit 1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + paramString1);
        }
        paramString1 = a().a(paramString1, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((paramString1 != null) && (paramString1.size() >= 1)) {
          break;
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("select * from ").append(MessageRecord.getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(akbm.a()).append(" ");
    if (paramString2 != null) {}
    for (paramString1 = "and " + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1 + " order by time desc , _id desc limit 1";
      break;
    }
    return (MessageRecord)paramString1.get(0);
  }
  
  protected String b(String paramString, int paramInt)
  {
    if (akbm.a(paramString)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc , _id desc";
    }
    if (akbm.c(paramInt)) {
      return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where _id in (select _id from " + MessageRecord.getTableName(paramString, paramInt) + " order by time desc limit " + 40 + ") order by time desc, _id desc";
    }
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " order by _id desc limit " + 40;
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = d(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List<MessageRecord> b(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    label234:
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
      {
        Object localObject1 = a(paramString, paramInt1);
        localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(localObject1);
        int j = k;
        if (localObject1 != null)
        {
          j = k;
          if (((List)localObject1).size() > 0) {
            if (paramInt2 > 0)
            {
              Iterator localIterator = ((List)localObject1).iterator();
              j = i;
              if (localIterator.hasNext())
              {
                if (((MessageRecord)localIterator.next()).getConfessTopicId() != paramInt2) {
                  break label234;
                }
                i += 1;
                break label234;
              }
            }
            else
            {
              j = ((List)localObject1).size();
            }
          }
        }
        if (j == 0)
        {
          localObject1 = f(paramString, paramInt1, paramInt2);
          b(paramString, paramInt1, (List)localObject1);
        }
        if ((localObject1 != null) && (QLog.isColorLevel())) {
          QLog.d("Q.msg.MsgProxy", 2, String.format("getMsgList_confess uin:%s type:%d topicId:%d size:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(((List)localObject1).size()) }));
        }
        return localObject1;
      }
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    ArrayList localArrayList;
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt1))
    {
      localArrayList = new ArrayList();
      paramString = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt1));
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramString.next();
          if ((localMessageRecord.shmsgseq == paramLong) && (localMessageRecord.msgtype == paramInt2)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (a(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = "select * from " + MessageRecord.getTableName(paramString1, paramInt1) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
    long l;
    if (paramString2 == null)
    {
      paramString2 = "";
      paramString2 = String.format((String)localObject, new Object[] { paramString2 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      if (paramInt2 > 0) {
        break label274;
      }
      l = 0L;
    }
    for (;;)
    {
      localObject = a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString2 = ((atmx)localObject).a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l) }, localQQAppInterface);
      if (paramString2 == null) {
        break label298;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      paramString2 = "and " + paramString2;
      break;
      label274:
      if (paramLong > paramInt2) {
        l = paramLong - paramInt2;
      } else {
        l = 0L;
      }
    }
    label298:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = f(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  List<MessageRecord> b(String paramString, int paramInt, awrt paramawrt)
  {
    Object localObject1;
    long l1;
    String str;
    boolean bool;
    List localList;
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        localObject1 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + paramString);
          }
          return localObject1;
        }
        l1 = System.currentTimeMillis();
        str = b(paramString, paramInt);
        bool = a(paramString, paramInt, false);
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
        }
        localList = g(paramString, paramInt);
        l2 = System.nanoTime();
        localObject1 = a().a(str, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (TextUtils.equals(paramawrt.jdField_b_of_type_JavaLangString, "launch"))
        {
          l2 = (System.nanoTime() - l2) / 1000L;
          paramawrt.jdField_a_of_type_Long += l2;
          paramawrt.jdField_b_of_type_Int += 1;
          paramawrt.c += 1;
          paramawrt.jdField_b_of_type_Long = (paramawrt.jdField_a_of_type_Long / paramawrt.jdField_b_of_type_Int);
          if ((awrn.c) && (QLog.isColorLevel()) && (a(paramString, paramInt))) {
            QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "|select|launch|1|" + l2 / 1000L + "|" + paramString);
          }
          if (localObject1 == null) {
            break;
          }
          int j = ((List)localObject1).size() / 2;
          paramInt = ((List)localObject1).size();
          int i = 0;
          paramInt -= 1;
          if (i >= j) {
            break label935;
          }
          paramawrt = (MessageRecord)((List)localObject1).get(i);
          ((List)localObject1).set(i, ((List)localObject1).get(paramInt));
          ((List)localObject1).set(paramInt, paramawrt);
          i += 1;
          paramInt -= 1;
          continue;
        }
        if (TextUtils.equals(paramawrt.jdField_b_of_type_JavaLangString, "AIO"))
        {
          l2 = (System.nanoTime() - l2) / 1000L;
          paramawrt.jdField_a_of_type_Long = l2;
          paramawrt.jdField_b_of_type_Int = 1;
          paramawrt.c = 1;
          paramawrt.jdField_b_of_type_Long = (paramawrt.jdField_a_of_type_Long / paramawrt.jdField_b_of_type_Int);
          if ((!awrn.c) || (!QLog.isColorLevel()) || (!a(paramString, paramInt))) {
            continue;
          }
          QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "|select|AIO|1|" + l2 / 1000L + "|" + paramString);
        }
      }
      long l2 = (System.nanoTime() - l2) / 1000L;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label930;
      }
      paramInt = 1;
      if ((paramInt != 0) && (awrn.a()) && (awrn.a(2)))
      {
        paramawrt.jdField_a_of_type_Int = 1;
        paramawrt.jdField_a_of_type_JavaLangString = "select";
        paramawrt.jdField_b_of_type_JavaLangString = "mainThread";
        paramawrt.jdField_a_of_type_Long = l2;
        paramawrt.jdField_b_of_type_Int = 1;
        paramawrt.c = 1;
        paramawrt.jdField_b_of_type_Long = (paramawrt.jdField_a_of_type_Long / paramawrt.jdField_b_of_type_Int);
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_IsMainThread", String.valueOf(paramawrt.jdField_a_of_type_Int));
        localHashMap.put("param_OptType", paramawrt.jdField_a_of_type_JavaLangString);
        localHashMap.put("param_OptTotalCost", String.valueOf(paramawrt.jdField_a_of_type_Long));
        localHashMap.put("param_OptCount", String.valueOf(paramawrt.jdField_b_of_type_Int));
        localHashMap.put("param_OptMsgCount", String.valueOf(paramawrt.c));
        localHashMap.put("param_OptOneCost", String.valueOf(paramawrt.jdField_b_of_type_Long));
        localHashMap.put("param_OptScene", paramawrt.jdField_b_of_type_JavaLangString);
        localHashMap.put("param_WalSwitch", String.valueOf(ajrl.jdField_a_of_type_Boolean));
        awrn.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, paramawrt.c, 0L, localHashMap, null, false);
      }
    }
    for (;;)
    {
      localObject1 = akbm.a(paramawrt, localList).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          akbm.a(paramawrt, (MessageRecord)((Iterator)localObject1).next(), true);
          continue;
          paramawrt = new ArrayList();
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l1), " sqlStr = ", str, " size =", Integer.valueOf(paramawrt.size()) });
      }
      return paramawrt;
      label930:
      paramInt = 0;
      break;
      label935:
      paramawrt = (awrt)localObject1;
    }
  }
  
  protected List<MessageRecord> b(String paramString, int paramInt, List<Long> paramList)
  {
    int j = 0;
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("queryMessagesByMsgUniseqFromDB, peerUin[").append(apck.e(paramString)).append("] type[").append(paramInt).append("] uniseqList[");
      if (paramList == null)
      {
        i = 0;
        QLog.d("Q.msg.MsgProxy", 2, i + "]");
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label125;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    label125:
    do
    {
      return paramString;
      i = paramList.size();
      break;
      if (a(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
      }
      localObject = new String[paramList.size()];
      StringBuilder localStringBuilder = new StringBuilder("(");
      i = j;
      while (i < paramList.size())
      {
        localObject[i] = String.valueOf(((Long)paramList.get(i)).longValue());
        localStringBuilder.append("?");
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, uniseq list=" + localStringBuilder.toString());
      }
      paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where uniseq in " + localStringBuilder.toString();
      paramList = a().a(paramString, (String[])localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = paramList;
    } while (paramList != null);
    return new ArrayList();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Atmx != null) && (this.jdField_a_of_type_Atmx.a())) {
      this.jdField_a_of_type_Atmx.a();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      localObject2 = d(paramString, paramInt);
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!akbm.a(paramInt)) || (!akbm.m(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
    }
    paramString = f(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (MessageRecord)paramString.next();
      if ((!((MessageRecord)localObject2).isread) && (a(paramInt, paramLong, (MessageRecord)localObject2)) && ((!akbm.a(paramInt)) || (!akbm.m(((MessageRecord)localObject2).msgtype)))) {
        ((MessageRecord)localObject2).isread = true;
      }
    }
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.uniseq != 0L)) {}
    do
    {
      return;
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + paramMessageRecord.getBaseInfoString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
  }
  
  public int c(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = e(paramString, paramInt, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->removeSingleMsg : peerUin:").append(paramString).append(" type:").append(paramInt).append(" uniseq:").append(paramLong).append(" mr:").append(localMessageRecord).append(" dbid:");
      if (localMessageRecord != null)
      {
        localObject = Long.valueOf(localMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (localMessageRecord == null) {
        break label213;
      }
      long l = localMessageRecord.getId();
      if (l == -1L) {
        break label182;
      }
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      a(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (!localMessageRecord.isread) {
        break label211;
      }
      return 1;
      localObject = "mr is null.";
      break;
      label182:
      a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    label211:
    return 2;
    label213:
    a(paramString, paramInt, MessageRecord.getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.shmsgseq == paramLong) {
          return localMessageRecord;
        }
      }
    }
    return g(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt)
  {
    ??? = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (??? == null)
    {
      QLog.e("Q.msg.MsgProxy", 1, "cloneMsgListWithoutInit null pool, " + paramString + "," + paramInt);
      return null;
    }
    synchronized (((akbi)???).a(paramString, paramInt))
    {
      paramString = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
    }
    return paramString;
  }
  
  protected List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aker localaker = (aker)((Iterator)localObject2).next();
        if ((localaker.jdField_a_of_type_Atmo instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localaker.jdField_a_of_type_Atmo;
          if ((akbm.a(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt1)) && (localaker.jdField_b_of_type_Int == 0) && ((paramInt2 <= 0) || (localMessageRecord.getConfessTopicId() == paramInt2))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt1), ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    paramString = MessageRecord.getTableName(paramString, paramInt1);
    Object localObject1 = "select * from " + paramString + " where (shmsgseq < ? and msgtype " + akbm.b() + " and isValid=1) order by shmsgseq desc limit ";
    Object localObject2 = new String[1];
    localObject2[0] = String.valueOf(paramLong);
    paramString = a().a((String)localObject1 + paramInt2, (String[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString == null) {
      paramString = new ArrayList();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq list.size=" + paramString.size());
      }
      if (paramString.size() < paramInt2)
      {
        atob localatob = (atob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201);
        if (localatob != null)
        {
          localObject1 = localatob.a().a((String)localObject1 + (paramInt2 - paramString.size()), (String[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("queryBeforeHistoryByShmsgseq list2.size=");
            if (localObject1 != null) {
              break label455;
            }
          }
        }
      }
      label455:
      for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1);
        if (localObject1 != null) {
          paramString.addAll((Collection)localObject1);
        }
        Collections.reverse(paramString);
        if (!QLog.isColorLevel()) {
          break label497;
        }
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
        }
      }
      QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq return size=" + paramString.size());
      label497:
      return paramString;
    }
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + paramString);
    }
    Object localObject = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((atmx)localObject).a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, List<Integer> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 50) {
      localObject = paramList.subList(0, 50);
    }
    paramString = MessageRecord.getTableName(paramString, paramInt);
    paramList = new String[1];
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      paramList[0] = String.valueOf(((Integer)localIterator.next()).intValue());
      localObject = a().a(false, paramString, null, "_id = ?", paramList, null, null, null, null);
      if (localObject != null) {}
      try
      {
        localArrayList.add((MessageRecord)a().a(MessageRecord.class, null, (Cursor)localObject));
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MsgProxy", 2, localException, new Object[0]);
        }
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    try
    {
      akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().clear();
      agjk localagjk = (agjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      localagjk.e = null;
      localagjk.f = null;
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = c(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong) && (!akbm.a(localMessageRecord))) {
          return localMessageRecord;
        }
      }
    }
    return h(paramString, paramInt, paramLong);
  }
  
  protected List<MessageRecord> d(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    for (;;)
    {
      Object localObject2;
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        localObject2 = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          long l = System.nanoTime();
          localObject2 = b(paramString, paramInt, new awrt());
          b(paramString, paramInt, (List)localObject2);
          if (!baio.a()) {
            break label310;
          }
          localObject1 = (awaq)awao.b.get(str);
          if (localObject1 == null)
          {
            localObject1 = new awaq();
            ((awaq)localObject1).jdField_a_of_type_JavaLangString = paramString;
            ((awaq)localObject1).jdField_a_of_type_Boolean = false;
            if (((List)localObject2).isEmpty()) {
              break label317;
            }
            bool = true;
            ((awaq)localObject1).b = bool;
            ((awaq)localObject1).jdField_a_of_type_Long = ((System.nanoTime() - l) / 1000000L);
            awao.b.put(str, localObject1);
            break label310;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getMsgList1 uin ").append(paramString).append(" , type = ").append(paramInt).append(" itemList size=").append(((List)localObject1).size());
            if ((jdField_a_of_type_Int % 20 == 0) && (jdField_a_of_type_Int > 100)) {
              ((StringBuilder)localObject2).append("\n").append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
            }
            QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject2).toString());
            jdField_a_of_type_Int += 1;
          }
          return localObject1;
        }
      }
      continue;
      label310:
      Object localObject1 = localObject2;
      continue;
      label317:
      boolean bool = false;
    }
  }
  
  protected List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + MessageRecord.getOldTableName(paramString, paramInt1) + " order by _id desc limit " + paramInt2 + " ) order by _id asc", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = a().a((String)localObject, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
    }
    Object localObject2 = MessageRecord.getTableName(paramString, paramInt1);
    paramString = "select * from " + (String)localObject2 + " where (shmsgseq >= ? and msgtype " + akbm.b() + " and isValid=1) order by shmsgseq asc limit " + (paramInt2 + 1);
    Object localObject1 = new String[1];
    localObject1[0] = String.valueOf(paramLong);
    paramString = a().a(paramString, (String[])localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString == null)
    {
      localObject1 = new ArrayList();
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq list.size=" + paramString.size());
    }
    if ((paramString.size() > 0) && (((MessageRecord)paramString.get(0)).shmsgseq == paramLong)) {
      paramString.remove(0);
    }
    label512:
    label552:
    for (;;)
    {
      localObject1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
      }
      atob localatob = (atob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201);
      if (localatob != null)
      {
        localObject2 = "select * from " + (String)localObject2 + " where (shmsgseq > ? and msgtype " + akbm.b() + " and isValid=1) order by shmsgseq asc limit " + paramInt2;
        localObject1 = localatob.a().a((String)localObject2, (String[])localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("queryLaterHistoryByShmsgseq list2.size=");
          if (localObject1 != null) {
            break label501;
          }
        }
        label501:
        for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
        {
          QLog.d("Q.msg.MsgProxy", 2, paramInt1);
          if (localObject1 == null) {
            break label552;
          }
          if (((List)localObject1).size() != paramInt2) {
            break label512;
          }
          paramString = (String)localObject1;
          break;
        }
        paramString.addAll(0, (Collection)localObject1);
        if (paramString.size() > paramInt2) {
          paramString.subList(paramInt2, paramString.size()).clear();
        }
      }
    }
    QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq return size=" + paramString.size());
    return paramString;
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromSeqRange, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    Object localObject1 = b(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).shmsgseq >= paramLong1) && (((MessageRecord)localObject2).shmsgseq <= paramLong2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).shmsgseq == paramLong1)) {
      return localArrayList;
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    localObject1 = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + (String)localObject1);
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).shmsgseq;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    if (localArrayList != null)
    {
      localObject2 = localArrayList.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label379;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (((MessageRecord)localObject3).shmsgseq != paramLong2) {
            break;
          }
          ((Iterator)localObject2).remove();
        }
      } while (((MessageRecord)localObject3).shmsgseq <= paramLong2);
    }
    label379:
    Object localObject2 = a();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = ((atmx)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt).append(",queryBeginSeq = ").append(paramLong1).append(",queryEndSeq = ").append(paramLong2).append(",resultSize=");
      if (localObject1 != null) {
        break label522;
      }
    }
    label522:
    for (paramInt = 0;; paramInt = ((List)localObject1).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject1 != null) {
        localArrayList.addAll(0, (Collection)localObject1);
      }
      return localArrayList;
    }
  }
  
  public void d()
  {
    akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().clear();
    akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).b().clear();
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt);
    List localList = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject3 = d(paramString, paramInt);
        localObject1 = localList;
        if (localObject3 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          localObject1 = localList;
          if (localIterator.hasNext())
          {
            localObject1 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject1).uniseq != paramLong) {
              continue;
            }
            ((List)localObject3).remove(localObject1);
          }
        }
        localList = f(paramString, paramInt);
        if (localList != null)
        {
          localObject3 = localList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (MessageRecord)((Iterator)localObject3).next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      finally {}
      paramString = (String)localObject1;
    }
  }
  
  public List<MessageRecord> e(String paramString, int paramInt)
  {
    synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
    {
      paramString = f(paramString, paramInt);
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
  }
  
  protected List<MessageRecord> e(String paramString, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = String.format("select * from " + MessageRecord.getTableName(paramString, paramInt1) + " where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    atmx localatmx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = localatmx.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, localQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, paramLong1, paramLong2, 0);
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	akbj:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   4: invokevirtual 328	com/tencent/mobileqq/app/proxy/ProxyManager:d	()V
    //   7: aload_0
    //   8: getfield 81	akbj:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   11: invokevirtual 1832	com/tencent/mobileqq/app/proxy/ProxyManager:e	()V
    //   14: aload_0
    //   15: invokevirtual 134	akbj:a	()Latmx;
    //   18: invokevirtual 1835	atmx:a	()Latmr;
    //   21: astore 11
    //   23: aload_0
    //   24: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 1837	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   30: astore 12
    //   32: aload 12
    //   34: invokevirtual 1842	com/tencent/mobileqq/app/SQLiteDatabase:b	()[Ljava/lang/String;
    //   37: astore 13
    //   39: aload 13
    //   41: ifnonnull +4 -> 45
    //   44: return
    //   45: aload_0
    //   46: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: sipush 201
    //   52: invokevirtual 563	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   55: checkcast 565	atob
    //   58: astore 14
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: aload 13
    //   65: arraylength
    //   66: if_icmpge -22 -> 44
    //   69: aload 13
    //   71: iload_1
    //   72: aaload
    //   73: astore 15
    //   75: aload 15
    //   77: ldc_w 1844
    //   80: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   83: ifeq +449 -> 532
    //   86: new 103	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 1846
    //   96: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 15
    //   101: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 1848
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 15
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 378
    //   118: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 8
    //   126: aload 8
    //   128: ifnull +286 -> 414
    //   131: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +31 -> 165
    //   137: ldc_w 341
    //   140: iconst_2
    //   141: new 103	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 1850
    //   151: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 8
    //   156: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 12
    //   167: aload 8
    //   169: aconst_null
    //   170: invokevirtual 1853	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull +170 -> 347
    //   180: aload 9
    //   182: astore 8
    //   184: aload 9
    //   186: invokeinterface 550 1 0
    //   191: ifle +156 -> 347
    //   194: aload 9
    //   196: astore 8
    //   198: aload 9
    //   200: invokeinterface 753 1 0
    //   205: pop
    //   206: aload 9
    //   208: astore 8
    //   210: aload 9
    //   212: aload 9
    //   214: ldc_w 1855
    //   217: invokeinterface 1858 2 0
    //   222: invokeinterface 1862 2 0
    //   227: lstore 6
    //   229: aload 9
    //   231: astore 8
    //   233: aload 9
    //   235: aload 9
    //   237: ldc_w 1863
    //   240: invokeinterface 1858 2 0
    //   245: invokeinterface 1028 2 0
    //   250: astore 10
    //   252: aload 9
    //   254: astore 8
    //   256: aload 9
    //   258: aload 9
    //   260: ldc_w 1864
    //   263: invokeinterface 1858 2 0
    //   268: invokeinterface 788 2 0
    //   273: istore_2
    //   274: aload 9
    //   276: astore 8
    //   278: aload 9
    //   280: aload 9
    //   282: ldc_w 1029
    //   285: invokeinterface 1858 2 0
    //   290: invokeinterface 788 2 0
    //   295: istore_3
    //   296: lload 6
    //   298: lstore 4
    //   300: aload 9
    //   302: astore 8
    //   304: iload_2
    //   305: invokestatic 516	akbj:a	(I)Z
    //   308: ifne +20 -> 328
    //   311: lload 6
    //   313: lstore 4
    //   315: iload_3
    //   316: iconst_1
    //   317: if_icmpne +11 -> 328
    //   320: lload 6
    //   322: ldc2_w 1865
    //   325: ladd
    //   326: lstore 4
    //   328: aload 9
    //   330: astore 8
    //   332: aload_0
    //   333: getfield 30	akbj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   336: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   339: aload 10
    //   341: iload_2
    //   342: lload 4
    //   344: invokevirtual 1868	awao:a	(Ljava/lang/String;IJ)V
    //   347: aload 9
    //   349: ifnull +10 -> 359
    //   352: aload 9
    //   354: invokeinterface 553 1 0
    //   359: aload 11
    //   361: ifnull +8 -> 369
    //   364: aload 11
    //   366: invokevirtual 1871	atmr:a	()V
    //   369: aload 12
    //   371: aload 15
    //   373: aconst_null
    //   374: aconst_null
    //   375: invokevirtual 1872	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   378: pop
    //   379: aload 11
    //   381: ifnull +8 -> 389
    //   384: aload 11
    //   386: invokevirtual 1874	atmr:c	()V
    //   389: aload 11
    //   391: ifnull +8 -> 399
    //   394: aload 11
    //   396: invokevirtual 1876	atmr:b	()V
    //   399: aload 14
    //   401: ifnull +13 -> 414
    //   404: aload 14
    //   406: aload 15
    //   408: aconst_null
    //   409: aconst_null
    //   410: invokevirtual 594	atob:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   413: pop
    //   414: iload_1
    //   415: iconst_1
    //   416: iadd
    //   417: istore_1
    //   418: goto -356 -> 62
    //   421: astore 10
    //   423: aconst_null
    //   424: astore 9
    //   426: aload 9
    //   428: astore 8
    //   430: aload 10
    //   432: invokevirtual 785	java/lang/Exception:printStackTrace	()V
    //   435: aload 9
    //   437: ifnull -78 -> 359
    //   440: aload 9
    //   442: invokeinterface 553 1 0
    //   447: goto -88 -> 359
    //   450: astore 9
    //   452: aconst_null
    //   453: astore 8
    //   455: aload 8
    //   457: ifnull +10 -> 467
    //   460: aload 8
    //   462: invokeinterface 553 1 0
    //   467: aload 9
    //   469: athrow
    //   470: astore 8
    //   472: aload 8
    //   474: invokevirtual 785	java/lang/Exception:printStackTrace	()V
    //   477: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +14 -> 494
    //   483: ldc 248
    //   485: iconst_2
    //   486: ldc_w 1878
    //   489: aload 8
    //   491: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload 11
    //   496: ifnull -97 -> 399
    //   499: aload 11
    //   501: invokevirtual 1876	atmr:b	()V
    //   504: goto -105 -> 399
    //   507: astore 8
    //   509: aload 11
    //   511: ifnull +8 -> 519
    //   514: aload 11
    //   516: invokevirtual 1876	atmr:b	()V
    //   519: aload 8
    //   521: athrow
    //   522: astore 9
    //   524: goto -69 -> 455
    //   527: astore 10
    //   529: goto -103 -> 426
    //   532: aconst_null
    //   533: astore 8
    //   535: goto -409 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	akbj
    //   61	357	1	i	int
    //   273	69	2	j	int
    //   295	23	3	k	int
    //   298	45	4	l1	long
    //   227	94	6	l2	long
    //   124	337	8	localObject1	Object
    //   470	20	8	localException1	Exception
    //   507	13	8	localObject2	Object
    //   533	1	8	localObject3	Object
    //   173	268	9	localCursor	Cursor
    //   450	18	9	localObject4	Object
    //   522	1	9	localObject5	Object
    //   250	90	10	str1	String
    //   421	10	10	localException2	Exception
    //   527	1	10	localException3	Exception
    //   21	494	11	localatmr	atmr
    //   30	340	12	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   37	33	13	arrayOfString	String[]
    //   58	347	14	localatob	atob
    //   73	334	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   165	175	421	java/lang/Exception
    //   165	175	450	finally
    //   364	369	470	java/lang/Exception
    //   369	379	470	java/lang/Exception
    //   384	389	470	java/lang/Exception
    //   364	369	507	finally
    //   369	379	507	finally
    //   384	389	507	finally
    //   472	494	507	finally
    //   184	194	522	finally
    //   198	206	522	finally
    //   210	229	522	finally
    //   233	252	522	finally
    //   256	274	522	finally
    //   278	296	522	finally
    //   304	311	522	finally
    //   332	347	522	finally
    //   430	435	522	finally
    //   184	194	527	java/lang/Exception
    //   198	206	527	java/lang/Exception
    //   210	229	527	java/lang/Exception
    //   233	252	527	java/lang/Exception
    //   256	274	527	java/lang/Exception
    //   278	296	527	java/lang/Exception
    //   304	311	527	java/lang/Exception
    //   332	347	527	java/lang/Exception
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    for (;;)
    {
      synchronized (akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(paramString, paramInt))
      {
        List localList = (List)akbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().get(a(paramString, paramInt));
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            paramString = (MessageRecord)localIterator.next();
            if (paramString.uniseq != paramLong) {
              continue;
            }
            localList.remove(paramString);
            return paramString;
          }
        }
      }
      paramString = null;
    }
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false, false);
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB, peerUin[" + apck.e(paramString) + "] type[" + paramInt + "] time[" + paramLong1 + "] uid[" + paramLong2 + "]");
    }
    if ((paramLong2 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB Warning! msgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where time=? and msgUid=?";
    atmx localatmx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = localatmx.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByTimeFromDB, peerUin[").append(apck.e(paramString)).append("] type[").append(paramInt).append("] time[").append(paramLong1).append("] uid[").append(paramLong2).append("], list.size():");
      if (localObject != null) {
        break label286;
      }
    }
    label286:
    for (paramInt = i;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return localObject;
    }
    return new ArrayList();
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(this.jdField_a_of_type_Atmx);
    }
  }
  
  protected MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + apck.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    Object localObject = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    atmx localatmx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = localatmx.a((String)localObject, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByShmsgseqFromDB, peerUin[").append(apck.e(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
      if (localObject != null) {
        break label260;
      }
    }
    label260:
    for (paramInt = 0;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
    return null;
  }
  
  protected List<MessageRecord> g(String paramString, int paramInt)
  {
    return c(paramString, paramInt, 0);
  }
  
  protected List<MessageRecord> g(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + apck.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if (((paramLong1 == 0L) || (paramLong2 == 0L)) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=? and msgUid=?";
    atmx localatmx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localatmx.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected MessageRecord h(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop, peerUin[" + apck.e(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
    }
    if (a(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=? and msgtype " + akbm.c();
    atmx localatmx = a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = localatmx.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  public MessageRecord i(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = c(paramString, paramInt, paramLong);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = (atob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(201);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMsgItemHistoryByShmsgseq, looking for slow db");
      }
      localObject1 = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
      localObject2 = ((atob)localObject2).a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ((atmx)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("queryMsgItemHistoryByShmsgseq, slow db return peerUin[").append(apck.e(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
        if (localObject1 != null) {
          break label210;
        }
      }
      label210:
      for (paramInt = 0;; paramInt = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt);
        if (localObject1 == null) {
          break;
        }
        return (MessageRecord)((List)localObject1).get(0);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbj
 * JD-Core Version:    0.7.0.1
 */