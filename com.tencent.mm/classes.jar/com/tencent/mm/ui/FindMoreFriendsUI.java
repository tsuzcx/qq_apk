package com.tencent.mm.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.a.abk;
import com.tencent.mm.autogen.a.adw;
import com.tencent.mm.autogen.a.ii;
import com.tencent.mm.autogen.a.ko;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.autogen.a.kq;
import com.tencent.mm.autogen.a.li;
import com.tencent.mm.autogen.a.lx;
import com.tencent.mm.autogen.a.lx.a;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.autogen.a.nl;
import com.tencent.mm.autogen.a.qw;
import com.tencent.mm.autogen.a.ss;
import com.tencent.mm.autogen.a.ss.a;
import com.tencent.mm.autogen.a.uk;
import com.tencent.mm.autogen.a.wl;
import com.tencent.mm.autogen.a.wn;
import com.tencent.mm.autogen.a.xh;
import com.tencent.mm.autogen.a.xl;
import com.tencent.mm.autogen.a.xl.b;
import com.tencent.mm.autogen.a.xn;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelimage.s;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.ui.MMFBFriendUI;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.ar.a;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.fjr;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class FindMoreFriendsUI
  extends AbstractTabChildPreference
  implements com.tencent.mm.model.bc, com.tencent.mm.model.bd, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static int adxX = 1000;
  public com.tencent.mm.ui.base.preference.h FUv;
  private IListener<adw> HzL;
  private IListenerMStorage IVx;
  private CheckBox MoT;
  private com.tencent.mm.ui.widget.a.e MoV;
  s.a MrK;
  public int PtI;
  IListener QvD;
  private View UfQ;
  private IListenerMStorage Ymn;
  private long adxY;
  private View adxZ;
  private boolean adyA;
  private com.tencent.mm.ui.findmore.a.a adyB;
  private Random adyC;
  private boolean adyD;
  private boolean adyE;
  private String adya;
  private int adyb;
  private String adyc;
  private String adyd;
  private String adye;
  private String adyf;
  private String adyg;
  private boolean adyh;
  private boolean adyi;
  private boolean adyj;
  private boolean adyk;
  private int adyl;
  private long adym;
  private int adyn;
  private TextView adyo;
  private IListener<wl> adyp;
  IListener adyq;
  IListener adyr;
  private IListenerMStorage adys;
  private IListenerMStorage adyt;
  private IListener adyu;
  private String adyv;
  private a adyw;
  private com.tencent.mm.plugin.messenger.foundation.a.t adyx;
  private IListener<li> adyy;
  private com.tencent.mm.ui.findmore.a.b adyz;
  public boolean hNd;
  private MMHandler mHandler;
  private y<l.a> observer;
  private com.tencent.mm.ui.widget.b.a rHs;
  private int status;
  private long xct;
  
  public FindMoreFriendsUI()
  {
    AppMethodBeat.i(33078);
    this.MoV = null;
    this.adya = "";
    this.adyb = 0;
    this.adyc = null;
    this.adyd = null;
    this.adye = null;
    this.adyf = null;
    this.adyg = null;
    this.adyh = false;
    this.adyi = false;
    this.adyj = true;
    this.hNd = false;
    this.adyk = false;
    this.adyl = 0;
    this.adym = 0L;
    this.mHandler = new FindMoreFriendsUI.1(this, Looper.getMainLooper());
    this.adyp = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Ymn = new FindMoreFriendsUI.3(this);
    this.QvD = new FindMoreFriendsUI.4(this, com.tencent.mm.app.f.hfK);
    this.adyq = new FindMoreFriendsUI.5(this, com.tencent.mm.app.f.hfK);
    this.adyr = new FindMoreFriendsUI.6(this, com.tencent.mm.app.f.hfK);
    this.IVx = new IListenerMStorage()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(33072);
        if ((paramAnonymousIEvent instanceof kp))
        {
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, false);
          FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(33072);
      }
    };
    this.adys = new IListenerMStorage()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(33073);
        if ((paramAnonymousIEvent instanceof ko))
        {
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, true);
          FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(33073);
      }
    };
    this.adyt = new FindMoreFriendsUI.9(this);
    this.adyu = new FindMoreFriendsUI.10(this, com.tencent.mm.app.f.hfK);
    this.adyw = a.adyV;
    this.adyx = new FindMoreFriendsUI.12(this);
    this.HzL = new IListener(com.tencent.mm.app.f.hfK) {};
    this.adyy = new FindMoreFriendsUI.18(this, com.tencent.mm.app.f.hfK);
    this.MrK = new s.a()
    {
      public final void onLoadImageEnd(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(250003);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249231);
            Object localObject = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
            if (paramAnonymousBitmap == null) {}
            for (boolean bool = true;; bool = false)
            {
              Log.i("MicroMsg.FindMoreFriendsUI", bool);
              localObject = (IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("jd_market_entrance");
              if (localObject != null)
              {
                if (paramAnonymousString1.equals(FindMoreFriendsUI.j(FindMoreFriendsUI.this)))
                {
                  ((IconPreference)localObject).bd(paramAnonymousBitmap);
                  FindMoreFriendsUI.d(FindMoreFriendsUI.this, null);
                }
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.k(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("find_friends_by_look")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), paramAnonymousBitmap);
                FindMoreFriendsUI.l(FindMoreFriendsUI.this);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.m(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("find_friends_by_search")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), paramAnonymousBitmap);
                FindMoreFriendsUI.n(FindMoreFriendsUI.this);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.o(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("find_friends_by_look")).bd(paramAnonymousBitmap);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.p(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("find_friends_by_search")).bd(paramAnonymousBitmap);
                FindMoreFriendsUI.c(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.q(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).bAi("my_life_around")).bd(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(249231);
              return;
            }
          }
        });
        AppMethodBeat.o(250003);
      }
    };
    this.adyz = null;
    this.observer = null;
    this.adyA = false;
    this.adyB = null;
    this.adyC = new Random();
    this.adyD = false;
    this.adyE = false;
    AppMethodBeat.o(33078);
  }
  
  private void KX(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(33087);
    boolean bool1 = bool2;
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null)
    {
      if (!com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAQ()) {
        break label657;
      }
      this.adyn += 1;
      localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN();
      localObject2 = (NormalIconNewTipPreference)this.FUv.bAi("jd_market_entrance");
      com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
      ((NormalIconNewTipPreference)localObject2).setTitle(com.tencent.mm.plugin.subapp.jdbiz.d.hAR());
      ((NormalIconNewTipPreference)localObject2).a(this.FUv);
      com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject2);
      ((NormalIconNewTipPreference)localObject2).a(this.MrK, new NormalIconNewTipPreference.a()
      {
        public final void aPT(String paramAnonymousString)
        {
          AppMethodBeat.i(249881);
          FindMoreFriendsUI.d(FindMoreFriendsUI.this, paramAnonymousString);
          AppMethodBeat.o(249881);
        }
      });
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
      if ((!com.tencent.mm.plugin.subapp.jdbiz.d.hAJ()) || (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).isStart()) || (((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).dgl())) {
        break label519;
      }
      bool1 = true;
      if ((!bool1) || ((Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEC)) && (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SED)) && (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEB))) {
        break label524;
      }
      bool2 = true;
      label173:
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool2, (com.tencent.mm.plugin.newtips.a.a)localObject2))
      {
        ((NormalIconNewTipPreference)localObject2).afx(8);
        ((NormalIconNewTipPreference)localObject2).aeD(8);
        ((NormalIconNewTipPreference)localObject2).aBf(8);
        ((NormalIconNewTipPreference)localObject2).LF(false);
        ((NormalIconNewTipPreference)localObject2).aBi(8);
        if (!bool1) {
          break label649;
        }
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEC))
        {
          ((NormalIconNewTipPreference)localObject2).afx(8);
          ((NormalIconNewTipPreference)localObject2).aeD(8);
          ((NormalIconNewTipPreference)localObject2).bd(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEC, -1, -7566196);
          ((NormalIconNewTipPreference)localObject2).aBf(0);
        }
        if (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SED)) {
          break label569;
        }
        com.tencent.mm.modelimage.r.bJZ();
        Bitmap localBitmap = com.tencent.mm.modelimage.e.Eo(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SED);
        ((NormalIconNewTipPreference)localObject2).aBi(0);
        ((NormalIconNewTipPreference)localObject2).aBh(0);
        ((NormalIconNewTipPreference)localObject2).aBj(0);
        ((NormalIconNewTipPreference)localObject2).LF(false);
        if (localBitmap == null) {
          break label529;
        }
        this.adyg = null;
        ((NormalIconNewTipPreference)localObject2).bd(localBitmap);
        label331:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEC)) {
          break label556;
        }
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, com.tencent.mm.plugin.newtips.a.k.MsO, true);
        label352:
        ef("jd_market_entrance", bool1);
      }
      if (paramBoolean) {
        this.FUv.notifyDataSetChanged();
      }
      paramBoolean = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acZy, false);
      if ((!jij()) || (paramBoolean))
      {
        localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAV().username;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAU();
        }
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZy, Boolean.FALSE);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 12);
        com.tencent.mm.plugin.report.service.h.OAn.b(11178, new Object[] { localObject1, com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN().rBJ, Integer.valueOf(jin()), Integer.valueOf(2) });
      }
      bool1 = false;
    }
    for (;;)
    {
      this.FUv.eh("jd_market_entrance", bool1);
      AppMethodBeat.o(33087);
      return;
      label519:
      bool1 = false;
      break;
      label524:
      bool2 = false;
      break label173;
      label529:
      com.tencent.mm.modelimage.r.bKd().a(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SED, this.MrK);
      this.adyg = ((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SED;
      break label331;
      label556:
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, com.tencent.mm.plugin.newtips.a.k.MsN, true);
      break label352;
      label569:
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEC))
      {
        ((NormalIconNewTipPreference)localObject2).LF(true);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, com.tencent.mm.plugin.newtips.a.k.MsM, true);
        break label352;
      }
      if (((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).SEB)
      {
        ((NormalIconNewTipPreference)localObject2).aeD(0);
        ((NormalIconNewTipPreference)localObject2).gv("", -1);
        ((NormalIconNewTipPreference)localObject2).afx(8);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, com.tencent.mm.plugin.newtips.a.k.MsK, true);
        break label352;
      }
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      break label352;
      label649:
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      break label352;
      label657:
      com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
      localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.hAR();
      com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
      localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.hAS();
      bool1 = bool2;
      if (!jij())
      {
        bool1 = bool2;
        if (LocaleUtil.isSimplifiedChineseAppLang())
        {
          if (Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 2);
          }
          bool1 = bool2;
          if (Util.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 4);
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private static void KY(boolean paramBoolean)
  {
    AppMethodBeat.i(33098);
    b.a.fCn().wc(paramBoolean);
    AppMethodBeat.o(33098);
  }
  
  /* Error */
  private void a(final ss paramss1, final IconPreference paramIconPreference, ss paramss2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 575
    //   5: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   12: getfield 586	com/tencent/mm/autogen/a/ss$a:icon	Ljava/lang/String;
    //   15: astore 10
    //   17: aload_1
    //   18: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   21: getfield 589	com/tencent/mm/autogen/a/ss$a:iconWidth	I
    //   24: istore 5
    //   26: aload_1
    //   27: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   30: getfield 592	com/tencent/mm/autogen/a/ss$a:iconHeight	I
    //   33: istore 6
    //   35: aload_1
    //   36: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   39: getfield 595	com/tencent/mm/autogen/a/ss$a:hVZ	Z
    //   42: istore 7
    //   44: aload 10
    //   46: invokestatic 373	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   49: ifne +14 -> 63
    //   52: aload_2
    //   53: ifnull +10 -> 63
    //   56: aload_2
    //   57: invokevirtual 601	com/tencent/mm/ui/base/preference/IconPreference:jnm	()Landroid/widget/ImageView;
    //   60: ifnonnull +12 -> 72
    //   63: ldc_w 575
    //   66: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: ldc_w 603
    //   75: ldc_w 605
    //   78: iconst_3
    //   79: anewarray 500	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload 10
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: iload 5
    //   91: invokestatic 513	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: iload 6
    //   99: invokestatic 513	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 610	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: iload 5
    //   108: ifle +28 -> 136
    //   111: iload 6
    //   113: ifle +23 -> 136
    //   116: aload_2
    //   117: invokestatic 616	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   120: iload 5
    //   122: invokestatic 622	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   125: invokestatic 616	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   128: iload 5
    //   130: invokestatic 622	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   133: invokevirtual 625	com/tencent/mm/ui/base/preference/IconPreference:oo	(II)V
    //   136: aload_3
    //   137: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   140: getfield 628	com/tencent/mm/autogen/a/ss$a:msgId	J
    //   143: lstore 8
    //   145: aload_3
    //   146: getfield 581	com/tencent/mm/autogen/a/ss:hVY	Lcom/tencent/mm/autogen/a/ss$a;
    //   149: getfield 630	com/tencent/mm/autogen/a/ss$a:hAN	I
    //   152: istore 5
    //   154: new 632	com/tencent/mm/autogen/a/kq
    //   157: dup
    //   158: invokespecial 633	com/tencent/mm/autogen/a/kq:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: getfield 637	com/tencent/mm/autogen/a/kq:hMl	Lcom/tencent/mm/autogen/a/kq$a;
    //   166: iconst_1
    //   167: putfield 642	com/tencent/mm/autogen/a/kq$a:bUl	I
    //   170: aload_1
    //   171: getfield 637	com/tencent/mm/autogen/a/kq:hMl	Lcom/tencent/mm/autogen/a/kq$a;
    //   174: aload 10
    //   176: putfield 645	com/tencent/mm/autogen/a/kq$a:url	Ljava/lang/String;
    //   179: aload_1
    //   180: invokevirtual 648	com/tencent/mm/autogen/a/kq:publish	()Z
    //   183: pop
    //   184: aload_1
    //   185: getfield 652	com/tencent/mm/autogen/a/kq:hMm	Lcom/tencent/mm/autogen/a/kq$b;
    //   188: getfield 657	com/tencent/mm/autogen/a/kq$b:hMo	Z
    //   191: ifeq +99 -> 290
    //   194: new 659	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 660	java/lang/StringBuilder:<init>	()V
    //   201: aload_1
    //   202: getfield 652	com/tencent/mm/autogen/a/kq:hMm	Lcom/tencent/mm/autogen/a/kq$b;
    //   205: getfield 663	com/tencent/mm/autogen/a/kq$b:hMn	Ljava/lang/String;
    //   208: invokevirtual 667	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 10
    //   213: invokevirtual 673	java/lang/String:getBytes	()[B
    //   216: invokestatic 679	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   219: invokevirtual 667	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 682	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_3
    //   226: new 684	com/tencent/mm/modelimage/loader/a/c$a
    //   229: dup
    //   230: invokespecial 685	com/tencent/mm/modelimage/loader/a/c$a:<init>	()V
    //   233: astore 11
    //   235: aload 11
    //   237: iconst_1
    //   238: putfield 688	com/tencent/mm/modelimage/loader/a/c$a:oKp	Z
    //   241: aload 11
    //   243: aload_3
    //   244: putfield 691	com/tencent/mm/modelimage/loader/a/c$a:fullPath	Ljava/lang/String;
    //   247: aload 11
    //   249: invokevirtual 695	com/tencent/mm/modelimage/loader/a/c$a:bKx	()Lcom/tencent/mm/modelimage/loader/a/c;
    //   252: astore_3
    //   253: invokestatic 699	com/tencent/mm/modelimage/r:bKe	()Lcom/tencent/mm/modelimage/loader/a;
    //   256: aload 10
    //   258: aconst_null
    //   259: aload_3
    //   260: new 701	com/tencent/mm/ui/FindMoreFriendsUI$32
    //   263: dup
    //   264: aload_0
    //   265: aload_1
    //   266: invokespecial 704	com/tencent/mm/ui/FindMoreFriendsUI$32:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;Lcom/tencent/mm/autogen/a/kq;)V
    //   269: new 36	com/tencent/mm/ui/FindMoreFriendsUI$33
    //   272: dup
    //   273: aload_0
    //   274: iload 7
    //   276: aload_1
    //   277: aload_2
    //   278: iload 5
    //   280: lload 8
    //   282: aload 4
    //   284: invokespecial 707	com/tencent/mm/ui/FindMoreFriendsUI$33:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;ZLcom/tencent/mm/autogen/a/kq;Lcom/tencent/mm/ui/base/preference/IconPreference;IJLjava/lang/String;)V
    //   287: invokevirtual 712	com/tencent/mm/modelimage/loader/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/modelimage/loader/a/c;Lcom/tencent/mm/modelimage/loader/b/k;Lcom/tencent/mm/modelimage/loader/b/h;)V
    //   290: ldc_w 575
    //   293: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: goto -227 -> 69
    //   299: astore_1
    //   300: aload_0
    //   301: monitorexit
    //   302: aload_1
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	FindMoreFriendsUI
    //   0	304	1	paramss1	ss
    //   0	304	2	paramIconPreference	IconPreference
    //   0	304	3	paramss2	ss
    //   0	304	4	paramString	String
    //   24	255	5	i	int
    //   33	79	6	j	int
    //   42	233	7	bool	boolean
    //   143	138	8	l	long
    //   15	242	10	str	String
    //   233	15	11	locala	com.tencent.mm.modelimage.loader.a.c.a
    // Exception table:
    //   from	to	target	type
    //   2	52	299	finally
    //   56	63	299	finally
    //   63	69	299	finally
    //   72	106	299	finally
    //   116	136	299	finally
    //   136	290	299	finally
    //   290	296	299	finally
  }
  
  private void a(ar.a parama, IconPreference paramIconPreference)
  {
    AppMethodBeat.i(33083);
    MMHandlerThread.postToMainThread(new FindMoreFriendsUI.15(this, paramIconPreference, parama));
    AppMethodBeat.o(33083);
  }
  
  private static void a(fng paramfng, hq paramhq)
  {
    AppMethodBeat.i(249656);
    if ((paramhq == null) || (paramhq.YIX == null))
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "analysisRedDotXml attributeXml empty");
      AppMethodBeat.o(249656);
      return;
    }
    if ((TextUtils.isEmpty(paramhq.YIX.title)) && ((paramhq.YIX.Zpp == null) || ((TextUtils.isEmpty(paramhq.YIX.Zpp.uCW)) && (TextUtils.isEmpty(paramhq.YIX.Zpp.iconUrl)))))
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "analysisRedDotXml invalid attributeXml!");
      AppMethodBeat.o(249656);
      return;
    }
    paramfng.title = paramhq.YIX.title;
    if (paramhq.YIX.Zpp != null)
    {
      paramfng.abNo = paramhq.YIX.Zpp.uCW;
      paramfng.abNq = paramhq.YIX.Zpp.iconUrl;
      paramfng.abNp = paramhq.YIX.Zpp.abKn;
      paramfng.abNr = paramhq.YIX.Zpp.abKo;
    }
    paramfng.abNs = true;
    AppMethodBeat.o(249656);
  }
  
  private void a(final FinderIconViewTipPreference paramFinderIconViewTipPreference, final int paramInt, long paramLong)
  {
    AppMethodBeat.i(249653);
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249779);
        bxq localbxq = new bxq();
        localbxq.show_type = paramInt;
        localbxq.title = FindMoreFriendsUI.x(FindMoreFriendsUI.this);
        localbxq.icon_url = FindMoreFriendsUI.jiA();
        localbxq.count = FindMoreFriendsUI.jiB();
        localbxq.aagt.addAll(FindMoreFriendsUI.jiC());
        FindMoreFriendsUI.this.a(localbxq, paramFinderIconViewTipPreference, this.adyS, ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs(), this.adyT);
        AppMethodBeat.o(249779);
      }
    }, paramLong);
    AppMethodBeat.o(249653);
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(33100);
    paramIconPreference.afx(paramInt1);
    paramIconPreference.aeD(paramInt2);
    paramIconPreference.aBf(paramInt3);
    paramIconPreference.LF(paramBoolean);
    paramIconPreference.aBi(paramInt4);
    paramIconPreference.aBh(paramInt5);
    paramIconPreference.aBj(paramInt6);
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramBoolean) || (paramInt4 == 0) || (paramInt5 == 0) || (paramInt6 == 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ef("more_tab_game_recommend", paramBoolean);
      AppMethodBeat.o(33100);
      return;
    }
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(33082);
    paramIconPreference.aeD(paramInt1);
    paramIconPreference.aBf(paramInt2);
    paramIconPreference.LF(paramBoolean);
    paramIconPreference.aBi(paramInt3);
    paramIconPreference.aBh(paramInt4);
    paramIconPreference.aBj(paramInt5);
    AppMethodBeat.o(33082);
  }
  
  private void a(boolean paramBoolean, FinderIconViewTipPreference paramFinderIconViewTipPreference)
  {
    AppMethodBeat.i(249651);
    FinderIconViewTipPreference localFinderIconViewTipPreference = paramFinderIconViewTipPreference;
    if (paramFinderIconViewTipPreference == null)
    {
      localFinderIconViewTipPreference = paramFinderIconViewTipPreference;
      if (this.FUv != null) {
        localFinderIconViewTipPreference = (FinderIconViewTipPreference)this.FUv.bAi("find_friends_by_finder");
      }
    }
    int j;
    int i;
    if (localFinderIconViewTipPreference != null)
    {
      j = localFinderIconViewTipPreference.getRowCount();
      i = localFinderIconViewTipPreference.getDropStat();
    }
    for (;;)
    {
      paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      m.a.h(paramBoolean, j, i);
      AppMethodBeat.o(249651);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private static void aO(long paramLong, int paramInt)
  {
    AppMethodBeat.i(33097);
    com.tencent.mm.kernel.h.baF();
    if (paramLong != com.tencent.mm.kernel.h.baE().ban().a(at.a.acUo, 0L))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUo, Long.valueOf(paramLong));
      com.tencent.mm.plugin.game.api.b localb = b.a.fCn();
      if (localb != null) {
        localb.al(paramLong, paramInt);
      }
    }
    AppMethodBeat.o(33097);
  }
  
  private static void b(fng paramfng)
  {
    AppMethodBeat.i(249654);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Integer)com.tencent.mm.plugin.finder.storage.d.eUz().bmg()).intValue();
    localObject = new Random();
    if (i > 0)
    {
      paramfng.abNo = "8.6万人";
      paramfng.abNp = "#FA9D3B";
      paramfng.abNr = "#56FA9D3B";
      if ((i == 2) || (i == 4)) {
        if (((Random)localObject).nextInt(10) % 2 != 0) {
          break label106;
        }
      }
    }
    label106:
    for (paramfng.abNq = "http://dldir1.qq.com/weixin/checkresupdate/icons_filled_fire_v1_3e6119848137473b86dd83e917afe31b.png";; paramfng.abNq = "http://dldir1.qq.com/weixin/checkresupdate/heart_d0713c51c1cb4a18b62d562fafefac53.png")
    {
      if ((i == 3) || (i == 4)) {
        paramfng.abNs = true;
      }
      AppMethodBeat.o(249654);
      return;
    }
  }
  
  private void bJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(249601);
    int i = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getTimelineCommentScene();
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 0L, 1L, false);
    Object localObject2 = new Intent();
    String str = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(1, 1, i, (Intent)localObject2);
    Object localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
    localObject1 = m.a.ai(str, 0, 0);
    ((Intent)localObject2).putExtra("key_red_dot_id", (String)localObject1);
    if (paramBoolean1) {
      ((Intent)localObject2).putExtra("KEY_ROUTE_TO_PAGE", FinderSelfUI.class.getSimpleName());
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderTimelineUI(getContext(), (Intent)localObject2, Boolean.TRUE);
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.id(str, "Enter");
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.ic(str, (String)localObject1);
      AppMethodBeat.o(249601);
      return;
      if (paramBoolean2) {
        ((Intent)localObject2).putExtra("KEY_ROUTE_TO_TOPIC", true);
      }
    }
  }
  
  private boolean bZX()
  {
    AppMethodBeat.i(249541);
    boolean bool3 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    boolean bool1;
    if (!ju(34359738368L))
    {
      bool1 = true;
      if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
        break label129;
      }
    }
    label129:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label134;
      }
      AppMethodBeat.o(249541);
      return true;
      bool1 = false;
      break;
    }
    label134:
    AppMethodBeat.o(249541);
    return false;
  }
  
  private void bbC()
  {
    AppMethodBeat.i(161495);
    this.adyq.dead();
    this.adyp.dead();
    this.adyr.dead();
    this.QvD.dead();
    this.adyu.dead();
    this.HzL.dead();
    this.adyy.dead();
    if (bh.baz())
    {
      IListenerMStorage.b(nl.class.getName(), this.Ymn);
      IListenerMStorage.b(kp.class.getName(), this.IVx);
      IListenerMStorage.b(xh.class.getName(), this.adyt);
      IListenerMStorage.b(ko.class.getName(), this.adys);
      com.tencent.mm.modelverify.d.bNK().remove(this);
      bh.bCz();
      com.tencent.mm.model.c.bzG().remove(this);
      bh.bCz();
      com.tencent.mm.model.c.b(this);
      bh.bCz();
      com.tencent.mm.model.c.ban().remove(this);
      if (this.adyg != null) {
        com.tencent.mm.modelimage.r.bJZ().NO(this.adyg);
      }
    }
    if (com.tencent.mm.plugin.sns.c.q.Qkm != null) {
      com.tencent.mm.plugin.sns.c.q.Qkm.b(this);
    }
    AppMethodBeat.o(161495);
  }
  
  public static void ef(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249659);
    Log.i("MicroMsg.FindMoreFriendsUI", "note entry red dot [%s] entry [%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ii localii = new ii();
    localii.hJO.hJP = paramString;
    localii.hJO.hJQ = paramBoolean;
    localii.publish();
    AppMethodBeat.o(249659);
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(33084);
    int j = bf.fs(getContext());
    int i = bf.I(getContext(), -1);
    View localView = getView().getRootView().findViewById(R.h.action_bar_container);
    if (aw.jkY())
    {
      if (localView != null)
      {
        i = localView.getTop();
        AppMethodBeat.o(33084);
        return i + j;
      }
      AppMethodBeat.o(33084);
      return i + j;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label215;
        }
      }
      label210:
      label215:
      for (boolean bool2 = localSharedPreferences.getBoolean("Main_need_read_top_margin", false);; bool2 = false)
      {
        if (bool2)
        {
          int k = localSharedPreferences.getInt("Main_top_marign", -1);
          if (k >= 0)
          {
            AppMethodBeat.o(33084);
            return j + k;
          }
        }
        if (bool1) {
          if (localView == null) {
            break label210;
          }
        }
        for (i = localView.getTop();; i = 0)
        {
          Log.i("MicroMsg.FindMoreFriendsUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
          AppMethodBeat.o(33084);
          return i + j;
        }
      }
    }
  }
  
  private void jik()
  {
    AppMethodBeat.i(33080);
    Log.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
    if ((!jnA()) || (!isAdded()))
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
      AppMethodBeat.o(33080);
      return;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (WeChatBrands.Business.Entries.DiscoveryChannels.banned()) {
          this.FUv.eh("find_friends_by_finder", true);
        }
        Object localObject1 = al.bix("discoverRecommendEntry");
        localObject2 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
        if (localObject2 == null) {
          break label318;
        }
        bool = ((com.tencent.mm.plugin.topstory.a.d)localObject2).hMx();
        Log.i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label279;
        }
        localObject1 = ((JSONObject)localObject1).optString("wording");
        localObject2 = (NormalIconNewTipPreference)this.FUv.bAi("find_friends_by_look");
        if (Util.isNullOrNil((String)localObject1))
        {
          ((NormalIconNewTipPreference)localObject2).setTitle(getString(R.l.find_friends_look));
          ((NormalIconNewTipPreference)localObject2).a(this.FUv);
          com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject2);
          ((NormalIconNewTipPreference)localObject2).a(this.MrK, new NormalIconNewTipPreference.a()
          {
            public final void aPT(String paramAnonymousString)
            {
              AppMethodBeat.i(249073);
              FindMoreFriendsUI.a(FindMoreFriendsUI.this, paramAnonymousString);
              AppMethodBeat.o(249073);
            }
          });
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
          this.adyn += 1;
          this.FUv.eh("find_friends_by_look", false);
          MMHandlerThread.postToMainThread(new FindMoreFriendsUI.14(this, (IconPreference)localObject2));
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.ui.b.class)).tryToCreateTopStoryWebView();
          AppMethodBeat.o(33080);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FindMoreFriendsUI", Util.stackTraceToString(localException));
        AppMethodBeat.o(33080);
        return;
      }
      ((NormalIconNewTipPreference)localObject2).setTitle(localException);
      continue;
      label279:
      this.FUv.eh("find_friends_by_look", true);
      if (!jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 3L, 1L);
      }
      AppMethodBeat.o(33080);
      return;
      label318:
      boolean bool = true;
    }
  }
  
  private void jil()
  {
    AppMethodBeat.i(249547);
    View localView = getView().getRootView().findViewById(R.h.fMt);
    int i = bf.fs(getContext());
    int j = bf.I(getContext(), -1);
    FindMoreFriendsUI.16 local16 = new FindMoreFriendsUI.16(this, localView);
    if (j <= 0)
    {
      getView().post(local16);
      AppMethodBeat.o(249547);
      return;
    }
    int k = getTopHeight();
    getView().setPadding(0, k, 0, localView.getHeight());
    Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    getView().postDelayed(local16, 100L);
    AppMethodBeat.o(249547);
  }
  
  private void jim()
  {
    AppMethodBeat.i(249585);
    Iterator localIterator = Arrays.asList(new androidx.core.f.d[] { new androidx.core.f.d("find_friends_by_near", WeChatBrands.Business.Entries.DiscoveryNearby), new androidx.core.f.d("find_live_friends_by_near", WeChatBrands.Business.Entries.DiscoveryNearbyLiveFriends), new androidx.core.f.d("find_friends_by_shake", WeChatBrands.Business.Entries.DiscoveryShake), new androidx.core.f.d("find_friends_by_qrcode", WeChatBrands.Business.Entries.GlobalScan), new androidx.core.f.d("more_tab_game_recommend", WeChatBrands.Business.Entries.DiscoveryGame), new androidx.core.f.d("jd_market_entrance", WeChatBrands.Business.Entries.DiscoveryShop), new androidx.core.f.d("app_brand_entrance", WeChatBrands.Business.Entries.DiscoveryAppbrand), new androidx.core.f.d("find_friends_by_search", WeChatBrands.Business.Entries.DiscoverySearch), new androidx.core.f.d("find_friends_by_look", WeChatBrands.Business.Entries.DiscoveryLooks), new androidx.core.f.d("find_friends_by_finder", WeChatBrands.Business.Entries.DiscoveryChannels), new androidx.core.f.d("find_friends_by_finder_live", WeChatBrands.Business.Entries.DiscoveryChannels) }).iterator();
    while (localIterator.hasNext())
    {
      androidx.core.f.d locald = (androidx.core.f.d)localIterator.next();
      if ((this.FUv.bAi((String)locald.bsC) instanceof IconPreference))
      {
        if (((WeChatBrands.Business.Entries)locald.bsD).banned()) {
          this.FUv.eh((String)locald.bsC, true);
        }
        ((WeChatBrands.Business.Entries)locald.bsD).signRequsted();
      }
    }
    AppMethodBeat.o(249585);
  }
  
  private static int jin()
  {
    AppMethodBeat.i(33088);
    int j = 1;
    int i = j;
    com.tencent.mm.plugin.subapp.jdbiz.c localc;
    if (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null)
    {
      localc = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN();
      com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
      i = j;
      if (com.tencent.mm.plugin.subapp.jdbiz.d.hAJ())
      {
        i = j;
        if (localc.isStart())
        {
          i = j;
          if (!localc.dgl())
          {
            if ((!"3".equals(localc.SEz)) || (Util.isNullOrNil(localc.jumpUrl))) {
              break label87;
            }
            i = 6;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33088);
      return i;
      label87:
      if (!Util.isNullOrNil(localc.SEC))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (localc.SEB) {
          i = 2;
        }
      }
    }
  }
  
  private static boolean jio()
  {
    AppMethodBeat.i(249607);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmE, 0);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acZx, false);
    Log.i("MicroMsg.FindMoreFriendsUI", "show declare needShow %d, hasShow %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if ((i != 0) && (!bool))
    {
      AppMethodBeat.o(249607);
      return true;
    }
    AppMethodBeat.o(249607);
    return false;
  }
  
  private void jip()
  {
    AppMethodBeat.i(249613);
    com.tencent.mm.plugin.report.service.h.OAn.b(17065, new Object[] { Integer.valueOf(1), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.adyw.ordinal()), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXB, ""), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXA, ""), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXz, "0") });
    if (this.adyw.equals(a.adza))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acXy, Boolean.FALSE);
      this.adyw = a.adyV;
      localObject = (IconPreference)this.FUv.bAi("my_life_around");
      ((IconPreference)localObject).afx(8);
      ((IconPreference)localObject).gv("", -1);
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXx, Boolean.FALSE)).booleanValue();
    ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_nearbylife");
    String str = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).bnt("labs_nearbylife");
    int i = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).bnu("labs_nearbylife");
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    int j = com.tencent.mm.k.i.aRC().getInt("LifeAppEntranceBringRedDot", 0);
    Log.d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", new Object[] { Integer.valueOf(j) });
    if ((j != 0) && (bool)) {}
    for (Object localObject = "?hasRedDot=true";; localObject = null)
    {
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(getContext(), str, null, i, 0, (String)localObject, localAppBrandStatObject);
      AppMethodBeat.o(249613);
      return;
    }
  }
  
  private void jir()
  {
    AppMethodBeat.i(33094);
    if (this.adxZ == null)
    {
      this.adxZ = View.inflate(getContext(), R.i.gli, null);
      this.MoT = ((CheckBox)this.adxZ.findViewById(R.h.fMB));
      this.MoT.setChecked(false);
    }
    if (this.MoV == null)
    {
      this.MoV = com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.app_tip), this.adxZ, new FindMoreFriendsUI.28(this), null);
      AppMethodBeat.o(33094);
      return;
    }
    this.MoV.show();
    AppMethodBeat.o(33094);
  }
  
  private void jis()
  {
    AppMethodBeat.i(33095);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.FUv.bAi("more_tab_game_recommend");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33095);
      return;
    }
    localNormalIconNewTipPreference.a(this.FUv);
    com.tencent.mm.plugin.newtips.a.gtf().h(localNormalIconNewTipPreference);
    com.tencent.threadpool.h.ahAA.g(new FindMoreFriendsUI.29(this), "updateGame");
    AppMethodBeat.o(33095);
  }
  
  private void jit()
  {
    boolean bool2 = false;
    AppMethodBeat.i(33106);
    boolean bool3;
    if ((this.PtI & 0x8000) == 0)
    {
      bool1 = true;
      bool3 = com.tencent.mm.br.c.blq("sns");
      Log.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if (!bool1)
      {
        if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYm, 0) != 1) {
          break label149;
        }
        Log.w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 71);
      }
    }
    for (;;)
    {
      if ((bool1) && (bool3)) {
        break label189;
      }
      this.FUv.eh("album_dyna_photo_ui_title", true);
      if (!jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 0L, 1L);
      }
      AppMethodBeat.o(33106);
      return;
      bool1 = false;
      break;
      label149:
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYm, 0) == -1)
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 70);
      }
    }
    label189:
    this.adyn += 1;
    this.FUv.eh("album_dyna_photo_ui_title", false);
    FriendSnsPreference localFriendSnsPreference = (FriendSnsPreference)this.FUv.bAi("album_dyna_photo_ui_title");
    localFriendSnsPreference.drawable = bd.by(getContext(), R.d.colorful_moment);
    bh.bCz();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(48, null));
    localFriendSnsPreference.afx(8);
    localFriendSnsPreference.aBj(8);
    if (bool1)
    {
      localFriendSnsPreference.afx(0);
      localFriendSnsPreference.gv(getString(R.l.app_new), R.g.new_tips_bg);
    }
    bh.bCz();
    this.adya = ((String)com.tencent.mm.model.c.ban().d(68377, null));
    if ((!Util.isNullOrNil(this.adya)) && (LauncherUI.getCurrentTabIndex() == 2))
    {
      bh.bCz();
      if (com.tencent.mm.model.c.ban().getInt(68419, 0) == 0)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.plugin.sns.statistics.k.z(2, (String)com.tencent.mm.kernel.h.baE().ban().d(68418, ""), this.adyb);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(68419, Integer.valueOf(1));
      }
    }
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acWS, null);
    long l;
    int i;
    if (localObject == null)
    {
      l = 0L;
      Log.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", new Object[] { Util.nullAs(this.adya, "") });
      localFriendSnsPreference.aBi(0);
      if (Util.isNullOrNil(this.adya)) {
        break label659;
      }
      localFriendSnsPreference.aBh(0);
      bh.bCz();
      if (!Util.nullAs((Boolean)com.tencent.mm.model.c.ban().d(68384, null), true)) {
        break label653;
      }
      i = 0;
      label497:
      localFriendSnsPreference.aBj(i);
      localFriendSnsPreference.bzH(this.adya);
      label512:
      if (com.tencent.mm.plugin.sns.c.q.Qkk != null) {
        if (!com.tencent.mm.plugin.sns.c.q.Qkk.hed()) {
          break label766;
        }
      }
    }
    label653:
    label659:
    label766:
    for (this.adyb = 0;; this.adyb = com.tencent.mm.plugin.sns.c.q.Qkk.dkF())
    {
      if (this.adyb != 0)
      {
        localFriendSnsPreference.afx(0);
        localFriendSnsPreference.gv(this.adyb, com.tencent.mm.ui.tools.v.bC(getContext(), this.adyb));
      }
      localFriendSnsPreference.aeD(8);
      localFriendSnsPreference.aBf(8);
      new abk().publish();
      if (Util.isNullOrNil(this.adya))
      {
        bool1 = bool2;
        if (this.adyb == 0) {}
      }
      else
      {
        bool1 = true;
      }
      ef("album_dyna_photo_ui_title", bool1);
      AppMethodBeat.o(33106);
      return;
      l = ((Long)localObject).longValue();
      break;
      i = 8;
      break label497;
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().d(589825, Boolean.FALSE)).booleanValue())
      {
        localFriendSnsPreference.aBg(R.k.net_warn_icon);
        localFriendSnsPreference.aBh(0);
        localFriendSnsPreference.aBj(8);
        break label512;
      }
      if ((l != 0L) && (((com.tencent.mm.plugin.sns.c.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.p.class)).ul(l)))
      {
        localFriendSnsPreference.aBh(0);
        localFriendSnsPreference.aBj(0);
        localFriendSnsPreference.zD(l);
        break label512;
      }
      localFriendSnsPreference.aBh(8);
      break label512;
    }
  }
  
  private void jiu()
  {
    boolean bool2 = false;
    AppMethodBeat.i(33107);
    if ((this.PtI & 0x100) == 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = com.tencent.mm.br.c.blq("shake");
      boolean bool4 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      Log.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((bool1) && (bool3) && (!bool4)) {
        break;
      }
      this.FUv.eh("find_friends_by_shake", true);
      if (!jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 2L, 1L);
      }
      AppMethodBeat.o(33107);
      return;
    }
    this.adyn += 1;
    this.FUv.eh("find_friends_by_shake", false);
    IconPreference localIconPreference = (IconPreference)this.FUv.bAi("find_friends_by_shake");
    int i = com.tencent.mm.modelverify.d.bNK().dkF() + o.a.iGH().gWV();
    if (i > 0)
    {
      localIconPreference.afx(0);
      localIconPreference.gv(String.valueOf(i), com.tencent.mm.ui.tools.v.bC(getContext(), i));
      localIconPreference.aBh(8);
      o.a.iGH().gWW();
      if (!o.a.iGH().gWX()) {
        break label612;
      }
    }
    label317:
    label575:
    label602:
    label612:
    for (bool1 = com.tencent.mm.aa.c.aYo().dW(262154, 266258);; bool1 = false)
    {
      int j;
      if (bool1)
      {
        bh.bCz();
        Object localObject = (String)com.tencent.mm.model.c.ban().get(at.a.acHM, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localIconPreference.aeD(8);
          localIconPreference.afx(0);
          localIconPreference.gv(String.valueOf(localObject), R.g.unread_count_shape);
          bh.bCz();
          localObject = Util.nullAs((String)com.tencent.mm.model.c.ban().get(at.a.acLx, null), "");
          bh.bCz();
          bool3 = Util.nullAs((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLz, null), false);
          bh.bCz();
          j = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acLv, Integer.valueOf(0))).intValue();
          if ((!Boolean.valueOf(bool3).booleanValue()) || (localObject == null) || (((String)localObject).equals("")) || (i > 0) || (bool1)) {
            break label602;
          }
          if (j != 0) {
            break label575;
          }
          localIconPreference.aeD(8);
          localIconPreference.aBf(0);
          localObject = ((String)localObject).split(",");
          if (localObject.length > 0) {
            localIconPreference.bd(localObject[0], -1, Color.parseColor("#8c8c8c"));
          }
          localIconPreference.LF(true);
          localIconPreference.aBi(8);
        }
      }
      for (;;)
      {
        if ((i > 0) || (bool1)) {
          bool2 = true;
        }
        ef("find_friends_by_shake", bool2);
        AppMethodBeat.o(33107);
        return;
        localIconPreference.afx(8);
        localIconPreference.gv("", -1);
        break;
        if (i > 0)
        {
          localIconPreference.aeD(0);
          break label317;
        }
        localIconPreference.aeD(0);
        localIconPreference.afx(8);
        localIconPreference.gv("", -1);
        break label317;
        localIconPreference.aeD(8);
        break label317;
        if (j == 1)
        {
          localIconPreference.aBf(8);
          localIconPreference.afx(0);
          localIconPreference.adYK = true;
          continue;
          localIconPreference.aBf(8);
        }
      }
    }
  }
  
  private void jiv()
  {
    AppMethodBeat.i(33108);
    boolean bool2 = ju(2097152L);
    boolean bool3 = aj.aBu();
    boolean bool4 = com.tencent.mm.br.c.blq("search");
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "openSearch %s, plugin installed %s isTeenMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool4) && (!bool3)) {
        break;
      }
      this.FUv.eh("find_friends_by_search", true);
      if (!jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 4L, 1L);
      }
      AppMethodBeat.o(33108);
      return;
    }
    this.adyn += 1;
    this.FUv.eh("find_friends_by_search", false);
    try
    {
      Object localObject = al.bix("discoverSearchEntry");
      String str = ((JSONObject)localObject).optString("wording");
      ((JSONObject)localObject).optString("androidIcon");
      localObject = (NormalIconNewTipPreference)this.FUv.bAi("find_friends_by_search");
      if (Util.isNullOrNil(str)) {
        ((NormalIconNewTipPreference)localObject).setTitle(getString(R.l.find_friends_search));
      }
      for (;;)
      {
        ((NormalIconNewTipPreference)localObject).a(this.FUv);
        com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject);
        ((NormalIconNewTipPreference)localObject).a(this.MrK, new NormalIconNewTipPreference.a()
        {
          public final void aPT(String paramAnonymousString)
          {
            AppMethodBeat.i(249747);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, paramAnonymousString);
            AppMethodBeat.o(249747);
          }
        });
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject);
        a(ar.iqh().WpK, (IconPreference)localObject);
        if (LauncherUI.getCurrentTabIndex() == 2) {
          ar.iqh().atd(1);
        }
        com.tencent.mm.plugin.ai.data.business.tools_mp.a.caq();
        if (!com.tencent.mm.plugin.ai.data.business.tools_mp.a.car()) {
          aj.ipT();
        }
        AppMethodBeat.o(33108);
        return;
        ((NormalIconNewTipPreference)localObject).setTitle(str);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FindMoreFriendsUI", localException, "update search entry exception!", new Object[0]);
      AppMethodBeat.o(33108);
    }
  }
  
  private void jiw()
  {
    AppMethodBeat.i(33109);
    if (this.adyz == null) {
      this.adyz = new com.tencent.mm.ui.findmore.a.b(getContext(), this);
    }
    if (this.adyz.jBs()) {
      this.adyn += 1;
    }
    AppMethodBeat.o(33109);
  }
  
  private void jix()
  {
    AppMethodBeat.i(33110);
    wn localwn = new wn();
    localwn.iai.hNd = this.hNd;
    localwn.publish();
    AppMethodBeat.o(33110);
  }
  
  private boolean pS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(33081);
    int i;
    int j;
    if (!Util.isNullOrNil(paramString1))
    {
      i = 1;
      if (Util.isNullOrNil(paramString2)) {
        break label91;
      }
      j = 1;
      label25:
      if ((i == 0) || (j == 0)) {
        break label97;
      }
      paramString1 = a.adyZ;
    }
    for (;;)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", new Object[] { paramString1, this.adyw });
      if (paramString1.compareTo(this.adyw) < 0) {
        break label127;
      }
      this.adyw = paramString1;
      AppMethodBeat.o(33081);
      return true;
      i = 0;
      break;
      label91:
      j = 0;
      break label25;
      label97:
      if (j != 0) {
        paramString1 = a.adyY;
      } else if (i != 0) {
        paramString1 = a.adyX;
      } else {
        paramString1 = a.adyW;
      }
    }
    label127:
    AppMethodBeat.o(33081);
    return false;
  }
  
  private String pT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(33099);
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(33099);
      return paramString1;
    }
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.x(getContext(), paramString2);
    AppMethodBeat.o(33099);
    return paramString1;
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(33086);
    this.adyn = 0;
    this.adxY = System.currentTimeMillis();
    if (this.UfQ != null) {
      this.UfQ.setVisibility(8);
    }
    if ((!jnA()) || (!isAdded()))
    {
      AppMethodBeat.o(33086);
      return;
    }
    Log.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(this.status), Integer.valueOf(com.tencent.mm.model.z.bAQ()), Long.valueOf(this.xct), Long.valueOf(com.tencent.mm.model.z.bAR()), Integer.valueOf(this.PtI), Integer.valueOf(com.tencent.mm.model.z.bBf()) });
    jit();
    boolean bool2 = bZX();
    Object localObject1 = this.FUv;
    label299:
    Object localObject2;
    int i;
    label360:
    boolean bool3;
    if (!bool2)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.h)localObject1).eh("find_friends_by_finder", bool1);
      if (!bool2) {
        break label1937;
      }
      this.adyA = true;
      this.adyn += 1;
      localObject1 = (FinderIconViewTipPreference)this.FUv.bAi("find_friends_by_finder");
      ((NormalIconNewTipPreference)localObject1).MrN = true;
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZj();
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).checkInsertLiveNewReddot();
      if (this.observer == null)
      {
        this.observer = new y() {};
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
        com.tencent.mm.plugin.finder.extension.reddot.l.dZC().a(this, this.observer);
      }
      localObject1 = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
      localObject1 = (l.a)com.tencent.mm.plugin.finder.extension.reddot.l.dZC().getValue();
      if (localObject1 != null) {
        this.observer.onChanged(localObject1);
      }
      if (this.adyB == null) {
        this.adyB = new com.tencent.mm.ui.findmore.a.a(getContext(), this);
      }
      localObject1 = this.adyB;
      localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      ((com.tencent.mm.ui.findmore.a.a)localObject1).afuY = com.tencent.mm.plugin.finder.nearby.abtest.a.eEl();
      if (((com.tencent.mm.ui.findmore.a.a)localObject1).fgE()) {
        break label1978;
      }
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isEnableFinderLiveEntry.");
      i = 0;
      if (i != 0) {
        this.adyn += 1;
      }
      bool2 = ju(1048576L);
      bool3 = com.tencent.mm.br.c.blq("scanner");
      if (bool2) {
        break label2080;
      }
      bool1 = true;
      label396:
      Log.i("MicroMsg.FindMoreFriendsUI", "openScan %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break label2085;
      }
      this.FUv.eh("find_friends_by_qrcode", true);
      if (!jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 1L, 1L);
      }
      label463:
      jiu();
      jiv();
      jiw();
      bool2 = ju(4194304L);
      bool3 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      if (bool2) {
        break label2176;
      }
      bool1 = true;
      label505:
      Log.i("MicroMsg.FindMoreFriendsUI", "openShoppingEntry %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((bool2) || (bool3)) {
        break label2181;
      }
      KX(false);
      label547:
      localObject1 = b.a.fCn();
      if (localObject1 == null) {
        break label2832;
      }
      getContext();
    }
    label775:
    label2442:
    label2827:
    label2832:
    for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).fBZ();; bool1 = false)
    {
      bool3 = ju(8388608L);
      boolean bool4 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      if (!bool3)
      {
        bool2 = true;
        label602:
        Log.i("MicroMsg.FindMoreFriendsUI", "shouldShowGame %s, openGameEntry %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
        if ((!bool1) || (bool3) || (bool4)) {
          break label2221;
        }
        if (this.hNd) {
          new xn().publish();
        }
        this.FUv.eh("more_tab_game_recommend", false);
        jis();
        this.adyn += 1;
        label695:
        localObject1 = new xl();
        ((xl)localObject1).iaO.iaQ = true;
        ((xl)localObject1).publish();
        bool2 = ((xl)localObject1).iaP.iaR;
        bool3 = ju(16777216L);
        bool4 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
        if (bool3) {
          break label2256;
        }
        bool1 = true;
        Log.i("MicroMsg.FindMoreFriendsUI", "shouldShowMiniProgram %s, openMiniProgramEntry %s, isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Integer.valueOf(i) });
        if ((bool2) && (!bool3) && ((!bool4) || (i != 2))) {
          break label2261;
        }
        this.FUv.eh("app_brand_entrance", true);
        if (!jij()) {
          com.tencent.mm.plugin.report.service.h.OAn.p(953L, 9L, 1L);
        }
        bool2 = com.tencent.mm.plugin.ipcall.d.fQV();
        bool3 = ju(33554432L);
        if (bool3) {
          break label2416;
        }
        bool1 = true;
        label888:
        Log.i("MicroMsg.FindMoreFriendsUI", "showShowWeChatOut %s, openWeChatOutEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (bool3)) {
          break label2452;
        }
        this.adyn += 1;
        this.FUv.eh("ip_call_entrance", false);
        localObject1 = (IconPreference)this.FUv.bAi("ip_call_entrance");
        bh.bCz();
        if (((Integer)com.tencent.mm.model.c.ban().get(at.a.acKM, Integer.valueOf(0))).intValue() >= com.tencent.mm.k.i.aRC().getInt("WCOEntranceRedDot", 0)) {
          break label2421;
        }
        ((IconPreference)localObject1).afx(0);
        ((IconPreference)localObject1).gv(getString(R.l.app_new), R.g.new_tips_bg);
        label1018:
        ((IconPreference)localObject1).aBi(8);
        bh.bCz();
        if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKO, Boolean.FALSE)).booleanValue() != true) {
          break label2431;
        }
        ((IconPreference)localObject1).LF(true);
        ((IconPreference)localObject1).afx(8);
        i = 1;
        label1066:
        bh.bCz();
        localObject2 = (String)com.tencent.mm.model.c.ban().get(at.a.acKN, "");
        ((IconPreference)localObject1).bd((String)localObject2, -1, -7566196);
        if (!Util.isNullOrNil((String)localObject2)) {
          i = 1;
        }
        if (i == 0) {
          break label2442;
        }
        ((IconPreference)localObject1).aBf(0);
        label1117:
        localObject1 = new PreferenceSmallCategory(getContext());
        this.FUv.a((Preference)localObject1, -1);
        label1140:
        jik();
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).bns("labs_nearbylife");
        Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isInExperiment: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label2827;
        }
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).UG("labs_nearbylife");
        Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isOpen: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label2827;
        }
      }
      for (i = 1;; i = 0)
      {
        label1512:
        Object localObject3;
        if (i != 0)
        {
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWL, 0);
          Log.d("MicroMsg.FindMoreFriendsUI", "life around preload, preload: %d.", new Object[] { Integer.valueOf(i) });
          if (1 == i)
          {
            ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(ab.tTW);
            localObject1 = (NormalIconNewTipPreference)this.FUv.bAi("my_life_around");
            ((NormalIconNewTipPreference)localObject1).setTitle(getString(R.l.FF_Entry_Nearby));
            this.adyn += 1;
            this.FUv.eh("my_life_around", false);
            ((NormalIconNewTipPreference)localObject1).a(this.FUv);
            com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject1);
            ((NormalIconNewTipPreference)localObject1).a(this.MrK, new NormalIconNewTipPreference.a()
            {
              public final void aPT(String paramAnonymousString)
              {
                AppMethodBeat.i(249114);
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, paramAnonymousString);
                AppMethodBeat.o(249114);
              }
            });
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
            bool2 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXy, Boolean.TRUE)).booleanValue();
            Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showNewRedDot %s.", new Object[] { Boolean.valueOf(bool2) });
            bool3 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXx, Boolean.FALSE)).booleanValue();
            Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showRedDot %s.", new Object[] { Boolean.valueOf(bool3) });
            if ((!bool2) && ((!bool3) || ((this.adyw != a.adyZ) && (this.adyw != a.adyY) && (this.adyw != a.adyX) && (this.adyw != a.adyW)))) {
              break label2492;
            }
            bool1 = true;
            if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, (com.tencent.mm.plugin.newtips.a.a)localObject1))
            {
              if (bool2)
              {
                this.adyw = a.adza;
                ((NormalIconNewTipPreference)localObject1).afx(0);
                ((NormalIconNewTipPreference)localObject1).gv(getString(R.l.app_new), R.g.new_tips_bg);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsL, true);
              }
              if (!bool3) {
                break label2758;
              }
              localObject3 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXA, "");
              localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXB, "");
              pS((String)localObject3, (String)localObject2);
            }
            switch (40.adyU[this.adyw.ordinal()])
            {
            default: 
              label1656:
              com.tencent.mm.plugin.report.service.h.OAn.b(17065, new Object[] { Integer.valueOf(0), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.adyw.ordinal()), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXB, ""), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXA, ""), com.tencent.mm.kernel.h.baE().ban().get(at.a.acXz, "0") });
              label1751:
              jim();
              if ((!com.tencent.mm.au.b.bKL()) || (!com.tencent.mm.model.z.bBw()))
              {
                this.FUv.eh("find_friends_by_facebook", true);
                label1779:
                this.FUv.eh("settings_emoji_store", true);
                if (this.adyn == 0)
                {
                  localObject1 = (ViewGroup)findViewById(16908298).getParent();
                  if (this.UfQ != null) {
                    break label2816;
                  }
                  this.UfQ = getContext().getLayoutInflater().inflate(R.i.gka, null);
                  this.adyo = ((TextView)this.UfQ.findViewById(R.h.fJj));
                  this.adyo.setOnClickListener(new FindMoreFriendsUI.19(this));
                  localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                  ((ViewGroup)localObject1).addView(this.UfQ, (ViewGroup.LayoutParams)localObject2);
                }
              }
              break;
            }
          }
        }
        for (;;)
        {
          this.FUv.notifyDataSetChanged();
          if (!jij()) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYn, Long.valueOf(this.adxY));
          }
          AppMethodBeat.o(33086);
          return;
          bool1 = false;
          break;
          label1937:
          if (this.adyA)
          {
            localObject1 = com.tencent.mm.plugin.finder.permission.a.ESS;
            if (!com.tencent.mm.plugin.finder.permission.a.eGX()) {
              ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).hG(true);
            }
          }
          this.adyA = false;
          break label299;
          label1978:
          if (((com.tencent.mm.ui.findmore.a.a)localObject1).afuX.hNd) {
            com.tencent.mm.ui.report.a.jCn();
          }
          ((com.tencent.mm.ui.findmore.a.a)localObject1).jBp();
          localObject2 = ((com.tencent.mm.ui.findmore.a.a)localObject1).afuX.FUv.bAi(((com.tencent.mm.ui.findmore.a.a)localObject1).jBr());
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
            AppMethodBeat.o(33086);
            throw ((Throwable)localObject1);
          }
          ((com.tencent.mm.ui.findmore.a.a)localObject1).a((FinderIconViewTipPreference)localObject2);
          ((com.tencent.mm.ui.findmore.a.a)localObject1).MN(((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZv());
          i = 1;
          break label360;
          label2080:
          bool1 = false;
          break label396;
          label2085:
          this.FUv.eh("find_friends_by_qrcode", false);
          this.adyn += 1;
          if (com.tencent.mm.aa.c.aYo().b(at.a.acXi, at.a.acXh))
          {
            ((NormalIconPreference)this.FUv.bAi("find_friends_by_qrcode")).aeD(0);
            ef("find_friends_by_qrcode", true);
            break label463;
          }
          ((NormalIconPreference)this.FUv.bAi("find_friends_by_qrcode")).aeD(4);
          ef("find_friends_by_qrcode", false);
          break label463;
          bool1 = false;
          break label505;
          this.FUv.eh("jd_market_entrance", true);
          if (jij()) {
            break label547;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(953L, 7L, 1L);
          break label547;
          bool2 = false;
          break label602;
          label2221:
          this.FUv.eh("more_tab_game_recommend", true);
          if (jij()) {
            break label695;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(953L, 8L, 1L);
          break label695;
          label2256:
          bool1 = false;
          break label775;
          label2261:
          ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).cew();
          this.adyn += 1;
          this.FUv.eh("app_brand_entrance", false);
          localObject2 = (IconPreference)this.FUv.bAi("app_brand_entrance");
          if (((xl)localObject1).iaP.iaT)
          {
            i = 0;
            label2325:
            ((IconPreference)localObject2).afx(i);
            ((IconPreference)localObject2).gv(getString(R.l.app_new), R.g.new_tips_bg);
            if (!((xl)localObject1).iaP.iaS) {
              break label2405;
            }
            i = 0;
            label2359:
            ((IconPreference)localObject2).aeD(i);
            if ((!((xl)localObject1).iaP.iaT) && (!((xl)localObject1).iaP.iaS)) {
              break label2411;
            }
          }
          label2405:
          label2411:
          for (bool1 = true;; bool1 = false)
          {
            ef("app_brand_entrance", bool1);
            break;
            i = 8;
            break label2325;
            i = 8;
            break label2359;
          }
          label2416:
          bool1 = false;
          break label888;
          label2421:
          ((IconPreference)localObject1).afx(8);
          break label1018;
          label2431:
          ((IconPreference)localObject1).LF(false);
          i = 0;
          break label1066;
          ((IconPreference)localObject1).aBf(8);
          break label1117;
          label2452:
          this.FUv.eh("ip_call_entrance", true);
          break label1140;
          if (2 != i) {
            break label1287;
          }
          ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(ab.tTW);
          break label1287;
          label2492:
          bool1 = false;
          break label1512;
          com.tencent.mm.modelimage.r.bJZ();
          Bitmap localBitmap = com.tencent.mm.modelimage.e.Eo((String)localObject2);
          if (localBitmap != null)
          {
            this.adyv = null;
            ((NormalIconNewTipPreference)localObject1).bd(BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() * 0.1F));
          }
          for (;;)
          {
            ((NormalIconNewTipPreference)localObject1).bd((String)localObject3, -1, Color.parseColor("#8c8c8c"));
            a((IconPreference)localObject1, 8, 0, false, 0, 0, 0);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsO, true);
            break;
            this.adyv = ((String)localObject2);
            com.tencent.mm.modelimage.r.bKd().a((String)localObject2, this.MrK);
          }
          com.tencent.mm.modelimage.r.bJZ();
          localObject3 = com.tencent.mm.modelimage.e.Eo((String)localObject2);
          if (localObject3 != null)
          {
            this.adyv = null;
            ((NormalIconNewTipPreference)localObject1).bd(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject3, false, ((Bitmap)localObject3).getWidth() * 0.1F));
          }
          for (;;)
          {
            a((IconPreference)localObject1, 8, 8, false, 0, 0, 0);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsN, true);
            break;
            this.adyv = ((String)localObject2);
            com.tencent.mm.modelimage.r.bKd().a((String)localObject2, this.MrK);
          }
          ((NormalIconNewTipPreference)localObject1).bd((String)localObject3, -1, Color.parseColor("#8c8c8c"));
          a((IconPreference)localObject1, 8, 0, true, 8, 8, 8);
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsM, true);
          break label1656;
          a((IconPreference)localObject1, 0, 8, false, 8, 8, 8);
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, com.tencent.mm.plugin.newtips.a.k.MsK, true);
          break label1656;
          label2758:
          a((IconPreference)localObject1, 8, 8, false, 8, 8, 8);
          if (bool2) {
            break label1656;
          }
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
          break label1656;
          this.FUv.eh("my_life_around", true);
          break label1751;
          this.FUv.eh("find_friends_by_facebook", false);
          break label1779;
          this.UfQ.setVisibility(0);
        }
      }
    }
  }
  
  public final void a(bxq parambxq, FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(249858);
    Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot icon url: " + parambxq.icon_url + " show_type:" + parambxq.show_type);
    Object localObject;
    int i;
    if ((parambxq.show_type == 7) || (parambxq.show_type == 11) || (parambxq.show_type == 4) || (parambxq.show_type == 12) || (parambxq.show_type == 13) || (parambxq.show_type == 14) || (parambxq.show_type == 16))
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot enableShowEntranceRedDot %s", new Object[] { Boolean.valueOf(paramBoolean2) });
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Integer)com.tencent.mm.plugin.finder.storage.d.eTk().bmg()).intValue() != -1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        i = ((Integer)com.tencent.mm.plugin.finder.storage.d.eTk().bmg()).intValue();
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (i < com.tencent.mm.plugin.finder.storage.d.eTl().size())
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          parambxq.show_type = ((Integer)((kotlin.r)com.tencent.mm.plugin.finder.storage.d.eTl().get(i)).bsC).intValue();
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          parambxq.title = ((String)((kotlin.r)com.tencent.mm.plugin.finder.storage.d.eTl().get(i)).bsD);
          Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot debug set showType %s title %s", new Object[] { Integer.valueOf(parambxq.show_type), parambxq.title });
        }
      }
    }
    if (parambxq.show_type == 16)
    {
      paramFinderIconViewTipPreference.MrN = true;
      localObject = new fng();
      ((fng)localObject).url = parambxq.icon_url;
      ((fng)localObject).title = parambxq.title;
      paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 4, true, false, true, paramBoolean3);
      parambxq = paramFinderIconViewTipPreference.getRootView();
      if ((((fng)localObject).title != null) && (parambxq != null)) {
        parambxq.setContentDescription(getString(R.l.finder_entrance_type_title, new Object[] { ((fng)localObject).title }));
      }
    }
    for (;;)
    {
      if (LauncherUI.getCurrentTabIndex() == 2)
      {
        a(false, paramFinderIconViewTipPreference);
        parambxq = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        m.a.h(false, paramFinderIconViewTipPreference.getRowCount(), paramFinderIconViewTipPreference.getDropStat());
        paramBoolean1 = true;
        if (this.adyB != null) {
          paramBoolean1 = this.adyB.fgE();
        }
        parambxq = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        m.a.U(false, paramBoolean1);
      }
      ef(paramFinderIconViewTipPreference.mKey, paramBoolean2);
      AppMethodBeat.o(249858);
      return;
      label558:
      boolean bool;
      View localView;
      if ((parambxq.show_type == 7) || (parambxq.show_type == 12) || (parambxq.show_type == 14))
      {
        paramFinderIconViewTipPreference.MrN = false;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).title = parambxq.title;
        b((fng)localObject);
        a((fng)localObject, parambxq.aagB);
        if (((paramBoolean2) && (parambxq.show_type == 12)) || ((Util.isNullOrNil(parambxq.title)) && (parambxq.show_type == 7)) || (parambxq.show_type == 14))
        {
          paramBoolean1 = true;
          if (parambxq.show_type == 14) {
            break label653;
          }
        }
        label653:
        for (bool = true;; bool = false)
        {
          paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 5, paramBoolean1, bool, false, paramBoolean3);
          localView = paramFinderIconViewTipPreference.getRootView();
          if (localView == null) {
            break;
          }
          if ((parambxq.title == null) || ((parambxq.show_type != 12) && (parambxq.show_type != 14))) {
            break label659;
          }
          localView.setContentDescription(getString(R.l.finder_entrance_type_title, new Object[] { ((fng)localObject).title }));
          break;
          paramBoolean1 = false;
          break label558;
        }
        label659:
        localView.setContentDescription(getString(R.l.finder_entrance_type_normal));
      }
      else if ((parambxq.show_type == 22) || (parambxq.show_type == 24) || (parambxq.show_type == 23) || (parambxq.show_type == 25))
      {
        paramFinderIconViewTipPreference.MrN = false;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).hrh = parambxq.aagt;
        ((fng)localObject).title = parambxq.title;
        b((fng)localObject);
        a((fng)localObject, parambxq.aagB);
        i = 11;
        if ((parambxq.show_type == 23) || (parambxq.show_type == 25)) {
          i = 12;
        }
        paramBoolean1 = false;
        if ((parambxq.show_type == 22) || (parambxq.show_type == 23)) {
          paramBoolean1 = true;
        }
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, i, true, paramBoolean1, false, false);
      }
      else if ((parambxq.show_type == 4) || (parambxq.show_type == 11) || (parambxq.show_type == 13))
      {
        paramFinderIconViewTipPreference.MrN = true;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).title = parambxq.title;
        b((fng)localObject);
        a((fng)localObject, parambxq.aagB);
        if (((paramBoolean2) && (parambxq.show_type == 11)) || ((Util.isNullOrNil(parambxq.title)) && (parambxq.show_type == 4)) || (parambxq.show_type == 13))
        {
          paramBoolean1 = true;
          label945:
          if (parambxq.show_type == 13) {
            break label1040;
          }
        }
        label1040:
        for (bool = true;; bool = false)
        {
          paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 4, paramBoolean1, bool, false, paramBoolean3);
          localView = paramFinderIconViewTipPreference.getRootView();
          if (localView == null) {
            break;
          }
          if ((parambxq.title == null) || ((parambxq.show_type != 11) && (parambxq.show_type != 13))) {
            break label1046;
          }
          localView.setContentDescription(getString(R.l.finder_entrance_type_title, new Object[] { ((fng)localObject).title }));
          break;
          paramBoolean1 = false;
          break label945;
        }
        label1046:
        localView.setContentDescription(getString(R.l.finder_entrance_type_normal));
      }
      else if (parambxq.show_type == 9)
      {
        paramFinderIconViewTipPreference.MrN = false;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).title = parambxq.title;
        a((fng)localObject, parambxq.aagB);
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 2, Util.isNullOrNil(parambxq.title), true, false, paramBoolean3);
        parambxq = paramFinderIconViewTipPreference.getRootView();
        if (parambxq != null) {
          parambxq.setContentDescription(getString(R.l.finder_entrance_type_little_square_icon));
        }
      }
      else if (parambxq.show_type == 10)
      {
        paramFinderIconViewTipPreference.MrN = true;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).title = parambxq.title;
        a((fng)localObject, parambxq.aagB);
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 1, Util.isNullOrNil(parambxq.title), true, false, paramBoolean3);
        parambxq = paramFinderIconViewTipPreference.getRootView();
        if (parambxq != null) {
          parambxq.setContentDescription(getString(R.l.finder_entrance_type_little_round_icon));
        }
      }
      else if (parambxq.show_type == 3)
      {
        localObject = new fng();
        ((fng)localObject).title = parambxq.title;
        b((fng)localObject);
        i = 6;
        if (paramBoolean1) {
          i = 7;
        }
        localView = paramFinderIconViewTipPreference.getRootView();
        if ((((fng)localObject).title != null) && (localView != null)) {
          localView.setContentDescription(getString(R.l.finder_entrance_type_title, new Object[] { ((fng)localObject).title }));
        }
        a((fng)localObject, parambxq.aagB);
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, i, true, false, false, paramBoolean3);
        parambxq = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        parambxq = com.tencent.mm.plugin.finder.extension.reddot.m.eaf();
        if (parambxq != null)
        {
          ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avr("FinderEntrance");
          w.a(w.FrV, "1", (com.tencent.mm.plugin.finder.extension.reddot.p)parambxq.bsC, (bxq)parambxq.bsD, 1, null, 0, 0, 0, 240);
        }
        com.tencent.mm.plugin.finder.extension.reddot.m.b(null);
      }
      else if (parambxq.show_type == 1)
      {
        paramFinderIconViewTipPreference.yn(paramBoolean2);
        parambxq = paramFinderIconViewTipPreference.getRootView();
        if (parambxq != null) {
          parambxq.setContentDescription(getString(R.l.finder_entrance_type_normal));
        }
      }
      else if (parambxq.show_type == 26)
      {
        paramFinderIconViewTipPreference.MrN = false;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).hrh = parambxq.aagt;
        a((fng)localObject, parambxq.aagB);
        ((fng)localObject).akls = ((fng)localObject).abNo;
        ((fng)localObject).abNo = "";
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 14, false, false, false, false);
      }
      else if ((parambxq.show_type == 100) || (parambxq.show_type == 6))
      {
        paramFinderIconViewTipPreference.yo(true);
        parambxq = paramFinderIconViewTipPreference.getRootView();
        if (parambxq != null) {
          parambxq.setContentDescription(getString(R.l.finder_entrance_type_bubble));
        }
      }
      else if ((parambxq.show_type == 2) && (parambxq.count > 0))
      {
        localObject = new fng();
        ((fng)localObject).num = parambxq.count;
        paramFinderIconViewTipPreference.d(paramBoolean2, (fng)localObject);
        localObject = paramFinderIconViewTipPreference.getRootView();
        if (localObject != null) {
          ((View)localObject).setContentDescription(getString(R.l.finder_entrance_type_count, new Object[] { Integer.valueOf(parambxq.count) }));
        }
      }
      else if (parambxq.show_type == 21)
      {
        paramFinderIconViewTipPreference.MrN = true;
        localObject = new fng();
        ((fng)localObject).url = parambxq.icon_url;
        ((fng)localObject).title = parambxq.title;
        a((fng)localObject, parambxq.aagB);
        paramFinderIconViewTipPreference.a(paramBoolean2, (fng)localObject, 10, true, false, true, paramBoolean3);
      }
      else
      {
        paramFinderIconViewTipPreference.yn(false);
      }
    }
  }
  
  public final void bCn()
  {
    AppMethodBeat.i(33101);
    if ((com.tencent.mm.model.z.bBf() & 0x8000) != 0)
    {
      AppMethodBeat.o(33101);
      return;
    }
    this.adyb += 1;
    jit();
    this.FUv.notifyDataSetChanged();
    AppMethodBeat.o(33101);
  }
  
  public final void bCo()
  {
    AppMethodBeat.i(33102);
    if ((com.tencent.mm.model.z.bBf() & 0x8000) != 0)
    {
      AppMethodBeat.o(33102);
      return;
    }
    jit();
    this.FUv.notifyDataSetChanged();
    AppMethodBeat.o(33102);
  }
  
  public final void bCp() {}
  
  public final void bCq()
  {
    AppMethodBeat.i(33122);
    Log.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
    if ((com.tencent.mm.model.z.bBf() & 0x8000) != 0)
    {
      AppMethodBeat.o(33122);
      return;
    }
    if (com.tencent.mm.plugin.sns.c.q.Qkk != null) {
      this.adyb = com.tencent.mm.plugin.sns.c.q.Qkk.dkF();
    }
    jit();
    this.FUv.notifyDataSetChanged();
    AppMethodBeat.o(33122);
  }
  
  public final int getResourceId()
  {
    return R.o.hbe;
  }
  
  public final void hFp()
  {
    AppMethodBeat.i(33121);
    Log.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
    this.hNd = false;
    this.adyD = false;
    this.adyE = false;
    jix();
    AppMethodBeat.o(33121);
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(33120);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab switch in isTabSwitchInReport:%b isTabResumeReport:%b", new Object[] { Boolean.valueOf(this.adyD), Boolean.valueOf(this.adyE) });
    this.hNd = true;
    jix();
    com.tencent.mm.blink.b.aJY().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249777);
        FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bAQ());
        FindMoreFriendsUI.b(FindMoreFriendsUI.this, com.tencent.mm.model.z.bBf());
        FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bAR());
        long l = System.currentTimeMillis();
        FindMoreFriendsUI.w(FindMoreFriendsUI.this);
        Log.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(249777);
      }
    });
    al.cj(20, false);
    if ((!this.adyD) && (!this.adyE))
    {
      if (bZX()) {
        a(true, null);
      }
      if (this.adyB == null) {
        break label132;
      }
    }
    label132:
    for (boolean bool = this.adyB.fgE();; bool = true)
    {
      m.a locala = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      m.a.U(true, bool);
      this.adyD = true;
      AppMethodBeat.o(33120);
      return;
    }
  }
  
  protected final void jhn()
  {
    AppMethodBeat.i(33104);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab create");
    this.FUv = ((com.tencent.mm.ui.base.preference.h)getPreferenceScreen());
    this.status = com.tencent.mm.model.z.bAQ();
    this.PtI = com.tencent.mm.model.z.bBf();
    this.xct = com.tencent.mm.model.z.bAR();
    this.rHs = new com.tencent.mm.ui.widget.b.a(getContext());
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    this.FUv.eh("find_friends_by_shake", true);
    this.FUv.eh("ip_call_entrance", true);
    AppMethodBeat.o(33104);
  }
  
  protected final void jho()
  {
    AppMethodBeat.i(33105);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume isTabSwitchInReport:%b isTabResumeReport:%b", new Object[] { Boolean.valueOf(this.adyD), Boolean.valueOf(this.adyE) });
    if (((this.FUv instanceof com.tencent.mm.ui.base.preference.h)) && (this.FUv.adZC == 0L)) {
      this.FUv.adZC = System.currentTimeMillis();
    }
    this.hNd = true;
    jix();
    IListenerMStorage.a(nl.class.getName(), this.Ymn);
    IListenerMStorage.a(kp.class.getName(), this.IVx);
    IListenerMStorage.a(xh.class.getName(), this.adyt);
    IListenerMStorage.a(ko.class.getName(), this.adys);
    this.adyq.alive();
    this.adyp.alive();
    this.adyr.alive();
    this.QvD.alive();
    this.adyu.alive();
    this.HzL.alive();
    this.adyy.alive();
    com.tencent.mm.modelverify.d.bNK().add(this);
    bh.bCz();
    com.tencent.mm.model.c.bzG().add(this);
    bh.bCz();
    com.tencent.mm.model.c.a(this);
    bh.bCz();
    com.tencent.mm.model.c.ban().add(this);
    if (com.tencent.mm.plugin.sns.c.q.Qkm != null) {
      com.tencent.mm.plugin.sns.c.q.Qkm.a(this);
    }
    Object localObject = findViewById(R.h.loading_tips_area);
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      new MMHandler(Looper.getMainLooper()).post(new FindMoreFriendsUI.34(this, (View)localObject));
    }
    if (isAdded()) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249741);
          Log.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(FindMoreFriendsUI.t(FindMoreFriendsUI.this)), Integer.valueOf(com.tencent.mm.model.z.bAQ()), Long.valueOf(FindMoreFriendsUI.u(FindMoreFriendsUI.this)), Long.valueOf(com.tencent.mm.model.z.bAR()), Integer.valueOf(FindMoreFriendsUI.v(FindMoreFriendsUI.this)), Integer.valueOf(com.tencent.mm.model.z.bBf()) });
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bAR());
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bAQ());
          FindMoreFriendsUI.b(FindMoreFriendsUI.this, com.tencent.mm.model.z.bBf());
          FindMoreFriendsUI.w(FindMoreFriendsUI.this);
          AppMethodBeat.o(249741);
        }
      });
    }
    jil();
    if ((!this.adyD) && (!this.adyE))
    {
      if (bZX()) {
        a(true, null);
      }
      if (this.adyB == null) {
        break label378;
      }
    }
    label378:
    for (boolean bool = this.adyB.fgE();; bool = true)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      m.a.U(true, bool);
      this.adyE = true;
      com.tencent.mm.plugin.scanner.box.h.aV(2, 0L);
      Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
      AppMethodBeat.o(33105);
      return;
    }
  }
  
  protected final void jhp()
  {
    AppMethodBeat.i(33111);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("lifeappreddot", this.adyx);
    AppMethodBeat.o(33111);
  }
  
  protected final void jhq()
  {
    AppMethodBeat.i(33112);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
    this.hNd = false;
    this.adyD = false;
    this.adyE = false;
    jix();
    bbC();
    AppMethodBeat.o(33112);
  }
  
  protected final void jhr()
  {
    AppMethodBeat.i(33113);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    AppMethodBeat.o(33113);
  }
  
  protected final void jhs()
  {
    AppMethodBeat.i(33114);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    bbC();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("lifeappreddot", this.adyx);
    AppMethodBeat.o(33114);
  }
  
  public final void jhu()
  {
    AppMethodBeat.i(33115);
    Log.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    AppMethodBeat.o(33115);
  }
  
  public final void jhv()
  {
    AppMethodBeat.i(33116);
    Log.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    AppMethodBeat.o(33116);
  }
  
  public final void jhx()
  {
    AppMethodBeat.i(33117);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    AppMethodBeat.o(33117);
  }
  
  public final boolean jij()
  {
    AppMethodBeat.i(33079);
    if (Util.isSameDay(com.tencent.mm.kernel.h.baE().ban().a(at.a.acYn, 0L), this.adxY))
    {
      AppMethodBeat.o(33079);
      return true;
    }
    AppMethodBeat.o(33079);
    return false;
  }
  
  public final void jiq()
  {
    AppMethodBeat.i(33093);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "4");
    Object localObject = cb.bDf();
    if (localObject == null)
    {
      com.tencent.mm.br.c.ai(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(33093);
      return;
    }
    String str = Util.nullAsNil(((cb)localObject).getProvince());
    int i = Util.nullAs(Integer.valueOf(((cb)localObject).sex), 0);
    if ((Util.isNullOrNil(str)) || (i == 0))
    {
      com.tencent.mm.br.c.ai(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(33093);
      return;
    }
    bh.bCz();
    localObject = (Boolean)com.tencent.mm.model.c.ban().d(4104, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).adBG.getMainTabUI().bzP("tab_find_friend");
      }
      localObject = new Intent();
      str = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.jCp(), (Intent)localObject);
      m.a locala = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      m.a.ew(str, 0);
      com.tencent.mm.bp.a.aM(getContext(), (Intent)localObject);
      AppMethodBeat.o(33093);
      return;
    }
    jir();
    AppMethodBeat.o(33093);
  }
  
  public final boolean ju(long paramLong)
  {
    return (this.xct & paramLong) != 0L;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(33085);
    super.onActivityCreated(paramBundle);
    Log.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
    AppMethodBeat.o(33085);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(249825);
    super.onConfigurationChanged(paramConfiguration);
    jil();
    AppMethodBeat.o(249825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249810);
    super.onDestroy();
    com.tencent.mm.plugin.finder.extension.reddot.l locall = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
    com.tencent.mm.plugin.finder.extension.reddot.l.dZC().b(this.observer);
    AppMethodBeat.o(249810);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    int i = 1;
    AppMethodBeat.i(33119);
    Log.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
    if (LauncherUI.getCurrentTabIndex() == 2)
    {
      paramInt = 0;
      if (this.status != com.tencent.mm.model.z.bAQ())
      {
        this.status = com.tencent.mm.model.z.bAQ();
        paramInt = 1;
      }
      if (this.xct != com.tencent.mm.model.z.bAR())
      {
        this.xct = com.tencent.mm.model.z.bAR();
        paramInt = 1;
      }
      if (this.PtI == com.tencent.mm.model.z.bBf()) {
        break label139;
      }
      this.PtI = com.tencent.mm.model.z.bBf();
      paramInt = i;
    }
    label139:
    for (;;)
    {
      if (paramInt != 0) {
        updateStatus();
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 68377)) {
        jit();
      }
      if ((paramMStorageEx instanceof com.tencent.mm.storage.bc)) {
        this.FUv.notifyDataSetChanged();
      }
      AppMethodBeat.o(33119);
      return;
    }
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    int j = 1;
    AppMethodBeat.i(33118);
    Log.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
    int i;
    if (LauncherUI.getCurrentTabIndex() == 2)
    {
      i = 0;
      if (this.status != com.tencent.mm.model.z.bAQ())
      {
        this.status = com.tencent.mm.model.z.bAQ();
        i = 1;
      }
      if (this.xct != com.tencent.mm.model.z.bAR())
      {
        this.xct = com.tencent.mm.model.z.bAR();
        i = 1;
      }
      if (this.PtI == com.tencent.mm.model.z.bBf()) {
        break label101;
      }
      this.PtI = com.tencent.mm.model.z.bBf();
      i = j;
    }
    label101:
    for (;;)
    {
      if (i != 0) {
        updateStatus();
      }
      AppMethodBeat.o(33118);
      return;
    }
  }
  
  public void onNotifyUserStatusChange()
  {
    AppMethodBeat.i(33103);
    if (this.FUv == null)
    {
      AppMethodBeat.o(33103);
      return;
    }
    this.status = com.tencent.mm.model.z.bAQ();
    updateStatus();
    AppMethodBeat.o(33103);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(33090);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    boolean bool1;
    label199:
    label362:
    boolean bool2;
    if ("album_dyna_photo_ui_title".equals(paramPreference.mKey))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().d(68377, null);
      com.tencent.mm.plugin.report.service.g.ahw(10);
      bh.bCz();
      paramf = (String)com.tencent.mm.model.c.ban().d(68377, null);
      paramPreference = new Intent();
      localObject = new com.tencent.mm.modelsns.l(701, 1);
      if (!Util.isNullOrNil(paramf))
      {
        bool1 = true;
        ((com.tencent.mm.modelsns.l)localObject).hm(bool1);
        ((com.tencent.mm.modelsns.l)localObject).Ph(this.adyb);
        paramPreference.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramPreference.putExtra("is_from_find_more", true);
        if ((Util.isNullOrNil(paramf)) && (this.adyb <= 0)) {
          break label585;
        }
        bool1 = true;
        paramPreference.putExtra("enter_by_red", bool1);
        bh.bCz();
        paramPreference.putExtra("is_sns_notify_open", Util.nullAs((Boolean)com.tencent.mm.model.c.ban().d(68384, null), true));
        paramPreference.putExtra("sns_unread_count", com.tencent.mm.plugin.sns.c.q.Qkk.dkF());
        if (!Util.isNullOrNil(paramf))
        {
          bh.bCz();
          paramPreference.putExtra("new_feed_id", Util.nullAs((String)com.tencent.mm.model.c.ban().d(68418, null), ""));
          bh.bCz();
          com.tencent.mm.plugin.sns.statistics.k.z(3, (String)com.tencent.mm.model.c.ban().d(68418, ""), this.adyb);
        }
        ((com.tencent.mm.modelsns.l)localObject).b(paramPreference, "enter_log");
        localObject = new lx();
        ((lx)localObject).publish();
        if (((lx)localObject).hNO.isResume) {
          break label4965;
        }
        if (Util.isNullOrNil(paramf)) {
          break label4959;
        }
        bool1 = false;
        bool2 = bool1;
        if (com.tencent.mm.plugin.sns.c.q.Qkk != null)
        {
          this.adyb = com.tencent.mm.plugin.sns.c.q.Qkk.dkF();
          bool2 = bool1;
          if (this.adyb > 0) {
            bool2 = false;
          }
        }
        bh.bCz();
        com.tencent.mm.model.c.ban().B(68377, "");
      }
    }
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(589825, Boolean.FALSE);
      paramPreference.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsTimeLineUI", paramPreference);
      paramf = com.tencent.mm.model.z.bAM();
      long l = com.tencent.mm.model.cn.bDu() / 1000L;
      bh.bCz();
      ac.a(paramf, 9, "MomentsTimelineStatus", String.format("%s,%s", new Object[] { Long.valueOf(l), com.tencent.mm.model.c.ban().d(68418, null) }));
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "1");
      com.tencent.mm.plugin.ai.data.business.tools_mp.a.caq();
      if (!com.tencent.mm.plugin.ai.data.business.tools_mp.a.car()) {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33049);
            com.tencent.mm.xwebutil.c.jQE();
            AppMethodBeat.o(33049);
          }
        }, 500L);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33090);
      return true;
      bool1 = false;
      break;
      label585:
      bool1 = false;
      break label199;
      int i;
      if (("find_friends_by_near".equals(paramPreference.mKey)) || ("find_live_friends_by_near".equals(paramPreference.mKey)) || ("find_friends_by_near_v3".equals(paramPreference.mKey)))
      {
        if (!"find_live_friends_by_near".equals(paramPreference.mKey))
        {
          i = 1;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGA = 1001;
          if (!com.tencent.mm.bp.a.iGm()) {
            break label797;
          }
          paramf = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
            break label791;
          }
          com.tencent.mm.ui.report.a.jCm();
          label670:
          if (i == 0) {
            break label885;
          }
          if (!com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null))) {
            break label828;
          }
          if (com.tencent.mm.pluginsdk.permission.b.s(thisActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            break label885;
          }
          if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
            break label813;
          }
          com.tencent.mm.plugin.account.sdk.c.a.b(thisActivity(), getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          i = 0;
          break;
          label791:
          com.tencent.mm.ui.report.a.jCk();
          break label670;
          label797:
          if (WeChatBrands.Business.Entries.DiscoveryNearby.checkAvailable(getContext())) {
            break label670;
          }
          continue;
          label813:
          com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_FINE_LOCATION", 66);
          continue;
          label828:
          bool1 = com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 66, null);
          Log.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            label885:
            jiq();
          }
        }
      }
      if ("find_friends_by_shake".equals(paramPreference.mKey))
      {
        if (!WeChatBrands.Business.Entries.DiscoveryShake.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if ((!this.adyh) && (com.tencent.mm.model.z.bBK().booleanValue()))
        {
          paramf = (IconPreference)paramf.bAi("find_friends_by_shake");
          if (paramf != null)
          {
            paramf.aeD(8);
            bh.bCz();
            com.tencent.mm.model.c.ban().B(340231, Boolean.TRUE);
            bh.bCz();
            com.tencent.mm.model.c.ban().iZy();
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(232L, 4L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "3");
        bh.bCz();
        paramf = Util.nullAs((String)com.tencent.mm.model.c.ban().get(at.a.acLx, null), "");
        bh.bCz();
        if ((Util.nullAs((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLz, null), false)) && (paramf != null) && (!paramf.equals(""))) {}
        for (paramf = Boolean.TRUE;; paramf = Boolean.FALSE)
        {
          if (paramf.booleanValue()) {
            com.tencent.mm.plugin.report.service.h.OAn.b(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          new uk().publish();
          com.tencent.mm.br.c.ai(getContext(), "shake", ".ui.ShakeReportUI");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
      }
      if ("find_friends_by_qrcode".equals(paramPreference.mKey))
      {
        if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.aa.c.aYo().c(at.a.acXi, at.a.acXh);
        if ((com.tencent.mm.n.a.p(getContext(), true)) || (com.tencent.mm.n.a.dl(getContext())) || (com.tencent.mm.n.a.u(getContext(), true)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "2");
        paramf = new Intent();
        paramf.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
        paramf.putExtra("key_scan_entry_scene", 2);
        paramf.putExtra("key_scan_report_enter_scene", 5);
        paramf.putExtra("key_config_black_interval", true);
        paramf.putExtra("key_enable_multi_code", true);
        paramf.putExtra("key_scan_goods_enable_dynamic_wording", true);
        paramf.putExtra("key_enable_scan_code_product_merge", true);
        com.tencent.mm.plugin.report.service.h.OAn.b(11265, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", paramf);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if (paramPreference.mKey.equals("more_tab_game_recommend"))
      {
        if (!WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.plugin.newtips.a.gtf().aeI(12);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10958, "6");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 2L, 1L, false);
        bh.bCz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          aa.j(getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        paramPreference = new Intent();
        paramPreference.putExtra("from_find_more_friend", true);
        paramPreference.putExtra("game_report_from_scene", 901);
        if (this.adyj)
        {
          localObject = new ss();
          ((ss)localObject).publish();
          paramf = (IconPreference)paramf.bAi("more_tab_game_recommend");
          if ((((ss)localObject).hVY.icon != null) && (paramf != null)) {
            com.tencent.mm.modelimage.r.bKe().a(((ss)localObject).hVY.icon, paramf.jnm());
          }
        }
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyN);
        Log.i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
        paramPreference.putExtra("start_time", System.currentTimeMillis());
      }
      try
      {
        paramPreference.putExtra("from_source_activity", getContext().getComponentName().getClassName());
        label1745:
        paramPreference.putExtra("has_game_life_chat_msg", this.adyk);
        paramPreference.putExtra("game_life_msg_count", this.adyl);
        com.tencent.mm.br.c.b(getContext(), "game", ".ui.GameCenterUI", paramPreference);
        if (((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).fTT()) {
          sendBroadcast(new Intent(getContext(), LiteAppTaskPreloadReceiver.class));
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
        if ("find_friends_by_micromsg".equals(paramPreference.mKey))
        {
          com.tencent.mm.br.c.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if ("find_friends_by_mobile".equals(paramPreference.mKey))
        {
          if (com.tencent.mm.plugin.account.friend.model.i.bWW() != i.a.pSQ)
          {
            paramf = new Intent(getContext(), BindMContactIntroUI.class);
            paramf.putExtra("key_upload_scene", 6);
            MMWizardActivity.aQ(getContext(), paramf);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          paramf = new Intent(getContext(), MobileFriendUI.class);
          paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if ("find_friends_by_facebook".equals(paramPreference.mKey))
        {
          paramf = new Intent(getContext(), MMFBFriendUI.class);
          paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if ("settings_mm_card_package".equals(paramPreference.mKey))
        {
          Log.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
          paramf = new mg();
          paramf.hOp.context = getContext();
          paramf.publish();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if (paramPreference.mKey.equals("jd_market_entrance"))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryShop.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          com.tencent.mm.plugin.newtips.a.gtf().aeI(11);
          com.tencent.mm.pluginsdk.wallet.h.setPayChannel(9);
          if (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null)
          {
            localObject = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAU();
            paramf = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAV();
            Log.i("MicroMsg.FindMoreFriendsUI", "jumpUrl %s, jumpWeapp %s", new Object[] { localObject, paramf });
            i = jin();
            com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
            com.tencent.mm.plugin.subapp.jdbiz.d.hAM();
            com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
            com.tencent.mm.plugin.subapp.jdbiz.d.hAL();
            ((IconPreference)paramPreference).gv("", -1);
            if (paramf.isValid())
            {
              Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd weapp %s", new Object[] { paramf.username });
              com.tencent.mm.plugin.report.service.h.OAn.b(11179, new Object[] { paramf.username, com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN().rBJ, Integer.valueOf(i) });
              if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUB, 1) == 1)
              {
                i = 1;
                if (i == 0) {
                  break label2669;
                }
                paramPreference = new com.tencent.mm.plugin.appbrand.api.g();
                paramPreference.username = paramf.username;
                paramPreference.version = paramf.version;
                paramPreference.qAF = paramf.path;
                paramPreference.scene = 1112;
                if (jio())
                {
                  paramf = new WeAppOpenDeclarePromptBundle((byte)0);
                  paramf.hyY = 1;
                  paramf.qBc = getString(R.l.disclaimer_title);
                  paramf.qBd = getString(R.l.gLZ);
                  paramf.qBe = getString(R.l.app_i_know);
                  paramf.dqR = false;
                  paramPreference.qAR = paramf;
                }
                ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(getContext(), paramPreference);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
                i = 0;
                break;
                label2669:
                Log.i("MicroMsg.FindMoreFriendsUI", "onClickOfJDEntrance clicfg_appbrand_dialog_optimize_switch close");
                paramPreference = new AppBrandStatObject();
                paramPreference.scene = 1112;
                if (jio()) {
                  com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.gLZ), getString(R.l.disclaimer_title), false, new FindMoreFriendsUI.25(this, paramf, paramPreference));
                } else {
                  ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(getContext(), paramf.username, "", 0, paramf.version, paramf.path, paramPreference);
                }
              }
            }
            if (!Util.isNullOrNil((String)localObject))
            {
              Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd webview %s", new Object[] { localObject });
              com.tencent.mm.plugin.report.service.h.OAn.b(11179, new Object[] { localObject, com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN().rBJ, Integer.valueOf(i) });
              paramf = new Intent();
              paramf.putExtra("rawUrl", (String)localObject);
              paramf.putExtra("useJs", true);
              paramf.putExtra("vertical_scroll", true);
              paramf.putExtra("minimize_secene", 1);
              paramf.putExtra("KPublisherId", "jd_store");
              paramf = new FindMoreFriendsUI.26(this, paramf);
              if (!jio()) {
                break label2942;
              }
              com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.gLZ), getString(R.l.disclaimer_title), false, new FindMoreFriendsUI.27(this, paramf));
            }
          }
          for (;;)
          {
            break;
            label2942:
            paramf.run();
          }
        }
        if ("ip_call_entrance".equals(paramPreference.mKey))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryWeChatOut.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          paramf = (IconPreference)paramf.bAi("ip_call_entrance");
          paramf.aeD(8);
          paramf.aBf(8);
          paramf.LF(false);
          paramf.aBi(8);
          i = 0;
          bh.bCz();
          paramf = (String)com.tencent.mm.model.c.ban().get(at.a.acKN, "");
          bh.bCz();
          if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKO, Boolean.FALSE)).booleanValue() == true)
          {
            com.tencent.mm.plugin.ipcall.model.f.i.aO(1, -1, -1);
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKO, Boolean.FALSE);
            i = 1;
          }
          bh.bCz();
          if (((Integer)com.tencent.mm.model.c.ban().get(at.a.acKM, Integer.valueOf(0))).intValue() < com.tencent.mm.k.i.aRC().getInt("WCOEntranceRedDot", 0))
          {
            i = 1;
            com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKM, Integer.valueOf(com.tencent.mm.k.i.aRC().getInt("WCOEntranceRedDot", 0)));
          }
          if (!Util.isNullOrNil(paramf))
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKN, "");
          }
          if (i != 0) {
            new abk().publish();
          }
          if ((com.tencent.mm.n.a.aTe()) || (com.tencent.mm.n.a.aTh())) {
            com.tencent.mm.ui.base.k.a(getContext(), R.l.multitalk_in_tip, 0, null, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
            com.tencent.mm.plugin.report.service.h.OAn.b(12061, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
            com.tencent.mm.br.c.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
          }
        }
        if ("app_brand_entrance".equals(paramPreference.mKey))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryAppbrand.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          ((com.tencent.mm.plugin.appbrand.service.v)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.v.class)).T(getContext(), 1);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if ("find_friends_by_search".equals(paramPreference.mKey))
        {
          if (!WeChatBrands.Business.Entries.DiscoverySearch.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          if (!aj.asX(0)) {
            Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.gtf().aeI(9);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
            paramf = al.bix("discoverSearchEntry").optString("wording");
            if (Util.isNullOrNil(paramf))
            {
              Log.e("MicroMsg.FindMoreFriendsUI", "empty title");
            }
            else
            {
              ar.iqh().atd(2);
              paramPreference = ar.iqh();
              paramPreference.WpK = new ar.a();
              paramPreference.sz();
              ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
              as.u("", 0, 0, 20);
              paramPreference = aj.asV(20);
              localObject = com.tencent.mm.plugin.webview.modeltools.g.ivW().itd();
              HashMap localHashMap = new HashMap();
              localHashMap.put("sessionId", paramPreference);
              localHashMap.put("inputMarginTop", "32");
              localHashMap.put("inputMarginLeftRight", "24");
              localHashMap.put("inputHeight", "48");
              if ((localObject != null) && (!((String)localObject).isEmpty())) {
                localHashMap.put("educationTab", Uri.encode((String)localObject));
              }
              localHashMap.put("clickType", "0");
              ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).b(getContext(), 20, "", paramPreference, true, localHashMap, paramf);
              ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyC);
            }
          }
        }
        if ("find_friends_by_look".equals(paramPreference.mKey))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryLooks.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          if (!aj.asX(1)) {
            Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
          }
          for (;;)
          {
            com.tencent.mm.plugin.newtips.a.gtf().aeI(6);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
            paramf = al.bix("discoverRecommendEntry").optString("wording");
            if (!Util.isNullOrNil(paramf)) {
              break;
            }
            Log.e("MicroMsg.FindMoreFriendsUI", "empty query");
          }
          Log.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
          com.tencent.mm.plugin.topstory.ui.d.bc(getContext(), 21);
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
          paramPreference = new qw();
          paramPreference.hTT.scene = 0;
          paramPreference.publish();
          as.dE(21, paramf);
          as.nb(21, 0);
          if (aj.asY(1) > aj.ipO()) {
            as.nb(21, 15);
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMB();
            break;
            as.nb(21, 14);
          }
        }
        if ("my_life_around".equals(paramPreference.mKey))
        {
          if ((WeChatEnvironment.isCoolassistEnv()) || ((BuildInfo.IS_FLAVOR_RED) && (!com.tencent.mm.compatible.deviceinfo.q.awm()))) {
            MultiProcessMMKV.getSingleDefault().getInt("life_mode", 1);
          }
          jip();
          com.tencent.mm.plugin.newtips.a.gtf().aeI(10);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if (("find_friends_by_finder".equals(paramPreference.mKey)) && (com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class) != null))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryChannels.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adcU, Boolean.FALSE);
          paramf = com.tencent.mm.plugin.findersdk.d.a.Hdr;
          if (com.tencent.mm.plugin.findersdk.d.a.aDj("entrance"))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          if (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry())
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "second check finderEntry");
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.adbw, Boolean.FALSE)).booleanValue();
          Log.d("MicroMsg.FindMoreFriendsUI", "needShowOverSeaDialog".concat(String.valueOf(bool1)));
          if (bool1)
          {
            paramf = getString(R.l.finder_oversea_title);
            paramPreference = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adby, "");
            FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog(getContext(), paramf, paramPreference, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(33052);
                ((com.tencent.mm.plugin.findersdk.a.bc)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.bc.class)).s(Boolean.FALSE);
                FindMoreFriendsUI.r(FindMoreFriendsUI.this);
                AppMethodBeat.o(33052);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          paramf = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
          l = System.currentTimeMillis();
          paramPreference = paramf.Su("FinderEntrance");
          if (paramPreference == null)
          {
            paramf = null;
            if (paramf == null) {
              break label4671;
            }
            i = paramPreference.ASz.aabL;
            Log.i("Finder.RedDotManager", "[getAliveTabType] cost=" + (System.currentTimeMillis() - l) + "ms enterAction :" + i);
            switch (i)
            {
            default: 
              label4532:
              paramf = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
              if (paramf != null)
              {
                paramPreference = paramf.avK("FinderEntrance");
                paramf = paramf.ASz.ZNl;
                if ((paramPreference != null) && (paramf != null) && (paramf.jumpinfo_type == 3) && (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().dZs()))
                {
                  label4625:
                  if (paramf == null) {
                    break label4690;
                  }
                  bJ(false, true);
                }
              }
              break;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
            paramf = paramPreference.avK("FinderEntrance");
            break;
            label4671:
            i = 0;
            break label4532;
            bJ(true, false);
            continue;
            paramf = null;
            break label4625;
            label4690:
            bJ(false, false);
          }
        }
        if (("find_friends_by_finder_live".equals(paramPreference.mKey)) || (("find_friends_by_finder_live_above_look".equals(paramPreference.mKey)) && (com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class) != null)))
        {
          if (!WeChatBrands.Business.Entries.DiscoveryChannelsLive.checkAvailable(getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
          }
          if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isNewLiveEntranceEnable())
          {
            paramf = new Intent();
            paramPreference = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.jCq(), paramf);
            localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
            m.a.avE(paramPreference);
            ((com.tencent.d.a.b.a.d)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.d.class)).enterFinderLiveEntrance(getContext(), paramf);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
            com.tencent.mm.ui.report.a.jCo();
            paramf = new Intent();
            paramPreference = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.jCq(), paramf);
            localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
            m.a.avE(paramPreference);
            ((com.tencent.d.a.b.a.d)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.d.class)).enterFinderLiveSquare(getContext(), paramf);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return false;
      }
      catch (Exception paramf)
      {
        break label1745;
      }
      label4959:
      bool1 = true;
      break label362;
      label4965:
      bool2 = true;
    }
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33089);
    if (("find_friends_by_finder".equals(paramPreference.mKey)) && (com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class) != null) && ((WeChatEnvironment.isCoolassistEnv()) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)))
    {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntranceDebugSheet(getContext());
      AppMethodBeat.o(33089);
      return true;
    }
    if (("app_brand_entrance".equals(paramPreference.mKey)) && (((com.tencent.mm.plugin.appbrand.service.v)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.v.class)).ew(getContext())))
    {
      AppMethodBeat.o(33089);
      return true;
    }
    if (((WeChatEnvironment.isCoolassistEnv()) || (BuildInfo.IS_FLAVOR_RED)) && (!com.tencent.mm.compatible.deviceinfo.q.awm()) && ("my_life_around".equals(paramPreference.mKey)))
    {
      paramPreference = MultiProcessMMKV.getMultiDefault();
      int i = paramPreference.getInt("life_mode", 1);
      paramf = new AlertDialog.Builder(getContext()).setTitle("选择附近的餐厅的渲染模式");
      paramPreference = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(249892);
          paramPreference.putInt("life_mode", paramAnonymousInt);
          paramPreference.commit();
          AppMethodBeat.o(249892);
        }
      };
      paramf.setSingleChoiceItems(new String[] { "webview", "flutter" }, i, paramPreference).create().show();
      AppMethodBeat.o(33089);
      return true;
    }
    boolean bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
    AppMethodBeat.o(33089);
    return bool;
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(33077);
      adyV = new a("TYPE_NONE", 0);
      adyW = new a("TYPE_NORMAL", 1);
      adyX = new a("TYPE_TEXT", 2);
      adyY = new a("TYPE_IMG", 3);
      adyZ = new a("TYPE_IMG_TEXT", 4);
      adza = new a("TYPE_NEW_HINT", 5);
      adzb = new a[] { adyV, adyW, adyX, adyY, adyZ, adza };
      AppMethodBeat.o(33077);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */