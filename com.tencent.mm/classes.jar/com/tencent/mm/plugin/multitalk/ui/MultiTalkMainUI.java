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
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.m;
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
import com.tencent.mm.plugin.multitalk.ui.widget.p.7;
import com.tencent.mm.plugin.multitalk.ui.widget.p.8;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class MultiTalkMainUI
  extends MMActivity
  implements ServiceConnection, d.a, com.tencent.mm.plugin.multitalk.model.e
{
  public static boolean Fvr = false;
  private com.tencent.mm.plugin.voip.a.b DYP;
  private boolean Fvh;
  private com.tencent.mm.plugin.multitalk.ui.widget.g Fvi;
  private com.tencent.mm.plugin.multitalk.ui.widget.p Fvj;
  private k Fvk;
  private boolean Fvl;
  private boolean Fvm;
  boolean Fvn;
  private MultiTalkMainUI.ScreenActionReceiver Fvo;
  private boolean Fvp;
  private ViewTreeObserver.OnGlobalLayoutListener Fvq;
  private Runnable Fvs;
  private boolean Fvt;
  private boolean Fvu;
  private boolean Fvv;
  private int Fvw;
  private BroadcastReceiver Fvx;
  MMHandler Fvy;
  protected MMHandler cyl;
  private boolean lwF;
  private Notification nSJ;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.Fvl = true;
    this.Fvm = false;
    this.Fvn = false;
    this.Fvp = true;
    this.lwF = false;
    this.Fvq = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(197367);
        int i;
        boolean bool;
        if (ax.av(MultiTalkMainUI.this.getContext()))
        {
          i = ax.aB(MultiTalkMainUI.this.getContext());
          bool = true;
        }
        for (;;)
        {
          if (MultiTalkMainUI.a(MultiTalkMainUI.this) != bool)
          {
            MultiTalkMainUI.a(MultiTalkMainUI.this, bool);
            com.tencent.mm.plugin.multitalk.ui.widget.p localp = MultiTalkMainUI.b(MultiTalkMainUI.this);
            if ((localp.FAh != null) && (localp.FAh.findViewById(a.e.rootView) != null))
            {
              Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "applyBottomMarin %s", new Object[] { Integer.valueOf(i) });
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localp.FAh.findViewById(a.e.rootView).getLayoutParams();
              localLayoutParams.bottomMargin = i;
              localp.FAh.findViewById(a.e.rootView).setLayoutParams(localLayoutParams);
            }
          }
          AppMethodBeat.o(197367);
          return;
          bool = false;
          i = 0;
        }
      }
    };
    this.Fvs = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(197491);
        Object localObject = ad.eYc();
        if (((q)localObject).FsC) {}
        for (boolean bool = false;; bool = v.Xz(((q)localObject).FrQ))
        {
          if ((bool) && (ad.eYe().eWu()) && (!ad.eYc().FrS) && (!ad.eYe().aXN())) {
            MultiTalkMainUI.b(MultiTalkMainUI.this).vb(true);
          }
          if (ad.eYc().FrZ != null)
          {
            localObject = ad.eYc().FrZ;
            if ((((com.tencent.mm.plugin.multitalk.model.z)localObject).FtQ) || (((com.tencent.mm.plugin.multitalk.model.z)localObject).FtR)) {
              i = 1;
            }
            if (i != 0) {}
          }
          else
          {
            ad.eYc().eXC();
            ad.eYc().eXB();
          }
          AppMethodBeat.o(197491);
          return;
        }
      }
    };
    this.Fvt = false;
    this.Fvu = false;
    this.Fvv = false;
    this.Fvw = 0;
    this.Fvx = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(199538);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (ad.eYc().FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzG))
        {
          ad.eYc().stopRing();
          MultiTalkMainUI.c(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(199538);
      }
    };
    this.Fvy = new MultiTalkMainUI.3(this);
    AppMethodBeat.o(114663);
  }
  
  public static void eYn()
  {
    Fvr = true;
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(197748);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.Fvv = true;
    this.Fvw = paramInt;
    AppMethodBeat.o(197748);
  }
  
  public final void a(v.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == v.a.Ftl)
    {
      ad.eYa().az(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == v.a.Ftm)
    {
      ad.eYa().ay(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == v.a.Ftn) {
      com.tencent.mm.bj.e.a(this, a.h.voip_net_unavailable, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.o paramo)
  {
    AppMethodBeat.i(114686);
    if (paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.FzJ)
    {
      paramo = this.Fvj;
      if (paramo.FAt > 0L) {
        paramo.FAt = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final void aC(Runnable paramRunnable)
  {
    AppMethodBeat.i(197750);
    this.cyl.removeCallbacks(paramRunnable);
    AppMethodBeat.o(197750);
  }
  
  public final void aQe(String paramString)
  {
    AppMethodBeat.i(197728);
    k localk;
    dd localdd;
    if (this.Fvk != null)
    {
      localk = this.Fvk;
      kotlin.g.b.p.k(paramString, "path");
      localdd = new dd();
      if (!Util.isNullOrNil(paramString)) {
        break label95;
      }
      Log.w("MicroMsg.MultiTalkScreenProjectUILogic", "fill favorite event fail, event is null or image path is empty");
      localdd.fyI.fyO = a.h.favorite_fail_argument_error;
    }
    for (;;)
    {
      localdd.fyI.activity = ((Activity)localk.Fyj);
      localdd.fyI.fyP = 6;
      EventCenter.instance.publish((IEvent)localdd);
      AppMethodBeat.o(197728);
      return;
      label95:
      Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(2) });
      aoc localaoc = new aoc();
      aoi localaoi = new aoi();
      anm localanm = new anm();
      localanm.arq(2);
      localanm.bsL(paramString);
      Object localObject = localanm.toString() + 2 + System.currentTimeMillis();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(197728);
        throw paramString;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      kotlin.g.b.p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      localanm.bsK(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      localObject = new hi();
      ((hi)localObject).fEb.type = 27;
      ((hi)localObject).fEb.fEd = localanm;
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((hi)localObject).fEc.thumbPath;
      BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
      localanm.bsM((String)localObject);
      localaoi.btx(com.tencent.mm.model.z.bcZ());
      localaoi.bty(com.tencent.mm.model.z.bcZ());
      localaoi.arz(2);
      localaoi.Ue(Util.nowMilliSecond());
      localaoc.a(localaoi);
      localaoc.syG.add(localanm);
      localdd.fyI.title = localanm.title;
      localdd.fyI.fyK = localaoc;
      localdd.fyI.type = 2;
    }
  }
  
  public final void aQf(String paramString)
  {
    AppMethodBeat.i(197733);
    if (this.Fvk != null)
    {
      k localk = this.Fvk;
      kotlin.g.b.p.k(paramString, "imgPath");
      Object localObject = new Intent();
      ((Intent)localObject).setClassName((Context)localk.Fyj, "com.tencent.mm.ui.transmit.MsgRetransmitUI");
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", 1);
      paramString = localk.Fyj;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(197733);
  }
  
  public final boolean aXN()
  {
    AppMethodBeat.i(114689);
    if (this.Fvj != null)
    {
      boolean bool = ad.eYe().aXN();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final ViewGroup cuR()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(a.e.rootview);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void eIN()
  {
    AppMethodBeat.i(197720);
    if (this.Fvj != null) {
      this.Fvj.XK(10);
    }
    AppMethodBeat.o(197720);
  }
  
  public final void eIO()
  {
    AppMethodBeat.i(197721);
    if (this.Fvj != null) {
      this.Fvj.XL(10);
    }
    AppMethodBeat.o(197721);
  }
  
  public final void eIX()
  {
    AppMethodBeat.i(114675);
    if (!eYm())
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "onMiniMultiTalk");
      nl localnl = new nl();
      localnl.fLP.action = 0;
      EventCenter.instance.publish(localnl);
      this.Fvj.vd(true);
      ad.eYc().stopRing();
      finish();
    }
    ad.eYc().Fri = null;
    ad.eYe().Fri = null;
    AppMethodBeat.o(114675);
  }
  
  public final void eIY()
  {
    AppMethodBeat.i(114688);
    if (!eYm())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      localObject1 = localp.timeTV;
      long l = ad.eYc().Fsd;
      ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
      Object localObject4 = localp.Fst;
      localObject1 = ad.eYc();
      kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      Object localObject5 = ((q)localObject1).FrW;
      localObject1 = ad.eYc();
      kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
      List localList = ((q)localObject1).eVE();
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).Fqj;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).Fwl;
        if (localObject1 != null)
        {
          Iterator localIterator = ((Iterable)localObject1).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).Fmr.ZiH;
            kotlin.g.b.p.j(localObject1, "it.member.usrName");
            localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).aPL((String)localObject1);
            if (localObject1 != null)
            {
              int i;
              if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww != null)
              {
                i = 1;
                label214:
                if (i == 0) {
                  break label358;
                }
                label218:
                if (localObject1 == null) {
                  break label362;
                }
                localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
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
                if (!kotlin.g.b.p.h(com.tencent.mm.model.z.bcZ(), localObject2)) {
                  break label364;
                }
                localObject3 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).Fqh;
                if ((localObject3 == null) || (((com.tencent.mm.plugin.multitalk.model.b)localObject3).aXN() != true)) {
                  break label364;
                }
                localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fwx;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(8);
                }
              }
              for (;;)
              {
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fww;
                if ((localObject1 == null) || (!((MultitalkFrameView)localObject1).tUi)) {
                  break;
                }
                com.tencent.e.h.ZvG.bc((Runnable)new MultitalkFrameView.e((MultitalkFrameView)localObject1));
                break;
                i = 0;
                break label214;
                label358:
                localObject1 = null;
                break label218;
                label362:
                break;
                label364:
                if ((localList != null) && (localList.contains(localObject2) == true) && (localObject5 != null) && (!((HashSet)localObject5).contains(localObject2)))
                {
                  localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fwx;
                  if (localObject2 != null) {
                    ((ImageView)localObject2).setVisibility(0);
                  }
                }
                else
                {
                  localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject1).Fwx;
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
        com.tencent.mm.plugin.multitalk.model.p.Xt(localList.size());
      }
      Object localObject3 = localp.Fst;
      localObject4 = ad.eYc();
      kotlin.g.b.p.j(localObject4, "SubCoreMultiTalk.getMultiTalkManager()");
      localObject2 = ((q)localObject4).FrY.FmO;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((q)localObject4).FrY.ZiE;
      }
      boolean bool = ((q)localObject4).aQj(((q)localObject4).FrY.FmP);
      Log.d("MicroMsg.MT.MultiTalkManager", "getWeakNetworkMember: %s, groupid:%s, isILink:%b", new Object[] { v.g(((q)localObject4).FrY), ((q)localObject4).FrY.FmP, Boolean.valueOf(bool) });
      new ArrayList();
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.b.o.Fne.eVG();
        localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).Fqj;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject2).Fwl;
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
            break label882;
          }
          localObject4 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject2).next();
          if (((List)localObject1).contains(((com.tencent.mm.plugin.multitalk.data.a)localObject4).Fmr.ZiH) == true)
          {
            localObject5 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).Fmr.ZiH;
            kotlin.g.b.p.j(localObject5, "it.member.usrName");
            localObject5 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aPL((String)localObject5);
            if (localObject5 != null)
            {
              localObject5 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject5).Fwy;
              if (localObject5 != null) {
                ((ImageView)localObject5).setVisibility(0);
              }
            }
            bool = kotlin.g.b.p.h(com.tencent.mm.model.z.bcZ(), ((com.tencent.mm.plugin.multitalk.data.a)localObject4).Fmr.ZiH);
            com.tencent.mm.plugin.multitalk.model.p.uF(bool);
            if (!bool) {
              continue;
            }
            localObject4 = ad.eYd();
            if ((((n)localObject4).Fzo == null) || (((n)localObject4).Fzq)) {
              continue;
            }
            com.tencent.e.h.ZvG.bDh("showIcon");
            com.tencent.e.h.ZvG.d((Runnable)new n.d((n)localObject4), "showIcon");
            continue;
            if (w.Ftp == null) {
              w.Ftp = new w();
            }
            localObject1 = w.Ftp.aQz((String)localObject1);
            break;
          }
          localObject4 = ((com.tencent.mm.plugin.multitalk.data.a)localObject4).Fmr.ZiH;
          kotlin.g.b.p.j(localObject4, "it.member.usrName");
          localObject4 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aPL((String)localObject4);
          if (localObject4 != null)
          {
            localObject4 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject4).Fwy;
            if (localObject4 != null) {
              ((ImageView)localObject4).setVisibility(8);
            }
          }
        }
      }
      label882:
      if (localp.FAp != null)
      {
        localObject1 = localp.FAp.FEl;
        if (localObject1 != null)
        {
          localObject1 = ((j)localObject1).FCm;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject1).eIY();
          }
        }
      }
    }
    Object localObject1 = this.Fvk;
    Object localObject2 = ((k)localObject1).FyY;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.f)localObject2).eIY();
    }
    localObject1 = ((k)localObject1).FyZ;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject1).eIY();
    }
    ad.eYe().eWs();
    AppMethodBeat.o(114688);
  }
  
  public final void eRL()
  {
    AppMethodBeat.i(114674);
    this.Fvi.eYx();
    this.Fvj.n(ad.eYc().FrY);
    AppMethodBeat.o(114674);
  }
  
  public final void eWh()
  {
    AppMethodBeat.i(114676);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onExitMultiTalk");
    this.lwF = true;
    Object localObject = ad.eYc();
    if (((q)localObject).Fsp != null) {
      ((q)localObject).Fsp.aa(false, 1);
    }
    localObject = new nl();
    ((nl)localObject).fLP.action = 0;
    EventCenter.instance.publish((IEvent)localObject);
    this.cyl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195767);
        MultiTalkMainUI.b(MultiTalkMainUI.this).vd(false);
        AppMethodBeat.o(195767);
      }
    });
    if (this.Fvk != null)
    {
      localObject = com.tencent.mm.plugin.multitalk.d.f.FEQ;
      com.tencent.mm.plugin.multitalk.d.f.fad();
      this.Fvk.eWl();
    }
    ad.eYc().Fri = null;
    ad.eYe().Fri = null;
    ad.eYc().stopRing();
    localObject = ad.eYc();
    if (((q)localObject).Fsp != null) {
      ((q)localObject).Fsp.eVm();
    }
    if (ad.eYc().Fsp != null) {
      com.tencent.mm.plugin.multitalk.a.b.unInit();
    }
    ad.eYe().release();
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void eWi()
  {
    AppMethodBeat.i(114673);
    switch (4.FvA[ad.eYc().FrX.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.Fvj.n(ad.eYc().FrY);
      AppMethodBeat.o(114673);
      return;
      this.Fvi.m(ad.eYc().FrY);
    }
  }
  
  public final void eWj()
  {
    AppMethodBeat.i(114678);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + ad.eYc().FrW.size());
    Object localObject;
    if (ad.eYc().eXh())
    {
      localObject = ad.eYc().FrW;
      if (((HashSet)localObject).size() <= 0) {
        break label160;
      }
      if ((((HashSet)localObject).size() != 1) || (!((HashSet)localObject).contains(com.tencent.mm.model.z.bcZ()))) {
        break label151;
      }
      ad.eYc().eXC();
    }
    for (;;)
    {
      if (!eYm())
      {
        localObject = this.Fvj;
        if (!((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Fst.eVP())
        {
          HashSet localHashSet = new HashSet(ad.eYc().FrW);
          if (v.XA(ad.eYc().FrQ)) {
            ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).d(localHashSet);
          }
          com.tencent.mm.plugin.multitalk.model.p.Xu(localHashSet.size());
        }
      }
      AppMethodBeat.o(114678);
      return;
      label151:
      ad.eYc().eXB();
      continue;
      label160:
      localObject = ad.eYc();
      Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
      if (((q)localObject).FrZ != null) {
        ((q)localObject).FrZ.stopVideo();
      }
    }
  }
  
  public final void eWk()
  {
    AppMethodBeat.i(197707);
    this.Fvj.va(true);
    AppMethodBeat.o(197707);
  }
  
  public final void eWl()
  {
    AppMethodBeat.i(197718);
    setRequestedOrientation(1);
    Object localObject = com.tencent.mm.plugin.multitalk.d.f.FEQ;
    com.tencent.mm.plugin.multitalk.d.f.fae();
    ad.eYc().FrS = false;
    ad.eYc().FrT = false;
    getIntent().removeExtra("enterMainUIScreenProjectOnline");
    getIntent().removeExtra("enterMainUIScreenProjectParams");
    this.Fvk.eWl();
    ad.eYc().aK(1, false);
    this.Fvj.eVV();
    localObject = this.Fvj;
    if (((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).FAk) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).FAh.setVisibility(0);
    }
    this.Fvj.FzL.setVisibility(0);
    com.tencent.mm.plugin.multitalk.ui.widget.p.eYG();
    this.Fvj.n(ad.eYc().FrY);
    localObject = this.Fvj;
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).FzQ.setVisibility(0);
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).FzO.setVisibility(0);
    if ((ad.eYc().eXh()) && (this.cyl != null))
    {
      localObject = this.Fvj;
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Fst.a(((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Fqe, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Fqf, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Fyj, (com.tencent.mm.plugin.multitalk.model.b)localObject);
      ad.eYc().eXD();
    }
    AppMethodBeat.o(197718);
  }
  
  public final void eWm()
  {
    AppMethodBeat.i(197719);
    Log.e("MicroMsg.MT.MultiTalkMainUI", "onCameraError");
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.bj.e.a(this, a.h.voip_no_record_video_permission, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200562);
        ad.eYe().release();
        AppMethodBeat.o(200562);
      }
    });
    if (!locald.isShowing()) {
      locald.show();
    }
    ad.eYc().aK(1, ad.eYc().FrS);
    AppMethodBeat.o(197719);
  }
  
  public final void eYk()
  {
    AppMethodBeat.i(114671);
    if (!this.Fvt)
    {
      this.Fvt = true;
      Intent localIntent = new Intent(this, MultiTalkAddMembersUI.class);
      ArrayList localArrayList = new ArrayList();
      if (ad.eYc().FrY != null)
      {
        Iterator localIterator = ad.eYc().FrY.ZiG.iterator();
        while (localIterator.hasNext())
        {
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
          if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
            localArrayList.add(localMultiTalkGroupMember.ZiH);
          }
        }
        localIntent.putExtra("titile", getString(a.h.multitalk_add_contact));
        localIntent.putExtra("chatroomName", ad.eYc().FrY.FmP);
        localIntent.putExtra("always_select_contact", Util.listToString(localArrayList, ","));
        localIntent.putExtra("key_need_gallery", false);
        startActivityForResult(localIntent, 1);
      }
    }
    AppMethodBeat.o(114671);
  }
  
  public final void eYl()
  {
    AppMethodBeat.i(197605);
    if ((!this.Fvu) && (ad.eYc().FrY != null))
    {
      this.Fvu = true;
      Intent localIntent = new Intent();
      localIntent.putExtra("kintent_talker", ad.eYc().FrY.FmP);
      localIntent.putExtra("key_media_type", 2);
      localIntent.putExtra("scene", 3);
      com.tencent.mm.by.c.d(this, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", localIntent, 3);
    }
    AppMethodBeat.o(197605);
  }
  
  public final boolean eYm()
  {
    AppMethodBeat.i(197610);
    if (this.Fvk != null)
    {
      boolean bool = this.Fvk.isShown();
      AppMethodBeat.o(197610);
      return bool;
    }
    AppMethodBeat.o(197610);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(197739);
    super.finish();
    if (this.Fvj != null) {
      this.Fvj.kgM = false;
    }
    if (this.orientationEventListener != null)
    {
      this.orientationEventListener.disable();
      this.orientationEventListener.EZi = null;
      this.orientationEventListener = null;
    }
    AppMethodBeat.o(197739);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(197723);
    if (!this.Fvk.isShown())
    {
      AppMethodBeat.o(197723);
      return 1;
    }
    AppMethodBeat.o(197723);
    return 4;
  }
  
  public int getLayoutId()
  {
    return a.f.multitalk_main_ui;
  }
  
  public final void im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (ad.eYc().eXh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      if (!v.Xz(paramInt2))
      {
        if (v.Xz(paramInt1))
        {
          localp.FzY.setChecked(false);
          localp.Fst.fm(com.tencent.mm.model.z.bcZ(), 0);
          localp.FzW.setVisibility(8);
        }
        localp.vc(false);
      }
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(ad.eYc().FrW);
        if (v.XA(paramInt2)) {
          break;
        }
        if (!v.XA(paramInt1)) {
          break label176;
        }
        localp.Fst.r(localHashSet);
        AppMethodBeat.o(114681);
        return;
        if ((v.Xz(paramInt2)) && (!v.Xz(paramInt1)))
        {
          localp.FzY.setChecked(true);
          localp.Fst.fm(com.tencent.mm.model.z.bcZ(), 1);
          localp.FzW.setVisibility(0);
        }
      }
      if ((v.XA(paramInt2)) && (!v.XA(paramInt1))) {
        localp.d(localHashSet);
      }
    }
    label176:
    AppMethodBeat.o(114681);
  }
  
  public final void kv(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localp.vc(false);
      ad.eYc().aK(1, ad.eYc().FrS);
      localp.FzY.setChecked(false);
    }
    AppMethodBeat.o(114677);
  }
  
  public final void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(197752);
    this.cyl.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(197752);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.Fvt = false;
    this.Fvu = false;
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
      ad.eYc().gc(paramIntent);
    }
    if ((paramInt1 == 1) && (this.Fvj != null) && (this.Fvv))
    {
      this.Fvv = false;
      if (this.Fvw == 1)
      {
        this.Fvj.XK(5);
        AppMethodBeat.o(114672);
        return;
      }
      if (this.Fvw == 2) {
        this.Fvj.XL(5);
      }
    }
    AppMethodBeat.o(114672);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(197716);
    super.onConfigurationChanged(paramConfiguration);
    if (eYm())
    {
      this.Fvk.refreshView();
      AppMethodBeat.o(197716);
      return;
    }
    paramConfiguration = k.Fzb;
    k.a.d(this, true);
    paramConfiguration = this.Fvj;
    if (ad.eYc().eWf())
    {
      paramConfiguration.Fqe.requestLayout();
      if (paramConfiguration.Fqe.getAdapter() != null) {
        paramConfiguration.Fqe.getAdapter().alc.notifyChanged();
      }
      paramConfiguration.FzN.requestLayout();
    }
    AppMethodBeat.o(197716);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    ad.eYc().eXz();
    com.tencent.mm.util.e.gsM();
    ad.eYc().eXr();
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    this.Fvp = ax.av(getContext());
    int i = getIntent().getIntExtra("enterMainUiSource", 0);
    if ((i == 1) || (i == 2)) {
      overridePendingTransition(com.tencent.mm.plugin.multitalk.a.a.pop_in, com.tencent.mm.plugin.multitalk.a.a.anim_not_change);
    }
    for (;;)
    {
      hideTitleView();
      getWindow().addFlags(6815872);
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(67108864);
      }
      ad.eYc().to(false);
      if (ad.eYc().eWg()) {
        break;
      }
      finish();
      if (i == 2) {
        getIntent().getStringExtra("enterMainUiWxGroupId");
      }
      AppMethodBeat.o(114664);
      return;
      overridePendingTransition(com.tencent.mm.plugin.multitalk.a.a.slide_top_in, com.tencent.mm.plugin.multitalk.a.a.slide_top_out);
    }
    this.Fvi = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.Fvj = new com.tencent.mm.plugin.multitalk.ui.widget.p(this);
    this.Fvk = new k(this);
    ad.eYc().uM(ad.eYc().pih);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.Fvx, paramBundle);
    this.Fvm = true;
    this.cyl = new MMHandler();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.qV(26))
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.Fvo = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      MMApplicationContext.getContext().registerReceiver(this.Fvo, paramBundle);
    }
    this.nSJ = ((Notification)getIntent().getParcelableExtra("notification"));
    this.DYP = new com.tencent.mm.plugin.voip.a.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.DYP.I(9, "VOIPFloatBall");
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this);
    this.orientationEventListener.enable();
    this.orientationEventListener.EZi = this;
    Fvr = false;
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if ((this.Fvt) || (this.Fvu) || (this.Fvv)) {
      ad.eYc().uL(false);
    }
    if (this.Fvm) {
      unregisterReceiver(this.Fvx);
    }
    if (this.Fvk != null)
    {
      Object localObject = this.Fvk;
      boolean bool = ad.eYc().DOp;
      com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = ((k)localObject).FyY;
      if (localf != null) {
        localf.vj(bool);
      }
      localObject = ((k)localObject).FyZ;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).vj(bool);
      }
    }
    this.Fvy.removeCallbacksAndMessages(null);
    this.Fvy.sendEmptyMessage(1);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.qV(26)) && (this.Fvn))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.Fvn = false;
      }
      if (com.tencent.mm.compatible.util.d.qV(26))
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.Fvo == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(this.Fvo);
        this.Fvo = null;
        cuR().getViewTreeObserver().removeOnGlobalLayoutListener(this.Fvq);
        super.onDestroy();
        if (this.DYP != null) {
          this.DYP.onDestroy();
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
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 0;
    AppMethodBeat.i(114669);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (eYm())
      {
        paramKeyEvent = this.Fvk;
        com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = paramKeyEvent.FyY;
        if (localf != null) {
          localf.onBack();
        }
        paramKeyEvent = paramKeyEvent.FyZ;
        if (paramKeyEvent != null) {
          paramKeyEvent.onBack();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(114669);
        return true;
        paramKeyEvent = this.Fvj;
        paramInt = i;
        if (paramKeyEvent.Fst != null)
        {
          paramInt = i;
          if (paramKeyEvent.Fst.eVP())
          {
            paramKeyEvent.eVV();
            paramKeyEvent.FAh.dGn();
            paramKeyEvent.Fst.eVO();
            paramInt = 1;
          }
        }
        if (paramInt == 0) {
          com.tencent.mm.ui.base.h.a(this, a.h.multitalk_exit_tip, a.h.multitalk, a.h.app_alert_exit, a.h.app_cancel, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(201152);
              ad.eYc().i(false, false, false);
              AppMethodBeat.o(201152);
            }
          }, null);
        }
      }
    }
    if (ad.eYc().FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzG)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        ad.eYc().stopRing();
        this.Fvl = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = ad.eYc();
        if (paramKeyEvent.Fsp != null) {
          paramKeyEvent.Fsp.Ey(com.tencent.mm.plugin.multitalk.a.b.eJJ());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = ad.eYc();
        if (paramKeyEvent.Fsp != null) {
          paramKeyEvent.Fsp.Ex(com.tencent.mm.plugin.multitalk.a.b.eJJ());
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
    AppMethodBeat.i(197627);
    super.onNewIntent(paramIntent);
    if ((ad.eYc().eXh()) && (this.cyl != null))
    {
      this.cyl.removeCallbacksAndMessages(null);
      this.cyl.postDelayed(this.Fvs, 2000L);
    }
    paramIntent = paramIntent.getStringExtra("filePath");
    if (paramIntent != null)
    {
      Bundle localBundle = new Bundle();
      int i = paramIntent.lastIndexOf(".") + 1;
      if (i >= paramIntent.length())
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "open file error : file path error");
        AppMethodBeat.o(197627);
        return;
      }
      String str = paramIntent.substring(i);
      localBundle.putString("file_path", paramIntent);
      localBundle.putString("file_ext", str);
      this.Fvk.eYz();
      this.Fvk.ak(localBundle);
      com.tencent.mm.plugin.multitalk.model.p.q(ad.eYc().FrY.FmO, 1, 2, 1);
      if (this.Fvk.isShown())
      {
        this.Fvi.eYx();
        this.Fvj.eYI();
        this.Fvj.aYA();
        this.Fvj.eVW();
        this.Fvj.FzL.setVisibility(8);
        this.Fvj.eYL();
        this.Fvj.eYK();
        this.Fvj.Fst.eVN();
        this.Fvu = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(197627);
        return;
      }
      this.Fvi.eYx();
      this.Fvj.n(ad.eYc().FrY);
    }
    AppMethodBeat.o(197627);
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(197741);
    if (eYm())
    {
      k localk = this.Fvk;
      kotlin.g.b.p.k(this, "context");
      if (k.a.hB(this) != localk.Fza)
      {
        localk.refreshView();
        if ((k.a.hB(this) == 90) || (k.a.hB(this) == 270)) {
          com.tencent.mm.plugin.multitalk.model.p.FrM += 1;
        }
      }
      AppMethodBeat.o(197741);
      return;
    }
    this.Fvj.XM(paramInt);
    AppMethodBeat.o(197741);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(114666);
    ad.eYc().eXC();
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3))
    {
      bool1 = true;
      this.Fvh = bool1;
      Log.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.Fvh) });
      if (ad.eYc().eXh()) {
        this.Fvj.vc(true);
      }
      if ((this.Fvu) || (this.Fvt) || (this.Fvv) || (eYm())) {
        break label194;
      }
      if (this.DYP != null)
      {
        this.DYP.aOj();
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
    }
    for (;;)
    {
      if (!eYm()) {
        break label231;
      }
      com.tencent.mm.plugin.voip.a.a.a.NJe.AJ(true);
      AppMethodBeat.o(114666);
      return;
      bool1 = false;
      break;
      label194:
      if ((eYm()) && (this.DYP != null) && (!this.Fvv)) {
        this.DYP.gxy();
      }
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    }
    label231:
    com.tencent.mm.plugin.voip.a.a.a.NJe.AJ(false);
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
      com.tencent.mm.ui.base.h.a(this, getString(a.h.permission_microphone_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new MultiTalkMainUI.10(this), new MultiTalkMainUI.11(this));
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.h.permission_camera_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new MultiTalkMainUI.12(this), new MultiTalkMainUI.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    this.lwF = false;
    ad.eYc().Fri = this;
    ad.eYe().Fri = this;
    cuR().getViewTreeObserver().addOnGlobalLayoutListener(this.Fvq);
    Object localObject1 = ad.eYc().eXm();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.t)localObject1).Ftb;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.plugin.multitalk.model.t)localObject1).aQy((String)((Iterator)localObject2).next());
      }
    }
    if ((this.DYP != null) && (!this.Fvv))
    {
      this.DYP.aOf();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    localObject1 = (com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).bKp();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).bKq();
    }
    localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.ball.c.b)localObject1).l(new BallInfo(6, "MusicFloatBall"));
    }
    if (ad.eYc().eXh()) {
      this.cyl.postDelayed(this.Fvs, 2000L);
    }
    if (eYm())
    {
      ad.eYc();
      q.Xx(101);
      ad.eYc().FrS = true;
      ad.eYc().FrT = false;
      switch (4.FvA[ad.eYc().FrX.ordinal()])
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
      this.Fvk.eYz();
      this.Fvk.ak((Bundle)localObject1);
      if (this.Fvk.isShown())
      {
        this.Fvj.aYA();
        this.Fvi.eYx();
        this.Fvj.eYI();
        this.Fvj.eVW();
        this.Fvj.eYL();
        this.Fvj.eYK();
        this.Fvu = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(114665);
        return;
      }
      this.Fvi.eYx();
      this.Fvj.n(ad.eYc().FrY);
      AppMethodBeat.o(114665);
      return;
      this.Fvj.eYL();
      this.Fvi.m(ad.eYc().FrY);
      if (NetStatusUtil.is4G(this)) {
        ad.eYa().az(this);
      }
      while (this.Fvl)
      {
        ad.eYc().uP(false);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ad.eYa().ay(this);
        }
      }
      this.Fvi.eYx();
      this.Fvj.n(ad.eYc().FrY);
      if (NetStatusUtil.is4G(this)) {
        ad.eYa().az(this);
      }
      for (;;)
      {
        ad.eYc().uP(true);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ad.eYa().ay(this);
        }
      }
      if (this.Fvk.isShown())
      {
        this.Fvi.eYx();
        this.Fvj.eVW();
        this.Fvj.eYL();
        AppMethodBeat.o(114665);
        return;
      }
      this.Fvi.eYx();
      this.Fvj.n(ad.eYc().FrY);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((eYm()) && (this.Fvh))
    {
      ad.eYc();
      q.Xx(102);
      ad.eYc().FrS = false;
      ad.eYc().FrT = true;
      ad.eYc().aK(1, true);
    }
    if ((!this.Fvt) && (!this.Fvu) && (!this.Fvv) && (this.Fvh) && (!this.lwF) && (!Fvr)) {
      ad.eYc().uL(false);
    }
    super.onStop();
    AppMethodBeat.o(114668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void uA(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (ad.eYc().eXh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      if (localp.FAa != null) {
        localp.FAa.setEnabled(paramBoolean);
      }
    }
    AppMethodBeat.o(114682);
  }
  
  public final void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    if (ad.eYc().eXh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      com.tencent.e.h.ZvG.bc(new p.7(localp, paramBoolean));
    }
    AppMethodBeat.o(114679);
  }
  
  public final void uz(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (ad.eYc().eXh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Fvj;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.e.h.ZvG.bc(new p.8(localp, paramBoolean));
    }
    AppMethodBeat.o(114680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */