package com.tencent.mm.plugin.mv.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ii;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.util.c;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper;", "", "()V", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCreateActionStruct;", "finderPostFinishListener", "com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1;", "fromScene", "", "isFlexMode", "", "materialFrom", "", "materialPosition", "postCache", "", "cacheMaterialFrom", "", "cacheMaterialPosition", "cacheMode", "enterCreateMv", "context", "Landroid/content/Context;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getModeVal", "initReporter", "onCancelMaterial", "position", "data", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "isScrollEdit", "onChangeTransition", "transitionType", "onChangedMode", "onConfirmMaterial", "onCreateMvFinish", "imgCnt", "videoCnt", "onDestroy", "onDragDropTrack", "onMaterialDelete", "onMaterialExposure", "onPostActionInvoke", "onPreparePostSuccess", "localId", "onPreviewMvFinish", "onReplayTransition", "onSaveDraft", "isSave", "isFinderNew", "partList", "", "onScaleTimeTrack", "onSearch", "keyWord", "expId", "onSelect", "onStartPost", "reporter", "updateRequestId", "requestId", "plugin-mv_release"})
public final class m
{
  public static final m GcA;
  private static ii Gct;
  public static int Gcu;
  public static int Gcv;
  private static long Gcw;
  private static boolean Gcx;
  public static final Map<Long, ii> Gcy;
  private static final m.a Gcz;
  
  static
  {
    AppMethodBeat.i(227171);
    GcA = new m();
    Gct = new ii();
    Gcw = 3L;
    Gcx = true;
    Gcy = (Map)new LinkedHashMap();
    Gcz = new m.a();
    EventCenter.instance.addListener((IListener)Gcz);
    AppMethodBeat.o(227171);
  }
  
  public static void ZE(int paramInt)
  {
    Gcv = paramInt;
  }
  
  public static void ZF(int paramInt)
  {
    Gcu = paramInt;
  }
  
  public static void a(int paramInt, e parame)
  {
    AppMethodBeat.i(227145);
    p.k(parame, "data");
    ii localii = fgi();
    localii.ys(parame.ahZ());
    localii.yt(parame.ffT());
    if ((Gcu != 1) && (Gcu != 2)) {
      localii.sS(Gcv);
    }
    localii.sU(paramInt);
    localii.sV(Gcu);
    localii.sX(parame.ffU());
    localii.sP(2L);
    localii.alS();
    localii.bpa();
    parame = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)localii);
    AppMethodBeat.o(227145);
  }
  
  public static void a(Context paramContext, bds parambds, dbo paramdbo, int paramInt, boolean paramBoolean)
  {
    ii localii = null;
    AppMethodBeat.i(227139);
    p.k(paramContext, "context");
    p.k(parambds, "songInfo");
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    Gct = new ii();
    if (paramContext != null)
    {
      Gct.yh(paramContext.wmL);
      Gct.sY(paramContext.scene);
      Gct.yq(paramContext.AtM);
    }
    paramContext = Gct;
    localObject = com.tencent.mm.plugin.comm.a.ubo;
    paramContext.yi(com.tencent.mm.plugin.comm.a.cPn());
    localObject = Gct;
    paramContext = parambds.HLH;
    if (paramContext != null)
    {
      paramContext = n.l(paramContext, ",", " ", false);
      ((ii)localObject).yj(paramContext);
      Gct.yk(parambds.kkU);
      Gct.yl(parambds.SOK);
      Gct.ym(parambds.musicDataUrl);
      localObject = Gct;
      parambds = parambds.ozs;
      paramContext = localii;
      if (parambds != null) {
        paramContext = n.l(parambds, ",", " ", false);
      }
      ((ii)localObject).yn(paramContext);
      localii = Gct;
      parambds = z.bdh();
      paramContext = parambds;
      if (parambds == null) {
        paramContext = "";
      }
      localii.yo(paramContext);
      paramContext = Gct;
      if (paramdbo == null) {
        break label339;
      }
      parambds = paramdbo.TIV;
      if (parambds == null) {
        break label339;
      }
      parambds = parambds.objectDesc;
      if (parambds == null) {
        break label339;
      }
      parambds = parambds.mvInfo;
      if (parambds == null) {
        break label339;
      }
      parambds = parambds.SOB;
      if (parambds == null) {
        break label339;
      }
    }
    label339:
    for (long l = parambds.size();; l = 0L)
    {
      paramContext.sT(l);
      Gct.sY(paramInt);
      vx(paramBoolean);
      paramContext = fgi();
      paramContext.sP(1L);
      paramContext.bpa();
      parambds = c.Yyz;
      c.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(227139);
      return;
      paramContext = null;
      break;
    }
  }
  
  public static void aSF(String paramString)
  {
    AppMethodBeat.i(227122);
    Gct.yw(paramString);
    AppMethodBeat.o(227122);
  }
  
  public static ii fgi()
  {
    AppMethodBeat.i(227118);
    ii localii = new ii(Gct.agH());
    AppMethodBeat.o(227118);
    return localii;
  }
  
  public static void fgj()
  {
    AppMethodBeat.i(227156);
    ii localii = fgi();
    localii.sP(7L);
    localii.alR();
    localii.bpa();
    c localc = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)localii);
    AppMethodBeat.o(227156);
  }
  
  private static long fgk()
  {
    if (Gcx) {
      return 1L;
    }
    return 2L;
  }
  
  public static void iB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227154);
    ii localii = fgi();
    localii.sP(6L);
    localii.yx(paramInt1 + '#' + paramInt2);
    localii.bpa();
    c localc = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)localii);
    AppMethodBeat.o(227154);
  }
  
  public static void jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227151);
    p.k(paramString1, "keyWord");
    p.k(paramString2, "expId");
    ii localii = fgi();
    localii.yu(paramString1);
    localii.yv(paramString2);
    localii.sP(3L);
    localii.bpa();
    paramString1 = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)localii);
    AppMethodBeat.o(227151);
  }
  
  private static void vx(boolean paramBoolean)
  {
    AppMethodBeat.i(227160);
    Gcx = paramBoolean;
    Gct.sZ(fgk());
    AppMethodBeat.o(227160);
  }
  
  public static void vy(boolean paramBoolean)
  {
    AppMethodBeat.i(227162);
    vx(paramBoolean);
    ii localii = fgi();
    localii.sP(12L);
    localii.bpa();
    c localc = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)localii);
    AppMethodBeat.o(227162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.m
 * JD-Core Version:    0.7.0.1
 */