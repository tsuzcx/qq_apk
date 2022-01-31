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

public class aixy
  implements aiyb, BusinessObserver
{
  private WeakReference<aiyc> a;
  
  private ReportTrace.ReportHead a(aixp paramaixp, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramaixp.a());
    localReportHead.platform.set(109);
    paramaixp = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramaixp = "8.2.6";
    }
    localReportHead.ver.set(paramaixp);
    paramaixp = babp.e();
    if (!TextUtils.isEmpty(paramaixp)) {
      localReportHead.os_ver.set(paramaixp);
    }
    paramaixp = babp.i();
    if (!TextUtils.isEmpty(paramaixp)) {
      localReportHead.model.set(paramaixp);
    }
    paramaixp = babp.a();
    if (!TextUtils.isEmpty(paramaixp)) {
      localReportHead.udid.set(paramaixp);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(aiyi paramaiyi)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramaiyi.jdField_a_of_type_Int);
    localSpanEntry.time_stamp.set(paramaiyi.jdField_a_of_type_Long);
    if (paramaiyi.jdField_a_of_type_Aiyh != null) {
      localSpanEntry.result.set(a(paramaiyi.jdField_a_of_type_Aiyh));
    }
    if ((paramaiyi.jdField_a_of_type_JavaUtilMap != null) && (paramaiyi.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      paramaiyi = paramaiyi.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramaiyi.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramaiyi.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, aixp paramaixp)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramaixp.a());
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
      paramaixp = paramTraceData.mSpanQueue.iterator();
      while (paramaixp.hasNext())
      {
        aiyi localaiyi = (aiyi)paramaixp.next();
        localTraceEntry.span_list.add(a(localaiyi));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(aiyh paramaiyh)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramaiyh.jdField_a_of_type_Int);
    localreportStat.cost.set(paramaiyh.b);
    localreportStat.net_type.set(paramaiyh.e);
    localreportStat.cpu.set(paramaiyh.d);
    localreportStat.memory.set(paramaiyh.c);
    localreportStat.java_heap.set(paramaiyh.f);
    localreportStat.native_heap.set(paramaiyh.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<aiyi> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      aiyi localaiyi = (aiyi)paramBlockingQueue.next();
      if ((localaiyi.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (localaiyi.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
      {
        Iterator localIterator = localaiyi.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
        while (localIterator.hasNext())
        {
          aiyf localaiyf = (aiyf)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localaiyi.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localaiyf.jdField_a_of_type_JavaLangString)) {
            localSpanAnnoEntry.anno_msg.set(localaiyf.jdField_a_of_type_JavaLangString);
          }
          if (localaiyi.jdField_a_of_type_Aiyh != null) {
            localSpanAnnoEntry.errCode.set(localaiyi.jdField_a_of_type_Aiyh.jdField_a_of_type_Int);
          }
          localSpanAnnoEntry.time_stamp.set(localaiyf.jdField_a_of_type_Long);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, aixp paramaixp, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramaixp == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramaixp, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramaixp = new NewIntent(paramAppRuntime.getApplication(), aiye.class);
    paramaixp.putExtra("cmd", "apollo_monitor.report_trace");
    paramaixp.putExtra("data", localReportTraceReq.toByteArray());
    paramaixp.putExtra("timeout", 30000);
    paramaixp.setObserver(this);
    paramAppRuntime.startServlet(paramaixp);
  }
  
  private void b(AppRuntime paramAppRuntime, aixp paramaixp, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramaixp == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramaixp, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramaixp = new NewIntent(paramAppRuntime.getApplication(), aiye.class);
    paramaixp.putExtra("cmd", "apollo_monitor.report_anno");
    paramaixp.putExtra("data", localReportAnnoReq.toByteArray());
    paramaixp.putExtra("timeout", 30000);
    paramaixp.setObserver(this);
    paramAppRuntime.startServlet(paramaixp);
  }
  
  public void a(aiyc paramaiyc)
  {
    this.a = new WeakReference(paramaiyc);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    aixp localaixp = aixs.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localaixp != null) && (!TextUtils.isEmpty(localaixp.a())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localaixp);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.2.6")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localaixp, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localaixp));
        }
      }
      a(localAppRuntime, localaixp, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    aixp localaixp = aixs.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localaixp != null) && (!TextUtils.isEmpty(localaixp.a())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localaixp.a());
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
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.2.6")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localaixp, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localaixp, null, localArrayList);
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
          localObject2 = (aiyc)this.a.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((aiyc)localObject2).a(i, j, bool);
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
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), aiye.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixy
 * JD-Core Version:    0.7.0.1
 */