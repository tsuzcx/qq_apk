package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class v
  implements com.tencent.mm.ak.g
{
  public static final v.a AoN;
  public final LinkedList<u> Ane;
  private LinkedList<btr> AoH;
  private xa AoI;
  private Map<Long, String> AoJ;
  d.g.a.b<? super are, d.y> AoK;
  private List<dqm> AoL;
  public boolean AoM;
  private int aNa;
  private int aNb;
  private final aw cqB;
  private int currentIndex;
  private int yiF;
  
  static
  {
    AppMethodBeat.i(207634);
    AoN = new v.a((byte)0);
    AppMethodBeat.o(207634);
  }
  
  public v()
  {
    AppMethodBeat.i(207633);
    this.cqB = aw.aKU("MicroMsg.VLogDataManager");
    this.AoH = new LinkedList();
    this.AoJ = ((Map)new LinkedHashMap());
    this.Ane = new LinkedList();
    this.AoL = ((List)new ArrayList());
    com.tencent.mm.kernel.g.agi().a(1469, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(2972, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(207633);
  }
  
  private final List<i> a(dqm paramdqm)
  {
    AppMethodBeat.i(207632);
    paramdqm = paramdqm.AoH;
    k.g(paramdqm, "script.materials");
    paramdqm = (Iterable)paramdqm;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramdqm.iterator();
    bts localbts;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localbts = (bts)localIterator.next();
      localObject = (String)this.AoJ.get(Long.valueOf(localbts.id));
      paramdqm = (dqm)localObject;
      if (localObject == null) {
        paramdqm = "";
      }
      localbts.path = paramdqm;
      l = localbts.cZM;
      if (l == 2L)
      {
        localObject = (String)this.AoJ.get(Long.valueOf(localbts.id));
        paramdqm = (dqm)localObject;
        if (localObject == null) {
          paramdqm = "";
        }
        paramdqm = (i)new z(paramdqm, localbts.FiW, localbts.FiX, (float)localbts.FiY, localbts.begin_time, localbts.begin_time + localbts.duration);
        label193:
        if (paramdqm == null) {
          break label392;
        }
        if (localbts.FiU != 3L) {
          break label358;
        }
        localObject = m.AnF;
        label214:
        paramdqm.a((m)localObject);
        if (localbts.Fjb != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = q.AnO;
      dqm localdqm = paramdqm;
      label236:
      localdqm.a((q)localObject);
      paramdqm.Anb = ((List)localbts.FiZ);
      paramdqm.Anc = ((List)localbts.Fja);
      for (;;)
      {
        if (paramdqm == null) {
          break label395;
        }
        localCollection.add(paramdqm);
        break;
        if (l == 1L)
        {
          localObject = (String)this.AoJ.get(Long.valueOf(localbts.id));
          paramdqm = (dqm)localObject;
          if (localObject == null) {
            paramdqm = "";
          }
          paramdqm = (i)new g(paramdqm, localbts.begin_time, localbts.begin_time + localbts.duration);
          break label193;
        }
        paramdqm = null;
        break label193;
        label358:
        localObject = m.AnE;
        break label214;
        label366:
        if (localbts.Fjb.FiS != 2L) {
          break label410;
        }
        localObject = q.AnP;
        localdqm = paramdqm;
        break label236;
        paramdqm = null;
      }
      break;
      paramdqm = (List)localCollection;
      AppMethodBeat.o(207632);
      return paramdqm;
    }
  }
  
  private final void gr(List<u> paramList)
  {
    AppMethodBeat.i(207631);
    c.b("generateVLog", (d.g.a.a)new v.b(this, paramList));
    AppMethodBeat.o(207631);
  }
  
  public final y RP(int paramInt)
  {
    AppMethodBeat.i(207628);
    this.currentIndex = paramInt;
    long l = ((dqm)this.AoL.get(this.currentIndex)).DXC;
    Object localObject = a((dqm)this.AoL.get(this.currentIndex));
    String str = ((dqm)this.AoL.get(this.currentIndex)).FXO.FhD;
    k.g(str, "scripts[currentIndex].music.music_url");
    localObject = new y(l, (List)localObject, str, (dqm)this.AoL.get(this.currentIndex));
    AppMethodBeat.o(207628);
    return localObject;
  }
  
  public final void a(int paramInt, d.g.a.b<? super are, d.y> paramb)
  {
    AppMethodBeat.i(207625);
    this.AoK = paramb;
    this.yiF = paramInt;
    if (paramInt == 0) {
      this.AoL.clear();
    }
    paramb = this.cqB.decodeBytes("VLOG_CONF");
    if (paramb != null) {
      if (paramb.length != 0) {
        break label81;
      }
    }
    label81:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      paramb = new com.tencent.mm.plugin.vlog.model.cgi.b();
      com.tencent.mm.kernel.g.agi().b((n)paramb);
      AppMethodBeat.o(207625);
      return;
    }
    paramb = new xa().parseFrom(paramb);
    if (paramb == null)
    {
      paramb = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
      AppMethodBeat.o(207625);
      throw paramb;
    }
    this.AoI = ((xa)paramb);
    gr((List)this.Ane);
    AppMethodBeat.o(207625);
  }
  
  public final List<bsq> diF()
  {
    AppMethodBeat.i(207629);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.AoL;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      dqm localdqm = (dqm)localObject;
      bsq localbsq = new bsq();
      String str = localdqm.FXO.FhD;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbsq.FhD = ((String)localObject);
      localbsq.Fhx = ((int)localdqm.FXO.EKf);
      localbsq.FhG = localdqm.FXO.FhG;
      str = localdqm.FXO.FhF;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbsq.FhF = ((String)localObject);
      localbsq.FhH = localdqm.FXO.FhH;
      localArrayList.add(localbsq);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(207629);
    return localObject;
  }
  
  public final y efL()
  {
    AppMethodBeat.i(207627);
    if (this.AoL.isEmpty())
    {
      localObject = y.AoZ;
      localObject = new y(0L, (List)new ArrayList(), "", new dqm());
      AppMethodBeat.o(207627);
      return localObject;
    }
    long l = ((dqm)this.AoL.get(this.currentIndex)).DXC;
    Object localObject = a((dqm)this.AoL.get(this.currentIndex));
    String str = ((dqm)this.AoL.get(this.currentIndex)).FXO.FhD;
    k.g(str, "scripts[currentIndex].music.music_url");
    localObject = new y(l, (List)localObject, str, (dqm)this.AoL.get(this.currentIndex));
    AppMethodBeat.o(207627);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(207630);
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(207630);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramn).Apl;
      if (paramString == null) {
        k.aVY("response");
      }
      this.AoI = paramString.ENE;
      paramString = this.cqB;
      paramn = this.AoI;
      if (paramn == null) {
        k.fOy();
      }
      paramString.encode("VLOG_CONF", paramn.toByteArray());
      gr((List)this.Ane);
      AppMethodBeat.o(207630);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(207630);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramn).Api;
      if (paramString == null) {
        k.aVY("response");
      }
      paramString = paramString.EKh;
      long l = paramString.DXN;
      paramn = paramString.EKi;
      ac.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramn);
      this.currentIndex = 0;
      List localList = this.AoL;
      k.g(paramn, "scripts");
      localList.addAll(0, (Collection)paramn);
      if (((Collection)paramn).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramn = this.AoK;
      if (paramn != null) {
        paramn.ay(paramString);
      }
    }
    for (;;)
    {
      this.AoK = null;
      AppMethodBeat.o(207630);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.AoK;
      if (paramString != null) {
        paramString.ay(null);
      }
    }
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207624);
    ac.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + paramInt1 + ", " + paramInt2);
    this.aNb = paramInt2;
    this.aNa = paramInt1;
    AppMethodBeat.o(207624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */