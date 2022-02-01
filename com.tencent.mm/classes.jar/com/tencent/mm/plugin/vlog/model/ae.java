package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.fpc;
import com.tencent.mm.protocal.protobuf.fyd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", "index", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements com.tencent.mm.am.h
{
  public static final a UaJ;
  public final LinkedList<ad> TZE;
  private LinkedList<dmr> UaK;
  public acw UaL;
  private Map<Long, String> UaM;
  public kotlin.g.a.b<? super cct, ah> UaN;
  public List<fyd> UaO;
  public boolean UaP;
  public int currentIndex;
  public final MultiProcessMMKV eMf;
  public int oeO;
  int previewHeight;
  int previewWidth;
  
  static
  {
    AppMethodBeat.i(283648);
    UaJ = new a((byte)0);
    AppMethodBeat.o(283648);
  }
  
  public ae()
  {
    AppMethodBeat.i(283605);
    this.eMf = MultiProcessMMKV.getSingleMMKV("MicroMsg.VLogDataManager");
    this.UaK = new LinkedList();
    this.UaM = ((Map)new LinkedHashMap());
    this.TZE = new LinkedList();
    this.UaO = ((List)new ArrayList());
    com.tencent.mm.kernel.h.aZW().a(1469, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(2972, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(283605);
  }
  
  public static boolean hRi()
  {
    return true;
  }
  
  public final List<s> a(fyd paramfyd)
  {
    AppMethodBeat.i(283692);
    paramfyd = paramfyd.UaK;
    kotlin.g.b.s.s(paramfyd, "script.materials");
    paramfyd = (Iterable)paramfyd;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramfyd.iterator();
    dms localdms;
    Object localObject;
    if (localIterator.hasNext())
    {
      localdms = (dms)localIterator.next();
      localObject = (String)this.UaM.get(Long.valueOf(localdms.id));
      paramfyd = (fyd)localObject;
      if (localObject == null) {
        paramfyd = "";
      }
      localdms.path = paramfyd;
      long l = localdms.beV;
      if (l == 2L)
      {
        localObject = (String)this.UaM.get(Long.valueOf(localdms.id));
        paramfyd = (fyd)localObject;
        if (localObject == null) {
          paramfyd = "";
        }
        paramfyd = (s)new ak(paramfyd, localdms.aaTa, localdms.aaTb, (float)localdms.aaTc, localdms.begin_time, localdms.begin_time + localdms.duration);
      }
      for (;;)
      {
        if (paramfyd != null) {
          break label290;
        }
        paramfyd = null;
        label199:
        if (paramfyd == null) {
          break label361;
        }
        localCollection.add(paramfyd);
        break;
        if (l == 1L)
        {
          localObject = (String)this.UaM.get(Long.valueOf(localdms.id));
          paramfyd = (fyd)localObject;
          if (localObject == null) {
            paramfyd = "";
          }
          paramfyd = (s)new q(paramfyd, localdms.begin_time, localdms.begin_time + localdms.duration);
        }
        else
        {
          paramfyd = null;
        }
      }
      label290:
      if (localdms.aaSY == 3L)
      {
        localObject = y.Uaf;
        label307:
        paramfyd.a((y)localObject);
        if (localdms.aaTf != null) {
          break label371;
        }
      }
    }
    label410:
    for (;;)
    {
      localObject = aa.Uao;
      for (fyd localfyd = paramfyd;; localfyd = paramfyd)
      {
        localfyd.a((aa)localObject);
        paramfyd.TZB = ((List)localdms.aaTd);
        paramfyd.TZC = ((List)localdms.aaTe);
        break label199;
        label361:
        break;
        localObject = y.Uae;
        break label307;
        label371:
        if (localdms.aaTf.aaSW != 2L) {
          break label410;
        }
        localObject = aa.Uap;
      }
      paramfyd = (List)localCollection;
      AppMethodBeat.o(283692);
      return paramfyd;
    }
  }
  
  public final List<dls> gnn()
  {
    AppMethodBeat.i(283654);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (Iterable)this.UaO;
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      fyd localfyd = (fyd)localObject;
      dls localdls = new dls();
      String str = localfyd.abVZ.aaRO;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localdls.aaRO = ((String)localObject);
      localdls.aaRI = ((int)localfyd.abVZ.aame);
      localdls.aaRQ = localfyd.abVZ.aaRQ;
      str = localfyd.abVZ.ZTw;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localdls.ZTw = ((String)localObject);
      localdls.aaRR = localfyd.abVZ.aaRR;
      localArrayList.add(localdls);
      i += 1;
    }
    localObject = (List)localArrayList;
    AppMethodBeat.o(283654);
    return localObject;
  }
  
  public final void lI(List<ad> paramList)
  {
    AppMethodBeat.i(283680);
    d.d("generateVLog", (kotlin.g.a.a)new ae.b(this, paramList));
    AppMethodBeat.o(283680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(283671);
    if ((paramp instanceof com.tencent.mm.plugin.vlog.model.cgi.b))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(283671);
        return;
      }
      paramp = ((com.tencent.mm.plugin.vlog.model.cgi.b)paramp).Ubr;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("response");
        paramString = null;
      }
      this.UaL = paramString.aaqm;
      paramString = this.eMf;
      paramp = this.UaL;
      kotlin.g.b.s.checkNotNull(paramp);
      paramString.encode("VLOG_CONF", paramp.toByteArray());
      lI((List)this.TZE);
      AppMethodBeat.o(283671);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.vlog.model.cgi.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(283671);
        return;
      }
      paramp = ((com.tencent.mm.plugin.vlog.model.cgi.a)paramp).Ubo;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("response");
        paramString = null;
      }
      paramString = paramString.aamg;
      long l = paramString.YNE;
      paramp = paramString.aamh;
      Log.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + l + ", scripts = " + paramp);
      this.currentIndex = 0;
      List localList = this.UaO;
      kotlin.g.b.s.s(paramp, "scripts");
      localList.addAll(0, (Collection)paramp);
      if (((Collection)paramp).isEmpty()) {
        break label358;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label363;
      }
      paramp = this.UaN;
      if (paramp != null) {
        paramp.invoke(paramString);
      }
    }
    for (;;)
    {
      this.UaN = null;
      AppMethodBeat.o(283671);
      return;
      label358:
      paramInt1 = 0;
      break;
      label363:
      paramString = this.UaN;
      if (paramString != null) {
        paramString.invoke(null);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static List<s> a(fyd paramfyd)
    {
      AppMethodBeat.i(283523);
      kotlin.g.b.s.u(paramfyd, "script");
      paramfyd = paramfyd.UaK;
      kotlin.g.b.s.s(paramfyd, "script.materials");
      paramfyd = (Iterable)paramfyd;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramfyd.iterator();
      dms localdms;
      label145:
      label215:
      Object localObject;
      if (localIterator.hasNext())
      {
        localdms = (dms)localIterator.next();
        long l = localdms.beV;
        if (l == 2L)
        {
          paramfyd = localdms.path;
          kotlin.g.b.s.s(paramfyd, "materialResp.path");
          paramfyd = (s)new ak(paramfyd, localdms.aaTa, localdms.aaTb, (float)localdms.aaTc, localdms.begin_time, localdms.begin_time + localdms.duration);
        }
        for (;;)
        {
          if (paramfyd != null) {
            break label215;
          }
          paramfyd = null;
          if (paramfyd == null) {
            break label282;
          }
          localCollection.add(paramfyd);
          break;
          if (l == 1L)
          {
            paramfyd = localdms.path;
            kotlin.g.b.s.s(paramfyd, "materialResp.path");
            paramfyd = (s)new q(paramfyd, localdms.begin_time, localdms.begin_time + localdms.duration);
          }
          else
          {
            paramfyd = null;
          }
        }
        if (localdms.aaSY == 3L)
        {
          localObject = y.Uaf;
          label231:
          paramfyd.a((y)localObject);
          if (localdms.aaTf != null) {
            break label291;
          }
        }
      }
      label282:
      label291:
      label329:
      for (;;)
      {
        localObject = aa.Uao;
        for (fyd localfyd = paramfyd;; localfyd = paramfyd)
        {
          localfyd.a((aa)localObject);
          paramfyd.TZB = ((List)localdms.aaTd);
          paramfyd.TZC = ((List)localdms.aaTe);
          break label145;
          break;
          localObject = y.Uae;
          break label231;
          if (localdms.aaTf.aaSW != 2L) {
            break label329;
          }
          localObject = aa.Uap;
        }
        paramfyd = (List)localCollection;
        AppMethodBeat.o(283523);
        return paramfyd;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ae
 * JD-Core Version:    0.7.0.1
 */