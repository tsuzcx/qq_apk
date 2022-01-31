import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.LbsData;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.ReqLbsReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class akue
  implements Manager, BusinessObserver
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<LbsReportInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public akue(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    b(null);
  }
  
  private int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int <= 0)
        {
          this.jdField_a_of_type_Int = (new Random().nextInt(1000000) + 100);
          int i = this.jdField_a_of_type_Int;
          return i;
        }
        if (this.jdField_a_of_type_Int >= 1000100) {
          this.jdField_a_of_type_Int = 100;
        } else {
          this.jdField_a_of_type_Int += 1;
        }
      }
      finally {}
    }
  }
  
  private String a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "lbs_report_config", "");
    if (QLog.isColorLevel()) {
      QLog.d("LBSReport", 2, "getLBSNewReport,lbs_report_config:" + paramContext);
    }
    return paramContext;
  }
  
  private ArrayList<String> a(ArrayList<LbsReportInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.get(i);
      if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
        localArrayList.add("dc01864");
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class);
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list size is: " + localList.size());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list is empty.");
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramString1 + "_" + "lbs_report_config", paramString2).commit();
  }
  
  public static void a(SosoInterface.SosoLocation paramSosoLocation, String paramString)
  {
    int i = 1;
    if ((paramSosoLocation.jdField_a_of_type_Double == 0.0D) || (paramSosoLocation.jdField_b_of_type_Double == 0.0D)) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    Intent localIntent;
    for (;;)
    {
      localIntent = new Intent();
      localIntent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("is_runtime", 1001);
      localIntent.putExtra("lat", paramSosoLocation.jdField_a_of_type_Double);
      localIntent.putExtra("lng", paramSosoLocation.jdField_b_of_type_Double);
      localIntent.putExtra("alt", paramSosoLocation.jdField_e_of_type_Double);
      localIntent.putExtra("accuracy", paramSosoLocation.jdField_a_of_type_Float);
      localIntent.putExtra("businessTag", paramString);
      if (!TextUtils.isEmpty(paramSosoLocation.c)) {
        localIntent.putExtra("nation", paramSosoLocation.c);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.d)) {
        localIntent.putExtra("province", paramSosoLocation.d);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("city", paramSosoLocation.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.g)) {
        localIntent.putExtra("district", paramSosoLocation.g);
      }
      if (i == 0) {
        break label231;
      }
      paramSosoLocation = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramSosoLocation == null) {
        break;
      }
      ((akue)paramSosoLocation.getManager(126)).a(localIntent);
      return;
      i = 0;
    }
    label231:
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface == null) || (paramArrayOfByte == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), mxe.class);
    localNewIntent.putExtra("cmd", "LbsSvc.lbs_report");
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("DataType", 2);
    localNewIntent.putExtra("retryTime", paramInt + 1);
    localNewIntent.putExtra("copyData", paramArrayOfByte);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  private void b(@Nullable JSONObject paramJSONObject)
  {
    boolean bool = true;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      paramJSONObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (TextUtils.isEmpty(paramJSONObject)) {
        return;
      }
      localJSONObject = new JSONObject(paramJSONObject);
      if (localJSONObject.optInt("is_close_old_report") != 1) {
        break label80;
      }
    }
    catch (JSONException paramJSONObject)
    {
      while (QLog.isColorLevel())
      {
        QLog.e("LBSReport", 2, paramJSONObject, new Object[0]);
        return;
        label80:
        bool = false;
      }
    }
    this.jdField_b_of_type_Boolean = bool;
    return;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "onReceiveLbsInfo intent is null. return.");
      }
    }
    double d1;
    double d2;
    double d3;
    float f;
    String str1;
    String str2;
    String str3;
    String str4;
    double d4;
    double d5;
    do
    {
      do
      {
        return;
        d1 = paramIntent.getDoubleExtra("lat", 0.0D);
        d2 = paramIntent.getDoubleExtra("lng", 0.0D);
        d3 = paramIntent.getDoubleExtra("alt", 0.0D);
        f = paramIntent.getFloatExtra("accuracy", 0.0F);
        str1 = paramIntent.getStringExtra("businessTag");
        str2 = paramIntent.getStringExtra("nation");
        str3 = paramIntent.getStringExtra("province");
        str4 = paramIntent.getStringExtra("city");
        paramIntent = paramIntent.getStringExtra("district");
        if ((d1 != 0.0D) && (d2 != 0.0D)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("LBSReport", 2, "onReceiveLbsInfo lat or lng is 0.0d. return.");
      return;
      d4 = TencentLocationUtils.distanceBetween(d1, d2, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      d5 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if ((d4 >= 20.0D) || (d5 >= 180000.0D)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LBSReport", 2, "onReceiveLbsInfo distance is: " + d4 + " collectGap: " + d5);
    return;
    ThreadManager.executeOnSubThread(new LbsInfoReportManager.1(this, d1, d2, d3, f, str1, str2, str3, str4, paramIntent));
  }
  
  public void a(ArrayList<LbsReportInfo> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report doNewReportLbsInfo: size = " + paramArrayList.size());
    }
    qqstory_lbs.ReqLbsReport localReqLbsReport = new qqstory_lbs.ReqLbsReport();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.next();
      qqstory_lbs.LbsData localLbsData = new qqstory_lbs.LbsData();
      localLbsData.alt.set(localLbsReportInfo.alt);
      localLbsData.lng.set(localLbsReportInfo.lng);
      localLbsData.lat.set(localLbsReportInfo.lat);
      localLbsData.accuracy.set(localLbsReportInfo.accuracy);
      if (!TextUtils.isEmpty(localLbsReportInfo.businessTag)) {
        localLbsData.bussinessTag.set(localLbsReportInfo.businessTag);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.nation)) {
        localLbsData.nation.set(localLbsReportInfo.nation);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.province)) {
        localLbsData.province.set(localLbsReportInfo.province);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.city)) {
        localLbsData.city.set(localLbsReportInfo.city);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.district)) {
        localLbsData.district.set(localLbsReportInfo.district);
      }
      localLbsData.plat_type.set(2);
      localLbsData.oper_time.set((int)localLbsReportInfo.operTime);
      localReqLbsReport.list_data.add(localLbsData);
    }
    a(localReqLbsReport.toByteArray(), paramInt);
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt1, int paramInt2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty()) || (paramArrayList2 == null) || (paramArrayList2.isEmpty())) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), axcv.class);
    localNewIntent.putExtra("sendType", 10);
    localNewIntent.putExtra("seqKey", paramInt1);
    localNewIntent.putExtra("tags", paramArrayList1);
    localNewIntent.putExtra("contents", paramArrayList2);
    localNewIntent.putExtra("retryTime", paramInt2 + 1);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("lbs_report_config");
    if (paramJSONObject != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramJSONObject.toString());
    }
    b(paramJSONObject);
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramInt == 10)
    {
      j = paramBundle.getInt("seqKey");
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + j);
      }
      paramInt = i;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null)) {
        a(paramBundle.getStringArrayList("tags"), paramBundle.getStringArrayList("contents"), j, paramInt);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramBundle.containsKey("cmd")) || (!"LbsSvc.lbs_report".equals(paramBundle.getString("cmd"))));
      paramInt = j;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report OnReceive: isSuccess =" + paramBoolean + ", retryTime = " + paramInt);
      }
    } while ((paramBoolean) || (paramInt >= 2));
    a(paramBundle.getByteArray("copyData"), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akue
 * JD-Core Version:    0.7.0.1
 */