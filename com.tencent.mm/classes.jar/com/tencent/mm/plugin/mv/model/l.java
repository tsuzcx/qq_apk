package com.tencent.mm.plugin.mv.model;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.a.n;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MvChattingDataManger;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "PAGE_HASH_CODE", "", "TAG", "", "activity", "Landroid/app/Activity;", "chattingFooterLlMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Landroid/widget/LinearLayout;", "Lkotlin/collections/HashMap;", "commentAreaRvMap", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "hasJoinMsg", "", "heartBeatCookie", "Lcom/tencent/mm/protobuf/ByteString;", "isInMvPlayer", "isNewSession", "joinMsg", "lastOnlineCount", "Ljava/lang/Integer;", "lastOnlineCountTimestamp", "", "Ljava/lang/Long;", "lastSongId", "liveMsgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lkotlin/collections/ArrayList;", "mmHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "offline", "onlineCount", "onlineUserTimeMap", "getOnlineUserTimeMap", "()Ljava/util/HashMap;", "onlineUserTvMap", "Landroid/widget/TextView;", "playState", "postLiveMsgScene", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "userEnterTipTvMap", "addChattingFooter", "", "chattingFooter", "addCommentAreaRv", "commentAreaRv", "addOnlineUserTv", "onlineUserTv", "addUserEnterTipTv", "userEnterTipTv", "doHeartBeatScene", "doJoinScene", "onDestroy", "onHeartBeatCallback", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "onInit", "onMusicStart", "onMusicStop", "onMvMainUIEnter", "onMvMainUIExit", "onPostMsgEnd", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSessionEnd", "postLiveMsg", "toSendText", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "msg", "reportChattingRoomCopy", "commentId", "reportChattingRoomExpose", "reportChattingRoomPost", "State", "plugin-mv_release"})
public final class l
  implements i
{
  private static final List<Long> CIH;
  public static bds GaB;
  public static boolean GbZ;
  public static String Gca;
  private static int Gcb;
  private static boolean Gcc;
  private static String Gcd;
  private static Integer Gce;
  private static Long Gcf;
  private static final HashMap<Integer, Long> Gcg;
  private static boolean Gch;
  private static b Gci;
  private static ArrayList<MusicMvCommentView.b> Gcj;
  public static final HashMap<Integer, WeakReference<TextView>> Gck;
  public static final HashMap<Integer, WeakReference<TextView>> Gcl;
  public static final HashMap<Integer, WeakReference<MusicMvCommentView>> Gcm;
  public static final HashMap<Integer, WeakReference<LinearLayout>> Gcn;
  private static n Gco;
  public static int Gcp;
  public static boolean Gcq;
  public static final l Gcr;
  public static Activity activity;
  private static final MMHandler qdR;
  
  static
  {
    AppMethodBeat.i(228056);
    Gcr = new l();
    GbZ = true;
    Gca = "";
    Gcd = "";
    Gcg = new HashMap();
    List localList = Collections.synchronizedList((List)new ArrayList());
    p.j(localList, "Collections.synchronizedList(ArrayList())");
    CIH = localList;
    Gcj = new ArrayList();
    Gck = new HashMap();
    Gcl = new HashMap();
    Gcm = new HashMap();
    Gcn = new HashMap();
    qdR = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)a.Gcs);
    AppMethodBeat.o(228056);
  }
  
  public static void A(TextView paramTextView)
  {
    AppMethodBeat.i(227981);
    p.k(paramTextView, "onlineUserTv");
    ((Map)Gck).put(Integer.valueOf(paramTextView.hashCode()), new WeakReference(paramTextView));
    AppMethodBeat.o(227981);
  }
  
  public static void B(TextView paramTextView)
  {
    AppMethodBeat.i(227984);
    p.k(paramTextView, "userEnterTipTv");
    ((Map)Gcl).put(Integer.valueOf(paramTextView.hashCode()), new WeakReference(paramTextView));
    AppMethodBeat.o(227984);
  }
  
  public static void a(f paramf, long paramLong)
  {
    AppMethodBeat.i(227973);
    bds localbds = GaB;
    Activity localActivity = activity;
    if ((localbds != null) && (localActivity != null))
    {
      o localo = o.GcB;
      o.b((Context)localActivity, localbds, paramf, 6, paramLong);
    }
    AppMethodBeat.o(227973);
  }
  
  public static void a(MusicMvCommentView paramMusicMvCommentView)
  {
    AppMethodBeat.i(227989);
    p.k(paramMusicMvCommentView, "commentAreaRv");
    ((Map)Gcm).put(Integer.valueOf(paramMusicMvCommentView.hashCode()), new WeakReference(paramMusicMvCommentView));
    paramMusicMvCommentView.aL(Gcj);
    AppMethodBeat.o(227989);
  }
  
  private static void a(dbe paramdbe)
  {
    AppMethodBeat.i(228053);
    Gcb = paramdbe.SHk;
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramdbe.TIE.iterator();
    while (localIterator.hasNext())
    {
      paramdbe = (dbj)localIterator.next();
      localObject1 = paramdbe.TIH;
      if ((localObject1 != null) && (((dbh)localObject1).type == 101))
      {
        Gcc = true;
        paramdbe = paramdbe.TIH;
        if (paramdbe != null)
        {
          paramdbe = paramdbe.TIG;
          if (paramdbe != null)
          {
            localObject1 = paramdbe.content;
            paramdbe = (dbe)localObject1;
            if (localObject1 != null) {
              break label112;
            }
          }
        }
        paramdbe = "";
        label112:
        Gcd = paramdbe;
      }
      else
      {
        p.j(paramdbe, "msgPack");
        localObject1 = new MusicMvCommentView.b(new MusicMvCommentView.d(paramdbe));
        if (CIH.contains(Long.valueOf(paramdbe.fxU)))
        {
          Log.i("MicroMsg.Mv.MvChattingDataManger", paramdbe.fxU + " is added, continue");
        }
        else
        {
          CIH.add(Long.valueOf(paramdbe.fxU));
          ((ArrayList)localObject2).add(localObject1);
        }
      }
    }
    int i;
    boolean bool;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i != 0) {
        Gcj.addAll((Collection)localObject2);
      }
      paramdbe = activity;
      if (paramdbe == null) {
        break label422;
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      paramdbe = com.tencent.mm.ui.component.g.lm((Context)paramdbe).i(com.tencent.mm.plugin.mv.ui.uic.g.class);
      p.j(paramdbe, "UICProvider.of(it).get(MusicMvDataUIC::class.java)");
      if ((((com.tencent.mm.plugin.mv.ui.uic.g)paramdbe).GiW & 0x2) <= 0L) {
        break label417;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "chatroom switch status:" + com.tencent.mm.plugin.music.model.m.cPk() + ", " + bool);
      if ((!com.tencent.mm.plugin.music.model.m.cPk()) || (!bool)) {
        break label919;
      }
      paramdbe = Gcn.values();
      p.j(paramdbe, "chattingFooterLlMap.values");
      paramdbe = ((Iterable)paramdbe).iterator();
      while (paramdbe.hasNext())
      {
        localObject1 = (LinearLayout)((WeakReference)paramdbe.next()).get();
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
      }
      i = 0;
      break;
      label417:
      bool = false;
      continue;
      label422:
      bool = false;
    }
    if (Gcc)
    {
      if (((CharSequence)Gcd).length() > 0) {
        i = 1;
      }
      while (i != 0)
      {
        paramdbe = Gck.values();
        p.j(paramdbe, "onlineUserTvMap.values");
        paramdbe = ((Iterable)paramdbe).iterator();
        for (;;)
        {
          if (paramdbe.hasNext())
          {
            localObject1 = (TextView)((WeakReference)paramdbe.next()).get();
            if (localObject1 != null)
            {
              ((TextView)localObject1).setVisibility(8);
              continue;
              i = 0;
              break;
            }
          }
        }
        paramdbe = Gcl.values();
        p.j(paramdbe, "userEnterTipTvMap.values");
        paramdbe = ((Iterable)paramdbe).iterator();
        while (paramdbe.hasNext())
        {
          localObject1 = (TextView)((WeakReference)paramdbe.next()).get();
          if (localObject1 != null)
          {
            ((TextView)localObject1).setText((CharSequence)Gcd);
            ((TextView)localObject1).setVisibility(0);
          }
        }
        qdR.removeCallbacksAndMessages(null);
        qdR.sendEmptyMessageDelayed(0, 2000L);
        paramdbe = Gcm.values();
        p.j(paramdbe, "commentAreaRvMap.values");
        paramdbe = ((Iterable)paramdbe).iterator();
      }
    }
    for (;;)
    {
      label640:
      if (paramdbe.hasNext())
      {
        localObject1 = (WeakReference)paramdbe.next();
        if (!((Collection)Gcj).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label917;
          }
          localObject2 = (MusicMvCommentView)((WeakReference)localObject1).get();
          if (localObject2 != null) {
            ((MusicMvCommentView)localObject2).setVisibility(0);
          }
          localObject1 = (MusicMvCommentView)((WeakReference)localObject1).get();
          if (localObject1 == null) {
            break label640;
          }
          ((MusicMvCommentView)localObject1).aL(Gcj);
          break label640;
          paramdbe = Gck.values();
          p.j(paramdbe, "onlineUserTvMap.values");
          localObject1 = ((Iterable)paramdbe).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TextView)((WeakReference)((Iterator)localObject1).next()).get();
            if (localObject2 != null)
            {
              if (Gcb <= 1) {}
              for (paramdbe = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_only_u_listening);; paramdbe = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_online_listener, new Object[] { Integer.valueOf(Gcb) }))
              {
                ((TextView)localObject2).setText(paramdbe);
                ((TextView)localObject2).setVisibility(0);
                break;
              }
            }
          }
          paramdbe = Gcl.values();
          p.j(paramdbe, "userEnterTipTvMap.values");
          paramdbe = ((Iterable)paramdbe).iterator();
          while (paramdbe.hasNext())
          {
            localObject1 = (TextView)((WeakReference)paramdbe.next()).get();
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(8);
            }
          }
          break;
        }
        label917:
        continue;
        label919:
        paramdbe = Gck.values();
        p.j(paramdbe, "onlineUserTvMap.values");
        localObject1 = ((Iterable)paramdbe).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TextView)((WeakReference)((Iterator)localObject1).next()).get();
          if (localObject2 != null)
          {
            if (Gcb <= 1) {}
            for (paramdbe = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_only_u_listening);; paramdbe = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_online_listener, new Object[] { Integer.valueOf(Gcb) }))
            {
              ((TextView)localObject2).setText(paramdbe);
              ((TextView)localObject2).setVisibility(0);
              break;
            }
          }
        }
      }
    }
    paramdbe = Gce;
    Object localObject1 = Gcf;
    if ((paramdbe != null) && (localObject1 != null))
    {
      long l1 = ((Number)localObject1).longValue();
      i = ((Number)paramdbe).intValue();
      localObject1 = (Long)Gcg.get(Integer.valueOf(i));
      paramdbe = (dbe)localObject1;
      if (localObject1 == null) {
        paramdbe = Long.valueOf(0L);
      }
      p.j(paramdbe, "onlineUserTimeMap[lastOnlineCount] ?: 0L");
      long l2 = paramdbe.longValue();
      long l3 = cm.bfE();
      ((Map)Gcg).put(Integer.valueOf(i), Long.valueOf(l3 - l1 + l2));
    }
    Gce = Integer.valueOf(Gcb);
    Gcf = Long.valueOf(cm.bfE());
    AppMethodBeat.o(228053);
  }
  
  private static void a(dbj paramdbj)
  {
    AppMethodBeat.i(228023);
    if ((0L == paramdbj.fxU) || (paramdbj.TIH == null))
    {
      Log.e("MicroMsg.Mv.MvChattingDataManger", "onPostMsgEnd, null == msgPack.msg, msgid:" + paramdbj.fxU);
      AppMethodBeat.o(228023);
      return;
    }
    Object localObject2 = new StringBuilder("onPostMsgEnd, msg.songId:").append(paramdbj.TIm).append(", content:");
    Object localObject1 = paramdbj.TIH;
    if (localObject1 != null)
    {
      localObject1 = ((dbh)localObject1).TIF;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((dbk)localObject1).text;; localObject1 = null)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", (String)localObject1);
      if (!CIH.contains(Long.valueOf(paramdbj.fxU))) {
        break;
      }
      Log.i("MicroMsg.Mv.MvChattingDataManger", paramdbj.fxU + " is added, continue");
      AppMethodBeat.o(228023);
      return;
    }
    CIH.add(Long.valueOf(paramdbj.fxU));
    paramdbj = new MusicMvCommentView.b(new MusicMvCommentView.d(paramdbj));
    Gcj.add(paramdbj);
    paramdbj = Gcm.values();
    p.j(paramdbj, "commentAreaRvMap.values");
    paramdbj = ((Iterable)paramdbj).iterator();
    label320:
    while (paramdbj.hasNext())
    {
      localObject1 = (WeakReference)paramdbj.next();
      if (!((Collection)Gcj).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label320;
        }
        localObject2 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject2 != null) {
          ((MusicMvCommentView)localObject2).setVisibility(0);
        }
        localObject1 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break;
        }
        ((MusicMvCommentView)localObject1).aL(Gcj);
        break;
      }
    }
    AppMethodBeat.o(228023);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(227969);
    p.k(paramString, "toSendText");
    p.k(paramf, "musicMv");
    Object localObject1 = GaB;
    if (localObject1 != null)
    {
      localObject1 = ((bds)localObject1).kkU;
      if (localObject1 != null)
      {
        if (!Util.isNullOrNil(paramString))
        {
          Object localObject2 = new dbj();
          dbh localdbh = new dbh();
          localdbh.type = 1;
          localdbh.TIF = new dbk();
          dbk localdbk = localdbh.TIF;
          if (localdbk != null) {
            localdbk.text = paramString;
          }
          ((dbj)localObject2).GWV = String.valueOf(cm.bfE());
          ((dbj)localObject2).TIm = ((String)localObject1);
          ((dbj)localObject2).TIJ = z.bdb();
          ((dbj)localObject2).TIH = localdbh;
          ((dbj)localObject2).createtime = ((int)(System.currentTimeMillis() / 1000L));
          paramString = f.GbD;
          paramString = f.a.b(paramf);
          if (paramString != null)
          {
            ((dbj)localObject2).TIL = paramString.id;
            ((dbj)localObject2).jDI = paramString.objectNonceId;
            paramString = paramString.contact;
            if (paramString != null)
            {
              localObject1 = paramString.nickname;
              paramString = (String)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramString = "";
            }
            ((dbj)localObject2).TIM = paramString;
          }
          Log.i("MicroMsg.Mv.MvChattingDataManger", "postLiveMsg msg.objectId:" + ((dbj)localObject2).TIL + " msg.objectNonceId:" + ((dbj)localObject2).jDI);
          paramString = Gco;
          if (paramString != null) {
            com.tencent.mm.kernel.h.aGY().a((q)paramString);
          }
          paramString = GaB;
          if (paramString != null)
          {
            Gco = new n((dbj)localObject2, paramString);
            com.tencent.mm.kernel.h.aGY().b((q)Gco);
          }
          paramString = GaB;
          localObject1 = activity;
          if ((paramString != null) && (localObject1 != null))
          {
            localObject2 = o.GcB;
            o.b((Context)localObject1, paramString, paramf, 1, 0L);
          }
        }
        AppMethodBeat.o(227969);
        return;
      }
    }
    AppMethodBeat.o(227969);
  }
  
  public static void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(227976);
    bds localbds = GaB;
    Activity localActivity = activity;
    if ((localbds != null) && (localActivity != null))
    {
      o localo = o.GcB;
      o.b((Context)localActivity, localbds, paramf, 7, paramLong);
    }
    AppMethodBeat.o(227976);
  }
  
  public static void c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(227993);
    p.k(paramLinearLayout, "chattingFooter");
    ((Map)Gcn).put(Integer.valueOf(paramLinearLayout.hashCode()), new WeakReference(paramLinearLayout));
    AppMethodBeat.o(227993);
  }
  
  public static HashMap<Integer, Long> fgc()
  {
    return Gcg;
  }
  
  public static void fgd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(227951);
    StringBuilder localStringBuilder = new StringBuilder("onMusicStart, songName:");
    Object localObject1 = GaB;
    if (localObject1 != null) {}
    for (localObject1 = ((bds)localObject1).HLH;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", singer:");
      bds localbds = GaB;
      localObject1 = localObject2;
      if (localbds != null) {
        localObject1 = localbds.ozs;
      }
      Log.i("MicroMsg.Mv.MvChattingDataManger", (String)localObject1);
      Gcp = 1;
      AppMethodBeat.o(227951);
      return;
    }
  }
  
  public static void fge()
  {
    Object localObject2 = null;
    AppMethodBeat.i(227955);
    StringBuilder localStringBuilder = new StringBuilder("onSessionEnd, songName:");
    Object localObject1 = GaB;
    if (localObject1 != null) {}
    for (localObject1 = ((bds)localObject1).HLH;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", singer:");
      bds localbds = GaB;
      localObject1 = localObject2;
      if (localbds != null) {
        localObject1 = localbds.ozs;
      }
      Log.i("MicroMsg.Mv.MvChattingDataManger", (String)localObject1);
      vw(true);
      Gcj.clear();
      GbZ = true;
      AppMethodBeat.o(227955);
      return;
    }
  }
  
  private static void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(227999);
    Gch = paramBoolean;
    Object localObject = GaB;
    if (localObject != null) {}
    for (localObject = ((bds)localObject).kkU;; localObject = null)
    {
      b localb = Gci;
      if ((localObject != null) && (localb != null))
      {
        localObject = new com.tencent.mm.plugin.mv.model.a.l((String)localObject, localb, paramBoolean);
        com.tencent.mm.kernel.h.aGY().b((q)localObject);
      }
      AppMethodBeat.o(227999);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Context localContext = null;
    AppMethodBeat.i(228017);
    if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.m))
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvJoin, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.m)paramq).GdF;
        if (paramString != null)
        {
          Gci = paramString.GdC;
          paramq = GaB;
          if (paramq != null) {
            paramq.kkU = paramString.TIm;
          }
          vw(false);
          paramq = new StringBuilder("NetSceneMusicMvJoin songId:");
          paramString = GaB;
          if (paramString != null) {}
          for (paramString = paramString.kkU;; paramString = null)
          {
            Log.i("MicroMsg.Mv.MvChattingDataManger", paramString);
            AppMethodBeat.o(228017);
            return;
          }
        }
        AppMethodBeat.o(228017);
      }
    }
    else if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.l))
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvHeartbeat, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!Gch))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.l)paramq).GdB;
        if (paramString != null) {
          a(paramString);
        }
        paramq = ((com.tencent.mm.plugin.mv.model.a.l)paramq).GdB;
        paramString = localContext;
        if (paramq != null) {
          paramString = paramq.GdC;
        }
        Gci = paramString;
        vw(false);
        AppMethodBeat.o(228017);
      }
    }
    else
    {
      if (((paramq instanceof n)) && (p.h(paramq, Gco)))
      {
        Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvPostLiveMsg, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((n)paramq).GdI;
          if (paramString != null)
          {
            if (paramString != null)
            {
              paramString = paramString.TIN;
              if (paramString != null)
              {
                p.j(paramString, "it");
                a(paramString);
                AppMethodBeat.o(228017);
                return;
              }
            }
            AppMethodBeat.o(228017);
            return;
          }
          AppMethodBeat.o(228017);
          return;
        }
        if (!Util.isNullOrNil(paramString))
        {
          localContext = (Context)activity;
          paramq = activity;
          if (paramq == null) {
            break label473;
          }
        }
        label473:
        for (paramq = paramq.getString(b.h.app_i_known);; paramq = null)
        {
          com.tencent.mm.ui.base.h.a(localContext, paramString, "", paramq, null);
          AppMethodBeat.o(228017);
          return;
        }
      }
      Log.e("MicroMsg.Mv.MvChattingDataManger", "invalid: Scene".concat(String.valueOf(paramq)));
    }
    AppMethodBeat.o(228017);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    public static final a Gcs;
    
    static
    {
      AppMethodBeat.i(231732);
      Gcs = new a();
      AppMethodBeat.o(231732);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(231731);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(231731);
        return false;
        paramMessage = l.Gcr;
        l.fgf();
        paramMessage = l.Gcr;
        l.aSE("");
        paramMessage = l.Gcr;
        paramMessage = l.fgg().values();
        p.j(paramMessage, "onlineUserTvMap.values");
        paramMessage = ((Iterable)paramMessage).iterator();
        TextView localTextView;
        while (paramMessage.hasNext())
        {
          localTextView = (TextView)((WeakReference)paramMessage.next()).get();
          if (localTextView != null) {
            localTextView.setVisibility(0);
          }
        }
        paramMessage = l.Gcr;
        paramMessage = l.fgh().values();
        p.j(paramMessage, "userEnterTipTvMap.values");
        paramMessage = ((Iterable)paramMessage).iterator();
        while (paramMessage.hasNext())
        {
          localTextView = (TextView)((WeakReference)paramMessage.next()).get();
          if (localTextView != null) {
            localTextView.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.l
 * JD-Core Version:    0.7.0.1
 */