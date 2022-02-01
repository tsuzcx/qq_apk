package com.tencent.mm.plugin.mv.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.autogen.mmdata.rpt.ko;
import com.tencent.mm.autogen.mmdata.rpt.kq;
import com.tencent.mm.autogen.mmdata.rpt.kr;
import com.tencent.mm.autogen.mmdata.rpt.ks;
import com.tencent.mm.autogen.mmdata.rpt.kt;
import com.tencent.mm.autogen.mmdata.rpt.ku;
import com.tencent.mm.autogen.mmdata.rpt.kv;
import com.tencent.mm.autogen.mmdata.rpt.kw;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.d.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MvReportLogic;", "", "()V", "TAG", "", "mvReportData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "scene", "", "getMvPlayTime", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getOnlineUserObj", "Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "context", "Landroid/content/Context;", "getPlayMusicTime", "reportComment", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "action", "commentId", "reportCommentLike", "reportDraftMvEnter", "reportMvExit", "reportMvInfo", "jumpRet", "jumpScene", "expoVIP", "reportMvLike", "likeSource", "reportMvMainUIEnter", "reportMvMainUIExit", "reportMvMakerPlayInfo", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "index", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "cdnVideoPlayInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "reportMvMusicCardAction", "reportMvPlayInfo", "playInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "reportMvShare", "actionType", "fromSourceId", "shareSource", "reportMvShareFromSdk", "sessionId", "appId", "wxMediaMessage", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "fromScene", "reportMvStat", "record", "Lcom/tencent/mm/plugin/mv/model/StatRecord;", "reportStat", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o LYk;
  private static dtk LYl;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(286465);
    LYk = new o();
    AppMethodBeat.o(286465);
  }
  
  private static final int a(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    AppMethodBeat.i(286454);
    if (((Number)paramEntry1.getValue()).longValue() > ((Number)paramEntry2.getValue()).longValue())
    {
      AppMethodBeat.o(286454);
      return -1;
    }
    if (((Number)paramEntry1.getValue()).longValue() < ((Number)paramEntry2.getValue()).longValue())
    {
      AppMethodBeat.o(286454);
      return 1;
    }
    AppMethodBeat.o(286454);
    return 0;
  }
  
  public static void a(Context paramContext, f paramf, com.tencent.mm.plugin.thumbplayer.d.c paramc)
  {
    AppMethodBeat.i(286341);
    s.u(paramContext, "context");
    s.u(paramf, "musicMv");
    if (paramc == null)
    {
      AppMethodBeat.o(286341);
      return;
    }
    if (paramc.TES.isEmpty())
    {
      AppMethodBeat.o(286341);
      return;
    }
    paramc.Ftc = Util.ticksToNow(paramc.moe);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject = new kw();
    if (paramContext != null)
    {
      ((kw)localObject).iYe = ((kw)localObject).F("contextId", paramContext.zIO, true);
      ((kw)localObject).iuA = paramContext.scene;
    }
    ((kw)localObject).iXL = ((kw)localObject).F("mvNonceId", paramf.LXk, true);
    paramContext = paramf.LXj;
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.toString())
    {
      ((kw)localObject).iXK = ((kw)localObject).F("mvObjectId", paramContext, true);
      ((kw)localObject).iMn = paramc.TER;
      ((kw)localObject).iLV = paramc.Ftc;
      paramContext = paramc.TES.values();
      s.s(paramContext, "playInfo.mediaReportInfo.values");
      paramContext = ((Iterable)paramContext).iterator();
      for (i = 0; paramContext.hasNext(); i = ((com.tencent.mm.plugin.thumbplayer.d.a)paramContext.next()).TEH + i) {}
    }
    ((kw)localObject).iMp = i;
    ((kw)localObject).iYl = ((kw)localObject).F("VideoPlayInfo", paramc.hLb(), true);
    paramContext = paramc.TES.values();
    s.s(paramContext, "mediaReportInfo.values");
    paramContext = ((Iterable)paramContext).iterator();
    int i = 0;
    if (paramContext.hasNext())
    {
      if (((com.tencent.mm.plugin.thumbplayer.d.a)paramContext.next()).hLa()) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    ((kw)localObject).iYm = i;
    ((kw)localObject).bMH();
    paramc.TES.clear();
    paramContext = paramc.TEQ;
    if (paramContext != null) {
      paramContext.reset();
    }
    paramContext = com.tencent.mm.util.c.agsX;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(286341);
  }
  
  public static void a(Context paramContext, boo paramboo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(286208);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    Object localObject3 = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = LYl;
    }
    localObject3 = new kq();
    label224:
    int i;
    label286:
    label350:
    long l;
    if (localObject1 != null)
    {
      ((kq)localObject3).tq(((dtk)localObject1).zIO);
      ((kq)localObject3).iqr = ((dtk)localObject1).scene;
      ((kq)localObject3).tv(((dtk)localObject1).aaYQ);
      ((kq)localObject3).iXB = ((dtk)localObject1).aaYR;
      ((kq)localObject3).iXD = ((dtk)localObject1).aaYX;
      ((kq)localObject3).iXF = ((dtk)localObject1).aaYY;
      ((kq)localObject3).iXG = ((dtk)localObject1).aaYZ;
      ((kq)localObject3).iXH = ((dtk)localObject1).aaZa;
      ((kq)localObject3).iXI = ((dtk)localObject1).aaZb;
      if (((dtk)localObject1).aaZe == 3) {
        ((kq)localObject3).iDn = 3L;
      }
    }
    else
    {
      if ((scene == 18) && ((paramContext instanceof Activity)))
      {
        ((kq)localObject3).iqr = scene;
        localObject1 = ((Activity)paramContext).getIntent();
        if (localObject1 != null) {
          break label450;
        }
        localObject1 = null;
        ((kq)localObject3).ty((String)localObject1);
        scene = 0;
      }
      localObject1 = jg(paramContext);
      ((kq)localObject3).iXy = ((p)localObject1).LYm;
      ((kq)localObject3).iXz = ((p)localObject1).LYn;
      ((kq)localObject3).iXA = ((p)localObject1).LYo;
      localObject1 = paramboo.songName;
      if (localObject1 != null) {
        break label463;
      }
      localObject1 = null;
      ((kq)localObject3).tr((String)localObject1);
      ((kq)localObject3).tu(paramboo.ZWQ);
      ((kq)localObject3).ts(paramboo.ZWR);
      ((kq)localObject3).tt(paramboo.musicDataUrl);
      localObject1 = (CharSequence)paramboo.Mcq;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label480;
      }
      i = 1;
      if (i == 0) {
        break label485;
      }
      l = 2L;
      label358:
      ((kq)localObject3).iXx = l;
      ((kq)localObject3).tw(paramboo.mLQ);
      paramboo = paramboo.rDl;
      if (paramboo != null) {
        break label490;
      }
    }
    label450:
    label463:
    label480:
    label485:
    label490:
    for (paramboo = localObject2;; paramboo = n.m(paramboo, ",", " ", false))
    {
      ((kq)localObject3).tx(paramboo);
      ((kq)localObject3).ioV = 2L;
      ((kq)localObject3).iXC = jh(paramContext);
      ((kq)localObject3).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject3);
      scene = 0;
      AppMethodBeat.o(286208);
      return;
      ((kq)localObject3).iDn = 2L;
      break;
      localObject1 = ((Intent)localObject1).getStringExtra("key_mv_scene_note");
      break label224;
      localObject1 = n.m((String)localObject1, ",", " ", false);
      break label286;
      i = 0;
      break label350;
      l = 1L;
      break label358;
    }
  }
  
  public static void a(Context paramContext, boo paramboo, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286322);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    Log.i("MicroMsg.Mv.MvReportLogic", s.X("reportMvMusicCardAction, action:", Integer.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject2 = new kn();
    if (paramContext != null)
    {
      ((kn)localObject2).ipT = ((kn)localObject2).F("ContextId", paramContext.zIO, true);
      ((kn)localObject2).iqr = paramContext.scene;
      ((kn)localObject2).sX(paramContext.aaYQ);
    }
    paramContext = paramboo.songName;
    if (paramContext == null)
    {
      paramContext = null;
      ((kn)localObject2).sT(paramContext);
      ((kn)localObject2).iWY = ((kn)localObject2).F("SongId", paramboo.mLQ, true);
      ((kn)localObject2).sU(paramboo.ZWR);
      ((kn)localObject2).sV(paramboo.musicDataUrl);
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label236;
      }
    }
    label236:
    for (paramContext = localObject1;; paramContext = n.m(paramContext, ",", " ", false))
    {
      ((kn)localObject2).sW(paramContext);
      ((kn)localObject2).sY(paramboo.ZWQ);
      ((kn)localObject2).ioV = paramInt;
      ((kn)localObject2).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(286322);
      return;
      paramContext = n.m(paramContext, ",", " ", false);
      break;
    }
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286186);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    dtk localdtk = (dtk)a.a.a(paramContext, 7, dtk.class);
    LYl = localdtk;
    localObject2 = new kq();
    if (localdtk != null)
    {
      ((kq)localObject2).tq(localdtk.zIO);
      ((kq)localObject2).iqr = localdtk.scene;
      ((kq)localObject2).tv(localdtk.aaYQ);
      localdtk.aaYX = 0;
      localdtk.aaYY = 0;
      localdtk.aaZb = 0L;
      localdtk.aaYZ = 0;
      localdtk.aaZa = 2;
      if (localdtk.scene == 18) {
        scene = 18;
      }
    }
    label190:
    int i;
    label250:
    long l;
    if ((scene == 18) && ((paramContext instanceof Activity)))
    {
      paramContext = ((Activity)paramContext).getIntent();
      if (paramContext == null)
      {
        paramContext = null;
        ((kq)localObject2).ty(paramContext);
      }
    }
    else
    {
      paramContext = paramboo.songName;
      if (paramContext != null) {
        break label386;
      }
      paramContext = null;
      ((kq)localObject2).tr(paramContext);
      ((kq)localObject2).tu(paramboo.ZWQ);
      ((kq)localObject2).ts(paramboo.ZWR);
      ((kq)localObject2).tt(paramboo.musicDataUrl);
      paramContext = (CharSequence)paramboo.Mcq;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label401;
      }
      i = 1;
      if (i == 0) {
        break label406;
      }
      l = 2L;
      label259:
      ((kq)localObject2).iXx = l;
      paramContext = paramf.LXj;
      if (paramContext != null) {
        break label412;
      }
      l = 0L;
      label278:
      ((kq)localObject2).iXa = ((kq)localObject2).F("MvObjectId", d.hF(l), true);
      ((kq)localObject2).iXb = ((kq)localObject2).F("MvNonceId", paramf.LXk, true);
      ((kq)localObject2).tw(paramboo.mLQ);
      ((kq)localObject2).ioV = 1L;
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label421;
      }
    }
    label386:
    label401:
    label406:
    label412:
    label421:
    for (paramContext = localObject1;; paramContext = n.m(paramContext, ",", " ", false))
    {
      ((kq)localObject2).tx(paramContext);
      ((kq)localObject2).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(286186);
      return;
      paramContext = paramContext.getStringExtra("key_mv_scene_note");
      break;
      paramContext = n.m(paramContext, ",", " ", false);
      break label190;
      i = 0;
      break label250;
      l = 1L;
      break label259;
      l = paramContext.longValue();
      break label278;
    }
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286303);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", s.X("reportMvLike, action:", Integer.valueOf(paramInt1)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    dtk localdtk = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject2 = new kt();
    if (localdtk != null)
    {
      ((kt)localObject2).tz(localdtk.zIO);
      ((kt)localObject2).iXe = jh(paramContext);
      ((kt)localObject2).iXf = d(paramf);
    }
    paramContext = paramboo.songName;
    label165:
    long l;
    if (paramContext == null)
    {
      paramContext = null;
      ((kt)localObject2).tA(paramContext);
      ((kt)localObject2).tB(paramboo.mLQ);
      ((kt)localObject2).tC(paramboo.ZWR);
      ((kt)localObject2).tD(paramboo.musicDataUrl);
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label298;
      }
      paramContext = localObject1;
      ((kt)localObject2).tH(paramContext);
      ((kt)localObject2).iXd = (paramboo.duration / 1000L);
      paramContext = paramf.LXj;
      if (paramContext != null) {
        break label313;
      }
      l = 0L;
      label198:
      ((kt)localObject2).tE(d.hF(l));
      ((kt)localObject2).tF(paramf.LXk);
      paramContext = f.LXf;
      paramContext = f.a.b(paramf);
      if (paramContext != null) {
        break label322;
      }
      paramContext = "";
    }
    for (;;)
    {
      ((kt)localObject2).tG(paramContext);
      ((kt)localObject2).ioV = paramInt1;
      ((kt)localObject2).iYa = paramInt2;
      ((kt)localObject2).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(286303);
      return;
      paramContext = n.m(paramContext, ",", " ", false);
      break;
      label298:
      paramContext = n.m(paramContext, ",", " ", false);
      break label165;
      label313:
      l = paramContext.longValue();
      break label198;
      label322:
      paramContext = paramContext.contact;
      if (paramContext == null)
      {
        paramContext = "";
      }
      else
      {
        paramboo = paramContext.username;
        paramContext = paramboo;
        if (paramboo == null) {
          paramContext = "";
        }
      }
    }
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    AppMethodBeat.i(286272);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", s.X("reportMvInfo, action:", Integer.valueOf(paramInt1)));
    paramf = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    paramf = new ks();
    label172:
    int i;
    label231:
    long l;
    if (paramContext != null)
    {
      paramf.ipT = paramf.F("ContextId", paramContext.zIO, true);
      paramContext = paramboo.songName;
      if (paramContext != null) {
        break label355;
      }
      paramContext = null;
      paramf.iWS = paramf.F("SongName", paramContext, true);
      paramf.iWY = paramf.F("SongId", paramboo.mLQ, true);
      paramf.iWU = paramf.F("WebUrl", paramboo.ZWR, true);
      paramf.iWV = paramf.F("DataUrl", paramboo.musicDataUrl, true);
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label370;
      }
      paramContext = localObject;
      paramf.iWT = paramf.F("Singer", paramContext, true);
      paramf.ioV = paramInt1;
      paramf.imT = paramf.F("AppId", paramboo.ZWQ, true);
      paramContext = (CharSequence)paramboo.Mcq;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label385;
      }
      i = 1;
      if (i == 0) {
        break label391;
      }
      l = 2L;
      label241:
      paramf.iXx = l;
      paramf.iXS = paramf.F("Sect", paramboo.ZTA, true);
      paramf.iXT = paramf.F("CoverURL", paramboo.ZWS, true);
      paramf.ioV = paramInt1;
      paramf.iXV = paramInt2;
      paramf.iXW = paramInt3;
      paramContext = paramboo.ZWW;
      if (paramContext != null) {
        break label397;
      }
      paramContext = "";
    }
    for (;;)
    {
      paramf.iXX = paramf.F("H5URL", paramContext, true);
      paramf.iXY = paramInt4;
      paramf.bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)paramf);
      AppMethodBeat.o(286272);
      return;
      label355:
      paramContext = n.m(paramContext, ",", " ", false);
      break;
      label370:
      paramContext = n.m(paramContext, ",", " ", false);
      break label172;
      label385:
      i = 0;
      break label231;
      label391:
      l = 1L;
      break label241;
      label397:
      paramContext = paramContext.ZWX;
      if (paramContext == null)
      {
        paramContext = "";
      }
      else
      {
        paramboo = n.m(paramContext, ",", " ", false);
        paramContext = paramboo;
        if (paramboo == null) {
          paramContext = "";
        }
      }
    }
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286309);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", s.X("reportCommentLike, action:", Integer.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    dtk localdtk = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject2 = new kt();
    if (localdtk != null)
    {
      ((kt)localObject2).tz(localdtk.zIO);
      ((kt)localObject2).iXe = jh(paramContext);
      ((kt)localObject2).iXf = d(paramf);
    }
    paramContext = paramboo.songName;
    label165:
    long l;
    if (paramContext == null)
    {
      paramContext = null;
      ((kt)localObject2).tA(paramContext);
      ((kt)localObject2).tB(paramboo.mLQ);
      ((kt)localObject2).tC(paramboo.ZWR);
      ((kt)localObject2).tD(paramboo.musicDataUrl);
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label309;
      }
      paramContext = localObject1;
      ((kt)localObject2).tH(paramContext);
      ((kt)localObject2).iXd = (paramboo.duration / 1000L);
      paramContext = paramf.LXj;
      if (paramContext != null) {
        break label324;
      }
      l = 0L;
      label198:
      ((kt)localObject2).tE(d.hF(l));
      ((kt)localObject2).tF(paramf.LXk);
      paramContext = f.LXf;
      paramContext = f.a.b(paramf);
      if (paramContext != null) {
        break label333;
      }
      paramContext = "";
    }
    for (;;)
    {
      ((kt)localObject2).tG(paramContext);
      ((kt)localObject2).ioV = paramInt;
      ((kt)localObject2).izz = ((kt)localObject2).F("CommentId", String.valueOf(paramLong), true);
      ((kt)localObject2).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(286309);
      return;
      paramContext = n.m(paramContext, ",", " ", false);
      break;
      label309:
      paramContext = n.m(paramContext, ",", " ", false);
      break label165;
      label324:
      l = paramContext.longValue();
      break label198;
      label333:
      paramContext = paramContext.contact;
      if (paramContext == null)
      {
        paramContext = "";
      }
      else
      {
        paramboo = paramContext.username;
        paramContext = paramboo;
        if (paramboo == null) {
          paramContext = "";
        }
      }
    }
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(286379);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    s.u(paramString, "fromSourceId");
    ku localku = new ku();
    a.a locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    if (paramContext != null) {
      localku.tI(paramContext.zIO);
    }
    localku.tJ(paramboo.songName);
    localku.iWY = localku.F("SongId", paramboo.mLQ, true);
    localku.tK(paramboo.ZWR);
    localku.tL(paramboo.musicDataUrl);
    localku.tP(paramboo.ZWQ);
    localku.tR(paramboo.rDl);
    localku.iqr = paramInt1;
    localku.ioV = 2L;
    localku.tQ(paramString);
    localku.iYc = 2L;
    paramContext = f.LXf;
    paramContext = f.a.b(paramf);
    if (paramContext != null)
    {
      localku.tM(d.hF(paramContext.id));
      localku.tN(paramContext.objectNonceId);
      localku.tO(paramContext.username);
    }
    localku.iYd = paramInt2;
    localku.bMH();
    paramContext = com.tencent.mm.util.c.agsX;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localku);
    AppMethodBeat.o(286379);
  }
  
  public static void a(Context paramContext, boo paramboo, f paramf, q paramq)
  {
    AppMethodBeat.i(286253);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    s.u(paramq, "record");
    fhp localfhp = new fhp();
    Object localObject = paramf.LXj;
    long l;
    label109:
    String str;
    if (localObject == null)
    {
      l = 0L;
      localfhp.hKN = l;
      localfhp.objectNonceId = paramf.LXk;
      localfhp.abIi = new fvu();
      localfhp.abIj = new dzj();
      localObject = paramf.LXt;
      if (localObject != null) {
        break label491;
      }
      i = 0;
      localfhp.mediaType = i;
      localObject = paramf.LXt;
      if (localObject != null) {
        break label519;
      }
      str = null;
      label130:
      localObject = str;
      if (str == null)
      {
        str = z.bAW();
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
      localfhp.finderUsername = ((String)localObject);
      localfhp.abIk = paramq.rmn;
      localObject = paramf.LXt;
      if (localObject != null) {
        break label529;
      }
      localObject = "";
      label190:
      localfhp.sessionBuffer = ((String)localObject);
      localfhp.abIr = paramq.rmn;
      l = cn.bDw();
      localObject = localfhp.abIi;
      if (localObject != null)
      {
        ((fvu)localObject).abTW = paramboo.duration;
        ((fvu)localObject).QXQ = ((int)((l - paramq.rmn) / 1000L));
        ((fvu)localObject).zIy = (l - paramq.rmn);
        ((fvu)localObject).abTX = paramf.LXy;
        ((fvu)localObject).abTY = paramf.LXy;
        ((fvu)localObject).abTZ = ((fvu)localObject).zIy;
        ((fvu)localObject).ork = paramq.rmn;
        ((fvu)localObject).abUa = l;
        ((fvu)localObject).abUb = paramf.LXz;
      }
      paramboo = localfhp.abIj;
      if (paramboo != null)
      {
        paramboo.abeg = paramq.FsM;
        paramf = localfhp.abIi;
        if (paramf != null) {
          break label553;
        }
      }
    }
    label519:
    label529:
    label553:
    for (int i = 0;; i = (int)paramf.zIy)
    {
      paramboo.abeh = i;
      paramboo.abeq = paramq.FsL;
      paramboo.abei = paramq.Gwt;
      Log.i("MicroMsg.Mv.MvReportLogic", "print stats: " + localfhp + " index:" + paramq.index);
      paramboo = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramboo = (dtk)a.a.a(paramContext, 7, dtk.class);
      paramContext = new bui();
      if (paramboo != null)
      {
        paramContext.zIO = paramboo.zIO;
        paramContext.AJo = 91;
      }
      paramboo = new LinkedList();
      paramboo.add(localfhp);
      paramf = ai.FtE;
      ai.a((List)paramboo, paramContext, 0);
      AppMethodBeat.o(286253);
      return;
      l = ((Long)localObject).longValue();
      break;
      label491:
      localObject = ((FinderObject)localObject).objectDesc;
      if (localObject == null)
      {
        i = 0;
        break label109;
      }
      i = ((FinderObjectDesc)localObject).mediaType;
      break label109;
      str = ((FinderObject)localObject).username;
      break label130;
      str = ((FinderObject)localObject).sessionBuffer;
      localObject = str;
      if (str != null) {
        break label190;
      }
      localObject = "";
      break label190;
    }
  }
  
  public static void a(Context paramContext, dtf paramdtf, int paramInt, e parame, com.tencent.mm.plugin.thumbplayer.d.a parama, b paramb)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(286362);
    s.u(paramContext, "context");
    if ((paramdtf == null) || (parame == null) || (parama == null) || (paramb == null))
    {
      AppMethodBeat.o(286362);
      return;
    }
    parama.stop();
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject = new kv();
    if (paramContext != null)
    {
      ((kv)localObject).iYe = ((kv)localObject).F("contextId", paramContext.zIO, true);
      ((kv)localObject).iuA = paramContext.scene;
    }
    paramContext = parame.LWY;
    boolean bool;
    if (paramContext == null)
    {
      bool = false;
      if (parame.LWZ != null) {
        i = 1;
      }
      paramContext = paramdtf.aaYK;
      if (paramContext != null) {
        break label304;
      }
      paramContext = "";
      label140:
      ((kv)localObject).iXK = ((kv)localObject).F("mvObjectId", paramContext, true);
      paramContext = paramdtf.aaYK;
      if (paramContext != null) {
        break label328;
      }
      paramContext = null;
      label165:
      ((kv)localObject).iXL = ((kv)localObject).F("mvNonceId", paramContext, true);
      ((kv)localObject).iYf = paramInt;
      if (i == 0) {
        break label336;
      }
      paramInt = 2;
      label192:
      ((kv)localObject).iYg = paramInt;
      if (!bool) {
        break label341;
      }
    }
    label304:
    label328:
    label336:
    label341:
    for (paramInt = j;; paramInt = 2)
    {
      ((kv)localObject).iYh = paramInt;
      ((kv)localObject).iMn = parama.wNr;
      ((kv)localObject).iYi = parama.TEH;
      ((kv)localObject).iYj = parama.errType;
      ((kv)localObject).iYk = parama.errCode;
      ((kv)localObject).bMH();
      parama.moe = Util.currentTicks();
      paramb.reset();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      AppMethodBeat.o(286362);
      return;
      bool = paramContext.eDB();
      break;
      parame = Long.valueOf(paramContext.id).toString();
      paramContext = parame;
      if (parame != null) {
        break label140;
      }
      paramContext = "";
      break label140;
      paramContext = paramContext.objectNonceId;
      break label165;
      paramInt = 1;
      break label192;
    }
  }
  
  public static void a(String paramString1, String paramString2, WXMediaMessage paramWXMediaMessage, int paramInt)
  {
    AppMethodBeat.i(286400);
    s.u(paramString1, "sessionId");
    s.u(paramWXMediaMessage, "wxMediaMessage");
    if ((paramInt != 1) && (paramInt != 0))
    {
      AppMethodBeat.o(286400);
      return;
    }
    ku localku = new ku();
    localku.tI(paramString1);
    localku.ioV = 1L;
    if (paramInt == 1) {}
    for (long l = 1L;; l = 2L)
    {
      localku.iqr = l;
      if (paramWXMediaMessage.getType() != 3) {
        break label236;
      }
      paramString1 = paramWXMediaMessage.mediaObject;
      if (paramString1 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXMusicObject");
      AppMethodBeat.o(286400);
      throw paramString1;
    }
    Object localObject = (WXMusicObject)paramString1;
    String str = paramWXMediaMessage.title;
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    localku.tJ(paramString1);
    localku.tK(((WXMusicObject)localObject).musicUrl);
    localku.tL(((WXMusicObject)localObject).musicDataUrl);
    localku.tR(paramWXMediaMessage.description);
    localku.tP(paramString2);
    if (m.aml(paramString2)) {}
    for (localku.iYc = 2L;; localku.iYc = 1L)
    {
      localku.bMH();
      paramString1 = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localku);
      AppMethodBeat.o(286400);
      return;
    }
    label236:
    if (paramWXMediaMessage.getType() == 76)
    {
      paramString1 = paramWXMediaMessage.mediaObject;
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject");
        AppMethodBeat.o(286400);
        throw paramString1;
      }
      localObject = (WXMusicVideoObject)paramString1;
      str = paramWXMediaMessage.title;
      paramString1 = str;
      if (str == null) {
        paramString1 = "";
      }
      localku.tJ(paramString1);
      localku.tK(((WXMusicVideoObject)localObject).musicUrl);
      localku.tL(((WXMusicVideoObject)localObject).musicDataUrl);
      paramString1 = (CharSequence)((WXMusicVideoObject)localObject).singerName;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label407;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label412;
      }
    }
    label407:
    label412:
    for (paramString1 = ((WXMusicVideoObject)localObject).singerName;; paramString1 = paramWXMediaMessage.description)
    {
      localku.tR(paramString1);
      localku.tP(paramString2);
      localku.iYc = 2L;
      localku.bMH();
      paramString1 = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localku);
      AppMethodBeat.o(286400);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static void b(Context paramContext, boo paramboo, f paramf)
  {
    Object localObject3 = null;
    AppMethodBeat.i(286234);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    s.u(paramf, "musicMv");
    Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit");
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject1 = (dtk)a.a.a(paramContext, 7, dtk.class);
    kr localkr;
    Object localObject2;
    label195:
    long l;
    label309:
    int i;
    if (localObject1 == null)
    {
      localObject1 = LYl;
      localkr = new kr();
      if (localObject1 != null)
      {
        Log.i("MicroMsg.Mv.MvReportLogic", "reportMVExit, isComment:" + ((dtk)localObject1).aaYS + ", isDragProcess:" + ((dtk)localObject1).aaYT + ", StartPlayMusicTick:" + ((dtk)localObject1).aaYU + ", PausePlayMusicTime:" + ((dtk)localObject1).aaYV + ", scene:" + ((dtk)localObject1).scene);
        localkr.ipT = localkr.F("ContextId", ((dtk)localObject1).zIO, true);
        localObject2 = paramboo.songName;
        if (localObject2 != null) {
          break label668;
        }
        localObject2 = null;
        localkr.iWS = localkr.F("SongName", (String)localObject2, true);
        localkr.iWU = localkr.F("WebUrl", paramboo.ZWR, true);
        localkr.iWV = localkr.F("DataUrl", paramboo.musicDataUrl, true);
        localkr.iqr = ((dtk)localObject1).scene;
        localkr.iWZ = localkr.F("FromSourceId", ((dtk)localObject1).aaYQ, true);
        localkr.imT = localkr.F("AppId", paramboo.ZWQ, true);
        localObject2 = paramf.LXj;
        if (localObject2 != null) {
          break label684;
        }
        l = 0L;
        localkr.iXK = localkr.F("mvObjectId", d.hF(l), true);
        localkr.iXL = localkr.F("mvNonceId", paramf.LXk, true);
        localObject2 = (CharSequence)paramboo.Mcq;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label694;
        }
        i = 1;
        label370:
        if (i == 0) {
          break label699;
        }
        l = 2L;
        label379:
        localkr.iXx = l;
        localObject2 = jg(paramContext);
        localkr.iXy = ((p)localObject2).LYm;
        localkr.iXz = ((p)localObject2).LYn;
        localkr.iXM = ((dtk)localObject1).aaYR;
        localkr.iXN = ((dtk)localObject1).aaYS;
        localkr.iWY = localkr.F("SongId", paramboo.mLQ, true);
        localkr.iqr = ((dtk)localObject1).scene;
        localkr.iXd = (paramboo.duration / 1000L);
        localkr.iXe = jh(paramContext);
        localkr.iXf = d(paramf);
        Log.i("MicroMsg.Mv.MvReportLogic", "playMusicTime:" + localkr.iXe + ", PauseMusicTick:" + ((dtk)localObject1).aaYW);
        localkr.iXO = ((dtk)localObject1).aaYT;
        paramContext = f.LXf;
        paramContext = f.a.b(paramf);
        if (paramContext != null) {
          break label705;
        }
        paramContext = "";
        label564:
        localkr.iXP = localkr.F("mvUserId", paramContext, true);
        paramContext = paramboo.rDl;
        if (paramContext != null) {
          break label739;
        }
      }
    }
    label668:
    label684:
    label694:
    label699:
    label705:
    label739:
    for (paramContext = localObject3;; paramContext = n.bV(paramContext, ",", " "))
    {
      localkr.iWT = localkr.F("Singer", paramContext, true);
      localkr.iXQ = ((dtk)localObject1).aaZc;
      localkr.iXR = ((dtk)localObject1).aaZd;
      ((dtk)localObject1).aaZc = 0;
      ((dtk)localObject1).aaZd = 0;
      localkr.bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localkr);
      AppMethodBeat.o(286234);
      return;
      break;
      localObject2 = n.bV((String)localObject2, ",", " ");
      break label195;
      l = ((Long)localObject2).longValue();
      break label309;
      i = 0;
      break label370;
      l = 1L;
      break label379;
      paramContext = paramContext.contact;
      if (paramContext == null)
      {
        paramContext = "";
        break label564;
      }
      paramf = paramContext.username;
      paramContext = paramf;
      if (paramf != null) {
        break label564;
      }
      paramContext = "";
      break label564;
    }
  }
  
  public static void b(Context paramContext, boo paramboo, f paramf, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286315);
    s.u(paramContext, "context");
    s.u(paramboo, "songInfo");
    Log.i("MicroMsg.Mv.MvReportLogic", s.X("reportComment, action:", Integer.valueOf(paramInt)));
    Object localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    dtk localdtk = (dtk)a.a.a(paramContext, 7, dtk.class);
    localObject2 = new ko();
    if (localdtk != null)
    {
      ((ko)localObject2).ipT = ((ko)localObject2).F("ContextId", localdtk.zIO, true);
      ((ko)localObject2).iXe = jh(paramContext);
    }
    paramContext = paramboo.songName;
    label190:
    long l;
    if (paramContext == null)
    {
      paramContext = null;
      ((ko)localObject2).iWS = ((ko)localObject2).F("SongName", paramContext, true);
      ((ko)localObject2).iWY = ((ko)localObject2).F("SongId", paramboo.mLQ, true);
      ((ko)localObject2).iWU = ((ko)localObject2).F("WebUrl", paramboo.ZWR, true);
      ((ko)localObject2).iWV = ((ko)localObject2).F("DataUrl", paramboo.musicDataUrl, true);
      paramContext = paramboo.rDl;
      if (paramContext != null) {
        break label379;
      }
      paramContext = localObject1;
      ((ko)localObject2).iWT = ((ko)localObject2).F("Singer", paramContext, true);
      ((ko)localObject2).iXd = (paramboo.duration / 1000L);
      if (paramf != null)
      {
        paramContext = paramf.LXj;
        if (paramContext != null) {
          break label394;
        }
        l = 0L;
        label235:
        ((ko)localObject2).iXa = ((ko)localObject2).F("MvObjectId", d.hF(l), true);
        ((ko)localObject2).iXb = ((ko)localObject2).F("MvNonceId", paramf.LXk, true);
        paramContext = f.LXf;
        paramContext = f.a.b(paramf);
        if (paramContext != null) {
          break label403;
        }
        paramContext = "";
      }
    }
    for (;;)
    {
      ((ko)localObject2).iXc = ((ko)localObject2).F("MvUserId", paramContext, true);
      ((ko)localObject2).iXf = d(paramf);
      ((ko)localObject2).ioV = paramInt;
      ((ko)localObject2).izz = ((ko)localObject2).F("CommentId", String.valueOf(paramLong), true);
      ((ko)localObject2).bMH();
      paramContext = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
      AppMethodBeat.o(286315);
      return;
      paramContext = n.m(paramContext, ",", " ", false);
      break;
      label379:
      paramContext = n.m(paramContext, ",", " ", false);
      break label190;
      label394:
      l = paramContext.longValue();
      break label235;
      label403:
      paramContext = paramContext.contact;
      if (paramContext == null)
      {
        paramContext = "";
      }
      else
      {
        paramboo = paramContext.username;
        paramContext = paramboo;
        if (paramboo == null) {
          paramContext = "";
        }
      }
    }
  }
  
  private static long d(f paramf)
  {
    AppMethodBeat.i(286439);
    s.u(paramf, "musicMv");
    if (paramf.LXx > 0L) {}
    for (long l = paramf.LXy + cn.bDw() - paramf.LXx;; l = paramf.LXy)
    {
      l /= 1000L;
      AppMethodBeat.o(286439);
      return l;
    }
  }
  
  private static p jg(Context paramContext)
  {
    AppMethodBeat.i(286420);
    s.u(paramContext, "context");
    paramContext = l.LXJ;
    Object localObject = l.gpG();
    paramContext = new LinkedList();
    paramContext.addAll((Collection)((HashMap)localObject).entrySet());
    kotlin.a.p.a((List)paramContext, o..ExternalSyntheticLambda0.INSTANCE);
    localObject = ((Iterable)paramContext).iterator();
    long l3 = 1L;
    long l1 = 1L;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (l1 >= ((Number)localEntry.getKey()).intValue()) {
        break label233;
      }
      l1 = ((Number)localEntry.getKey()).intValue();
    }
    label233:
    for (;;)
    {
      long l2 = l3;
      if (l3 > ((Number)localEntry.getKey()).intValue()) {
        l2 = ((Number)localEntry.getKey()).intValue();
      }
      l3 = l2;
      break;
      paramContext = (Map.Entry)kotlin.a.p.oL((List)paramContext);
      if (paramContext == null) {
        l2 = 0L;
      }
      for (;;)
      {
        paramContext = new p(l1, l3, l2);
        AppMethodBeat.o(286420);
        return paramContext;
        paramContext = (Integer)paramContext.getKey();
        if (paramContext == null) {
          l2 = 0L;
        } else {
          l2 = paramContext.intValue();
        }
      }
    }
  }
  
  private static long jh(Context paramContext)
  {
    AppMethodBeat.i(286428);
    s.u(paramContext, "context");
    a.a locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramContext = (dtk)a.a.a(paramContext, 7, dtk.class);
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext == null)
      {
        AppMethodBeat.o(286428);
        return 0L;
      }
    }
    else
    {
      if (paramContext.aaYW > 0L)
      {
        l = Util.currentTicks() - paramContext.aaYW;
        Log.i("MicroMsg.Mv.MvReportLogic", s.X("pause music now, pauseTime:", Long.valueOf(l)));
      }
      for (l = Util.currentTicks() - paramContext.aaYU - l;; l = Util.currentTicks() - paramContext.aaYU - paramContext.aaYV)
      {
        paramContext = Long.valueOf(l);
        break;
      }
    }
    long l = paramContext.longValue();
    AppMethodBeat.o(286428);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.o
 * JD-Core Version:    0.7.0.1
 */