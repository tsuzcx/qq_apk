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
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.d;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.f.a.abz;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.f.a.jn;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.a.jp;
import com.tencent.mm.f.a.ke;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.kt.a;
import com.tencent.mm.f.a.lc;
import com.tencent.mm.f.a.mf;
import com.tencent.mm.f.a.pj;
import com.tencent.mm.f.a.rd;
import com.tencent.mm.f.a.rd.a;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.f.a.uv;
import com.tencent.mm.f.a.ux;
import com.tencent.mm.f.a.vr;
import com.tencent.mm.f.a.vv;
import com.tencent.mm.f.a.vv.b;
import com.tencent.mm.f.a.vx;
import com.tencent.mm.f.a.zp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.findersdk.a.u;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.plugin.websearch.api.aq.a;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.findmore.a.a.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FindMoreFriendsUI
  extends AbstractTabChildPreference
  implements bc, bd, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static int VTM = 1000;
  private com.tencent.mm.ui.base.preference.h Avm;
  private IListener<abz> BOg;
  private com.tencent.mm.pluginsdk.d.a Dbj;
  private CheckBox GsT;
  private com.tencent.mm.ui.widget.a.d GsV;
  r.a GvL;
  IListener JYs;
  private int JhW;
  private View Nsh;
  private com.tencent.mm.pluginsdk.d.a RpX;
  private long VTN;
  private View VTO;
  private String VTP;
  private int VTQ;
  private String VTR;
  private String VTS;
  private String VTT;
  private String VTU;
  private String VTV;
  private boolean VTW;
  private boolean VTX;
  private boolean VTY;
  private boolean VTZ;
  private int VUa;
  private long VUb;
  private int VUc;
  private TextView VUd;
  private IListener<uv> VUe;
  IListener VUf;
  IListener VUg;
  private com.tencent.mm.pluginsdk.d.a VUh;
  private com.tencent.mm.pluginsdk.d.a VUi;
  private IListener VUj;
  private String VUk;
  private a VUl;
  private com.tencent.mm.plugin.messenger.foundation.a.t VUm;
  private IListener<ke> VUn;
  private com.tencent.mm.ui.findmore.a.b VUo;
  private com.tencent.mm.ui.findmore.a.a VUp;
  private boolean VUq;
  private boolean VUr;
  private boolean fHD;
  private MMHandler mHandler;
  private com.tencent.mm.ui.widget.b.a oEa;
  private int status;
  private long tZb;
  private s<com.tencent.mm.plugin.finder.extension.reddot.h.a> xnQ;
  
  public FindMoreFriendsUI()
  {
    AppMethodBeat.i(33078);
    this.GsV = null;
    this.VTP = "";
    this.VTQ = 0;
    this.VTR = null;
    this.VTS = null;
    this.VTT = null;
    this.VTU = null;
    this.VTV = null;
    this.VTW = false;
    this.VTX = false;
    this.VTY = true;
    this.fHD = false;
    this.VTZ = false;
    this.VUa = 0;
    this.VUb = 0L;
    this.mHandler = new FindMoreFriendsUI.1(this, Looper.getMainLooper());
    this.VUe = new IListener() {};
    this.RpX = new FindMoreFriendsUI.21(this);
    this.JYs = new FindMoreFriendsUI.32(this);
    this.VUf = new FindMoreFriendsUI.34(this);
    this.VUg = new FindMoreFriendsUI.36(this);
    this.Dbj = new com.tencent.mm.pluginsdk.d.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(33072);
        if ((paramAnonymousIEvent instanceof jo))
        {
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, false);
          FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(33072);
      }
    };
    this.VUh = new com.tencent.mm.pluginsdk.d.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(33073);
        if ((paramAnonymousIEvent instanceof jn))
        {
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, true);
          FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(33073);
      }
    };
    this.VUi = new FindMoreFriendsUI.39(this);
    this.VUj = new FindMoreFriendsUI.2(this);
    this.VUl = a.VUG;
    this.VUm = new com.tencent.mm.plugin.messenger.foundation.a.t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.an.h.a paramAnonymousa)
      {
        AppMethodBeat.i(268355);
        if ((Util.nullAsNil(paramAnonymousString).equals("lifeappreddot")) && (paramAnonymousMap != null))
        {
          boolean bool = "1".equals(paramAnonymousMap.get(".sysmsg.lifeappreddot"));
          Log.i("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvN, Boolean.valueOf(bool));
          if (bool)
          {
            paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.lifeappreddot.$type");
            paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.lifeappreddot.$text");
            paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.lifeappreddot.$imageurl");
            Log.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", new Object[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap });
            if (FindMoreFriendsUI.a(FindMoreFriendsUI.this, paramAnonymousa, paramAnonymousMap))
            {
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvP, paramAnonymousString);
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvQ, paramAnonymousa);
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvR, paramAnonymousMap);
            }
            AppMethodBeat.o(268355);
            return;
          }
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, FindMoreFriendsUI.a.VUG);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvP, "0");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvQ, "");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvR, "");
        }
        AppMethodBeat.o(268355);
      }
    };
    this.BOg = new IListener() {};
    this.VUn = new FindMoreFriendsUI.10(this);
    this.GvL = new r.a()
    {
      public final void a(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(290671);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(291996);
            Object localObject = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
            if (paramAnonymousBitmap == null) {}
            for (boolean bool = true;; bool = false)
            {
              Log.i("MicroMsg.FindMoreFriendsUI", bool);
              localObject = (IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("jd_market_entrance");
              if (localObject != null)
              {
                if (paramAnonymousString1.equals(FindMoreFriendsUI.j(FindMoreFriendsUI.this)))
                {
                  ((IconPreference)localObject).aK(paramAnonymousBitmap);
                  FindMoreFriendsUI.d(FindMoreFriendsUI.this, null);
                }
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.k(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("find_friends_by_look")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), paramAnonymousBitmap);
                FindMoreFriendsUI.l(FindMoreFriendsUI.this);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.m(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("find_friends_by_search")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), paramAnonymousBitmap);
                FindMoreFriendsUI.n(FindMoreFriendsUI.this);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.o(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("find_friends_by_look")).aK(paramAnonymousBitmap);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.p(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("find_friends_by_search")).aK(paramAnonymousBitmap);
                FindMoreFriendsUI.c(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              if (paramAnonymousString1.equals(FindMoreFriendsUI.q(FindMoreFriendsUI.this)))
              {
                ((IconPreference)FindMoreFriendsUI.a(FindMoreFriendsUI.this).byG("my_life_around")).aK(BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() * 0.1F));
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, null);
                FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(291996);
              return;
            }
          }
        });
        AppMethodBeat.o(290671);
      }
    };
    this.VUo = null;
    this.xnQ = null;
    this.VUp = null;
    this.VUq = false;
    this.VUr = false;
    AppMethodBeat.o(33078);
  }
  
  private void Fl(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(33087);
    boolean bool1 = bool2;
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.pluginsdk.j.d.QYQ != null)
    {
      if (!com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghx()) {
        break label657;
      }
      this.VUc += 1;
      localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu();
      localObject2 = (NormalIconNewTipPreference)this.Avm.byG("jd_market_entrance");
      com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
      ((NormalIconNewTipPreference)localObject2).setTitle(com.tencent.mm.plugin.subapp.jdbiz.d.ghy());
      ((NormalIconNewTipPreference)localObject2).a(this.Avm);
      com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject2);
      ((NormalIconNewTipPreference)localObject2).a(this.GvL, new NormalIconNewTipPreference.a()
      {
        public final void aSU(String paramAnonymousString)
        {
          AppMethodBeat.i(288334);
          FindMoreFriendsUI.d(FindMoreFriendsUI.this, paramAnonymousString);
          AppMethodBeat.o(288334);
        }
      });
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
      if ((!com.tencent.mm.plugin.subapp.jdbiz.d.ghq()) || (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).isStart()) || (((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).eqj())) {
        break label519;
      }
      bool1 = true;
      if ((!bool1) || ((Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdm)) && (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdn)) && (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdl))) {
        break label524;
      }
      bool2 = true;
      label173:
      if (!com.tencent.mm.plugin.newtips.a.g.a(bool2, (com.tencent.mm.plugin.newtips.a.a)localObject2))
      {
        ((NormalIconNewTipPreference)localObject2).abe(8);
        ((NormalIconNewTipPreference)localObject2).aak(8);
        ((NormalIconNewTipPreference)localObject2).auD(8);
        ((NormalIconNewTipPreference)localObject2).FT(false);
        ((NormalIconNewTipPreference)localObject2).auG(8);
        if (!bool1) {
          break label649;
        }
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdm))
        {
          ((NormalIconNewTipPreference)localObject2).abe(8);
          ((NormalIconNewTipPreference)localObject2).aak(8);
          ((NormalIconNewTipPreference)localObject2).aU(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdm, -1, -7566196);
          ((NormalIconNewTipPreference)localObject2).auD(0);
        }
        if (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdn)) {
          break label569;
        }
        com.tencent.mm.ay.q.bmg();
        Bitmap localBitmap = com.tencent.mm.ay.d.LI(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdn);
        ((NormalIconNewTipPreference)localObject2).auG(0);
        ((NormalIconNewTipPreference)localObject2).auF(0);
        ((NormalIconNewTipPreference)localObject2).auH(0);
        ((NormalIconNewTipPreference)localObject2).FT(false);
        if (localBitmap == null) {
          break label529;
        }
        this.VTV = null;
        ((NormalIconNewTipPreference)localObject2).aK(localBitmap);
        label331:
        if (Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdm)) {
          break label556;
        }
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, k.GwO, true);
        label352:
        dx("jd_market_entrance", bool1);
      }
      if (paramBoolean) {
        this.Avm.notifyDataSetChanged();
      }
      paramBoolean = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VxL, false);
      if ((!hFY()) || (paramBoolean))
      {
        localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghC().username;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghB();
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxL, Boolean.FALSE);
        com.tencent.mm.plugin.report.service.h.IzE.el(931, 12);
        com.tencent.mm.plugin.report.service.h.IzE.a(11178, new Object[] { localObject1, com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu().oym, Integer.valueOf(hGc()), Integer.valueOf(2) });
      }
      bool1 = false;
    }
    for (;;)
    {
      this.Avm.dz("jd_market_entrance", bool1);
      AppMethodBeat.o(33087);
      return;
      label519:
      bool1 = false;
      break;
      label524:
      bool2 = false;
      break label173;
      label529:
      com.tencent.mm.ay.q.bmk().a(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdn, this.GvL);
      this.VTV = ((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdn;
      break label331;
      label556:
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, k.GwN, true);
      break label352;
      label569:
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdm))
      {
        ((NormalIconNewTipPreference)localObject2).FT(true);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, k.GwM, true);
        break label352;
      }
      if (((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).Mdl)
      {
        ((NormalIconNewTipPreference)localObject2).aak(0);
        ((NormalIconNewTipPreference)localObject2).fC("", -1);
        ((NormalIconNewTipPreference)localObject2).abe(8);
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2, k.GwK, true);
        break label352;
      }
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      break label352;
      label649:
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
      break label352;
      label657:
      com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
      localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.ghy();
      com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
      localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.ghz();
      bool1 = bool2;
      if (!hFY())
      {
        bool1 = bool2;
        if (LocaleUtil.isSimplifiedChineseAppLang())
        {
          if (Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.IzE.el(931, 2);
          }
          bool1 = bool2;
          if (Util.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(931, 4);
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void Fm(boolean paramBoolean)
  {
    AppMethodBeat.i(282126);
    int i = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getTimelineCommentScene();
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 0L, 1L, false);
    Object localObject2 = new Intent();
    String str = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(1, 1, i, (Intent)localObject2);
    Object localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
    localObject1 = i.a.dQ(str, 0);
    ((Intent)localObject2).putExtra("key_red_dot_id", (String)localObject1);
    if (paramBoolean) {
      ((Intent)localObject2).putExtra("KEY_ROUTE_TO_PAGE", FinderSelfUI.class.getSimpleName());
    }
    ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderTimelineUI(getContext(), (Intent)localObject2, Boolean.TRUE);
    localObject2 = n.zWF;
    n.hj(str, "Enter");
    localObject2 = n.zWF;
    n.hi(str, (String)localObject1);
    AppMethodBeat.o(282126);
  }
  
  private static void Fn(boolean paramBoolean)
  {
    AppMethodBeat.i(33098);
    com.tencent.mm.plugin.game.api.b.a.evu().sb(paramBoolean);
    AppMethodBeat.o(33098);
  }
  
  /* Error */
  private void a(final rd paramrd1, final IconPreference paramIconPreference, rd paramrd2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 650
    //   5: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   12: getfield 661	com/tencent/mm/f/a/rd$a:icon	Ljava/lang/String;
    //   15: astore 10
    //   17: aload_1
    //   18: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   21: getfield 664	com/tencent/mm/f/a/rd$a:iconWidth	I
    //   24: istore 5
    //   26: aload_1
    //   27: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   30: getfield 667	com/tencent/mm/f/a/rd$a:iconHeight	I
    //   33: istore 6
    //   35: aload_1
    //   36: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   39: getfield 670	com/tencent/mm/f/a/rd$a:fQe	Z
    //   42: istore 7
    //   44: aload 10
    //   46: invokestatic 365	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   49: ifne +14 -> 63
    //   52: aload_2
    //   53: ifnull +10 -> 63
    //   56: aload_2
    //   57: invokevirtual 676	com/tencent/mm/ui/base/preference/IconPreference:hKJ	()Landroid/widget/ImageView;
    //   60: ifnonnull +12 -> 72
    //   63: ldc_w 650
    //   66: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: ldc_w 678
    //   75: ldc_w 680
    //   78: iconst_3
    //   79: anewarray 493	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload 10
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: iload 5
    //   91: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: iload 6
    //   99: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 685	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: iload 5
    //   108: ifle +28 -> 136
    //   111: iload 6
    //   113: ifle +23 -> 136
    //   116: aload_2
    //   117: invokestatic 690	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   120: iload 5
    //   122: invokestatic 696	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   125: invokestatic 690	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   128: iload 5
    //   130: invokestatic 696	com/tencent/mm/ci/a:fromDPToPix	(Landroid/content/Context;I)I
    //   133: invokevirtual 699	com/tencent/mm/ui/base/preference/IconPreference:mu	(II)V
    //   136: aload_3
    //   137: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   140: getfield 702	com/tencent/mm/f/a/rd$a:msgId	J
    //   143: lstore 8
    //   145: aload_3
    //   146: getfield 656	com/tencent/mm/f/a/rd:fQd	Lcom/tencent/mm/f/a/rd$a;
    //   149: getfield 705	com/tencent/mm/f/a/rd$a:fwp	I
    //   152: istore 5
    //   154: new 707	com/tencent/mm/f/a/jp
    //   157: dup
    //   158: invokespecial 708	com/tencent/mm/f/a/jp:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: getfield 712	com/tencent/mm/f/a/jp:fGP	Lcom/tencent/mm/f/a/jp$a;
    //   166: iconst_1
    //   167: putfield 717	com/tencent/mm/f/a/jp$a:Vh	I
    //   170: aload_1
    //   171: getfield 712	com/tencent/mm/f/a/jp:fGP	Lcom/tencent/mm/f/a/jp$a;
    //   174: aload 10
    //   176: putfield 720	com/tencent/mm/f/a/jp$a:url	Ljava/lang/String;
    //   179: getstatic 726	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   182: aload_1
    //   183: invokevirtual 730	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   186: pop
    //   187: aload_1
    //   188: getfield 734	com/tencent/mm/f/a/jp:fGQ	Lcom/tencent/mm/f/a/jp$b;
    //   191: getfield 739	com/tencent/mm/f/a/jp$b:fGS	Z
    //   194: ifeq +99 -> 293
    //   197: new 741	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 742	java/lang/StringBuilder:<init>	()V
    //   204: aload_1
    //   205: getfield 734	com/tencent/mm/f/a/jp:fGQ	Lcom/tencent/mm/f/a/jp$b;
    //   208: getfield 745	com/tencent/mm/f/a/jp$b:fGR	Ljava/lang/String;
    //   211: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 10
    //   216: invokevirtual 755	java/lang/String:getBytes	()[B
    //   219: invokestatic 761	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   222: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 764	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_3
    //   229: new 766	com/tencent/mm/ay/a/a/c$a
    //   232: dup
    //   233: invokespecial 767	com/tencent/mm/ay/a/a/c$a:<init>	()V
    //   236: astore 11
    //   238: aload 11
    //   240: iconst_1
    //   241: putfield 770	com/tencent/mm/ay/a/a/c$a:lRD	Z
    //   244: aload 11
    //   246: aload_3
    //   247: putfield 773	com/tencent/mm/ay/a/a/c$a:fullPath	Ljava/lang/String;
    //   250: aload 11
    //   252: invokevirtual 777	com/tencent/mm/ay/a/a/c$a:bmL	()Lcom/tencent/mm/ay/a/a/c;
    //   255: astore_3
    //   256: invokestatic 781	com/tencent/mm/ay/q:bml	()Lcom/tencent/mm/ay/a/a;
    //   259: aload 10
    //   261: aconst_null
    //   262: aload_3
    //   263: new 783	com/tencent/mm/ui/FindMoreFriendsUI$26
    //   266: dup
    //   267: aload_0
    //   268: aload_1
    //   269: invokespecial 786	com/tencent/mm/ui/FindMoreFriendsUI$26:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;Lcom/tencent/mm/f/a/jp;)V
    //   272: new 32	com/tencent/mm/ui/FindMoreFriendsUI$27
    //   275: dup
    //   276: aload_0
    //   277: iload 7
    //   279: aload_1
    //   280: aload_2
    //   281: iload 5
    //   283: lload 8
    //   285: aload 4
    //   287: invokespecial 789	com/tencent/mm/ui/FindMoreFriendsUI$27:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;ZLcom/tencent/mm/f/a/jp;Lcom/tencent/mm/ui/base/preference/IconPreference;IJLjava/lang/String;)V
    //   290: invokevirtual 794	com/tencent/mm/ay/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/ay/a/a/c;Lcom/tencent/mm/ay/a/c/k;Lcom/tencent/mm/ay/a/c/h;)V
    //   293: ldc_w 650
    //   296: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: goto -230 -> 69
    //   302: astore_1
    //   303: aload_0
    //   304: monitorexit
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	FindMoreFriendsUI
    //   0	307	1	paramrd1	rd
    //   0	307	2	paramIconPreference	IconPreference
    //   0	307	3	paramrd2	rd
    //   0	307	4	paramString	String
    //   24	258	5	i	int
    //   33	79	6	j	int
    //   42	236	7	bool	boolean
    //   143	141	8	l	long
    //   15	245	10	str	String
    //   236	15	11	locala	com.tencent.mm.ay.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   2	52	302	finally
    //   56	63	302	finally
    //   63	69	302	finally
    //   72	106	302	finally
    //   116	136	302	finally
    //   136	293	302	finally
    //   293	299	302	finally
  }
  
  private void a(final aq.a parama, final IconPreference paramIconPreference)
  {
    AppMethodBeat.i(33083);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33038);
        if (paramIconPreference == null)
        {
          AppMethodBeat.o(33038);
          return;
        }
        FindMoreFriendsUI.dx("find_friends_by_search", false);
        com.tencent.mm.plugin.newtips.a.a locala = (com.tencent.mm.plugin.newtips.a.a)paramIconPreference;
        if ((parama != null) && (parama.isValid()) && (parama.type > 0) && (parama.type <= 4)) {}
        for (boolean bool = true; locala.tX(bool); bool = false)
        {
          AppMethodBeat.o(33038);
          return;
        }
        paramIconPreference.abe(8);
        if (parama == null)
        {
          paramIconPreference.aak(8);
          AppMethodBeat.o(33038);
          return;
        }
        if (parama.isValid())
        {
          Log.i("MicroMsg.FindMoreFriendsUI", "show red %s", new Object[] { paramIconPreference.getTitle() });
          switch (parama.type)
          {
          default: 
            Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(parama.type) });
          }
        }
        for (;;)
        {
          FindMoreFriendsUI.dx("find_friends_by_search", parama.isValid());
          FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
          AppMethodBeat.o(33038);
          return;
          paramIconPreference.aak(0);
          paramIconPreference.auD(8);
          locala.a(k.GwK, true);
          continue;
          paramIconPreference.aak(8);
          paramIconPreference.auD(0);
          paramIconPreference.aU(parama.text, -1, Color.parseColor("#8c8c8c"));
          paramIconPreference.FT(true);
          paramIconPreference.auG(8);
          locala.a(k.GwM, true);
          continue;
          paramIconPreference.auG(0);
          paramIconPreference.auF(0);
          paramIconPreference.auH(0);
          paramIconPreference.FT(false);
          com.tencent.mm.ay.q.bmg();
          Bitmap localBitmap = com.tencent.mm.ay.d.LI(parama.icon);
          if (localBitmap != null)
          {
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, null);
            paramIconPreference.aK(localBitmap);
          }
          for (;;)
          {
            locala.a(k.GwN, true);
            break;
            com.tencent.mm.ay.q.bmk().a(parama.icon, FindMoreFriendsUI.this.GvL);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, parama.icon);
          }
          paramIconPreference.auG(0);
          paramIconPreference.auF(0);
          paramIconPreference.auH(0);
          paramIconPreference.auD(0);
          paramIconPreference.FT(false);
          paramIconPreference.aU(parama.text, -1, Color.parseColor("#8c8c8c"));
          com.tencent.mm.ay.q.bmg();
          localBitmap = com.tencent.mm.ay.d.LI(parama.icon);
          if (localBitmap != null)
          {
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, null);
            paramIconPreference.aK(localBitmap);
          }
          for (;;)
          {
            locala.a(k.GwO, true);
            break;
            com.tencent.mm.ay.q.bmk().a(parama.icon, FindMoreFriendsUI.this.GvL);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, parama.icon);
          }
          Log.i("MicroMsg.FindMoreFriendsUI", "hide red %s", new Object[] { paramIconPreference.getTitle() });
          paramIconPreference.aak(8);
          paramIconPreference.auD(8);
          paramIconPreference.auG(8);
          paramIconPreference.auO(0);
          if ((paramIconPreference instanceof NormalIconNewTipPreference)) {
            com.tencent.mm.plugin.newtips.a.g.a((NormalIconNewTipPreference)paramIconPreference);
          }
        }
      }
    });
    AppMethodBeat.o(33083);
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(33100);
    paramIconPreference.abe(paramInt1);
    paramIconPreference.aak(paramInt2);
    paramIconPreference.auD(paramInt3);
    paramIconPreference.FT(paramBoolean);
    paramIconPreference.auG(paramInt4);
    paramIconPreference.auF(paramInt5);
    paramIconPreference.auH(paramInt6);
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0) || (paramBoolean) || (paramInt4 == 0) || (paramInt5 == 0) || (paramInt6 == 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      dx("more_tab_game_recommend", paramBoolean);
      AppMethodBeat.o(33100);
      return;
    }
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(33082);
    paramIconPreference.aak(paramInt1);
    paramIconPreference.auD(paramInt2);
    paramIconPreference.FT(paramBoolean);
    paramIconPreference.auG(paramInt3);
    paramIconPreference.auF(paramInt4);
    paramIconPreference.auH(paramInt5);
    AppMethodBeat.o(33082);
  }
  
  private void aIG()
  {
    AppMethodBeat.i(161495);
    EventCenter.instance.removeListener(this.VUf);
    EventCenter.instance.removeListener(this.VUe);
    EventCenter.instance.removeListener(this.VUg);
    EventCenter.instance.removeListener(this.JYs);
    EventCenter.instance.removeListener(this.VUj);
    EventCenter.instance.removeListener(this.BOg);
    EventCenter.instance.removeListener(this.VUn);
    if (bh.aHB())
    {
      com.tencent.mm.pluginsdk.d.a.b(mf.class.getName(), this.RpX);
      com.tencent.mm.pluginsdk.d.a.b(jo.class.getName(), this.Dbj);
      com.tencent.mm.pluginsdk.d.a.b(vr.class.getName(), this.VUi);
      com.tencent.mm.pluginsdk.d.a.b(jn.class.getName(), this.VUh);
      com.tencent.mm.bl.d.bqe().remove(this);
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(this);
      bh.beI();
      com.tencent.mm.model.c.b(this);
      bh.beI();
      com.tencent.mm.model.c.aHp().remove(this);
      if (this.VTV != null) {
        com.tencent.mm.ay.q.bmg().VL(this.VTV);
      }
    }
    if (com.tencent.mm.plugin.sns.b.p.JPg != null) {
      com.tencent.mm.plugin.sns.b.p.JPg.b(this);
    }
    AppMethodBeat.o(161495);
  }
  
  private static void aw(long paramLong, int paramInt)
  {
    AppMethodBeat.i(33097);
    com.tencent.mm.kernel.h.aHH();
    if (paramLong != com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.VsJ, 0L))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsJ, Long.valueOf(paramLong));
      com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.evu();
      if (localb != null) {
        localb.V(paramLong, paramInt);
      }
    }
    AppMethodBeat.o(33097);
  }
  
  private boolean bBl()
  {
    AppMethodBeat.i(282109);
    boolean bool3 = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).showFinderEntry();
    boolean bool1;
    if (!Hh(34359738368L))
    {
      bool1 = true;
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
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
      AppMethodBeat.o(282109);
      return true;
      bool1 = false;
      break;
    }
    label134:
    AppMethodBeat.o(282109);
    return false;
  }
  
  public static void dx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(282142);
    Log.i("MicroMsg.FindMoreFriendsUI", "note entry red dot [%s] entry [%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    hx localhx = new hx();
    localhx.fEW.fEX = paramString;
    localhx.fEW.fEY = paramBoolean;
    EventCenter.instance.publish(localhx);
    AppMethodBeat.o(282142);
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(33084);
    int j = ax.ew(getContext());
    int i = ax.F(getContext(), -1);
    View localView = getView().getRootView().findViewById(R.h.action_bar_container);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label178;
        }
      }
      label173:
      label178:
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
            break label173;
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
  
  private void hFZ()
  {
    AppMethodBeat.i(33080);
    Log.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
    if ((!hKT()) || (!isAdded()))
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
          this.Avm.dz("find_friends_by_finder", true);
        }
        Object localObject1 = com.tencent.mm.plugin.websearch.api.ak.biP("discoverRecommendEntry");
        localObject2 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
        if (localObject2 == null) {
          break label318;
        }
        bool = ((com.tencent.mm.plugin.topstory.a.e)localObject2).gpE();
        Log.i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label279;
        }
        localObject1 = ((JSONObject)localObject1).optString("wording");
        localObject2 = (NormalIconNewTipPreference)this.Avm.byG("find_friends_by_look");
        if (Util.isNullOrNil((String)localObject1))
        {
          ((NormalIconNewTipPreference)localObject2).setTitle(getString(R.l.find_friends_look));
          ((NormalIconNewTipPreference)localObject2).a(this.Avm);
          com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject2);
          ((NormalIconNewTipPreference)localObject2).a(this.GvL, new NormalIconNewTipPreference.a()
          {
            public final void aSU(String paramAnonymousString)
            {
              AppMethodBeat.i(278112);
              FindMoreFriendsUI.a(FindMoreFriendsUI.this, paramAnonymousString);
              AppMethodBeat.o(278112);
            }
          });
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject2);
          this.VUc += 1;
          this.Avm.dz("find_friends_by_look", false);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              boolean bool2 = false;
              AppMethodBeat.i(33037);
              if (this.qTC == null)
              {
                AppMethodBeat.o(33037);
                return;
              }
              FindMoreFriendsUI.dx("find_friends_by_look", false);
              boolean bool1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpF();
              int i;
              int j;
              label123:
              int m;
              int k;
              if ((((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpg()) && (bool1))
              {
                i = 1;
                bool1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpG();
                if ((!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpw()) || (!bool1)) {
                  break label337;
                }
                j = 1;
                m = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpp();
                if ((m <= 0) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gph())) {
                  break label342;
                }
                k = 1;
                label171:
                if (((k == 0) && (j != 0)) || ((k == 0) && (j != 0) && (LauncherUI.getCurrentTabIndex() == 2))) {
                  ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpI();
                }
                if ((k != 0) || (i == 0)) {
                  break label1469;
                }
              }
              label1420:
              label1469:
              for (Object localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj();; localObject = null)
              {
                if ((k == 0) && (j != 0)) {}
                for (ess localess = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpm();; localess = null)
                {
                  com.tencent.mm.plugin.newtips.a.a locala = (com.tencent.mm.plugin.newtips.a.a)this.qTC;
                  if ((k != 0) || ((i != 0) && ((localObject == null) || ((((ess)localObject).type > 0) && (((ess)localObject).type <= 4)))) || (j != 0)) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    if (!locala.tX(bool1)) {
                      break label353;
                    }
                    AppMethodBeat.o(33037);
                    return;
                    i = 0;
                    break;
                    label337:
                    j = 0;
                    break label123;
                    label342:
                    k = 0;
                    break label171;
                  }
                  label353:
                  if ((localObject != null) && (localess != null)) {
                    if (com.tencent.mm.plugin.topstory.ui.d.gqb() == 100) {
                      i = 0;
                    }
                  }
                  for (;;)
                  {
                    this.qTC.aak(8);
                    this.qTC.auD(8);
                    this.qTC.auG(8);
                    this.qTC.abe(8);
                    if (k != 0)
                    {
                      this.qTC.abe(0);
                      localObject = String.valueOf(m);
                      if (m > 99) {
                        localObject = "99+";
                      }
                      this.qTC.fC((String)localObject, com.tencent.mm.ui.tools.w.bj(FindMoreFriendsUI.this.getContext(), m));
                      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpI();
                      locala.a(k.GwP, true);
                    }
                    for (;;)
                    {
                      label489:
                      if ((j == 0) && (k == 0))
                      {
                        bool1 = bool2;
                        if (i == 0) {}
                      }
                      else
                      {
                        bool1 = true;
                      }
                      FindMoreFriendsUI.dx("find_friends_by_look", bool1);
                      FindMoreFriendsUI.a(FindMoreFriendsUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(33037);
                      return;
                      j = 0;
                      break;
                      if ((i != 0) && (localObject != null)) {}
                      switch (((ess)localObject).type)
                      {
                      default: 
                        Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(((ess)localObject).type) });
                      case 1: 
                      case 2: 
                        while (j != 0)
                        {
                          if (localess == null) {
                            break label1420;
                          }
                          switch (localess.type)
                          {
                          default: 
                            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpI();
                            this.qTC.aak(0);
                            locala.a(k.GwK, true);
                            break label489;
                            this.qTC.aak(0);
                            locala.a(k.GwK, true);
                            continue;
                            this.qTC.aak(8);
                            this.qTC.auD(0);
                            this.qTC.aU(((ess)localObject).text, -1, Color.parseColor("#8c8c8c"));
                            this.qTC.FT(true);
                            this.qTC.auG(8);
                            locala.a(k.GwM, true);
                          }
                        }
                      case 3: 
                        this.qTC.aak(8);
                        this.qTC.auG(0);
                        this.qTC.auF(0);
                        this.qTC.auH(0);
                        this.qTC.FT(false);
                        com.tencent.mm.ay.q.bmg();
                        localBitmap = com.tencent.mm.ay.d.LI(((ess)localObject).icon);
                        if (localBitmap != null)
                        {
                          FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                          this.qTC.aK(localBitmap);
                        }
                        for (;;)
                        {
                          locala.a(k.GwN, true);
                          break;
                          com.tencent.mm.ay.q.bmk().a(((ess)localObject).icon, FindMoreFriendsUI.this.GvL);
                          FindMoreFriendsUI.a(FindMoreFriendsUI.this, ((ess)localObject).icon);
                        }
                      }
                      this.qTC.aak(8);
                      this.qTC.auG(0);
                      this.qTC.auF(0);
                      this.qTC.auH(0);
                      this.qTC.auD(0);
                      this.qTC.FT(false);
                      this.qTC.aU(((ess)localObject).text, -1, Color.parseColor("#8c8c8c"));
                      com.tencent.mm.ay.q.bmg();
                      Bitmap localBitmap = com.tencent.mm.ay.d.LI(((ess)localObject).icon);
                      if (localBitmap != null)
                      {
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                        this.qTC.aK(localBitmap);
                      }
                      for (;;)
                      {
                        locala.a(k.GwO, true);
                        break;
                        com.tencent.mm.ay.q.bmk().a(((ess)localObject).icon, FindMoreFriendsUI.this.GvL);
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, ((ess)localObject).icon);
                      }
                      this.qTC.aak(0);
                      locala.a(k.GwK, true);
                      continue;
                      this.qTC.aak(8);
                      this.qTC.auD(0);
                      this.qTC.aU(localess.text, -1, Color.parseColor("#8c8c8c"));
                      this.qTC.FT(true);
                      this.qTC.auG(8);
                      locala.a(k.GwM, true);
                      continue;
                      this.qTC.aak(8);
                      this.qTC.auG(0);
                      this.qTC.auF(0);
                      this.qTC.auH(0);
                      this.qTC.FT(false);
                      com.tencent.mm.ay.q.bmg();
                      localObject = com.tencent.mm.ay.d.LI(localess.icon);
                      if (localObject != null)
                      {
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                        this.qTC.aK((Bitmap)localObject);
                      }
                      for (;;)
                      {
                        locala.a(k.GwN, true);
                        break;
                        com.tencent.mm.ay.q.bmk().a(localess.icon, FindMoreFriendsUI.this.GvL);
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, localess.icon);
                      }
                      this.qTC.aak(8);
                      this.qTC.auG(0);
                      this.qTC.auF(0);
                      this.qTC.auH(0);
                      this.qTC.auD(0);
                      this.qTC.FT(false);
                      this.qTC.aU(localess.text, -1, Color.parseColor("#8c8c8c"));
                      com.tencent.mm.ay.q.bmg();
                      localObject = com.tencent.mm.ay.d.LI(localess.icon);
                      if (localObject != null)
                      {
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, null);
                        this.qTC.aK((Bitmap)localObject);
                      }
                      for (;;)
                      {
                        locala.a(k.GwO, true);
                        break;
                        com.tencent.mm.ay.q.bmk().a(localess.icon, FindMoreFriendsUI.this.GvL);
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, localess.icon);
                      }
                      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpI();
                      this.qTC.aak(0);
                      locala.a(k.GwK, true);
                    }
                  }
                }
              }
            }
          });
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.ui.b.class)).tryToCreateTopStoryWebView();
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
      this.Avm.dz("find_friends_by_look", true);
      if (!hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 3L, 1L);
      }
      AppMethodBeat.o(33080);
      return;
      label318:
      boolean bool = true;
    }
  }
  
  private void hGa()
  {
    AppMethodBeat.i(282110);
    final View localView = getView().getRootView().findViewById(R.h.dKR);
    int i = ax.ew(getContext());
    int j = ax.F(getContext(), -1);
    Runnable local8 = new Runnable()
    {
      int kQn = 0;
      
      public final void run()
      {
        AppMethodBeat.i(286443);
        if (FindMoreFriendsUI.this.getView() == null)
        {
          AppMethodBeat.o(286443);
          return;
        }
        int i = ax.ew(FindMoreFriendsUI.this.getContext());
        int j = ax.F(FindMoreFriendsUI.this.getContext(), -1);
        if (j <= 0) {
          if (this.kQn < 2)
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
            FindMoreFriendsUI.this.getView().post(this);
            this.kQn += 1;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.kQn), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(286443);
          return;
          Log.e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
          break;
          int k = FindMoreFriendsUI.h(FindMoreFriendsUI.this);
          if (k != FindMoreFriendsUI.this.getView().getPaddingTop())
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(FindMoreFriendsUI.this.getView().getPaddingTop()) });
            FindMoreFriendsUI.this.getView().setPadding(0, k, 0, localView.getHeight());
          }
          else
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
    };
    if (j <= 0)
    {
      getView().post(local8);
      AppMethodBeat.o(282110);
      return;
    }
    int k = getTopHeight();
    getView().setPadding(0, k, 0, localView.getHeight());
    Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    getView().postDelayed(local8, 100L);
    AppMethodBeat.o(282110);
  }
  
  private void hGb()
  {
    AppMethodBeat.i(282113);
    Iterator localIterator = Arrays.asList(new androidx.core.f.e[] { new androidx.core.f.e("find_friends_by_near", WeChatBrands.Business.Entries.DiscoveryNearby), new androidx.core.f.e("find_live_friends_by_near", WeChatBrands.Business.Entries.DiscoveryNearbyLiveFriends), new androidx.core.f.e("find_friends_by_shake", WeChatBrands.Business.Entries.DiscoveryShake), new androidx.core.f.e("find_friends_by_qrcode", WeChatBrands.Business.Entries.GlobalScan), new androidx.core.f.e("more_tab_game_recommend", WeChatBrands.Business.Entries.DiscoveryGame), new androidx.core.f.e("jd_market_entrance", WeChatBrands.Business.Entries.DiscoveryShop), new androidx.core.f.e("app_brand_entrance", WeChatBrands.Business.Entries.DiscoveryAppbrand), new androidx.core.f.e("find_friends_by_search", WeChatBrands.Business.Entries.DiscoverySearch), new androidx.core.f.e("find_friends_by_look", WeChatBrands.Business.Entries.DiscoveryLooks), new androidx.core.f.e("find_friends_by_finder", WeChatBrands.Business.Entries.DiscoveryChannels), new androidx.core.f.e("find_friends_by_finder_live", WeChatBrands.Business.Entries.DiscoveryChannels) }).iterator();
    while (localIterator.hasNext())
    {
      androidx.core.f.e locale = (androidx.core.f.e)localIterator.next();
      if ((this.Avm.byG((String)locale.Mx) instanceof IconPreference))
      {
        if (((WeChatBrands.Business.Entries)locale.My).banned()) {
          this.Avm.dz((String)locale.Mx, true);
        }
        ((WeChatBrands.Business.Entries)locale.My).signRequsted();
      }
    }
    AppMethodBeat.o(282113);
  }
  
  private static int hGc()
  {
    AppMethodBeat.i(33088);
    int j = 1;
    int i = j;
    com.tencent.mm.plugin.subapp.jdbiz.c localc;
    if (com.tencent.mm.pluginsdk.j.d.QYQ != null)
    {
      localc = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu();
      com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
      i = j;
      if (com.tencent.mm.plugin.subapp.jdbiz.d.ghq())
      {
        i = j;
        if (localc.isStart())
        {
          i = j;
          if (!localc.eqj())
          {
            if ((!"3".equals(localc.Mdj)) || (Util.isNullOrNil(localc.jumpUrl))) {
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
      if (!Util.isNullOrNil(localc.Mdm))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (localc.Mdl) {
          i = 2;
        }
      }
    }
  }
  
  private static boolean hGd()
  {
    AppMethodBeat.i(282127);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUa, 0);
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VxK, false);
    Log.i("MicroMsg.FindMoreFriendsUI", "show declare needShow %d, hasShow %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if ((i != 0) && (!bool))
    {
      AppMethodBeat.o(282127);
      return true;
    }
    AppMethodBeat.o(282127);
    return false;
  }
  
  private void hGe()
  {
    AppMethodBeat.i(282128);
    com.tencent.mm.plugin.report.service.h.IzE.a(17065, new Object[] { Integer.valueOf(1), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.VUl.ordinal()), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvR, ""), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvQ, ""), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvP, "0") });
    if (this.VUl.equals(a.VUL))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvO, Boolean.FALSE);
      this.VUl = a.VUG;
      localObject = (IconPreference)this.Avm.byG("my_life_around");
      ((IconPreference)localObject).abe(8);
      ((IconPreference)localObject).fC("", -1);
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvN, Boolean.FALSE)).booleanValue();
    ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_nearbylife");
    String str = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).bnF("labs_nearbylife");
    int i = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).bnG("labs_nearbylife");
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    int j = com.tencent.mm.n.h.axc().getInt("LifeAppEntranceBringRedDot", 0);
    Log.d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", new Object[] { Integer.valueOf(j) });
    if ((j != 0) && (bool)) {}
    for (Object localObject = "?hasRedDot=true";; localObject = null)
    {
      ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), str, null, i, 0, (String)localObject, localAppBrandStatObject);
      AppMethodBeat.o(282128);
      return;
    }
  }
  
  private void hGg()
  {
    AppMethodBeat.i(33094);
    if (this.VTO == null)
    {
      this.VTO = View.inflate(getContext(), R.i.lbs_open_dialog_view, null);
      this.GsT = ((CheckBox)this.VTO.findViewById(R.h.lbs_open_dialog_cb));
      this.GsT.setChecked(false);
    }
    if (this.GsV == null)
    {
      this.GsV = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.app_tip), this.VTO, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(273160);
          if (FindMoreFriendsUI.s(FindMoreFriendsUI.this) != null)
          {
            bh.beI();
            paramAnonymousDialogInterface = com.tencent.mm.model.c.aHp();
            if (FindMoreFriendsUI.s(FindMoreFriendsUI.this).isChecked()) {
              break label119;
            }
          }
          label119:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDialogInterface.i(4104, Boolean.valueOf(bool));
            paramAnonymousDialogInterface = (LauncherUI)FindMoreFriendsUI.this.getContext();
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.VXk.getMainTabUI().byt("tab_find_friend");
            }
            paramAnonymousDialogInterface = new Intent();
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.hXI(), paramAnonymousDialogInterface);
            com.tencent.mm.bw.a.aD(FindMoreFriendsUI.this.getContext(), paramAnonymousDialogInterface);
            AppMethodBeat.o(273160);
            return;
          }
        }
      }, null);
      AppMethodBeat.o(33094);
      return;
    }
    this.GsV.show();
    AppMethodBeat.o(33094);
  }
  
  private void hGh()
  {
    AppMethodBeat.i(33095);
    NormalIconNewTipPreference localNormalIconNewTipPreference = (NormalIconNewTipPreference)this.Avm.byG("more_tab_game_recommend");
    if (localNormalIconNewTipPreference == null)
    {
      AppMethodBeat.o(33095);
      return;
    }
    localNormalIconNewTipPreference.a(this.Avm);
    com.tencent.mm.plugin.newtips.a.fiO().h(localNormalIconNewTipPreference);
    com.tencent.e.h.ZvG.d(new FindMoreFriendsUI.23(this), "updateGame");
    AppMethodBeat.o(33095);
  }
  
  private void hGi()
  {
    boolean bool2 = false;
    AppMethodBeat.i(33106);
    boolean bool3;
    if ((this.JhW & 0x8000) == 0)
    {
      bool1 = true;
      bool3 = com.tencent.mm.by.c.blP("sns");
      Log.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if (!bool1)
      {
        if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VwB, 0) != 1) {
          break label149;
        }
        Log.w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 71);
      }
    }
    for (;;)
    {
      if ((bool1) && (bool3)) {
        break label189;
      }
      this.Avm.dz("album_dyna_photo_ui_title", true);
      if (!hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 0L, 1L);
      }
      AppMethodBeat.o(33106);
      return;
      bool1 = false;
      break;
      label149:
      if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VwB, 0) == -1)
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 70);
      }
    }
    label189:
    this.VUc += 1;
    this.Avm.dz("album_dyna_photo_ui_title", false);
    FriendSnsPreference localFriendSnsPreference = (FriendSnsPreference)this.Avm.byG("album_dyna_photo_ui_title");
    localFriendSnsPreference.drawable = aw.bf(getContext(), R.d.colorful_moment);
    bh.beI();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(48, null));
    localFriendSnsPreference.abe(8);
    localFriendSnsPreference.auH(8);
    if (bool1)
    {
      localFriendSnsPreference.abe(0);
      localFriendSnsPreference.fC(getString(R.l.app_new), R.g.new_tips_bg);
    }
    bh.beI();
    this.VTP = ((String)com.tencent.mm.model.c.aHp().b(68377, null));
    if ((!Util.isNullOrNil(this.VTP)) && (LauncherUI.getCurrentTabIndex() == 2))
    {
      bh.beI();
      if (com.tencent.mm.model.c.aHp().getInt(68419, 0) == 0)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.plugin.sns.k.h.u(2, (String)com.tencent.mm.kernel.h.aHG().aHp().b(68418, ""), this.VTQ);
        bh.beI();
        com.tencent.mm.model.c.aHp().i(68419, Integer.valueOf(1));
      }
    }
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvj, null);
    long l;
    int i;
    if (localObject == null)
    {
      l = 0L;
      Log.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", new Object[] { Util.nullAs(this.VTP, "") });
      localFriendSnsPreference.auG(0);
      if (Util.isNullOrNil(this.VTP)) {
        break label662;
      }
      localFriendSnsPreference.auF(0);
      bh.beI();
      if (!Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().b(68384, null), true)) {
        break label656;
      }
      i = 0;
      label497:
      localFriendSnsPreference.auH(i);
      localFriendSnsPreference.byl(this.VTP);
      label512:
      if (com.tencent.mm.plugin.sns.b.p.JPe != null) {
        if (!com.tencent.mm.plugin.sns.b.p.JPe.fMX()) {
          break label769;
        }
      }
    }
    label769:
    for (this.VTQ = 0;; this.VTQ = com.tencent.mm.plugin.sns.b.p.JPe.cHo())
    {
      if (this.VTQ != 0)
      {
        localFriendSnsPreference.abe(0);
        localFriendSnsPreference.fC(this.VTQ, com.tencent.mm.ui.tools.w.bj(getContext(), this.VTQ));
      }
      localFriendSnsPreference.aak(8);
      localFriendSnsPreference.auD(8);
      EventCenter.instance.publish(new zp());
      if (Util.isNullOrNil(this.VTP))
      {
        bool1 = bool2;
        if (this.VTQ == 0) {}
      }
      else
      {
        bool1 = true;
      }
      dx("album_dyna_photo_ui_title", bool1);
      AppMethodBeat.o(33106);
      return;
      l = ((Long)localObject).longValue();
      break;
      label656:
      i = 8;
      break label497;
      label662:
      bh.beI();
      if (((Boolean)com.tencent.mm.model.c.aHp().b(589825, Boolean.FALSE)).booleanValue())
      {
        localFriendSnsPreference.auE(R.k.net_warn_icon);
        localFriendSnsPreference.auF(0);
        localFriendSnsPreference.auH(8);
        break label512;
      }
      if ((l != 0L) && (((com.tencent.mm.plugin.sns.b.o)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sns.b.o.class)).Qf(l)))
      {
        localFriendSnsPreference.auF(0);
        localFriendSnsPreference.auH(0);
        localFriendSnsPreference.Vv(l);
        break label512;
      }
      localFriendSnsPreference.auF(8);
      break label512;
    }
  }
  
  private void hGj()
  {
    boolean bool2 = false;
    AppMethodBeat.i(33107);
    if ((this.JhW & 0x100) == 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = com.tencent.mm.by.c.blP("shake");
      boolean bool4 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      Log.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      if ((bool1) && (bool3) && (!bool4)) {
        break;
      }
      this.Avm.dz("find_friends_by_shake", true);
      if (!hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 2L, 1L);
      }
      AppMethodBeat.o(33107);
      return;
    }
    this.VUc += 1;
    this.Avm.dz("find_friends_by_shake", false);
    IconPreference localIconPreference = (IconPreference)this.Avm.byG("find_friends_by_shake");
    int i = com.tencent.mm.bl.d.bqe().cHo() + o.a.hfN().fHh();
    if (i > 0)
    {
      localIconPreference.abe(0);
      localIconPreference.fC(String.valueOf(i), R.g.unread_count_shape);
      localIconPreference.auF(8);
      o.a.hfN().fHi();
      if (!o.a.hfN().fHj()) {
        break label607;
      }
    }
    label312:
    label570:
    label597:
    label607:
    for (bool1 = com.tencent.mm.aa.c.aFn().dk(262154, 266258);; bool1 = false)
    {
      int j;
      if (bool1)
      {
        bh.beI();
        Object localObject = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgx, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localIconPreference.aak(8);
          localIconPreference.abe(0);
          localIconPreference.fC(String.valueOf(localObject), R.g.unread_count_shape);
          bh.beI();
          localObject = Util.nullAs((String)com.tencent.mm.model.c.aHp().get(ar.a.Vkd, null), "");
          bh.beI();
          bool3 = Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vkf, null), false);
          bh.beI();
          j = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vkb, Integer.valueOf(0))).intValue();
          if ((!Boolean.valueOf(bool3).booleanValue()) || (localObject == null) || (((String)localObject).equals("")) || (i > 0) || (bool1)) {
            break label597;
          }
          if (j != 0) {
            break label570;
          }
          localIconPreference.aak(8);
          localIconPreference.auD(0);
          localObject = ((String)localObject).split(",");
          if (localObject.length > 0) {
            localIconPreference.aU(localObject[0], -1, Color.parseColor("#8c8c8c"));
          }
          localIconPreference.FT(true);
          localIconPreference.auG(8);
        }
      }
      for (;;)
      {
        if ((i > 0) || (bool1)) {
          bool2 = true;
        }
        dx("find_friends_by_shake", bool2);
        AppMethodBeat.o(33107);
        return;
        localIconPreference.abe(8);
        localIconPreference.fC("", -1);
        break;
        if (i > 0)
        {
          localIconPreference.aak(0);
          break label312;
        }
        localIconPreference.aak(0);
        localIconPreference.abe(8);
        localIconPreference.fC("", -1);
        break label312;
        localIconPreference.aak(8);
        break label312;
        if (j == 1)
        {
          localIconPreference.auD(8);
          localIconPreference.abe(0);
          localIconPreference.Wru = true;
          continue;
          localIconPreference.auD(8);
        }
      }
    }
  }
  
  private void hGk()
  {
    AppMethodBeat.i(33108);
    boolean bool2 = Hh(2097152L);
    boolean bool3 = com.tencent.mm.by.c.blP("search");
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "openSearch %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break;
      }
      this.Avm.dz("find_friends_by_search", true);
      if (!hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 4L, 1L);
      }
      AppMethodBeat.o(33108);
      return;
    }
    this.VUc += 1;
    this.Avm.dz("find_friends_by_search", false);
    try
    {
      Object localObject = com.tencent.mm.plugin.websearch.api.ak.biP("discoverSearchEntry");
      String str = ((JSONObject)localObject).optString("wording");
      ((JSONObject)localObject).optString("androidIcon");
      localObject = (NormalIconNewTipPreference)this.Avm.byG("find_friends_by_search");
      if (Util.isNullOrNil(str)) {
        ((NormalIconNewTipPreference)localObject).setTitle(getString(R.l.find_friends_search));
      }
      for (;;)
      {
        ((NormalIconNewTipPreference)localObject).a(this.Avm);
        com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject);
        ((NormalIconNewTipPreference)localObject).a(this.GvL, new NormalIconNewTipPreference.a()
        {
          public final void aSU(String paramAnonymousString)
          {
            AppMethodBeat.i(220140);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this, paramAnonymousString);
            AppMethodBeat.o(220140);
          }
        });
        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject);
        a(aq.gQV().PzC, (IconPreference)localObject);
        if (LauncherUI.getCurrentTabIndex() == 2) {
          aq.gQV().anm(1);
        }
        ai.gQJ();
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
  
  private void hGl()
  {
    AppMethodBeat.i(33109);
    if (this.VUo == null) {
      this.VUo = new com.tencent.mm.ui.findmore.a.b(getContext(), this);
    }
    if (this.VUo.hWV()) {
      this.VUc += 1;
    }
    AppMethodBeat.o(33109);
  }
  
  private void hGm()
  {
    AppMethodBeat.i(33110);
    ux localux = new ux();
    localux.fUl.fHD = this.fHD;
    EventCenter.instance.publish(localux);
    AppMethodBeat.o(33110);
  }
  
  private boolean nU(String paramString1, String paramString2)
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
      paramString1 = a.VUK;
    }
    for (;;)
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", new Object[] { paramString1, this.VUl });
      if (paramString1.compareTo(this.VUl) < 0) {
        break label127;
      }
      this.VUl = paramString1;
      AppMethodBeat.o(33081);
      return true;
      i = 0;
      break;
      label91:
      j = 0;
      break label25;
      label97:
      if (j != 0) {
        paramString1 = a.VUJ;
      } else if (i != 0) {
        paramString1 = a.VUI;
      } else {
        paramString1 = a.VUH;
      }
    }
    label127:
    AppMethodBeat.o(33081);
    return false;
  }
  
  private String nV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(33099);
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(33099);
      return paramString1;
    }
    paramString1 = com.tencent.mm.pluginsdk.model.app.h.t(getContext(), paramString2);
    AppMethodBeat.o(33099);
    return paramString1;
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(33086);
    this.VUc = 0;
    this.VTN = System.currentTimeMillis();
    if (this.Nsh != null) {
      this.Nsh.setVisibility(8);
    }
    if ((!hKT()) || (!isAdded()))
    {
      AppMethodBeat.o(33086);
      return;
    }
    Log.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(this.status), Integer.valueOf(com.tencent.mm.model.z.bdd()), Long.valueOf(this.tZb), Long.valueOf(com.tencent.mm.model.z.bde()), Integer.valueOf(this.JhW), Integer.valueOf(com.tencent.mm.model.z.bdn()) });
    hGi();
    boolean bool2 = bBl();
    Object localObject1 = this.Avm;
    Object localObject2;
    int i;
    label359:
    boolean bool3;
    if (!bool2)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.h)localObject1).dz("find_friends_by_finder", bool1);
      if (bool2) {
        this.VUc += 1;
      }
      if (bool2)
      {
        localObject1 = (FinderIconViewTipPreference)this.Avm.byG("find_friends_by_finder");
        ((NormalIconNewTipPreference)localObject1).GvO = true;
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getRedDotManager().dqB();
        ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).checkInsertLiveNewReddot();
        if (this.xnQ == null)
        {
          this.xnQ = new s() {};
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
          com.tencent.mm.plugin.finder.extension.reddot.h.dqO().a(this, this.xnQ);
        }
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        localObject1 = (com.tencent.mm.plugin.finder.extension.reddot.h.a)com.tencent.mm.plugin.finder.extension.reddot.h.dqO().getValue();
        if (localObject1 != null) {
          this.xnQ.onChanged(localObject1);
        }
      }
      if (this.VUp == null) {
        this.VUp = new com.tencent.mm.ui.findmore.a.a(getContext(), this);
      }
      localObject1 = this.VUp;
      localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      ((com.tencent.mm.ui.findmore.a.a)localObject1).aadj = com.tencent.mm.plugin.finder.nearby.abtest.a.cFx();
      if (((com.tencent.mm.ui.findmore.a.a)localObject1).eeH()) {
        break label1937;
      }
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isEnableFinderLiveEntry.");
      i = 0;
      if (i != 0) {
        this.VUc += 1;
      }
      bool2 = Hh(1048576L);
      bool3 = com.tencent.mm.by.c.blP("scanner");
      if (bool2) {
        break label2398;
      }
      bool1 = true;
      label395:
      Log.i("MicroMsg.FindMoreFriendsUI", "openScan %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break label2403;
      }
      this.Avm.dz("find_friends_by_qrcode", true);
      if (!hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 1L, 1L);
      }
      label462:
      hGj();
      hGk();
      hGl();
      bool2 = Hh(4194304L);
      bool3 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      if (bool2) {
        break label2494;
      }
      bool1 = true;
      label504:
      Log.i("MicroMsg.FindMoreFriendsUI", "openShoppingEntry %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((bool2) || (bool3)) {
        break label2499;
      }
      Fl(false);
      label546:
      localObject1 = com.tencent.mm.plugin.game.api.b.a.evu();
      if (localObject1 == null) {
        break label3135;
      }
      getContext();
    }
    label701:
    label2494:
    label3135:
    for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).evh();; bool1 = false)
    {
      bool3 = Hh(8388608L);
      boolean bool4 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      if (!bool3)
      {
        bool2 = true;
        label601:
        Log.i("MicroMsg.FindMoreFriendsUI", "shouldShowGame %s, openGameEntry %s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
        if ((!bool1) || (bool3) || (bool4)) {
          break label2539;
        }
        if (this.fHD)
        {
          localObject1 = new vx();
          EventCenter.instance.publish((IEvent)localObject1);
        }
        this.Avm.dz("more_tab_game_recommend", false);
        hGh();
        this.VUc += 1;
        localObject1 = new vv();
        ((vv)localObject1).fUR.fUT = true;
        EventCenter.instance.publish((IEvent)localObject1);
        bool2 = ((vv)localObject1).fUS.fUU;
        bool3 = Hh(16777216L);
        bool4 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
        i = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks();
        if (bool3) {
          break label2574;
        }
        bool1 = true;
        Log.i("MicroMsg.FindMoreFriendsUI", "shouldShowMiniProgram %s, openMiniProgramEntry %s, isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Integer.valueOf(i) });
        if ((bool2) && (!bool3) && ((!bool4) || (i != 2))) {
          break label2579;
        }
        this.Avm.dz("app_brand_entrance", true);
        if (!hFY()) {
          com.tencent.mm.plugin.report.service.h.IzE.p(953L, 9L, 1L);
        }
        bool2 = com.tencent.mm.plugin.ipcall.d.eIU();
        bool3 = Hh(33554432L);
        if (bool3) {
          break label2734;
        }
        bool1 = true;
        Log.i("MicroMsg.FindMoreFriendsUI", "showShowWeChatOut %s, openWeChatOutEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (bool3)) {
          break label2770;
        }
        this.VUc += 1;
        this.Avm.dz("ip_call_entrance", false);
        localObject1 = (IconPreference)this.Avm.byG("ip_call_entrance");
        bh.beI();
        if (((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vjs, Integer.valueOf(0))).intValue() >= com.tencent.mm.n.h.axc().getInt("WCOEntranceRedDot", 0)) {
          break label2739;
        }
        ((IconPreference)localObject1).abe(0);
        ((IconPreference)localObject1).fC(getString(R.l.app_new), R.g.new_tips_bg);
        ((IconPreference)localObject1).auG(8);
        bh.beI();
        if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vju, Boolean.FALSE)).booleanValue() != true) {
          break label2749;
        }
        ((IconPreference)localObject1).FT(true);
        ((IconPreference)localObject1).abe(8);
        i = 1;
        bh.beI();
        localObject2 = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjt, "");
        ((IconPreference)localObject1).aU((String)localObject2, -1, -7566196);
        if (!Util.isNullOrNil((String)localObject2)) {
          i = 1;
        }
        if (i == 0) {
          break label2760;
        }
        ((IconPreference)localObject1).auD(0);
        label1126:
        localObject1 = new PreferenceSmallCategory(getContext());
        this.Avm.a((Preference)localObject1, -1);
        label1149:
        hFZ();
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).bnE("labs_nearbylife");
        Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isInExperiment: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label3130;
        }
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).acg("labs_nearbylife");
        Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isOpen: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label3130;
        }
      }
      for (i = 1;; i = 0)
      {
        label1521:
        Object localObject3;
        if (i != 0)
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGS, 0);
          Log.d("MicroMsg.FindMoreFriendsUI", "life around preload, preload: %d.", new Object[] { Integer.valueOf(i) });
          if (1 == i)
          {
            ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(com.tencent.mm.plugin.appbrand.service.z.qPf);
            localObject1 = (NormalIconNewTipPreference)this.Avm.byG("my_life_around");
            ((NormalIconNewTipPreference)localObject1).setTitle(getString(R.l.FF_Entry_Nearby));
            this.VUc += 1;
            this.Avm.dz("my_life_around", false);
            ((NormalIconNewTipPreference)localObject1).a(this.Avm);
            com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject1);
            ((NormalIconNewTipPreference)localObject1).a(this.GvL, new NormalIconNewTipPreference.a()
            {
              public final void aSU(String paramAnonymousString)
              {
                AppMethodBeat.i(292413);
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, paramAnonymousString);
                AppMethodBeat.o(292413);
              }
            });
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
            bool2 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvO, Boolean.TRUE)).booleanValue();
            Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showNewRedDot %s.", new Object[] { Boolean.valueOf(bool2) });
            bool3 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvN, Boolean.FALSE)).booleanValue();
            Log.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showRedDot %s.", new Object[] { Boolean.valueOf(bool3) });
            if ((!bool2) && ((!bool3) || ((this.VUl != a.VUK) && (this.VUl != a.VUJ) && (this.VUl != a.VUI) && (this.VUl != a.VUH)))) {
              break label2810;
            }
            bool1 = true;
            if (!com.tencent.mm.plugin.newtips.a.g.a(bool1, (com.tencent.mm.plugin.newtips.a.a)localObject1))
            {
              if (bool2)
              {
                this.VUl = a.VUL;
                ((NormalIconNewTipPreference)localObject1).abe(0);
                ((NormalIconNewTipPreference)localObject1).fC(getString(R.l.app_new), R.g.new_tips_bg);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, k.GwL, true);
              }
              if (!bool3) {
                break label3076;
              }
              localObject3 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvQ, "");
              localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvR, "");
              nU((String)localObject3, (String)localObject2);
            }
            switch (35.VUF[this.VUl.ordinal()])
            {
            default: 
              com.tencent.mm.plugin.report.service.h.IzE.a(17065, new Object[] { Integer.valueOf(0), Long.valueOf(Util.nowSecond()), Integer.valueOf(this.VUl.ordinal()), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvR, ""), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvQ, ""), com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvP, "0") });
              label1759:
              hGb();
              com.tencent.mm.az.b.bmZ();
              this.Avm.dz("find_friends_by_facebook", true);
              this.Avm.dz("settings_emoji_store", true);
              if (this.VUc == 0)
              {
                localObject1 = (ViewGroup)findViewById(16908298).getParent();
                if (this.Nsh != null) {
                  break label3119;
                }
                this.Nsh = getContext().getLayoutInflater().inflate(R.i.ehf, null);
                this.VUd = ((TextView)this.Nsh.findViewById(R.h.dHW));
                this.VUd.setOnClickListener(new FindMoreFriendsUI.11(this));
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                ((ViewGroup)localObject1).addView(this.Nsh, (ViewGroup.LayoutParams)localObject2);
              }
              break;
            }
          }
        }
        for (;;)
        {
          this.Avm.notifyDataSetChanged();
          if (!hFY()) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VwC, Long.valueOf(this.VTN));
          }
          AppMethodBeat.o(33086);
          return;
          bool1 = false;
          break;
          if (((com.tencent.mm.ui.findmore.a.a)localObject1).XHq.fHD) {
            com.tencent.mm.ui.report.a.hXG();
          }
          ((com.tencent.mm.ui.findmore.a.a)localObject1).iWD();
          localObject2 = ((com.tencent.mm.ui.findmore.a.a)localObject1).XHq.Avm.byG(((com.tencent.mm.ui.findmore.a.a)localObject1).iWF());
          if (localObject2 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
            AppMethodBeat.o(33086);
            throw ((Throwable)localObject1);
          }
          localObject2 = (FinderIconViewTipPreference)localObject2;
          if (localObject2 == null)
          {
            Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for preference.");
            i = 0;
            break label359;
          }
          ((com.tencent.mm.ui.findmore.a.a)localObject1).XHp = ((FinderIconViewTipPreference)localObject2);
          if (((com.tencent.mm.ui.findmore.a.a)localObject1).XHo != null)
          {
            Log.w("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + localObject2 + ' ' + ((FinderIconViewTipPreference)localObject2).hashCode() + " return for observing.");
            if (((com.tencent.mm.ui.findmore.a.a)localObject1).aadk != ((com.tencent.mm.ui.findmore.a.a)localObject1).aadj)
            {
              Log.w("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + localObject2 + ' ' + ((FinderIconViewTipPreference)localObject2).hashCode() + ' ' + "refresh red not, enableFinderLiveEntryAboveLook:" + ((com.tencent.mm.ui.findmore.a.a)localObject1).aadj + " lastIsEnableFinderLiveEntryAboveLook:" + ((com.tencent.mm.ui.findmore.a.a)localObject1).aadk);
              localObject2 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
              localObject2 = com.tencent.mm.plugin.finder.extension.reddot.h.drj();
              localObject3 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
              ((androidx.lifecycle.r)localObject2).L(com.tencent.mm.plugin.finder.extension.reddot.h.drj().getValue());
            }
          }
          for (((com.tencent.mm.ui.findmore.a.a)localObject1).aadk = ((com.tencent.mm.ui.findmore.a.a)localObject1).aadj;; ((com.tencent.mm.ui.findmore.a.a)localObject1).aadk = ((com.tencent.mm.ui.findmore.a.a)localObject1).aadj)
          {
            localObject2 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
            kotlin.g.b.p.j(localObject2, "MMKernel.plugin(IPluginFinder::class.java)");
            localObject2 = ((com.tencent.mm.plugin.findersdk.a.ak)localObject2).getRedDotManager();
            kotlin.g.b.p.j(localObject2, "MMKernel.plugin(IPluginF…class.java).redDotManager");
            ((com.tencent.mm.ui.findmore.a.a)localObject1).GV(((com.tencent.mm.plugin.findersdk.a.z)localObject2).dqK());
            i = 1;
            break;
            Log.i("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + localObject2 + ' ' + ((FinderIconViewTipPreference)localObject2).hashCode());
            ((com.tencent.mm.ui.findmore.a.a)localObject1).XHo = ((s)new a.c((com.tencent.mm.ui.findmore.a.a)localObject1));
            localObject2 = ((com.tencent.mm.ui.findmore.a.a)localObject1).XHo;
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
              com.tencent.mm.plugin.finder.extension.reddot.h.drj().a((androidx.lifecycle.l)((com.tencent.mm.ui.findmore.a.a)localObject1).XHq, (s)localObject2);
            }
            localObject2 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
            localObject2 = (com.tencent.mm.plugin.finder.extension.reddot.h.a)com.tencent.mm.plugin.finder.extension.reddot.h.drj().getValue();
            if (localObject2 != null)
            {
              localObject3 = ((com.tencent.mm.ui.findmore.a.a)localObject1).XHo;
              if (localObject3 != null) {
                ((s)localObject3).onChanged(localObject2);
              }
            }
          }
          label2398:
          bool1 = false;
          break label395;
          label2403:
          this.Avm.dz("find_friends_by_qrcode", false);
          this.VUc += 1;
          if (com.tencent.mm.aa.c.aFn().b(ar.a.Vvz, ar.a.Vvy))
          {
            ((NormalIconPreference)this.Avm.byG("find_friends_by_qrcode")).aak(0);
            dx("find_friends_by_qrcode", true);
            break label462;
          }
          ((NormalIconPreference)this.Avm.byG("find_friends_by_qrcode")).aak(4);
          dx("find_friends_by_qrcode", false);
          break label462;
          bool1 = false;
          break label504;
          label2499:
          this.Avm.dz("jd_market_entrance", true);
          if (hFY()) {
            break label546;
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(953L, 7L, 1L);
          break label546;
          bool2 = false;
          break label601;
          label2539:
          this.Avm.dz("more_tab_game_recommend", true);
          if (hFY()) {
            break label701;
          }
          com.tencent.mm.plugin.report.service.h.IzE.p(953L, 8L, 1L);
          break label701;
          bool1 = false;
          break label784;
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).bFi();
          this.VUc += 1;
          this.Avm.dz("app_brand_entrance", false);
          localObject2 = (IconPreference)this.Avm.byG("app_brand_entrance");
          if (((vv)localObject1).fUS.fUW)
          {
            i = 0;
            label2643:
            ((IconPreference)localObject2).abe(i);
            ((IconPreference)localObject2).fC(getString(R.l.app_new), R.g.new_tips_bg);
            if (!((vv)localObject1).fUS.fUV) {
              break label2723;
            }
            i = 0;
            label2677:
            ((IconPreference)localObject2).aak(i);
            if ((!((vv)localObject1).fUS.fUW) && (!((vv)localObject1).fUS.fUV)) {
              break label2729;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            dx("app_brand_entrance", bool1);
            break;
            i = 8;
            break label2643;
            i = 8;
            break label2677;
          }
          bool1 = false;
          break label897;
          ((IconPreference)localObject1).abe(8);
          break label1027;
          ((IconPreference)localObject1).FT(false);
          i = 0;
          break label1075;
          label2760:
          ((IconPreference)localObject1).auD(8);
          break label1126;
          label2770:
          this.Avm.dz("ip_call_entrance", true);
          break label1149;
          if (2 != i) {
            break label1296;
          }
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(com.tencent.mm.plugin.appbrand.service.z.qPf);
          break label1296;
          label2810:
          bool1 = false;
          break label1521;
          com.tencent.mm.ay.q.bmg();
          Bitmap localBitmap = com.tencent.mm.ay.d.LI((String)localObject2);
          if (localBitmap != null)
          {
            this.VUk = null;
            ((NormalIconNewTipPreference)localObject1).aK(BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() * 0.1F));
          }
          for (;;)
          {
            ((NormalIconNewTipPreference)localObject1).aU((String)localObject3, -1, Color.parseColor("#8c8c8c"));
            a((IconPreference)localObject1, 8, 0, false, 0, 0, 0);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, k.GwO, true);
            break;
            this.VUk = ((String)localObject2);
            com.tencent.mm.ay.q.bmk().a((String)localObject2, this.GvL);
          }
          com.tencent.mm.ay.q.bmg();
          localObject3 = com.tencent.mm.ay.d.LI((String)localObject2);
          if (localObject3 != null)
          {
            this.VUk = null;
            ((NormalIconNewTipPreference)localObject1).aK(BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject3, false, ((Bitmap)localObject3).getWidth() * 0.1F));
          }
          for (;;)
          {
            a((IconPreference)localObject1, 8, 8, false, 0, 0, 0);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, k.GwN, true);
            break;
            this.VUk = ((String)localObject2);
            com.tencent.mm.ay.q.bmk().a((String)localObject2, this.GvL);
          }
          ((NormalIconNewTipPreference)localObject1).aU((String)localObject3, -1, Color.parseColor("#8c8c8c"));
          a((IconPreference)localObject1, 8, 0, true, 8, 8, 8);
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, k.GwM, true);
          break label1664;
          a((IconPreference)localObject1, 0, 8, false, 8, 8, 8);
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1, k.GwK, true);
          break label1664;
          a((IconPreference)localObject1, 8, 8, false, 8, 8, 8);
          if (bool2) {
            break label1664;
          }
          com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject1);
          break label1664;
          this.Avm.dz("my_life_around", true);
          break label1759;
          this.Nsh.setVisibility(0);
        }
      }
    }
  }
  
  public final boolean Hh(long paramLong)
  {
    return (this.tZb & paramLong) != 0L;
  }
  
  public final void a(bkn parambkn, FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(282138);
    Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot icon url: " + parambkn.ufC + " show_type:" + parambkn.CKC);
    Object localObject;
    int i;
    if ((parambkn.CKC == 7) || (parambkn.CKC == 11) || (parambkn.CKC == 4) || (parambkn.CKC == 12) || (parambkn.CKC == 13) || (parambkn.CKC == 14) || (parambkn.CKC == 16))
    {
      Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot enableShowEntranceRedDot %s", new Object[] { Boolean.valueOf(paramBoolean2) });
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Integer)com.tencent.mm.plugin.finder.storage.d.dUL().aSr()).intValue() != -1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        i = ((Integer)com.tencent.mm.plugin.finder.storage.d.dUL().aSr()).intValue();
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (i < com.tencent.mm.plugin.finder.storage.d.dUM().size())
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
          parambkn.CKC = ((Integer)((kotlin.o)com.tencent.mm.plugin.finder.storage.d.dUM().get(i)).Mx).intValue();
          localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
          parambkn.title = ((String)((kotlin.o)com.tencent.mm.plugin.finder.storage.d.dUM().get(i)).My);
          Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot debug set showType %s title %s", new Object[] { Integer.valueOf(parambkn.CKC), parambkn.title });
        }
      }
    }
    if (parambkn.CKC == 16)
    {
      paramFinderIconViewTipPreference.GvO = true;
      localObject = new erx();
      ((erx)localObject).url = parambkn.ufC;
      ((erx)localObject).title = parambkn.title;
      paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, 4, true, false, true);
    }
    for (;;)
    {
      if (LauncherUI.getCurrentTabIndex() == 2)
      {
        parambkn = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.on(false);
        paramBoolean1 = true;
        if (this.VUp != null) {
          paramBoolean1 = this.VUp.eeH();
        }
        parambkn = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.P(false, paramBoolean1);
      }
      dx(paramFinderIconViewTipPreference.mKey, paramBoolean2);
      AppMethodBeat.o(282138);
      return;
      label488:
      boolean bool;
      if ((parambkn.CKC == 7) || (parambkn.CKC == 12) || (parambkn.CKC == 14))
      {
        paramFinderIconViewTipPreference.GvO = false;
        localObject = new erx();
        ((erx)localObject).url = parambkn.ufC;
        ((erx)localObject).title = parambkn.title;
        if (((paramBoolean2) && (parambkn.CKC == 12)) || ((Util.isNullOrNil(parambkn.title)) && (parambkn.CKC == 7)) || (parambkn.CKC == 14))
        {
          paramBoolean1 = true;
          if (parambkn.CKC == 14) {
            break label521;
          }
        }
        label521:
        for (bool = true;; bool = false)
        {
          paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, 5, paramBoolean1, bool, false);
          break;
          paramBoolean1 = false;
          break label488;
        }
      }
      if ((parambkn.CKC == 4) || (parambkn.CKC == 11) || (parambkn.CKC == 13))
      {
        paramFinderIconViewTipPreference.GvO = true;
        localObject = new erx();
        ((erx)localObject).url = parambkn.ufC;
        ((erx)localObject).title = parambkn.title;
        if (((paramBoolean2) && (parambkn.CKC == 11)) || ((Util.isNullOrNil(parambkn.title)) && (parambkn.CKC == 4)) || (parambkn.CKC == 13))
        {
          paramBoolean1 = true;
          label628:
          if (parambkn.CKC == 13) {
            break label661;
          }
        }
        label661:
        for (bool = true;; bool = false)
        {
          paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, 4, paramBoolean1, bool, false);
          break;
          paramBoolean1 = false;
          break label628;
        }
      }
      if (parambkn.CKC == 9)
      {
        paramFinderIconViewTipPreference.GvO = false;
        localObject = new erx();
        ((erx)localObject).url = parambkn.ufC;
        ((erx)localObject).title = parambkn.title;
        paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, 2, Util.isNullOrNil(parambkn.title), true, false);
      }
      else if (parambkn.CKC == 10)
      {
        paramFinderIconViewTipPreference.GvO = true;
        localObject = new erx();
        ((erx)localObject).url = parambkn.ufC;
        ((erx)localObject).title = parambkn.title;
        paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, 1, Util.isNullOrNil(parambkn.title), true, false);
      }
      else if (parambkn.CKC == 3)
      {
        localObject = new erx();
        ((erx)localObject).title = parambkn.title;
        i = 6;
        if (paramBoolean1) {
          i = 7;
        }
        paramFinderIconViewTipPreference.a(paramBoolean2, (erx)localObject, i, true, false, false);
      }
      else if (parambkn.CKC == 1)
      {
        paramFinderIconViewTipPreference.tY(paramBoolean2);
      }
      else if ((parambkn.CKC == 100) || (parambkn.CKC == 6))
      {
        paramFinderIconViewTipPreference.tZ(true);
      }
      else if ((parambkn.CKC == 2) && (parambkn.count > 0))
      {
        localObject = new erx();
        ((erx)localObject).num = parambkn.count;
        paramFinderIconViewTipPreference.d(paramBoolean2, (erx)localObject);
      }
      else
      {
        paramFinderIconViewTipPreference.tY(false);
      }
    }
  }
  
  public final void bev()
  {
    AppMethodBeat.i(33101);
    if ((com.tencent.mm.model.z.bdn() & 0x8000) != 0)
    {
      AppMethodBeat.o(33101);
      return;
    }
    this.VTQ += 1;
    hGi();
    this.Avm.notifyDataSetChanged();
    AppMethodBeat.o(33101);
  }
  
  public final void bew()
  {
    AppMethodBeat.i(33102);
    if ((com.tencent.mm.model.z.bdn() & 0x8000) != 0)
    {
      AppMethodBeat.o(33102);
      return;
    }
    hGi();
    this.Avm.notifyDataSetChanged();
    AppMethodBeat.o(33102);
  }
  
  public final void bex() {}
  
  public final void bey()
  {
    AppMethodBeat.i(33122);
    Log.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
    if ((com.tencent.mm.model.z.bdn() & 0x8000) != 0)
    {
      AppMethodBeat.o(33122);
      return;
    }
    if (com.tencent.mm.plugin.sns.b.p.JPe != null) {
      this.VTQ = com.tencent.mm.plugin.sns.b.p.JPe.cHo();
    }
    hGi();
    this.Avm.notifyDataSetChanged();
    AppMethodBeat.o(33122);
  }
  
  public final void bez()
  {
    AppMethodBeat.i(33103);
    if (this.Avm == null)
    {
      AppMethodBeat.o(33103);
      return;
    }
    this.status = com.tencent.mm.model.z.bdd();
    updateStatus();
    AppMethodBeat.o(33103);
  }
  
  public final int getResourceId()
  {
    return R.o.eXD;
  }
  
  public final void gkE()
  {
    AppMethodBeat.i(33121);
    Log.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
    this.fHD = false;
    this.VUq = false;
    this.VUr = false;
    hGm();
    AppMethodBeat.o(33121);
  }
  
  public final void gkF()
  {
    AppMethodBeat.i(33120);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab switch in isTabSwitchInReport:%b isTabResumeReport:%b", new Object[] { Boolean.valueOf(this.VUq), Boolean.valueOf(this.VUr) });
    this.fHD = true;
    hGm();
    com.tencent.mm.blink.b.aqa().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278127);
        FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bdd());
        FindMoreFriendsUI.b(FindMoreFriendsUI.this, com.tencent.mm.model.z.bdn());
        FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bde());
        long l = System.currentTimeMillis();
        FindMoreFriendsUI.w(FindMoreFriendsUI.this);
        Log.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(278127);
      }
    });
    com.tencent.mm.plugin.websearch.api.ak.bB(20, false);
    i.a locala;
    if ((!this.VUq) && (!this.VUr))
    {
      if (bBl())
      {
        locala = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.on(true);
      }
      if (this.VUp == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool = this.VUp.eeH();; bool = true)
    {
      locala = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      i.a.P(true, bool);
      this.VUq = true;
      AppMethodBeat.o(33120);
      return;
    }
  }
  
  public final boolean hFY()
  {
    AppMethodBeat.i(33079);
    if (Util.isSameDay(com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.VwC, 0L), this.VTN))
    {
      AppMethodBeat.o(33079);
      return true;
    }
    AppMethodBeat.o(33079);
    return false;
  }
  
  protected final void hFb()
  {
    AppMethodBeat.i(33104);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab create");
    this.Avm = ((com.tencent.mm.ui.base.preference.h)getPreferenceScreen());
    this.status = com.tencent.mm.model.z.bdd();
    this.JhW = com.tencent.mm.model.z.bdn();
    this.tZb = com.tencent.mm.model.z.bde();
    this.oEa = new com.tencent.mm.ui.widget.b.a(getContext());
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    this.Avm.dz("find_friends_by_shake", true);
    this.Avm.dz("ip_call_entrance", true);
    AppMethodBeat.o(33104);
  }
  
  protected final void hFc()
  {
    AppMethodBeat.i(33105);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume isTabSwitchInReport:%b isTabResumeReport:%b", new Object[] { Boolean.valueOf(this.VUq), Boolean.valueOf(this.VUr) });
    if (((this.Avm instanceof com.tencent.mm.ui.base.preference.h)) && (this.Avm.Wsm == 0L)) {
      this.Avm.Wsm = System.currentTimeMillis();
    }
    this.fHD = true;
    hGm();
    com.tencent.mm.pluginsdk.d.a.a(mf.class.getName(), this.RpX);
    com.tencent.mm.pluginsdk.d.a.a(jo.class.getName(), this.Dbj);
    com.tencent.mm.pluginsdk.d.a.a(vr.class.getName(), this.VUi);
    com.tencent.mm.pluginsdk.d.a.a(jn.class.getName(), this.VUh);
    EventCenter.instance.addListener(this.VUf);
    EventCenter.instance.addListener(this.VUe);
    EventCenter.instance.addListener(this.VUg);
    EventCenter.instance.addListener(this.JYs);
    EventCenter.instance.addListener(this.VUj);
    EventCenter.instance.add(this.BOg);
    EventCenter.instance.addListener(this.VUn);
    com.tencent.mm.bl.d.bqe().add(this);
    bh.beI();
    com.tencent.mm.model.c.bbR().add(this);
    bh.beI();
    com.tencent.mm.model.c.a(this);
    bh.beI();
    com.tencent.mm.model.c.aHp().add(this);
    if (com.tencent.mm.plugin.sns.b.p.JPg != null) {
      com.tencent.mm.plugin.sns.b.p.JPg.a(this);
    }
    Object localObject = findViewById(R.h.loading_tips_area);
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287546);
          this.VUC.setVisibility(8);
          this.VUC.startAnimation(AnimationUtils.loadAnimation(FindMoreFriendsUI.this.getContext(), R.a.fast_faded_out));
          AppMethodBeat.o(287546);
        }
      });
    }
    if (isAdded()) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(243561);
          Log.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(FindMoreFriendsUI.t(FindMoreFriendsUI.this)), Integer.valueOf(com.tencent.mm.model.z.bdd()), Long.valueOf(FindMoreFriendsUI.u(FindMoreFriendsUI.this)), Long.valueOf(com.tencent.mm.model.z.bde()), Integer.valueOf(FindMoreFriendsUI.v(FindMoreFriendsUI.this)), Integer.valueOf(com.tencent.mm.model.z.bdn()) });
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bde());
          FindMoreFriendsUI.a(FindMoreFriendsUI.this, com.tencent.mm.model.z.bdd());
          FindMoreFriendsUI.b(FindMoreFriendsUI.this, com.tencent.mm.model.z.bdn());
          FindMoreFriendsUI.w(FindMoreFriendsUI.this);
          AppMethodBeat.o(243561);
        }
      });
    }
    hGa();
    if ((!this.VUq) && (!this.VUr))
    {
      if (bBl())
      {
        localObject = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.on(true);
      }
      if (this.VUp == null) {
        break label408;
      }
    }
    label408:
    for (boolean bool = this.VUp.eeH();; bool = true)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      i.a.P(true, bool);
      this.VUr = true;
      com.tencent.mm.plugin.scanner.box.h.aO(2, 0L);
      Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
      AppMethodBeat.o(33105);
      return;
    }
  }
  
  protected final void hFd()
  {
    AppMethodBeat.i(33111);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("lifeappreddot", this.VUm);
    AppMethodBeat.o(33111);
  }
  
  protected final void hFe()
  {
    AppMethodBeat.i(33112);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
    this.fHD = false;
    this.VUq = false;
    this.VUr = false;
    hGm();
    aIG();
    AppMethodBeat.o(33112);
  }
  
  protected final void hFf()
  {
    AppMethodBeat.i(33113);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    AppMethodBeat.o(33113);
  }
  
  protected final void hFg()
  {
    AppMethodBeat.i(33114);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    aIG();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("lifeappreddot", this.VUm);
    AppMethodBeat.o(33114);
  }
  
  public final void hFi()
  {
    AppMethodBeat.i(33115);
    Log.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    AppMethodBeat.o(33115);
  }
  
  public final void hFj()
  {
    AppMethodBeat.i(33116);
    Log.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    AppMethodBeat.o(33116);
  }
  
  public final void hFl()
  {
    AppMethodBeat.i(33117);
    Log.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    AppMethodBeat.o(33117);
  }
  
  public final void hGf()
  {
    AppMethodBeat.i(33093);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "4");
    Object localObject = ca.bfo();
    if (localObject == null)
    {
      com.tencent.mm.by.c.ad(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(33093);
      return;
    }
    String str = Util.nullAsNil(((ca)localObject).getProvince());
    int i = Util.nullAs(Integer.valueOf(((ca)localObject).sex), 0);
    if ((Util.isNullOrNil(str)) || (i == 0))
    {
      com.tencent.mm.by.c.ad(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(33093);
      return;
    }
    bh.beI();
    localObject = (Boolean)com.tencent.mm.model.c.aHp().b(4104, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).VXk.getMainTabUI().byt("tab_find_friend");
      }
      localObject = new Intent();
      str = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.hXI(), (Intent)localObject);
      i.a locala = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      i.a.aBu(str);
      com.tencent.mm.bw.a.aD(getContext(), (Intent)localObject);
      AppMethodBeat.o(33093);
      return;
    }
    hGg();
    AppMethodBeat.o(33093);
  }
  
  public final boolean hGn()
  {
    return this.fHD;
  }
  
  public final com.tencent.mm.ui.base.preference.h hGo()
  {
    return this.Avm;
  }
  
  public final int hGp()
  {
    return this.JhW;
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
    AppMethodBeat.i(282132);
    super.onConfigurationChanged(paramConfiguration);
    hGa();
    AppMethodBeat.o(282132);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(282129);
    super.onDestroy();
    com.tencent.mm.plugin.finder.extension.reddot.h localh = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.dqO().b(this.xnQ);
    AppMethodBeat.o(282129);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    int i = 1;
    AppMethodBeat.i(33119);
    Log.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
    if (LauncherUI.getCurrentTabIndex() == 2)
    {
      paramInt = 0;
      if (this.status != com.tencent.mm.model.z.bdd())
      {
        this.status = com.tencent.mm.model.z.bdd();
        paramInt = 1;
      }
      if (this.tZb != com.tencent.mm.model.z.bde())
      {
        this.tZb = com.tencent.mm.model.z.bde();
        paramInt = 1;
      }
      if (this.JhW == com.tencent.mm.model.z.bdn()) {
        break label139;
      }
      this.JhW = com.tencent.mm.model.z.bdn();
      paramInt = i;
    }
    label139:
    for (;;)
    {
      if (paramInt != 0) {
        updateStatus();
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 68377)) {
        hGi();
      }
      if ((paramMStorageEx instanceof ba)) {
        this.Avm.notifyDataSetChanged();
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
      if (this.status != com.tencent.mm.model.z.bdd())
      {
        this.status = com.tencent.mm.model.z.bdd();
        i = 1;
      }
      if (this.tZb != com.tencent.mm.model.z.bde())
      {
        this.tZb = com.tencent.mm.model.z.bde();
        i = 1;
      }
      if (this.JhW == com.tencent.mm.model.z.bdn()) {
        break label101;
      }
      this.JhW = com.tencent.mm.model.z.bdn();
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
  
  public final boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(33090);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    boolean bool1;
    long l;
    if ("album_dyna_photo_ui_title".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.g.ada(10);
      bh.beI();
      this.VTP = ((String)com.tencent.mm.model.c.aHp().b(68377, null));
      paramf = new Intent();
      paramPreference = new com.tencent.mm.modelsns.l(701, 1);
      if (!Util.isNullOrNil(this.VTP))
      {
        bool1 = true;
        paramPreference.gx(bool1);
        paramPreference.Xf(this.VTQ);
        paramf.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramf.putExtra("is_from_find_more", true);
        if ((Util.isNullOrNil(this.VTP)) && (this.VTQ <= 0)) {
          break label574;
        }
      }
      label574:
      for (bool1 = true;; bool1 = false)
      {
        paramf.putExtra("enter_by_red", bool1);
        bh.beI();
        paramf.putExtra("is_sns_notify_open", Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().b(68384, null), true));
        paramf.putExtra("sns_unread_count", com.tencent.mm.plugin.sns.b.p.JPe.cHo());
        if (!Util.isNullOrNil(this.VTP))
        {
          bh.beI();
          paramf.putExtra("new_feed_id", Util.nullAs((String)com.tencent.mm.model.c.aHp().b(68418, null), ""));
          bh.beI();
          com.tencent.mm.plugin.sns.k.h.u(3, (String)com.tencent.mm.model.c.aHp().b(68418, ""), this.VTQ);
        }
        paramPreference.b(paramf, "enter_log");
        paramPreference = new kt();
        EventCenter.instance.publish(paramPreference);
        boolean bool2 = true;
        bool1 = true;
        if (!paramPreference.fIo.isResume)
        {
          if (!Util.isNullOrNil(this.VTP)) {
            bool1 = false;
          }
          bool2 = bool1;
          if (com.tencent.mm.plugin.sns.b.p.JPe != null)
          {
            this.VTQ = com.tencent.mm.plugin.sns.b.p.JPe.cHo();
            bool2 = bool1;
            if (this.VTQ > 0) {
              bool2 = false;
            }
          }
          bh.beI();
          com.tencent.mm.model.c.aHp().i(68377, "");
        }
        bh.beI();
        com.tencent.mm.model.c.aHp().i(589825, Boolean.FALSE);
        paramf.putExtra("sns_resume_state", bool2);
        com.tencent.mm.by.c.b(getContext(), "sns", ".ui.SnsTimeLineUI", paramf);
        paramf = com.tencent.mm.model.z.bcZ();
        l = cm.bfC() / 1000L;
        bh.beI();
        ab.b(paramf, 9, "MomentsTimelineStatus", String.format("%s,%s", new Object[] { Long.valueOf(l), com.tencent.mm.model.c.aHp().b(68418, null) }));
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "1");
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284579);
            com.tencent.mm.xwebutil.c.ikh();
            AppMethodBeat.o(284579);
          }
        }, 500L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
        bool1 = false;
        break;
      }
    }
    if (("find_friends_by_near".equals(paramPreference.mKey)) || ("find_live_friends_by_near".equals(paramPreference.mKey)) || ("find_friends_by_near_v3".equals(paramPreference.mKey)))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkv = 1001;
      if (com.tencent.mm.bw.a.hfs())
      {
        paramf = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
        if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
        {
          com.tencent.mm.ui.report.a.hXF();
          if (!com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null))) {
            break label815;
          }
          if (com.tencent.mm.pluginsdk.permission.b.o(thisActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            break label895;
          }
          if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VvE, Boolean.FALSE)).booleanValue()) {
            break label800;
          }
          com.tencent.mm.plugin.account.sdk.b.a.b(thisActivity(), getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
        com.tencent.mm.ui.report.a.hXD();
        break;
        if (WeChatBrands.Business.Entries.DiscoveryNearby.checkAvailable(getContext())) {
          break;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
        label800:
        com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_FINE_LOCATION", 66);
      }
      label815:
      bool1 = com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 66, null, null);
      Log.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      label895:
      hGf();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33090);
      return true;
    }
    if ("find_friends_by_shake".equals(paramPreference.mKey))
    {
      if (!WeChatBrands.Business.Entries.DiscoveryShake.checkAvailable(getContext()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if ((!this.VTW) && (com.tencent.mm.model.z.bdS().booleanValue()))
      {
        paramf = (IconPreference)paramf.byG("find_friends_by_shake");
        if (paramf != null)
        {
          paramf.aak(8);
          bh.beI();
          com.tencent.mm.model.c.aHp().i(340231, Boolean.TRUE);
          bh.beI();
          com.tencent.mm.model.c.aHp().hxT();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(232L, 4L, 1L, false);
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "3");
      bh.beI();
      paramf = Util.nullAs((String)com.tencent.mm.model.c.aHp().get(ar.a.Vkd, null), "");
      bh.beI();
      if ((Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vkf, null), false)) && (paramf != null) && (!paramf.equals(""))) {}
      for (paramf = Boolean.TRUE;; paramf = Boolean.FALSE)
      {
        if (paramf.booleanValue()) {
          com.tencent.mm.plugin.report.service.h.IzE.a(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
        }
        EventCenter.instance.publish(new sv());
        com.tencent.mm.by.c.ad(getContext(), "shake", ".ui.ShakeReportUI");
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
      com.tencent.mm.aa.c.aFn().c(ar.a.Vvz, ar.a.Vvy);
      if (!com.tencent.mm.q.a.p(getContext(), true))
      {
        getContext();
        if ((!com.tencent.mm.bj.e.bpU()) && (!com.tencent.mm.q.a.t(getContext(), true))) {}
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "2");
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
      paramf.putExtra("key_scan_entry_scene", 2);
      paramf.putExtra("key_config_black_interval", true);
      paramf.putExtra("key_enable_multi_code", true);
      paramf.putExtra("key_scan_goods_enable_dynamic_wording", true);
      com.tencent.mm.plugin.report.service.h.IzE.a(11265, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.by.c.b(getContext(), "scanner", ".ui.BaseScanUI", paramf);
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
      com.tencent.mm.plugin.newtips.a.fiO().aap(12);
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10958, "6");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 2L, 1L, false);
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(getContext(), null);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      paramPreference = new Intent();
      paramPreference.putExtra("from_find_more_friend", true);
      paramPreference.putExtra("game_report_from_scene", 901);
      if (this.VTY)
      {
        localObject1 = new rd();
        EventCenter.instance.publish((IEvent)localObject1);
        paramf = (IconPreference)paramf.byG("more_tab_game_recommend");
        if ((((rd)localObject1).fQd.icon != null) && (paramf != null)) {
          com.tencent.mm.ay.q.bml().a(((rd)localObject1).fQd.icon, paramf.hKJ());
        }
      }
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smO);
      Log.i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
      paramPreference.putExtra("start_time", System.currentTimeMillis());
    }
    try
    {
      paramPreference.putExtra("from_source_activity", getContext().getComponentName().getClassName());
      label1766:
      paramPreference.putExtra("has_game_life_chat_msg", this.VTZ);
      paramPreference.putExtra("game_life_msg_count", this.VUa);
      com.tencent.mm.by.c.b(getContext(), "game", ".ui.GameCenterUI", paramPreference);
      if (((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).eLA()) {
        sendBroadcast(new Intent(getContext(), LiteAppTaskPreloadReceiver.class));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33090);
      return true;
      if ("find_friends_by_micromsg".equals(paramPreference.mKey))
      {
        com.tencent.mm.by.c.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if ("find_friends_by_mobile".equals(paramPreference.mKey))
      {
        if (com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWk)
        {
          paramf = new Intent(getContext(), BindMContactIntroUI.class);
          paramf.putExtra("key_upload_scene", 6);
          MMWizardActivity.aH(getContext(), paramf);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        paramf = new Intent(getContext(), MobileFriendUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if ("find_friends_by_facebook".equals(paramPreference.mKey))
      {
        paramf = new Intent(getContext(), FacebookFriendUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if ("settings_mm_card_package".equals(paramPreference.mKey))
      {
        Log.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
        paramf = new lc();
        paramf.fIO.context = getContext();
        EventCenter.instance.publish(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      int i;
      if (paramPreference.mKey.equals("jd_market_entrance"))
      {
        if (!WeChatBrands.Business.Entries.DiscoveryShop.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.plugin.newtips.a.fiO().aap(11);
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(9);
        if (com.tencent.mm.pluginsdk.j.d.QYQ != null)
        {
          localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghB();
          paramf = com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghC();
          Log.i("MicroMsg.FindMoreFriendsUI", "jumpUrl %s, jumpWeapp %s", new Object[] { localObject1, paramf });
          i = hGc();
          com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
          com.tencent.mm.plugin.subapp.jdbiz.d.ght();
          com.tencent.mm.plugin.subapp.jdbiz.d.ghp();
          com.tencent.mm.plugin.subapp.jdbiz.d.ghs();
          ((IconPreference)paramPreference).fC("", -1);
          if (paramf.isValid())
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd weapp %s", new Object[] { paramf.username });
            com.tencent.mm.plugin.report.service.h.IzE.a(11179, new Object[] { paramf.username, com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu().oym, Integer.valueOf(i) });
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFd, 1) == 1)
            {
              i = 1;
              if (i == 0) {
                break label2693;
              }
              paramPreference = new com.tencent.mm.plugin.appbrand.api.g();
              paramPreference.username = paramf.username;
              paramPreference.version = paramf.version;
              paramPreference.nBq = paramf.path;
              paramPreference.scene = 1112;
              if (hGd())
              {
                paramf = new WeAppOpenDeclarePromptBundle((byte)0);
                paramf.hDp = 1;
                paramf.nBL = getString(R.l.disclaimer_title);
                paramf.nBM = getString(R.l.eKs);
                paramf.nBN = getString(R.l.app_i_know);
                paramf.bxO = false;
                paramPreference.nBC = paramf;
              }
              ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), paramPreference);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
              AppMethodBeat.o(33090);
              return true;
              i = 0;
              break;
              label2693:
              Log.i("MicroMsg.FindMoreFriendsUI", "onClickOfJDEntrance clicfg_appbrand_dialog_optimize_switch close");
              paramPreference = new AppBrandStatObject();
              paramPreference.scene = 1112;
              if (hGd()) {
                com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.eKs), getString(R.l.disclaimer_title), false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(270645);
                    ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(FindMoreFriendsUI.this.getContext(), paramf.username, "", 0, paramf.version, paramf.path, paramPreference);
                    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VxK, Boolean.TRUE);
                    AppMethodBeat.o(270645);
                  }
                });
              } else {
                ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), paramf.username, "", 0, paramf.version, paramf.path, paramPreference);
              }
            }
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd webview %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.report.service.h.IzE.a(11179, new Object[] { localObject1, com.tencent.mm.plugin.subapp.jdbiz.d.ghp().ghu().oym, Integer.valueOf(i) });
            paramf = new Intent();
            paramf.putExtra("rawUrl", (String)localObject1);
            paramf.putExtra("useJs", true);
            paramf.putExtra("vertical_scroll", true);
            paramf.putExtra("minimize_secene", 1);
            paramf.putExtra("KPublisherId", "jd_store");
            paramf = new FindMoreFriendsUI.19(this, paramf);
            if (!hGd()) {
              break label2966;
            }
            com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.eKs), getString(R.l.disclaimer_title), false, new FindMoreFriendsUI.20(this, paramf));
          }
        }
        for (;;)
        {
          break;
          label2966:
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
        paramf = (IconPreference)paramf.byG("ip_call_entrance");
        paramf.aak(8);
        paramf.auD(8);
        paramf.FT(false);
        paramf.auG(8);
        i = 0;
        bh.beI();
        paramf = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjt, "");
        bh.beI();
        if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vju, Boolean.FALSE)).booleanValue() == true)
        {
          com.tencent.mm.plugin.ipcall.model.f.i.ar(1, -1, -1);
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.Vju, Boolean.FALSE);
          i = 1;
        }
        bh.beI();
        if (((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vjs, Integer.valueOf(0))).intValue() < com.tencent.mm.n.h.axc().getInt("WCOEntranceRedDot", 0))
        {
          i = 1;
          com.tencent.mm.plugin.report.service.h.IzE.a(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.Vjs, Integer.valueOf(com.tencent.mm.n.h.axc().getInt("WCOEntranceRedDot", 0)));
        }
        if (!Util.isNullOrNil(paramf))
        {
          bh.beI();
          com.tencent.mm.model.c.aHp().set(ar.a.Vjt, "");
        }
        if (i != 0) {
          EventCenter.instance.publish(new zp());
        }
        if ((com.tencent.mm.q.a.aAj()) || (com.tencent.mm.q.a.aAm())) {
          com.tencent.mm.ui.base.h.a(getContext(), R.l.multitalk_in_tip, 0, null, null);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          com.tencent.mm.plugin.report.service.h.IzE.a(12061, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.by.c.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
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
        ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.t.class)).O(getContext(), 1);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      Object localObject2;
      if ("find_friends_by_search".equals(paramPreference.mKey))
      {
        if (!WeChatBrands.Business.Entries.DiscoverySearch.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if (!ai.ang(0)) {
          Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.fiO().aap(9);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          paramf = com.tencent.mm.plugin.websearch.api.ak.biP("discoverSearchEntry").optString("wording");
          if (Util.isNullOrNil(paramf))
          {
            Log.e("MicroMsg.FindMoreFriendsUI", "empty title");
          }
          else
          {
            aq.gQV().anm(2);
            paramPreference = aq.gQV();
            paramPreference.PzC = new aq.a();
            paramPreference.arg();
            ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
            ar.u("", 0, 0, 20);
            paramPreference = ai.ane(20);
            localObject1 = com.tencent.mm.plugin.webview.modeltools.f.gWq().gTq();
            localObject2 = new HashMap();
            ((Map)localObject2).put("sessionId", paramPreference);
            ((Map)localObject2).put("inputMarginTop", "32");
            ((Map)localObject2).put("inputMarginLeftRight", "24");
            ((Map)localObject2).put("inputHeight", "48");
            if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
              ((Map)localObject2).put("educationTab", Uri.encode((String)localObject1));
            }
            ((Map)localObject2).put("clickType", "0");
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).b(getContext(), 20, "", paramPreference, true, (Map)localObject2, paramf);
            ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smD);
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
        if (!ai.ang(1)) {
          Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.fiO().aap(6);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          paramf = com.tencent.mm.plugin.websearch.api.ak.biP("discoverRecommendEntry").optString("wording");
          if (!Util.isNullOrNil(paramf)) {
            break;
          }
          Log.e("MicroMsg.FindMoreFriendsUI", "empty query");
        }
        Log.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
        com.tencent.mm.plugin.topstory.ui.d.aK(getContext(), 21);
        ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
        paramPreference = new pj();
        paramPreference.fOb.scene = 0;
        EventCenter.instance.publish(paramPreference);
        ar.cO(21, paramf);
        ar.lr(21, 0);
        if (ai.anh(1) > ai.gQF()) {
          ar.lr(21, 15);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpH();
          break;
          ar.lr(21, 14);
        }
      }
      if ("my_life_around".equals(paramPreference.mKey))
      {
        if ((WeChatEnvironment.isCoolassistEnv()) || ((BuildInfo.IS_FLAVOR_RED) && (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()))) {
          MultiProcessMMKV.getSingleDefault().getInt("life_mode", 1);
        }
        hGe();
        com.tencent.mm.plugin.newtips.a.fiO().aap(10);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
        AppMethodBeat.o(33090);
        return true;
      }
      if (("find_friends_by_finder".equals(paramPreference.mKey)) && (com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class) != null))
      {
        if (!WeChatBrands.Business.Entries.DiscoveryChannels.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VAC, Boolean.FALSE);
        paramf = com.tencent.mm.plugin.findersdk.c.a.Bwg;
        if (com.tencent.mm.plugin.findersdk.c.a.aGS("entrance"))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        if (!((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).showFinderEntry())
        {
          Log.i("MicroMsg.FindMoreFriendsUI", "second check finderEntry");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        bool1 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vzr, Boolean.FALSE)).booleanValue();
        Log.d("MicroMsg.FindMoreFriendsUI", "needShowOverSeaDialog".concat(String.valueOf(bool1)));
        if (bool1)
        {
          paramf = getString(R.l.finder_oversea_title);
          paramPreference = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vzt, "");
          FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog(getContext(), paramf, paramPreference, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(33052);
              ((u)com.tencent.mm.kernel.h.ae(u.class)).p(Boolean.FALSE);
              FindMoreFriendsUI.r(FindMoreFriendsUI.this);
              AppMethodBeat.o(33052);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        paramf = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager();
        l = System.currentTimeMillis();
        paramPreference = paramf.aBf("FinderEntrance");
        if (paramPreference != null)
        {
          paramf = paramPreference.aBy("FinderEntrance");
          if (paramf == null) {
            break label4623;
          }
          i = paramPreference.xuM.SSw;
          Log.i("Finder.RedDotManager", "[getAliveTabType] cost=" + (System.currentTimeMillis() - l) + "ms enterAction :" + i);
          switch (i)
          {
          default: 
            label4568:
            Fm(false);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          paramf = null;
          break;
          label4623:
          i = 0;
          break label4568;
          Fm(true);
        }
      }
      if (("find_friends_by_finder_live".equals(paramPreference.mKey)) || (("find_friends_by_finder_live_above_look".equals(paramPreference.mKey)) && (com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class) != null)))
      {
        if (!WeChatBrands.Business.Entries.DiscoveryChannelsLive.checkAvailable(getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
        }
        com.tencent.mm.ui.report.a.hXH();
        paramPreference = new Intent();
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.hXJ(), paramPreference);
        paramf = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        kotlin.g.b.p.k(localObject1, "contextId");
        paramf = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
        kotlin.g.b.p.j(paramf, "MMKernel.plugin(IPluginFinder::class.java)");
        paramf = ((com.tencent.mm.plugin.findersdk.a.ak)paramf).getRedDotManager();
        kotlin.g.b.p.j(paramf, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        com.tencent.mm.plugin.finder.extension.reddot.l locall;
        if (paramf.dqJ())
        {
          paramf = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          kotlin.g.b.p.j(paramf, "MMKernel.plugin(PluginFinder::class.java)");
          localObject2 = ((PluginFinder)paramf).getRedDotManager().aBe("FinderLiveEntrance");
          paramf = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          kotlin.g.b.p.j(paramf, "MMKernel.plugin(PluginFinder::class.java)");
          locall = ((PluginFinder)paramf).getRedDotManager().aBf("FinderLiveEntrance");
          paramf = aj.AGc;
          if (locall == null) {
            break label5035;
          }
          paramf = locall.field_ctrInfo;
          if ((localObject2 != null) && (paramf != null)) {
            if ((paramf.type != 16) && (((bkn)localObject2).CKC != 6)) {
              break label5040;
            }
          }
        }
        label5035:
        label5040:
        for (i = 2;; i = 3)
        {
          paramf = "8001-" + cm.bfE();
          String str = String.valueOf(((com.tencent.c.a.b.a.d)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.d.class)).getTargetLiveTabId()) + "-" + cm.bfE();
          com.tencent.mm.plugin.finder.report.l locall1 = com.tencent.mm.plugin.finder.report.l.zWx;
          if (locall == null) {
            kotlin.g.b.p.iCn();
          }
          locall1.a("1", locall, (bkn)localObject2, i, (String)localObject1, 1, paramf, str);
          ((com.tencent.c.a.b.a.d)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.d.class)).enterFinderLiveSquare(getContext(), paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
          AppMethodBeat.o(33090);
          return true;
          paramf = null;
          break;
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
      AppMethodBeat.o(33090);
      return false;
    }
    catch (Exception paramf)
    {
      break label1766;
    }
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(33089);
    if (((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.t.class)).dF(getContext()))
    {
      AppMethodBeat.o(33089);
      return true;
    }
    if (((WeChatEnvironment.isCoolassistEnv()) || (BuildInfo.IS_FLAVOR_RED)) && (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) && ("my_life_around".equals(paramPreference.mKey)))
    {
      paramPreference = MultiProcessMMKV.getMultiDefault();
      int i = paramPreference.getInt("life_mode", 1);
      paramf = new AlertDialog.Builder(getContext()).setTitle("选择附近的餐厅的渲染模式");
      paramPreference = new FindMoreFriendsUI.15(this, paramPreference);
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
      VUG = new a("TYPE_NONE", 0);
      VUH = new a("TYPE_NORMAL", 1);
      VUI = new a("TYPE_TEXT", 2);
      VUJ = new a("TYPE_IMG", 3);
      VUK = new a("TYPE_IMG_TEXT", 4);
      VUL = new a("TYPE_NEW_HINT", 5);
      VUM = new a[] { VUG, VUH, VUI, VUJ, VUK, VUL };
      AppMethodBeat.o(33077);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */