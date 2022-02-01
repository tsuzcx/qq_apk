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
import com.tencent.mm.av.i;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.e.n;
import com.tencent.mm.plugin.sns.ad.e.n.a;
import com.tencent.mm.plugin.sns.ad.e.n.b;
import com.tencent.mm.plugin.sns.ad.e.n.c;
import com.tencent.mm.plugin.sns.ad.e.n.d;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, c.b
{
  private com.tencent.mm.plugin.sns.ad.e.k AqO;
  private int ArA;
  private float Ary;
  private int Arz;
  private boolean AxV;
  private boolean Aya;
  private boolean Ayb;
  private boolean Ayc;
  private String AzM;
  private TextView AzN;
  private MMPinProgressBtn AzO;
  private String AzP;
  private RelativeLayout AzQ;
  View.OnCreateContextMenuListener AzR;
  private float aZk;
  private float aZl;
  private boolean cBE;
  public l contextMenuHelper;
  private bzh dKe;
  private int dMN;
  private int doj;
  private String dsN;
  private int duration;
  private boolean hLB;
  private String hgD;
  private ImageView iXI;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private GestureDetector lwM;
  private VelocityTracker mVelocityTracker;
  Bundle oMP;
  com.tencent.mm.ui.tools.e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  com.tencent.mm.pluginsdk.ui.tools.h oNV;
  com.tencent.mm.ui.base.n.e ogY;
  private com.tencent.mm.model.d ozB;
  private int rES;
  private TextView rIh;
  private boolean rIk;
  private String thumbPath;
  private TextView ziS;
  private boolean ziT;
  private int zin;
  ViewGroup zjc;
  private int zjj;
  private int zjk;
  public int zjr;
  private p znm;
  private com.tencent.mm.plugin.sns.storage.a zrN;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.AqO = new com.tencent.mm.plugin.sns.ad.e.k("SnsSightPlayerUI");
    this.hgD = "";
    this.imagePath = "";
    this.dsN = "";
    this.AzM = "";
    this.isAd = false;
    this.oNV = null;
    this.ziS = null;
    this.AzN = null;
    this.AzO = null;
    this.doj = 0;
    this.duration = 0;
    this.dMN = 0;
    this.zin = 0;
    this.rES = 0;
    this.ziT = false;
    this.AxV = false;
    this.zjj = 0;
    this.zjk = 0;
    this.cBE = false;
    this.rIk = false;
    this.znm = null;
    this.zrN = null;
    this.dKe = null;
    this.thumbPath = "";
    this.AzP = "";
    this.rIh = null;
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.Aya = false;
    this.Ayb = false;
    this.Ayc = false;
    this.Ary = 1.0F;
    this.Arz = 0;
    this.ArA = 0;
    this.hLB = false;
    this.AzR = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (bu.aSB(com.tencent.mm.n.g.acL().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = com.tencent.mm.vfs.o.fB(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = com.tencent.mm.vfs.o.fB(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          ae.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(2131763770));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.d.aJN("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousView = new ec();
            paramAnonymousView.dql.dqc = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            if (paramAnonymousView.dqm.dpK) {
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
    this.ogY = new com.tencent.mm.ui.base.n.e()
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
          paramAnonymousMenuItem = ah.dXE().aBr(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new cw();
          com.tencent.mm.plugin.sns.k.a.a((cw)localObject, paramAnonymousMenuItem);
          ((cw)localObject).doL.activity = SnsSightPlayerUI.this;
          ((cw)localObject).doL.doR = 17;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            n.a(n.d.zqD, n.c.zqy, com.tencent.mm.plugin.sns.ad.e.n.e.zqK, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new ul();
            ((ul)localObject).dJT.dqc = paramAnonymousMenuItem.eco();
            ((ul)localObject).dJT.dAg = com.tencent.mm.plugin.sns.data.r.o(paramAnonymousMenuItem);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          p localp = ah.dXE().aBr(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (localp != null) {
            ae.i("MicroMsg.SnsSightPlayerUI", "expose id " + localp.getSnsId());
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
            com.tencent.mm.br.d.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
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
          com.tencent.mm.br.d.c(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 4097);
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = ah.dXE().aBr(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.ebP().HUG.Gtw == 15) && ((bzh)paramAnonymousMenuItem.ebP().HUG.Gtx.get(0) == null))
          {
            ae.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.d.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.zjr = 0;
    AppMethodBeat.o(99100);
  }
  
  private void RU(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.e.a.a locala;
    if (this.oNV.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.oNV.getDuration();
      }
      this.AqO.Qf(this.duration);
      this.AqO.zpN.zqT = bu.HQ();
      locala = this.AqO.zpN;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.zqS = paramInt;
      this.AqO.zpN.zqR = 2;
      ae.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.AqO.zpN.zqS);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void aH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.zjk == 0) || (this.zjj == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.zjk = ((DisplayMetrics)localObject).heightPixels;
      this.zjj = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.zjc.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.AzN.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.zjj;
      localLayoutParams1.height = ((int)(this.zjj * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.zjc.getId());
      findViewById(2131305896).setVisibility(0);
    }
    for (;;)
    {
      ae.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.oNV).setLayoutParams(localLayoutParams1);
      if ((this.oNV instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.oNV).hy(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.ziS.setLayoutParams(localLayoutParams);
      this.zjc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.oNV).requestLayout();
      if (!paramBoolean) {
        RU(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.zjj;
      localLayoutParams1.width = ((int)(this.zjj * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.zjc.getId());
      findViewById(2131305896).setVisibility(8);
    }
  }
  
  private void cyX()
  {
    AppMethodBeat.i(99104);
    ae.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.oNV.pause();
    this.oNV.onDetach();
    this.ozB.ez(false);
    AppMethodBeat.o(99104);
  }
  
  private void rj(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.oNV.start();
    this.duration = this.oNV.getDuration();
    ae.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.ozB.a(this);
    com.tencent.mm.plugin.sns.ad.e.a.a locala;
    if (paramBoolean)
    {
      locala = this.AqO.zpN;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      locala.zqS = i;
      this.AqO.zpN.zqT = bu.HQ();
      this.AqO.zpN.zqR = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final void azJ(String paramString) {}
  
  public final void bQ(String paramString, boolean paramBoolean) {}
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    ae.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!bu.isNullOrNil(paramString)) && (this.dKe != null) && (paramString.equals(this.dKe.Id)) && (com.tencent.mm.vfs.o.fB(this.hgD)))
    {
      this.AqO.zpF = 1;
      this.oNV.setVideoPath(this.hgD);
      rj(true);
      if (this.AzO != null) {
        this.AzO.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(99109);
    int k = this.zjc.getWidth();
    int j = this.zjc.getHeight();
    int i = j;
    if (this.oMT != 0)
    {
      i = j;
      if (this.oMU != 0) {
        i = (int)(k / this.oMT * this.oMU);
      }
    }
    this.oMQ.kg(k, i);
    this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
    if (this.Ary != 1.0D)
    {
      int m = al.en(getContext());
      this.oMQ.LeF = (1.0F / this.Ary);
      if ((this.Arz != 0) || (this.ArA != 0))
      {
        j = (int)(this.zjc.getWidth() / 2 * (1.0F - this.Ary));
        k = this.Arz;
        i = (int)((m + this.zjc.getHeight()) / 2 - i / 2 * this.Ary + this.ArA);
        this.oMQ.ki(j + k, i);
      }
    }
    this.oMQ.a(this.zjc, this.iXI, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(99083);
        new aq().post(new Runnable()
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
  
  public final void dWB() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.hLB)
    {
      super.finish();
      this.hLB = true;
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
        Iterator localIterator = bu.U(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        dld localdld;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.doj == 0)
          {
            localObject1 = ah.dXE().aBr(this.dsN);
            if (localObject1 != null)
            {
              if (!x.wb(str2)) {
                break;
              }
              localObject2 = new up();
              ((up)localObject2).dJX.dAg = com.tencent.mm.plugin.sns.data.r.o((p)localObject1);
              ((up)localObject2).dJX.dqc = ((p)localObject1).eco();
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.znm.ebP();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.znm.dVj();
          localdld = new dld();
          localdld.GBN = this.dKe.AIa;
          localdld.hET = this.dKe.Hmq;
          if (((TimeLineObject)localObject2).HUG.Gtw != 15) {
            break label630;
          }
          localdld.hEZ = this.zrN.dGD;
          localdld.hFa = ((TimeLineObject)localObject2).Id;
          if (!bu.isNullOrNil(this.dKe.Hmu)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).HUD;
          localdld.hEV = ((String)localObject1);
          if (!bu.isNullOrNil(this.dKe.Hmt)) {
            break label671;
          }
          localObject1 = this.dKe.Hmj;
          localdld.hEY = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zMZ == 0))
          {
            localdld.hEX = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNb;
            localdld.hEW = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNa;
          }
          if (localObject3 != null) {
            localdld.hEX = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zLV;
          }
          i = com.tencent.mm.plugin.sns.data.r.azA(this.hgD);
          ae.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.hgD, this.imagePath, this.dKe.Hmq, Integer.valueOf(this.dKe.AIa), localdld.hEY, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.doC().a(this, str2, this.hgD, this.imagePath, 43, i, localdld, ((TimeLineObject)localObject2).AiG, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.doC().hW(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(this.doj, 5, this.znm.field_snsId, 12, 0));
        boolean bool = x.wb(str2);
        Object localObject2 = n.d.zqD;
        if (bool)
        {
          localObject1 = n.c.zqA;
          label544:
          localObject3 = com.tencent.mm.plugin.sns.ad.e.n.e.zqK;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = com.tencent.mm.model.r.zC(str2);; i = 0)
        {
          n.a((n.d)localObject2, (n.c)localObject1, (com.tencent.mm.plugin.sns.ad.e.n.e)localObject3, i, this.znm, this.doj);
          break;
          localObject2 = new uq();
          ((uq)localObject2).dJY.dAg = com.tencent.mm.plugin.sns.data.r.o((p)localObject1);
          ((uq)localObject2).dJY.dqc = ((p)localObject1).eco();
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          break label152;
          label630:
          localdld.hEZ = ((TimeLineObject)localObject2).HUL.hEZ;
          localdld.hFa = ((TimeLineObject)localObject2).HUL.hFa;
          break label245;
          label659:
          localObject1 = this.dKe.Hmu;
          break label265;
          label671:
          localObject1 = this.dKe.Hmt;
          break label294;
          label683:
          i = com.tencent.mm.plugin.sns.data.r.azA(this.hgD);
          ae.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.hgD, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.doC().a(this, str2, this.hgD, this.imagePath, 43, i, ((TimeLineObject)localObject2).AiG, null);
          break label462;
          localObject1 = n.c.zqz;
          break label544;
        }
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(this.doj, 5, this.znm.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    bYa();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.zjr);
    if (this.zjr == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    aH(paramConfiguration.orientation, false);
    this.zjr = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.doj = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    ah.dXz().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100017));
    }
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.oMP = paramBundle;
      this.ozB = new com.tencent.mm.model.d();
      this.hgD = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.dsN = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.znm = ah.dXE().aBr(this.dsN);
      if (!this.isAd) {
        break label338;
      }
      if (this.znm != null) {
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
      this.dKe = ((bzh)this.znm.ebP().HUG.Gtx.get(0));
      paramBundle = ap.jv(ah.getAccSnsPath(), this.dKe.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.r.j(this.dKe);
      this.AzP = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + com.tencent.mm.plugin.sns.data.r.d(this.dKe));
    }
    label338:
    if (com.tencent.mm.r.a.MW() != null) {
      com.tencent.mm.r.a.MW().WD();
    }
    if (this.znm != null) {
      if (this.doj == 2)
      {
        paramBundle = this.znm.ebM();
        this.zrN = paramBundle;
        this.AqO.zpH = bu.HQ();
        this.AzQ = ((RelativeLayout)findViewById(2131298770));
        this.AzQ.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            SnsSightPlayerUI.this.bYa();
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(99078);
            return true;
          }
        });
        ae.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.abq() + " initView: fullpath:" + this.hgD + ", imagepath:" + this.imagePath);
        this.oMQ = new com.tencent.mm.ui.tools.e(getContext());
        this.iXI = ((ImageView)findViewById(2131300336));
        this.ziS = ((TextView)findViewById(2131305896));
        this.AzO = ((MMPinProgressBtn)findViewById(2131304805));
        this.zjc = ((ViewGroup)findViewById(2131306317));
        this.oNV = t.hK(getContext());
        if ((this.oNV instanceof VideoSightView)) {
          ((VideoSightView)this.oNV).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.rIh = ((TextView)findViewById(2131304777));
        this.rIh.setTextColor(Color.parseColor("#888888"));
        this.zjc.addView((View)this.oNV, 0, paramBundle);
        this.AzN = ((TextView)findViewById(2131305813));
        this.AzN.setText("");
        if (!this.isAd) {
          this.AzN.setVisibility(8);
        }
        if (!this.isAd) {
          break label1317;
        }
        if (this.dKe != null) {
          break label993;
        }
        this.rIh.setVisibility(8);
        label689:
        s.a(this.rIh, (VideoSightView)this.oNV);
        label703:
        this.oNV.setVideoCallback(new h.a()
        {
          public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
          public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final void onCompletion()
          {
            AppMethodBeat.i(99093);
            ae.d("MicroMsg.SnsSightPlayerUI", "on completion");
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
            com.tencent.mm.plugin.sns.ad.e.a.a locala = SnsSightPlayerUI.l(SnsSightPlayerUI.this).zpN;
            locala.zqO += 1;
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
            AppMethodBeat.o(99093);
          }
          
          public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(99092);
            ae.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).stop();
            if (SnsSightPlayerUI.h(SnsSightPlayerUI.this))
            {
              AppMethodBeat.o(99092);
              return;
            }
            SnsSightPlayerUI.i(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dTw() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bu.bI(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(2131306415);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.xIs);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                com.tencent.mm.sdk.platformtools.o.a(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.k(str), "video/*");
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(2131759030));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  ae.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
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
            ae.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.abq() + " onPrepared");
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            SnsSightPlayerUI.this.bYa();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.oNV).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            SnsSightPlayerUI.this.bYa();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99095);
          }
        });
        this.lwM = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(219939);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219939);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(219938);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219938);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
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
            AppMethodBeat.i(219937);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219937);
            return bool;
          }
        });
        ((View)this.oNV).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99098);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = SnsSightPlayerUI.n(SnsSightPlayerUI.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.zjc.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.zjc.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.oNV, paramAnonymousView.AzR, paramAnonymousView.ogY);
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
                    SnsSightPlayerUI.this.bYa();
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
              float f1 = 1.0F - f3 / SnsSightPlayerUI.this.zjc.getHeight();
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.zjc.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.zjc.getHeight() / 2);
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
        if (!com.tencent.mm.vfs.o.fB(this.hgD)) {
          break label1329;
        }
        if (this.hgD != null)
        {
          this.oNV.stop();
          this.oNV.setVideoPath(this.hgD);
        }
        this.AzO.setVisibility(8);
      }
    }
    for (this.AqO.zpF = 1;; this.AqO.zpF = 0)
    {
      ae.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new xg();
      paramBundle.dMK.type = 1;
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new l(getContext());
      }
      this.contextMenuHelper.a((View)this.oNV, this.AzR, this.ogY);
      ((View)this.oNV).post(new Runnable()
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
      paramBundle = this.znm.dVi();
      break;
      paramBundle = null;
      break;
      label993:
      if (bu.isNullOrNil(this.dKe.Hmq))
      {
        ae.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.znm.ebP();
        Object localObject2 = this.znm.dVj();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNa;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).zNb;
        if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2)))
        {
          this.rIh.setVisibility(0);
          this.rIh.setText((CharSequence)localObject1);
          this.rIh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
              Object localObject2;
              if (n.b.zqs.value != 0)
              {
                localObject1 = n.a.zqm;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label259;
                }
              }
              label259:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dGD)
              {
                n.a((n.a)localObject1, (String)localObject2, paramAnonymousView, 1, n.b.zqs.value, paramBundle.nIJ, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.AiG);
                localObject1 = this.rIv;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.r.jo((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).dGD);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.c.a.iUz.i(this.val$intent, SnsSightPlayerUI.this);
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
        this.rIh.setVisibility(8);
        break label689;
      }
      localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (this.dKe.AIa / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(this.dKe.AIa / 60) });
      }
      localObject1 = paramBundle;
      if (this.dKe.AIa % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(this.dKe.AIa % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.rIh.setText(paramBundle);
      this.rIh.setVisibility(0);
      this.rIh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).Rt(32)) {
            n.a(n.b.zqs, n.a.zql, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          localObject1 = new Intent();
          paramAnonymousView = ap.jv(ah.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = com.tencent.mm.plugin.sns.data.r.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxf, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            ae.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmq);
            if (!bu.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmt)) {
              break label790;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmj;
            label237:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).aQj);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).ebP();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label804;
            }
            paramAnonymousView = "";
            label320:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", n.b.zqs.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).nIJ);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).AiG);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).AIa);
            if (!bu.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmu)) {
              break label818;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).HUD;
            label431:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dVj();
            if ((paramAnonymousView != null) && (paramAnonymousView.zMZ == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.zNa);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.zNb);
            }
            localObject2 = ah.dXE().aBr(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label832;
            }
            paramAnonymousView = com.tencent.mm.modelsns.e.pY(747);
            label517:
            paramAnonymousView.GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject2)).qb(((p)localObject2).field_type).eV(true).GU(((p)localObject2).ecx()).qb(SnsSightPlayerUI.d(SnsSightPlayerUI.this).AIa);
            paramAnonymousView.aLH();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label842;
            }
          }
          label790:
          label804:
          label818:
          label832:
          label842:
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pY(748);; paramAnonymousView = com.tencent.mm.modelsns.e.pZ(748))
          {
            paramAnonymousView.GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject2)).qb(((p)localObject2).field_type).eV(true).GU(((p)localObject2).ecx()).qb(SnsSightPlayerUI.d(SnsSightPlayerUI.this).AIa);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((p)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new ud();
              paramAnonymousView.dJG.isStart = true;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmt;
            break label237;
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dGD;
            break label320;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Hmu;
            break label431;
            paramAnonymousView = com.tencent.mm.modelsns.e.pZ(747);
            break label517;
          }
        }
      });
      break label689;
      label1317:
      this.rIh.setVisibility(8);
      break label703;
      label1329:
      ah.dXz().a(this.dKe, 6, null, bk.JgC);
      this.AzO.setVisibility(0);
      this.AzO.fPL();
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
      if (this.znm != null) {
        break label496;
      }
      localObject = "";
      if (this.znm != null)
      {
        String str2 = this.AqO.dUX();
        if (this.znm != null) {
          break label508;
        }
        i = 0;
        long l2 = this.AqO.zpG - this.AqO.ipS;
        long l1 = l2;
        if (l2 < 0L)
        {
          ae.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.AqO.zpG), Long.valueOf(this.AqO.ipS) });
          l1 = this.AqO.zpG;
        }
        int k = (int)l1;
        if (this.zrN != null) {
          break label519;
        }
        str1 = "";
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.ajQ().gDv;
        if (this.doj != 0) {
          break label531;
        }
        j = 1;
        int m = this.AqO.zpG;
        if (this.doj != 2) {
          break label536;
        }
        localb1 = this.znm.ecy().ebT();
        if (this.doj != 2) {
          break label551;
        }
        localb2 = this.znm.ecy().ebU();
        label219:
        localq.a(new com.tencent.mm.plugin.sns.ad.e.f((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    ae.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.znm != null) && (this.znm.Rt(32))) {
      n.a(n.b.zqs, n.a.zqn, this.znm, this.doj);
    }
    ah.dXz().b(this);
    Object localObject = com.tencent.mm.modelsns.e.w(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label572;
      }
      if (bu.isNullOrNil(this.dKe.Hmq)) {
        break label566;
      }
      label342:
      ((com.tencent.mm.modelsns.e)localObject).eV(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.e)localObject).update();
      ((com.tencent.mm.modelsns.e)localObject).aLH();
      if (com.tencent.mm.r.a.MW() != null) {
        com.tencent.mm.r.a.MW().WC();
      }
      if (this.oNV != null)
      {
        this.oNV.setVideoCallback(null);
        this.oNV.stop();
        this.oNV.onDetach();
      }
      if (!this.ziT)
      {
        localObject = new xg();
        ((xg)localObject).dMK.type = 0;
        ((xg)localObject).dMK.dML = this.zin;
        ((xg)localObject).dMK.dMM = this.rES;
        ((xg)localObject).dMK.dMN = this.dMN;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      this.ozB.ez(false);
      AppMethodBeat.o(99105);
      return;
      label496:
      localObject = this.zrN.aQj;
      break;
      label508:
      i = this.znm.ecz();
      break label56;
      label519:
      str1 = this.zrN.zMw;
      break label149;
      label531:
      j = 2;
      break label170;
      label536:
      localb1 = this.znm.ecy().ebR();
      break label199;
      label551:
      localb2 = this.znm.ecy().ebS();
      break label219;
      label566:
      bool = false;
      break label342;
      label572:
      ((com.tencent.mm.modelsns.e)localObject).eV(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ae.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    RU(i);
    if (!this.AxV)
    {
      cyX();
      ae.v("check", "onclick");
      new aq().post(new Runnable()
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
      if (this.AqO != null) {
        this.AqO.ipR = bu.HQ();
      }
      AppMethodBeat.o(99108);
      return;
      cyX();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.cBE)
    {
      ae.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        aH(getResources().getConfiguration().orientation, true);
      }
      this.cBE = true;
    }
    if ((this.zjk == 0) || (this.zjj == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.zjk = localDisplayMetrics.heightPixels;
      this.zjj = localDisplayMetrics.widthPixels;
    }
    if ((this.AxV) && (com.tencent.mm.vfs.o.fB(this.hgD)))
    {
      rj(false);
      this.AxV = false;
    }
    if (this.AqO != null) {
      this.AqO.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.oMP;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.oMR = getIntent().getIntExtra("img_gallery_top", 0);
        this.oMS = getIntent().getIntExtra("img_gallery_left", 0);
        this.oMT = getIntent().getIntExtra("img_gallery_width", 0);
        this.oMU = getIntent().getIntExtra("img_gallery_height", 0);
        this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
        if (localBundle == null) {
          this.zjc.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.zjc.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.oMQ.a(SnsSightPlayerUI.this.zjc, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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