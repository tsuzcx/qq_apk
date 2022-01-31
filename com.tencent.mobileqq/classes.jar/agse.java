import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Locale;
import mqq.manager.AccountManager;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class agse
  implements aboo, alsn
{
  private final agsi jdField_a_of_type_Agsi = new agsi(null);
  private alsl jdField_a_of_type_Alsl;
  private alxo jdField_a_of_type_Alxo = new agsf(this);
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final agsi jdField_b_of_type_Agsi = new agsi(null);
  private boolean jdField_b_of_type_Boolean;
  private final agsi jdField_c_of_type_Agsi = new agsi(null);
  private boolean jdField_c_of_type_Boolean;
  private final agsi jdField_d_of_type_Agsi = new agsi(null);
  private boolean jdField_d_of_type_Boolean;
  private final agsi jdField_e_of_type_Agsi = new agsi(null);
  private boolean jdField_e_of_type_Boolean;
  private final agsi jdField_f_of_type_Agsi = new agsi(null);
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  public agse(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a(String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "canGetRoamMsg app is null");
      return 0;
    }
    if (localQQAppInterface.a().a(paramString))
    {
      if (localQQAppInterface.a(paramInt).a(paramString, paramInt) + paramArrayList.size() < 15)
      {
        QLog.d("C2CMsgRoamProxy", 1, "can't get roam msg");
        return 0;
      }
      localQQAppInterface.a().j(paramString);
      return 1;
    }
    return 2;
  }
  
  private Calendar a()
  {
    return this.jdField_a_of_type_Alsl.a();
  }
  
  @Nullable
  private List<ChatMessage> a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_Alsl.a();
      if (localObject != null) {
        break label87;
      }
    }
    label87:
    for (long l1 = 0L;; l1 = ((Calendar)localObject).getTimeInMillis())
    {
      QLog.d("C2CMsgRoamProxy", 2, "getHistorySync, current date: " + l1 + ", type: " + paramInt);
      b();
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList = null;
      if (!this.jdField_f_of_type_Boolean) {
        break;
      }
      QLog.w("C2CMsgRoamProxy", 1, "get roam msg canceled");
      return null;
    }
    if (this.jdField_a_of_type_Alsl.a() == null)
    {
      QLog.e("C2CMsgRoamProxy", 1, "current page date is null, show roam flag: " + this.jdField_a_of_type_Alsl.e());
      return null;
    }
    Object localObject = this.jdField_a_of_type_Alsl.a(paramInt);
    if ((localObject != null) && (((RoamMessagePreloadInfo)localObject).curday != null))
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Agsi.a();
      this.jdField_a_of_type_Alsl.a(((RoamMessagePreloadInfo)localObject).curday, null, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySig wait");
      }
      this.jdField_a_of_type_Agsi.a(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySync cost: " + (l2 - l1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Alsl.a();
      return this.jdField_a_of_type_JavaUtilList;
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "preload info is null");
      }
    }
  }
  
  @Nullable
  private List<ChatMessage> a(List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord)
  {
    Object localObject = a(1);
    if (localObject == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator2.next();
          if (abot.a(localMessageRecord, localChatMessage, true)) {
            localArrayList.add(localChatMessage);
          }
        }
      }
      ((List)localObject).removeAll(localArrayList);
      if ((((List)localObject).size() > 0) && (paramMessageRecord != null) && (aslq.a(paramMessageRecord)) && (((ChatMessage)((List)localObject).get(0)).time >= paramMessageRecord.time))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "roam msg is later than top revoke msg. revoke msg time: " + paramMessageRecord.time + ", top msg time: " + ((ChatMessage)((List)localObject).get(0)).time);
        }
        try
        {
          Thread.sleep(200L);
          localObject = new ArrayList((Collection)localObject);
          paramMessageRecord = a(paramList, paramLong, paramMessageRecord);
          paramList = (List<MessageRecord>)localObject;
          if (paramMessageRecord != null)
          {
            ((List)localObject).addAll(0, paramMessageRecord);
            return localObject;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
    }
    if ((((List)localObject).size() == 0) || ((paramLong != 0L) && (((ChatMessage)((List)localObject).get(0)).time >= paramLong)) || ((paramLong == 0L) && (paramMessageRecord != null) && (((ChatMessage)((List)localObject).get(0)).time >= paramMessageRecord.time)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("get duplicate msg, try again. break time: ").append(paramLong).append(", top msg time: ");
        if (((List)localObject).size() != 0) {
          break label427;
        }
        localObject = "";
      }
      for (;;)
      {
        QLog.d("C2CMsgRoamProxy", 2, localObject);
        try
        {
          Thread.sleep(200L);
          return a(paramList, paramLong, paramMessageRecord);
          label427:
          localObject = Long.valueOf(((ChatMessage)((List)localObject).get(0)).time);
        }
        catch (InterruptedException localInterruptedException1)
        {
          for (;;)
          {
            QLog.e("C2CMsgRoamProxy", 1, localInterruptedException1, new Object[0]);
          }
        }
      }
    }
    return localInterruptedException1;
  }
  
  private void a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    RoamDate localRoamDate = this.jdField_a_of_type_Alsl.a().a(this.jdField_a_of_type_JavaLangString, localCalendar.get(1), localCalendar.get(2) + 1);
    if (localRoamDate != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "update today's roam date");
      }
      localRoamDate.setLocState(localCalendar.get(5) - 1, paramInt);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (alsl)paramQQAppInterface.getManager(92);
    if (((paramQQAppInterface.d()) && (paramQQAppInterface.a() == 3)) || ((paramQQAppInterface.c()) && (paramQQAppInterface.a() == 2)) || ((paramQQAppInterface.c()) && ((paramQQAppInterface.a() == 0) || (paramQQAppInterface.a() == 1)))) {}
    while ((paramQQAppInterface.a() == 4) || (!this.jdField_d_of_type_Boolean) || (paramQQAppInterface.a() != 2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "query failed, continue");
    }
    paramQQAppInterface.g();
  }
  
  private void a(Calendar paramCalendar)
  {
    this.jdField_a_of_type_Alsl.a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Alsl.a();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      try
      {
        if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
        {
          if (localObject1 == null)
          {
            QLog.d("C2CMsgRoamProxy", 1, "init after destroy");
            return;
          }
          this.jdField_a_of_type_Alsl = ((alsl)((QQAppInterface)localObject1).getManager(92));
          this.jdField_a_of_type_Alsl.a(this.jdField_a_of_type_JavaLangString, false);
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
          this.jdField_a_of_type_Alsl.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Alsl.a();
          this.jdField_a_of_type_Boolean = true;
        }
        return;
      }
      finally {}
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_a_of_type_Alsl.b();
    boolean bool = this.jdField_a_of_type_Alsl.g();
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_Alsl.b();
      localObject2 = new StringBuilder().append("mode: ").append(j).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("C2CMsgRoamProxy", 2, i);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null) {
        break label153;
      }
      QLog.d("C2CMsgRoamProxy", 1, "checkDevAuthSync after destroy");
    }
    label153:
    do
    {
      return;
      i = localObject1.length;
      break;
      if (j != 1) {
        break label255;
      }
    } while (!paramBoolean1);
    if (this.jdField_a_of_type_Alsl.b() != null)
    {
      this.g = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("C2CMsgRoamProxy", 2, "devlock is open but no da2 ticket， refresh da2...");
    }
    Object localObject2 = (AccountManager)((QQAppInterface)localObject1).getManager(0);
    if (localObject2 != null)
    {
      this.jdField_f_of_type_Agsi.a();
      ((AccountManager)localObject2).refreshDA2(((QQAppInterface)localObject1).getCurrentAccountUin(), new agsh(this));
      this.jdField_f_of_type_Agsi.a(30000L);
      return;
    }
    this.g = false;
    return;
    label255:
    this.g = false;
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "isDevOpened");
    }
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = bdee.d(BaseApplication.getContext());
    c();
    boolean bool2 = this.jdField_a_of_type_Alsl.h();
    if ((!bool1) || (!bool2)) {
      return false;
    }
    if (!this.jdField_a_of_type_Alsl.f())
    {
      d();
      if (this.jdField_a_of_type_Alsl.f()) {
        c(false);
      }
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "isDevOpened cost: " + (l2 - l1) + ", ret: " + this.g);
      }
      return this.g;
      this.g = false;
      continue;
      c(false);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    paramObject = (List)paramObject;
    paramQQAppInterface = (alsl)paramQQAppInterface.getManager(92);
    if ((paramObject == null) || (paramObject.size() == 0))
    {
      if (((paramQQAppInterface.d()) && (paramQQAppInterface.a() == 3)) || ((paramQQAppInterface.c()) && (paramQQAppInterface.a() == 2)) || ((paramQQAppInterface.c()) && ((paramQQAppInterface.a() == 0) || (paramQQAppInterface.a() == 1)))) {
        return true;
      }
      if (paramQQAppInterface.a() != 4)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMsgRoamProxy", 2, "query success, continue");
          }
          paramQQAppInterface.g();
          return false;
        }
        return true;
      }
    }
    else
    {
      if (paramQQAppInterface.a() == 4) {}
      this.jdField_d_of_type_Boolean = false;
    }
    paramQQAppInterface.h();
    this.jdField_a_of_type_JavaUtilList = paramObject;
    return true;
  }
  
  private void b()
  {
    try
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_Alsl.b(hashCode());
        this.jdField_a_of_type_Alsl.a(this);
        this.jdField_e_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Alsl.c(true);
    long l1 = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Agsi.a();
    this.jdField_a_of_type_Alsl.a(paramBoolean);
    this.jdField_b_of_type_Agsi.a(30000L);
    a(3);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync cost: " + (l2 - l1) + ", result: " + this.jdField_c_of_type_Boolean);
    }
    this.jdField_a_of_type_Alsl.f();
    this.jdField_a_of_type_Alsl.c(this.jdField_c_of_type_Boolean);
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync");
    }
    boolean bool1;
    if (this.jdField_b_of_type_Boolean) {
      bool1 = this.jdField_c_of_type_Boolean;
    }
    long l1;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
        return bool1;
        b();
        l1 = SystemClock.uptimeMillis();
        bool3 = bdee.d(BaseApplication.getContext());
        c();
        bool4 = this.jdField_a_of_type_Alsl.h();
        bool1 = bool2;
      } while (!bool3);
      bool1 = bool2;
    } while (!bool4);
    b(false);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync cost: " + (l2 - l1));
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Alsl.i()) {}
    long l1;
    long l2;
    do
    {
      return;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localQQAppInterface == null)
      {
        QLog.d("C2CMsgRoamProxy", 1, "syncRoamType after destroy");
        return;
      }
      l1 = SystemClock.uptimeMillis();
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).addObserver(this.jdField_a_of_type_Alxo);
      bdpx localbdpx = (bdpx)localQQAppInterface.a(71);
      this.jdField_c_of_type_Agsi.a();
      localbdpx.a(new String[] { localQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
      this.jdField_c_of_type_Agsi.a();
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("C2CMsgRoamProxy", 2, "syncRoamType cost: " + (l2 - l1));
  }
  
  private void c(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramInt1) });
      }
      this.jdField_b_of_type_Agsi.b();
      return;
      if (paramInt2 == -1) {}
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        break;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131693126), 0).a();
      }
      this.jdField_c_of_type_Boolean = false;
      continue;
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "checkDevStatusSync");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevStatusOnlySync after destroy");
      return;
    }
    if (this.jdField_a_of_type_Alsl.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_e_of_type_Agsi.a();
    int[] arrayOfInt = new int[1];
    DevlockInfo[] arrayOfDevlockInfo = new DevlockInfo[1];
    apwu.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new agsg(this, l, arrayOfInt, arrayOfDevlockInfo));
    this.jdField_e_of_type_Agsi.a(30000L);
    if ((arrayOfInt[0] == 0) && (arrayOfDevlockInfo[0] != null))
    {
      boolean bool1;
      if (arrayOfDevlockInfo[0].DevSetup == 1)
      {
        bool1 = true;
        if (arrayOfDevlockInfo[0].AllowSet != 1) {
          break label169;
        }
      }
      for (;;)
      {
        a(bool1, bool2, paramBoolean);
        return;
        bool1 = false;
        break;
        label169:
        bool2 = false;
      }
    }
    this.g = false;
  }
  
  private boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  private void d(int paramInt1, int paramInt2, Object paramObject) {}
  
  private boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "getAuthModeSync after destroy");
      return false;
    }
    localObject = (ammr)((QQAppInterface)localObject).a(59);
    if (localObject != null)
    {
      long l1 = SystemClock.uptimeMillis();
      this.jdField_d_of_type_Agsi.a();
      ((ammr)localObject).a();
      this.jdField_d_of_type_Agsi.a(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync cost: " + (l2 - l1));
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "hasGetAuthMode false hanlder is null");
    }
    return false;
  }
  
  private void e(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "handleRoamMessageRsp, what: " + paramInt1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleRoamMessageRsp after destroy");
      this.jdField_a_of_type_Agsi.b();
      return;
    }
    localObject = (alsl)((QQAppInterface)localObject).getManager(92);
    Calendar localCalendar;
    if (paramObject != null)
    {
      localCalendar = Calendar.getInstance();
      paramObject = (Long)paramObject;
      if (paramInt2 != 1) {
        break label179;
      }
    }
    label179:
    for (int i = 1;; i = 0)
    {
      localCalendar.setTimeInMillis(paramObject.longValue() * 1000L);
      if (i == 0) {
        ((alsl)localObject).a(localCalendar, false);
      }
      switch (paramInt1)
      {
      case 3: 
      default: 
        return;
      case 0: 
        QLog.e("C2CMsgRoamProxy", 2, new Exception("handleRoamMessageRsp"), new Object[0]);
        ((alsl)localObject).e();
        return;
      }
    }
    if (paramInt2 == -1) {}
    for (;;)
    {
      ((alsl)localObject).e();
      return;
      paramObject = ((alsl)localObject).a();
      if (paramObject != null) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131693128, new Object[] { Integer.valueOf(paramObject.get(2) + 1), Integer.valueOf(paramObject.get(5)) }), 0).a();
      }
    }
    ((alsl)localObject).e();
  }
  
  private boolean e()
  {
    Object localObject2 = this.jdField_a_of_type_Alsl.c();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
    }
    if (this.jdField_a_of_type_Alsl.b() == null)
    {
      QLog.e("C2CMsgRoamProxy", 1, "can not get first page date, roam flag: " + this.jdField_a_of_type_Alsl.e());
      return true;
    }
    long l = this.jdField_a_of_type_Alsl.b().getTimeInMillis();
    while (((Calendar)localObject1).getTimeInMillis() >= l)
    {
      int i = ((Calendar)localObject1).get(5);
      localObject2 = this.jdField_a_of_type_Alsl.a().a(this.jdField_a_of_type_JavaLangString, ((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("C2CMsgRoamProxy", 2, "roam date cache is null: " + ((Calendar)localObject1).getTimeInMillis());
        }
        ((Calendar)localObject1).set(5, 1);
        ((Calendar)localObject1).add(5, -1);
        a((Calendar)localObject1);
      }
      else
      {
        this.jdField_a_of_type_Alsl.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), i);
        int j = ((RoamDate)localObject2).getLocState(i - 1);
        int k = ((RoamDate)localObject2).getSerState(i - 1);
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "ser: " + k + ", local: " + j + ", day: " + i);
        }
        if ((k == 2) && ((j == 1) || (j == 2) || (j == 0)))
        {
          ((Calendar)localObject1).add(5, 1);
          this.jdField_a_of_type_Alsl.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_Alsl.a();
          return false;
        }
        ((Calendar)localObject1).add(5, -1);
      }
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alsl != null)
    {
      this.jdField_a_of_type_Alsl.q();
      this.jdField_a_of_type_Alsl.a(hashCode());
      this.jdField_a_of_type_Alsl.b(this);
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).removeObserver(this.jdField_a_of_type_Alxo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "handleQueryMessageFromDBRsp, what: " + paramInt1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleQueryMessageFromDBRsp after destroy");
      this.jdField_a_of_type_Agsi.b();
      return;
    }
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel())
      {
        paramObject = this.jdField_a_of_type_JavaUtilList;
        localObject = new StringBuilder().append("getHistorySig notify, result ");
        if (paramObject != null) {
          break label161;
        }
      }
      break;
    }
    label161:
    for (paramObject = "is null";; paramObject = " size: " + paramObject.size())
    {
      QLog.d("C2CMsgRoamProxy", 2, paramObject);
      this.jdField_a_of_type_Agsi.b();
      return;
      a((QQAppInterface)localObject);
      break;
      if (a((QQAppInterface)localObject, paramObject)) {
        break;
      }
      return;
    }
  }
  
  public void a(alsn paramalsn)
  {
    try
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Alsl.b(this);
      this.jdField_a_of_type_Alsl.a(hashCode());
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public boolean a(String paramString, int paramInt1, int paramInt2, abpd paramabpd, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = a(paramString, paramInt1, paramArrayList);
    if (i == 0) {
      return true;
    }
    this.jdField_f_of_type_Boolean = false;
    int j = paramArrayList.size();
    long l1;
    if (paramMessageRecord == null)
    {
      l1 = NetConnInfoCenter.getServerTime();
      if ((paramMessageRecord != null) && ((this.jdField_a_of_type_Alsl == null) || (!this.jdField_a_of_type_Alsl.e()) || (this.jdField_a_of_type_Alsl.a() != null))) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      b();
      if (this.jdField_a_of_type_Alsl.h()) {
        break label122;
      }
      QLog.i("C2CMsgRoamProxy", 1, "not open roam");
      return false;
      l1 = paramMessageRecord.time;
      break;
    }
    label122:
    if ((paramMessageRecord != null) && (i == 2))
    {
      a(3);
      this.jdField_a_of_type_Alsl.c(true);
      if (a() == null)
      {
        QLog.w("C2CMsgRoamProxy", 1, "current page date is null, init again");
        paramabpd = this.jdField_a_of_type_Alsl.d;
        a(true);
        if (paramabpd == null) {
          break label219;
        }
        a(paramabpd);
      }
    }
    for (;;)
    {
      bool = e();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label231;
      }
      QLog.w("C2CMsgRoamProxy", 1, "getRoamMsg app is null");
      return true;
      a(0);
      break;
      label219:
      QLog.d("C2CMsgRoamProxy", 1, "last query date is null");
    }
    label231:
    paramabpd = a();
    if (paramabpd == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "last synced date is null");
      return true;
    }
    if ((paramMessageRecord != null) && (i == 2)) {
      if (paramArrayList.size() <= 0) {
        break label499;
      }
    }
    label499:
    for (long l2 = ((MessageRecord)paramArrayList.get(0)).time;; l2 = l1)
    {
      long l3 = paramabpd.getTimeInMillis() / 1000L;
      QLog.d("C2CMsgRoamProxy", 1, "query local msg from " + l2 + " to " + l3);
      if ((l1 >= 0L) && (l1 > l3))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, paramInt2 - j, String.format(Locale.getDefault(), "time>=%d", new Object[] { Long.valueOf(l3) }));
        if ((paramString.size() > 0) && (QLog.isColorLevel())) {
          QLog.d("C2CMsgRoamProxy", 2, "query local msg size: " + paramString.size() + ", first msg: " + ((MessageRecord)paramString.get(0)).toString());
        }
        paramArrayList.addAll(0, paramString);
      }
      if ((bool) || (paramArrayList.size() >= paramInt2)) {
        break label620;
      }
      if (a()) {
        break;
      }
      QLog.d("C2CMsgRoamProxy", 1, "check auth failed");
      return false;
    }
    if (c())
    {
      paramString = a(paramArrayList, paramLong, paramMessageRecord);
      if (paramString != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("C2CMsgRoamProxy", 2, "get roam msg size: " + paramString.size());
          if (paramString.size() > 0) {
            QLog.d("C2CMsgRoamProxy", 2, "first roam msg: " + ((ChatMessage)paramString.get(0)).toString());
          }
        }
        paramArrayList.addAll(0, paramString);
      }
      for (;;)
      {
        label620:
        return true;
        QLog.d("C2CMsgRoamProxy", 1, "no more roam msg");
      }
    }
    QLog.d("C2CMsgRoamProxy", 1, "get timeline failed");
    return false;
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "onHandleMsg: " + paramInt1);
    }
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      e(paramInt1, paramInt2, paramObject);
      return;
    case 22: 
    case 23: 
      a(paramInt1, paramInt2, paramObject);
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
      c(paramInt1, paramInt2, paramObject);
      return;
    case 34: 
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "handle_get_roam_msg_auth_mode notify");
      }
      this.jdField_d_of_type_Agsi.b();
      return;
    }
    d(paramInt1, paramInt2, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agse
 * JD-Core Version:    0.7.0.1
 */