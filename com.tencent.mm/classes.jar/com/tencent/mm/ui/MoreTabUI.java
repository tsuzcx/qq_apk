package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
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
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.i.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bdo;
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
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.NormalIconTipPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import com.tencent.mm.y.a.a;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.e, MStorageEx.IOnStorageChange
{
  private AbsStoryGallery BdF;
  private AbsStoryMuteView BdG;
  private com.tencent.mm.plugin.textstatus.a.b BdM;
  private View BdR;
  private boolean Bgv;
  private boolean Bgw;
  private byte[] CYQ;
  private a.a DeE;
  private Bitmap FNn;
  private RelativeLayout KoQ;
  private FrameLayout KoR;
  private LinearLayout KoS;
  private boolean KoT;
  PullDownListView OIC;
  private View OID;
  private View OIE;
  private b OIF;
  private boolean OIG;
  private boolean OIH;
  private boolean OII;
  private AccountInfoPreference OIJ;
  private RelativeLayout OIK;
  private int OIL;
  private int OIM;
  private int OIN;
  private int OIO;
  private boolean OIP;
  private boolean OIQ;
  private boolean OIR;
  private boolean OIS;
  private com.tencent.mm.av.a.c.h OIT;
  public boolean OIU;
  private boolean OIV;
  public boolean OIW;
  private int OIX;
  private int OIY;
  private MoreTabUI.a OIZ;
  private boolean UuP;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private boolean nmu;
  private com.tencent.mm.ui.base.preference.f screen;
  private RelativeLayout zWu;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.FNn = null;
    this.CYQ = null;
    this.BdG = null;
    this.zWu = null;
    this.OID = null;
    this.BdF = null;
    this.BdM = null;
    this.OIE = null;
    this.OIF = new b((byte)0);
    this.Bgv = false;
    this.Bgw = false;
    this.OIG = false;
    this.OIH = false;
    this.OII = false;
    this.OIJ = null;
    this.KoT = false;
    this.KoQ = null;
    this.KoR = null;
    this.OIK = null;
    this.KoS = null;
    this.OIL = 0;
    this.OIM = 0;
    this.OIN = 0;
    this.OIO = 0;
    this.nmu = false;
    this.OIP = false;
    this.OIQ = false;
    this.OIR = false;
    this.OIS = false;
    this.DeE = new a.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString)
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
          } else if ((paramAnonymousInt == 352280) && (MoreTabUI.f(MoreTabUI.this)) && (com.tencent.mm.y.c.axV().axS())) {
            com.tencent.mm.y.c.axV().B(352280, false);
          }
        }
      }
      
      public final void b(ar.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == ar.a.NTN) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.g(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == ar.a.NTO) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == ar.a.Odt) || (paramAnonymousa == ar.a.OeY)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == ar.a.Ogg) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.OIT = new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.OJc.alH(0);
            this.OJc.alG(2131234198);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.g(MoreTabUI.this).bmg("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.aL(this.jUL);
              paramAnonymousString.alH(0);
              AppMethodBeat.o(33540);
            }
          });
          AppMethodBeat.o(33543);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33541);
            paramAnonymousString.aL(null);
            paramAnonymousString.alH(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
    };
    this.OIU = true;
    this.OIV = true;
    this.OIW = true;
    this.OIX = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    this.OIY = com.tencent.mm.cb.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void UC(int paramAnonymousInt)
      {
        AppMethodBeat.i(232659);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).aaB(paramAnonymousInt);
        }
        AppMethodBeat.o(232659);
      }
      
      public final void UD(int paramAnonymousInt)
      {
        AppMethodBeat.i(232660);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).aaC(paramAnonymousInt);
        }
        AppMethodBeat.o(232660);
      }
      
      public final void UE(int paramAnonymousInt)
      {
        AppMethodBeat.i(232661);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).UE(paramAnonymousInt);
        }
        AppMethodBeat.o(232661);
      }
      
      public final void eEk()
      {
        boolean bool = true;
        AppMethodBeat.i(232655);
        Object localObject;
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreOpen, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).eEk();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                localObject = MoreTabUI.s(MoreTabUI.this).BgU;
                if (localObject != null) {
                  ((com.tencent.mm.plugin.textstatus.a.d)localObject).eEk();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).KoU = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(232655);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).fmO();
          }
          if ((MoreTabUI.f(MoreTabUI.this)) && (!MoreTabUI.n(MoreTabUI.this)))
          {
            localObject = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqB().eRY = System.currentTimeMillis();
            localObject = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqC();
          }
        }
      }
      
      public final void eEl()
      {
        boolean bool = true;
        AppMethodBeat.i(232656);
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).eEl();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                com.tencent.mm.plugin.textstatus.a.d locald = MoreTabUI.s(MoreTabUI.this).BgU;
                if (locald != null) {
                  locald.eEl();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).KoU = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(232656);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).fmP();
          }
        }
      }
      
      public final void eEm()
      {
        AppMethodBeat.i(232657);
        Log.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.A(MoreTabUI.this).fmV();
        AppMethodBeat.o(232657);
      }
      
      public final void eEn()
      {
        AppMethodBeat.i(232658);
        MoreTabUI.A(MoreTabUI.this).fmW();
        AppMethodBeat.o(232658);
      }
      
      public final void onPostClose()
      {
        boolean bool = true;
        AppMethodBeat.i(232654);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        if (MoreTabUI.l(MoreTabUI.this))
        {
          if (MoreTabUI.r(MoreTabUI.this) == null) {}
          for (;;)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPostClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).onPostClose();
            }
            if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
              MoreTabUI.s(MoreTabUI.this).grG();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V");
            AppMethodBeat.o(232654);
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
            MoreTabUI.m(MoreTabUI.this).vI(true);
            MoreTabUI.m(MoreTabUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232652);
                MoreTabUI.x(MoreTabUI.this);
                MoreTabUI.a(MoreTabUI.this, 0);
                MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
                if (MoreTabUI.y(MoreTabUI.this) != null) {
                  MoreTabUI.y(MoreTabUI.this).setTranslationY(0.0F);
                }
                AppMethodBeat.o(232652);
              }
            });
          }
          MoreTabUI.a(MoreTabUI.this, false);
          MoreTabUI.z(MoreTabUI.this).eEj();
          if ((!MoreTabUI.f(MoreTabUI.this)) || (MoreTabUI.n(MoreTabUI.this))) {
            break;
          }
          long l = System.currentTimeMillis();
          com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.Kv(l);
          localh = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqB().eQM = l;
          break;
        }
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232653);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).en(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (MoreTabUI.l(MoreTabUI.this))
        {
          if (MoreTabUI.r(MoreTabUI.this) == null) {}
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPostOpen, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).onPostOpen(paramAnonymousBoolean);
            }
            MoreTabUI.a(MoreTabUI.this, 8);
            if (MoreTabUI.s(MoreTabUI.this) != null) {
              MoreTabUI.s(MoreTabUI.this).grF();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
            AppMethodBeat.o(232653);
            return;
          }
        }
        if (MoreTabUI.m(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().eQv = 1L;
            localObject = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqi().eRT = 1L;
            MoreTabUI.m(MoreTabUI.this).ar(paramAnonymousBoolean, true);
            MoreTabUI.a(MoreTabUI.this, 8);
            MoreTabUI.t(MoreTabUI.this);
            MoreTabUI.u(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if ((MoreTabUI.n(MoreTabUI.this)) || (MoreTabUI.v(MoreTabUI.this))) {
            break;
          }
          int i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.OiJ, 0);
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OiJ, Integer.valueOf(i + 1));
          MoreTabUI.w(MoreTabUI.this);
          break;
        }
      }
    };
    this.UuP = false;
    this.OIZ = new MoreTabUI.a(this);
    AppMethodBeat.o(33555);
  }
  
  private boolean Bl(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.w.c.nFD.a(com.tencent.mm.plugin.appbrand.w.c.a.nFH);
    com.tencent.mm.plugin.appbrand.w.c.nFD.a(com.tencent.mm.plugin.appbrand.w.c.a.nFT);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.br.c.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void Bm(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.BdR == null)
      {
        View localView = findViewById(2131296366);
        if (localView != null) {
          this.BdR = localView.findViewById(2131296363);
        }
        if (this.BdR == null) {
          break label105;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.BdR == null) {
          break label118;
        }
        if (!paramBoolean) {
          break;
        }
        this.BdR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(232663);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.p(MoreTabUI.this)) {
              u.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131766547), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(232663);
              return;
              if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
                MoreTabUI.o(MoreTabUI.this).hbY();
              }
            }
          }
        });
        AppMethodBeat.o(33587);
        return;
        label105:
        bool = false;
      }
      this.BdR.setOnClickListener(null);
    }
    label118:
    AppMethodBeat.o(33587);
  }
  
  private void Bn(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.OIC != null) && (this.OIC.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().Bf(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  private void alh(int paramInt)
  {
    AppMethodBeat.i(33576);
    View localView = findViewById(2131296366);
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      Log.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(33576);
      return;
    }
    Log.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
    AppMethodBeat.o(33576);
  }
  
  private void gJi()
  {
    AppMethodBeat.i(33559);
    if (!this.OIP)
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.OiJ, 0);
      boolean bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oiw, false);
      Log.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.Bgv) && ((bool) || (i > 0)))
      {
        this.OIP = true;
        if (this.OIJ != null) {
          this.OIJ.p(this.Bgv, this.OIP, this.Bgw);
        }
        if (!this.OIP) {
          break label150;
        }
      }
    }
    label150:
    for (int i = com.tencent.mm.cb.a.aH(getContext(), 2131166842);; i = com.tencent.mm.cb.a.aH(getContext(), 2131166841))
    {
      this.OIN = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void gJj()
  {
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.br.c.aZU("sns"))
    {
      this.screen.jdMethod_do("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.jdMethod_do("settings_my_album", false);
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_my_album");
    if (localIconPreference != null)
    {
      if ((com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OiS, true)) && (this.OIR))
      {
        localIconPreference.alF(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.OIR = false;
      localIconPreference.alF(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void gJk()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.card.c.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.c.b)localObject1).cuq()) && (!((com.tencent.mm.plugin.card.c.b)localObject1).cur())) || (!com.tencent.mm.br.c.aZU("card")))
    {
      this.screen.jdMethod_do("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.c.b)localObject1).cus();; localObject1 = "")
    {
      this.screen.jdMethod_do("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bmg("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.y.c.axV().cP(262152, 266256);
      boolean bool3 = com.tencent.mm.y.c.axV().cO(262152, 266256);
      boolean bool4 = com.tencent.mm.y.c.axV().a(ar.a.NTN, ar.a.NTP);
      boolean bool5 = com.tencent.mm.y.c.axV().a(ar.a.NTO, ar.a.NTQ);
      bg.aVF();
      String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NTW, "");
      localNormalIconNewTipPreference.setTitle(2131765449);
      com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.exl().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.Akx = this.OIT;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.alD(0);
        localNormalIconNewTipPreference.gY(getString(2131755915), 2131234232);
        localNormalIconNewTipPreference.alF(8);
        localNormalIconNewTipPreference.setSummary(null);
        localNormalIconNewTipPreference.aL(null);
        localNormalIconNewTipPreference.alH(8);
        localNormalIconNewTipPreference.gZ("", -1);
        localNormalIconNewTipPreference.alE(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADH, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(2131165997);
        Object localObject2 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aKJ();
        q.bcW();
        ((com.tencent.mm.av.a.a.c.a)localObject2).jbw = null;
        ((com.tencent.mm.av.a.a.c.a)localObject2).jbf = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).iaT = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).jbd = true;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hZA = i;
        ((com.tencent.mm.av.a.a.c.a)localObject2).hZz = i;
        localObject2 = ((com.tencent.mm.av.a.a.c.a)localObject2).bdv();
        q.bcV().a(str, localNormalIconNewTipPreference.gLG(), (com.tencent.mm.av.a.a.c)localObject2, this.OIT);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADJ, true);
        if (!bool2) {
          break label633;
        }
        localNormalIconNewTipPreference.alF(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADG, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.gY("", -1);
          localNormalIconNewTipPreference.alD(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.setSummary(null);
            if (!af.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.aS((String)localObject1, -1, getResources().getColor(2131100594));
              localNormalIconNewTipPreference.alE(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADI, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.aL(null);
              localNormalIconNewTipPreference.alH(8);
              break;
              label633:
              localNormalIconNewTipPreference.alF(8);
              continue;
            }
            localNormalIconNewTipPreference.gZ("", -1);
            localNormalIconNewTipPreference.alE(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.gZ("", -1);
          localNormalIconNewTipPreference.alE(8);
          if (!af.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADI, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.setSummary(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.alE(8);
      localNormalIconNewTipPreference.alD(8);
      localNormalIconNewTipPreference.setSummary(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void gJl()
  {
    AppMethodBeat.i(33566);
    this.screen.jdMethod_do("more_setting", false);
    final IconPreference localIconPreference = (IconPreference)this.screen.bmg("more_setting");
    boolean bool;
    if (localIconPreference != null)
    {
      localIconPreference.alI(8);
      bool = com.tencent.mm.y.c.axV().cO(262145, 266242);
      if (bool)
      {
        localIconPreference.alD(0);
        localIconPreference.gY(getString(2131755915), 2131234232);
      }
      for (;;)
      {
        localIconPreference.alF(8);
        if (!bool) {
          break;
        }
        AppMethodBeat.o(33566);
        return;
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
      }
      bg.aVF();
      i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.OaN, Integer.valueOf(0))).intValue();
      bg.aVF();
      int j = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.OaO, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class)).gji()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class)).gjj()) || (i > j)) && (!bool))
      {
        localIconPreference.alF(0);
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.alF(8);
      if (com.tencent.mm.y.c.axV().cP(262157, 266261))
      {
        localIconPreference.alF(0);
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.alF(8);
      if (com.tencent.mm.y.c.axV().cP(262164, 266268))
      {
        localIconPreference.alF(0);
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.alF(8);
      if (com.tencent.mm.y.c.axV().cP(262158, 266264))
      {
        localIconPreference.alF(0);
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
        AppMethodBeat.o(33566);
        return;
      }
      if (com.tencent.mm.y.c.axV().a(ar.a.Ogg, 266242))
      {
        localIconPreference.alF(0);
        AppMethodBeat.o(33566);
        return;
      }
      localIconPreference.alF(8);
      bg.aVF();
      if ((com.tencent.mm.model.c.azQ().getInt(40, 0) & 0x20000) != 0) {
        break label662;
      }
    }
    label662:
    for (int i = 1;; i = 0)
    {
      if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1) {
        bg.aVF();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NTp, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          Log.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          localIconPreference.alF(0);
          AppMethodBeat.o(33566);
          return;
        }
        localIconPreference.alF(8);
        com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.exm().TF(com.tencent.mm.plugin.newtips.a.d.ADb);
        if ((locala != null) && (!locala.field_isExit)) {
          com.tencent.mm.plugin.newtips.a.exl().ADB = new i.a()
          {
            public final void e(com.tencent.mm.plugin.newtips.b.a paramAnonymousa)
            {
              AppMethodBeat.i(33546);
              if ((paramAnonymousa != null) && (paramAnonymousa.field_tipId == com.tencent.mm.plugin.newtips.a.d.ADb))
              {
                com.tencent.mm.plugin.newtips.a.exo();
                if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb))
                {
                  localIconPreference.alF(0);
                  localIconPreference.alD(8);
                  localIconPreference.gY("", -1);
                  AppMethodBeat.o(33546);
                  return;
                }
              }
              AppMethodBeat.o(33546);
            }
          };
        }
        while (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasSettingTabRedDot())
        {
          localIconPreference.alF(0);
          AppMethodBeat.o(33566);
          return;
          com.tencent.mm.plugin.newtips.a.exo();
          if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb))
          {
            localIconPreference.alF(0);
            localIconPreference.alD(8);
            localIconPreference.gY("", -1);
            AppMethodBeat.o(33566);
            return;
          }
        }
        localIconPreference.alF(8);
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private void gJm()
  {
    AppMethodBeat.i(232665);
    this.screen.jdMethod_do("more_tab_setting_personal_info", false);
    this.OIJ = ((AccountInfoPreference)this.adapter.bmg("more_tab_setting_personal_info"));
    Object localObject = z.aTZ();
    if (af.isNullOrNil((String)localObject))
    {
      localObject = z.aTY();
      if (com.tencent.mm.storage.as.bjx((String)localObject)) {
        this.OIJ.KoH = null;
      }
    }
    for (;;)
    {
      this.OIJ.userName = z.aTY();
      String str = z.aUa();
      localObject = str;
      if (af.isNullOrNil(str)) {
        localObject = z.aUb();
      }
      this.OIJ.KoG = l.c(getContext(), (CharSequence)localObject);
      this.OIJ.p(this.Bgv, this.OIP, this.Bgw);
      this.OIJ.KoV = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33547);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (MoreTabUI.l(MoreTabUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33547);
            return;
          }
          if ((MoreTabUI.m(MoreTabUI.this) != null) && (MoreTabUI.n(MoreTabUI.this)) && (MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
            MoreTabUI.m(MoreTabUI.this).fmQ();
          }
          if (MoreTabUI.p(MoreTabUI.this)) {
            u.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(2131766547), 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33547);
            return;
            if (MoreTabUI.o(MoreTabUI.this) != null) {
              MoreTabUI.o(MoreTabUI.this).hbY();
            }
          }
        }
      };
      ((AccountInfoPreference)this.screen.bmg("more_tab_setting_personal_info")).AmH = new MoreTabUI.14(this);
      AppMethodBeat.o(232665);
      return;
      this.OIJ.KoH = ((String)localObject);
      continue;
      this.OIJ.KoH = ((String)localObject);
    }
  }
  
  private void gJn()
  {
    AppMethodBeat.i(33567);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (com.tencent.mm.br.c.aZU("emoji"))
    {
      com.tencent.mm.br.c.gsX();
      this.screen.jdMethod_do("settings_emoji_store", false);
      bool1 = com.tencent.mm.y.c.axV().cO(262147, 266244);
      bool2 = com.tencent.mm.y.c.axV().cO(262149, 266244);
      localIconPreference = (IconPreference)this.screen.bmg("settings_emoji_store");
      if (localIconPreference == null) {
        AppMethodBeat.o(33567);
      }
    }
    else
    {
      this.screen.jdMethod_do("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.alD(0);
      localIconPreference.gY(getString(2131755915), 2131234232);
    }
    while ((bool2) || (bool1))
    {
      bg.aVF();
      String str = (String)com.tencent.mm.model.c.azQ().get(229633, null);
      q.bcV().a(str, localIconPreference.gLG(), new com.tencent.mm.av.a.c.h()
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
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33549);
                MoreTabUI.15.this.OJf.aL(this.jUL);
                MoreTabUI.15.this.OJf.alH(0);
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
              MoreTabUI.15.this.OJf.alH(8);
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
        localIconPreference.alD(0);
        localIconPreference.gY(getString(2131755860), 2131234232);
      }
      else
      {
        localIconPreference.alD(8);
        localIconPreference.gY("", -1);
      }
    }
    localIconPreference.alH(8);
    AppMethodBeat.o(33567);
  }
  
  private void gJo()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = z.aUj();
    Log.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    if (!bool2)
    {
      bool1 = true;
      localf.jdMethod_do("settings_mm_wallet", bool1);
      this.adapter.notifyDataSetChanged();
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
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label146:
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1056L, 0L, 1L, false);
    label158:
    AppMethodBeat.o(33568);
  }
  
  private void gJp()
  {
    AppMethodBeat.i(33569);
    bg.aVF();
    int i = af.i((Integer)com.tencent.mm.model.c.azQ().get(204820, null));
    bg.aVF();
    int j = i + af.i((Integer)com.tencent.mm.model.c.azQ().get(204817, null));
    boolean bool3 = com.tencent.mm.y.c.axV().cO(262156, 266248);
    boolean bool4 = com.tencent.mm.y.c.axV().cP(262156, 266248);
    boolean bool5 = com.tencent.mm.y.c.axV().b(ar.a.Odt, ar.a.Odv);
    bg.aVF();
    String str2 = (String)com.tencent.mm.model.c.azQ().get(ar.a.Odw, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bmg("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    Log.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool3)));
    Log.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool4)));
    localNormalIconNewTipPreference.a(this.screen);
    com.tencent.mm.plugin.newtips.a.exl().h(localNormalIconNewTipPreference);
    com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
    bg.aVF();
    String str3 = (String)com.tencent.mm.model.c.azQ().get(ar.a.OcM, "");
    bg.aVF();
    int k = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.OcN, Integer.valueOf(-1))).intValue();
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
      bg.aVF();
      l1 = ((Long)com.tencent.mm.model.c.azQ().get(ar.a.OcK, Long.valueOf(-1L))).longValue();
      long l2 = af.Fk(com.tencent.mm.n.h.aqJ().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 86400000.0D;
      Log.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
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
            com.tencent.mm.y.c.axV().A(262156, false);
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.kernel.g.aAi();
    bool3 = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeU, Boolean.FALSE)).booleanValue();
    com.tencent.mm.kernel.g.aAi();
    long l1 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeV, Long.valueOf(0L))).longValue();
    if ((bool3) && (l1 > 0L) && (System.currentTimeMillis() > l1))
    {
      Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
      bool3 = false;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeU, Boolean.FALSE);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeV, Long.valueOf(0L));
    }
    for (;;)
    {
      bool3 = bool2 | bool3;
      com.tencent.mm.kernel.g.aAi();
      Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeR, "");
      Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), localObject });
      bool2 = com.tencent.mm.y.c.axV().b(ar.a.OeY, ar.a.Ofe);
      com.tencent.mm.kernel.g.aAi();
      l1 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofa, Long.valueOf(0L))).longValue();
      if ((bool2) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool2 = false;
        com.tencent.mm.y.c.axV().c(ar.a.OeY, ar.a.Ofe);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofa, Long.valueOf(0L));
      }
      for (;;)
      {
        bool3 |= bool2;
        com.tencent.mm.kernel.g.aAi();
        String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OeX, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), str1 });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
        if (bool3)
        {
          i = 1;
          localh.a(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
          Log.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
          if ((!bool5) && (!bool1) && (j <= 0) && (!bool3) && (k != 1)) {
            break label929;
          }
        }
        label929:
        for (bool2 = true;; bool2 = false)
        {
          if (!com.tencent.mm.plugin.newtips.a.g.a(bool2, localNormalIconNewTipPreference)) {
            break label935;
          }
          AppMethodBeat.o(33569);
          return;
          i = 0;
          break;
        }
        label935:
        if (bool5) {
          if (!Util.isNullOrNil(str2))
          {
            localNormalIconNewTipPreference.alE(0);
            localNormalIconNewTipPreference.aS(str2, -1, -7566196);
            localNormalIconNewTipPreference.BB(true);
            localNormalIconNewTipPreference.alF(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADI, true);
            if (Util.isNullOrNil(str1)) {
              break label1388;
            }
            localObject = str1;
          }
        }
        label1388:
        for (;;)
        {
          if ((!af.isNullOrNil((String)localObject)) && (bool3))
          {
            localNormalIconNewTipPreference.setSummary((CharSequence)localObject);
            AppMethodBeat.o(33569);
            return;
            localNormalIconNewTipPreference.gZ("", -1);
            localNormalIconNewTipPreference.alE(8);
            localNormalIconNewTipPreference.alF(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADG, true);
            break;
            if (bool1)
            {
              localNormalIconNewTipPreference.alD(0);
              localNormalIconNewTipPreference.gY(getString(2131755915), 2131234232);
              localNormalIconNewTipPreference.alF(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADH, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.alD(0);
              localNormalIconNewTipPreference.gY(getString(2131766602), v.kH(getContext()));
              localNormalIconNewTipPreference.alF(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADL, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.alD(0);
              localNormalIconNewTipPreference.gY(String.valueOf(j), v.aQ(getContext(), j));
              localNormalIconNewTipPreference.alF(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADL, true);
              break;
            }
            if (bool3)
            {
              localNormalIconNewTipPreference.gY("", -1);
              localNormalIconNewTipPreference.alD(8);
              localNormalIconNewTipPreference.alF(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADG, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.gY("", -1);
              localNormalIconNewTipPreference.alD(8);
              localNormalIconNewTipPreference.alE(0);
              localNormalIconNewTipPreference.BB(true);
              if (!af.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.aS(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.alI(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, k.ADI, true);
              break;
            }
            localNormalIconNewTipPreference.gY("", -1);
            localNormalIconNewTipPreference.alD(8);
            localNormalIconNewTipPreference.alF(8);
            localNormalIconNewTipPreference.alE(8);
            localNormalIconNewTipPreference.gZ("", -1);
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
  
  private void gJq()
  {
    AppMethodBeat.i(232666);
    if (getActivity() == null)
    {
      AppMethodBeat.o(232666);
      return;
    }
    boolean bool = p.fvC();
    if (bool == this.OIG)
    {
      AppMethodBeat.o(232666);
      return;
    }
    this.OIG = bool;
    if (this.BdF != null)
    {
      this.zWu.removeView(this.BdF);
      this.BdF.onDestroy();
      this.OIC.y(null, 0, 0);
      this.BdF = null;
    }
    if (this.BdM != null)
    {
      this.zWu.removeView(this.OIE);
      this.zWu.removeView(this.BdM.getView());
      this.BdM.fvv();
      this.BdM = null;
      if (this.OIJ != null)
      {
        AccountInfoPreference localAccountInfoPreference = this.OIJ;
        if (localAccountInfoPreference.BgU != null)
        {
          localAccountInfoPreference.BgU.fvv();
          localAccountInfoPreference.BgU = null;
        }
      }
    }
    this.OIH = false;
    gJr();
    gJi();
    if (this.OIJ != null) {
      gJm();
    }
    AppMethodBeat.o(232666);
  }
  
  private void gJr()
  {
    AppMethodBeat.i(33575);
    if (this.OIH)
    {
      AppMethodBeat.o(33575);
      return;
    }
    this.OIH = true;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.OIG)
    {
      this.OIE = new View(getContext());
      this.zWu.addView(this.OIE, 0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.OIE.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.topMargin = au.az(getContext()).x;
      this.OIE.setBackgroundColor(getResources().getColor(2131099648));
      float f = ah.jS(getContext()).width;
      this.OIC.setTranslationListener(new PullDownListView.a()
      {
        public final void bI(float paramAnonymousFloat)
        {
          float f1 = 0.0F;
          AppMethodBeat.i(232651);
          if (!MoreTabUI.l(MoreTabUI.this))
          {
            AppMethodBeat.o(232651);
            return;
          }
          float f2 = paramAnonymousFloat / this.BdW;
          if (paramAnonymousFloat < 0.0F) {}
          for (;;)
          {
            if (paramAnonymousFloat > this.BdW) {
              f1 = 1.0F;
            }
            MoreTabUI.q(MoreTabUI.this).setTranslationY(paramAnonymousFloat);
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).cd(f1);
            }
            if (MoreTabUI.s(MoreTabUI.this) != null)
            {
              View localView = MoreTabUI.s(MoreTabUI.this).KoL;
              if (localView != null) {
                localView.setAlpha((1.0F - f1) * 1.0F);
              }
            }
            AppMethodBeat.o(232651);
            return;
            f1 = f2;
          }
        }
      });
      this.BdM = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getBackPreview(getContext());
      this.zWu.addView(this.BdM.getView(), 0);
      this.BdM.a(this);
      this.BdM.DV(com.tencent.mm.plugin.auth.a.a.ceA());
    }
    do
    {
      this.OIF.gJs();
      AppMethodBeat.o(33575);
      return;
      this.BdF = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.Fkx, null);
    } while (this.BdF == null);
    this.BdF.fmS();
    this.OIO = (-(au.az(getContext()).y / 10));
    if (this.OIP) {}
    for (int i = com.tencent.mm.cb.a.aH(getContext(), 2131166842);; i = com.tencent.mm.cb.a.aH(getContext(), 2131166841))
    {
      this.OIN = i;
      this.OIM = (-com.tencent.mm.cb.a.fromDPToPix(getContext(), 330));
      this.OIL = 0;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, au.az(getContext()).y);
      localLayoutParams.topMargin = this.OIO;
      localLayoutParams.bottomMargin = (-au.aD(getContext()));
      this.zWu.addView(this.BdF, 0, localLayoutParams);
      this.OIC.y(this.BdF, this.OIN, this.OIO);
      this.OIC.setNavigationBarHeight(au.aD(getActivity()));
      this.OIC.setTranslationListener(null);
      this.BdF.setDataSeed(z.aTY());
      this.BdF.a(this.OIC);
      this.BdF.setStoryBrowseUIListener(this);
      break;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(232667);
    if (this.OIJ != null)
    {
      com.tencent.mm.plugin.textstatus.a.d locald = this.OIJ.BgU;
      if (locald != null) {
        locald.DV(com.tencent.mm.plugin.auth.a.a.ceA());
      }
    }
    if (this.BdM != null) {
      this.BdM.DV(com.tencent.mm.plugin.auth.a.a.ceA());
    }
    AppMethodBeat.o(232667);
  }
  
  public final void eEb()
  {
    AppMethodBeat.i(33584);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.OIC != null) && (!this.OIC.isVisible)) {
      this.OIC.hbX();
    }
    if ((!o.isShowStoryCheck()) || (this.nmu)) {
      this.OIF.ali(2);
    }
    for (;;)
    {
      if (this.OIJ != null) {
        this.OIJ.grF();
      }
      AppMethodBeat.o(33584);
      return;
      this.OIF.ali(1);
    }
  }
  
  public final void eEc()
  {
    AppMethodBeat.i(33585);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.OIC != null) && (this.OIC.isVisible) && (this.OIQ))
    {
      if (!this.nmu) {
        break label107;
      }
      this.OIF.ali(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.bmg("settings_my_album");
      if (localIconPreference == null) {
        break label129;
      }
      if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.OiS, true)) {
        break;
      }
      this.OIR = true;
      localIconPreference.alF(0);
      AppMethodBeat.o(33585);
      return;
      label107:
      this.OIF.ali(0);
    }
    this.OIR = false;
    localIconPreference.alF(8);
    label129:
    AppMethodBeat.o(33585);
  }
  
  public final void eEd()
  {
    AppMethodBeat.i(33586);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.OIC != null) && (!this.OIC.isVisible)) {
      this.OIC.hbX();
    }
    alh(0);
    Bn(this.Bgv);
    AppMethodBeat.o(33586);
  }
  
  public final void eEe()
  {
    AppMethodBeat.i(232669);
    Log.i("MicroMsg.MoreTabUI", "status statusUINoStatus");
    this.Bgw = false;
    this.OIC.setSupportOverscroll(false);
    if ((this.OIC != null) && (!this.OIC.isVisible)) {
      this.OIC.hbX();
    }
    this.OIF.ali(2);
    if (this.OIJ != null) {
      this.OIJ.grF();
    }
    AppMethodBeat.o(232669);
  }
  
  public final void eEf()
  {
    AppMethodBeat.i(232670);
    Log.i("MicroMsg.MoreTabUI", "statusUIHasStatus");
    this.Bgw = true;
    if (this.nmu) {
      this.Bgw = false;
    }
    if ((this.OIC != null) && (this.OIC.isVisible) && (this.OIQ))
    {
      if (this.Bgw)
      {
        this.OIF.ali(3);
        AppMethodBeat.o(232670);
        return;
      }
      this.OIF.ali(2);
    }
    AppMethodBeat.o(232670);
  }
  
  final void eEh()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(33590);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(33590);
  }
  
  public final void gGB() {}
  
  public final void gGC() {}
  
  public final void gGE() {}
  
  protected final void gGu()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Log.i("MicroMsg.MoreTabUI", "onTabCreate:  %s", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 2)
    {
      bool1 = true;
      this.nmu = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label272;
      }
    }
    label272:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.OIS = bool1;
      this.screen = this.adapter;
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.cy(getContext());
      com.tencent.mm.kernel.g.aAi();
      this.BdG = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().hh(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cb.a.aH(getContext(), 2131166840), com.tencent.mm.cb.a.aH(getContext(), 2131166840));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(2131305772).getParent()).addView(this.BdG, 0, (ViewGroup.LayoutParams)localObject);
      this.OIC.QRK = this.mPullDownCallback;
      this.OIC.setPadding(this.OIC.getPaddingLeft(), this.OIC.getPaddingTop(), this.OIC.getPaddingRight(), this.OID.getHeight());
      if (this.zWu != null)
      {
        Log.d("MicroMsg.MoreTabUI", "dancy test add view !");
        gJr();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void gGv()
  {
    AppMethodBeat.i(33577);
    Log.i("MicroMsg.MoreTabUI", "onTabResume:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (((this.screen instanceof com.tencent.mm.ui.base.preference.h)) && (((com.tencent.mm.ui.base.preference.h)this.screen).OZd == 0L)) {
      ((com.tencent.mm.ui.base.preference.h)this.screen).OZd = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    this.screen = this.adapter;
    gJq();
    bg.aVF();
    com.tencent.mm.model.c.azQ().add(this);
    com.tencent.mm.y.c.axV().a(this.DeE);
    gJm();
    Object localObject1 = (IconPreference)this.screen.bmg("settings_my_address");
    label271:
    Object localObject2;
    if (localObject1 != null)
    {
      int i = com.tencent.mm.bj.d.bgN().gCR();
      if (i > 0)
      {
        ((IconPreference)localObject1).alD(0);
        ((IconPreference)localObject1).gY(String.valueOf(i), 2131234232);
      }
    }
    else
    {
      gJj();
      if (!((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderSwitchApi().dCs()) {
        break label876;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
      this.screen.jdMethod_do("settings_my_finder_album", false);
      localObject1 = (NormalIconTipPreference)this.screen.bmg("settings_my_finder_album");
      if (!af.isNullOrNil(z.aUg())) {
        break label833;
      }
      ((NormalIconTipPreference)localObject1).bml(getString(2131765486));
      localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
      if (com.tencent.mm.plugin.finder.utils.y.dCY())
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (!com.tencent.mm.plugin.finder.utils.y.dCZ())
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
          if (!com.tencent.mm.plugin.finder.utils.y.dDa())
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCX();
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      localObject1 = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.dbb().getValue();
      localObject2 = (IconPreference)this.screen.bmg("settings_my_finder_album");
      if (localObject1 == null) {
        break label860;
      }
      if (localObject1 != null)
      {
        Log.i("MicroMsg.MoreTabUI", "[onChanged] result=%s", new Object[] { localObject1 });
        if (!((h.a)localObject1).dEF) {
          break label844;
        }
        ((IconPreference)localObject2).aS(((h.a)localObject1).tKS.title, -1, -7566196);
        ((IconPreference)localObject2).BB(true);
        ((IconPreference)localObject2).alE(0);
      }
      label410:
      gJn();
      gJl();
      if (com.tencent.mm.br.c.aZU("favorite")) {
        break label893;
      }
      this.screen.jdMethod_do("settings_mm_favorite", true);
      label441:
      gJp();
      gJo();
      gJk();
      if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.y.a.a.class)) {
        break label910;
      }
      this.screen.jdMethod_do("more_uishow", false);
      label479:
      localObject1 = this.screen.bmg("settings_privacy_agreements");
      if (!com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null))) {
        break label927;
      }
      localObject2 = getString(2131764020);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
      localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(2131100685)), localSpannable.length() - ((String)localObject2).length(), localSpannable.length(), 33);
      ((Preference)localObject1).setTitle(localSpannable);
      this.screen.jdMethod_do("settings_privacy_agreements", false);
      label601:
      thisActivity().supportInvalidateOptionsMenu();
      this.screen.notifyDataSetChanged();
      localObject1 = findViewById(2131303716);
      if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
        new MMHandler(Looper.getMainLooper()).post(new MoreTabUI.4(this, (View)localObject1));
      }
      if ((this.OIC != null) && (this.OIC.isVisible))
      {
        alh(0);
        Log.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
      }
      if (this.BdF != null)
      {
        this.BdF.onResume();
        this.BdF.fmR();
      }
      updateStatus();
      if (this.OIJ != null)
      {
        localObject1 = this.OIJ;
        if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.y.c.axV().cO(352279, 266241))) {
          break label944;
        }
      }
    }
    label910:
    label927:
    label944:
    for (boolean bool = true;; bool = false)
    {
      ((AccountInfoPreference)localObject1).KoT = bool;
      this.OIJ.grG();
      Log.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      ((IconPreference)localObject1).alD(8);
      ((IconPreference)localObject1).gY("", -1);
      break;
      label833:
      ((NormalIconTipPreference)localObject1).bml("");
      break label271;
      label844:
      ((IconPreference)localObject2).BB(false);
      ((IconPreference)localObject2).alE(8);
      break label410;
      label860:
      ((IconPreference)localObject2).BB(false);
      ((IconPreference)localObject2).alE(8);
      break label410;
      label876:
      this.screen.jdMethod_do("settings_my_finder_album", true);
      break label410;
      label893:
      this.screen.jdMethod_do("settings_mm_favorite", false);
      break label441;
      this.screen.jdMethod_do("more_uishow", true);
      break label479;
      this.screen.jdMethod_do("settings_privacy_agreements", true);
      break label601;
    }
  }
  
  protected final void gGw()
  {
    AppMethodBeat.i(33578);
    if (this.BdF != null) {
      this.BdF.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void gGx()
  {
    AppMethodBeat.i(33579);
    Log.d("MicroMsg.MoreTabUI", "onTabPause %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.y.c.axV().b(this.DeE);
    bg.aVF();
    com.tencent.mm.model.c.azQ().remove(this);
    if (this.BdF != null) {
      this.BdF.onPause();
    }
    if (this.OIC != null)
    {
      if ((this.OIC.isVisible) || (this.Bgv)) {
        break label133;
      }
      this.OIC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232662);
          MoreTabUI.o(MoreTabUI.this).hbX();
          AppMethodBeat.o(232662);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.OIJ != null) {
        this.OIJ.grF();
      }
      Bm(false);
      AppMethodBeat.o(33579);
      return;
      label133:
      if ((this.OIC.isVisible) && (this.OIC.getTranslationY() != 0.0F)) {
        this.OIC.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void gGy()
  {
    AppMethodBeat.i(33580);
    if (this.BdF != null) {
      this.BdF.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void gGz()
  {
    AppMethodBeat.i(33581);
    Log.i("MicroMsg.MoreTabUI", "onTabDestroy:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.BdF != null) {
      this.BdF.onDestroy();
    }
    if (this.OIJ != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.OIJ;
      if (localAccountInfoPreference.rFe) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fP(localAccountInfoPreference.KoP);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void gHE()
  {
    AppMethodBeat.i(33582);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.OIQ = true;
    gJq();
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (((Configuration)localObject).orientation == 2)
      {
        bool = true;
        this.nmu = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label311;
        }
        bool = true;
        label79:
        this.OIS = bool;
      }
    }
    else if (this.OIC != null)
    {
      localObject = this.OIC;
      as.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).QRG = true;
      if ((!this.OIC.isVisible) || (this.OIC.getTranslationY() == 0.0F)) {
        break label316;
      }
      this.OIC.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.BdF != null) {
        this.BdF.fmR();
      }
      if (this.UuP) {}
      try
      {
        localObject = SecDataUIC.CWq;
        localObject = (com.tencent.mm.plugin.textstatus.g.y)SecDataUIC.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.g.y.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.textstatus.g.y)localObject).sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
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
      this.UuP = false;
      Bm(true);
      l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.Kv(l);
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqB().eQM = l;
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqB().eRW = System.currentTimeMillis();
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(34);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickBottomTabRedDot();
      AppMethodBeat.o(33582);
      return;
      bool = false;
      break;
      label311:
      bool = false;
      break label79;
      label316:
      if (!this.OIC.isVisible) {
        this.OIC.hbX();
      }
    }
  }
  
  public final void gHF()
  {
    AppMethodBeat.i(33583);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchOut");
    this.OIQ = false;
    if (this.OIC != null)
    {
      localObject = this.OIC;
      as.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).QRG = false;
      if (!this.OIC.isVisible) {
        this.OIC.hbX();
      }
    }
    if (this.BdG != null) {
      this.BdG.setVisibility(8);
    }
    alh(0);
    Object localObject = new xe();
    EventCenter.instance.publish((IEvent)localObject);
    Bm(false);
    localObject = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqC();
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(50);
    }
    this.UuP = true;
    AppMethodBeat.o(33583);
  }
  
  public final int getResourceId()
  {
    return 2132017237;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(33561);
    Log.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.screen = this.adapter;
    this.screen.jdMethod_do("more_setting", true);
    this.screen.jdMethod_do("settings_emoji_store", true);
    this.screen.jdMethod_do("settings_mm_wallet", true);
    this.screen.jdMethod_do("settings_mm_cardpackage", true);
    this.screen.jdMethod_do("settings_mm_favorite", true);
    this.screen.jdMethod_do("settings_my_album", true);
    this.screen.jdMethod_do("settings_my_finder_album", true);
    this.screen.jdMethod_do("settings_my_address", true);
    this.screen.jdMethod_do("more_tab_setting_personal_info", true);
    this.screen.jdMethod_do("more_uishow", true);
    this.screen.jdMethod_do("settings_privacy_agreements", true);
    this.OID = getView().getRootView().findViewById(2131303053);
    this.zWu = ((RelativeLayout)findViewById(2131306092));
    this.OIC = ((PullDownListView)this.list);
    this.OIC.setTabView(this.OID);
    this.OIC.setBackground(at.aN(getContext(), 2130969381));
    this.OIC.setOnScrollListener(new AbsListView.OnScrollListener()
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
    if (this.OIG)
    {
      updateStatus();
      AppMethodBeat.o(33573);
      return;
    }
    if (paramConfiguration.orientation == 1)
    {
      this.nmu = false;
      if (this.OIC != null) {
        this.OIF.gJs();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label233;
      }
    }
    for (;;)
    {
      if (bool != this.OIS)
      {
        this.OIS = bool;
        if ((this.BdF != null) && (this.zWu != null) && (this.OIC != null))
        {
          this.BdF.onDestroy();
          this.zWu.removeView(this.BdF);
          gJr();
          this.BdF.onResume();
          if (!this.OIC.isVisible)
          {
            this.OIC.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232664);
                MoreTabUI.o(MoreTabUI.this).hbX();
                AppMethodBeat.o(232664);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.nmu = true;
            if (this.OIC == null) {
              break;
            }
            if (!this.OIC.isVisible) {
              this.OIC.hbX();
            }
            this.OIF.ali(2);
            break;
            label233:
            bool = false;
            continue;
          }
          if ((this.OIC.isVisible) && (this.OIC.getTranslationY() != 0.0F)) {
            this.OIC.setTranslationY(0.0F);
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
    Log.i("MicroMsg.MoreTabUI", "onCreate:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if ((!bg.aAc()) || (bg.azj()))
    {
      Log.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(bg.aAc()), Boolean.valueOf(bg.azj()) });
      AppMethodBeat.o(33556);
      return;
    }
    this.OIG = p.fvC();
    gJi();
    Bm(false);
    try
    {
      paramBundle = getContext();
      if (paramBundle == null)
      {
        AppMethodBeat.o(33556);
        return;
      }
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      ((SecDataUIC)com.tencent.mm.ui.component.a.ko(paramBundle).get(SecDataUIC.class)).a(new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.g.y.class, 9));
      paramBundle = SecDataUIC.CWq;
      paramBundle = (com.tencent.mm.plugin.textstatus.g.y)SecDataUIC.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.g.y.class);
      if (paramBundle != null) {
        paramBundle.sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
      }
      AppMethodBeat.o(33556);
      return;
    }
    catch (Throwable paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.MoreTabUI", paramBundle, "[initStatusReportData]err", new Object[0]);
      AppMethodBeat.o(33556);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33560);
    super.onDestroy();
    Log.i("MicroMsg.MoreTabUI", "onDestroy:  %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33560);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33588);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.BdF != null)) {}
    for (boolean bool = this.BdF.onBackPressed();; bool = false)
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
    int i = af.cm(paramObject);
    Log.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != com.tencent.mm.model.c.azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      gJp();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      gJo();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      gJn();
    }
    AppMethodBeat.o(33570);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33558);
    super.onPause();
    Log.i("MicroMsg.MoreTabUI", "onPause:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.OIQ)
    {
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqC();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (localObject = "null";; localObject = paramPreference.mKey)
    {
      Log.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.g.aAc()) {
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_add_contact"))
    {
      com.tencent.mm.br.c.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
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
      com.tencent.mm.plugin.newtips.a.exl().TC(13);
      bool1 = com.tencent.mm.y.c.axV().cO(262156, 266248);
      boolean bool2 = com.tencent.mm.y.c.axV().cP(262156, 266248);
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.h.CyF;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.a(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new sd();
        paramPreference.dYH.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.dYH.intent = ((Intent)localObject);
        EventCenter.instance.publish(paramPreference);
        com.tencent.mm.y.c.axV().cQ(262156, 266248);
        com.tencent.mm.y.c.axV().c(ar.a.Odt, ar.a.Odv);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.OcM, "");
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.OcN, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeU, Boolean.FALSE);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeR, "");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeS, Boolean.FALSE);
        com.tencent.mm.y.c.axV().c(ar.a.OeY, ar.a.Ofe);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OeX, "");
        paramf = com.tencent.mm.plugin.report.service.h.CyF;
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
      com.tencent.mm.plugin.newtips.a.exl().TC(14);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NTT, "");
      new Intent().putExtra("key_from_scene", 22);
      Log.i("MicroMsg.MoreTabUI", "enter to cardhome");
      paramf = new kl();
      paramf.dPA.context = getContext();
      paramf.dPA.enterScene = 1;
      EventCenter.instance.publish(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_my_album"))
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        u.g(getContext(), null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        bg.aVF();
        paramf = (String)com.tencent.mm.model.c.azQ().get(2, null);
        paramPreference = new Intent(getContext(), AlbumUI.class);
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.putExtra("username", paramf);
        paramPreference.putExtra("story_dot", this.OIR);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        bg.aVF();
        i = af.i((Integer)com.tencent.mm.model.c.azQ().get(68389, null));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(68389, Integer.valueOf(i + 1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22208(12L, "");
      }
    }
    if (paramPreference.mKey.equals("settings_my_finder_album"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
      paramf = new Intent();
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderSelfProfile(getContext(), paramf, 13, 2);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10958, "8");
      com.tencent.mm.plugin.report.service.h.CyF.a(14103, new Object[] { Integer.valueOf(0) });
      com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
      com.tencent.mm.cr.d.hiy();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10958, "7");
      com.tencent.mm.y.c.axV().cQ(262147, 266244);
      com.tencent.mm.y.c.axV().cQ(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.h.CyF.a(12065, new Object[] { Integer.valueOf(1) });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkp, 881);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_setting"))
    {
      bool1 = com.tencent.mm.y.c.axV().cO(262145, 266242);
      com.tencent.mm.y.c.axV().cQ(262145, 266242);
      com.tencent.mm.y.c.axV().cQ(262157, 266261);
      com.tencent.mm.y.c.axV().cQ(262158, 266264);
      com.tencent.mm.y.c.axV().b(ar.a.Ogg, 266242);
      com.tencent.mm.y.c.axV().cQ(262164, 266268);
      paramPreference = new Intent();
      com.tencent.mm.br.c.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
      bg.aVF();
      i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.OaN, Integer.valueOf(0))).intValue();
      bg.aVF();
      int j = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.OaO, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.OaO, Integer.valueOf(i));
        paramf = (IconPreference)paramf.bmg("more_setting");
        if (paramf != null) {
          paramf.alF(8);
        }
        com.tencent.mm.y.c.axV().cQ(266260, 266241);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("more_uishow"))
    {
      paramf = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      paramf.HLX = new MoreTabUI.10(this);
      paramf.HLY = new o.g()
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
      paramf.dGm();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return true;
    }
    if (paramPreference.mKey.equals("settings_privacy_agreements"))
    {
      com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(2131762219, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.kernel.g.aAh().azQ().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
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
    if (!com.tencent.mm.kernel.g.aAc())
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
          bool = Bl(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (Util.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = Bl(false);
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
    gJi();
    if (this.OIQ)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.Kv(l);
      localh = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqB().eQM = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class b
  {
    private int status = 2;
    
    private b() {}
    
    public final void ali(int paramInt)
    {
      AppMethodBeat.i(33554);
      Log.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 0) {
        MoreTabUI.e(MoreTabUI.this, true);
      }
      for (;;)
      {
        this.status = paramInt;
        eEj();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.e(MoreTabUI.this, false);
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void eEj()
    {
      AppMethodBeat.i(33552);
      Log.i("MicroMsg.MoreTabUI", "updateUIByStory status:%s", new Object[] { Integer.valueOf(this.status) });
      if (MoreTabUI.this.getActivity() == null)
      {
        AppMethodBeat.o(33552);
        return;
      }
      if (this.status == 3)
      {
        MoreTabUI.o(MoreTabUI.this).setSelector(2131099648);
        switch (this.status)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33552);
        return;
        MoreTabUI.o(MoreTabUI.this).setSelector(2131101287);
        break;
        boolean bool = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).isHasStatusThumb(com.tencent.mm.plugin.auth.a.a.ceA());
        MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(bool);
        MoreTabUI.o(MoreTabUI.this).setBackground(null);
        MoreTabUI.o(MoreTabUI.this).setMuteView(null);
        MoreTabUI.o(MoreTabUI.this).setNeedHover(true);
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.B(MoreTabUI.this));
        if (MoreTabUI.s(MoreTabUI.this) != null)
        {
          MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(true);
          MoreTabUI.w(MoreTabUI.this);
          if (MoreTabUI.v(MoreTabUI.this)) {
            MoreTabUI.o(MoreTabUI.this).setBackground(at.aN(MoreTabUI.this.getContext(), 2130969382));
          }
          for (;;)
          {
            if (MoreTabUI.m(MoreTabUI.this) != null)
            {
              ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.C(MoreTabUI.this);
              MoreTabUI.o(MoreTabUI.this).y(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.C(MoreTabUI.this));
            }
            MoreTabUI.o(MoreTabUI.this).setMuteView(null);
            MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
            MoreTabUI.a(MoreTabUI.this, 0);
            MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
            if (MoreTabUI.s(MoreTabUI.this) != null) {
              MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
            }
            MoreTabUI.o(MoreTabUI.this).setNeedHover(false);
            AppMethodBeat.o(33552);
            return;
            MoreTabUI.o(MoreTabUI.this).setBackground(at.aN(MoreTabUI.this.getContext(), 2130969381));
          }
          MoreTabUI.o(MoreTabUI.this).setBackground(at.aN(MoreTabUI.this.getContext(), 2130969381));
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.E(MoreTabUI.this);
          MoreTabUI.b(MoreTabUI.this, com.tencent.mm.cb.a.aH(MoreTabUI.this.getContext(), 2131166841));
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.F(MoreTabUI.this);
            MoreTabUI.o(MoreTabUI.this).y(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.F(MoreTabUI.this));
          }
          MoreTabUI.o(MoreTabUI.this).setMuteView(MoreTabUI.A(MoreTabUI.this));
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.a(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.o(MoreTabUI.this).setNeedHover(false);
          if (MoreTabUI.s(MoreTabUI.this) != null)
          {
            MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
            AppMethodBeat.o(33552);
            return;
            MoreTabUI.o(MoreTabUI.this).setBackground(at.aN(MoreTabUI.this.getContext(), 2130969382));
            MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
            MoreTabUI.o(MoreTabUI.this).setNeedHover(false);
            MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
            MoreTabUI.t(MoreTabUI.this);
            if (MoreTabUI.s(MoreTabUI.this) != null) {
              MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
            }
          }
        }
      }
    }
    
    public final void gJs()
    {
      AppMethodBeat.i(33553);
      MoreTabUI.d(MoreTabUI.this, ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.ceA()));
      if (MoreTabUI.l(MoreTabUI.this)) {
        if ((!MoreTabUI.B(MoreTabUI.this)) || (MoreTabUI.p(MoreTabUI.this)))
        {
          this.status = 2;
          MoreTabUI.e(MoreTabUI.this, false);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
        eEj();
        AppMethodBeat.o(33553);
        return;
        this.status = 3;
        break;
        if ((o.isShowStoryCheck()) || (MoreTabUI.p(MoreTabUI.this)))
        {
          MoreTabUI.e(MoreTabUI.this, false);
          this.status = 2;
        }
        else if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(z.aTY()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */