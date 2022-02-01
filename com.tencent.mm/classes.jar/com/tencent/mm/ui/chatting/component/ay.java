package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.api.an;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=an.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/PayReportComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IPayReportComponent;", "()V", "runningTasks", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "Lkotlin/collections/ArrayList;", "sessionData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "cancelAndClearTasks", "", "checkLuckyMoneyViewExposure", "checkRemittanceViewExposure", "onBottomPanelVisible", "visible", "", "onChattingExitAnimEnd", "onChattingPause", "onDragBegin", "onPanelShow", "panelType", "isVoiceInputPanelShow", "", "putData", "key", "value", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends a
  implements an
{
  public static final ay.a aevz;
  private final HashMap<String, Object> aevA;
  private ArrayList<WeakReference<b>> aevB;
  
  static
  {
    AppMethodBeat.i(255827);
    aevz = new ay.a((byte)0);
    AppMethodBeat.o(255827);
  }
  
  public ay()
  {
    AppMethodBeat.i(255805);
    this.aevA = new HashMap();
    this.aevB = new ArrayList();
    AppMethodBeat.o(255805);
  }
  
  private final void jtl()
  {
    AppMethodBeat.i(255808);
    if (this.aevB.isEmpty())
    {
      AppMethodBeat.o(255808);
      return;
    }
    Iterator localIterator = ((Iterable)this.aevB).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)((WeakReference)localIterator.next()).get();
      if (localb != null) {
        localb.jZt();
      }
    }
    this.aevB.clear();
    AppMethodBeat.o(255808);
  }
  
  public final void T(String paramString, Object paramObject)
  {
    AppMethodBeat.i(255831);
    s.u(paramString, "key");
    s.u(paramObject, "value");
    ((Map)this.aevA).put(paramString, paramObject);
    AppMethodBeat.o(255831);
  }
  
  public final void aBR(int paramInt)
  {
    AppMethodBeat.i(255844);
    Log.d("MicroMsg.PayReportComponent", s.X("onBottomPanelVisible: ", Integer.valueOf(paramInt)));
    if (paramInt != 0) {
      jtl();
    }
    AppMethodBeat.o(255844);
  }
  
  public final void cG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(255842);
    Log.d("MicroMsg.PayReportComponent", "onPanelShow: " + paramInt + ", " + paramBoolean);
    if ((!paramBoolean) && (paramInt == 3))
    {
      b localb = new b(this);
      h.ahAA.bm((Runnable)localb);
      this.aevB.add(new WeakReference(localb));
      AppMethodBeat.o(255842);
      return;
    }
    jtl();
    AppMethodBeat.o(255842);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(255833);
    Log.d("MicroMsg.PayReportComponent", "onChattingPause");
    jtl();
    AppMethodBeat.o(255833);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(255838);
    Log.d("MicroMsg.PayReportComponent", "onChattingExitAnimEnd");
    jtl();
    AppMethodBeat.o(255838);
  }
  
  public final void onDragBegin()
  {
    AppMethodBeat.i(255848);
    jtl();
    AppMethodBeat.o(255848);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/PayReportComponent$onPanelShow$runnable$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends b
  {
    b(ay paramay) {}
    
    public final String getKey()
    {
      return "check_attach_view_task";
    }
    
    public final void run()
    {
      AppMethodBeat.i(255908);
      ay.a(this.aevC);
      ay.b(this.aevC);
      AppMethodBeat.o(255908);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ay
 * JD-Core Version:    0.7.0.1
 */