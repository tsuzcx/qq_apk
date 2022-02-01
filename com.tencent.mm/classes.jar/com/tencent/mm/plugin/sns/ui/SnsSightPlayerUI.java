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
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.ad.d.m.d;
import com.tencent.mm.plugin.sns.ad.d.m.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, b.b
{
  private float aOQ;
  private float aOR;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  private boolean cqf;
  private int dbL;
  private String dgl;
  private int duration;
  private btz dwE;
  private int dzm;
  private String gKe;
  private boolean hqq;
  private ImageView iBF;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private GestureDetector kVo;
  private VelocityTracker mVelocityTracker;
  n.d nAc;
  private com.tencent.mm.model.d nQt;
  Bundle ocU;
  com.tencent.mm.ui.tools.e ocV;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  com.tencent.mm.pluginsdk.ui.tools.h odZ;
  private int qME;
  private TextView qPW;
  private boolean qPZ;
  private String thumbPath;
  private TextView xDY;
  private boolean xDZ;
  private int xDt;
  ViewGroup xEi;
  private int xEp;
  private int xEq;
  public int xEx;
  private p xIq;
  private float yIR;
  private int yIS;
  private int yIT;
  private com.tencent.mm.plugin.sns.ad.d.j yIh;
  private boolean yPn;
  private boolean yPs;
  private boolean yPt;
  private boolean yPu;
  private String yRa;
  private TextView yRb;
  private MMPinProgressBtn yRc;
  private com.tencent.mm.plugin.sns.storage.a yRd;
  private String yRe;
  private RelativeLayout yRf;
  View.OnCreateContextMenuListener yRg;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.yIh = new com.tencent.mm.plugin.sns.ad.d.j("SnsSightPlayerUI");
    this.gKe = "";
    this.imagePath = "";
    this.dgl = "";
    this.yRa = "";
    this.isAd = false;
    this.odZ = null;
    this.xDY = null;
    this.yRb = null;
    this.yRc = null;
    this.dbL = 0;
    this.duration = 0;
    this.dzm = 0;
    this.xDt = 0;
    this.qME = 0;
    this.xDZ = false;
    this.yPn = false;
    this.xEp = 0;
    this.xEq = 0;
    this.cqf = false;
    this.qPZ = false;
    this.xIq = null;
    this.yRd = null;
    this.dwE = null;
    this.thumbPath = "";
    this.yRe = "";
    this.qPW = null;
    this.isAnimated = false;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.aOQ = 0.0F;
    this.aOR = 0.0F;
    this.yPs = false;
    this.yPt = false;
    this.yPu = false;
    this.yIR = 1.0F;
    this.yIS = 0;
    this.yIT = 0;
    this.hqq = false;
    this.yRg = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (bs.aLy(com.tencent.mm.m.g.ZY().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = i.eA(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = i.eA(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          ac.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(2131763770));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.d.aCT("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousView = new dy();
            paramAnonymousView.ddK.ddB = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            if (paramAnonymousView.ddL.ddj) {
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
    this.nAc = new n.d()
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
          paramAnonymousMenuItem = af.dHR().auT(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new cs();
          com.tencent.mm.plugin.sns.k.a.a((cs)localObject, paramAnonymousMenuItem);
          ((cs)localObject).dck.activity = SnsSightPlayerUI.this;
          ((cs)localObject).dck.dcq = 17;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            com.tencent.mm.plugin.sns.ad.d.m.a(m.d.xKN, m.c.xKI, m.e.xKU, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new to();
            ((to)localObject).dwt.ddB = paramAnonymousMenuItem.dMu();
            ((to)localObject).dwt.dnn = com.tencent.mm.plugin.sns.data.q.l(paramAnonymousMenuItem);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          p localp = af.dHR().auT(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (localp != null) {
            ac.i("MicroMsg.SnsSightPlayerUI", "expose id " + localp.getSnsId());
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
          paramAnonymousMenuItem = af.dHR().auT(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dLV().FQo.Ety == 15) && ((btz)paramAnonymousMenuItem.dLV().FQo.Etz.get(0) == null))
          {
            ac.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.d.e(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.xEx = 0;
    AppMethodBeat.o(99100);
  }
  
  private void PE(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (this.odZ.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.odZ.getDuration();
      }
      this.yIh.NV(this.duration);
      this.yIh.xJX.xLd = bs.Gn();
      locala = this.yIh.xJX;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.xLc = paramInt;
      this.yIh.xJX.xLb = 2;
      ac.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.yIh.xJX.xLc);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.xEq == 0) || (this.xEp == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.xEq = ((DisplayMetrics)localObject).heightPixels;
      this.xEp = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.xEi.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yRb.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.xEp;
      localLayoutParams1.height = ((int)(this.xEp * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.xEi.getId());
      findViewById(2131305896).setVisibility(0);
    }
    for (;;)
    {
      ac.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.odZ).setLayoutParams(localLayoutParams1);
      if ((this.odZ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.odZ).hf(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.xDY.setLayoutParams(localLayoutParams);
      this.xEi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.odZ).requestLayout();
      if (!paramBoolean) {
        PE(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.xEp;
      localLayoutParams1.width = ((int)(this.xEp * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.xEi.getId());
      findViewById(2131305896).setVisibility(8);
    }
  }
  
  private void crK()
  {
    AppMethodBeat.i(99104);
    ac.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.odZ.pause();
    this.odZ.onDetach();
    this.nQt.ev(false);
    AppMethodBeat.o(99104);
  }
  
  private void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.odZ.start();
    this.duration = this.odZ.getDuration();
    ac.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.nQt.a(this);
    com.tencent.mm.plugin.sns.ad.d.a.a locala;
    if (paramBoolean)
    {
      locala = this.yIh.xJX;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      locala.xLc = i;
      this.yIh.xJX.xLd = bs.Gn();
      this.yIh.xJX.xLb = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void atn(String paramString) {}
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final void bF(String paramString, boolean paramBoolean) {}
  
  public final void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    ac.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!bs.isNullOrNil(paramString)) && (this.dwE != null) && (paramString.equals(this.dwE.Id)) && (i.eA(this.gKe)))
    {
      this.yIh.xJP = 1;
      this.odZ.setVideoPath(this.gKe);
      qA(true);
      if (this.yRc != null) {
        this.yRc.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void bSg()
  {
    AppMethodBeat.i(99109);
    int k = this.xEi.getWidth();
    int j = this.xEi.getHeight();
    int i = j;
    if (this.ocY != 0)
    {
      i = j;
      if (this.ocZ != 0) {
        i = (int)(k / this.ocY * this.ocZ);
      }
    }
    this.ocV.jN(k, i);
    this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
    if (this.yIR != 1.0D)
    {
      int m = aj.ej(getContext());
      this.ocV.IRh = (1.0F / this.yIR);
      if ((this.yIS != 0) || (this.yIT != 0))
      {
        j = (int)(this.xEi.getWidth() / 2 * (1.0F - this.yIR));
        k = this.yIS;
        i = (int)((m + this.xEi.getHeight()) / 2 - i / 2 * this.yIR + this.yIT);
        this.ocV.jP(j + k, i);
      }
    }
    this.ocV.a(this.xEi, this.iBF, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(99083);
        new ao().post(new Runnable()
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
  
  public final void dGO() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.hqq)
    {
      super.finish();
      this.hqq = true;
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
        Iterator localIterator = bs.S(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        dev localdev;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.dbL == 0)
          {
            localObject1 = af.dHR().auT(this.dgl);
            if (localObject1 != null)
            {
              if (!w.sQ(str2)) {
                break;
              }
              localObject2 = new ts();
              ((ts)localObject2).dwx.dnn = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
              ((ts)localObject2).dwx.ddB = ((p)localObject1).dMu();
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.xIq.dLV();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.xIq.dFR();
          localdev = new dev();
          localdev.EBs = this.dwE.yYY;
          localdev.hjV = this.dwE.Fjo;
          if (((TimeLineObject)localObject2).FQo.Ety != 15) {
            break label630;
          }
          localdev.hkb = this.yRd.dtx;
          localdev.hkc = ((TimeLineObject)localObject2).Id;
          if (!bs.isNullOrNil(this.dwE.Fjs)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).FQl;
          localdev.hjX = ((String)localObject1);
          if (!bs.isNullOrNil(this.dwE.Fjr)) {
            break label671;
          }
          localObject1 = this.dwE.Fjh;
          localdev.hka = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfC == 0))
          {
            localdev.hjZ = ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfE;
            localdev.hjY = ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfD;
          }
          if (localObject3 != null) {
            localdev.hjZ = ((com.tencent.mm.plugin.sns.storage.b)localObject3).yeD;
          }
          i = com.tencent.mm.plugin.sns.data.q.ate(this.gKe);
          ac.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.gKe, this.imagePath, this.dwE.Fjo, Integer.valueOf(this.dwE.yYY), localdev.hka, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.j.dck().a(this, str2, this.gKe, this.imagePath, 43, i, localdev, ((TimeLineObject)localObject2).yAj, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.j.dck().hF(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dbL, 5, this.xIq.field_snsId, 12, 0));
        boolean bool = w.sQ(str2);
        Object localObject2 = m.d.xKN;
        if (bool)
        {
          localObject1 = m.c.xKK;
          label544:
          localObject3 = m.e.xKU;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = com.tencent.mm.model.q.wb(str2);; i = 0)
        {
          com.tencent.mm.plugin.sns.ad.d.m.a((m.d)localObject2, (m.c)localObject1, (m.e)localObject3, i, this.xIq, this.dbL);
          break;
          localObject2 = new tt();
          ((tt)localObject2).dwy.dnn = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
          ((tt)localObject2).dwy.ddB = ((p)localObject1).dMu();
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          break label152;
          label630:
          localdev.hkb = ((TimeLineObject)localObject2).FQt.hkb;
          localdev.hkc = ((TimeLineObject)localObject2).FQt.hkc;
          break label245;
          label659:
          localObject1 = this.dwE.Fjs;
          break label265;
          label671:
          localObject1 = this.dwE.Fjr;
          break label294;
          label683:
          i = com.tencent.mm.plugin.sns.data.q.ate(this.gKe);
          ac.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.gKe, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.j.dck().a(this, str2, this.gKe, this.imagePath, 43, i, ((TimeLineObject)localObject2).yAj, null);
          break label462;
          localObject1 = m.c.xKJ;
          break label544;
        }
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dbL, 5, this.xIq.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    bSg();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.xEx);
    if (this.xEx == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    az(paramConfiguration.orientation, false);
    this.xEx = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.dbL = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    af.dHM().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100017));
    }
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.ocU = paramBundle;
      this.nQt = new com.tencent.mm.model.d();
      this.gKe = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.dgl = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.xIq = af.dHR().auT(this.dgl);
      if (!this.isAd) {
        break label338;
      }
      if (this.xIq != null) {
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
      this.dwE = ((btz)this.xIq.dLV().FQo.Etz.get(0));
      paramBundle = an.jc(af.getAccSnsPath(), this.dwE.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.dwE);
      this.yRe = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + com.tencent.mm.plugin.sns.data.q.d(this.dwE));
    }
    label338:
    if (com.tencent.mm.r.a.Lt() != null) {
      com.tencent.mm.r.a.Lt().Ue();
    }
    if (this.xIq != null) {
      if (this.dbL == 2)
      {
        paramBundle = this.xIq.dLS();
        this.yRd = paramBundle;
        this.yIh.xJR = bs.Gn();
        this.yRf = ((RelativeLayout)findViewById(2131298770));
        this.yRf.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            SnsSightPlayerUI.this.bSg();
            AppMethodBeat.o(99078);
            return true;
          }
        });
        ac.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.YF() + " initView: fullpath:" + this.gKe + ", imagepath:" + this.imagePath);
        this.ocV = new com.tencent.mm.ui.tools.e(getContext());
        this.iBF = ((ImageView)findViewById(2131300336));
        this.xDY = ((TextView)findViewById(2131305896));
        this.yRc = ((MMPinProgressBtn)findViewById(2131304805));
        this.xEi = ((ViewGroup)findViewById(2131306317));
        this.odZ = t.hz(getContext());
        if ((this.odZ instanceof VideoSightView)) {
          ((VideoSightView)this.odZ).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.qPW = ((TextView)findViewById(2131304777));
        this.qPW.setTextColor(Color.parseColor("#888888"));
        this.xEi.addView((View)this.odZ, 0, paramBundle);
        this.yRb = ((TextView)findViewById(2131305813));
        this.yRb.setText("");
        if (!this.isAd) {
          this.yRb.setVisibility(8);
        }
        if (!this.isAd) {
          break label1317;
        }
        if (this.dwE != null) {
          break label993;
        }
        this.qPW.setVisibility(8);
        label689:
        s.a(this.qPW, (VideoSightView)this.odZ);
        label703:
        this.odZ.setVideoCallback(new h.a()
        {
          public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(99093);
            ac.d("MicroMsg.SnsSightPlayerUI", "on completion");
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
            com.tencent.mm.plugin.sns.ad.d.a.a locala = SnsSightPlayerUI.l(SnsSightPlayerUI.this).xJX;
            locala.xKY += 1;
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
            AppMethodBeat.o(99093);
          }
          
          public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(99092);
            ac.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).stop();
            if (SnsSightPlayerUI.h(SnsSightPlayerUI.this))
            {
              AppMethodBeat.o(99092);
              return;
            }
            SnsSightPlayerUI.i(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.a.b.N(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dEw() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bs.bG(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(2131306415);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.wkB);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                com.tencent.mm.sdk.platformtools.m.a(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(2131759030));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  ac.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  com.tencent.mm.ui.base.h.l(SnsSightPlayerUI.this.getContext(), 2131758931, 2131758932);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
          
          public final void rB()
          {
            AppMethodBeat.i(99091);
            ac.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.YF() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
        });
        findViewById(2131306317).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            SnsSightPlayerUI.this.bSg();
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.odZ).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            SnsSightPlayerUI.this.bSg();
            AppMethodBeat.o(99095);
          }
        });
        this.kVo = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            SnsSightPlayerUI.b(SnsSightPlayerUI.this, true);
            super.onLongPress(paramAnonymousMotionEvent);
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
        });
        ((View)this.odZ).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            float f1 = 1.0F;
            AppMethodBeat.i(99098);
            SnsSightPlayerUI.n(SnsSightPlayerUI.this).onTouchEvent(paramAnonymousMotionEvent);
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.xEi.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.xEi.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.odZ, paramAnonymousView.yRg, paramAnonymousView.nAc);
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
                    SnsSightPlayerUI.this.bSg();
                    SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                    AppMethodBeat.o(99098);
                    return true;
                  }
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
                }
              }
            }
            float f3 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationX();
            float f4 = ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).getTranslationY();
            paramAnonymousView = SnsSightPlayerUI.o(SnsSightPlayerUI.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            float f2;
            if (((Math.abs(f3) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsSightPlayerUI.r(SnsSightPlayerUI.this))) || (SnsSightPlayerUI.m(SnsSightPlayerUI.this)))
            {
              f2 = 1.0F - f4 / SnsSightPlayerUI.this.xEi.getHeight();
              if (f2 > 1.0F)
              {
                label515:
                if (((j > 0) && (f1 < SnsSightPlayerUI.s(SnsSightPlayerUI.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  SnsSightPlayerUI.a(SnsSightPlayerUI.this, (int)f3);
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, (int)f4);
                  SnsSightPlayerUI.c(SnsSightPlayerUI.this, f1);
                  if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
                    SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(8);
                  }
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.xEi.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.xEi.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(f1);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(f1);
                  SnsSightPlayerUI.t(SnsSightPlayerUI.this).setAlpha(f1);
                }
                SnsSightPlayerUI.c(SnsSightPlayerUI.this, true);
                label699:
                if (f4 <= 200.0F) {
                  break label802;
                }
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, false);
              }
            }
            for (;;)
            {
              if (f4 > 50.0F) {
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
              f1 = f2;
              break label515;
              SnsSightPlayerUI.c(SnsSightPlayerUI.this, false);
              break label699;
              label802:
              if (f4 > 10.0F) {
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, true);
              }
            }
          }
        });
        if (!i.eA(this.gKe)) {
          break label1329;
        }
        if (this.gKe != null)
        {
          this.odZ.stop();
          this.odZ.setVideoPath(this.gKe);
        }
        this.yRc.setVisibility(8);
      }
    }
    for (this.yIh.xJP = 1;; this.yIh.xJP = 0)
    {
      ac.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new wj();
      paramBundle.dzj.type = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
      }
      this.contextMenuHelper.a((View)this.odZ, this.yRg, this.nAc);
      ((View)this.odZ).post(new Runnable()
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
      paramBundle = this.xIq.dFQ();
      break;
      paramBundle = null;
      break;
      label993:
      if (bs.isNullOrNil(this.dwE.Fjo))
      {
        ac.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.xIq.dLV();
        Object localObject2 = this.xIq.dFR();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).yfD;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).yfE;
        if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2)))
        {
          this.qPW.setVisibility(0);
          this.qPW.setText((CharSequence)localObject1);
          this.qPW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1;
              Object localObject2;
              if (m.b.xKC.value != 0)
              {
                localObject1 = m.a.xKw;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label218;
                }
              }
              label218:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dtx)
              {
                com.tencent.mm.plugin.sns.ad.d.m.a((m.a)localObject1, (String)localObject2, paramAnonymousView, 1, m.b.xKC.value, paramBundle.ncR, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.yAj);
                localObject1 = this.qQk;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).dtx);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.c.a.iyx.i(this.val$intent, SnsSightPlayerUI.this);
                    SnsSightPlayerUI.this.finish();
                    AppMethodBeat.o(99086);
                  }
                });
                AppMethodBeat.o(99087);
                return;
              }
            }
          });
          break label689;
        }
        this.qPW.setVisibility(8);
        break label689;
      }
      localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (this.dwE.yYY / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(this.dwE.yYY / 60) });
      }
      localObject1 = paramBundle;
      if (this.dwE.yYY % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(this.dwE.yYY % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.qPW.setText(paramBundle);
      this.qPW.setVisibility(0);
      this.qPW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).Pe(32)) {
            com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKv, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          Object localObject1 = new Intent();
          paramAnonymousView = an.jc(af.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = com.tencent.mm.plugin.sns.data.q.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMG, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            ac.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjo);
            if (!bs.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjr)) {
              break label752;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjh;
            label208:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).dyy);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dLV();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label766;
            }
            paramAnonymousView = "";
            label291:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", m.b.xKC.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).ncR);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).yAj);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).yYY);
            if (!bs.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjs)) {
              break label780;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).FQl;
            label402:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dFR();
            if ((paramAnonymousView != null) && (paramAnonymousView.yfC == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.yfD);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.yfE);
            }
            localObject2 = af.dHR().auT(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label794;
            }
            paramAnonymousView = com.tencent.mm.modelsns.d.ps(747);
            label485:
            paramAnonymousView.Dn(com.tencent.mm.plugin.sns.data.q.l((p)localObject2)).pv(((p)localObject2).field_type).eQ(true).Dn(((p)localObject2).dMD()).pv(SnsSightPlayerUI.d(SnsSightPlayerUI.this).yYY);
            paramAnonymousView.aHZ();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label804;
            }
          }
          label780:
          label794:
          label804:
          for (paramAnonymousView = com.tencent.mm.modelsns.d.ps(748);; paramAnonymousView = com.tencent.mm.modelsns.d.pt(748))
          {
            paramAnonymousView.Dn(com.tencent.mm.plugin.sns.data.q.l((p)localObject2)).pv(((p)localObject2).field_type).eQ(true).Dn(((p)localObject2).dMD()).pv(SnsSightPlayerUI.d(SnsSightPlayerUI.this).yYY);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((p)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new tj();
              paramAnonymousView.dwp.isStart = true;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            }
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            label752:
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjr;
            break label208;
            label766:
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dtx;
            break label291;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).Fjs;
            break label402;
            paramAnonymousView = com.tencent.mm.modelsns.d.pt(747);
            break label485;
          }
        }
      });
      break label689;
      label1317:
      this.qPW.setVisibility(8);
      break label703;
      label1329:
      af.dHM().a(this.dwE, 6, null, bf.GYH);
      this.yRc.setVisibility(0);
      this.yRc.fuE();
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
      if (this.xIq != null) {
        break label496;
      }
      localObject = "";
      if (this.xIq != null)
      {
        String str2 = this.yIh.dFH();
        if (this.xIq != null) {
          break label508;
        }
        i = 0;
        long l2 = this.yIh.xJQ - this.yIh.hTE;
        long l1 = l2;
        if (l2 < 0L)
        {
          ac.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.yIh.xJQ), Long.valueOf(this.yIh.hTE) });
          l1 = this.yIh.xJQ;
        }
        int k = (int)l1;
        if (this.yRd != null) {
          break label519;
        }
        str1 = "";
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.agQ().ghe;
        if (this.dbL != 0) {
          break label531;
        }
        j = 1;
        int m = this.yIh.xJQ;
        if (this.dbL != 2) {
          break label536;
        }
        localb1 = this.xIq.dME().dLZ();
        if (this.dbL != 2) {
          break label551;
        }
        localb2 = this.xIq.dME().dMa();
        label219:
        localq.a(new com.tencent.mm.plugin.sns.ad.d.f((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    ac.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.xIq != null) && (this.xIq.Pe(32))) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKx, this.xIq, this.dbL);
    }
    af.dHM().b(this);
    Object localObject = com.tencent.mm.modelsns.d.w(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label572;
      }
      if (bs.isNullOrNil(this.dwE.Fjo)) {
        break label566;
      }
      label342:
      ((com.tencent.mm.modelsns.d)localObject).eQ(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.d)localObject).update();
      ((com.tencent.mm.modelsns.d)localObject).aHZ();
      if (com.tencent.mm.r.a.Lt() != null) {
        com.tencent.mm.r.a.Lt().Ud();
      }
      if (this.odZ != null)
      {
        this.odZ.setVideoCallback(null);
        this.odZ.stop();
        this.odZ.onDetach();
      }
      if (!this.xDZ)
      {
        localObject = new wj();
        ((wj)localObject).dzj.type = 0;
        ((wj)localObject).dzj.dzk = this.xDt;
        ((wj)localObject).dzj.dzl = this.qME;
        ((wj)localObject).dzj.dzm = this.dzm;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      this.nQt.ev(false);
      AppMethodBeat.o(99105);
      return;
      label496:
      localObject = this.yRd.dyy;
      break;
      label508:
      i = this.xIq.dMF();
      break label56;
      label519:
      str1 = this.yRd.yfa;
      break label149;
      label531:
      j = 2;
      break label170;
      label536:
      localb1 = this.xIq.dME().dLX();
      break label199;
      label551:
      localb2 = this.xIq.dME().dLY();
      break label219;
      label566:
      bool = false;
      break label342;
      label572:
      ((com.tencent.mm.modelsns.d)localObject).eQ(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ac.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    PE(i);
    if (!this.yPn)
    {
      crK();
      ac.v("check", "onclick");
      new ao().post(new Runnable()
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
      if (this.yIh != null) {
        this.yIh.hTD = bs.Gn();
      }
      AppMethodBeat.o(99108);
      return;
      crK();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.cqf)
    {
      ac.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        az(getResources().getConfiguration().orientation, true);
      }
      this.cqf = true;
    }
    if ((this.xEq == 0) || (this.xEp == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.xEq = localDisplayMetrics.heightPixels;
      this.xEp = localDisplayMetrics.widthPixels;
    }
    if ((this.yPn) && (i.eA(this.gKe)))
    {
      qA(false);
      this.yPn = false;
    }
    if (this.yIh != null) {
      this.yIh.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.ocU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.ocW = getIntent().getIntExtra("img_gallery_top", 0);
        this.ocX = getIntent().getIntExtra("img_gallery_left", 0);
        this.ocY = getIntent().getIntExtra("img_gallery_width", 0);
        this.ocZ = getIntent().getIntExtra("img_gallery_height", 0);
        this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
        if (localBundle == null) {
          this.xEi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.xEi.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.ocV.a(SnsSightPlayerUI.this.xEi, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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