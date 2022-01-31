import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager.2;
import com.tencent.mobileqq.app.FriendsManager.3;
import com.tencent.mobileqq.app.FriendsManager.5;
import com.tencent.mobileqq.app.FriendsManager.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class ajjj
  implements Manager
{
  public int a;
  private final ajeb jdField_a_of_type_Ajeb = new ajeb();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private MQLruCache<String, DateNickNameInfo> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(500);
  private atmp jdField_a_of_type_Atmp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<atmo> jdField_a_of_type_JavaUtilArrayList;
  ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ajjk(this);
  public volatile boolean a;
  public int b;
  private final MQLruCache<String, Card> jdField_b_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(20);
  private ConcurrentHashMap<String, Groups> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean b;
  public int c;
  private ConcurrentHashMap<String, atmo> c;
  public boolean c;
  public int d;
  private ConcurrentHashMap<String, atmo> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1011, 0, 400);
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private ConcurrentHashMap<String, atmo> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1012, 0, 400);
  private volatile boolean jdField_e_of_type_Boolean;
  public int f;
  private ConcurrentHashMap<String, Integer> jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_f_of_type_Boolean;
  public int g;
  private ConcurrentHashMap<String, ArrayList<atmo>> jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  private boolean jdField_g_of_type_Boolean;
  public int h;
  private ConcurrentHashMap<String, SpecialCareInfo> jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_h_of_type_Boolean;
  public int i;
  private ConcurrentHashMap<String, String> i;
  public int j = 30;
  public int k = 5;
  public int l = 7;
  public int m = 30;
  public int n = 7;
  public int o = 30;
  public int p = 6;
  public int q = -1;
  public int r;
  int s = 0;
  private int t;
  
  public ajjj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 7;
    this.jdField_d_of_type_Int = 30;
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 30;
    this.jdField_g_of_type_Int = 3;
    this.jdField_h_of_type_Int = 30;
    this.jdField_i_of_type_Int = 3;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    f();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap<String, ArrayList<atmo>> a(boolean paramBoolean)
  {
    label561:
    label564:
    label567:
    label570:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject4;
      int i1;
      Object localObject3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject4 = new ConcurrentHashMap(4);
        int i2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
          if (localFriends.gathtertype != 1) {
            break label567;
          }
          i1 += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label564;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            ajgh.a(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject3 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label561;
            }
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label561;
            }
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(Math.min(i2, localGroups.group_friend_count));
          }
          ((ArrayList)localObject1).add(localFriends);
          if (!paramBoolean) {
            break label570;
          }
          int i3 = babh.a(localFriends);
          if ((i3 == 0) || (i3 == 6)) {
            break label570;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject4).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      if (paramBoolean) {
        this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject4);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(300);
        localStringBuilder.append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject3 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localStringBuilder.append((String)localObject4).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject4)).size()).append("; ");
        }
        localStringBuilder.append(" gatherCount=").append(i1);
        QLog.d("Q.contacttab.friend", 2, localStringBuilder.toString());
      }
      this.t = i1;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(10);
    String str;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      str = "1";
      localHashMap.put("param_IsMainThread", str);
      localHashMap.put("param_OptType", paramString1);
      localHashMap.put("param_bustag", paramString2);
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap.put("param_intrans", paramString1);
      localHashMap.put("param_OptTotalCost", String.valueOf(paramLong));
      localHashMap.put("param_WalSwitch", String.valueOf(ajrl.a));
      awrn.a(BaseApplicationImpl.getContext()).a(null, "actFriendSqliteOpt", true, paramLong, 0L, localHashMap, null, false);
      return;
      str = "0";
      break;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[i1].uin);
      i1 += 1;
    }
    aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), localArrayList);
  }
  
  private void c(int paramInt)
  {
    int i1 = 0;
    try
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localSharedPreferences.edit().putInt("friend_count_from_server", paramInt).apply();
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        i1 = 0;
        while (localIterator.hasNext())
        {
          Groups localGroups = (Groups)((Map.Entry)localIterator.next()).getValue();
          if (localGroups != null) {
            i1 += localGroups.group_friend_count;
          }
        }
        localSharedPreferences.edit().putInt("friend_count_from_group", i1).apply();
      }
      QLog.i("friend", 1, String.format("saveFrdCount [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) }));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.i("friend", 1, localThrowable.toString(), localThrowable);
    }
  }
  
  private void f()
  {
    ThreadManager.executeOnSubThread(new FriendsManager.2(this));
  }
  
  private boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    j();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  private void g(String paramString)
  {
    for (;;)
    {
      int i3;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i4 = this.r;
        localStringBuilder.append("checkAndLog, ").append(paramString);
        i3 = 0;
        int i1 = 0;
        int i2 = 0;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i3 < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          paramString = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
          if (paramString != null)
          {
            if (QLog.isColorLevel()) {
              localStringBuilder.append(", [").append(paramString.group_id).append(",").append(paramString.group_friend_count).append("]");
            }
            i2 += paramString.group_friend_count;
            paramString = (ArrayList)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramString.group_id));
            if (paramString != null) {
              i1 = paramString.size() + i1;
            }
          }
        }
        else
        {
          localStringBuilder.append(", count1: ").append(i2);
          localStringBuilder.append(", count2: ").append(i1);
          localStringBuilder.append(", count3: ").append(i4);
          if ((i2 != i4) || (i1 != i4))
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
            i1 = paramString.getInt("friend_count_from_server", -1);
            i2 = paramString.getInt("friend_count_from_group", -1);
            localStringBuilder.append(", count4: ").append(i1);
            localStringBuilder.append(", count5: ").append(i2);
          }
          QLog.i("friend", 1, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.i("friend", 1, paramString.toString(), paramString);
        return;
      }
      i3 += 1;
    }
  }
  
  private void h()
  {
    alrm localalrm = alrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = localalrm.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, new Object[] { "doResetRingIdOfExtensionInfo: invoked. ", " hasResetGrayUserRingId: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      localalrm.a(this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap);
      localalrm.a();
    }
  }
  
  private void i()
  {
    ??? = (ArrayList)this.jdField_a_of_type_Atmp.a(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private void j()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_Atmp.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilArrayList.size());
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        ((ConcurrentHashMap)localObject).put(localGroups.group_id + "", localGroups);
        i1 += 1;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initGroupList end: ");
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label191;
      }
    }
    label191:
    for (int i1 = i2;; i1 = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size())
    {
      QLog.d("Q.contacttab.friend", 2, i1);
      return;
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (!((Friends)localIterator.next()).isFriend()) {
        break label51;
      }
      i1 += 1;
    }
    label51:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (!paramString.isFriend())) {
      return 0;
    }
    return paramString.friendType;
  }
  
  public ajeb a()
  {
    if (!this.jdField_a_of_type_Ajeb.a) {
      ThreadManager.excute(new FriendsManager.6(this), 16, null, true);
    }
    return this.jdField_a_of_type_Ajeb;
  }
  
  public atmr a()
  {
    return this.jdField_a_of_type_Atmp.a();
  }
  
  public Card a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache)
      {
        paramString = (Card)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
        return paramString;
      }
    }
    return null;
  }
  
  public Card a(String paramString, boolean paramBoolean)
  {
    long l1;
    if (awrn.a(7))
    {
      l1 = SystemClock.uptimeMillis();
      aqqw.a();
    }
    for (;;)
    {
      ??? = null;
      if (!TextUtils.isEmpty(paramString)) {}
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache)
      {
        ??? = (Card)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
        ??? = ???;
        if (??? == null)
        {
          ??? = (Card)this.jdField_a_of_type_Atmp.a(Card.class, paramString);
          if ((??? == null) || (TextUtils.isEmpty(paramString))) {}
        }
        synchronized (this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache)
        {
          this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, ???);
          ??? = ???;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin find from DB uin=%s card=%s", new Object[] { paramString, ??? }));
            ??? = ???;
          }
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "query", "Card");
          }
          ??? = ???;
          if (??? == null)
          {
            ??? = ???;
            if (paramBoolean)
            {
              ??? = new Card();
              ((Card)???).uin = paramString;
              ((Card)???).shGender = -1;
              if (awrn.a(8)) {
                l1 = SystemClock.uptimeMillis();
              }
              if (TextUtils.isEmpty(paramString)) {}
            }
          }
        }
      }
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache)
      {
        this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, ???);
        this.jdField_a_of_type_Atmp.a((atmo)???);
        if (l1 != 0L) {
          a(SystemClock.uptimeMillis() - l1, false, "insert", "Card");
        }
        ??? = ???;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, String.format(Locale.getDefault(), "findFriendCardByUin new uin=%s card=%s", new Object[] { paramString, ??? }));
          ??? = ???;
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder(200);
          ((StringBuilder)???).append("findFriendCardByUin  uin=").append(paramString).append(", card=").append(???);
          if (??? != null) {
            ((StringBuilder)???).append(", medalSwitchDisable=").append(((Card)???).medalSwitchDisable).append(", bSuperVipOpen=").append(((Card)???).bSuperVipOpen).append(", bQQVipOpen =").append(((Card)???).bQQVipOpen).append(", showOnlineFriends=").append(((Card)???).showOnlineFriends);
          }
          QLog.d("Q.contacttab.", 2, ((StringBuilder)???).toString());
        }
        return ???;
        paramString = finally;
        throw paramString;
        paramString = finally;
        throw paramString;
      }
      l1 = 0L;
    }
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.jdField_a_of_type_Atmp.a(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.jdField_h_of_type_Boolean) {
      ThreadManager.postImmediately(new FriendsManager.5(this), null, false);
    }
    return (DateNickNameInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return ???;
    }
    ExtensionInfo localExtensionInfo;
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localExtensionInfo = (ExtensionInfo)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    do
    {
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_Atmp.a(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
      localExtensionInfo = null;
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
    } while (paramBoolean);
    return null;
  }
  
  public Friends a(String paramString)
  {
    if (!f(paramString)) {
      return null;
    }
    return (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ajgh.a(paramString1);
    }
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_Atmp.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    this.jdField_a_of_type_JavaUtilArrayList = ajgh.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public KplCard a(String paramString)
  {
    long l1;
    if (awrn.a(7))
    {
      l1 = SystemClock.uptimeMillis();
      aqqw.a();
    }
    for (;;)
    {
      paramString = (KplCard)this.jdField_a_of_type_Atmp.a(KplCard.class, paramString);
      if (l1 != 0L) {
        a(SystemClock.uptimeMillis() - l1, false, "query", "Card");
      }
      if (paramString != null) {
        paramString.transStringToList();
      }
      if ((QLog.isColorLevel()) && (paramString != null)) {
        QLog.d("Q.contacttab.", 2, "findFriendCardByUin qqNick=" + paramString.qqNick + ",gameNick=" + paramString.gameNick + ",uin = " + paramString.uin);
      }
      return paramString;
      l1 = 0L;
    }
  }
  
  public NoC2CExtensionInfo a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = NoC2CExtensionInfo.getNoC2Ckey(paramInt, paramString);
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.jdField_e_of_type_Boolean)
        {
          paramString = (NoC2CExtensionInfo)this.jdField_a_of_type_Atmp.a(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
              return paramString;
            }
          }
        }
      }
    }
    return ???;
  }
  
  public SpecialCareInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    ??? = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label28;
      }
      ??? = localObject1;
    }
    for (;;)
    {
      return ???;
      label28:
      localObject1 = localObject3;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
      synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        ??? = localObject1;
        if (localObject1 == null) {
          continue;
        }
        return (SpecialCareInfo)((SpecialCareInfo)localObject1).clone();
      }
    }
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = e(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  public ArrayList<Friends> a()
  {
    if (!this.jdField_d_of_type_Boolean) {
      b();
    }
    if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(10);
      Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Friends localFriends = (Friends)localIterator.next();
        if (localFriends.isShield()) {
          localArrayList.add(localFriends);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public ArrayList<atmo> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<atmo> a(String paramString)
  {
    return (ArrayList)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List<SpecialCareInfo> a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
        if (localSpecialCareInfo.globalSwitch != 0) {
          localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecailCareInfos: size=" + localList.size());
    }
    return localList;
  }
  
  public ConcurrentHashMap<String, ArrayList<atmo>> a()
  {
    return a(false);
  }
  
  public void a()
  {
    label543:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        int i1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label325;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ajgh.a(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label543;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label543;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(Math.min(i1, localGroups.group_friend_count));
        }
        ((ArrayList)localObject1).add(localFriends);
        int i2 = babh.a(localFriends.detalStatusFlag, localFriends.iTermType);
        if ((i2 == 0) || (i2 == 6)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(localObject2.intValue() + 1));
      }
      finally {}
      continue;
      label325:
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            Collections.sort((List)localObject4, ajgh.a);
          }
        }
      }
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = localConcurrentHashMap;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 819	java/lang/StringBuffer
    //   5: dup
    //   6: invokespecial 820	java/lang/StringBuffer:<init>	()V
    //   9: astore 6
    //   11: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +19 -> 33
    //   17: aload 6
    //   19: ldc_w 822
    //   22: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   25: pop
    //   26: aload 6
    //   28: iload_1
    //   29: invokevirtual 828	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aload_0
    //   34: iload_1
    //   35: invokevirtual 830	ajjj:a	(I)Ljava/util/ArrayList;
    //   38: astore 5
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   46: invokevirtual 591	atmp:a	()Latmr;
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 833	atmr:a	()V
    //   58: aload 5
    //   60: invokevirtual 276	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 225 1 0
    //   72: ifeq +115 -> 187
    //   75: aload 4
    //   77: invokeinterface 229 1 0
    //   82: checkcast 278	atmo
    //   85: checkcast 236	com/tencent/mobileqq/data/Friends
    //   88: astore 7
    //   90: aload 7
    //   92: iconst_0
    //   93: putfield 257	com/tencent/mobileqq/data/Friends:groupid	I
    //   96: aload_0
    //   97: aload 7
    //   99: invokevirtual 836	ajjj:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   102: pop
    //   103: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -41 -> 65
    //   109: aload 6
    //   111: ldc_w 838
    //   114: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload 6
    //   120: aload 7
    //   122: getfield 401	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   125: iconst_0
    //   126: iconst_4
    //   127: invokevirtual 842	java/lang/String:substring	(II)Ljava/lang/String;
    //   130: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: goto -69 -> 65
    //   137: astore 4
    //   139: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +32 -> 174
    //   145: ldc_w 844
    //   148: iconst_2
    //   149: new 171	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 846
    //   159: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_1
    //   163: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload 4
    //   171: invokestatic 848	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 850	atmr:b	()V
    //   182: aload_0
    //   183: invokevirtual 481	ajjj:a	()V
    //   186: return
    //   187: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +15 -> 205
    //   193: ldc_w 844
    //   196: iconst_2
    //   197: aload 6
    //   199: invokevirtual 851	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   202: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: iconst_0
    //   207: invokestatic 499	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 853	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   213: astore 4
    //   215: aload 4
    //   217: ifnull +26 -> 243
    //   220: aload 4
    //   222: aload 4
    //   224: getfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   227: aload 5
    //   229: invokevirtual 326	java/util/ArrayList:size	()I
    //   232: iadd
    //   233: putfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   236: aload_0
    //   237: aload 4
    //   239: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   242: pop
    //   243: aload_0
    //   244: new 171	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   251: iload_1
    //   252: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 262
    //   258: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 853	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   267: astore 4
    //   269: aload_0
    //   270: getfield 434	ajjj:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   273: ifnull +31 -> 304
    //   276: aload_0
    //   277: getfield 434	ajjj:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: new 171	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   287: iload_1
    //   288: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 262
    //   294: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokevirtual 859	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: aload_0
    //   305: getfield 275	ajjj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   308: invokevirtual 860	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   311: checkcast 268	java/util/ArrayList
    //   314: astore 5
    //   316: iload_2
    //   317: aload 5
    //   319: invokevirtual 326	java/util/ArrayList:size	()I
    //   322: if_icmpge +26 -> 348
    //   325: iload_1
    //   326: aload 5
    //   328: iload_2
    //   329: invokevirtual 490	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   332: checkcast 280	com/tencent/mobileqq/data/Groups
    //   335: getfield 283	com/tencent/mobileqq/data/Groups:group_id	I
    //   338: if_icmpne +41 -> 379
    //   341: aload 5
    //   343: iload_2
    //   344: invokevirtual 862	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   347: pop
    //   348: aload_0
    //   349: aload 5
    //   351: putfield 275	ajjj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   354: aload_0
    //   355: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   358: aload 4
    //   360: invokevirtual 864	atmp:b	(Latmo;)Z
    //   363: pop
    //   364: aload_3
    //   365: invokevirtual 866	atmr:c	()V
    //   368: aload_3
    //   369: ifnull -187 -> 182
    //   372: aload_3
    //   373: invokevirtual 850	atmr:b	()V
    //   376: goto -194 -> 182
    //   379: iload_2
    //   380: iconst_1
    //   381: iadd
    //   382: istore_2
    //   383: goto -67 -> 316
    //   386: astore 4
    //   388: aconst_null
    //   389: astore_3
    //   390: aload_3
    //   391: ifnull +7 -> 398
    //   394: aload_3
    //   395: invokevirtual 850	atmr:b	()V
    //   398: aload 4
    //   400: athrow
    //   401: astore 4
    //   403: goto -13 -> 390
    //   406: astore 4
    //   408: goto -18 -> 390
    //   411: astore 4
    //   413: goto -274 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	ajjj
    //   0	416	1	paramInt	int
    //   1	382	2	i1	int
    //   41	354	3	localObject1	Object
    //   49	27	4	localObject2	Object
    //   137	33	4	localException1	Exception
    //   213	146	4	localGroups	Groups
    //   386	13	4	localObject3	Object
    //   401	1	4	localObject4	Object
    //   406	1	4	localObject5	Object
    //   411	1	4	localException2	Exception
    //   38	312	5	localArrayList	ArrayList
    //   9	189	6	localStringBuffer	java.lang.StringBuffer
    //   88	33	7	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   54	65	137	java/lang/Exception
    //   65	134	137	java/lang/Exception
    //   187	205	137	java/lang/Exception
    //   205	215	137	java/lang/Exception
    //   220	243	137	java/lang/Exception
    //   243	304	137	java/lang/Exception
    //   304	316	137	java/lang/Exception
    //   316	348	137	java/lang/Exception
    //   348	368	137	java/lang/Exception
    //   42	51	386	finally
    //   54	65	401	finally
    //   65	134	401	finally
    //   187	205	401	finally
    //   205	215	401	finally
    //   220	243	401	finally
    //   243	304	401	finally
    //   304	316	401	finally
    //   316	348	401	finally
    //   348	368	401	finally
    //   139	174	406	finally
    //   42	51	411	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {}
    Friends localFriends;
    int i1;
    do
    {
      do
      {
        return;
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong));
      } while (localFriends == null);
      i1 = babh.a(localFriends.detalStatusFlag, localFriends.iTermType);
    } while ((i1 != 0) && (i1 != 6));
    localFriends.detalStatusFlag = 10;
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (TextUtils.isEmpty(paramExtensionInfo.uin))) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ajgh.a(paramFriends);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Groups paramGroups)
  {
    int i3 = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int i1;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_Atmp.a(paramGroups);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
      i1 = 0;
    }
    for (;;)
    {
      int i2 = i3;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          i2 = 1;
        }
      }
      else
      {
        if (i2 == 0) {
          this.jdField_a_of_type_JavaUtilArrayList = ajgh.a(this.jdField_a_of_type_JavaUtilArrayList, paramGroups);
        }
        a();
        return;
        this.jdField_a_of_type_Atmp.a(paramGroups);
        break;
      }
      i1 += 1;
    }
  }
  
  /* Error */
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +34 -> 37
    //   6: aload_1
    //   7: getfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   10: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +24 -> 37
    //   16: aload_1
    //   17: getfield 888	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   20: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +14 -> 37
    //   26: aload_1
    //   27: getfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   30: lstore_2
    //   31: lload_2
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new 690	com/tencent/mobileqq/data/DateNickNameInfo
    //   43: dup
    //   44: aload_1
    //   45: getfield 888	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   48: aload_1
    //   49: getfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   52: invokespecial 894	com/tencent/mobileqq/data/DateNickNameInfo:<init>	(Ljava/lang/String;J)V
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 81	ajjj:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   61: aload_1
    //   62: getfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   65: aload 4
    //   67: invokevirtual 612	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: goto -34 -> 37
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ajjj
    //   0	79	1	paramNearbyPeopleCard	NearbyPeopleCard
    //   30	2	2	l1	long
    //   55	11	4	localDateNickNameInfo	DateNickNameInfo
    // Exception table:
    //   from	to	target	type
    //   6	31	74	finally
    //   40	71	74	finally
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if ((paramNoC2CExtensionInfo == null) || (paramNoC2CExtensionInfo.uin == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        continue;
      }
      synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramNoC2CExtensionInfo);
        if (!paramBoolean) {
          continue;
        }
        a(paramNoC2CExtensionInfo);
        return;
      }
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo == null) || (paramSpecialCareInfo.uin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo: " + paramSpecialCareInfo.toString());
    }
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getInt("hotDisableInteractive", 1) == 1) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString.length >= 9) {}
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        this.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[1]).intValue();
        this.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[2]).intValue();
        this.jdField_f_of_type_Int = Integer.valueOf(arrayOfString[3]).intValue();
        this.jdField_g_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
        this.jdField_h_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
        this.jdField_i_of_type_Int = Integer.valueOf(arrayOfString[6]).intValue();
        this.j = Integer.valueOf(arrayOfString[7]).intValue();
        this.k = Integer.valueOf(arrayOfString[8]).intValue();
        if (arrayOfString.length < 11) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[9]).intValue();
          this.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[10]).intValue();
          if (arrayOfString.length < 13) {}
        }
        catch (Exception localException3)
        {
          try
          {
            do
            {
              for (;;)
              {
                this.l = Integer.valueOf(arrayOfString[11]).intValue();
                this.m = Integer.valueOf(arrayOfString[12]).intValue();
                ascd.a(localSharedPreferences, this);
                return;
                this.jdField_b_of_type_Boolean = false;
                break;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.contacttab.", 2, paramString, localException2);
                }
              }
              localException3 = localException3;
            } while (!QLog.isColorLevel());
            QLog.e("Q.contacttab.", 2, paramString, localException3);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.contacttab.", 2, paramString, localException1);
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(String paramString, byte paramByte)
  {
    paramString = a(paramString, true);
    if (paramString != null)
    {
      paramString.bSingle = paramByte;
      a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Friends localFriends = e(paramString);
    int i1;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      i1 = localFriends.groupid;
      localGroups1 = a(String.valueOf(i1));
      if ((i1 >= 0) && (localGroups1 != null)) {
        localGroups1.group_friend_count -= 1;
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null) {
        localGroups2.group_friend_count += 1;
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      atmr localatmr = this.jdField_a_of_type_Atmp.a();
      paramString = localatmr;
      localObject = localatmr;
      localatmr.a();
      paramString = localatmr;
      localObject = localatmr;
      a(localFriends);
      if ((i1 >= 0) && (localGroups1 != null))
      {
        paramString = localatmr;
        localObject = localatmr;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localatmr;
        localObject = localatmr;
        a(localGroups2);
      }
      paramString = localatmr;
      localObject = localatmr;
      localatmr.c();
      if (localatmr != null) {
        localatmr.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label239;
      }
      ((atmr)localObject).b();
    }
    a();
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    Friends localFriends;
    if (paramGetOnlineInfoResp != null)
    {
      localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localFriends != null) {
        break label21;
      }
    }
    label21:
    do
    {
      for (;;)
      {
        return;
        localFriends.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
        localFriends.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
        localFriends.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
        localFriends.eNetwork = paramGetOnlineInfoResp.eNetworkType;
        localFriends.netTypeIconId = paramGetOnlineInfoResp.eIconType;
        localFriends.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
        localFriends.uExtOnlineStatus = paramGetOnlineInfoResp.uExtOnlineStatus;
        localFriends.iBatteryStatus = paramGetOnlineInfoResp.iBatteryStatus;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, new Object[] { "updateOnlineStatus uin:", paramString, " extOnline:", Long.valueOf(paramGetOnlineInfoResp.uExtOnlineStatus), " battery:", Integer.valueOf(paramGetOnlineInfoResp.iBatteryStatus) });
        }
        CustomOnlineStatusPb.CustomOnlineStatusMsg localCustomOnlineStatusMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
        try
        {
          banc.a().a(paramString);
          localCustomOnlineStatusMsg.mergeFrom(paramGetOnlineInfoResp.strCustomOnlineStatusDesc.getBytes());
          localFriends.customOnlineStatusType = bane.b(localCustomOnlineStatusMsg);
          localFriends.customOnlineStatus = bane.a(localCustomOnlineStatusMsg);
          localFriends.customModel = bane.b(localCustomOnlineStatusMsg);
          if (QLog.isDevelopLevel())
          {
            QLog.d("CustomOnlineStatusManager", 4, "updateOnlineStatus : customOnlineStatusType = " + localFriends.customOnlineStatusType + " customOnlineStatus = " + localFriends.customOnlineStatus);
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("CustomOnlineStatusManager", 2, paramString, new Object[0]);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = d(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_Atmp.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    if (paramByte != -1) {
      localNearbyPeopleCard1.gender = paramByte;
    }
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte1, short paramShort, byte paramByte2)
  {
    byte b1 = 1;
    if ((mqb.a(paramByte1)) && (!bcpn.b(paramByte1))) {
      return;
    }
    paramString1 = d(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.", 2, "saveFriendInfoByUin uin=" + paramString1.uin + ", cSpecialFlag=" + paramString1.cSpecialFlag);
    }
    paramString1.name = paramString2;
    if (paramShort == 0) {
      paramByte1 = b1;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ajgh.a(paramString1);
      a(paramString1);
      return;
      if (paramShort == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).notifyUI(105, paramBoolean, paramString);
      }
      return;
      if (a().contains(paramString))
      {
        a().edit().remove(paramString).commit();
        i1 = 1;
      }
    }
  }
  
  public void a(ArrayList<SimpleOnlineFriendInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Object localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append("updateOnlineStatus size:").append(paramArrayList.size()).append("\n");
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject2 = (SimpleOnlineFriendInfo)paramArrayList.next();
        String str = String.valueOf(((SimpleOnlineFriendInfo)localObject2).friendUin);
        Friends localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localFriends != null)
        {
          localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject2).detalStatusFlag;
          localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject2).iTermType;
          localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject2).uAbiFlag;
          localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject2).eNetworkType;
          localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject2).eIconType;
          localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject2).strTermDesc;
          localFriends.iBatteryStatus = ((SimpleOnlineFriendInfo)localObject2).iBatteryStatus;
          localFriends.uExtOnlineStatus = ((SimpleOnlineFriendInfo)localObject2).uExtOnlineStatus;
          ((StringBuilder)localObject1).append("uin:").append(str).append(" battery:").append(((SimpleOnlineFriendInfo)localObject2).iBatteryStatus).append(" extOnline:").append(((SimpleOnlineFriendInfo)localObject2).uExtOnlineStatus).append("\n");
          localHashMap.put(str, Boolean.TRUE);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, ((StringBuilder)localObject1).toString());
      }
      paramArrayList = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public void a(@NonNull ArrayList<Friends> paramArrayList, int paramInt)
  {
    Object localObject2;
    Friends localFriends;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(paramArrayList.size() * 12 + 48);
      ((StringBuilder)localObject1).append("saveGatherList size=").append(paramArrayList.size()).append(" startIndex=").append(paramInt).append(" uin=");
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localFriends = (Friends)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localFriends.uin + ",");
      }
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    Object localObject1 = this.jdField_a_of_type_Atmp.a();
    try
    {
      ((atmr)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1)
          {
            localFriends.gathtertype = 0;
            a(localFriends);
          }
        }
      }
    }
    catch (Exception paramArrayList)
    {
      QLog.e("Q.contacttab.", 1, "saveGatherList", paramArrayList);
      return;
      this.t = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
          this.t += 1;
        }
      }
    }
    finally
    {
      ((atmr)localObject1).b();
    }
    ((atmr)localObject1).b();
  }
  
  public void a(List<String> paramList)
  {
    beoj.a("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i1 = 1;
      while (i1 < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i1 += 1;
      }
      paramList = this.jdField_a_of_type_Atmp.a(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
          bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject);
        }
      }
    }
    beoj.a();
  }
  
  public void a(List<SpecialCareInfo> paramList, long paramLong, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramList != null) {}
    for (int i1 = paramList.size();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + i1 + ", " + paramLong + ", " + paramBoolean);
      }
      int i2;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap;
        i2 = 0;
        for (;;)
        {
          if (i2 < i1) {}
          Iterator localIterator;
          try
          {
            this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(((SpecialCareInfo)paramList.get(i2)).uin, paramList.get(i2));
            i2 += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.jdField_a_of_type_Atmp.a();
      try
      {
        ((atmr)localObject).a();
        i2 = i3;
        while (i2 < i1)
        {
          a((atmo)paramList.get(i2));
          i2 += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          i1 = this.jdField_a_of_type_Atmp.a(paramList, "dateTime<" + paramLong, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.", 2, "syncSpecialCareInfos delete from table " + paramList + " ret = " + i1);
          }
        }
        ((atmr)localObject).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((atmr)localObject).b();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("show_vip_red_name", paramBoolean).commit();
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    this.jdField_f_of_type_Boolean = paramBoolean1;
    this.jdField_g_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.jdField_g_of_type_Int = paramInt5;
    this.jdField_h_of_type_Int = paramInt6;
    this.jdField_i_of_type_Int = paramInt7;
    this.j = paramInt8;
    this.k = paramInt11;
    this.l = paramInt9;
    this.m = paramInt10;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +278 -> 282
    //   7: aload_2
    //   8: ifnull +274 -> 282
    //   11: aconst_null
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   18: invokevirtual 591	atmp:a	()Latmr;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 833	atmr:a	()V
    //   32: new 819	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 820	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 1223
    //   52: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +218 -> 283
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_1
    //   73: iload 5
    //   75: baload
    //   76: invokestatic 499	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 853	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 1225
    //   101: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 828	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 1227
    //   126: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 828	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 1229
    //   156: invokevirtual 825	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +222 -> 387
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 1232	com/tencent/mobileqq/data/Groups:seqid	B
    //   176: aload_2
    //   177: iload 5
    //   179: baload
    //   180: if_icmpne +9 -> 189
    //   183: iload_3
    //   184: istore 4
    //   186: goto +201 -> 387
    //   189: iload_3
    //   190: istore 4
    //   192: aload 8
    //   194: aload_2
    //   195: iload 5
    //   197: baload
    //   198: putfield 1232	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +171 -> 387
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 844
    //   235: iconst_2
    //   236: new 171	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1234
    //   246: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_2
    //   250: invokevirtual 1237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: ifnull +118 -> 381
    //   266: aload_1
    //   267: invokevirtual 850	atmr:b	()V
    //   270: iload_3
    //   271: istore 4
    //   273: iload 4
    //   275: ifeq +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 1239	ajjj:d	()V
    //   282: return
    //   283: iload_3
    //   284: istore 4
    //   286: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +18 -> 307
    //   292: iload_3
    //   293: istore 4
    //   295: ldc_w 844
    //   298: iconst_2
    //   299: aload 7
    //   301: invokevirtual 851	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   304: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iload_3
    //   308: istore 4
    //   310: aload 6
    //   312: invokevirtual 866	atmr:c	()V
    //   315: iload_3
    //   316: istore 4
    //   318: aload 6
    //   320: ifnull -47 -> 273
    //   323: aload 6
    //   325: invokevirtual 850	atmr:b	()V
    //   328: iload_3
    //   329: istore 4
    //   331: goto -58 -> 273
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 6
    //   338: aload 6
    //   340: ifnull +8 -> 348
    //   343: aload 6
    //   345: invokevirtual 850	atmr:b	()V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: goto -13 -> 338
    //   354: astore_2
    //   355: aload_1
    //   356: astore 6
    //   358: aload_2
    //   359: astore_1
    //   360: goto -22 -> 338
    //   363: astore_2
    //   364: iconst_0
    //   365: istore_3
    //   366: aload 6
    //   368: astore_1
    //   369: goto -143 -> 226
    //   372: astore_2
    //   373: aload 6
    //   375: astore_1
    //   376: iconst_0
    //   377: istore_3
    //   378: goto -152 -> 226
    //   381: iload_3
    //   382: istore 4
    //   384: goto -111 -> 273
    //   387: iload 5
    //   389: iconst_1
    //   390: iadd
    //   391: istore 5
    //   393: iload 4
    //   395: istore_3
    //   396: goto -338 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	ajjj
    //   0	399	1	paramArrayOfByte1	byte[]
    //   0	399	2	paramArrayOfByte2	byte[]
    //   57	339	3	i1	int
    //   59	335	4	i2	int
    //   1	391	5	i3	int
    //   12	362	6	localObject1	Object
    //   21	279	7	localObject2	Object
    //   82	126	8	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   61	68	219	java/lang/Exception
    //   71	84	219	java/lang/Exception
    //   87	93	219	java/lang/Exception
    //   96	105	219	java/lang/Exception
    //   108	118	219	java/lang/Exception
    //   121	130	219	java/lang/Exception
    //   133	143	219	java/lang/Exception
    //   151	160	219	java/lang/Exception
    //   171	183	219	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   206	213	219	java/lang/Exception
    //   286	292	219	java/lang/Exception
    //   295	307	219	java/lang/Exception
    //   310	315	219	java/lang/Exception
    //   14	23	334	finally
    //   27	56	350	finally
    //   61	68	350	finally
    //   71	84	350	finally
    //   87	93	350	finally
    //   96	105	350	finally
    //   108	118	350	finally
    //   121	130	350	finally
    //   133	143	350	finally
    //   151	160	350	finally
    //   171	183	350	finally
    //   192	201	350	finally
    //   206	213	350	finally
    //   286	292	350	finally
    //   295	307	350	finally
    //   310	315	350	finally
    //   226	262	354	finally
    //   14	23	363	java/lang/Exception
    //   27	56	372	java/lang/Exception
  }
  
  public void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    int i2;
    atmr localatmr;
    long l1;
    label120:
    int i1;
    if (paramArrayOfFriends != null)
    {
      i2 = paramArrayOfFriends.length;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + i2 + ", " + paramLong + ", " + paramBoolean);
      }
      localatmr = this.jdField_a_of_type_Atmp.a();
      l1 = 0L;
      for (;;)
      {
        try
        {
          if (awrn.a(11)) {
            l1 = SystemClock.uptimeMillis();
          }
          localatmr.a();
          if (l1 == 0L) {
            break label365;
          }
          a(SystemClock.uptimeMillis() - l1, false, "trans", "Friends");
        }
        catch (Exception localException)
        {
          Iterator localIterator;
          localException.printStackTrace();
          localatmr.b();
          continue;
        }
        finally
        {
          localatmr.b();
        }
        if (i1 < i2)
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[i1].uin, paramArrayOfFriends[i1]);
          a(paramArrayOfFriends[i1]);
          i1 += 1;
        }
        else if (paramBoolean)
        {
          i1 = 0;
          localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        }
      }
    }
    label362:
    label365:
    label377:
    for (;;)
    {
      Friends localFriends;
      if (localIterator.hasNext())
      {
        localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
        if (!localFriends.isFriend()) {
          break label362;
        }
        i1 += 1;
      }
      for (;;)
      {
        if ((localFriends.datetime < paramLong) && (localFriends.isFriend()))
        {
          localIterator.remove();
          l1 = 0L;
          if (awrn.a(10)) {
            l1 = SystemClock.uptimeMillis();
          }
          this.jdField_a_of_type_Atmp.b(localFriends);
          if (l1 != 0L)
          {
            a(SystemClock.uptimeMillis() - l1, true, "delete", "Friends");
            break label377;
            c(i1);
            localatmr.c();
            localatmr.b();
            if (i2 > 0) {
              a(paramArrayOfFriends);
            }
            a();
            return;
            continue;
            i1 = 0;
            break label120;
            i2 = -1;
            break;
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 171	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1255
    //   16: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_3
    //   20: aload_1
    //   21: ifnull +31 -> 52
    //   24: aload_1
    //   25: arraylength
    //   26: istore_2
    //   27: ldc_w 332
    //   30: iconst_2
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +8 -> 51
    //   46: aload_1
    //   47: arraylength
    //   48: ifne +9 -> 57
    //   51: return
    //   52: iconst_m1
    //   53: istore_2
    //   54: goto -27 -> 27
    //   57: new 268	java/util/ArrayList
    //   60: dup
    //   61: aload_1
    //   62: arraylength
    //   63: invokespecial 772	java/util/ArrayList:<init>	(I)V
    //   66: astore 4
    //   68: new 53	java/util/concurrent/ConcurrentHashMap
    //   71: dup
    //   72: aload_1
    //   73: arraylength
    //   74: invokespecial 56	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   77: astore 5
    //   79: aload_0
    //   80: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   83: invokevirtual 591	atmp:a	()Latmr;
    //   86: astore_3
    //   87: aload_3
    //   88: invokevirtual 833	atmr:a	()V
    //   91: iconst_0
    //   92: istore_2
    //   93: iload_2
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge +61 -> 157
    //   99: aload 5
    //   101: new 171	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: iload_2
    //   110: aaload
    //   111: getfield 283	com/tencent/mobileqq/data/Groups:group_id	I
    //   114: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 262
    //   120: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aload_1
    //   127: iload_2
    //   128: aaload
    //   129: invokevirtual 273	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload 4
    //   135: aload_1
    //   136: iload_2
    //   137: aaload
    //   138: invokevirtual 299	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: aload_0
    //   143: aload_1
    //   144: iload_2
    //   145: aaload
    //   146: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   149: pop
    //   150: iload_2
    //   151: iconst_1
    //   152: iadd
    //   153: istore_2
    //   154: goto -61 -> 93
    //   157: aload_1
    //   158: arraylength
    //   159: iconst_1
    //   160: if_icmple +11 -> 171
    //   163: aload 4
    //   165: getstatic 807	ajgh:a	Ljava/util/Comparator;
    //   168: invokestatic 813	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   171: aload_0
    //   172: getfield 434	ajjj:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   175: ifnull +114 -> 289
    //   178: aload_0
    //   179: getfield 434	ajjj:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   182: invokevirtual 214	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   185: invokeinterface 220 1 0
    //   190: astore_1
    //   191: aload_1
    //   192: invokeinterface 225 1 0
    //   197: ifeq +92 -> 289
    //   200: aload_1
    //   201: invokeinterface 229 1 0
    //   206: checkcast 231	java/util/Map$Entry
    //   209: astore 6
    //   211: aload 5
    //   213: aload 6
    //   215: invokeinterface 1258 1 0
    //   220: checkcast 246	java/lang/String
    //   223: invokevirtual 721	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   226: ifne -35 -> 191
    //   229: aload_0
    //   230: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   233: aload 6
    //   235: invokeinterface 234 1 0
    //   240: checkcast 278	atmo
    //   243: invokevirtual 864	atmp:b	(Latmo;)Z
    //   246: pop
    //   247: goto -56 -> 191
    //   250: astore_1
    //   251: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +14 -> 268
    //   257: ldc_w 844
    //   260: iconst_2
    //   261: ldc_w 1260
    //   264: aload_1
    //   265: invokestatic 848	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: aload_3
    //   269: invokevirtual 850	atmr:b	()V
    //   272: aload_0
    //   273: aload 4
    //   275: putfield 275	ajjj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   278: aload_0
    //   279: aload 5
    //   281: putfield 434	ajjj:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   284: aload_0
    //   285: invokevirtual 481	ajjj:a	()V
    //   288: return
    //   289: aload_3
    //   290: invokevirtual 866	atmr:c	()V
    //   293: aload_3
    //   294: invokevirtual 850	atmr:b	()V
    //   297: goto -25 -> 272
    //   300: astore_1
    //   301: aload_3
    //   302: invokevirtual 850	atmr:b	()V
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	ajjj
    //   0	307	1	paramArrayOfGroups	Groups[]
    //   26	128	2	i1	int
    //   19	283	3	localObject	Object
    //   66	208	4	localArrayList	ArrayList
    //   77	203	5	localConcurrentHashMap	ConcurrentHashMap
    //   209	25	6	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   87	91	250	java/lang/Exception
    //   93	150	250	java/lang/Exception
    //   157	171	250	java/lang/Exception
    //   171	191	250	java/lang/Exception
    //   191	247	250	java/lang/Exception
    //   289	293	250	java/lang/Exception
    //   87	91	300	finally
    //   93	150	300	finally
    //   157	171	300	finally
    //   171	191	300	finally
    //   191	247	300	finally
    //   251	268	300	finally
    //   289	293	300	finally
  }
  
  public boolean a()
  {
    boolean bool = b();
    g();
    this.jdField_f_of_type_Boolean = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_g_of_type_Boolean = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
    a(baig.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    g("buildFriends");
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt != 0) || (this.jdField_f_of_type_Boolean))
    {
      bool1 = bool2;
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (this.jdField_g_of_type_Boolean) {}
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_Q.contacttab.", 2, "isEnableChatDays|config close, type=" + paramInt);
      }
      bool1 = false;
    }
    return bool1;
  }
  
  protected boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Atmp.a()) {
      if (paramatmo.getStatus() == 1000)
      {
        this.jdField_a_of_type_Atmp.b(paramatmo);
        if (paramatmo.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramatmo.getStatus() == 1001) || (paramatmo.getStatus() == 1002)) {
        return this.jdField_a_of_type_Atmp.a(paramatmo);
      }
    }
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramatmo.getTableName());
    return false;
  }
  
  public boolean a(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    if (QLog.isDevelopLevel()) {}
    for (;;)
    {
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache)
      {
        Card localCard = (Card)this.jdField_b_of_type_AndroidSupportV4UtilMQLruCache.get(paramCard.uin);
        if (localCard != paramCard) {
          QLog.i("Q.contacttab.", 4, String.format(Locale.getDefault(), "saveCard uin=%s cacheOne=%s card=%s", new Object[] { paramCard.uin, localCard, paramCard }));
        }
        if (awrn.a(9))
        {
          l1 = SystemClock.uptimeMillis();
          boolean bool = a(paramCard);
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "update", "Card");
          }
          return bool;
        }
      }
      long l1 = 0L;
    }
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  public boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Atmp.a()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_Atmp.a(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.jdField_a_of_type_Atmp.a(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_Atmp.a(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
    return this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +50 -> 56
    //   9: ldc_w 844
    //   12: iconst_2
    //   13: new 171	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1303
    //   23: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 325
    //   33: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 325
    //   43: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokevirtual 657	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   60: invokevirtual 591	atmp:a	()Latmr;
    //   63: astore 8
    //   65: aload 8
    //   67: astore 9
    //   69: aload 8
    //   71: invokevirtual 833	atmr:a	()V
    //   74: aload 8
    //   76: astore 9
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 706	ajjj:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   83: astore 10
    //   85: aload 8
    //   87: astore 9
    //   89: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +48 -> 140
    //   95: aload 8
    //   97: astore 9
    //   99: ldc_w 1145
    //   102: iconst_2
    //   103: new 171	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 1305
    //   113: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 1307
    //   123: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 10
    //   128: getfield 240	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   131: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 8
    //   142: astore 9
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 1309	ajjj:a	(Ljava/lang/String;)Z
    //   149: ifeq +12 -> 161
    //   152: aload 8
    //   154: astore 9
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual 1311	ajjj:c	(Ljava/lang/String;)V
    //   161: aload 8
    //   163: astore 9
    //   165: aload 10
    //   167: getfield 257	com/tencent/mobileqq/data/Friends:groupid	I
    //   170: iconst_m1
    //   171: if_icmpne +274 -> 445
    //   174: aload 8
    //   176: astore 9
    //   178: aload 10
    //   180: iload_2
    //   181: putfield 257	com/tencent/mobileqq/data/Friends:groupid	I
    //   184: iconst_m1
    //   185: istore 5
    //   187: iconst_1
    //   188: istore 7
    //   190: aload 8
    //   192: astore 9
    //   194: aload 10
    //   196: invokestatic 714	java/lang/System:currentTimeMillis	()J
    //   199: putfield 718	com/tencent/mobileqq/data/Friends:datetime	J
    //   202: iload_3
    //   203: ifeq +98 -> 301
    //   206: aload 8
    //   208: astore 9
    //   210: aload 10
    //   212: iconst_1
    //   213: putfield 240	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   216: aload 8
    //   218: astore 9
    //   220: aload 10
    //   222: ldc_w 1312
    //   225: invokestatic 1316	ajjy:a	(I)Ljava/lang/String;
    //   228: putfield 1159	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   231: aload 8
    //   233: astore 9
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 334	ajjj:t	I
    //   240: iconst_1
    //   241: iadd
    //   242: putfield 334	ajjj:t	I
    //   245: aload 8
    //   247: astore 9
    //   249: aload_0
    //   250: aload 10
    //   252: getfield 401	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   255: invokevirtual 1318	ajjj:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   258: astore_1
    //   259: aload_1
    //   260: ifnull +41 -> 301
    //   263: aload 8
    //   265: astore 9
    //   267: aload_1
    //   268: getfield 635	com/tencent/mobileqq/data/Card:shGender	S
    //   271: ifne +201 -> 472
    //   274: iconst_1
    //   275: istore 4
    //   277: aload 8
    //   279: astore 9
    //   281: aload 10
    //   283: iload 4
    //   285: putfield 1078	com/tencent/mobileqq/data/Friends:gender	B
    //   288: aload 8
    //   290: astore 9
    //   292: aload 10
    //   294: aload_1
    //   295: getfield 1320	com/tencent/mobileqq/data/Card:age	B
    //   298: putfield 1081	com/tencent/mobileqq/data/Friends:age	I
    //   301: aload 8
    //   303: astore 9
    //   305: aload_0
    //   306: aload 10
    //   308: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   311: pop
    //   312: aload 8
    //   314: astore 9
    //   316: aload_0
    //   317: iload_2
    //   318: invokestatic 499	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   321: invokevirtual 853	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +30 -> 356
    //   329: aload 8
    //   331: astore 9
    //   333: aload_1
    //   334: aload_1
    //   335: getfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   338: iconst_1
    //   339: iadd
    //   340: putfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   343: aload 8
    //   345: astore 9
    //   347: aload_0
    //   348: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   351: aload_1
    //   352: invokevirtual 881	atmp:a	(Latmo;)Z
    //   355: pop
    //   356: iload 7
    //   358: ifne +56 -> 414
    //   361: iload 5
    //   363: iflt +51 -> 414
    //   366: iload 5
    //   368: iload_2
    //   369: if_icmpeq +45 -> 414
    //   372: aload 8
    //   374: astore 9
    //   376: aload_0
    //   377: iload 5
    //   379: invokestatic 499	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   382: invokevirtual 853	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   385: astore_1
    //   386: aload_1
    //   387: ifnull +27 -> 414
    //   390: aload 8
    //   392: astore 9
    //   394: aload_1
    //   395: aload_1
    //   396: getfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   399: iconst_1
    //   400: isub
    //   401: putfield 286	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   404: aload 8
    //   406: astore 9
    //   408: aload_0
    //   409: aload_1
    //   410: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   413: pop
    //   414: aload 8
    //   416: astore 9
    //   418: aload 8
    //   420: invokevirtual 866	atmr:c	()V
    //   423: iload 7
    //   425: istore_3
    //   426: aload 8
    //   428: ifnull +11 -> 439
    //   431: aload 8
    //   433: invokevirtual 850	atmr:b	()V
    //   436: iload 7
    //   438: istore_3
    //   439: aload_0
    //   440: invokevirtual 481	ajjj:a	()V
    //   443: iload_3
    //   444: ireturn
    //   445: aload 8
    //   447: astore 9
    //   449: aload 10
    //   451: getfield 257	com/tencent/mobileqq/data/Friends:groupid	I
    //   454: istore 5
    //   456: aload 8
    //   458: astore 9
    //   460: aload 10
    //   462: iload_2
    //   463: putfield 257	com/tencent/mobileqq/data/Friends:groupid	I
    //   466: iconst_0
    //   467: istore 7
    //   469: goto -279 -> 190
    //   472: aload 8
    //   474: astore 9
    //   476: aload_1
    //   477: getfield 635	com/tencent/mobileqq/data/Card:shGender	S
    //   480: istore 6
    //   482: iload 6
    //   484: iconst_1
    //   485: if_icmpne -208 -> 277
    //   488: iconst_2
    //   489: istore 4
    //   491: goto -214 -> 277
    //   494: astore_1
    //   495: aconst_null
    //   496: astore 8
    //   498: iconst_0
    //   499: istore 7
    //   501: aload 8
    //   503: astore 9
    //   505: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +18 -> 526
    //   511: aload 8
    //   513: astore 9
    //   515: ldc_w 844
    //   518: iconst_2
    //   519: ldc_w 1322
    //   522: aload_1
    //   523: invokestatic 848	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   526: iload 7
    //   528: istore_3
    //   529: aload 8
    //   531: ifnull -92 -> 439
    //   534: aload 8
    //   536: invokevirtual 850	atmr:b	()V
    //   539: iload 7
    //   541: istore_3
    //   542: goto -103 -> 439
    //   545: astore_1
    //   546: aconst_null
    //   547: astore 9
    //   549: aload 9
    //   551: ifnull +8 -> 559
    //   554: aload 9
    //   556: invokevirtual 850	atmr:b	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_1
    //   562: goto -13 -> 549
    //   565: astore_1
    //   566: iconst_0
    //   567: istore 7
    //   569: goto -68 -> 501
    //   572: astore_1
    //   573: goto -72 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	ajjj
    //   0	576	1	paramString	String
    //   0	576	2	paramInt	int
    //   0	576	3	paramBoolean	boolean
    //   1	489	4	b1	byte
    //   185	270	5	i1	int
    //   480	6	6	i2	int
    //   188	380	7	bool	boolean
    //   63	472	8	localatmr1	atmr
    //   67	488	9	localatmr2	atmr
    //   83	378	10	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   56	65	494	java/lang/Exception
    //   56	65	545	finally
    //   69	74	561	finally
    //   78	85	561	finally
    //   89	95	561	finally
    //   99	140	561	finally
    //   144	152	561	finally
    //   156	161	561	finally
    //   165	174	561	finally
    //   178	184	561	finally
    //   194	202	561	finally
    //   210	216	561	finally
    //   220	231	561	finally
    //   235	245	561	finally
    //   249	259	561	finally
    //   267	274	561	finally
    //   281	288	561	finally
    //   292	301	561	finally
    //   305	312	561	finally
    //   316	325	561	finally
    //   333	343	561	finally
    //   347	356	561	finally
    //   376	386	561	finally
    //   394	404	561	finally
    //   408	414	561	finally
    //   418	423	561	finally
    //   449	456	561	finally
    //   460	466	561	finally
    //   476	482	561	finally
    //   505	511	561	finally
    //   515	526	561	finally
    //   69	74	565	java/lang/Exception
    //   78	85	565	java/lang/Exception
    //   89	95	565	java/lang/Exception
    //   99	140	565	java/lang/Exception
    //   144	152	565	java/lang/Exception
    //   156	161	565	java/lang/Exception
    //   165	174	565	java/lang/Exception
    //   178	184	565	java/lang/Exception
    //   449	456	565	java/lang/Exception
    //   460	466	565	java/lang/Exception
    //   194	202	572	java/lang/Exception
    //   210	216	572	java/lang/Exception
    //   220	231	572	java/lang/Exception
    //   235	245	572	java/lang/Exception
    //   249	259	572	java/lang/Exception
    //   267	274	572	java/lang/Exception
    //   281	288	572	java/lang/Exception
    //   292	301	572	java/lang/Exception
    //   305	312	572	java/lang/Exception
    //   316	325	572	java/lang/Exception
    //   333	343	572	java/lang/Exception
    //   347	356	572	java/lang/Exception
    //   376	386	572	java/lang/Exception
    //   394	404	572	java/lang/Exception
    //   408	414	572	java/lang/Exception
    //   418	423	572	java/lang/Exception
    //   476	482	572	java/lang/Exception
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, false);
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      l2 = a().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = a().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = a().getLong(paramString.replace("+86", ""), 0L);
        }
      }
    } while (l2 == 0L);
    long l2 = System.currentTimeMillis() - l2;
    if (paramBoolean1) {}
    for (long l1 = 259200000L;; l1 = 500654080L)
    {
      if (paramBoolean2) {
        l1 = 86400000L;
      }
      if ((l2 <= 0L) || (l2 >= l1)) {
        break;
      }
      return true;
    }
    a().edit().remove(paramString).commit();
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = this.jdField_b_of_type_Boolean;
    if (this.q == -1)
    {
      if (!paramBoolean) {
        break label98;
      }
      ((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).p();
      paramBoolean = bool1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "getEnableReactive disableReactive" + paramBoolean + "IsDisableInteractive=" + this.q);
      }
      return paramBoolean;
      paramBoolean = bool2;
      if (this.q != 1)
      {
        paramBoolean = false;
        continue;
        label98:
        paramBoolean = bool1;
      }
    }
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    atmr localatmr = this.jdField_a_of_type_Atmp.a();
    try
    {
      localatmr.a();
      int i1 = 0;
      while (i1 < paramInt)
      {
        ajgh.a(paramArrayOfFriends[i1]);
        a(paramArrayOfFriends[i1]);
        i1 += 1;
      }
      localatmr.c();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localatmr.b();
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() - this.t;
  }
  
  public int b(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.detalStatusFlag;
    }
    return 10;
  }
  
  public Card b(String paramString)
  {
    return a(paramString, false);
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.jdField_a_of_type_Atmp.a(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.jdField_a_of_type_Atmp.a(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    if (!f(paramString)) {
      localObject = null;
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return localObject;
          localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_d_of_type_Boolean);
      localFriends = (Friends)this.jdField_a_of_type_Atmp.a(Friends.class, paramString);
      if (localFriends != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      }
      localObject = localFriends;
    } while (!QLog.isColorLevel());
    Object localObject = "findFriendEntifyFromCache from db uin = " + paramString + ",f=";
    if (localFriends == null) {}
    for (paramString = "null";; paramString = baip.e(localFriends.uin))
    {
      QLog.d("Q.contacttab.", 2, new Object[] { localObject, paramString });
      return localFriends;
    }
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = d(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ajgh.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  @UiThread
  public ArrayList<atmo> b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      ThreadManager.postImmediately(new FriendsManager.3(this), null, false);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<SpecialCareInfo> b()
  {
    List localList = a();
    if (localList != null) {
      Collections.sort(localList, new ajjl(this));
    }
    return localList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    Object localObject5;
    Object localObject3;
    if (!this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_e_of_type_Boolean) {
        return;
      }
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 100) {
        break label397;
      }
      localObject5 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      ??? = new StringBuilder(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() * 20);
      localObject3 = new ArrayList(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      while (((Iterator)localObject5).hasNext())
      {
        Friends localFriends = (Friends)((Map.Entry)((Iterator)localObject5).next()).getValue();
        if (localFriends.isFriend())
        {
          ((StringBuilder)???).append("uin=? or ");
          ((List)localObject3).add(localFriends.uin);
        }
      }
      if (((StringBuilder)???).length() <= 4) {
        break label394;
      }
      ??? = ((StringBuilder)???).delete(((StringBuilder)???).length() - 4, ((StringBuilder)???).length());
    }
    label171:
    label345:
    Object localObject2;
    label394:
    label397:
    for (??? = this.jdField_a_of_type_Atmp.a(ExtensionInfo.class, true, ((StringBuilder)???).toString(), (String[])((List)localObject3).toArray(new String[((List)localObject3).size()]), null, null, null, null);; localObject2 = null)
    {
      for (;;)
      {
        localObject3 = ???;
        if (??? == null) {}
        try
        {
          localObject3 = (ArrayList)this.jdField_a_of_type_Atmp.a(ExtensionInfo.class);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (ExtensionInfo)((Iterator)localObject3).next();
              if ((localObject5 != null) && (((ExtensionInfo)localObject5).uin != null) && (b(((ExtensionInfo)localObject5).uin))) {
                synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
                {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ExtensionInfo)localObject5).uin, localObject5);
                }
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            ArrayList localArrayList = new ArrayList(0);
            QLog.e("Q.contacttab.", 1, "initExtensionInfoCache error oom", localOutOfMemoryError);
          }
          i();
        }
        try
        {
          h();
          this.jdField_e_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size());
          return;
        }
        catch (Throwable localThrowable)
        {
          break label345;
        }
      }
      break label171;
    }
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void b(Friends paramFriends)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    a();
  }
  
  public void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      localatmr = this.jdField_a_of_type_Atmp.a();
      localObject1 = localatmr;
      localObject2 = localatmr;
      localatmr.a();
      localObject1 = localatmr;
      localObject2 = localatmr;
      paramString = d(paramString);
      localObject1 = localatmr;
      localObject2 = localatmr;
      if (paramString.groupid >= 0)
      {
        localObject1 = localatmr;
        localObject2 = localatmr;
        Groups localGroups = a(String.valueOf(paramString.groupid));
        if (localGroups != null)
        {
          localObject1 = localatmr;
          localObject2 = localatmr;
          localGroups.group_friend_count -= 1;
          localObject1 = localatmr;
          localObject2 = localatmr;
          a(localGroups);
        }
      }
      localObject1 = localatmr;
      localObject2 = localatmr;
      paramString.groupid = -1002;
      localObject1 = localatmr;
      localObject2 = localatmr;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.uin);
      localObject1 = localatmr;
      localObject2 = localatmr;
      a(paramString);
      localObject1 = localatmr;
      localObject2 = localatmr;
      localatmr.c();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        atmr localatmr;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          localObject1.b();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label286;
      }
      localObject2.b();
    }
    a();
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ajgh.a(paramString1);
    a(paramString1);
  }
  
  public void b(List<ExtensionInfo> arg1)
  {
    if ((??? == null) || (???.size() == 0)) {}
    for (;;)
    {
      return;
      if (???.size() == 1)
      {
        a((ExtensionInfo)???.get(0));
        return;
      }
      Object localObject1 = this.jdField_a_of_type_Atmp.a();
      ((atmr)localObject1).a();
      try
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo2 = (ExtensionInfo)localIterator.next();
          if (!TextUtils.isEmpty(localExtensionInfo2.uin)) {
            a(localExtensionInfo2);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.extension", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((atmr)localObject1).b();
        for (;;)
        {
          localObject1 = ???.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo1 = (ExtensionInfo)((Iterator)localObject1).next();
            if ((!TextUtils.isEmpty(localExtensionInfo1.uin)) && (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
              synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
              {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localExtensionInfo1.uin, localExtensionInfo1);
              }
            }
          }
          localObject2.c();
          localObject2.b();
        }
      }
      finally
      {
        localObject2.b();
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_Atmp.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int i1;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label113:
    Friends localFriends;
    if (localObject2 != null)
    {
      i1 = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(i1);
      this.s = 0;
      this.r = 0;
      localStringBuilder = new StringBuilder();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label365;
      }
      localArrayList = new ArrayList();
      i1 = 0;
      if (i1 >= ((ArrayList)localObject2).size()) {
        break label296;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(i1);
      bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        ajgh.a(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.isFriend()) {
        this.r += 1;
      }
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label274;
      }
      this.s += 1;
    }
    for (;;)
    {
      i1 += 1;
      break label113;
      i1 = 0;
      break;
      label274:
      if (localFriends.gathtertype == 1) {
        this.t += 1;
      }
    }
    label296:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_Atmp.a();
      ((atmr)localObject2).a();
      i1 = 0;
    }
    try
    {
      while (i1 < localArrayList.size())
      {
        a((atmo)localArrayList.get(i1));
        i1 += 1;
      }
      ((atmr)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label365:
        ((atmr)localObject2).b();
      }
    }
    finally
    {
      ((atmr)localObject2).b();
    }
    localArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.s + " ; mGatheredCount = " + this.t + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_d_of_type_Boolean = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int c()
  {
    return this.t;
  }
  
  public Card c(String paramString)
  {
    return a(paramString, true);
  }
  
  public Friends c(String paramString)
  {
    if (!f(paramString)) {
      return null;
    }
    return (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList<atmo> c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      g();
      g("buildGroupList");
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_Atmp.a(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    paramString = d(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  /* Error */
  public void c(List<SpecialCareInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 789 1 0
    //   10: ifne +20 -> 30
    //   13: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +13 -> 29
    //   19: ldc_w 332
    //   22: iconst_2
    //   23: ldc_w 1455
    //   26: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokeinterface 789 1 0
    //   36: iconst_1
    //   37: if_icmpne +18 -> 55
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: invokeinterface 1189 2 0
    //   48: checkcast 755	com/tencent/mobileqq/data/SpecialCareInfo
    //   51: invokevirtual 1457	ajjj:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   54: return
    //   55: aload_0
    //   56: getfield 84	ajjj:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +73 -> 132
    //   62: aload_0
    //   63: getfield 84	ajjj:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_1
    //   70: invokeinterface 1180 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 225 1 0
    //   82: ifeq +48 -> 130
    //   85: aload_3
    //   86: invokeinterface 229 1 0
    //   91: checkcast 755	com/tencent/mobileqq/data/SpecialCareInfo
    //   94: astore 4
    //   96: aload 4
    //   98: getfield 897	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   101: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne -28 -> 76
    //   107: aload_0
    //   108: getfield 84	ajjj:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 4
    //   113: getfield 897	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   116: aload 4
    //   118: invokevirtual 273	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -46 -> 76
    //   125: astore_1
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   136: invokevirtual 591	atmp:a	()Latmr;
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 833	atmr:a	()V
    //   144: aload_1
    //   145: invokeinterface 1180 1 0
    //   150: astore_1
    //   151: aload_1
    //   152: invokeinterface 225 1 0
    //   157: ifeq +110 -> 267
    //   160: aload_1
    //   161: invokeinterface 229 1 0
    //   166: checkcast 755	com/tencent/mobileqq/data/SpecialCareInfo
    //   169: astore_3
    //   170: aload_3
    //   171: getfield 897	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   174: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne -26 -> 151
    //   180: aload_0
    //   181: aload_3
    //   182: invokevirtual 856	ajjj:a	(Latmo;)Z
    //   185: pop
    //   186: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -38 -> 151
    //   192: ldc_w 332
    //   195: iconst_2
    //   196: new 171	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 1459
    //   206: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 902	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   213: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -71 -> 151
    //   225: astore_1
    //   226: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +33 -> 262
    //   232: ldc_w 1418
    //   235: iconst_2
    //   236: new 171	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1461
    //   246: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 1237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_2
    //   263: invokevirtual 850	atmr:b	()V
    //   266: return
    //   267: aload_2
    //   268: invokevirtual 866	atmr:c	()V
    //   271: aload_2
    //   272: invokevirtual 850	atmr:b	()V
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: invokevirtual 850	atmr:b	()V
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	ajjj
    //   0	283	1	paramList	List<SpecialCareInfo>
    //   66	212	2	localObject1	Object
    //   75	135	3	localObject2	Object
    //   94	23	4	localSpecialCareInfo	SpecialCareInfo
    // Exception table:
    //   from	to	target	type
    //   69	76	125	finally
    //   76	122	125	finally
    //   126	128	125	finally
    //   130	132	125	finally
    //   144	151	225	java/lang/Exception
    //   151	222	225	java/lang/Exception
    //   267	271	225	java/lang/Exception
    //   144	151	276	finally
    //   151	222	276	finally
    //   226	262	276	finally
    //   267	271	276	finally
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
  }
  
  public boolean c(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int d()
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = ((ArrayList)localObject1).iterator();
    int i1;
    for (int i2 = 0; ((Iterator)localObject1).hasNext(); i2 = i1)
    {
      Object localObject2 = (Friends)((Iterator)localObject1).next();
      i1 = i2;
      if (((Friends)localObject2).isFriend())
      {
        localObject2 = a(((Friends)localObject2).uin);
        i1 = i2;
        if (localObject2 != null) {
          if ((((ExtensionInfo)localObject2).intimate_type != 1) && (((ExtensionInfo)localObject2).intimate_type != 2))
          {
            i1 = i2;
            if (((ExtensionInfo)localObject2).intimate_type != 3) {}
          }
          else
          {
            i2 += 1;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("\nuin:").append(((ExtensionInfo)localObject2).uin).append(" type:").append(((ExtensionInfo)localObject2).intimate_type).append(" level:").append(((ExtensionInfo)localObject2).intimate_level);
              i1 = i2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("\ncount:").append(i2);
      QLog.d("Q.contacttab.", 2, "getBindIntimateRelationshipFriendCount " + localStringBuilder.toString());
    }
    return i2;
  }
  
  public Friends d(String paramString)
  {
    Friends localFriends2 = e(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
      a(localFriends1);
    }
    return localFriends1;
  }
  
  public ArrayList<atmo> d()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    j();
    a();
  }
  
  public void d(String paramString)
  {
    Object localObject4 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject4 != null)
    {
      if (((Friends)localObject4).gathtertype != 2) {
        break label256;
      }
      this.s -= 1;
    }
    for (;;)
    {
      localObject2 = null;
      localObject1 = null;
      try
      {
        localatmr = this.jdField_a_of_type_Atmp.a();
        localObject1 = localatmr;
        localObject2 = localatmr;
        localatmr.a();
        Object localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localatmr;
          localObject2 = localatmr;
          localObject3 = (Friends)this.jdField_a_of_type_Atmp.a(Friends.class, paramString);
        }
        if (localObject3 != null)
        {
          localObject1 = localatmr;
          localObject2 = localatmr;
          localObject4 = a(String.valueOf(((Friends)localObject3).groupid));
          if (localObject4 != null)
          {
            localObject1 = localatmr;
            localObject2 = localatmr;
            ((Groups)localObject4).group_friend_count -= 1;
            localObject1 = localatmr;
            localObject2 = localatmr;
            a((atmo)localObject4);
          }
          localObject1 = localatmr;
          localObject2 = localatmr;
          this.jdField_a_of_type_Atmp.b((atmo)localObject3);
        }
        localObject1 = localatmr;
        localObject2 = localatmr;
        localatmr.c();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          atmr localatmr;
          localObject2 = localObject1;
          QLog.e("Q.contacttab.", 1, "", localException);
          if (localObject1 != null) {
            localObject1.b();
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        localObject2.b();
      }
      a();
      if (ahwj.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        ahwj.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (ahwj.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        ahwj.c(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      e(paramString);
      paramString = a(paramString);
      if (paramString != null)
      {
        paramString.removeAllMutualMark();
        a(paramString);
      }
      return;
      label256:
      if (((Friends)localObject4).gathtertype == 1) {
        this.t -= 1;
      }
    }
  }
  
  /* Error */
  public void d(List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 789 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 158	ajjj:jdField_a_of_type_Atmp	Latmp;
    //   18: invokevirtual 591	atmp:a	()Latmr;
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 833	atmr:a	()V
    //   26: aload_1
    //   27: invokeinterface 1180 1 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 225 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_1
    //   43: invokeinterface 229 1 0
    //   48: checkcast 246	java/lang/String
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 58	ajjj:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_3
    //   57: invokevirtual 266	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 236	com/tencent/mobileqq/data/Friends
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 240	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 836	ajjj:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 334	ajjj:t	I
    //   84: iconst_1
    //   85: isub
    //   86: putfield 334	ajjj:t	I
    //   89: goto -56 -> 33
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 1212	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 850	atmr:b	()V
    //   101: aload_0
    //   102: invokevirtual 481	ajjj:a	()V
    //   105: return
    //   106: aload_2
    //   107: invokevirtual 866	atmr:c	()V
    //   110: aload_2
    //   111: invokevirtual 850	atmr:b	()V
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 850	atmr:b	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ajjj
    //   0	124	1	paramList	List<String>
    //   21	98	2	localatmr	atmr
    //   51	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	92	java/lang/Exception
    //   33	64	92	java/lang/Exception
    //   68	89	92	java/lang/Exception
    //   106	110	92	java/lang/Exception
    //   22	33	117	finally
    //   33	64	117	finally
    //   68	89	117	finally
    //   93	97	117	finally
    //   106	110	117	finally
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean d(String paramString)
  {
    return a(paramString, false);
  }
  
  public Friends e(String paramString)
  {
    Object localObject2;
    if (!f(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (Friends)this.jdField_a_of_type_Atmp.a(Friends.class, paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.jdField_d_of_type_Boolean + " f=" + localObject2 + " uin=" + paramString);
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return localObject1;
  }
  
  public ArrayList<atmo> e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      j();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_h_of_type_Boolean;
        if (bool) {
          return;
        }
        long l1 = System.currentTimeMillis();
        try
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_Atmp.a(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
          if (!QLog.isColorLevel()) {
            break label215;
          }
          if (localArrayList == null)
          {
            i1 = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + i1);
            break label215;
            if (i1 >= localArrayList.size()) {
              continue;
            }
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(i1);
            if (localNearbyPeopleCard == null) {
              break label225;
            }
            a(localNearbyPeopleCard);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_Atmp.a(NearbyPeopleCard.class.getSimpleName());
          Object localObject1 = null;
          continue;
          i1 = localObject1.size();
          continue;
          this.jdField_h_of_type_Boolean = true;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l1));
        continue;
        if (localObject2 == null) {
          continue;
        }
      }
      finally {}
      label215:
      int i1 = 0;
      continue;
      label225:
      i1 += 1;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "deleteSpecialCareInfo: uin=" + paramString);
    }
    SpecialCareInfo localSpecialCareInfo = null;
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    for (;;)
    {
      synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localSpecialCareInfo = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localSpecialCareInfo != null) {
          break label147;
        }
        paramString = (SpecialCareInfo)this.jdField_a_of_type_Atmp.a(SpecialCareInfo.class, paramString);
        if (paramString != null)
        {
          if (!awrn.a(10)) {
            break label142;
          }
          l1 = SystemClock.uptimeMillis();
          this.jdField_a_of_type_Atmp.b(paramString);
          if (l1 != 0L) {
            a(SystemClock.uptimeMillis() - l1, false, "delete", "SpecialCare");
          }
        }
        return;
      }
      label142:
      long l1 = 0L;
      continue;
      label147:
      paramString = localSpecialCareInfo;
    }
  }
  
  public void e(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    atmr localatmr = this.jdField_a_of_type_Atmp.a();
    for (;;)
    {
      try
      {
        localatmr.a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject == null) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 2) {
          this.s -= 1;
        }
        if ((((Friends)localObject).gathtertype != 2) && (((Friends)localObject).gathtertype != 0)) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 0) {
          ((Friends)localObject).recommReason = ajjy.a(2131639148);
        }
        ((Friends)localObject).gathtertype = 1;
        localCard = b(((Friends)localObject).uin);
        if (localCard == null) {
          continue;
        }
        if (localCard.shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Card localCard;
        paramList.printStackTrace();
        localatmr.b();
        return;
        if (localCard.shGender != 1) {
          break label241;
        }
        b1 = 2;
        continue;
        localatmr.c();
        localatmr.b();
        continue;
      }
      finally
      {
        localatmr.b();
      }
      ((Friends)localObject).gender = b1;
      ((Friends)localObject).age = localCard.age;
      a((Friends)localObject);
      this.t += 1;
      continue;
      label241:
      byte b1 = 0;
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean e(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public ArrayList<atmo> f()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    akeu localakeu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localakeu.b(paramString, 0);
    if (localRecentUser == null)
    {
      localRecentUser = new RecentUser();
      localRecentUser.uin = paramString;
      localRecentUser.setType(0);
      localRecentUser.lastmsgtime = NetConnInfoCenter.getServerTime();
      paramString = localRecentUser;
    }
    for (;;)
    {
      paramString.lastmsgdrafttime = paramString.lastmsgtime;
      localakeu.a(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramString == null) {
        break;
      }
      paramString.sendEmptyMessage(1009);
      return;
      long l1 = NetConnInfoCenter.getServerTime();
      paramString = localRecentUser;
      if (localRecentUser.lastmsgtime < l1)
      {
        localRecentUser.lastmsgtime = l1;
        paramString = localRecentUser;
      }
    }
  }
  
  public void f(List<cmd0x7c4.RecommendReason> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("show_vip_red_name", true);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_Atmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajjj
 * JD-Core Version:    0.7.0.1
 */