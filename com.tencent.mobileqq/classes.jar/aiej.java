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
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.6;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Laicz;>;
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

public class aiej
  extends Observable
  implements Handler.Callback, Manager
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private amsu jdField_a_of_type_Amsu = new aiem(this);
  private amsw jdField_a_of_type_Amsw;
  private amvo jdField_a_of_type_Amvo;
  private amyk jdField_a_of_type_Amyk;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public apza a;
  private avsz jdField_a_of_type_Avsz = new aien(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList<aigo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<aigo> jdField_a_of_type_JavaUtilComparator = new aiek(this);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<aiep> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Long, SysSuspiciousMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
  public boolean a;
  private int jdField_b_of_type_Int;
  ArrayList<aigj> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<SysSuspiciousMsg> jdField_b_of_type_JavaUtilComparator = new aiel(this);
  public boolean b;
  private int jdField_c_of_type_Int;
  private Comparator<Object> jdField_c_of_type_JavaUtilComparator = new aieo(this);
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
    jdField_a_of_type_JavaLangString = amtj.a(2131706602);
  }
  
  public aiej(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Amvo = ((amvo)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Amyk = ((amyk)paramQQAppInterface.getManager(257));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_Avsz);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amsu, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private int a(boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<aigo> paramArrayList, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      long l = bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l);
      localObject1 = new ArrayList(((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
    }
    int i;
    for (;;)
    {
      i = paramInt;
      if (localObject1 == null) {
        break;
      }
      i = paramInt;
      if (((List)localObject1).size() <= 0) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForSystemMsg))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
          }
          ((MessageForSystemMsg)localObject2).parse();
          i = paramInt;
          if (((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get() == 13)
          {
            if (this.jdField_a_of_type_Amsw.b(String.valueOf(((MessageForSystemMsg)localObject2).structMsg.req_uin.get()))) {
              continue;
            }
            paramInt += 1;
            i = paramInt;
            if (QLog.isColorLevel())
            {
              paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
              i = paramInt;
            }
          }
          paramArrayList.add(new aigj((MessageForSystemMsg)localObject2));
          paramInt = i;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    }
    return i;
  }
  
  private ArrayList<aicz> a(int paramInt, boolean paramBoolean1, ArrayList<aigo> paramArrayList, StringBuilder paramStringBuilder, boolean paramBoolean2, ArrayList<MayKnowRecommend> paramArrayList1, ArrayList<aicz> paramArrayList2, boolean paramBoolean3)
  {
    Object localObject;
    if (paramBoolean3)
    {
      localObject = this.jdField_a_of_type_Amvo.a();
      paramArrayList2 = (ArrayList<aicz>)localObject;
      if (localObject != null)
      {
        paramArrayList2 = (ArrayList<aicz>)localObject;
        if (!((ArrayList)localObject).isEmpty())
        {
          ArrayList localArrayList = this.jdField_a_of_type_Amvo.a(paramInt);
          paramArrayList2 = (ArrayList<aicz>)localObject;
          if (localArrayList != null)
          {
            paramArrayList1.addAll(localArrayList);
            paramArrayList2 = (ArrayList<aicz>)localObject;
          }
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean2)) {}
    for (paramInt = 1; (paramArrayList1 != null) && (paramArrayList1.size() > 0) && (paramInt != 0); paramInt = 0)
    {
      localObject = new ArrayList(paramArrayList1.size());
      ((ArrayList)localObject).addAll(paramArrayList1);
      paramArrayList1 = ((ArrayList)localObject).iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (MayKnowRecommend)paramArrayList1.next();
        if ((localObject != null) && ((localObject instanceof MayKnowRecommend)))
        {
          paramArrayList.add(new aigl((MayKnowRecommend)localObject));
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("mk uin:").append(((MayKnowRecommend)localObject).uin).append(" reason:").append(((MayKnowRecommend)localObject).recommendReason);
          }
        }
      }
    }
    return paramArrayList2;
  }
  
  private ArrayList<Entity> a(boolean paramBoolean1, ArrayList<aigo> paramArrayList, StringBuilder paramStringBuilder, ArrayList<aicz> paramArrayList1, boolean paramBoolean2, ArrayList<Entity> paramArrayList2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b().clone();
      paramArrayList2 = null;
      Object localObject;
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        localObject = paramArrayList1.iterator();
        for (paramArrayList1 = paramArrayList2; ((Iterator)localObject).hasNext(); paramArrayList1 = paramArrayList2)
        {
          paramArrayList2 = (aicz)((Iterator)localObject).next();
          if (!paramBoolean1) {
            break label355;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + paramArrayList1.jdField_b_of_type_Int);
        }
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramArrayList2 = localArrayList.iterator();
          while (paramArrayList2.hasNext())
          {
            localObject = (Entity)paramArrayList2.next();
            if ((localObject instanceof ContactMatch))
            {
              if (paramBoolean2) {
                paramArrayList.add(new aigi((ContactMatch)localObject));
              }
              if (paramArrayList1 != null) {
                paramArrayList1.jdField_b_of_type_Int += 1;
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cm").append(((ContactMatch)localObject).mobileNo).append(((ContactMatch)localObject).isReaded);
              }
            }
            else if ((localObject instanceof ContactBinded))
            {
              if (paramBoolean2) {
                paramArrayList.add(new aigh((ContactBinded)localObject));
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cb").append(((ContactBinded)localObject).isReaded);
              }
            }
          }
          if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + paramArrayList1.jdField_b_of_type_Int);
          }
        }
        return localArrayList;
        label355:
        break;
        paramArrayList1 = null;
      }
    }
    return paramArrayList2;
  }
  
  private void a(aigo paramaigo)
  {
    if (!a(paramaigo)) {}
    anuz localanuz;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = (RecentUser)localanuz.findRecentUserByUin(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 26;
    localRecentUser.displayName = jdField_a_of_type_JavaLangString;
    if ((paramaigo != null) && ((paramaigo instanceof aigl)))
    {
      localRecentUser.lastmsgdrafttime = paramaigo.jdField_a_of_type_Long;
      localRecentUser.msg = paramaigo.jdField_a_of_type_JavaLangString;
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
      localanuz.saveRecentUser(localRecentUser);
      return;
      if ((paramaigo != null) && ((paramaigo instanceof aigj)) && (!TextUtils.isEmpty(paramaigo.jdField_a_of_type_JavaLangString)))
      {
        if (paramaigo.jdField_a_of_type_Long > 0L) {
          localRecentUser.lastmsgtime = paramaigo.jdField_a_of_type_Long;
        }
        localRecentUser.msg = paramaigo.jdField_a_of_type_JavaLangString;
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
    long l2 = bbko.a() - 60L;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((ChatMessage)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString2, 0, new int[] { paramInt });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = bbli.a(paramInt);
    ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!amwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addAIOHeadMessage(paramString2, 0, paramString1);
    }
  }
  
  private void a(ArrayList<aigo> paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        aigo localaigo = (aigo)localIterator.next();
        if ((localaigo == null) || (localaigo.a()) || (!(localaigo instanceof aigj))) {
          break label102;
        }
        i += 1;
      }
    }
    label102:
    for (;;)
    {
      break;
      QLog.d("NewFriendManager", 2, "loadNewFriendMsg size = " + paramArrayList.size() + ",unReadSysMsgCountInCache = " + i);
      return;
    }
  }
  
  private void a(ArrayList<aigo> paramArrayList, int paramInt)
  {
    String str = "";
    if (paramInt == 1)
    {
      str = aicl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_JavaLangString;
      paramArrayList.add(new aigw(str));
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.loadNewFriendMsg, type=" + paramInt + ",blockedUin=" + str);
    }
  }
  
  private void a(ArrayList<aigo> paramArrayList, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramArrayList.add(new aigm());
    }
    while ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (!paramPhoneContactManagerImp.n()))) {
      return;
    }
    paramArrayList.add(new aign(a(), this.jdField_b_of_type_Boolean));
  }
  
  private void a(ArrayList<aigo> paramArrayList1, ArrayList<aigo> paramArrayList2)
  {
    int j = 0;
    boolean bool2 = true;
    if (paramArrayList2.size() > 1)
    {
      int i = paramArrayList2.size() - 1;
      int k;
      for (;;)
      {
        if ((i < 0) || (!((aigo)paramArrayList2.get(i)).a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + i);
          }
          k = bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i > 0) {
            break label195;
          }
          i = j;
          while (i < 1)
          {
            paramArrayList1.add((aigo)paramArrayList2.get(i));
            i += 1;
          }
        }
        i -= 1;
      }
      this.jdField_a_of_type_Int = 1;
      boolean bool1 = bool2;
      label195:
      do
      {
        do
        {
          this.f = bool1;
          if (bool1)
          {
            paramArrayList2 = new NewFriendMoreInfo();
            paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694078);
            paramArrayList2.type = 1000;
            paramArrayList1.add(new aigp(paramArrayList2));
          }
          return;
          j = 0;
          while (j <= i)
          {
            paramArrayList1.add((aigo)paramArrayList2.get(j));
            j += 1;
          }
          this.jdField_a_of_type_Int = (i + 1);
          bool1 = bool2;
        } while (k > 99);
        bool1 = bool2;
      } while (i + 1 != paramArrayList2.size());
      if (!bcsy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
    }
    paramArrayList1.addAll(paramArrayList2);
    this.f = false;
    this.jdField_a_of_type_Int = paramArrayList2.size();
  }
  
  private void a(ArrayList<aigo> paramArrayList1, ArrayList<aigo> paramArrayList2, int paramInt1, ArrayList<aicz> paramArrayList, boolean paramBoolean, ArrayList<Entity> paramArrayList3, int paramInt2)
  {
    int j = 0;
    int i = 0;
    if (paramArrayList2.size() > 0)
    {
      Collections.sort(paramArrayList2, this.jdField_a_of_type_JavaUtilComparator);
      NewFriendSubTitle localNewFriendSubTitle = new NewFriendSubTitle();
      localNewFriendSubTitle.title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694084);
      boolean bool;
      if (paramInt2 == 3)
      {
        bool = true;
        localNewFriendSubTitle.showEntrance = bool;
        paramArrayList1.add(new aigr(localNewFriendSubTitle));
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.jdField_b_of_type_Int + ",notifyListSize = " + paramArrayList2.size() + ", mSysMsgShouldAddMoreInfo = " + this.f);
        }
        if (((!this.jdField_b_of_type_Boolean) || (paramArrayList3 == null) || (paramArrayList3.size() <= 0)) && (!paramBoolean) && ((paramArrayList == null) || (paramArrayList.isEmpty()))) {
          break label312;
        }
        paramInt1 = i;
        if (this.jdField_b_of_type_Int == paramArrayList2.size()) {
          break label219;
        }
        a(paramArrayList1, paramArrayList2);
        label204:
        this.jdField_b_of_type_Int = paramArrayList2.size();
      }
      label219:
      do
      {
        return;
        bool = false;
        break;
        while (paramInt1 < this.jdField_a_of_type_Int)
        {
          paramArrayList1.add((aigo)paramArrayList2.get(paramInt1));
          paramInt1 += 1;
        }
        if (!this.f) {
          break label204;
        }
        paramArrayList = new NewFriendMoreInfo();
        paramArrayList.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694078);
        paramArrayList.type = 1000;
        paramArrayList1.add(new aigp(paramArrayList));
        break label204;
        if (paramArrayList2.size() > 100)
        {
          paramInt1 = j;
          while (paramInt1 < 100)
          {
            paramArrayList1.add(paramArrayList2.get(paramInt1));
            paramInt1 += 1;
          }
          paramArrayList2 = new NewFriendMoreInfo();
          paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694078);
          paramArrayList2.type = 1000;
          paramArrayList1.add(new aigp(paramArrayList2));
          return;
        }
        paramArrayList1.addAll(paramArrayList2);
      } while (((paramInt1 % 20 != 0) || (bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((paramInt1 <= 20) || (bcsy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))));
      label312:
      paramArrayList2 = new NewFriendMoreInfo();
      paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694078);
      paramArrayList2.type = 1000;
      paramArrayList1.add(new aigp(paramArrayList2));
      return;
    }
    paramArrayList1.add(new aigs());
  }
  
  private void a(ArrayList<QIMFollwerAdd> paramArrayList, ArrayList<aigo> paramArrayList1, FlashChatManager paramFlashChatManager)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Amyk.a(false);
    if (localArrayList.size() > 0) {
      paramArrayList1.addAll(localArrayList);
    }
    if ((paramFlashChatManager.b()) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        paramArrayList1.add(new aigy((QIMFollwerAdd)paramArrayList.next()));
      }
    }
  }
  
  private void a(ArrayList<PhoneContactAdd> paramArrayList, ArrayList<aigo> paramArrayList1, StringBuilder paramStringBuilder)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)paramArrayList.next();
        paramArrayList1.add(new aigx(localPhoneContactAdd));
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" pca").append(localPhoneContactAdd.unifiedCode);
        }
      }
    }
  }
  
  private void a(ArrayList<aigo> paramArrayList1, boolean paramBoolean1, ArrayList<aigo> paramArrayList2, StringBuilder paramStringBuilder, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean2)
  {
    if (paramArrayList2.size() > 0)
    {
      this.d = paramArrayList1.size();
      Collections.sort(paramArrayList2, this.jdField_a_of_type_JavaUtilComparator);
      if ((paramBoolean2) && (paramBoolean1)) {
        b(paramArrayList, paramArrayList2);
      }
      paramArrayList1.addAll(paramArrayList2);
    }
    this.jdField_c_of_type_Int = paramArrayList2.size();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append(" mRecommendSubTitleIndex : ").append(this.d).append(" mRecommendShowCount : ").append(this.jdField_c_of_type_Int).append(" shouldShowNewFriendMayknow:").append(paramBoolean2);
      QLog.d("NewFriendManager", 2, paramStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<aigo> paramArrayList1, boolean paramBoolean1, ArrayList<aigo> paramArrayList2, boolean paramBoolean2, ArrayList<aicz> paramArrayList, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
      if (paramArrayList.size() > 1)
      {
        paramBoolean3 = true;
        paramArrayList1.add(new aigv(paramArrayList, paramBoolean3));
        if (paramArrayList.size() > 1) {
          paramArrayList1.add(new aigq(paramArrayList));
        }
        if (!paramBoolean1) {
          break label99;
        }
        if (paramArrayList2.size() == 0) {
          paramArrayList1.add(new aigt());
        }
      }
    }
    label99:
    while (paramArrayList2.size() <= 0)
    {
      do
      {
        for (;;)
        {
          return;
          paramBoolean3 = false;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (paramArrayList2.size() != 0);
      paramArrayList1.add(new aigt());
      return;
      paramArrayList1.add(new aigu());
      return;
    }
    paramArrayList2 = new NewFriendSubTitle();
    paramArrayList2.title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131689655);
    paramArrayList1.add(new aigr(paramArrayList2));
  }
  
  private boolean a(aigo paramaigo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    anuz localanuz;
    do
    {
      return false;
      localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    } while ((paramaigo == null) || (localanuz == null) || ((paramaigo.a()) && (!localanuz.isRecentUserInCache(AppConstants.RECOMMEND_CONTACT_UIN, 4000))));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(AppConstants.RECOMMEND_CONTACT_UIN)) && (!paramString.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (!paramString.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (!paramString.equals(AppConstants.FRIEND_ANNIVER_UIN))) {
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
      boolean bool = aigj.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramString, 0, new int[] { paramInt });
    return (paramString != null) && (paramString.size() > 0);
  }
  
  private void b(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<aigo> paramArrayList1)
  {
    if (paramArrayList1 == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localArrayList = ((apgi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|card.strSchool = " + ((Card)localObject).strSchool + "schoolInfos =" + localArrayList);
      }
    } while ((!TextUtils.isEmpty(((Card)localObject).strSchool)) || ((localArrayList != null) && (!localArrayList.isEmpty())) || (paramArrayList == null) || (paramArrayList.size() <= 0));
    Object localObject = new ConnectsExplorationBanner();
    ((ConnectsExplorationBanner)localObject).setBanner(true);
    localObject = new aigk((ConnectsExplorationBanner)localObject);
    if (paramArrayList.size() <= 4)
    {
      paramArrayList1.add(localObject);
      return;
    }
    paramArrayList1.add(4, localObject);
  }
  
  private boolean b()
  {
    return !((airj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c();
  }
  
  private ArrayList<aigj> c()
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
  }
  
  private ArrayList<aigj> d()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
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
            if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.jdField_a_of_type_Amsw.b(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + localMessageRecord.senderuin + ",mr.time = " + localMessageRecord.time);
            }
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              break label367;
            }
            Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!localIterator.hasNext()) {
              break label367;
            }
            aigj localaigj = (aigj)localIterator.next();
            if ((localaigj.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg == null) || (!localaigj.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.senderuin.equals(localMessageRecord.senderuin))) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(new aigj((MessageForSystemMsg)localMessageRecord));
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          break label358;
        }
      }
      finally {}
      QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      label358:
      ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      return localArrayList;
      label367:
      int i = 0;
    }
  }
  
  private void m()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localEntityManager.query(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localEntityManager.update(localQIMFollwerAdd);
      }
    }
    localEntityManager.close();
  }
  
  private void n()
  {
    aigo localaigo = a();
    if (localaigo != null)
    {
      a(localaigo);
      setChanged();
      notifyObservers(localaigo);
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
  
  public aigo a()
  {
    int j = 0;
    Object localObject = b();
    int i = 0;
    aigo localaigo1;
    if (i < ((ArrayList)localObject).size())
    {
      localaigo1 = (aigo)((ArrayList)localObject).get(i);
      if ((localaigo1 == null) || (localaigo1.a())) {}
    }
    for (;;)
    {
      if ((localaigo1 != null) && (!(localaigo1 instanceof aigh)) && (!(localaigo1 instanceof aigl)))
      {
        i = j;
        if (!(localaigo1 instanceof aigi)) {
          break label80;
        }
      }
      for (;;)
      {
        return localaigo1;
        i += 1;
        break;
        label80:
        aigo localaigo2;
        do
        {
          i += 1;
          if (i >= ((ArrayList)localObject).size()) {
            break;
          }
          localaigo2 = (aigo)((ArrayList)localObject).get(i);
        } while ((localaigo2 == null) || (localaigo2.a()) || ((localaigo2 instanceof aigj)));
        while (localaigo2 != null)
        {
          localObject = localaigo2;
          if (localaigo1.jdField_a_of_type_Long >= localaigo2.jdField_a_of_type_Long) {
            localObject = localaigo1;
          }
          return localObject;
          localaigo2 = null;
        }
      }
      localaigo1 = null;
    }
  }
  
  public apza a()
  {
    if (this.jdField_a_of_type_Apza == null) {
      this.jdField_a_of_type_Apza = apzc.a();
    }
    return this.jdField_a_of_type_Apza;
  }
  
  public ArrayList<QIMFollwerAdd> a()
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(QIMFollwerAdd.class);
  }
  
  public List<Object> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().iterator();
    int i = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (aigo)localIterator.next();
      if ((localObject != null) && (!((aigo)localObject).a())) {
        if ((localObject instanceof aigj))
        {
          i += 1;
        }
        else if ((localObject instanceof aigh))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.c();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        else if ((localObject instanceof aigi))
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
    if (localArrayList.size() > 0) {}
    try
    {
      Collections.sort(localArrayList, this.jdField_c_of_type_JavaUtilComparator);
      if (QLog.isColorLevel())
      {
        QLog.d("NewFriendManager", 2, "getAllUnreadMsg size = " + localArrayList.size() + ",unReadSysMsgCountInCache = " + i);
        if (localArrayList.size() > 0)
        {
          localIterator = localArrayList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return localArrayList;
            }
            localObject = localIterator.next();
            if (!(localObject instanceof PhoneContact)) {
              break;
            }
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg PhoneContact time  = " + ((PhoneContact)localObject).lastScanTime);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("NewFriendManager", 1, "getAllUnreadMsg sort exception ", localException);
        continue;
        if ((localObject instanceof aigj)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg FriendSystemMessage time  = " + ((aigj)localObject).jdField_a_of_type_Long * 1000L);
        } else if ((localObject instanceof aigi)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg ContactMatchMessage time  = " + ((aigi)localObject).jdField_a_of_type_Long * 1000L);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      if (localSysSuspiciousMsg != null) {
        break label115;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(SysSuspiciousMsg.class, paramLong);
    }
    label115:
    for (;;)
    {
      boolean bool = false;
      if (localSysSuspiciousMsg != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localSysSuspiciousMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "deleteSysSuspiciousMsg " + paramLong + " " + bool);
      }
      return;
    }
  }
  
  public void a(aiep paramaiep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramaiep)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramaiep);
      }
      return;
    }
  }
  
  public void a(aigj paramaigj)
  {
    long l = bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((localMessageRecord.isread) || (!(localMessageRecord instanceof MessageForSystemMsg)));
    for (localObject = new aigj((MessageForSystemMsg)localMessageRecord);; localObject = null)
    {
      if (localObject != null)
      {
        ((aigj)localObject).jdField_a_of_type_Long = paramaigj.jdField_a_of_type_Long;
        ((aigj)localObject).jdField_a_of_type_JavaLangString = paramaigj.jdField_a_of_type_JavaLangString;
        a((aigo)localObject);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().remove(paramQIMFollwerAdd);
  }
  
  public void a(SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if ((paramSysSuspiciousMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramSysSuspiciousMsg);
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
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 61	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 62	java/util/ArrayList:<init>	()V
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 153	aiej:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;
    //   15: invokevirtual 1019	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:c	()Ljava/util/ArrayList;
    //   18: astore 11
    //   20: aload_0
    //   21: invokevirtual 1020	aiej:a	()Ljava/util/ArrayList;
    //   24: astore 12
    //   26: iload_2
    //   27: bipush 23
    //   29: if_icmpne +324 -> 353
    //   32: iconst_1
    //   33: istore 4
    //   35: new 61	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 62	java/util/ArrayList:<init>	()V
    //   42: astore 8
    //   44: new 61	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 62	java/util/ArrayList:<init>	()V
    //   51: astore 9
    //   53: new 236	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 256
    //   60: invokespecial 1021	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 10
    //   65: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: aload 10
    //   73: ldc_w 1023
    //   76: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: getfield 114	aiej:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   84: bipush 11
    //   86: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   89: checkcast 151	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp
    //   92: astore 13
    //   94: aload_0
    //   95: aload 13
    //   97: invokevirtual 1025	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:m	()Z
    //   100: putfield 339	aiej:jdField_b_of_type_Boolean	Z
    //   103: aload_0
    //   104: getfield 114	aiej:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: sipush 217
    //   110: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   113: checkcast 692	com/tencent/mobileqq/flashchat/FlashChatManager
    //   116: astore 14
    //   118: aload_0
    //   119: aload 7
    //   121: aload 13
    //   123: invokespecial 1027	aiej:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;)V
    //   126: aload_0
    //   127: iload_1
    //   128: aload 10
    //   130: aload 8
    //   132: iconst_0
    //   133: invokespecial 1029	aiej:a	(ZLjava/lang/StringBuilder;Ljava/util/ArrayList;I)I
    //   136: istore_3
    //   137: aload_0
    //   138: aload 12
    //   140: aload 8
    //   142: aload 14
    //   144: invokespecial 1031	aiej:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/flashchat/FlashChatManager;)V
    //   147: aload_0
    //   148: aload 11
    //   150: aload 8
    //   152: aload 10
    //   154: invokespecial 1033	aiej:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/StringBuilder;)V
    //   157: aload_0
    //   158: invokespecial 1034	aiej:b	()Z
    //   161: istore 5
    //   163: new 61	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 62	java/util/ArrayList:<init>	()V
    //   170: astore 11
    //   172: aload_0
    //   173: getfield 149	aiej:jdField_a_of_type_Amvo	Lamvo;
    //   176: invokevirtual 1036	amvo:e	()Z
    //   179: istore 6
    //   181: aload_0
    //   182: iload_2
    //   183: iload 4
    //   185: aload 9
    //   187: aload 10
    //   189: iload 5
    //   191: aload 11
    //   193: aconst_null
    //   194: iload 6
    //   196: invokespecial 1038	aiej:a	(IZLjava/util/ArrayList;Ljava/lang/StringBuilder;ZLjava/util/ArrayList;Ljava/util/ArrayList;Z)Ljava/util/ArrayList;
    //   199: astore 12
    //   201: iconst_0
    //   202: istore_1
    //   203: iload 4
    //   205: ifeq +5 -> 210
    //   208: iconst_1
    //   209: istore_1
    //   210: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +43 -> 256
    //   216: ldc_w 348
    //   219: iconst_2
    //   220: new 236	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 1040
    //   230: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 339	aiej:jdField_b_of_type_Boolean	Z
    //   237: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   240: ldc_w 1042
    //   243: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_1
    //   247: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   250: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_0
    //   257: iload 4
    //   259: aload 9
    //   261: aload 10
    //   263: aload 12
    //   265: iload_1
    //   266: aconst_null
    //   267: invokespecial 1044	aiej:a	(ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;ZLjava/util/ArrayList;)Ljava/util/ArrayList;
    //   270: astore 13
    //   272: aload_0
    //   273: getfield 114	aiej:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: invokestatic 565	aicl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laicl;
    //   279: invokevirtual 1046	aicl:a	()I
    //   282: istore_2
    //   283: aload_0
    //   284: aload 7
    //   286: iload_2
    //   287: invokespecial 1048	aiej:a	(Ljava/util/ArrayList;I)V
    //   290: aload_0
    //   291: aload 7
    //   293: aload 8
    //   295: iload_3
    //   296: aload 12
    //   298: iload 6
    //   300: aload 13
    //   302: iload_2
    //   303: invokespecial 1050	aiej:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/util/ArrayList;ZLjava/util/ArrayList;I)V
    //   306: aload_0
    //   307: aload 7
    //   309: iload 4
    //   311: aload 9
    //   313: iload 5
    //   315: aload 12
    //   317: iload 6
    //   319: invokespecial 1052	aiej:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;ZLjava/util/ArrayList;Z)V
    //   322: aload_0
    //   323: aload 7
    //   325: iload 4
    //   327: aload 9
    //   329: aload 10
    //   331: aload 11
    //   333: iload 6
    //   335: invokespecial 1054	aiej:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Z)V
    //   338: aload_0
    //   339: aload 7
    //   341: invokespecial 1056	aiej:a	(Ljava/util/ArrayList;)V
    //   344: aload_0
    //   345: aload 7
    //   347: putfield 64	aiej:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   350: aload_0
    //   351: monitorexit
    //   352: return
    //   353: iconst_0
    //   354: istore 4
    //   356: goto -321 -> 35
    //   359: astore 7
    //   361: aload_0
    //   362: monitorexit
    //   363: aload 7
    //   365: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	aiej
    //   0	366	1	paramBoolean	boolean
    //   0	366	2	paramInt	int
    //   136	160	3	i	int
    //   33	322	4	bool1	boolean
    //   161	153	5	bool2	boolean
    //   179	155	6	bool3	boolean
    //   9	337	7	localArrayList1	ArrayList
    //   359	5	7	localObject1	Object
    //   42	252	8	localArrayList2	ArrayList
    //   51	277	9	localArrayList3	ArrayList
    //   63	267	10	localStringBuilder	StringBuilder
    //   18	314	11	localArrayList4	ArrayList
    //   24	292	12	localArrayList5	ArrayList
    //   92	209	13	localObject2	Object
    //   116	27	14	localFlashChatManager	FlashChatManager
    // Exception table:
    //   from	to	target	type
    //   2	26	359	finally
    //   35	80	359	finally
    //   80	201	359	finally
    //   210	256	359	finally
    //   256	350	359	finally
  }
  
  public boolean a()
  {
    aigo localaigo = a();
    return (localaigo != null) && (localaigo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    boolean bool1 = ((azwy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a();
    boolean bool2 = b(paramString);
    QLog.d("NewFriendManager", 1, String.format("handleNewFrdAIOShow [isNewFrd,newFrdMiniCardSwitch]=[%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    if (!bool2) {
      return false;
    }
    if (!bool1)
    {
      a(paramString);
      acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    return true;
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
  
  public ArrayList<aigo> b()
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
          break label198;
        }
      }
      label198:
      for (localObject2 = Integer.valueOf(((List)localObject1).size());; localObject2 = "null")
      {
        QLog.i("NewFriendManager", 2, localObject2);
        return localObject1;
        if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
          break label205;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(SysSuspiciousMsg.class);
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
      label205:
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
  
  public void b(aiep paramaiep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramaiep);
      return;
    }
  }
  
  public void b(QIMFollwerAdd paramQIMFollwerAdd)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.persistOrReplace(paramQIMFollwerAdd);
    localEntityManager.close();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
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
    return bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c()
  {
    int i = d();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendManager.5(this, i));
  }
  
  public int d()
  {
    int k = bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = b().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      aigo localaigo = (aigo)localIterator.next();
      if ((localaigo == null) || (localaigo.a())) {
        break label159;
      }
      if ((localaigo instanceof aigj)) {
        j += 1;
      } else if ((localaigo instanceof aigh)) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a() + i;
      } else {
        i += 1;
      }
    }
    label159:
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
    anuz localanuz;
    RecentUser localRecentUser;
    do
    {
      return;
      localanuz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = (RecentUser)localanuz.findRecentUser(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    } while (localRecentUser == null);
    localanuz.delRecentUser(localRecentUser);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.h();
      m();
      this.jdField_a_of_type_Amyk.b();
      bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().b();
      b();
      return true;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().b();
      this.jdField_a_of_type_Amyk.b();
      b();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.h();
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
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
      return;
    }
    boolean bool = localSharedPreferences.getBoolean("contact_guide_user_close", false);
    int i = localSharedPreferences.getInt("new_friend_show_count_after_user_close", 0);
    apza localapza = a();
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(localapza.jdField_a_of_type_Boolean), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localapza.jdField_a_of_type_Int) }));
    }
    if ((localapza.jdField_a_of_type_Boolean) && ((!bool) || (i >= localapza.jdField_a_of_type_Int)))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(SysSuspiciousMsg.class);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_a_of_type_Avsz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiej
 * JD-Core Version:    0.7.0.1
 */