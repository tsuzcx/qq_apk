package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.plugin.textstatus.h.f.d;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter;", "", "()V", "ICON_CHAR", "", "TAG", "", "listeners", "", "", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "cancelListener", "", "_key", "subject", "onNotify", "userName", "Listener", "StatusIconListener", "StatusSpanListener", "StatusSpanListenerNoMeasure", "StatusSpanWithDescListener", "StatusUpdateListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o Tna;
  private static final Map<Integer, o.a> wss;
  
  static
  {
    AppMethodBeat.i(290583);
    Tna = new o();
    f localf = f.TjQ;
    f.hGH().add(o..ExternalSyntheticLambda2.INSTANCE);
    localf = f.TjQ;
    f.hGI().add(o..ExternalSyntheticLambda3.INSTANCE);
    localf = f.TjQ;
    f.hGL().add(o..ExternalSyntheticLambda1.INSTANCE);
    localf = f.TjQ;
    f.hGN().add(o..ExternalSyntheticLambda0.INSTANCE);
    localf = f.TjQ;
    f.hGK().add(o..ExternalSyntheticLambda4.INSTANCE);
    wss = (Map)new LinkedHashMap();
    AppMethodBeat.o(290583);
  }
  
  public static void N(String paramString, Object paramObject)
  {
    AppMethodBeat.i(290515);
    s.u(paramString, "_key");
    s.u(paramObject, "subject");
    synchronized (wss)
    {
      o.a locala = (o.a)wss.get(Integer.valueOf(paramObject.hashCode()));
      if ((locala != null) && (s.p(paramString, locala.key)))
      {
        wss.remove(Integer.valueOf(paramObject.hashCode()));
        Log.i("MicroMsg.TextStatus.TextStatusEventCenter", s.X("cancelListener ", paramString));
      }
      AppMethodBeat.o(290515);
      return;
    }
  }
  
  private static void bdS(String paramString)
  {
    AppMethodBeat.i(290504);
    Log.i("MicroMsg.TextStatus.TextStatusEventCenter", s.X("onNotify ", paramString));
    com.tencent.threadpool.h.ahAA.bk(new o..ExternalSyntheticLambda5(paramString));
    AppMethodBeat.o(290504);
  }
  
  private static final void bdT(String paramString)
  {
    AppMethodBeat.i(290562);
    s.u(paramString, "$userName");
    List localList;
    for (;;)
    {
      synchronized (wss)
      {
        localList = (List)new ArrayList();
        Iterator localIterator = wss.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (!s.p(((o.a)((Map.Entry)localObject).getValue()).key, paramString)) {
          continue;
        }
        if (((o.a)((Map.Entry)localObject).getValue()).hHA().get() == null) {
          localList.add(((Map.Entry)localObject).getKey());
        }
      }
      Object localObject = (o.a)((Map.Entry)localObject).getValue();
      if (((o.a)localObject).hHA().get() != null) {
        ((o.a)localObject).onChange();
      }
    }
    paramString = ((Iterable)localList).iterator();
    while (paramString.hasNext())
    {
      int i = ((Number)paramString.next()).intValue();
      wss.remove(Integer.valueOf(i));
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(290562);
  }
  
  private static final void e(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290520);
    Log.i("MicroMsg.TextStatus.TextStatusEventCenter", s.X("TextStatusStorage notify ", paramString));
    s.s(paramString, "userName");
    bdS(paramString);
    AppMethodBeat.o(290520);
  }
  
  private static final void f(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290524);
    Log.i("MicroMsg.TextStatus.TextStatusEventCenter", s.X("TextStatusLikedStorage notify ", paramString));
    s.s(paramString, "userName");
    bdS(paramString);
    AppMethodBeat.o(290524);
  }
  
  private static final void g(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290535);
    Log.i("MicroMsg.TextStatus.TextStatusEventCenter", s.X("conversation notify ", paramString));
    paramString = com.tencent.mm.plugin.auth.a.a.cUx();
    s.s(paramString, "username()");
    bdS(paramString);
    AppMethodBeat.o(290535);
  }
  
  private static final void h(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290544);
    if ((paramMStorageEventData != null) && (paramMStorageEventData.eventId == 2)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.TextStatus.TextStatusEventCenter", "greeting notify");
        paramString = com.tencent.mm.plugin.auth.a.a.cUx();
        s.s(paramString, "username()");
        bdS(paramString);
      }
      AppMethodBeat.o(290544);
      return;
    }
  }
  
  private static final void i(String paramString, MStorageEventData paramMStorageEventData)
  {
    Object localObject = null;
    AppMethodBeat.i(290551);
    if ((paramMStorageEventData != null) && (paramMStorageEventData.eventId == 2))
    {
      i = 1;
      if (i != 0)
      {
        paramString = com.tencent.mm.plugin.auth.a.a.cUx();
        s.s(paramString, "username()");
        bdS(paramString);
      }
      if (paramMStorageEventData != null) {
        break label115;
      }
      paramString = null;
      label47:
      if (!(paramString instanceof com.tencent.mm.plugin.textstatus.h.f.h)) {
        break label123;
      }
      paramString = (com.tencent.mm.plugin.textstatus.h.f.h)paramString;
      label59:
      if (paramString != null) {
        break label128;
      }
      paramString = localObject;
      label65:
      paramMStorageEventData = (CharSequence)paramString;
      if ((paramMStorageEventData != null) && (!n.bp(paramMStorageEventData))) {
        break label136;
      }
    }
    label128:
    label136:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.d("MicroMsg.TextStatus.TextStatusEventCenter", s.X("stranger contact notify ", paramString));
        bdS(paramString);
      }
      AppMethodBeat.o(290551);
      return;
      i = 0;
      break;
      label115:
      paramString = paramMStorageEventData.obj;
      break label47;
      label123:
      paramString = null;
      break label59;
      paramString = paramString.field_sessionId;
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o
 * JD-Core Version:    0.7.0.1
 */