package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class x
  implements f
{
  public static final a BGE;
  public final LinkedList<w> BFr;
  private Map<Long, String> BGA;
  public d.g.a.b<? super ava, z> BGB;
  public List<dwg> BGC;
  public boolean BGD;
  private LinkedList<byf> BGy;
  public yz BGz;
  public int aXs;
  public int aXt;
  public final ax cBy;
  public int currentIndex;
  public int zyN;
  
  static
  {
    AppMethodBeat.i(195821);
    BGE = new a((byte)0);
    AppMethodBeat.o(195821);
  }
  
  public x()
  {
    AppMethodBeat.i(195820);
    this.cBy = ax.aQA("MicroMsg.VLogDataManager");
    this.BGy = new LinkedList();
    this.BGA = ((Map)new LinkedHashMap());
    this.BFr = new LinkedList();
    this.BGC = ((List)new ArrayList());
    g.aiU().a(1469, (f)this);
    g.aiU().a(2972, (f)this);
    AppMethodBeat.o(195820);
  }
  
  public final List<l> a(dwg paramdwg)
  {
    AppMethodBeat.i(195819);
    paramdwg = paramdwg.BGy;
    p.g(paramdwg, "script.materials");
    paramdwg = (Iterable)paramdwg;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramdwg.iterator();
    byg localbyg;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localbyg = (byg)localIterator.next();
      localObject = (String)this.BGA.get(Long.valueOf(localbyg.id));
      paramdwg = (dwg)localObject;
      if (localObject == null) {
        paramdwg = "";
      }
      localbyg.path = paramdwg;
      l = localbyg.dle;
      if (l == 2L)
      {
        localObject = (String)this.BGA.get(Long.valueOf(localbyg.id));
        paramdwg = (dwg)localObject;
        if (localObject == null) {
          paramdwg = "";
        }
        paramdwg = (l)new ab(paramdwg, localbyg.GSx, localbyg.GSy, (float)localbyg.GSz, localbyg.begin_time, localbyg.begin_time + localbyg.duration);
        label193:
        if (paramdwg == null) {
          break label392;
        }
        if (localbyg.GSv != 3L) {
          break label358;
        }
        localObject = r.BFY;
        label214:
        paramdwg.a((r)localObject);
        if (localbyg.GSC != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = u.BGh;
      dwg localdwg = paramdwg;
      label236:
      localdwg.a((u)localObject);
      paramdwg.BFo = ((List)localbyg.GSA);
      paramdwg.BFp = ((List)localbyg.GSB);
      for (;;)
      {
        if (paramdwg == null) {
          break label395;
        }
        localCollection.add(paramdwg);
        break;
        if (l == 1L)
        {
          localObject = (String)this.BGA.get(Long.valueOf(localbyg.id));
          paramdwg = (dwg)localObject;
          if (localObject == null) {
            paramdwg = "";
          }
          paramdwg = (l)new j(paramdwg, localbyg.begin_time, localbyg.begin_time + localbyg.duration);
          break label193;
        }
        paramdwg = null;
        break label193;
        label358:
        localObject = r.BFX;
        break label214;
        label366:
        if (localbyg.GSC.GSt != 2L) {
          break label410;
        }
        localObject = u.BGi;
        localdwg = paramdwg;
        break label236;
        paramdwg = null;
      }
      break;
      paramdwg = (List)localCollection;
      AppMethodBeat.o(195819);
      return paramdwg;
    }
  }
  
  public final List<bxd> dsR()
  {
    AppMethodBeat.i(195816);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.BGC;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        d.a.j.gfB();
      }
      dwg localdwg = (dwg)localObject;
      bxd localbxd = new bxd();
      String str = localdwg.HIK.GRf;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbxd.GRf = ((String)localObject);
      localbxd.GQZ = ((int)localdwg.HIK.Gth);
      localbxd.GRi = localdwg.HIK.GRi;
      str = localdwg.HIK.GRh;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbxd.GRh = ((String)localObject);
      localbxd.GRj = localdwg.HIK.GRj;
      localArrayList.add(localbxd);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(195816);
    return localObject;
  }
  
  public final void gC(final List<w> paramList)
  {
    AppMethodBeat.i(195818);
    c.b("generateVLog", (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(195818);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(195817);
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(195817);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramn).BHb;
      if (paramString == null) {
        p.bcb("response");
      }
      this.BGz = paramString.GwI;
      paramString = this.cBy;
      paramn = this.BGz;
      if (paramn == null) {
        p.gfZ();
      }
      paramString.encode("VLOG_CONF", paramn.toByteArray());
      gC((List)this.BFr);
      AppMethodBeat.o(195817);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(195817);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramn).BGY;
      if (paramString == null) {
        p.bcb("response");
      }
      paramString = paramString.Gtj;
      long l = paramString.FDj;
      paramn = paramString.Gtk;
      ad.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramn);
      this.currentIndex = 0;
      List localList = this.BGC;
      p.g(paramn, "scripts");
      localList.addAll(0, (Collection)paramn);
      if (((Collection)paramn).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramn = this.BGB;
      if (paramn != null) {
        paramn.invoke(paramString);
      }
    }
    for (;;)
    {
      this.BGB = null;
      AppMethodBeat.o(195817);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.BGB;
      if (paramString != null) {
        paramString.invoke(null);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
  public static final class a
  {
    public static List<l> a(dwg paramdwg)
    {
      AppMethodBeat.i(195814);
      p.h(paramdwg, "script");
      paramdwg = paramdwg.BGy;
      p.g(paramdwg, "script.materials");
      paramdwg = (Iterable)paramdwg;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramdwg.iterator();
      byg localbyg;
      long l;
      label139:
      Object localObject;
      if (localIterator.hasNext())
      {
        localbyg = (byg)localIterator.next();
        l = localbyg.dle;
        if (l == 2L)
        {
          paramdwg = localbyg.path;
          p.g(paramdwg, "materialResp.path");
          paramdwg = (l)new ab(paramdwg, localbyg.GSx, localbyg.GSy, (float)localbyg.GSz, localbyg.begin_time, localbyg.begin_time + localbyg.duration);
          if (paramdwg == null) {
            break label311;
          }
          if (localbyg.GSv != 3L) {
            break label279;
          }
          localObject = r.BFY;
          label159:
          paramdwg.a((r)localObject);
          if (localbyg.GSC != null) {
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
        localObject = u.BGh;
        dwg localdwg = paramdwg;
        localdwg.a((u)localObject);
        paramdwg.BFo = ((List)localbyg.GSA);
        paramdwg.BFp = ((List)localbyg.GSB);
        for (;;)
        {
          if (paramdwg == null) {
            break label314;
          }
          localCollection.add(paramdwg);
          break;
          if (l == 1L)
          {
            paramdwg = localbyg.path;
            p.g(paramdwg, "materialResp.path");
            paramdwg = (l)new j(paramdwg, localbyg.begin_time, localbyg.begin_time + localbyg.duration);
            break label139;
          }
          paramdwg = null;
          break label139;
          localObject = r.BFX;
          break label159;
          if (localbyg.GSC.GSt != 2L) {
            break label329;
          }
          localObject = u.BGi;
          localdwg = paramdwg;
          break label179;
          paramdwg = null;
        }
        break;
        paramdwg = (List)localCollection;
        AppMethodBeat.o(195814);
        return paramdwg;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(x paramx, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.x
 * JD-Core Version:    0.7.0.1
 */