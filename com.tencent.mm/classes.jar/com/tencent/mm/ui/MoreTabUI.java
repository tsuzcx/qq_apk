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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.x.a.a;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, n.b
{
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean mnn;
  private boolean pBa;
  private RelativeLayout pmj;
  private View pyF;
  private AbsStoryGallery pyx;
  private AbsStoryMuteView pyy;
  private byte[] qFE;
  private a.a qKG;
  private Bitmap sZL;
  private com.tencent.mm.ui.base.preference.f screen;
  private ImageView zcY;
  PullDownListView zcZ;
  private View zda;
  private MoreTabUI.b zdb;
  private boolean zdc;
  private AccountInfoPreference zdd;
  private boolean zde;
  private RelativeLayout zdf;
  private FrameLayout zdg;
  private int zdh;
  private int zdi;
  private int zdj;
  private int zdk;
  private boolean zdl;
  private boolean zdm;
  private boolean zdn;
  public boolean zdo;
  private boolean zdp;
  public boolean zdq;
  private int zdr;
  private int zds;
  private a zdt;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(29717);
    this.sZL = null;
    this.qFE = null;
    this.pyy = null;
    this.pmj = null;
    this.zda = null;
    this.pyx = null;
    this.zdb = new MoreTabUI.b(this, (byte)0);
    this.pBa = false;
    this.zdc = false;
    this.zdd = null;
    this.zde = false;
    this.zdf = null;
    this.zdg = null;
    this.zdh = 0;
    this.zdi = 0;
    this.zdj = 0;
    this.zdk = 0;
    this.mnn = false;
    this.zdl = false;
    this.zdm = false;
    this.zdn = false;
    this.qKG = new MoreTabUI.1(this);
    this.zdo = true;
    this.zdp = true;
    this.zdq = true;
    this.zdr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    this.zds = com.tencent.mm.cb.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new MoreTabUI.10(this);
    this.zdt = new a();
    AppMethodBeat.o(29717);
  }
  
  private void Oq(int paramInt)
  {
    AppMethodBeat.i(29736);
    View localView = findViewById(2131820956);
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      ab.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(29736);
      return;
    }
    ab.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
    AppMethodBeat.o(29736);
  }
  
  private void dCO()
  {
    AppMethodBeat.i(29721);
    if (!this.zdl)
    {
      i = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLI, 0);
      boolean bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yLw, false);
      ab.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.pBa) && ((bool) || (i > 0)))
      {
        this.zdl = true;
        if (this.zdd != null) {
          this.zdd.ae(this.pBa, this.zdl);
        }
        if (!this.zdl) {
          break label132;
        }
      }
    }
    label132:
    for (int i = com.tencent.mm.cb.a.ap(getContext(), 2131428635);; i = com.tencent.mm.cb.a.ap(getContext(), 2131428634))
    {
      this.zdj = i;
      AppMethodBeat.o(29721);
      return;
    }
  }
  
  private void dCP()
  {
    AppMethodBeat.i(29726);
    if (!com.tencent.mm.bq.d.ahR("sns"))
    {
      this.screen.cl("settings_my_album", true);
      AppMethodBeat.o(29726);
      return;
    }
    this.screen.cl("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yLO, true)) && (this.zdn))
      {
        localIconPreference.ON(0);
        AppMethodBeat.o(29726);
        return;
      }
      this.zdn = false;
      localIconPreference.ON(8);
    }
    AppMethodBeat.o(29726);
  }
  
  private void dCQ()
  {
    AppMethodBeat.i(29727);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).bcu()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).bcv())) || (!com.tencent.mm.bq.d.ahR("card")))
    {
      this.screen.cl("settings_mm_cardpackage", true);
      AppMethodBeat.o(29727);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).bcw();; localObject1 = "")
    {
      boolean bool1 = com.tencent.mm.x.c.PJ().cd(262152, 266256);
      boolean bool2 = com.tencent.mm.x.c.PJ().cc(262152, 266256);
      boolean bool3 = com.tencent.mm.x.c.PJ().a(ac.a.yyN, ac.a.yyP);
      boolean bool4 = com.tencent.mm.x.c.PJ().a(ac.a.yyO, ac.a.yyQ);
      this.screen.cl("settings_mm_cardpackage", false);
      IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_mm_cardpackage");
      if (localIconPreference == null)
      {
        AppMethodBeat.o(29727);
        return;
      }
      localIconPreference.setTitle(2131303305);
      if (bool2)
      {
        localIconPreference.OL(0);
        localIconPreference.eN(getString(2131297012), 2130839787);
        localIconPreference.ON(8);
        localIconPreference.setSummary(null);
        localIconPreference.ap(null);
        localIconPreference.OP(8);
        localIconPreference.eO("", -1);
        localIconPreference.OM(8);
        AppMethodBeat.o(29727);
        return;
      }
      com.tencent.mm.model.aw.aaz();
      String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yyW, "");
      if ((bool4) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131428166);
        Object localObject2 = new com.tencent.mm.at.a.a.c.a();
        ((com.tencent.mm.at.a.a.c.a)localObject2).eNP = com.tencent.mm.compatible.util.e.eQz;
        o.ahH();
        ((com.tencent.mm.at.a.a.c.a)localObject2).eOd = null;
        ((com.tencent.mm.at.a.a.c.a)localObject2).eNM = true;
        ((com.tencent.mm.at.a.a.c.a)localObject2).eOk = true;
        ((com.tencent.mm.at.a.a.c.a)localObject2).eNK = true;
        ((com.tencent.mm.at.a.a.c.a)localObject2).eNT = i;
        ((com.tencent.mm.at.a.a.c.a)localObject2).eNS = i;
        localObject2 = ((com.tencent.mm.at.a.a.c.a)localObject2).ahY();
        o.ahG().a(str, localIconPreference.dEK(), (com.tencent.mm.at.a.a.c)localObject2, new MoreTabUI.5(this, localIconPreference));
        if (!bool1) {
          break label514;
        }
        localIconPreference.ON(0);
        label407:
        if (!bool3) {
          break label586;
        }
        localIconPreference.eN("", -1);
        localIconPreference.OL(8);
        if (!bool4) {
          break label543;
        }
        localIconPreference.setSummary(null);
        if (ah.isNullOrNil((String)localObject1)) {
          break label524;
        }
        localIconPreference.aG((String)localObject1, -1, getResources().getColor(2131690168));
        localIconPreference.OM(0);
      }
      for (;;)
      {
        h.qsU.e(16322, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(29727);
        return;
        localIconPreference.ap(null);
        localIconPreference.OP(8);
        break;
        label514:
        localIconPreference.ON(8);
        break label407;
        label524:
        localIconPreference.eO("", -1);
        localIconPreference.OM(8);
        continue;
        label543:
        localIconPreference.eO("", -1);
        localIconPreference.OM(8);
        if (!ah.isNullOrNil((String)localObject1))
        {
          localIconPreference.setSummary((CharSequence)localObject1);
        }
        else
        {
          localIconPreference.setSummary(null);
          continue;
          label586:
          localIconPreference.OM(8);
          localIconPreference.OL(8);
          localIconPreference.setSummary(null);
        }
      }
    }
  }
  
  private void dCR()
  {
    AppMethodBeat.i(29728);
    this.screen.cl("more_setting", false);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.OQ(8);
      bool = com.tencent.mm.x.c.PJ().cc(262145, 266242);
      if (bool)
      {
        localIconPreference.OL(0);
        localIconPreference.eN(getString(2131297012), 2130839787);
        com.tencent.mm.model.aw.aaz();
        if (((Integer)com.tencent.mm.model.c.Ru().get(9, Integer.valueOf(0))).intValue() != 0)
        {
          if (r.Zv()) {
            break label162;
          }
          localIconPreference.setSummary(2131302835);
        }
      }
      for (;;)
      {
        localIconPreference.ON(8);
        if (!bool) {
          break label173;
        }
        AppMethodBeat.o(29728);
        return;
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
        break;
        label162:
        localIconPreference.setSummary("");
      }
      label173:
      com.tencent.mm.model.aw.aaz();
      i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yFx, Integer.valueOf(0))).intValue();
      com.tencent.mm.model.aw.aaz();
      int j = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yFy, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.c.class)).dho()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.c.class)).dhp()) || (i > j)) && (!bool))
      {
        localIconPreference.ON(0);
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
        AppMethodBeat.o(29728);
        return;
      }
      localIconPreference.ON(8);
      if (com.tencent.mm.x.c.PJ().cd(262157, 266261))
      {
        localIconPreference.ON(0);
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
        AppMethodBeat.o(29728);
        return;
      }
      localIconPreference.ON(8);
      if (com.tencent.mm.x.c.PJ().cd(262158, 266264))
      {
        localIconPreference.ON(0);
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
        AppMethodBeat.o(29728);
        return;
      }
      if (com.tencent.mm.x.c.PJ().a(ac.a.yJH, 266242))
      {
        localIconPreference.ON(0);
        AppMethodBeat.o(29728);
        return;
      }
      localIconPreference.ON(8);
      com.tencent.mm.model.aw.aaz();
      if ((com.tencent.mm.model.c.Ru().getInt(40, 0) & 0x20000) != 0) {
        break label629;
      }
    }
    label629:
    for (int i = 1;; i = 0)
    {
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1) {
        com.tencent.mm.model.aw.aaz();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yyq, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ab.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.ON(0);
          AppMethodBeat.o(29728);
          return;
        }
        localIconPreference.ON(8);
        bm localbm = com.tencent.mm.plugin.r.a.bWT().Ny(com.tencent.mm.ax.b.fKS);
        if ((localbm != null) && (!localbm.field_isExit))
        {
          com.tencent.mm.plugin.r.a.bWS().fLi = new MoreTabUI.6(this, localIconPreference);
          AppMethodBeat.o(29728);
          return;
        }
        com.tencent.mm.plugin.r.a.bWU();
        if (com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKS))
        {
          localIconPreference.ON(0);
          localIconPreference.OL(8);
          localIconPreference.eN("", -1);
          AppMethodBeat.o(29728);
          return;
        }
        AppMethodBeat.o(29728);
        return;
      }
    }
  }
  
  private void dCS()
  {
    AppMethodBeat.i(29729);
    boolean bool1;
    boolean bool2;
    IconPreference localIconPreference;
    if (com.tencent.mm.bq.d.ahR("emoji"))
    {
      com.tencent.mm.bq.d.dpU();
      this.screen.cl("settings_emoji_store", false);
      bool1 = com.tencent.mm.x.c.PJ().cc(262147, 266244);
      bool2 = com.tencent.mm.x.c.PJ().cc(262149, 266244);
      localIconPreference = (IconPreference)this.screen.atx("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(29729);
      }
    }
    else
    {
      this.screen.cl("settings_emoji_store", false);
      AppMethodBeat.o(29729);
      return;
    }
    if (bool1)
    {
      localIconPreference.OL(0);
      localIconPreference.eN(getString(2131297012), 2130839787);
    }
    while ((bool2) || (bool1))
    {
      com.tencent.mm.model.aw.aaz();
      String str = (String)com.tencent.mm.model.c.Ru().get(229633, null);
      o.ahG().a(str, localIconPreference.dEK(), new MoreTabUI.9(this, localIconPreference));
      AppMethodBeat.o(29729);
      return;
      if (bool2)
      {
        localIconPreference.OL(0);
        localIconPreference.eN(getString(2131296966), 2130839787);
      }
      else
      {
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
      }
    }
    localIconPreference.OP(8);
    AppMethodBeat.o(29729);
  }
  
  private void dCT()
  {
    AppMethodBeat.i(29730);
    boolean bool2 = r.Zw();
    ab.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.cl("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (bo.hl(i, -1)) {
        break label155;
      }
      if ((i & 0x8000) == 0) {
        break label138;
      }
    }
    label138:
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label155;
      }
      if (!bool2) {
        break label143;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(29730);
      return;
      bool1 = false;
      break;
    }
    label143:
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(1056L, 0L, 1L, false);
    label155:
    AppMethodBeat.o(29730);
  }
  
  private void dCU()
  {
    AppMethodBeat.i(29731);
    com.tencent.mm.model.aw.aaz();
    int i = ah.h((Integer)com.tencent.mm.model.c.Ru().get(204820, null));
    com.tencent.mm.model.aw.aaz();
    i += ah.h((Integer)com.tencent.mm.model.c.Ru().get(204817, null));
    boolean bool3 = com.tencent.mm.x.c.PJ().cc(262156, 266248);
    boolean bool4 = com.tencent.mm.x.c.PJ().cd(262156, 266248);
    boolean bool5 = com.tencent.mm.x.c.PJ().b(ac.a.yHy, ac.a.yHA);
    com.tencent.mm.model.aw.aaz();
    String str2 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yHB, "");
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_mm_wallet");
    if (localIconPreference == null)
    {
      AppMethodBeat.o(29731);
      return;
    }
    ab.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    ab.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    com.tencent.mm.model.aw.aaz();
    String str3 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yHh, "");
    com.tencent.mm.model.aw.aaz();
    int j = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yHi, Integer.valueOf(-1))).intValue();
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
      com.tencent.mm.model.aw.aaz();
      l1 = ((Long)com.tencent.mm.model.c.Ru().get(ac.a.yHf, Long.valueOf(-1L))).longValue();
      long l2 = ah.lU(com.tencent.mm.m.g.Nq().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      ab.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
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
            com.tencent.mm.x.c.PJ().x(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.RM();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIU, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.RM();
    long l1 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIV, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      ab.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIU, Boolean.FALSE);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIV, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.RM();
      Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIR, "");
      ab.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.x.c.PJ().b(ac.a.yIY, ac.a.yJe);
      com.tencent.mm.kernel.g.RM();
      l1 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJa, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        ab.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.x.c.PJ().c(ac.a.yIY, ac.a.yJe);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJa, Long.valueOf(0L));
      }
      for (;;)
      {
        bool2 = bool3 | bool2;
        com.tencent.mm.kernel.g.RM();
        String str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIX, "");
        ab.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), str1 });
        ab.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
        if (bool5) {
          if (!bo.isNullOrNil(str2))
          {
            localIconPreference.OM(0);
            localIconPreference.aG(str2, -1, -7566196);
            localIconPreference.qI(true);
            localIconPreference.ON(8);
            if (bo.isNullOrNil(str1)) {
              break label1221;
            }
            localObject = str1;
          }
        }
        label1216:
        label1221:
        for (;;)
        {
          if ((!ah.isNullOrNil((String)localObject)) && (bool2))
          {
            localIconPreference.setSummary((CharSequence)localObject);
            label864:
            localObject = h.qsU;
            if (!bool2) {
              break label1216;
            }
          }
          for (i = 1;; i = 0)
          {
            ((h)localObject).e(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
            AppMethodBeat.o(29731);
            return;
            localIconPreference.eO("", -1);
            localIconPreference.OM(8);
            localIconPreference.ON(0);
            break;
            if (bool1)
            {
              localIconPreference.OL(0);
              localIconPreference.eN(getString(2131297012), 2130839787);
              localIconPreference.ON(8);
              break;
            }
            if (i > 99)
            {
              localIconPreference.OL(0);
              localIconPreference.eN(getString(2131304225), com.tencent.mm.ui.tools.t.iF(getContext()));
              localIconPreference.ON(8);
              break;
            }
            if (i > 0)
            {
              localIconPreference.OL(0);
              localIconPreference.eN(String.valueOf(i), com.tencent.mm.ui.tools.t.iF(getContext()));
              localIconPreference.ON(8);
              break;
            }
            if (bool2)
            {
              localIconPreference.eN("", -1);
              localIconPreference.OL(8);
              localIconPreference.ON(0);
              break;
            }
            if (j == 1)
            {
              localIconPreference.eN("", -1);
              localIconPreference.OL(8);
              localIconPreference.OM(0);
              localIconPreference.qI(true);
              if (!ah.isNullOrNil(str3)) {
                localIconPreference.aG(str3, -1, Color.parseColor("#888888"));
              }
              localIconPreference.OQ(8);
              break;
            }
            localIconPreference.eN("", -1);
            localIconPreference.OL(8);
            localIconPreference.ON(8);
            localIconPreference.OM(8);
            localIconPreference.eO("", -1);
            break;
            localIconPreference.setSummary("");
            break label864;
          }
        }
      }
    }
  }
  
  private void dCV()
  {
    AppMethodBeat.i(29751);
    ab.b("MicroMsg.MoreTabUI", "activeBubbleTip", new Object[0]);
    this.zdf.setVisibility(0);
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().ei(this.zcY);
    AppMethodBeat.o(29751);
  }
  
  private void dCW()
  {
    AppMethodBeat.i(29752);
    ab.b("MicroMsg.MoreTabUI", "forceStopBubbleTip", new Object[0]);
    this.zdf.setVisibility(4);
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().ej(this.zcY);
    AppMethodBeat.o(29752);
  }
  
  private void dCX()
  {
    AppMethodBeat.i(29753);
    if ((this.zde) && (this.zcZ.isVisible))
    {
      dCV();
      AppMethodBeat.o(29753);
      return;
    }
    dCW();
    AppMethodBeat.o(29753);
  }
  
  private boolean qt(boolean paramBoolean)
  {
    AppMethodBeat.i(29733);
    com.tencent.mm.plugin.appbrand.o.c.iEL.a(com.tencent.mm.plugin.appbrand.o.c.a.iEP);
    com.tencent.mm.plugin.appbrand.o.c.iEL.a(com.tencent.mm.plugin.appbrand.o.c.a.iFb);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.bq.d.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(29733);
    return true;
  }
  
  private void qu(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(29747);
    if (getActivity() != null)
    {
      if (this.pyF == null)
      {
        View localView = findViewById(2131820956);
        if (localView != null) {
          this.pyF = localView.findViewById(2131820957);
        }
        if (this.pyF == null) {
          break label103;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.pyF == null) {
          break label116;
        }
        if (!paramBoolean) {
          break;
        }
        this.pyF.setOnClickListener(new MoreTabUI.3(this));
        AppMethodBeat.o(29747);
        return;
        label103:
        bool = false;
      }
      this.pyF.setOnClickListener(null);
    }
    label116:
    AppMethodBeat.o(29747);
  }
  
  private void qv(boolean paramBoolean)
  {
    AppMethodBeat.i(29749);
    if (((getContext() instanceof LauncherUI)) && (this.zcZ != null) && (this.zcZ.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().qm(paramBoolean);
    }
    AppMethodBeat.o(29749);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(29732);
    int i = ah.aW(paramObject);
    ab.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    com.tencent.mm.model.aw.aaz();
    if ((paramn != com.tencent.mm.model.c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(29732);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      dCU();
      AppMethodBeat.o(29732);
      return;
    }
    if (40 == i)
    {
      dCT();
      AppMethodBeat.o(29732);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      dCS();
    }
    AppMethodBeat.o(29732);
  }
  
  public final void cbR()
  {
    AppMethodBeat.i(29744);
    ab.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.zcZ != null) && (!this.zcZ.isVisible)) {
      this.zcZ.dPi();
    }
    if ((!com.tencent.mm.plugin.story.api.n.isShowStoryCheck()) || (this.mnn))
    {
      this.zdb.Or(2);
      AppMethodBeat.o(29744);
      return;
    }
    this.zdb.Or(1);
    AppMethodBeat.o(29744);
  }
  
  public final void cbS()
  {
    AppMethodBeat.i(29745);
    ab.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.zcZ != null) && (this.zcZ.isVisible))
    {
      if (!this.mnn) {
        break label99;
      }
      this.zdb.Or(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.atx("settings_my_album");
      if (localIconPreference == null) {
        break label121;
      }
      if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yLO, true)) {
        break;
      }
      this.zdn = true;
      localIconPreference.ON(0);
      AppMethodBeat.o(29745);
      return;
      label99:
      this.zdb.Or(0);
    }
    this.zdn = false;
    localIconPreference.ON(8);
    label121:
    AppMethodBeat.o(29745);
  }
  
  public final void cbT()
  {
    AppMethodBeat.i(29746);
    ab.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.zcZ != null) && (!this.zcZ.isVisible)) {
      this.zcZ.dPi();
    }
    Oq(0);
    qv(this.pBa);
    AppMethodBeat.o(29746);
  }
  
  final void cbV()
  {
    AppMethodBeat.i(29750);
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(29750);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(29750);
  }
  
  protected final void dAA()
  {
    AppMethodBeat.i(29738);
    if (this.pyx != null) {
      this.pyx.onStart();
    }
    AppMethodBeat.o(29738);
  }
  
  protected final void dAB()
  {
    AppMethodBeat.i(29739);
    ab.d("MicroMsg.MoreTabUI", "onTabPause");
    com.tencent.mm.x.c.PJ().b(this.qKG);
    com.tencent.mm.model.aw.aaz();
    com.tencent.mm.model.c.Ru().b(this);
    if (this.pyx != null) {
      this.pyx.onPause();
    }
    if (this.zcZ != null)
    {
      if ((this.zcZ.isVisible) || (this.pBa)) {
        break label108;
      }
      this.zcZ.postDelayed(new MoreTabUI.2(this), 200L);
    }
    for (;;)
    {
      dCW();
      qu(false);
      AppMethodBeat.o(29739);
      return;
      label108:
      if ((this.zcZ.isVisible) && (this.zcZ.getTranslationY() != 0.0F)) {
        this.zcZ.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void dAC()
  {
    AppMethodBeat.i(29740);
    if (this.pyx != null) {
      this.pyx.onStop();
    }
    AppMethodBeat.o(29740);
  }
  
  protected final void dAD()
  {
    AppMethodBeat.i(29741);
    if (this.pyx != null) {
      this.pyx.onDestroy();
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().eh(this.zcY);
    AppMethodBeat.o(29741);
  }
  
  public final void dAF() {}
  
  public final void dAG() {}
  
  public final void dAI() {}
  
  protected final void dAy()
  {
    AppMethodBeat.i(29735);
    boolean bool;
    Object localObject;
    if (getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.mnn = bool;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.bL(getContext());
      com.tencent.mm.kernel.g.RM();
      this.pyy = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fb(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cb.a.ap(getContext(), 2131428633), com.tencent.mm.cb.a.ap(getContext(), 2131428633));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131823945).getParent()).addView(this.pyy, 0, (ViewGroup.LayoutParams)localObject);
      this.zcZ.AIa = this.mPullDownCallback;
      this.zcZ.setPadding(this.zcZ.getPaddingLeft(), this.zcZ.getPaddingTop(), this.zcZ.getPaddingRight(), this.zda.getHeight());
      if (this.pmj != null)
      {
        ab.d("MicroMsg.MoreTabUI", "dancy test add view !");
        this.pyx = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), m.a.sqP, null);
        if (this.pyx != null)
        {
          this.zdk = (-(am.hQ(getContext()).y / 10));
          if (!this.zdl) {
            break label458;
          }
        }
      }
    }
    label458:
    for (int i = com.tencent.mm.cb.a.ap(getContext(), 2131428635);; i = com.tencent.mm.cb.a.ap(getContext(), 2131428634))
    {
      this.zdj = i;
      this.zdi = (-com.tencent.mm.cb.a.fromDPToPix(getContext(), 330));
      this.zdh = 0;
      localObject = new RelativeLayout.LayoutParams(-1, am.hQ(getContext()).y);
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.zdk;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-am.fx(getContext()));
      this.pmj.addView(this.pyx, 0, (ViewGroup.LayoutParams)localObject);
      this.zcZ.y(this.pyx, this.zdj, this.zdk);
      this.zcZ.setNavigationBarHeight(am.fx(getActivity()));
      this.pyx.setDataSeed(r.Zn());
      this.pyx.a(this.zcZ);
      this.pyx.setStoryBrowseUIListener(this);
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().d(this.zdg, this.zcY);
      this.zdb.dCY();
      AppMethodBeat.o(29735);
      return;
      bool = false;
      break;
    }
  }
  
  protected final void dAz()
  {
    AppMethodBeat.i(29737);
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    com.tencent.mm.model.aw.aaz();
    com.tencent.mm.model.c.Ru().a(this);
    com.tencent.mm.x.c.PJ().a(this.qKG);
    this.screen.cl("more_tab_setting_personal_info", false);
    this.zdd = ((AccountInfoPreference)this.adapter.atx("more_tab_setting_personal_info"));
    Object localObject = r.Zo();
    if (ah.isNullOrNil((String)localObject))
    {
      localObject = r.Zn();
      if (ad.ari((String)localObject))
      {
        this.zdd.waq = null;
        this.zdd.userName = r.Zn();
        String str = r.Zp();
        localObject = str;
        if (ah.isNullOrNil(str)) {
          localObject = r.Zn();
        }
        this.zdd.wap = j.b(getContext(), (CharSequence)localObject);
        this.zdd.ae(this.pBa, this.zdl);
        this.zdd.wax = new MoreTabUI.7(this);
        ((AccountInfoPreference)this.screen.atx("more_tab_setting_personal_info")).waw = new MoreTabUI.8(this);
        localObject = (IconPreference)this.screen.atx("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.bi.d.ali().dxy();
          if (i <= 0) {
            break label665;
          }
          ((IconPreference)localObject).OL(0);
          ((IconPreference)localObject).eN(String.valueOf(i), 2130839787);
        }
        label260:
        dCP();
        dCS();
        dCR();
        if (com.tencent.mm.bq.d.ahR("favorite")) {
          break label684;
        }
        this.screen.cl("settings_mm_favorite", true);
        label294:
        dCU();
        dCT();
        dCQ();
        if (!com.tencent.mm.kernel.g.RH().D(com.tencent.mm.plugin.x.a.a.class)) {
          break label700;
        }
        this.screen.cl("more_uishow", false);
        label331:
        localObject = this.screen.atx("settings_privacy_agreements");
        if (!com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) {
          break label716;
        }
        str = getString(2131302168);
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
        localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131690214)), localSpannable.length() - str.length(), localSpannable.length(), 33);
        ((Preference)localObject).setTitle(localSpannable);
        this.screen.cl("settings_privacy_agreements", false);
        label452:
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        localObject = findViewById(2131828467);
        if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
          new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper()).post(new MoreTabUI.11(this, (View)localObject));
        }
        if ((this.zcZ != null) && (this.zcZ.isVisible))
        {
          Oq(0);
          ab.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.pyx != null)
        {
          this.pyx.onResume();
          this.pyx.Pc();
        }
        if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.x.c.PJ().cc(352279, 266241))) {
          break label732;
        }
      }
    }
    label665:
    label684:
    label700:
    label716:
    label732:
    for (boolean bool = true;; bool = false)
    {
      this.zde = bool;
      dCX();
      ab.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(29737);
      return;
      this.zdd.waq = ((String)localObject);
      break;
      this.zdd.waq = ((String)localObject);
      break;
      ((IconPreference)localObject).OL(8);
      ((IconPreference)localObject).eN("", -1);
      break label260;
      this.screen.cl("settings_mm_favorite", false);
      break label294;
      this.screen.cl("more_uishow", true);
      break label331;
      this.screen.cl("settings_privacy_agreements", true);
      break label452;
    }
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(29742);
    ab.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.zdm = true;
    boolean bool;
    Object localObject;
    if (getContext() != null)
    {
      if (getResources().getConfiguration().orientation == 2)
      {
        bool = true;
        this.mnn = bool;
      }
    }
    else if (this.zcZ != null)
    {
      localObject = this.zcZ;
      ak.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).AHW = true;
      if ((!this.zcZ.isVisible) || (this.zcZ.getTranslationY() == 0.0F)) {
        break label179;
      }
      this.zcZ.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.pyx != null) {
        this.pyx.Pc();
      }
      qu(true);
      long l = System.currentTimeMillis();
      localObject = i.sFa;
      i.mO(l);
      localObject = i.sFa;
      i.cDJ().cVu = l;
      localObject = i.sFa;
      i.cDJ().cWB = System.currentTimeMillis();
      AppMethodBeat.o(29742);
      return;
      bool = false;
      break;
      label179:
      if (!this.zcZ.isVisible) {
        this.zcZ.dPi();
      }
    }
  }
  
  public final void dBD()
  {
    AppMethodBeat.i(29743);
    this.zdm = false;
    if (this.zcZ != null)
    {
      localObject = this.zcZ;
      ak.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).AHW = false;
      if (!this.zcZ.isVisible) {
        this.zcZ.dPi();
      }
    }
    if (this.pyy != null) {
      this.pyy.setVisibility(8);
    }
    Object localObject = new ta();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    qu(false);
    localObject = i.sFa;
    i.cDK();
    AppMethodBeat.o(29743);
  }
  
  public final int getResourceId()
  {
    return 2131165251;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(29723);
    ab.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = this.adapter;
    this.screen.cl("more_setting", true);
    this.screen.cl("settings_emoji_store", true);
    this.screen.cl("settings_mm_wallet", true);
    this.screen.cl("settings_mm_cardpackage", true);
    this.screen.cl("settings_mm_favorite", true);
    this.screen.cl("settings_my_album", true);
    this.screen.cl("settings_my_address", true);
    this.screen.cl("more_tab_setting_personal_info", true);
    this.screen.cl("more_uishow", true);
    this.screen.cl("settings_privacy_agreements", true);
    this.zda = getView().getRootView().findViewById(2131820634);
    this.pmj = ((RelativeLayout)findViewById(2131826236));
    this.zcY = ((ImageView)findViewById(2131826239));
    this.zdf = ((RelativeLayout)findViewById(2131826237));
    this.zdg = ((FrameLayout)findViewById(2131826238));
    this.zcZ = ((PullDownListView)this.list);
    this.zcZ.setTabView(this.zda);
    this.zcZ.setBackgroundResource(2130839609);
    this.zcZ.setOnScrollListener(new MoreTabUI.4(this));
    AppMethodBeat.o(29723);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(29734);
    super.onConfigurationChanged(paramConfiguration);
    ab.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
    if (paramConfiguration.orientation == 1)
    {
      this.mnn = false;
      if (this.zcZ != null)
      {
        this.zdb.dCY();
        AppMethodBeat.o(29734);
      }
    }
    else if (paramConfiguration.orientation == 2)
    {
      this.mnn = true;
      if (this.zcZ != null)
      {
        if (!this.zcZ.isVisible) {
          this.zcZ.dPi();
        }
        this.zdb.Or(2);
      }
    }
    AppMethodBeat.o(29734);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29718);
    super.onCreate(paramBundle);
    if ((!com.tencent.mm.model.aw.RG()) || (com.tencent.mm.model.aw.QP()))
    {
      ab.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(com.tencent.mm.model.aw.RG()), Boolean.valueOf(com.tencent.mm.model.aw.QP()) });
      AppMethodBeat.o(29718);
      return;
    }
    dCO();
    qu(false);
    AppMethodBeat.o(29718);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29722);
    super.onDestroy();
    AppMethodBeat.o(29722);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29748);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.pyx != null)) {}
    for (boolean bool = this.pyx.onBackPressed();; bool = false)
    {
      ab.d("MicroMsg.MoreTabUI", "onBackPressed: %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) || (super.onKeyDown(paramInt, paramKeyEvent)))
      {
        AppMethodBeat.o(29748);
        return true;
      }
      AppMethodBeat.o(29748);
      return false;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29720);
    super.onPause();
    ab.i("MicroMsg.MoreTabUI", "onPause: ");
    if (this.zdm)
    {
      i locali = i.sFa;
      i.cDK();
    }
    AppMethodBeat.o(29720);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29725);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (Object localObject = "null";; localObject = paramPreference.mKey)
    {
      ab.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.RG()) {
        break;
      }
      ab.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      startActivity(paramf);
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.bq.d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      AppMethodBeat.o(29725);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      bool1 = com.tencent.mm.x.c.PJ().cc(262156, 266248);
      boolean bool2 = com.tencent.mm.x.c.PJ().cd(262156, 266248);
      h.qsU.kvStat(10958, "9");
      paramf = h.qsU;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.e(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        h.qsU.e(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new ou();
        paramPreference.cFt.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.cFt.intent = ((Intent)localObject);
        com.tencent.mm.sdk.b.a.ymk.l(paramPreference);
        com.tencent.mm.x.c.PJ().ce(262156, 266248);
        com.tencent.mm.x.c.PJ().c(ac.a.yHy, ac.a.yHA);
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yHh, "");
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yHi, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIU, Boolean.FALSE);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIR, "");
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIS, Boolean.FALSE);
        com.tencent.mm.x.c.PJ().c(ac.a.yIY, ac.a.yJe);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIX, "");
        paramf = h.qsU;
        if (!bool2) {
          break label567;
        }
      }
      label567:
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        AppMethodBeat.o(29725);
        return true;
        i = 0;
        break;
      }
    }
    if (paramPreference.mKey.equals("settings_mm_cardpackage"))
    {
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yyT, "");
      new Intent().putExtra("key_from_scene", 22);
      ab.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new il();
      paramf.cxQ.context = getContext();
      paramf.cxQ.cxS = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      com.tencent.mm.model.aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.ii(getContext());
        AppMethodBeat.o(29725);
        return true;
      }
      com.tencent.mm.model.aw.aaz();
      paramf = (String)com.tencent.mm.model.c.Ru().get(2, null);
      paramPreference = new Intent(getContext(), AlbumUI.class);
      paramPreference.putExtra("sns_userName", paramf);
      paramPreference.putExtra("username", paramf);
      paramPreference.putExtra("story_dot", this.zdn);
      paramPreference.setFlags(536870912);
      paramPreference.addFlags(67108864);
      com.tencent.mm.model.aw.aaz();
      i = ah.h((Integer)com.tencent.mm.model.c.Ru().get(68389, null));
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.Ru().set(68389, Integer.valueOf(i + 1));
      startActivity(paramPreference);
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      h.qsU.kvStat(10958, "8");
      h.qsU.e(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cn.d.aNX();
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      h.qsU.kvStat(10958, "7");
      com.tencent.mm.x.c.PJ().ce(262147, 266244);
      com.tencent.mm.x.c.PJ().ce(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.bq.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      h.qsU.e(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).dH(com.tencent.mm.plugin.boots.a.b.jRB, 881);
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.x.c.PJ().cc(262145, 266242);
      com.tencent.mm.x.c.PJ().ce(262145, 266242);
      com.tencent.mm.x.c.PJ().ce(262157, 266261);
      com.tencent.mm.x.c.PJ().ce(262158, 266264);
      com.tencent.mm.x.c.PJ().b(ac.a.yJH, 266242);
      paramPreference = new Intent();
      com.tencent.mm.bq.d.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      com.tencent.mm.model.aw.aaz();
      i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yFx, Integer.valueOf(0))).intValue();
      com.tencent.mm.model.aw.aaz();
      int j = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yFy, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yFy, Integer.valueOf(i));
        paramf = (IconPreference)paramf.atx("more_setting");
        if (paramf != null) {
          paramf.ON(8);
        }
        com.tencent.mm.x.c.PJ().ce(266260, 266241);
      }
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.x.a.a.a.class);
      getContext();
      new Intent();
      AppMethodBeat.o(29725);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131306182, new Object[] { aa.dsG(), com.tencent.mm.kernel.g.RL().Ru().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
      AppMethodBeat.o(29725);
      return true;
    }
    AppMethodBeat.o(29725);
    return false;
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(29724);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(29724);
      return true;
    }
    boolean bool;
    try
    {
      if ((bp.dsd()) || (bp.dub()) || (bp.dud()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED))
      {
        if (bo.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = qt(true);
          AppMethodBeat.o(29724);
          return bool;
        }
        if (bo.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = qt(false);
          AppMethodBeat.o(29724);
          return bool;
        }
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
      AppMethodBeat.o(29724);
    }
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29719);
    super.onResume();
    ab.i("MicroMsg.MoreTabUI", "onResume: ");
    dCO();
    if (this.zdm)
    {
      long l = System.currentTimeMillis();
      i locali = i.sFa;
      i.mO(l);
      locali = i.sFa;
      i.cDJ().cVu = l;
    }
    AppMethodBeat.o(29719);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
    implements com.tencent.mm.ai.f
  {
    a() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */