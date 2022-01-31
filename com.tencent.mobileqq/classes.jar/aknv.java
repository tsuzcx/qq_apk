import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.icebreaking.IceBreakingMng.2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ImgInfo;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ReqBody;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.RspBody;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aknv
  implements amot, Handler.Callback, Manager
{
  public static final String a;
  public static boolean a;
  private float jdField_a_of_type_Float = 7.0F;
  public int a;
  ajxl jdField_a_of_type_Ajxl = new aknw(this);
  private akim jdField_a_of_type_Akim = new aknx(this);
  private bfmt jdField_a_of_type_Bfmt = new bfmt(ThreadManager.getFileThreadLooper(), this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<aknz> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int = 100;
  private String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private WeakReference<aknu> jdField_b_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 50;
  private String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private volatile String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131705689);
  }
  
  public aknv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("breaking_ice_config", this);
    this.jdField_a_of_type_Bfmt.sendEmptyMessage(0);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Akim, true);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean1)
    {
      bool1 = bool2;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(0)))
      {
        Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() == 0) {
            localIterator.remove();
          }
        }
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (!paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(1)))
      {
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        while (paramConcurrentHashMap.hasNext()) {
          if (((Integer)((Map.Entry)paramConcurrentHashMap.next()).getValue()).intValue() == 0) {
            paramConcurrentHashMap.remove();
          }
        }
        paramBoolean1 = true;
      }
    }
    return paramBoolean1;
  }
  
  private Object[] a(boolean paramBoolean, String paramString)
  {
    boolean bool8 = false;
    bool5 = false;
    boolean bool7 = false;
    bool4 = false;
    String str5 = jdField_a_of_type_JavaLangString;
    String str4 = jdField_a_of_type_JavaLangString;
    float f3 = 7.0F;
    boolean bool6 = false;
    bool3 = false;
    int i1 = 100;
    int n = 50;
    i3 = 60;
    Object localObject2 = paramString;
    if (!paramBoolean) {
      localObject2 = bbjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "breaking_ice_config");
    }
    i2 = i3;
    m = n;
    k = i1;
    f2 = f3;
    str3 = str4;
    String str2 = str5;
    i = n;
    j = i1;
    paramBoolean = bool6;
    f1 = f3;
    paramString = str4;
    str1 = str5;
    bool1 = bool7;
    bool2 = bool8;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool8;
        localObject2 = new JSONObject((String)localObject2);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool8;
        bool5 = ((JSONObject)localObject2).optBoolean("switchNewFrd", false);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool7;
        bool2 = bool5;
        bool4 = ((JSONObject)localObject2).optBoolean("switchOldFrd", false);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool4;
        bool2 = bool5;
        str2 = ((JSONObject)localObject2).optString("tipNewFrd", jdField_a_of_type_JavaLangString);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str4;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        str3 = ((JSONObject)localObject2).optString("tipOldFrd", jdField_a_of_type_JavaLangString);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f3;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        f2 = (float)((JSONObject)localObject2).optDouble("daysOldFrd", 7.0D);
        i = n;
        j = i1;
        paramBoolean = bool6;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        bool3 = ((JSONObject)localObject2).optBoolean("switchTroop", false);
        i = n;
        j = i1;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        k = ((JSONObject)localObject2).optInt("troopNumberCount", 100);
        i = n;
        j = k;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        m = ((JSONObject)localObject2).optInt("troopNumberNotFirendRate", 50);
        i = m;
        j = k;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        i2 = ((JSONObject)localObject2).optInt("showDuration", 60);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i2 = i3;
        m = i;
        k = j;
        bool3 = paramBoolean;
        f2 = f1;
        str3 = paramString;
        Object localObject1 = str1;
        bool4 = bool1;
        bool5 = bool2;
      }
    }
    return new Object[] { Boolean.valueOf(bool5), Boolean.valueOf(bool4), str2, str3, Float.valueOf(f2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2) };
  }
  
  private void f()
  {
    Object[] arrayOfObject = a(false, null);
    Object localObject1 = bbdj.a(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = bbdj.a(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = bbdj.a(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = bbdj.a(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((localObject1 != null) && ((localObject1 instanceof ConcurrentHashMap))) {}
    Object localObject6;
    for (localObject1 = (ConcurrentHashMap)localObject1;; localObject6 = null)
    {
      if (localObject1 == null) {
        localObject1 = new ConcurrentHashMap();
      }
      for (;;)
      {
        for (;;)
        {
          if (??? != null) {}
          synchronized (this.jdField_a_of_type_JavaUtilSet)
          {
            this.jdField_a_of_type_JavaUtilSet.addAll((Set)???);
            if (??? != null) {}
            synchronized (this.jdField_b_of_type_JavaUtilSet)
            {
              this.jdField_b_of_type_JavaUtilSet.addAll((Set)???);
              if (??? != null) {}
              synchronized (this.jdField_c_of_type_JavaUtilSet)
              {
                this.jdField_c_of_type_JavaUtilSet.addAll((Set)???);
                a(((Boolean)arrayOfObject[0]).booleanValue(), ((Boolean)arrayOfObject[1]).booleanValue(), (ConcurrentHashMap)localObject1);
              }
            }
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              if (localObject1 != null) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll((Map)localObject1);
              }
              this.jdField_c_of_type_Boolean = ((Boolean)arrayOfObject[0]).booleanValue();
              this.jdField_d_of_type_Boolean = ((Boolean)arrayOfObject[1]).booleanValue();
              this.jdField_b_of_type_JavaLangString = ((String)arrayOfObject[2]);
              this.jdField_c_of_type_JavaLangString = ((String)arrayOfObject[3]);
              this.jdField_a_of_type_Float = ((Float)arrayOfObject[4]).floatValue();
              this.e = ((Boolean)arrayOfObject[5]).booleanValue();
              this.jdField_b_of_type_Int = ((Integer)arrayOfObject[6]).intValue();
              this.jdField_c_of_type_Int = ((Integer)arrayOfObject[7]).intValue();
              this.jdField_a_of_type_Int = ((Integer)arrayOfObject[8]).intValue();
              this.jdField_b_of_type_Boolean = true;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("init IceBreak Config: mSwitchNewFrd: ").append(this.jdField_c_of_type_Boolean).append(",mSwitchOldFrd: ").append(this.jdField_d_of_type_Boolean).append(",mTipNewFrd: ").append(this.jdField_b_of_type_JavaLangString).append(",mTipOldFrd: ").append(this.jdField_c_of_type_JavaLangString).append(",mDaysOldFrd: ").append(this.jdField_a_of_type_Float).append(",switchTroop: ").append(this.e).append(",troopMemberMinCount: ").append(this.jdField_b_of_type_Int).append(",troopMemberNotFriendRate: ").append(this.jdField_c_of_type_Int).append(",showDuration: ").append(this.jdField_a_of_type_Int);
            QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject1).toString());
            return;
            localObject2 = finally;
            throw localObject2;
            localObject3 = finally;
            throw localObject3;
            localObject4 = finally;
            throw localObject4;
          }
        }
      }
    }
  }
  
  private void g()
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    bbdj.a(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localConcurrentHashMap);
  }
  
  private void j(String paramString)
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).c(paramString);
    if (localTroopInfo == null)
    {
      QLog.i("IceBreak.HotPic", 1, "troop info is null.");
      return;
    }
    int i;
    int j;
    if (localTroopInfo.wMemberNum < this.jdField_b_of_type_Int)
    {
      Object localObject2 = ((TroopManager)localObject1).b(paramString);
      if ((localObject2 == null) || (((List)localObject2).size() <= 1))
      {
        if (localObject2 == null) {}
        for (i = 0;; i = ((List)localObject2).size())
        {
          QLog.i("IceBreak.HotPic", 1, "troop member size: " + i);
          this.jdField_d_of_type_JavaLangString = paramString;
          ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).o(paramString);
          return;
        }
      }
      j = ((List)localObject2).size();
      localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      label183:
      if (((Iterator)localObject2).hasNext())
      {
        String str2 = ((TroopMemberInfo)((Iterator)localObject2).next()).memberuin;
        if ((TextUtils.isEmpty(str2)) || (str2.equals(str1)) || (((ajxn)localObject1).b(str2))) {
          break label318;
        }
        i += 1;
      }
    }
    label318:
    for (;;)
    {
      break label183;
      QLog.i("IceBreak.HotPic", 1, "noFriendCount: " + i + " total count: " + localTroopInfo.wMemberNum);
      if (1.0F * i / (j - 1) <= this.jdField_c_of_type_Int / 100.0F) {
        break;
      }
      e(paramString);
      return;
      e(paramString);
      return;
    }
  }
  
  public float a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    return this.jdField_a_of_type_Float;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = -1;
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (paramInt == 1)
    {
      paramString = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        paramInt = -1;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return paramInt;
          paramInt = paramString.intValue();
        }
        if (!akny.d(paramInt)) {
          break;
        }
        paramString = (Integer)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        paramInt = i;
      } while (paramString == null);
      return paramString.intValue();
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      paramInt = i;
    } while (paramString == null);
    return paramString.intValue();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeAllEnteredMatchChat ");
    }
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_c_of_type_JavaUtilSet.clear();
      d();
    }
  }
  
  public void a(aknu paramaknu)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramaknu);
  }
  
  public void a(aknz paramaknz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaknz);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, amos paramamos)
  {
    if ((paramamos != null) && ("breaking_ice_config".equals(paramString)))
    {
      if (!this.jdField_b_of_type_Boolean) {
        f();
      }
      paramQQAppInterface = a(true, paramamos.jdField_a_of_type_JavaLangString);
      boolean bool1 = ((Boolean)paramQQAppInterface[0]).booleanValue();
      boolean bool2 = ((Boolean)paramQQAppInterface[1]).booleanValue();
      this.jdField_b_of_type_JavaLangString = ((String)paramQQAppInterface[2]);
      this.jdField_c_of_type_JavaLangString = ((String)paramQQAppInterface[3]);
      this.jdField_a_of_type_Float = ((Float)paramQQAppInterface[4]).floatValue();
      this.e = ((Boolean)paramQQAppInterface[5]).booleanValue();
      this.jdField_b_of_type_Int = ((Integer)paramQQAppInterface[6]).intValue();
      this.jdField_c_of_type_Int = ((Integer)paramQQAppInterface[7]).intValue();
      this.jdField_a_of_type_Int = ((Integer)paramQQAppInterface[8]).intValue();
      if ((bool1 != this.jdField_c_of_type_Boolean) || (bool2 != this.jdField_d_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = ((Boolean)paramQQAppInterface[0]).booleanValue();
        this.jdField_d_of_type_Boolean = ((Boolean)paramQQAppInterface[1]).booleanValue();
        paramQQAppInterface = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        paramQQAppInterface.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        if (a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean, paramQQAppInterface))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramQQAppInterface);
          if (this.jdField_a_of_type_Bfmt.hasMessages(1)) {
            this.jdField_a_of_type_Bfmt.removeMessages(1);
          }
          this.jdField_a_of_type_Bfmt.sendEmptyMessage(1);
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onGetConfig: mSwitchNewFrd: ").append(this.jdField_c_of_type_Boolean).append(",mSwitchOldFrd: ").append(this.jdField_d_of_type_Boolean).append(",mTipNewFrd: ").append(this.jdField_b_of_type_JavaLangString).append(",mTipOldFrd: ").append(this.jdField_c_of_type_JavaLangString).append(",mDaysOldFrd: ").append(this.jdField_a_of_type_Float).append(",switchTroop: ").append(this.e).append(",troopMemberMinCount: ").append(this.jdField_b_of_type_Int).append(",troopMemberNotFriendRate: ").append(this.jdField_c_of_type_Int).append(",showDuration: ").append(this.jdField_a_of_type_Int);
        QLog.d("IceBreak.Mng", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeEnteredMatchChat " + paramString);
    }
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (this.jdField_c_of_type_JavaUtilSet.contains(paramString))
    {
      this.jdField_c_of_type_JavaUtilSet.remove(paramString);
      d();
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.Mng", 2, String.format("request HotPicList fromUin: %s, termType: %s, aioType: %s, toUin: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    try
    {
      IcebreakHotPic.ReqBody localReqBody = new IcebreakHotPic.ReqBody();
      localReqBody.setHasFlag(true);
      String str = paramString1 + SystemClock.uptimeMillis();
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      paramString1 = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramString1 != null) {
        localReqBody.uint32_age.set(paramString1.age);
      }
      for (;;)
      {
        paramString1 = localReqBody.toByteArray();
        paramString2 = ByteBuffer.allocate(paramString1.length + 4);
        paramString2.putInt(paramString1.length + 4).put(paramString1);
        paramString1 = paramString2.array();
        paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aexi.class);
        paramString2.putExtra("key_body", paramString1);
        paramString2.putExtra("key_cmd", "BreakIceSvr.Pull");
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.Mng", 2, "request HotPicList, sessionId = " + str);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
        return;
        localReqBody.uint32_age.set(0);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("IceBreak.Mng", 1, "request HotPicList exception", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a(paramBoolean)) {}
    label54:
    label185:
    for (;;)
    {
      return;
      Object localObject = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(paramString);
      boolean bool;
      int i;
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        bool = true;
        if (!bool) {
          break label178;
        }
        if (!paramBoolean) {
          break label173;
        }
        i = 0;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(i));
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((aknz)localObject).a(paramString, false);
          }
        }
        if (this.jdField_a_of_type_Bfmt.hasMessages(1)) {
          this.jdField_a_of_type_Bfmt.removeMessages(1);
        }
        this.jdField_a_of_type_Bfmt.sendEmptyMessage(1);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label185;
        }
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addToBreakingIceList uin: %s, ret: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        bool = false;
        break;
        i = 1;
        break label54;
        d(paramString);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new IcebreakHotPic.RspBody();
      ((IcebreakHotPic.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((IcebreakHotPic.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse response code error,result:" + ((IcebreakHotPic.RspBody)localObject).int32_result.get() + " message : " + ((IcebreakHotPic.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((IcebreakHotPic.RspBody)localObject).rpt_msg_img_info.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse imgInfos is null or empty");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("IceBreak.HotPic", 2, bfnd.a(paramArrayOfByte));
        return;
        localObject = new ArrayList();
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          IcebreakHotPic.ImgInfo localImgInfo = (IcebreakHotPic.ImgInfo)paramArrayOfByte.get(i);
          aewx localaewx = new aewx();
          localaewx.e(i);
          localaewx.a(localImgInfo.uint64_img_size.get());
          localaewx.a(localImgInfo.uint32_img_width.get());
          localaewx.b(localImgInfo.uint32_img_height.get());
          localaewx.d(localImgInfo.bytes_img_md5.get().toStringUtf8());
          localaewx.b(localImgInfo.bytes_img_down_url.get().toStringUtf8());
          localaewx.a(localImgInfo.bytes_img_word.get().toStringUtf8());
          localaewx.b(localImgInfo.uint64_thumb_size.get());
          localaewx.d(localImgInfo.uint32_thumb_img_height.get());
          localaewx.c(localImgInfo.uint32_thumb_img_width.get());
          localaewx.c(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
          localaewx.e(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
          ((List)localObject).add(localaewx);
          i += 1;
        }
        ThreadManager.getUIHandler().post(new IceBreakingMng.2(this, (List)localObject));
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse dateList size is: " + ((List)localObject).size());
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
    }
    if (paramBoolean) {
      return this.jdField_c_of_type_Boolean;
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_a_of_type_JavaUtilSet);
    bbdj.a(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void b(aknz paramaknz)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramaknz)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_b_of_type_JavaUtilSet);
    bbdj.a(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    return this.jdField_c_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_c_of_type_JavaUtilSet);
    bbdj.a(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        this.jdField_b_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        aknz localaknz = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localaknz != null) {
          localaknz.b(paramString, false);
        }
      }
      if (this.jdField_a_of_type_Bfmt.hasMessages(1)) {
        this.jdField_a_of_type_Bfmt.removeMessages(1);
      }
      this.jdField_a_of_type_Bfmt.sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", new Object[] { paramString, localObject }));
    }
    return localObject != null;
  }
  
  public void e()
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void e(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "insertTroopToBreakingIceMap troopUin: " + paramString);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aknz localaknz = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaknz != null) {
        localaknz.a(paramString, true);
      }
    }
  }
  
  public boolean e(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    boolean bool2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    boolean bool1 = bool2;
    if (bool2)
    {
      paramString = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(paramString);
      if ((paramString != null) && (paramString.isFriend())) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void f(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "removeTroopFromBreakingIceMap troopUin: " + paramString);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aknz localaknz = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaknz != null) {
        localaknz.b(paramString, true);
      }
    }
  }
  
  public void g(String paramString)
  {
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aknz localaknz = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaknz != null) {
        localaknz.b(paramString, false);
      }
    }
  }
  
  public void h(String paramString)
  {
    if (c(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + paramString);
      }
    }
    aknz localaknz;
    do
    {
      do
      {
        do
        {
          return;
          if (((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
        return;
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localaknz = (aknz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localaknz == null);
    localaknz.a(paramString, false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      g();
      continue;
      f();
    }
  }
  
  public void i(String paramString)
  {
    if (!aexd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
      }
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      return;
      if (b(paramString))
      {
        QLog.i("IceBreak.HotPic", 1, "entered toop.");
        return;
      }
      if (!this.e)
      {
        QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
        return;
      }
      localTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localTroopMemberInfo == null) || (localTroopMemberInfo.last_active_time == localTroopMemberInfo.join_time))
      {
        QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
        this.jdField_d_of_type_JavaLangString = paramString;
        ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(Long.valueOf(paramString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), true);
        return;
      }
      QLog.i("IceBreak.HotPic", 1, "last_active_time: " + localTroopMemberInfo.last_active_time + " join_time: " + localTroopMemberInfo.join_time);
    } while (localTroopMemberInfo.last_active_time > localTroopMemberInfo.join_time);
    j(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bfmt.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aknv
 * JD-Core Version:    0.7.0.1
 */