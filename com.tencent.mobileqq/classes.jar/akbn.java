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
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager.5;
import com.tencent.mobileqq.app.NewFriendManager.6;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class akbn
  extends Observable
  implements Handler.Callback, Manager
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private ajxj jdField_a_of_type_Ajxj = new akbq(this);
  private ajxl jdField_a_of_type_Ajxl;
  private akaa jdField_a_of_type_Akaa;
  private akdq jdField_a_of_type_Akdq;
  public amtg a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private asko jdField_a_of_type_Asko = new akbr(this);
  private aukp jdField_a_of_type_Aukp;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<atza> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<atza> jdField_a_of_type_JavaUtilComparator = new akbo(this);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<akbt> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Long, SysSuspiciousMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
  public boolean a;
  private int jdField_b_of_type_Int;
  ArrayList<atyv> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<SysSuspiciousMsg> jdField_b_of_type_JavaUtilComparator = new akbp(this);
  public boolean b;
  private int jdField_c_of_type_Int;
  private Comparator<Object> jdField_c_of_type_JavaUtilComparator = new akbs(this);
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
    jdField_a_of_type_JavaLangString = ajya.a(2131707490);
  }
  
  public akbn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Aukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Akaa = ((akaa)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Akdq = ((akdq)paramQQAppInterface.getManager(257));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_Asko);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void a(atza paramatza)
  {
    if (!a(paramatza)) {}
    aktf localaktf;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localaktf.a(ajsd.D, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 26;
    localRecentUser.displayName = jdField_a_of_type_JavaLangString;
    if ((paramatza != null) && ((paramatza instanceof atyx)))
    {
      localRecentUser.lastmsgdrafttime = paramatza.jdField_a_of_type_Long;
      localRecentUser.msg = paramatza.jdField_a_of_type_JavaLangString;
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
      localaktf.a(localRecentUser);
      return;
      if ((paramatza != null) && ((paramatza instanceof atyv)) && (!TextUtils.isEmpty(paramatza.jdField_a_of_type_JavaLangString)))
      {
        if (paramatza.jdField_a_of_type_Long > 0L) {
          localRecentUser.lastmsgtime = paramatza.jdField_a_of_type_Long;
        }
        localRecentUser.msg = paramatza.jdField_a_of_type_JavaLangString;
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
    long l2 = awzy.a() - 60L;
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
    localObject = axas.a(paramInt);
    ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!akas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, paramString1);
    }
  }
  
  private void a(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<atza> paramArrayList1)
  {
    if (paramArrayList1 == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localObject = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localArrayList = ((amdj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|card.strSchool = " + ((Card)localObject).strSchool + "schoolInfos =" + localArrayList);
      }
    } while ((!TextUtils.isEmpty(((Card)localObject).strSchool)) || ((localArrayList != null) && (!localArrayList.isEmpty())) || (paramArrayList == null) || (paramArrayList.size() <= 0));
    Object localObject = new ConnectsExplorationBanner();
    ((ConnectsExplorationBanner)localObject).setBanner(true);
    localObject = new atyw((ConnectsExplorationBanner)localObject);
    if (paramArrayList.size() <= 4)
    {
      paramArrayList1.add(localObject);
      return;
    }
    paramArrayList1.add(4, localObject);
  }
  
  private boolean a(atza paramatza)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    aktf localaktf;
    do
    {
      return false;
      localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramatza == null) || (localaktf == null) || ((paramatza.a()) && (!localaktf.a(ajsd.D, 4000))));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(ajsd.D)) && (!paramString.equals(ajsd.ax)) && (!paramString.equals(ajsd.M)) && (!paramString.equals(ajsd.aE))) {
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
      boolean bool = atyv.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
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
    return !((afry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c();
  }
  
  private ArrayList<atyv> c()
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
  }
  
  private ArrayList<atyv> d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajsd.M, 0);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    label341:
    label344:
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (!(localMessageRecord instanceof MessageForSystemMsg)) {
          continue;
        }
        ((MessageForSystemMsg)localMessageRecord).parse();
        if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.jdField_a_of_type_Ajxl.b(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + localMessageRecord.senderuin + ",mr.time = " + localMessageRecord.time);
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
          break label341;
        }
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((atyv)localIterator.next()).jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.senderuin.equals(localMessageRecord.senderuin));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label344;
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(new atyv((MessageForSystemMsg)localMessageRecord));
        break;
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        return this.jdField_b_of_type_JavaUtilArrayList;
      }
    }
  }
  
  private void m()
  {
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localaukp.a(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localaukp.a(localQIMFollwerAdd);
      }
    }
    localaukp.a();
  }
  
  private void n()
  {
    atza localatza = a();
    if (localatza != null)
    {
      a(localatza);
      setChanged();
      notifyObservers(localatza);
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
  
  public amtg a()
  {
    if (this.jdField_a_of_type_Amtg == null) {
      this.jdField_a_of_type_Amtg = amti.a();
    }
    return this.jdField_a_of_type_Amtg;
  }
  
  public atza a()
  {
    int j = 0;
    Object localObject = b();
    int i = 0;
    atza localatza1;
    if (i < ((ArrayList)localObject).size())
    {
      localatza1 = (atza)((ArrayList)localObject).get(i);
      if ((localatza1 == null) || (localatza1.a())) {}
    }
    for (;;)
    {
      if ((localatza1 != null) && (!(localatza1 instanceof atyt)) && (!(localatza1 instanceof atyx)))
      {
        i = j;
        if (!(localatza1 instanceof atyu)) {
          break label80;
        }
      }
      for (;;)
      {
        return localatza1;
        i += 1;
        break;
        label80:
        atza localatza2;
        do
        {
          i += 1;
          if (i >= ((ArrayList)localObject).size()) {
            break;
          }
          localatza2 = (atza)((ArrayList)localObject).get(i);
        } while ((localatza2 == null) || (localatza2.a()) || ((localatza2 instanceof atyv)));
        while (localatza2 != null)
        {
          localObject = localatza2;
          if (localatza1.jdField_a_of_type_Long >= localatza2.jdField_a_of_type_Long) {
            localObject = localatza1;
          }
          return localObject;
          localatza2 = null;
        }
      }
      localatza1 = null;
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
      localObject = (atza)localIterator.next();
      if ((localObject != null) && (!((atza)localObject).a())) {
        if ((localObject instanceof atyv))
        {
          i += 1;
        }
        else if ((localObject instanceof atyt))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        else if ((localObject instanceof atyu))
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
          } else if ((localObject instanceof atyv)) {
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg FriendSystemMessage time  = " + ((atyv)localObject).jdField_a_of_type_Long * 1000L);
          } else if ((localObject instanceof atyu)) {
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg ContactMatchMessage time  = " + ((atyu)localObject).jdField_a_of_type_Long * 1000L);
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
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a()))
    {
      if (localSysSuspiciousMsg != null) {
        break label114;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_Aukp.a(SysSuspiciousMsg.class, paramLong);
    }
    label114:
    for (;;)
    {
      boolean bool = false;
      if (localSysSuspiciousMsg != null) {
        bool = this.jdField_a_of_type_Aukp.b(localSysSuspiciousMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "deleteSysSuspiciousMsg " + paramLong + " " + bool);
      }
      return;
    }
  }
  
  public void a(akbt paramakbt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramakbt)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramakbt);
      }
      return;
    }
  }
  
  public void a(atyv paramatyv)
  {
    long l = aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsd.M, 0, l).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((localMessageRecord.isread) || (!(localMessageRecord instanceof MessageForSystemMsg)));
    for (localObject = new atyv((MessageForSystemMsg)localMessageRecord);; localObject = null)
    {
      if (localObject != null)
      {
        ((atyv)localObject).jdField_a_of_type_Long = paramatyv.jdField_a_of_type_Long;
        ((atyv)localObject).jdField_a_of_type_JavaLangString = paramatyv.jdField_a_of_type_JavaLangString;
        a((atza)localObject);
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
    if ((paramSysSuspiciousMsg != null) && (this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a()))
    {
      this.jdField_a_of_type_Aukp.b(paramSysSuspiciousMsg);
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
          break label2661;
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
          localArrayList1.add(new atyy());
          localArrayList3 = new ArrayList();
          localArrayList2 = new ArrayList();
          localObject6 = new HashSet();
          int m = 0;
          i = 0;
          if (paramBoolean)
          {
            long l = aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsd.M, 0, l);
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
              break label2658;
            }
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" sys").append(((MessageRecord)localObject7).isread);
            }
            ((MessageForSystemMsg)localObject7).parse();
            if (((MessageForSystemMsg)localObject7).structMsg.msg.sub_type.get() != 13) {
              break label2655;
            }
            ((HashSet)localObject6).add(String.valueOf(((MessageForSystemMsg)localObject7).structMsg.req_uin.get()));
            if (this.jdField_a_of_type_Ajxl.b(String.valueOf(((MessageForSystemMsg)localObject7).structMsg.req_uin.get()))) {
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
            localArrayList3.add(new atyv((MessageForSystemMsg)localObject7));
            break label2658;
          }
        }
        else
        {
          if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (!((PhoneContactManagerImp)localObject1).l()))) {
            continue;
          }
          localArrayList1.add(new atyz(a(), this.jdField_b_of_type_Boolean));
          continue;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajsd.M, 0);
      }
      finally {}
    }
    Object localObject3 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
    Object localObject6 = this.jdField_a_of_type_Akdq.a(false);
    if (((ArrayList)localObject6).size() > 0) {
      localArrayList3.addAll((Collection)localObject6);
    }
    if ((((FlashChatManager)localObject3).b()) && (localObject5 != null) && (((ArrayList)localObject5).size() > 0))
    {
      localObject3 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList3.add(new atzk((QIMFollwerAdd)((Iterator)localObject3).next()));
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (localObject4 != null) && (!((ArrayList)localObject4).isEmpty()))
    {
      localObject3 = ((ArrayList)((ArrayList)localObject4).clone()).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
        localArrayList3.add(new atzj((PhoneContactAdd)localObject4));
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" pca").append(((PhoneContactAdd)localObject4).unifiedCode);
        }
      }
    }
    boolean bool1 = b();
    Object localObject7 = new ArrayList();
    boolean bool2 = this.jdField_a_of_type_Akaa.b("sp_mayknow_entry_list_new");
    if (bool2)
    {
      localObject4 = this.jdField_a_of_type_Akaa.a();
      if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
        break label2667;
      }
      localObject3 = this.jdField_a_of_type_Akaa.a(paramInt);
      if (localObject3 == null) {
        break label2667;
      }
      ((ArrayList)localObject7).addAll((Collection)localObject3);
      break label2667;
      label773:
      if ((localObject7 == null) || (((ArrayList)localObject7).size() <= 0) || (paramInt == 0)) {
        break label2687;
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
            localArrayList2.add(new atyx((MayKnowRecommend)localObject5));
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("mk uin:").append(((MayKnowRecommend)localObject5).uin).append(" reason:").append(((MayKnowRecommend)localObject5).recommendReason);
              continue;
              label909:
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
                  label999:
                  if (!((Iterator)localObject8).hasNext()) {
                    break label2700;
                  }
                  localObject6 = (aflw)((Iterator)localObject8).next();
                  if (j != 0)
                  {
                    localObject3 = localObject6;
                    break label2697;
                    label1033:
                    if ((localObject3 != null) && (QLog.isColorLevel())) {
                      QLog.d("NewFriendManager", 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + ((aflw)localObject3).jdField_b_of_type_Int);
                    }
                    if ((localObject5 == null) || (((ArrayList)localObject5).size() <= 0)) {
                      break label2703;
                    }
                    localObject6 = ((ArrayList)localObject5).iterator();
                    while (((Iterator)localObject6).hasNext())
                    {
                      localObject8 = (auko)((Iterator)localObject6).next();
                      if ((localObject8 instanceof ContactMatch))
                      {
                        if (paramBoolean) {
                          localArrayList2.add(new atyu((ContactMatch)localObject8));
                        }
                        if (localObject3 != null) {
                          ((aflw)localObject3).jdField_b_of_type_Int += 1;
                        }
                        if (QLog.isColorLevel()) {
                          localStringBuilder.append(" cm").append(((ContactMatch)localObject8).mobileNo).append(((ContactMatch)localObject8).isReaded);
                        }
                      }
                      else if ((localObject8 instanceof ContactBinded))
                      {
                        if (paramBoolean) {
                          localArrayList2.add(new atyt((ContactBinded)localObject8));
                        }
                        if (QLog.isColorLevel()) {
                          localStringBuilder.append(" cb").append(((ContactBinded)localObject8).isReaded);
                        }
                      }
                    }
                    if ((localObject3 == null) || (!QLog.isColorLevel())) {
                      break label2703;
                    }
                    QLog.d("NewFriendManager", 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + ((aflw)localObject3).jdField_b_of_type_Int);
                    break label2703;
                    label1306:
                    paramInt = akka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
                    localObject5 = "";
                    if (paramInt == 1)
                    {
                      localObject5 = akka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_JavaLangString;
                      localArrayList1.add(new atzi((String)localObject5));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("NewFriendVerification.manager", 2, "ui.loadNewFriendMsg, type=" + paramInt + ",blockedUin=" + (String)localObject5);
                    }
                    if (localArrayList3.size() > 0)
                    {
                      Collections.sort(localArrayList3, this.jdField_a_of_type_JavaUtilComparator);
                      localObject5 = new NewFriendSubTitle();
                      ((NewFriendSubTitle)localObject5).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694633);
                      if (paramInt != 3) {
                        break label2710;
                      }
                      paramBoolean = true;
                      label1455:
                      ((NewFriendSubTitle)localObject5).showEntrance = paramBoolean;
                      localArrayList1.add(new atzd((NewFriendSubTitle)localObject5));
                      if (QLog.isColorLevel()) {
                        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.jdField_b_of_type_Int + ",notifyListSize = " + localArrayList3.size() + ", mSysMsgShouldAddMoreInfo = " + this.f);
                      }
                      if (((this.jdField_b_of_type_Boolean) && (localObject3 != null) && (((ArrayList)localObject3).size() > 0)) || (bool2) || ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty())))
                      {
                        if (this.jdField_b_of_type_Int == localArrayList3.size()) {
                          break label2732;
                        }
                        if (localArrayList3.size() > 1)
                        {
                          paramInt = localArrayList3.size() - 1;
                          label1605:
                          if ((paramInt >= 0) && (((atza)localArrayList3.get(paramInt)).a())) {
                            break label2715;
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + paramInt);
                          }
                          k = aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                          if (paramInt > 0) {
                            break label2722;
                          }
                          paramInt = 0;
                          while (paramInt < 1)
                          {
                            localArrayList1.add((atza)localArrayList3.get(paramInt));
                            paramInt += 1;
                          }
                          this.jdField_a_of_type_Int = 1;
                          paramBoolean = true;
                          label1708:
                          this.f = paramBoolean;
                          if (paramBoolean)
                          {
                            localObject3 = new NewFriendMoreInfo();
                            ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694627);
                            ((NewFriendMoreInfo)localObject3).type = 1000;
                            localArrayList1.add(new atzb((NewFriendMoreInfo)localObject3));
                          }
                          label1773:
                          this.jdField_b_of_type_Int = localArrayList3.size();
                          label1782:
                          if ((!bool2) || (localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
                            break label2516;
                          }
                          if (((ArrayList)localObject4).size() <= 1) {
                            break label2737;
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
    label2060:
    label2703:
    label2710:
    label2715:
    label2722:
    label2727:
    label2732:
    label2737:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArrayList1.add(new atzh((ArrayList)localObject4, paramBoolean));
      if (((ArrayList)localObject4).size() > 1) {
        localArrayList1.add(new atzc((ArrayList)localObject4));
      }
      if (j != 0)
      {
        if (localArrayList2.size() == 0) {
          localArrayList1.add(new atzf());
        }
        label1877:
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
          break label2615;
        }
        localObject3 = localArrayList1.iterator();
        paramInt = 0;
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (atza)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!((atza)localObject4).a()) && ((localObject4 instanceof atyv)))
            {
              paramInt += 1;
              continue;
              while (i <= paramInt)
              {
                localArrayList1.add((atza)localArrayList3.get(i));
                i += 1;
              }
              this.jdField_a_of_type_Int = (paramInt + 1);
              if ((k > 99) || (paramInt + 1 != localArrayList3.size())) {
                break label2624;
              }
              if (aydc.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                break label2727;
              }
              paramBoolean = true;
              break;
              localArrayList1.addAll(localArrayList3);
              this.f = false;
              this.jdField_a_of_type_Int = localArrayList3.size();
              break label1773;
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Int)
        {
          localArrayList1.add((atza)localArrayList3.get(paramInt));
          paramInt += 1;
        }
        else
        {
          if (!this.f) {
            break label1773;
          }
          localObject3 = new NewFriendMoreInfo();
          ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694627);
          ((NewFriendMoreInfo)localObject3).type = 1000;
          localArrayList1.add(new atzb((NewFriendMoreInfo)localObject3));
          break label1773;
          if (localArrayList3.size() > 100)
          {
            paramInt = 0;
            while (paramInt < 100)
            {
              localArrayList1.add(localArrayList3.get(paramInt));
              paramInt += 1;
            }
            localObject3 = new NewFriendMoreInfo();
            ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694627);
            ((NewFriendMoreInfo)localObject3).type = 1000;
            localArrayList1.add(new atzb((NewFriendMoreInfo)localObject3));
            break label1782;
          }
          localArrayList1.addAll(localArrayList3);
          if (((k % 20 != 0) || (aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((k <= 20) || (aydc.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
            break label1782;
          }
          localObject3 = new NewFriendMoreInfo();
          ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694627);
          ((NewFriendMoreInfo)localObject3).type = 1000;
          localArrayList1.add(new atzb((NewFriendMoreInfo)localObject3));
          break label1782;
          localArrayList1.add(new atze());
          break label1782;
          if (bool1)
          {
            if (localArrayList2.size() != 0) {
              break label1877;
            }
            localArrayList1.add(new atzf());
            break label1877;
          }
          localArrayList1.add(new atzg());
          break label1877;
          label2516:
          if (localArrayList2.size() <= 0) {
            break label1877;
          }
          localObject3 = new NewFriendSubTitle();
          ((NewFriendSubTitle)localObject3).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131689762);
          localArrayList1.add(new atzd((NewFriendSubTitle)localObject3));
          break label1877;
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg size = " + localArrayList1.size() + ",unReadSysMsgCountInCache = " + paramInt);
          label2615:
          this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
          return;
          label2624:
          paramBoolean = true;
          break label1708;
          break label2697;
          localObject3 = null;
          break label1033;
          localObject3 = null;
          break label1306;
          label2655:
          label2658:
          label2661:
          label2667:
          label2687:
          do
          {
            paramBoolean = false;
            break label909;
            localObject4 = null;
            break label2667;
            break label399;
            break label229;
            j = 0;
            break;
            if ((j != 0) || (bool1))
            {
              paramInt = 1;
              break label773;
            }
            paramInt = 0;
            break label773;
          } while (j == 0);
          paramBoolean = true;
          break label909;
          break label999;
          break label1033;
          localObject3 = localObject5;
          break label1306;
          paramBoolean = false;
          break label1455;
          paramInt -= 1;
          break label1605;
          i = 0;
          break label2060;
          paramBoolean = false;
          break label1708;
          paramInt = 0;
        }
      }
    }
  }
  
  public boolean a()
  {
    atza localatza = a();
    return (localatza != null) && (localatza.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
  
  public ArrayList<atza> b()
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
        if ((this.jdField_a_of_type_Aukp == null) || (!this.jdField_a_of_type_Aukp.a())) {
          break label204;
        }
        localObject1 = this.jdField_a_of_type_Aukp.a(SysSuspiciousMsg.class);
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
  
  public void b(akbt paramakbt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramakbt);
      return;
    }
  }
  
  public void b(QIMFollwerAdd paramQIMFollwerAdd)
  {
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukp.b(paramQIMFollwerAdd);
    localaukp.a();
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
    return aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c()
  {
    int i = d();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendManager.5(this, i));
  }
  
  public int d()
  {
    int k = aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = b().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      atza localatza = (atza)localIterator.next();
      if ((localatza == null) || (localatza.a())) {
        break label158;
      }
      if ((localatza instanceof atyv)) {
        j += 1;
      } else if ((localatza instanceof atyt)) {
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
    aktf localaktf;
    RecentUser localRecentUser;
    do
    {
      return;
      localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localaktf.b(ajsd.D, 4000);
    } while (localRecentUser == null);
    localaktf.b(localRecentUser);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsd.M, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f();
      m();
      this.jdField_a_of_type_Akdq.b();
      aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      b();
      return true;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ajsd.M, 0, true, true);
      aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      this.jdField_a_of_type_Akdq.b();
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
    Object localObject = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int i = ((askn)localObject).d();
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
      QLog.i("NewFriendManager", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(((amtg)localObject).jdField_a_of_type_Boolean), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(((amtg)localObject).jdField_a_of_type_Int) }));
    }
    if ((((amtg)localObject).jdField_a_of_type_Boolean) && ((!bool) || (i >= ((amtg)localObject).jdField_a_of_type_Int)))
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
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a()))
    {
      boolean bool = this.jdField_a_of_type_Aukp.a(SysSuspiciousMsg.class);
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
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_a_of_type_Asko);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbn
 * JD-Core Version:    0.7.0.1
 */