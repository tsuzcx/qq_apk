package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class x
  implements f
{
  public static final a BYd;
  public final LinkedList<w> BWP;
  private LinkedList<byz> BXX;
  public zc BXY;
  private Map<Long, String> BXZ;
  public d.g.a.b<? super avq, z> BYa;
  public List<dxb> BYb;
  public boolean BYc;
  public int aXs;
  public int aXt;
  public final ay cCf;
  public int currentIndex;
  public int zQm;
  
  static
  {
    AppMethodBeat.i(191280);
    BYd = new a((byte)0);
    AppMethodBeat.o(191280);
  }
  
  public x()
  {
    AppMethodBeat.i(191279);
    this.cCf = ay.aRX("MicroMsg.VLogDataManager");
    this.BXX = new LinkedList();
    this.BXZ = ((Map)new LinkedHashMap());
    this.BWP = new LinkedList();
    this.BYb = ((List)new ArrayList());
    g.ajj().a(1469, (f)this);
    g.ajj().a(2972, (f)this);
    AppMethodBeat.o(191279);
  }
  
  public final List<l> a(dxb paramdxb)
  {
    AppMethodBeat.i(191278);
    paramdxb = paramdxb.BXX;
    p.g(paramdxb, "script.materials");
    paramdxb = (Iterable)paramdxb;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramdxb.iterator();
    bza localbza;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localbza = (bza)localIterator.next();
      localObject = (String)this.BXZ.get(Long.valueOf(localbza.id));
      paramdxb = (dxb)localObject;
      if (localObject == null) {
        paramdxb = "";
      }
      localbza.path = paramdxb;
      l = localbza.dmg;
      if (l == 2L)
      {
        localObject = (String)this.BXZ.get(Long.valueOf(localbza.id));
        paramdxb = (dxb)localObject;
        if (localObject == null) {
          paramdxb = "";
        }
        paramdxb = (l)new ab(paramdxb, localbza.HlY, localbza.HlZ, (float)localbza.Hma, localbza.begin_time, localbza.begin_time + localbza.duration);
        label193:
        if (paramdxb == null) {
          break label392;
        }
        if (localbza.HlW != 3L) {
          break label358;
        }
        localObject = r.BXw;
        label214:
        paramdxb.a((r)localObject);
        if (localbza.Hmd != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = u.BXF;
      dxb localdxb = paramdxb;
      label236:
      localdxb.a((u)localObject);
      paramdxb.BWM = ((List)localbza.Hmb);
      paramdxb.BWN = ((List)localbza.Hmc);
      for (;;)
      {
        if (paramdxb == null) {
          break label395;
        }
        localCollection.add(paramdxb);
        break;
        if (l == 1L)
        {
          localObject = (String)this.BXZ.get(Long.valueOf(localbza.id));
          paramdxb = (dxb)localObject;
          if (localObject == null) {
            paramdxb = "";
          }
          paramdxb = (l)new j(paramdxb, localbza.begin_time, localbza.begin_time + localbza.duration);
          break label193;
        }
        paramdxb = null;
        break label193;
        label358:
        localObject = r.BXv;
        break label214;
        label366:
        if (localbza.Hmd.HlU != 2L) {
          break label410;
        }
        localObject = u.BXG;
        localdxb = paramdxb;
        break label236;
        paramdxb = null;
      }
      break;
      paramdxb = (List)localCollection;
      AppMethodBeat.o(191278);
      return paramdxb;
    }
  }
  
  public final List<bxx> dwg()
  {
    AppMethodBeat.i(191275);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.BYb;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        d.a.j.gkd();
      }
      dxb localdxb = (dxb)localObject;
      bxx localbxx = new bxx();
      String str = localdxb.Icw.HkG;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbxx.HkG = ((String)localObject);
      localbxx.HkA = ((int)localdxb.Icw.GMF);
      localbxx.HkJ = localdxb.Icw.HkJ;
      str = localdxb.Icw.HkI;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbxx.HkI = ((String)localObject);
      localbxx.HkK = localdxb.Icw.HkK;
      localArrayList.add(localbxx);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(191275);
    return localObject;
  }
  
  public final void gL(final List<w> paramList)
  {
    AppMethodBeat.i(191277);
    c.b("generateVLog", (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(191277);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(191276);
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(191276);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramn).BYA;
      if (paramString == null) {
        p.bdF("response");
      }
      this.BXY = paramString.GQi;
      paramString = this.cCf;
      paramn = this.BXY;
      if (paramn == null) {
        p.gkB();
      }
      paramString.encode("VLOG_CONF", paramn.toByteArray());
      gL((List)this.BWP);
      AppMethodBeat.o(191276);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(191276);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramn).BYx;
      if (paramString == null) {
        p.bdF("response");
      }
      paramString = paramString.GMH;
      long l = paramString.FVE;
      paramn = paramString.GMI;
      ae.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramn);
      this.currentIndex = 0;
      List localList = this.BYb;
      p.g(paramn, "scripts");
      localList.addAll(0, (Collection)paramn);
      if (((Collection)paramn).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramn = this.BYa;
      if (paramn != null) {
        paramn.invoke(paramString);
      }
    }
    for (;;)
    {
      this.BYa = null;
      AppMethodBeat.o(191276);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.BYa;
      if (paramString != null) {
        paramString.invoke(null);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
  public static final class a
  {
    public static List<l> a(dxb paramdxb)
    {
      AppMethodBeat.i(191273);
      p.h(paramdxb, "script");
      paramdxb = paramdxb.BXX;
      p.g(paramdxb, "script.materials");
      paramdxb = (Iterable)paramdxb;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramdxb.iterator();
      bza localbza;
      long l;
      label139:
      Object localObject;
      if (localIterator.hasNext())
      {
        localbza = (bza)localIterator.next();
        l = localbza.dmg;
        if (l == 2L)
        {
          paramdxb = localbza.path;
          p.g(paramdxb, "materialResp.path");
          paramdxb = (l)new ab(paramdxb, localbza.HlY, localbza.HlZ, (float)localbza.Hma, localbza.begin_time, localbza.begin_time + localbza.duration);
          if (paramdxb == null) {
            break label311;
          }
          if (localbza.HlW != 3L) {
            break label279;
          }
          localObject = r.BXw;
          label159:
          paramdxb.a((r)localObject);
          if (localbza.Hmd != null) {
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
        localObject = u.BXF;
        dxb localdxb = paramdxb;
        localdxb.a((u)localObject);
        paramdxb.BWM = ((List)localbza.Hmb);
        paramdxb.BWN = ((List)localbza.Hmc);
        for (;;)
        {
          if (paramdxb == null) {
            break label314;
          }
          localCollection.add(paramdxb);
          break;
          if (l == 1L)
          {
            paramdxb = localbza.path;
            p.g(paramdxb, "materialResp.path");
            paramdxb = (l)new j(paramdxb, localbza.begin_time, localbza.begin_time + localbza.duration);
            break label139;
          }
          paramdxb = null;
          break label139;
          localObject = r.BXv;
          break label159;
          if (localbza.Hmd.HlU != 2L) {
            break label329;
          }
          localObject = u.BXG;
          localdxb = paramdxb;
          break label179;
          paramdxb = null;
        }
        break;
        paramdxb = (List)localCollection;
        AppMethodBeat.o(191273);
        return paramdxb;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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