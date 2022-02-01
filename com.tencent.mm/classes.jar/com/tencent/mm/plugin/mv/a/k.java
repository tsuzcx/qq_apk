package com.tencent.mm.plugin.mv.a;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.b.a.od;
import com.tencent.mm.g.b.a.oe;
import com.tencent.mm.g.b.a.og;
import com.tencent.mm.g.b.a.oh;
import com.tencent.mm.g.b.a.oi;
import com.tencent.mm.g.b.a.oj;
import com.tencent.mm.g.b.a.ok;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.thumbplayer.d.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MvReportLogic;", "", "()V", "TAG", "", "getMvPlayTime", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnlineUserObj", "Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "context", "Landroid/content/Context;", "getPlayMusicTime", "reportComment", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "action", "", "commentId", "reportCommentLike", "reportMvExit", "reportMvInfo", "reportMvLike", "reportMvMainUIEnter", "reportMvMainUIExit", "reportMvMakerPlayInfo", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "index", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "cdnVideoPlayInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "reportMvMusicCardAction", "reportMvPlayInfo", "playInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "plugin-mv_release"})
public final class k
{
  public static final k Aql;
  
  static
  {
    AppMethodBeat.i(256811);
    Aql = new k();
    AppMethodBeat.o(256811);
  }
  
  public static void a(Context paramContext, e parame, com.tencent.mm.plugin.thumbplayer.d.d paramd)
  {
    AppMethodBeat.i(258852);
    p.h(paramContext, "context");
    p.h(parame, "musicMv");
    if (paramd == null)
    {
      AppMethodBeat.o(258852);
      return;
    }
    if (paramd.Utm.isEmpty())
    {
      AppMethodBeat.o(258852);
      return;
    }
    paramd.vgo = Util.ticksToNow(paramd.gXF);
    Object localObject = SecDataUIC.CWq;
    paramContext = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject = new ok();
    if (paramContext != null)
    {
      ((ok)localObject).bwt(paramContext.sGQ);
      ((ok)localObject).Qr(paramContext.scene);
    }
    ((ok)localObject).bwv(parame.ApF);
    paramContext = parame.ApE;
    if (paramContext != null) {}
    for (paramContext = String.valueOf(paramContext.longValue());; paramContext = null)
    {
      ((ok)localObject).bwu(paramContext);
      ((ok)localObject).Qs(paramd.Utl);
      ((ok)localObject).Qu(paramd.vgo);
      paramContext = paramd.Utm.values();
      p.g(paramContext, "playInfo.mediaReportInfo.values");
      paramContext = ((Iterable)paramContext).iterator();
      for (i = 0; paramContext.hasNext(); i = ((com.tencent.mm.plugin.thumbplayer.d.b)paramContext.next()).UsZ + i) {}
    }
    ((ok)localObject).Qt(i);
    ((ok)localObject).bww(paramd.gWO());
    paramContext = paramd.Utm.values();
    p.g(paramContext, "mediaReportInfo.values");
    paramContext = ((Iterable)paramContext).iterator();
    int i = 0;
    if (paramContext.hasNext())
    {
      if (((com.tencent.mm.plugin.thumbplayer.d.b)paramContext.next()).gWN()) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    ((ok)localObject).Qv(i);
    ((ok)localObject).bfK();
    paramd.Utm.clear();
    paramContext = paramd.Utk;
    if (paramContext != null) {
      paramContext.reset();
    }
    paramContext = com.tencent.mm.util.b.QYu;
    com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(258852);
  }
  
  public static void a(Context paramContext, axy paramaxy, int paramInt)
  {
    AppMethodBeat.i(258851);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvMusicCardAction, action:".concat(String.valueOf(paramInt)));
    Object localObject = SecDataUIC.CWq;
    localObject = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    paramContext = new od();
    if (localObject != null)
    {
      paramContext.fL(((cst)localObject).sGQ);
      paramContext.PA(((cst)localObject).scene);
      paramContext.VS(((cst)localObject).MxJ);
    }
    paramContext.Tz(paramaxy.BPc);
    paramContext.TA(paramaxy.AqO);
    paramContext.VN(paramaxy.LIg);
    paramContext.VO(paramaxy.musicDataUrl);
    paramContext.VP(paramaxy.lDR);
    paramContext.agP(paramaxy.LIf);
    paramContext.Pz(paramInt);
    paramContext.bfK();
    paramaxy = com.tencent.mm.util.b.QYu;
    com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramContext);
    AppMethodBeat.o(258851);
  }
  
