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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.u;
import com.tencent.mm.plugin.multitalk.model.u.a;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.y;
import com.tencent.mm.plugin.multitalk.ui.widget.CollapseView;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkControlIconLayout;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.p.10;
import com.tencent.mm.plugin.multitalk.ui.widget.p.9;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
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
  public static boolean LrF = false;
  private com.tencent.mm.plugin.voip.c.b JPY;
  private boolean LrA;
  boolean LrB;
  private MultiTalkMainUI.ScreenActionReceiver LrC;
  private boolean LrD;
  private ViewTreeObserver.OnGlobalLayoutListener LrE;
  private Runnable LrG;
  public boolean LrH;
  private boolean LrI;
  private boolean LrJ;
  private int LrK;
  private BroadcastReceiver LrL;
  MMHandler LrM;
  private boolean Lrq;
  private com.tencent.mm.plugin.multitalk.ui.widget.g Lrw;
  private com.tencent.mm.plugin.multitalk.ui.widget.p Lrx;
  private com.tencent.mm.plugin.multitalk.ui.widget.k Lry;
  private boolean Lrz;
  protected MMHandler eqE;
  private boolean ooe;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private Notification qSv;
  
  public MultiTalkMainUI()
  {
    AppMethodBeat.i(114663);
    this.Lrz = true;
    this.LrA = false;
    this.LrB = false;
    this.LrD = true;
    this.ooe = false;
    this.LrE = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(285249);
        int i;
        boolean bool;
        if (bf.bg(MultiTalkMainUI.this.getContext()))
        {
          i = bf.bk(MultiTalkMainUI.this.getContext());
          bool = true;
        }
        for (;;)
        {
          if (MultiTalkMainUI.a(MultiTalkMainUI.this) != bool)
          {
            MultiTalkMainUI.a(MultiTalkMainUI.this, bool);
            com.tencent.mm.plugin.multitalk.ui.widget.p localp = MultiTalkMainUI.b(MultiTalkMainUI.this);
            if ((localp.Lwl != null) && (localp.Lwl.findViewById(a.e.rootView) != null))
            {
              Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "applyBottomMarin %s", new Object[] { Integer.valueOf(i) });
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localp.Lwl.findViewById(a.e.rootView).getLayoutParams();
              localLayoutParams.bottomMargin = i;
              localp.Lwl.findViewById(a.e.rootView).setLayoutParams(localLayoutParams);
            }
          }
          AppMethodBeat.o(285249);
          return;
          bool = false;
          i = 0;
        }
      }
    };
    this.LrG = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(285271);
        Object localObject = ac.ggS();
        if (((com.tencent.mm.plugin.multitalk.model.p)localObject).LoU) {}
        for (boolean bool = false;; bool = u.abK(((com.tencent.mm.plugin.multitalk.model.p)localObject).Lod))
        {
          if ((bool) && (ac.ggU().gfm()) && (!ac.ggS().Lof) && (!ac.ggU().bsA())) {
            MultiTalkMainUI.b(MultiTalkMainUI.this).zp(true);
          }
          if (ac.ggS().Lom != null)
          {
            localObject = ac.ggS().Lom;
            if ((((y)localObject).Lqk) || (((y)localObject).Lql)) {
              i = 1;
            }
            if (i != 0) {}
          }
          else
          {
            ac.ggS().ggs();
            ac.ggS().ggr();
          }
          AppMethodBeat.o(285271);
          return;
        }
      }
    };
    this.LrH = false;
    this.LrI = false;
    this.LrJ = false;
    this.LrK = 0;
    this.LrL = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(285262);
        if (("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction())) && (ac.ggS().Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK))
        {
          ac.ggS().stopRing();
          MultiTalkMainUI.c(MultiTalkMainUI.this);
        }
        AppMethodBeat.o(285262);
      }
    };
    this.LrM = new MultiTalkMainUI.3(this);
    AppMethodBeat.o(114663);
  }
  
  public static void ghi()
  {
    LrF = true;
  }
  
  public final void VW(int paramInt)
  {
    AppMethodBeat.i(285601);
    Intent localIntent = new Intent(this, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    startActivityForResult(localIntent, 1);
    this.LrJ = true;
    this.LrK = paramInt;
    AppMethodBeat.o(285601);
  }
  
  public final void a(u.a parama)
  {
    AppMethodBeat.i(114687);
    if (parama == u.a.LpE)
    {
      ac.ggQ().ba(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == u.a.LpF)
    {
      ac.ggQ().aZ(this);
      AppMethodBeat.o(114687);
      return;
    }
    if (parama == u.a.LpG) {
      com.tencent.mm.bc.e.a(this, a.h.voip_net_unavailable, null);
    }
    AppMethodBeat.o(114687);
  }
  
  public final void a(com.tencent.mm.plugin.multitalk.ui.widget.o paramo)
  {
    AppMethodBeat.i(114686);
    if (paramo == com.tencent.mm.plugin.multitalk.ui.widget.o.LvN)
    {
      paramo = this.Lrx;
      if (paramo.Lwx > 0L) {
        paramo.Lwx = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(114686);
  }
  
  public final void aL(Runnable paramRunnable)
  {
    AppMethodBeat.i(285607);
    this.eqE.removeCallbacks(paramRunnable);
    AppMethodBeat.o(285607);
  }
  
  public final void aMZ(String paramString)
  {
    AppMethodBeat.i(285554);
    com.tencent.mm.plugin.multitalk.ui.widget.k localk;
    dn localdn;
    if (this.Lry != null)
    {
      localk = this.Lry;
      kotlin.g.b.s.u(paramString, "path");
      localdn = new dn();
      if (!Util.isNullOrNil(paramString)) {
        break label89;
      }
      Log.w("MicroMsg.MultiTalkScreenProjectUILogic", "fill favorite event fail, event is null or image path is empty");
      localdn.hDr.hDx = a.h.favorite_fail_argument_error;
    }
    for (;;)
    {
      localdn.hDr.activity = ((Activity)localk.Luv);
      localdn.hDr.hDy = 6;
      localdn.publish();
      AppMethodBeat.o(285554);
      return;
      label89:
      Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(2) });
      arv localarv = new arv();
      asb localasb = new asb();
      arf localarf = new arf();
      localarf.axy(2);
      localarf.bsC(paramString);
      Object localObject = localarf + '2' + System.currentTimeMillis();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(285554);
        throw paramString;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localarf.bsB(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      localObject = new ht();
      ((ht)localObject).hIR.type = 27;
      ((ht)localObject).hIR.hIT = localarf;
      ((ht)localObject).publish();
      localObject = ((ht)localObject).hIS.thumbPath;
      BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
      localarf.bsD((String)localObject);
      localasb.bto(z.bAM());
      localasb.btp(z.bAM());
      localasb.axH(2);
      localasb.yu(Util.nowMilliSecond());
      localarv.a(localasb);
      localarv.vEn.add(localarf);
      localdn.hDr.title = localarf.title;
      localdn.hDr.hDt = localarv;
      localdn.hDr.type = 2;
    }
  }
  
  public final void aNa(String paramString)
  {
    AppMethodBeat.i(285562);
    if (this.Lry != null)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.k localk = this.Lry;
      kotlin.g.b.s.u(paramString, "imgPath");
      Object localObject = new Intent();
      ((Intent)localObject).setClassName((Context)localk.Luv, "com.tencent.mm.ui.transmit.MsgRetransmitUI");
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", 1);
      paramString = localk.Luv;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(285562);
  }
  
  public final boolean bsA()
  {
    AppMethodBeat.i(114689);
    if (this.Lrx != null)
    {
      boolean bool = ac.ggU().bsA();
      AppMethodBeat.o(114689);
      return bool;
    }
    AppMethodBeat.o(114689);
    return false;
  }
  
  public final ViewGroup cXB()
  {
    AppMethodBeat.i(114691);
    ViewGroup localViewGroup = (ViewGroup)findViewById(a.e.rootview);
    AppMethodBeat.o(114691);
    return localViewGroup;
  }
  
  public final void fQN()
  {
    AppMethodBeat.i(285535);
    if (this.Lrx != null) {
      this.Lrx.abU(10);
    }
    AppMethodBeat.o(285535);
  }
  
  public final void fQY()
  {
    AppMethodBeat.i(114675);
    if (!ghh())
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "onMiniMultiTalk");
      os localos = new os();
      localos.hRy.action = 0;
      localos.publish();
      this.Lrx.zr(true);
      ac.ggS().stopRing();
      finish();
    }
    ac.ggS().Lnt = null;
    ac.ggU().Lnt = null;
    AppMethodBeat.o(114675);
  }
  
  public final void fQZ()
  {
    AppMethodBeat.i(114688);
    if (!ghh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Lrx;
      localObject1 = localp.timeTV;
      long l = ac.ggS().Loq;
      ((TextView)localObject1).setText(String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) }));
      localObject1 = localp.timeTV;
      int i = ac.ggS().Loq;
      ((TextView)localObject1).setContentDescription(String.format(localp.Luv.getString(a.h.mutitalk_time_desc), new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
      Object localObject4 = localp.LoH;
      Object localObject5 = ac.ggS().Loj;
      List localList = ac.ggS().gew();
      localObject1 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).Lmu;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject1).Lsx;
        if (localObject1 != null)
        {
          Iterator localIterator = ((Iterable)localObject1).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localIterator.next()).Liv.ahhi;
            kotlin.g.b.s.s(localObject1, "it.member.usrName");
            localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).aMG((String)localObject1);
            if (localObject2 != null)
            {
              if (((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI != null)
              {
                i = 1;
                label247:
                if (i == 0) {
                  break label357;
                }
                label251:
                if (localObject2 == null) {
                  break label361;
                }
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI;
                if (localObject1 != null) {
                  break label363;
                }
                localObject1 = "";
                label273:
                if (!kotlin.g.b.s.p(z.bAM(), localObject1)) {
                  break label392;
                }
                localObject3 = ((com.tencent.mm.plugin.multitalk.model.a)localObject4).Lms;
                if ((localObject3 == null) || (((com.tencent.mm.plugin.multitalk.model.b)localObject3).bsA() != true)) {
                  break label387;
                }
                i = 1;
                label309:
                if (i == 0) {
                  break label392;
                }
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsJ;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(8);
                }
              }
              for (;;)
              {
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsI;
                if (localObject1 == null) {
                  break;
                }
                ((MultitalkFrameView)localObject1).ghK();
                break;
                i = 0;
                break label247;
                label357:
                localObject2 = null;
                break label251;
                label361:
                break;
                label363:
                localObject3 = ((MultitalkFrameView)localObject1).getUsername();
                localObject1 = localObject3;
                if (localObject3 != null) {
                  break label273;
                }
                localObject1 = "";
                break label273;
                label387:
                i = 0;
                break label309;
                label392:
                if ((localList != null) && (localList.contains(localObject1) == true))
                {
                  i = 1;
                  label412:
                  if (i == 0) {
                    break label468;
                  }
                  if ((localObject5 == null) || (((HashSet)localObject5).contains(localObject1))) {
                    break label463;
                  }
                }
                label463:
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label468;
                  }
                  localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsJ;
                  if (localObject1 == null) {
                    break;
                  }
                  ((ImageView)localObject1).setVisibility(0);
                  break;
                  i = 0;
                  break label412;
                }
                label468:
                localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsJ;
                if (localObject1 != null) {
                  ((ImageView)localObject1).setVisibility(8);
                }
              }
            }
          }
        }
      }
      if (localList != null) {
        com.tencent.mm.plugin.multitalk.model.o.abE(localList.size());
      }
      Object localObject3 = localp.LoH;
      localObject4 = ac.ggS();
      localObject2 = ((com.tencent.mm.plugin.multitalk.model.p)localObject4).Lol.LiU;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.multitalk.model.p)localObject4).Lol.ahhf;
      }
      boolean bool = ((com.tencent.mm.plugin.multitalk.model.p)localObject4).aNe(((com.tencent.mm.plugin.multitalk.model.p)localObject4).Lol.LiV);
      Log.d("MicroMsg.MT.MultiTalkManager", "getWeakNetworkMember: %s, groupid:%s, isILink:%b", new Object[] { u.g(((com.tencent.mm.plugin.multitalk.model.p)localObject4).Lol), ((com.tencent.mm.plugin.multitalk.model.p)localObject4).Lol.LiV, Boolean.valueOf(bool) });
      new ArrayList();
      if (bool)
      {
        localObject1 = com.tencent.mm.plugin.multitalk.c.o.Ljn.gey();
        localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).Lmu;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.a)localObject2).Lsx;
          if (localObject2 != null) {
            localObject4 = ((Iterable)localObject2).iterator();
          }
        }
      }
      else
      {
        label899:
        for (;;)
        {
          label664:
          if (!((Iterator)localObject4).hasNext()) {
            break label901;
          }
          localObject5 = (com.tencent.mm.plugin.multitalk.data.a)((Iterator)localObject4).next();
          if ((localObject1 != null) && (((List)localObject1).contains(((com.tencent.mm.plugin.multitalk.data.a)localObject5).Liv.ahhi) == true))
          {
            i = 1;
            label712:
            if (i == 0) {
              break label841;
            }
            localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localObject5).Liv.ahhi;
            kotlin.g.b.s.s(localObject2, "it.member.usrName");
            localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aMG((String)localObject2);
            if (localObject2 != null) {
              break label831;
            }
          }
          label831:
          for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsK)
          {
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(0);
            }
            bool = kotlin.g.b.s.p(z.bAM(), ((com.tencent.mm.plugin.multitalk.data.a)localObject5).Liv.ahhi);
            com.tencent.mm.plugin.multitalk.model.o.yU(bool);
            if (!bool) {
              break label664;
            }
            ac.ggT().ghA();
            break label664;
            if (v.LpI == null) {
              v.LpI = new v();
            }
            localObject1 = v.LpI.aNs((String)localObject1);
            break;
            i = 0;
            break label712;
          }
          label841:
          localObject2 = ((com.tencent.mm.plugin.multitalk.data.a)localObject5).Liv.ahhi;
          kotlin.g.b.s.s(localObject2, "it.member.usrName");
          localObject2 = ((com.tencent.mm.plugin.multitalk.model.a)localObject3).aMG((String)localObject2);
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.b)localObject2).LsK)
          {
            if (localObject2 == null) {
              break label899;
            }
            ((ImageView)localObject2).setVisibility(8);
            break;
          }
        }
      }
      label901:
      if (localp.Lwt != null)
      {
        localObject1 = localp.Lwt.LzU;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.i)localObject1).Lyk;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitalk.ui.widget.projector.h)localObject1).fQZ();
          }
        }
      }
    }
    Object localObject1 = this.Lry;
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject1).Lvh;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.f)localObject2).fQZ();
    }
    localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject1).Lvi;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject1).fQZ();
    }
    ac.ggU().gfj();
    AppMethodBeat.o(114688);
  }
  
  public void finish()
  {
    AppMethodBeat.i(285590);
    super.finish();
    if (this.Lrx != null) {
      this.Lrx.mHf = false;
    }
    if (this.orientationEventListener != null)
    {
      this.orientationEventListener.disable();
      this.orientationEventListener.KUU = null;
      this.orientationEventListener = null;
    }
    AppMethodBeat.o(285590);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(285538);
    if (this.Lrx != null) {
      this.Lrx.abV(10);
    }
    AppMethodBeat.o(285538);
  }
  
  public final void gau()
  {
    AppMethodBeat.i(114674);
    this.Lrw.ghs();
    this.Lrx.o(ac.ggS().Lol);
    this.Lrx.gau();
    AppMethodBeat.o(114674);
  }
  
  public final void geY()
  {
    AppMethodBeat.i(114676);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onExitMultiTalk");
    this.ooe = true;
    Object localObject = ac.ggS();
    if (((com.tencent.mm.plugin.multitalk.model.p)localObject).LoD != null) {
      ((com.tencent.mm.plugin.multitalk.model.p)localObject).LoD.ac(false, 1);
    }
    localObject = new os();
    ((os)localObject).hRy.action = 0;
    ((os)localObject).publish();
    this.eqE.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285256);
        MultiTalkMainUI.b(MultiTalkMainUI.this).zr(false);
        AppMethodBeat.o(285256);
      }
    });
    if (this.Lry != null) {
      this.Lry.gfc();
    }
    ac.ggS().Lnt = null;
    ac.ggU().Lnt = null;
    ac.ggS().stopRing();
    localObject = ac.ggS();
    if (((com.tencent.mm.plugin.multitalk.model.p)localObject).LoD != null) {
      ((com.tencent.mm.plugin.multitalk.model.p)localObject).LoD.ged();
    }
    if (ac.ggS().LoD != null) {
      com.tencent.mm.plugin.multitalk.b.b.unInit();
    }
    ac.ggU().release();
    finish();
    AppMethodBeat.o(114676);
  }
  
  public final void geZ()
  {
    AppMethodBeat.i(114673);
    switch (4.LrO[ac.ggS().Lok.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114673);
      return;
      this.Lrx.o(ac.ggS().Lol);
      AppMethodBeat.o(114673);
      return;
      this.Lrw.n(ac.ggS().Lol);
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(285545);
    if (!this.Lry.isShown())
    {
      AppMethodBeat.o(285545);
      return 1;
    }
    AppMethodBeat.o(285545);
    return 4;
  }
  
  public int getLayoutId()
  {
    return a.f.multitalk_main_ui;
  }
  
  public final void gfa()
  {
    AppMethodBeat.i(114678);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + ac.ggS().Loj.size());
    Object localObject;
    if (ac.ggS().gfW())
    {
      localObject = ac.ggS().Loj;
      if (((HashSet)localObject).size() <= 0) {
        break label160;
      }
      if ((((HashSet)localObject).size() != 1) || (!((HashSet)localObject).contains(z.bAM()))) {
        break label151;
      }
      ac.ggS().ggs();
    }
    for (;;)
    {
      if (!ghh())
      {
        localObject = this.Lrx;
        if (!((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).LoH.geG())
        {
          HashSet localHashSet = new HashSet(ac.ggS().Loj);
          if (u.abL(ac.ggS().Lod)) {
            ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).f(localHashSet);
          }
          com.tencent.mm.plugin.multitalk.model.o.abF(localHashSet.size());
        }
      }
      AppMethodBeat.o(114678);
      return;
      label151:
      ac.ggS().ggr();
      continue;
      label160:
      localObject = ac.ggS();
      Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
      if (((com.tencent.mm.plugin.multitalk.model.p)localObject).Lom != null) {
        ((com.tencent.mm.plugin.multitalk.model.p)localObject).Lom.stopVideo();
      }
    }
  }
  
  public final void gfb()
  {
    AppMethodBeat.i(285508);
    this.Lrx.zo(true);
    AppMethodBeat.o(285508);
  }
  
  public final void gfc()
  {
    AppMethodBeat.i(285526);
    setRequestedOrientation(1);
    Object localObject = com.tencent.mm.plugin.multitalk.e.g.LAS;
    com.tencent.mm.plugin.multitalk.e.g.gjj();
    ac.ggS().Lof = false;
    ac.ggS().Log = false;
    getIntent().removeExtra("enterMainUIScreenProjectOnline");
    getIntent().removeExtra("enterMainUIScreenProjectParams");
    this.Lry.gfc();
    ac.ggS().bl(1, false);
    this.Lrx.geM();
    localObject = this.Lrx;
    if (((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Lwo) {
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Lwl.setVisibility(0);
    }
    this.Lrx.LvP.setVisibility(0);
    com.tencent.mm.plugin.multitalk.ui.widget.p.ghC();
    this.Lrx.o(ac.ggS().Lol);
    localObject = this.Lrx;
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).LvU.setVisibility(0);
    ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).LvS.setVisibility(0);
    this.Lrx.gau();
    if ((ac.ggS().gfW()) && (this.eqE != null))
    {
      localObject = this.Lrx;
      ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).LoH.a(((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Lmp, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Lmq, ((com.tencent.mm.plugin.multitalk.ui.widget.p)localObject).Luv, (com.tencent.mm.plugin.multitalk.model.b)localObject);
      ac.ggS().ggt();
    }
    AppMethodBeat.o(285526);
  }
  
  public final void gfd()
  {
    AppMethodBeat.i(285531);
    Log.e("MicroMsg.MT.MultiTalkMainUI", "onCameraError");
    com.tencent.mm.ui.widget.a.e locale = com.tencent.mm.bc.e.a(this, a.h.voip_no_record_video_permission, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285266);
        ac.ggU().gfp();
        AppMethodBeat.o(285266);
      }
    });
    if (!locale.isShowing()) {
      locale.show();
    }
    ac.ggS().bl(1, ac.ggS().Lof);
    AppMethodBeat.o(285531);
  }
  
  public final void ghg()
  {
    AppMethodBeat.i(285420);
    if ((!this.LrI) && (ac.ggS().Lol != null))
    {
      this.LrI = true;
      Intent localIntent = new Intent();
      localIntent.putExtra("kintent_talker", ac.ggS().Lol.LiV);
      localIntent.putExtra("key_media_type", 2);
      localIntent.putExtra("scene", 3);
      com.tencent.mm.br.c.d(this, "com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI", localIntent, 3);
    }
    AppMethodBeat.o(285420);
  }
  
  public final boolean ghh()
  {
    AppMethodBeat.i(285429);
    if (this.Lry != null)
    {
      boolean bool = this.Lry.isShown();
      AppMethodBeat.o(285429);
      return bool;
    }
    AppMethodBeat.o(285429);
    return false;
  }
  
  public final void jQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114681);
    if (ac.ggS().gfW())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Lrx;
      if (!u.abK(paramInt2))
      {
        if (u.abK(paramInt1))
        {
          localp.Lwc.setChecked(false);
          localp.LoH.gf(z.bAM(), 0);
          localp.Lwa.setVisibility(8);
        }
        localp.zq(false);
      }
      HashSet localHashSet;
      for (;;)
      {
        localHashSet = new HashSet(ac.ggS().Loj);
        if (u.abL(paramInt2)) {
          break;
        }
        if (!u.abL(paramInt1)) {
          break label180;
        }
        localp.LoH.z(localHashSet);
        AppMethodBeat.o(114681);
        return;
        if ((u.abK(paramInt2)) && (!u.abK(paramInt1)))
        {
          localp.Lwc.setChecked(true);
          localp.LoH.gf(z.bAM(), 1);
          localp.Lwa.setVisibility(0);
          localp.ghJ();
        }
      }
      if ((u.abL(paramInt2)) && (!u.abL(paramInt1))) {
        localp.f(localHashSet);
      }
    }
    label180:
    AppMethodBeat.o(114681);
  }
  
  public final void n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(285612);
    this.eqE.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(285612);
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(114677);
    if (paramInt == -1700)
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Lrx;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
      localp.Lwc.setChecked(false);
      localp.zq(false);
      ac.ggS().bl(1, ac.ggS().Lof);
      com.tencent.mm.plugin.multitalk.model.o.gfQ();
      com.tencent.mm.plugin.multitalk.c.o.Ljn.drn();
      ac.ggT().LvB = false;
    }
    AppMethodBeat.o(114677);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(114672);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + paramInt1 + " resultCode " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.LrH = false;
    this.LrI = false;
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
      ac.ggS().iZ(paramIntent);
    }
    if ((paramInt1 == 1) && (this.Lrx != null) && (this.LrJ))
    {
      this.LrJ = false;
      if (this.LrK == 1)
      {
        this.Lrx.abU(5);
        AppMethodBeat.o(114672);
        return;
      }
      if (this.LrK == 2) {
        this.Lrx.abV(5);
      }
    }
    AppMethodBeat.o(114672);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(285517);
    super.onConfigurationChanged(paramConfiguration);
    if (ghh())
    {
      this.Lry.refreshView();
      AppMethodBeat.o(285517);
      return;
    }
    paramConfiguration = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
    k.a.d(this, true);
    paramConfiguration = this.Lrx;
    if (ac.ggS().geW())
    {
      paramConfiguration.Lmp.requestLayout();
      if (paramConfiguration.Lmp.getAdapter() != null) {
        paramConfiguration.Lmp.getAdapter().bZE.notifyChanged();
      }
      paramConfiguration.LvR.requestLayout();
    }
    AppMethodBeat.o(285517);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114664);
    super.onCreate(paramBundle);
    com.tencent.mm.util.e.hPY();
    ac.ggS().ggh();
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    this.LrD = bf.bg(getContext());
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
      ac.ggS().xz(false);
      if (ac.ggS().geX()) {
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
    this.Lrw = new com.tencent.mm.plugin.multitalk.ui.widget.g(this);
    this.Lrx = new com.tencent.mm.plugin.multitalk.ui.widget.p(this);
    this.Lry = new com.tencent.mm.plugin.multitalk.ui.widget.k(this);
    paramBundle = com.tencent.mm.plugin.ringtone.c.OBr;
    if ((com.tencent.mm.plugin.ringtone.c.gOh()) || ((ac.ggS().geW()) && (ac.ggS().dro()))) {
      ac.ggS().zb(ac.ggS().snA);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.LrL, paramBundle);
    this.LrA = true;
    this.eqE = new MMHandler();
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "")) {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
    }
    if (com.tencent.mm.compatible.util.d.rb(26))
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
      this.LrC = new MultiTalkMainUI.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      MMApplicationContext.getContext().registerReceiver(this.LrC, paramBundle);
    }
    this.qSv = ((Notification)getIntent().getParcelableExtra("notification"));
    this.JPY = new com.tencent.mm.plugin.voip.c.b(new com.tencent.mm.plugin.ball.a.e(this));
    this.JPY.J(9, "VOIPFloatBall");
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this);
    this.orientationEventListener.enable();
    this.orientationEventListener.KUU = this;
    LrF = false;
    AppMethodBeat.o(114664);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114667);
    if ((this.LrH) || (this.LrI) || (this.LrJ)) {
      ac.ggS().za(false);
    }
    if (this.LrA) {
      unregisterReceiver(this.LrL);
    }
    if (this.Lry != null)
    {
      Object localObject = this.Lry;
      boolean bool = ac.ggS().JFE;
      com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject).Lvh;
      if (localf != null) {
        localf.zx(bool);
      }
      localObject = ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject).Lvi;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.widget.projector.d)localObject).zx(bool);
      }
    }
    this.LrM.removeCallbacksAndMessages(null);
    this.LrM.sendEmptyMessage(1);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
    try
    {
      if ((com.tencent.mm.compatible.util.d.rb(26)) && (this.LrB))
      {
        MMApplicationContext.getContext().unbindService(this);
        this.LrB = false;
      }
      if (com.tencent.mm.compatible.util.d.rb(26))
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
        if (this.LrC == null) {}
      }
    }
    catch (Exception localException1)
    {
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(this.LrC);
        this.LrC = null;
        cXB().getViewTreeObserver().removeOnGlobalLayoutListener(this.LrE);
        super.onDestroy();
        if (this.JPY != null) {
          this.JPY.onDestroy();
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
      if (ghh())
      {
        paramKeyEvent = this.Lry;
        com.tencent.mm.plugin.multitalk.ui.widget.projector.f localf = paramKeyEvent.Lvh;
        if (localf != null) {
          localf.onBack();
        }
        paramKeyEvent = paramKeyEvent.Lvi;
        if (paramKeyEvent != null) {
          paramKeyEvent.onBack();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(114669);
        return true;
        paramKeyEvent = this.Lrx;
        paramInt = i;
        if (paramKeyEvent.LoH != null)
        {
          paramInt = i;
          if (paramKeyEvent.LoH.geG())
          {
            paramKeyEvent.geM();
            paramKeyEvent.Lwl.exz();
            paramKeyEvent.LoH.geF();
            paramInt = 1;
          }
        }
        if (paramInt == 0) {
          com.tencent.mm.ui.base.k.a(this, a.h.multitalk_exit_tip, a.h.multitalk, a.h.app_alert_exit, a.h.app_cancel, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(285274);
              ac.ggS().j(false, false, false);
              AppMethodBeat.o(285274);
            }
          }, null);
        }
      }
    }
    if (ac.ggS().Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK)
    {
      if ((paramInt == 25) || (paramInt == 24))
      {
        ac.ggS().stopRing();
        this.Lrz = false;
        AppMethodBeat.o(114669);
        return true;
      }
    }
    else
    {
      if (paramInt == 25)
      {
        paramKeyEvent = ac.ggS();
        if (paramKeyEvent.LoD != null) {
          paramKeyEvent.LoD.EZ(com.tencent.mm.plugin.multitalk.b.b.fwf());
        }
        AppMethodBeat.o(114669);
        return true;
      }
      if (paramInt == 24)
      {
        paramKeyEvent = ac.ggS();
        if (paramKeyEvent.LoD != null) {
          paramKeyEvent.LoD.EY(com.tencent.mm.plugin.multitalk.b.b.fwf());
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
    AppMethodBeat.i(285437);
    super.onNewIntent(paramIntent);
    if ((ac.ggS().gfW()) && (this.eqE != null))
    {
      this.eqE.removeCallbacksAndMessages(null);
      this.eqE.postDelayed(this.LrG, 2000L);
    }
    paramIntent = paramIntent.getStringExtra("filePath");
    if (paramIntent != null)
    {
      Bundle localBundle = new Bundle();
      int i = paramIntent.lastIndexOf(".") + 1;
      if (i >= paramIntent.length())
      {
        Log.i("MicroMsg.MT.MultiTalkMainUI", "open file error : file path error");
        AppMethodBeat.o(285437);
        return;
      }
      String str = paramIntent.substring(i);
      localBundle.putString("file_path", paramIntent);
      localBundle.putString("file_ext", str);
      this.Lry.ghu();
      this.Lry.aI(localBundle);
      ac.ggS();
      com.tencent.mm.plugin.multitalk.model.o.gfF();
      if (this.Lry.isShown())
      {
        this.Lrw.ghs();
        this.Lrx.ghE();
        this.Lrx.bty();
        this.Lrx.geN();
        this.Lrx.LvP.setVisibility(8);
        this.Lrx.ghH();
        this.Lrx.ghG();
        this.Lrx.LoH.geE();
        this.LrI = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(285437);
        return;
      }
      this.Lrw.ghs();
      this.Lrx.o(ac.ggS().Lol);
      this.Lrx.gau();
    }
    AppMethodBeat.o(285437);
  }
  
  public void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(285596);
    if (ghh())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.k localk = this.Lry;
      kotlin.g.b.s.u(this, "context");
      if (k.a.iY(this) != localk.Lvj)
      {
        localk.refreshView();
        if ((k.a.iY(this) == 90) || (k.a.iY(this) == 270)) {
          com.tencent.mm.plugin.multitalk.model.o.LnZ += 1;
        }
      }
      AppMethodBeat.o(285596);
      return;
    }
    this.Lrx.abW(paramInt);
    AppMethodBeat.o(285596);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(114666);
    ac.ggS().ggs();
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3))
    {
      bool1 = true;
      this.Lrq = bool1;
      Log.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[] { Boolean.valueOf(this.Lrq) });
      if (ac.ggS().gfW()) {
        this.Lrx.zq(true);
      }
      if ((this.LrI) || (this.LrH) || (this.LrJ) || (ghh())) {
        break label194;
      }
      if (this.JPY != null)
      {
        this.JPY.bhW();
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
    }
    for (;;)
    {
      if (!ghh()) {
        break label231;
      }
      com.tencent.mm.plugin.voip.c.a.a.Uvh.Gi(true);
      AppMethodBeat.o(114666);
      return;
      bool1 = false;
      break;
      label194:
      if ((ghh()) && (this.JPY != null) && (!this.LrJ)) {
        this.JPY.hVv();
      }
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    }
    label231:
    com.tencent.mm.plugin.voip.c.a.a.Uvh.Gi(false);
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
      com.tencent.mm.ui.base.k.a(this, getString(a.h.permission_microphone_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114659);
          com.tencent.mm.pluginsdk.permission.b.lx(MultiTalkMainUI.this.getContext());
          AppMethodBeat.o(114659);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114660);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(114660);
        }
      });
      AppMethodBeat.o(114690);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
        AppMethodBeat.o(114690);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(a.h.permission_camera_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(285245);
          com.tencent.mm.pluginsdk.permission.b.lx(MultiTalkMainUI.this.getContext());
          AppMethodBeat.o(285245);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(285263);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(285263);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114665);
    Log.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
    super.onResume();
    this.ooe = false;
    ac.ggS().JFE = false;
    ac.ggS().Lnt = this;
    ac.ggU().Lnt = this;
    cXB().getViewTreeObserver().addOnGlobalLayoutListener(this.LrE);
    Object localObject1 = ac.ggS().ggc();
    Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.s)localObject1).Lpv;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.mm.plugin.multitalk.model.s)localObject1).aNr((String)((Iterator)localObject2).next());
      }
    }
    if ((this.JPY != null) && (!this.LrJ))
    {
      this.JPY.bhT();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    localObject1 = (com.tencent.mm.plugin.appbrand.backgroundrunning.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).cjP();
      ((com.tencent.mm.plugin.appbrand.backgroundrunning.g)localObject1).cjQ();
    }
    localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.ball.c.b)localObject1).l(new BallInfo(6, "MusicFloatBall"));
    }
    if (ac.ggS().gfW()) {
      this.eqE.postDelayed(this.LrG, 2000L);
    }
    if (ghh())
    {
      ac.ggS();
      com.tencent.mm.plugin.multitalk.model.p.abJ(101);
      ac.ggS().Lof = true;
      ac.ggS().Log = false;
      switch (4.LrO[ac.ggS().Lok.ordinal()])
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
      this.Lry.ghu();
      this.Lry.aI((Bundle)localObject1);
      if (this.Lry.isShown())
      {
        this.Lrx.bty();
        this.Lrw.ghs();
        this.Lrx.ghE();
        this.Lrx.geN();
        this.Lrx.ghH();
        this.Lrx.ghG();
        this.LrI = false;
        setRequestedOrientation(4);
        AppMethodBeat.o(114665);
        return;
      }
      this.Lrw.ghs();
      this.Lrx.o(ac.ggS().Lol);
      this.Lrx.gau();
      AppMethodBeat.o(114665);
      return;
      this.Lrx.ghH();
      this.Lrw.n(ac.ggS().Lol);
      if (NetStatusUtil.is4G(this)) {
        ac.ggQ().ba(this);
      }
      while (this.Lrz)
      {
        ac.ggS().zd(false);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ac.ggQ().aZ(this);
        }
      }
      this.Lrw.ghs();
      this.Lrx.o(ac.ggS().Lol);
      if (NetStatusUtil.is4G(this)) {
        ac.ggQ().ba(this);
      }
      for (;;)
      {
        ac.ggS().zd(true);
        AppMethodBeat.o(114665);
        return;
        if ((NetStatusUtil.is2G(this)) || (NetStatusUtil.is3G(this))) {
          ac.ggQ().aZ(this);
        }
      }
      if (this.Lry.isShown())
      {
        this.Lrw.ghs();
        this.Lrx.geN();
        this.Lrx.ghH();
        AppMethodBeat.o(114665);
        return;
      }
      this.Lrw.ghs();
      this.Lrx.o(ac.ggS().Lol);
      this.Lrx.gau();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStop()
  {
    AppMethodBeat.i(114668);
    if ((ghh()) && (this.Lrq))
    {
      ac.ggS();
      com.tencent.mm.plugin.multitalk.model.p.abJ(102);
      ac.ggS().Lof = false;
      ac.ggS().Log = true;
      ac.ggS().bl(1, true);
    }
    if ((!this.LrH) && (!this.LrI) && (!this.LrJ) && (this.Lrq) && (!this.ooe) && (!LrF)) {
      ac.ggS().za(false);
    }
    super.onStop();
    AppMethodBeat.o(114668);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(285361);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.multitalk.a.a.class);
    AppMethodBeat.o(285361);
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(114679);
    if (ac.ggS().gfW())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Lrx;
      com.tencent.threadpool.h.ahAA.bk(new p.9(localp, paramBoolean));
    }
    AppMethodBeat.o(114679);
  }
  
  public final void yO(boolean paramBoolean)
  {
    AppMethodBeat.i(114680);
    if (ac.ggS().gfW())
    {
      com.tencent.mm.plugin.multitalk.ui.widget.p localp = this.Lrx;
      Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.threadpool.h.ahAA.bk(new p.10(localp, paramBoolean));
    }
    AppMethodBeat.o(114680);
  }
  
  public final void yP(boolean paramBoolean)
  {
    AppMethodBeat.i(114682);
    if (ac.ggS().gfW()) {
      this.Lrx.yP(paramBoolean);
    }
    AppMethodBeat.o(114682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI
 * JD-Core Version:    0.7.0.1
 */