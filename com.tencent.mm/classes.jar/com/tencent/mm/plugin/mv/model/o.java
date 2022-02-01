package com.tencent.mm.plugin.mv.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.f.b.a.ih;
import com.tencent.mm.f.b.a.ij;
import com.tencent.mm.f.b.a.ik;
import com.tencent.mm.f.b.a.il;
import com.tencent.mm.f.b.a.im;
import com.tencent.mm.f.b.a.in;
import com.tencent.mm.f.b.a.io;
import com.tencent.mm.f.b.a.ip;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
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
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MvReportLogic;", "", "()V", "TAG", "", "getMvPlayTime", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnlineUserObj", "Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "context", "Landroid/content/Context;", "getPlayMusicTime", "reportComment", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "action", "", "commentId", "reportCommentLike", "reportDraftMvEnter", "reportMvExit", "reportMvInfo", "jumpRet", "jumpScene", "reportMvLike", "likeSource", "reportMvMainUIEnter", "reportMvMainUIExit", "reportMvMakerPlayInfo", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "index", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "cdnVideoPlayInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "reportMvMusicCardAction", "reportMvPlayInfo", "playInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "reportMvShare", "actionType", "scene", "fromSourceId", "shareSource", "reportMvShareFromSdk", "sessionId", "appId", "wxMediaMessage", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "fromScene", "reportMvStat", "record", "Lcom/tencent/mm/plugin/mv/model/StatRecord;", "reportStat", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-mv_release"})
public final class o
{
  public static final o GcB;
  
  static
  {
    AppMethodBeat.i(235170);
    GcB = new o();
    AppMethodBeat.o(235170);
  }
  
  public static void a(Context paramContext, f paramf, com.tencent.mm.plugin.thumbplayer.e.c paramc)
  {
    AppMethodBeat.i(235154);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramf, "musicMv");
    if (paramc == null)
    {
      AppMethodBeat.o(235154);
      return;
    }
    if (paramc.MSy.isEmpty())
    {
      AppMethodBeat.o(235154);
      return;
    }
    paramc.zXw = Util.ticksToNow(paramc.jID);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject = new ip();
    if (paramContext != null)
    {
      ((ip)localObject).zA(paramContext.wmL);
      ((ip)localObject).tR(paramContext.scene);
    }
    ((ip)localObject).zC(paramf.Gbm);
    paramContext = paramf.Gbl;
    if (paramContext != null) {}
    for (paramContext = String.valueOf(paramContext.longValue());; paramContext = null)
    {
      ((ip)localObject).zB(paramContext);
      ((ip)localObject).tS(paramc.MSx);
      ((ip)localObject).tU(paramc.zXw);
      paramContext = paramc.MSy.values();
      kotlin.g.b.p.j(paramContext, "playInfo.mediaReportInfo.values");
      paramContext = ((Iterable)paramContext).iterator();
      for (i = 0; paramContext.hasNext(); i = ((com.tencent.mm.plugin.thumbplayer.e.a)paramContext.next()).MSn + i) {}
    }
    ((ip)localObject).tT(i);
    ((ip)localObject).zD(paramc.goo());
    paramContext = paramc.MSy.values();
    kotlin.g.b.p.j(paramContext, "mediaReportInfo.values");
    paramContext = ((Iterable)paramContext).iterator();
    int i = 0;
    if (paramContext.hasNext())
    {
      if (((com.tencent.mm.plugin.thumbplayer.e.a)paramContext.next()).gon()) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    ((ip)localObject).tV(i);
    ((ip)localObject).bpa();
    paramc.MSy.clear();
    paramContext = paramc.MSw;
    if (paramContext != null) {
      paramContext.reset();
    }
    paramContext = com.tencent.mm.util.c.Yyz;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(235154);
  }
  
