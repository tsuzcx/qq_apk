package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mv.a.a.j;
import com.tencent.mm.plugin.mv.a.a.k;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.b;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView.d;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvChattingUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "commentAreaRvMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Lkotlin/collections/HashMap;", "getCommentAreaRvMap", "()Ljava/util/HashMap;", "hasJoinMsg", "", "getHasJoinMsg", "()Z", "setHasJoinMsg", "(Z)V", "heartBeatCookie", "Lcom/tencent/mm/protobuf/ByteString;", "joinMsg", "", "getJoinMsg", "()Ljava/lang/String;", "setJoinMsg", "(Ljava/lang/String;)V", "lastOnlineCount", "getLastOnlineCount", "()Ljava/lang/Integer;", "setLastOnlineCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastOnlineCountTimestamp", "", "getLastOnlineCountTimestamp", "()Ljava/lang/Long;", "setLastOnlineCountTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;)V", "liveMsgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lkotlin/collections/ArrayList;", "getLiveMsgList", "()Ljava/util/ArrayList;", "setLiveMsgList", "(Ljava/util/ArrayList;)V", "mmHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMmHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "offline", "onlineCount", "getOnlineCount", "()I", "setOnlineCount", "(I)V", "onlineUserTimeMap", "getOnlineUserTimeMap", "onlineUserTvMap", "Landroid/widget/TextView;", "getOnlineUserTvMap", "postLiveMsgScene", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "songId", "userEnterTipTvMap", "getUserEnterTipTvMap", "addCommentAreaRv", "", "commentAreaRv", "addOnlineUserTv", "onlineUserTv", "addUserEnterTipTv", "userEnterTipTv", "doHeartBeatScene", "doJoinScene", "minHeight", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onHeartBeatCallback", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "onPostMsgEnd", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLiveMsg", "msg", "toSendText", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "Companion", "plugin-mv_release"})
public final class MusicMvChattingUIC
  extends UIComponent
  implements i
{
  public static final a Ate;
  private static final int minHeight;
  String AqO;
  private boolean AqQ;
  private b AsR;
  private int AsS;
  boolean AsT;
  String AsU;
  private ArrayList<MusicMvCommentView.b> AsV;
  private Integer AsW;
  public final HashMap<Integer, Long> AsY;
  public com.tencent.mm.plugin.mv.ui.uic.a.a AsZ;
  com.tencent.mm.plugin.mv.a.a.l Ata;
  public final HashMap<Integer, WeakReference<TextView>> Atb;
  public final HashMap<Integer, WeakReference<TextView>> Atc;
  public final HashMap<Integer, WeakReference<MusicMvCommentView>> Atd;
  private Long UqZ;
  private final IListener<?> lEl;
  private final MMHandler ndA;
  
  static
  {
    AppMethodBeat.i(257095);
    Ate = new a((byte)0);
    minHeight = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131165298);
    AppMethodBeat.o(257095);
  }
  
  public MusicMvChattingUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257094);
    this.AsU = "";
    this.AsV = new ArrayList();
    this.AsY = new HashMap();
    this.ndA = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new b(this));
    this.Atb = new HashMap();
    this.Atc = new HashMap();
    this.Atd = new HashMap();
    this.lEl = ((IListener)new MusicMvChattingUIC.c(this, paramAppCompatActivity));
    AppMethodBeat.o(257094);
  }
  
  private final void a(csf paramcsf)
  {
    AppMethodBeat.i(257093);
    this.AsS = paramcsf.LDO;
    Object localObject1 = new ArrayList();
    paramcsf = paramcsf.Mxo.iterator();
    Object localObject2;
    while (paramcsf.hasNext())
    {
      localObject2 = (csk)paramcsf.next();
      if (((csk)localObject2).Mxr.type == 101)
      {
        this.AsT = true;
        localObject2 = ((csk)localObject2).Mxr.Mxq.content;
        p.g(localObject2, "msgPack.msg.Join.content");
        this.AsU = ((String)localObject2);
      }
      else
      {
        p.g(localObject2, "msgPack");
        ((ArrayList)localObject1).add(new MusicMvCommentView.b(new MusicMvCommentView.d((csk)localObject2)));
      }
    }
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i != 0) {
        this.AsV.addAll((Collection)localObject1);
      }
      if (!com.tencent.mm.plugin.music.model.m.cAJ()) {
        break label705;
      }
      if (!this.AsT) {
        break label492;
      }
      if (((CharSequence)this.AsU).length() != 0) {
        break label268;
      }
      i = 1;
    }
    label268:
    for (;;)
    {
      label193:
      if (i == 0)
      {
        paramcsf = this.Atb.values();
        p.g(paramcsf, "onlineUserTvMap.values");
        paramcsf = ((Iterable)paramcsf).iterator();
        for (;;)
        {
          if (paramcsf.hasNext())
          {
            localObject1 = (TextView)((WeakReference)paramcsf.next()).get();
            if (localObject1 != null)
            {
              ((TextView)localObject1).setVisibility(8);
              continue;
              i = 0;
              break;
              i = 0;
              break label193;
            }
          }
        }
        paramcsf = this.Atc.values();
        p.g(paramcsf, "userEnterTipTvMap.values");
        paramcsf = ((Iterable)paramcsf).iterator();
        while (paramcsf.hasNext())
        {
          localObject1 = (TextView)((WeakReference)paramcsf.next()).get();
          if (localObject1 != null)
          {
            p.g(localObject1, "it");
            ((TextView)localObject1).setText((CharSequence)this.AsU);
            ((TextView)localObject1).setVisibility(0);
          }
        }
        this.ndA.removeCallbacksAndMessages(null);
        this.ndA.sendEmptyMessageDelayed(0, 2000L);
        paramcsf = this.Atd.values();
        p.g(paramcsf, "commentAreaRvMap.values");
        paramcsf = ((Iterable)paramcsf).iterator();
      }
    }
    label403:
    label703:
    for (;;)
    {
      if (!paramcsf.hasNext()) {
        break label847;
      }
      localObject1 = (WeakReference)paramcsf.next();
      if (!((Collection)this.AsV).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label703;
        }
        localObject2 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject2 != null) {
          ((MusicMvCommentView)localObject2).setVisibility(0);
        }
        localObject1 = (MusicMvCommentView)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break label403;
        }
        ((MusicMvCommentView)localObject1).aE(this.AsV);
        break label403;
        label492:
        paramcsf = this.Atb.values();
        p.g(paramcsf, "onlineUserTvMap.values");
        paramcsf = ((Iterable)paramcsf).iterator();
        while (paramcsf.hasNext())
        {
          localObject1 = (TextView)((WeakReference)paramcsf.next()).get();
          if (localObject1 != null)
          {
            if (this.AsS <= 1)
            {
              p.g(localObject1, "it");
              ((TextView)localObject1).setText((CharSequence)getActivity().getString(2131763386));
            }
            for (;;)
            {
              ((TextView)localObject1).setVisibility(0);
              break;
              p.g(localObject1, "it");
              ((TextView)localObject1).setText((CharSequence)getActivity().getString(2131763385, new Object[] { Integer.valueOf(this.AsS) }));
            }
          }
        }
        paramcsf = this.Atc.values();
        p.g(paramcsf, "userEnterTipTvMap.values");
        paramcsf = ((Iterable)paramcsf).iterator();
        while (paramcsf.hasNext())
        {
          localObject1 = (TextView)((WeakReference)paramcsf.next()).get();
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
        }
        break;
      }
    }
    label705:
    paramcsf = this.Atb.values();
    p.g(paramcsf, "onlineUserTvMap.values");
    paramcsf = ((Iterable)paramcsf).iterator();
    while (paramcsf.hasNext())
    {
      localObject1 = (TextView)((WeakReference)paramcsf.next()).get();
      if (localObject1 != null)
      {
        if (this.AsS <= 1)
        {
          p.g(localObject1, "it");
          ((TextView)localObject1).setText((CharSequence)getActivity().getString(2131763386));
        }
        for (;;)
        {
          ((TextView)localObject1).setVisibility(0);
          break;
          p.g(localObject1, "it");
          ((TextView)localObject1).setText((CharSequence)getActivity().getString(2131763385, new Object[] { Integer.valueOf(this.AsS) }));
        }
      }
    }
    label847:
    paramcsf = this.AsW;
    localObject1 = this.UqZ;
    if ((paramcsf != null) && (localObject1 != null))
    {
      long l1 = ((Number)localObject1).longValue();
      i = ((Number)paramcsf).intValue();
      localObject1 = (Long)this.AsY.get(Integer.valueOf(i));
      paramcsf = (csf)localObject1;
      if (localObject1 == null) {
        paramcsf = Long.valueOf(0L);
      }
      p.g(paramcsf, "onlineUserTimeMap[lastOnlineCount] ?: 0L");
      long l2 = paramcsf.longValue();
      long l3 = cl.aWA();
      ((Map)this.AsY).put(Integer.valueOf(i), Long.valueOf(l3 - l1 + l2));
    }
    this.AsW = Integer.valueOf(this.AsS);
    this.UqZ = Long.valueOf(cl.aWA());
    AppMethodBeat.o(257093);
  }
  
  private final void a(csk paramcsk)
  {
    AppMethodBeat.i(257092);
    paramcsk = new MusicMvCommentView.b(new MusicMvCommentView.d(paramcsk));
    this.AsV.add(paramcsk);
    paramcsk = this.Atd.values();
    p.g(paramcsk, "commentAreaRvMap.values");
    paramcsk = ((Iterable)paramcsk).iterator();
    label142:
    while (paramcsk.hasNext())
    {
      Object localObject = (WeakReference)paramcsk.next();
      if (!((Collection)this.AsV).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label142;
        }
        MusicMvCommentView localMusicMvCommentView = (MusicMvCommentView)((WeakReference)localObject).get();
        if (localMusicMvCommentView != null) {
          localMusicMvCommentView.setVisibility(0);
        }
        localObject = (MusicMvCommentView)((WeakReference)localObject).get();
        if (localObject == null) {
          break;
        }
        ((MusicMvCommentView)localObject).aE(this.AsV);
        break;
      }
    }
    AppMethodBeat.o(257092);
  }
  
  private final void gFl()
  {
    AppMethodBeat.i(258897);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = new k(((MusicMvDataUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class)).Aqo, getActivity().hashCode());
    g.azz().b((q)localObject);
    AppMethodBeat.o(258897);
  }
  
  private final void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(257090);
    this.AqQ = paramBoolean;
    Object localObject = this.AqO;
    if (localObject != null)
    {
      b localb = this.AsR;
      if (localb != null)
      {
        localObject = new j((String)localObject, localb, paramBoolean, getActivity().hashCode());
        g.azz().b((q)localObject);
        AppMethodBeat.o(257090);
        return;
      }
      AppMethodBeat.o(257090);
      return;
    }
    AppMethodBeat.o(257090);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257087);
    super.onCreate(paramBundle);
    g.azz().a(6893, (i)this);
    g.azz().a(6820, (i)this);
    g.azz().a(6672, (i)this);
    this.lEl.alive();
    AppMethodBeat.o(257087);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(257088);
    gFl();
    AppMethodBeat.o(257088);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257089);
    g.azz().b(6893, (i)this);
    g.azz().b(6820, (i)this);
    g.azz().b(6672, (i)this);
    sr(true);
    this.lEl.dead();
    super.onDestroy();
    AppMethodBeat.o(257089);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257091);
    if (((paramq instanceof com.tencent.mm.plugin.mv.a.a.m)) && (((com.tencent.mm.plugin.mv.a.a.m)paramq).NoN != 0) && (((com.tencent.mm.plugin.mv.a.a.m)paramq).NoN != getActivity().hashCode()))
    {
      Log.i("MicroMsg.Mv.MusicMvChattingUIC", "not the same page of netscene");
      AppMethodBeat.o(257091);
      return;
    }
    if ((paramq instanceof j))
    {
      Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvHeartbeat, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!this.AqQ))
      {
        paramString = ((j)paramq).AqN;
        if (paramString != null) {
          a(paramString);
        }
        paramString = ((j)paramq).AqN;
        if (paramString != null) {}
        for (paramString = paramString.AqP;; paramString = null)
        {
          this.AsR = paramString;
          sr(false);
          AppMethodBeat.o(257091);
          return;
        }
      }
    }
    else if ((paramq instanceof k))
    {
      Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvJoin, errCode:" + paramInt2 + ", errType:" + paramInt1 + ", errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((k)paramq).AqT;
        if (paramString != null)
        {
          this.AsR = paramString.AqP;
          this.AqO = paramString.MwX;
          sr(false);
          Log.i("MicroMsg.Mv.MusicMvChattingUIC", "NetSceneMusicMvJoin songId:" + this.AqO);
          AppMethodBeat.o(257091);
          return;
        }
        AppMethodBeat.o(257091);
      }
    }
    else if (((paramq instanceof com.tencent.mm.plugin.mv.a.a.l)) && (p.j(paramq, this.Ata)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.a.a.l)paramq).AqW;
        if (paramString != null)
        {
          paramString = paramString.Mxx;
          p.g(paramString, "it.msg");
          a(paramString);
          AppMethodBeat.o(257091);
          return;
        }
        AppMethodBeat.o(257091);
      }
    }
    else
    {
      Log.e("MicroMsg.Mv.MusicMvChattingUIC", "invalid: Scene".concat(String.valueOf(paramq)));
    }
    AppMethodBeat.o(257091);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvChattingUIC$Companion;", "", "()V", "TAG", "", "minHeight", "", "plugin-mv_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    b(MusicMvChattingUIC paramMusicMvChattingUIC) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(257086);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(257086);
        return false;
        this.Atf.AsT = false;
        paramMessage = this.Atf;
        p.h("", "<set-?>");
        paramMessage.AsU = "";
        paramMessage = this.Atf.Atb.values();
        p.g(paramMessage, "onlineUserTvMap.values");
        paramMessage = ((Iterable)paramMessage).iterator();
        TextView localTextView;
        while (paramMessage.hasNext())
        {
          localTextView = (TextView)((WeakReference)paramMessage.next()).get();
          if (localTextView != null) {
            localTextView.setVisibility(0);
          }
        }
        paramMessage = this.Atf.Atc.values();
        p.g(paramMessage, "userEnterTipTvMap.values");
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
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC
 * JD-Core Version:    0.7.0.1
 */