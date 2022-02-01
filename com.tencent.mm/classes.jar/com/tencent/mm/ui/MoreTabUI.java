package com.tencent.mm.ui;

import android.annotation.SuppressLint;
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
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.lc;
import com.tencent.mm.f.a.te;
import com.tencent.mm.f.a.yl;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconTipPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.g, MStorageEx.IOnStorageChange
{
  private RelativeLayout DtO;
  private AbsStoryMuteView GXE;
  private com.tencent.mm.plugin.textstatus.a.b GXK;
  private View GXO;
  private boolean Had;
  private boolean Hae;
  private byte[] Jew;
  private com.tencent.mm.aa.a.a Jkk;
  private Bitmap Mho;
  private RelativeLayout RpH;
  private FrameLayout RpI;
  private LinearLayout RpJ;
  private boolean RpK;
  PullDownListView WbV;
  private View WbW;
  private View WbX;
  private c WbY;
  private boolean WbZ;
  private boolean Wca;
  private boolean Wcb;
  private AccountInfoPreference Wcc;
  private RelativeLayout Wcd;
  private int Wce;
  private int Wcf;
  private int Wcg;
  private int Wch;
  private boolean Wci;
  private boolean Wcj;
  private boolean Wck;
  private boolean Wcl;
  private com.tencent.mm.ay.a.c.h Wcm;
  private a Wcn;
  public boolean Wco;
  private boolean Wcp;
  public boolean Wcq;
  private int Wcr;
  private int Wcs;
  private boolean Wct;
  private MoreTabUI.b Wcu;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean qoc;
  private com.tencent.mm.ui.base.preference.f screen;
  @Keep
  private AbsStoryGallery storyGallery;
  private s<h.a> xnQ;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.Mho = null;
    this.Jew = null;
    this.GXE = null;
    this.DtO = null;
    this.WbW = null;
    this.storyGallery = null;
    this.GXK = null;
    this.WbX = null;
    this.WbY = new c((byte)0);
    this.Had = false;
    this.Hae = false;
    this.WbZ = false;
    this.Wca = false;
    this.Wcb = false;
    this.Wcc = null;
    this.RpK = false;
    this.RpH = null;
    this.RpI = null;
    this.Wcd = null;
    this.RpJ = null;
    this.Wce = 0;
    this.Wcf = 0;
    this.Wcg = 0;
    this.Wch = 0;
    this.qoc = false;
    this.Wci = false;
    this.Wcj = false;
    this.Wck = false;
    this.Wcl = false;
    this.Jkk = new com.tencent.mm.aa.a.a()
    {
      public final void E(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(33523);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 266267) || (paramAnonymousInt == 262158) || (paramAnonymousInt == 262164))
        {
          MoreTabUI.a(MoreTabUI.this);
          MoreTabUI.b(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.g(MoreTabUI.this).notifyDataSetChanged();
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
          } else if ((paramAnonymousInt == 352280) && (MoreTabUI.f(MoreTabUI.this)) && (com.tencent.mm.aa.c.aFn().aFk())) {
            com.tencent.mm.aa.c.aFn().D(352280, false);
          }
        }
      }
      
      public final void b(ar.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == ar.a.VhN) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.g(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == ar.a.VhO) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == ar.a.VrE) || (paramAnonymousa == ar.a.Vtk)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == ar.a.Vuw) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.Wcm = new MoreTabUI.9(this);
    this.xnQ = null;
    this.Wco = true;
    this.Wcp = true;
    this.Wcq = true;
    this.Wcr = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
    this.Wcs = com.tencent.mm.ci.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void abo(int paramAnonymousInt)
      {
        AppMethodBeat.i(268683);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).ahW(paramAnonymousInt);
        }
        AppMethodBeat.o(268683);
      }
      
      public final void abp(int paramAnonymousInt)
      {
        AppMethodBeat.i(268684);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).ahX(paramAnonymousInt);
        }
        AppMethodBeat.o(268684);
      }
      
      public final void abq(int paramAnonymousInt)
      {
        AppMethodBeat.i(268685);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).abq(paramAnonymousInt);
        }
        AppMethodBeat.o(268685);
      }
      
      public final void dDB()
      {
        boolean bool = true;
        AppMethodBeat.i(268679);
        Object localObject;
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreOpen, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).dDB();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                localObject = MoreTabUI.s(MoreTabUI.this).HaE;
                if (localObject != null) {
                  ((com.tencent.mm.plugin.textstatus.a.e)localObject).dDB();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).RpL = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(268679);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).gbh();
          }
          if ((MoreTabUI.f(MoreTabUI.this)) && (!MoreTabUI.n(MoreTabUI.this)))
          {
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geX().gSu = System.currentTimeMillis();
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geY();
          }
        }
      }
      
      public final void dDC()
      {
        boolean bool = true;
        AppMethodBeat.i(268680);
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).dDC();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                com.tencent.mm.plugin.textstatus.a.e locale = MoreTabUI.s(MoreTabUI.this).HaE;
                if (locale != null) {
                  locale.dDC();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).RpL = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(268680);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).gbi();
          }
        }
      }
      
      public final void fqe()
      {
        AppMethodBeat.i(268681);
        Log.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.A(MoreTabUI.this).gbo();
        AppMethodBeat.o(268681);
      }
      
      public final void fqf()
      {
        AppMethodBeat.i(268682);
        MoreTabUI.A(MoreTabUI.this).gbp();
        AppMethodBeat.o(268682);
      }
      
      public final void onPostClose()
      {
        boolean bool = true;
        AppMethodBeat.i(268678);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$12", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        Object localObject;
        if (MoreTabUI.l(MoreTabUI.this))
        {
          if (MoreTabUI.r(MoreTabUI.this) == null) {}
          for (;;)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPostClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).onPostClose();
            }
            if (MoreTabUI.s(MoreTabUI.this) != null)
            {
              localObject = MoreTabUI.s(MoreTabUI.this).HaE;
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.e)localObject).onPostClose();
              }
            }
            if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
              MoreTabUI.s(MoreTabUI.this).hmI();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$12", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V");
            AppMethodBeat.o(268678);
            return;
            bool = false;
          }
        }
        if (MoreTabUI.m(MoreTabUI.this) == null) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            MoreTabUI.m(MoreTabUI.this).zm(true);
            MoreTabUI.m(MoreTabUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(214370);
                MoreTabUI.x(MoreTabUI.this);
                MoreTabUI.a(MoreTabUI.this, 0);
                MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
                if (MoreTabUI.y(MoreTabUI.this) != null) {
                  MoreTabUI.y(MoreTabUI.this).setTranslationY(0.0F);
                }
                AppMethodBeat.o(214370);
              }
            });
          }
          MoreTabUI.a(MoreTabUI.this, false);
          MoreTabUI.z(MoreTabUI.this).fqd();
          if ((!MoreTabUI.f(MoreTabUI.this)) || (MoreTabUI.n(MoreTabUI.this))) {
            break;
          }
          long l = System.currentTimeMillis();
          localObject = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.RP(l);
          localObject = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geX().gRi = l;
          break;
        }
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268677);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).eL(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$12", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (MoreTabUI.l(MoreTabUI.this))
        {
          if (MoreTabUI.r(MoreTabUI.this) == null) {}
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPostOpen, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).onPostOpen(paramAnonymousBoolean);
            }
            if (MoreTabUI.s(MoreTabUI.this) != null)
            {
              localObject = MoreTabUI.s(MoreTabUI.this).HaE;
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.e)localObject).onPostOpen(paramAnonymousBoolean);
              }
            }
            MoreTabUI.a(MoreTabUI.this, 8);
            if (MoreTabUI.s(MoreTabUI.this) != null) {
              MoreTabUI.s(MoreTabUI.this).hmH();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$12", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
            AppMethodBeat.o(268677);
            return;
          }
        }
        if (MoreTabUI.m(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geE().gQR = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.LOJ;
            com.tencent.mm.plugin.story.h.h.geE().gSp = 1L;
            MoreTabUI.m(MoreTabUI.this).aD(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.t(MoreTabUI.this);
            MoreTabUI.u(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if ((MoreTabUI.n(MoreTabUI.this)) || (MoreTabUI.v(MoreTabUI.this))) {
            break;
          }
          int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VwZ, 0);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VwZ, Integer.valueOf(i + 1));
          MoreTabUI.w(MoreTabUI.this);
          break;
        }
      }
    };
    this.Wct = false;
    this.Wcu = new MoreTabUI.b(this);
    AppMethodBeat.o(33555);
  }
  
  private boolean FB(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.w.c.qHP.a(com.tencent.mm.plugin.appbrand.w.c.a.qHT);
    com.tencent.mm.plugin.appbrand.w.c.qHP.a(com.tencent.mm.plugin.appbrand.w.c.a.qIf);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.by.c.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void FC(boolean paramBoolean)
  {
    AppMethodBeat.i(264639);
    this.WbZ = paramBoolean;
    if (this.storyGallery != null)
    {
      this.DtO.removeView(this.storyGallery);
      this.storyGallery.onDestroy();
      this.WbV.A(null, 0, 0);
      this.storyGallery = null;
    }
    if (this.GXK != null)
    {
      this.DtO.removeView(this.WbX);
      this.DtO.removeView(this.GXK.getView());
      this.GXK.gkI();
      this.GXK = null;
      if (this.Wcc != null) {
        this.Wcc.hmG();
      }
    }
    this.Wca = false;
    hIp();
    hIg();
    if (this.Wcc != null) {
      hIk();
    }
    AppMethodBeat.o(264639);
  }
  
  private void FD(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.GXO == null)
      {
        View localView = findViewById(R.h.action_bar_container);
        if (localView != null) {
          this.GXO = localView.findViewById(R.h.action_bar);
        }
        if (this.GXO == null) {
          break label112;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.GXO == null) {
          break label125;
        }
        if ((!paramBoolean) || (this.WbZ)) {
          break;
        }
        this.GXO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(279953);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.p(MoreTabUI.this)) {
              com.tencent.mm.ui.base.w.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.l.eTH), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(279953);
              return;
              if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
                MoreTabUI.o(MoreTabUI.this).idh();
              }
            }
          }
        });
        AppMethodBeat.o(33587);
        return;
        label112:
        bool = false;
      }
      this.GXO.setOnClickListener(null);
    }
    label125:
    AppMethodBeat.o(33587);
  }
  
  private void FE(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.WbV != null) && (this.WbV.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().Fv(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  private void aue(int paramInt)
  {
    AppMethodBeat.i(33576);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (getActivity() != null) {}
    try
    {
      localObject1 = findViewById(R.h.action_bar_container);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(paramInt);
        Log.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(33576);
        return;
      }
      Log.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
      AppMethodBeat.o(33576);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static void d(NormalIconNewTipPreference paramNormalIconNewTipPreference)
  {
    AppMethodBeat.i(264636);
    paramNormalIconNewTipPreference.aak(0);
    paramNormalIconNewTipPreference.abe(8);
    paramNormalIconNewTipPreference.fC("", -1);
    com.tencent.mm.plugin.newtips.a.g.a(paramNormalIconNewTipPreference, k.GwK, true);
    AppMethodBeat.o(264636);
  }
  
  private void hIg()
  {
    AppMethodBeat.i(33559);
    if (!this.Wci)
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VwZ, 0);
      boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VwM, false);
      Log.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.Had) && ((bool) || (i > 0)))
      {
        this.Wci = true;
        if (this.Wcc != null) {
          this.Wcc.n(this.Had, this.Wci, this.Hae);
        }
        if (!this.Wci) {
          break label150;
        }
      }
    }
    label150:
    for (int i = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlC);; i = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlB))
    {
      this.Wcg = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void hIh()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.by.c.blP("sns"))
    {
      this.screen.dz("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.dz("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.byG("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vxi, true)) && (this.Wck))
      {
        localIconPreference.aak(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.Wck = false;
      localIconPreference.aak(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void hIi()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).cHS()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).cHT())) || (!com.tencent.mm.by.c.blP("card")))
    {
      this.screen.dz("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).cHU();; localObject1 = "")
    {
      this.screen.dz("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.byG("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262152, 266256);
      boolean bool3 = com.tencent.mm.aa.c.aFn().dj(262152, 266256);
      boolean bool4 = com.tencent.mm.aa.c.aFn().a(ar.a.VhN, ar.a.VhP);
      boolean bool5 = com.tencent.mm.aa.c.aFn().a(ar.a.VhO, ar.a.VhQ);
      bh.beI();
      String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.VhW, "");
      localNormalIconNewTipPreference.setTitle(R.l.settings_mm_card_package_new);
      com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.fiO().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.FRB = this.Wcm;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.abe(0);
        localNormalIconNewTipPreference.fC(getString(R.l.app_new), R.g.new_tips_bg);
        localNormalIconNewTipPreference.aak(8);
        localNormalIconNewTipPreference.aF(null);
        localNormalIconNewTipPreference.aK(null);
        localNormalIconNewTipPreference.auF(8);
        localNormalIconNewTipPreference.hI("", -1);
        localNormalIconNewTipPreference.auD(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwL, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(R.f.card_entrance_icon_height);
        Object localObject2 = new com.tencent.mm.ay.a.a.c.a();
        ((com.tencent.mm.ay.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aSL();
        q.bmm();
        ((com.tencent.mm.ay.a.a.c.a)localObject2).lRV = null;
        ((com.tencent.mm.ay.a.a.c.a)localObject2).lRD = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject2).kPz = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject2).lRB = true;
        ((com.tencent.mm.ay.a.a.c.a)localObject2).kOg = i;
        ((com.tencent.mm.ay.a.a.c.a)localObject2).kOf = i;
        localObject2 = ((com.tencent.mm.ay.a.a.c.a)localObject2).bmL();
        q.bml().a(str, localNormalIconNewTipPreference.hKJ(), (com.tencent.mm.ay.a.a.c)localObject2, this.Wcm);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwN, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.aak(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwK, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.fC("", -1);
          localNormalIconNewTipPreference.abe(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.aF(null);
            if (!ae.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aU((String)localObject1, -1, getResources().getColor(R.e.hint_text_color));
              localNormalIconNewTipPreference.auD(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwM, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aK(null);
              localNormalIconNewTipPreference.auF(8);
              break;
              label633:
              localNormalIconNewTipPreference.aak(8);
              continue;
            }
            localNormalIconNewTipPreference.hI("", -1);
            localNormalIconNewTipPreference.auD(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.hI("", -1);
          localNormalIconNewTipPreference.auD(8);
          if (!ae.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.aF((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwM, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.aF(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.auD(8);
      localNormalIconNewTipPreference.abe(8);
      localNormalIconNewTipPreference.aF(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void hIj()
  {
    AppMethodBeat.i(33566);
    this.screen.dz("more_setting", false);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.byG("more_setting");
    boolean bool2;
    int i;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if (localNormalIconNewTipPreference != null)
    {
      localNormalIconNewTipPreference.auG(8);
      com.tencent.mm.plugin.newtips.a.fiO().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      bool2 = com.tencent.mm.aa.c.aFn().dj(262145, 266242);
      bh.beI();
      i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VoP, Integer.valueOf(0))).intValue();
      bh.beI();
      j = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VoQ, Integer.valueOf(0))).intValue();
      if ((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.c.class)).hcV()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.c.class)).hcW()) || (i > j))
      {
        i = 1;
        bool3 = com.tencent.mm.aa.c.aFn().dk(262157, 266261);
        bool4 = com.tencent.mm.aa.c.aFn().dk(262164, 266268);
        bool5 = com.tencent.mm.aa.c.aFn().dk(262158, 266264);
        bool6 = com.tencent.mm.aa.c.aFn().a(ar.a.Vuw, 266242);
        bh.beI();
        if ((com.tencent.mm.model.c.aHp().getInt(40, 0) & 0x20000) != 0) {
          break label760;
        }
      }
    }
    label304:
    label343:
    label480:
    label485:
    label491:
    label497:
    label760:
    for (int j = 1;; j = 0)
    {
      if (Util.getInt(com.tencent.mm.n.h.axc().getValue("VoiceprintEntry"), 0) == 1) {
        bh.beI();
      }
      for (boolean bool1 = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vhp, Boolean.FALSE)).booleanValue();; bool1 = false)
      {
        int k;
        boolean bool7;
        int m;
        if ((bool1) && (j != 0))
        {
          j = 1;
          com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.fiP().aas(com.tencent.mm.plugin.newtips.a.d.Gwf);
          if ((locala == null) || (!locala.field_isExit)) {
            break label480;
          }
          com.tencent.mm.plugin.newtips.a.fiR();
          if (!com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf)) {
            break label480;
          }
          k = 1;
          bool7 = ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).hasSettingTabRedDot();
          if ((!bool2) && (i == 0) && (!bool3) && (!bool4) && (!bool5) && (!bool6) && (j == 0)) {
            break label485;
          }
          m = 1;
          if ((m == 0) && (locala != null) && (!locala.field_isExit))
          {
            this.Wcn = new a(localNormalIconNewTipPreference);
            com.tencent.mm.plugin.newtips.a.fiO().GwG = this.Wcn;
          }
          if ((m == 0) && (k == 0) && (!bool7)) {
            break label491;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference)) {
            break label497;
          }
          AppMethodBeat.o(33566);
          return;
          i = 0;
          break;
          j = 0;
          break label304;
          k = 0;
          break label343;
          m = 0;
          break label395;
        }
        localNormalIconNewTipPreference.aak(8);
        if (bool2)
        {
          localNormalIconNewTipPreference.abe(0);
          localNormalIconNewTipPreference.fC(getString(R.l.app_new), R.g.new_tips_bg);
          com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwL, true);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.abe(8);
        localNormalIconNewTipPreference.fC("", -1);
        if (i != 0)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        if (bool3)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        if (bool4)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        if (bool5)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        if (bool6)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        if (j != 0)
        {
          Log.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        if (k != 0)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        if (bool7)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aak(8);
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void hIk()
  {
    AppMethodBeat.i(264637);
    this.screen.dz("more_tab_setting_personal_info", false);
    this.Wcc = ((AccountInfoPreference)getPreferenceScreen().byG("more_tab_setting_personal_info"));
    Object localObject = z.bda();
    if (ae.isNullOrNil((String)localObject))
    {
      localObject = z.bcZ();
      if (as.bvU((String)localObject)) {
        this.Wcc.Rpx = null;
      }
    }
    for (;;)
    {
      this.Wcc.userName = z.bcZ();
      String str = z.bdb();
      localObject = str;
      if (ae.isNullOrNil(str)) {
        localObject = z.bdc();
      }
      this.Wcc.Rpw = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)localObject);
      this.Wcc.n(this.Had, this.Wci, this.Hae);
      this.Wcc.RpM = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33547);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (MoreTabUI.l(MoreTabUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33547);
            return;
          }
          if ((MoreTabUI.m(MoreTabUI.this) != null) && (MoreTabUI.n(MoreTabUI.this)) && (MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
            MoreTabUI.m(MoreTabUI.this).gbj();
          }
          if (MoreTabUI.p(MoreTabUI.this)) {
            com.tencent.mm.ui.base.w.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.l.eTH), 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33547);
            return;
            if (MoreTabUI.o(MoreTabUI.this) != null) {
              MoreTabUI.o(MoreTabUI.this).idh();
            }
          }
        }
      };
      ((AccountInfoPreference)this.screen.byG("more_tab_setting_personal_info")).FTO = new MoreTabUI.15(this);
      AppMethodBeat.o(264637);
      return;
      this.Wcc.Rpx = ((String)localObject);
      continue;
      this.Wcc.Rpx = ((String)localObject);
    }
  }
  
  private void hIl()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.by.c.blP("emoji"))
    {
      com.tencent.mm.by.c.hok();
      this.screen.dz("settings_emoji_store", false);
      bool1 = com.tencent.mm.aa.c.aFn().dj(262147, 266244);
      bool2 = com.tencent.mm.aa.c.aFn().dj(262149, 266244);
      localIconPreference = (IconPreference)this.screen.byG("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.dz("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.abe(0);
      localIconPreference.fC(getString(R.l.app_new), R.g.new_tips_bg);
    }
    while ((bool2) || (bool1))
    {
      bh.beI();
      String str = (String)com.tencent.mm.model.c.aHp().b(229633, null);
      q.bml().a(str, localIconPreference.hKJ(), new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(33551);
          if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null))
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.16.this.Wcz.aK(this.mLY);
                MoreTabUI.16.this.Wcz.auF(0);
                AppMethodBeat.o(33549);
              }
            });
            AppMethodBeat.o(33551);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33550);
              MoreTabUI.16.this.Wcz.auF(8);
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
        localIconPreference.abe(0);
        localIconPreference.fC(getString(R.l.app_free), R.g.new_tips_bg);
      }
      else
      {
        localIconPreference.abe(8);
        localIconPreference.fC("", -1);
      }
    }
    localIconPreference.auF(8);
    AppMethodBeat.o(33567);
  }
  
  private void hIm()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = z.bdl();
    Log.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.dz("settings_mm_wallet", bool1);
      getPreferenceScreen().notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (Util.isEqual(i, -1)) {
        break label158;
      }
      if ((i & 0x8000) == 0) {
        break label141;
      }
    }
    label141:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label158;
      }
      if (!bool2) {
        break label146;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label146:
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1056L, 0L, 1L, false);
    label158:
    AppMethodBeat.o(33568);
  }
  
  private void hIn()
  {
    AppMethodBeat.i(33569);
    bh.beI();
    int i = ae.l((Integer)com.tencent.mm.model.c.aHp().b(204820, null));
    bh.beI();
    int j = i + ae.l((Integer)com.tencent.mm.model.c.aHp().b(204817, null));
    boolean bool2 = com.tencent.mm.aa.c.aFn().dj(262156, 266248);
    boolean bool1 = com.tencent.mm.aa.c.aFn().dk(262156, 266248);
    boolean bool5 = com.tencent.mm.aa.c.aFn().b(ar.a.VrE, ar.a.VrG);
    bh.beI();
    String str2 = (String)com.tencent.mm.model.c.aHp().get(ar.a.VrH, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.byG("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.aHH();
    int k = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqP, Integer.valueOf(0))).intValue();
    int m;
    if ((i != 0) && (i != 1))
    {
      com.tencent.mm.kernel.h.aHH();
      m = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VqQ, Integer.valueOf(0))).intValue();
      if (i != k)
      {
        bool1 = false;
        bool2 = false;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool2)));
      Log.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool1)));
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.fiO().h(localNormalIconNewTipPreference);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      bh.beI();
      String str3 = (String)com.tencent.mm.model.c.aHp().get(ar.a.VqT, "");
      bh.beI();
      k = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VqU, Integer.valueOf(-1))).intValue();
      boolean bool4;
      boolean bool3;
      if (!bool2)
      {
        bool4 = bool1;
        bool3 = bool2;
        if (!bool1) {}
      }
      else
      {
        bh.beI();
        l1 = ((Long)com.tencent.mm.model.c.aHp().get(ar.a.VqN, Long.valueOf(-1L))).longValue();
        long l2 = ae.Mh(com.tencent.mm.n.h.axc().getValue("PayWalletRedDotExpire"));
        long l3 = System.currentTimeMillis();
        double d = (l3 - l1) / 86400000.0D;
        Log.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
        bool4 = bool1;
        bool3 = bool2;
        if (l1 > 0L)
        {
          bool4 = bool1;
          bool3 = bool2;
          if (l2 > 0L)
          {
            bool4 = bool1;
            bool3 = bool2;
            if (d >= l2)
            {
              bool3 = false;
              bool4 = false;
              com.tencent.mm.aa.c.aFn().C(262156, false);
            }
          }
        }
      }
      com.tencent.mm.kernel.h.aHH();
      bool1 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtg, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.aHH();
      long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vth, Long.valueOf(0L))).longValue();
      if ((bool1) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool1 = false;
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtg, Boolean.FALSE);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vth, Long.valueOf(0L));
      }
      for (;;)
      {
        bool2 = bool4 | bool1;
        com.tencent.mm.kernel.h.aHH();
        Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtc, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), localObject });
        bool1 = com.tencent.mm.aa.c.aFn().b(ar.a.Vtk, ar.a.Vtq);
        com.tencent.mm.kernel.h.aHH();
        l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtm, Long.valueOf(0L))).longValue();
        if ((bool1) && (l1 > 0L) && (System.currentTimeMillis() > l1))
        {
          Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
          bool1 = false;
          com.tencent.mm.aa.c.aFn().c(ar.a.Vtk, ar.a.Vtq);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtm, Long.valueOf(0L));
        }
        for (;;)
        {
          bool2 |= bool1;
          com.tencent.mm.kernel.h.aHH();
          String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtj, "");
          Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), str1 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
          if (bool2)
          {
            i = 1;
            label919:
            localh.a(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
            Log.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
            if ((!bool5) && (!bool3) && (j <= 0) && (!bool2) && (k != 1)) {
              break label1072;
            }
          }
          label1072:
          for (bool1 = true;; bool1 = false)
          {
            if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference)) {
              break label1078;
            }
            AppMethodBeat.o(33569);
            return;
            if (m == 1)
            {
              bool1 = false;
              bool2 = true;
              break;
            }
            if (m == 2)
            {
              bool1 = true;
              bool2 = false;
              break;
            }
            bool1 = false;
            bool2 = false;
            break;
            i = 0;
            break label919;
          }
          label1078:
          if (bool5) {
            if (!Util.isNullOrNil(str2))
            {
              localNormalIconNewTipPreference.auD(0);
              localNormalIconNewTipPreference.aU(str2, -1, -7566196);
              localNormalIconNewTipPreference.FT(true);
              localNormalIconNewTipPreference.aak(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwM, true);
              if (Util.isNullOrNil(str1)) {
                break label1531;
              }
              localObject = str1;
            }
          }
          label1531:
          for (;;)
          {
            if ((!ae.isNullOrNil((String)localObject)) && (bool2))
            {
              localNormalIconNewTipPreference.aF((CharSequence)localObject);
              AppMethodBeat.o(33569);
              return;
              localNormalIconNewTipPreference.hI("", -1);
              localNormalIconNewTipPreference.auD(8);
              localNormalIconNewTipPreference.aak(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwK, true);
              break;
              if (bool3)
              {
                localNormalIconNewTipPreference.abe(0);
                localNormalIconNewTipPreference.fC(getString(R.l.app_new), R.g.new_tips_bg);
                localNormalIconNewTipPreference.aak(8);
                com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwL, true);
                break;
              }
              if (j > 99)
              {
                localNormalIconNewTipPreference.abe(0);
                localNormalIconNewTipPreference.fC(getString(R.l.tab_msg_tip_over), com.tencent.mm.ui.tools.w.lE(getContext()));
                localNormalIconNewTipPreference.aak(8);
                com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwP, true);
                break;
              }
              if (j > 0)
              {
                localNormalIconNewTipPreference.abe(0);
                localNormalIconNewTipPreference.fC(String.valueOf(j), com.tencent.mm.ui.tools.w.bj(getContext(), j));
                localNormalIconNewTipPreference.aak(8);
                com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwP, true);
                break;
              }
              if (bool2)
              {
                localNormalIconNewTipPreference.fC("", -1);
                localNormalIconNewTipPreference.abe(8);
                localNormalIconNewTipPreference.aak(0);
                com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwK, true);
                break;
              }
              if (k == 1)
              {
                localNormalIconNewTipPreference.fC("", -1);
                localNormalIconNewTipPreference.abe(8);
                localNormalIconNewTipPreference.auD(0);
                localNormalIconNewTipPreference.FT(true);
                if (!ae.isNullOrNil(str3)) {
                  localNormalIconNewTipPreference.aU(str3, -1, Color.parseColor("#888888"));
                }
                localNormalIconNewTipPreference.auG(8);
                com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.GwM, true);
                break;
              }
              localNormalIconNewTipPreference.fC("", -1);
              localNormalIconNewTipPreference.abe(8);
              localNormalIconNewTipPreference.aak(8);
              localNormalIconNewTipPreference.auD(8);
              localNormalIconNewTipPreference.hI("", -1);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
              break;
            }
            localNormalIconNewTipPreference.aF("");
            AppMethodBeat.o(33569);
            return;
          }
        }
      }
    }
  }
  
  private void hIo()
  {
    AppMethodBeat.i(264638);
    if (getActivity() == null)
    {
      AppMethodBeat.o(264638);
      return;
    }
    boolean bool = t.gkZ();
    if (bool == this.WbZ)
    {
      AppMethodBeat.o(264638);
      return;
    }
    FC(bool);
    AppMethodBeat.o(264638);
  }
  
  private void hIp()
  {
    AppMethodBeat.i(33575);
    if (this.Wca)
    {
      AppMethodBeat.o(33575);
      return;
    }
    this.Wca = true;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.WbZ)
    {
      this.WbX = new View(getContext());
      this.DtO.addView(this.WbX, 0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.WbX.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.topMargin = ax.au(getContext()).x;
      this.WbX.setBackgroundColor(getResources().getColor(R.e.BG_0));
      ak.kU(getContext());
      final float f = com.tencent.mm.plugin.textstatus.a.a.is(getContext());
      this.WbV.setTranslationListener(new PullDownListView.a()
      {
        public final void bO(float paramAnonymousFloat)
        {
          AppMethodBeat.i(209797);
          if (!MoreTabUI.l(MoreTabUI.this))
          {
            AppMethodBeat.o(209797);
            return;
          }
          float f1 = paramAnonymousFloat / f;
          if (paramAnonymousFloat < 0.0F) {
            f1 = 0.0F;
          }
          if (paramAnonymousFloat > f) {
            f1 = 1.0F;
          }
          MoreTabUI.q(MoreTabUI.this).setTranslationY(paramAnonymousFloat);
          if (MoreTabUI.r(MoreTabUI.this) != null) {
            MoreTabUI.r(MoreTabUI.this).r(f1, paramAnonymousFloat, f);
          }
          Object localObject;
          if (MoreTabUI.s(MoreTabUI.this) != null)
          {
            localObject = MoreTabUI.s(MoreTabUI.this).RpB;
            if (localObject != null)
            {
              float f2 = 1.0F * (1.0F - f1);
              ((View)localObject).setAlpha(f2);
              localObject = MoreTabUI.s(MoreTabUI.this).RpC;
              if (localObject != null)
              {
                if (f2 > 0.0F) {
                  break label190;
                }
                ((View)localObject).setVisibility(0);
              }
            }
          }
          for (;;)
          {
            localObject = MoreTabUI.s(MoreTabUI.this).HaE;
            if (localObject != null) {
              ((com.tencent.mm.plugin.textstatus.a.e)localObject).r(f1, paramAnonymousFloat, f);
            }
            AppMethodBeat.o(209797);
            return;
            label190:
            ((View)localObject).setVisibility(8);
          }
        }
      });
      this.GXK = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getBackPreview(getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33535);
          if ((MoreTabUI.o(MoreTabUI.this) != null) && (!MoreTabUI.o(MoreTabUI.this).isVisible)) {
            MoreTabUI.o(MoreTabUI.this).idg();
          }
          AppMethodBeat.o(33535);
        }
      }, false);
      this.DtO.addView(this.GXK.getView(), 0);
      this.GXK.gkD();
      this.GXK.a(this);
      this.GXK.KN(com.tencent.mm.plugin.auth.a.a.crN());
    }
    do
    {
      this.WbY.hIq();
      AppMethodBeat.o(33575);
      return;
      this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.LEz, null);
    } while (this.storyGallery == null);
    this.storyGallery.gbl();
    this.Wch = (-(ax.au(getContext()).y / 10));
    if (this.Wci) {}
    for (int i = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlC);; i = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlB))
    {
      this.Wcg = i;
      this.Wcf = (-com.tencent.mm.ci.a.fromDPToPix(getContext(), 330));
      this.Wce = 0;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, ax.au(getContext()).y);
      localLayoutParams.topMargin = this.Wch;
      localLayoutParams.bottomMargin = (-ax.aB(getContext()));
      this.DtO.addView(this.storyGallery, 0, localLayoutParams);
      this.WbV.A(this.storyGallery, this.Wcg, this.Wch);
      this.WbV.setNavigationBarHeight(ax.aB(getActivity()));
      this.WbV.setTranslationListener(null);
      this.storyGallery.setDataSeed(z.bcZ());
      this.storyGallery.a(this.WbV);
      this.storyGallery.setStoryBrowseUIListener(this);
      break;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(264640);
    if (this.Wcc != null)
    {
      com.tencent.mm.plugin.textstatus.a.e locale = this.Wcc.HaE;
      if (locale != null) {
        locale.KN(com.tencent.mm.plugin.auth.a.a.crN());
      }
    }
    if (this.GXK != null) {
      this.GXK.KN(com.tencent.mm.plugin.auth.a.a.crN());
    }
    AppMethodBeat.o(264640);
  }
  
  public final void fpV()
  {
    AppMethodBeat.i(33584);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.WbV != null) && (!this.WbV.isVisible)) {
      this.WbV.idf();
    }
    if ((!o.isShowStoryCheck()) || (this.qoc)) {
      this.WbY.auf(2);
    }
    for (;;)
    {
      if (this.Wcc != null) {
        this.Wcc.hmH();
      }
      AppMethodBeat.o(33584);
      return;
      this.WbY.auf(1);
    }
  }
  
  public final void fpW()
  {
    AppMethodBeat.i(33585);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.WbV != null) && (this.WbV.isVisible) && (this.Wcj))
    {
      if (!this.qoc) {
        break label107;
      }
      this.WbY.auf(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.byG("settings_my_album");
      if (localIconPreference == null) {
        break label129;
      }
      if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vxi, true)) {
        break;
      }
      this.Wck = true;
      localIconPreference.aak(0);
      AppMethodBeat.o(33585);
      return;
      label107:
      this.WbY.auf(0);
    }
    this.Wck = false;
    localIconPreference.aak(8);
    label129:
    AppMethodBeat.o(33585);
  }
  
  public final void fpX()
  {
    AppMethodBeat.i(33586);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.WbV != null) && (!this.WbV.isVisible)) {
      this.WbV.idf();
    }
    aue(0);
    FE(this.Had);
    AppMethodBeat.o(33586);
  }
  
  public final void fpY()
  {
    AppMethodBeat.i(264641);
    Log.i("MicroMsg.MoreTabUI", "status statusUINoStatus");
    this.WbV.setSupportOverscroll(false);
    if ((this.WbV != null) && (!this.WbV.isVisible)) {
      this.WbV.idf();
    }
    this.WbY.auf(2);
    if (this.Wcc != null) {
      this.Wcc.hmH();
    }
    AppMethodBeat.o(264641);
  }
  
  public final void fpZ()
  {
    AppMethodBeat.i(264642);
    Log.i("MicroMsg.MoreTabUI", "statusUIHasStatus");
    if ((this.WbV != null) && (this.WbV.isVisible) && (this.Wcj))
    {
      if (this.qoc)
      {
        this.WbY.auf(2);
        AppMethodBeat.o(264642);
        return;
      }
      this.WbY.auf(3);
    }
    AppMethodBeat.o(264642);
  }
  
  final void fqb()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  public final int getResourceId()
  {
    return R.o.eXH;
  }
  
  public final void gkE()
  {
    AppMethodBeat.i(33583);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchOut");
    this.Wcj = false;
    if (this.WbV != null)
    {
      localObject = this.WbV;
      av.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).Yqr = false;
      if (!this.WbV.isVisible) {
        this.WbV.idf();
      }
    }
    if (this.GXK != null) {
      this.GXK.gkE();
    }
    if (this.GXE != null) {
      this.GXE.setVisibility(8);
    }
    aue(0);
    Object localObject = new yl();
    EventCenter.instance.publish((IEvent)localObject);
    FD(false);
    localObject = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.geY();
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(50);
    }
    this.Wct = true;
    AppMethodBeat.o(33583);
  }
  
  public final void gkF()
  {
    AppMethodBeat.i(33582);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.Wcj = true;
    hIo();
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.qoc = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label327;
        }
        bool = true;
        label79:
        this.Wcl = bool;
      }
    }
    else if (this.WbV != null)
    {
      localObject = this.WbV;
      av.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).Yqr = true;
      if ((!this.WbV.isVisible) || (this.WbV.getTranslationY() == 0.0F)) {
        break label332;
      }
      this.WbV.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.storyGallery != null) {
        this.storyGallery.gbk();
      }
      if (this.Wct) {}
      try
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.textstatus.proto.f)localObject).sessionId = com.tencent.mm.plugin.fts.a.d.Sx(1);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.MoreTabUI", localThrowable, "[handleTabSwitchOutForStatus]err", new Object[0]);
        }
      }
      updateStatus();
      if (this.GXK != null) {
        this.GXK.gkF();
      }
      this.Wct = false;
      FD(true);
      l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.RP(l);
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geX().gRi = l;
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geX().gSs = System.currentTimeMillis();
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(34);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).clickBottomTabRedDot();
      AppMethodBeat.o(33582);
      return;
      bool = false;
      break;
      label327:
      bool = false;
      break label79;
      label332:
      if (!this.WbV.isVisible) {
        this.WbV.idf();
      }
    }
  }
  
  protected final void hFb()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Log.i("MicroMsg.MoreTabUI", "onTabCreate:  %s", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.qoc = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label272;
      }
    }
    label272:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Wcl = bool1;
      this.screen = getPreferenceScreen();
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.cu(getContext());
      com.tencent.mm.kernel.h.aHH();
      this.GXE = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().ii(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.ci.a.aZ(getContext(), R.f.dlA), com.tencent.mm.ci.a.aZ(getContext(), R.f.dlA));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(R.h.pager).getParent()).addView(this.GXE, 0, (ViewGroup.LayoutParams)localObject);
      this.WbV.Yqv = this.mPullDownCallback;
      this.WbV.setPadding(this.WbV.getPaddingLeft(), this.WbV.getPaddingTop(), this.WbV.getPaddingRight(), this.WbW.getHeight());
      if (this.DtO != null)
      {
        Log.d("MicroMsg.MoreTabUI", "dancy test add view !");
        hIp();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void hFc()
  {
    AppMethodBeat.i(33577);
    Log.i("MicroMsg.MoreTabUI", "onTabResume:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (((this.screen instanceof com.tencent.mm.ui.base.preference.h)) && (((com.tencent.mm.ui.base.preference.h)this.screen).Wsm == 0L)) {
      ((com.tencent.mm.ui.base.preference.h)this.screen).Wsm = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    this.screen = getPreferenceScreen();
    hIo();
    bh.beI();
    com.tencent.mm.model.c.aHp().add(this);
    com.tencent.mm.aa.c.aFn().a(this.Jkk);
    hIk();
    Object localObject = (IconPreference)this.screen.byG("settings_my_address");
    if (localObject != null)
    {
      int i = com.tencent.mm.bl.d.bqc().hze();
      if (i > 0)
      {
        ((IconPreference)localObject).abe(0);
        ((IconPreference)localObject).fC(String.valueOf(i), R.g.new_tips_bg);
      }
    }
    else
    {
      hIh();
      if (!((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderSwitchApi().edO()) {
        break label751;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
      this.screen.dz("settings_my_finder_album", false);
      localObject = (NormalIconTipPreference)this.screen.byG("settings_my_finder_album");
      if (!ae.isNullOrNil(z.bdh())) {
        break label740;
      }
      ((NormalIconTipPreference)localObject).byK(getString(R.l.settings_my_album_finder_no_account));
      label271:
      if (this.xnQ == null)
      {
        this.xnQ = new s() {};
        localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        com.tencent.mm.plugin.finder.extension.reddot.h.dqQ().a(this, this.xnQ);
      }
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.aBk("ProfileEntrance");
      label317:
      hIl();
      hIj();
      if (com.tencent.mm.by.c.blP("favorite")) {
        break label768;
      }
      this.screen.dz("settings_mm_favorite", true);
      label348:
      hIn();
      hIm();
      hIi();
      if (!com.tencent.mm.kernel.h.aHC().ad(com.tencent.mm.plugin.as.a.a.class)) {
        break label785;
      }
      this.screen.dz("more_uishow", false);
      label386:
      localObject = this.screen.byG("settings_privacy_agreements");
      if (!com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
        break label802;
      }
      String str = getString(R.l.privacy_detail);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
      localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.link_color)), localSpannable.length() - str.length(), localSpannable.length(), 33);
      ((Preference)localObject).setTitle(localSpannable);
      this.screen.dz("settings_privacy_agreements", false);
      label508:
      thisActivity().supportInvalidateOptionsMenu();
      this.screen.notifyDataSetChanged();
      localObject = findViewById(R.h.loading_tips_area);
      if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(275967);
            this.VUC.setVisibility(8);
            this.VUC.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), R.a.fast_faded_out));
            AppMethodBeat.o(275967);
          }
        });
      }
      if ((this.WbV != null) && (this.WbV.isVisible))
      {
        aue(0);
        Log.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
      }
      if (this.storyGallery != null)
      {
        this.storyGallery.onResume();
        this.storyGallery.gbk();
      }
      updateStatus();
      if (this.Wcc != null)
      {
        localObject = this.Wcc;
        if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.aa.c.aFn().dj(352279, 266241))) {
          break label819;
        }
      }
    }
    label768:
    label785:
    label802:
    label819:
    for (boolean bool = true;; bool = false)
    {
      ((AccountInfoPreference)localObject).RpK = bool;
      this.Wcc.hmI();
      Log.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      ((IconPreference)localObject).abe(8);
      ((IconPreference)localObject).fC("", -1);
      break;
      label740:
      ((NormalIconTipPreference)localObject).byK("");
      break label271;
      label751:
      this.screen.dz("settings_my_finder_album", true);
      break label317;
      this.screen.dz("settings_mm_favorite", false);
      break label348;
      this.screen.dz("more_uishow", true);
      break label386;
      this.screen.dz("settings_privacy_agreements", true);
      break label508;
    }
  }
  
  protected final void hFd()
  {
    AppMethodBeat.i(33578);
    if (this.storyGallery != null) {
      this.storyGallery.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void hFe()
  {
    AppMethodBeat.i(33579);
    Log.d("MicroMsg.MoreTabUI", "onTabPause %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.aa.c.aFn().b(this.Jkk);
    bh.beI();
    com.tencent.mm.model.c.aHp().remove(this);
    if (this.storyGallery != null) {
      this.storyGallery.onPause();
    }
    if (this.WbV != null)
    {
      if ((this.WbV.isVisible) || (this.Had)) {
        break label153;
      }
      this.WbV.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33538);
          MoreTabUI.o(MoreTabUI.this).idf();
          AppMethodBeat.o(33538);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.Wcc != null) {
        this.Wcc.hmH();
      }
      FD(false);
      if (this.Wcn != null)
      {
        this.Wcn.WcB = null;
        this.Wcn = null;
      }
      AppMethodBeat.o(33579);
      return;
      label153:
      if ((this.WbV.isVisible) && (this.WbV.getTranslationY() != 0.0F)) {
        this.WbV.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void hFf()
  {
    AppMethodBeat.i(33580);
    if (this.storyGallery != null) {
      this.storyGallery.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void hFg()
  {
    AppMethodBeat.i(33581);
    Log.i("MicroMsg.MoreTabUI", "onTabDestroy:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.storyGallery != null) {
      this.storyGallery.onDestroy();
    }
    if (this.Wcc != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.Wcc;
      if (localAccountInfoPreference.vkO) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().gW(localAccountInfoPreference.RpG);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void hFi() {}
  
  public final void hFj() {}
  
  public final void hFl() {}
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(33561);
    Log.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = getPreferenceScreen();
    this.screen.dz("more_setting", true);
    this.screen.dz("settings_emoji_store", true);
    this.screen.dz("settings_mm_wallet", true);
    this.screen.dz("settings_mm_cardpackage", true);
    this.screen.dz("settings_mm_favorite", true);
    this.screen.dz("settings_my_album", true);
    this.screen.dz("settings_my_finder_album", true);
    this.screen.dz("settings_my_address", true);
    this.screen.dz("more_tab_setting_personal_info", true);
    this.screen.dz("more_uishow", true);
    this.screen.dz("settings_privacy_agreements", true);
    this.WbW = getView().getRootView().findViewById(R.h.dKR);
    this.DtO = ((RelativeLayout)findViewById(R.h.preference_page));
    this.WbV = ((PullDownListView)getListView());
    this.WbV.setTabView(this.WbW);
    this.WbV.setBackground(aw.bf(getContext(), R.d.me_alpha_bg));
    this.WbV.setOnScrollListener(new AbsListView.OnScrollListener()
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
    Log.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
    if (this.WbZ)
    {
      if (paramConfiguration.orientation == 1)
      {
        this.qoc = false;
        FC(t.gkZ());
        if (this.WbV != null) {
          this.WbY.hIq();
        }
        if (this.WbX != null)
        {
          if (!this.qoc) {
            break label152;
          }
          this.WbX.setVisibility(8);
        }
      }
      for (;;)
      {
        updateStatus();
        AppMethodBeat.o(33573);
        return;
        if (paramConfiguration.orientation != 2) {
          break;
        }
        this.qoc = true;
        if (this.WbV == null) {
          break;
        }
        if (!this.WbV.isVisible)
        {
          this.WbV.idg();
          FC(t.gkZ());
        }
        this.WbY.auf(2);
        break;
        label152:
        this.WbX.setVisibility(0);
      }
    }
    if (paramConfiguration.orientation == 1)
    {
      this.qoc = false;
      if (this.WbV != null) {
        this.WbY.hIq();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label356;
      }
    }
    for (;;)
    {
      if (bool != this.Wcl)
      {
        this.Wcl = bool;
        if ((this.storyGallery != null) && (this.DtO != null) && (this.WbV != null))
        {
          this.storyGallery.onDestroy();
          this.DtO.removeView(this.storyGallery);
          hIp();
          this.storyGallery.onResume();
          if (!this.WbV.isVisible)
          {
            this.WbV.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284610);
                MoreTabUI.o(MoreTabUI.this).idf();
                AppMethodBeat.o(284610);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.qoc = true;
            if (this.WbV == null) {
              break;
            }
            if (!this.WbV.isVisible) {
              this.WbV.idf();
            }
            this.WbY.auf(2);
            break;
            label356:
            bool = false;
            continue;
          }
          if ((this.WbV.isVisible) && (this.WbV.getTranslationY() != 0.0F)) {
            this.WbV.setTranslationY(0.0F);
          }
        }
      }
    }
    AppMethodBeat.o(33573);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bool = true;
    AppMethodBeat.i(33556);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MoreTabUI", "onCreate:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if ((!bh.aHB()) || (bh.aGE()))
    {
      Log.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(bh.aHB()), Boolean.valueOf(bh.aGE()) });
      AppMethodBeat.o(33556);
      return;
    }
    this.WbZ = t.gkZ();
    hIg();
    FD(false);
    for (;;)
    {
      try
      {
        paramBundle = getContext();
        if (paramBundle != null) {
          continue;
        }
        if (getActivity() == null) {
          continue;
        }
        Log.e("MicroMsg.MoreTabUI", "context is null : getActivity valid =%s", new Object[] { Boolean.valueOf(bool) });
      }
      catch (Throwable paramBundle)
      {
        com.tencent.mm.ui.component.g localg;
        Log.printErrStackTrace("MicroMsg.MoreTabUI", paramBundle, "[initStatusReportData]err", new Object[0]);
        continue;
        bool = false;
        continue;
      }
      if (getBounceView() != null) {
        getBounceView().setStart2EndBgColor(getResources().getColor(R.e.BG_2));
      }
      AppMethodBeat.o(33556);
      return;
      bool = false;
      continue;
      localg = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.g.lm(paramBundle).i(com.tencent.mm.plugin.secdata.ui.a.class)).a(new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.f.class, 9));
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramBundle = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if (paramBundle != null) {
        paramBundle.sessionId = com.tencent.mm.plugin.fts.a.d.Sx(1);
      }
      if (paramBundle == null) {
        continue;
      }
      bool = true;
      Log.i("MicroMsg.MoreTabUI", "initStatusReportData : data valid = %s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33560);
    super.onDestroy();
    Log.i("MicroMsg.MoreTabUI", "onDestroy:  %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.finder.extension.reddot.h localh = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.dqQ().b(this.xnQ);
    AppMethodBeat.o(33560);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33588);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.storyGallery != null)) {}
    for (boolean bool = this.storyGallery.onBackPressed();; bool = false)
    {
      Log.d("MicroMsg.MoreTabUI", "onBackPressed: %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) || (super.onKeyDown(paramInt, paramKeyEvent)))
      {
        AppMethodBeat.o(33588);
        return true;
      }
      AppMethodBeat.o(33588);
      return false;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33570);
    int i = ae.cl(paramObject);
    Log.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.beI();
    if ((paramMStorageEx != com.tencent.mm.model.c.aHp()) || (i <= 0))
    {
      Log.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      hIn();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      hIm();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      hIl();
    }
    AppMethodBeat.o(33570);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33558);
    super.onPause();
    Log.i("MicroMsg.MoreTabUI", "onPause:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.Wcj)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geY();
    }
    if (this.GXK != null) {
      this.GXK.gkK();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (localObject = "null";; localObject = paramPreference.mKey)
    {
      Log.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.h.aHB()) {
        break;
      }
      Log.w("MicroMsg.MoreTabUI", "account has not already!");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_address"))
    {
      paramf = new Intent(getContext(), AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.by.c.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      if (!WeChatBrands.Business.Entries.MePayment.checkAvailable(getActivity()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      com.tencent.mm.plugin.newtips.a.fiO().aap(13);
      bool1 = com.tencent.mm.aa.c.aFn().dj(262156, 266248);
      boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262156, 266248);
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.a(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.h.IzE.a(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new te();
        paramPreference.fSz.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.fSz.intent = ((Intent)localObject);
        EventCenter.instance.publish(paramPreference);
        com.tencent.mm.aa.c.aFn().dl(262156, 266248);
        com.tencent.mm.aa.c.aFn().c(ar.a.VrE, ar.a.VrG);
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VqT, "");
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VqU, Integer.valueOf(-1));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtg, Boolean.FALSE);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtc, "");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtd, Boolean.FALSE);
        com.tencent.mm.aa.c.aFn().c(ar.a.Vtk, ar.a.Vtq);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtj, "");
        paramf = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool2) {
          break label792;
        }
      }
      label792:
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        i = 0;
        break;
      }
    }
    if (paramPreference.mKey.equals("settings_mm_cardpackage"))
    {
      if (!WeChatBrands.Business.Entries.MeCouponCard.checkAvailable(getActivity()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      com.tencent.mm.plugin.newtips.a.fiO().aap(14);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VhT, "");
      new Intent().putExtra("key_from_scene", 22);
      Log.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new lc();
      paramf.fIO.context = getContext();
      paramf.fIO.enterScene = 1;
      EventCenter.instance.publish(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        com.tencent.mm.ui.base.w.g(getContext(), null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        bh.beI();
        paramf = (String)com.tencent.mm.model.c.aHp().b(2, null);
        paramPreference = new Intent(getContext(), AlbumUI.class);
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.putExtra("username", paramf);
        paramPreference.putExtra("story_dot", this.Wck);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        bh.beI();
        i = ae.l((Integer)com.tencent.mm.model.c.aHp().b(68389, null));
        bh.beI();
        com.tencent.mm.model.c.aHp().i(68389, Integer.valueOf(i + 1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22208(12L, "");
      }
    }
    if (paramPreference.mKey.equals("settings_my_finder_album"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
      paramf = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().aBe("ProfileEntrance");
      paramPreference = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().aBf("ProfileEntrance");
      if ((paramf != null) && (paramPreference != null)) {
        com.tencent.mm.plugin.finder.report.l.zWx.a("12", paramPreference, paramf, 2, "", 0);
      }
      ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().aBd("ProfileEntrance");
      paramf = new Intent();
      ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderSelfProfile(getContext(), paramf, 13, 2);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.h.IzE.a(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.xwebutil.c.ikh();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "7");
      com.tencent.mm.aa.c.aFn().dl(262147, 266244);
      com.tencent.mm.aa.c.aFn().dl(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.by.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.h.IzE.a(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).fA(com.tencent.mm.plugin.boots.a.b.smy, 881);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      com.tencent.mm.plugin.newtips.a.fiO().aap(30);
      bool1 = com.tencent.mm.aa.c.aFn().dj(262145, 266242);
      com.tencent.mm.aa.c.aFn().dl(262145, 266242);
      com.tencent.mm.aa.c.aFn().dl(262157, 266261);
      com.tencent.mm.aa.c.aFn().dl(262158, 266264);
      com.tencent.mm.aa.c.aFn().b(ar.a.Vuw, 266242);
      com.tencent.mm.aa.c.aFn().dl(262164, 266268);
      paramPreference = new Intent();
      com.tencent.mm.by.c.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      bh.beI();
      i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VoP, Integer.valueOf(0))).intValue();
      bh.beI();
      int j = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VoQ, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.VoQ, Integer.valueOf(i));
        paramf = (IconPreference)paramf.byG("more_setting");
        if (paramf != null) {
          paramf.aak(8);
        }
        com.tencent.mm.aa.c.aFn().dl(266260, 266241);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.ODT = new MoreTabUI.11(this);
      paramf.ODU = new q.g()
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
            MoreTabUI.h(MoreTabUI.this);
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.i(MoreTabUI.this);
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.j(MoreTabUI.this);
            AppMethodBeat.o(33545);
            return;
            MoreTabUI.k(MoreTabUI.this);
          }
        }
      };
      paramf.eik();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.sdk.b.a.b(getActivity(), getString(R.l.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.kernel.h.aHG().aHp().b(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
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
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.MoreTabUI", "account has not already!");
      AppMethodBeat.o(33562);
      return true;
    }
    boolean bool;
    try
    {
      if ((WeChatEnvironment.isMonkeyEnv()) || (WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
      {
        if (Util.nullAsNil(paramPreference.mKey).equals("settings_emoji_store"))
        {
          bool = FB(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (Util.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = FB(false);
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
    Log.i("MicroMsg.MoreTabUI", "onResume:  %s", new Object[] { Integer.valueOf(hashCode()) });
    hIg();
    if (this.Wcj)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.RP(l);
      localh = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geX().gRi = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  static final class a
    implements i.a
  {
    IconPreference WcB;
    
    public a(IconPreference paramIconPreference)
    {
      this.WcB = paramIconPreference;
    }
    
    public final void e(com.tencent.mm.plugin.newtips.b.a parama)
    {
      AppMethodBeat.i(270598);
      if ((parama != null) && (parama.field_tipId == com.tencent.mm.plugin.newtips.a.d.Gwf))
      {
        com.tencent.mm.plugin.newtips.a.fiR();
        if (com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwf))
        {
          this.WcB.aak(0);
          this.WcB.abe(8);
          this.WcB.fC("", -1);
          AppMethodBeat.o(270598);
          return;
        }
      }
      AppMethodBeat.o(270598);
    }
  }
  
  final class c
  {
    private int status = 2;
    
    private c() {}
    
    public final void auf(int paramInt)
    {
      AppMethodBeat.i(33554);
      Log.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0)
      {
        MoreTabUI.e(MoreTabUI.this, true);
        if (paramInt != 3) {
          break label77;
        }
        MoreTabUI.d(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        fqd();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.e(MoreTabUI.this, false);
        break;
        label77:
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void fqd()
    {
      boolean bool = true;
      AppMethodBeat.i(33552);
      Log.i("MicroMsg.MoreTabUI", "updateUIByStory status:%s", new Object[] { Integer.valueOf(this.status) });
      if (MoreTabUI.this.getActivity() == null)
      {
        AppMethodBeat.o(33552);
        return;
      }
      if (this.status == 3)
      {
        MoreTabUI.o(MoreTabUI.this).setSelector(R.e.BG_0);
        if (MoreTabUI.this.getBounceView() != null) {
          MoreTabUI.this.getBounceView().HO(false);
        }
        switch (this.status)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33552);
        return;
        MoreTabUI.o(MoreTabUI.this).setSelector(R.e.transparent);
        if (MoreTabUI.this.getBounceView() == null) {
          break;
        }
        MoreTabUI.this.getBounceView().HO(true);
        break;
        if ((MoreTabUI.r(MoreTabUI.this) != null) && (MoreTabUI.r(MoreTabUI.this).gkG())) {}
        for (;;)
        {
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(bool);
          MoreTabUI.o(MoreTabUI.this).setBackground(null);
          MoreTabUI.o(MoreTabUI.this).setMuteView(null);
          MoreTabUI.o(MoreTabUI.this).ayC(com.tencent.mm.plugin.textstatus.a.a.is(MoreTabUI.this.getActivity()));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.B(MoreTabUI.this));
          if (MoreTabUI.s(MoreTabUI.this) == null) {
            break;
          }
          MoreTabUI.s(MoreTabUI.this).n(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          bool = false;
        }
        MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(true);
        MoreTabUI.w(MoreTabUI.this);
        if (MoreTabUI.v(MoreTabUI.this)) {
          MoreTabUI.o(MoreTabUI.this).setBackground(aw.bf(MoreTabUI.this.getContext(), R.d.me_normal_bg));
        }
        for (;;)
        {
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.C(MoreTabUI.this);
            MoreTabUI.o(MoreTabUI.this).A(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.C(MoreTabUI.this));
          }
          MoreTabUI.o(MoreTabUI.this).setMuteView(null);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.a(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          if (MoreTabUI.s(MoreTabUI.this) != null) {
            MoreTabUI.s(MoreTabUI.this).n(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          }
          MoreTabUI.o(MoreTabUI.this).icZ();
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.o(MoreTabUI.this).setBackground(aw.bf(MoreTabUI.this.getContext(), R.d.me_alpha_bg));
        }
        MoreTabUI.o(MoreTabUI.this).setBackground(aw.bf(MoreTabUI.this.getContext(), R.d.me_alpha_bg));
        MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.E(MoreTabUI.this);
        MoreTabUI.b(MoreTabUI.this, com.tencent.mm.ci.a.aZ(MoreTabUI.this.getContext(), R.f.dlB));
        if (MoreTabUI.m(MoreTabUI.this) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.F(MoreTabUI.this);
          MoreTabUI.o(MoreTabUI.this).A(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.F(MoreTabUI.this));
        }
        MoreTabUI.o(MoreTabUI.this).setMuteView(MoreTabUI.A(MoreTabUI.this));
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.a(MoreTabUI.this, 0);
        MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.o(MoreTabUI.this).icZ();
        if (MoreTabUI.s(MoreTabUI.this) != null)
        {
          MoreTabUI.s(MoreTabUI.this).n(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.o(MoreTabUI.this).setBackground(aw.bf(MoreTabUI.this.getContext(), R.d.me_normal_bg));
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.o(MoreTabUI.this).icZ();
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.t(MoreTabUI.this);
          if (MoreTabUI.s(MoreTabUI.this) != null) {
            MoreTabUI.s(MoreTabUI.this).n(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void hIq()
    {
      AppMethodBeat.i(33553);
      if (MoreTabUI.l(MoreTabUI.this))
      {
        if (MoreTabUI.p(MoreTabUI.this))
        {
          MoreTabUI.d(MoreTabUI.this, false);
          this.status = 2;
        }
        for (;;)
        {
          MoreTabUI.e(MoreTabUI.this, false);
          Log.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
          fqd();
          AppMethodBeat.o(33553);
          return;
          if (((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.crN()))
          {
            MoreTabUI.d(MoreTabUI.this, true);
            this.status = 3;
          }
          else
          {
            MoreTabUI.d(MoreTabUI.this, false);
            this.status = 2;
          }
        }
      }
      if ((!o.isShowStoryCheck()) || (MoreTabUI.p(MoreTabUI.this)))
      {
        MoreTabUI.e(MoreTabUI.this, false);
        this.status = 2;
      }
      for (;;)
      {
        MoreTabUI.d(MoreTabUI.this, false);
        break;
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(z.bcZ()))
        {
          MoreTabUI.e(MoreTabUI.this, true);
          this.status = 0;
        }
        else
        {
          MoreTabUI.e(MoreTabUI.this, false);
          this.status = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */