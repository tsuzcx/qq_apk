package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.z.a.a;
import java.util.HashMap;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, n.b
{
  private Bitmap Blc;
  private RelativeLayout Ffv;
  private FrameLayout Ffw;
  private LinearLayout Ffx;
  private boolean Ffy;
  private b JdA;
  private boolean JdB;
  private AccountInfoPreference JdC;
  private RelativeLayout JdD;
  private int JdE;
  private int JdF;
  private int JdG;
  private int JdH;
  private boolean JdI;
  private boolean JdJ;
  private boolean JdK;
  private boolean JdL;
  private com.tencent.mm.aw.a.c.h JdM;
  public boolean JdN;
  private boolean JdO;
  public boolean JdP;
  private int JdQ;
  private int JdR;
  private a JdS;
  PullDownListView Jdx;
  private RelativeLayout Jdy;
  private View Jdz;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean rmt;
  private com.tencent.mm.ui.base.preference.f screen;
  private AbsStoryGallery wQh;
  private AbsStoryMuteView wQi;
  private View wQq;
  private boolean wSK;
  private byte[] yDS;
  private a.a yJC;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.Blc = null;
    this.yDS = null;
    this.wQi = null;
    this.Jdy = null;
    this.Jdz = null;
    this.wQh = null;
    this.JdA = new b((byte)0);
    this.wSK = false;
    this.JdB = false;
    this.JdC = null;
    this.Ffy = false;
    this.Ffv = null;
    this.Ffw = null;
    this.JdD = null;
    this.Ffx = null;
    this.JdE = 0;
    this.JdF = 0;
    this.JdG = 0;
    this.JdH = 0;
    this.rmt = false;
    this.JdI = false;
    this.JdJ = false;
    this.JdK = false;
    this.JdL = false;
    this.yJC = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33523);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 266267) || (paramAnonymousInt == 262158))
        {
          MoreTabUI.a(MoreTabUI.this);
          MoreTabUI.b(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.f(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33523);
          return;
          if (paramAnonymousInt == 262147) {
            MoreTabUI.c(MoreTabUI.this);
          } else if (paramAnonymousInt == 262156) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousInt == 262152) {
            MoreTabUI.e(MoreTabUI.this);
          } else if (paramAnonymousInt == 352279) {
            MoreTabUI.a(MoreTabUI.this, paramAnonymousString);
          }
        }
      }
      
      public final void b(al.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == al.a.Irp) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.f(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == al.a.Irq) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == al.a.IAC) || (paramAnonymousa == al.a.ICh)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == al.a.IDj) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.JdM = new com.tencent.mm.aw.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.JdV.acp(0);
            this.JdV.aco(2131233400);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.f(MoreTabUI.this).aVD("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.aH(this.iUT);
              paramAnonymousString.acp(0);
              AppMethodBeat.o(33540);
            }
          });
          AppMethodBeat.o(33543);
          return;
        }
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33541);
            paramAnonymousString.aH(null);
            paramAnonymousString.acp(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
    };
    this.JdN = true;
    this.JdO = true;
    this.JdP = true;
    this.JdQ = com.tencent.mm.cc.a.fromDPToPix(getContext(), 48);
    this.JdR = com.tencent.mm.cc.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void MJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(33532);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).RY(paramAnonymousInt);
        }
        AppMethodBeat.o(33532);
      }
      
      public final void MK(int paramAnonymousInt)
      {
        AppMethodBeat.i(33533);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).RZ(paramAnonymousInt);
        }
        AppMethodBeat.o(33533);
      }
      
      public final void ML(int paramAnonymousInt)
      {
        AppMethodBeat.i(33534);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).ML(paramAnonymousInt);
        }
        AppMethodBeat.o(33534);
      }
      
      public final void dAA()
      {
        AppMethodBeat.i(33528);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).egG();
        }
        if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
        {
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.eks().emL = System.currentTimeMillis();
          localh = com.tencent.mm.plugin.story.h.h.ASt;
          com.tencent.mm.plugin.story.h.h.ekt();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).Ffz = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33528);
      }
      
      public final void dAB()
      {
        AppMethodBeat.i(33529);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).egH();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).Ffz = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33529);
      }
      
      public final void dAC()
      {
        AppMethodBeat.i(33530);
        ad.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.w(MoreTabUI.this).egM();
        AppMethodBeat.o(33530);
      }
      
      public final void dAD()
      {
        AppMethodBeat.i(33531);
        MoreTabUI.w(MoreTabUI.this).egN();
        AppMethodBeat.o(33531);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(33527);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            MoreTabUI.l(MoreTabUI.this).sg(true);
            MoreTabUI.l(MoreTabUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33525);
                MoreTabUI.s(MoreTabUI.this);
                MoreTabUI.a(MoreTabUI.this, 0);
                MoreTabUI.b(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
                if (MoreTabUI.t(MoreTabUI.this) != null) {
                  MoreTabUI.t(MoreTabUI.this).setTranslationY(0.0F);
                }
                AppMethodBeat.o(33525);
              }
            });
          }
          MoreTabUI.a(MoreTabUI.this, false);
          if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
            MoreTabUI.o(MoreTabUI.this).feE();
          }
          MoreTabUI.u(MoreTabUI.this).dAz();
          if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
          {
            long l = System.currentTimeMillis();
            com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
            com.tencent.mm.plugin.story.h.h.AS(l);
            localh = com.tencent.mm.plugin.story.h.h.ASt;
            com.tencent.mm.plugin.story.h.h.eks().ely = l;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V");
          AppMethodBeat.o(33527);
          return;
        }
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(33526);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).dw(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.ASt;
            com.tencent.mm.plugin.story.h.h.ejZ().elh = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.ASt;
            com.tencent.mm.plugin.story.h.h.ejZ().emG = 1L;
            MoreTabUI.l(MoreTabUI.this).ak(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.m(MoreTabUI.this);
            MoreTabUI.n(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).feD();
          }
          if ((!MoreTabUI.p(MoreTabUI.this)) && (!MoreTabUI.q(MoreTabUI.this)))
          {
            int i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFD, 0);
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFD, Integer.valueOf(i + 1));
            MoreTabUI.r(MoreTabUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
          AppMethodBeat.o(33526);
          return;
        }
      }
    };
    this.JdS = new a();
    AppMethodBeat.o(33555);
  }
  
  private void abR(int paramInt)
  {
    AppMethodBeat.i(33576);
    View localView = findViewById(2131296345);
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      ad.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33576);
      return;
    }
    ad.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
    AppMethodBeat.o(33576);
  }
  
  private void fxn()
  {
    AppMethodBeat.i(33559);
    if (!this.JdI)
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFD, 0);
      boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IFq, false);
      ad.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.wSK) && ((bool) || (i > 0)))
      {
        this.JdI = true;
        if (this.JdC != null) {
          this.JdC.aO(this.wSK, this.JdI);
        }
        if (!this.JdI) {
          break label145;
        }
      }
    }
    label145:
    for (int i = com.tencent.mm.cc.a.ay(getContext(), 2131166722);; i = com.tencent.mm.cc.a.ay(getContext(), 2131166721))
    {
      this.JdG = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void fxo()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.bs.d.aIu("sns"))
    {
      this.screen.cP("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.cP("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IFM, true)) && (this.JdK))
      {
        localIconPreference.acn(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.JdK = false;
      localIconPreference.acn(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void fxp()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).bVk()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).bVl())) || (!com.tencent.mm.bs.d.aIu("card")))
    {
      this.screen.cP("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).bVm();; localObject1 = "")
    {
      this.screen.cP("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aVD("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.z.c.aht().cJ(262152, 266256);
      boolean bool3 = com.tencent.mm.z.c.aht().cI(262152, 266256);
      boolean bool4 = com.tencent.mm.z.c.aht().a(al.a.Irp, al.a.Irr);
      boolean bool5 = com.tencent.mm.z.c.aht().a(al.a.Irq, al.a.Irs);
      ba.aBQ();
      String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iry, "");
      localNormalIconNewTipPreference.setTitle(2131763275);
      com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.dun().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.wkP = this.JdM;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.acl(0);
        localNormalIconNewTipPreference.gw(getString(2131755829), 2131233430);
        localNormalIconNewTipPreference.acn(8);
        localNormalIconNewTipPreference.setSummary(null);
        localNormalIconNewTipPreference.aH(null);
        localNormalIconNewTipPreference.acp(8);
        localNormalIconNewTipPreference.gx("", -1);
        localNormalIconNewTipPreference.acm(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsM, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131165965);
        Object localObject2 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.arU();
        q.aIK();
        ((com.tencent.mm.aw.a.a.c.a)localObject2).idJ = null;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).idr = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hfi = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).idp = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hdS = i;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hdR = i;
        localObject2 = ((com.tencent.mm.aw.a.a.c.a)localObject2).aJc();
        q.aIJ().a(str, localNormalIconNewTipPreference.fzB(), (com.tencent.mm.aw.a.a.c)localObject2, this.JdM);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsO, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.acn(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsL, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.gw("", -1);
          localNormalIconNewTipPreference.acl(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.setSummary(null);
            if (!af.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aU((String)localObject1, -1, getResources().getColor(2131100490));
              localNormalIconNewTipPreference.acm(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsN, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aH(null);
              localNormalIconNewTipPreference.acp(8);
              break;
              label633:
              localNormalIconNewTipPreference.acn(8);
              continue;
            }
            localNormalIconNewTipPreference.gx("", -1);
            localNormalIconNewTipPreference.acm(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.gx("", -1);
          localNormalIconNewTipPreference.acm(8);
          if (!af.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsN, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.setSummary(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.acm(8);
      localNormalIconNewTipPreference.acl(8);
      localNormalIconNewTipPreference.setSummary(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void fxq()
  {
    AppMethodBeat.i(33566);
    this.screen.cP("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.screen.aVD("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.acq(8);
      bool = com.tencent.mm.z.c.aht().cI(262145, 266242);
      if (bool)
      {
        localIconPreference.acl(0);
        localIconPreference.gw(getString(2131755829), 2131233430);
      }
      for (;;)
      {
        localIconPreference.acn(8);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(33566);
        return;
        localIconPreference.acl(8);
        localIconPreference.gw("", -1);
      }
      ba.aBQ();
      i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iyn, Integer.valueOf(0))).intValue();
      ba.aBQ();
      int j = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iyo, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).eWr()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).eWs()) || (i > j)) && (!bool))
      {
        localIconPreference.acn(0);
        localIconPreference.acl(8);
        localIconPreference.gw("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acn(8);
      if (com.tencent.mm.z.c.aht().cJ(262157, 266261))
      {
        localIconPreference.acn(0);
        localIconPreference.acl(8);
        localIconPreference.gw("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acn(8);
      if (com.tencent.mm.z.c.aht().cJ(262158, 266264))
      {
        localIconPreference.acn(0);
        localIconPreference.acl(8);
        localIconPreference.gw("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      if (com.tencent.mm.z.c.aht().a(al.a.IDj, 266242))
      {
        localIconPreference.acn(0);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acn(8);
      ba.aBQ();
      if ((com.tencent.mm.model.c.ajl().getInt(40, 0) & 0x20000) != 0) {
        break label610;
      }
    }
    label610:
    for (int i = 1;; i = 0)
    {
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("VoiceprintEntry"), 0) == 1) {
        ba.aBQ();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IqS, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ad.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.acn(0);
          AppMethodBeat.o(33566);
          return;
        }
        localIconPreference.acn(8);
        com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.duo().LT(com.tencent.mm.plugin.newtips.a.d.wsi);
        if ((locala != null) && (!locala.field_isExit)) {
          com.tencent.mm.plugin.newtips.a.dun().wsI = new i.a()
          {
            public final void e(com.tencent.mm.plugin.newtips.b.a paramAnonymousa)
            {
              AppMethodBeat.i(33546);
              if ((paramAnonymousa != null) && (paramAnonymousa.field_tipId == com.tencent.mm.plugin.newtips.a.d.wsi))
              {
                com.tencent.mm.plugin.newtips.a.duq();
                if (com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsi))
                {
                  localIconPreference.acn(0);
                  localIconPreference.acl(8);
                  localIconPreference.gw("", -1);
                  AppMethodBeat.o(33546);
                  return;
                }
              }
              AppMethodBeat.o(33546);
            }
          };
        }
        while (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).hasSettingTabRedDot())
        {
          localIconPreference.acn(0);
          AppMethodBeat.o(33566);
          return;
          com.tencent.mm.plugin.newtips.a.duq();
          if (com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsi))
          {
            localIconPreference.acn(0);
            localIconPreference.acl(8);
            localIconPreference.gw("", -1);
            AppMethodBeat.o(33566);
            return;
          }
        }
        localIconPreference.acn(8);
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void fxr()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.bs.d.aIu("emoji"))
    {
      com.tencent.mm.bs.d.ffH();
      this.screen.cP("settings_emoji_store", false);
      bool1 = com.tencent.mm.z.c.aht().cI(262147, 266244);
      bool2 = com.tencent.mm.z.c.aht().cI(262149, 266244);
      localIconPreference = (IconPreference)this.screen.aVD("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.cP("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.acl(0);
      localIconPreference.gw(getString(2131755829), 2131233430);
    }
    while ((bool2) || (bool1))
    {
      ba.aBQ();
      String str = (String)com.tencent.mm.model.c.ajl().get(229633, null);
      q.aIJ().a(str, localIconPreference.fzB(), new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(33551);
          if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null))
          {
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.16.this.JdY.aH(this.iUT);
                MoreTabUI.16.this.JdY.acp(0);
                AppMethodBeat.o(33549);
              }
            });
            AppMethodBeat.o(33551);
            return;
          }
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33550);
              MoreTabUI.16.this.JdY.acp(8);
              AppMethodBeat.o(33550);
            }
          });
          AppMethodBeat.o(33551);
        }
      });
      AppMethodBeat.o(33567);
      return;
      if (bool2)
      {
        localIconPreference.acl(0);
        localIconPreference.gw(getString(2131755781), 2131233430);
      }
      else
      {
        localIconPreference.acl(8);
        localIconPreference.gw("", -1);
      }
    }
    localIconPreference.acp(8);
    AppMethodBeat.o(33567);
  }
  
  private void fxs()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = com.tencent.mm.model.u.aAw();
    ad.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.cP("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (bt.jx(i, -1)) {
        break label156;
      }
      if ((i & 0x8000) == 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label156;
      }
      if (!bool2) {
        break label144;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label144:
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1056L, 0L, 1L, false);
    label156:
    AppMethodBeat.o(33568);
  }
  
  private void fxt()
  {
    AppMethodBeat.i(33569);
    ba.aBQ();
    int i = af.h((Integer)com.tencent.mm.model.c.ajl().get(204820, null));
    ba.aBQ();
    int j = i + af.h((Integer)com.tencent.mm.model.c.ajl().get(204817, null));
    boolean bool3 = com.tencent.mm.z.c.aht().cI(262156, 266248);
    boolean bool4 = com.tencent.mm.z.c.aht().cJ(262156, 266248);
    boolean bool5 = com.tencent.mm.z.c.aht().b(al.a.IAC, al.a.IAE);
    ba.aBQ();
    String str2 = (String)com.tencent.mm.model.c.ajl().get(al.a.IAF, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aVD("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    ad.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    ad.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.dun().h(localNormalIconNewTipPreference);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    ba.aBQ();
    String str3 = (String)com.tencent.mm.model.c.ajl().get(al.a.IzZ, "");
    ba.aBQ();
    int k = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.IAa, Integer.valueOf(-1))).intValue();
    boolean bool2;
    boolean bool1;
    if (!bool3)
    {
      bool2 = bool4;
      bool1 = bool3;
      if (!bool4) {}
    }
    else
    {
      ba.aBQ();
      l1 = ((Long)com.tencent.mm.model.c.ajl().get(al.a.IzX, Long.valueOf(-1L))).longValue();
      long l2 = af.wn(com.tencent.mm.n.g.acA().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      ad.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
      bool2 = bool4;
      bool1 = bool3;
      if (l1 > 0L)
      {
        bool2 = bool4;
        bool1 = bool3;
        if (l2 > 0L)
        {
          bool2 = bool4;
          bool1 = bool3;
          if (d >= l2)
          {
            bool1 = false;
            com.tencent.mm.z.c.aht().w(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.ajD();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICd, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.ajD();
    long l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICe, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      ad.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICd, Boolean.FALSE);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICe, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.ajD();
      Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICa, "");
      ad.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.z.c.aht().b(al.a.ICh, al.a.ICn);
      com.tencent.mm.kernel.g.ajD();
      l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICj, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        ad.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.z.c.aht().c(al.a.ICh, al.a.ICn);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICj, Long.valueOf(0L));
      }
      for (;;)
      {
        bool3 |= bool2;
        com.tencent.mm.kernel.g.ajD();
        String str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICg, "");
        ad.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), str1 });
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        if (bool3)
        {
          i = 1;
          localg.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
          ad.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
          if ((!bool5) && (!bool1) && (j <= 0) && (!bool3) && (k != 1)) {
            break label921;
          }
        }
        label921:
        for (bool2 = true;; bool2 = false)
        {
          if (!com.tencent.mm.plugin.newtips.a.g.a(bool2, localNormalIconNewTipPreference)) {
            break label927;
          }
          AppMethodBeat.o(33569);
          return;
          i = 0;
          break;
        }
        label927:
        if (bool5) {
          if (!bt.isNullOrNil(str2))
          {
            localNormalIconNewTipPreference.acm(0);
            localNormalIconNewTipPreference.aU(str2, -1, -7566196);
            localNormalIconNewTipPreference.xF(true);
            localNormalIconNewTipPreference.acn(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsN, true);
            if (bt.isNullOrNil(str1)) {
              break label1380;
            }
            localObject = str1;
          }
        }
        label1380:
        for (;;)
        {
          if ((!af.isNullOrNil((String)localObject)) && (bool3))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject);
            AppMethodBeat.o(33569);
            return;
            localNormalIconNewTipPreference.gx("", -1);
            localNormalIconNewTipPreference.acm(8);
            localNormalIconNewTipPreference.acn(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsL, true);
            break;
            if (bool1)
            {
              localNormalIconNewTipPreference.acl(0);
              localNormalIconNewTipPreference.gw(getString(2131755829), 2131233430);
              localNormalIconNewTipPreference.acn(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsM, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.acl(0);
              localNormalIconNewTipPreference.gw(getString(2131764343), com.tencent.mm.ui.tools.u.kE(getContext()));
              localNormalIconNewTipPreference.acn(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsQ, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.acl(0);
              localNormalIconNewTipPreference.gw(String.valueOf(j), com.tencent.mm.ui.tools.u.aP(getContext(), j));
              localNormalIconNewTipPreference.acn(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsQ, true);
              break;
            }
            if (bool3)
            {
              localNormalIconNewTipPreference.gw("", -1);
              localNormalIconNewTipPreference.acl(8);
              localNormalIconNewTipPreference.acn(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsL, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.gw("", -1);
              localNormalIconNewTipPreference.acl(8);
              localNormalIconNewTipPreference.acm(0);
              localNormalIconNewTipPreference.xF(true);
              if (!af.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.aU(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.acq(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wsN, true);
              break;
            }
            localNormalIconNewTipPreference.gw("", -1);
            localNormalIconNewTipPreference.acl(8);
            localNormalIconNewTipPreference.acn(8);
            localNormalIconNewTipPreference.acm(8);
            localNormalIconNewTipPreference.gx("", -1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
            break;
          }
          localNormalIconNewTipPreference.setSummary("");
          AppMethodBeat.o(33569);
          return;
        }
      }
    }
  }
  
  private boolean fxu()
  {
    AppMethodBeat.i(33571);
    com.tencent.mm.plugin.flutter.a.c localc = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
    ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), localc);
    AppMethodBeat.o(33571);
    return true;
  }
  
  private void fxv()
  {
    AppMethodBeat.i(33575);
    this.wQh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.AHW, null);
    if (this.wQh != null)
    {
      this.wQh.egJ();
      this.JdH = (-(ar.ci(getContext()).y / 10));
      if (!this.JdI) {
        break label239;
      }
    }
    label239:
    for (int i = com.tencent.mm.cc.a.ay(getContext(), 2131166722);; i = com.tencent.mm.cc.a.ay(getContext(), 2131166721))
    {
      this.JdG = i;
      this.JdF = (-com.tencent.mm.cc.a.fromDPToPix(getContext(), 330));
      this.JdE = 0;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ar.ci(getContext()).y);
      localLayoutParams.topMargin = this.JdH;
      localLayoutParams.bottomMargin = (-ar.ej(getContext()));
      this.Jdy.addView(this.wQh, 0, localLayoutParams);
      this.Jdx.B(this.wQh, this.JdG, this.JdH);
      this.Jdx.setNavigationBarHeight(ar.ej(getActivity()));
      this.wQh.setDataSeed(com.tencent.mm.model.u.aAm());
      this.wQh.a(this.Jdx);
      this.wQh.setStoryBrowseUIListener(this);
      this.JdA.fxw();
      AppMethodBeat.o(33575);
      return;
    }
  }
  
  private boolean xo(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.t.c.mpU.a(com.tencent.mm.plugin.appbrand.t.c.a.mpY);
    com.tencent.mm.plugin.appbrand.t.c.mpU.a(com.tencent.mm.plugin.appbrand.t.c.a.mqk);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.bs.d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void xp(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.wQq == null)
      {
        View localView = findViewById(2131296345);
        if (localView != null) {
          this.wQq = localView.findViewById(2131296343);
        }
        if (this.wQq == null) {
          break label104;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.wQq == null) {
          break label117;
        }
        if (!paramBoolean) {
          break;
        }
        this.wQq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33537);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.j(MoreTabUI.this)) {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33537);
              return;
              if ((MoreTabUI.k(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this).isVisible)) {
                MoreTabUI.k(MoreTabUI.this).fMF();
              }
            }
          }
        });
        AppMethodBeat.o(33587);
        return;
        label104:
        bool = false;
      }
      this.wQq.setOnClickListener(null);
    }
    label117:
    AppMethodBeat.o(33587);
  }
  
  private void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.Jdx != null) && (this.Jdx.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().xi(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33570);
    int i = af.cd(paramObject);
    ad.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    ba.aBQ();
    if ((paramn != com.tencent.mm.model.c.ajl()) || (i <= 0))
    {
      ad.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      fxt();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      fxs();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      fxr();
    }
    AppMethodBeat.o(33570);
  }
  
  public final void dAt()
  {
    AppMethodBeat.i(33584);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.Jdx != null) && (!this.Jdx.isVisible)) {
      this.Jdx.fME();
    }
    if ((!o.isShowStoryCheck()) || (this.rmt)) {
      this.JdA.abS(2);
    }
    for (;;)
    {
      if (this.JdC != null) {
        this.JdC.feD();
      }
      AppMethodBeat.o(33584);
      return;
      this.JdA.abS(1);
    }
  }
  
  public final void dAu()
  {
    AppMethodBeat.i(33585);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.Jdx != null) && (this.Jdx.isVisible) && (this.JdJ))
    {
      if (!this.rmt) {
        break label106;
      }
      this.JdA.abS(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.aVD("settings_my_album");
      if (localIconPreference == null) {
        break label128;
      }
      if (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IFM, true)) {
        break;
      }
      this.JdK = true;
      localIconPreference.acn(0);
      AppMethodBeat.o(33585);
      return;
      label106:
      this.JdA.abS(0);
    }
    this.JdK = false;
    localIconPreference.acn(8);
    label128:
    AppMethodBeat.o(33585);
  }
  
  public final void dAv()
  {
    AppMethodBeat.i(33586);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.Jdx != null) && (!this.Jdx.isVisible)) {
      this.Jdx.fME();
    }
    abR(0);
    xq(this.wSK);
    AppMethodBeat.o(33586);
  }
  
  final void dAx()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  protected final void fuF()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.rmt = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label247;
      }
    }
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.JdL = bool1;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.cb(getContext());
      com.tencent.mm.kernel.g.ajD();
      this.wQi = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gr(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cc.a.ay(getContext(), 2131166720), com.tencent.mm.cc.a.ay(getContext(), 2131166720));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131303135).getParent()).addView(this.wQi, 0, (ViewGroup.LayoutParams)localObject);
      this.Jdx.KZC = this.mPullDownCallback;
      this.Jdx.setPadding(this.Jdx.getPaddingLeft(), this.Jdx.getPaddingTop(), this.Jdx.getPaddingRight(), this.Jdz.getHeight());
      if (this.Jdy != null)
      {
        ad.d("MicroMsg.MoreTabUI", "dancy test add view !");
        fxv();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void fuG()
  {
    AppMethodBeat.i(33577);
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    ba.aBQ();
    com.tencent.mm.model.c.ajl().a(this);
    com.tencent.mm.z.c.aht().a(this.yJC);
    this.screen.cP("more_tab_setting_personal_info", false);
    this.JdC = ((AccountInfoPreference)this.adapter.aVD("more_tab_setting_personal_info"));
    Object localObject = com.tencent.mm.model.u.aAn();
    if (af.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.model.u.aAm();
      if (am.aSX((String)localObject))
      {
        this.JdC.Ffo = null;
        this.JdC.userName = com.tencent.mm.model.u.aAm();
        String str = com.tencent.mm.model.u.aAo();
        localObject = str;
        if (af.isNullOrNil(str)) {
          localObject = com.tencent.mm.model.u.aAp();
        }
        this.JdC.Ffn = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject);
        this.JdC.aO(this.wSK, this.JdI);
        this.JdC.FfB = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33547);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (MoreTabUI.j(MoreTabUI.this)) {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33547);
              return;
              if (MoreTabUI.k(MoreTabUI.this) != null) {
                MoreTabUI.k(MoreTabUI.this).fMF();
              }
            }
          }
        };
        ((AccountInfoPreference)this.screen.aVD("more_tab_setting_personal_info")).FfA = new MoreTabUI.15(this);
        localObject = (IconPreference)this.screen.aVD("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.bk.d.aMo().frk();
          if (i <= 0) {
            break label686;
          }
          ((IconPreference)localObject).acl(0);
          ((IconPreference)localObject).gw(String.valueOf(i), 2131233430);
        }
        label261:
        fxo();
        fxr();
        fxq();
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          break label705;
        }
        this.screen.cP("settings_mm_favorite", true);
        label296:
        fxt();
        fxs();
        fxp();
        if (!com.tencent.mm.kernel.g.ajy().aa(com.tencent.mm.plugin.z.a.a.class)) {
          break label722;
        }
        this.screen.cP("more_uishow", false);
        label334:
        localObject = this.screen.aVD("settings_privacy_agreements");
        if (!com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null))) {
          break label739;
        }
        str = getString(2131762010);
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
        localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131100547)), localSpannable.length() - str.length(), localSpannable.length(), 33);
        ((Preference)localObject).setTitle(localSpannable);
        this.screen.cP("settings_privacy_agreements", false);
        label456:
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        localObject = findViewById(2131301512);
        if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
          new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new MoreTabUI.3(this, (View)localObject));
        }
        if ((this.Jdx != null) && (this.Jdx.isVisible))
        {
          abR(0);
          ad.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.wQh != null)
        {
          this.wQh.onResume();
          this.wQh.egI();
        }
        if (this.JdC != null)
        {
          localObject = this.JdC;
          if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.z.c.aht().cI(352279, 266241))) {
            break label756;
          }
        }
      }
    }
    label686:
    label705:
    label722:
    label739:
    label756:
    for (boolean bool = true;; bool = false)
    {
      ((AccountInfoPreference)localObject).Ffy = bool;
      this.JdC.feE();
      ad.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      this.JdC.Ffo = ((String)localObject);
      break;
      this.JdC.Ffo = ((String)localObject);
      break;
      ((IconPreference)localObject).acl(8);
      ((IconPreference)localObject).gw("", -1);
      break label261;
      this.screen.cP("settings_mm_favorite", false);
      break label296;
      this.screen.cP("more_uishow", true);
      break label334;
      this.screen.cP("settings_privacy_agreements", true);
      break label456;
    }
  }
  
  protected final void fuH()
  {
    AppMethodBeat.i(33578);
    if (this.wQh != null) {
      this.wQh.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void fuI()
  {
    AppMethodBeat.i(33579);
    ad.d("MicroMsg.MoreTabUI", "onTabPause");
    com.tencent.mm.z.c.aht().b(this.yJC);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().b(this);
    if (this.wQh != null) {
      this.wQh.onPause();
    }
    if (this.Jdx != null)
    {
      if ((this.Jdx.isVisible) || (this.wSK)) {
        break label118;
      }
      this.Jdx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33536);
          MoreTabUI.k(MoreTabUI.this).fME();
          AppMethodBeat.o(33536);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.JdC != null) {
        this.JdC.feD();
      }
      xp(false);
      AppMethodBeat.o(33579);
      return;
      label118:
      if ((this.Jdx.isVisible) && (this.Jdx.getTranslationY() != 0.0F)) {
        this.Jdx.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void fuJ()
  {
    AppMethodBeat.i(33580);
    if (this.wQh != null) {
      this.wQh.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void fuK()
  {
    AppMethodBeat.i(33581);
    if (this.wQh != null) {
      this.wQh.onDestroy();
    }
    if (this.JdC != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.JdC;
      if (localAccountInfoPreference.qhs) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fz(localAccountInfoPreference.Ffu);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void fuM() {}
  
  public final void fuN() {}
  
  public final void fuP() {}
  
  public final void fvQ()
  {
    AppMethodBeat.i(33582);
    ad.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.JdJ = true;
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.rmt = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label254;
        }
        bool = true;
        label74:
        this.JdL = bool;
      }
    }
    else if (this.Jdx != null)
    {
      localObject = this.Jdx;
      ap.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).KZy = true;
      if ((!this.Jdx.isVisible) || (this.Jdx.getTranslationY() == 0.0F)) {
        break label259;
      }
      this.Jdx.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.wQh != null) {
        this.wQh.egI();
      }
      xp(true);
      long l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.AS(l);
      localObject = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.eks().ely = l;
      localObject = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.eks().emJ = System.currentTimeMillis();
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(34);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickBottomTabRedDot();
      AppMethodBeat.o(33582);
      return;
      bool = false;
      break;
      label254:
      bool = false;
      break label74;
      label259:
      if (!this.Jdx.isVisible) {
        this.Jdx.fME();
      }
    }
  }
  
  public final void fvR()
  {
    AppMethodBeat.i(33583);
    this.JdJ = false;
    if (this.Jdx != null)
    {
      localObject = this.Jdx;
      ap.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).KZy = false;
      if (!this.Jdx.isVisible) {
        this.Jdx.fME();
      }
    }
    if (this.wQi != null) {
      this.wQi.setVisibility(8);
    }
    Object localObject = new wa();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    xp(false);
    localObject = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekt();
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(50);
    }
    AppMethodBeat.o(33583);
  }
  
  public final int getResourceId()
  {
    return 2131951693;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(33561);
    ad.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = this.adapter;
    this.screen.cP("more_setting", true);
    this.screen.cP("settings_emoji_store", true);
    this.screen.cP("settings_mm_wallet", true);
    this.screen.cP("settings_mm_cardpackage", true);
    this.screen.cP("settings_mm_favorite", true);
    this.screen.cP("settings_my_album", true);
    this.screen.cP("settings_my_address", true);
    this.screen.cP("more_tab_setting_personal_info", true);
    this.screen.cP("more_uishow", true);
    this.screen.cP("settings_privacy_agreements", true);
    this.Jdz = getView().getRootView().findViewById(2131301338);
    this.Jdy = ((RelativeLayout)findViewById(2131303379));
    this.Jdx = ((PullDownListView)this.list);
    this.Jdx.setTabView(this.Jdz);
    this.Jdx.setBackground(aq.aM(getContext(), 2130969307));
    this.Jdx.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(33561);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool = true;
    AppMethodBeat.i(33573);
    super.onConfigurationChanged(paramConfiguration);
    ad.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
    if (paramConfiguration.orientation == 1)
    {
      this.rmt = false;
      if (this.Jdx != null) {
        this.JdA.fxw();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label214;
      }
    }
    for (;;)
    {
      if (bool != this.JdL)
      {
        this.JdL = bool;
        if ((this.wQh != null) && (this.Jdy != null) && (this.Jdx != null))
        {
          this.wQh.onDestroy();
          this.Jdy.removeView(this.wQh);
          fxv();
          this.wQh.onResume();
          if (!this.Jdx.isVisible)
          {
            this.Jdx.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33538);
                MoreTabUI.k(MoreTabUI.this).fME();
                AppMethodBeat.o(33538);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.rmt = true;
            if (this.Jdx == null) {
              break;
            }
            if (!this.Jdx.isVisible) {
              this.Jdx.fME();
            }
            this.JdA.abS(2);
            break;
            label214:
            bool = false;
            continue;
          }
          if ((this.Jdx.isVisible) && (this.Jdx.getTranslationY() != 0.0F)) {
            this.Jdx.setTranslationY(0.0F);
          }
        }
      }
    }
    AppMethodBeat.o(33573);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33556);
    super.onCreate(paramBundle);
    if ((!ba.ajx()) || (ba.aiE()))
    {
      ad.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(ba.ajx()), Boolean.valueOf(ba.aiE()) });
      AppMethodBeat.o(33556);
      return;
    }
    fxn();
    xp(false);
    AppMethodBeat.o(33556);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33560);
    super.onDestroy();
    AppMethodBeat.o(33560);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33588);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.wQh != null)) {}
    for (boolean bool = this.wQh.onBackPressed();; bool = false)
    {
      ad.d("MicroMsg.MoreTabUI", "onBackPressed: %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) || (super.onKeyDown(paramInt, paramKeyEvent)))
      {
        AppMethodBeat.o(33588);
        return true;
      }
      AppMethodBeat.o(33588);
      return false;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33558);
    super.onPause();
    ad.i("MicroMsg.MoreTabUI", "onPause: ");
    if (this.JdJ)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ekt();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (localObject = "null";; localObject = paramPreference.mKey)
    {
      ad.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.ajx()) {
        break;
      }
      ad.w("MicroMsg.MoreTabUI", "account has not already!");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.bs.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      com.tencent.mm.plugin.newtips.a.dun().LQ(13);
      bool1 = com.tencent.mm.z.c.aht().cI(262156, 266248);
      boolean bool2 = com.tencent.mm.z.c.aht().cJ(262156, 266248);
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.g.yhR;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.f(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new rg();
        paramPreference.dFQ.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.dFQ.intent = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.IbL.l(paramPreference);
        com.tencent.mm.z.c.aht().cK(262156, 266248);
        com.tencent.mm.z.c.aht().c(al.a.IAC, al.a.IAE);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.IzZ, "");
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.IAa, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICd, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICa, "");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICb, Boolean.FALSE);
        com.tencent.mm.z.c.aht().c(al.a.ICh, al.a.ICn);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICg, "");
        paramf = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool2) {
          break label752;
        }
      }
      label752:
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        i = 0;
        break;
      }
    }
    if (paramPreference.mKey.equals("settings_mm_cardpackage"))
    {
      com.tencent.mm.plugin.newtips.a.dun().LQ(14);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Irv, "");
      new Intent().putExtra("key_from_scene", 22);
      ad.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new jv();
      paramf.dwO.context = getContext();
      paramf.dwO.enterScene = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(getContext(), null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        ba.aBQ();
        paramf = (String)com.tencent.mm.model.c.ajl().get(2, null);
        paramPreference = new Intent(getContext(), AlbumUI.class);
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.putExtra("username", paramf);
        paramPreference.putExtra("story_dot", this.JdK);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        ba.aBQ();
        i = af.h((Integer)com.tencent.mm.model.c.ajl().get(68389, null));
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(68389, Integer.valueOf(i + 1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.g.yhR.f(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cq.d.fSu();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10958, "7");
      if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
      {
        bool1 = fxu();
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return bool1;
      }
      com.tencent.mm.z.c.aht().cK(262147, 266244);
      com.tencent.mm.z.c.aht().cK(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.g.yhR.f(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eN(com.tencent.mm.plugin.boots.a.b.nTL, 881);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.z.c.aht().cI(262145, 266242);
      com.tencent.mm.z.c.aht().cK(262145, 266242);
      com.tencent.mm.z.c.aht().cK(262157, 266261);
      com.tencent.mm.z.c.aht().cK(262158, 266264);
      com.tencent.mm.z.c.aht().b(al.a.IDj, 266242);
      paramPreference = new Intent();
      com.tencent.mm.bs.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      ba.aBQ();
      i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iyn, Integer.valueOf(0))).intValue();
      ba.aBQ();
      int j = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iyo, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.Iyo, Integer.valueOf(i));
        paramf = (IconPreference)paramf.aVD("more_setting");
        if (paramf != null) {
          paramf.acn(8);
        }
        com.tencent.mm.z.c.aht().cK(266260, 266241);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(33544);
          paramAnonymousl.c(0, "GameCenter");
          paramAnonymousl.c(1, "FluterEmojiStore");
          paramAnonymousl.c(3, "weui");
          AppMethodBeat.o(33544);
        }
      };
      paramf.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(33545);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.g(MoreTabUI.this);
            MoreTabUI.h(MoreTabUI.this);
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.i(MoreTabUI.this);
          }
        }
      };
      paramf.cMW();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131760685, new Object[] { ac.fks(), com.tencent.mm.kernel.g.ajC().ajl().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
    AppMethodBeat.o(33563);
    return false;
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33562);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33562);
      return true;
    }
    boolean bool;
    try
    {
      if ((bu.fjL()) || (bu.flW()) || (bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED))
      {
        if (bt.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = xo(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (bt.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = xo(false);
          AppMethodBeat.o(33562);
          return bool;
        }
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
      AppMethodBeat.o(33562);
    }
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33557);
    super.onResume();
    ad.i("MicroMsg.MoreTabUI", "onResume: ");
    fxn();
    if (this.JdJ)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.AS(l);
      localh = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.eks().ely = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
    implements com.tencent.mm.al.f
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn) {}
  }
  
  final class b
  {
    private int status = 2;
    
    private b() {}
    
    public final void abS(int paramInt)
    {
      AppMethodBeat.i(33554);
      ad.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0) {
        MoreTabUI.d(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        dAz();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    public final void dAz()
    {
      AppMethodBeat.i(33552);
      if (MoreTabUI.this.getActivity() == null)
      {
        AppMethodBeat.o(33552);
        return;
      }
      switch (this.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(33552);
        return;
        MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(true);
        MoreTabUI.r(MoreTabUI.this);
        if (MoreTabUI.q(MoreTabUI.this)) {
          MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969308));
        }
        for (;;)
        {
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            ((RelativeLayout.LayoutParams)MoreTabUI.l(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.x(MoreTabUI.this);
            MoreTabUI.k(MoreTabUI.this).B(MoreTabUI.l(MoreTabUI.this), MoreTabUI.y(MoreTabUI.this), MoreTabUI.x(MoreTabUI.this));
          }
          MoreTabUI.k(MoreTabUI.this).setMuteView(null);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.a(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          if (MoreTabUI.o(MoreTabUI.this) == null) {
            break;
          }
          MoreTabUI.o(MoreTabUI.this).aO(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969307));
        }
        MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969307));
        MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
        MoreTabUI.z(MoreTabUI.this);
        MoreTabUI.b(MoreTabUI.this, com.tencent.mm.cc.a.ay(MoreTabUI.this.getContext(), 2131166721));
        if (MoreTabUI.l(MoreTabUI.this) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.l(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.A(MoreTabUI.this);
          MoreTabUI.k(MoreTabUI.this).B(MoreTabUI.l(MoreTabUI.this), MoreTabUI.y(MoreTabUI.this), MoreTabUI.A(MoreTabUI.this));
        }
        MoreTabUI.k(MoreTabUI.this).setMuteView(MoreTabUI.w(MoreTabUI.this));
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
        MoreTabUI.a(MoreTabUI.this, 0);
        MoreTabUI.b(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
        if (MoreTabUI.o(MoreTabUI.this) != null)
        {
          MoreTabUI.o(MoreTabUI.this).aO(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969308));
          MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.m(MoreTabUI.this);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).aO(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void fxw()
    {
      AppMethodBeat.i(33553);
      if ((!o.isShowStoryCheck()) || (MoreTabUI.j(MoreTabUI.this)))
      {
        MoreTabUI.d(MoreTabUI.this, false);
        this.status = 2;
      }
      for (;;)
      {
        ad.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
        dAz();
        AppMethodBeat.o(33553);
        return;
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(com.tencent.mm.model.u.aAm()))
        {
          MoreTabUI.d(MoreTabUI.this, true);
          this.status = 0;
        }
        else
        {
          MoreTabUI.d(MoreTabUI.this, false);
          this.status = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */