package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.wf;
import com.tencent.mm.f.a.wo;
import com.tencent.mm.f.a.ws;
import com.tencent.mm.f.a.wt;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.f.p;
import com.tencent.mm.plugin.sns.ad.f.p.a;
import com.tencent.mm.plugin.sns.ad.f.p.b;
import com.tencent.mm.plugin.sns.ad.f.p.c;
import com.tencent.mm.plugin.sns.ad.f.p.d;
import com.tencent.mm.plugin.sns.ad.f.p.e;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, c.b
{
  private ADInfo JIX;
  private int JsJ;
  private int JtF;
  private int JtG;
  public int JtN;
  private TextView Jto;
  private boolean Jtp;
  ViewGroup Jty;
  private SnsInfo Jzk;
  private com.tencent.mm.plugin.sns.ad.f.m KNB;
  private float KOu;
  private int KOv;
  private int KOw;
  private boolean KVh;
  private boolean KVq;
  private boolean KVr;
  private boolean KVs;
  private String KXj;
  private TextView KXk;
  private MMPinProgressBtn KXl;
  private String KXm;
  private RelativeLayout KXn;
  View.OnCreateContextMenuListener KXo;
  private float aIC;
  private float aID;
  public com.tencent.mm.ui.tools.m contextMenuHelper;
  private int duration;
  private String fCM;
  private cvt fVT;
  private int fYU;
  private String fullPath;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private boolean isInit;
  private boolean lwF;
  private ImageView mLT;
  private VelocityTracker mVelocityTracker;
  private GestureDetector pCU;
  q.g sBv;
  private com.tencent.mm.model.d sUi;
  private int source;
  private String thumbPath;
  Bundle twA;
  com.tencent.mm.ui.tools.f twB;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  k txH;
  private int wKJ;
  private TextView wOf;
  private boolean wOi;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.KNB = new com.tencent.mm.plugin.sns.ad.f.m("SnsSightPlayerUI");
    this.fullPath = "";
    this.imagePath = "";
    this.fCM = "";
    this.KXj = "";
    this.isAd = false;
    this.txH = null;
    this.Jto = null;
    this.KXk = null;
    this.KXl = null;
    this.source = 0;
    this.duration = 0;
    this.fYU = 0;
    this.JsJ = 0;
    this.wKJ = 0;
    this.Jtp = false;
    this.KVh = false;
    this.JtF = 0;
    this.JtG = 0;
    this.isInit = false;
    this.wOi = false;
    this.Jzk = null;
    this.JIX = null;
    this.fVT = null;
    this.thumbPath = "";
    this.KXm = "";
    this.wOf = null;
    this.isAnimated = false;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.KOu = 1.0F;
    this.KOv = 0;
    this.KOw = 0;
    this.lwF = false;
    this.KXo = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = u.agG(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = u.agG(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          Log.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(i.j.sns_ad_video_right_menu_send_friend));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.by.c.blP("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(i.j.plugin_favorite_opt));
          }
          if (i != 0)
          {
            paramAnonymousView = new em();
            paramAnonymousView.fAp.fAg = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            EventCenter.instance.publish(paramAnonymousView);
            if (paramAnonymousView.fAq.fzO) {
              paramAnonymousContextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(i.j.app_open));
            }
          }
          if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
            paramAnonymousContextMenu.add(0, 1, 0, SnsSightPlayerUI.this.getContext().getString(i.j.sns_timeline_expose));
          }
          AppMethodBeat.o(99084);
          return;
        }
      }
    };
    this.sBv = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(99085);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = aj.fOI().bbl(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new dd();
          com.tencent.mm.plugin.sns.l.a.a((dd)localObject, paramAnonymousMenuItem);
          ((dd)localObject).fyI.activity = SnsSightPlayerUI.this;
          ((dd)localObject).fyI.fyP = 17;
          EventCenter.instance.publish((IEvent)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            p.a(p.d.JGo, p.c.JGj, p.e.JGv, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new wo();
            ((wo)localObject).fVI.fAg = paramAnonymousMenuItem.getLocalid();
            ((wo)localObject).fVI.fLp = com.tencent.mm.plugin.sns.data.t.w(paramAnonymousMenuItem);
            EventCenter.instance.publish((IEvent)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = aj.fOI().bbl(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (localSnsInfo != null) {
            Log.i("MicroMsg.SnsSightPlayerUI", "expose id " + localSnsInfo.getSnsId());
          }
          if (localSnsInfo == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localSnsInfo != null) {
              break label369;
            }
          }
          label369:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localSnsInfo.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.by.c.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(99085);
            return;
            paramAnonymousMenuItem = localSnsInfo.getSnsId();
            break;
          }
          SnsSightPlayerUI.v(SnsSightPlayerUI.this);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
          paramAnonymousMenuItem.putExtra("select_is_ret", true);
          paramAnonymousMenuItem.putExtra("mutil_select_is_ret", true);
          paramAnonymousMenuItem.putExtra("image_path", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.by.c.d(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 4097);
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = aj.fOI().bbl(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.Sqq == 15) && ((cvt)paramAnonymousMenuItem.getTimeLine().ContentObj.Sqr.get(0) == null))
          {
            Log.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.by.c.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.JtN = 0;
    AppMethodBeat.o(99100);
  }
  
  private void ahn(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.f.a.b localb;
    if (this.txH.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.txH.getDuration();
      }
      this.KNB.aeO(this.duration);
      this.KNB.JFu.JGJ = Util.currentTicks();
      localb = this.KNB.JFu;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      localb.JGI = paramInt;
      this.KNB.JFu.JGH = 2;
      Log.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.KNB.JFu.JGI);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void bh(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.JtG == 0) || (this.JtF == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.JtG = ((DisplayMetrics)localObject).heightPixels;
      this.JtF = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.Jty.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.KXk.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.JtF;
      localLayoutParams1.height = ((int)(this.JtF * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.Jty.getId());
      findViewById(i.f.tips_tv).setVisibility(0);
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.txH).setLayoutParams(localLayoutParams1);
      if ((this.txH instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.txH).ju(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.Jto.setLayoutParams(localLayoutParams);
      this.Jty.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.txH).requestLayout();
      if (!paramBoolean) {
        ahn(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.JtF;
      localLayoutParams1.width = ((int)(this.JtF * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.Jty.getId());
      findViewById(i.f.tips_tv).setVisibility(8);
    }
  }
  
  private void dmi()
  {
    AppMethodBeat.i(99104);
    Log.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.txH.pause();
    this.txH.onDetach();
    this.sUi.fZ(false);
    AppMethodBeat.o(99104);
  }
  
  private void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.txH.start();
    this.duration = this.txH.getDuration();
    Log.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.sUi.a(this);
    com.tencent.mm.plugin.sns.ad.f.a.b localb;
    if (paramBoolean)
    {
      localb = this.KNB.JFu;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      localb.JGI = i;
      this.KNB.JFu.JGJ = Util.currentTicks();
      this.KNB.JFu.JGH = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void aYK(String paramString) {}
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void cJs()
  {
    AppMethodBeat.i(99109);
    int k = this.Jty.getWidth();
    int j = this.Jty.getHeight();
    int i = j;
    if (this.twE != 0)
    {
      i = j;
      if (this.twF != 0) {
        i = (int)(k / this.twE * this.twF);
      }
    }
    this.twB.mJ(k, i);
    this.twB.V(this.twD, this.twC, this.twE, this.twF);
    if (this.KOu != 1.0D)
    {
      int m = ar.aB(getContext());
      this.twB.XRS = (1.0F / this.KOu);
      if ((this.KOv != 0) || (this.KOw != 0))
      {
        j = (int)(this.Jty.getWidth() / 2 * (1.0F - this.KOu));
        k = this.KOv;
        i = (int)((m + this.Jty.getHeight()) / 2 - i / 2 * this.KOu + this.KOw);
        this.twB.mL(j + k, i);
      }
    }
    this.twB.a(this.Jty, this.mLT, new f.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(99083);
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99081);
            SnsSightPlayerUI.this.finish();
            SnsSightPlayerUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(99081);
          }
        });
        AppMethodBeat.o(99083);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(99082);
        if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
          SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(8);
        }
        AppMethodBeat.o(99082);
      }
    }, null);
    AppMethodBeat.o(99109);
  }
  
  public final void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    Log.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.fVT != null) && (paramString.equals(this.fVT.Id)) && (u.agG(this.fullPath)))
    {
      this.KNB.JFm = 1;
      this.txH.setVideoPath(this.fullPath);
      yd(true);
      if (this.KXl != null) {
        this.KXl.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void cr(String paramString, boolean paramBoolean) {}
  
  public final void fLL() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.lwF)
    {
      super.finish();
      this.lwF = true;
    }
    AppMethodBeat.o(99102);
  }
  
  public int getForceOrientation()
  {
    return 7;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_sight_player_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99111);
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        eor localeor;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.source == 0)
          {
            localObject1 = aj.fOI().bbl(this.fCM);
            if (localObject1 != null)
            {
              if (!ab.Lj(str2)) {
                break;
              }
              localObject2 = new ws();
              ((ws)localObject2).fVM.fLp = com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1);
              ((ws)localObject2).fVM.fAg = ((SnsInfo)localObject1).getLocalid();
              EventCenter.instance.publish((IEvent)localObject2);
            }
          }
          localObject2 = this.Jzk.getTimeLine();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.Jzk.getAdXml();
          localeor = new eor();
          localeor.SAk = this.fVT.Lgc;
          localeor.lor = this.fVT.TDL;
          if (((TimeLineObject)localObject2).ContentObj.Sqq != 15) {
            break label630;
          }
          localeor.lox = this.JIX.uxInfo;
          localeor.loy = ((TimeLineObject)localObject2).Id;
          if (!Util.isNullOrNil(this.fVT.TDP)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).ContentDesc;
          localeor.lot = ((String)localObject1);
          if (!Util.isNullOrNil(this.fVT.TDO)) {
            break label671;
          }
          localObject1 = this.fVT.TDF;
          localeor.low = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            localeor.lov = ((ADXml)localObject3).attachShareLinkUrl;
            localeor.lou = ((ADXml)localObject3).attachShareLinkWording;
          }
          if (localObject3 != null) {
            localeor.lov = ((ADXml)localObject3).adActionLink;
          }
          i = com.tencent.mm.plugin.sns.data.t.aZt(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, this.fVT.TDL, Integer.valueOf(this.fVT.Lgc), localeor.low, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eRW().a(this, str2, this.fullPath, this.imagePath, 43, i, localeor, ((TimeLineObject)localObject2).statExtStr, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.eRW().iQ(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i.j.has_send));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(this.source, 5, this.Jzk.field_snsId, 12, 0));
        boolean bool = ab.Lj(str2);
        Object localObject2 = p.d.JGo;
        if (bool)
        {
          localObject1 = p.c.JGl;
          label544:
          localObject3 = p.e.JGv;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = v.Pu(str2);; i = 0)
        {
          p.a((p.d)localObject2, (p.c)localObject1, (p.e)localObject3, i, this.Jzk, this.source);
          break;
          localObject2 = new wt();
          ((wt)localObject2).fVN.fLp = com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1);
          ((wt)localObject2).fVN.fAg = ((SnsInfo)localObject1).getLocalid();
          EventCenter.instance.publish((IEvent)localObject2);
          break label152;
          label630:
          localeor.lox = ((TimeLineObject)localObject2).streamvideo.lox;
          localeor.loy = ((TimeLineObject)localObject2).streamvideo.loy;
          break label245;
          label659:
          localObject1 = this.fVT.TDP;
          break label265;
          label671:
          localObject1 = this.fVT.TDO;
          break label294;
          label683:
          i = com.tencent.mm.plugin.sns.data.t.aZt(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eRW().a(this, str2, this.fullPath, this.imagePath, 43, i, ((TimeLineObject)localObject2).statExtStr, null);
          break label462;
          localObject1 = p.c.JGk;
          break label544;
        }
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(this.source, 5, this.Jzk.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    cJs();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.JtN);
    if (this.JtN == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    bh(paramConfiguration.orientation, false);
    this.JtN = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.source = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    aj.fOD().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(i.c.black));
    }
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.twA = paramBundle;
      this.sUi = com.tencent.mm.model.d.bcs();
      this.fullPath = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.fCM = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.Jzk = aj.fOI().bbl(this.fCM);
      if (!this.isAd) {
        break label334;
      }
      if (this.Jzk != null) {
        break label231;
      }
    }
    label231:
    Object localObject1;
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label334;
      }
      finish();
      AppMethodBeat.o(99101);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      this.fVT = ((cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(0));
      paramBundle = aq.kD(aj.getAccSnsPath(), this.fVT.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.t.j(this.fVT);
      this.KXm = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + com.tencent.mm.plugin.sns.data.t.d(this.fVT));
    }
    label334:
    if (com.tencent.mm.q.a.abL() != null) {
      com.tencent.mm.q.a.abL().aqn();
    }
    if (this.Jzk != null) {
      if (this.source == 2)
      {
        paramBundle = this.Jzk.getAtAdInfo();
        this.JIX = paramBundle;
        this.KNB.JFo = Util.currentTicks();
        this.KXn = ((RelativeLayout)findViewById(i.f.content_root));
        this.KXn.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            SnsSightPlayerUI.this.cJs();
            AppMethodBeat.o(99078);
            return true;
          }
        });
        Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.avC() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
        this.twB = new com.tencent.mm.ui.tools.f(getContext());
        this.mLT = ((ImageView)findViewById(i.f.gallery_bg));
        this.Jto = ((TextView)findViewById(i.f.tips_tv));
        this.KXl = ((MMPinProgressBtn)findViewById(i.f.sight_downloading_pb));
        this.Jty = ((ViewGroup)findViewById(i.f.video_container));
        this.txH = x.jH(getContext());
        if ((this.txH instanceof VideoSightView)) {
          ((VideoSightView)this.txH).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.wOf = ((TextView)findViewById(i.f.show_ad_sight));
        this.wOf.setTextColor(Color.parseColor("#888888"));
        this.Jty.addView((View)this.txH, 0, paramBundle);
        this.KXk = ((TextView)findViewById(i.f.time_counter_tv));
        this.KXk.setText("");
        if (!this.isAd) {
          this.KXk.setVisibility(8);
        }
        if (!this.isAd) {
          break label1313;
        }
        if (this.fVT != null) {
          break label989;
        }
        this.wOf.setVisibility(8);
        label685:
        w.a(this.wOf, (VideoSightView)this.txH);
        label699:
        this.txH.setVideoCallback(new k.a()
        {
          public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(99093);
            Log.d("MicroMsg.SnsSightPlayerUI", "on completion");
            if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
              SnsSightPlayerUI.k(SnsSightPlayerUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(99090);
                  if (SnsSightPlayerUI.k(SnsSightPlayerUI.this).getVisibility() != 0)
                  {
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).setVisibility(0);
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.getContext(), i.a.fast_faded_in));
                  }
                  AppMethodBeat.o(99090);
                }
              });
            }
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).setLoop(true);
            com.tencent.mm.plugin.sns.ad.f.a.b localb = SnsSightPlayerUI.l(SnsSightPlayerUI.this).JFu;
            localb.JGE += 1;
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
            AppMethodBeat.o(99093);
          }
          
          public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(99092);
            Log.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).stop();
            if (SnsSightPlayerUI.h(SnsSightPlayerUI.this))
            {
              AppMethodBeat.o(99092);
              return;
            }
            SnsSightPlayerUI.i(SnsSightPlayerUI.this);
            CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.fIy() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            i locali = com.tencent.mm.ay.q.bmh();
            float f = com.tencent.mm.ci.a.getDensity(SnsSightPlayerUI.this.getContext());
            SnsSightPlayerUI.this.getContext();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(i.f.videoplayer_maskview);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.HEA);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.q(str), "video/*", false);
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(i.j.favorite_video));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  com.tencent.mm.ui.base.h.p(SnsSightPlayerUI.this.getContext(), i.j.favorite_no_match_msg, i.j.favorite_no_match_title);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
          
          public final void qX()
          {
            AppMethodBeat.i(99091);
            Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.avC() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
        });
        findViewById(i.f.video_container).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SnsSightPlayerUI.this.cJs();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.txH).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SnsSightPlayerUI.this.cJs();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99095);
          }
        });
        this.pCU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268365);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(268365);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268364);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(268364);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
            SnsSightPlayerUI.b(SnsSightPlayerUI.this, true);
            super.onLongPress(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(99097);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(99096);
            paramAnonymousFloat1 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationX();
            paramAnonymousFloat2 = paramAnonymousMotionEvent2.getX();
            float f1 = paramAnonymousMotionEvent1.getX();
            float f2 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationY();
            float f3 = paramAnonymousMotionEvent2.getY();
            float f4 = paramAnonymousMotionEvent1.getY();
            if (SnsSightPlayerUI.m(SnsSightPlayerUI.this))
            {
              ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(paramAnonymousFloat1 + paramAnonymousFloat2 - f1);
              ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(f2 + f3 - f4);
            }
            AppMethodBeat.o(99096);
            return true;
          }
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268363);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(268363);
            return bool;
          }
        });
        ((View)this.txH).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99098);
            paramAnonymousView = SnsSightPlayerUI.n(SnsSightPlayerUI.this);
            com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aFh(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if (SnsSightPlayerUI.o(SnsSightPlayerUI.this) == null) {
              SnsSightPlayerUI.a(SnsSightPlayerUI.this, VelocityTracker.obtain());
            }
            SnsSightPlayerUI.o(SnsSightPlayerUI.this).addMovement(paramAnonymousMotionEvent);
            switch (paramAnonymousMotionEvent.getAction() & 0xFF)
            {
            default: 
            case 0: 
            case 1: 
              for (;;)
              {
                AppMethodBeat.o(99098);
                return false;
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, paramAnonymousMotionEvent.getX());
                SnsSightPlayerUI.b(SnsSightPlayerUI.this, paramAnonymousMotionEvent.getY());
                continue;
                if (SnsSightPlayerUI.p(SnsSightPlayerUI.this))
                {
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.Jty.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.Jty.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new com.tencent.mm.ui.tools.m(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.txH, paramAnonymousView.KXo, paramAnonymousView.sBv);
                  if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
                    SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(0);
                  }
                  SnsSightPlayerUI.c(SnsSightPlayerUI.this, false);
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                }
                else
                {
                  if ((SnsSightPlayerUI.m(SnsSightPlayerUI.this)) && (!SnsSightPlayerUI.r(SnsSightPlayerUI.this)))
                  {
                    SnsSightPlayerUI.this.cJs();
                    SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                    AppMethodBeat.o(99098);
                    return true;
                  }
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                }
              }
            }
            float f2 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationX();
            float f3 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationY();
            paramAnonymousView = SnsSightPlayerUI.o(SnsSightPlayerUI.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            if (((Math.abs(f2) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsSightPlayerUI.r(SnsSightPlayerUI.this))) || (SnsSightPlayerUI.m(SnsSightPlayerUI.this)))
            {
              float f1 = 1.0F - f3 / SnsSightPlayerUI.this.Jty.getHeight();
              if (f1 > 1.0F)
              {
                f1 = 1.0F;
                label575:
                if (((j > 0) && (f1 < SnsSightPlayerUI.s(SnsSightPlayerUI.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  SnsSightPlayerUI.a(SnsSightPlayerUI.this, (int)f2);
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, (int)f3);
                  SnsSightPlayerUI.c(SnsSightPlayerUI.this, f1);
                  if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
                    SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(8);
                  }
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.Jty.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.Jty.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(f1);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(f1);
                  SnsSightPlayerUI.t(SnsSightPlayerUI.this).setAlpha(f1);
                }
                SnsSightPlayerUI.c(SnsSightPlayerUI.this, true);
                label759:
                if (f3 <= 200.0F) {
                  break label859;
                }
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, false);
              }
            }
            for (;;)
            {
              if (f3 > 50.0F) {
                ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setOnLongClickListener(null);
              }
              if (SnsSightPlayerUI.o(SnsSightPlayerUI.this) != null)
              {
                SnsSightPlayerUI.o(SnsSightPlayerUI.this).recycle();
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, null);
              }
              if (!SnsSightPlayerUI.m(SnsSightPlayerUI.this)) {
                break;
              }
              AppMethodBeat.o(99098);
              return true;
              break label575;
              SnsSightPlayerUI.c(SnsSightPlayerUI.this, false);
              break label759;
              label859:
              if (f3 > 10.0F) {
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, true);
              }
            }
          }
        });
        if (!u.agG(this.fullPath)) {
          break label1325;
        }
        if (this.fullPath != null)
        {
          this.txH.stop();
          this.txH.setVideoPath(this.fullPath);
        }
        this.KXl.setVisibility(8);
      }
    }
    for (this.KNB.JFm = 1;; this.KNB.JFm = 0)
    {
      Log.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new zo();
      paramBundle.fYR.type = 1;
      EventCenter.instance.publish(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.m(getContext());
      }
      this.contextMenuHelper.a((View)this.txH, this.KXo, this.sBv);
      ((View)this.txH).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99099);
          DisplayMetrics localDisplayMetrics = new DisplayMetrics();
          SnsSightPlayerUI.this.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
          if ((SnsSightPlayerUI.g(SnsSightPlayerUI.this) instanceof VideoSightView)) {
            ((VideoSightView)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setDrawableWidth(localDisplayMetrics.widthPixels);
          }
          ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).requestLayout();
          ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).postInvalidate();
          AppMethodBeat.o(99099);
        }
      });
      AppMethodBeat.o(99101);
      return;
      paramBundle = this.Jzk.getAdInfo();
      break;
      paramBundle = null;
      break;
      label989:
      if (Util.isNullOrNil(this.fVT.TDL))
      {
        Log.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.Jzk.getTimeLine();
        Object localObject2 = this.Jzk.getAdXml();
        localObject1 = ((ADXml)localObject2).attachShareLinkWording;
        localObject2 = ((ADXml)localObject2).attachShareLinkUrl;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          this.wOf.setVisibility(0);
          this.wOf.setText((CharSequence)localObject1);
          this.wOf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
              Object localObject2;
              if (p.b.JGd.value != 0)
              {
                localObject1 = p.a.JFX;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label259;
                }
              }
              label259:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo)
              {
                p.a((p.a)localObject1, (String)localObject2, paramAnonymousView, 1, p.b.JGd.value, paramBundle.UserName, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.statExtStr);
                localObject1 = this.wOu;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.c.a.mIG.h(this.val$intent, SnsSightPlayerUI.this);
                    SnsSightPlayerUI.this.finish();
                    AppMethodBeat.o(99086);
                  }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99087);
                return;
              }
            }
          });
          break label685;
        }
        this.wOf.setVisibility(8);
        break label685;
      }
      localObject1 = getResources().getString(i.j.sns_ad_sight_full);
      paramBundle = (Bundle)localObject1;
      if (this.fVT.Lgc / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(i.j.sns_ad_sight_full_m, new Object[] { Integer.valueOf(this.fVT.Lgc / 60) });
      }
      localObject1 = paramBundle;
      if (this.fVT.Lgc % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(i.j.sns_ad_sight_full_s, new Object[] { Integer.valueOf(this.fVT.Lgc % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(i.j.sns_ad_sight_full_end);
      this.wOf.setText(paramBundle);
      this.wOf.setVisibility(0);
      this.wOf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).isAd()) {
            p.a(p.b.JGd, p.a.JFW, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          localObject1 = new Intent();
          paramAnonymousView = aq.kD(aj.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = com.tencent.mm.plugin.sns.data.t.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuU, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            Log.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDL);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDO)) {
              break label788;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDF;
            label235:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).viewId);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).getTimeLine();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label802;
            }
            paramAnonymousView = "";
            label318:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", p.b.JGd.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).UserName);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).statExtStr);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Lgc);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDP)) {
              break label816;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).ContentDesc;
            label429:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).getAdXml();
            if ((paramAnonymousView != null) && (paramAnonymousView.attachShareLinkIsHidden == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.attachShareLinkWording);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.attachShareLinkUrl);
            }
            localObject2 = aj.fOI().bbl(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label830;
            }
            paramAnonymousView = l.wO(747);
            label515:
            paramAnonymousView.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).gx(true).Xf(((SnsInfo)localObject2).getUxinfo()).wR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Lgc);
            paramAnonymousView.bpa();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label840;
            }
          }
          label788:
          label802:
          label816:
          label830:
          label840:
          for (paramAnonymousView = l.wO(748);; paramAnonymousView = l.wP(748))
          {
            paramAnonymousView.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).gx(true).Xf(((SnsInfo)localObject2).getUxinfo()).wR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Lgc);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((SnsInfo)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new wf();
              paramAnonymousView.fVs.isStart = true;
              EventCenter.instance.publish(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDO;
            break label235;
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo;
            break label318;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).TDP;
            break label429;
            paramAnonymousView = l.wP(747);
            break label515;
          }
        }
      });
      break label685;
      label1313:
      this.wOf.setVisibility(8);
      break label699;
      label1325:
      aj.fOD().a(this.fVT, 6, null, bp.VGp);
      this.KXl.setVisibility(0);
      this.KXl.hZF();
    }
  }
  
  public void onDestroy()
  {
    boolean bool = true;
    AppMethodBeat.i(99105);
    super.onDestroy();
    int i;
    label56:
    String str1;
    label149:
    int j;
    label170:
    com.tencent.mm.cd.b localb1;
    label199:
    com.tencent.mm.cd.b localb2;
    if (this.isAd)
    {
      if (this.Jzk != null) {
        break label494;
      }
      localObject = "";
      if (this.Jzk != null)
      {
        String str2 = this.KNB.fKS();
        if (this.Jzk != null) {
          break label506;
        }
        i = 0;
        long l2 = this.KNB.JFn - this.KNB.mba;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.KNB.JFn), Long.valueOf(this.KNB.mba) });
          l1 = this.KNB.JFn;
        }
        int k = (int)l1;
        if (this.JIX != null) {
          break label517;
        }
        str1 = "";
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aHF().kcd;
        if (this.source != 0) {
          break label529;
        }
        j = 1;
        int m = this.KNB.JFn;
        if (this.source != 2) {
          break label534;
        }
        localb1 = this.Jzk.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
        if (this.source != 2) {
          break label549;
        }
        localb2 = this.Jzk.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
        label219:
        localt.a(new com.tencent.mm.plugin.sns.ad.f.g((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    Log.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.Jzk != null) && (this.Jzk.isAd())) {
      p.a(p.b.JGd, p.a.JFY, this.Jzk, this.source);
    }
    aj.fOD().b(this);
    Object localObject = l.x(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label570;
      }
      if (Util.isNullOrNil(this.fVT.TDL)) {
        break label564;
      }
      label340:
      ((l)localObject).gx(bool);
    }
    for (;;)
    {
      ((l)localObject).update();
      ((l)localObject).bpa();
      if (com.tencent.mm.q.a.abL() != null) {
        com.tencent.mm.q.a.abL().aqm();
      }
      if (this.txH != null)
      {
        this.txH.setVideoCallback(null);
        this.txH.stop();
        this.txH.onDetach();
      }
      if (!this.Jtp)
      {
        localObject = new zo();
        ((zo)localObject).fYR.type = 0;
        ((zo)localObject).fYR.fYS = this.JsJ;
        ((zo)localObject).fYR.fYT = this.wKJ;
        ((zo)localObject).fYR.fYU = this.fYU;
        EventCenter.instance.publish((IEvent)localObject);
      }
      this.sUi.fZ(false);
      AppMethodBeat.o(99105);
      return;
      label494:
      localObject = this.JIX.viewId;
      break;
      label506:
      i = this.Jzk.getAdRecSrc();
      break label56;
      label517:
      str1 = this.JIX.waidPkg;
      break label149;
      label529:
      j = 2;
      break label170;
      label534:
      localb1 = this.Jzk.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
      break label199;
      label549:
      localb2 = this.Jzk.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
      break label219;
      label564:
      bool = false;
      break label340;
      label570:
      ((l)localObject).gx(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    ahn(i);
    if (!this.KVh)
    {
      dmi();
      Log.v("check", "onclick");
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99079);
          SnsSightPlayerUI.this.finish();
          AppMethodBeat.o(99079);
        }
      });
    }
    for (;;)
    {
      if (this.KNB != null) {
        this.KNB.maZ = Util.currentTicks();
      }
      AppMethodBeat.o(99108);
      return;
      dmi();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.isInit)
    {
      Log.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        bh(getResources().getConfiguration().orientation, true);
      }
      this.isInit = true;
    }
    if ((this.JtG == 0) || (this.JtF == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.JtG = localDisplayMetrics.heightPixels;
      this.JtF = localDisplayMetrics.widthPixels;
    }
    if ((this.KVh) && (u.agG(this.fullPath)))
    {
      yd(false);
      this.KVh = false;
    }
    if (this.KNB != null) {
      this.KNB.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.twA;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.twC = getIntent().getIntExtra("img_gallery_top", 0);
        this.twD = getIntent().getIntExtra("img_gallery_left", 0);
        this.twE = getIntent().getIntExtra("img_gallery_width", 0);
        this.twF = getIntent().getIntExtra("img_gallery_height", 0);
        this.twB.V(this.twD, this.twC, this.twE, this.twF);
        if (localBundle == null) {
          this.Jty.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.Jty.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.twB.a(SnsSightPlayerUI.this.Jty, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
              AppMethodBeat.o(99080);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(99106);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI
 * JD-Core Version:    0.7.0.1
 */