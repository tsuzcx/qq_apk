package com.tencent.mm.sensitive.d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.pl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/report/SensitiveReporter;", "", "()V", "TAG", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "methodTimeStamp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMethodTimeStamp", "()Ljava/util/HashMap;", "reportFrequencyLimiter", "reportTimeStamp", "Ljava/util/ArrayList;", "structList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/autogen/mmdata/rpt/SystemServiceHookStatusStruct;", "structStackMap", "add", "", "struct", "addReportInterval", "calculateBusinessType", "throwAble", "", "report", "reportHookFailed", "serviceName", "manualStack", "reportHookMethodCall", "methodName", "isCache", "", "reportHookMethodCallException", "throwAbleStr", "reportHookSnapShot", "duration", "successCount", "", "reportTooFrequency", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  private static final HashMap<String, pl> acvA;
  private static final ArrayList<Long> acvB;
  private static final long acvC;
  public static final a acvx;
  private static final HashMap<String, Long> acvy;
  private static final CopyOnWriteArrayList<pl> acvz;
  private static final j rdm;
  
  static
  {
    AppMethodBeat.i(241023);
    acvx = new a();
    acvy = new HashMap();
    TAG = "MicroMsg.SensitiveReporter";
    acvz = new CopyOnWriteArrayList();
    acvA = new HashMap();
    acvB = new ArrayList();
    acvC = 2000L;
    rdm = k.cm((kotlin.g.a.a)a.acvD);
    AppMethodBeat.o(241023);
  }
  
  public static void M(String paramString1, final String paramString2, final boolean paramBoolean)
  {
    AppMethodBeat.i(240998);
    s.u(paramString1, "serviceName");
    s.u(paramString2, "methodName");
    d.d(TAG, (kotlin.g.a.a)new c(paramString1, paramString2, paramBoolean));
    AppMethodBeat.o(240998);
  }
  
  public static void aM(long paramLong, int paramInt)
  {
    AppMethodBeat.i(240981);
    d.d(TAG, (kotlin.g.a.a)new e(paramLong, paramInt));
    AppMethodBeat.o(240981);
  }
  
  public static void pB(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(240986);
    d.d(TAG, (kotlin.g.a.a)new b(paramString2, paramString1));
    AppMethodBeat.o(240986);
  }
  
  public static void pC(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(241003);
    s.u(paramString1, "methodName");
    s.u(paramString2, "throwAbleStr");
    d.d(TAG, (kotlin.g.a.a)new d(paramString2, paramString1));
    AppMethodBeat.o(241003);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    public static final a acvD;
    
    static
    {
      AppMethodBeat.i(240995);
      acvD = new a();
      AppMethodBeat.o(240995);
    }
    
    a()
    {
      super();
    }
    
    private static final boolean w(Message paramMessage)
    {
      AppMethodBeat.i(240988);
      s.u(paramMessage, "msg");
      if (a.iUm().size() > 100)
      {
        paramMessage = a.acvx;
        a.iUn();
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)a.iUm());
        a.iUm().clear();
        Iterator localIterator = localArrayList.iterator();
        s.s(localIterator, "tempReportList.iterator()");
        while (localIterator.hasNext())
        {
          paramMessage = localIterator.next();
          s.s(paramMessage, "i.next()");
          pl localpl1 = (pl)paramMessage;
          if (localpl1.jlY == 0) {
            paramMessage = MD5Util.getMD5String(localpl1.jmg);
          }
          pl localpl2;
          for (;;)
          {
            if (paramMessage == null) {
              break label167;
            }
            localpl2 = (pl)a.iUl().get(paramMessage);
            if (localpl2 != null) {
              break label169;
            }
            ((Map)a.iUl()).put(paramMessage, localpl1);
            break;
            if (localpl1.jlY == 1) {
              paramMessage = MD5Util.getMD5String(localpl1.jmc);
            } else {
              paramMessage = null;
            }
          }
          label167:
          continue;
          label169:
          localpl2.wR(localpl2.jme + ';' + localpl1.jme);
          localIterator.remove();
        }
        a.iUl().clear();
        Log.i(a.aUw(), s.X("report，size = ", Integer.valueOf(localArrayList.size())));
        paramMessage = ((Iterable)localArrayList).iterator();
        while (paramMessage.hasNext()) {
          ((pl)paramMessage.next()).bMH();
        }
        localArrayList.clear();
      }
      AppMethodBeat.o(240988);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString1, String paramString2, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(long paramLong, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sensitive.d.a
 * JD-Core Version:    0.7.0.1
 */