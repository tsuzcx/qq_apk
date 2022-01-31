import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.ReportTrace.ExtParam;
import com.tencent.pb.ReportTrace.ReportAnnoReq;
import com.tencent.pb.ReportTrace.ReportHead;
import com.tencent.pb.ReportTrace.ReportTraceReq;
import com.tencent.pb.ReportTrace.ReportTraceRsp;
import com.tencent.pb.ReportTrace.SpanAnnoEntry;
import com.tencent.pb.ReportTrace.SpanEntry;
import com.tencent.pb.ReportTrace.TraceAnnoEntry;
import com.tencent.pb.ReportTrace.TraceEntry;
import com.tencent.pb.ReportTrace.reportStat;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class alia
  implements alid, BusinessObserver
{
  private WeakReference<alie> a;
  
  private ReportTrace.ReportHead a(alhq paramalhq, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramalhq.a());
    localReportHead.platform.set(109);
    paramalhq = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramalhq = "8.3.5";
    }
    localReportHead.ver.set(paramalhq);
    paramalhq = bdgk.e();
    if (!TextUtils.isEmpty(paramalhq)) {
      localReportHead.os_ver.set(paramalhq);
    }
    paramalhq = bdgk.i();
    if (!TextUtils.isEmpty(paramalhq)) {
      localReportHead.model.set(paramalhq);
    }
    paramalhq = bdgk.a();
    if (!TextUtils.isEmpty(paramalhq)) {
      localReportHead.udid.set(paramalhq);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(alik paramalik)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramalik.jdField_a_of_type_Int);
    localSpanEntry.time_stamp.set(paramalik.jdField_a_of_type_Long);
    if (paramalik.jdField_a_of_type_Alij != null) {
      localSpanEntry.result.set(a(paramalik.jdField_a_of_type_Alij));
    }
    if ((paramalik.jdField_a_of_type_JavaUtilMap != null) && (paramalik.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      paramalik = paramalik.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramalik.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramalik.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, alhq paramalhq)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramalhq.a());
    if (!TextUtils.isEmpty(paramTraceData.tUid)) {
      localTraceEntry.to_uid.set(paramTraceData.tUid);
    }
    localTraceEntry.time_stamp.set(paramTraceData.timestamp);
    localTraceEntry.server_timestamp.set(paramTraceData.serverTime);
    if (paramTraceData.result != null) {
      localTraceEntry.result.set(a(paramTraceData.result));
    }
    if (paramTraceData.mSpanQueue != null)
    {
      paramalhq = paramTraceData.mSpanQueue.iterator();
      while (paramalhq.hasNext())
      {
        alik localalik = (alik)paramalhq.next();
        localTraceEntry.span_list.add(a(localalik));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(alij paramalij)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramalij.jdField_a_of_type_Int);
    localreportStat.cost.set(paramalij.b);
    localreportStat.net_type.set(paramalij.e);
    localreportStat.cpu.set(paramalij.d);
    localreportStat.memory.set(paramalij.c);
    localreportStat.java_heap.set(paramalij.f);
    localreportStat.native_heap.set(paramalij.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<alik> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      alik localalik = (alik)paramBlockingQueue.next();
      if ((localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
      {
        Iterator localIterator = localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
        while (localIterator.hasNext())
        {
          alih localalih = (alih)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localalik.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localalih.jdField_a_of_type_JavaLangString)) {
            localSpanAnnoEntry.anno_msg.set(localalih.jdField_a_of_type_JavaLangString);
          }
          if (localalik.jdField_a_of_type_Alij != null) {
            localSpanAnnoEntry.errCode.set(localalik.jdField_a_of_type_Alij.jdField_a_of_type_Int);
          }
          localSpanAnnoEntry.time_stamp.set(localalih.jdField_a_of_type_Long);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, alhq paramalhq, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramalhq == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramalhq, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramalhq = new NewIntent(paramAppRuntime.getApplication(), alig.class);
    paramalhq.putExtra("cmd", "apollo_monitor.report_trace");
    paramalhq.putExtra("data", localReportTraceReq.toByteArray());
    paramalhq.putExtra("timeout", 30000);
    paramalhq.setObserver(this);
    paramAppRuntime.startServlet(paramalhq);
  }
  
  private void b(AppRuntime paramAppRuntime, alhq paramalhq, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramalhq == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramalhq, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramalhq = new NewIntent(paramAppRuntime.getApplication(), alig.class);
    paramalhq.putExtra("cmd", "apollo_monitor.report_anno");
    paramalhq.putExtra("data", localReportAnnoReq.toByteArray());
    paramalhq.putExtra("timeout", 30000);
    paramalhq.setObserver(this);
    paramAppRuntime.startServlet(paramalhq);
  }
  
  public void a(alie paramalie)
  {
    this.a = new WeakReference(paramalie);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    alhq localalhq = alht.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localalhq != null) && (!TextUtils.isEmpty(localalhq.a())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localalhq);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.3.5")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localalhq, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localalhq));
        }
      }
      a(localAppRuntime, localalhq, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    alhq localalhq = alht.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localalhq != null) && (!TextUtils.isEmpty(localalhq.a())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localalhq.a());
        localTraceAnnoEntry.trace_id.set(localTraceData.traceId);
        localTraceAnnoEntry.feature_id.set(localTraceData.featureId);
        localTraceAnnoEntry.server_timestamp.set(localTraceData.serverTime);
        int j = i;
        if (localTraceData.result != null)
        {
          j = i;
          if (localTraceData.result.jdField_a_of_type_Int != 0)
          {
            localTraceAnnoEntry.ret.set(localTraceData.result.jdField_a_of_type_Int);
            Object localObject = a(localTraceData.mSpanQueue);
            if (localObject != null) {
              localTraceAnnoEntry.span_anno_list.addAll((Collection)localObject);
            }
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.3.5")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localalhq, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localalhq, null, localArrayList);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    if (("apollo_monitor.report_trace".equals(str)) || ("apollo_monitor.report_anno".equals(str)))
    {
      if (paramBoolean) {
        break label318;
      }
      paramInt = paramBundle.getInt("retryTime");
      QLog.w("TraceReport", 1, "cmd:" + str + ",retryTime:" + paramInt);
    }
    for (;;)
    {
      Object localObject1;
      if (("apollo_monitor.report_trace".equals(str)) && (paramBoolean) && (this.a != null)) {
        localObject1 = new ReportTrace.ReportTraceRsp();
      }
      for (;;)
      {
        try
        {
          localObject2 = (alie)this.a.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((alie)localObject2).a(i, j, bool);
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          boolean bool;
          QLog.e("TraceReport", 1, localException, new Object[0]);
          continue;
        }
        localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((!paramBoolean) && (paramInt < 1) && (localObject1 != null))
        {
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), alig.class);
          ((NewIntent)localObject2).putExtra("retryTime", paramInt + 1);
          ((NewIntent)localObject2).putExtra("cmd", str);
          ((NewIntent)localObject2).putExtra("data", paramBundle.getByteArray("request_data"));
          ((NewIntent)localObject2).putExtra("timeout", 30000);
          ((NewIntent)localObject2).setObserver(this);
          ((AppRuntime)localObject1).startServlet((NewIntent)localObject2);
        }
        return;
        bool = false;
      }
      label318:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alia
 * JD-Core Version:    0.7.0.1
 */