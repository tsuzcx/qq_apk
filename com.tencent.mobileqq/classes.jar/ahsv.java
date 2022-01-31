import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.statistics.battery.BatteryIPCModule;
import com.tencent.mobileqq.statistics.battery.BatteryLog;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.mobileqq.statistics.battery.HighFrequencyDetector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahsv
  extends ahsm
  implements HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 900000L;
  private HighFrequencyDetector jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector = new HighFrequencyDetector(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 18000000L;
  private HighFrequencyDetector jdField_b_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector = new HighFrequencyDetector(this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashMap c;
  private HashMap d;
  private HashMap e = new HashMap();
  
  public ahsv(BatteryStatsImpl paramBatteryStatsImpl, String paramString)
  {
    super(paramBatteryStatsImpl, paramString);
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 2))
    {
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue();
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 2))
    {
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue();
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][1]).intValue() * 60 * 1000L);
    }
  }
  
  private final void a(ahsx paramahsx, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramahsx.c);
    localBundle.putString("key_tag", paramahsx.b);
    if (paramInt == 9) {
      localBundle.putLong("key_duration", SystemClock.uptimeMillis() - paramahsx.jdField_a_of_type_Long);
    }
    if (!BatteryStatsImpl.a())
    {
      BatteryIPCModule.a().a(localBundle);
      return;
    }
    a(localBundle);
  }
  
  private final void a(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.jdField_b_of_type_JavaUtilHashMap;
    long l = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int j;
      try
      {
        HashMap localHashMap1 = this.jdField_b_of_type_JavaUtilHashMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ahsw)((Iterator)localObject2).next();
          j = ((ahsw)localObject3).jdField_a_of_type_JavaUtilHashSet.size();
          localObject3 = ((ahsw)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label443;
          }
          l = ((Long)((Pair)((Iterator)localObject3).next()).second).longValue() + l;
          continue;
          localHashMap1 = this.jdField_c_of_type_JavaUtilHashMap;
          continue;
        }
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
        if (!paramBoolean) {
          break label453;
        }
        localObject2 = "fg30WFLCount";
        BatteryStatsImpl.b((BatteryStatsImpl)localObject3, new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l), "|0" });
        Iterator localIterator = localHashMap1.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label434;
        }
        String str = (String)localIterator.next();
        localObject3 = (ahsw)localHashMap1.get(str);
        StringBuilder localStringBuilder = BatteryLog.a();
        localObject2 = ((ahsw)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject4).first)).append(",").append(String.valueOf(((Pair)localObject4).second));
          i += 1;
          if (i >= ((ahsw)localObject3).jdField_a_of_type_JavaUtilHashSet.size()) {
            break label450;
          }
          localStringBuilder.append("#");
          break label450;
        }
        Object localObject4 = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl;
        if (paramBoolean)
        {
          localObject2 = "fg30WFLDetail";
          if (((ahsw)localObject3).jdField_a_of_type_JavaLangString != null) {
            break label417;
          }
          localObject3 = "";
          BatteryStatsImpl.b((BatteryStatsImpl)localObject4, new String[] { localObject2, "|", localObject3, "|0|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WFSDetail";
      }
      finally {}
      continue;
      label417:
      Object localObject3 = ((ahsw)localObject3).jdField_a_of_type_JavaLangString.replace("|", "_");
      continue;
      label434:
      localObject1.clear();
      return;
      label443:
      int i = j + i;
      continue;
      label450:
      continue;
      label453:
      Object localObject2 = "bg5WFLCount";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    String str;
    do
    {
      return;
      i = paramBundle.getInt("key_action");
      str = paramBundle.getString("key_stack");
      ??? = paramBundle.getString("key_tag");
      long l = paramBundle.getLong("key_duration");
      Object localObject1;
      if (i == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BatteryStats", 2, new Object[] { "WiFi.onOtherProcReport: scan:", str });
        }
        synchronized (this.jdField_d_of_type_JavaUtilHashMap)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = (HashSet)this.jdField_d_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.jdField_d_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localObject1 = (HashSet)this.e.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.e.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          return;
        }
      }
      if (i == 9) {
        synchronized (this.jdField_b_of_type_JavaUtilHashMap)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = (ahsw)this.jdField_b_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new ahsw(this, null);
              paramBundle.jdField_a_of_type_JavaLangString = ((String)???);
              paramBundle.b = str;
              this.jdField_b_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localObject1 = (ahsw)this.jdField_c_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new ahsw(this, null);
              paramBundle.jdField_a_of_type_JavaLangString = ((String)???);
              paramBundle.b = str;
              this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          return;
        }
      }
    } while (i != 10);
    BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wflNotRelease", "|", str, "|", ???, "|0|0" });
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str;
    label235:
    do
    {
      return;
      for (;;)
      {
        WeakReference localWeakReference;
        ahsx localahsx;
        try
        {
          str = BatteryStatsImpl.a().toString();
          if (!"release".equals(paramMethodHookParam.method.getName())) {
            break label289;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label286;
            }
            localWeakReference = (WeakReference)((Iterator)localObject2).next();
            localahsx = (ahsx)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
            if (localWeakReference.get() != paramMethodHookParam.thisObject) {
              break label235;
            }
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_rl|", localahsx.jdField_a_of_type_JavaLangString, "|", str });
            if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld())
            {
              BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_time|", localahsx.jdField_a_of_type_JavaLangString, "|", String.valueOf(SystemClock.uptimeMillis() - localahsx.jdField_a_of_type_Long) });
              ((Iterator)localObject2).remove();
            }
            a(localahsx, 9);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Throwable paramMethodHookParam) {}
        QLog.d("BatteryStats", 2, "", paramMethodHookParam);
        return;
        if (localWeakReference.get() == null)
        {
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_alarm|", localahsx.jdField_a_of_type_JavaLangString });
          ((Iterator)localObject2).remove();
          a(localahsx, 10);
        }
      }
      return;
    } while (!"createWifiLock".equals(paramMethodHookParam.method.getName()));
    label286:
    label289:
    ??? = new WeakReference((WifiManager.WifiLock)paramMethodHookParam.result);
    Object localObject2 = new ahsx(this, null);
    ((ahsx)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(localObject2.hashCode());
    ((ahsx)localObject2).c = str;
    if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 2)) {}
    for (((ahsx)localObject2).b = ((String)paramMethodHookParam.args[1]);; ((ahsx)localObject2).b = ((String)paramMethodHookParam.args[0])) {
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(???, localObject2);
        if (paramMethodHookParam.args.length != 1) {
          break;
        }
        BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_new|", ((ahsx)localObject2).jdField_a_of_type_JavaLangString, "|0|", String.valueOf(paramMethodHookParam.args[0]) });
        return;
      } while ((paramMethodHookParam.args == null) || (paramMethodHookParam.args.length != 1));
    }
    BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_new|", ((ahsx)localObject2).jdField_a_of_type_JavaLangString, "|", String.valueOf(paramMethodHookParam.args[0]), "|", String.valueOf(paramMethodHookParam.args[1]) });
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      this.e.clear();
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str;
    label345:
    do
    {
      do
      {
        return;
        try
        {
          str = BatteryStatsImpl.a().toString();
          if (QLog.isColorLevel()) {
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, paramMethodHookParam.method.getName() + str);
          }
          if (!"startScan".equals(paramMethodHookParam.method.getName())) {
            break label345;
          }
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wfScan", "|", str });
          paramMethodHookParam = this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_a_of_type_Int + " in " + this.jdField_a_of_type_Long / 60L / 1000L + " seconds", HighFrequencyDetector.a(paramMethodHookParam));
            this.jdField_a_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector.a();
          }
          paramMethodHookParam = this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_b_of_type_Int + " in " + this.jdField_b_of_type_Long / 60L / 1000L + " seconds", HighFrequencyDetector.a(paramMethodHookParam));
            this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryHighFrequencyDetector.a();
          }
          paramMethodHookParam = new Bundle();
          paramMethodHookParam.putInt("key_action", 8);
          paramMethodHookParam.putString("key_stack", str);
          if (BatteryStatsImpl.a()) {
            break;
          }
          BatteryIPCModule.a().a(paramMethodHookParam);
          return;
        }
        catch (Throwable paramMethodHookParam) {}
      } while (!QLog.isColorLevel());
      QLog.d("BatteryStats", 2, "", paramMethodHookParam);
      return;
      a(paramMethodHookParam);
      return;
    } while (!"acquire".equals(paramMethodHookParam.method.getName()));
    for (;;)
    {
      Iterator localIterator;
      WeakReference localWeakReference;
      ahsx localahsx;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        localahsx = (ahsx)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
        if (localWeakReference.get() == paramMethodHookParam.thisObject)
        {
          BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_ac|", localahsx.jdField_a_of_type_JavaLangString, "|", str });
          if (((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld()) {
            continue;
          }
          localahsx.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
      }
      if (localWeakReference.get() == null)
      {
        BatteryStatsImpl.a(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "wf_alarm|", localahsx.jdField_a_of_type_JavaLangString });
        localIterator.remove();
      }
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JavaHookBridge.findAndHookMethod(WifiManager.class, "startScan", new Object[] { this });
        JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { Integer.TYPE, String.class, this });
        JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { String.class, this });
        JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "acquire", new Object[] { this });
        JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "release", new Object[] { this });
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("BatteryStats", 2, "", localThrowable);
  }
  
  public void e()
  {
    super.e();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean) && (BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl))) {}
    label279:
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        Iterator localIterator1 = this.jdField_d_of_type_JavaUtilHashMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "fg30WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = BatteryLog.a();
          HashSet localHashSet = (HashSet)this.jdField_d_of_type_JavaUtilHashMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label279;
            }
            localStringBuilder.append("#");
            break label279;
          }
          BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "fg30WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_d_of_type_JavaUtilHashMap.clear();
      a(true);
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if ((BatteryStatsImpl.a()) && (this.jdField_a_of_type_Boolean) && (BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl))) {}
    label278:
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        Iterator localIterator1 = this.e.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "bg5WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.e.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = BatteryLog.a();
          HashSet localHashSet = (HashSet)this.e.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label278;
            }
            localStringBuilder.append("#");
            break label278;
          }
          BatteryStatsImpl.b(this.jdField_b_of_type_ComTencentMobileqqStatisticsBatteryBatteryStatsImpl, new String[] { "bg5WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.e.clear();
      a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahsv
 * JD-Core Version:    0.7.0.1
 */