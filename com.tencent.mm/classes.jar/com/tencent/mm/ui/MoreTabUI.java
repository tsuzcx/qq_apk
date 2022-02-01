package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
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
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.we;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.y.a.a;
import java.util.HashMap;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, n.b
{
  private Bitmap BCB;
  private RelativeLayout FxT;
  private FrameLayout FxU;
  private LinearLayout FxV;
  private boolean FxW;
  public boolean JyA;
  private int JyB;
  private int JyC;
  private a JyD;
  PullDownListView Jyi;
  private RelativeLayout Jyj;
  private View Jyk;
  private b Jyl;
  private boolean Jym;
  private AccountInfoPreference Jyn;
  private RelativeLayout Jyo;
  private int Jyp;
  private int Jyq;
  private int Jyr;
  private int Jys;
  private boolean Jyt;
  private boolean Jyu;
  private boolean Jyv;
  private boolean Jyw;
  private com.tencent.mm.av.a.c.h Jyx;
  public boolean Jyy;
  private boolean Jyz;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean ruy;
  private com.tencent.mm.ui.base.preference.f screen;
  private AbsStoryGallery xfY;
  private AbsStoryMuteView xfZ;
  private View xgh;
  private boolean xiB;
  private byte[] yTX;
  private a.a yZM;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.BCB = null;
    this.yTX = null;
    this.xfZ = null;
    this.Jyj = null;
    this.Jyk = null;
    this.xfY = null;
    this.Jyl = new b((byte)0);
    this.xiB = false;
    this.Jym = false;
    this.Jyn = null;
    this.FxW = false;
    this.FxT = null;
    this.FxU = null;
    this.Jyo = null;
    this.FxV = null;
    this.Jyp = 0;
    this.Jyq = 0;
    this.Jyr = 0;
    this.Jys = 0;
    this.ruy = false;
    this.Jyt = false;
    this.Jyu = false;
    this.Jyv = false;
    this.Jyw = false;
    this.yZM = new a.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33523);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 266267) || (paramAnonymousInt == 262158) || (paramAnonymousInt == 262164))
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
      
      public final void b(am.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == am.a.ILL) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.f(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == am.a.ILM) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == am.a.IVb) || (paramAnonymousa == am.a.IWG)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == am.a.IXJ) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.Jyx = new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.JyG.acW(0);
            this.JyG.acV(2131233400);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.f(MoreTabUI.this).aXe("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.aI(this.iXM);
              paramAnonymousString.acW(0);
              AppMethodBeat.o(33540);
            }
          });
          AppMethodBeat.o(33543);
          return;
        }
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33541);
            paramAnonymousString.aI(null);
            paramAnonymousString.acW(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
    };
    this.Jyy = true;
    this.Jyz = true;
    this.JyA = true;
    this.JyB = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    this.JyC = com.tencent.mm.cb.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void Np(int paramAnonymousInt)
      {
        AppMethodBeat.i(33532);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).SF(paramAnonymousInt);
        }
        AppMethodBeat.o(33532);
      }
      
      public final void Nq(int paramAnonymousInt)
      {
        AppMethodBeat.i(33533);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).SG(paramAnonymousInt);
        }
        AppMethodBeat.o(33533);
      }
      
      public final void Nr(int paramAnonymousInt)
      {
        AppMethodBeat.i(33534);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).Nr(paramAnonymousInt);
        }
        AppMethodBeat.o(33534);
      }
      
      public final void dDR()
      {
        AppMethodBeat.i(33528);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).eko();
        }
        if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
        {
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.eob().eou = System.currentTimeMillis();
          localh = com.tencent.mm.plugin.story.h.h.BjR;
          com.tencent.mm.plugin.story.h.h.eoc();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).FxX = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33528);
      }
      
      public final void dDS()
      {
        AppMethodBeat.i(33529);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).ekp();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).FxX = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33529);
      }
      
      public final void dDT()
      {
        AppMethodBeat.i(33530);
        ae.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.w(MoreTabUI.this).eku();
        AppMethodBeat.o(33530);
      }
      
      public final void dDU()
      {
        AppMethodBeat.i(33531);
        MoreTabUI.w(MoreTabUI.this).ekv();
        AppMethodBeat.o(33531);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(33527);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            MoreTabUI.l(MoreTabUI.this).sn(true);
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
            MoreTabUI.o(MoreTabUI.this).fiu();
          }
          MoreTabUI.u(MoreTabUI.this).dDQ();
          if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
          {
            long l = System.currentTimeMillis();
            com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
            com.tencent.mm.plugin.story.h.h.Bq(l);
            localh = com.tencent.mm.plugin.story.h.h.BjR;
            com.tencent.mm.plugin.story.h.h.eob().eng = l;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).dx(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.BjR;
            com.tencent.mm.plugin.story.h.h.enI().emO = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.BjR;
            com.tencent.mm.plugin.story.h.h.enI().eop = 1L;
            MoreTabUI.l(MoreTabUI.this).aj(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.m(MoreTabUI.this);
            MoreTabUI.n(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).fit();
          }
          if ((!MoreTabUI.p(MoreTabUI.this)) && (!MoreTabUI.q(MoreTabUI.this)))
          {
            int i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jad, 0);
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jad, Integer.valueOf(i + 1));
            MoreTabUI.r(MoreTabUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
          AppMethodBeat.o(33526);
          return;
        }
      }
    };
    this.JyD = new a();
    AppMethodBeat.o(33555);
  }
  
  private void acz(int paramInt)
  {
    AppMethodBeat.i(33576);
    View localView = findViewById(2131296345);
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      ae.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33576);
      return;
    }
    ae.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
    AppMethodBeat.o(33576);
  }
  
  private void fBp()
  {
    AppMethodBeat.i(33559);
    if (!this.Jyt)
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jad, 0);
      boolean bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IZQ, false);
      ae.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.xiB) && ((bool) || (i > 0)))
      {
        this.Jyt = true;
        if (this.Jyn != null) {
          this.Jyn.aN(this.xiB, this.Jyt);
        }
        if (!this.Jyt) {
          break label145;
        }
      }
    }
    label145:
    for (int i = com.tencent.mm.cb.a.ay(getContext(), 2131166722);; i = com.tencent.mm.cb.a.ay(getContext(), 2131166721))
    {
      this.Jyr = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void fBq()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.br.d.aJN("sns"))
    {
      this.screen.cT("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.cT("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jam, true)) && (this.Jyv))
      {
        localIconPreference.acU(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.Jyv = false;
      localIconPreference.acU(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void fBr()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).bWz()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).bWA())) || (!com.tencent.mm.br.d.aJN("card")))
    {
      this.screen.cT("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).bWB();; localObject1 = "")
    {
      this.screen.cT("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aXe("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262152, 266256);
      boolean bool3 = com.tencent.mm.y.c.ahI().cI(262152, 266256);
      boolean bool4 = com.tencent.mm.y.c.ahI().a(am.a.ILL, am.a.ILN);
      boolean bool5 = com.tencent.mm.y.c.ahI().a(am.a.ILM, am.a.ILO);
      bc.aCg();
      String str = (String)com.tencent.mm.model.c.ajA().get(am.a.ILU, "");
      localNormalIconNewTipPreference.setTitle(2131763275);
      com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.dxD().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.wAy = this.Jyx;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.acS(0);
        localNormalIconNewTipPreference.gF(getString(2131755829), 2131233430);
        localNormalIconNewTipPreference.acU(8);
        localNormalIconNewTipPreference.setSummary(null);
        localNormalIconNewTipPreference.aI(null);
        localNormalIconNewTipPreference.acW(8);
        localNormalIconNewTipPreference.gG("", -1);
        localNormalIconNewTipPreference.acT(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIw, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131165965);
        Object localObject2 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.asj();
        q.aJc();
        ((com.tencent.mm.av.a.a.c.a)localObject2).igB = null;
        ((com.tencent.mm.av.a.a.c.a)localObject2).igk = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hhW = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).igi = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hgG = i;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hgF = i;
        localObject2 = ((com.tencent.mm.av.a.a.c.a)localObject2).aJu();
        q.aJb().a(str, localNormalIconNewTipPreference.fDD(), (com.tencent.mm.av.a.a.c)localObject2, this.Jyx);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIy, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.acU(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIv, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.gF("", -1);
          localNormalIconNewTipPreference.acS(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.setSummary(null);
            if (!af.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aX((String)localObject1, -1, getResources().getColor(2131100490));
              localNormalIconNewTipPreference.acT(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIx, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aI(null);
              localNormalIconNewTipPreference.acW(8);
              break;
              label633:
              localNormalIconNewTipPreference.acU(8);
              continue;
            }
            localNormalIconNewTipPreference.gG("", -1);
            localNormalIconNewTipPreference.acT(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.gG("", -1);
          localNormalIconNewTipPreference.acT(8);
          if (!af.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIx, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.setSummary(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.acT(8);
      localNormalIconNewTipPreference.acS(8);
      localNormalIconNewTipPreference.setSummary(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void fBs()
  {
    AppMethodBeat.i(33566);
    this.screen.cT("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.screen.aXe("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.acX(8);
      bool = com.tencent.mm.y.c.ahI().cI(262145, 266242);
      if (bool)
      {
        localIconPreference.acS(0);
        localIconPreference.gF(getString(2131755829), 2131233430);
      }
      for (;;)
      {
        localIconPreference.acU(8);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(33566);
        return;
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
      }
      bc.aCg();
      i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.ISL, Integer.valueOf(0))).intValue();
      bc.aCg();
      int j = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.ISM, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).fad()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).fae()) || (i > j)) && (!bool))
      {
        localIconPreference.acU(0);
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acU(8);
      if (com.tencent.mm.y.c.ahI().cJ(262157, 266261))
      {
        localIconPreference.acU(0);
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acU(8);
      if (com.tencent.mm.y.c.ahI().cJ(262164, 266268))
      {
        localIconPreference.acU(0);
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acU(8);
      if (com.tencent.mm.y.c.ahI().cJ(262158, 266264))
      {
        localIconPreference.acU(0);
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      if (com.tencent.mm.y.c.ahI().a(am.a.IXJ, 266242))
      {
        localIconPreference.acU(0);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.acU(8);
      bc.aCg();
      if ((com.tencent.mm.model.c.ajA().getInt(40, 0) & 0x20000) != 0) {
        break label661;
      }
    }
    label661:
    for (int i = 1;; i = 0)
    {
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("VoiceprintEntry"), 0) == 1) {
        bc.aCg();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.ILo, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ae.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.acU(0);
          AppMethodBeat.o(33566);
          return;
        }
        localIconPreference.acU(8);
        com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dxE().My(com.tencent.mm.plugin.newtips.a.d.wHR);
        if ((locala != null) && (!locala.field_isExit)) {
          com.tencent.mm.plugin.newtips.a.dxD().wIr = new i.a()
          {
            public final void e(com.tencent.mm.plugin.newtips.b.a paramAnonymousa)
            {
              AppMethodBeat.i(33546);
              if ((paramAnonymousa != null) && (paramAnonymousa.field_tipId == com.tencent.mm.plugin.newtips.a.d.wHR))
              {
                com.tencent.mm.plugin.newtips.a.dxG();
                if (com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR))
                {
                  localIconPreference.acU(0);
                  localIconPreference.acS(8);
                  localIconPreference.gF("", -1);
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
          localIconPreference.acU(0);
          AppMethodBeat.o(33566);
          return;
          com.tencent.mm.plugin.newtips.a.dxG();
          if (com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR))
          {
            localIconPreference.acU(0);
            localIconPreference.acS(8);
            localIconPreference.gF("", -1);
            AppMethodBeat.o(33566);
            return;
          }
        }
        localIconPreference.acU(8);
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void fBt()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.br.d.aJN("emoji"))
    {
      com.tencent.mm.br.d.fjx();
      this.screen.cT("settings_emoji_store", false);
      bool1 = com.tencent.mm.y.c.ahI().cI(262147, 266244);
      bool2 = com.tencent.mm.y.c.ahI().cI(262149, 266244);
      localIconPreference = (IconPreference)this.screen.aXe("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.cT("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.acS(0);
      localIconPreference.gF(getString(2131755829), 2131233430);
    }
    while ((bool2) || (bool1))
    {
      bc.aCg();
      String str = (String)com.tencent.mm.model.c.ajA().get(229633, null);
      q.aJb().a(str, localIconPreference.fDD(), new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(33551);
          if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null))
          {
            com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.14.this.JyJ.aI(this.iXM);
                MoreTabUI.14.this.JyJ.acW(0);
                AppMethodBeat.o(33549);
              }
            });
            AppMethodBeat.o(33551);
            return;
          }
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33550);
              MoreTabUI.14.this.JyJ.acW(8);
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
        localIconPreference.acS(0);
        localIconPreference.gF(getString(2131755781), 2131233430);
      }
      else
      {
        localIconPreference.acS(8);
        localIconPreference.gF("", -1);
      }
    }
    localIconPreference.acW(8);
    AppMethodBeat.o(33567);
  }
  
  private void fBu()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = v.aAM();
    ae.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.cT("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (bu.jB(i, -1)) {
        break label156;
      }
      if ((i & 0x8000) == 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label156;
      }
      if (!bool2) {
        break label144;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label144:
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1056L, 0L, 1L, false);
    label156:
    AppMethodBeat.o(33568);
  }
  
  private void fBv()
  {
    AppMethodBeat.i(33569);
    bc.aCg();
    int i = af.i((Integer)com.tencent.mm.model.c.ajA().get(204820, null));
    bc.aCg();
    int j = i + af.i((Integer)com.tencent.mm.model.c.ajA().get(204817, null));
    boolean bool3 = com.tencent.mm.y.c.ahI().cI(262156, 266248);
    boolean bool4 = com.tencent.mm.y.c.ahI().cJ(262156, 266248);
    boolean bool5 = com.tencent.mm.y.c.ahI().b(am.a.IVb, am.a.IVd);
    bc.aCg();
    String str2 = (String)com.tencent.mm.model.c.ajA().get(am.a.IVe, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aXe("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    ae.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    ae.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.dxD().h(localNormalIconNewTipPreference);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    bc.aCg();
    String str3 = (String)com.tencent.mm.model.c.ajA().get(am.a.IUy, "");
    bc.aCg();
    int k = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IUz, Integer.valueOf(-1))).intValue();
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
      bc.aCg();
      l1 = ((Long)com.tencent.mm.model.c.ajA().get(am.a.IUw, Long.valueOf(-1L))).longValue();
      long l2 = af.wW(com.tencent.mm.n.g.acL().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      ae.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
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
            com.tencent.mm.y.c.ahI().w(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.ajS();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWC, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.ajS();
    long l1 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWD, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      ae.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWC, Boolean.FALSE);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWD, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.ajS();
      Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWz, "");
      ae.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.y.c.ahI().b(am.a.IWG, am.a.IWM);
      com.tencent.mm.kernel.g.ajS();
      l1 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWI, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        ae.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.y.c.ahI().c(am.a.IWG, am.a.IWM);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWI, Long.valueOf(0L));
      }
      for (;;)
      {
        bool3 |= bool2;
        com.tencent.mm.kernel.g.ajS();
        String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWF, "");
        ae.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), str1 });
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
        if (bool3)
        {
          i = 1;
          localg.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
          ae.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
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
          if (!bu.isNullOrNil(str2))
          {
            localNormalIconNewTipPreference.acT(0);
            localNormalIconNewTipPreference.aX(str2, -1, -7566196);
            localNormalIconNewTipPreference.xM(true);
            localNormalIconNewTipPreference.acU(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIx, true);
            if (bu.isNullOrNil(str1)) {
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
            localNormalIconNewTipPreference.gG("", -1);
            localNormalIconNewTipPreference.acT(8);
            localNormalIconNewTipPreference.acU(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIv, true);
            break;
            if (bool1)
            {
              localNormalIconNewTipPreference.acS(0);
              localNormalIconNewTipPreference.gF(getString(2131755829), 2131233430);
              localNormalIconNewTipPreference.acU(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIw, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.acS(0);
              localNormalIconNewTipPreference.gF(getString(2131764343), u.kL(getContext()));
              localNormalIconNewTipPreference.acU(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIA, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.acS(0);
              localNormalIconNewTipPreference.gF(String.valueOf(j), u.aP(getContext(), j));
              localNormalIconNewTipPreference.acU(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIA, true);
              break;
            }
            if (bool3)
            {
              localNormalIconNewTipPreference.gF("", -1);
              localNormalIconNewTipPreference.acS(8);
              localNormalIconNewTipPreference.acU(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIv, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.gF("", -1);
              localNormalIconNewTipPreference.acS(8);
              localNormalIconNewTipPreference.acT(0);
              localNormalIconNewTipPreference.xM(true);
              if (!af.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.aX(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.acX(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.wIx, true);
              break;
            }
            localNormalIconNewTipPreference.gF("", -1);
            localNormalIconNewTipPreference.acS(8);
            localNormalIconNewTipPreference.acU(8);
            localNormalIconNewTipPreference.acT(8);
            localNormalIconNewTipPreference.gG("", -1);
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
  
  private boolean fBw()
  {
    AppMethodBeat.i(33571);
    com.tencent.mm.plugin.flutter.a.c localc = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
    ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), localc);
    AppMethodBeat.o(33571);
    return true;
  }
  
  private void fBx()
  {
    AppMethodBeat.i(33575);
    this.xfY = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.AZz, null);
    if (this.xfY != null)
    {
      this.xfY.ekr();
      this.Jys = (-(ar.ck(getContext()).y / 10));
      if (!this.Jyt) {
        break label239;
      }
    }
    label239:
    for (int i = com.tencent.mm.cb.a.ay(getContext(), 2131166722);; i = com.tencent.mm.cb.a.ay(getContext(), 2131166721))
    {
      this.Jyr = i;
      this.Jyq = (-com.tencent.mm.cb.a.fromDPToPix(getContext(), 330));
      this.Jyp = 0;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ar.ck(getContext()).y);
      localLayoutParams.topMargin = this.Jys;
      localLayoutParams.bottomMargin = (-ar.en(getContext()));
      this.Jyj.addView(this.xfY, 0, localLayoutParams);
      this.Jyi.A(this.xfY, this.Jyr, this.Jys);
      this.Jyi.setNavigationBarHeight(ar.en(getActivity()));
      this.xfY.setDataSeed(v.aAC());
      this.xfY.a(this.Jyi);
      this.xfY.setStoryBrowseUIListener(this);
      this.Jyl.fBy();
      AppMethodBeat.o(33575);
      return;
    }
  }
  
  private boolean xw(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.s.c.muS.a(com.tencent.mm.plugin.appbrand.s.c.a.muW);
    com.tencent.mm.plugin.appbrand.s.c.muS.a(com.tencent.mm.plugin.appbrand.s.c.a.mvi);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.br.d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void xx(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.xgh == null)
      {
        View localView = findViewById(2131296345);
        if (localView != null) {
          this.xgh = localView.findViewById(2131296343);
        }
        if (this.xgh == null) {
          break label104;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.xgh == null) {
          break label117;
        }
        if (!paramBoolean) {
          break;
        }
        this.xgh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33537);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.j(MoreTabUI.this)) {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33537);
              return;
              if ((MoreTabUI.k(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this).isVisible)) {
                MoreTabUI.k(MoreTabUI.this).fQZ();
              }
            }
          }
        });
        AppMethodBeat.o(33587);
        return;
        label104:
        bool = false;
      }
      this.xgh.setOnClickListener(null);
    }
    label117:
    AppMethodBeat.o(33587);
  }
  
  private void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.Jyi != null) && (this.Jyi.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().xq(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33570);
    int i = af.cd(paramObject);
    ae.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    bc.aCg();
    if ((paramn != com.tencent.mm.model.c.ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      fBv();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      fBu();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      fBt();
    }
    AppMethodBeat.o(33570);
  }
  
  public final void dDK()
  {
    AppMethodBeat.i(33584);
    ae.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.Jyi != null) && (!this.Jyi.isVisible)) {
      this.Jyi.fQY();
    }
    if ((!o.isShowStoryCheck()) || (this.ruy)) {
      this.Jyl.acA(2);
    }
    for (;;)
    {
      if (this.Jyn != null) {
        this.Jyn.fit();
      }
      AppMethodBeat.o(33584);
      return;
      this.Jyl.acA(1);
    }
  }
  
  public final void dDL()
  {
    AppMethodBeat.i(33585);
    ae.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.Jyi != null) && (this.Jyi.isVisible) && (this.Jyu))
    {
      if (!this.ruy) {
        break label106;
      }
      this.Jyl.acA(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.aXe("settings_my_album");
      if (localIconPreference == null) {
        break label128;
      }
      if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jam, true)) {
        break;
      }
      this.Jyv = true;
      localIconPreference.acU(0);
      AppMethodBeat.o(33585);
      return;
      label106:
      this.Jyl.acA(0);
    }
    this.Jyv = false;
    localIconPreference.acU(8);
    label128:
    AppMethodBeat.o(33585);
  }
  
  public final void dDM()
  {
    AppMethodBeat.i(33586);
    ae.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.Jyi != null) && (!this.Jyi.isVisible)) {
      this.Jyi.fQY();
    }
    acz(0);
    xy(this.xiB);
    AppMethodBeat.o(33586);
  }
  
  final void dDO()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  protected final void fyG()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.ruy = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label247;
      }
    }
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Jyw = bool1;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.cd(getContext());
      com.tencent.mm.kernel.g.ajS();
      this.xfZ = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gw(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cb.a.ay(getContext(), 2131166720), com.tencent.mm.cb.a.ay(getContext(), 2131166720));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131303135).getParent()).addView(this.xfZ, 0, (ViewGroup.LayoutParams)localObject);
      this.Jyi.Lwa = this.mPullDownCallback;
      this.Jyi.setPadding(this.Jyi.getPaddingLeft(), this.Jyi.getPaddingTop(), this.Jyi.getPaddingRight(), this.Jyk.getHeight());
      if (this.Jyj != null)
      {
        ae.d("MicroMsg.MoreTabUI", "dancy test add view !");
        fBx();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void fyH()
  {
    AppMethodBeat.i(33577);
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    bc.aCg();
    com.tencent.mm.model.c.ajA().a(this);
    com.tencent.mm.y.c.ahI().a(this.yZM);
    this.screen.cT("more_tab_setting_personal_info", false);
    this.Jyn = ((AccountInfoPreference)this.adapter.aXe("more_tab_setting_personal_info"));
    Object localObject = v.aAD();
    if (af.isNullOrNil((String)localObject))
    {
      localObject = v.aAC();
      if (an.aUy((String)localObject))
      {
        this.Jyn.FxM = null;
        this.Jyn.userName = v.aAC();
        String str = v.aAE();
        localObject = str;
        if (af.isNullOrNil(str)) {
          localObject = v.aAF();
        }
        this.Jyn.FxL = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject);
        this.Jyn.aN(this.xiB, this.Jyt);
        this.Jyn.FxZ = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33547);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (MoreTabUI.j(MoreTabUI.this)) {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33547);
              return;
              if (MoreTabUI.k(MoreTabUI.this) != null) {
                MoreTabUI.k(MoreTabUI.this).fQZ();
              }
            }
          }
        };
        ((AccountInfoPreference)this.screen.aXe("more_tab_setting_personal_info")).FxY = new MoreTabUI.13(this);
        localObject = (IconPreference)this.screen.aXe("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.bj.d.aMM().fvk();
          if (i <= 0) {
            break label686;
          }
          ((IconPreference)localObject).acS(0);
          ((IconPreference)localObject).gF(String.valueOf(i), 2131233430);
        }
        label261:
        fBq();
        fBt();
        fBs();
        if (com.tencent.mm.br.d.aJN("favorite")) {
          break label705;
        }
        this.screen.cT("settings_mm_favorite", true);
        label296:
        fBv();
        fBu();
        fBr();
        if (!com.tencent.mm.kernel.g.ajN().aa(com.tencent.mm.plugin.z.a.a.class)) {
          break label722;
        }
        this.screen.cT("more_uishow", false);
        label334:
        localObject = this.screen.aXe("settings_privacy_agreements");
        if (!com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null))) {
          break label739;
        }
        str = getString(2131762010);
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
        localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131100547)), localSpannable.length() - str.length(), localSpannable.length(), 33);
        ((Preference)localObject).setTitle(localSpannable);
        this.screen.cT("settings_privacy_agreements", false);
        label456:
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        localObject = findViewById(2131301512);
        if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
          new com.tencent.mm.sdk.platformtools.aq(Looper.getMainLooper()).post(new MoreTabUI.3(this, (View)localObject));
        }
        if ((this.Jyi != null) && (this.Jyi.isVisible))
        {
          acz(0);
          ae.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.xfY != null)
        {
          this.xfY.onResume();
          this.xfY.ekq();
        }
        if (this.Jyn != null)
        {
          localObject = this.Jyn;
          if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.y.c.ahI().cI(352279, 266241))) {
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
      ((AccountInfoPreference)localObject).FxW = bool;
      this.Jyn.fiu();
      ae.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      this.Jyn.FxM = ((String)localObject);
      break;
      this.Jyn.FxM = ((String)localObject);
      break;
      ((IconPreference)localObject).acS(8);
      ((IconPreference)localObject).gF("", -1);
      break label261;
      this.screen.cT("settings_mm_favorite", false);
      break label296;
      this.screen.cT("more_uishow", true);
      break label334;
      this.screen.cT("settings_privacy_agreements", true);
      break label456;
    }
  }
  
  protected final void fyI()
  {
    AppMethodBeat.i(33578);
    if (this.xfY != null) {
      this.xfY.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void fyJ()
  {
    AppMethodBeat.i(33579);
    ae.d("MicroMsg.MoreTabUI", "onTabPause");
    com.tencent.mm.y.c.ahI().b(this.yZM);
    bc.aCg();
    com.tencent.mm.model.c.ajA().b(this);
    if (this.xfY != null) {
      this.xfY.onPause();
    }
    if (this.Jyi != null)
    {
      if ((this.Jyi.isVisible) || (this.xiB)) {
        break label118;
      }
      this.Jyi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33536);
          MoreTabUI.k(MoreTabUI.this).fQY();
          AppMethodBeat.o(33536);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.Jyn != null) {
        this.Jyn.fit();
      }
      xx(false);
      AppMethodBeat.o(33579);
      return;
      label118:
      if ((this.Jyi.isVisible) && (this.Jyi.getTranslationY() != 0.0F)) {
        this.Jyi.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void fyK()
  {
    AppMethodBeat.i(33580);
    if (this.xfY != null) {
      this.xfY.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void fyL()
  {
    AppMethodBeat.i(33581);
    if (this.xfY != null) {
      this.xfY.onDestroy();
    }
    if (this.Jyn != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.Jyn;
      if (localAccountInfoPreference.qnX) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fy(localAccountInfoPreference.FxS);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void fyN() {}
  
  public final void fyO() {}
  
  public final void fyQ() {}
  
  public final void fzQ()
  {
    AppMethodBeat.i(33582);
    ae.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.Jyu = true;
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.ruy = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label254;
        }
        bool = true;
        label74:
        this.Jyw = bool;
      }
    }
    else if (this.Jyi != null)
    {
      localObject = this.Jyi;
      ap.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).LvW = true;
      if ((!this.Jyi.isVisible) || (this.Jyi.getTranslationY() == 0.0F)) {
        break label259;
      }
      this.Jyi.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.xfY != null) {
        this.xfY.ekq();
      }
      xx(true);
      long l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.Bq(l);
      localObject = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eob().eng = l;
      localObject = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eob().eos = System.currentTimeMillis();
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
      if (!this.Jyi.isVisible) {
        this.Jyi.fQY();
      }
    }
  }
  
  public final void fzR()
  {
    AppMethodBeat.i(33583);
    this.Jyu = false;
    if (this.Jyi != null)
    {
      localObject = this.Jyi;
      ap.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).LvW = false;
      if (!this.Jyi.isVisible) {
        this.Jyi.fQY();
      }
    }
    if (this.xfZ != null) {
      this.xfZ.setVisibility(8);
    }
    Object localObject = new we();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    xx(false);
    localObject = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.eoc();
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
    ae.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = this.adapter;
    this.screen.cT("more_setting", true);
    this.screen.cT("settings_emoji_store", true);
    this.screen.cT("settings_mm_wallet", true);
    this.screen.cT("settings_mm_cardpackage", true);
    this.screen.cT("settings_mm_favorite", true);
    this.screen.cT("settings_my_album", true);
    this.screen.cT("settings_my_address", true);
    this.screen.cT("more_tab_setting_personal_info", true);
    this.screen.cT("more_uishow", true);
    this.screen.cT("settings_privacy_agreements", true);
    this.Jyk = getView().getRootView().findViewById(2131301338);
    this.Jyj = ((RelativeLayout)findViewById(2131303379));
    this.Jyi = ((PullDownListView)this.list);
    this.Jyi.setTabView(this.Jyk);
    this.Jyi.setBackground(aq.aM(getContext(), 2130969307));
    this.Jyi.setOnScrollListener(new AbsListView.OnScrollListener()
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
    ae.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
    if (paramConfiguration.orientation == 1)
    {
      this.ruy = false;
      if (this.Jyi != null) {
        this.Jyl.fBy();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label214;
      }
    }
    for (;;)
    {
      if (bool != this.Jyw)
      {
        this.Jyw = bool;
        if ((this.xfY != null) && (this.Jyj != null) && (this.Jyi != null))
        {
          this.xfY.onDestroy();
          this.Jyj.removeView(this.xfY);
          fBx();
          this.xfY.onResume();
          if (!this.Jyi.isVisible)
          {
            this.Jyi.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33538);
                MoreTabUI.k(MoreTabUI.this).fQY();
                AppMethodBeat.o(33538);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.ruy = true;
            if (this.Jyi == null) {
              break;
            }
            if (!this.Jyi.isVisible) {
              this.Jyi.fQY();
            }
            this.Jyl.acA(2);
            break;
            label214:
            bool = false;
            continue;
          }
          if ((this.Jyi.isVisible) && (this.Jyi.getTranslationY() != 0.0F)) {
            this.Jyi.setTranslationY(0.0F);
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
    if ((!bc.ajM()) || (bc.aiT()))
    {
      ae.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(bc.ajM()), Boolean.valueOf(bc.aiT()) });
      AppMethodBeat.o(33556);
      return;
    }
    fBp();
    xx(false);
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
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.xfY != null)) {}
    for (boolean bool = this.xfY.onBackPressed();; bool = false)
    {
      ae.d("MicroMsg.MoreTabUI", "onBackPressed: %b", new Object[] { Boolean.valueOf(bool) });
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
    ae.i("MicroMsg.MoreTabUI", "onPause: ");
    if (this.Jyu)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eoc();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (localObject = "null";; localObject = paramPreference.mKey)
    {
      ae.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.ajM()) {
        break;
      }
      ae.w("MicroMsg.MoreTabUI", "account has not already!");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.br.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      com.tencent.mm.plugin.newtips.a.dxD().Mv(13);
      bool1 = com.tencent.mm.y.c.ahI().cI(262156, 266248);
      boolean bool2 = com.tencent.mm.y.c.ahI().cJ(262156, 266248);
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.f(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new rh();
        paramPreference.dGV.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.dGV.intent = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.IvT.l(paramPreference);
        com.tencent.mm.y.c.ahI().cK(262156, 266248);
        com.tencent.mm.y.c.ahI().c(am.a.IVb, am.a.IVd);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.IUy, "");
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.IUz, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWC, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWz, "");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWA, Boolean.FALSE);
        com.tencent.mm.y.c.ahI().c(am.a.IWG, am.a.IWM);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWF, "");
        paramf = com.tencent.mm.plugin.report.service.g.yxI;
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
      com.tencent.mm.plugin.newtips.a.dxD().Mv(14);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.ILR, "");
      new Intent().putExtra("key_from_scene", 22);
      ae.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new jw();
      paramf.dxT.context = getContext();
      paramf.dxT.enterScene = 1;
      com.tencent.mm.sdk.b.a.IvT.l(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(getContext(), null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        bc.aCg();
        paramf = (String)com.tencent.mm.model.c.ajA().get(2, null);
        paramPreference = new Intent(getContext(), AlbumUI.class);
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.putExtra("username", paramf);
        paramPreference.putExtra("story_dot", this.Jyv);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        bc.aCg();
        i = af.i((Integer)com.tencent.mm.model.c.ajA().get(68389, null));
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(68389, Integer.valueOf(i + 1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.g.yxI.f(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cp.d.fWU();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10958, "7");
      if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
      {
        bool1 = fBw();
        com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return bool1;
      }
      com.tencent.mm.y.c.ahI().cK(262147, 266244);
      com.tencent.mm.y.c.ahI().cK(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.g.yxI.f(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eO(com.tencent.mm.plugin.boots.a.b.nZr, 881);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.y.c.ahI().cI(262145, 266242);
      com.tencent.mm.y.c.ahI().cK(262145, 266242);
      com.tencent.mm.y.c.ahI().cK(262157, 266261);
      com.tencent.mm.y.c.ahI().cK(262158, 266264);
      com.tencent.mm.y.c.ahI().b(am.a.IXJ, 266242);
      com.tencent.mm.y.c.ahI().cK(262164, 266268);
      paramPreference = new Intent();
      com.tencent.mm.br.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      bc.aCg();
      i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.ISL, Integer.valueOf(0))).intValue();
      bc.aCg();
      int j = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.ISM, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.ISM, Integer.valueOf(i));
        paramf = (IconPreference)paramf.aXe("more_setting");
        if (paramf != null) {
          paramf.acU(8);
        }
        com.tencent.mm.y.c.ahI().cK(266260, 266241);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(33544);
          paramAnonymousl.d(0, "LiteAppList");
          paramAnonymousl.d(1, "FluterEmojiStore");
          paramAnonymousl.d(3, "weui");
          AppMethodBeat.o(33544);
        }
      };
      paramf.LfT = new n.e()
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
      paramf.cPF();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131760685, new Object[] { ad.fom(), com.tencent.mm.kernel.g.ajR().ajA().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
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
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33562);
      return true;
    }
    boolean bool;
    try
    {
      if ((bv.fnD()) || (bv.fpR()) || (bv.fpT()) || (j.IS_FLAVOR_RED))
      {
        if (bu.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = xw(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (bu.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = xw(false);
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
    ae.i("MicroMsg.MoreTabUI", "onResume: ");
    fBp();
    if (this.Jyu)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.Bq(l);
      localh = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eob().eng = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
    implements com.tencent.mm.ak.f
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn) {}
  }
  
  final class b
  {
    private int status = 2;
    
    private b() {}
    
    public final void acA(int paramInt)
    {
      AppMethodBeat.i(33554);
      ae.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0) {
        MoreTabUI.d(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        dDQ();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    public final void dDQ()
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
            MoreTabUI.k(MoreTabUI.this).A(MoreTabUI.l(MoreTabUI.this), MoreTabUI.y(MoreTabUI.this), MoreTabUI.x(MoreTabUI.this));
          }
          MoreTabUI.k(MoreTabUI.this).setMuteView(null);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.a(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          if (MoreTabUI.o(MoreTabUI.this) == null) {
            break;
          }
          MoreTabUI.o(MoreTabUI.this).aN(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969307));
        }
        MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969307));
        MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
        MoreTabUI.z(MoreTabUI.this);
        MoreTabUI.b(MoreTabUI.this, com.tencent.mm.cb.a.ay(MoreTabUI.this.getContext(), 2131166721));
        if (MoreTabUI.l(MoreTabUI.this) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.l(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.A(MoreTabUI.this);
          MoreTabUI.k(MoreTabUI.this).A(MoreTabUI.l(MoreTabUI.this), MoreTabUI.y(MoreTabUI.this), MoreTabUI.A(MoreTabUI.this));
        }
        MoreTabUI.k(MoreTabUI.this).setMuteView(MoreTabUI.w(MoreTabUI.this));
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
        MoreTabUI.a(MoreTabUI.this, 0);
        MoreTabUI.b(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
        if (MoreTabUI.o(MoreTabUI.this) != null)
        {
          MoreTabUI.o(MoreTabUI.this).aN(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(aq.aM(MoreTabUI.this.getContext(), 2130969308));
          MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.m(MoreTabUI.this);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).aN(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void fBy()
    {
      AppMethodBeat.i(33553);
      if ((!o.isShowStoryCheck()) || (MoreTabUI.j(MoreTabUI.this)))
      {
        MoreTabUI.d(MoreTabUI.this, false);
        this.status = 2;
      }
      for (;;)
      {
        ae.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
        dDQ();
        AppMethodBeat.o(33553);
        return;
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(v.aAC()))
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