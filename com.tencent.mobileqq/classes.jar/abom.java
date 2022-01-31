import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class abom
  extends amiz
{
  awbw jdField_a_of_type_Awbw = null;
  awcg jdField_a_of_type_Awcg = new abon(this);
  protected QQConcurrentHashMap<String, ConversationInfo> a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  
  public abom(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = new QQConcurrentHashMap(1005, 0, 100);
  }
  
  private awbw a()
  {
    if ((this.jdField_a_of_type_Awbw == null) || (!this.jdField_a_of_type_Awbw.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Awbw == null) || (!this.jdField_a_of_type_Awbw.a())) {
        this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_Awbw;
    }
  }
  
  /* Error */
  protected int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +106 -> 115
    //   12: aload_0
    //   13: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_3
    //   17: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +95 -> 115
    //   23: aload_0
    //   24: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_3
    //   28: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +84 -> 115
    //   34: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +55 -> 92
    //   40: ldc 83
    //   42: iconst_2
    //   43: new 85	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   50: ldc 88
    //   52: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 94
    //   61: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   68: aload_3
    //   69: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   75: getfield 100	com/tencent/mobileqq/data/ConversationInfo:extInt3	I
    //   78: iconst_1
    //   79: iand
    //   80: invokestatic 106	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   83: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   96: aload_3
    //   97: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   103: getfield 100	com/tencent/mobileqq/data/ConversationInfo:extInt3	I
    //   106: istore_2
    //   107: iload_2
    //   108: iconst_1
    //   109: iand
    //   110: istore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: iload_2
    //   114: ireturn
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -6 -> 111
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	abom
    //   0	125	1	paramString	String
    //   0	125	2	paramInt	int
    //   7	90	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	8	120	finally
    //   12	92	120	finally
    //   92	107	120	finally
  }
  
  /* Error */
  public long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 119	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   37: lstore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_3
    //   41: lreturn
    //   42: lconst_0
    //   43: lstore_3
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	abom
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    //   37	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  /* Error */
  protected ConversationInfo a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +30 -> 39
    //   12: aload_0
    //   13: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +19 -> 39
    //   23: aload_0
    //   24: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	abom
    //   0	49	1	paramString	String
    //   0	49	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	44	finally
    //   12	35	44	finally
  }
  
  public Set<ConversationInfo> a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.unread.Proxy", 2, "cloneConversationInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  protected void a() {}
  
  protected void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = abot.a(paramString, paramInt);
      if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
      {
        localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
        ((ConversationInfo)localObject).extInt3 = (((ConversationInfo)localObject).extInt3 >> 1 << 1);
        a(paramString, paramInt, (ConversationInfo)localObject);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 > 0) {
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Proxy", 2, "setUnreadForImax uin=" + paramString);
        }
        localObject = abot.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).unreadCount != i)
          {
            ((ConversationInfo)localObject).unreadCount = i;
            QLog.d("Q.unread.Proxy", 1, "setUnreadForImax update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "setUnreadForImax nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.unreadCount = i;
      QLog.d("Q.unread.Proxy", 1, "setUnreadForImax insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  /* Error */
  protected void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 6
    //   15: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +66 -> 84
    //   21: aload_0
    //   22: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 6
    //   27: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +54 -> 84
    //   33: aload_0
    //   34: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 6
    //   39: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 6
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 6
    //   52: getfield 119	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: aload 6
    //   57: getfield 151	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   60: iload_3
    //   61: iadd
    //   62: aload 6
    //   64: getfield 172	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   67: iload 4
    //   69: iadd
    //   70: aload 6
    //   72: getfield 175	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   75: iload 5
    //   77: iadd
    //   78: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: aload_0
    //   85: aload_1
    //   86: iload_2
    //   87: lconst_0
    //   88: iload_3
    //   89: iload 4
    //   91: iload 5
    //   93: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   96: goto -15 -> 81
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	abom
    //   0	104	1	paramString	String
    //   0	104	2	paramInt1	int
    //   0	104	3	paramInt2	int
    //   0	104	4	paramInt3	int
    //   0	104	5	paramInt4	int
    //   7	64	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	81	99	finally
    //   84	96	99	finally
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = abot.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((((ConversationInfo)localObject).lastread < paramLong) && (abol.a(paramInt1))) || ((((ConversationInfo)localObject).lastread != paramLong) && (!abol.a(paramInt1))) || (((ConversationInfo)localObject).unreadCount != paramInt2) || (((ConversationInfo)localObject).unreadGiftCount != paramInt3) || (((ConversationInfo)localObject).extInt1 != paramInt4))
          {
            long l = paramLong;
            if (abol.a(paramInt1)) {
              l = Math.max(((ConversationInfo)localObject).lastread, paramLong);
            }
            ((ConversationInfo)localObject).lastread = l;
            ((ConversationInfo)localObject).unreadCount = Math.max(0, paramInt2);
            ((ConversationInfo)localObject).unreadGiftCount = Math.max(0, paramInt3);
            ((ConversationInfo)localObject).extInt1 = Math.max(0, paramInt4);
            if (paramInt2 == 0) {
              ((ConversationInfo)localObject).extInt3 = (((ConversationInfo)localObject).extInt3 >> 1 << 1);
            }
            QLog.d("Q.unread.Proxy_UnreadMonitor", 1, "insertOrUpdateUnread update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread  nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, paramLong, Math.max(0, paramInt2));
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.unreadGiftCount = Math.max(0, paramInt3);
      localConversationInfo.extInt1 = Math.max(0, paramInt4);
      if (paramInt2 == 0) {
        localConversationInfo.extInt3 = (localConversationInfo.extInt3 >> 1 << 1);
      }
      QLog.d("Q.unread.Proxy_UnreadMonitor", 1, "insertOrUpdateUnread insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 4, null);
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.recent.RecentBaseData paramRecentBaseData)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +51 -> 54
    //   6: aload_1
    //   7: invokevirtual 216	com/tencent/mobileqq/activity/recent/RecentBaseData:a	()Ljava/lang/String;
    //   10: aload_1
    //   11: invokevirtual 219	com/tencent/mobileqq/activity/recent/RecentBaseData:a	()I
    //   14: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +23 -> 54
    //   34: aload_1
    //   35: getfield 175	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   38: istore_2
    //   39: iload_2
    //   40: ifle +9 -> 49
    //   43: iconst_1
    //   44: istore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_3
    //   51: goto -6 -> 45
    //   54: iconst_0
    //   55: istore_3
    //   56: goto -11 -> 45
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	abom
    //   0	64	1	paramRecentBaseData	com.tencent.mobileqq.activity.recent.RecentBaseData
    //   38	2	2	i	int
    //   44	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	30	59	finally
    //   34	39	59	finally
  }
  
  /* Error */
  protected int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 151	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	abom
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  protected void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
      if ((this.jdField_a_of_type_Awbw != null) && (this.jdField_a_of_type_Awbw.a())) {
        this.jdField_a_of_type_Awbw.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    for (;;)
    {
      String str;
      ConversationInfo localConversationInfo;
      try
      {
        str = abot.a(paramString, paramInt);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str) != null))
        {
          localConversationInfo = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str);
          if ((((ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str)).unreadCount > 0) && (!aljq.aR.equals(paramString)) && (!aljq.aS.equals(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed return , updateinfo= " + localConversationInfo.toString());
            }
            return;
          }
          localConversationInfo.unreadCount += 1;
          localConversationInfo.extInt3 = (((ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str)).extInt3 | 0x1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed update=" + localConversationInfo.toString());
          }
          a(paramString, paramInt, localConversationInfo);
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt, 0L, 0);
      }
      finally {}
      localConversationInfo.extInt3 = 1;
      localConversationInfo.unreadCount += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed insert=" + localConversationInfo.toString());
      }
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(str, localConversationInfo);
      b(paramString, paramInt, localConversationInfo);
    }
  }
  
  protected void b(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = abot.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).unreadMark != paramInt2)
          {
            ((ConversationInfo)localObject).unreadMark = paramInt2;
            QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark update=" + ((ConversationInfo)localObject).toString());
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnreadMark nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.unreadMark = paramInt2;
      QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark insert=" + localConversationInfo.toString());
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void b(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 3, null);
  }
  
  /* Error */
  protected int c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 172	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	abom
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 83
    //   8: iconst_2
    //   9: ldc_w 256
    //   12: invokestatic 259	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   19: invokevirtual 222	com/tencent/commonsdk/cache/QQConcurrentHashMap:clear	()V
    //   22: aload_0
    //   23: invokespecial 261	abom:a	()Lawbw;
    //   26: ldc 96
    //   28: invokestatic 206	com/tencent/mobileqq/data/ConversationInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   31: iconst_0
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aload_0
    //   39: getfield 31	abom:jdField_a_of_type_Awcg	Lawcg;
    //   42: invokevirtual 264	awbw:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lawcg;)Ljava/util/List;
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 62	abom:jdField_a_of_type_Boolean	Z
    //   50: ifeq +46 -> 96
    //   53: aload_0
    //   54: invokespecial 261	abom:a	()Lawbw;
    //   57: ldc 96
    //   59: invokevirtual 267	awbw:a	(Ljava/lang/Class;)Z
    //   62: pop
    //   63: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 83
    //   71: iconst_2
    //   72: ldc_w 269
    //   75: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: invokestatic 275	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   81: invokestatic 280	azmz:a	(Landroid/content/Context;)Lazmz;
    //   84: aconst_null
    //   85: ldc_w 282
    //   88: iconst_1
    //   89: lconst_1
    //   90: lconst_0
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 285	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   96: aload_2
    //   97: ifnonnull +4 -> 101
    //   100: return
    //   101: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +34 -> 138
    //   107: ldc 83
    //   109: iconst_2
    //   110: new 85	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 287
    //   120: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: invokeinterface 292 1 0
    //   129: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iconst_0
    //   139: istore_1
    //   140: iload_1
    //   141: aload_2
    //   142: invokeinterface 292 1 0
    //   147: if_icmpge -47 -> 100
    //   150: aload_0
    //   151: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   154: aload_2
    //   155: iload_1
    //   156: invokeinterface 298 2 0
    //   161: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   164: getfield 301	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   167: aload_2
    //   168: iload_1
    //   169: invokeinterface 298 2 0
    //   174: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   177: getfield 304	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   180: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   183: aload_2
    //   184: iload_1
    //   185: invokeinterface 298 2 0
    //   190: invokevirtual 165	com/tencent/commonsdk/cache/QQConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: iload_1
    //   195: iconst_1
    //   196: iadd
    //   197: istore_1
    //   198: goto -58 -> 140
    //   201: astore_2
    //   202: aload_2
    //   203: athrow
    //   204: astore_2
    //   205: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	abom
    //   139	59	1	i	int
    //   45	139	2	localList	java.util.List
    //   201	2	2	localObject	Object
    //   204	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   140	194	201	finally
    //   140	194	204	java/lang/Exception
  }
  
  protected void c(String paramString, int paramInt)
  {
    try
    {
      String str = abot.a(paramString, paramInt);
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(str))
      {
        c(paramString, paramInt, (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str));
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.remove(str);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void c(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = abot.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject);
          if (((ConversationInfo)localObject).extInt2 != paramInt2)
          {
            ((ConversationInfo)localObject).extInt2 = paramInt2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.unread.Proxy", 1, "insertOrUpdateSubAccountTroopUnRead update=" + ((ConversationInfo)localObject).toString());
            }
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateSubAccountTroopUnRead nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, 0L, 0);
      }
      finally {}
      ConversationInfo localConversationInfo;
      localConversationInfo.extInt2 = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Proxy", 1, "insertOrUpdateSubAccountTroopUnRead insert=" + localConversationInfo.toString());
      }
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void c(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 5, null);
  }
  
  /* Error */
  protected int d(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   30: getfield 175	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	abom
    //   0	48	1	paramString	String
    //   0	48	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	34	43	finally
  }
  
  protected void d()
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
          if ((localConversationInfo.unreadCount > 0) || (localConversationInfo.unreadMark > 0))
          {
            localConversationInfo.unreadCount = 0;
            localConversationInfo.unreadGiftCount = 0;
            localConversationInfo.unreadMark = 0;
            localConversationInfo.extInt1 = 0;
            localConversationInfo.extInt3 = (localConversationInfo.extInt3 >> 1 << 1);
            a(localConversationInfo.uin, localConversationInfo.type, localConversationInfo);
          }
          if (localConversationInfo.extInt2 > 0) {
            localConversationInfo.extInt2 = 0;
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  protected void d(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +54 -> 72
    //   21: aload_0
    //   22: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +42 -> 72
    //   33: aload_0
    //   34: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 4
    //   39: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 4
    //   52: getfield 119	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: iload_3
    //   56: aload 4
    //   58: getfield 172	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   61: aload 4
    //   63: getfield 175	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   66: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: aload_1
    //   74: iload_2
    //   75: lconst_0
    //   76: iload_3
    //   77: iconst_0
    //   78: iconst_0
    //   79: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   82: goto -13 -> 69
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	abom
    //   0	90	1	paramString	String
    //   0	90	2	paramInt1	int
    //   0	90	3	paramInt2	int
    //   7	55	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	69	85	finally
    //   72	82	85	finally
  }
  
  /* Error */
  protected void e(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 68	abot:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 72	com/tencent/commonsdk/cache/QQConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +60 -> 78
    //   21: aload_0
    //   22: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +48 -> 78
    //   33: aload_0
    //   34: getfield 38	abom:jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap	Lcom/tencent/commonsdk/cache/QQConcurrentHashMap;
    //   37: aload 4
    //   39: invokevirtual 76	com/tencent/commonsdk/cache/QQConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 96	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 4
    //   52: getfield 119	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: aload 4
    //   57: getfield 151	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   60: iload_3
    //   61: iadd
    //   62: aload 4
    //   64: getfield 172	com/tencent/mobileqq/data/ConversationInfo:unreadGiftCount	I
    //   67: aload 4
    //   69: getfield 175	com/tencent/mobileqq/data/ConversationInfo:extInt1	I
    //   72: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: aload_1
    //   80: iload_2
    //   81: lconst_0
    //   82: iload_3
    //   83: iconst_0
    //   84: iconst_0
    //   85: invokevirtual 178	abom:a	(Ljava/lang/String;IJIII)V
    //   88: goto -13 -> 75
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	abom
    //   0	96	1	paramString	String
    //   0	96	2	paramInt1	int
    //   0	96	3	paramInt2	int
    //   7	61	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	75	91	finally
    //   78	88	91	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abom
 * JD-Core Version:    0.7.0.1
 */