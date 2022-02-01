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
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.a.aae;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.autogen.a.ut;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.u;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.event.IListener;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconTipPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import java.util.UUID;

public class MoreTabUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.i, MStorageEx.IOnStorageChange
{
  private View GJe;
  private RelativeLayout Ikt;
  private AbsStoryMuteView MVB;
  private com.tencent.mm.plugin.textstatus.a.b MVH;
  private View MVL;
  private View MVQ;
  private View.OnLayoutChangeListener MVR;
  private boolean MYi;
  private boolean MYj;
  private byte[] PoW;
  private com.tencent.mm.aa.a.a PwL;
  private Bitmap SIL;
  private RelativeLayout YlX;
  private FrameLayout YlY;
  private LinearLayout YlZ;
  private boolean Yma;
  private boolean adHA;
  private boolean adHB;
  private AccountInfoPreference adHC;
  private RelativeLayout adHD;
  private int adHE;
  private int adHF;
  private int adHG;
  private int adHH;
  private boolean adHI;
  private boolean adHJ;
  private boolean adHK;
  private boolean adHL;
  private boolean adHM;
  private com.tencent.threadpool.i.b adHN;
  private com.tencent.mm.modelimage.loader.b.h adHO;
  IListener<cx> adHP;
  private MoreTabUI.a adHQ;
  public boolean adHR;
  private boolean adHS;
  public boolean adHT;
  private int adHU;
  private int adHV;
  private boolean adHW;
  private MoreTabUI.b adHX;
  PullDownListView adHx;
  private c adHy;
  private boolean adHz;
  private View contentView;
  public PullDownListView.IPullDownCallback mPullDownCallback;
  private y<l.a> observer;
  private com.tencent.mm.ui.base.preference.f screen;
  private AbsStoryGallery storyGallery;
  private boolean tsJ;
  
