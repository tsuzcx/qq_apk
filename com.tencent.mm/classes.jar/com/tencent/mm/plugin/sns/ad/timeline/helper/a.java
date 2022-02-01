package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.o;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper;", "", "()V", "TAG", "", "thumbDownloadChannels", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "getThumbDownloadChannels", "()Ljava/util/Map;", "thumbRequestedIds", "", "getThumbRequestedIds", "()Ljava/util/Set;", "videoDownloadChannels", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "getVideoDownloadChannels", "videoRequestedIds", "getVideoRequestedIds", "getSightDownloadFlow", "Lkotlinx/coroutines/flow/Flow;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "imageLoader2", "Lcom/tencent/mm/plugin/sns/model/LazyerImageLoader2;", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "getThumbDownloadChannelById", "cacheName", "getThumbDownloadFlow", "getVideoDownloadChannelById", "mediaId", "removeAllThumbDownloadChannel", "", "removeThumbDownloadChannelById", "removeVideoDownloadChannelById", "setThumbDownloadValue", "result", "setVideoDownloadValue", "triggerDownloadMediaSight", "triggerDownloadMediaThumb", "ResultState", "ThumbResult", "VideoResult", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a PZY;
  private static final Map<String, x<a.b>> PZZ;
  private static final Map<String, x<a.c>> Qaa;
  private static final Set<String> Qab;
  private static final Set<String> Qac;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(311228);
    PZY = new a();
    TAG = "AdMediaDownloadHelper";
    PZZ = (Map)new LinkedHashMap();
    Qaa = (Map)new LinkedHashMap();
    Qab = (Set)new LinkedHashSet();
    Qac = (Set)new LinkedHashSet();
    AppMethodBeat.o(311228);
  }
  
  public static kotlinx.coroutines.b.g<a.b> a(com.tencent.mm.plugin.sns.model.g paramg, dmz paramdmz, br parambr)
  {
    AppMethodBeat.i(311191);
    if (paramdmz == null)
    {
      paramg = j.at(new a.b[0]);
      AppMethodBeat.o(311191);
      return paramg;
    }
    if (paramg == null)
    {
      paramg = j.at(new a.b[0]);
      AppMethodBeat.o(311191);
      return paramg;
    }
    String str = t.db(1, paramdmz.Id);
    Object localObject1;
    for (;;)
    {
      synchronized (Qab)
      {
        Set localSet = Qab;
        if (str == null)
        {
          localObject1 = "";
          localSet.add(localObject1);
          if (!y.ZC(s.X(as.mg(al.getAccSnsPath(), paramdmz.Id), t.d(paramdmz))))
          {
            s.s(str, "cacheName");
            aWL(str).setValue(null);
            localObject1 = new p(paramdmz);
            ((p)localObject1).QnY = 1;
            ((p)localObject1).hOG = paramdmz.Id;
            ??? = al.hgw();
            if (paramdmz.vhJ == 6)
            {
              i = 5;
              ((c)???).a(paramdmz, i, (p)localObject1, parambr);
            }
          }
          else
          {
            localObject1 = paramg.aYd(str);
            if (t.b((m)localObject1)) {
              break;
            }
            if (!paramg.aYi(str)) {
              paramg.a(1, paramdmz, parambr);
            }
            paramg = paramdmz.Id;
            s.s(paramg, "media.Id");
            paramg = o.d(j.jb(new a.b(paramg, null, a.a.Qad)), (q)new a.e(str, null));
            AppMethodBeat.o(311191);
            return paramg;
          }
        }
        else
        {
          localObject1 = str;
        }
      }
      int i = 1;
    }
    paramg = paramdmz.Id;
    s.s(paramg, "media.Id");
    paramg = j.jb(new a.b(paramg, new WeakReference(localObject1), a.a.Qaf));
    AppMethodBeat.o(311191);
    return paramg;
  }
  
  public static kotlinx.coroutines.b.g<a.c> a(SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.model.g paramg, dmz paramdmz, br parambr)
  {
    AppMethodBeat.i(311203);
    if (paramg == null)
    {
      paramSnsInfo = j.at(new a.c[0]);
      AppMethodBeat.o(311203);
      return paramSnsInfo;
    }
    if (paramdmz == null)
    {
      paramSnsInfo = j.at(new a.c[0]);
      AppMethodBeat.o(311203);
      return paramSnsInfo;
    }
    paramdmz.isAd = true;
    e.a(paramSnsInfo, paramdmz);
    for (;;)
    {
      synchronized (Qac)
      {
        Set localSet2 = Qac;
        paramg = paramdmz.Id;
        paramSnsInfo = paramg;
        if (paramg == null) {
          paramSnsInfo = "";
        }
        localSet2.add(paramSnsInfo);
        paramSnsInfo = as.mg(al.getAccSnsPath(), paramdmz.Id);
        paramg = t.i(paramdmz);
        if (y.ZC(s.X(paramSnsInfo, paramg)))
        {
          paramSnsInfo = s.X(paramSnsInfo, paramg);
          paramg = (CharSequence)paramSnsInfo;
          if ((paramg != null) && (!n.bp(paramg))) {
            break label204;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          paramg = paramdmz.Id;
          s.s(paramg, "media.Id");
          paramSnsInfo = j.jb(new a.c(paramg, paramSnsInfo, a.a.Qaf));
          AppMethodBeat.o(311203);
          return paramSnsInfo;
        }
      }
      paramSnsInfo = null;
      continue;
      label204:
      int i = 0;
    }
    paramSnsInfo = paramdmz.Id;
    s.s(paramSnsInfo, "media.Id");
    aWN(paramSnsInfo).setValue(null);
    Log.i(TAG, "down load sight is " + paramdmz.Id + " url: " + paramdmz.Url);
    al.fAG().postDelayed(new a..ExternalSyntheticLambda0(paramdmz, parambr), 0L);
    paramSnsInfo = paramdmz.Id;
    s.s(paramSnsInfo, "media.Id");
    paramSnsInfo = o.d(j.jb(new a.c(paramSnsInfo, null, a.a.Qad)), (q)new a.d(paramdmz, null));
    AppMethodBeat.o(311203);
    return paramSnsInfo;
  }
  
  public static void a(SnsInfo paramSnsInfo, dmz paramdmz, br parambr)
  {
    AppMethodBeat.i(311179);
    if (paramdmz == null)
    {
      AppMethodBeat.o(311179);
      return;
    }
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(311179);
      return;
    }
    paramdmz.isAd = true;
    for (;;)
    {
      synchronized (Qac)
      {
        Set localSet2 = Qac;
        String str2 = paramdmz.Id;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localSet2.add(str1);
        e.a(paramSnsInfo, paramdmz);
        paramSnsInfo = as.mg(al.getAccSnsPath(), paramdmz.Id);
        str1 = t.i(paramdmz);
        if (y.ZC(s.X(paramSnsInfo, str1)))
        {
          paramSnsInfo = s.X(paramSnsInfo, str1);
          paramSnsInfo = (CharSequence)paramSnsInfo;
          if ((paramSnsInfo != null) && (!n.bp(paramSnsInfo))) {
            break label182;
          }
          i = 1;
          if (i != 0) {
            al.fAG().postDelayed(new a..ExternalSyntheticLambda1(paramdmz, parambr), 0L);
          }
          AppMethodBeat.o(311179);
          return;
        }
      }
      paramSnsInfo = null;
      continue;
      label182:
      int i = 0;
    }
  }
  
  public static void a(dmz paramdmz, br parambr)
  {
    int i = 1;
    AppMethodBeat.i(311184);
    if (paramdmz == null)
    {
      AppMethodBeat.o(311184);
      return;
    }
    synchronized (Qab)
    {
      Set localSet2 = Qab;
      Object localObject2 = paramdmz.Id;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localSet2.add(localObject1);
      if (!y.ZC(s.X(as.mg(al.getAccSnsPath(), paramdmz.Id), t.d(paramdmz))))
      {
        localObject1 = new p(paramdmz);
        ((p)localObject1).QnY = 1;
        ((p)localObject1).hOG = paramdmz.Id;
        localObject2 = al.hgw();
        if (paramdmz.vhJ == 6) {
          i = 5;
        }
        ((c)localObject2).a(paramdmz, i, (p)localObject1, parambr);
      }
      AppMethodBeat.o(311184);
      return;
    }
  }
  
  public static final void a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(311138);
    if (paramString == null)
    {
      AppMethodBeat.o(311138);
      return;
    }
    synchronized (Qab)
    {
      boolean bool = Qab.contains(paramString);
      if (bool) {
        aWL(paramString).setValue(paramb);
      }
      Log.d(TAG, "setThumbDownloadValue() called with: mediaId = " + paramString + ", contains = " + bool);
      paramString = kotlin.ah.aiuX;
      AppMethodBeat.o(311138);
      return;
    }
  }
  
  public static final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(311145);
    if (paramString == null)
    {
      AppMethodBeat.o(311145);
      return;
    }
    synchronized (Qac)
    {
      boolean bool = Qac.contains(paramString);
      if (bool) {
        aWN(paramString).setValue(paramc);
      }
      Log.d(TAG, "setVideoDownloadValue() called with: mediaId = " + paramString + ", contains = " + bool);
      paramString = kotlin.ah.aiuX;
      AppMethodBeat.o(311145);
      return;
    }
  }
  
  public static final x<a.b> aWL(String paramString)
  {
    AppMethodBeat.i(311148);
    s.u(paramString, "cacheName");
    synchronized (PZZ)
    {
      if ((PZZ.containsKey(paramString)) && (PZZ.get(paramString) != null))
      {
        paramString = PZZ.get(paramString);
        s.checkNotNull(paramString);
        paramString = (x)paramString;
        AppMethodBeat.o(311148);
        return paramString;
      }
      PZZ.put(paramString, kotlinx.coroutines.b.ah.ji(null));
      paramString = PZZ.get(paramString);
      s.checkNotNull(paramString);
      paramString = (x)paramString;
    }
  }
  
  public static final void aWM(String paramString)
  {
    AppMethodBeat.i(311160);
    if (paramString == null)
    {
      AppMethodBeat.o(311160);
      return;
    }
    synchronized (PZZ)
    {
      PZZ.remove(paramString);
      AppMethodBeat.o(311160);
      return;
    }
  }
  
  public static final x<a.c> aWN(String paramString)
  {
    AppMethodBeat.i(311168);
    s.u(paramString, "mediaId");
    synchronized (Qaa)
    {
      if ((Qaa.containsKey(paramString)) && (Qaa.get(paramString) != null))
      {
        paramString = Qaa.get(paramString);
        s.checkNotNull(paramString);
        paramString = (x)paramString;
        AppMethodBeat.o(311168);
        return paramString;
      }
      Qaa.put(paramString, kotlinx.coroutines.b.ah.ji(null));
      paramString = Qaa.get(paramString);
      s.checkNotNull(paramString);
      paramString = (x)paramString;
    }
  }
  
  private static final void b(dmz paramdmz, br parambr)
  {
    AppMethodBeat.i(311210);
    al.hgw().a(paramdmz, 4, null, parambr);
    AppMethodBeat.o(311210);
  }
  
  private static final void c(dmz paramdmz, br parambr)
  {
    AppMethodBeat.i(311216);
    al.hgw().a(paramdmz, 4, null, parambr);
    AppMethodBeat.o(311216);
  }
  
  public static final void hbO()
  {
    AppMethodBeat.i(311153);
    synchronized (PZZ)
    {
      Log.d(TAG, "removeAllThumbDownloadChannel() called");
      PZZ.clear();
      kotlin.ah localah = kotlin.ah.aiuX;
      AppMethodBeat.o(311153);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a
 * JD-Core Version:    0.7.0.1
 */