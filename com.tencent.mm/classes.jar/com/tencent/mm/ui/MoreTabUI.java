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
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.model.az;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import java.util.HashMap;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, n.b
{
  private RelativeLayout DAo;
  private FrameLayout DAp;
  private LinearLayout DAq;
  private boolean DAr;
  PullDownListView HpR;
  private RelativeLayout HpS;
  private View HpT;
  private b HpU;
  private boolean HpV;
  private AccountInfoPreference HpW;
  private RelativeLayout HpX;
  private int HpY;
  private int HpZ;
  private int Hqa;
  private int Hqb;
  private boolean Hqc;
  private boolean Hqd;
  private boolean Hqe;
  private boolean Hqf;
  private com.tencent.mm.av.a.c.h Hqg;
  public boolean Hqh;
  private boolean Hqi;
  public boolean Hqj;
  private int Hqk;
  private int Hql;
  private a Hqm;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean qCD;
  private f screen;
  private AbsStoryGallery vJa;
  private AbsStoryMuteView vJb;
  private View vJi;
  private boolean vLB;
  private byte[] xpp;
  private com.tencent.mm.y.a.a xuR;
  private Bitmap zTx;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.zTx = null;
    this.xpp = null;
    this.vJb = null;
    this.HpS = null;
    this.HpT = null;
    this.vJa = null;
    this.HpU = new b((byte)0);
    this.vLB = false;
    this.HpV = false;
    this.HpW = null;
    this.DAr = false;
    this.DAo = null;
    this.DAp = null;
    this.HpX = null;
    this.DAq = null;
    this.HpY = 0;
    this.HpZ = 0;
    this.Hqa = 0;
    this.Hqb = 0;
    this.qCD = false;
    this.Hqc = false;
    this.Hqd = false;
    this.Hqe = false;
    this.Hqf = false;
    this.xuR = new com.tencent.mm.y.a.a()
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
      
      public final void b(ah.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == ah.a.GEX) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.f(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == ah.a.GEY) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == ah.a.GOh) || (paramAnonymousa == ah.a.GPM)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == ah.a.GQM) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.Hqg = new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.Hqp.aaf(0);
            this.Hqp.aae(2131233400);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.f(MoreTabUI.this).aPN("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.aF(this.iBJ);
              paramAnonymousString.aaf(0);
              AppMethodBeat.o(33540);
            }
          });
          AppMethodBeat.o(33543);
          return;
        }
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33541);
            paramAnonymousString.aF(null);
            paramAnonymousString.aaf(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
    };
    this.Hqh = true;
    this.Hqi = true;
    this.Hqj = true;
    this.Hqk = com.tencent.mm.cc.a.fromDPToPix(getContext(), 48);
    this.Hql = com.tencent.mm.cc.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void Lh(int paramAnonymousInt)
      {
        AppMethodBeat.i(33532);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).Qp(paramAnonymousInt);
        }
        AppMethodBeat.o(33532);
      }
      
      public final void Li(int paramAnonymousInt)
      {
        AppMethodBeat.i(33533);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).Qq(paramAnonymousInt);
        }
        AppMethodBeat.o(33533);
      }
      
      public final void Lj(int paramAnonymousInt)
      {
        AppMethodBeat.i(33534);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).Lj(paramAnonymousInt);
        }
        AppMethodBeat.o(33534);
      }
      
      public final void dpX()
      {
        AppMethodBeat.i(33528);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).dUs();
        }
        if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
        {
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dYd().dWv = System.currentTimeMillis();
          localh = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dYe();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).DAs = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33528);
      }
      
      public final void dpY()
      {
        AppMethodBeat.i(33529);
        if (MoreTabUI.l(MoreTabUI.this) != null) {
          MoreTabUI.l(MoreTabUI.this).dUt();
        }
        if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this) != null)) {
          MoreTabUI.o(MoreTabUI.this).DAs = MoreTabUI.k(MoreTabUI.this).isVisible;
        }
        AppMethodBeat.o(33529);
      }
      
      public final void dpZ()
      {
        AppMethodBeat.i(33530);
        ac.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.w(MoreTabUI.this).dUy();
        AppMethodBeat.o(33530);
      }
      
      public final void dqa()
      {
        AppMethodBeat.i(33531);
        MoreTabUI.w(MoreTabUI.this).dUz();
        AppMethodBeat.o(33531);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(33527);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            MoreTabUI.l(MoreTabUI.this).rA(true);
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
            MoreTabUI.o(MoreTabUI.this).ePC();
          }
          MoreTabUI.u(MoreTabUI.this).dpW();
          if ((MoreTabUI.v(MoreTabUI.this)) && (!MoreTabUI.p(MoreTabUI.this)))
          {
            long l = System.currentTimeMillis();
            com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
            com.tencent.mm.plugin.story.h.h.yu(l);
            localh = com.tencent.mm.plugin.story.h.h.zAU;
            com.tencent.mm.plugin.story.h.h.dYd().dVg = l;
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
        if (MoreTabUI.l(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.l(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.zAU;
            com.tencent.mm.plugin.story.h.h.dXK().dUP = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.zAU;
            com.tencent.mm.plugin.story.h.h.dXK().dWq = 1L;
            MoreTabUI.l(MoreTabUI.this).ag(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.m(MoreTabUI.this);
            MoreTabUI.n(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).ePB();
          }
          if ((!MoreTabUI.p(MoreTabUI.this)) && (!MoreTabUI.q(MoreTabUI.this)))
          {
            int i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GSY, 0);
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSY, Integer.valueOf(i + 1));
            MoreTabUI.r(MoreTabUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$10", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
          AppMethodBeat.o(33526);
          return;
        }
      }
    };
    this.Hqm = new a();
    AppMethodBeat.o(33555);
  }
  
  private void ZH(int paramInt)
  {
    AppMethodBeat.i(33576);
    View localView = findViewById(2131296345);
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      ac.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33576);
      return;
    }
    ac.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
    AppMethodBeat.o(33576);
  }
  
  private void fhb()
  {
    AppMethodBeat.i(33559);
    if (!this.Hqc)
    {
      if (!com.tencent.mm.kernel.g.agM())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GSY, 0);
      boolean bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GSL, false);
      ac.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.vLB) && ((bool) || (i > 0)))
      {
        this.Hqc = true;
        if (this.HpW != null) {
          this.HpW.aH(this.vLB, this.Hqc);
        }
        if (!this.Hqc) {
          break label145;
        }
      }
    }
    label145:
    for (int i = com.tencent.mm.cc.a.av(getContext(), 2131166722);; i = com.tencent.mm.cc.a.av(getContext(), 2131166721))
    {
      this.Hqa = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void fhc()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.br.d.aCT("sns"))
    {
      this.screen.cK("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.cK("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.aPN("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GTh, true)) && (this.Hqe))
      {
        localIconPreference.aad(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.Hqe = false;
      localIconPreference.aad(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void fhd()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).bQF()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).bQG())) || (!com.tencent.mm.br.d.aCT("card")))
    {
      this.screen.cK("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).bQH();; localObject1 = "")
    {
      this.screen.cK("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aPN("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.y.c.aeH().cH(262152, 266256);
      boolean bool3 = com.tencent.mm.y.c.aeH().cG(262152, 266256);
      boolean bool4 = com.tencent.mm.y.c.aeH().a(ah.a.GEX, ah.a.GEZ);
      boolean bool5 = com.tencent.mm.y.c.aeH().a(ah.a.GEY, ah.a.GFa);
      az.ayM();
      String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GFg, "");
      localNormalIconNewTipPreference.setTitle(2131763275);
      com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.dkb().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.vfu = this.Hqg;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.aab(0);
        localNormalIconNewTipPreference.fZ(getString(2131755829), 2131233430);
        localNormalIconNewTipPreference.aad(8);
        localNormalIconNewTipPreference.setSummary(null);
        localNormalIconNewTipPreference.aF(null);
        localNormalIconNewTipPreference.aaf(8);
        localNormalIconNewTipPreference.ga("", -1);
        localNormalIconNewTipPreference.aac(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnu, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131165965);
        Object localObject2 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aph();
        com.tencent.mm.av.o.aFC();
        ((com.tencent.mm.av.a.a.c.a)localObject2).hKO = null;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hKx = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).gLt = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hKv = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).gKh = i;
        ((com.tencent.mm.av.a.a.c.a)localObject2).gKg = i;
        localObject2 = ((com.tencent.mm.av.a.a.c.a)localObject2).aFT();
        com.tencent.mm.av.o.aFB().a(str, localNormalIconNewTipPreference.fjm(), (com.tencent.mm.av.a.a.c)localObject2, this.Hqg);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnw, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.aad(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnt, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.fZ("", -1);
          localNormalIconNewTipPreference.aab(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.setSummary(null);
            if (!com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aQ((String)localObject1, -1, getResources().getColor(2131100490));
              localNormalIconNewTipPreference.aac(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnv, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aF(null);
              localNormalIconNewTipPreference.aaf(8);
              break;
              label633:
              localNormalIconNewTipPreference.aad(8);
              continue;
            }
            localNormalIconNewTipPreference.ga("", -1);
            localNormalIconNewTipPreference.aac(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.ga("", -1);
          localNormalIconNewTipPreference.aac(8);
          if (!com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnv, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.setSummary(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.aac(8);
      localNormalIconNewTipPreference.aab(8);
      localNormalIconNewTipPreference.setSummary(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void fhe()
  {
    AppMethodBeat.i(33566);
    this.screen.cK("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.screen.aPN("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.aag(8);
      bool = com.tencent.mm.y.c.aeH().cG(262145, 266242);
      if (bool)
      {
        localIconPreference.aab(0);
        localIconPreference.fZ(getString(2131755829), 2131233430);
      }
      for (;;)
      {
        localIconPreference.aad(8);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(33566);
        return;
        localIconPreference.aab(8);
        localIconPreference.fZ("", -1);
      }
      az.ayM();
      i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GLV, Integer.valueOf(0))).intValue();
      az.ayM();
      int j = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GLW, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).eHy()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.c.class)).eHz()) || (i > j)) && (!bool))
      {
        localIconPreference.aad(0);
        localIconPreference.aab(8);
        localIconPreference.fZ("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.aad(8);
      if (com.tencent.mm.y.c.aeH().cH(262157, 266261))
      {
        localIconPreference.aad(0);
        localIconPreference.aab(8);
        localIconPreference.fZ("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.aad(8);
      if (com.tencent.mm.y.c.aeH().cH(262158, 266264))
      {
        localIconPreference.aad(0);
        localIconPreference.aab(8);
        localIconPreference.fZ("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      if (com.tencent.mm.y.c.aeH().a(ah.a.GQM, 266242))
      {
        localIconPreference.aad(0);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.aad(8);
      az.ayM();
      if ((com.tencent.mm.model.c.agA().getInt(40, 0) & 0x20000) != 0) {
        break label580;
      }
    }
    label580:
    for (int i = 1;; i = 0)
    {
      if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("VoiceprintEntry"), 0) == 1) {
        az.ayM();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GEz, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ac.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.aad(0);
          AppMethodBeat.o(33566);
          return;
        }
        localIconPreference.aad(8);
        com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(com.tencent.mm.plugin.newtips.a.d.vmQ);
        if ((locala != null) && (!locala.field_isExit))
        {
          com.tencent.mm.plugin.newtips.a.dkb().vnq = new i.a()
          {
            public final void e(com.tencent.mm.plugin.newtips.b.a paramAnonymousa)
            {
              AppMethodBeat.i(33546);
              if ((paramAnonymousa != null) && (paramAnonymousa.field_tipId == com.tencent.mm.plugin.newtips.a.d.vmQ))
              {
                com.tencent.mm.plugin.newtips.a.dke();
                if (com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmQ))
                {
                  localIconPreference.aad(0);
                  localIconPreference.aab(8);
                  localIconPreference.fZ("", -1);
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
        com.tencent.mm.plugin.newtips.a.dke();
        if (com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmQ))
        {
          localIconPreference.aad(0);
          localIconPreference.aab(8);
          localIconPreference.fZ("", -1);
          AppMethodBeat.o(33566);
          return;
        }
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void fhf()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.br.d.aCT("emoji"))
    {
      com.tencent.mm.br.d.eQD();
      this.screen.cK("settings_emoji_store", false);
      bool1 = com.tencent.mm.y.c.aeH().cG(262147, 266244);
      bool2 = com.tencent.mm.y.c.aeH().cG(262149, 266244);
      localIconPreference = (IconPreference)this.screen.aPN("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.cK("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.aab(0);
      localIconPreference.fZ(getString(2131755829), 2131233430);
    }
    while ((bool2) || (bool1))
    {
      az.ayM();
      String str = (String)com.tencent.mm.model.c.agA().get(229633, null);
      com.tencent.mm.av.o.aFB().a(str, localIconPreference.fjm(), new com.tencent.mm.av.a.c.h()
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
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.16.this.Hqs.aF(this.iBJ);
                MoreTabUI.16.this.Hqs.aaf(0);
                AppMethodBeat.o(33549);
              }
            });
            AppMethodBeat.o(33551);
            return;
          }
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33550);
              MoreTabUI.16.this.Hqs.aaf(8);
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
        localIconPreference.aab(0);
        localIconPreference.fZ(getString(2131755781), 2131233430);
      }
      else
      {
        localIconPreference.aab(8);
        localIconPreference.fZ("", -1);
      }
    }
    localIconPreference.aaf(8);
    AppMethodBeat.o(33567);
  }
  
  private void fhg()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = com.tencent.mm.model.u.axG();
    ac.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.cK("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (bs.jl(i, -1)) {
        break label156;
      }
      if ((i & 0x8000) == 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label156;
      }
      if (!bool2) {
        break label144;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label144:
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(1056L, 0L, 1L, false);
    label156:
    AppMethodBeat.o(33568);
  }
  
  private void fhh()
  {
    AppMethodBeat.i(33569);
    az.ayM();
    int i = com.tencent.mm.platformtools.ae.h((Integer)com.tencent.mm.model.c.agA().get(204820, null));
    az.ayM();
    int j = i + com.tencent.mm.platformtools.ae.h((Integer)com.tencent.mm.model.c.agA().get(204817, null));
    boolean bool3 = com.tencent.mm.y.c.aeH().cG(262156, 266248);
    boolean bool4 = com.tencent.mm.y.c.aeH().cH(262156, 266248);
    boolean bool5 = com.tencent.mm.y.c.aeH().b(ah.a.GOh, ah.a.GOj);
    az.ayM();
    String str2 = (String)com.tencent.mm.model.c.agA().get(ah.a.GOk, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.aPN("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    ac.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    ac.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.dkb().h(localNormalIconNewTipPreference);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    az.ayM();
    String str3 = (String)com.tencent.mm.model.c.agA().get(ah.a.GNI, "");
    az.ayM();
    int k = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GNJ, Integer.valueOf(-1))).intValue();
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
      az.ayM();
      l1 = ((Long)com.tencent.mm.model.c.agA().get(ah.a.GNG, Long.valueOf(-1L))).longValue();
      long l2 = com.tencent.mm.platformtools.ae.tx(com.tencent.mm.m.g.ZY().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      ac.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
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
            com.tencent.mm.y.c.aeH().w(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.agS();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPI, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.agS();
    long l1 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPJ, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      ac.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPI, Boolean.FALSE);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPJ, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.agS();
      Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPF, "");
      ac.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.y.c.aeH().b(ah.a.GPM, ah.a.GPT);
      com.tencent.mm.kernel.g.agS();
      l1 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPO, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        ac.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.y.c.aeH().c(ah.a.GPM, ah.a.GPT);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPO, Long.valueOf(0L));
      }
      for (;;)
      {
        bool3 |= bool2;
        com.tencent.mm.kernel.g.agS();
        String str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPL, "");
        ac.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), str1 });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
        if (bool3)
        {
          i = 1;
          localh.f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
          ac.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
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
          if (!bs.isNullOrNil(str2))
          {
            localNormalIconNewTipPreference.aac(0);
            localNormalIconNewTipPreference.aQ(str2, -1, -7566196);
            localNormalIconNewTipPreference.wU(true);
            localNormalIconNewTipPreference.aad(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnv, true);
            if (bs.isNullOrNil(str1)) {
              break label1380;
            }
            localObject = str1;
          }
        }
        label1380:
        for (;;)
        {
          if ((!com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject)) && (bool3))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject);
            AppMethodBeat.o(33569);
            return;
            localNormalIconNewTipPreference.ga("", -1);
            localNormalIconNewTipPreference.aac(8);
            localNormalIconNewTipPreference.aad(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnt, true);
            break;
            if (bool1)
            {
              localNormalIconNewTipPreference.aab(0);
              localNormalIconNewTipPreference.fZ(getString(2131755829), 2131233430);
              localNormalIconNewTipPreference.aad(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnu, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.aab(0);
              localNormalIconNewTipPreference.fZ(getString(2131764343), com.tencent.mm.ui.tools.u.ks(getContext()));
              localNormalIconNewTipPreference.aad(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vny, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.aab(0);
              localNormalIconNewTipPreference.fZ(String.valueOf(j), com.tencent.mm.ui.tools.u.aM(getContext(), j));
              localNormalIconNewTipPreference.aad(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vny, true);
              break;
            }
            if (bool3)
            {
              localNormalIconNewTipPreference.fZ("", -1);
              localNormalIconNewTipPreference.aab(8);
              localNormalIconNewTipPreference.aad(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnt, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.fZ("", -1);
              localNormalIconNewTipPreference.aab(8);
              localNormalIconNewTipPreference.aac(0);
              localNormalIconNewTipPreference.wU(true);
              if (!com.tencent.mm.platformtools.ae.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.aQ(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.aag(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.vnv, true);
              break;
            }
            localNormalIconNewTipPreference.fZ("", -1);
            localNormalIconNewTipPreference.aab(8);
            localNormalIconNewTipPreference.aad(8);
            localNormalIconNewTipPreference.aac(8);
            localNormalIconNewTipPreference.ga("", -1);
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
  
  private boolean fhi()
  {
    AppMethodBeat.i(33571);
    com.tencent.mm.plugin.flutter.a.c localc = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new HashMap());
    ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), localc);
    AppMethodBeat.o(33571);
    return true;
  }
  
  private void fhj()
  {
    AppMethodBeat.i(33575);
    this.vJa = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.zqc, null);
    if (this.vJa != null)
    {
      this.vJa.dUv();
      this.Hqb = (-(ap.cl(getContext()).y / 10));
      if (!this.Hqc) {
        break label240;
      }
    }
    label240:
    for (int i = com.tencent.mm.cc.a.av(getContext(), 2131166722);; i = com.tencent.mm.cc.a.av(getContext(), 2131166721))
    {
      this.Hqa = i;
      this.HpZ = (-com.tencent.mm.cc.a.fromDPToPix(getContext(), 330));
      this.HpY = 0;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ap.cl(getContext()).y);
      localLayoutParams.topMargin = this.Hqb;
      localLayoutParams.bottomMargin = (-ap.ej(getContext()));
      this.HpS.addView(this.vJa, 0, localLayoutParams);
      this.HpR.A(this.vJa, this.Hqa, this.Hqb);
      this.HpR.setNavigationBarHeight(ap.ej(getActivity()));
      this.vJa.setDataSeed(com.tencent.mm.model.u.axw());
      this.vJa.a(this.HpR);
      this.vJa.setStoryBrowseUIListener(this);
      this.HpU.fhk();
      AppMethodBeat.o(33575);
      return;
    }
  }
  
  private boolean wC(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.t.c.lQe.a(com.tencent.mm.plugin.appbrand.t.c.a.lQi);
    com.tencent.mm.plugin.appbrand.t.c.lQe.a(com.tencent.mm.plugin.appbrand.t.c.a.lQu);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.br.d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void wD(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.vJi == null)
      {
        View localView = findViewById(2131296345);
        if (localView != null) {
          this.vJi = localView.findViewById(2131296343);
        }
        if (this.vJi == null) {
          break label103;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.vJi == null) {
          break label116;
        }
        if (!paramBoolean) {
          break;
        }
        this.vJi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33537);
            ac.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.j(MoreTabUI.this))
            {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
              AppMethodBeat.o(33537);
              return;
            }
            if ((MoreTabUI.k(MoreTabUI.this) != null) && (MoreTabUI.k(MoreTabUI.this).isVisible)) {
              MoreTabUI.k(MoreTabUI.this).fvR();
            }
            AppMethodBeat.o(33537);
          }
        });
        AppMethodBeat.o(33587);
        return;
        label103:
        bool = false;
      }
      this.vJi.setOnClickListener(null);
    }
    label116:
    AppMethodBeat.o(33587);
  }
  
  private void wE(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.HpR != null) && (this.HpR.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().ww(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(33570);
    int i = com.tencent.mm.platformtools.ae.ca(paramObject);
    ac.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.ayM();
    if ((paramn != com.tencent.mm.model.c.agA()) || (i <= 0))
    {
      ac.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      fhh();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      fhg();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      fhf();
    }
    AppMethodBeat.o(33570);
  }
  
  public final void dpQ()
  {
    AppMethodBeat.i(33584);
    ac.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.HpR != null) && (!this.HpR.isVisible)) {
      this.HpR.fvQ();
    }
    if ((!com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) || (this.qCD)) {
      this.HpU.ZI(2);
    }
    for (;;)
    {
      if (this.HpW != null) {
        this.HpW.ePB();
      }
      AppMethodBeat.o(33584);
      return;
      this.HpU.ZI(1);
    }
  }
  
  public final void dpR()
  {
    AppMethodBeat.i(33585);
    ac.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.HpR != null) && (this.HpR.isVisible) && (this.Hqd))
    {
      if (!this.qCD) {
        break label106;
      }
      this.HpU.ZI(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.aPN("settings_my_album");
      if (localIconPreference == null) {
        break label128;
      }
      if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GTh, true)) {
        break;
      }
      this.Hqe = true;
      localIconPreference.aad(0);
      AppMethodBeat.o(33585);
      return;
      label106:
      this.HpU.ZI(0);
    }
    this.Hqe = false;
    localIconPreference.aad(8);
    label128:
    AppMethodBeat.o(33585);
  }
  
  public final void dpS()
  {
    AppMethodBeat.i(33586);
    ac.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.HpR != null) && (!this.HpR.isVisible)) {
      this.HpR.fvQ();
    }
    ZH(0);
    wE(this.vLB);
    AppMethodBeat.o(33586);
  }
  
  final void dpU()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  protected final void feA()
  {
    AppMethodBeat.i(33578);
    if (this.vJa != null) {
      this.vJa.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void feB()
  {
    AppMethodBeat.i(33579);
    ac.d("MicroMsg.MoreTabUI", "onTabPause");
    com.tencent.mm.y.c.aeH().b(this.xuR);
    az.ayM();
    com.tencent.mm.model.c.agA().b(this);
    if (this.vJa != null) {
      this.vJa.onPause();
    }
    if (this.HpR != null)
    {
      if ((this.HpR.isVisible) || (this.vLB)) {
        break label118;
      }
      this.HpR.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33536);
          MoreTabUI.k(MoreTabUI.this).fvQ();
          AppMethodBeat.o(33536);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.HpW != null) {
        this.HpW.ePB();
      }
      wD(false);
      AppMethodBeat.o(33579);
      return;
      label118:
      if ((this.HpR.isVisible) && (this.HpR.getTranslationY() != 0.0F)) {
        this.HpR.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void feC()
  {
    AppMethodBeat.i(33580);
    if (this.vJa != null) {
      this.vJa.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void feD()
  {
    AppMethodBeat.i(33581);
    if (this.vJa != null) {
      this.vJa.onDestroy();
    }
    if (this.HpW != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.HpW;
      if (localAccountInfoPreference.pDN) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fm(localAccountInfoPreference.DAn);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void feF() {}
  
  public final void feG() {}
  
  public final void feI() {}
  
  protected final void fey()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.qCD = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Hqf = bool1;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.cd(getContext());
      com.tencent.mm.kernel.g.agS();
      this.vJb = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().go(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cc.a.av(getContext(), 2131166720), com.tencent.mm.cc.a.av(getContext(), 2131166720));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131303135).getParent()).addView(this.vJb, 0, (ViewGroup.LayoutParams)localObject);
      this.HpR.Jim = this.mPullDownCallback;
      this.HpR.setPadding(this.HpR.getPaddingLeft(), this.HpR.getPaddingTop(), this.HpR.getPaddingRight(), this.HpT.getHeight());
      if (this.HpS != null)
      {
        ac.d("MicroMsg.MoreTabUI", "dancy test add view !");
        fhj();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void fez()
  {
    AppMethodBeat.i(33577);
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    az.ayM();
    com.tencent.mm.model.c.agA().a(this);
    com.tencent.mm.y.c.aeH().a(this.xuR);
    this.screen.cK("more_tab_setting_personal_info", false);
    this.HpW = ((AccountInfoPreference)this.adapter.aPN("more_tab_setting_personal_info"));
    Object localObject = com.tencent.mm.model.u.axx();
    if (com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.mm.model.u.axw();
      if (ai.aNf((String)localObject))
      {
        this.HpW.DAh = null;
        this.HpW.userName = com.tencent.mm.model.u.axw();
        String str = com.tencent.mm.model.u.axy();
        localObject = str;
        if (com.tencent.mm.platformtools.ae.isNullOrNil(str)) {
          localObject = com.tencent.mm.model.u.axz();
        }
        this.HpW.DAg = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)localObject);
        this.HpW.aH(this.vLB, this.Hqc);
        this.HpW.DAu = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33547);
            if (MoreTabUI.j(MoreTabUI.this))
            {
              t.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131764289), 0).show();
              AppMethodBeat.o(33547);
              return;
            }
            if (MoreTabUI.k(MoreTabUI.this) != null) {
              MoreTabUI.k(MoreTabUI.this).fvR();
            }
            AppMethodBeat.o(33547);
          }
        };
        ((AccountInfoPreference)this.screen.aPN("more_tab_setting_personal_info")).DAt = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33548);
            com.tencent.mm.plugin.report.service.h.wUl.f(11264, new Object[] { Integer.valueOf(1) });
            paramAnonymousView = MoreTabUI.this;
            Object localObject = new Intent(MoreTabUI.this.getContext(), SelfQRCodeUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33548);
          }
        };
        localObject = (IconPreference)this.screen.aPN("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.bj.d.aJe().fbh();
          if (i <= 0) {
            break label687;
          }
          ((IconPreference)localObject).aab(0);
          ((IconPreference)localObject).fZ(String.valueOf(i), 2131233430);
        }
        label261:
        fhc();
        fhf();
        fhe();
        if (com.tencent.mm.br.d.aCT("favorite")) {
          break label706;
        }
        this.screen.cK("settings_mm_favorite", true);
        label296:
        fhh();
        fhg();
        fhd();
        if (!com.tencent.mm.kernel.g.agN().aa(com.tencent.mm.plugin.y.a.a.class)) {
          break label723;
        }
        this.screen.cK("more_uishow", false);
        label334:
        localObject = this.screen.aPN("settings_privacy_agreements");
        if (!com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null))) {
          break label740;
        }
        str = getString(2131762010);
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
        localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131100547)), localSpannable.length() - str.length(), localSpannable.length(), 33);
        ((Preference)localObject).setTitle(localSpannable);
        this.screen.cK("settings_privacy_agreements", false);
        label456:
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        localObject = findViewById(2131301512);
        if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
          new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33535);
              this.Hjf.setVisibility(8);
              this.Hjf.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), 2130772048));
              AppMethodBeat.o(33535);
            }
          });
        }
        if ((this.HpR != null) && (this.HpR.isVisible))
        {
          ZH(0);
          ac.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.vJa != null)
        {
          this.vJa.onResume();
          this.vJa.dUu();
        }
        if (this.HpW != null)
        {
          localObject = this.HpW;
          if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.y.c.aeH().cG(352279, 266241))) {
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
      ((AccountInfoPreference)localObject).DAr = bool;
      this.HpW.ePC();
      ac.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      this.HpW.DAh = ((String)localObject);
      break;
      this.HpW.DAh = ((String)localObject);
      break;
      ((IconPreference)localObject).aab(8);
      ((IconPreference)localObject).fZ("", -1);
      break label261;
      this.screen.cK("settings_mm_favorite", false);
      break label296;
      this.screen.cK("more_uishow", true);
      break label334;
      this.screen.cK("settings_privacy_agreements", true);
      break label456;
    }
  }
  
  public final void ffG()
  {
    AppMethodBeat.i(33582);
    ac.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.Hqd = true;
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.qCD = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label240;
        }
        bool = true;
        label74:
        this.Hqf = bool;
      }
    }
    else if (this.HpR != null)
    {
      localObject = this.HpR;
      an.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).Jii = true;
      if ((!this.HpR.isVisible) || (this.HpR.getTranslationY() == 0.0F)) {
        break label245;
      }
      this.HpR.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.vJa != null) {
        this.vJa.dUu();
      }
      wD(true);
      long l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.yu(l);
      localObject = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYd().dVg = l;
      localObject = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYd().dWt = System.currentTimeMillis();
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
      if (!this.HpR.isVisible) {
        this.HpR.fvQ();
      }
    }
  }
  
  public final void ffH()
  {
    AppMethodBeat.i(33583);
    this.Hqd = false;
    if (this.HpR != null)
    {
      localObject = this.HpR;
      an.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).Jii = false;
      if (!this.HpR.isVisible) {
        this.HpR.fvQ();
      }
    }
    if (this.vJb != null) {
      this.vJb.setVisibility(8);
    }
    Object localObject = new vh();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    wD(false);
    localObject = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYe();
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
    ac.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = this.adapter;
    this.screen.cK("more_setting", true);
    this.screen.cK("settings_emoji_store", true);
    this.screen.cK("settings_mm_wallet", true);
    this.screen.cK("settings_mm_cardpackage", true);
    this.screen.cK("settings_mm_favorite", true);
    this.screen.cK("settings_my_album", true);
    this.screen.cK("settings_my_address", true);
    this.screen.cK("more_tab_setting_personal_info", true);
    this.screen.cK("more_uishow", true);
    this.screen.cK("settings_privacy_agreements", true);
    this.HpT = getView().getRootView().findViewById(2131301338);
    this.HpS = ((RelativeLayout)findViewById(2131303379));
    this.HpR = ((PullDownListView)this.list);
    this.HpR.setTabView(this.HpT);
    this.HpR.setBackground(ao.aI(getContext(), 2130969307));
    this.HpR.setOnScrollListener(new AbsListView.OnScrollListener()
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
    ac.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
    if (paramConfiguration.orientation == 1)
    {
      this.qCD = false;
      if (this.HpR != null) {
        this.HpU.fhk();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label214;
      }
    }
    for (;;)
    {
      if (bool != this.Hqf)
      {
        this.Hqf = bool;
        if ((this.vJa != null) && (this.HpS != null) && (this.HpR != null))
        {
          this.vJa.onDestroy();
          this.HpS.removeView(this.vJa);
          fhj();
          this.vJa.onResume();
          if (!this.HpR.isVisible)
          {
            this.HpR.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33538);
                MoreTabUI.k(MoreTabUI.this).fvQ();
                AppMethodBeat.o(33538);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.qCD = true;
            if (this.HpR == null) {
              break;
            }
            if (!this.HpR.isVisible) {
              this.HpR.fvQ();
            }
            this.HpU.ZI(2);
            break;
            label214:
            bool = false;
            continue;
          }
          if ((this.HpR.isVisible) && (this.HpR.getTranslationY() != 0.0F)) {
            this.HpR.setTranslationY(0.0F);
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
    if ((!az.agM()) || (az.afS()))
    {
      ac.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(az.agM()), Boolean.valueOf(az.afS()) });
      AppMethodBeat.o(33556);
      return;
    }
    fhb();
    wD(false);
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
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.vJa != null)) {}
    for (boolean bool = this.vJa.onBackPressed();; bool = false)
    {
      ac.d("MicroMsg.MoreTabUI", "onBackPressed: %b", new Object[] { Boolean.valueOf(bool) });
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
    ac.i("MicroMsg.MoreTabUI", "onPause: ");
    if (this.Hqd)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYe();
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
      ac.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.agM()) {
        break;
      }
      ac.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.br.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      AppMethodBeat.o(33563);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      com.tencent.mm.plugin.newtips.a.dkb().Ko(13);
      bool1 = com.tencent.mm.y.c.aeH().cG(262156, 266248);
      boolean bool2 = com.tencent.mm.y.c.aeH().cH(262156, 266248);
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.h.wUl;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.f(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.h.wUl.f(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new qv();
        paramPreference.dtQ.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.dtQ.intent = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.GpY.l(paramPreference);
        com.tencent.mm.y.c.aeH().cI(262156, 266248);
        com.tencent.mm.y.c.aeH().c(ah.a.GOh, ah.a.GOj);
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GNI, "");
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GNJ, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPI, Boolean.FALSE);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPF, "");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPG, Boolean.FALSE);
        com.tencent.mm.y.c.aeH().c(ah.a.GPM, ah.a.GPT);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPL, "");
        paramf = com.tencent.mm.plugin.report.service.h.wUl;
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
      com.tencent.mm.plugin.newtips.a.dkb().Ko(14);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GFd, "");
      new Intent().putExtra("key_from_scene", 22);
      ac.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new jn();
      paramf.dlb.context = getContext();
      paramf.dlb.enterScene = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramf);
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(getContext(), null);
        AppMethodBeat.o(33563);
        return true;
      }
      az.ayM();
      paramf = (String)com.tencent.mm.model.c.agA().get(2, null);
      paramPreference = new Intent(getContext(), AlbumUI.class);
      paramPreference.putExtra("sns_userName", paramf);
      paramPreference.putExtra("username", paramf);
      paramPreference.putExtra("story_dot", this.Hqe);
      paramPreference.setFlags(536870912);
      paramPreference.addFlags(67108864);
      az.ayM();
      i = com.tencent.mm.platformtools.ae.h((Integer)com.tencent.mm.model.c.agA().get(68389, null));
      az.ayM();
      com.tencent.mm.model.c.agA().set(68389, Integer.valueOf(i + 1));
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.h.wUl.f(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cq.d.fBf();
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10958, "7");
      if (((com.tencent.mm.plugin.flutter.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
      {
        bool1 = fhi();
        AppMethodBeat.o(33563);
        return bool1;
      }
      com.tencent.mm.y.c.aeH().cI(262147, 266244);
      com.tencent.mm.y.c.aeH().cI(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.h.wUl.f(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).eJ(com.tencent.mm.plugin.boots.a.b.nsP, 881);
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.y.c.aeH().cG(262145, 266242);
      com.tencent.mm.y.c.aeH().cI(262145, 266242);
      com.tencent.mm.y.c.aeH().cI(262157, 266261);
      com.tencent.mm.y.c.aeH().cI(262158, 266264);
      com.tencent.mm.y.c.aeH().b(ah.a.GQM, 266242);
      paramPreference = new Intent();
      com.tencent.mm.br.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      az.ayM();
      i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GLV, Integer.valueOf(0))).intValue();
      az.ayM();
      int j = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GLW, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GLW, Integer.valueOf(i));
        paramf = (IconPreference)paramf.aPN("more_setting");
        if (paramf != null) {
          paramf.aad(8);
        }
        com.tencent.mm.y.c.aeH().cI(266260, 266241);
      }
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.ISu = new n.c()
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
      paramf.ISv = new n.d()
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
      paramf.cED();
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131760685, new Object[] { ab.eUO(), com.tencent.mm.kernel.g.agR().agA().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
      AppMethodBeat.o(33563);
      return true;
    }
    AppMethodBeat.o(33563);
    return false;
  }
  
  public final boolean onPreferenceTreeLongClick(f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33562);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33562);
      return true;
    }
    boolean bool;
    try
    {
      if ((bt.eUi()) || (bt.eWm()) || (bt.eWo()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
      {
        if (bs.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = wC(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (bs.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = wC(false);
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
    ac.i("MicroMsg.MoreTabUI", "onResume: ");
    fhb();
    if (this.Hqd)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.yu(l);
      localh = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYd().dVg = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
    implements com.tencent.mm.ak.g
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn) {}
  }
  
  final class b
  {
    private int status = 2;
    
    private b() {}
    
    public final void ZI(int paramInt)
    {
      AppMethodBeat.i(33554);
      ac.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0) {
        MoreTabUI.d(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        dpW();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    public final void dpW()
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
          MoreTabUI.k(MoreTabUI.this).setBackground(ao.aI(MoreTabUI.this.getContext(), 2130969308));
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
          MoreTabUI.o(MoreTabUI.this).aH(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(ao.aI(MoreTabUI.this.getContext(), 2130969307));
        }
        MoreTabUI.k(MoreTabUI.this).setBackground(ao.aI(MoreTabUI.this.getContext(), 2130969307));
        MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
        MoreTabUI.z(MoreTabUI.this);
        MoreTabUI.b(MoreTabUI.this, com.tencent.mm.cc.a.av(MoreTabUI.this.getContext(), 2131166721));
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
          MoreTabUI.o(MoreTabUI.this).aH(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.k(MoreTabUI.this).setBackground(ao.aI(MoreTabUI.this.getContext(), 2130969308));
          MoreTabUI.k(MoreTabUI.this).setSupportOverscroll(MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.p(MoreTabUI.this));
          MoreTabUI.m(MoreTabUI.this);
          if (MoreTabUI.o(MoreTabUI.this) != null) {
            MoreTabUI.o(MoreTabUI.this).aH(MoreTabUI.p(MoreTabUI.this), MoreTabUI.q(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void fhk()
    {
      AppMethodBeat.i(33553);
      if ((!com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) || (MoreTabUI.j(MoreTabUI.this)))
      {
        MoreTabUI.d(MoreTabUI.this, false);
        this.status = 2;
      }
      for (;;)
      {
        ac.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
        dpW();
        AppMethodBeat.o(33553);
        return;
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(com.tencent.mm.model.u.axw()))
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