  public static void a(Context paramContext, bds parambds, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235150);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvMusicCardAction, action:".concat(String.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject2 = new ig();
    if (paramContext != null)
    {
      ((ig)localObject2).xP(paramContext.wmL);
      ((ig)localObject2).sK(paramContext.scene);
      ((ig)localObject2).xV(paramContext.TJa);
    }
    paramContext = parambds.HLH;
    if (paramContext != null) {}
    for (paramContext = n.l(paramContext, ",", " ", false);; paramContext = null)
    {
      ((ig)localObject2).xQ(paramContext);
      ((ig)localObject2).xR(parambds.kkU);
      ((ig)localObject2).xS(parambds.SOK);
      ((ig)localObject2).xT(parambds.musicDataUrl);
      String str = parambds.ozs;
      paramContext = localObject1;
      if (str != null) {
        paramContext = n.l(str, ",", " ", false);
      }
      ((ig)localObject2).xU(paramContext);
      ((ig)localObject2).xW(parambds.SOJ);
      ((ig)localObject2).sJ(paramInt);
      ((ig)localObject2).bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(235150);
      return;
    }
  }
  
  public static void a(Context paramContext, bds parambds, f paramf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235127);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject2 = new ij();
    if (paramContext != null)
    {
      ((ij)localObject2).yy(paramContext.wmL);
      ((ij)localObject2).ta(paramContext.scene);
      ((ij)localObject2).yD(paramContext.TJa);
      paramContext.TJh = 0;
      paramContext.TJi = 0;
      paramContext.TJl = 0L;
      paramContext.TJj = 0;
      paramContext.TJk = 2;
    }
    paramContext = parambds.HLH;
    int i;
    if (paramContext != null)
    {
      paramContext = n.l(paramContext, ",", " ", false);
      ((ij)localObject2).yz(paramContext);
      ((ij)localObject2).yC(parambds.SOJ);
      ((ij)localObject2).yA(parambds.SOK);
      ((ij)localObject2).yB(parambds.musicDataUrl);
      paramContext = (CharSequence)parambds.SOL;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label326;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label331;
      }
      l = 2L;
      label204:
      ((ij)localObject2).tb(l);
      paramContext = paramf.Gbl;
      if (paramContext == null) {
        break label337;
      }
    }
    label326:
    label331:
    label337:
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((ij)localObject2).yE(d.Fw(l));
      ((ij)localObject2).yF(paramf.Gbm);
      ((ij)localObject2).yG(parambds.kkU);
      ((ij)localObject2).tc(1L);
      parambds = parambds.ozs;
      paramContext = localObject1;
      if (parambds != null) {
        paramContext = n.l(parambds, ",", " ", false);
      }
      ((ij)localObject2).yH(paramContext);
      ((ij)localObject2).bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(235127);
      return;
      paramContext = null;
      break;
      i = 0;
      break label195;
      l = 1L;
      break label204;
    }
  }
  
  public static void a(Context paramContext, bds parambds, f paramf, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235143);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvLike, action:".concat(String.valueOf(paramInt1)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    Object localObject3 = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject2 = new im();
    if (localObject3 != null)
    {
      ((im)localObject2).zc(((dbs)localObject3).wmL);
      ((im)localObject2).tG(hG(paramContext));
      ((im)localObject2).tH(d(paramf));
    }
    paramContext = parambds.HLH;
    if (paramContext != null)
    {
      paramContext = n.l(paramContext, ",", " ", false);
      ((im)localObject2).zd(paramContext);
      ((im)localObject2).ze(parambds.kkU);
      ((im)localObject2).zf(parambds.SOK);
      ((im)localObject2).zg(parambds.musicDataUrl);
      localObject3 = parambds.ozs;
      paramContext = localObject1;
      if (localObject3 != null) {
        paramContext = n.l((String)localObject3, ",", " ", false);
      }
      ((im)localObject2).zl(paramContext);
      ((im)localObject2).tF(parambds.duration / 1000L);
      paramContext = paramf.Gbl;
      if (paramContext == null) {
        break label341;
      }
    }
    label287:
    label341:
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((im)localObject2).zh(d.Fw(l));
      ((im)localObject2).zi(paramf.Gbm);
      paramContext = f.GbD;
      paramContext = f.a.b(paramf);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          parambds = paramContext.username;
          paramContext = parambds;
          if (parambds != null) {
            break label287;
          }
        }
      }
      paramContext = "";
      ((im)localObject2).zj(paramContext);
      ((im)localObject2).tE(paramInt1);
      ((im)localObject2).tI(paramInt2);
      ((im)localObject2).bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(235143);
      return;
      paramContext = null;
      break;
    }
  }
  
  public static void a(Context paramContext, bds parambds, f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    AppMethodBeat.i(235141);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMvInfo, action:".concat(String.valueOf(paramInt1)));
    paramf = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    paramf = new il();
    int i;
    if (paramContext != null)
    {
      paramf.yT(paramContext.wmL);
      paramContext = parambds.HLH;
      if (paramContext == null) {
        break label289;
      }
      paramContext = n.l(paramContext, ",", " ", false);
      paramf.yU(paramContext);
      paramf.yV(parambds.kkU);
      paramf.yW(parambds.SOK);
      paramf.yX(parambds.musicDataUrl);
      String str = parambds.ozs;
      paramContext = localObject;
      if (str != null) {
        paramContext = n.l(str, ",", " ", false);
      }
      paramf.yY(paramContext);
      paramf.tA(paramInt1);
      paramf.yZ(parambds.SOJ);
      paramContext = (CharSequence)parambds.SOL;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label294;
      }
      i = 1;
      label208:
      if (i == 0) {
        break label300;
      }
    }
    label289:
    label294:
    label300:
    for (long l = 2L;; l = 1L)
    {
      paramf.tB(l);
      paramf.za(parambds.SMY);
      paramf.zb(parambds.SOM);
      paramf.tA(paramInt1);
      paramf.tC(paramInt2);
      paramf.tD(paramInt3);
      paramf.bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramf);
      AppMethodBeat.o(235141);
      return;
      paramContext = null;
      break;
      i = 0;
      break label208;
    }
  }
  
  public static void a(Context paramContext, bds parambds, f paramf, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235146);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportCommentLike, action:".concat(String.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    Object localObject3 = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject2 = new im();
    if (localObject3 != null)
    {
      ((im)localObject2).zc(((dbs)localObject3).wmL);
      ((im)localObject2).tG(hG(paramContext));
      ((im)localObject2).tH(d(paramf));
    }
    paramContext = parambds.HLH;
    if (paramContext != null)
    {
      paramContext = n.l(paramContext, ",", " ", false);
      ((im)localObject2).zd(paramContext);
      ((im)localObject2).ze(parambds.kkU);
      ((im)localObject2).zf(parambds.SOK);
      ((im)localObject2).zg(parambds.musicDataUrl);
      localObject3 = parambds.ozs;
      paramContext = localObject1;
      if (localObject3 != null) {
        paramContext = n.l((String)localObject3, ",", " ", false);
      }
      ((im)localObject2).zl(paramContext);
      ((im)localObject2).tF(parambds.duration / 1000L);
      paramContext = paramf.Gbl;
      if (paramContext == null) {
        break label343;
      }
    }
    label287:
    label343:
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((im)localObject2).zh(d.Fw(l));
      ((im)localObject2).zi(paramf.Gbm);
      paramContext = f.GbD;
      paramContext = f.a.b(paramf);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          parambds = paramContext.username;
          paramContext = parambds;
          if (parambds != null) {
            break label287;
          }
        }
      }
      paramContext = "";
      ((im)localObject2).zj(paramContext);
      ((im)localObject2).tE(paramInt);
      ((im)localObject2).zk(String.valueOf(paramLong));
      ((im)localObject2).bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(235146);
      return;
      paramContext = null;
      break;
    }
  }
  
  public static void a(Context paramContext, bds parambds, f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(235157);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    kotlin.g.b.p.k(paramString, "fromSourceId");
    in localin = new in();
    a.a locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    if (paramContext != null) {
      localin.zm(paramContext.wmL);
    }
    localin.zn(parambds.HLH);
    localin.zo(parambds.kkU);
    localin.zp(parambds.SOK);
    localin.zq(parambds.musicDataUrl);
    localin.zu(parambds.SOJ);
    localin.zw(parambds.ozs);
    localin.tK(paramInt);
    localin.tJ(2L);
    localin.zv(paramString);
    localin.tL(2L);
    paramContext = f.GbD;
    paramContext = f.a.b(paramf);
    if (paramContext != null)
    {
      localin.zr(d.Fw(paramContext.id));
      localin.zs(paramContext.objectNonceId);
      localin.zt(paramContext.username);
    }
    localin.alU();
    localin.bpa();
    paramContext = com.tencent.mm.util.c.Yyz;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localin);
    AppMethodBeat.o(235157);
  }
  
  public static void a(Context paramContext, bds parambds, f paramf, q paramq)
  {
    AppMethodBeat.i(235137);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    kotlin.g.b.p.k(paramq, "record");
    emr localemr = new emr();
    Object localObject1 = paramf.Gbl;
    long l;
    if (localObject1 != null)
    {
      l = ((Long)localObject1).longValue();
      localemr.xbk = l;
      localemr.objectNonceId = paramf.Gbm;
      localemr.Upk = new ezq();
      localemr.Upl = new dhb();
      localObject1 = paramf.Gbv;
      if (localObject1 == null) {
        break label531;
      }
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null) {
        break label531;
      }
      i = ((FinderObjectDesc)localObject1).mediaType;
      label129:
      localemr.mediaType = i;
      localObject1 = paramf.Gbv;
      if (localObject1 != null)
      {
        localObject2 = ((FinderObject)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = z.bdh();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localemr.finderUsername = ((String)localObject2);
      localemr.Upm = paramq.oiL;
      localObject1 = paramf.Gbv;
      if (localObject1 != null)
      {
        localObject2 = ((FinderObject)localObject1).sessionBuffer;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localemr.sessionBuffer = ((String)localObject1);
      localemr.Upt = paramq.oiL;
      l = cm.bfE();
      localObject1 = localemr.Upk;
      if (localObject1 != null)
      {
        ((ezq)localObject1).UzT = parambds.duration;
        ((ezq)localObject1).KyZ = ((int)((l - paramq.oiL) / 1000L));
        ((ezq)localObject1).wmw = (l - paramq.oiL);
        ((ezq)localObject1).UzU = paramf.GbA;
        ((ezq)localObject1).UzV = paramf.GbA;
        ((ezq)localObject1).UzW = ((ezq)localObject1).wmw;
        ((ezq)localObject1).lzJ = paramq.oiL;
        ((ezq)localObject1).UzX = l;
        ((ezq)localObject1).UzY = paramf.GbB;
      }
      parambds = localemr.Upl;
      if (parambds != null)
      {
        parambds.TNL = paramq.zXg;
        paramf = localemr.Upk;
        if (paramf == null) {
          break label537;
        }
      }
    }
    label531:
    label537:
    for (int i = (int)paramf.wmw;; i = 0)
    {
      parambds.TNM = i;
      parambds.TNW = paramq.zXf;
      parambds.TNN = paramq.AUa;
      Log.i("MicroMsg.Mv.MvReportLogic", "print stats: " + localemr + " index:" + paramq.index);
      parambds = com.tencent.mm.plugin.secdata.ui.a.JbV;
      parambds = (dbs)a.a.a(paramContext, 7, dbs.class);
      paramContext = new bid();
      if (parambds != null)
      {
        paramContext.wmL = parambds.wmL;
        paramContext.xkX = 91;
      }
      parambds = new LinkedList();
      parambds.add(localemr);
      paramf = w.zYO;
      w.a((List)parambds, paramContext, 0);
      AppMethodBeat.o(235137);
      return;
      l = 0L;
      break;
      i = 0;
      break label129;
    }
  }
  
  public static void a(Context paramContext, dbo paramdbo, int paramInt, e parame, com.tencent.mm.plugin.thumbplayer.e.a parama, b paramb)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(235156);
    kotlin.g.b.p.k(paramContext, "context");
    if ((paramdbo == null) || (parame == null) || (parama == null) || (paramb == null))
    {
      AppMethodBeat.o(235156);
      return;
    }
    parama.stop();
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject = new io();
    if (paramContext != null)
    {
      ((io)localObject).zx(paramContext.wmL);
      ((io)localObject).tM(paramContext.scene);
    }
    paramContext = parame.GaX;
    boolean bool;
    if (paramContext != null)
    {
      bool = paramContext.dKS();
      if (parame.GaY != null) {
        i = 1;
      }
      paramContext = paramdbo.TIV;
      if (paramContext != null)
      {
        parame = String.valueOf(paramContext.id);
        paramContext = parame;
        if (parame != null) {}
      }
      else
      {
        paramContext = "";
      }
      ((io)localObject).zy(paramContext);
      paramContext = paramdbo.TIV;
      if (paramContext == null) {
        break label308;
      }
      paramContext = paramContext.objectNonceId;
      label174:
      ((io)localObject).zz(paramContext);
      ((io)localObject).ni(paramInt);
      if (i == 0) {
        break label313;
      }
      paramInt = 2;
      label195:
      ((io)localObject).nj(paramInt);
      if (!bool) {
        break label318;
      }
    }
    label308:
    label313:
    label318:
    for (paramInt = j;; paramInt = 2)
    {
      ((io)localObject).nk(paramInt);
      ((io)localObject).tN(parama.tJV);
      ((io)localObject).tO(parama.MSn);
      ((io)localObject).tP(parama.errType);
      ((io)localObject).tQ(parama.errCode);
      ((io)localObject).bpa();
      parama.jID = Util.currentTicks();
      paramb.reset();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(235156);
      return;
      bool = false;
      break;
      paramContext = null;
      break label174;
      paramInt = 1;
      break label195;
    }
  }
  
  public static void a(String paramString1, String paramString2, WXMediaMessage paramWXMediaMessage, int paramInt)
  {
    AppMethodBeat.i(235161);
    kotlin.g.b.p.k(paramString1, "sessionId");
    kotlin.g.b.p.k(paramWXMediaMessage, "wxMediaMessage");
    if ((paramInt != 1) && (paramInt != 0))
    {
      AppMethodBeat.o(235161);
      return;
    }
    in localin = new in();
    localin.zm(paramString1);
    localin.tJ(1L);
    if (paramInt == 1) {}
    for (long l = 1L;; l = 2L)
    {
      localin.tK(l);
      if (paramWXMediaMessage.getType() != 3) {
        break label240;
      }
      paramString1 = paramWXMediaMessage.mediaObject;
      if (paramString1 != null) {
        break;
      }
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXMusicObject");
      AppMethodBeat.o(235161);
      throw paramString1;
    }
    Object localObject = (WXMusicObject)paramString1;
    String str = paramWXMediaMessage.title;
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localin.zn(paramString1);
    localin.zp(((WXMusicObject)localObject).musicUrl);
    localin.zq(((WXMusicObject)localObject).musicDataUrl);
    localin.zw(paramWXMediaMessage.description);
    localin.zu(paramString2);
    if (m.asG(paramString2)) {
      localin.tL(2L);
    }
    for (;;)
    {
      localin.bpa();
      paramString1 = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localin);
      AppMethodBeat.o(235161);
      return;
      localin.tL(1L);
    }
    label240:
    if (paramWXMediaMessage.getType() == 76)
    {
      paramString1 = paramWXMediaMessage.mediaObject;
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject");
        AppMethodBeat.o(235161);
        throw paramString1;
      }
      localObject = (WXMusicVideoObject)paramString1;
      str = paramWXMediaMessage.title;
      paramString1 = str;
      if (str == null) {
        paramString1 = "";
      }
      localin.zn(paramString1);
      localin.zp(((WXMusicVideoObject)localObject).musicUrl);
      localin.zq(((WXMusicVideoObject)localObject).musicDataUrl);
      paramString1 = (CharSequence)((WXMusicVideoObject)localObject).singerName;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label412;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label417;
      }
    }
    label412:
    label417:
    for (paramString1 = ((WXMusicVideoObject)localObject).singerName;; paramString1 = paramWXMediaMessage.description)
    {
      localin.zw(paramString1);
      localin.zu(paramString2);
      localin.tL(2L);
      localin.bpa();
      paramString1 = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localin);
      AppMethodBeat.o(235161);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static void b(Context paramContext, bds parambds, f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235133);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    kotlin.g.b.p.k(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit");
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    dbs localdbs = (dbs)a.a.a(paramContext, 7, dbs.class);
    ik localik = new ik();
    label267:
    int i;
    if (localdbs != null)
    {
      Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit, isComment:" + localdbs.TJc + ", isDragProcess:" + localdbs.TJd + ", StartPlayMusicTick:" + localdbs.TJe + ", PausePlayMusicTime:" + localdbs.TJf + ", scene:" + localdbs.scene);
      localik.yI(localdbs.wmL);
      localObject1 = parambds.HLH;
      if (localObject1 == null) {
        break label629;
      }
      localObject1 = n.l((String)localObject1, ",", " ", false);
      localik.yJ((String)localObject1);
      localik.yK(parambds.SOK);
      localik.yL(parambds.musicDataUrl);
      localik.to(localdbs.scene);
      localik.yM(localdbs.TJa);
      localik.yN(parambds.SOJ);
      localObject1 = paramf.Gbl;
      if (localObject1 == null) {
        break label635;
      }
      l = ((Long)localObject1).longValue();
      localik.yO(d.Fw(l));
      localik.yP(paramf.Gbm);
      localObject1 = (CharSequence)parambds.SOL;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label641;
      }
      i = 1;
      label314:
      if (i == 0) {
        break label646;
      }
    }
    label641:
    label646:
    for (long l = 2L;; l = 1L)
    {
      localik.tp(l);
      localObject1 = hF(paramContext);
      localik.tq(((p)localObject1).GcD);
      localik.tr(((p)localObject1).GcE);
      localik.ts(localdbs.TJb);
      localik.tu(localdbs.TJc);
      localik.yQ(parambds.kkU);
      localik.to(localdbs.scene);
      localik.tv(parambds.duration / 1000L);
      localik.tw(hG(paramContext));
      localik.tt(d(paramf));
      Log.i("MicroMsg.Mv.MvReportLogic", "playMusicTime:" + localik.alT() + ", PauseMusicTick:" + localdbs.TJg);
      localik.tx(localdbs.TJd);
      paramContext = f.GbD;
      paramContext = f.a.b(paramf);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          paramf = paramContext.username;
          paramContext = paramf;
          if (paramf != null) {
            break label530;
          }
        }
      }
      paramContext = "";
      label530:
      localik.yR(paramContext);
      parambds = parambds.ozs;
      paramContext = localObject2;
      if (parambds != null) {
        paramContext = n.l(parambds, ",", " ", false);
      }
      localik.yS(paramContext);
      localik.ty(localdbs.TJm);
      localik.tz(localdbs.TJn);
      localdbs.TJm = 0;
      localdbs.TJn = 0;
      localik.bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localik);
      AppMethodBeat.o(235133);
      return;
      label629:
      localObject1 = null;
      break;
      label635:
      l = 0L;
      break label267;
      i = 0;
      break label314;
    }
  }
  
  public static void b(Context paramContext, bds parambds, f paramf, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235148);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(parambds, "songInfo");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportComment, action:".concat(String.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    Object localObject3 = (dbs)a.a.a(paramContext, 7, dbs.class);
    localObject2 = new ih();
    if (localObject3 != null)
    {
      ((ih)localObject2).xX(((dbs)localObject3).wmL);
      ((ih)localObject2).sN(hG(paramContext));
    }
    paramContext = parambds.HLH;
    if (paramContext != null)
    {
      paramContext = n.l(paramContext, ",", " ", false);
      ((ih)localObject2).xY(paramContext);
      ((ih)localObject2).xZ(parambds.kkU);
      ((ih)localObject2).ya(parambds.SOK);
      ((ih)localObject2).yb(parambds.musicDataUrl);
      localObject3 = parambds.ozs;
      paramContext = localObject1;
      if (localObject3 != null) {
        paramContext = n.l((String)localObject3, ",", " ", false);
      }
      ((ih)localObject2).yg(paramContext);
      ((ih)localObject2).sM(parambds.duration / 1000L);
      if (paramf != null)
      {
        paramContext = paramf.Gbl;
        if (paramContext == null) {
          break label341;
        }
      }
    }
    label275:
    label341:
    for (long l = paramContext.longValue();; l = 0L)
    {
      ((ih)localObject2).yc(d.Fw(l));
      ((ih)localObject2).yd(paramf.Gbm);
      paramContext = f.GbD;
      paramContext = f.a.b(paramf);
      if (paramContext != null)
      {
        paramContext = paramContext.contact;
        if (paramContext != null)
        {
          parambds = paramContext.username;
          paramContext = parambds;
          if (parambds != null) {
            break label275;
          }
        }
      }
      paramContext = "";
      ((ih)localObject2).ye(paramContext);
      ((ih)localObject2).sO(d(paramf));
      ((ih)localObject2).sL(paramInt);
      ((ih)localObject2).yf(String.valueOf(paramLong));
      ((ih)localObject2).bpa();
      paramContext = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(235148);
      return;
      paramContext = null;
      break;
    }
  }
  
  private static long d(f paramf)
  {
    AppMethodBeat.i(235167);
    kotlin.g.b.p.k(paramf, "musicMv");
    if (paramf.Gbz > 0L) {}
    for (long l = paramf.GbA + cm.bfE() - paramf.Gbz;; l = paramf.GbA)
    {
      l /= 1000L;
      AppMethodBeat.o(235167);
      return l;
    }
  }
  
  public static p hF(Context paramContext)
  {
    AppMethodBeat.i(235162);
    kotlin.g.b.p.k(paramContext, "context");
    paramContext = l.Gcr;
    Object localObject = l.fgc();
    paramContext = new LinkedList();
    paramContext.addAll((Collection)((HashMap)localObject).entrySet());
    j.a((List)paramContext, (Comparator)o.a.GcC);
    localObject = ((Iterable)paramContext).iterator();
    long l2 = 1L;
    long l1 = 1L;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (l1 >= ((Number)localEntry.getKey()).longValue()) {
        break label230;
      }
      l1 = ((Number)localEntry.getKey()).intValue();
    }
    label230:
    for (;;)
    {
      long l3 = l2;
      if (l2 > ((Number)localEntry.getKey()).longValue()) {
        l3 = ((Number)localEntry.getKey()).intValue();
      }
      l2 = l3;
      break;
      paramContext = (Map.Entry)j.lp((List)paramContext);
      if (paramContext != null)
      {
        paramContext = (Integer)paramContext.getKey();
        if (paramContext == null) {}
      }
      for (l3 = paramContext.intValue();; l3 = 0L)
      {
        paramContext = new p(l1, l2, l3);
        AppMethodBeat.o(235162);
        return paramContext;
      }
    }
  }
  
  public static long hG(Context paramContext)
  {
    AppMethodBeat.i(235165);
    kotlin.g.b.p.k(paramContext, "context");
    a.a locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramContext = (dbs)a.a.a(paramContext, 7, dbs.class);
    if (paramContext != null)
    {
      if (paramContext.TJg > 0L)
      {
        l1 = Util.currentTicks() - paramContext.TJg;
        Log.i("MicroMsg.Mv.MvReportLogic", "pause music now, pauseTime:".concat(String.valueOf(l1)));
        l2 = Util.currentTicks();
        l3 = paramContext.TJe;
        AppMethodBeat.o(235165);
        return l2 - l3 - l1;
      }
      long l1 = Util.currentTicks();
      long l2 = paramContext.TJe;
      long l3 = paramContext.TJf;
      AppMethodBeat.o(235165);
      return l1 - l2 - l3;
    }
    AppMethodBeat.o(235165);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.o
 * JD-Core Version:    0.7.0.1
 */