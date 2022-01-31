import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDetailInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsSubnation;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class akfi
  extends ajtd
  implements ajte
{
  public static final HashSet<String> a;
  public int a;
  private akuj a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public akfi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 600000;
    this.jdField_a_of_type_Akuj = new akfj(this, "vas_red_point", false);
  }
  
  private BusinessInfoCheckUpdate.LbsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    BusinessInfoCheckUpdate.LbsInfo localLbsInfo = new BusinessInfoCheckUpdate.LbsInfo();
    BusinessInfoCheckUpdate.LbsDetailInfo localLbsDetailInfo = new BusinessInfoCheckUpdate.LbsDetailInfo();
    BusinessInfoCheckUpdate.LbsSubnation localLbsSubnation = new BusinessInfoCheckUpdate.LbsSubnation();
    if (TextUtils.isEmpty(paramSosoLocation.f)) {}
    for (paramSosoLocation = "";; paramSosoLocation = paramSosoLocation.f)
    {
      localLbsSubnation.code.set(paramSosoLocation);
      localLbsSubnation.nation.set("unknown");
      localLbsSubnation.province.set("unknown");
      localLbsSubnation.city.set("unknown");
      localLbsSubnation.district.set("unknown");
      localLbsDetailInfo.subnation.set(localLbsSubnation);
      localLbsInfo.detail_info.set(localLbsDetailInfo);
      return localLbsInfo;
    }
  }
  
  public static List<akfk> a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramAppRuntime = LebaPluginInfo.getAll(((QQAppInterface)paramAppRuntime).getEntityManagerFactory().createEntityManager());
    } while (paramAppRuntime == null);
    int i = 0;
    while (i < paramAppRuntime.size())
    {
      akfk localakfk = new akfk();
      localakfk.jdField_a_of_type_Long = ((LebaPluginInfo)paramAppRuntime.get(i)).uiResId;
      localakfk.jdField_a_of_type_Int = ((int)((LebaPluginInfo)paramAppRuntime.get(i)).uiResId);
      localArrayList.add(localakfk);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedpointHandler.2(this, paramInt, paramSosoLbsInfo), 5, null, true);
      return;
    }
    b(paramInt, paramSosoLbsInfo);
  }
  
  private void a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilHashSet == null) {}
    do
    {
      return;
      if (paramLong == 1113L)
      {
        jdField_a_of_type_JavaUtilHashSet.add("1113.100800");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100801");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100802");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100803");
        jdField_a_of_type_JavaUtilHashSet.add("1113.100804");
        return;
      }
    } while (paramLong != 100001113L);
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100800");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100801");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100802");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100803");
    jdField_a_of_type_JavaUtilHashSet.add("100600.100001113.100100804");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (axbt)paramQQAppInterface.getManager(12);
    if (localObject != null) {
      ((axbt)localObject).a();
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), axbw.class);
    ((NewIntent)localObject).setAction("gc_refresh_ui");
    ((NewIntent)localObject).putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet((NewIntent)localObject);
    ((akfi)paramQQAppInterface.a(87)).notifyUI(3, true, null);
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1 = (bbpl)this.app.getManager(177);
    if ((!((bbpl)localObject1).jdField_b_of_type_Boolean) && (!((bbpl)localObject1).jdField_a_of_type_Boolean)) {
      ((bbpl)localObject1).a(this.app.getCurrentAccountUin());
    }
    int j;
    int i;
    if (paramTimeRspBody.rptMsgAppInfo.has())
    {
      j = paramTimeRspBody.rptMsgAppInfo.size();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramTimeRspBody.rptMsgAppInfo.get(i);
        if (localObject2 == null) {
          break label269;
        }
        if (String.valueOf(100005).equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get()))
        {
          if ((((bbpl)localObject1).jdField_a_of_type_Int == 0) || (TextUtils.isEmpty(((bbpl)localObject1).jdField_a_of_type_JavaLangString)) || (((bbpl)localObject1).jdField_b_of_type_Int != 0)) {
            break label269;
          }
          ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
          ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
        }
      }
      else
      {
        if (!paramTimeRspBody.rptMsgNumRedInfo.has()) {
          break label346;
        }
        localObject1 = new ArrayList();
        localObject2 = paramTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject2 != null) {
          break;
        }
        return;
      }
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get() == 769) {
        this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.app.getCurrentAccountUin(), (int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)).apply();
      }
      label269:
      i += 1;
    }
    Object localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
      if (((BusinessInfoCheckUpdate.NumRedInfo)localObject3).appid.get() == 7719) {
        ((List)localObject1).add(localObject3);
      }
    }
    ataq.a().a(this.app, (List)localObject1);
    label346:
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "individuation jump open");
    }
    if (paramTimeRspBody.rptSetting.get() != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        localObject3 = paramTimeRspBody.rptSetting.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject3).next();
          if (localAppSetting != null)
          {
            StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("appid: ");
            if (localAppSetting.appid.has())
            {
              localObject1 = Integer.valueOf(localAppSetting.appid.get());
              label462:
              localStringBuilder = localStringBuilder.append(localObject1).append("  setting:");
              if (!localAppSetting.setting.has()) {
                break label565;
              }
              localObject1 = Boolean.valueOf(localAppSetting.setting.get());
              label501:
              localStringBuilder = localStringBuilder.append(localObject1).append(" modify_ts:");
              if (!localAppSetting.modify_ts.has()) {
                break label573;
              }
            }
            label565:
            label573:
            for (localObject1 = Long.valueOf(localAppSetting.modify_ts.get());; localObject1 = "null")
            {
              localStringBuilder.append(localObject1).append("\n");
              break;
              localObject1 = "null";
              break label462;
              localObject1 = "null";
              break label501;
            }
          }
        }
        QLog.i("RedpointHandler", 2, ((StringBuilder)localObject2).toString());
      }
      agca.a().a(paramTimeRspBody.rptSetting.get());
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedpointHandler", 2, "update NearbyNumAppinfo");
    }
    atyq.a(this.app, true);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      QLog.e("RedpointHandler", 1, "handleResponse data = null");
    }
    Object localObject1;
    int i;
    avpq localavpq;
    label604:
    do
    {
      do
      {
        return;
        try
        {
          localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
          ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).mergeFrom((byte[])paramObject);
          paramObject = localObject1;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            paramObject.printStackTrace();
            QLog.e("RedpointHandler", 1, "mergeFrom failed");
            paramObject = null;
          }
        }
        if (paramObject == null)
        {
          QLog.e("RedpointHandler", 1, "handleResponse prb = null");
          return;
        }
        if (paramObject.iResult.get() == 0) {
          break;
        }
        QLog.d("RedpointHandler", 2, "handleResponse,return fail ,TimeRspBody result:" + paramObject.iResult.get());
      } while (paramObject.iResult.get() != 104005);
      localObject1 = new BusinessInfoCheckUpdate.TimeRspBody();
      QLog.i("RedpointHandler", 1, "handleResponse");
      paramObject = this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
      if (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iInterval.has())
      {
        localObject2 = "businessinfo_check_update_interval_" + this.app.getCurrentAccountUin();
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iInterval.get() > 0)
        {
          i = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iInterval.get();
          paramObject.putInt((String)localObject2, i);
        }
      }
      for (;;)
      {
        paramObject.putInt("businessinfo_check_update_interval_lbsinfo_" + this.app.getCurrentAccountUin(), ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iLbsInterval.get());
        QLog.d("RedpointHandler", 1, "handleResponse, iInterval = " + ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iInterval.get() + "; lbsInterval = " + ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).iLbsInterval.get());
        paramObject.putInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
        paramObject.apply();
        this.app.getEntityManagerFactory().createEntityManager();
        localavpq = (avpq)this.app.getManager(36);
        try
        {
          if (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has()) {
            break label667;
          }
          paramObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get().iterator();
          while (paramObject.hasNext())
          {
            localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramObject.next();
            if (localObject2 != null)
            {
              if ((!a(this.app, (BusinessInfoCheckUpdate.AppInfo)localObject2)) && (1 == ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get()))
              {
                ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
                ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(0);
                if (QLog.isColorLevel()) {
                  QLog.d("RedpointHandler", 2, "verifyDataCorrect,return false ,appInfo.path.get():" + ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
                }
              }
              if (((BusinessInfoCheckUpdate.AppInfo)localObject2).use_cache.get())
              {
                localObject3 = localavpq.a(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
                if (localObject3 != null) {
                  ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get());
                }
              }
            }
          }
          localavpq.a((BusinessInfoCheckUpdate.TimeRspBody)localObject1);
        }
        catch (Exception paramObject)
        {
          QLog.i("RedpointHandler", 2, "handleResponse", paramObject);
        }
        a((BusinessInfoCheckUpdate.TimeRspBody)localObject1);
        a(this.app);
        return;
        i = 0;
        break;
        paramObject.remove("businessinfo_check_update_interval_" + this.app.getCurrentAccountUin());
      }
      if (!((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.has()) {
        break;
      }
      paramObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.get();
    } while (paramObject == null);
    label667:
    paramObject = paramObject.iterator();
    while (paramObject.hasNext())
    {
      localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)paramObject.next()).num_red_path.get();
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((List)localObject2).size())
        {
          ((BusinessInfoCheckUpdate.NumRedPath)((List)localObject2).get(i)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
          i += 1;
        }
      }
    }
    Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptSetting.get();
    paramObject = localavpq.a();
    Object localObject3 = new ArrayList();
    label810:
    int j;
    if ((localObject2 != null) && (paramObject != null))
    {
      i = 0;
      if (i < ((List)localObject2).size())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(i);
        j = 0;
        label836:
        if (j < paramObject.size())
        {
          if (((BusinessInfoCheckUpdate.AppSetting)paramObject.get(j)).appid.get() != localAppSetting.appid.get()) {
            break label1208;
          }
          paramObject.set(j, localAppSetting);
          j = 1;
          label885:
          if (j != 0) {
            break label1201;
          }
          ((List)localObject3).add(localAppSetting);
          break label1201;
        }
      }
      else
      {
        paramObject.addAll((Collection)localObject3);
      }
    }
    for (;;)
    {
      label911:
      ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptSetting.set(paramObject);
      paramObject = new StringBuilder("Rsp Body :");
      if (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has())
      {
        localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            paramObject.append("appid = ").append(((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.get());
            paramObject.append(" path = ").append(((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
            paramObject.append(" inewflag = ").append(((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get());
            paramObject.append(" missions = ").append(((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.get());
            paramObject.append(";");
          }
        }
      }
      if (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.has())
      {
        localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            paramObject.append("numred appid = ").append(((BusinessInfoCheckUpdate.NumRedInfo)localObject3).appid.get());
            paramObject.append(" appset = ").append(((BusinessInfoCheckUpdate.NumRedInfo)localObject3).appset.get());
            paramObject.append(";");
          }
        }
      }
      QLog.i("RedpointHandler", 2, paramObject.toString());
      break label604;
      label1201:
      label1208:
      do
      {
        break label911;
        j = 0;
        break label885;
        localObject1 = paramObject;
        break;
        i += 1;
        break label810;
        j += 1;
        break label836;
      } while (paramObject != null);
      paramObject = localObject2;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return false;
      if (paramAppInfo.appset.get() == 3) {
        return true;
      }
      Object localObject1 = a(paramQQAppInterface);
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int j = ((List)localObject1).size();
        i = 0;
        while (i < j)
        {
          long l = ((akfk)((List)localObject1).get(i)).jdField_a_of_type_Long;
          localObject2 = "100600." + (100000000L + l) + "";
          if (((((akfk)((List)localObject1).get(i)).jdField_a_of_type_Long + "").equals(paramAppInfo.path.get())) || (((String)localObject2).equals(paramAppInfo.path.get()))) {
            return true;
          }
          if ((jdField_a_of_type_JavaUtilHashSet != null) && (jdField_a_of_type_JavaUtilHashSet.contains(paramAppInfo.path.get()))) {
            return true;
          }
          i += 1;
        }
      }
      localObject1 = ajte.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajtf)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((ajtf)localObject2).a(paramQQAppInterface);
          if ((localObject2 != null) && (((List)localObject2).contains(paramAppInfo.path.get()))) {
            return true;
          }
        }
      }
      int i = 0;
      while (i < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        paramQQAppInterface = paramAppInfo.path.get();
        if (jdField_a_of_type_Array2dOfJavaLangString[i][1].equals(paramQQAppInterface)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void b(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.d("RedpointHandler", 1, "sendReq start");
    BusinessInfoCheckUpdate.TimeReqBody localTimeReqBody = new BusinessInfoCheckUpdate.TimeReqBody();
    localTimeReqBody.iProtocolVer.set(1);
    localTimeReqBody.uiClientPlatID.set(109);
    localTimeReqBody.sClientVer.set("8.2.8.4440");
    localTimeReqBody.uiUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    int i = bbev.a(BaseApplication.getContext());
    localTimeReqBody.uiNetType.set(i);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if (paramSosoLbsInfo != null) {
        localTimeReqBody.lbs.set(paramSosoLbsInfo);
      }
    }
    this.app.getEntityManagerFactory().createEntityManager();
    List localList = a(this.app);
    Object localObject3 = (avpq)this.app.getManager(36);
    Object localObject1;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label203:
    Object localObject2;
    int k;
    int j;
    if (localObject3 == null)
    {
      localObject1 = null;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      if (localList == null) {
        break label488;
      }
      paramSosoLbsInfo = null;
      if (localObject1 != null) {
        break label311;
      }
      paramInt = 0;
      i = 0;
      if (i >= localList.size()) {
        break label488;
      }
      localObject2 = ((akfk)localList.get(i)).jdField_a_of_type_Long + "";
      k = ((akfk)localList.get(i)).jdField_a_of_type_Int;
      j = 0;
      label269:
      if (j >= paramInt) {
        break label334;
      }
      paramSosoLbsInfo = (BusinessInfoCheckUpdate.AppSetting)((List)localObject1).get(j);
      if (paramSosoLbsInfo != null) {
        break label322;
      }
    }
    label311:
    label322:
    while (k != paramSosoLbsInfo.appid.get())
    {
      j += 1;
      break label269;
      localObject1 = ((avpq)localObject3).a();
      break;
      paramInt = ((List)localObject1).size();
      break label203;
    }
    label334:
    if ((j == paramInt) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = new BusinessInfoCheckUpdate.AppSetting();
      paramSosoLbsInfo.appid.set(k);
      paramSosoLbsInfo.setting.set(true);
      paramSosoLbsInfo.modify_ts.set(0L);
    }
    for (;;)
    {
      if (!paramSosoLbsInfo.setting.get())
      {
        long l = 100000000L + ((akfk)localList.get(i)).jdField_a_of_type_Long;
        localObject2 = "100600." + l + "";
        a(l);
      }
      for (;;)
      {
        localTimeReqBody.rptSetting.add(paramSosoLbsInfo);
        localArrayList1.add(localObject2);
        i += 1;
        break;
        a(((akfk)localList.get(i)).jdField_a_of_type_Long);
      }
      label488:
      localArrayList1.addAll(jdField_a_of_type_JavaUtilHashSet);
      paramSosoLbsInfo = ajte.a.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject1 = (ajtf)paramSosoLbsInfo.next();
        if ((localObject1 != null) && (((ajtf)localObject1).a(this.app) != null)) {
          localArrayList1.addAll(((ajtf)localObject1).a(this.app));
        }
      }
      paramInt = 0;
      while (paramInt < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        localArrayList1.add(jdField_a_of_type_Array2dOfJavaLangString[paramInt][1]);
        paramInt += 1;
      }
      if (localObject3 != null)
      {
        paramSosoLbsInfo = ((avpq)localObject3).b(3).iterator();
        while (paramSosoLbsInfo.hasNext()) {
          localArrayList1.add(((BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.next()).path.get());
        }
        if (((avpq)localObject3).a() == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedpointHandler", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
          }
          localArrayList2.addAll(localArrayList1);
        }
      }
      else
      {
        localTimeReqBody.rptMsgAppInfo.set(localArrayList3);
        localTimeReqBody.rptNoRedPath.set(localArrayList2);
        if (!this.app.q) {
          break label1263;
        }
        localTimeReqBody.bHebaFlag.set(true);
        label726:
        if ((!((ho)this.app.getManager(42)).jdField_a_of_type_Boolean) && (localTimeReqBody.rptMsgAppInfo.has()))
        {
          paramInt = 0;
          label757:
          if (paramInt < localTimeReqBody.rptMsgAppInfo.size())
          {
            if (!"100005.100011".equals(((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get())) {
              break label1275;
            }
            localTimeReqBody.rptMsgAppInfo.remove(paramInt);
          }
        }
        if (!QLog.isColorLevel()) {
          break label1312;
        }
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("req red pathlist:");
        if (!localTimeReqBody.rptMsgAppInfo.has()) {
          break label1282;
        }
        paramInt = 0;
        while (paramInt < localTimeReqBody.rptMsgAppInfo.size())
        {
          localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localTimeReqBody.rptMsgAppInfo.get(paramInt)).path.get();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramSosoLbsInfo.append((String)localObject1);
            paramSosoLbsInfo.append(";");
          }
          paramInt += 1;
        }
      }
      paramSosoLbsInfo = ((avpq)localObject3).a();
      if (paramSosoLbsInfo.rptMsgAppInfo.has())
      {
        i = 0;
        label920:
        if (i < localArrayList1.size())
        {
          localObject1 = (String)localArrayList1.get(i);
          paramInt = 0;
          label946:
          if (paramInt >= paramSosoLbsInfo.rptMsgAppInfo.size()) {
            break label1364;
          }
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)paramSosoLbsInfo.rptMsgAppInfo.get(paramInt);
          if (!((String)localObject1).equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get())) {
            break label1243;
          }
          localObject3 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get();
          paramInt = 0;
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
            paramInt = 1;
          }
          if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0) || (paramInt == 0)) {
            break label1053;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          localArrayList2.add(localObject1);
        }
        i += 1;
        break label920;
        break;
        label1053:
        localObject3 = new BusinessInfoCheckUpdate.AppInfo();
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).path.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).modify_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).type.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).push_red_ts.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.get());
        ((BusinessInfoCheckUpdate.AppInfo)localObject3).mission_level.set(((BusinessInfoCheckUpdate.AppInfo)localObject2).mission_level.get());
        paramInt = 0;
        while (paramInt < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject3).missions.add(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(paramInt));
          paramInt += 1;
        }
        localArrayList3.add(localObject3);
        paramInt = 0;
        continue;
        label1243:
        paramInt += 1;
        break label946;
        localArrayList2.addAll(localArrayList1);
        break;
        label1263:
        localTimeReqBody.bHebaFlag.set(false);
        break label726;
        label1275:
        paramInt += 1;
        break label757;
        label1282:
        QLog.d("RedpointHandler", 1, "getNewFlagOp rptMsginfoPath:" + paramSosoLbsInfo.toString());
        label1312:
        if (QLog.isColorLevel()) {}
        QLog.d("RedpointHandler", 1, "getNewFlagOp local message ok");
        paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQClubComm.getNewFlag");
        paramSosoLbsInfo.putWupBuffer(localTimeReqBody.toByteArray());
        sendPbReq(paramSosoLbsInfo);
        return;
        label1364:
        paramInt = 1;
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RedpointHandler", 2, "getNewFlagOp:send redInfo start");
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("businessinfo_check_update_interval_" + this.app.getCurrentAccountUin(), 600);
    this.jdField_a_of_type_Int = (i * 1000);
    int j = localSharedPreferences.getInt("businessinfo_check_update_interval_lbsinfo_" + this.app.getCurrentAccountUin(), 43200000);
    int k = localSharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), 0);
    int m = localSharedPreferences.getInt("businessinfo_last_check_lbsinfo_timestamp_" + this.app.getCurrentAccountUin(), 0);
    int n = (int)(System.currentTimeMillis() / 1000L);
    boolean bool = localSharedPreferences.getBoolean("redtouch_force", false);
    QLog.d("RedpointHandler", 1, "getNewFlagOp:sendredInfo :systemTimestamp = " + n + ";lastUpdateTimestamp = " + k + ";updateInterval = " + i + ";updateLbsInterval = " + j + ";lastCheckLbsInfo = " + m + ";isDebugVersion = " + false);
    if ((!bool) && (!paramBoolean1) && (n - k <= i) && (n >= k)) {
      return;
    }
    localEditor.putInt("businessinfo_last_check_update_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
    localEditor.putBoolean("redtouch_force", false);
    localEditor.apply();
    if ((paramBoolean2) && ((n - m > j) || (n < k)))
    {
      localEditor.putInt("businessinfo_last_check_lbsinfo_timestamp_" + this.app.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.app.getApplication().getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          a(-1, null);
          return;
        }
        akug.a(this.jdField_a_of_type_Akuj);
        return;
      }
      akug.a(this.jdField_a_of_type_Akuj);
      return;
    }
    a(-1, null);
  }
  
  public void a(int paramInt)
  {
    QLog.d("RedpointHandler", 1, "forceSendReq fromSrc:" + paramInt);
    a(-1, null);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramBoolean1, paramBoolean2);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return akfl.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    akug.b(this.jdField_a_of_type_Akuj);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (("QQClubComm.getNewFlag".equals(paramFromServiceMsg.getServiceCmd())) && (i != 0)) {
        a(paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */