import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.statistics.battery.BatteryIPCModule;
import com.tencent.mobileqq.statistics.battery.BatteryLog;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.mobileqq.statistics.battery.HighFrequencyStringDetector;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MainService;
import mqq.util.IServiceCmdCallback;

public class aigq
  extends aigp
  implements IServiceCmdCallback
{
  private int jdField_a_of_type_Int = 20;
  private long jdField_a_of_type_Long = 2000L;
  private HighFrequencyStringDetector jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = 30;
  private long jdField_b_of_type_Long;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = 40;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  
  public aigq(BatteryStatsImpl paramBatteryStatsImpl, String paramString)
  {
    super(paramBatteryStatsImpl, paramString);
    MainService.setServiceCmdCallback(this);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 4))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 1000L);
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue();
      this.jdField_c_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][2]).intValue();
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][3]).intValue();
      this.jdField_b_of_type_Int *= 3;
      this.jdField_c_of_type_Int *= 8;
    }
    this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector = new HighFrequencyStringDetector(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x58b_0", Integer.valueOf(150));
    this.jdField_a_of_type_JavaUtilMap.put("IncreaseURLSvr.QQHeadUrlReq", Integer.valueOf(100));
    this.jdField_a_of_type_JavaUtilMap.put("AvatarInfoSvr.QQHeadUrlReq", Integer.valueOf(100));
    this.jdField_a_of_type_JavaUtilMap.put("OnlinePush.RespPush", Integer.valueOf(120));
    this.jdField_a_of_type_JavaUtilMap.put("CliLogSvc.UploadReq", Integer.valueOf(50));
    this.jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x787_1", Integer.valueOf(90));
    this.jdField_a_of_type_JavaUtilMap.put("friendlist.getTroopMemberList", Integer.valueOf(40));
    this.jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbDeleteMsg", Integer.valueOf(100));
  }
  
  public void a(Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (paramBundle.getInt("key_action") != 7) {
      return;
    }
    String str = paramBundle.getString("key_log");
    int i = paramBundle.getInt("key_count");
    if (QLog.isColorLevel()) {
      QLog.d("BatteryStats", 2, new Object[] { "CMD.onOtherProcReport:", str, ", count:" + i });
    }
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      HashSet localHashSet;
      if (this.jdField_b_of_type_Boolean)
      {
        localHashSet = (HashSet)this.jdField_b_of_type_JavaUtilMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.jdField_b_of_type_JavaUtilMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      if ((this.jdField_c_of_type_Boolean) && (this.d))
      {
        localHashSet = (HashSet)this.jdField_c_of_type_JavaUtilMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.jdField_c_of_type_JavaUtilMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      return;
    }
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_c_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void e()
  {
    super.e();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean)) {}
    label290:
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "fg30CmdCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.jdField_b_of_type_JavaUtilMap.get(str);
          StringBuilder localStringBuilder = BatteryLog.a();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label290;
            }
            localStringBuilder.append("#");
            break label290;
          }
          BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "fg30CmdAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean)) {}
    label292:
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "bg5CmdCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_c_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.jdField_c_of_type_JavaUtilMap.get(str);
          StringBuilder localStringBuilder = BatteryLog.a();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label292;
            }
            localStringBuilder.append("#");
            break label292;
          }
          BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "bg5CmdAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_c_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void onCmdRequest(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector.a();
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector.a(paramString);
    } while (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long);
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector.a();
    StringBuilder localStringBuilder;
    int i;
    Object localObject;
    if ((localMap == null) || ((localMap != null) && (localMap.size() > 0)))
    {
      localStringBuilder = new StringBuilder(localMap.size() * 20);
      paramString = null;
      Iterator localIterator = localMap.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("#");
        }
        localStringBuilder.append("[").append((String)localObject).append(",").append(localMap.get(localObject)).append("]");
        if (((Integer)localMap.get(localObject)).intValue() <= i) {
          break label439;
        }
        i = ((Integer)localMap.get(localObject)).intValue();
        paramString = (String)localObject;
      }
    }
    label439:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 7);
      localBundle.putString("key_log", (String)localObject);
      localBundle.putInt("key_count", ((Integer)localMap.get(localObject)).intValue());
      if (!BatteryStatsImpl.a()) {
        BatteryIPCModule.a().a(localBundle);
      }
      for (;;)
      {
        break;
        a(localBundle);
      }
      BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "cmd|", localStringBuilder.toString() });
      localObject = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
      if (i > this.jdField_c_of_type_Int)
      {
        i = 1;
        BatteryStatsImpl.a((BatteryStatsImpl)localObject, 3, 0, i, "发现高频命令字:" + paramString, "2秒钟命令字请求次数：" + localStringBuilder.toString());
      }
      for (;;)
      {
        this.jdField_b_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyStringDetector.a();
        return;
        i = 0;
        break;
        if ((BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl) != null) && (QLog.isColorLevel())) {
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, "No high frequnecy cmd in last 2seconds");
        }
      }
    }
  }
  
  public void onCmdResponse(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aigq
 * JD-Core Version:    0.7.0.1
 */