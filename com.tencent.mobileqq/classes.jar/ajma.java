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

public class ajma
  implements ajmd, BusinessObserver
{
  private WeakReference<ajme> a;
  
  private ReportTrace.ReportHead a(ajlr paramajlr, String paramString)
  {
    ReportTrace.ReportHead localReportHead = new ReportTrace.ReportHead();
    localReportHead.appid.set(paramajlr.a());
    localReportHead.platform.set(109);
    paramajlr = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramajlr = "8.2.8";
    }
    localReportHead.ver.set(paramajlr);
    paramajlr = bbct.e();
    if (!TextUtils.isEmpty(paramajlr)) {
      localReportHead.os_ver.set(paramajlr);
    }
    paramajlr = bbct.i();
    if (!TextUtils.isEmpty(paramajlr)) {
      localReportHead.model.set(paramajlr);
    }
    paramajlr = bbct.a();
    if (!TextUtils.isEmpty(paramajlr)) {
      localReportHead.udid.set(paramajlr);
    }
    return localReportHead;
  }
  
  private ReportTrace.SpanEntry a(ajmk paramajmk)
  {
    ReportTrace.SpanEntry localSpanEntry = new ReportTrace.SpanEntry();
    localSpanEntry.span_id.set(paramajmk.jdField_a_of_type_Int);
    localSpanEntry.time_stamp.set(paramajmk.jdField_a_of_type_Long);
    if (paramajmk.jdField_a_of_type_Ajmj != null) {
      localSpanEntry.result.set(a(paramajmk.jdField_a_of_type_Ajmj));
    }
    if ((paramajmk.jdField_a_of_type_JavaUtilMap != null) && (paramajmk.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      paramajmk = paramajmk.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (paramajmk.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramajmk.next();
        ReportTrace.ExtParam localExtParam = new ReportTrace.ExtParam();
        localExtParam.param_id.set(((Integer)localEntry.getKey()).intValue());
        localExtParam.value.set(((Long)localEntry.getValue()).longValue());
        localSpanEntry.param_list.add(localExtParam);
      }
    }
    return localSpanEntry;
  }
  
  private ReportTrace.TraceEntry a(TraceData paramTraceData, ajlr paramajlr)
  {
    ReportTrace.TraceEntry localTraceEntry = new ReportTrace.TraceEntry();
    localTraceEntry.feature_id.set(paramTraceData.featureId);
    localTraceEntry.trace_id.set(paramTraceData.traceId);
    localTraceEntry.from_uid.set(paramajlr.a());
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
      paramajlr = paramTraceData.mSpanQueue.iterator();
      while (paramajlr.hasNext())
      {
        ajmk localajmk = (ajmk)paramajlr.next();
        localTraceEntry.span_list.add(a(localajmk));
      }
    }
    localTraceEntry.extra1.set(paramTraceData.extra1);
    localTraceEntry.extra2.set(paramTraceData.extra2);
    localTraceEntry.extra3.set(paramTraceData.extra3);
    return localTraceEntry;
  }
  
  private ReportTrace.reportStat a(ajmj paramajmj)
  {
    ReportTrace.reportStat localreportStat = new ReportTrace.reportStat();
    localreportStat.ret.set(paramajmj.jdField_a_of_type_Int);
    localreportStat.cost.set(paramajmj.b);
    localreportStat.net_type.set(paramajmj.e);
    localreportStat.cpu.set(paramajmj.d);
    localreportStat.memory.set(paramajmj.c);
    localreportStat.java_heap.set(paramajmj.f);
    localreportStat.native_heap.set(paramajmj.g);
    return localreportStat;
  }
  
  private List<ReportTrace.SpanAnnoEntry> a(BlockingQueue<ajmk> paramBlockingQueue)
  {
    if ((paramBlockingQueue == null) || (paramBlockingQueue.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBlockingQueue = paramBlockingQueue.iterator();
    while (paramBlockingQueue.hasNext())
    {
      ajmk localajmk = (ajmk)paramBlockingQueue.next();
      if ((localajmk.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (localajmk.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
      {
        Iterator localIterator = localajmk.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
        while (localIterator.hasNext())
        {
          ajmh localajmh = (ajmh)localIterator.next();
          ReportTrace.SpanAnnoEntry localSpanAnnoEntry = new ReportTrace.SpanAnnoEntry();
          localSpanAnnoEntry.span_id.set(localajmk.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localajmh.jdField_a_of_type_JavaLangString)) {
            localSpanAnnoEntry.anno_msg.set(localajmh.jdField_a_of_type_JavaLangString);
          }
          if (localajmk.jdField_a_of_type_Ajmj != null) {
            localSpanAnnoEntry.errCode.set(localajmk.jdField_a_of_type_Ajmj.jdField_a_of_type_Int);
          }
          localSpanAnnoEntry.time_stamp.set(localajmh.jdField_a_of_type_Long);
          localArrayList.add(localSpanAnnoEntry);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(AppRuntime paramAppRuntime, ajlr paramajlr, String paramString, List<ReportTrace.TraceEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramajlr == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportTraceReq localReportTraceReq = new ReportTrace.ReportTraceReq();
    localReportTraceReq.head.set(a(paramajlr, paramString));
    localReportTraceReq.trace_list.set(paramList);
    paramajlr = new NewIntent(paramAppRuntime.getApplication(), ajmg.class);
    paramajlr.putExtra("cmd", "apollo_monitor.report_trace");
    paramajlr.putExtra("data", localReportTraceReq.toByteArray());
    paramajlr.putExtra("timeout", 30000);
    paramajlr.setObserver(this);
    paramAppRuntime.startServlet(paramajlr);
  }
  
  private void b(AppRuntime paramAppRuntime, ajlr paramajlr, String paramString, List<ReportTrace.TraceAnnoEntry> paramList)
  {
    if ((paramAppRuntime == null) || (paramajlr == null) || (paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ReportTrace.ReportAnnoReq localReportAnnoReq = new ReportTrace.ReportAnnoReq();
    localReportAnnoReq.head.set(a(paramajlr, paramString));
    localReportAnnoReq.anno_list.set(paramList);
    paramajlr = new NewIntent(paramAppRuntime.getApplication(), ajmg.class);
    paramajlr.putExtra("cmd", "apollo_monitor.report_anno");
    paramajlr.putExtra("data", localReportAnnoReq.toByteArray());
    paramajlr.putExtra("timeout", 30000);
    paramajlr.setObserver(this);
    paramAppRuntime.startServlet(paramajlr);
  }
  
  public void a(ajme paramajme)
  {
    this.a = new WeakReference(paramajme);
  }
  
  public void a(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    ajlr localajlr = ajlu.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localajlr != null) && (!TextUtils.isEmpty(localajlr.a())))
    {
      ArrayList localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceEntry localTraceEntry = a(localTraceData, localajlr);
        if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.2.8")))
        {
          ArrayList localArrayList2 = new ArrayList();
          localArrayList2.add(localTraceEntry);
          a(localAppRuntime, localajlr, localTraceData.version, localArrayList2);
        }
        else
        {
          localArrayList1.add(a(localTraceData, localajlr));
        }
      }
      a(localAppRuntime, localajlr, null, localArrayList1);
    }
  }
  
  public void b(List<TraceData> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    ajlr localajlr = ajlu.a().a();
    if ((localAppRuntime != null) && (paramList != null) && (localajlr != null) && (!TextUtils.isEmpty(localajlr.a())))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TraceData localTraceData = (TraceData)paramList.next();
        ReportTrace.TraceAnnoEntry localTraceAnnoEntry = new ReportTrace.TraceAnnoEntry();
        localTraceAnnoEntry.uid.set(localajlr.a());
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
            if ((!TextUtils.isEmpty(localTraceData.version)) && (!localTraceData.version.equals("8.2.8")))
            {
              localObject = new ArrayList();
              ((List)localObject).add(localTraceAnnoEntry);
              b(localAppRuntime, localajlr, localTraceData.version, (List)localObject);
              continue;
            }
            j = 1;
            localArrayList.add(localTraceAnnoEntry);
          }
        }
        i = j;
      }
      if (i != 0) {
        b(localAppRuntime, localajlr, null, localArrayList);
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
          localObject2 = (ajme)this.a.get();
          if (localObject2 != null)
          {
            ((ReportTrace.ReportTraceRsp)localObject1).mergeFrom(paramBundle.getByteArray("data"));
            int i = ((ReportTrace.ReportTraceRsp)localObject1).report_interval.get();
            int j = ((ReportTrace.ReportTraceRsp)localObject1).report_num.get();
            if (((ReportTrace.ReportTraceRsp)localObject1).report_fail.get() != 1) {
              continue;
            }
            bool = true;
            ((ajme)localObject2).a(i, j, bool);
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
          localObject2 = new NewIntent(((AppRuntime)localObject1).getApplication(), ajmg.class);
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
 * Qualified Name:     ajma
 * JD-Core Version:    0.7.0.1
 */