package com.tencent.mm.plugin.mv.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.mmdata.rpt.kp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.util.c;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper;", "", "()V", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCreateActionStruct;", "finderPostFinishListener", "com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1;", "fromScene", "", "isFlexMode", "", "materialFrom", "", "materialPosition", "postCache", "", "cacheMaterialFrom", "", "cacheMaterialPosition", "cacheMode", "enterCreateMv", "context", "Landroid/content/Context;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getModeVal", "initReporter", "onCancelMaterial", "position", "data", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "isScrollEdit", "onChangeTransition", "transitionType", "onChangedMode", "onConfirmMaterial", "onCreateMvFinish", "imgCnt", "videoCnt", "onDestroy", "onDragDropTrack", "onMaterialDelete", "onMaterialExposure", "onPostActionInvoke", "onPreparePostSuccess", "localId", "onPreviewMvFinish", "onReplayTransition", "onSaveDraft", "isSave", "isFinderNew", "partList", "", "onScaleTimeTrack", "onSearch", "keyWord", "expId", "onSelect", "onStartPost", "reporter", "updateRequestId", "requestId", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m LYc;
  private static kp LYd;
  public static int LYe;
  public static int LYf;
  private static long LYg;
  private static boolean LYh;
  public static final Map<Long, kp> LYi;
  private static final MvCreateReportHelper.finderPostFinishListener.1 LYj;
  
  static
  {
    AppMethodBeat.i(286216);
    LYc = new m();
    LYd = new kp();
    LYg = 3L;
    LYh = true;
    LYi = (Map)new LinkedHashMap();
    MvCreateReportHelper.finderPostFinishListener.1 local1 = new MvCreateReportHelper.finderPostFinishListener.1(f.hfK);
    LYj = local1;
    local1.alive();
    AppMethodBeat.o(286216);
  }
  
  public static void a(int paramInt, e parame)
  {
    AppMethodBeat.i(286166);
    s.u(parame, "data");
    kp localkp = gpJ();
    localkp.tk(parame.gpw());
    localkp.tl(parame.gpx());
    if ((LYe != 1) && (LYe != 2)) {
      localkp.iMe = LYf;
    }
    localkp.iXp = paramInt;
    localkp.iXq = LYe;
    localkp.iXs = parame.gpy();
    localkp.ioV = 2L;
    localkp.iPH = 1;
    localkp.bMH();
    parame = c.agsX;
    c.a((com.tencent.mm.plugin.report.a)localkp);
    AppMethodBeat.o(286166);
  }
  
  public static void a(Context paramContext, boo paramboo, dtf paramdtf, int paramInt, boolean paramBoolean)
  {
    kp localkp = null;
    AppMethodBeat.i(286152);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    LYd = new kp();
    if (paramContext != null)
    {
      LYd.sZ(paramContext.zIO);
      LYd.iqr = paramContext.scene;
      LYd.ti(paramContext.FST);
    }
    paramContext = LYd;
    localObject = com.tencent.mm.plugin.comm.a.xeG;
    paramContext.ta(com.tencent.mm.plugin.comm.a.dsT());
    localObject = LYd;
    paramContext = paramboo.songName;
    label174:
    long l;
    if (paramContext == null)
    {
      paramContext = null;
      ((kp)localObject).tb(paramContext);
      LYd.tc(paramboo.mLQ);
      LYd.td(paramboo.ZWR);
      LYd.te(paramboo.musicDataUrl);
      localObject = LYd;
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label283;
      }
      paramContext = localkp;
      ((kp)localObject).tf(paramContext);
      localkp = LYd;
      paramboo = z.bAW();
      paramContext = paramboo;
      if (paramboo == null) {
        paramContext = "";
      }
      localkp.tg(paramContext);
      paramContext = LYd;
      if (paramdtf != null) {
        break label298;
      }
      l = 0L;
    }
    for (;;)
    {
      paramContext.iXo = l;
      LYd.iqr = paramInt;
      zR(paramBoolean);
      paramContext = gpJ();
      paramContext.ioV = 1L;
      paramContext.bMH();
      paramboo = c.agsX;
      c.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(286152);
      return;
      paramContext = n.m(paramContext, ",", " ", false);
      break;
      label283:
      paramContext = n.m(paramContext, ",", " ", false);
      break label174;
      label298:
      paramboo = paramdtf.aaYK;
      if (paramboo == null)
      {
        l = 0L;
      }
      else
      {
        paramboo = paramboo.objectDesc;
        if (paramboo == null)
        {
          l = 0L;
        }
        else
        {
          paramboo = paramboo.mvInfo;
          if (paramboo == null)
          {
            l = 0L;
          }
          else
          {
            paramboo = paramboo.ZWI;
            if (paramboo == null) {
              l = 0L;
            } else {
              l = paramboo.size();
            }
          }
        }
      }
    }
  }
  
  public static void aPz(String paramString)
  {
    AppMethodBeat.i(286142);
    LYd.to(paramString);
    AppMethodBeat.o(286142);
  }
  
  public static void adR(int paramInt)
  {
    LYf = paramInt;
  }
  
  public static void adS(int paramInt)
  {
    LYe = paramInt;
  }
  
  public static kp gpJ()
  {
    AppMethodBeat.i(286134);
    kp localkp = new kp(LYd.aIE());
    AppMethodBeat.o(286134);
    return localkp;
  }
  
  public static void gpK()
  {
    AppMethodBeat.i(286184);
    kp localkp = gpJ();
    localkp.ioV = 7L;
    localkp.iXw = 0;
    localkp.bMH();
    c localc = c.agsX;
    c.a((com.tencent.mm.plugin.report.a)localkp);
    AppMethodBeat.o(286184);
  }
  
  private static long gpL()
  {
    if (LYh) {
      return 1L;
    }
    return 2L;
  }
  
  public static void kB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(286171);
    s.u(paramString1, "keyWord");
    s.u(paramString2, "expId");
    kp localkp = gpJ();
    localkp.tm(paramString1);
    localkp.tn(paramString2);
    localkp.ioV = 3L;
    localkp.bMH();
    paramString1 = c.agsX;
    c.a((com.tencent.mm.plugin.report.a)localkp);
    AppMethodBeat.o(286171);
  }
  
  public static void kf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286177);
    kp localkp = gpJ();
    localkp.ioV = 6L;
    localkp.tp(paramInt1 + '#' + paramInt2);
    localkp.bMH();
    c localc = c.agsX;
    c.a((com.tencent.mm.plugin.report.a)localkp);
    AppMethodBeat.o(286177);
  }
  
  private static void zR(boolean paramBoolean)
  {
    AppMethodBeat.i(286190);
    LYh = paramBoolean;
    LYd.iXt = gpL();
    AppMethodBeat.o(286190);
  }
  
  public static void zS(boolean paramBoolean)
  {
    AppMethodBeat.i(286195);
    zR(paramBoolean);
    kp localkp = gpJ();
    localkp.ioV = 12L;
    localkp.bMH();
    c localc = c.agsX;
    c.a((com.tencent.mm.plugin.report.a)localkp);
    AppMethodBeat.o(286195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.m
 * JD-Core Version:    0.7.0.1
 */