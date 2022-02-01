package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.u;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.v.a;
import com.tencent.mm.plugin.multitalk.model.w;
import com.tencent.mm.plugin.multitalk.ui.widget.CollapseView;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView.e;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.n.d;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.plugin.multitalk.ui.widget.p.11;
import com.tencent.mm.plugin.multitalk.ui.widget.p.2;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, d.a, com.tencent.mm.plugin.multitalk.model.e
{
  protected MMHandler czp;
  private boolean iGD;
  private Notification kYy;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private com.tencent.mm.plugin.voip.a.b yyX;
  private boolean zPH;
  public com.tencent.mm.plugin.multitalk.ui.widget.g zPI;
  public com.tencent.mm.plugin.multitalk.ui.widget.p zPJ;
  public k zPK;
  private boolean zPL;
  private boolean zPM;
  boolean zPN;
  private MultiTalkMainUI.ScreenActionReceiver zPO;
  private boolean zPP;
  private ViewTreeObserver.OnGlobalLayoutListener zPQ;
  private Runnable zPR;
  private boolean zPS;
  public boolean zPT;
  private BroadcastReceiver zPU;
  MMHandler zPV;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.zPL = true;
    this.zPM = false;
    this.zPN = false;
    this.zPP = true;
    this.iGD = false;
    this.zPQ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(239433);
        int i;
        boolean bool;
        if (au.aA(MultiTalkMainUI.this.getContext()))
        {
          i = au.aD(MultiTalkMainUI.this.getContext());
          bool = true;
        }
        for (;;)
        {
          if (MultiTalkMainUI.a(MultiTalkMainUI.this) != bool)
          {
            MultiTalkMainUI.a(MultiTalkMainUI.this, bool);
            com.tencent.mm.plugin.multitalk.ui.widget.p localp = MultiTalkMainUI.b(MultiTalkMainUI.this);
            if ((localp.zUA != null) && (localp.zUA.findViewById(2131307159) != null))
            {
              Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "applyBottomMarin %s", new Object[] { Integer.valueOf(i) });
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localp.zUA.findViewById(2131307159).getLayoutParams();
              localLayoutParams.bottomMargin = i;
              localp.zUA.findViewById(2131307159).setLayoutParams(localLayoutParams);
            }
          }
          AppMethodBeat.o(239433);
          return;
          bool = false;
          i = 0;
        }
      }
    };
    this.zPR = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(239437);
        Object localObject = ac.eom();
        if (((q)localObject).zNf) {}
        for (boolean bool = false;; bool = v.Rl(((q)localObject).zMx))
        {
          if ((bool) && (!ac.eom().zMz) && (!ac.eoo().emo())) {
            MultiTalkMainUI.b(MultiTalkMainUI.this).rZ(true);
          }
          if (ac.eom().zMF != null)
          {
            localObject = ac.eom().zMF;
            if ((((com.tencent.mm.plugin.multitalk.model.z)localObject).zOt) || (((com.tencent.mm.plugin.multitalk.model.z)localObject).zOu)) {
              i = 1;
            }
            if (i != 0) {}
          }
          else
          {
            ac.eom().enM();
            ac.eom().enL();
          }
          AppMethodBeat.o(239437);
          return;
        }
      }
    };
    this.zPS = false;
    this.zPT = false;
    this.zPU = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(239441);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (ac.eom().zMD == o.zUd))
        {
          ac.eom().stopRing();
          MultiTalkMainUI.c(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(239441);
      }
    };
    this.zPV = new MultiTalkMainUI.3(this);
    AppMethodBeat.o(114663);
  }
  
  public final void a(v.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == v.a.zNO)
    {
      ac.eok().at(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == v.a.zNP)
    {
      ac.eok().as(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == v.a.zNQ) {
      com.tencent.mm.bh.e.a(this, 2131767334, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(114686);
    if (paramo == o.zUg)
    {
      paramo = this.zPJ;
      if (paramo.zUL > 0L) {
        paramo.zUL = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final void aFS(String paramString)
  {
    AppMethodBeat.i(239450);
    k localk;
    cz localcz;
    if (this.zPK != null)
    {
      localk = this.zPK;
      kotlin.g.b.p.h(paramString, "path");
      localcz = new cz();
      if (!Util.isNullOrNil(paramString)) {
        break label94;
      }
      Log.w("MicroMsg.MultiTalkScreenProjectUILogic", "fill favorite event fail, event is null or image path is empty");
      localcz.dFZ.dGe = 2131759209;
    }
    for (;;)
    {
      localcz.dFZ.activity = ((Activity)localk.zSH);
      localcz.dFZ.dGf = 6;
      EventCenter.instance.publish((IEvent)localcz);
      AppMethodBeat.o(239450);
      return;
      label94:
      Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(2) });
      anb localanb = new anb();
      anh localanh = new anh();
      aml localaml = new aml();
      localaml.ajd(2);
      localaml.bgt(paramString);
      Object localObject = localaml.toString() + 2 + System.currentTimeMillis();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(239450);
        throw paramString;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      kotlin.g.b.p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localaml.bgs(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      localObject = new hb();
      ((hb)localObject).dLm.type = 27;
      ((hb)localObject).dLm.dLo = localaml;
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((hb)localObject).dLn.thumbPath;
      BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
      localaml.bgu((String)localObject);
      localanh.bhf(com.tencent.mm.model.z.aTY());
      localanh.bhg(com.tencent.mm.model.z.aTY());
      localanh.ajm(2);
      localanh.MA(Util.nowMilliSecond());
      localanb.a(localanh);
      localanb.ppH.add(localaml);
      localcz.dFZ.title = localaml.title;
      localcz.dFZ.dGb = localanb;
      localcz.dFZ.type = 2;
    }
  }
  
  public final void aFT(String paramString)
  {
    AppMethodBeat.i(239451);
    if (this.zPK != null)
    {
      k localk = this.zPK;
      kotlin.g.b.p.h(paramString, "imgPath");
      Object localObject = new Intent();
      ((Intent)localObject).setClassName((Context)localk.zSH, "com.tencent.mm.ui.transmit.MsgRetransmitUI");
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", 1);
      paramString = localk.zSH;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(239451);
  }
  
  public final ViewGroup chG()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131307175);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void dZZ()
  {
    AppMethodBeat.i(114675);
    if (!eov())
    {
      mu localmu = new mu();
      localmu.dSs.action = 0;
      EventCenter.instance.publish(localmu);
      this.zPJ.sb(true);
      ac.eom().stopRing();
      finish();
    }
    ac.eom().zLR = null;
    ac.eoo().zLR = null;
    AppMethodBeat.o(114675);
  }
  
  public final void eaa()
  {
    AppMethodBeat.i(114688);
    com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
    Object localObject1 = localp.timeTV;
    long l = ac.eom().zMJ;
    ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
    Object localObject4 = localp.zMZ;
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject5 = ((q)localObject1).zMC;
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    List localList = ((q)localObject1).elR();
    localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).zKS;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).zQI;
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).zHg.RHb;
          kotlin.g.b.p.g(localObject1, "it.member.usrName");
          localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).aFA((String)localObject1);
          if (localObject1 != null)
          {
            int i;
            if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT != null)
            {
              i = 1;
              label207:
              if (i == 0) {
                break label351;
              }
              label211:
              if (localObject1 == null) {
                break label355;
              }
              localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
              if (localObject2 != null)
              {
                localObject3 = ((MultitalkFrameView)localObject2).getUsername();
                localObject2 = localObject3;
                if (localObject3 != null) {}
              }
              else
              {
                localObject2 = "";
              }
              if (!kotlin.g.b.p.j(com.tencent.mm.model.z.aTY(), localObject2)) {
                break label357;
              }
              localObject3 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).zKQ;
              if ((localObject3 == null) || (((com.tencent.mm.plugin.multitalk.model.b)localObject3).emo() != true)) {
                break label357;
              }
              localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQU;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
            }
            for (;;)
            {
              localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQT;
              if ((localObject1 == null) || (!((MultitalkFrameView)localObject1).qvn)) {
                break;
              }
              com.tencent.f.h.RTc.aV((Runnable)new MultitalkFrameView.e((MultitalkFrameView)localObject1));
              break;
              i = 0;
              break label207;
              label351:
              localObject1 = null;
              break label211;
              label355:
              break;
              label357:
              if ((localList != null) && (localList.contains(localObject2) == true) && (localObject5 != null) && (!((HashSet)localObject5).contains(localObject2)))
              {
                localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQU;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
              }
              else
              {
                localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).zQU;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
    if (localList != null) {
      com.tencent.mm.plugin.multitalk.model.p.Rf(localList.size());
    }
    Object localObject3 = localp.zMZ;
    localObject4 = ac.eom();
    kotlin.g.b.p.g(localObject4, "SubCoreMultiTalk.getMultiTalkManager()");
    Object localObject2 = ((q)localObject4).zME.zHD;
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = ((q)localObject4).zME.RGY;
    }
    boolean bool = ((q)localObject4).aFW(((q)localObject4).zME.zHE);
    Log.d("MicroMsg.MT.MultiTalkManager", "getWeakNetworkMember: %s, groupid:%s, isILink:%b", new Object[] { v.g(((q)localObject4).zME), ((q)localObject4).zME.zHE, Boolean.valueOf(bool) });
    new ArrayList();
    if (bool)
    {
      localObject1 = com.tencent.mm.plugin.multitalk.b.p.zHS.elT();
      localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).zKS;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject2).zQI;
        if (localObject2 != null) {
          localObject2 = ((Iterable)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label875;
        }
        localObject4 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject2).next();
        if (((List)localObject1).contains(((com.tencent.mm.plugin.multitalk.data.a)localObject4).zHg.RHb) == true)
        {
          localObject5 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).zHg.RHb;
          kotlin.g.b.p.g(localObject5, "it.member.usrName");
          localObject5 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aFA((String)localObject5);
          if (localObject5 != null)
          {
            localObject5 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject5).zQV;
            if (localObject5 != null) {
              ((ImageView)localObject5).setVisibility(0);
            }
          }
          bool = kotlin.g.b.p.j(com.tencent.mm.model.z.aTY(), ((com.tencent.mm.plugin.multitalk.data.a)localObject4).zHg.RHb);
          com.tencent.mm.plugin.multitalk.model.p.rC(bool);
          if (!bool) {
            continue;
          }
          localObject4 = ac.eon();
          if ((((n)localObject4).zTM == null) || (((n)localObject4).zTO)) {
            continue;
          }
          com.tencent.f.h.RTc.bqo("showIcon");
          com.tencent.f.h.RTc.b((Runnable)new n.d((n)localObject4), "showIcon");
          continue;
          if (w.zNS == null) {
            w.zNS = new w();
          }
          localObject1 = w.zNS.aGl((String)localObject1);
          break;
        }
        localObject4 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).zHg.RHb;
        kotlin.g.b.p.g(localObject4, "it.member.usrName");
        localObject4 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aFA((String)localObject4);
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).zQV;
          if (localObject4 != null) {
            ((ImageView)localObject4).setVisibility(8);
          }
        }
      }
    }
    label875:
    if (localp.zUI != null)
    {
      localObject1 = localp.zUI.zYA;
      if (localObject1 != null)
      {
        localObject1 = ((j)localObject1).zWE;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject1).eaa();
        }
      }
    }
    localObject1 = this.zPK;
    localObject2 = ((k)localObject1).zTw;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.f)localObject2).eaa();
    }
    localObject1 = ((k)localObject1).zTx;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject1).eaa();
    }
    ac.eoo().emE();
    AppMethodBeat.o(114688);
  }
  
  public final void eie()
  {
    AppMethodBeat.i(114674);
    this.zPI.eoG();
    this.zPJ.n(ac.eom().zME);
    AppMethodBeat.o(114674);
  }
  
  public final boolean emo()
  {
    AppMethodBeat.i(114689);
    if (this.zPJ != null)
    {
      boolean bool = ac.eoo().emo();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final void emt()
  {
    AppMethodBeat.i(114676);
    this.iGD = true;
    Object localObject = ac.eom();
    if (((q)localObject).zMV != null) {
      ((q)localObject).zMV.P(false, 1);
    }
    localObject = new mu();
    ((mu)localObject).dSs.action = 0;
    EventCenter.instance.publish((IEvent)localObject);
    this.czp.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239439);
        MultiTalkMainUI.b(MultiTalkMainUI.this).sb(false);
        AppMethodBeat.o(239439);
      }
    });
    if (this.zPK != null)
    {
      localObject = com.tencent.mm.plugin.multitalk.d.f.zZd;
      com.tencent.mm.plugin.multitalk.d.f.eqn();
      this.zPK.emx();
    }
    ac.eom().zLR = null;
    ac.eoo().zLR = null;
    ac.eom().stopRing();
    localObject = ac.eom();
    if (((q)localObject).zMV != null) {
      ((q)localObject).zMV.elB();
    }
    if (ac.eom().zMV != null) {
      com.tencent.mm.plugin.multitalk.a.a.unInit();
    }
    ac.eoo().release();
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void emu()
  {
    AppMethodBeat.i(114673);
    switch (4.zPX[ac.eom().zMD.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.zPJ.n(ac.eom().zME);
      AppMethodBeat.o(114673);
      return;
      this.zPI.m(ac.eom().zME);
    }
  }
  
  public final void emv()
  {
    AppMethodBeat.i(114678);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + ac.eom().zMC.size());
    Object localObject;
    if (ac.eom().ent())
    {
      localObject = ac.eom().zMC;
      if (((HashSet)localObject).size() <= 0) {
        break label143;
      }
      if ((((HashSet)localObject).size() != 1) || (!((HashSet)localObject).contains(com.tencent.mm.model.z.aTY()))) {
        break label134;
      }
      ac.eom().enM();
    }
    for (;;)
    {
      localObject = this.zPJ;
      HashSet localHashSet = new HashSet(ac.eom().zMC);
      if (v.Rm(ac.eom().zMx)) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).d(localHashSet);
      }
      com.tencent.mm.plugin.multitalk.model.p.Rg(localHashSet.size());
      AppMethodBeat.o(114678);
      return;
      label134:
      ac.eom().enL();
      continue;
      label143:
      localObject = ac.eom();
      Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
      if (((q)localObject).zMF != null) {
        ((q)localObject).zMF.stopVideo();
      }
    }
  }
  
  public final void emw()
  {
    AppMethodBeat.i(239445);
    this.zPJ.rY(true);
    AppMethodBeat.o(239445);
  }
  
  public final void emx()
  {
    AppMethodBeat.i(239447);
    setRequestedOrientation(1);
    Object localObject = com.tencent.mm.plugin.multitalk.d.f.zZd;
    com.tencent.mm.plugin.multitalk.d.f.eqo();
    ac.eom().zMz = false;
    ac.eom().zMA = false;
    getIntent().removeExtra("enterMainUIScreenProjectOnline");
    getIntent().removeExtra("enterMainUIScreenProjectParams");
    this.zPK.emx();
    ac.eom().aF(1, false);
    this.zPJ.emg();
    localObject = this.zPJ;
    if (((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zUD) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zUA.setVisibility(0);
    }
    this.zPJ.zUi.setVisibility(0);
    com.tencent.mm.plugin.multitalk.ui.widget.p.eoQ();
    this.zPJ.n(ac.eom().zME);
    localObject = this.zPJ;
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zUm.setVisibility(0);
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zUl.setVisibility(0);
    if ((ac.eom().ent()) && (this.czp != null))
    {
      localObject = this.zPJ;
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zMZ.a(((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zKN, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zKO, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).zSH, (com.tencent.mm.plugin.multitalk.model.b)localObject);
      ac.eom().enN();
    }
    AppMethodBeat.o(239447);
  }
  
  public final void emy()
  {
    AppMethodBeat.i(239448);
    Log.e("MicroMsg.MT.MultiTalkMainUI", "onCameraError");
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.bh.e.a(this, 2131767335, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239440);
        ac.eoo().release();
        AppMethodBeat.o(239440);
      }
    });
    if (!locald.isShowing()) {
      locald.show();
    }
    ac.eom().aF(1, ac.eom().zMz);
    AppMethodBeat.o(239448);
  }
  
  public final void eou()
  {
    AppMethodBeat.i(114671);
    if (!this.zPS)
    {
      this.zPS = true;
      Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
      ArrayList localArrayList = new ArrayList();
      if (ac.eom().zME != null)
      {
        Iterator localIterator = ac.eom().zME.RHa.iterator();
        while (localIterator.hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
          if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
            localArrayList.add(localMultiTalkGroupMember.RHb);
          }
        }
        localIntent.putExtra("titile", getString(2131763242));
        localIntent.putExtra("chatroomName", ac.eom().zME.zHE);
        localIntent.putExtra("always_select_contact", Util.listToString(localArrayList, ","));
        localIntent.putExtra("key_need_gallery", false);
        startActivityForResult(localIntent, 1);
      }
    }
    AppMethodBeat.o(114671);
  }
  
  public final boolean eov()
  {
    AppMethodBeat.i(239443);
    if (this.zPK != null)
    {
      boolean bool = this.zPK.isShown();
      AppMethodBeat.o(239443);
      return bool;
    }
    AppMethodBeat.o(239443);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(239452);
    super.finish();
    if (this.zPJ != null) {
      this.zPJ.huQ = false;
    }
    if (this.orientationEventListener != null)
    {
      this.orientationEventListener.disable();
      this.orientationEventListener.ztH = null;
      this.orientationEventListener = null;
    }
    AppMethodBeat.o(239452);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(239449);
    if (!this.zPK.isShown())
    {
      AppMethodBeat.o(239449);
      return 1;
    }
    AppMethodBeat.o(239449);
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495730;
  }
  
  public final void hh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (ac.eom().ent())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
      if (!v.Rl(paramInt2))
      {
        if (v.Rl(paramInt1))
        {
          localp.zUr.setChecked(false);
          localp.zMZ.eL(com.tencent.mm.model.z.aTY(), 0);
          localp.zUq.setVisibility(8);
        }
        localp.sa(false);
      }
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(ac.eom().zMC);
        if (v.Rm(paramInt2)) {
          break;
        }
        if (!v.Rm(paramInt1)) {
          break label176;
        }
        localp.zMZ.r(localHashSet);
        AppMethodBeat.o(114681);
        return;
        if ((v.Rl(paramInt2)) && (!v.Rl(paramInt1)))
        {
          localp.zUr.setChecked(true);
          localp.zMZ.eL(com.tencent.mm.model.z.aTY(), 1);
          localp.zUq.setVisibility(0);
        }
      }
      if ((v.Rm(paramInt2)) && (!v.Rm(paramInt1))) {
        localp.d(localHashSet);
      }
    }
    label176:
    AppMethodBeat.o(114681);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.zPS = false;
    this.zPT = false;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Log.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(paramIntent)));
      paramIntent = Util.stringsToList(paramIntent.split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(114672);
        return;
      }
      ac.eom().fA(paramIntent);
    }
    AppMethodBeat.o(114672);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239446);
    super.onConfigurationChanged(paramConfiguration);
    if (eov())
    {
      this.zPK.refreshView();
      AppMethodBeat.o(239446);
      return;
    }
    paramConfiguration = k.zTz;
    k.a.c(this, true);
    paramConfiguration = this.zPJ;
    if (ac.eom().emr())
    {
      paramConfiguration.zKN.requestLayout();
      if (paramConfiguration.zKN.getAdapter() != null) {
        paramConfiguration.zKN.getAdapter().atj.notifyChanged();
      }
      paramConfiguration.zUk.requestLayout();
    }
    AppMethodBeat.o(239446);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.multitalk.b.m.czc();
    ac.eom().enJ();
    com.tencent.mm.util.d.fAL();
    ac.eom().enB();
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    this.zPP = au.aA(getContext());
    int i = getIntent().getIntExtra("enterMainUiSource", 0);
    if ((i == 1) || (i == 2)) {
      overridePendingTransition(2130772119, 2130771986);
    }
    for (;;)
    {
      hideTitleView();
      getWindow().addFlags(6815872);
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(67108864);
      }
      ac.eom().qm(false);
      if (ac.eom().ems()) {
        break;
      }
      finish();
      if (i == 2) {
        getIntent().getStringExtra("enterMainUiWxGroupId");
      }
      AppMethodBeat.o(114664);
      return;
      overridePendingTransition(2130772171, 2130772172);
    }
    this.zPI = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.zPJ = new com.tencent.mm.plugin.multitalk.ui.widget.p(this);
    this.zPK = new k(this);
    ac.eom().rJ(ac.eom().mkd);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.zPU, paramBundle);
    this.zPM = true;
    this.czp = new MMHandler();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.oD(26))
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.zPO = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      MMApplicationContext.getContext().registerReceiver(this.zPO, paramBundle);
    }
    this.kYy = ((Notification)getIntent().getParcelableExtra("notification"));
    this.yyX = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.yyX.G(9, "VOIPFloatBall");
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this);
    this.orientationEventListener.enable();
    this.orientationEventListener.ztH = this;
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if ((this.zPS) || (this.zPT)) {
      ac.eom().rI(false);
    }
    if (this.zPM) {
      unregisterReceiver(this.zPU);
    }
    if (this.zPK != null)
    {
      Object localObject = this.zPK;
      boolean bool = ac.eom().yon;
      com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = ((k)localObject).zTw;
      if (localf != null) {
        localf.sh(bool);
      }
      localObject = ((k)localObject).zTx;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).sh(bool);
      }
    }
    this.zPV.removeCallbacksAndMessages(null);
    this.zPV.sendEmptyMessage(1);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.oD(26)) && (this.zPN))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.zPN = false;
      }
      if (com.tencent.mm.compatible.util.d.oD(26))
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.zPO == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(this.zPO);
        this.zPO = null;
        chG().getViewTreeObserver().removeOnGlobalLayoutListener(this.zPQ);
        super.onDestroy();
        if (this.yyX != null) {
          this.yyX.onDestroy();
        }
        AppMethodBeat.o(114667);
        return;
        localException1 = localException1;
        Log.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", localException1, "unbindVoiceServiceIfNeed error: %s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localp.sa(false);
      ac.eom().aF(1, ac.eom().zMz);
      localp.zUr.setChecked(false);
    }
    AppMethodBeat.o(114677);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(114669);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (eov())
      {
        paramKeyEvent = this.zPK;
        com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = paramKeyEvent.zTw;
        if (localf != null) {
          localf.onBack();
        }
        paramKeyEvent = paramKeyEvent.zTx;
        if (paramKeyEvent != null) {
          paramKeyEvent.onBack();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(114669);
        return true;
        com.tencent.mm.ui.base.h.a(this, 2131763265, 2131763241, 2131755312, 2131755761, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(239438);
            ac.eom().j(false, false, false);
            AppMethodBeat.o(239438);
          }
        }, null);
      }
    }
    if (ac.eom().zMD == o.zUd)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        ac.eom().stopRing();
        this.zPL = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = ac.eom();
        if (paramKeyEvent.zMV != null) {
          paramKeyEvent.zMV.AX(com.tencent.mm.plugin.multitalk.a.a.eaL());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = ac.eom();
        if (paramKeyEvent.zMV != null) {
          paramKeyEvent.zMV.AW(com.tencent.mm.plugin.multitalk.a.a.eaL());
        }
        AppMethodBeat.o(114669);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(114669);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(239444);
    super.onNewIntent(paramIntent);
    if ((ac.eom().ent()) && (this.czp != null))
    {
      this.czp.removeCallbacksAndMessages(null);
      this.czp.postDelayed(this.zPR, 2000L);
    }
    paramIntent = paramIntent.getStringExtra("filePath");
    if (paramIntent != null)
    {
      Bundle localBundle = new Bundle();
      int i = paramIntent.lastIndexOf(".") + 1;
      if (i >= paramIntent.length())
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "open file error : file path error");
        AppMethodBeat.o(239444);
        return;
      }
      String str = paramIntent.substring(i);
      localBundle.putString("file_path", paramIntent);
      localBundle.putString("file_ext", str);
      this.zPK.Rs(2);
      this.zPK.aq(localBundle);
      com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 1, 2, 1);
      if (this.zPK.isShown())
      {
        this.zPI.eoG();
        this.zPJ.eoS();
        this.zPJ.emh();
        this.zPJ.zUi.setVisibility(8);
        this.zPJ.eoV();
        this.zPJ.eoU();
        this.zPT = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(239444);
        return;
      }
      this.zPI.eoG();
      this.zPJ.n(ac.eom().zME);
    }
    AppMethodBeat.o(239444);
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(239453);
    if (eov())
    {
      k localk = this.zPK;
      kotlin.g.b.p.h(this, "context");
      if (k.a.gE(this) != localk.zTy)
      {
        localk.refreshView();
        if ((k.a.gE(this) == 90) || (k.a.gE(this) == 270)) {
          com.tencent.mm.plugin.multitalk.model.p.zMt += 1;
        }
      }
      AppMethodBeat.o(239453);
      return;
    }
    this.zPJ.Rv(paramInt);
    AppMethodBeat.o(239453);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(114666);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3))
    {
      bool1 = true;
      this.zPH = bool1;
      Log.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.zPH) });
      if (ac.eom().ent()) {
        this.zPJ.sa(true);
      }
      if ((this.zPT) || (this.zPS) || (eov())) {
        break label181;
      }
      if (this.yyX != null)
      {
        this.yyX.aGj();
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
      }
    }
    for (;;)
    {
      if (!eov()) {
        break label211;
      }
      a.a.GST.wR(true);
      AppMethodBeat.o(114666);
      return;
      bool1 = false;
      break;
      label181:
      if ((eov()) && (this.yyX != null)) {
        this.yyX.fFm();
      }
      com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    }
    label211:
    a.a.GST.wR(false);
    AppMethodBeat.o(114666);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114690);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      Log.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(114690);
      return;
    }
    Log.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131755761), false, new MultiTalkMainUI.10(this), new MultiTalkMainUI.11(this));
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new MultiTalkMainUI.12(this), new MultiTalkMainUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    this.iGD = false;
    ac.eom().zLR = this;
    ac.eoo().zLR = this;
    chG().getViewTreeObserver().addOnGlobalLayoutListener(this.zPQ);
    Object localObject1 = ac.eom().enw();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.t)localObject1).zNE;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.plugin.multitalk.model.t)localObject1).aGk((String)((Iterator)localObject2).next());
      }
    }
    if (this.yyX != null)
    {
      this.yyX.aGf();
      com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    }
    localObject1 = (com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).bza();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).bzb();
    }
    localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.ball.c.b)localObject1).l(new BallInfo(6, "MusicFloatBall"));
    }
    if (ac.eom().ent()) {
      this.czp.postDelayed(this.zPR, 2000L);
    }
    if (eov())
    {
      ac.eom();
      q.Rj(101);
      ac.eom().zMz = true;
      ac.eom().zMA = false;
      switch (4.zPX[ac.eom().zMD.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114665);
      return;
      boolean bool = getIntent().getBooleanExtra("enterMainUIScreenProjectOnline", false);
      localObject1 = getIntent().getBundleExtra("enterMainUIScreenProjectParams");
      if ((!bool) || (localObject1 == null)) {
        break;
      }
      this.zPK.Rs(2);
      this.zPK.aq((Bundle)localObject1);
      if (this.zPK.isShown())
      {
        this.zPI.eoG();
        this.zPJ.eoS();
        this.zPJ.emh();
        this.zPJ.eoV();
        this.zPJ.eoU();
        this.zPT = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(114665);
        return;
      }
      this.zPI.eoG();
      this.zPJ.n(ac.eom().zME);
      AppMethodBeat.o(114665);
      return;
      this.zPJ.eoV();
      this.zPI.m(ac.eom().zME);
      if (NetStatusUtil.is4G(this)) {
        ac.eok().at(this);
      }
      while (this.zPL)
      {
        ac.eom().rM(false);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ac.eok().as(this);
        }
      }
      this.zPI.eoG();
      this.zPJ.n(ac.eom().zME);
      if (NetStatusUtil.is4G(this)) {
        ac.eok().at(this);
      }
      for (;;)
      {
        ac.eom().rM(true);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ac.eok().as(this);
        }
      }
      if (this.zPK.isShown())
      {
        this.zPI.eoG();
        this.zPJ.emh();
        this.zPJ.eoV();
        AppMethodBeat.o(114665);
        return;
      }
      this.zPI.eoG();
      this.zPJ.n(ac.eom().zME);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((eov()) && (this.zPH))
    {
      ac.eom();
      q.Rj(102);
      ac.eom().zMz = false;
      ac.eom().zMA = true;
      ac.eom().aF(1, true);
    }
    if ((!this.zPS) && (!this.zPT) && (this.zPH) && (!this.iGD)) {
      ac.eom().rI(false);
    }
    super.onStop();
    AppMethodBeat.o(114668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    if (ac.eom().ent())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
      com.tencent.f.h.RTc.aV(new p.11(localp, paramBoolean));
    }
    AppMethodBeat.o(114679);
  }
  
  public final void rw(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (ac.eom().ent())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.f.h.RTc.aV(new p.2(localp, paramBoolean));
    }
    AppMethodBeat.o(114680);
  }
  
  public final void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (ac.eom().ent())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.zPJ;
      if (localp.zUt != null) {
        localp.zUt.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */