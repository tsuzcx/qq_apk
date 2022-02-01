package com.tencent.mm.plugin.wxpayreport;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpayreport.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "mCustomRecordMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/wxpayreport/api/ReportAbnormalOptions;", "Lkotlin/collections/HashMap;", "getMCustomRecordMap", "()Ljava/util/HashMap;", "mRecordMap", "Lcom/tencent/mm/plugin/wxpayreport/WcPayReportUIC$ReportEvent;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMRecordMap", "mRunningTasks", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getMRunningTasks", "addCustomReportEvent", "", "key", "options", "addLifecycleReportEvent", "reportEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFinished", "onPause", "onResume", "onStart", "removeTask", "triggerReport", "event", "customKey", "Companion", "ReportEvent", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j
  extends UIComponent
{
  public static final j.a XIW;
  private final HashMap<b, ArrayList<com.tencent.mm.plugin.wxpayreport.a.b>> XIX;
  private final HashMap<String, com.tencent.mm.plugin.wxpayreport.a.b> XIY;
  final HashMap<String, WeakReference<com.tencent.threadpool.i.b>> XIZ;
  
  static
  {
    AppMethodBeat.i(261128);
    XIW = new j.a((byte)0);
    AppMethodBeat.o(261128);
  }
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(261093);
    this.XIX = new HashMap();
    this.XIY = new HashMap();
    this.XIZ = new HashMap();
    AppMethodBeat.o(261093);
  }
  
  public j(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(261106);
    this.XIX = new HashMap();
    this.XIY = new HashMap();
    this.XIZ = new HashMap();
    AppMethodBeat.o(261106);
  }
  
  public final void Em(String paramString)
  {
    AppMethodBeat.i(261197);
    s.u(paramString, "key");
    Log.d("MicroMsg.WcPayReportUIC", s.X("remove task: ", paramString));
    paramString = (WeakReference)this.XIZ.remove(paramString);
    if (paramString != null)
    {
      paramString = (com.tencent.threadpool.i.b)paramString.get();
      if (paramString != null) {
        paramString.jZt();
      }
    }
    AppMethodBeat.o(261197);
  }
  
  public final void addCustomReportEvent(String paramString, com.tencent.mm.plugin.wxpayreport.a.b paramb)
  {
    AppMethodBeat.i(261148);
    s.u(paramString, "key");
    s.u(paramb, "options");
    Object localObject = (com.tencent.mm.plugin.wxpayreport.a.b)this.XIY.get(paramString);
    if (localObject != null)
    {
      localObject = (WeakReference)this.XIZ.get(((com.tencent.mm.plugin.wxpayreport.a.b)localObject).viewId.toString());
      if (localObject != null)
      {
        localObject = (com.tencent.threadpool.i.b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((com.tencent.threadpool.i.b)localObject).jZt();
        }
      }
    }
    ((Map)this.XIY).put(paramString, paramb);
    AppMethodBeat.o(261148);
  }
  
  public final void addLifecycleReportEvent(b paramb, com.tencent.mm.plugin.wxpayreport.a.b paramb1)
  {
    AppMethodBeat.i(261139);
    s.u(paramb, "reportEvent");
    s.u(paramb1, "options");
    ArrayList localArrayList2 = (ArrayList)this.XIX.get(paramb);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      ((Map)this.XIX).put(paramb, localArrayList1);
    }
    localArrayList1.add(paramb1);
    AppMethodBeat.o(261139);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(261158);
    super.onCreate(paramBundle);
    a(this, b.XJa);
    AppMethodBeat.o(261158);
  }
  
  public void onFinished()
  {
    AppMethodBeat.i(261188);
    super.onFinished();
    Iterator localIterator = ((Map)this.XIZ).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.threadpool.i.b localb = (com.tencent.threadpool.i.b)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
      if (localb != null) {
        localb.jZt();
      }
    }
    this.XIZ.clear();
    AppMethodBeat.o(261188);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(261182);
    super.onPause();
    Iterator localIterator = ((Map)this.XIZ).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Log.d("MicroMsg.WcPayReportUIC", s.X("cancel tasks: ", ((WeakReference)((Map.Entry)localObject).getValue()).get()));
      localObject = (com.tencent.threadpool.i.b)((WeakReference)((Map.Entry)localObject).getValue()).get();
      if (localObject != null) {
        ((com.tencent.threadpool.i.b)localObject).jZt();
      }
    }
    this.XIZ.clear();
    AppMethodBeat.o(261182);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(261174);
    super.onResume();
    a(this, b.XJc);
    AppMethodBeat.o(261174);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(261164);
    super.onStart();
    a(this, b.XJb);
    AppMethodBeat.o(261164);
  }
  
  public final void triggerReport(b paramb, String paramString)
  {
    AppMethodBeat.i(261210);
    s.u(paramb, "event");
    switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(261210);
      return;
      paramString = (ArrayList)this.XIX.get(paramb);
      if (paramString == null)
      {
        AppMethodBeat.o(261210);
        return;
      }
      d.a(paramString, (kotlin.g.a.b)new d(paramb, this));
      AppMethodBeat.o(261210);
      return;
      if (paramString != null)
      {
        paramb = (com.tencent.mm.plugin.wxpayreport.a.b)this.XIY.get(paramString);
        if (paramb == null)
        {
          AppMethodBeat.o(261210);
          return;
        }
        Log.d("MicroMsg.WcPayReportUIC", "do checkViewAbnormal: " + paramString + ", " + paramb.viewId);
        com.tencent.threadpool.i.b localb = ((a)h.az(a.class)).checkViewAbnormal(paramb);
        if (localb != null) {
          ((Map)this.XIZ).put(paramb.viewId.toString(), new WeakReference(localb));
        }
        this.XIY.remove(paramString);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayReportUIC$ReportEvent;", "", "(Ljava/lang/String;I)V", "Event_OnCreate", "Event_OnStart", "Event_OnResume", "Event_OnPause", "Event_OnStop", "Event_OnDestroy", "Event_Custom", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(261064);
      XJa = new b("Event_OnCreate", 0);
      XJb = new b("Event_OnStart", 1);
      XJc = new b("Event_OnResume", 2);
      XJd = new b("Event_OnPause", 3);
      XJe = new b("Event_OnStop", 4);
      XJf = new b("Event_OnDestroy", 5);
      XJg = new b("Event_Custom", 6);
      XJh = new b[] { XJa, XJb, XJc, XJd, XJe, XJf, XJg };
      AppMethodBeat.o(261064);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wxpayreport/api/ReportAbnormalOptions;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.wxpayreport.a.b, Boolean>
  {
    d(j.b paramb, j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.j
 * JD-Core Version:    0.7.0.1
 */