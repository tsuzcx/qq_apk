import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mm.hardcoder.HCPerfManager.1;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class abwo
{
  private static abwo jdField_a_of_type_Abwo;
  static RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  public static final String a;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 2, 3 };
  static RecyclablePool jdField_b_of_type_ComTencentCommonsdkPoolRecyclablePool;
  public static final String b;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 0, 1, 2, 3 };
  private LinkedBlockingQueue<Object> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue();
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(abwp.class, 4);
    jdField_b_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(abwq.class, 4);
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/hc/hardcoder.so";
    jdField_b_of_type_JavaLangString = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/hc/hardcoder_new.so";
  }
  
  public static abwo a()
  {
    if (jdField_a_of_type_Abwo == null) {}
    try
    {
      if (jdField_a_of_type_Abwo == null) {
        jdField_a_of_type_Abwo = new abwo();
      }
      return jdField_a_of_type_Abwo;
    }
    finally {}
  }
  
  private void b()
  {
    Log.i("HardCoder.HCPerfManager", String.format("HCPerfManager thread[%d] running", new Object[] { Long.valueOf(Thread.currentThread().getId()) }));
    Object localObject6 = new HashSet();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet2 = new HashSet();
    Object localObject5 = null;
    Object localObject4 = null;
    long l1 = 30000L;
    label441:
    label1091:
    label1116:
    label3676:
    for (;;)
    {
      int k;
      int i;
      int j;
      Object localObject3;
      HashSet localHashSet1;
      long l3;
      Object localObject8;
      Object localObject9;
      Object localObject2;
      long l2;
      Object localObject7;
      long l5;
      int m;
      int n;
      if (this.jdField_b_of_type_Boolean)
      {
        long l4 = System.currentTimeMillis();
        k = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.size();
        if (HardCoderJNI.hcDebug) {
          Log.d("HardCoder.HCPerfManager", "StartLoop queue:" + k + " startTask:" + localArrayList.size() + " nextWakeInterval:" + l1);
        }
        i = 0;
        if (k == 0)
        {
          j = 1;
          if (i >= j) {}
        }
        try
        {
          Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll(l1, TimeUnit.MILLISECONDS);
          if (localObject1 == null)
          {
            l1 = 30000L;
            localObject1 = null;
            localObject3 = null;
            localHashSet1 = new HashSet();
            l3 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
              Log.d("HardCoder.HCPerfManager", "InLoop startSize:" + localArrayList.size());
            }
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                localObject8 = (abwp)localArrayList.get(i);
                if (localObject8 == null)
                {
                  localObject9 = localObject1;
                  j = i;
                  i = j + 1;
                  localObject1 = localObject9;
                  continue;
                  j = k;
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("HardCoder.HCPerfManager", "queueTask poll: " + localException.getMessage());
            localObject2 = null;
            continue;
            if ((localObject2 instanceof abwp))
            {
              localArrayList.add((abwp)localObject2);
              localHashSet2.add(Integer.valueOf(((abwp)localObject2).hashCode()));
            }
            for (;;)
            {
              i += 1;
              break;
              if ((localObject2 instanceof abwq))
              {
                j = ((abwq)localObject2).jdField_a_of_type_Int;
                if (localHashSet2.contains(Integer.valueOf(j))) {
                  localHashMap.put(Integer.valueOf(j), (abwq)localObject2);
                } else {
                  ((abwq)localObject2).recycle();
                }
              }
              else
              {
                if (!HardCoderJNI.checkEnv) {
                  break label441;
                }
                bhsa.a("queueTask poll invalid object");
              }
            }
            a();
            continue;
            if (localHashMap.containsKey(Integer.valueOf(localObject8.hashCode())))
            {
              ((abwp)localObject8).jdField_d_of_type_Long = l3;
              ((abwp)localObject8).jdField_g_of_type_Long = ((abwq)localHashMap.get(Integer.valueOf(localObject8.hashCode()))).jdField_a_of_type_Long;
              localHashMap.remove(Integer.valueOf(localObject8.hashCode()));
            }
            l2 = ((abwp)localObject8).jdField_d_of_type_Long - l3;
            if (l2 <= 0L)
            {
              if (HardCoderJNI.hcDebug) {
                Log.d("HardCoder.HCPerfManager", "InLoop STOP:" + i + "/" + localArrayList.size() + " task:" + ((abwp)localObject8).a(l3));
              }
              localArrayList.remove(localObject8);
              localHashSet2.remove(Integer.valueOf(localObject8.hashCode()));
              ((abwp)localObject8).recycle();
              j = i - 1;
              localObject9 = localObject2;
            }
            else
            {
              l2 = Math.min(l1, l2);
              l1 = ((abwp)localObject8).jdField_b_of_type_Long - l3;
              if (l1 > 0L)
              {
                if (HardCoderJNI.hcDebug) {
                  Log.d("HardCoder.HCPerfManager", "InLoop WAIT:" + i + "/" + localArrayList.size() + " task:" + ((abwp)localObject8).a(l3));
                }
                l1 = Math.min(l2, l1);
                j = i;
                localObject9 = localObject2;
              }
              else
              {
                if (HardCoderJNI.hcDebug) {
                  Log.d("HardCoder.HCPerfManager", "InLoop  RUN:" + i + "/" + localArrayList.size() + " task:" + ((abwp)localObject8).a(l3));
                }
                localObject7 = localObject2;
                if (((abwp)localObject8).jdField_c_of_type_Int > 0) {
                  if ((localObject2 != null) && (localObject2.jdField_c_of_type_Int <= ((abwp)localObject8).jdField_c_of_type_Int))
                  {
                    localObject7 = localObject2;
                    if (localObject2.jdField_c_of_type_Int == ((abwp)localObject8).jdField_c_of_type_Int)
                    {
                      localObject7 = localObject2;
                      if (localObject2.jdField_d_of_type_Long >= ((abwp)localObject8).jdField_d_of_type_Long) {}
                    }
                  }
                  else
                  {
                    localObject7 = localObject8;
                  }
                }
                localObject2 = localObject3;
                if (((abwp)localObject8).jdField_d_of_type_Int > 0) {
                  if ((localObject3 != null) && (localObject3.jdField_d_of_type_Int <= ((abwp)localObject8).jdField_d_of_type_Int))
                  {
                    localObject2 = localObject3;
                    if (localObject3.jdField_d_of_type_Int == ((abwp)localObject8).jdField_d_of_type_Int)
                    {
                      localObject2 = localObject3;
                      if (localObject3.jdField_d_of_type_Long >= ((abwp)localObject8).jdField_d_of_type_Long) {}
                    }
                  }
                  else
                  {
                    localObject2 = localObject8;
                  }
                }
                j = i;
                l1 = l2;
                localObject3 = localObject2;
                localObject9 = localObject7;
                if (((abwp)localObject8).jdField_e_of_type_Int > 0)
                {
                  localHashSet1.add(localObject8);
                  j = i;
                  l1 = l2;
                  localObject3 = localObject2;
                  localObject9 = localObject7;
                }
              }
            }
          }
          l5 = System.currentTimeMillis();
          if (HardCoderJNI.hcDebug)
          {
            Log.d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l5 - l3), Long.valueOf(l5 - l4), Integer.valueOf(localArrayList.size()), Integer.valueOf(localHashMap.size()), Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            localObject8 = new StringBuilder().append("EndLoop CurrCpu:");
            if (localObject4 != null) {
              break label1314;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxCpu:");
            if (localObject2 != null) {
              break label1326;
            }
            localObject7 = "null";
            Log.d("HardCoder.HCPerfManager", (String)localObject7);
            localObject8 = new StringBuilder().append("EndLoop CurrIO:");
            if (localObject5 != null) {
              break label1338;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxIO:");
            if (localObject3 != null) {
              break label1350;
            }
          }
          for (localObject7 = "null";; localObject7 = localObject3.a(l3))
          {
            Log.d("HardCoder.HCPerfManager", (String)localObject7);
            Log.d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            if ((localObject2 != localObject4) || (localObject3 != localObject5) || (((HashSet)localObject6).size() != localHashSet1.size())) {
              break label1362;
            }
            localObject7 = new HashSet();
            ((HashSet)localObject7).addAll((Collection)localObject6);
            ((HashSet)localObject7).removeAll(localHashSet1);
            if (!((HashSet)localObject7).isEmpty()) {
              break label1362;
            }
            if (!HardCoderJNI.hcDebug) {
              break label3676;
            }
            Log.i("HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
            break;
            localObject7 = ((abwp)localObject4).a(l3);
            break label1091;
            localObject7 = localObject2.a(l3);
            break label1116;
            localObject7 = ((abwp)localObject5).a(l3);
            break label1157;
          }
          l2 = 0L;
          j = 0;
          m = 2147483647;
          localObject8 = new HashSet();
          ((HashSet)localObject8).addAll((Collection)localObject6);
          ((HashSet)localObject8).removeAll(localHashSet1);
          i = ((HashSet)localObject8).size();
          if (i > 0)
          {
            localObject6 = new int[i];
            localObject7 = ((HashSet)localObject8).iterator();
            i = 0;
            while (((Iterator)localObject7).hasNext())
            {
              localObject9 = (abwp)((Iterator)localObject7).next();
              Log.i("HardCoder.HCPerfManager", "!cancelBindCore task:" + ((abwp)localObject9).a(l3));
              if ((((abwp)localObject9).jdField_d_of_type_Long <= l3) || (HardCoderJNI.checkEnv))
              {
                if (((abwp)localObject9).jdField_e_of_type_Int == 0)
                {
                  if (!HardCoderJNI.checkEnv) {
                    break label1799;
                  }
                  bhsa.a("bindTid:" + ((abwp)localObject9).jdField_e_of_type_Int);
                }
                localObject6[i] = ((abwp)localObject9).jdField_e_of_type_Int;
                i += 1;
              }
              else
              {
                a();
              }
            }
          }
          for (;;)
          {
            if ((!jdField_a_of_type_Boolean) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelCpuCoreForThread((int[])localObject6, android.os.Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            localObject9 = new int[localHashSet1.size()];
            localObject6 = localHashSet1.iterator();
            n = 0;
            k = 0;
            i = m;
            m = n;
            for (;;)
            {
              if (!((Iterator)localObject6).hasNext()) {
                break label1810;
              }
              localObject7 = (abwp)((Iterator)localObject6).next();
              Log.i("HardCoder.HCPerfManager", "requestBindCore task:" + ((abwp)localObject7).a(l3));
              if (((abwp)localObject7).jdField_d_of_type_Long <= l3)
              {
                if (!HardCoderJNI.checkEnv) {
                  break;
                }
                bhsa.a("stopTime:" + (((abwp)localObject7).jdField_d_of_type_Long - l3));
              }
              if (((abwp)localObject7).jdField_e_of_type_Int == 0)
              {
                if (!HardCoderJNI.checkEnv) {
                  break label2380;
                }
                bhsa.a("bindTid:" + ((abwp)localObject7).jdField_e_of_type_Int);
              }
              localObject9[m] = ((abwp)localObject7).jdField_e_of_type_Int;
              m += 1;
              k = ((abwp)localObject7).jdField_f_of_type_Int;
              l2 = ((abwp)localObject7).jdField_a_of_type_Long;
              j = ((abwp)localObject7).jdField_g_of_type_Int;
              i = Math.min((int)(((abwp)localObject7).jdField_d_of_type_Long - l3), i);
            }
            a();
          }
          a();
        }
        if (localObject3 == null)
        {
          if (localObject5 != null)
          {
            Log.i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + ((abwp)localObject5).a(l3));
            if ((!jdField_a_of_type_Boolean) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelHighIOFreq(((abwp)localObject5).jdField_g_of_type_Int, SystemClock.elapsedRealtimeNanos());
            }
          }
          if (localObject3 == null) {
            break label3670;
          }
          m = localObject3.jdField_d_of_type_Int;
          k = localObject3.jdField_f_of_type_Int;
          l2 = localObject3.jdField_a_of_type_Long;
          j = localObject3.jdField_g_of_type_Int;
          i = Math.min((int)(localObject3.jdField_d_of_type_Long - l3), i);
        }
      }
      for (;;)
      {
        int i1;
        if (localObject2 == null)
        {
          if (localObject4 != null)
          {
            Log.i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + ((abwp)localObject4).a(l3));
            if ((!jdField_a_of_type_Boolean) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelCpuHighFreq(((abwp)localObject4).jdField_g_of_type_Int, SystemClock.elapsedRealtimeNanos());
            }
          }
          if (localObject2 == null) {
            break label3652;
          }
          i1 = localObject2.jdField_c_of_type_Int;
          k = localObject2.jdField_f_of_type_Int;
          l2 = localObject2.jdField_a_of_type_Long;
          n = localObject2.jdField_g_of_type_Int;
          j = Math.min((int)(localObject2.jdField_d_of_type_Long - l3), i);
          i = i1;
        }
        for (;;)
        {
          if (j < 2147483647)
          {
            i1 = localObject9.length;
            if (localObject2 != null) {
              break label2591;
            }
            localObject4 = "null";
            if (localObject3 != null) {
              break label2603;
            }
            localObject5 = "null";
            if (localObject2 != null) {
              break label2615;
            }
            localObject6 = "null";
            if (localObject3 != null) {
              break label2627;
            }
            localObject7 = "null";
            Log.i("HardCoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7 }));
            if (j <= 0) {
              break label2639;
            }
            bool = true;
            bhsa.a(bool);
            if ((k <= 0) && (l2 <= 0L)) {
              break label2645;
            }
            bool = true;
            bhsa.a(bool);
            if (n <= 0) {
              break label2651;
            }
            bool = true;
            bhsa.a(bool);
            if ((i <= 0) && (m <= 0) && (localObject9.length <= 0)) {
              break label2657;
            }
          }
          label2657:
          for (boolean bool = true;; bool = false)
          {
            bhsa.a(bool);
            if (!jdField_a_of_type_Boolean)
            {
              HardCoderJNI.requestUnifyCpuIOThreadCore(k, l2, i, m, (int[])localObject9, j, n, SystemClock.elapsedRealtimeNanos());
              Log.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j) }));
              if (localObject9.length > 0) {
                Log.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCore bindTid=%d", new Object[] { Integer.valueOf(localObject9[0]) }));
              }
            }
            if (jdField_a_of_type_Boolean) {
              break label2663;
            }
            localObject6 = localHashSet1;
            localObject5 = localObject3;
            localObject4 = localObject2;
            break;
            a();
            break label1810;
            if ((localObject5 == localObject3) || (!HardCoderJNI.hcDebug)) {
              break label1876;
            }
            localObject6 = new StringBuilder().append("IOReq:");
            if (localObject5 == null) {}
            for (localObject5 = "null";; localObject5 = ((abwp)localObject5).a(l3))
            {
              Log.d("HardCoder.HCPerfManager", (String)localObject5 + " -> " + localObject3.a(l3) + " delay:" + (l5 - localObject3.jdField_b_of_type_Long));
              break;
            }
            if ((localObject4 == localObject2) || (!HardCoderJNI.hcDebug)) {
              break label1987;
            }
            localObject5 = new StringBuilder().append("CPUReq:");
            if (localObject4 == null) {}
            for (localObject4 = "null";; localObject4 = ((abwp)localObject4).a(l3))
            {
              Log.d("HardCoder.HCPerfManager", (String)localObject4 + " -> " + localObject2.a(l3) + " delay:" + (l5 - localObject2.jdField_b_of_type_Long));
              break;
            }
            localObject4 = localObject2.a(l3);
            break label2058;
            localObject5 = localObject3.a(l3);
            break label2068;
            localObject6 = localObject2.a(l3);
            break label2078;
            localObject7 = localObject3.a(l3);
            break label2088;
            bool = false;
            break label2190;
            bool = false;
            break label2209;
            bool = false;
            break label2222;
          }
          label2663:
          if (localObject2 == localObject2)
          {
            bool = true;
            bhsa.a(bool);
            if (localObject3 != localObject3) {
              break label3195;
            }
            bool = true;
            bhsa.a(bool);
            if (localArrayList.isEmpty())
            {
              if (l1 != 30000L) {
                break label3201;
              }
              bool = true;
              bhsa.a(bool);
              if (j != 2147483647) {
                break label3207;
              }
              bool = true;
              bhsa.a(bool);
              bhsa.a(localHashSet1.isEmpty());
              if (localObject2 != null) {
                break label3213;
              }
              bool = true;
              bhsa.a(bool);
              if (localObject3 != null) {
                break label3219;
              }
              bool = true;
              bhsa.a(bool);
            }
            k = 0;
            if (k >= localArrayList.size()) {
              break label3636;
            }
            localObject4 = (abwp)localArrayList.get(k);
            if (HardCoderJNI.hcDebug) {
              Log.d("HardCoder.HCPerfManager", "CheckTask:" + k + "/" + localArrayList.size() + " task:" + ((abwp)localObject4).a(l3));
            }
            if ((((abwp)localObject4).jdField_c_of_type_Int <= 0) && (((abwp)localObject4).jdField_d_of_type_Int <= 0) && (((abwp)localObject4).jdField_e_of_type_Int <= 0)) {
              break label3225;
            }
            bool = true;
            bhsa.a(bool);
            if ((((abwp)localObject4).jdField_a_of_type_Long <= 0L) && (((abwp)localObject4).jdField_f_of_type_Int <= 0)) {
              break label3231;
            }
            bool = true;
            bhsa.a(bool);
            localObject5 = "taskInintTime:" + (((abwp)localObject4).jdField_c_of_type_Long - l3);
            if (((abwp)localObject4).jdField_c_of_type_Long > l3) {
              break label3237;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "taskStopTime:" + (((abwp)localObject4).jdField_d_of_type_Long - l3);
            if (((abwp)localObject4).jdField_d_of_type_Long < l3) {
              break label3243;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "taskHash:" + localObject4.hashCode();
            if (localHashMap.containsKey(Integer.valueOf(localObject4.hashCode()))) {
              break label3249;
            }
            bool = true;
            label3052:
            bhsa.a((String)localObject5, bool);
            if (((abwp)localObject4).jdField_b_of_type_Long <= l3) {
              break label3279;
            }
            if (localObject4 == localObject2) {
              break label3255;
            }
            bool = true;
            bhsa.a(bool);
            if (localObject4 == localObject3) {
              break label3261;
            }
            bool = true;
            bhsa.a(bool);
            if (localHashSet1.contains(localObject4)) {
              break label3267;
            }
            bool = true;
            bhsa.a(bool);
            localObject5 = "next:" + l1 + " start:" + (((abwp)localObject4).jdField_b_of_type_Long - l3);
            if (l1 > ((abwp)localObject4).jdField_b_of_type_Long - l3) {
              break label3273;
            }
            bool = true;
            label3175:
            bhsa.a((String)localObject5, bool);
          }
          label3195:
          do
          {
            k += 1;
            break label2769;
            bool = false;
            break;
            bool = false;
            break label2688;
            bool = false;
            break label2713;
            bool = false;
            break label2728;
            bool = false;
            break label2749;
            bool = false;
            break label2762;
            bool = false;
            break label2876;
            bool = false;
            break label2902;
            bool = false;
            break label2950;
            bool = false;
            break label3000;
            bool = false;
            break label3052;
            bool = false;
            break label3080;
            bool = false;
            break label3095;
            bool = false;
            break label3113;
            bool = false;
            break label3175;
            localObject5 = "nextWake:" + l1 + " stop:" + (((abwp)localObject4).jdField_d_of_type_Long - l3);
            if (l1 > ((abwp)localObject4).jdField_d_of_type_Long - l3) {
              break label3600;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "reqTimeStamp:" + j;
            if ((j <= 0) || (j >= 9223372036854775807L)) {
              break label3606;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "reqTimeStamp:" + j + " stop:" + (((abwp)localObject4).jdField_d_of_type_Long - l3);
            if (j > ((abwp)localObject4).jdField_d_of_type_Long - l3) {
              break label3612;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "reqCpu:" + i + " task:" + ((abwp)localObject4).jdField_c_of_type_Int;
            if (i > ((abwp)localObject4).jdField_c_of_type_Int) {
              break label3618;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
            localObject5 = "reqIO:" + m + " task:" + ((abwp)localObject4).jdField_d_of_type_Int;
            if (m > ((abwp)localObject4).jdField_d_of_type_Int) {
              break label3624;
            }
            bool = true;
            bhsa.a((String)localObject5, bool);
          } while (((abwp)localObject4).jdField_e_of_type_Int <= 0);
          label3444:
          bhsa.a(localHashSet1.contains(localObject4));
          label3554:
          if (!((HashSet)localObject8).contains(localObject4)) {}
          for (bool = true;; bool = false)
          {
            bhsa.a(bool);
            break;
            bool = false;
            break label3336;
            bool = false;
            break label3381;
            bool = false;
            break label3444;
            bool = false;
            break label3498;
            bool = false;
            break label3554;
          }
          localObject6 = localHashSet1;
          localObject5 = localObject3;
          localObject4 = localObject2;
          break;
          return;
          n = i;
          i1 = j;
          i = 0;
          j = n;
          n = i1;
        }
        m = 0;
      }
    }
  }
  
  int a()
  {
    int j = 0;
    Object localObject = null;
    try
    {
      str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop persist.sys.hardcoder.name").getInputStream())).readLine();
      localObject = str;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          String str;
          int i;
          System.load(jdField_b_of_type_JavaLangString);
          HardCoderJNI.initHardCoder((String)localObject, 0, "testapp.hardcoder.client.sock", false);
          this.jdField_b_of_type_Boolean = true;
          localObject = new Thread(new HCPerfManager.1(this), "hardcoder-0");
          ((Thread)localObject).setPriority(1);
          ((Thread)localObject).start();
          return 10;
        }
        catch (Throwable localThrowable1)
        {
          QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable1);
          return 7;
        }
        localThrowable2 = localThrowable2;
        QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable2);
      }
    }
    str = Build.CPU_ABI;
    i = j;
    if (str != null)
    {
      i = j;
      if (!str.contains("x86"))
      {
        i = j;
        if (!str.contains("mips")) {
          i = 1;
        }
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0))
    {
      if (new File(jdField_b_of_type_JavaLangString).exists()) {}
      return 4;
    }
    return 1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    abwp localabwp = (abwp)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(abwp.class);
    localabwp.jdField_a_of_type_Int = paramInt1;
    localabwp.jdField_c_of_type_Int = paramInt2;
    localabwp.jdField_d_of_type_Int = paramInt3;
    localabwp.jdField_e_of_type_Int = paramInt4;
    localabwp.jdField_b_of_type_Int = paramInt5;
    localabwp.jdField_f_of_type_Int = paramInt6;
    localabwp.jdField_a_of_type_Long = paramLong;
    localabwp.jdField_g_of_type_Int = paramInt7;
    localabwp.jdField_c_of_type_Long = System.currentTimeMillis();
    localabwp.jdField_b_of_type_Long = (localabwp.jdField_c_of_type_Long + paramInt1);
    localabwp.jdField_d_of_type_Long = (localabwp.jdField_c_of_type_Long + paramInt1 + paramInt5);
    localabwp.jdField_a_of_type_JavaLangString = paramString;
    localabwp.jdField_e_of_type_Long = localabwp.jdField_b_of_type_Long;
    localabwp.jdField_f_of_type_Long = localabwp.jdField_c_of_type_Long;
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt5 <= 0) || ((paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)))
    {
      Log.e("HardCoder.HCPerfManager", "ErrorParam task:" + localabwp.a(localabwp.jdField_c_of_type_Long));
      return 0;
    }
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(localabwp);
    if (HardCoderJNI.hcDebug) {
      Log.d("HardCoder.HCPerfManager", "OutCallAddTask ret:" + bool + " task:" + localabwp.a(localabwp.jdField_c_of_type_Long));
    }
    if (bool) {
      return localabwp.hashCode();
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a(int paramInt)
  {
    abwq localabwq = (abwq)jdField_b_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(abwq.class);
    localabwq.jdField_a_of_type_Long = System.currentTimeMillis();
    localabwq.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0) {}
    for (boolean bool = this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(localabwq);; bool = false)
    {
      if (HardCoderJNI.hcDebug) {
        Log.d("HardCoder.HCPerfManager", String.format("OutCallStopTask ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwo
 * JD-Core Version:    0.7.0.1
 */