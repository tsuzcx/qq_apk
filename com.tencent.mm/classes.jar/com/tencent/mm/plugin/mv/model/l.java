package com.tencent.mm.plugin.mv.model;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.a.q;
import com.tencent.mm.plugin.mv.model.a.r;
import com.tencent.mm.plugin.mv.ui.uic.e;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MvChattingDataManger;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "PAGE_HASH_CODE", "", "TAG", "", "activity", "Landroid/app/Activity;", "chattingFooterLlMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Landroid/widget/LinearLayout;", "Lkotlin/collections/HashMap;", "commentAreaRvMap", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "hasJoinMsg", "", "heartBeatCookie", "Lcom/tencent/mm/protobuf/ByteString;", "isInMvPlayer", "isNewSession", "joinMsg", "lastOnlineCount", "Ljava/lang/Integer;", "lastOnlineCountTimestamp", "", "Ljava/lang/Long;", "lastSongId", "liveMsgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lkotlin/collections/ArrayList;", "mmHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "offline", "onlineCount", "onlineUserTimeMap", "getOnlineUserTimeMap", "()Ljava/util/HashMap;", "onlineUserTvMap", "Landroid/widget/TextView;", "playState", "postLiveMsgScene", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "userEnterTipTvMap", "addChattingFooter", "", "chattingFooter", "addCommentAreaRv", "commentAreaRv", "addOnlineUserTv", "onlineUserTv", "addUserEnterTipTv", "userEnterTipTv", "doHeartBeatScene", "doJoinScene", "onDestroy", "onHeartBeatCallback", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "onInit", "onMusicStart", "onMusicStop", "onMvMainUIEnter", "onMvMainUIExit", "onPostMsgEnd", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSessionEnd", "postLiveMsg", "toSendText", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "msg", "reportChattingRoomCopy", "commentId", "reportChattingRoomExpose", "reportChattingRoomPost", "State", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h
{
  private static final List<Long> ICS;
  public static boo LWI;
  public static final l LXJ;
  public static boolean LXK;
  public static String LXL;
  private static int LXM;
  private static boolean LXN;
  private static String LXO;
  private static Integer LXP;
  private static Long LXQ;
  private static final HashMap<Integer, Long> LXR;
  private static boolean LXS;
  private static b LXT;
  private static ArrayList<MusicMvCommentView.b> LXU;
  public static final HashMap<Integer, WeakReference<TextView>> LXV;
  public static final HashMap<Integer, WeakReference<TextView>> LXW;
  public static final HashMap<Integer, WeakReference<MusicMvCommentView>> LXX;
  public static final HashMap<Integer, WeakReference<LinearLayout>> LXY;
  private static r LXZ;
  public static int LYa;
  public static boolean LYb;
  public static Activity activity;
  private static final MMHandler tiG;
  
  static
  {
    AppMethodBeat.i(286205);
    LXJ = new l();
    LXK = true;
    LXL = "";
    LXO = "";
    LXR = new HashMap();
    List localList = Collections.synchronizedList((List)new ArrayList());
    kotlin.g.b.s.s(localList, "synchronizedList(ArrayList())");
    ICS = localList;
    LXU = new ArrayList();
    LXV = new HashMap();
    LXW = new HashMap();
    LXX = new HashMap();
    LXY = new HashMap();
    tiG = new MMHandler(Looper.getMainLooper(), l..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(286205);
  }
  
  public static void B(TextView paramTextView)
  {
    AppMethodBeat.i(286133);
    kotlin.g.b.s.u(paramTextView, "onlineUserTv");
    ((Map)LXV).put(Integer.valueOf(paramTextView.hashCode()), new WeakReference(paramTextView));
    AppMethodBeat.o(286133);
  }
  
  public static void C(TextView paramTextView)
  {
    AppMethodBeat.i(286140);
    kotlin.g.b.s.u(paramTextView, "userEnterTipTv");
    ((Map)LXW).put(Integer.valueOf(paramTextView.hashCode()), new WeakReference(paramTextView));
    AppMethodBeat.o(286140);
  }
  
  public static void a(f paramf, long paramLong)
  {
    AppMethodBeat.i(286118);
    boo localboo = LWI;
    Activity localActivity = activity;
    if ((localboo != null) && (localActivity != null))
    {
      o localo = o.LYk;
      o.b((Context)localActivity, localboo, paramf, 6, paramLong);
    }
    AppMethodBeat.o(286118);
  }
  
  public static void a(MusicMvCommentView paramMusicMvCommentView)
  {
    AppMethodBeat.i(286146);
    kotlin.g.b.s.u(paramMusicMvCommentView, "commentAreaRv");
    ((Map)LXX).put(Integer.valueOf(paramMusicMvCommentView.hashCode()), new WeakReference(paramMusicMvCommentView));
    paramMusicMvCommentView.bf(LXU);
    AppMethodBeat.o(286146);
  }
  
  private static void a(dsv paramdsv)
  {
    AppMethodBeat.i(286191);
    LXM = paramdsv.ZKz;
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramdsv.aaYu.iterator();
    Object localObject1;
    int i;
    while (localIterator.hasNext())
    {
      paramdsv = (dta)localIterator.next();
      localObject1 = paramdsv.aaYx;
      if ((localObject1 != null) && (((dsy)localObject1).type == 101))
      {
        i = 1;
        label75:
        if (i == 0) {
          break label142;
        }
        LXN = true;
        paramdsv = paramdsv.aaYx;
        if (paramdsv != null) {
          break label107;
        }
        paramdsv = "";
      }
      for (;;)
      {
        LXO = paramdsv;
        break;
        i = 0;
        break label75;
        label107:
        paramdsv = paramdsv.aaYw;
        if (paramdsv == null)
        {
          paramdsv = "";
        }
        else
        {
          localObject1 = paramdsv.content;
          paramdsv = (dsv)localObject1;
          if (localObject1 == null) {
            paramdsv = "";
          }
        }
      }
      label142:
      kotlin.g.b.s.s(paramdsv, "msgPack");
      localObject1 = new MusicMvCommentView.b(new MusicMvCommentView.d(paramdsv));
      if (ICS.contains(Long.valueOf(paramdsv.hCz)))
      {
        Log.i("MicroMsg.Mv.MvChattingDataManger", paramdsv.hCz + " is added, continue");
      }
      else
      {
        ICS.add(Long.valueOf(paramdsv.hCz));
        ((ArrayList)localObject2).add(localObject1);
      }
    }
    boolean bool;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i != 0) {
        LXU.addAll((Collection)localObject2);
      }
      paramdsv = activity;
      if (paramdsv == null) {
        break label1187;
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      paramdsv = com.tencent.mm.ui.component.k.nq((Context)paramdsv).q(e.class);
      kotlin.g.b.s.s(paramdsv, "UICProvider.of(it).get(MusicMvDataUIC::class.java)");
      if ((((e)paramdsv).MdX & 0x2) <= 0L) {
        break label440;
      }
      bool = true;
    }
    for (;;)
    {
      label326:
      Log.i("MicroMsg.Mv.MvChattingDataManger", "chatroom switch status:" + m.dsQ() + ", " + bool);
      if ((m.dsQ()) && (bool))
      {
        paramdsv = LXY.values();
        kotlin.g.b.s.s(paramdsv, "chattingFooterLlMap.values");
        paramdsv = ((Iterable)paramdsv).iterator();
        for (;;)
        {
          if (paramdsv.hasNext())
          {
            localObject1 = (LinearLayout)((WeakReference)paramdsv.next()).get();
            if (localObject1 != null)
            {
              ((LinearLayout)localObject1).setVisibility(0);
              continue;
              i = 0;
              break;
              label440:
              bool = false;
              break label326;
            }
          }
        }
        if (LXN)
        {
          if (((CharSequence)LXO).length() > 0) {
            i = 1;
          }
          while (i != 0)
          {
            paramdsv = LXV.values();
            kotlin.g.b.s.s(paramdsv, "onlineUserTvMap.values");
            paramdsv = ((Iterable)paramdsv).iterator();
            for (;;)
            {
              if (paramdsv.hasNext())
              {
                localObject1 = (TextView)((WeakReference)paramdsv.next()).get();
                if (localObject1 != null)
                {
                  ((TextView)localObject1).setVisibility(8);
                  continue;
                  i = 0;
                  break;
                }
              }
            }
            paramdsv = LXW.values();
            kotlin.g.b.s.s(paramdsv, "userEnterTipTvMap.values");
            paramdsv = ((Iterable)paramdsv).iterator();
            while (paramdsv.hasNext())
            {
              localObject1 = (TextView)((WeakReference)paramdsv.next()).get();
              if (localObject1 != null)
              {
                ((TextView)localObject1).setText((CharSequence)LXO);
                ((TextView)localObject1).setVisibility(0);
              }
            }
            tiG.removeCallbacksAndMessages(null);
            tiG.sendEmptyMessageDelayed(0, 2000L);
            paramdsv = LXX.values();
            kotlin.g.b.s.s(paramdsv, "commentAreaRvMap.values");
            paramdsv = ((Iterable)paramdsv).iterator();
          }
        }
      }
      for (;;)
      {
        label658:
        if (paramdsv.hasNext())
        {
          localObject1 = (WeakReference)paramdsv.next();
          if (!((Collection)LXU).isEmpty()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label935;
            }
            localObject2 = (MusicMvCommentView)((WeakReference)localObject1).get();
            if (localObject2 != null) {
              ((MusicMvCommentView)localObject2).setVisibility(0);
            }
            localObject1 = (MusicMvCommentView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              break label658;
            }
            ((MusicMvCommentView)localObject1).bf(LXU);
            break label658;
            paramdsv = LXV.values();
            kotlin.g.b.s.s(paramdsv, "onlineUserTvMap.values");
            localObject1 = ((Iterable)paramdsv).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (TextView)((WeakReference)((Iterator)localObject1).next()).get();
              if (localObject2 != null)
              {
                if (LXM <= 1) {}
                for (paramdsv = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_only_u_listening);; paramdsv = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_online_listener, new Object[] { Integer.valueOf(LXM) }))
                {
                  ((TextView)localObject2).setText(paramdsv);
                  ((TextView)localObject2).setVisibility(0);
                  break;
                }
              }
            }
            paramdsv = LXW.values();
            kotlin.g.b.s.s(paramdsv, "userEnterTipTvMap.values");
            paramdsv = ((Iterable)paramdsv).iterator();
            while (paramdsv.hasNext())
            {
              localObject1 = (TextView)((WeakReference)paramdsv.next()).get();
              if (localObject1 != null) {
                ((TextView)localObject1).setVisibility(8);
              }
            }
            break;
          }
          label935:
          continue;
          paramdsv = LXV.values();
          kotlin.g.b.s.s(paramdsv, "onlineUserTvMap.values");
          localObject1 = ((Iterable)paramdsv).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TextView)((WeakReference)((Iterator)localObject1).next()).get();
            if (localObject2 != null)
            {
              if (LXM <= 1) {}
              for (paramdsv = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_only_u_listening);; paramdsv = (CharSequence)MMApplicationContext.getContext().getString(b.h.music_online_listener, new Object[] { Integer.valueOf(LXM) }))
              {
                ((TextView)localObject2).setText(paramdsv);
                ((TextView)localObject2).setVisibility(0);
                break;
              }
            }
          }
        }
      }
      paramdsv = LXP;
      localObject1 = LXQ;
      if ((paramdsv != null) && (localObject1 != null))
      {
        long l1 = ((Number)localObject1).longValue();
        i = ((Number)paramdsv).intValue();
        localObject1 = (Long)LXR.get(Integer.valueOf(i));
        paramdsv = (dsv)localObject1;
        if (localObject1 == null) {
          paramdsv = Long.valueOf(0L);
        }
        long l2 = ((Number)paramdsv).longValue();
        long l3 = cn.bDw();
        ((Map)LXR).put(Integer.valueOf(i), Long.valueOf(l3 - l1 + l2));
      }
      LXP = Integer.valueOf(LXM);
      LXQ = Long.valueOf(cn.bDw());
      AppMethodBeat.o(286191);
      return;
      label1187:
      bool = false;
    }
  }
  
  private static void a(dta paramdta)
  {
    Object localObject1 = null;
    AppMethodBeat.i(286163);
    if ((0L == paramdta.hCz) || (paramdta.aaYx == null))
    {
      Log.e("MicroMsg.Mv.MvChattingDataManger", kotlin.g.b.s.X("onPostMsgEnd, null == msgPack.msg, msgid:", Long.valueOf(paramdta.hCz)));
      AppMethodBeat.o(286163);
      return;
    }
    Object localObject2 = new StringBuilder("onPostMsgEnd, msg.songId:").append(paramdta.aaXV).append(", content:");
    Object localObject3 = paramdta.aaYx;
    if (localObject3 == null) {}
    for (;;)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", localObject1);
      if (!ICS.contains(Long.valueOf(paramdta.hCz))) {
        break;
      }
      Log.i("MicroMsg.Mv.MvChattingDataManger", paramdta.hCz + " is added, continue");
      AppMethodBeat.o(286163);
      return;
      localObject3 = ((dsy)localObject3).aaYv;
      if (localObject3 != null) {
        localObject1 = ((dtb)localObject3).text;
      }
    }
    ICS.add(Long.valueOf(paramdta.hCz));
    paramdta = new MusicMvCommentView.b(new MusicMvCommentView.d(paramdta));
    LXU.add(paramdta);
    paramdta = LXX.values();
    kotlin.g.b.s.s(paramdta, "commentAreaRvMap.values");
    paramdta = ((Iterable)paramdta).iterator();
    label319:
    while (paramdta.hasNext())
    {
      localObject1 = (WeakReference)paramdta.next();
      if (!((Collection)LXU).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label319;
        }
        localObject2 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject2 != null) {
          ((MusicMvCommentView)localObject2).setVisibility(0);
        }
        localObject1 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break;
        }
        ((MusicMvCommentView)localObject1).bf(LXU);
        break;
      }
    }
    AppMethodBeat.o(286163);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(286109);
    kotlin.g.b.s.u(paramString, "toSendText");
    kotlin.g.b.s.u(paramf, "musicMv");
    Object localObject1 = LWI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((boo)localObject1).mLQ;
      if ((localObject1 != null) && (!Util.isNullOrNil(paramString)))
      {
        localObject2 = new dta();
        dsy localdsy = new dsy();
        localdsy.type = 1;
        localdsy.aaYv = new dtb();
        dtb localdtb = localdsy.aaYv;
        if (localdtb != null) {
          localdtb.text = paramString;
        }
        ((dta)localObject2).MUO = String.valueOf(cn.bDw());
        ((dta)localObject2).aaXV = ((String)localObject1);
        ((dta)localObject2).aaYz = z.bAO();
        ((dta)localObject2).aaYx = localdsy;
        ((dta)localObject2).createtime = ((int)(System.currentTimeMillis() / 1000L));
        paramString = f.LXf;
        paramString = f.a.b(paramf);
        if (paramString != null)
        {
          ((dta)localObject2).aaYB = paramString.id;
          ((dta)localObject2).mdD = paramString.objectNonceId;
          paramString = paramString.contact;
          if (paramString != null) {
            break label312;
          }
          paramString = "";
        }
      }
    }
    for (;;)
    {
      ((dta)localObject2).aaYC = paramString;
      Log.i("MicroMsg.Mv.MvChattingDataManger", "postLiveMsg msg.objectId:" + ((dta)localObject2).aaYB + " msg.objectNonceId:" + ((dta)localObject2).mdD);
      paramString = LXZ;
      if (paramString != null) {
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString);
      }
      paramString = LWI;
      if (paramString != null)
      {
        LXZ = new r((dta)localObject2, paramString);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)LXZ, 0);
      }
      paramString = LWI;
      localObject1 = activity;
      if ((paramString != null) && (localObject1 != null))
      {
        localObject2 = o.LYk;
        o.b((Context)localObject1, paramString, paramf, 1, 0L);
      }
      AppMethodBeat.o(286109);
      return;
      label312:
      localObject1 = paramString.nickname;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
    }
  }
  
  public static void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(286126);
    boo localboo = LWI;
    Activity localActivity = activity;
    if ((localboo != null) && (localActivity != null))
    {
      o localo = o.LYk;
      o.b((Context)localActivity, localboo, paramf, 7, paramLong);
    }
    AppMethodBeat.o(286126);
  }
  
  public static void e(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(286151);
    kotlin.g.b.s.u(paramLinearLayout, "chattingFooter");
    ((Map)LXY).put(Integer.valueOf(paramLinearLayout.hashCode()), new WeakReference(paramLinearLayout));
    AppMethodBeat.o(286151);
  }
  
  public static HashMap<Integer, Long> gpG()
  {
    return LXR;
  }
  
  public static void gpH()
  {
    Object localObject2 = null;
    AppMethodBeat.i(286082);
    StringBuilder localStringBuilder = new StringBuilder("onMusicStart, songName:");
    Object localObject1 = LWI;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", singer:");
      localObject1 = LWI;
      if (localObject1 != null) {
        break label84;
      }
    }
    label84:
    for (localObject1 = localObject2;; localObject1 = ((boo)localObject1).rDl)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", localObject1);
      LYa = 1;
      AppMethodBeat.o(286082);
      return;
      localObject1 = ((boo)localObject1).songName;
      break;
    }
  }
  
  public static void gpI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(286093);
    StringBuilder localStringBuilder = new StringBuilder("onSessionEnd, songName:");
    Object localObject1 = LWI;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", singer:");
      localObject1 = LWI;
      if (localObject1 != null) {
        break label94;
      }
    }
    label94:
    for (localObject1 = localObject2;; localObject1 = ((boo)localObject1).rDl)
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", localObject1);
      zQ(true);
      LXU.clear();
      LXK = true;
      AppMethodBeat.o(286093);
      return;
      localObject1 = ((boo)localObject1).songName;
      break;
    }
  }
  
  private static final boolean s(Message paramMessage)
  {
    AppMethodBeat.i(286198);
    kotlin.g.b.s.u(paramMessage, "it");
    if (paramMessage.what == 0)
    {
      LXN = false;
      LXO = "";
      paramMessage = LXV.values();
      kotlin.g.b.s.s(paramMessage, "onlineUserTvMap.values");
      paramMessage = ((Iterable)paramMessage).iterator();
      TextView localTextView;
      while (paramMessage.hasNext())
      {
        localTextView = (TextView)((WeakReference)paramMessage.next()).get();
        if (localTextView != null) {
          localTextView.setVisibility(0);
        }
      }
      paramMessage = LXW.values();
      kotlin.g.b.s.s(paramMessage, "userEnterTipTvMap.values");
      paramMessage = ((Iterable)paramMessage).iterator();
      while (paramMessage.hasNext())
      {
        localTextView = (TextView)((WeakReference)paramMessage.next()).get();
        if (localTextView != null) {
          localTextView.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(286198);
    return false;
  }
  
  private static void zQ(boolean paramBoolean)
  {
    AppMethodBeat.i(286155);
    LXS = paramBoolean;
    Object localObject = LWI;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((boo)localObject).mLQ)
    {
      b localb = LXT;
      if ((localObject != null) && (localb != null))
      {
        localObject = new com.tencent.mm.plugin.mv.model.a.p((String)localObject, localb, paramBoolean);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
      AppMethodBeat.o(286155);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Context localContext = null;
    AppMethodBeat.i(286226);
    if ((paramp instanceof q))
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvJoin, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((q)paramp).LZu;
        if (paramString != null)
        {
          LXT = paramString.cookie;
          paramp = LWI;
          if (paramp != null) {
            paramp.mLQ = paramString.aaXV;
          }
          zQ(false);
          paramString = LWI;
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.mLQ)
          {
            Log.i("MicroMsg.Mv.MvChattingDataManger", kotlin.g.b.s.X("NetSceneMusicMvJoin songId:", paramString));
            AppMethodBeat.o(286226);
            return;
          }
        }
      }
    }
    else if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.p))
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvHeartbeat, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!LXS))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.p)paramp).LZr;
        if (paramString != null) {
          a(paramString);
        }
        paramString = ((com.tencent.mm.plugin.mv.model.a.p)paramp).LZr;
        if (paramString == null) {}
        for (paramString = localContext;; paramString = paramString.cookie)
        {
          LXT = paramString;
          zQ(false);
          AppMethodBeat.o(286226);
          return;
        }
      }
    }
    else if (((paramp instanceof r)) && (kotlin.g.b.s.p(paramp, LXZ)))
    {
      Log.i("MicroMsg.Mv.MvChattingDataManger", "NetSceneMusicMvPostLiveMsg, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((r)paramp).LZx;
        if (paramString != null)
        {
          paramString = paramString.aaYD;
          if (paramString != null) {
            a(paramString);
          }
          AppMethodBeat.o(286226);
        }
      }
      else if (!Util.isNullOrNil(paramString))
      {
        localContext = (Context)activity;
        paramp = activity;
        if (paramp == null) {}
        for (paramp = null;; paramp = paramp.getString(b.h.app_i_known))
        {
          com.tencent.mm.ui.base.k.a(localContext, paramString, "", paramp, null);
          AppMethodBeat.o(286226);
          return;
        }
      }
    }
    else
    {
      Log.e("MicroMsg.Mv.MvChattingDataManger", kotlin.g.b.s.X("invalid: Scene", paramp));
    }
    AppMethodBeat.o(286226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.l
 * JD-Core Version:    0.7.0.1
 */