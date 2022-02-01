package com.tencent.mm.plugin.sns.h;

import android.os.HandlerThread;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bt;
import com.tencent.mm.plugin.findersdk.a.bt.a;
import com.tencent.mm.plugin.findersdk.a.bt.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher;", "", "()V", "DEBUG", "", "MaxCacheResult", "", "TAG", "", "cacheLock", "Ljava/lang/Object;", "keywordRegexs", "Lkotlin/text/Regex;", "keywordsHashMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$TriggerInfo;", "matchCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$SnsInfoMatchResult;", "onStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "getOnStorageChange", "()Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "spanHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "spanThread", "Landroid/os/HandlerThread;", "threadCreateLock", "buildKeywordSpan", "Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$KeywordClickableSpan;", "feedId", "", "commentId", "keyword", "startPos", "buildKeywordsRegex", "", "loadFinderKeywords", "matchContent", "content", "putMatchContent", "queue", "delay", "callback", "Lkotlin/Function0;", "spanContent", "", "start", "startInner", "delayTime", "stop", "ContentMatchResult", "KeywordClickableSpan", "SnsInfoMatchResult", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QoW;
  private static final LruCache<String, a.c> QoX;
  private static final Object QoY;
  private static final HashMap<String, bt.b> QoZ;
  private static HandlerThread Qpa;
  private static MMHandler Qpb;
  private static final Object Qpc;
  private static k Qpd;
  private static final MStorage.IOnStorageChange rpm;
  
  static
  {
    AppMethodBeat.i(306514);
    QoW = new a();
    QoX = new LruCache(100);
    QoY = new Object();
    QoZ = new HashMap();
    Qpc = new Object();
    Qpd = new k("");
    rpm = a..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(306514);
  }
  
  public static final CharSequence a(long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(306482);
    s.u(paramCharSequence, "content");
    if ((QoX == null) || (QoX.size() <= 0))
    {
      AppMethodBeat.o(306482);
      return paramCharSequence;
    }
    if (Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_sns_keyword", "0", false, true), 0) <= 0)
    {
      Log.e("MicroMsg.SnsKeywordMatcher", "switch close.");
      stop();
      AppMethodBeat.o(306482);
      return paramCharSequence;
    }
    long l = Util.currentTicks();
    boolean bool;
    for (;;)
    {
      final int i;
      final ah.d locald;
      String str2;
      synchronized (QoY)
      {
        Object localObject2 = (a.c)QoX.get(paramCharSequence.toString());
        bool = false;
        if (localObject2 == null) {
          break label470;
        }
        ??? = new ArrayList((Collection)((a.c)localObject2).Qpf);
        if (!((Collection)???).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label470;
          }
          paramCharSequence = new SpannableStringBuilder(paramCharSequence);
          ??? = ((Iterable)???).iterator();
          bool = false;
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject2 = (a.a)((Iterator)???).next();
          String str1 = ((a.a)localObject2).hAB;
          i = ((a.a)localObject2).dIY;
          a.b localb = new a.b(str1);
          locald = new ah.d();
          str2 = Util.getTopActivityName(MMApplicationContext.getContext());
          if (!Util.isNullOrNil(str2))
          {
            if (!n.T(str2, "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", true)) {
              break label400;
            }
            locald.aixb = 1;
          }
          al.gHI().post(new a..ExternalSyntheticLambda1(paramLong, paramInt, str1, i, locald));
          localb.Qpe = ((kotlin.g.a.b)new d(paramLong, paramInt, i, locald));
          paramCharSequence.setSpan(localb, ((a.a)localObject2).dIY, ((a.a)localObject2).endPos + 1, 18);
          Log.d("MicroMsg.SnsKeywordMatcher", "setSpan:[" + ((a.a)localObject2).dIY + ", " + ((a.a)localObject2).endPos + "], keyWord:" + ((a.a)localObject2).hAB);
          bool = true;
        }
      }
      label400:
      if (n.T(str2, "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI", true)) {
        locald.aixb = 2;
      }
    }
    label470:
    for (;;)
    {
      Log.d("MicroMsg.SnsKeywordMatcher", "spanContent cost:" + Util.ticksToNow(l) + ", spanned:" + bool);
      paramCharSequence = (CharSequence)paramCharSequence;
      AppMethodBeat.o(306482);
      return paramCharSequence;
    }
  }
  
  private static final void a(long paramLong, int paramInt1, String paramString, int paramInt2, ah.d paramd)
  {
    AppMethodBeat.i(306490);
    s.u(paramString, "$keyword");
    s.u(paramd, "$tagSource");
    Object localObject = al.hgB();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((w)localObject).vj(paramLong))
    {
      AppMethodBeat.o(306490);
      return;
    }
    int i;
    if (((SnsInfo)localObject).isAd()) {
      i = 2;
    }
    for (;;)
    {
      nv localnv = new nv();
      localnv.vQ(com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA());
      localnv.vR(String.valueOf(paramLong));
      localnv.vS(((SnsInfo)localObject).getUserName());
      localnv.vT(String.valueOf(paramInt1));
      localnv.vU(paramString);
      localnv.jgi = 1;
      localnv.jgj = paramInt2;
      localnv.ioV = 1L;
      localnv.jgk = i;
      localnv.jgl = paramd.aixb;
      localnv.bMH();
      AppMethodBeat.o(306490);
      return;
      if (au.bwO(((SnsInfo)localObject).getUserName())) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
  
  public static final void aXN(String paramString)
  {
    AppMethodBeat.i(306469);
    if ((!Util.isNullOrNil(paramString)) && (Qpd != null))
    {
      String str = Qpd.ajuR.pattern();
      s.s(str, "nativePattern.pattern()");
      if (!Util.isNullOrNil(str)) {}
    }
    else
    {
      AppMethodBeat.o(306469);
      return;
    }
    if (QoX.get(paramString) == null) {
      b(0L, (kotlin.g.a.a)new f(paramString));
    }
    AppMethodBeat.o(306469);
  }
  
  private static void b(long paramLong, kotlin.g.a.a<ah> parama)
  {
    int j = 1;
    AppMethodBeat.i(306476);
    synchronized (Qpc)
    {
      if (Qpb != null)
      {
        HandlerThread localHandlerThread = Qpa;
        if (localHandlerThread != null)
        {
          boolean bool = localHandlerThread.isAlive();
          if (bool != true) {}
        }
        for (i = 1; i != 0; i = 0)
        {
          i = j;
          if (i != 0) {
            break label99;
          }
          Log.e("MicroMsg.SnsKeywordMatcher", "queue thread already release");
          AppMethodBeat.o(306476);
          return;
        }
      }
      int i = 0;
    }
    label99:
    ??? = Qpb;
    if (??? != null) {
      ((MMHandler)???).postDelayed(new a..ExternalSyntheticLambda2(parama), paramLong);
    }
    AppMethodBeat.o(306476);
  }
  
  private static final void bw(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(306486);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(306486);
  }
  
  private static final void d(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(306483);
    Log.i("MicroMsg.SnsKeywordMatcher", "receive SnsKeyWordsStorage change, reload data.");
    hfe();
    AppMethodBeat.o(306483);
  }
  
  public static MStorage.IOnStorageChange hfd()
  {
    return rpm;
  }
  
  public static final void hfe()
  {
    AppMethodBeat.i(306466);
    QoZ.clear();
    QoX.evictAll();
    Qpd = new k("");
    bt localbt = (bt)h.ax(bt.class);
    if (localbt != null) {
      localbt.a((bt.a)new a.e());
    }
    AppMethodBeat.o(306466);
  }
  
  public static final void hff()
  {
    AppMethodBeat.i(306473);
    com.tencent.mm.ae.d.a("SnsKeywordMatcher_Thread", false, (kotlin.g.a.a)g.Qpk, 0L, 2);
    AppMethodBeat.o(306473);
  }
  
  public static final void start()
  {
    boolean bool = true;
    AppMethodBeat.i(306472);
    int i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_sns_keyword", "0", false, true), 0);
    if ((ar.a.hhj() & 0x4) > 0) {}
    while ((i <= 0) || (bool))
    {
      Log.e("MicroMsg.SnsKeywordMatcher", "switch not enable. switch:" + i + ", isFlagClose:" + bool);
      AppMethodBeat.o(306472);
      return;
      bool = false;
    }
    hff();
    AppMethodBeat.o(306472);
  }
  
  public static final void stop()
  {
    AppMethodBeat.i(306474);
    com.tencent.mm.ae.d.B((kotlin.g.a.a)h.Qpl);
    AppMethodBeat.o(306474);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "keyword", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(long paramLong, int paramInt1, int paramInt2, ah.d paramd)
    {
      super();
    }
    
    private static final void b(long paramLong, int paramInt1, String paramString, int paramInt2, ah.d paramd)
    {
      AppMethodBeat.i(306433);
      s.u(paramString, "$keyword");
      s.u(paramd, "$tagSource");
      Object localObject = al.hgB();
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((w)localObject).vj(paramLong))
      {
        AppMethodBeat.o(306433);
        return;
      }
      int i;
      if (((SnsInfo)localObject).isAd()) {
        i = 2;
      }
      for (;;)
      {
        nv localnv = new nv();
        localnv.vQ(com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA());
        localnv.vR(String.valueOf(paramLong));
        localnv.vS(((SnsInfo)localObject).getUserName());
        localnv.vT(String.valueOf(paramInt1));
        localnv.vU(paramString);
        localnv.jgi = 1;
        localnv.jgj = paramInt2;
        localnv.ioV = 2L;
        localnv.jgk = i;
        localnv.jgl = paramd.aixb;
        localnv.bMH();
        AppMethodBeat.o(306433);
        return;
        if (au.bwO(((SnsInfo)localObject).getUserName())) {
          i = 3;
        } else {
          i = 1;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final g Qpk;
    
    static
    {
      AppMethodBeat.i(306424);
      Qpk = new g();
      AppMethodBeat.o(306424);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final h Qpl;
    
    static
    {
      AppMethodBeat.i(306432);
      Qpl = new h();
      AppMethodBeat.o(306432);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a
 * JD-Core Version:    0.7.0.1
 */