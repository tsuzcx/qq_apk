import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager.5;
import com.tencent.mobileqq.app.NewFriendManager.6;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class alxr
  extends Observable
  implements Handler.Callback, Manager
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private altm jdField_a_of_type_Altm = new alxu(this);
  private alto jdField_a_of_type_Alto;
  private alwd jdField_a_of_type_Alwd;
  private alzu jdField_a_of_type_Alzu;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public aoor a;
  private aufw jdField_a_of_type_Aufw = new alxv(this);
  private awgf jdField_a_of_type_Awgf;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<avun> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<avun> jdField_a_of_type_JavaUtilComparator = new alxs(this);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<alxx> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Long, SysSuspiciousMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
  public boolean a;
  private int jdField_b_of_type_Int;
  ArrayList<avui> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<SysSuspiciousMsg> jdField_b_of_type_JavaUtilComparator = new alxt(this);
  public boolean b;
  private int jdField_c_of_type_Int;
  private Comparator<Object> jdField_c_of_type_JavaUtilComparator = new alxw(this);
  public boolean c;
  private int d = -1;
  public boolean d;
  private volatile int e;
  public boolean e;
  private boolean f;
  private volatile boolean g = true;
  private volatile boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131707874);
  }
  
  public alxr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Alwd = ((alwd)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Alzu = ((alzu)paramQQAppInterface.getManager(257));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_Aufw);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Altm, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void a(avun paramavun)
  {
    if (!a(paramavun)) {}
    amnz localamnz;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localamnz.a(alof.D, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 26;
    localRecentUser.displayName = jdField_a_of_type_JavaLangString;
    if ((paramavun != null) && ((paramavun instanceof avuk)))
    {
      localRecentUser.lastmsgdrafttime = paramavun.jdField_a_of_type_Long;
      localRecentUser.msg = paramavun.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + localRecentUser.msg);
      }
    }
    for (;;)
    {
      if (localRecentUser.msgData == null) {
        localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | ru.msg = " + localRecentUser.msg);
      }
      localamnz.a(localRecentUser);
      return;
      if ((paramavun != null) && ((paramavun instanceof avui)) && (!TextUtils.isEmpty(paramavun.jdField_a_of_type_JavaLangString)))
      {
        if (paramavun.jdField_a_of_type_Long > 0L) {
          localRecentUser.lastmsgtime = paramavun.jdField_a_of_type_Long;
        }
        localRecentUser.msg = paramavun.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | ru.lastmsgtime = " + localRecentUser.lastmsgtime);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "insertMsgForAIOShowNewsMsg" + paramString2 + ",msgType:" + paramInt);
    }
    long l2 = ayzl.a() - 60L;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((ChatMessage)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { paramInt });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = azaf.a(paramInt);
    ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!alww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, paramString1);
    }
  }
  
  private void a(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<avun> paramArrayList1)
  {
    if (paramArrayList1 == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localArrayList = ((anys)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|card.strSchool = " + ((Card)localObject).strSchool + "schoolInfos =" + localArrayList);
      }
    } while ((!TextUtils.isEmpty(((Card)localObject).strSchool)) || ((localArrayList != null) && (!localArrayList.isEmpty())) || (paramArrayList == null) || (paramArrayList.size() <= 0));
    Object localObject = new ConnectsExplorationBanner();
    ((ConnectsExplorationBanner)localObject).setBanner(true);
    localObject = new avuj((ConnectsExplorationBanner)localObject);
    if (paramArrayList.size() <= 4)
    {
      paramArrayList1.add(localObject);
      return;
    }
    paramArrayList1.add(4, localObject);
  }
  
  private boolean a(avun paramavun)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    amnz localamnz;
    do
    {
      return false;
      localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramavun == null) || (localamnz == null) || ((paramavun.a()) && (!localamnz.a(alof.D, 4000))));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(alof.D)) && (!paramString.equals(alof.ax)) && (!paramString.equals(alof.M)) && (!paramString.equals(alof.aF))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgData == null)) {
      return false;
    }
    try
    {
      boolean bool = avui.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("NewFriendManager", 2, paramMessageRecord, new Object[0]);
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0, new int[] { paramInt });
    return (paramString != null) && (paramString.size() > 0);
  }
  
  private boolean b()
  {
    return !((ahuf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c();
  }
  
  private ArrayList<avui> c()
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
  }
  
  private ArrayList<avui> d()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (!(localMessageRecord instanceof MessageForSystemMsg)) {
              continue;
            }
            ((MessageForSystemMsg)localMessageRecord).parse();
            if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.jdField_a_of_type_Alto.b(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + localMessageRecord.senderuin + ",mr.time = " + localMessageRecord.time);
            }
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              break label364;
            }
            Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!localIterator.hasNext()) {
              break label364;
            }
            avui localavui = (avui)localIterator.next();
            if ((localavui.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg == null) || (!localavui.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.senderuin.equals(localMessageRecord.senderuin))) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(new avui((MessageForSystemMsg)localMessageRecord));
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          break label355;
        }
      }
      finally {}
      QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      label355:
      ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      return localArrayList;
      label364:
      int i = 0;
    }
  }
  
  private void m()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localawgf.a(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localawgf.a(localQIMFollwerAdd);
      }
    }
    localawgf.a();
  }
  
  private void n()
  {
    avun localavun = a();
    if (localavun != null)
    {
      a(localavun);
      setChanged();
      notifyObservers(localavun);
    }
    for (;;)
    {
      c();
      return;
      e();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public aoor a()
  {
    if (this.jdField_a_of_type_Aoor == null) {
      this.jdField_a_of_type_Aoor = aoot.a();
    }
    return this.jdField_a_of_type_Aoor;
  }
  
  public avun a()
  {
    int j = 0;
    Object localObject = b();
    int i = 0;
    avun localavun1;
    if (i < ((ArrayList)localObject).size())
    {
      localavun1 = (avun)((ArrayList)localObject).get(i);
      if ((localavun1 == null) || (localavun1.a())) {}
    }
    for (;;)
    {
      if ((localavun1 != null) && (!(localavun1 instanceof avug)) && (!(localavun1 instanceof avuk)))
      {
        i = j;
        if (!(localavun1 instanceof avuh)) {
          break label80;
        }
      }
      for (;;)
      {
        return localavun1;
        i += 1;
        break;
        label80:
        avun localavun2;
        do
        {
          i += 1;
          if (i >= ((ArrayList)localObject).size()) {
            break;
          }
          localavun2 = (avun)((ArrayList)localObject).get(i);
        } while ((localavun2 == null) || (localavun2.a()) || ((localavun2 instanceof avui)));
        while (localavun2 != null)
        {
          localObject = localavun2;
          if (localavun1.jdField_a_of_type_Long >= localavun2.jdField_a_of_type_Long) {
            localObject = localavun1;
          }
          return localObject;
          localavun2 = null;
        }
      }
      localavun1 = null;
    }
  }
  
  public ArrayList<QIMFollwerAdd> a()
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QIMFollwerAdd.class);
  }
  
  public List<Object> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().iterator();
    int i = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (avun)localIterator.next();
      if ((localObject != null) && (!((avun)localObject).a())) {
        if ((localObject instanceof avui))
        {
          i += 1;
        }
        else if ((localObject instanceof avug))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        else if ((localObject instanceof avuh))
        {
          localArrayList.add(localObject);
        }
        else
        {
          localArrayList.add(localObject);
          QLog.d("NewFriendManager", 1, "getAllUnreadMsg unexpected nfm = " + localObject);
        }
      }
    }
    localArrayList.addAll(c());
    if (localArrayList.size() > 0) {
      Collections.sort(localArrayList, this.jdField_c_of_type_JavaUtilComparator);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("NewFriendManager", 2, "getAllUnreadMsg size = " + localArrayList.size() + ",unReadSysMsgCountInCache = " + i);
      if (localArrayList.size() > 0)
      {
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((localObject instanceof PhoneContact)) {
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg PhoneContact time  = " + ((PhoneContact)localObject).lastScanTime);
          } else if ((localObject instanceof avui)) {
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg FriendSystemMessage time  = " + ((avui)localObject).jdField_a_of_type_Long * 1000L);
          } else if ((localObject instanceof avuh)) {
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg ContactMatchMessage time  = " + ((avuh)localObject).jdField_a_of_type_Long * 1000L);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("contact_guide_user_close", true).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    if ((this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()))
    {
      if (localSysSuspiciousMsg != null) {
        break label114;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_Awgf.a(SysSuspiciousMsg.class, paramLong);
    }
    label114:
    for (;;)
    {
      boolean bool = false;
      if (localSysSuspiciousMsg != null) {
        bool = this.jdField_a_of_type_Awgf.b(localSysSuspiciousMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "deleteSysSuspiciousMsg " + paramLong + " " + bool);
      }
      return;
    }
  }
  
  public void a(alxx paramalxx)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramalxx)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramalxx);
      }
      return;
    }
  }
  
  public void a(avui paramavui)
  {
    long l = bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, l).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((localMessageRecord.isread) || (!(localMessageRecord instanceof MessageForSystemMsg)));
    for (localObject = new avui((MessageForSystemMsg)localMessageRecord);; localObject = null)
    {
      if (localObject != null)
      {
        ((avui)localObject).jdField_a_of_type_Long = paramavui.jdField_a_of_type_Long;
        ((avui)localObject).jdField_a_of_type_JavaLangString = paramavui.jdField_a_of_type_JavaLangString;
        a((avun)localObject);
        setChanged();
        notifyObservers(localObject);
      }
      for (;;)
      {
        c();
        return;
        e();
      }
    }
  }
  
  public void a(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().b(paramQIMFollwerAdd);
  }
  
  public void a(SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if ((paramSysSuspiciousMsg != null) && (this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()))
    {
      this.jdField_a_of_type_Awgf.b(paramSysSuspiciousMsg);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramSysSuspiciousMsg.uin), paramSysSuspiciousMsg);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateOrInsertSysSuspiciousMsg " + paramSysSuspiciousMsg.uin + " " + paramSysSuspiciousMsg.time);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a(paramString2, -2023)) {
      a(paramString1, paramString2, -2015);
    }
  }
  
  public void a(ArrayList<SysSuspiciousMsg> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer " + paramBoolean + " " + paramArrayList.size() + " " + paramArrayList.toString());
      }
      Object localObject = b();
      int i;
      if (localObject != null)
      {
        i = paramArrayList.size();
        if ((i == 0) && (paramBoolean)) {
          l();
        }
      }
      for (;;)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          a((SysSuspiciousMsg)paramArrayList.next());
        }
        if (i > 0)
        {
          Collections.sort(paramArrayList, this.jdField_b_of_type_JavaUtilComparator);
          SysSuspiciousMsg localSysSuspiciousMsg1 = (SysSuspiciousMsg)paramArrayList.get(0);
          SysSuspiciousMsg localSysSuspiciousMsg2 = (SysSuspiciousMsg)paramArrayList.get(paramArrayList.size() - 1);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SysSuspiciousMsg localSysSuspiciousMsg3 = (SysSuspiciousMsg)((Iterator)localObject).next();
            if (!paramBoolean)
            {
              if ((localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) && (localSysSuspiciousMsg3.time >= localSysSuspiciousMsg2.time)) {
                a(localSysSuspiciousMsg3.uin);
              }
            }
            else if (localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) {
              a(localSysSuspiciousMsg3.uin);
            }
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer local empty");
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 23);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList1;
    Object localObject4;
    Object localObject5;
    int j;
    StringBuilder localStringBuilder;
    ArrayList localArrayList3;
    ArrayList localArrayList2;
    int i;
    int k;
    for (;;)
    {
      try
      {
        localArrayList1 = new ArrayList();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
        localObject5 = a();
        if (paramInt != 23) {
          break label2658;
        }
        j = 1;
        localStringBuilder = new StringBuilder(256);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("loadNewFriendMsg");
        }
        Object localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        this.jdField_b_of_type_Boolean = ((PhoneContactManagerImp)localObject1).k();
        if (this.jdField_a_of_type_Boolean)
        {
          localArrayList1.add(new avul());
          localArrayList3 = new ArrayList();
          localArrayList2 = new ArrayList();
          localObject6 = new HashSet();
          int m = 0;
          i = 0;
          if (paramBoolean)
          {
            long l = bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, l);
            localObject1 = new ArrayList(((List)localObject7).size());
            ((List)localObject1).addAll((Collection)localObject7);
            k = m;
            if (localObject1 == null) {
              break;
            }
            k = m;
            if (((List)localObject1).size() <= 0) {
              break;
            }
            localObject1 = ((List)localObject1).iterator();
            label229:
            k = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject7 = (MessageRecord)((Iterator)localObject1).next();
            if (!(localObject7 instanceof MessageForSystemMsg)) {
              break label2655;
            }
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" sys").append(((MessageRecord)localObject7).isread);
            }
            ((MessageForSystemMsg)localObject7).parse();
            if (((MessageForSystemMsg)localObject7).structMsg.msg.sub_type.get() != 13) {
              break label2652;
            }
            ((HashSet)localObject6).add(String.valueOf(((MessageForSystemMsg)localObject7).structMsg.req_uin.get()));
            if (this.jdField_a_of_type_Alto.b(String.valueOf(((MessageForSystemMsg)localObject7).structMsg.req_uin.get()))) {
              continue;
            }
            k = i + 1;
            i = k;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append(" sys").append(((MessageRecord)localObject7).isread);
              i = k;
            }
            label399:
            localArrayList3.add(new avui((MessageForSystemMsg)localObject7));
            break label2655;
          }
        }
        else
        {
          if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (!((PhoneContactManagerImp)localObject1).l()))) {
            continue;
          }
          localArrayList1.add(new avum(a(), this.jdField_b_of_type_Boolean));
          continue;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0);
      }
      finally {}
    }
    Object localObject3 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
    Object localObject6 = this.jdField_a_of_type_Alzu.a(false);
    if (((ArrayList)localObject6).size() > 0) {
      localArrayList3.addAll((Collection)localObject6);
    }
    if ((((FlashChatManager)localObject3).b()) && (localObject5 != null) && (((ArrayList)localObject5).size() > 0))
    {
      localObject3 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList3.add(new avux((QIMFollwerAdd)((Iterator)localObject3).next()));
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
    {
      localObject3 = ((ArrayList)((ArrayList)localObject4).clone()).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
        localArrayList3.add(new avuw((PhoneContactAdd)localObject4));
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" pca").append(((PhoneContactAdd)localObject4).unifiedCode);
        }
      }
    }
    boolean bool1 = b();
    Object localObject7 = new ArrayList();
    boolean bool2 = this.jdField_a_of_type_Alwd.e();
    if (bool2)
    {
      localObject4 = this.jdField_a_of_type_Alwd.a();
      if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
        break label2664;
      }
      localObject3 = this.jdField_a_of_type_Alwd.a(paramInt);
      if (localObject3 == null) {
        break label2664;
      }
      ((ArrayList)localObject7).addAll((Collection)localObject3);
      break label2664;
      label770:
      if ((localObject7 == null) || (((ArrayList)localObject7).size() <= 0) || (paramInt == 0)) {
        break label2684;
      }
      localObject3 = new ArrayList(((ArrayList)localObject7).size());
      ((ArrayList)localObject3).addAll((Collection)localObject7);
      localObject3 = ((ArrayList)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject5 = (MayKnowRecommend)((Iterator)localObject3).next();
          if ((localObject5 != null) && ((localObject5 instanceof MayKnowRecommend)))
          {
            localArrayList2.add(new avuk((MayKnowRecommend)localObject5));
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("mk uin:").append(((MayKnowRecommend)localObject5).uin).append(" reason:").append(((MayKnowRecommend)localObject5).recommendReason);
              continue;
              label906:
              if (QLog.isColorLevel()) {
                QLog.d("NewFriendManager", 2, "loadNewFriendMsg mHasReadContactPermission = " + this.jdField_b_of_type_Boolean + ",needAddContactMsg =" + paramBoolean);
              }
              if (this.jdField_b_of_type_Boolean)
              {
                localObject5 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b().clone();
                localObject3 = null;
                if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
                {
                  Object localObject8 = ((ArrayList)localObject4).iterator();
                  label996:
                  if (!((Iterator)localObject8).hasNext()) {
                    break label2697;
                  }
                  localObject6 = (ahnq)((Iterator)localObject8).next();
                  if (j != 0)
                  {
                    localObject3 = localObject6;
                    break label2694;
                    label1030:
                    if ((localObject3 != null) && (QLog.isColorLevel())) {
                      QLog.d("NewFriendManager", 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + ((ahnq)localObject3).jdField_b_of_type_Int);
                    }
                    if ((localObject5 == null) || (((ArrayList)localObject5).size() <= 0)) {
                      break label2700;
                    }
                    localObject6 = ((ArrayList)localObject5).iterator();
                    while (((Iterator)localObject6).hasNext())
                    {
                      localObject8 = (awge)((Iterator)localObject6).next();
                      if ((localObject8 instanceof ContactMatch))
                      {
                        if (paramBoolean) {
                          localArrayList2.add(new avuh((ContactMatch)localObject8));
                        }
                        if (localObject3 != null) {
                          ((ahnq)localObject3).jdField_b_of_type_Int += 1;
                        }
                        if (QLog.isColorLevel()) {
                          localStringBuilder.append(" cm").append(((ContactMatch)localObject8).mobileNo).append(((ContactMatch)localObject8).isReaded);
                        }
                      }
                      else if ((localObject8 instanceof ContactBinded))
                      {
                        if (paramBoolean) {
                          localArrayList2.add(new avug((ContactBinded)localObject8));
                        }
                        if (QLog.isColorLevel()) {
                          localStringBuilder.append(" cb").append(((ContactBinded)localObject8).isReaded);
                        }
                      }
                    }
                    if ((localObject3 == null) || (!QLog.isColorLevel())) {
                      break label2700;
                    }
                    QLog.d("NewFriendManager", 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + ((ahnq)localObject3).jdField_b_of_type_Int);
                    break label2700;
                    label1303:
                    paramInt = amgf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
                    localObject5 = "";
                    if (paramInt == 1)
                    {
                      localObject5 = amgf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_JavaLangString;
                      localArrayList1.add(new avuv((String)localObject5));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("NewFriendVerification.manager", 2, "ui.loadNewFriendMsg, type=" + paramInt + ",blockedUin=" + (String)localObject5);
                    }
                    if (localArrayList3.size() > 0)
                    {
                      Collections.sort(localArrayList3, this.jdField_a_of_type_JavaUtilComparator);
                      localObject5 = new NewFriendSubTitle();
                      ((NewFriendSubTitle)localObject5).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694791);
                      if (paramInt != 3) {
                        break label2707;
                      }
                      paramBoolean = true;
                      label1452:
                      ((NewFriendSubTitle)localObject5).showEntrance = paramBoolean;
                      localArrayList1.add(new avuq((NewFriendSubTitle)localObject5));
                      if (QLog.isColorLevel()) {
                        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.jdField_b_of_type_Int + ",notifyListSize = " + localArrayList3.size() + ", mSysMsgShouldAddMoreInfo = " + this.f);
                      }
                      if (((this.jdField_b_of_type_Boolean) && (localObject3 != null) && (((ArrayList)localObject3).size() > 0)) || (bool2) || ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty())))
                      {
                        if (this.jdField_b_of_type_Int == localArrayList3.size()) {
                          break label2729;
                        }
                        if (localArrayList3.size() > 1)
                        {
                          paramInt = localArrayList3.size() - 1;
                          label1602:
                          if ((paramInt >= 0) && (((avun)localArrayList3.get(paramInt)).a())) {
                            break label2712;
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + paramInt);
                          }
                          k = bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                          if (paramInt > 0) {
                            break label2719;
                          }
                          paramInt = 0;
                          while (paramInt < 1)
                          {
                            localArrayList1.add((avun)localArrayList3.get(paramInt));
                            paramInt += 1;
                          }
                          this.jdField_a_of_type_Int = 1;
                          paramBoolean = true;
                          label1705:
                          this.f = paramBoolean;
                          if (paramBoolean)
                          {
                            localObject3 = new NewFriendMoreInfo();
                            ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694785);
                            ((NewFriendMoreInfo)localObject3).type = 1000;
                            localArrayList1.add(new avuo((NewFriendMoreInfo)localObject3));
                          }
                          label1770:
                          this.jdField_b_of_type_Int = localArrayList3.size();
                          label1779:
                          if ((!bool2) || (localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
                            break label2513;
                          }
                          if (((ArrayList)localObject4).size() <= 1) {
                            break label2734;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label2057:
    label2700:
    label2707:
    label2712:
    label2719:
    label2724:
    label2729:
    label2734:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArrayList1.add(new avuu((ArrayList)localObject4, paramBoolean));
      if (((ArrayList)localObject4).size() > 1) {
        localArrayList1.add(new avup((ArrayList)localObject4));
      }
      if (j != 0)
      {
        if (localArrayList2.size() == 0) {
          localArrayList1.add(new avus());
        }
        label1874:
        if (localArrayList2.size() > 0)
        {
          this.d = localArrayList1.size();
          Collections.sort(localArrayList2, this.jdField_a_of_type_JavaUtilComparator);
          if ((bool2) && (j != 0)) {
            a((ArrayList)localObject7, localArrayList2);
          }
          localArrayList1.addAll(localArrayList2);
        }
        this.jdField_c_of_type_Int = localArrayList2.size();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" mRecommendSubTitleIndex : ").append(this.d).append(" mRecommendShowCount : ").append(this.jdField_c_of_type_Int).append(" shouldShowNewFriendMayknow:").append(bool2);
          QLog.d("NewFriendManager", 2, localStringBuilder.toString());
        }
        if (!QLog.isColorLevel()) {
          break label2612;
        }
        localObject3 = localArrayList1.iterator();
        paramInt = 0;
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (avun)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!((avun)localObject4).a()) && ((localObject4 instanceof avui)))
            {
              paramInt += 1;
              continue;
              while (i <= paramInt)
              {
                localArrayList1.add((avun)localArrayList3.get(i));
                i += 1;
              }
              this.jdField_a_of_type_Int = (paramInt + 1);
              if ((k > 99) || (paramInt + 1 != localArrayList3.size())) {
                break label2621;
              }
              if (bafi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                break label2724;
              }
              paramBoolean = true;
              break;
              localArrayList1.addAll(localArrayList3);
              this.f = false;
              this.jdField_a_of_type_Int = localArrayList3.size();
              break label1770;
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Int)
        {
          localArrayList1.add((avun)localArrayList3.get(paramInt));
          paramInt += 1;
        }
        else
        {
          if (!this.f) {
            break label1770;
          }
          localObject3 = new NewFriendMoreInfo();
          ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694785);
          ((NewFriendMoreInfo)localObject3).type = 1000;
          localArrayList1.add(new avuo((NewFriendMoreInfo)localObject3));
          break label1770;
          if (localArrayList3.size() > 100)
          {
            paramInt = 0;
            while (paramInt < 100)
            {
              localArrayList1.add(localArrayList3.get(paramInt));
              paramInt += 1;
            }
            localObject3 = new NewFriendMoreInfo();
            ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694785);
            ((NewFriendMoreInfo)localObject3).type = 1000;
            localArrayList1.add(new avuo((NewFriendMoreInfo)localObject3));
            break label1779;
          }
          localArrayList1.addAll(localArrayList3);
          if (((k % 20 != 0) || (bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((k <= 20) || (bafi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
            break label1779;
          }
          localObject3 = new NewFriendMoreInfo();
          ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694785);
          ((NewFriendMoreInfo)localObject3).type = 1000;
          localArrayList1.add(new avuo((NewFriendMoreInfo)localObject3));
          break label1779;
          localArrayList1.add(new avur());
          break label1779;
          if (bool1)
          {
            if (localArrayList2.size() != 0) {
              break label1874;
            }
            localArrayList1.add(new avus());
            break label1874;
          }
          localArrayList1.add(new avut());
          break label1874;
          label2513:
          if (localArrayList2.size() <= 0) {
            break label1874;
          }
          localObject3 = new NewFriendSubTitle();
          ((NewFriendSubTitle)localObject3).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131689763);
          localArrayList1.add(new avuq((NewFriendSubTitle)localObject3));
          break label1874;
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg size = " + localArrayList1.size() + ",unReadSysMsgCountInCache = " + paramInt);
          label2612:
          this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
          return;
          label2621:
          paramBoolean = true;
          break label1705;
          break label2694;
          localObject3 = null;
          break label1030;
          localObject3 = null;
          break label1303;
          label2652:
          label2655:
          label2658:
          label2664:
          label2684:
          do
          {
            paramBoolean = false;
            break label906;
            localObject4 = null;
            break label2664;
            break label399;
            break label229;
            j = 0;
            break;
            if ((j != 0) || (bool1))
            {
              paramInt = 1;
              break label770;
            }
            paramInt = 0;
            break label770;
          } while (j == 0);
          paramBoolean = true;
          break label906;
          break label996;
          break label1030;
          localObject3 = localObject5;
          break label1303;
          paramBoolean = false;
          break label1452;
          paramInt -= 1;
          break label1602;
          i = 0;
          break label2057;
          paramBoolean = false;
          break label1705;
          paramInt = 0;
        }
      }
    }
  }
  
  public boolean a()
  {
    avun localavun = a();
    return (localavun != null) && (localavun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      bool = this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
    return bool;
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public ArrayList<avun> b()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public List<SysSuspiciousMsg> b()
  {
    Object localObject1 = null;
    Object localObject2;
    if (!this.g)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
      if (localObject2 != null) {
        localObject1 = new ArrayList((Collection)localObject2);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        Collections.sort((List)localObject1, this.jdField_b_of_type_JavaUtilComparator);
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getAllSysSuspiciousMsg ").append(this.g).append(" ");
        if (localObject1 == null) {
          break label197;
        }
      }
      label197:
      for (localObject2 = Integer.valueOf(((List)localObject1).size());; localObject2 = "null")
      {
        QLog.i("NewFriendManager", 2, localObject2);
        return localObject1;
        if ((this.jdField_a_of_type_Awgf == null) || (!this.jdField_a_of_type_Awgf.a())) {
          break label204;
        }
        localObject1 = this.jdField_a_of_type_Awgf.a(SysSuspiciousMsg.class);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SysSuspiciousMsg)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((SysSuspiciousMsg)localObject3).uin), localObject3);
          }
        }
        this.g = false;
        break;
      }
      label204:
      localObject1 = null;
    }
  }
  
  public void b()
  {
    a(true);
    n();
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(alxx paramalxx)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramalxx);
      return;
    }
  }
  
  public void b(QIMFollwerAdd paramQIMFollwerAdd)
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localawgf.b(paramQIMFollwerAdd);
    localawgf.a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (!a(paramString2, -2015)) {
      a(paramString1, paramString2, -2023);
    }
  }
  
  public boolean b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      return bool;
    }
  }
  
  public int c()
  {
    return bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c()
  {
    int i = d();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendManager.5(this, i));
  }
  
  public int d()
  {
    int k = bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = b().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      avun localavun = (avun)localIterator.next();
      if ((localavun == null) || (localavun.a())) {
        break label158;
      }
      if ((localavun instanceof avui)) {
        j += 1;
      } else if ((localavun instanceof avug)) {
        i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a() + i;
      } else {
        i += 1;
      }
    }
    label158:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "getAllUnreadMessageCount|total unread = " + i + ",unReadSysMsgCount = " + k + ",unReadSysMsgCountInCache = " + j);
      }
      return i + k;
    }
  }
  
  public void d()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      c();
      return;
    }
    ThreadManager.postImmediately(new NewFriendManager.6(this), null, false);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      super.deleteObserver(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    amnz localamnz;
    RecentUser localRecentUser;
    do
    {
      return;
      localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localamnz.b(alof.D, 4000);
    } while (localRecentUser == null);
    localamnz.b(localRecentUser);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "HandleMessage what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 4: 
    case 6: 
    case 7: 
    default: 
      return true;
    case 1: 
      a(true);
      return true;
    case 2: 
      b();
      return true;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f();
      m();
      this.jdField_a_of_type_Alzu.b();
      bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      b();
      return true;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, true, true);
      bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      this.jdField_a_of_type_Alzu.b();
      b();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f();
    b();
    return true;
  }
  
  public void i()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "initNewFriendList hasInitNewFriendList: " + this.h);
    }
    if (this.h) {}
    do
    {
      return;
      this.h = true;
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).getString("new_friend_list", "");
    } while (TextUtils.isEmpty((CharSequence)???));
    String[] arrayOfString = ((String)???).split("#");
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        int j = arrayOfString.length;
        if (i < j)
        {
          if (!TextUtils.isEmpty(arrayOfString[i])) {
            this.jdField_a_of_type_JavaUtilHashSet.add(arrayOfString[i]);
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  public void j()
  {
    Object localObject = (aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int i = ((aufv)localObject).d();
    if ((i == 1) || (i == 5))
    {
      i = localSharedPreferences.getInt("system_msg_list_showcount", 0) + 1;
      if (i <= 3)
      {
        this.jdField_a_of_type_Boolean = true;
        localSharedPreferences.edit().putInt("system_msg_list_showcount", i).apply();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label161;
      }
      this.jdField_c_of_type_Boolean = false;
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      this.jdField_a_of_type_Boolean = false;
      localSharedPreferences.edit().putInt("system_msg_list_showcount", 0).apply();
    }
    label161:
    boolean bool = localSharedPreferences.getBoolean("contact_guide_user_close", false);
    i = localSharedPreferences.getInt("new_friend_show_count_after_user_close", 0);
    localObject = a();
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(((aoor)localObject).jdField_a_of_type_Boolean), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(((aoor)localObject).jdField_a_of_type_Int) }));
    }
    if ((((aoor)localObject).jdField_a_of_type_Boolean) && ((!bool) || (i >= ((aoor)localObject).jdField_a_of_type_Int)))
    {
      this.jdField_c_of_type_Boolean = true;
      localSharedPreferences.edit().putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
      return;
    }
    if (bool) {
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", i + 1).apply();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousCache ");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.g = true;
  }
  
  public void l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if ((this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()))
    {
      boolean bool = this.jdField_a_of_type_Awgf.a(SysSuspiciousMsg.class);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousMsg " + bool);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_a_of_type_Aufw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxr
 * JD-Core Version:    0.7.0.1
 */