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
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
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
  private RelativeLayout ChX;
  private FrameLayout ChY;
  private LinearLayout ChZ;
  private boolean Cia;
  private int FQA;
  private a FQB;
  PullDownListView FQg;
  private RelativeLayout FQh;
  private View FQi;
  private b FQj;
  private boolean FQk;
  private AccountInfoPreference FQl;
  private RelativeLayout FQm;
  private int FQn;
  private int FQo;
  private int FQp;
  private int FQq;
  private boolean FQr;
  private boolean FQs;
  private boolean FQt;
  private boolean FQu;
  private com.tencent.mm.aw.a.c.h FQv;
  public boolean FQw;
  private boolean FQx;
  public boolean FQy;
  private int FQz;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean pTY;
  private f screen;
  private AbsStoryGallery uAh;
  private AbsStoryMuteView uAi;
  private View uAp;
  private boolean uCI;
  private byte[] web;
  private a.a wjB;
  private Bitmap yGj;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.yGj = null;
    this.web = null;
    this.uAi = null;
    this.FQh = null;
    this.FQi = null;
    this.uAh = null;
    this.FQj = new b((byte)0);
    this.uCI = false;
    this.FQk = false;
    this.FQl = null;
    this.Cia = false;
    this.ChX = null;
    this.ChY = null;
    this.FQm = null;
    this.ChZ = null;
    this.FQn = 0;
    this.FQo = 0;
    this.FQp = 0;
    this.FQq = 0;
    this.pTY = false;
    this.FQr = false;
    this.FQs = false;
    this.FQt = false;
    this.FQu = false;
    this.wjB = new a.a()
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
      
      public final void b(ae.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == ae.a.Fhi) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.f(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == ae.a.Fhj) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == ae.a.Fqr) || (paramAnonymousa == ae.a.FrW)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == ae.a.FsT) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.FQv = new com.tencent.mm.aw.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.FQE.XU(0);
            this.FQE.XT(2131233400);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.f(MoreTabUI.this).aKk("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.aD(this.ibC);
              paramAnonymousString.XU(0);
              AppMethodBeat.o(33540);
            }
          });
          AppMethodBeat.o(33543);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33541);
            paramAnonymousString.aD(null);
            paramAnonymousString.XU(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
    };
    this.FQw = true;
    this.FQx = true;
    this.FQy = true;
    this.FQz = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
    this.FQA = com.tencent.mm.cd.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void Ji(int paramAnonymousInt)
      {
        AppMethodBeat.i(33532);
        if (MoreTabUI.k(MoreTabUI.this) != null) {
          MoreTabUI.k(MoreTabUI.this).Oj(paramAnonymousInt);
        }
        AppMethodBeat.o(33532);
      }
      
      public final void Jj(int paramAnonymousInt)
      {
        AppMethodBeat.i(33533);
        if (MoreTabUI.k(MoreTabUI.this) != null) {
          MoreTabUI.k(MoreTabUI.this).Ok(paramAnonymousInt);
        }
        AppMethodBeat.o(33533);
      }
      
      public final void Jk(int paramAnonymousInt)
      {
        AppMethodBeat.i(33534);
        if (MoreTabUI.k(MoreTabUI.this) != null) {
          MoreTabUI.k(MoreTabUI.this).Jk(paramAnonymousInt);
        }
        AppMethodBeat.o(33534);
      }
      
      public final void dcp()
      {
        AppMethodBeat.i(33528);
        if (MoreTabUI.k(MoreTabUI.this) != null) {
          MoreTabUI.k(MoreTabUI.this).dFR();
        }
        if ((MoreTabUI.u(MoreTabUI.this)) && (!MoreTabUI.o(MoreTabUI.this)))
        {
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJC().dUJ = System.currentTimeMillis();
          localh = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJD();
        }
        if ((MoreTabUI.n(MoreTabUI.this) != null) && (MoreTabUI.j(MoreTabUI.this) != null)) {
          MoreTabUI.n(MoreTabUI.this).Cib = MoreTabUI.j(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33528);
      }
      
      public final void dcq()
      {
        AppMethodBeat.i(33529);
        if (MoreTabUI.k(MoreTabUI.this) != null) {
          MoreTabUI.k(MoreTabUI.this).dFS();
        }
        if ((MoreTabUI.n(MoreTabUI.this) != null) && (MoreTabUI.j(MoreTabUI.this) != null)) {
          MoreTabUI.n(MoreTabUI.this).Cib = MoreTabUI.j(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33529);
      }
      
      public final void dcr()
      {
        AppMethodBeat.i(33530);
        ad.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.v(MoreTabUI.this).dFX();
        AppMethodBeat.o(33530);
      }
      
      public final void dcs()
      {
        AppMethodBeat.i(33531);
        MoreTabUI.v(MoreTabUI.this).dFY();
        AppMethodBeat.o(33531);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(33527);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        if (MoreTabUI.k(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.k(MoreTabUI.this) != null)
          {
            MoreTabUI.k(MoreTabUI.this).qC(true);
            MoreTabUI.k(MoreTabUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33525);
                MoreTabUI.r(MoreTabUI.this);
                MoreTabUI.a(MoreTabUI.this, 0);
                MoreTabUI.b(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
                if (MoreTabUI.s(MoreTabUI.this) != null) {
                  MoreTabUI.s(MoreTabUI.this).setTranslationY(0.0F);
                }
                AppMethodBeat.o(33525);
              }
            });
          }
          MoreTabUI.a(MoreTabUI.this, false);
          if ((MoreTabUI.n(MoreTabUI.this) != null) && (MoreTabUI.j(MoreTabUI.this) != null)) {
            MoreTabUI.n(MoreTabUI.this).eAi();
          }
          MoreTabUI.t(MoreTabUI.this).dco();
          if ((MoreTabUI.u(MoreTabUI.this)) && (!MoreTabUI.o(MoreTabUI.this)))
          {
            long l = System.currentTimeMillis();
            com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
            com.tencent.mm.plugin.story.h.h.tR(l);
            localh = com.tencent.mm.plugin.story.h.h.ynv;
            com.tencent.mm.plugin.story.h.h.dJC().dTu = l;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).du(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
        if (MoreTabUI.k(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.k(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.ynv;
            com.tencent.mm.plugin.story.h.h.dJj().dTd = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.ynv;
            com.tencent.mm.plugin.story.h.h.dJj().dUE = 1L;
            MoreTabUI.k(MoreTabUI.this).ad(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.l(MoreTabUI.this);
            MoreTabUI.m(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if (MoreTabUI.n(MoreTabUI.this) != null) {
            MoreTabUI.n(MoreTabUI.this).eAh();
          }
          if ((!MoreTabUI.o(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
          {
            int i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fve, 0);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fve, Integer.valueOf(i + 1));
            MoreTabUI.q(MoreTabUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
          AppMethodBeat.o(33526);
          return;
        }
      }
    };
    this.FQB = new a();
    AppMethodBeat.o(33555);
  }
  
  private void Xw(int paramInt)
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
  
  private void eRA()
  {
    AppMethodBeat.i(33575);
    this.uAh = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.ydc, null);
    if (this.uAh != null)
    {
      this.uAh.dFU();
      this.FQq = (-(ap.cf(getContext()).y / 10));
      if (!this.FQr) {
        break label240;
      }
    }
    label240:
    for (int i = com.tencent.mm.cd.a.ap(getContext(), 2131166722);; i = com.tencent.mm.cd.a.ap(getContext(), 2131166721))
    {
      this.FQp = i;
      this.FQo = (-com.tencent.mm.cd.a.fromDPToPix(getContext(), 330));
      this.FQn = 0;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ap.cf(getContext()).y);
      localLayoutParams.topMargin = this.FQq;
      localLayoutParams.bottomMargin = (-ap.eb(getContext()));
      this.FQh.addView(this.uAh, 0, localLayoutParams);
      this.FQg.A(this.uAh, this.FQp, this.FQq);
      this.FQg.setNavigationBarHeight(ap.eb(getActivity()));
      this.uAh.setDataSeed(com.tencent.mm.model.u.aqG());
      this.uAh.a(this.FQg);
      this.uAh.setStoryBrowseUIListener(this);
      this.FQj.eRB();
      AppMethodBeat.o(33575);
      return;
    }
  }
  
  private void eRs()
  {
    AppMethodBeat.i(33559);
    if (!this.FQr)
    {
      if (!com.tencent.mm.kernel.g.afw())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fve, 0);
      boolean bool = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FuR, false);
      ad.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.uCI) && ((bool) || (i > 0)))
      {
        this.FQr = true;
        if (this.FQl != null) {
          this.FQl.aD(this.uCI, this.FQr);
        }
        if (!this.FQr) {
          break label145;
        }
      }
    }
    label145:
    for (int i = com.tencent.mm.cd.a.ap(getContext(), 2131166722);; i = com.tencent.mm.cd.a.ap(getContext(), 2131166721))
    {
      this.FQp = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void eRt()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.bs.d.axB("sns"))
    {
      this.screen.cE("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.cE("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.aKk("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fvn, true)) && (this.FQt))
      {
        localIconPreference.XS(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.FQt = false;
      localIconPreference.XS(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void eRu()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).bJs()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).bJt())) || (!com.tencent.mm.bs.d.axB("card")))
    {
      this.screen.cE("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).bJu();; localObject1 = "")
    {
      this.screen.cE("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aKk("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.z.c.adr().cJ(262152, 266256);
      boolean bool3 = com.tencent.mm.z.c.adr().cI(262152, 266256);
      boolean bool4 = com.tencent.mm.z.c.adr().a(ae.a.Fhi, ae.a.Fhk);
      boolean bool5 = com.tencent.mm.z.c.adr().a(ae.a.Fhj, ae.a.Fhl);
      com.tencent.mm.model.az.arV();
      String str = (String)com.tencent.mm.model.c.afk().get(ae.a.Fhr, "");
      localNormalIconNewTipPreference.setTitle(2131763275);
      com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.cWs().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.tWJ = this.FQv;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.XQ(0);
        localNormalIconNewTipPreference.fV(getString(2131755829), 2131233430);
        localNormalIconNewTipPreference.XS(8);
        localNormalIconNewTipPreference.setSummary(null);
        localNormalIconNewTipPreference.aD(null);
        localNormalIconNewTipPreference.XU(8);
        localNormalIconNewTipPreference.fW("", -1);
        localNormalIconNewTipPreference.XR(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uew, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131165965);
        Object localObject2 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aih();
        com.tencent.mm.aw.o.ayK();
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hkl = null;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hjU = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).gkG = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).hjS = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).gjw = i;
        ((com.tencent.mm.aw.a.a.c.a)localObject2).gjv = i;
        localObject2 = ((com.tencent.mm.aw.a.a.c.a)localObject2).azc();
        com.tencent.mm.aw.o.ayJ().a(str, localNormalIconNewTipPreference.eTA(), (com.tencent.mm.aw.a.a.c)localObject2, this.FQv);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uey, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.XS(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uev, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.fV("", -1);
          localNormalIconNewTipPreference.XQ(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.setSummary(null);
            if (!ae.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aN((String)localObject1, -1, getResources().getColor(2131100490));
              localNormalIconNewTipPreference.XR(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uex, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aD(null);
              localNormalIconNewTipPreference.XU(8);
              break;
              label633:
              localNormalIconNewTipPreference.XS(8);
              continue;
            }
            localNormalIconNewTipPreference.fW("", -1);
            localNormalIconNewTipPreference.XR(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.fW("", -1);
          localNormalIconNewTipPreference.XR(8);
          if (!ae.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uex, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.setSummary(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.XR(8);
      localNormalIconNewTipPreference.XQ(8);
      localNormalIconNewTipPreference.setSummary(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void eRv()
  {
    AppMethodBeat.i(33566);
    this.screen.cE("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.screen.aKk("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.XV(8);
      bool = com.tencent.mm.z.c.adr().cI(262145, 266242);
      if (bool)
      {
        localIconPreference.XQ(0);
        localIconPreference.fV(getString(2131755829), 2131233430);
      }
      for (;;)
      {
        localIconPreference.XS(8);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(33566);
        return;
        localIconPreference.XQ(8);
        localIconPreference.fV("", -1);
      }
      com.tencent.mm.model.az.arV();
      i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fog, Integer.valueOf(0))).intValue();
      com.tencent.mm.model.az.arV();
      int j = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Foh, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).ese()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).esf()) || (i > j)) && (!bool))
      {
        localIconPreference.XS(0);
        localIconPreference.XQ(8);
        localIconPreference.fV("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.XS(8);
      if (com.tencent.mm.z.c.adr().cJ(262157, 266261))
      {
        localIconPreference.XS(0);
        localIconPreference.XQ(8);
        localIconPreference.fV("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.XS(8);
      if (com.tencent.mm.z.c.adr().cJ(262158, 266264))
      {
        localIconPreference.XS(0);
        localIconPreference.XQ(8);
        localIconPreference.fV("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      if (com.tencent.mm.z.c.adr().a(ae.a.FsT, 266242))
      {
        localIconPreference.XS(0);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.XS(8);
      com.tencent.mm.model.az.arV();
      if ((com.tencent.mm.model.c.afk().getInt(40, 0) & 0x20000) != 0) {
        break label580;
      }
    }
    label580:
    for (int i = 1;; i = 0)
    {
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("VoiceprintEntry"), 0) == 1) {
        com.tencent.mm.model.az.arV();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FgL, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ad.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.XS(0);
          AppMethodBeat.o(33566);
          return;
        }
        localIconPreference.XS(8);
        com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.cWt().Is(com.tencent.mm.plugin.newtips.a.d.udR);
        if ((locala != null) && (!locala.field_isExit))
        {
          com.tencent.mm.plugin.newtips.a.cWs().ues = new i.a()
          {
            public final void e(com.tencent.mm.plugin.newtips.b.a paramAnonymousa)
            {
              AppMethodBeat.i(33546);
              if ((paramAnonymousa != null) && (paramAnonymousa.field_tipId == com.tencent.mm.plugin.newtips.a.d.udR))
              {
                com.tencent.mm.plugin.newtips.a.cWv();
                if (com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udR))
                {
                  localIconPreference.XS(0);
                  localIconPreference.XQ(8);
                  localIconPreference.fV("", -1);
                  AppMethodBeat.o(33546);
                  return;
                }
              }
              AppMethodBeat.o(33546);
            }
          };
          AppMethodBeat.o(33566);
          return;
        }
        com.tencent.mm.plugin.newtips.a.cWv();
        if (com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udR))
        {
          localIconPreference.XS(0);
          localIconPreference.XQ(8);
          localIconPreference.fV("", -1);
          AppMethodBeat.o(33566);
          return;
        }
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void eRw()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.bs.d.axB("emoji"))
    {
      com.tencent.mm.bs.d.eBj();
      this.screen.cE("settings_emoji_store", false);
      bool1 = com.tencent.mm.z.c.adr().cI(262147, 266244);
      bool2 = com.tencent.mm.z.c.adr().cI(262149, 266244);
      localIconPreference = (IconPreference)this.screen.aKk("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.cE("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.XQ(0);
      localIconPreference.fV(getString(2131755829), 2131233430);
    }
    while ((bool2) || (bool1))
    {
      com.tencent.mm.model.az.arV();
      String str = (String)com.tencent.mm.model.c.afk().get(229633, null);
      com.tencent.mm.aw.o.ayJ().a(str, localIconPreference.eTA(), new com.tencent.mm.aw.a.c.h()
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
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.14.this.FQH.aD(this.ibC);
                MoreTabUI.14.this.FQH.XU(0);
                AppMethodBeat.o(33549);
              }
            });
            AppMethodBeat.o(33551);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33550);
              MoreTabUI.14.this.FQH.XU(8);
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
        localIconPreference.XQ(0);
        localIconPreference.fV(getString(2131755781), 2131233430);
      }
      else
      {
        localIconPreference.XQ(8);
        localIconPreference.fV("", -1);
      }
    }
    localIconPreference.XU(8);
    AppMethodBeat.o(33567);
  }
  
  private void eRx()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = com.tencent.mm.model.u.aqQ();
    ad.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.cE("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (bt.iY(i, -1)) {
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label144:
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(1056L, 0L, 1L, false);
    label156:
    AppMethodBeat.o(33568);
  }
  
  private void eRy()
  {
    AppMethodBeat.i(33569);
    com.tencent.mm.model.az.arV();
    int i = ae.h((Integer)com.tencent.mm.model.c.afk().get(204820, null));
    com.tencent.mm.model.az.arV();
    int j = i + ae.h((Integer)com.tencent.mm.model.c.afk().get(204817, null));
    boolean bool3 = com.tencent.mm.z.c.adr().cI(262156, 266248);
    boolean bool4 = com.tencent.mm.z.c.adr().cJ(262156, 266248);
    boolean bool5 = com.tencent.mm.z.c.adr().b(ae.a.Fqr, ae.a.Fqt);
    com.tencent.mm.model.az.arV();
    String str2 = (String)com.tencent.mm.model.c.afk().get(ae.a.Fqu, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aKk("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    ad.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    ad.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.cWs().h(localNormalIconNewTipPreference);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    com.tencent.mm.model.az.arV();
    String str3 = (String)com.tencent.mm.model.c.afk().get(ae.a.FpS, "");
    com.tencent.mm.model.az.arV();
    int k = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FpT, Integer.valueOf(-1))).intValue();
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
      com.tencent.mm.model.az.arV();
      l1 = ((Long)com.tencent.mm.model.c.afk().get(ae.a.FpQ, Long.valueOf(-1L))).longValue();
      long l2 = ae.aa(com.tencent.mm.m.g.Zd().getValue("PayWalletRedDotExpire"));
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
            com.tencent.mm.z.c.adr().w(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.afC();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrS, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.afC();
    long l1 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrT, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      ad.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrS, Boolean.FALSE);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrT, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.afC();
      Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrP, "");
      ad.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.z.c.adr().b(ae.a.FrW, ae.a.Fsc);
      com.tencent.mm.kernel.g.afC();
      l1 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrY, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        ad.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.z.c.adr().c(ae.a.FrW, ae.a.Fsc);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrY, Long.valueOf(0L));
      }
      for (;;)
      {
        bool3 |= bool2;
        com.tencent.mm.kernel.g.afC();
        String str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrV, "");
        ad.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), str1 });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
        if (bool3)
        {
          i = 1;
          localh.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
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
            localNormalIconNewTipPreference.XR(0);
            localNormalIconNewTipPreference.aN(str2, -1, -7566196);
            localNormalIconNewTipPreference.vQ(true);
            localNormalIconNewTipPreference.XS(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uex, true);
            if (bt.isNullOrNil(str1)) {
              break label1380;
            }
            localObject = str1;
          }
        }
        label1380:
        for (;;)
        {
          if ((!ae.isNullOrNil((String)localObject)) && (bool3))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject);
            AppMethodBeat.o(33569);
            return;
            localNormalIconNewTipPreference.fW("", -1);
            localNormalIconNewTipPreference.XR(8);
            localNormalIconNewTipPreference.XS(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uev, true);
            break;
            if (bool1)
            {
              localNormalIconNewTipPreference.XQ(0);
              localNormalIconNewTipPreference.fV(getString(2131755829), 2131233430);
              localNormalIconNewTipPreference.XS(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uew, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.XQ(0);
              localNormalIconNewTipPreference.fV(getString(2131764343), com.tencent.mm.ui.tools.u.kh(getContext()));
              localNormalIconNewTipPreference.XS(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.ueA, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.XQ(0);
              localNormalIconNewTipPreference.fV(String.valueOf(j), com.tencent.mm.ui.tools.u.aG(getContext(), j));
              localNormalIconNewTipPreference.XS(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.ueA, true);
              break;
            }
            if (bool3)
            {
              localNormalIconNewTipPreference.fV("", -1);
              localNormalIconNewTipPreference.XQ(8);
              localNormalIconNewTipPreference.XS(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uev, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.fV("", -1);
              localNormalIconNewTipPreference.XQ(8);
              localNormalIconNewTipPreference.XR(0);
              localNormalIconNewTipPreference.vQ(true);
              if (!ae.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.aN(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.XV(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.uex, true);
              break;
            }
            localNormalIconNewTipPreference.fV("", -1);
            localNormalIconNewTipPreference.XQ(8);
            localNormalIconNewTipPreference.XS(8);
            localNormalIconNewTipPreference.XR(8);
            localNormalIconNewTipPreference.fW("", -1);
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
  
  private boolean eRz()
  {
    AppMethodBeat.i(33571);
    com.tencent.mm.plugin.flutter.a.c localc = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
    ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), localc);
    AppMethodBeat.o(33571);
    return true;
  }
  
  private boolean vA(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.u.c.lod.a(com.tencent.mm.plugin.appbrand.u.c.a.loi);
    com.tencent.mm.plugin.appbrand.u.c.lod.a(com.tencent.mm.plugin.appbrand.u.c.a.lou);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.bs.d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void vB(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.uAp == null)
      {
        View localView = findViewById(2131296345);
        if (localView != null) {
          this.uAp = localView.findViewById(2131296343);
        }
        if (this.uAp == null) {
          break label103;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.uAp == null) {
          break label116;
        }
        if (!paramBoolean) {
          break;
        }
        this.uAp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33537);
            ad.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.i(MoreTabUI.this))
            {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
              AppMethodBeat.o(33537);
              return;
            }
            if ((MoreTabUI.j(MoreTabUI.this) != null) && (MoreTabUI.j(MoreTabUI.this).isVisible)) {
              MoreTabUI.j(MoreTabUI.this).ffS();
            }
            AppMethodBeat.o(33537);
          }
        });
        AppMethodBeat.o(33587);
        return;
        label103:
        bool = false;
      }
      this.uAp.setOnClickListener(null);
    }
    label116:
    AppMethodBeat.o(33587);
  }
  
  private void vC(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.FQg != null) && (this.FQg.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().vu(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33570);
    int i = ae.cd(paramObject);
    ad.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    com.tencent.mm.model.az.arV();
    if ((paramn != com.tencent.mm.model.c.afk()) || (i <= 0))
    {
      ad.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      eRy();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      eRx();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      eRw();
    }
    AppMethodBeat.o(33570);
  }
  
  public final void dci()
  {
    AppMethodBeat.i(33584);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.FQg != null) && (!this.FQg.isVisible)) {
      this.FQg.ffR();
    }
    if ((!com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) || (this.pTY)) {
      this.FQj.Xx(2);
    }
    for (;;)
    {
      if (this.FQl != null) {
        this.FQl.eAh();
      }
      AppMethodBeat.o(33584);
      return;
      this.FQj.Xx(1);
    }
  }
  
  public final void dcj()
  {
    AppMethodBeat.i(33585);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.FQg != null) && (this.FQg.isVisible) && (this.FQs))
    {
      if (!this.pTY) {
        break label106;
      }
      this.FQj.Xx(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.aKk("settings_my_album");
      if (localIconPreference == null) {
        break label128;
      }
      if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fvn, true)) {
        break;
      }
      this.FQt = true;
      localIconPreference.XS(0);
      AppMethodBeat.o(33585);
      return;
      label106:
      this.FQj.Xx(0);
    }
    this.FQt = false;
    localIconPreference.XS(8);
    label128:
    AppMethodBeat.o(33585);
  }
  
  public final void dck()
  {
    AppMethodBeat.i(33586);
    ad.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.FQg != null) && (!this.FQg.isVisible)) {
      this.FQg.ffR();
    }
    Xw(0);
    vC(this.uCI);
    AppMethodBeat.o(33586);
  }
  
  final void dcm()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  protected final void eOU()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.pTY = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.FQu = bool1;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.ca(getContext());
      com.tencent.mm.kernel.g.afC();
      this.uAi = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gc(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cd.a.ap(getContext(), 2131166720), com.tencent.mm.cd.a.ap(getContext(), 2131166720));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131303135).getParent()).addView(this.uAi, 0, (ViewGroup.LayoutParams)localObject);
      this.FQg.HHP = this.mPullDownCallback;
      this.FQg.setPadding(this.FQg.getPaddingLeft(), this.FQg.getPaddingTop(), this.FQg.getPaddingRight(), this.FQi.getHeight());
      if (this.FQh != null)
      {
        ad.d("MicroMsg.MoreTabUI", "dancy test add view !");
        eRA();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void eOV()
  {
    AppMethodBeat.i(33577);
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    com.tencent.mm.model.az.arV();
    com.tencent.mm.model.c.afk().a(this);
    com.tencent.mm.z.c.adr().a(this.wjB);
    this.screen.cE("more_tab_setting_personal_info", false);
    this.FQl = ((AccountInfoPreference)this.adapter.aKk("more_tab_setting_personal_info"));
    Object localObject = com.tencent.mm.model.u.aqH();
    if (ae.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.model.u.aqG();
      if (af.aHK((String)localObject))
      {
        this.FQl.ChQ = null;
        this.FQl.userName = com.tencent.mm.model.u.aqG();
        String str = com.tencent.mm.model.u.aqI();
        localObject = str;
        if (ae.isNullOrNil(str)) {
          localObject = com.tencent.mm.model.u.aqJ();
        }
        this.FQl.ChP = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject);
        this.FQl.aD(this.uCI, this.FQr);
        this.FQl.Cid = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33547);
            if (MoreTabUI.i(MoreTabUI.this))
            {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
              AppMethodBeat.o(33547);
              return;
            }
            if (MoreTabUI.j(MoreTabUI.this) != null) {
              MoreTabUI.j(MoreTabUI.this).ffS();
            }
            AppMethodBeat.o(33547);
          }
        };
        ((AccountInfoPreference)this.screen.aKk("more_tab_setting_personal_info")).Cic = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33548);
            com.tencent.mm.plugin.report.service.h.vKh.f(11264, new Object[] { Integer.valueOf(1) });
            paramAnonymousView = MoreTabUI.this;
            Object localObject = new Intent(MoreTabUI.this.getContext(), SelfQRCodeUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33548);
          }
        };
        localObject = (IconPreference)this.screen.aKk("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.bk.d.aCo().eLD();
          if (i <= 0) {
            break label687;
          }
          ((IconPreference)localObject).XQ(0);
          ((IconPreference)localObject).fV(String.valueOf(i), 2131233430);
        }
        label261:
        eRt();
        eRw();
        eRv();
        if (com.tencent.mm.bs.d.axB("favorite")) {
          break label706;
        }
        this.screen.cE("settings_mm_favorite", true);
        label296:
        eRy();
        eRx();
        eRu();
        if (!com.tencent.mm.kernel.g.afx().aa(com.tencent.mm.plugin.y.a.a.class)) {
          break label723;
        }
        this.screen.cE("more_uishow", false);
        label334:
        localObject = this.screen.aKk("settings_privacy_agreements");
        if (!com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null))) {
          break label740;
        }
        str = getString(2131762010);
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
        localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131100547)), localSpannable.length() - str.length(), localSpannable.length(), 33);
        ((Preference)localObject).setTitle(localSpannable);
        this.screen.cE("settings_privacy_agreements", false);
        label456:
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        localObject = findViewById(2131301512);
        if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
          new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33535);
              this.FJX.setVisibility(8);
              this.FJX.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), 2130772048));
              AppMethodBeat.o(33535);
            }
          });
        }
        if ((this.FQg != null) && (this.FQg.isVisible))
        {
          Xw(0);
          ad.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.uAh != null)
        {
          this.uAh.onResume();
          this.uAh.dFT();
        }
        if (this.FQl != null)
        {
          localObject = this.FQl;
          if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.z.c.adr().cI(352279, 266241))) {
            break label757;
          }
        }
      }
    }
    label687:
    label706:
    label723:
    label740:
    label757:
    for (boolean bool = true;; bool = false)
    {
      ((AccountInfoPreference)localObject).Cia = bool;
      this.FQl.eAi();
      ad.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      this.FQl.ChQ = ((String)localObject);
      break;
      this.FQl.ChQ = ((String)localObject);
      break;
      ((IconPreference)localObject).XQ(8);
      ((IconPreference)localObject).fV("", -1);
      break label261;
      this.screen.cE("settings_mm_favorite", false);
      break label296;
      this.screen.cE("more_uishow", true);
      break label334;
      this.screen.cE("settings_privacy_agreements", true);
      break label456;
    }
  }
  
  protected final void eOW()
  {
    AppMethodBeat.i(33578);
    if (this.uAh != null) {
      this.uAh.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void eOX()
  {
    AppMethodBeat.i(33579);
    ad.d("MicroMsg.MoreTabUI", "onTabPause");
    com.tencent.mm.z.c.adr().b(this.wjB);
    com.tencent.mm.model.az.arV();
    com.tencent.mm.model.c.afk().b(this);
    if (this.uAh != null) {
      this.uAh.onPause();
    }
    if (this.FQg != null)
    {
      if ((this.FQg.isVisible) || (this.uCI)) {
        break label118;
      }
      this.FQg.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33536);
          MoreTabUI.j(MoreTabUI.this).ffR();
          AppMethodBeat.o(33536);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.FQl != null) {
        this.FQl.eAh();
      }
      vB(false);
      AppMethodBeat.o(33579);
      return;
      label118:
      if ((this.FQg.isVisible) && (this.FQg.getTranslationY() != 0.0F)) {
        this.FQg.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void eOY()
  {
    AppMethodBeat.i(33580);
    if (this.uAh != null) {
      this.uAh.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void eOZ()
  {
    AppMethodBeat.i(33581);
    if (this.uAh != null) {
      this.uAh.onDestroy();
    }
    if (this.FQl != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.FQl;
      if (localAccountInfoPreference.paC) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().eZ(localAccountInfoPreference.ChW);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void ePb() {}
  
  public final void ePc() {}
  
  public final void ePe() {}
  
  public final void eQa()
  {
    AppMethodBeat.i(33582);
    ad.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.FQs = true;
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.pTY = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label240;
        }
        bool = true;
        label74:
        this.FQu = bool;
      }
    }
    else if (this.FQg != null)
    {
      localObject = this.FQg;
      an.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).HHL = true;
      if ((!this.FQg.isVisible) || (this.FQg.getTranslationY() == 0.0F)) {
        break label245;
      }
      this.FQg.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.uAh != null) {
        this.uAh.dFT();
      }
      vB(true);
      long l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.tR(l);
      localObject = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJC().dTu = l;
      localObject = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJC().dUH = System.currentTimeMillis();
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(34);
      }
      AppMethodBeat.o(33582);
      return;
      bool = false;
      break;
      label240:
      bool = false;
      break label74;
      label245:
      if (!this.FQg.isVisible) {
        this.FQg.ffR();
      }
    }
  }
  
  public final void eQb()
  {
    AppMethodBeat.i(33583);
    this.FQs = false;
    if (this.FQg != null)
    {
      localObject = this.FQg;
      an.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).HHL = false;
      if (!this.FQg.isVisible) {
        this.FQg.ffR();
      }
    }
    if (this.uAi != null) {
      this.uAi.setVisibility(8);
    }
    Object localObject = new ux();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    vB(false);
    localObject = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJD();
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
    this.screen.cE("more_setting", true);
    this.screen.cE("settings_emoji_store", true);
    this.screen.cE("settings_mm_wallet", true);
    this.screen.cE("settings_mm_cardpackage", true);
    this.screen.cE("settings_mm_favorite", true);
    this.screen.cE("settings_my_album", true);
    this.screen.cE("settings_my_address", true);
    this.screen.cE("more_tab_setting_personal_info", true);
    this.screen.cE("more_uishow", true);
    this.screen.cE("settings_privacy_agreements", true);
    this.FQi = getView().getRootView().findViewById(2131301338);
    this.FQh = ((RelativeLayout)findViewById(2131303379));
    this.FQg = ((PullDownListView)this.list);
    this.FQg.setTabView(this.FQi);
    this.FQg.setBackground(ao.aC(getContext(), 2130969307));
    this.FQg.setOnScrollListener(new AbsListView.OnScrollListener()
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
      this.pTY = false;
      if (this.FQg != null) {
        this.FQj.eRB();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label214;
      }
    }
    for (;;)
    {
      if (bool != this.FQu)
      {
        this.FQu = bool;
        if ((this.uAh != null) && (this.FQh != null) && (this.FQg != null))
        {
          this.uAh.onDestroy();
          this.FQh.removeView(this.uAh);
          eRA();
          this.uAh.onResume();
          if (!this.FQg.isVisible)
          {
            this.FQg.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33538);
                MoreTabUI.j(MoreTabUI.this).ffR();
                AppMethodBeat.o(33538);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.pTY = true;
            if (this.FQg == null) {
              break;
            }
            if (!this.FQg.isVisible) {
              this.FQg.ffR();
            }
            this.FQj.Xx(2);
            break;
            label214:
            bool = false;
            continue;
          }
          if ((this.FQg.isVisible) && (this.FQg.getTranslationY() != 0.0F)) {
            this.FQg.setTranslationY(0.0F);
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
    if ((!com.tencent.mm.model.az.afw()) || (com.tencent.mm.model.az.aeC()))
    {
      ad.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(com.tencent.mm.model.az.afw()), Boolean.valueOf(com.tencent.mm.model.az.aeC()) });
      AppMethodBeat.o(33556);
      return;
    }
    eRs();
    vB(false);
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
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.uAh != null)) {}
    for (boolean bool = this.uAh.onBackPressed();; bool = false)
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
    if (this.FQs)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJD();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33563);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (Object localObject = "null";; localObject = paramPreference.mKey)
    {
      ad.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.afw()) {
        break;
      }
      ad.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.bs.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      AppMethodBeat.o(33563);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      com.tencent.mm.plugin.newtips.a.cWs().Ip(13);
      bool1 = com.tencent.mm.z.c.adr().cI(262156, 266248);
      boolean bool2 = com.tencent.mm.z.c.adr().cJ(262156, 266248);
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.h.vKh;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.f(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.h.vKh.f(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new qm();
        paramPreference.dwd.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.dwd.intent = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.ESL.l(paramPreference);
        com.tencent.mm.z.c.adr().cK(262156, 266248);
        com.tencent.mm.z.c.adr().c(ae.a.Fqr, ae.a.Fqt);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FpS, "");
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FpT, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrS, Boolean.FALSE);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrP, "");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrQ, Boolean.FALSE);
        com.tencent.mm.z.c.adr().c(ae.a.FrW, ae.a.Fsc);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrV, "");
        paramf = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool2) {
          break label642;
        }
      }
      label642:
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        AppMethodBeat.o(33563);
        return true;
        i = 0;
        break;
      }
    }
    if (paramPreference.mKey.equals("settings_mm_cardpackage"))
    {
      com.tencent.mm.plugin.newtips.a.cWs().Ip(14);
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fho, "");
      new Intent().putExtra("key_from_scene", 22);
      ad.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new jg();
      paramf.dnt.context = getContext();
      paramf.dnt.enterScene = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramf);
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      com.tencent.mm.model.az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(getContext(), null);
        AppMethodBeat.o(33563);
        return true;
      }
      com.tencent.mm.model.az.arV();
      paramf = (String)com.tencent.mm.model.c.afk().get(2, null);
      paramPreference = new Intent(getContext(), AlbumUI.class);
      paramPreference.putExtra("sns_userName", paramf);
      paramPreference.putExtra("username", paramf);
      paramPreference.putExtra("story_dot", this.FQt);
      paramPreference.setFlags(536870912);
      paramPreference.addFlags(67108864);
      com.tencent.mm.model.az.arV();
      i = ae.h((Integer)com.tencent.mm.model.c.afk().get(68389, null));
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.afk().set(68389, Integer.valueOf(i + 1));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.h.vKh.f(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cr.d.fkP();
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10958, "7");
      if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
      {
        bool1 = eRz();
        AppMethodBeat.o(33563);
        return bool1;
      }
      com.tencent.mm.z.c.adr().cK(262147, 266244);
      com.tencent.mm.z.c.adr().cK(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.h.vKh.f(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eG(com.tencent.mm.plugin.boots.a.b.mQE, 881);
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.z.c.adr().cI(262145, 266242);
      com.tencent.mm.z.c.adr().cK(262145, 266242);
      com.tencent.mm.z.c.adr().cK(262157, 266261);
      com.tencent.mm.z.c.adr().cK(262158, 266264);
      com.tencent.mm.z.c.adr().b(ae.a.FsT, 266242);
      paramPreference = new Intent();
      com.tencent.mm.bs.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      com.tencent.mm.model.az.arV();
      i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fog, Integer.valueOf(0))).intValue();
      com.tencent.mm.model.az.arV();
      int j = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Foh, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.Foh, Integer.valueOf(i));
        paramf = (IconPreference)paramf.aKk("more_setting");
        if (paramf != null) {
          paramf.XS(8);
        }
        com.tencent.mm.z.c.adr().cK(266260, 266241);
      }
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(33544);
          paramAnonymousl.c(1, "FluterEmojiStore");
          paramAnonymousl.c(3, "weui");
          AppMethodBeat.o(33544);
        }
      };
      paramf.HrY = new n.d()
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
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.h(MoreTabUI.this);
          }
        }
      };
      paramf.csG();
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131760685, new Object[] { ac.eFu(), com.tencent.mm.kernel.g.afB().afk().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
      AppMethodBeat.o(33563);
      return true;
    }
    AppMethodBeat.o(33563);
    return false;
  }
  
  public final boolean onPreferenceTreeLongClick(f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33562);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33562);
      return true;
    }
    boolean bool;
    try
    {
      if ((bu.eEO()) || (bu.eGR()) || (bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
      {
        if (bt.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = vA(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (bt.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = vA(false);
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
    eRs();
    if (this.FQs)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.tR(l);
      localh = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJC().dTu = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
    implements com.tencent.mm.al.g
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn) {}
  }
  
  final class b
  {
    private int status = 2;
    
    private b() {}
    
    public final void Xx(int paramInt)
    {
      AppMethodBeat.i(33554);
      ad.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0) {
        MoreTabUI.d(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        dco();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    public final void dco()
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
        MoreTabUI.j(MoreTabUI.this).setSupportOverscroll(true);
        MoreTabUI.q(MoreTabUI.this);
        if (MoreTabUI.p(MoreTabUI.this)) {
          MoreTabUI.j(MoreTabUI.this).setBackground(ao.aC(MoreTabUI.this.getContext(), 2130969308));
        }
        for (;;)
        {
          if (MoreTabUI.k(MoreTabUI.this) != null)
          {
            ((RelativeLayout.LayoutParams)MoreTabUI.k(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.w(MoreTabUI.this);
            MoreTabUI.j(MoreTabUI.this).A(MoreTabUI.k(MoreTabUI.this), MoreTabUI.x(MoreTabUI.this), MoreTabUI.w(MoreTabUI.this));
          }
          MoreTabUI.j(MoreTabUI.this).setMuteView(null);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
          MoreTabUI.a(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
          if (MoreTabUI.n(MoreTabUI.this) == null) {
            break;
          }
          MoreTabUI.n(MoreTabUI.this).aD(MoreTabUI.o(MoreTabUI.this), MoreTabUI.p(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.j(MoreTabUI.this).setBackground(ao.aC(MoreTabUI.this.getContext(), 2130969307));
        }
        MoreTabUI.j(MoreTabUI.this).setBackground(ao.aC(MoreTabUI.this.getContext(), 2130969307));
        MoreTabUI.j(MoreTabUI.this).setSupportOverscroll(MoreTabUI.o(MoreTabUI.this));
        MoreTabUI.y(MoreTabUI.this);
        MoreTabUI.b(MoreTabUI.this, com.tencent.mm.cd.a.ap(MoreTabUI.this.getContext(), 2131166721));
        if (MoreTabUI.k(MoreTabUI.this) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.k(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.z(MoreTabUI.this);
          MoreTabUI.j(MoreTabUI.this).A(MoreTabUI.k(MoreTabUI.this), MoreTabUI.x(MoreTabUI.this), MoreTabUI.z(MoreTabUI.this));
        }
        MoreTabUI.j(MoreTabUI.this).setMuteView(MoreTabUI.v(MoreTabUI.this));
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
        MoreTabUI.a(MoreTabUI.this, 0);
        MoreTabUI.b(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
        if (MoreTabUI.n(MoreTabUI.this) != null)
        {
          MoreTabUI.n(MoreTabUI.this).aD(MoreTabUI.o(MoreTabUI.this), MoreTabUI.p(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.j(MoreTabUI.this).setBackground(ao.aC(MoreTabUI.this.getContext(), 2130969308));
          MoreTabUI.j(MoreTabUI.this).setSupportOverscroll(MoreTabUI.o(MoreTabUI.this));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.o(MoreTabUI.this));
          MoreTabUI.l(MoreTabUI.this);
          if (MoreTabUI.n(MoreTabUI.this) != null) {
            MoreTabUI.n(MoreTabUI.this).aD(MoreTabUI.o(MoreTabUI.this), MoreTabUI.p(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void eRB()
    {
      AppMethodBeat.i(33553);
      if ((!com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) || (MoreTabUI.i(MoreTabUI.this)))
      {
        MoreTabUI.d(MoreTabUI.this, false);
        this.status = 2;
      }
      for (;;)
      {
        ad.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
        dco();
        AppMethodBeat.o(33553);
        return;
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(com.tencent.mm.model.u.aqG()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */