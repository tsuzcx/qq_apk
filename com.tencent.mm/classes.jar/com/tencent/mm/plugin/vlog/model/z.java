package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class z
  implements com.tencent.mm.al.g
{
  public static final a LrD;
  public final LinkedList<y> Lqh;
  d.g.a.b<? super aoa, d.y> LrA;
  private List<dkv> LrB;
  public boolean LrC;
  private wp Lry;
  private Map<Long, String> Lrz;
  private int aMk;
  private int aMl;
  private final ax ctt;
  private int currentIndex;
  private int wVR;
  private LinkedList<bpb> zcd;
  
  static
  {
    AppMethodBeat.i(200948);
    LrD = new a((byte)0);
    AppMethodBeat.o(200948);
  }
  
  public z()
  {
    AppMethodBeat.i(200947);
    this.ctt = ax.aFD("MicroMsg.VLogDataManager");
    this.zcd = new LinkedList();
    this.Lrz = ((Map)new LinkedHashMap());
    this.Lqh = new LinkedList();
    this.LrB = ((List)new ArrayList());
    com.tencent.mm.kernel.g.aeS().a(1469, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(2972, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(200947);
  }
  
  private final List<d> a(dkv paramdkv)
  {
    AppMethodBeat.i(200946);
    paramdkv = paramdkv.zcd;
    k.g(paramdkv, "script.materials");
    paramdkv = (Iterable)paramdkv;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramdkv.iterator();
    bpc localbpc;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localbpc = (bpc)localIterator.next();
      localObject = (String)this.Lrz.get(Long.valueOf(localbpc.id));
      paramdkv = (dkv)localObject;
      if (localObject == null) {
        paramdkv = "";
      }
      localbpc.path = paramdkv;
      l = localbpc.dcn;
      if (l == 2L)
      {
        localObject = (String)this.Lrz.get(Long.valueOf(localbpc.id));
        paramdkv = (dkv)localObject;
        if (localObject == null) {
          paramdkv = "";
        }
        paramdkv = (d)new i(paramdkv, localbpc.DMG, localbpc.DMH, (float)localbpc.DMI, localbpc.begin_time, localbpc.begin_time + localbpc.duration);
        label193:
        if (paramdkv == null) {
          break label392;
        }
        if (localbpc.DME != 3L) {
          break label358;
        }
        localObject = e.yZj;
        label214:
        paramdkv.a((e)localObject);
        if (localbpc.DML != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = f.yZm;
      dkv localdkv = paramdkv;
      label236:
      localdkv.a((f)localObject);
      paramdkv.yZf = ((List)localbpc.DMJ);
      paramdkv.yZg = ((List)localbpc.DMK);
      for (;;)
      {
        if (paramdkv == null) {
          break label395;
        }
        localCollection.add(paramdkv);
        break;
        if (l == 1L)
        {
          localObject = (String)this.Lrz.get(Long.valueOf(localbpc.id));
          paramdkv = (dkv)localObject;
          if (localObject == null) {
            paramdkv = "";
          }
          paramdkv = (d)new c(paramdkv, localbpc.begin_time, localbpc.begin_time + localbpc.duration);
          break label193;
        }
        paramdkv = null;
        break label193;
        label358:
        localObject = e.yZi;
        break label214;
        label366:
        if (localbpc.DML.DMC != 2L) {
          break label410;
        }
        localObject = f.yZn;
        localdkv = paramdkv;
        break label236;
        paramdkv = null;
      }
      break;
      paramdkv = (List)localCollection;
      AppMethodBeat.o(200946);
      return paramdkv;
    }
  }
  
  private final void ja(final List<y> paramList)
  {
    AppMethodBeat.i(200945);
    com.tencent.mm.ad.c.b("generateVLog", (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(200945);
  }
  
  public final void a(int paramInt, d.g.a.b<? super aoa, d.y> paramb)
  {
    AppMethodBeat.i(200939);
    this.LrA = paramb;
    this.wVR = paramInt;
    if (paramInt == 0) {
      this.LrB.clear();
    }
    paramb = this.ctt.decodeBytes("VLOG_CONF");
    if (paramb != null) {
      if (paramb.length != 0) {
        break label81;
      }
    }
    label81:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramb = new com.tencent.mm.plugin.vlog.model.cgi.b();
      com.tencent.mm.kernel.g.aeS().b((n)paramb);
      AppMethodBeat.o(200939);
      return;
    }
    paramb = new wp().parseFrom(paramb);
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
      AppMethodBeat.o(200939);
      throw paramb;
    }
    this.Lry = ((wp)paramb);
    ja((List)this.Lqh);
    AppMethodBeat.o(200939);
  }
  
  public final h aif(int paramInt)
  {
    AppMethodBeat.i(200942);
    this.currentIndex = paramInt;
    long l = ((dkv)this.LrB.get(this.currentIndex)).CFc;
    Object localObject = a((dkv)this.LrB.get(this.currentIndex));
    String str = ((dkv)this.LrB.get(this.currentIndex)).EAA.DLo;
    k.g(str, "scripts[currentIndex].music.music_url");
    localObject = new h(l, (List)localObject, str, (dkv)this.LrB.get(this.currentIndex));
    AppMethodBeat.o(200942);
    return localObject;
  }
  
  public final List<boa> cUZ()
  {
    AppMethodBeat.i(200943);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.LrB;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      dkv localdkv = (dkv)localObject;
      boa localboa = new boa();
      String str = localdkv.EAA.DLo;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localboa.DLo = ((String)localObject);
      localboa.DLi = ((int)localdkv.EAA.Dpf);
      localboa.DLr = localdkv.EAA.DLr;
      str = localdkv.EAA.DLq;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localboa.DLq = ((String)localObject);
      localboa.DLs = localdkv.EAA.DLs;
      localArrayList.add(localboa);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(200943);
    return localObject;
  }
  
  public final h fYR()
  {
    AppMethodBeat.i(200941);
    if (this.LrB.isEmpty())
    {
      localObject = h.yZw;
      localObject = new h(0L, (List)new ArrayList(), "", new dkv());
      AppMethodBeat.o(200941);
      return localObject;
    }
    long l = ((dkv)this.LrB.get(this.currentIndex)).CFc;
    Object localObject = a((dkv)this.LrB.get(this.currentIndex));
    String str = ((dkv)this.LrB.get(this.currentIndex)).EAA.DLo;
    k.g(str, "scripts[currentIndex].music.music_url");
    localObject = new h(l, (List)localObject, str, (dkv)this.LrB.get(this.currentIndex));
    AppMethodBeat.o(200941);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(200944);
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(200944);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramn).yZI;
      if (paramString == null) {
        k.aPZ("response");
      }
      this.Lry = paramString.DsA;
      paramString = this.ctt;
      paramn = this.Lry;
      if (paramn == null) {
        k.fvU();
      }
      paramString.encode("VLOG_CONF", paramn.toByteArray());
      ja((List)this.Lqh);
      AppMethodBeat.o(200944);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(200944);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramn).yZF;
      if (paramString == null) {
        k.aPZ("response");
      }
      paramString = paramString.Dph;
      long l = paramString.CFn;
      paramn = paramString.Dpi;
      ad.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramn);
      this.currentIndex = 0;
      List localList = this.LrB;
      k.g(paramn, "scripts");
      localList.addAll(0, (Collection)paramn);
      if (((Collection)paramn).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramn = this.LrA;
      if (paramn != null) {
        paramn.aA(paramString);
      }
    }
    for (;;)
    {
      this.LrA = null;
      AppMethodBeat.o(200944);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.LrA;
      if (paramString != null) {
        paramString.aA(null);
      }
    }
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200938);
    ad.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + paramInt1 + ", " + paramInt2);
    this.aMl = paramInt2;
    this.aMk = paramInt1;
    AppMethodBeat.o(200938);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
  public static final class a
  {
    public static List<d> a(dkv paramdkv)
    {
      AppMethodBeat.i(200936);
      k.h(paramdkv, "script");
      paramdkv = paramdkv.zcd;
      k.g(paramdkv, "script.materials");
      paramdkv = (Iterable)paramdkv;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramdkv.iterator();
      bpc localbpc;
      long l;
      label139:
      Object localObject;
      if (localIterator.hasNext())
      {
        localbpc = (bpc)localIterator.next();
        l = localbpc.dcn;
        if (l == 2L)
        {
          paramdkv = localbpc.path;
          k.g(paramdkv, "materialResp.path");
          paramdkv = (d)new i(paramdkv, localbpc.DMG, localbpc.DMH, (float)localbpc.DMI, localbpc.begin_time, localbpc.begin_time + localbpc.duration);
          if (paramdkv == null) {
            break label311;
          }
          if (localbpc.DME != 3L) {
            break label279;
          }
          localObject = e.yZj;
          label159:
          paramdkv.a((e)localObject);
          if (localbpc.DML != null) {
            break label286;
          }
        }
      }
      label179:
      label311:
      label314:
      label329:
      for (;;)
      {
        localObject = f.yZm;
        dkv localdkv = paramdkv;
        localdkv.a((f)localObject);
        paramdkv.yZf = ((List)localbpc.DMJ);
        paramdkv.yZg = ((List)localbpc.DMK);
        for (;;)
        {
          if (paramdkv == null) {
            break label314;
          }
          localCollection.add(paramdkv);
          break;
          if (l == 1L)
          {
            paramdkv = localbpc.path;
            k.g(paramdkv, "materialResp.path");
            paramdkv = (d)new c(paramdkv, localbpc.begin_time, localbpc.begin_time + localbpc.duration);
            break label139;
          }
          paramdkv = null;
          break label139;
          localObject = e.yZi;
          break label159;
          if (localbpc.DML.DMC != 2L) {
            break label329;
          }
          localObject = f.yZn;
          localdkv = paramdkv;
          break label179;
          paramdkv = null;
        }
        break;
        paramdkv = (List)localCollection;
        AppMethodBeat.o(200936);
        return paramdkv;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    b(z paramz, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */