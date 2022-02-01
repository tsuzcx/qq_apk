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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.an;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.g.o.a;
import com.tencent.mm.plugin.sns.ad.g.o.b;
import com.tencent.mm.plugin.sns.ad.g.o.c;
import com.tencent.mm.plugin.sns.ad.g.o.d;
import com.tencent.mm.plugin.sns.ad.g.o.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eeq;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, c.b
{
  private TextView DnJ;
  private boolean DnK;
  ViewGroup DnT;
  private int Dne;
  private int Doa;
  private int Dob;
  public int Doi;
  private SnsInfo DsC;
  private ADInfo DyO;
  private float EAC;
  private int EAD;
  private int EAE;
  private boolean EHl;
  private boolean EHq;
  private boolean EHr;
  private boolean EHs;
  private String EJi;
  private TextView EJj;
  private MMPinProgressBtn EJk;
  private String EJl;
  private RelativeLayout EJm;
  View.OnCreateContextMenuListener EJn;
  private com.tencent.mm.plugin.sns.ad.g.l EzN;
  private float aZg;
  private float aZh;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  private String dJX;
  private int duration;
  private cnb ebR;
  private int eeF;
  private String fullPath;
  private boolean iGD;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private boolean isInit;
  private ImageView jUG;
  private GestureDetector mDJ;
  private VelocityTracker mVelocityTracker;
  private com.tencent.mm.model.d pNk;
  o.g pso;
  Bundle qaD;
  com.tencent.mm.ui.tools.e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  j qbJ;
  private int source;
  private int tex;
  private TextView thO;
  private boolean thR;
  private String thumbPath;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.EzN = new com.tencent.mm.plugin.sns.ad.g.l("SnsSightPlayerUI");
    this.fullPath = "";
    this.imagePath = "";
    this.dJX = "";
    this.EJi = "";
    this.isAd = false;
    this.qbJ = null;
    this.DnJ = null;
    this.EJj = null;
    this.EJk = null;
    this.source = 0;
    this.duration = 0;
    this.eeF = 0;
    this.Dne = 0;
    this.tex = 0;
    this.DnK = false;
    this.EHl = false;
    this.Doa = 0;
    this.Dob = 0;
    this.isInit = false;
    this.thR = false;
    this.DsC = null;
    this.DyO = null;
    this.ebR = null;
    this.thumbPath = "";
    this.EJl = "";
    this.thO = null;
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.EAC = 1.0F;
    this.EAD = 0;
    this.EAE = 0;
    this.iGD = false;
    this.EJn = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = s.YS(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = s.YS(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          Log.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(2131765992));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.c.aZU("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(2131763947));
          }
          if (i != 0)
          {
            paramAnonymousView = new ef();
            paramAnonymousView.dHy.dHp = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            EventCenter.instance.publish(paramAnonymousView);
            if (paramAnonymousView.dHz.dGX) {
              paramAnonymousContextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(2131755922));
            }
          }
          if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
            paramAnonymousContextMenu.add(0, 1, 0, SnsSightPlayerUI.this.getContext().getString(2131766260));
          }
          AppMethodBeat.o(99084);
          return;
        }
      }
    };
    this.pso = new o.g()
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
          paramAnonymousMenuItem = aj.faO().aQm(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new cz();
          com.tencent.mm.plugin.sns.l.a.a((cz)localObject, paramAnonymousMenuItem);
          ((cz)localObject).dFZ.activity = SnsSightPlayerUI.this;
          ((cz)localObject).dFZ.dGf = 17;
          EventCenter.instance.publish((IEvent)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            com.tencent.mm.plugin.sns.ad.g.o.a(o.d.DwM, o.c.DwH, o.e.DwT, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new vj();
            ((vj)localObject).ebG.dHp = paramAnonymousMenuItem.getLocalid();
            ((vj)localObject).ebG.dRS = r.v(paramAnonymousMenuItem);
            EventCenter.instance.publish((IEvent)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = aj.faO().aQm(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
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
            ((Intent)localObject).putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.br.c.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
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
          com.tencent.mm.br.c.c(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 4097);
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = aj.faO().aQm(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.LoU == 15) && ((cnb)paramAnonymousMenuItem.getTimeLine().ContentObj.LoV.get(0) == null))
          {
            Log.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.c.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.Doi = 0;
    AppMethodBeat.o(99100);
  }
  
  private void ZQ(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.g.a.a locala;
    if (this.qbJ.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.qbJ.getDuration();
      }
      this.EzN.XK(this.duration);
      this.EzN.DvW.Dxc = Util.currentTicks();
      locala = this.EzN.DvW;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.Dxb = paramInt;
      this.EzN.DvW.Dxa = 2;
      Log.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.EzN.DvW.Dxb);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void aW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.Dob == 0) || (this.Doa == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.Dob = ((DisplayMetrics)localObject).heightPixels;
      this.Doa = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.DnT.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.EJj.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.Doa;
      localLayoutParams1.height = ((int)(this.Doa * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.DnT.getId());
      findViewById(2131309187).setVisibility(0);
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.qbJ).setLayoutParams(localLayoutParams1);
      if ((this.qbJ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.qbJ).im(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.DnJ.setLayoutParams(localLayoutParams);
      this.DnT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.qbJ).requestLayout();
      if (!paramBoolean) {
        ZQ(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.Doa;
      localLayoutParams1.width = ((int)(this.Doa * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.DnT.getId());
      findViewById(2131309187).setVisibility(8);
    }
  }
  
  private void cXa()
  {
    AppMethodBeat.i(99104);
    Log.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.qbJ.pause();
    this.qbJ.onDetach();
    this.pNk.fp(false);
    AppMethodBeat.o(99104);
  }
  
  private void uF(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.qbJ.start();
    this.duration = this.qbJ.getDuration();
    Log.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.pNk.a(this);
    com.tencent.mm.plugin.sns.ad.g.a.a locala;
    if (paramBoolean)
    {
      locala = this.EzN.DvW;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      locala.Dxb = i;
      this.EzN.DvW.Dxc = Util.currentTicks();
      this.EzN.DvW.Dxa = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void aOG(String paramString) {}
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void ci(String paramString, boolean paramBoolean) {}
  
  public final void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    Log.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.ebR != null) && (paramString.equals(this.ebR.Id)) && (s.YS(this.fullPath)))
    {
      this.EzN.DvO = 1;
      this.qbJ.setVideoPath(this.fullPath);
      uF(true);
      if (this.EJk != null) {
        this.EJk.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(99109);
    int k = this.DnT.getWidth();
    int j = this.DnT.getHeight();
    int i = j;
    if (this.qaH != 0)
    {
      i = j;
      if (this.qaI != 0) {
        i = (int)(k / this.qaH * this.qaI);
      }
    }
    this.qaE.ls(k, i);
    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
    if (this.EAC != 1.0D)
    {
      int m = ao.aD(getContext());
      this.qaE.QtG = (1.0F / this.EAC);
      if ((this.EAD != 0) || (this.EAE != 0))
      {
        j = (int)(this.DnT.getWidth() / 2 * (1.0F - this.EAC));
        k = this.EAD;
        i = (int)((m + this.DnT.getHeight()) / 2 - i / 2 * this.EAC + this.EAE);
        this.qaE.lu(j + k, i);
      }
    }
    this.qaE.a(this.DnT, this.jUG, new e.c()
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
  
  public final void eZJ() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.iGD)
    {
      super.finish();
      this.iGD = true;
    }
    AppMethodBeat.o(99102);
  }
  
  public int getForceOrientation()
  {
    return 7;
  }
  
  public int getLayoutId()
  {
    return 2131496486;
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
        eeq localeeq;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.source == 0)
          {
            localObject1 = aj.faO().aQm(this.dJX);
            if (localObject1 != null)
            {
              if (!ab.Eq(str2)) {
                break;
              }
              localObject2 = new vn();
              ((vn)localObject2).ebK.dRS = r.v((SnsInfo)localObject1);
              ((vn)localObject2).ebK.dHp = ((SnsInfo)localObject1).getLocalid();
              EventCenter.instance.publish((IEvent)localObject2);
            }
          }
          localObject2 = this.DsC.getTimeLine();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.DsC.getAdXml();
          localeeq = new eeq();
          localeeq.LxJ = this.ebR.ERX;
          localeeq.iyZ = this.ebR.MsF;
          if (((TimeLineObject)localObject2).ContentObj.LoU != 15) {
            break label630;
          }
          localeeq.izf = this.DyO.uxInfo;
          localeeq.izg = ((TimeLineObject)localObject2).Id;
          if (!Util.isNullOrNil(this.ebR.MsJ)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).ContentDesc;
          localeeq.izb = ((String)localObject1);
          if (!Util.isNullOrNil(this.ebR.MsI)) {
            break label671;
          }
          localObject1 = this.ebR.Msz;
          localeeq.ize = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            localeeq.izd = ((ADXml)localObject3).attachShareLinkUrl;
            localeeq.izc = ((ADXml)localObject3).attachShareLinkWording;
          }
          if (localObject3 != null) {
            localeeq.izd = ((ADXml)localObject3).adActionLink;
          }
          i = r.aOx(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, this.ebR.MsF, Integer.valueOf(this.ebR.ERX), localeeq.ize, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.imagePath, 43, i, localeeq, ((TimeLineObject)localObject2).statExtStr, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.eir().iF(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        r.a(new SnsAdClick(this.source, 5, this.DsC.field_snsId, 12, 0));
        boolean bool = ab.Eq(str2);
        Object localObject2 = o.d.DwM;
        if (bool)
        {
          localObject1 = o.c.DwJ;
          label544:
          localObject3 = o.e.DwT;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = com.tencent.mm.model.v.Ie(str2);; i = 0)
        {
          com.tencent.mm.plugin.sns.ad.g.o.a((o.d)localObject2, (o.c)localObject1, (o.e)localObject3, i, this.DsC, this.source);
          break;
          localObject2 = new vo();
          ((vo)localObject2).ebL.dRS = r.v((SnsInfo)localObject1);
          ((vo)localObject2).ebL.dHp = ((SnsInfo)localObject1).getLocalid();
          EventCenter.instance.publish((IEvent)localObject2);
          break label152;
          label630:
          localeeq.izf = ((TimeLineObject)localObject2).streamvideo.izf;
          localeeq.izg = ((TimeLineObject)localObject2).streamvideo.izg;
          break label245;
          label659:
          localObject1 = this.ebR.MsJ;
          break label265;
          label671:
          localObject1 = this.ebR.MsI;
          break label294;
          label683:
          i = r.aOx(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.imagePath, 43, i, ((TimeLineObject)localObject2).statExtStr, null);
          break label462;
          localObject1 = o.c.DwI;
          break label544;
        }
      }
      if (this.isAd) {
        r.a(new SnsAdClick(this.source, 5, this.DsC.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    cvQ();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.Doi);
    if (this.Doi == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    aW(paramConfiguration.orientation, false);
    this.Doi = paramConfiguration.orientation;
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
    aj.faJ().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100042));
    }
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.qaD = paramBundle;
      this.pNk = new com.tencent.mm.model.d();
      this.fullPath = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.dJX = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.DsC = aj.faO().aQm(this.dJX);
      if (!this.isAd) {
        break label338;
      }
      if (this.DsC != null) {
        break label235;
      }
    }
    label235:
    Object localObject1;
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label338;
      }
      finish();
      AppMethodBeat.o(99101);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      this.ebR = ((cnb)this.DsC.getTimeLine().ContentObj.LoV.get(0));
      paramBundle = ar.ki(aj.getAccSnsPath(), this.ebR.Id);
      localObject1 = r.k(this.ebR);
      this.EJl = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + r.e(this.ebR));
    }
    label338:
    if (com.tencent.mm.q.a.Xi() != null) {
      com.tencent.mm.q.a.Xi().akr();
    }
    if (this.DsC != null) {
      if (this.source == 2)
      {
        paramBundle = this.DsC.getAtAdInfo();
        this.DyO = paramBundle;
        this.EzN.DvQ = Util.currentTicks();
        this.EJm = ((RelativeLayout)findViewById(2131299214));
        this.EJm.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            SnsSightPlayerUI.this.cvQ();
            AppMethodBeat.o(99078);
            return true;
          }
        });
        Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.app() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
        this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        this.jUG = ((ImageView)findViewById(2131301854));
        this.DnJ = ((TextView)findViewById(2131309187));
        this.EJk = ((MMPinProgressBtn)findViewById(2131307888));
        this.DnT = ((ViewGroup)findViewById(2131309736));
        this.qbJ = com.tencent.mm.pluginsdk.ui.tools.v.iE(getContext());
        if ((this.qbJ instanceof VideoSightView)) {
          ((VideoSightView)this.qbJ).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.thO = ((TextView)findViewById(2131307859));
        this.thO.setTextColor(Color.parseColor("#888888"));
        this.DnT.addView((View)this.qbJ, 0, paramBundle);
        this.EJj = ((TextView)findViewById(2131309091));
        this.EJj.setText("");
        if (!this.isAd) {
          this.EJj.setVisibility(8);
        }
        if (!this.isAd) {
          break label1317;
        }
        if (this.ebR != null) {
          break label993;
        }
        this.thO.setVisibility(8);
        label689:
        u.a(this.thO, (VideoSightView)this.qbJ);
        label703:
        this.qbJ.setVideoCallback(new j.a()
        {
          public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.getContext(), 2130772059));
                  }
                  AppMethodBeat.o(99090);
                }
              });
            }
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).setLoop(true);
            com.tencent.mm.plugin.sns.ad.g.a.a locala = SnsSightPlayerUI.l(SnsSightPlayerUI.this).DvW;
            locala.DwX += 1;
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
            CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.eVv() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            i locali = q.bcR();
            float f = com.tencent.mm.cb.a.getDensity(SnsSightPlayerUI.this.getContext());
            SnsSightPlayerUI.this.getContext();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(2131309846);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.BIt);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.o(str), "video/*", false);
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(2131759356));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  com.tencent.mm.ui.base.h.n(SnsSightPlayerUI.this.getContext(), 2131759255, 2131759256);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
          
          public final void tf()
          {
            AppMethodBeat.i(99091);
            Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.app() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
        });
        findViewById(2131309736).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SnsSightPlayerUI.this.cvQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.qbJ).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SnsSightPlayerUI.this.cvQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99095);
          }
        });
        this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(203656);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(203656);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(203655);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(203655);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
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
            AppMethodBeat.i(203654);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(203654);
            return bool;
          }
        });
        ((View)this.qbJ).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99098);
            paramAnonymousView = SnsSightPlayerUI.n(SnsSightPlayerUI.this);
            com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, locala.axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.DnT.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.DnT.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.qbJ, paramAnonymousView.EJn, paramAnonymousView.pso);
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
                    SnsSightPlayerUI.this.cvQ();
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
              float f1 = 1.0F - f3 / SnsSightPlayerUI.this.DnT.getHeight();
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.DnT.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.DnT.getHeight() / 2);
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
        if (!s.YS(this.fullPath)) {
          break label1329;
        }
        if (this.fullPath != null)
        {
          this.qbJ.stop();
          this.qbJ.setVideoPath(this.fullPath);
        }
        this.EJk.setVisibility(8);
      }
    }
    for (this.EzN.DvO = 1;; this.EzN.DvO = 0)
    {
      Log.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new yh();
      paramBundle.eeC.type = 1;
      EventCenter.instance.publish(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
      }
      this.contextMenuHelper.a((View)this.qbJ, this.EJn, this.pso);
      ((View)this.qbJ).post(new Runnable()
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
      paramBundle = this.DsC.getAdInfo();
      break;
      paramBundle = null;
      break;
      label993:
      if (Util.isNullOrNil(this.ebR.MsF))
      {
        Log.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.DsC.getTimeLine();
        Object localObject2 = this.DsC.getAdXml();
        localObject1 = ((ADXml)localObject2).attachShareLinkWording;
        localObject2 = ((ADXml)localObject2).attachShareLinkUrl;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          this.thO.setVisibility(0);
          this.thO.setText((CharSequence)localObject1);
          this.thO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
              Object localObject2;
              if (o.b.DwB.value != 0)
              {
                localObject1 = o.a.Dwv;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label259;
                }
              }
              label259:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo)
              {
                com.tencent.mm.plugin.sns.ad.g.o.a((o.a)localObject1, (String)localObject2, paramAnonymousView, 1, o.b.DwB.value, paramBundle.UserName, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.statExtStr);
                localObject1 = this.tic;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = r.kb((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.c.a.jRt.i(this.val$intent, SnsSightPlayerUI.this);
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
          break label689;
        }
        this.thO.setVisibility(8);
        break label689;
      }
      localObject1 = getResources().getString(2131765980);
      paramBundle = (Bundle)localObject1;
      if (this.ebR.ERX / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131765982, new Object[] { Integer.valueOf(this.ebR.ERX / 60) });
      }
      localObject1 = paramBundle;
      if (this.ebR.ERX % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131765983, new Object[] { Integer.valueOf(this.ebR.ERX % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131765981);
      this.thO.setText(paramBundle);
      this.thO.setVisibility(0);
      this.thO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).isAd()) {
            com.tencent.mm.plugin.sns.ad.g.o.a(o.b.DwB, o.a.Dwu, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          localObject1 = new Intent();
          paramAnonymousView = ar.ki(aj.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = r.k(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            Log.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).MsF);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).MsI)) {
              break label788;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Msz;
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
            ((Intent)localObject1).putExtra("KSta_Scene", o.b.DwB.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).UserName);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).statExtStr);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).ERX);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).MsJ)) {
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
            localObject2 = aj.faO().aQm(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label830;
            }
            paramAnonymousView = k.tO(747);
            label515:
            paramAnonymousView.PH(r.v((SnsInfo)localObject2)).tR(((SnsInfo)localObject2).field_type).fL(true).PH(((SnsInfo)localObject2).getUxinfo()).tR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).ERX);
            paramAnonymousView.bfK();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label840;
            }
          }
          label788:
          label802:
          label816:
          label830:
          label840:
          for (paramAnonymousView = k.tO(748);; paramAnonymousView = k.tP(748))
          {
            paramAnonymousView.PH(r.v((SnsInfo)localObject2)).tR(((SnsInfo)localObject2).field_type).fL(true).PH(((SnsInfo)localObject2).getUxinfo()).tR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).ERX);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((SnsInfo)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new vb();
              paramAnonymousView.ebt.isStart = true;
              EventCenter.instance.publish(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).MsI;
            break label235;
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo;
            break label318;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).MsJ;
            break label429;
            paramAnonymousView = k.tP(747);
            break label515;
          }
        }
      });
      break label689;
      label1317:
      this.thO.setVisibility(8);
      break label703;
      label1329:
      aj.faJ().a(this.ebR, 6, null, bp.Oqt);
      this.EJk.setVisibility(0);
      this.EJk.gYN();
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
    com.tencent.mm.bw.b localb1;
    label199:
    com.tencent.mm.bw.b localb2;
    if (this.isAd)
    {
      if (this.DsC != null) {
        break label494;
      }
      localObject = "";
      if (this.DsC != null)
      {
        String str2 = this.EzN.eXr();
        if (this.DsC != null) {
          break label506;
        }
        i = 0;
        long l2 = this.EzN.DvP - this.EzN.jkZ;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ) });
          l1 = this.EzN.DvP;
        }
        int k = (int)l1;
        if (this.DyO != null) {
          break label517;
        }
        str1 = "";
        com.tencent.mm.kernel.g.aAi();
        t localt = com.tencent.mm.kernel.g.aAg().hqi;
        if (this.source != 0) {
          break label529;
        }
        j = 1;
        int m = this.EzN.DvP;
        if (this.source != 2) {
          break label534;
        }
        localb1 = this.DsC.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
        if (this.source != 2) {
          break label549;
        }
        localb2 = this.DsC.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
        label219:
        localt.a(new com.tencent.mm.plugin.sns.ad.g.g((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    Log.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.DsC != null) && (this.DsC.isAd())) {
      com.tencent.mm.plugin.sns.ad.g.o.a(o.b.DwB, o.a.Dww, this.DsC, this.source);
    }
    aj.faJ().b(this);
    Object localObject = k.w(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label570;
      }
      if (Util.isNullOrNil(this.ebR.MsF)) {
        break label564;
      }
      label340:
      ((k)localObject).fL(bool);
    }
    for (;;)
    {
      ((k)localObject).update();
      ((k)localObject).bfK();
      if (com.tencent.mm.q.a.Xi() != null) {
        com.tencent.mm.q.a.Xi().akq();
      }
      if (this.qbJ != null)
      {
        this.qbJ.setVideoCallback(null);
        this.qbJ.stop();
        this.qbJ.onDetach();
      }
      if (!this.DnK)
      {
        localObject = new yh();
        ((yh)localObject).eeC.type = 0;
        ((yh)localObject).eeC.eeD = this.Dne;
        ((yh)localObject).eeC.eeE = this.tex;
        ((yh)localObject).eeC.eeF = this.eeF;
        EventCenter.instance.publish((IEvent)localObject);
      }
      this.pNk.fp(false);
      AppMethodBeat.o(99105);
      return;
      label494:
      localObject = this.DyO.viewId;
      break;
      label506:
      i = this.DsC.getAdRecSrc();
      break label56;
      label517:
      str1 = this.DyO.waidPkg;
      break label149;
      label529:
      j = 2;
      break label170;
      label534:
      localb1 = this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
      break label199;
      label549:
      localb2 = this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
      break label219;
      label564:
      bool = false;
      break label340;
      label570:
      ((k)localObject).fL(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    ZQ(i);
    if (!this.EHl)
    {
      cXa();
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
      if (this.EzN != null) {
        this.EzN.jkY = Util.currentTicks();
      }
      AppMethodBeat.o(99108);
      return;
      cXa();
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
        aW(getResources().getConfiguration().orientation, true);
      }
      this.isInit = true;
    }
    if ((this.Dob == 0) || (this.Doa == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.Dob = localDisplayMetrics.heightPixels;
      this.Doa = localDisplayMetrics.widthPixels;
    }
    if ((this.EHl) && (s.YS(this.fullPath)))
    {
      uF(false);
      this.EHl = false;
    }
    if (this.EzN != null) {
      this.EzN.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.qaD;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
        this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
        this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
        this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        if (localBundle == null) {
          this.DnT.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.DnT.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.qaE.a(SnsSightPlayerUI.this.DnT, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI
 * JD-Core Version:    0.7.0.1
 */