  public static void a(Context paramContext, axy paramaxy, e parame)
  {
    AppMethodBeat.i(256810);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Object localObject = SecDataUIC.CWq;
    localObject = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    paramContext = new gk();
    if (localObject != null)
    {
      paramContext.tW(((cst)localObject).sGQ);
      paramContext.qn(((cst)localObject).scene);
      paramContext.ub(((cst)localObject).MxJ);
    }
    paramContext.tX(paramaxy.BPc);
    paramContext.ua(paramaxy.LIf);
    paramContext.tY(paramaxy.LIg);
    paramContext.tZ(paramaxy.musicDataUrl);
    localObject = (CharSequence)paramaxy.LIh;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label253;
      }
      l = 2L;
      label157:
      paramContext.qo(l);
      localObject = parame.ApE;
      if (localObject == null) {
        break label259;
      }
    }
    label259:
    for (long l = ((Long)localObject).longValue();; l = 0L)
    {
      paramContext.uc(com.tencent.mm.ac.d.zs(l));
      paramContext.ud(parame.ApF);
      paramContext.ue(paramaxy.AqO);
      paramContext.PP(1L);
      paramContext.bvL(paramaxy.lDR);
      paramContext.bfK();
      paramaxy = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(256810);
      return;
      i = 0;
      break;
      label253:
      l = 1L;
      break label157;
    }
  }
  
  public static void a(Context paramContext, axy paramaxy, e parame, int paramInt)
  {
    AppMethodBeat.i(258847);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvInfo, action:".concat(String.valueOf(paramInt)));
    parame = SecDataUIC.CWq;
    parame = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    paramContext = new oh();
    int i;
    if (parame != null)
    {
      paramContext.bvX(parame.sGQ);
      paramContext.bvY(paramaxy.BPc);
      paramContext.bvZ(paramaxy.AqO);
      paramContext.bwa(paramaxy.LIg);
      paramContext.bwb(paramaxy.musicDataUrl);
      paramContext.bwc(paramaxy.lDR);
      paramContext.Qg(paramInt);
      paramContext.bwd(paramaxy.LIf);
      parame = (CharSequence)paramaxy.LIh;
      if ((parame != null) && (parame.length() != 0)) {
        break label226;
      }
      i = 1;
      if (i == 0) {
        break label232;
      }
    }
    label226:
    label232:
    for (long l = 2L;; l = 1L)
    {
      paramContext.Qh(l);
      paramContext.bwe(paramaxy.LIi);
      paramContext.bwf(paramaxy.Djf);
      paramContext.Qg(paramInt);
      paramContext.bfK();
      paramaxy = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(258847);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, axy paramaxy, e parame, int paramInt, long paramLong)
  {
    AppMethodBeat.i(258849);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportCommentLike, action:".concat(String.valueOf(paramInt)));
    Object localObject = SecDataUIC.CWq;
    cst localcst = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject = new oi();
    if (localcst != null)
    {
      ((oi)localObject).bwg(localcst.sGQ);
      ((oi)localObject).Qk(me(paramContext));
      ((oi)localObject).Ql(k(parame));
    }
    ((oi)localObject).bwh(paramaxy.BPc);
    ((oi)localObject).bwi(paramaxy.AqO);
    ((oi)localObject).bwj(paramaxy.LIg);
    ((oi)localObject).bwk(paramaxy.musicDataUrl);
    ((oi)localObject).bwp(paramaxy.lDR);
    ((oi)localObject).Qj(paramaxy.duration / 1000L);
    paramContext = parame.ApE;
    if (paramContext != null) {}
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((oi)localObject).bwl(com.tencent.mm.ac.d.zs(l));
      ((oi)localObject).bwm(parame.ApF);
      paramContext = e.ApR;
      paramContext = e.a.a(parame);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          paramaxy = paramContext.username;
          paramContext = paramaxy;
          if (paramaxy != null) {
            break label240;
          }
        }
      }
      paramContext = "";
      label240:
      ((oi)localObject).bwn(paramContext);
      ((oi)localObject).Qi(paramInt);
      ((oi)localObject).bwo(String.valueOf(paramLong));
      ((oi)localObject).bfK();
      paramContext = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(258849);
      return;
    }
  }
  
  public static void a(Context paramContext, csp paramcsp, int paramInt, d paramd, com.tencent.mm.plugin.thumbplayer.d.b paramb, c paramc)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(258853);
    p.h(paramContext, "context");
    if ((paramcsp == null) || (paramd == null) || (paramb == null) || (paramc == null))
    {
      AppMethodBeat.o(258853);
      return;
    }
    paramb.stop();
    Object localObject = SecDataUIC.CWq;
    paramContext = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject = new oj();
    if (paramContext != null)
    {
      ((oj)localObject).bwq(paramContext.sGQ);
      ((oj)localObject).Qm(paramContext.scene);
    }
    paramContext = paramd.App;
    boolean bool;
    if (paramContext != null)
    {
      bool = paramContext.dkS();
      if (paramd.Apq != null) {
        i = 1;
      }
      paramContext = paramcsp.MxE;
      if (paramContext != null)
      {
        paramd = String.valueOf(paramContext.id);
        paramContext = paramd;
        if (paramd != null) {}
      }
      else
      {
        paramContext = "";
      }
      ((oj)localObject).bwr(paramContext);
      paramContext = paramcsp.MxE;
      if (paramContext == null) {
        break label308;
      }
      paramContext = paramContext.objectNonceId;
      label174:
      ((oj)localObject).bws(paramContext);
      ((oj)localObject).zY(paramInt);
      if (i == 0) {
        break label313;
      }
      paramInt = 2;
      label195:
      ((oj)localObject).SM(paramInt);
      if (!bool) {
        break label318;
      }
    }
    label308:
    label313:
    label318:
    for (paramInt = j;; paramInt = 2)
    {
      ((oj)localObject).SR(paramInt);
      ((oj)localObject).Qn(paramb.UsY);
      ((oj)localObject).Qo(paramb.UsZ);
      ((oj)localObject).Qp(paramb.errType);
      ((oj)localObject).Qq(paramb.errCode);
      ((oj)localObject).bfK();
      paramb.gXF = Util.currentTicks();
      paramc.reset();
      paramContext = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(258853);
      return;
      bool = false;
      break;
      paramContext = null;
      break label174;
      paramInt = 1;
      break label195;
    }
  }
  
  public static void b(Context paramContext, axy paramaxy, e parame)
  {
    AppMethodBeat.i(258846);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit");
    Object localObject1 = SecDataUIC.CWq;
    cst localcst = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject1 = new og();
    Object localObject2;
    int i;
    if (localcst != null)
    {
      Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit, isComment:" + localcst.MxP + ", isDragProcess:" + localcst.Uud + ", StartPlayMusicTick:" + localcst.Uue + ", PausePlayMusicTime:" + localcst.Uuf + ", scene:" + localcst.scene);
      ((og)localObject1).bvM(localcst.sGQ);
      ((og)localObject1).bvN(paramaxy.BPc);
      ((og)localObject1).bvO(paramaxy.LIg);
      ((og)localObject1).bvP(paramaxy.musicDataUrl);
      ((og)localObject1).PW(localcst.scene);
      ((og)localObject1).bvQ(localcst.MxJ);
      ((og)localObject1).bvR(paramaxy.LIf);
      localObject2 = parame.ApE;
      if (localObject2 == null) {
        break label542;
      }
      l = ((Long)localObject2).longValue();
      ((og)localObject1).bvS(com.tencent.mm.ac.d.zs(l));
      ((og)localObject1).bvT(parame.ApF);
      localObject2 = (CharSequence)paramaxy.LIh;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label548;
      }
      i = 1;
      label285:
      if (i == 0) {
        break label553;
      }
    }
    label542:
    label548:
    label553:
    for (long l = 2L;; l = 1L)
    {
      ((og)localObject1).PX(l);
      localObject2 = hz(paramContext);
      ((og)localObject1).PY(((n)localObject2).UqB);
      ((og)localObject1).PZ(((n)localObject2).UqC);
      ((og)localObject1).Qa(localcst.MxN);
      ((og)localObject1).Qc(localcst.MxP);
      ((og)localObject1).bvU(paramaxy.AqO);
      ((og)localObject1).PW(localcst.scene);
      ((og)localObject1).Qd(paramaxy.duration / 1000L);
      ((og)localObject1).Qe(me(paramContext));
      ((og)localObject1).Qb(k(parame));
      Log.i("MicroMsg.Mv.MvReportLogic", "playMusicTime:" + ((og)localObject1).agN() + ", PauseMusicTick:" + localcst.Uug);
      ((og)localObject1).Qf(localcst.Uud);
      paramContext = e.ApR;
      paramContext = e.a.a(parame);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          parame = paramContext.username;
          paramContext = parame;
          if (parame != null) {
            break label500;
          }
        }
      }
      paramContext = "";
      label500:
      ((og)localObject1).bvV(paramContext);
      ((og)localObject1).bvW(paramaxy.lDR);
      ((og)localObject1).bfK();
      paramContext = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(258846);
      return;
      l = 0L;
      break;
      i = 0;
      break label285;
    }
  }
  
  public static void b(Context paramContext, axy paramaxy, e parame, int paramInt)
  {
    AppMethodBeat.i(258848);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvLike, action:".concat(String.valueOf(paramInt)));
    Object localObject = SecDataUIC.CWq;
    cst localcst = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject = new oi();
    if (localcst != null)
    {
      ((oi)localObject).bwg(localcst.sGQ);
      ((oi)localObject).Qk(me(paramContext));
      ((oi)localObject).Ql(k(parame));
    }
    ((oi)localObject).bwh(paramaxy.BPc);
    ((oi)localObject).bwi(paramaxy.AqO);
    ((oi)localObject).bwj(paramaxy.LIg);
    ((oi)localObject).bwk(paramaxy.musicDataUrl);
    ((oi)localObject).bwp(paramaxy.lDR);
    ((oi)localObject).Qj(paramaxy.duration / 1000L);
    paramContext = parame.ApE;
    if (paramContext != null) {}
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((oi)localObject).bwl(com.tencent.mm.ac.d.zs(l));
      ((oi)localObject).bwm(parame.ApF);
      paramContext = e.ApR;
      paramContext = e.a.a(parame);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          paramaxy = paramContext.username;
          paramContext = paramaxy;
          if (paramaxy != null) {
            break label240;
          }
        }
      }
      paramContext = "";
      label240:
      ((oi)localObject).bwn(paramContext);
      ((oi)localObject).Qi(paramInt);
      ((oi)localObject).bfK();
      paramContext = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(258848);
      return;
    }
  }
  
  public static void b(Context paramContext, axy paramaxy, e parame, int paramInt, long paramLong)
  {
    AppMethodBeat.i(258850);
    p.h(paramContext, "context");
    p.h(paramaxy, "songInfo");
    p.h(parame, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportComment, action:".concat(String.valueOf(paramInt)));
    Object localObject = SecDataUIC.CWq;
    cst localcst = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    localObject = new oe();
    if (localcst != null)
    {
      ((oe)localObject).ahU(localcst.sGQ);
      ((oe)localObject).PD(me(paramContext));
      ((oe)localObject).PE(k(parame));
    }
    ((oe)localObject).amE(paramaxy.BPc);
    ((oe)localObject).aTq(paramaxy.AqO);
    ((oe)localObject).aYJ(paramaxy.LIg);
    ((oe)localObject).aYK(paramaxy.musicDataUrl);
    ((oe)localObject).aZn(paramaxy.lDR);
    ((oe)localObject).PC(paramaxy.duration / 1000L);
    paramContext = parame.ApE;
    if (paramContext != null) {}
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((oe)localObject).aYL(com.tencent.mm.ac.d.zs(l));
      ((oe)localObject).aZk(parame.ApF);
      paramContext = e.ApR;
      paramContext = e.a.a(parame);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          paramaxy = paramContext.username;
          paramContext = paramaxy;
          if (paramaxy != null) {
            break label240;
          }
        }
      }
      paramContext = "";
      label240:
      ((oe)localObject).aZl(paramContext);
      ((oe)localObject).PB(paramInt);
      ((oe)localObject).aZm(String.valueOf(paramLong));
      ((oe)localObject).bfK();
      paramContext = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(258850);
      return;
    }
  }
  
  public static n hz(Context paramContext)
  {
    AppMethodBeat.i(258854);
    p.h(paramContext, "context");
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    paramContext = com.tencent.mm.ui.component.a.ko(paramContext).get(MusicMvChattingUIC.class);
    p.g(paramContext, "UICProvider.of(context).…vChattingUIC::class.java)");
    localObject = ((MusicMvChattingUIC)paramContext).AsY;
    paramContext = new LinkedList();
    paramContext.addAll((Collection)((HashMap)localObject).entrySet());
    j.a((List)paramContext, (Comparator)k.a.UqA);
    localObject = ((Iterable)paramContext).iterator();
    long l2 = 1L;
    long l1 = 1L;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (l1 >= ((Number)localEntry.getKey()).longValue()) {
        break label253;
      }
      l1 = ((Number)localEntry.getKey()).intValue();
    }
    label253:
    for (;;)
    {
      long l3 = l2;
      if (l2 > ((Number)localEntry.getKey()).longValue()) {
        l3 = ((Number)localEntry.getKey()).intValue();
      }
      l2 = l3;
      break;
      paramContext = (Map.Entry)j.kt((List)paramContext);
      if (paramContext != null)
      {
        paramContext = (Integer)paramContext.getKey();
        if (paramContext == null) {}
      }
      for (l3 = paramContext.intValue();; l3 = 0L)
      {
        paramContext = new n(l1, l2, l3);
        AppMethodBeat.o(258854);
        return paramContext;
      }
    }
  }
  
  private static long k(e parame)
  {
    AppMethodBeat.i(258856);
    p.h(parame, "musicMv");
    if (parame.Uqs > 0L) {}
    for (long l = parame.Uqt + cl.aWA() - parame.Uqs;; l = parame.Uqt)
    {
      l /= 1000L;
      AppMethodBeat.o(258856);
      return l;
    }
  }
  
  public static long me(Context paramContext)
  {
    AppMethodBeat.i(258855);
    p.h(paramContext, "context");
    SecDataUIC.a locala = SecDataUIC.CWq;
    paramContext = (cst)SecDataUIC.a.a(paramContext, 7, cst.class);
    if (paramContext != null)
    {
      if (paramContext.Uug > 0L)
      {
        l1 = Util.currentTicks() - paramContext.Uug;
        Log.i("MicroMsg.Mv.MvReportLogic", "pause music now, pauseTime:".concat(String.valueOf(l1)));
        l2 = Util.currentTicks();
        l3 = paramContext.Uue;
        AppMethodBeat.o(258855);
        return l2 - l3 - l1;
      }
      long l1 = Util.currentTicks();
      long l2 = paramContext.Uue;
      long l3 = paramContext.Uuf;
      AppMethodBeat.o(258855);
      return l1 - l2 - l3;
    }
    AppMethodBeat.o(258855);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.k
 * JD-Core Version:    0.7.0.1
 */