package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class ae
  implements i
{
  public static final a GzI;
  public int DYl;
  public final LinkedList<ad> Gyw;
  private LinkedList<cmt> GzC;
  public aar GzD;
  private Map<Long, String> GzE;
  public kotlin.g.a.b<? super bha, x> GzF;
  public List<erh> GzG;
  public boolean GzH;
  public final MultiProcessMMKV cQe;
  public int currentIndex;
  int previewHeight;
  int previewWidth;
  
  static
  {
    AppMethodBeat.i(190719);
    GzI = new a((byte)0);
    AppMethodBeat.o(190719);
  }
  
  public ae()
  {
    AppMethodBeat.i(190718);
    this.cQe = MultiProcessMMKV.getSingleMMKV("MicroMsg.VLogDataManager");
    this.GzC = new LinkedList();
    this.GzE = ((Map)new LinkedHashMap());
    this.Gyw = new LinkedList();
    this.GzG = ((List)new ArrayList());
    g.azz().a(1469, (i)this);
    g.azz().a(2972, (i)this);
    AppMethodBeat.o(190718);
  }
  
  public final List<s> a(erh paramerh)
  {
    AppMethodBeat.i(190717);
    paramerh = paramerh.GzC;
    p.g(paramerh, "script.materials");
    paramerh = (Iterable)paramerh;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramerh.iterator();
    cmu localcmu;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localcmu = (cmu)localIterator.next();
      localObject = (String)this.GzE.get(Long.valueOf(localcmu.id));
      paramerh = (erh)localObject;
      if (localObject == null) {
        paramerh = "";
      }
      localcmu.path = paramerh;
      l = localcmu.dDw;
      if (l == 2L)
      {
        localObject = (String)this.GzE.get(Long.valueOf(localcmu.id));
        paramerh = (erh)localObject;
        if (localObject == null) {
          paramerh = "";
        }
        paramerh = (s)new aj(paramerh, localcmu.Mso, localcmu.Msp, (float)localcmu.Msq, localcmu.begin_time, localcmu.begin_time + localcmu.duration);
        label193:
        if (paramerh == null) {
          break label392;
        }
        if (localcmu.Msm != 3L) {
          break label358;
        }
        localObject = y.Gzb;
        label214:
        paramerh.a((y)localObject);
        if (localcmu.Mst != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = ab.Gzk;
      erh localerh = paramerh;
      label236:
      localerh.a((ab)localObject);
      paramerh.Gyt = ((List)localcmu.Msr);
      paramerh.Gyu = ((List)localcmu.Mss);
      for (;;)
      {
        if (paramerh == null) {
          break label395;
        }
        localCollection.add(paramerh);
        break;
        if (l == 1L)
        {
          localObject = (String)this.GzE.get(Long.valueOf(localcmu.id));
          paramerh = (erh)localObject;
          if (localObject == null) {
            paramerh = "";
          }
          paramerh = (s)new q(paramerh, localcmu.begin_time, localcmu.begin_time + localcmu.duration);
          break label193;
        }
        paramerh = null;
        break label193;
        label358:
        localObject = y.Gza;
        break label214;
        label366:
        if (localcmu.Mst.Msk != 2L) {
          break label410;
        }
        localObject = ab.Gzl;
        localerh = paramerh;
        break label236;
        paramerh = null;
      }
      break;
      paramerh = (List)localCollection;
      AppMethodBeat.o(190717);
      return paramerh;
    }
  }
  
  public final List<clp> eua()
  {
    AppMethodBeat.i(190714);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.GzG;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      erh localerh = (erh)localObject;
      clp localclp = new clp();
      String str = localerh.NoU.MqU;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localclp.MqU = ((String)localObject);
      localclp.MqO = ((int)localerh.NoU.LQL);
      localclp.MqX = localerh.NoU.MqX;
      str = localerh.NoU.MqW;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localclp.MqW = ((String)localObject);
      localclp.MqY = localerh.NoU.MqY;
      localArrayList.add(localclp);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(190714);
    return localObject;
  }
  
  public final void hN(final List<ad> paramList)
  {
    AppMethodBeat.i(190716);
    d.b("generateVLog", (kotlin.g.a.a)new b(this, paramList));
    AppMethodBeat.o(190716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(190715);
    if ((paramq instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(190715);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramq).GAh;
      if (paramString == null) {
        p.btv("response");
      }
      this.GzD = paramString.LUp;
      paramString = this.cQe;
      paramq = this.GzD;
      if (paramq == null) {
        p.hyc();
      }
      paramString.encode("VLOG_CONF", paramq.toByteArray());
      hN((List)this.Gyw);
      AppMethodBeat.o(190715);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(190715);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramq).GAe;
      if (paramString == null) {
        p.btv("response");
      }
      paramString = paramString.LQN;
      long l = paramString.KPp;
      paramq = paramString.LQO;
      Log.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramq);
      this.currentIndex = 0;
      List localList = this.GzG;
      p.g(paramq, "scripts");
      localList.addAll(0, (Collection)paramq);
      if (((Collection)paramq).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramq = this.GzF;
      if (paramq != null) {
        paramq.invoke(paramString);
      }
    }
    for (;;)
    {
      this.GzF = null;
      AppMethodBeat.o(190715);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.GzF;
      if (paramString != null) {
        paramString.invoke(null);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
  public static final class a
  {
    public static List<s> a(erh paramerh)
    {
      AppMethodBeat.i(190712);
      p.h(paramerh, "script");
      paramerh = paramerh.GzC;
      p.g(paramerh, "script.materials");
      paramerh = (Iterable)paramerh;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramerh.iterator();
      cmu localcmu;
      long l;
      label139:
      Object localObject;
      if (localIterator.hasNext())
      {
        localcmu = (cmu)localIterator.next();
        l = localcmu.dDw;
        if (l == 2L)
        {
          paramerh = localcmu.path;
          p.g(paramerh, "materialResp.path");
          paramerh = (s)new aj(paramerh, localcmu.Mso, localcmu.Msp, (float)localcmu.Msq, localcmu.begin_time, localcmu.begin_time + localcmu.duration);
          if (paramerh == null) {
            break label311;
          }
          if (localcmu.Msm != 3L) {
            break label279;
          }
          localObject = y.Gzb;
          label159:
          paramerh.a((y)localObject);
          if (localcmu.Mst != null) {
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
        localObject = ab.Gzk;
        erh localerh = paramerh;
        localerh.a((ab)localObject);
        paramerh.Gyt = ((List)localcmu.Msr);
        paramerh.Gyu = ((List)localcmu.Mss);
        for (;;)
        {
          if (paramerh == null) {
            break label314;
          }
          localCollection.add(paramerh);
          break;
          if (l == 1L)
          {
            paramerh = localcmu.path;
            p.g(paramerh, "materialResp.path");
            paramerh = (s)new q(paramerh, localcmu.begin_time, localcmu.begin_time + localcmu.duration);
            break label139;
          }
          paramerh = null;
          break label139;
          localObject = y.Gza;
          break label159;
          if (localcmu.Mst.Msk != 2L) {
            break label329;
          }
          localObject = ab.Gzl;
          localerh = paramerh;
          break label179;
          paramerh = null;
        }
        break;
        paramerh = (List)localCollection;
        AppMethodBeat.o(190712);
        return paramerh;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(ae paramae, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ae
 * JD-Core Version:    0.7.0.1
 */