  public MoreTabUI()
  {
    AppMethodBeat.i(33555);
    this.SIL = null;
    this.PoW = null;
    this.MVB = null;
    this.Ikt = null;
    this.GJe = null;
    this.storyGallery = null;
    this.MVH = null;
    this.MVQ = null;
    this.adHy = new c((byte)0);
    this.MYi = false;
    this.MYj = false;
    this.adHz = false;
    this.adHA = false;
    this.adHB = false;
    this.adHC = null;
    this.Yma = false;
    this.YlX = null;
    this.YlY = null;
    this.adHD = null;
    this.YlZ = null;
    this.adHE = 0;
    this.adHF = 0;
    this.adHG = 0;
    this.adHH = 0;
    this.adHI = false;
    this.tsJ = false;
    this.adHJ = false;
    this.adHK = false;
    this.adHL = false;
    this.adHM = false;
    this.PwL = new com.tencent.mm.aa.a.a()
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
          } else if ((paramAnonymousInt == 352280) && (MoreTabUI.f(MoreTabUI.this)) && (com.tencent.mm.aa.c.aYo().aYl())) {
            com.tencent.mm.aa.c.aYo().R(352280, false);
          }
        }
      }
      
      public final void b(at.a paramAnonymousa)
      {
        AppMethodBeat.i(33524);
        if (paramAnonymousa == at.a.acJh) {
          MoreTabUI.e(MoreTabUI.this);
        }
        for (;;)
        {
          MoreTabUI.g(MoreTabUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33524);
          return;
          if (paramAnonymousa == at.a.acJi) {
            MoreTabUI.e(MoreTabUI.this);
          } else if ((paramAnonymousa == at.a.acTi) || (paramAnonymousa == at.a.acUP)) {
            MoreTabUI.d(MoreTabUI.this);
          } else if (paramAnonymousa == at.a.acWf) {
            MoreTabUI.a(MoreTabUI.this);
          }
        }
      }
    };
    this.adHO = new com.tencent.mm.modelimage.loader.b.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
      {
        AppMethodBeat.i(33543);
        paramAnonymousString = (NormalIconNewTipPreference)MoreTabUI.g(MoreTabUI.this).bAi("settings_mm_cardpackage");
        if (paramAnonymousb.bitmap != null)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33540);
              paramAnonymousString.bd(this.pIG);
              paramAnonymousString.aBh(0);
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
            paramAnonymousString.bd(null);
            paramAnonymousString.aBh(8);
            AppMethodBeat.o(33541);
          }
        });
        AppMethodBeat.o(33543);
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView)
      {
        AppMethodBeat.i(33542);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33539);
            this.adIc.aBh(0);
            this.adIc.aBg(R.g.my_card_package_defaultlogo);
            AppMethodBeat.o(33539);
          }
        });
        AppMethodBeat.o(33542);
      }
    };
    this.observer = null;
    this.adHP = new MoreTabUI.3(this, com.tencent.mm.app.f.hfK);
    this.MVR = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(249266);
        paramAnonymousInt1 = paramAnonymousInt4 - paramAnonymousInt2;
        Log.d("MicroMsg.MoreTabUI", "onLayoutChange: oldHeight:%s, newHeight:%s", new Object[] { Integer.valueOf(paramAnonymousInt8 - paramAnonymousInt6), Integer.valueOf(paramAnonymousInt1) });
        MoreTabUI.a(MoreTabUI.this, paramAnonymousInt1);
        AppMethodBeat.o(249266);
      }
    };
    this.adHR = true;
    this.adHS = true;
    this.adHT = true;
    this.adHU = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
    this.adHV = com.tencent.mm.cd.a.fromDPToPix(getContext(), 120);
    this.mPullDownCallback = new PullDownListView.IPullDownCallback()
    {
      public final void afI(int paramAnonymousInt)
      {
        AppMethodBeat.i(249331);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).amX(paramAnonymousInt);
        }
        AppMethodBeat.o(249331);
      }
      
      public final void afJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(249333);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).amY(paramAnonymousInt);
        }
        AppMethodBeat.o(249333);
      }
      
      public final void afK(int paramAnonymousInt)
      {
        AppMethodBeat.i(249335);
        if ((!MoreTabUI.l(MoreTabUI.this)) && (MoreTabUI.m(MoreTabUI.this) != null)) {
          MoreTabUI.m(MoreTabUI.this).afK(paramAnonymousInt);
        }
        AppMethodBeat.o(249335);
      }
      
      public final void etL()
      {
        boolean bool = true;
        AppMethodBeat.i(249320);
        Object localObject;
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreOpen, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).etL();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                localObject = MoreTabUI.s(MoreTabUI.this).MYL;
                if (localObject != null) {
                  ((com.tencent.mm.plugin.textstatus.a.g)localObject).etL();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).Ymb = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(249320);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).huA();
          }
          if ((MoreTabUI.f(MoreTabUI.this)) && (!MoreTabUI.n(MoreTabUI.this)))
          {
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hyp().jkQ = System.currentTimeMillis();
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hyq();
          }
        }
      }
      
      public final void etM()
      {
        boolean bool = true;
        AppMethodBeat.i(249323);
        if (MoreTabUI.l(MoreTabUI.this)) {
          if (MoreTabUI.r(MoreTabUI.this) == null)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPreClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null)
            {
              MoreTabUI.r(MoreTabUI.this).etM();
              if (MoreTabUI.s(MoreTabUI.this) != null)
              {
                com.tencent.mm.plugin.textstatus.a.g localg = MoreTabUI.s(MoreTabUI.this).MYL;
                if (localg != null) {
                  localg.etM();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
            MoreTabUI.s(MoreTabUI.this).Ymb = MoreTabUI.o(MoreTabUI.this).isVisible;
          }
          AppMethodBeat.o(249323);
          return;
          bool = false;
          break;
          if (MoreTabUI.m(MoreTabUI.this) != null) {
            MoreTabUI.m(MoreTabUI.this).huB();
          }
        }
      }
      
      public final void gBu()
      {
        AppMethodBeat.i(249326);
        Log.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
        MoreTabUI.A(MoreTabUI.this).huH();
        AppMethodBeat.o(249326);
      }
      
      public final void gBv()
      {
        AppMethodBeat.i(249327);
        MoreTabUI.A(MoreTabUI.this).huI();
        AppMethodBeat.o(249327);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(249313);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$14", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
        Object localObject;
        if (MoreTabUI.l(MoreTabUI.this))
        {
          if (MoreTabUI.r(MoreTabUI.this) == null) {}
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.MoreTabUI", "status_cat onPostClose, statusBackPreview is null?:%s", new Object[] { Boolean.valueOf(bool) });
            if (MoreTabUI.r(MoreTabUI.this) != null) {
              MoreTabUI.r(MoreTabUI.this).onPostClose();
            }
            if (MoreTabUI.s(MoreTabUI.this) != null)
            {
              localObject = MoreTabUI.s(MoreTabUI.this).MYL;
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.g)localObject).onPostClose();
              }
            }
            localObject = MoreTabUI.this.getBounceView();
            if (localObject != null) {
              ((com.tencent.mm.ui.widget.pulldown.f)localObject).NJ(true);
            }
            if ((MoreTabUI.s(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this) != null)) {
              MoreTabUI.s(MoreTabUI.this).iNx();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$14", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V");
            AppMethodBeat.o(249313);
            return;
          }
        }
        if (MoreTabUI.m(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            MoreTabUI.m(MoreTabUI.this).ED(true);
            MoreTabUI.m(MoreTabUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249647);
                MoreTabUI.x(MoreTabUI.this);
                MoreTabUI.b(MoreTabUI.this, 0);
                MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
                if (MoreTabUI.y(MoreTabUI.this) != null) {
                  MoreTabUI.y(MoreTabUI.this).setTranslationY(0.0F);
                }
                AppMethodBeat.o(249647);
              }
            });
          }
          MoreTabUI.a(MoreTabUI.this, false);
          MoreTabUI.z(MoreTabUI.this).gBt();
          if ((!MoreTabUI.f(MoreTabUI.this)) || (MoreTabUI.n(MoreTabUI.this))) {
            break;
          }
          long l = System.currentTimeMillis();
          localObject = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.vY(l);
          localObject = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyp().jjE = l;
          break;
        }
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(249307);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).fv(paramAnonymousBoolean);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$14", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
              localObject = MoreTabUI.s(MoreTabUI.this).MYL;
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.g)localObject).onPostOpen(paramAnonymousBoolean);
              }
            }
            MoreTabUI.b(MoreTabUI.this, 8);
            localObject = MoreTabUI.this.getBounceView();
            if (localObject != null) {
              ((com.tencent.mm.ui.widget.pulldown.f)localObject).NJ(false);
            }
            if (MoreTabUI.s(MoreTabUI.this) != null) {
              MoreTabUI.s(MoreTabUI.this).iNw();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$14", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
            AppMethodBeat.o(249307);
            return;
          }
        }
        if (MoreTabUI.m(MoreTabUI.this) == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hxW().jjn = 1L;
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.hxW().jkL = 1L;
            MoreTabUI.m(MoreTabUI.this).ba(paramAnonymousBoolean, true);
            MoreTabUI.b(MoreTabUI.this, 8);
            MoreTabUI.t(MoreTabUI.this);
            MoreTabUI.u(MoreTabUI.this);
          }
          MoreTabUI.a(MoreTabUI.this, true);
          if ((MoreTabUI.n(MoreTabUI.this)) || (MoreTabUI.v(MoreTabUI.this))) {
            break;
          }
          int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYK, 0);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acYK, Integer.valueOf(i + 1));
          MoreTabUI.w(MoreTabUI.this);
          break;
        }
      }
    };
    this.adHW = false;
    this.adHX = new MoreTabUI.b(this);
    AppMethodBeat.o(33555);
  }
  
  private boolean Lk(boolean paramBoolean)
  {
    AppMethodBeat.i(33572);
    com.tencent.mm.plugin.appbrand.x.c.tMy.a(com.tencent.mm.plugin.appbrand.x.c.a.tMC);
    com.tencent.mm.plugin.appbrand.x.c.tMy.a(com.tencent.mm.plugin.appbrand.x.c.a.tMO);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 2);
    localIntent.putExtra("isNativeView", paramBoolean);
    com.tencent.mm.br.c.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", localIntent);
    AppMethodBeat.o(33572);
    return true;
  }
  
  private void Ll(boolean paramBoolean)
  {
    AppMethodBeat.i(250221);
    this.adHz = paramBoolean;
    if (this.storyGallery != null)
    {
      this.Ikt.removeView(this.storyGallery);
      this.storyGallery.onDestroy();
      this.adHx.G(null, 0, 0);
      this.storyGallery = null;
    }
    if (this.MVH != null)
    {
      this.Ikt.removeView(this.MVQ);
      this.Ikt.removeView(this.MVH.getView());
      this.MVH.hFv();
      this.MVH = null;
    }
    this.adHA = false;
    jkx();
    jkn();
    if (this.adHC != null) {
      jks();
    }
    AppMethodBeat.o(250221);
  }
  
  private void Lm(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(33587);
    if (getActivity() != null)
    {
      if (this.MVL == null)
      {
        View localView = findViewById(R.h.action_bar_container);
        if (localView != null) {
          this.MVL = localView.findViewById(R.h.action_bar);
        }
        if (this.MVL == null) {
          break label112;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", new Object[] { Boolean.valueOf(bool) });
        if (this.MVL == null) {
          break label125;
        }
        if ((!paramBoolean) || (this.adHz)) {
          break;
        }
        this.MVL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249085);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
            if (MoreTabUI.p(MoreTabUI.this)) {
              aa.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.l.gWz), 0).show();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(249085);
              return;
              if ((MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
                MoreTabUI.o(MoreTabUI.this).jIt();
              }
            }
          }
        });
        AppMethodBeat.o(33587);
        return;
        label112:
        bool = false;
      }
      this.MVL.setOnClickListener(null);
    }
    label125:
    AppMethodBeat.o(33587);
  }
  
  private void Ln(boolean paramBoolean)
  {
    AppMethodBeat.i(33589);
    if (((getContext() instanceof LauncherUI)) && (this.adHx != null) && (this.adHx.isVisible)) {
      ((LauncherUI)getContext()).getHomeUI().Lf(paramBoolean);
    }
    AppMethodBeat.o(33589);
  }
  
  private void aAv(int paramInt)
  {
    AppMethodBeat.i(33576);
    Object localObject4 = null;
    Object localObject1 = localObject4;
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
    finally
    {
      for (;;)
      {
        Object localObject3 = localObject4;
      }
    }
  }
  
  private void afH(int paramInt)
  {
    AppMethodBeat.i(250231);
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.MVQ.getLayoutParams();
      if (localLayoutParams.topMargin != paramInt)
      {
        localLayoutParams.topMargin = paramInt;
        this.MVQ.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(250231);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.MoreTabUI", localThrowable, "adjustStatusBgPosition", new Object[0]);
      AppMethodBeat.o(250231);
    }
  }
  
  private static void d(NormalIconNewTipPreference paramNormalIconNewTipPreference)
  {
    AppMethodBeat.i(250160);
    paramNormalIconNewTipPreference.aeD(0);
    paramNormalIconNewTipPreference.afx(8);
    paramNormalIconNewTipPreference.gv("", -1);
    com.tencent.mm.plugin.newtips.a.g.a(paramNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
    AppMethodBeat.o(250160);
  }
  
  private void jkn()
  {
    AppMethodBeat.i(33559);
    if (!this.adHJ)
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(33559);
        return;
      }
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYK, 0);
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acYx, false);
      Log.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", new Object[] { Integer.valueOf(i) });
      if ((!this.MYi) && ((bool) || (i > 0)))
      {
        this.adHJ = true;
        if (this.adHC != null) {
          this.adHC.p(this.MYi, this.adHJ, this.MYj);
        }
        if (!this.adHJ) {
          break label150;
        }
      }
    }
    label150:
    for (int i = com.tencent.mm.cd.a.bs(getContext(), R.f.flU);; i = com.tencent.mm.cd.a.bs(getContext(), R.f.flT))
    {
      this.adHG = i;
      AppMethodBeat.o(33559);
      return;
    }
  }
  
  private void jko()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33564);
    if (!com.tencent.mm.br.c.blq("sns"))
    {
      this.screen.eh("settings_my_album", true);
      AppMethodBeat.o(33564);
      return;
    }
    this.screen.eh("settings_my_album", false);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_my_album");
    int i;
    if ((com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acYU, true)) && (this.adHL))
    {
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        if (!aj.hgc()) {
          break label151;
        }
      }
    }
    label151:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference)) {
        break label156;
      }
      AppMethodBeat.o(33564);
      return;
      i = 0;
      break;
    }
    label156:
    if (localNormalIconNewTipPreference != null)
    {
      if (bool1)
      {
        localNormalIconNewTipPreference.aeD(0);
        AppMethodBeat.o(33564);
        return;
      }
      this.adHL = false;
      localNormalIconNewTipPreference.aeD(8);
    }
    AppMethodBeat.o(33564);
  }
  
  private void jkp()
  {
    AppMethodBeat.i(33565);
    Object localObject1 = (com.tencent.mm.plugin.card.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.card.b.b.class);
    if ((localObject1 == null) || ((!((com.tencent.mm.plugin.card.b.b)localObject1).dlj()) && (!((com.tencent.mm.plugin.card.b.b)localObject1).dlk())) || (!com.tencent.mm.br.c.blq("card")))
    {
      this.screen.eh("settings_mm_cardpackage", true);
      AppMethodBeat.o(33565);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.card.b.b)localObject1).dll();; localObject1 = "")
    {
      this.screen.eh("settings_mm_cardpackage", false);
      NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_mm_cardpackage");
      if (localNormalIconNewTipPreference == null)
      {
        AppMethodBeat.o(33565);
        return;
      }
      boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262152, 266256);
      boolean bool3 = com.tencent.mm.aa.c.aYo().dV(262152, 266256);
      boolean bool4 = com.tencent.mm.aa.c.aYo().a(at.a.acJh, at.a.acJj);
      boolean bool5 = com.tencent.mm.aa.c.aYo().a(at.a.acJi, at.a.acJk);
      bh.bCz();
      String str = (String)com.tencent.mm.model.c.ban().get(at.a.acJq, "");
      localNormalIconNewTipPreference.setTitle(R.l.settings_mm_card_package_new);
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(1) });
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.LMw = this.adHO;
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      if ((bool3) || ((bool5) && (!TextUtils.isEmpty(str))) || (bool2) || (bool4)) {}
      for (boolean bool1 = true; com.tencent.mm.plugin.newtips.a.g.a(bool1, localNormalIconNewTipPreference); bool1 = false)
      {
        AppMethodBeat.o(33565);
        return;
      }
      if (bool3)
      {
        localNormalIconNewTipPreference.afx(0);
        localNormalIconNewTipPreference.gv(getString(R.l.app_new), R.g.new_tips_bg);
        localNormalIconNewTipPreference.aeD(8);
        localNormalIconNewTipPreference.aS(null);
        localNormalIconNewTipPreference.bd(null);
        localNormalIconNewTipPreference.aBh(8);
        localNormalIconNewTipPreference.iP("", -1);
        localNormalIconNewTipPreference.aBf(8);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsL, true);
        AppMethodBeat.o(33565);
        return;
      }
      if ((bool5) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(R.f.card_entrance_icon_height);
        Object localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).prefixPath = com.tencent.mm.loader.i.b.bmz();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKH = r.bKf();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKp = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).nrc = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKn = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).npV = i;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).npU = i;
        localObject2 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx();
        r.bKe().a(str, localNormalIconNewTipPreference.jnm(), (com.tencent.mm.modelimage.loader.a.c)localObject2, this.adHO);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsN, true);
        if (!bool2) {
          break label631;
        }
        localNormalIconNewTipPreference.aeD(0);
        com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
      }
      for (;;)
      {
        if (bool4)
        {
          localNormalIconNewTipPreference.gv("", -1);
          localNormalIconNewTipPreference.afx(8);
          if (bool5)
          {
            localNormalIconNewTipPreference.aS(null);
            if (!ab.isNullOrNil((String)localObject1))
            {
              localNormalIconNewTipPreference.bd((String)localObject1, -1, getResources().getColor(R.e.hint_text_color));
              localNormalIconNewTipPreference.aBf(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsM, true);
              AppMethodBeat.o(33565);
              return;
              localNormalIconNewTipPreference.bd(null);
              localNormalIconNewTipPreference.aBh(8);
              break;
              label631:
              localNormalIconNewTipPreference.aeD(8);
              continue;
            }
            localNormalIconNewTipPreference.iP("", -1);
            localNormalIconNewTipPreference.aBf(8);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.iP("", -1);
          localNormalIconNewTipPreference.aBf(8);
          if (!ab.isNullOrNil((String)localObject1))
          {
            localNormalIconNewTipPreference.aS((CharSequence)localObject1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsM, true);
            AppMethodBeat.o(33565);
            return;
          }
          localNormalIconNewTipPreference.aS(null);
          AppMethodBeat.o(33565);
          return;
        }
      }
      localNormalIconNewTipPreference.aBf(8);
      localNormalIconNewTipPreference.afx(8);
      localNormalIconNewTipPreference.aS(null);
      AppMethodBeat.o(33565);
      return;
    }
  }
  
  private void jkq()
  {
    AppMethodBeat.i(33566);
    this.screen.eh("more_setting", false);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("more_setting");
    boolean bool2;
    int i;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if (localNormalIconNewTipPreference != null)
    {
      localNormalIconNewTipPreference.aBi(8);
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      bool2 = com.tencent.mm.aa.c.aYo().dV(262145, 266242);
      bh.bCz();
      i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acQl, Integer.valueOf(0))).intValue();
      bh.bCz();
      j = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acQm, Integer.valueOf(0))).intValue();
      if ((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.c.class)).iDD()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.c.class)).iDE()) || (i > j))
      {
        i = 1;
        bool3 = com.tencent.mm.aa.c.aYo().dW(262157, 266261);
        bool4 = com.tencent.mm.aa.c.aYo().dW(262164, 266268);
        bool5 = com.tencent.mm.aa.c.aYo().dW(262158, 266264);
        bool6 = com.tencent.mm.aa.c.aYo().a(at.a.acWf, 266242);
        bh.bCz();
        if ((com.tencent.mm.model.c.ban().getInt(40, 0) & 0x20000) != 0) {
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
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("VoiceprintEntry"), 0) == 1) {
        bh.bCz();
      }
      for (boolean bool1 = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acIJ, Boolean.FALSE)).booleanValue();; bool1 = false)
      {
        int k;
        boolean bool7;
        int m;
        if ((bool1) && (j != 0))
        {
          j = 1;
          com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.gtg().aeL(com.tencent.mm.plugin.newtips.a.d.Mse);
          if ((locala == null) || (!locala.field_isExit)) {
            break label480;
          }
          com.tencent.mm.plugin.newtips.a.gti();
          if (!com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Mse)) {
            break label480;
          }
          k = 1;
          bool7 = ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).hasSettingTabRedDot();
          if ((!bool2) && (i == 0) && (!bool3) && (!bool4) && (!bool5) && (!bool6) && (j == 0)) {
            break label485;
          }
          m = 1;
          if ((m == 0) && (locala != null) && (!locala.field_isExit))
          {
            this.adHQ = new MoreTabUI.a(localNormalIconNewTipPreference);
            com.tencent.mm.plugin.newtips.a.gtf().MsG = this.adHQ;
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
        localNormalIconNewTipPreference.aeD(8);
        if (bool2)
        {
          localNormalIconNewTipPreference.afx(0);
          localNormalIconNewTipPreference.gv(getString(R.l.app_new), R.g.new_tips_bg);
          com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsL, true);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.afx(8);
        localNormalIconNewTipPreference.gv("", -1);
        if (i != 0)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aeD(8);
        if (bool3)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aeD(8);
        if (bool4)
        {
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aeD(8);
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
        localNormalIconNewTipPreference.aeD(8);
        if (j != 0)
        {
          Log.i("MicroMsg.MoreTabUI", "show voiceprint dot");
          d(localNormalIconNewTipPreference);
          AppMethodBeat.o(33566);
          return;
        }
        localNormalIconNewTipPreference.aeD(8);
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
        localNormalIconNewTipPreference.aeD(8);
        AppMethodBeat.o(33566);
        return;
      }
    }
  }
  
  private AccountInfoPreference jkr()
  {
    AppMethodBeat.i(250164);
    if (this.adHC == null) {
      this.adHC = ((AccountInfoPreference)getPreferenceScreen().bAi("more_tab_setting_personal_info"));
    }
    AccountInfoPreference localAccountInfoPreference = this.adHC;
    AppMethodBeat.o(250164);
    return localAccountInfoPreference;
  }
  
  private void jks()
  {
    AppMethodBeat.i(250171);
    this.screen.eh("more_tab_setting_personal_info", false);
    this.adHC = ((AccountInfoPreference)getPreferenceScreen().bAi("more_tab_setting_personal_info"));
    Object localObject = z.bAN();
    if (ab.isNullOrNil((String)localObject))
    {
      localObject = z.bAM();
      if (au.bxb((String)localObject)) {
        this.adHC.YlN = null;
      }
    }
    for (;;)
    {
      this.adHC.userName = z.bAM();
      String str = z.bAO();
      localObject = str;
      if (ab.isNullOrNil(str)) {
        localObject = z.bAP();
      }
      this.adHC.YlM = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject);
      this.adHC.p(this.MYi, this.adHJ, this.MYj);
      this.adHC.Ymc = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33548);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (MoreTabUI.l(MoreTabUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33548);
            return;
          }
          if ((MoreTabUI.m(MoreTabUI.this) != null) && (MoreTabUI.n(MoreTabUI.this)) && (MoreTabUI.o(MoreTabUI.this) != null) && (MoreTabUI.o(MoreTabUI.this).isVisible)) {
            MoreTabUI.m(MoreTabUI.this).huC();
          }
          if (MoreTabUI.p(MoreTabUI.this)) {
            aa.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.l.gWz), 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33548);
            return;
            if (MoreTabUI.o(MoreTabUI.this) != null) {
              MoreTabUI.o(MoreTabUI.this).jIt();
            }
          }
        }
      };
      ((AccountInfoPreference)this.screen.bAi("more_tab_setting_personal_info")).LOO = new MoreTabUI.18(this);
      if ((this.MVQ != null) && (jkr() != null))
      {
        localObject = jkr().rootView;
        if ((localObject != null) && (((View)localObject).getMeasuredHeight() != 0)) {
          afH(((View)localObject).getMeasuredHeight());
        }
        jkr().a(this.MVR);
      }
      AppMethodBeat.o(250171);
      return;
      this.adHC.YlN = ((String)localObject);
      continue;
      this.adHC.YlN = ((String)localObject);
    }
  }
  
  private void jkt()
  {
    AppMethodBeat.i(33567);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.screen.eh("settings_emoji_store", true);
      AppMethodBeat.o(33567);
      return;
    }
    if ((!com.tencent.mm.br.c.blq("emoji")) || (com.tencent.mm.br.c.iPe()))
    {
      this.screen.eh("settings_emoji_store", false);
      AppMethodBeat.o(33567);
      return;
    }
    this.screen.eh("settings_emoji_store", false);
    boolean bool1 = com.tencent.mm.aa.c.aYo().dV(262147, 266244);
    boolean bool2 = com.tencent.mm.aa.c.aYo().dV(262149, 266244);
    final IconPreference localIconPreference = (IconPreference)this.screen.bAi("settings_emoji_store");
    if (localIconPreference == null)
    {
      AppMethodBeat.o(33567);
      return;
    }
    if (bool1)
    {
      localIconPreference.afx(0);
      localIconPreference.gv(getString(R.l.app_new), R.g.new_tips_bg);
    }
    while ((bool2) || (bool1))
    {
      bh.bCz();
      String str = (String)com.tencent.mm.model.c.ban().d(229633, null);
      r.bKe().a(str, localIconPreference.jnm(), new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(249289);
          if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null))
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33525);
                MoreTabUI.2.this.adHZ.bd(this.pIG);
                MoreTabUI.2.this.adHZ.aBh(0);
                AppMethodBeat.o(33525);
              }
            });
            AppMethodBeat.o(249289);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(249371);
              MoreTabUI.2.this.adHZ.aBh(8);
              AppMethodBeat.o(249371);
            }
          });
          AppMethodBeat.o(249289);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      AppMethodBeat.o(33567);
      return;
      if (bool2)
      {
        localIconPreference.afx(0);
        localIconPreference.gv(getString(R.l.app_free), R.g.new_tips_bg);
      }
      else
      {
        localIconPreference.afx(8);
        localIconPreference.gv("", -1);
      }
    }
    localIconPreference.aBh(8);
    AppMethodBeat.o(33567);
  }
  
  private void jku()
  {
    AppMethodBeat.i(33568);
    boolean bool2 = z.bBd();
    Log.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(bool2)));
    boolean bool3 = this.screen.bAj("settings_mm_wallet");
    Object localObject = this.screen;
    if (!bool2)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("settings_mm_wallet", bool1);
      if ((!bool3) && (bool2))
      {
        localObject = new com.tencent.mm.plugin.wxpayreport.a.b(true, true, 300L, null, 0, com.tencent.mm.plugin.wxpayreport.a.c.a.XJG.toString(), (MMFragmentActivity)thisActivity(), false, 0, R.h.preference_page);
        this.adHN = ((com.tencent.mm.plugin.wxpayreport.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpayreport.a.a.class)).checkViewAbnormal((com.tencent.mm.plugin.wxpayreport.a.b)localObject);
      }
      getPreferenceScreen().notifyDataSetChanged();
      int i = PluginAuth.getUserInfoPluginSwitch();
      if (Util.isEqual(i, -1)) {
        break label235;
      }
      if ((i & 0x8000) == 0) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2 == bool1) {
        break label235;
      }
      if (!bool2) {
        break label223;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1056L, 1L, 1L, false);
      AppMethodBeat.o(33568);
      return;
      bool1 = false;
      break;
    }
    label223:
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1056L, 0L, 1L, false);
    label235:
    AppMethodBeat.o(33568);
  }
  
  private void jkv()
  {
    AppMethodBeat.i(33569);
    bh.bCz();
    int i = ab.n((Integer)com.tencent.mm.model.c.ban().d(204820, null));
    bh.bCz();
    int j = i + ab.n((Integer)com.tencent.mm.model.c.ban().d(204817, null));
    boolean bool2 = com.tencent.mm.aa.c.aYo().dV(262156, 266248);
    boolean bool1 = com.tencent.mm.aa.c.aYo().dW(262156, 266248);
    boolean bool5 = com.tencent.mm.aa.c.aYo().b(at.a.acTi, at.a.acTk);
    bh.bCz();
    String str2 = (String)com.tencent.mm.model.c.ban().get(at.a.acTl, "");
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.screen.bAi("settings_mm_wallet");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33569);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    com.tencent.mm.kernel.h.baF();
    int k = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSr, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.MoreTabUI", "currentWalletRegion: %s", new Object[] { Integer.valueOf(i) });
    boolean bool3;
    int m;
    if ((i == 0) || (i == 1))
    {
      bool3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXe, false);
      Log.i("MicroMsg.MoreTabUI", " cn wallet open new name ：%s", new Object[] { Boolean.valueOf(bool3) });
      if (bool3)
      {
        localNormalIconNewTipPreference.setTitle(getString(R.l.settings_mm_wallet_service));
        if ((i == 0) || (i == 1)) {
          break label1773;
        }
        com.tencent.mm.kernel.h.baF();
        m = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSs, Integer.valueOf(0))).intValue();
        if (i == k) {
          break label1218;
        }
        bool1 = false;
        bool2 = false;
      }
    }
    label334:
    label1767:
    label1773:
    for (;;)
    {
      Log.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(bool2)));
      Log.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(bool1)));
      localNormalIconNewTipPreference.a(this.screen);
      com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
      com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
      bh.bCz();
      String str3 = (String)com.tencent.mm.model.c.ban().get(at.a.acSv, "");
      bh.bCz();
      k = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acSw, Integer.valueOf(-1))).intValue();
      boolean bool4;
      if (!bool2)
      {
        bool4 = bool1;
        bool3 = bool2;
        if (!bool1) {}
      }
      else
      {
        bh.bCz();
        l1 = ((Long)com.tencent.mm.model.c.ban().get(at.a.acSp, Long.valueOf(-1L))).longValue();
        long l2 = ab.EP(com.tencent.mm.k.i.aRC().getValue("PayWalletRedDotExpire"));
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
              com.tencent.mm.aa.c.aYo().Q(262156, false);
            }
          }
        }
      }
      com.tencent.mm.kernel.h.baF();
      bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUL, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.baF();
      long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUM, Long.valueOf(0L))).longValue();
      if ((bool1) && (l1 > 0L) && (System.currentTimeMillis() > l1))
      {
        Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
        bool1 = false;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUL, Boolean.FALSE);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUM, Long.valueOf(0L));
      }
      for (;;)
      {
        bool4 |= bool1;
        com.tencent.mm.kernel.h.baF();
        Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUH, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), localObject });
        bool2 = com.tencent.mm.aa.c.aYo().b(at.a.acUP, at.a.acUV);
        com.tencent.mm.kernel.h.baF();
        l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUR, Long.valueOf(0L))).longValue();
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (l1 > 0L)
          {
            bool1 = bool2;
            if (System.currentTimeMillis() > l1)
            {
              Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
              com.tencent.mm.aa.c.aYo().c(at.a.acUP, at.a.acUV);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acUR, Long.valueOf(0L));
              bool1 = false;
            }
          }
        }
        bool4 |= bool1;
        com.tencent.mm.kernel.h.baF();
        String str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUO, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), str1 });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (bool4)
        {
          i = 1;
          label1018:
          localh.b(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(1) });
          Log.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(bool5)));
          if ((!bool5) && (!bool3) && (j <= 0) && (!bool4) && (k != 1)) {
            break label1262;
          }
        }
        label1262:
        for (bool2 = true;; bool2 = false)
        {
          if (!com.tencent.mm.plugin.newtips.a.g.a(bool2, localNormalIconNewTipPreference)) {
            break label1268;
          }
          AppMethodBeat.o(33569);
          return;
          localNormalIconNewTipPreference.setTitle(getString(R.l.settings_mm_wallet_new));
          break;
          bool3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXf, false);
          Log.i("MicroMsg.MoreTabUI", " oversea wallet open new name ：%s", new Object[] { Boolean.valueOf(bool3) });
          if (bool3)
          {
            localNormalIconNewTipPreference.setTitle(getString(R.l.settings_mm_wallet_service));
            break;
          }
          localNormalIconNewTipPreference.setTitle(getString(R.l.settings_mm_wallet_new));
          break;
          if (m == 1)
          {
            bool1 = false;
            bool2 = true;
            break label334;
          }
          if (m == 2)
          {
            bool1 = true;
            bool2 = false;
            break label334;
          }
          bool1 = false;
          bool2 = false;
          break label334;
          i = 0;
          break label1018;
        }
        label1268:
        if ((bool1) && (!this.adHI))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(25075, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          this.adHI = true;
        }
        if (bool5) {
          if (!Util.isNullOrNil(str2))
          {
            localNormalIconNewTipPreference.aBf(0);
            localNormalIconNewTipPreference.bd(str2, -1, -7566196);
            localNormalIconNewTipPreference.LF(true);
            localNormalIconNewTipPreference.aeD(8);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsM, true);
            if (Util.isNullOrNil(str1)) {
              break label1767;
            }
            localObject = str1;
          }
        }
        for (;;)
        {
          if ((!ab.isNullOrNil((String)localObject)) && (bool4))
          {
            localNormalIconNewTipPreference.aS((CharSequence)localObject);
            AppMethodBeat.o(33569);
            return;
            localNormalIconNewTipPreference.iP("", -1);
            localNormalIconNewTipPreference.aBf(8);
            localNormalIconNewTipPreference.aeD(0);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
            break;
            if (bool3)
            {
              localNormalIconNewTipPreference.afx(0);
              localNormalIconNewTipPreference.gv(getString(R.l.app_new), R.g.new_tips_bg);
              localNormalIconNewTipPreference.aeD(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsL, true);
              break;
            }
            if (j > 99)
            {
              localNormalIconNewTipPreference.afx(0);
              localNormalIconNewTipPreference.gv(getString(R.l.tab_msg_tip_over), v.bC(getContext(), j));
              localNormalIconNewTipPreference.aeD(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsP, true);
              break;
            }
            if (j > 0)
            {
              localNormalIconNewTipPreference.afx(0);
              localNormalIconNewTipPreference.gv(String.valueOf(j), v.bC(getContext(), j));
              localNormalIconNewTipPreference.aeD(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsP, true);
              break;
            }
            if (bool4)
            {
              localNormalIconNewTipPreference.gv("", -1);
              localNormalIconNewTipPreference.afx(8);
              localNormalIconNewTipPreference.aeD(0);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsK, true);
              break;
            }
            if (k == 1)
            {
              localNormalIconNewTipPreference.gv("", -1);
              localNormalIconNewTipPreference.afx(8);
              localNormalIconNewTipPreference.aBf(0);
              localNormalIconNewTipPreference.LF(true);
              if (!ab.isNullOrNil(str3)) {
                localNormalIconNewTipPreference.bd(str3, -1, Color.parseColor("#888888"));
              }
              localNormalIconNewTipPreference.aBi(8);
              com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MsM, true);
              break;
            }
            localNormalIconNewTipPreference.gv("", -1);
            localNormalIconNewTipPreference.afx(8);
            localNormalIconNewTipPreference.aeD(8);
            localNormalIconNewTipPreference.aBf(8);
            localNormalIconNewTipPreference.iP("", -1);
            com.tencent.mm.plugin.newtips.a.g.a(localNormalIconNewTipPreference);
            break;
          }
          localNormalIconNewTipPreference.aS("");
          AppMethodBeat.o(33569);
          return;
        }
      }
    }
  }
  
  private void jkw()
  {
    AppMethodBeat.i(250213);
    if (getActivity() == null)
    {
      AppMethodBeat.o(250213);
      return;
    }
    boolean bool = ac.hFS();
    if ((!bool) && (getBounceView() != null)) {
      getBounceView().setBounceEnabled(false);
    }
    if (bool == this.adHz)
    {
      AppMethodBeat.o(250213);
      return;
    }
    Ll(bool);
    AppMethodBeat.o(250213);
  }
  
  private void jkx()
  {
    AppMethodBeat.i(33575);
    if (this.adHA)
    {
      AppMethodBeat.o(33575);
      return;
    }
    this.adHA = true;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.adHz)
    {
      this.MVQ = new View(getContext());
      this.Ikt.addView(this.MVQ, 0);
      localLayoutParams = (RelativeLayout.LayoutParams)this.MVQ.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.topMargin = bf.bf(getContext()).x;
      this.MVQ.setBackgroundColor(getResources().getColor(R.e.BG_0));
      ao.mX(getContext());
      final float f = com.tencent.mm.plugin.textstatus.a.a.ki(getContext());
      this.adHx.setTranslationListener(new PullDownListView.a()
      {
        public final void cS(float paramAnonymousFloat)
        {
          AppMethodBeat.i(249319);
          if (!MoreTabUI.l(MoreTabUI.this))
          {
            AppMethodBeat.o(249319);
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
            MoreTabUI.r(MoreTabUI.this).w(f1, paramAnonymousFloat, f);
          }
          Object localObject;
          if (MoreTabUI.s(MoreTabUI.this) != null)
          {
            localObject = MoreTabUI.s(MoreTabUI.this).YlR;
            if (localObject != null)
            {
              float f2 = 1.0F * (1.0F - f1);
              ((View)localObject).setAlpha(f2);
              localObject = MoreTabUI.s(MoreTabUI.this).YlS;
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
            localObject = MoreTabUI.s(MoreTabUI.this).MYL;
            if (localObject != null) {
              ((com.tencent.mm.plugin.textstatus.a.g)localObject).w(f1, paramAnonymousFloat, f);
            }
            AppMethodBeat.o(249319);
            return;
            label190:
            ((View)localObject).setVisibility(8);
          }
        }
      });
      this.MVH = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getBackPreview(getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249325);
          if ((MoreTabUI.o(MoreTabUI.this) != null) && (!MoreTabUI.o(MoreTabUI.this).isVisible)) {
            MoreTabUI.o(MoreTabUI.this).jIs();
          }
          AppMethodBeat.o(249325);
        }
      }, false);
      this.Ikt.addView(this.MVH.getView(), 0);
      this.MVH.hFo();
      this.MVH.a(this);
      this.MVH.Ds(com.tencent.mm.plugin.auth.a.a.cUx());
    }
    do
    {
      this.adHy.jkz();
      AppMethodBeat.o(33575);
      return;
      this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.Sik, null);
    } while (this.storyGallery == null);
    this.storyGallery.huE();
    this.adHH = (-(bf.bf(getContext()).y / 10));
    if (this.adHJ) {}
    for (int i = com.tencent.mm.cd.a.bs(getContext(), R.f.flU);; i = com.tencent.mm.cd.a.bs(getContext(), R.f.flT))
    {
      this.adHG = i;
      this.adHF = (-com.tencent.mm.cd.a.fromDPToPix(getContext(), 330));
      this.adHE = 0;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, bf.bf(getContext()).y);
      localLayoutParams.topMargin = this.adHH;
      localLayoutParams.bottomMargin = (-bf.bk(getContext()));
      this.Ikt.addView(this.storyGallery, 0, localLayoutParams);
      this.adHx.G(this.storyGallery, this.adHG, this.adHH);
      this.adHx.setNavigationBarHeight(bf.bk(getActivity()));
      this.adHx.setTranslationListener(null);
      this.storyGallery.setDataSeed(z.bAM());
      this.storyGallery.a(this.adHx);
      this.storyGallery.setStoryBrowseUIListener(this);
      break;
    }
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(250252);
    if (this.adHC != null)
    {
      com.tencent.mm.plugin.textstatus.a.g localg = this.adHC.MYL;
      if (localg != null) {
        localg.Ds(com.tencent.mm.plugin.auth.a.a.cUx());
      }
    }
    if (this.MVH != null) {
      this.MVH.Ds(com.tencent.mm.plugin.auth.a.a.cUx());
    }
    AppMethodBeat.o(250252);
  }
  
  public final void gBk()
  {
    AppMethodBeat.i(33584);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
    if ((this.adHx != null) && (!this.adHx.isVisible)) {
      this.adHx.jIr();
    }
    if ((!o.isShowStoryCheck()) || (this.tsJ)) {
      this.adHy.aAw(2);
    }
    for (;;)
    {
      if (this.adHC != null) {
        this.adHC.iNw();
      }
      AppMethodBeat.o(33584);
      return;
      this.adHy.aAw(1);
    }
  }
  
  public final void gBl()
  {
    AppMethodBeat.i(33585);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
    if ((this.adHx != null) && (this.adHx.isVisible) && (this.adHK))
    {
      if (!this.tsJ) {
        break label107;
      }
      this.adHy.aAw(2);
    }
    IconPreference localIconPreference;
    for (;;)
    {
      localIconPreference = (IconPreference)this.screen.bAi("settings_my_album");
      if (localIconPreference == null) {
        break label129;
      }
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acYU, true)) {
        break;
      }
      this.adHL = true;
      localIconPreference.aeD(0);
      AppMethodBeat.o(33585);
      return;
      label107:
      this.adHy.aAw(0);
    }
    this.adHL = false;
    localIconPreference.aeD(8);
    label129:
    AppMethodBeat.o(33585);
  }
  
  public final void gBm()
  {
    AppMethodBeat.i(33586);
    Log.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
    if ((this.adHx != null) && (!this.adHx.isVisible)) {
      this.adHx.jIr();
    }
    aAv(0);
    Ln(this.MYi);
    AppMethodBeat.o(33586);
  }
  
  public final void gBn()
  {
    AppMethodBeat.i(250691);
    Log.i("MicroMsg.MoreTabUI", "status statusUINoStatus");
    this.adHx.setSupportOverscroll(false);
    if ((this.adHx != null) && (!this.adHx.isVisible)) {
      this.adHx.jIr();
    }
    this.adHy.aAw(2);
    if (this.adHC != null) {
      this.adHC.iNw();
    }
    AppMethodBeat.o(250691);
  }
  
  public final void gBo()
  {
    AppMethodBeat.i(250696);
    Log.i("MicroMsg.MoreTabUI", "statusUIHasStatus");
    if ((this.adHx != null) && (this.adHx.isVisible) && (this.adHK))
    {
      if (this.tsJ)
      {
        this.adHy.aAw(2);
        AppMethodBeat.o(250696);
        return;
      }
      this.adHy.aAw(3);
    }
    AppMethodBeat.o(250696);
  }
  
  final void gBq()
  {
    AppMethodBeat.i(33590);
    if (com.tencent.mm.compatible.util.d.rb(19))
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
    return R.o.hbi;
  }
  
  public final void hFp()
  {
    AppMethodBeat.i(33583);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchOut");
    this.adHK = false;
    if (this.adHx != null)
    {
      localObject = this.adHx;
      bc.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
      ((PullDownListView)localObject).agiE = false;
      if (!this.adHx.isVisible) {
        this.adHx.jIr();
      }
    }
    if (this.MVH != null) {
      this.MVH.hFp();
    }
    if (this.MVB != null) {
      this.MVB.setVisibility(8);
    }
    aAv(0);
    new aae().publish();
    Lm(false);
    Object localObject = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hyq();
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(50);
    }
    this.adHW = true;
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFA();
    AppMethodBeat.o(33583);
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(33582);
    Log.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
    this.adHK = true;
    jkw();
    Object localObject;
    boolean bool;
    if (getContext() != null)
    {
      localObject = getResources().getConfiguration();
      if (!com.tencent.mm.plugin.textstatus.a.a.kj(getContext()))
      {
        bool = true;
        this.tsJ = bool;
        if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
          break label338;
        }
        bool = true;
        label80:
        this.adHM = bool;
      }
    }
    else if (this.adHx != null)
    {
      localObject = this.adHx;
      bc.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
      ((PullDownListView)localObject).agiE = true;
      if ((!this.adHx.isVisible) || (this.adHx.getTranslationY() == 0.0F)) {
        break label343;
      }
      this.adHx.setTranslationY(0.0F);
    }
    for (;;)
    {
      if (this.storyGallery != null) {
        this.storyGallery.huD();
      }
      if (this.adHW) {}
      try
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (localObject != null) {
          ((com.tencent.mm.plugin.textstatus.proto.p)localObject).sessionId = ((u)com.tencent.mm.kernel.h.ax(u.class)).hFz();
        }
      }
      finally
      {
        for (;;)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.MoreTabUI", localThrowable, "[handleTabSwitchOutForStatus]err", new Object[0]);
        }
      }
      updateStatus();
      if (this.MVH != null) {
        this.MVH.hFq();
      }
      this.adHW = false;
      Lm(true);
      l = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.vY(l);
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyp().jjE = l;
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyp().jkO = System.currentTimeMillis();
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(34);
      }
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).clickBottomTabRedDot();
      AppMethodBeat.o(33582);
      return;
      bool = false;
      break;
      label338:
      bool = false;
      break label80;
      label343:
      if (!this.adHx.isVisible) {
        this.adHx.jIr();
      }
    }
  }
  
  protected final void jhn()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33574);
    Log.i("MicroMsg.MoreTabUI", "onTabCreate:  %s", new Object[] { Integer.valueOf(hashCode()) });
    Object localObject = getResources().getConfiguration();
    if (!com.tencent.mm.plugin.textstatus.a.a.kj(getContext()))
    {
      bool1 = true;
      this.tsJ = bool1;
      if (((((Configuration)localObject).screenLayout & 0x3) == 0) || ((((Configuration)localObject).screenLayout & 0x10) == 0)) {
        break label274;
      }
    }
    label274:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.adHM = bool1;
      this.screen = getPreferenceScreen();
      this.contentView = getContentView();
      com.tencent.mm.compatible.util.a.di(getContext());
      com.tencent.mm.kernel.h.baF();
      this.MVB = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().jY(getContext());
      localObject = new FrameLayout.LayoutParams(com.tencent.mm.cd.a.bs(getContext(), R.f.flS), com.tencent.mm.cd.a.bs(getContext(), R.f.flS));
      ((FrameLayout.LayoutParams)localObject).gravity = 83;
      ((ViewGroup)getContext().findViewById(R.h.pager).getParent()).addView(this.MVB, 0, (ViewGroup.LayoutParams)localObject);
      this.adHx.agiI = this.mPullDownCallback;
      this.adHx.setPadding(this.adHx.getPaddingLeft(), this.adHx.getPaddingTop(), this.adHx.getPaddingRight(), this.GJe.getHeight());
      if (this.Ikt != null)
      {
        Log.d("MicroMsg.MoreTabUI", "dancy test add view !");
        jkx();
      }
      AppMethodBeat.o(33574);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void jho()
  {
    AppMethodBeat.i(33577);
    Log.i("MicroMsg.MoreTabUI", "onTabResume:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (((this.screen instanceof com.tencent.mm.ui.base.preference.h)) && (((com.tencent.mm.ui.base.preference.h)this.screen).adZC == 0L)) {
      ((com.tencent.mm.ui.base.preference.h)this.screen).adZC = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    this.screen = getPreferenceScreen();
    jkw();
    bh.bCz();
    com.tencent.mm.model.c.ban().add(this);
    com.tencent.mm.aa.c.aYo().a(this.PwL);
    jks();
    Object localObject = (IconPreference)this.screen.bAi("settings_my_address");
    if (localObject != null)
    {
      int i = com.tencent.mm.modelverify.d.bNI().jbe();
      if (i > 0)
      {
        ((IconPreference)localObject).afx(0);
        ((IconPreference)localObject).gv(String.valueOf(i), R.g.new_tips_bg);
      }
    }
    else
    {
      jko();
      if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().ffF()) {
        break label763;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
      this.screen.eh("settings_my_finder_album", false);
      localObject = (NormalIconTipPreference)this.screen.bAi("settings_my_finder_album");
      if (!ab.isNullOrNil(z.bAW())) {
        break label752;
      }
      ((NormalIconTipPreference)localObject).bAm(getString(R.l.settings_my_album_finder_no_account));
      label271:
      if (this.observer == null)
      {
        this.observer = new y() {};
        localObject = l.ARA;
        l.dZE().a(this, this.observer);
      }
      localObject = l.ARA;
      l.avu("ProfileEntrance");
      label317:
      jkt();
      jkq();
      if (com.tencent.mm.br.c.blq("favorite")) {
        break label780;
      }
      this.screen.eh("settings_mm_favorite", true);
      label348:
      jkv();
      jku();
      jkp();
      if (((!WeChatEnvironment.isMonkeyEnv()) && (!WeChatEnvironment.isCoolassistEnv())) || (!com.tencent.mm.kernel.h.baA().aw(com.tencent.mm.plugin.at.a.a.class))) {
        break label797;
      }
      this.screen.eh("more_uishow", false);
      label398:
      localObject = this.screen.bAi("settings_privacy_agreements");
      if (!com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
        break label814;
      }
      String str = getString(R.l.privacy_detail);
      Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(str);
      localSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.link_color)), localSpannable.length() - str.length(), localSpannable.length(), 33);
      ((Preference)localObject).setTitle(localSpannable);
      this.screen.eh("settings_privacy_agreements", false);
      label520:
      thisActivity().supportInvalidateOptionsMenu();
      this.screen.notifyDataSetChanged();
      localObject = findViewById(R.h.loading_tips_area);
      if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249301);
            this.adyP.setVisibility(8);
            this.adyP.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), R.a.fast_faded_out));
            AppMethodBeat.o(249301);
          }
        });
      }
      if ((this.adHx != null) && (this.adHx.isVisible))
      {
        aAv(0);
        Log.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
      }
      if (this.storyGallery != null)
      {
        this.storyGallery.onResume();
        this.storyGallery.huD();
      }
      updateStatus();
      if (this.adHC != null)
      {
        localObject = this.adHC;
        if ((!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck()) || (!com.tencent.mm.aa.c.aYo().dV(352279, 266241))) {
          break label831;
        }
      }
    }
    label780:
    label797:
    label814:
    label831:
    for (boolean bool = true;; bool = false)
    {
      ((AccountInfoPreference)localObject).Yma = bool;
      this.adHC.iNx();
      Log.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33577);
      return;
      ((IconPreference)localObject).afx(8);
      ((IconPreference)localObject).gv("", -1);
      break;
      label752:
      ((NormalIconTipPreference)localObject).bAm("");
      break label271;
      label763:
      this.screen.eh("settings_my_finder_album", true);
      break label317;
      this.screen.eh("settings_mm_favorite", false);
      break label348;
      this.screen.eh("more_uishow", true);
      break label398;
      this.screen.eh("settings_privacy_agreements", true);
      break label520;
    }
  }
  
  protected final void jhp()
  {
    AppMethodBeat.i(33578);
    if (this.storyGallery != null) {
      this.storyGallery.onStart();
    }
    AppMethodBeat.o(33578);
  }
  
  protected final void jhq()
  {
    AppMethodBeat.i(33579);
    Log.d("MicroMsg.MoreTabUI", "onTabPause %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.aa.c.aYo().b(this.PwL);
    bh.bCz();
    com.tencent.mm.model.c.ban().remove(this);
    if (this.storyGallery != null) {
      this.storyGallery.onPause();
    }
    if (this.adHx != null)
    {
      if ((this.adHx.isVisible) || (this.MYi)) {
        break label153;
      }
      this.adHx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249340);
          MoreTabUI.o(MoreTabUI.this).jIr();
          AppMethodBeat.o(249340);
        }
      }, 200L);
    }
    for (;;)
    {
      if (this.adHC != null) {
        this.adHC.iNw();
      }
      Lm(false);
      if (this.adHQ != null)
      {
        this.adHQ.adIe = null;
        this.adHQ = null;
      }
      AppMethodBeat.o(33579);
      return;
      label153:
      if ((this.adHx.isVisible) && (this.adHx.getTranslationY() != 0.0F)) {
        this.adHx.setTranslationY(0.0F);
      }
    }
  }
  
  protected final void jhr()
  {
    AppMethodBeat.i(33580);
    if (this.storyGallery != null) {
      this.storyGallery.onStop();
    }
    AppMethodBeat.o(33580);
  }
  
  protected final void jhs()
  {
    AppMethodBeat.i(33581);
    Log.i("MicroMsg.MoreTabUI", "onTabDestroy:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.storyGallery != null) {
      this.storyGallery.onDestroy();
    }
    if (this.adHC != null)
    {
      AccountInfoPreference localAccountInfoPreference = this.adHC;
      if (localAccountInfoPreference.yxr) {
        ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().kc(localAccountInfoPreference.YlW);
      }
    }
    AppMethodBeat.o(33581);
  }
  
  public final void jhu() {}
  
  public final void jhv() {}
  
  public final void jhx() {}
  
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
    this.screen.eh("more_setting", true);
    this.screen.eh("settings_emoji_store", true);
    this.screen.eh("settings_mm_wallet", true);
    this.screen.eh("settings_mm_cardpackage", true);
    this.screen.eh("settings_mm_favorite", true);
    this.screen.eh("settings_my_album", true);
    this.screen.eh("settings_my_finder_album", true);
    this.screen.eh("settings_my_address", true);
    this.screen.eh("more_tab_setting_personal_info", true);
    this.screen.eh("more_uishow", true);
    this.screen.eh("settings_privacy_agreements", true);
    this.GJe = getView().getRootView().findViewById(R.h.fMt);
    this.Ikt = ((RelativeLayout)findViewById(R.h.preference_page));
    this.adHx = ((PullDownListView)getListView());
    this.adHx.setTabView(this.GJe);
    this.adHx.setBackground(bd.by(getContext(), R.d.me_alpha_bg));
    this.adHx.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(33561);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool4 = true;
    boolean bool3 = true;
    AppMethodBeat.i(33573);
    super.onConfigurationChanged(paramConfiguration);
    boolean bool5 = this.adHz;
    int i = paramConfiguration.orientation;
    boolean bool1;
    boolean bool2;
    if (paramConfiguration.orientation == 2)
    {
      bool1 = true;
      if (com.tencent.mm.plugin.textstatus.a.a.kj(getContext())) {
        break label204;
      }
      bool2 = true;
      label51:
      Log.d("MicroMsg.MoreTabUI", "onConfigurationChanged mIsTextStatusOpen:%s orientation:%s isLandScape:%s mIsLandscape2:%s", new Object[] { Boolean.valueOf(bool5), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.adHz) {
        break label250;
      }
      if (com.tencent.mm.plugin.textstatus.a.a.kj(getContext())) {
        break label210;
      }
      bool1 = bool3;
      label114:
      this.tsJ = bool1;
      if (!this.tsJ) {
        break label215;
      }
      if (this.adHx != null)
      {
        if (!this.adHx.isVisible)
        {
          this.adHx.jIs();
          Ll(ac.hFS());
        }
        this.adHy.aAw(2);
      }
      label165:
      if (this.MVQ != null)
      {
        if (!this.tsJ) {
          break label239;
        }
        this.MVQ.setVisibility(8);
      }
    }
    for (;;)
    {
      updateStatus();
      AppMethodBeat.o(33573);
      return;
      bool1 = false;
      break;
      label204:
      bool2 = false;
      break label51;
      label210:
      bool1 = false;
      break label114;
      label215:
      Ll(ac.hFS());
      if (this.adHx == null) {
        break label165;
      }
      this.adHy.jkz();
      break label165;
      label239:
      this.MVQ.setVisibility(0);
    }
    label250:
    if (paramConfiguration.orientation == 1)
    {
      this.tsJ = false;
      if (this.adHx != null) {
        this.adHy.jkz();
      }
      if (((paramConfiguration.screenLayout & 0x3) == 0) || ((paramConfiguration.screenLayout & 0x10) == 0)) {
        break label446;
      }
      bool1 = bool4;
    }
    for (;;)
    {
      if (bool1 != this.adHM)
      {
        this.adHM = bool1;
        if ((this.storyGallery != null) && (this.Ikt != null) && (this.adHx != null))
        {
          this.storyGallery.onDestroy();
          this.Ikt.removeView(this.storyGallery);
          jkx();
          this.storyGallery.onResume();
          if (!this.adHx.isVisible)
          {
            this.adHx.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249065);
                MoreTabUI.o(MoreTabUI.this).jIr();
                AppMethodBeat.o(249065);
              }
            }, 200L);
            AppMethodBeat.o(33573);
            return;
            if (paramConfiguration.orientation != 2) {
              break;
            }
            this.tsJ = true;
            if (this.adHx == null) {
              break;
            }
            if (!this.adHx.isVisible) {
              this.adHx.jIr();
            }
            this.adHy.aAw(2);
            break;
            label446:
            bool1 = false;
            continue;
          }
          if ((this.adHx.isVisible) && (this.adHx.getTranslationY() != 0.0F)) {
            this.adHx.setTranslationY(0.0F);
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
    if ((!bh.baz()) || (bh.aZG()))
    {
      Log.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(bh.baz()), Boolean.valueOf(bh.aZG()) });
      AppMethodBeat.o(33556);
      return;
    }
    this.adHz = ac.hFS();
    jkn();
    Lm(false);
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
      finally
      {
        com.tencent.mm.ui.component.k localk;
        Log.printErrStackTrace("MicroMsg.MoreTabUI", paramBundle, "[initStatusReportData]err", new Object[0]);
        continue;
        bool = false;
        continue;
      }
      if (getBounceView() != null) {
        getBounceView().setStart2EndBgColor(getResources().getColor(R.e.BG_2));
      }
      this.adHP.alive();
      AppMethodBeat.o(33556);
      return;
      bool = false;
      continue;
      localk = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.k.nq(paramBundle).q(com.tencent.mm.plugin.secdata.ui.a.class)).a(new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.p.class, 9));
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramBundle = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
      if (paramBundle != null) {
        paramBundle.sessionId = ((u)com.tencent.mm.kernel.h.ax(u.class)).hFz();
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
    l locall = l.ARA;
    l.dZE().b(this.observer);
    this.adHP.dead();
    ((u)com.tencent.mm.kernel.h.ax(u.class)).hFA();
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
    int i = ab.dE(paramObject);
    Log.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.bCz();
    if ((paramMStorageEx != com.tencent.mm.model.c.ban()) || (i <= 0))
    {
      Log.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(33570);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      jkv();
      AppMethodBeat.o(33570);
      return;
    }
    if (40 == i)
    {
      jku();
      AppMethodBeat.o(33570);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      jkt();
    }
    AppMethodBeat.o(33570);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33558);
    super.onPause();
    Log.i("MicroMsg.MoreTabUI", "onPause:  %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.adHN != null) {
      this.adHN.jZt();
    }
    if (this.adHK)
    {
      com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyq();
    }
    if (this.MVH != null) {
      this.MVH.hFx();
    }
    AppMethodBeat.o(33558);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 0;
    AppMethodBeat.i(33563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPreference == null) {}
    for (localObject = "null";; localObject = paramPreference.mKey)
    {
      Log.i("MicroMsg.MoreTabUI", (String)localObject + " item has been clicked!");
      if (com.tencent.mm.kernel.h.baz()) {
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    boolean bool2;
    if (paramPreference.mKey.equals("settings_mm_wallet"))
    {
      if (!WeChatBrands.Business.Entries.MePayment.checkAvailable(getActivity()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      com.tencent.mm.plugin.newtips.a.gtf().aeI(13);
      bool1 = com.tencent.mm.aa.c.aYo().dV(262156, 266248);
      bool2 = com.tencent.mm.aa.c.aYo().dW(262156, 266248);
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if ((bool1) || (bool2))
      {
        i = 1;
        paramf.b(13341, new Object[] { Integer.valueOf(i) });
        paramf = UUID.randomUUID().toString();
        com.tencent.mm.plugin.report.service.h.OAn.b(14419, new Object[] { paramf, Integer.valueOf(0) });
        paramPreference = new ut();
        paramPreference.hYw.context = getContext();
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_wallet_has_red", bool2);
        ((Intent)localObject).putExtra("key_uuid", paramf);
        paramPreference.hYw.intent = ((Intent)localObject);
        paramPreference.publish();
        com.tencent.mm.aa.c.aYo().dX(262156, 266248);
        com.tencent.mm.aa.c.aYo().c(at.a.acTi, at.a.acTk);
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acSv, "");
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acSw, Integer.valueOf(-1));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUL, Boolean.FALSE);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUH, "");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUI, Boolean.FALSE);
        bool1 = com.tencent.mm.aa.c.aYo().b(at.a.acUP, at.a.acUV);
        if (!bool1) {
          break label2286;
        }
        com.tencent.mm.kernel.h.baF();
        long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUR, Long.valueOf(0L))).longValue();
        if ((l <= 0L) || (System.currentTimeMillis() <= l)) {
          break label2286;
        }
        bool1 = false;
      }
    }
    label2286:
    for (;;)
    {
      com.tencent.mm.aa.c.aYo().c(at.a.acUP, at.a.acUV);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUO, "");
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (bool2) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        if (bool1)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(25075, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
          com.tencent.mm.plugin.report.service.h.OAn.b(25075, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
        i = 0;
        break;
      }
      if (paramPreference.mKey.equals("settings_mm_cardpackage"))
      {
        if (!WeChatBrands.Business.Entries.MeCouponCard.checkAvailable(getActivity()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33563);
          return true;
        }
        com.tencent.mm.plugin.newtips.a.gtf().aeI(14);
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acJn, "");
        new Intent().putExtra("key_from_scene", 22);
        Log.i("MicroMsg.MoreTabUI", "enter to cardhome");
        paramf = new mg();
        paramf.hOp.context = getContext();
        paramf.hOp.enterScene = 1;
        paramf.publish();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      int j;
      if (paramPreference.mKey.equals("settings_my_album"))
      {
        bh.bCz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          aa.j(getContext(), null);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(36);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33563);
          return true;
        }
        bh.bCz();
        paramf = (String)com.tencent.mm.model.c.ban().d(2, null);
        paramPreference = new Intent(getContext(), AlbumUI.class);
        paramPreference.putExtra("sns_userName", paramf);
        paramPreference.putExtra("username", paramf);
        paramPreference.putExtra("story_dot", this.adHL);
        paramPreference.setFlags(536870912);
        paramPreference.addFlags(67108864);
        bh.bCz();
        j = ab.n((Integer)com.tencent.mm.model.c.ban().d(68389, null));
        bh.bCz();
        com.tencent.mm.model.c.ban().B(68389, Integer.valueOf(j + 1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (((NormalIconNewTipPreference)this.screen.bAi("settings_my_album")).adYn == 0) {
          i = 1;
        }
        paramPreference = (com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class);
        if (i != 0) {}
        for (paramf = "1";; paramf = "0")
        {
          paramPreference.report22208(12L, paramf);
          break;
        }
      }
      if (paramPreference.mKey.equals("settings_my_finder_album"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(21908, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        paramf = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("ProfileEntrance");
        paramPreference = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("ProfileEntrance");
        if ((paramf != null) && (paramPreference != null)) {
          w.FrV.a("12", paramPreference, paramf, 2, "", 0, 0, 0);
        }
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("ProfileEntrance");
        paramf = new Intent();
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderSelfProfile(getContext(), paramf, 13, 2);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      if (paramPreference.mKey.equals("settings_mm_favorite"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "8");
        com.tencent.mm.plugin.report.service.h.OAn.b(14103, new Object[] { Integer.valueOf(0) });
        com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
        com.tencent.mm.xwebutil.c.jQE();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      if (paramPreference.mKey.equals("settings_emoji_store"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "7");
        com.tencent.mm.aa.c.aYo().dX(262147, 266244);
        com.tencent.mm.aa.c.aYo().dX(262149, 266244);
        paramf = new Intent();
        paramf.putExtra("preceding_scence", 2);
        com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
        com.tencent.mm.plugin.report.service.h.OAn.b(12065, new Object[] { Integer.valueOf(1) });
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).gs(com.tencent.mm.plugin.boots.a.b.vyx, 881);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      if (paramPreference.mKey.equals("more_setting"))
      {
        com.tencent.mm.plugin.newtips.a.gtf().aeI(30);
        bool1 = com.tencent.mm.aa.c.aYo().dV(262145, 266242);
        com.tencent.mm.aa.c.aYo().dX(262145, 266242);
        com.tencent.mm.aa.c.aYo().dX(262157, 266261);
        com.tencent.mm.aa.c.aYo().dX(262158, 266264);
        com.tencent.mm.aa.c.aYo().b(at.a.acWf, 266242);
        com.tencent.mm.aa.c.aYo().dX(262164, 266268);
        paramPreference = new Intent();
        com.tencent.mm.br.c.b(getContext(), "setting", ".ui.setting.SettingsUI", paramPreference);
        bh.bCz();
        i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acQl, Integer.valueOf(0))).intValue();
        bh.bCz();
        j = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acQm, Integer.valueOf(0))).intValue();
        if ((!bool1) && (i > j))
        {
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acQm, Integer.valueOf(i));
          paramf = (IconPreference)paramf.bAi("more_setting");
          if (paramf != null) {
            paramf.aeD(8);
          }
          com.tencent.mm.aa.c.aYo().dX(266260, 266241);
        }
        ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      if (paramPreference.mKey.equals("more_uishow"))
      {
        paramf = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
        paramf.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymouss)
          {
            AppMethodBeat.i(249061);
            paramAnonymouss.c(0, "LiteAppList");
            paramAnonymouss.c(3, "weui");
            paramAnonymouss.c(4, "KindaUI");
            AppMethodBeat.o(249061);
          }
        };
        paramf.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(249057);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(249057);
              return;
              MoreTabUI.h(MoreTabUI.this);
              AppMethodBeat.o(249057);
              return;
              MoreTabUI.i(MoreTabUI.this);
              AppMethodBeat.o(249057);
              return;
              MoreTabUI.j(MoreTabUI.this);
              AppMethodBeat.o(249057);
              return;
              MoreTabUI.k(MoreTabUI.this);
              AppMethodBeat.o(249057);
              return;
              MoreTabUI.jky();
            }
          }
        };
        paramf.dDn();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      if (paramPreference.mKey.equals("settings_privacy_agreements"))
      {
        com.tencent.mm.plugin.account.sdk.c.a.b(getActivity(), getString(R.l.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.kernel.h.baE().ban().d(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0) }), 0, true);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33563);
        return true;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33563);
      return false;
    }
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33562);
    if (!com.tencent.mm.kernel.h.baz())
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
          bool = Lk(true);
          AppMethodBeat.o(33562);
          return bool;
        }
        if (Util.nullAsNil(paramPreference.mKey).equals("more_setting"))
        {
          bool = Lk(false);
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
    jkn();
    if (this.adHK)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.vY(l);
      localh = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyp().jjE = l;
    }
    AppMethodBeat.o(33557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class c
  {
    private int status = 2;
    
    private c() {}
    
    public final void aAw(int paramInt)
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
        gBt();
        AppMethodBeat.o(33554);
        return;
        MoreTabUI.e(MoreTabUI.this, false);
        break;
        label77:
        MoreTabUI.d(MoreTabUI.this, false);
      }
    }
    
    public final void gBt()
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
        MoreTabUI.o(MoreTabUI.this).setSelector(R.e.BG_0);
        if (MoreTabUI.this.getBounceView() != null) {
          MoreTabUI.this.getBounceView().NI(false);
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
        MoreTabUI.this.getBounceView().NI(true);
        break;
        if ((MoreTabUI.r(MoreTabUI.this) != null) && (MoreTabUI.r(MoreTabUI.this).hFr())) {}
        for (boolean bool = true;; bool = false)
        {
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(bool);
          MoreTabUI.o(MoreTabUI.this).setBackground(null);
          MoreTabUI.o(MoreTabUI.this).setMuteView(null);
          MoreTabUI.o(MoreTabUI.this).oS(com.tencent.mm.plugin.textstatus.a.a.ki(MoreTabUI.this.getActivity()), com.tencent.mm.plugin.textstatus.a.a.kk(MoreTabUI.this.getActivity())[1]);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.B(MoreTabUI.this));
          if (MoreTabUI.s(MoreTabUI.this) == null) {
            break;
          }
          MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
        }
        MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(true);
        MoreTabUI.w(MoreTabUI.this);
        if (MoreTabUI.v(MoreTabUI.this)) {
          MoreTabUI.o(MoreTabUI.this).setBackground(bd.by(MoreTabUI.this.getContext(), R.d.me_normal_bg));
        }
        for (;;)
        {
          if (MoreTabUI.m(MoreTabUI.this) != null)
          {
            ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.C(MoreTabUI.this);
            MoreTabUI.o(MoreTabUI.this).G(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.C(MoreTabUI.this));
          }
          MoreTabUI.o(MoreTabUI.this).setMuteView(null);
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.b(MoreTabUI.this, 0);
          MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          if (MoreTabUI.s(MoreTabUI.this) != null) {
            MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          }
          MoreTabUI.o(MoreTabUI.this).jIm();
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.o(MoreTabUI.this).setBackground(bd.by(MoreTabUI.this.getContext(), R.d.me_alpha_bg));
        }
        MoreTabUI.o(MoreTabUI.this).setBackground(bd.by(MoreTabUI.this.getContext(), R.d.me_alpha_bg));
        MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.E(MoreTabUI.this);
        MoreTabUI.c(MoreTabUI.this, com.tencent.mm.cd.a.bs(MoreTabUI.this.getContext(), R.f.flT));
        if (MoreTabUI.m(MoreTabUI.this) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.m(MoreTabUI.this).getLayoutParams()).topMargin = MoreTabUI.F(MoreTabUI.this);
          MoreTabUI.o(MoreTabUI.this).G(MoreTabUI.m(MoreTabUI.this), MoreTabUI.D(MoreTabUI.this), MoreTabUI.F(MoreTabUI.this));
        }
        MoreTabUI.o(MoreTabUI.this).setMuteView(MoreTabUI.A(MoreTabUI.this));
        MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.b(MoreTabUI.this, 0);
        MoreTabUI.b(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
        MoreTabUI.o(MoreTabUI.this).jIm();
        if (MoreTabUI.s(MoreTabUI.this) != null)
        {
          MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          AppMethodBeat.o(33552);
          return;
          MoreTabUI.o(MoreTabUI.this).setBackground(bd.by(MoreTabUI.this.getContext(), R.d.me_normal_bg));
          MoreTabUI.o(MoreTabUI.this).setSupportOverscroll(MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.o(MoreTabUI.this).jIm();
          MoreTabUI.c(MoreTabUI.this, MoreTabUI.n(MoreTabUI.this));
          MoreTabUI.t(MoreTabUI.this);
          if (MoreTabUI.s(MoreTabUI.this) != null) {
            MoreTabUI.s(MoreTabUI.this).p(MoreTabUI.n(MoreTabUI.this), MoreTabUI.v(MoreTabUI.this), MoreTabUI.B(MoreTabUI.this));
          }
        }
      }
    }
    
    public final void jkz()
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
          gBt();
          AppMethodBeat.o(33553);
          return;
          if (((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.cUx()))
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
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(z.bAM()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI
 * JD-Core Version:    0.7.0.1
 */