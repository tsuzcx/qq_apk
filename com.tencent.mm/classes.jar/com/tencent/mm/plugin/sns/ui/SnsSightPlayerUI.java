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
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.d.j;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.ad.d.m.d;
import com.tencent.mm.plugin.sns.ad.d.m.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, b.b
{
  private float Aal;
  private int Aam;
  private int Aan;
  private boolean AgJ;
  private boolean AgO;
  private boolean AgP;
  private boolean AgQ;
  private String AiA;
  private TextView AiB;
  private MMPinProgressBtn AiC;
  private com.tencent.mm.plugin.sns.storage.a AiD;
  private String AiE;
  private RelativeLayout AiF;
  View.OnCreateContextMenuListener AiG;
  private float aZk;
  private float aZl;
  private boolean cAX;
  public l contextMenuHelper;
  private byn dIQ;
  private int dLy;
  private int dnh;
  private String drH;
  private int duration;
  private boolean hII;
  private String hdP;
  private ImageView iUP;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private GestureDetector lsn;
  private VelocityTracker mVelocityTracker;
  Bundle oGn;
  com.tencent.mm.ui.tools.e oGo;
  private int oGp;
  private int oGq;
  private int oGr;
  private int oGs;
  com.tencent.mm.pluginsdk.ui.tools.h oHt;
  n.e obh;
  private com.tencent.mm.model.d ota;
  private int rwG;
  private TextView rzW;
  private boolean rzZ;
  private String thumbPath;
  private TextView ySI;
  private boolean ySJ;
  ViewGroup ySS;
  private int ySZ;
  private int ySd;
  private int yTa;
  public int yTh;
  private p yXF;
  private j zZB;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.zZB = new j("SnsSightPlayerUI");
    this.hdP = "";
    this.imagePath = "";
    this.drH = "";
    this.AiA = "";
    this.isAd = false;
    this.oHt = null;
    this.ySI = null;
    this.AiB = null;
    this.AiC = null;
    this.dnh = 0;
    this.duration = 0;
    this.dLy = 0;
    this.ySd = 0;
    this.rwG = 0;
    this.ySJ = false;
    this.AgJ = false;
    this.ySZ = 0;
    this.yTa = 0;
    this.cAX = false;
    this.rzZ = false;
    this.yXF = null;
    this.AiD = null;
    this.dIQ = null;
    this.thumbPath = "";
    this.AiE = "";
    this.rzW = null;
    this.isAnimated = false;
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.AgO = false;
    this.AgP = false;
    this.AgQ = false;
    this.Aal = 1.0F;
    this.Aam = 0;
    this.Aan = 0;
    this.hII = false;
    this.AiG = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (bt.aRe(com.tencent.mm.n.g.acA().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = com.tencent.mm.vfs.i.fv(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = com.tencent.mm.vfs.i.fv(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          ad.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(2131763770));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.bs.d.aIu("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousView = new eb();
            paramAnonymousView.dpg.doX = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            if (paramAnonymousView.dph.doF) {
              paramAnonymousContextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(2131755836));
            }
          }
          if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
            paramAnonymousContextMenu.add(0, 1, 0, SnsSightPlayerUI.this.getContext().getString(2131764022));
          }
          AppMethodBeat.o(99084);
          return;
        }
      }
    };
    this.obh = new n.e()
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
          paramAnonymousMenuItem = ag.dUe().aAa(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new cv();
          com.tencent.mm.plugin.sns.k.a.a((cv)localObject, paramAnonymousMenuItem);
          ((cv)localObject).dnG.activity = SnsSightPlayerUI.this;
          ((cv)localObject).dnG.dnM = 17;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            com.tencent.mm.plugin.sns.ad.d.m.a(m.d.zac, m.c.yZX, m.e.zaj, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new uh();
            ((uh)localObject).dIF.doX = paramAnonymousMenuItem.dYK();
            ((uh)localObject).dIF.dzb = com.tencent.mm.plugin.sns.data.q.n(paramAnonymousMenuItem);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          p localp = ag.dUe().aAa(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (localp != null) {
            ad.i("MicroMsg.SnsSightPlayerUI", "expose id " + localp.getSnsId());
          }
          if (localp == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localp != null) {
              break label368;
            }
          }
          label368:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localp.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.bs.d.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(99085);
            return;
            paramAnonymousMenuItem = localp.getSnsId();
            break;
          }
          SnsSightPlayerUI.v(SnsSightPlayerUI.this);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
          paramAnonymousMenuItem.putExtra("select_is_ret", true);
          paramAnonymousMenuItem.putExtra("mutil_select_is_ret", true);
          paramAnonymousMenuItem.putExtra("image_path", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.bs.d.c(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 4097);
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = ag.dUe().aAa(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dYl().HAT.GaP == 15) && ((byn)paramAnonymousMenuItem.dYl().HAT.GaQ.get(0) == null))
          {
            ad.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.bs.d.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.yTh = 0;
    AppMethodBeat.o(99100);
  }
  
  private void Rn(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (this.oHt.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.oHt.getDuration();
      }
      this.zZB.Py(this.duration);
      this.zZB.yZm.zas = bt.HI();
      locala = this.zZB.yZm;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.zar = paramInt;
      this.zZB.yZm.zaq = 2;
      ad.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.zZB.yZm.zar);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.yTa == 0) || (this.ySZ == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.yTa = ((DisplayMetrics)localObject).heightPixels;
      this.ySZ = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.ySS.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AiB.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.ySZ;
      localLayoutParams1.height = ((int)(this.ySZ * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.ySS.getId());
      findViewById(2131305896).setVisibility(0);
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.oHt).setLayoutParams(localLayoutParams1);
      if ((this.oHt instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.oHt).hw(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.ySI.setLayoutParams(localLayoutParams);
      this.ySS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.oHt).requestLayout();
      if (!paramBoolean) {
        Rn(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.ySZ;
      localLayoutParams1.width = ((int)(this.ySZ * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.ySS.getId());
      findViewById(2131305896).setVisibility(8);
    }
  }
  
  private void cxw()
  {
    AppMethodBeat.i(99104);
    ad.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.oHt.pause();
    this.oHt.onDetach();
    this.ota.ex(false);
    AppMethodBeat.o(99104);
  }
  
  private void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.oHt.start();
    this.duration = this.oHt.getDuration();
    ad.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.ota.a(this);
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (paramBoolean)
    {
      locala = this.zZB.yZm;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      locala.zar = i;
      this.zZB.yZm.zas = bt.HI();
      this.zZB.yZm.zaq = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void ays(String paramString) {}
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    ad.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!bt.isNullOrNil(paramString)) && (this.dIQ != null) && (paramString.equals(this.dIQ.Id)) && (com.tencent.mm.vfs.i.fv(this.hdP)))
    {
      this.zZB.yZe = 1;
      this.oHt.setVideoPath(this.hdP);
      rc(true);
      if (this.AiC != null) {
        this.AiC.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void bWL()
  {
    AppMethodBeat.i(99109);
    int k = this.ySS.getWidth();
    int j = this.ySS.getHeight();
    int i = j;
    if (this.oGr != 0)
    {
      i = j;
      if (this.oGs != 0) {
        i = (int)(k / this.oGr * this.oGs);
      }
    }
    this.oGo.jZ(k, i);
    this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
    if (this.Aal != 1.0D)
    {
      int m = al.ej(getContext());
      this.oGo.KIl = (1.0F / this.Aal);
      if ((this.Aam != 0) || (this.Aan != 0))
      {
        j = (int)(this.ySS.getWidth() / 2 * (1.0F - this.Aal));
        k = this.Aam;
        i = (int)((m + this.ySS.getHeight()) / 2 - i / 2 * this.Aal + this.Aan);
        this.oGo.kb(j + k, i);
      }
    }
    this.oGo.a(this.ySS, this.iUP, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(99083);
        new ap().post(new Runnable()
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
  
  public final void dTb() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.hII)
    {
      super.finish();
      this.hII = true;
    }
    AppMethodBeat.o(99102);
  }
  
  public int getForceOrientation()
  {
    return 7;
  }
  
  public int getLayoutId()
  {
    return 2131495587;
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
        Iterator localIterator = bt.U(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        dki localdki;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.dnh == 0)
          {
            localObject1 = ag.dUe().aAa(this.drH);
            if (localObject1 != null)
            {
              if (!w.vF(str2)) {
                break;
              }
              localObject2 = new ul();
              ((ul)localObject2).dIJ.dzb = com.tencent.mm.plugin.sns.data.q.n((p)localObject1);
              ((ul)localObject2).dIJ.doX = ((p)localObject1).dYK();
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.yXF.dYl();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.yXF.dRL();
          localdki = new dki();
          localdki.Gje = this.dIQ.AqM;
          localdki.hCe = this.dIQ.GSP;
          if (((TimeLineObject)localObject2).HAT.GaP != 15) {
            break label630;
          }
          localdki.hCk = this.AiD.dFy;
          localdki.hCl = ((TimeLineObject)localObject2).Id;
          if (!bt.isNullOrNil(this.dIQ.GST)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).HAQ;
          localdki.hCg = ((String)localObject1);
          if (!bt.isNullOrNil(this.dIQ.GSS)) {
            break label671;
          }
          localObject1 = this.dIQ.GSI;
          localdki.hCj = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvE == 0))
          {
            localdki.hCi = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvG;
            localdki.hCh = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvF;
          }
          if (localObject3 != null) {
            localdki.hCi = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zuE;
          }
          i = com.tencent.mm.plugin.sns.data.q.ayj(this.hdP);
          ad.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.hdP, this.imagePath, this.dIQ.GSP, Integer.valueOf(this.dIQ.AqM), localdki.hCj, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.dlD().a(this, str2, this.hdP, this.imagePath, 43, i, localdki, ((TimeLineObject)localObject2).zRz, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.dlD().hP(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dnh, 5, this.yXF.field_snsId, 12, 0));
        boolean bool = w.vF(str2);
        Object localObject2 = m.d.zac;
        if (bool)
        {
          localObject1 = m.c.yZZ;
          label544:
          localObject3 = m.e.zaj;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = com.tencent.mm.model.q.yS(str2);; i = 0)
        {
          com.tencent.mm.plugin.sns.ad.d.m.a((m.d)localObject2, (m.c)localObject1, (m.e)localObject3, i, this.yXF, this.dnh);
          break;
          localObject2 = new um();
          ((um)localObject2).dIK.dzb = com.tencent.mm.plugin.sns.data.q.n((p)localObject1);
          ((um)localObject2).dIK.doX = ((p)localObject1).dYK();
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          break label152;
          label630:
          localdki.hCk = ((TimeLineObject)localObject2).HAY.hCk;
          localdki.hCl = ((TimeLineObject)localObject2).HAY.hCl;
          break label245;
          label659:
          localObject1 = this.dIQ.GST;
          break label265;
          label671:
          localObject1 = this.dIQ.GSS;
          break label294;
          label683:
          i = com.tencent.mm.plugin.sns.data.q.ayj(this.hdP);
          ad.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.hdP, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.dlD().a(this, str2, this.hdP, this.imagePath, 43, i, ((TimeLineObject)localObject2).zRz, null);
          break label462;
          localObject1 = m.c.yZY;
          break label544;
        }
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dnh, 5, this.yXF.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    bWL();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.yTh);
    if (this.yTh == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    aE(paramConfiguration.orientation, false);
    this.yTh = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.dnh = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    ag.dTZ().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100017));
    }
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.oGn = paramBundle;
      this.ota = new com.tencent.mm.model.d();
      this.hdP = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.drH = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.yXF = ag.dUe().aAa(this.drH);
      if (!this.isAd) {
        break label338;
      }
      if (this.yXF != null) {
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
      this.dIQ = ((byn)this.yXF.dYl().HAT.GaQ.get(0));
      paramBundle = ao.jo(ag.getAccSnsPath(), this.dIQ.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.dIQ);
      this.AiE = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + com.tencent.mm.plugin.sns.data.q.d(this.dIQ));
    }
    label338:
    if (com.tencent.mm.s.a.Nb() != null) {
      com.tencent.mm.s.a.Nb().Wv();
    }
    if (this.yXF != null) {
      if (this.dnh == 2)
      {
        paramBundle = this.yXF.dYi();
        this.AiD = paramBundle;
        this.zZB.yZg = bt.HI();
        this.AiF = ((RelativeLayout)findViewById(2131298770));
        this.AiF.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            SnsSightPlayerUI.this.bWL();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(99078);
            return true;
          }
        });
        ad.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.abh() + " initView: fullpath:" + this.hdP + ", imagepath:" + this.imagePath);
        this.oGo = new com.tencent.mm.ui.tools.e(getContext());
        this.iUP = ((ImageView)findViewById(2131300336));
        this.ySI = ((TextView)findViewById(2131305896));
        this.AiC = ((MMPinProgressBtn)findViewById(2131304805));
        this.ySS = ((ViewGroup)findViewById(2131306317));
        this.oHt = t.hE(getContext());
        if ((this.oHt instanceof VideoSightView)) {
          ((VideoSightView)this.oHt).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.rzW = ((TextView)findViewById(2131304777));
        this.rzW.setTextColor(Color.parseColor("#888888"));
        this.ySS.addView((View)this.oHt, 0, paramBundle);
        this.AiB = ((TextView)findViewById(2131305813));
        this.AiB.setText("");
        if (!this.isAd) {
          this.AiB.setVisibility(8);
        }
        if (!this.isAd) {
          break label1317;
        }
        if (this.dIQ != null) {
          break label993;
        }
        this.rzW.setVisibility(8);
        label689:
        s.a(this.rzW, (VideoSightView)this.oHt);
        label703:
        this.oHt.setVideoCallback(new h.a()
        {
          public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
          public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final void onCompletion()
          {
            AppMethodBeat.i(99093);
            ad.d("MicroMsg.SnsSightPlayerUI", "on completion");
            if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
              SnsSightPlayerUI.k(SnsSightPlayerUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(99090);
                  if (SnsSightPlayerUI.k(SnsSightPlayerUI.this).getVisibility() != 0)
                  {
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).setVisibility(0);
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.getContext(), 2130772047));
                  }
                  AppMethodBeat.o(99090);
                }
              });
            }
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).setLoop(true);
            com.tencent.mm.plugin.sns.ad.d.a.a locala = SnsSightPlayerUI.l(SnsSightPlayerUI.this).yZm;
            locala.zan += 1;
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
            AppMethodBeat.o(99093);
          }
          
          public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(99092);
            ad.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).stop();
            if (SnsSightPlayerUI.h(SnsSightPlayerUI.this))
            {
              AppMethodBeat.o(99092);
              return;
            }
            SnsSightPlayerUI.i(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dPZ() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bt.bI(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(2131306415);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.xsv);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                n.a(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(2131759030));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  ad.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  com.tencent.mm.ui.base.h.l(SnsSightPlayerUI.this.getContext(), 2131758931, 2131758932);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
          
          public final void ta()
          {
            AppMethodBeat.i(99091);
            ad.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.abh() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
        });
        findViewById(2131306317).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            SnsSightPlayerUI.this.bWL();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.oHt).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            SnsSightPlayerUI.this.bWL();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99095);
          }
        });
        this.lsn = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198397);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198397);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198396);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198396);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
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
            AppMethodBeat.i(198395);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198395);
            return bool;
          }
        });
        ((View)this.oHt).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99098);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = SnsSightPlayerUI.n(SnsSightPlayerUI.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(99098);
                return false;
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, paramAnonymousMotionEvent.getX());
                SnsSightPlayerUI.b(SnsSightPlayerUI.this, paramAnonymousMotionEvent.getY());
                continue;
                if (SnsSightPlayerUI.p(SnsSightPlayerUI.this))
                {
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.ySS.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.ySS.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.oHt, paramAnonymousView.AiG, paramAnonymousView.obh);
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
                    SnsSightPlayerUI.this.bWL();
                    SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
              float f1 = 1.0F - f3 / SnsSightPlayerUI.this.ySS.getHeight();
              if (f1 > 1.0F)
              {
                f1 = 1.0F;
                label637:
                if (((j > 0) && (f1 < SnsSightPlayerUI.s(SnsSightPlayerUI.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  SnsSightPlayerUI.a(SnsSightPlayerUI.this, (int)f2);
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, (int)f3);
                  SnsSightPlayerUI.c(SnsSightPlayerUI.this, f1);
                  if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
                    SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(8);
                  }
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.ySS.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.ySS.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(f1);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(f1);
                  SnsSightPlayerUI.t(SnsSightPlayerUI.this).setAlpha(f1);
                }
                SnsSightPlayerUI.c(SnsSightPlayerUI.this, true);
                label821:
                if (f3 <= 200.0F) {
                  break label936;
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
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(99098);
              return true;
              break label637;
              SnsSightPlayerUI.c(SnsSightPlayerUI.this, false);
              break label821;
              label936:
              if (f3 > 10.0F) {
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, true);
              }
            }
          }
        });
        if (!com.tencent.mm.vfs.i.fv(this.hdP)) {
          break label1329;
        }
        if (this.hdP != null)
        {
          this.oHt.stop();
          this.oHt.setVideoPath(this.hdP);
        }
        this.AiC.setVisibility(8);
      }
    }
    for (this.zZB.yZe = 1;; this.zZB.yZe = 0)
    {
      ad.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new xc();
      paramBundle.dLv.type = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new l(getContext());
      }
      this.contextMenuHelper.a((View)this.oHt, this.AiG, this.obh);
      ((View)this.oHt).post(new Runnable()
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
      paramBundle = this.yXF.dRK();
      break;
      paramBundle = null;
      break;
      label993:
      if (bt.isNullOrNil(this.dIQ.GSP))
      {
        ad.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.yXF.dYl();
        Object localObject2 = this.yXF.dRL();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvF;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zvG;
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
        {
          this.rzW.setVisibility(0);
          this.rzW.setText((CharSequence)localObject1);
          this.rzW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
              Object localObject2;
              if (m.b.yZR.value != 0)
              {
                localObject1 = m.a.yZL;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label259;
                }
              }
              label259:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dFy)
              {
                com.tencent.mm.plugin.sns.ad.d.m.a((m.a)localObject1, (String)localObject2, paramAnonymousView, 1, m.b.yZR.value, paramBundle.nDo, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.zRz);
                localObject1 = this.rAk;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).dFy);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.c.a.iRG.i(this.val$intent, SnsSightPlayerUI.this);
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
        this.rzW.setVisibility(8);
        break label689;
      }
      localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (this.dIQ.AqM / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(this.dIQ.AqM / 60) });
      }
      localObject1 = paramBundle;
      if (this.dIQ.AqM % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(this.dIQ.AqM % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.rzW.setText(paramBundle);
      this.rzW.setVisibility(0);
      this.rzW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).QM(32)) {
            com.tencent.mm.plugin.sns.ad.d.m.a(m.b.yZR, m.a.yZK, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          localObject1 = new Intent();
          paramAnonymousView = ao.jo(ag.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = com.tencent.mm.plugin.sns.data.q.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            ad.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).GSP);
            if (!bt.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).GSS)) {
              break label790;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).GSI;
            label237:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).aQj);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dYl();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label804;
            }
            paramAnonymousView = "";
            label320:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", m.b.yZR.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).nDo);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).zRz);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).AqM);
            if (!bt.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).GST)) {
              break label818;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).HAQ;
            label431:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dRL();
            if ((paramAnonymousView != null) && (paramAnonymousView.zvE == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.zvF);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.zvG);
            }
            localObject2 = ag.dUe().aAa(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label832;
            }
            paramAnonymousView = com.tencent.mm.modelsns.e.pV(747);
            label517:
            paramAnonymousView.Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject2)).pY(((p)localObject2).field_type).eS(true).Gs(((p)localObject2).dYT()).pY(SnsSightPlayerUI.d(SnsSightPlayerUI.this).AqM);
            paramAnonymousView.aLk();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label842;
            }
          }
          label790:
          label804:
          label818:
          label832:
          label842:
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pV(748);; paramAnonymousView = com.tencent.mm.modelsns.e.pW(748))
          {
            paramAnonymousView.Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject2)).pY(((p)localObject2).field_type).eS(true).Gs(((p)localObject2).dYT()).pY(SnsSightPlayerUI.d(SnsSightPlayerUI.this).AqM);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((p)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new ub();
              paramAnonymousView.dIz.isStart = true;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).GSS;
            break label237;
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dFy;
            break label320;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).GST;
            break label431;
            paramAnonymousView = com.tencent.mm.modelsns.e.pW(747);
            break label517;
          }
        }
      });
      break label689;
      label1317:
      this.rzW.setVisibility(8);
      break label703;
      label1329:
      ag.dTZ().a(this.dIQ, 6, null, bj.ILV);
      this.AiC.setVisibility(0);
      this.AiC.fLr();
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
    com.tencent.mm.bx.b localb1;
    label199:
    com.tencent.mm.bx.b localb2;
    if (this.isAd)
    {
      if (this.yXF != null) {
        break label496;
      }
      localObject = "";
      if (this.yXF != null)
      {
        String str2 = this.zZB.dRz();
        if (this.yXF != null) {
          break label508;
        }
        i = 0;
        long l2 = this.zZB.yZf - this.zZB.imY;
        long l1 = l2;
        if (l2 < 0L)
        {
          ad.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.zZB.yZf), Long.valueOf(this.zZB.imY) });
          l1 = this.zZB.yZf;
        }
        int k = (int)l1;
        if (this.AiD != null) {
          break label519;
        }
        str1 = "";
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.ajB().gAO;
        if (this.dnh != 0) {
          break label531;
        }
        j = 1;
        int m = this.zZB.yZf;
        if (this.dnh != 2) {
          break label536;
        }
        localb1 = this.yXF.dYU().dYp();
        if (this.dnh != 2) {
          break label551;
        }
        localb2 = this.yXF.dYU().dYq();
        label219:
        localq.a(new com.tencent.mm.plugin.sns.ad.d.f((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    ad.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.yXF != null) && (this.yXF.QM(32))) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.b.yZR, m.a.yZM, this.yXF, this.dnh);
    }
    ag.dTZ().b(this);
    Object localObject = com.tencent.mm.modelsns.e.w(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label572;
      }
      if (bt.isNullOrNil(this.dIQ.GSP)) {
        break label566;
      }
      label342:
      ((com.tencent.mm.modelsns.e)localObject).eS(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.e)localObject).update();
      ((com.tencent.mm.modelsns.e)localObject).aLk();
      if (com.tencent.mm.s.a.Nb() != null) {
        com.tencent.mm.s.a.Nb().Wu();
      }
      if (this.oHt != null)
      {
        this.oHt.setVideoCallback(null);
        this.oHt.stop();
        this.oHt.onDetach();
      }
      if (!this.ySJ)
      {
        localObject = new xc();
        ((xc)localObject).dLv.type = 0;
        ((xc)localObject).dLv.dLw = this.ySd;
        ((xc)localObject).dLv.dLx = this.rwG;
        ((xc)localObject).dLv.dLy = this.dLy;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      this.ota.ex(false);
      AppMethodBeat.o(99105);
      return;
      label496:
      localObject = this.AiD.aQj;
      break;
      label508:
      i = this.yXF.dYV();
      break label56;
      label519:
      str1 = this.AiD.zvb;
      break label149;
      label531:
      j = 2;
      break label170;
      label536:
      localb1 = this.yXF.dYU().dYn();
      break label199;
      label551:
      localb2 = this.yXF.dYU().dYo();
      break label219;
      label566:
      bool = false;
      break label342;
      label572:
      ((com.tencent.mm.modelsns.e)localObject).eS(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ad.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    Rn(i);
    if (!this.AgJ)
    {
      cxw();
      ad.v("check", "onclick");
      new ap().post(new Runnable()
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
      if (this.zZB != null) {
        this.zZB.imX = bt.HI();
      }
      AppMethodBeat.o(99108);
      return;
      cxw();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.cAX)
    {
      ad.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        aE(getResources().getConfiguration().orientation, true);
      }
      this.cAX = true;
    }
    if ((this.yTa == 0) || (this.ySZ == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.yTa = localDisplayMetrics.heightPixels;
      this.ySZ = localDisplayMetrics.widthPixels;
    }
    if ((this.AgJ) && (com.tencent.mm.vfs.i.fv(this.hdP)))
    {
      rc(false);
      this.AgJ = false;
    }
    if (this.zZB != null) {
      this.zZB.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.oGn;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.oGp = getIntent().getIntExtra("img_gallery_top", 0);
        this.oGq = getIntent().getIntExtra("img_gallery_left", 0);
        this.oGr = getIntent().getIntExtra("img_gallery_width", 0);
        this.oGs = getIntent().getIntExtra("img_gallery_height", 0);
        this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
        if (localBundle == null) {
          this.ySS.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.ySS.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.oGo.a(SnsSightPlayerUI.this.ySS, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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