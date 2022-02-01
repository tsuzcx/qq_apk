package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.protocal.protobuf.fbs;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class ae
  implements i
{
  public static final a Nno;
  public int KlE;
  public final LinkedList<ad> NlY;
  private LinkedList<cvl> Nni;
  public aaw Nnj;
  private Map<Long, String> Nnk;
  public kotlin.g.a.b<? super boi, x> Nnl;
  public List<fbs> Nnm;
  public boolean Nnn;
  public final MultiProcessMMKV cQO;
  public int currentIndex;
  int previewHeight;
  int previewWidth;
  
  static
  {
    AppMethodBeat.i(243759);
    Nno = new a((byte)0);
    AppMethodBeat.o(243759);
  }
  
  public ae()
  {
    AppMethodBeat.i(243758);
    this.cQO = MultiProcessMMKV.getSingleMMKV("MicroMsg.VLogDataManager");
    this.Nni = new LinkedList();
    this.Nnk = ((Map)new LinkedHashMap());
    this.NlY = new LinkedList();
    this.Nnm = ((List)new ArrayList());
    h.aGY().a(1469, (i)this);
    h.aGY().a(2972, (i)this);
    AppMethodBeat.o(243758);
  }
  
  public final List<s> a(fbs paramfbs)
  {
    AppMethodBeat.i(243757);
    paramfbs = paramfbs.Nni;
    p.j(paramfbs, "script.materials");
    paramfbs = (Iterable)paramfbs;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramfbs.iterator();
    cvm localcvm;
    Object localObject;
    long l;
    if (localIterator.hasNext())
    {
      localcvm = (cvm)localIterator.next();
      localObject = (String)this.Nnk.get(Long.valueOf(localcvm.id));
      paramfbs = (fbs)localObject;
      if (localObject == null) {
        paramfbs = "";
      }
      localcvm.path = paramfbs;
      l = localcvm.fwf;
      if (l == 2L)
      {
        localObject = (String)this.Nnk.get(Long.valueOf(localcvm.id));
        paramfbs = (fbs)localObject;
        if (localObject == null) {
          paramfbs = "";
        }
        paramfbs = (s)new aj(paramfbs, localcvm.TDu, localcvm.TDv, (float)localcvm.TDw, localcvm.begin_time, localcvm.begin_time + localcvm.duration);
        label193:
        if (paramfbs == null) {
          break label392;
        }
        if (localcvm.TDs != 3L) {
          break label358;
        }
        localObject = y.NmD;
        label214:
        paramfbs.a((y)localObject);
        if (localcvm.TDz != null) {
          break label366;
        }
      }
    }
    label392:
    label395:
    label410:
    for (;;)
    {
      localObject = aa.NmL;
      fbs localfbs = paramfbs;
      label236:
      localfbs.a((aa)localObject);
      paramfbs.NlV = ((List)localcvm.TDx);
      paramfbs.NlW = ((List)localcvm.TDy);
      for (;;)
      {
        if (paramfbs == null) {
          break label395;
        }
        localCollection.add(paramfbs);
        break;
        if (l == 1L)
        {
          localObject = (String)this.Nnk.get(Long.valueOf(localcvm.id));
          paramfbs = (fbs)localObject;
          if (localObject == null) {
            paramfbs = "";
          }
          paramfbs = (s)new q(paramfbs, localcvm.begin_time, localcvm.begin_time + localcvm.duration);
          break label193;
        }
        paramfbs = null;
        break label193;
        label358:
        localObject = y.NmC;
        break label214;
        label366:
        if (localcvm.TDz.TDq != 2L) {
          break label410;
        }
        localObject = aa.NmM;
        localfbs = paramfbs;
        break label236;
        paramfbs = null;
      }
      break;
      paramfbs = (List)localCollection;
      AppMethodBeat.o(243757);
      return paramfbs;
    }
  }
  
  public final List<cum> fek()
  {
    AppMethodBeat.i(243751);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.Nnm;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      fbs localfbs = (fbs)localObject;
      cum localcum = new cum();
      String str = localfbs.UBQ.TCi;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcum.TCi = ((String)localObject);
      localcum.TCc = ((int)localfbs.UBQ.SZm);
      localcum.TCk = localfbs.UBQ.TCk;
      str = localfbs.UBQ.SMU;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcum.SMU = ((String)localObject);
      localcum.TCl = localfbs.UBQ.TCl;
      localArrayList.add(localcum);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(243751);
    return localObject;
  }
  
  public final void iC(final List<ad> paramList)
  {
    AppMethodBeat.i(243755);
    d.b("generateVLog", (kotlin.g.a.a)new b(this, paramList));
    AppMethodBeat.o(243755);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(243753);
    if ((paramq instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(243753);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramq).NnN;
      if (paramString == null) {
        p.bGy("response");
      }
      this.Nnj = paramString.TcX;
      paramString = this.cQO;
      paramq = this.Nnj;
      if (paramq == null) {
        p.iCn();
      }
      paramString.encode("VLOG_CONF", paramq.toByteArray());
      iC((List)this.NlY);
      AppMethodBeat.o(243753);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(243753);
        return;
      }
      paramString = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramq).NnK;
      if (paramString == null) {
        p.bGy("response");
      }
      paramString = paramString.SZo;
      long l = paramString.RQn;
      paramq = paramString.SZp;
      Log.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramq);
      this.currentIndex = 0;
      List localList = this.Nnm;
      p.j(paramq, "scripts");
      localList.addAll(0, (Collection)paramq);
      if (((Collection)paramq).isEmpty()) {
        break label347;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label352;
      }
      paramq = this.Nnl;
      if (paramq != null) {
        paramq.invoke(paramString);
      }
    }
    for (;;)
    {
      this.Nnl = null;
      AppMethodBeat.o(243753);
      return;
      label347:
      paramInt1 = 0;
      break;
      label352:
      paramString = this.Nnl;
      if (paramString != null) {
        paramString.invoke(null);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
  public static final class a
  {
    public static List<s> a(fbs paramfbs)
    {
      AppMethodBeat.i(240245);
      p.k(paramfbs, "script");
      paramfbs = paramfbs.Nni;
      p.j(paramfbs, "script.materials");
      paramfbs = (Iterable)paramfbs;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramfbs.iterator();
      cvm localcvm;
      long l;
      label139:
      Object localObject;
      if (localIterator.hasNext())
      {
        localcvm = (cvm)localIterator.next();
        l = localcvm.fwf;
        if (l == 2L)
        {
          paramfbs = localcvm.path;
          p.j(paramfbs, "materialResp.path");
          paramfbs = (s)new aj(paramfbs, localcvm.TDu, localcvm.TDv, (float)localcvm.TDw, localcvm.begin_time, localcvm.begin_time + localcvm.duration);
          if (paramfbs == null) {
            break label311;
          }
          if (localcvm.TDs != 3L) {
            break label279;
          }
          localObject = y.NmD;
          label159:
          paramfbs.a((y)localObject);
          if (localcvm.TDz != null) {
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
        localObject = aa.NmL;
        fbs localfbs = paramfbs;
        localfbs.a((aa)localObject);
        paramfbs.NlV = ((List)localcvm.TDx);
        paramfbs.NlW = ((List)localcvm.TDy);
        for (;;)
        {
          if (paramfbs == null) {
            break label314;
          }
          localCollection.add(paramfbs);
          break;
          if (l == 1L)
          {
            paramfbs = localcvm.path;
            p.j(paramfbs, "materialResp.path");
            paramfbs = (s)new q(paramfbs, localcvm.begin_time, localcvm.begin_time + localcvm.duration);
            break label139;
          }
          paramfbs = null;
          break label139;
          localObject = y.NmC;
          break label159;
          if (localcvm.TDz.TDq != 2L) {
            break label329;
          }
          localObject = aa.NmM;
          localfbs = paramfbs;
          break label179;
          paramfbs = null;
        }
        break;
        paramfbs = (List)localCollection;
        AppMethodBeat.o(240245);
        return paramfbs;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ae
 * JD-Core Version:    0.7.0.1
 */