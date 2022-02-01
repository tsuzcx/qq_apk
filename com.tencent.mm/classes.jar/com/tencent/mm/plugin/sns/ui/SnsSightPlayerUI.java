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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.a.b.m.a;
import com.tencent.mm.plugin.sns.a.b.m.b;
import com.tencent.mm.plugin.sns.a.b.m.c;
import com.tencent.mm.plugin.sns.a.b.m.d;
import com.tencent.mm.plugin.sns.a.b.m.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
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
  private float aOa;
  private float aOb;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  private boolean csX;
  private int dBy;
  private int dep;
  private String diQ;
  private int duration;
  private bpi dyS;
  private boolean gPQ;
  private String gjt;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private GestureDetector ktZ;
  private VelocityTracker mVelocityTracker;
  n.d mXD;
  com.tencent.mm.pluginsdk.ui.tools.h nAZ;
  private com.tencent.mm.model.d nnt;
  Bundle nzU;
  com.tencent.mm.ui.tools.e nzV;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  private ImageView qdk;
  private int qeb;
  private TextView qhu;
  private boolean qhx;
  private String thumbPath;
  private TextView wsI;
  private boolean wsJ;
  ViewGroup wsS;
  private int wsZ;
  private int wsd;
  private int wta;
  public int wth;
  private p wwP;
  private boolean xCE;
  private boolean xCF;
  private boolean xCG;
  private boolean xCz;
  private String xEm;
  private TextView xEn;
  private MMPinProgressBtn xEo;
  private com.tencent.mm.plugin.sns.storage.a xEp;
  private String xEq;
  private RelativeLayout xEr;
  View.OnCreateContextMenuListener xEs;
  private com.tencent.mm.plugin.sns.a.b.j xvr;
  private float xwb;
  private int xwc;
  private int xwd;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.xvr = new com.tencent.mm.plugin.sns.a.b.j("SnsSightPlayerUI");
    this.gjt = "";
    this.imagePath = "";
    this.diQ = "";
    this.xEm = "";
    this.isAd = false;
    this.nAZ = null;
    this.wsI = null;
    this.xEn = null;
    this.xEo = null;
    this.dep = 0;
    this.duration = 0;
    this.dBy = 0;
    this.wsd = 0;
    this.qeb = 0;
    this.wsJ = false;
    this.xCz = false;
    this.wsZ = 0;
    this.wta = 0;
    this.csX = false;
    this.qhx = false;
    this.wwP = null;
    this.xEp = null;
    this.dyS = null;
    this.thumbPath = "";
    this.xEq = "";
    this.qhu = null;
    this.isAnimated = false;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.aOa = 0.0F;
    this.aOb = 0.0F;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.xwb = 1.0F;
    this.xwc = 0;
    this.xwd = 0;
    this.gPQ = false;
    this.xEs = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (bt.aGh(com.tencent.mm.m.g.Zd().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = i.eK(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = i.eK(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          ad.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(2131763770));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.bs.d.axB("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousView = new dx();
            paramAnonymousView.dgp.dgg = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            if (paramAnonymousView.dgq.dfO) {
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
    this.mXD = new n.d()
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
          paramAnonymousMenuItem = af.dtu().apK(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new cs();
          com.tencent.mm.plugin.sns.l.a.a((cs)localObject, paramAnonymousMenuItem);
          ((cs)localObject).deQ.activity = SnsSightPlayerUI.this;
          ((cs)localObject).deQ.deW = 17;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            com.tencent.mm.plugin.sns.a.b.m.a(m.d.wzm, m.c.wzh, m.e.wzt, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new tf();
            ((tf)localObject).dyH.dgg = paramAnonymousMenuItem.dxX();
            ((tf)localObject).dyH.dpC = com.tencent.mm.plugin.sns.data.q.l(paramAnonymousMenuItem);
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          p localp = af.dtu().apK(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
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
          paramAnonymousMenuItem = af.dtu().apK(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dxy().Etm.DaB == 15) && ((bpi)paramAnonymousMenuItem.dxy().Etm.DaC.get(0) == null))
          {
            ad.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.bs.d.e(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.wth = 0;
    AppMethodBeat.o(99100);
  }
  
  private void NA(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (this.nAZ.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.nAZ.getDuration();
      }
      this.xvr.LV(this.duration);
      this.xvr.wyw.wzC = bt.GC();
      locala = this.xvr.wyw;
      if (paramInt != 2) {
        break label156;
      }
    }
    label156:
    for (paramInt = 2;; paramInt = 1)
    {
      locala.wzB = paramInt;
      this.xvr.wyw.wzA = 2;
      ad.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.xvr.wyw.wzB);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.wta == 0) || (this.wsZ == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.wta = ((DisplayMetrics)localObject).heightPixels;
      this.wsZ = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.wsS.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.xEn.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.wsZ;
      localLayoutParams1.height = ((int)(this.wsZ * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.wsS.getId());
      findViewById(2131305896).setVisibility(0);
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.nAZ).setLayoutParams(localLayoutParams1);
      if ((this.nAZ instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        ((com.tencent.mm.plugin.sight.decode.a.a)this.nAZ).gW(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.wsI.setLayoutParams(localLayoutParams);
      this.wsS.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.nAZ).requestLayout();
      if (!paramBoolean) {
        NA(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.wsZ;
      localLayoutParams1.width = ((int)(this.wsZ * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.wsS.getId());
      findViewById(2131305896).setVisibility(8);
    }
  }
  
  private void ckd()
  {
    AppMethodBeat.i(99104);
    ad.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.nAZ.pause();
    this.nAZ.onDetach();
    this.nnt.ea(false);
    AppMethodBeat.o(99104);
  }
  
  private void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.nAZ.start();
    this.duration = this.nAZ.getDuration();
    ad.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.nnt.a(this);
    com.tencent.mm.plugin.sns.a.b.a.a locala;
    if (paramBoolean)
    {
      locala = this.xvr.wyw;
      if (getResources().getConfiguration().orientation != 2) {
        break label128;
      }
    }
    label128:
    for (int i = 2;; i = 1)
    {
      locala.wzB = i;
      this.xvr.wyw.wzC = bt.GC();
      this.xvr.wyw.wzA = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  public final void aob(String paramString) {}
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final void bKT()
  {
    AppMethodBeat.i(99109);
    int k = this.wsS.getWidth();
    int j = this.wsS.getHeight();
    int i = j;
    if (this.nzY != 0)
    {
      i = j;
      if (this.nzZ != 0) {
        i = (int)(k / this.nzY * this.nzZ);
      }
    }
    this.nzV.jB(k, i);
    this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
    if (this.xwb != 1.0D)
    {
      int m = ai.eb(getContext());
      this.nzV.HqK = (1.0F / this.xwb);
      if ((this.xwc != 0) || (this.xwd != 0))
      {
        j = (int)(this.wsS.getWidth() / 2 * (1.0F - this.xwb));
        k = this.xwc;
        i = (int)((m + this.wsS.getHeight()) / 2 - i / 2 * this.xwb + this.xwd);
        this.nzV.jD(j + k, i);
      }
    }
    this.nzV.a(this.wsS, this.qdk, new e.c()
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
  
  public final void by(String paramString, boolean paramBoolean) {}
  
  public final void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    ad.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!bt.isNullOrNil(paramString)) && (this.dyS != null) && (paramString.equals(this.dyS.Id)) && (i.eK(this.gjt)))
    {
      this.xvr.wyo = 1;
      this.nAZ.setVideoPath(this.gjt);
      pB(true);
      if (this.xEo != null) {
        this.xEo.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
  
  public final void dsp() {}
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.gPQ)
    {
      super.finish();
      this.gPQ = true;
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
        Iterator localIterator = bt.S(((String)localObject1).split(",")).iterator();
        String str2;
        label152:
        Object localObject3;
        czj localczj;
        label245:
        do
        {
          if (!localIterator.hasNext()) {
            break label810;
          }
          str2 = (String)localIterator.next();
          if (this.dep == 0)
          {
            localObject1 = af.dtu().apK(this.diQ);
            if (localObject1 != null)
            {
              if (!w.pF(str2)) {
                break;
              }
              localObject2 = new tj();
              ((tj)localObject2).dyL.dpC = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
              ((tj)localObject2).dyL.dgg = ((p)localObject1).dxX();
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
            }
          }
          localObject2 = this.wwP.dxy();
          if (!this.isAd) {
            break label683;
          }
          localObject3 = this.wwP.dxs();
          localczj = new czj();
          localczj.Dim = this.dyS.xMj;
          localczj.gJv = this.dyS.DMX;
          if (((TimeLineObject)localObject2).Etm.DaB != 15) {
            break label630;
          }
          localczj.gJB = this.xEp.dvK;
          localczj.gJC = ((TimeLineObject)localObject2).Id;
          if (!bt.isNullOrNil(this.dyS.DNb)) {
            break label659;
          }
          localObject1 = ((TimeLineObject)localObject2).Etj;
          localczj.gJx = ((String)localObject1);
          if (!bt.isNullOrNil(this.dyS.DNa)) {
            break label671;
          }
          localObject1 = this.dyS.DMQ;
          localczj.gJA = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).wSS == 0))
          {
            localczj.gJz = ((com.tencent.mm.plugin.sns.storage.b)localObject3).wSU;
            localczj.gJy = ((com.tencent.mm.plugin.sns.storage.b)localObject3).wST;
          }
          if (localObject3 != null) {
            localczj.gJz = ((com.tencent.mm.plugin.sns.storage.b)localObject3).wRX;
          }
          i = com.tencent.mm.plugin.sns.data.q.anS(this.gjt);
          ad.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.gjt, this.imagePath, this.dyS.DMX, Integer.valueOf(this.dyS.xMj), localczj.gJA, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.j.cOB().a(this, str2, this.gjt, this.imagePath, 43, i, localczj, ((TimeLineObject)localObject2).xns, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.j.cOB().hm(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
        } while (!this.isAd);
        label265:
        label294:
        label462:
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dep, 5, this.wwP.field_snsId, 12, 0));
        boolean bool = w.pF(str2);
        Object localObject2 = m.d.wzm;
        if (bool)
        {
          localObject1 = m.c.wzj;
          label544:
          localObject3 = m.e.wzt;
          if (!bool) {
            break label772;
          }
        }
        label772:
        for (int i = com.tencent.mm.model.q.rY(str2);; i = 0)
        {
          com.tencent.mm.plugin.sns.a.b.m.a((m.d)localObject2, (m.c)localObject1, (m.e)localObject3, i, this.wwP, this.dep);
          break;
          localObject2 = new tk();
          ((tk)localObject2).dyM.dpC = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
          ((tk)localObject2).dyM.dgg = ((p)localObject1).dxX();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          break label152;
          label630:
          localczj.gJB = ((TimeLineObject)localObject2).Etr.gJB;
          localczj.gJC = ((TimeLineObject)localObject2).Etr.gJC;
          break label245;
          label659:
          localObject1 = this.dyS.DNb;
          break label265;
          label671:
          localObject1 = this.dyS.DNa;
          break label294;
          label683:
          i = com.tencent.mm.plugin.sns.data.q.anS(this.gjt);
          ad.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.gjt, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.j.cOB().a(this, str2, this.gjt, this.imagePath, 43, i, ((TimeLineObject)localObject2).xns, null);
          break label462;
          localObject1 = m.c.wzi;
          break label544;
        }
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(this.dep, 5, this.wwP.field_snsId, 13, 0));
      }
    }
    label810:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    bKT();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.wth);
    if (this.wth == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    aw(paramConfiguration.orientation, false);
    this.wth = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.dep = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    af.dtp().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(2131100017));
    }
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.nzU = paramBundle;
      this.nnt = new com.tencent.mm.model.d();
      this.gjt = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.diQ = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.wwP = af.dtu().apK(this.diQ);
      if (!this.isAd) {
        break label338;
      }
      if (this.wwP != null) {
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
      this.dyS = ((bpi)this.wwP.dxy().Etm.DaC.get(0));
      paramBundle = an.iF(af.getAccSnsPath(), this.dyS.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.dyS);
      this.xEq = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + com.tencent.mm.plugin.sns.data.q.d(this.dyS));
    }
    label338:
    if (com.tencent.mm.r.a.Lv() != null) {
      com.tencent.mm.r.a.Lv().Tk();
    }
    if (this.wwP != null) {
      if (this.dep == 2)
      {
        paramBundle = this.wwP.dxv();
        this.xEp = paramBundle;
        this.xvr.wyq = bt.GC();
        this.xEr = ((RelativeLayout)findViewById(2131298770));
        this.xEr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            SnsSightPlayerUI.this.bKT();
            AppMethodBeat.o(99078);
            return true;
          }
        });
        ad.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.XI() + " initView: fullpath:" + this.gjt + ", imagepath:" + this.imagePath);
        this.nzV = new com.tencent.mm.ui.tools.e(getContext());
        this.qdk = ((ImageView)findViewById(2131300336));
        this.wsI = ((TextView)findViewById(2131305896));
        this.xEo = ((MMPinProgressBtn)findViewById(2131304805));
        this.wsS = ((ViewGroup)findViewById(2131306317));
        this.nAZ = t.ho(getContext());
        if ((this.nAZ instanceof VideoSightView)) {
          ((VideoSightView)this.nAZ).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.qhu = ((TextView)findViewById(2131304777));
        this.qhu.setTextColor(Color.parseColor("#888888"));
        this.wsS.addView((View)this.nAZ, 0, paramBundle);
        this.xEn = ((TextView)findViewById(2131305813));
        this.xEn.setText("");
        if (!this.isAd) {
          this.xEn.setVisibility(8);
        }
        if (!this.isAd) {
          break label1317;
        }
        if (this.dyS != null) {
          break label993;
        }
        this.qhu.setVisibility(8);
        label689:
        s.a(this.qhu, (VideoSightView)this.nAZ);
        label703:
        this.nAZ.setVideoCallback(new h.a()
        {
          public final void dY(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final int eM(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
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
            com.tencent.mm.plugin.sns.a.b.a.a locala = SnsSightPlayerUI.l(SnsSightPlayerUI.this).wyw;
            locala.wzx += 1;
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
            com.tencent.mm.sdk.a.b.M(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dqn() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + bt.by(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(2131306415);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.vbN);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                com.tencent.mm.sdk.platformtools.m.a(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(2131759030));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  ad.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  com.tencent.mm.ui.base.h.j(SnsSightPlayerUI.this.getContext(), 2131758931, 2131758932);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
          
          public final void rq()
          {
            AppMethodBeat.i(99091);
            ad.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.XI() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
        });
        findViewById(2131306317).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            SnsSightPlayerUI.this.bKT();
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.nAZ).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            SnsSightPlayerUI.this.bKT();
            AppMethodBeat.o(99095);
          }
        });
        this.ktZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
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
        ((View)this.nAZ).setOnTouchListener(new View.OnTouchListener()
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.wsS.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.wsS.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.nAZ, paramAnonymousView.xEs, paramAnonymousView.mXD);
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
                    SnsSightPlayerUI.this.bKT();
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
              f2 = 1.0F - f4 / SnsSightPlayerUI.this.wsS.getHeight();
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.wsS.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.wsS.getHeight() / 2);
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
        if (!i.eK(this.gjt)) {
          break label1329;
        }
        if (this.gjt != null)
        {
          this.nAZ.stop();
          this.nAZ.setVideoPath(this.gjt);
        }
        this.xEo.setVisibility(8);
      }
    }
    for (this.xvr.wyo = 1;; this.xvr.wyo = 0)
    {
      ad.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new vy();
      paramBundle.dBv.type = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
      }
      this.contextMenuHelper.a((View)this.nAZ, this.xEs, this.mXD);
      ((View)this.nAZ).post(new Runnable()
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
      paramBundle = this.wwP.dxu();
      break;
      paramBundle = null;
      break;
      label993:
      if (bt.isNullOrNil(this.dyS.DMX))
      {
        ad.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.wwP.dxy();
        Object localObject2 = this.wwP.dxs();
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).wST;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).wSU;
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
        {
          this.qhu.setVisibility(0);
          this.qhu.setText((CharSequence)localObject1);
          this.qhu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1;
              Object localObject2;
              if (m.b.wzb.value != 0)
              {
                localObject1 = m.a.wyV;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label218;
                }
              }
              label218:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dvK)
              {
                com.tencent.mm.plugin.sns.a.b.m.a((m.a)localObject1, (String)localObject2, paramAnonymousView, 1, m.b.wzb.value, paramBundle.mAQ, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.xns);
                localObject1 = this.qhI;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).dvK);
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
                    com.tencent.mm.plugin.sns.d.a.hYt.i(this.val$intent, SnsSightPlayerUI.this);
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
        this.qhu.setVisibility(8);
        break label689;
      }
      localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (this.dyS.xMj / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(this.dyS.xMj / 60) });
      }
      localObject1 = paramBundle;
      if (this.dyS.xMj % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(this.dyS.xMj % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.qhu.setText(paramBundle);
      this.qhu.setVisibility(0);
      this.qhu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).Nb(32)) {
            com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyU, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          Object localObject1 = new Intent();
          paramAnonymousView = an.iF(af.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = com.tencent.mm.plugin.sns.data.q.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            ad.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).DMX);
            if (!bt.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).DNa)) {
              break label752;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).DMQ;
            label208:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).dAM);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dxy();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label766;
            }
            paramAnonymousView = "";
            label291:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", m.b.wzb.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).mAQ);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).xns);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).xMj);
            if (!bt.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).DNb)) {
              break label780;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).Etj;
            label402:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).dxs();
            if ((paramAnonymousView != null) && (paramAnonymousView.wSS == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.wST);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.wSU);
            }
            localObject2 = af.dtu().apK(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label794;
            }
            paramAnonymousView = com.tencent.mm.modelsns.d.oE(747);
            label485:
            paramAnonymousView.zi(com.tencent.mm.plugin.sns.data.q.l((p)localObject2)).oH(((p)localObject2).field_type).ew(true).zi(((p)localObject2).dyg()).oH(SnsSightPlayerUI.d(SnsSightPlayerUI.this).xMj);
            paramAnonymousView.aBj();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label804;
            }
          }
          label780:
          label794:
          label804:
          for (paramAnonymousView = com.tencent.mm.modelsns.d.oE(748);; paramAnonymousView = com.tencent.mm.modelsns.d.oF(748))
          {
            paramAnonymousView.zi(com.tencent.mm.plugin.sns.data.q.l((p)localObject2)).oH(((p)localObject2).field_type).ew(true).zi(((p)localObject2).dyg()).oH(SnsSightPlayerUI.d(SnsSightPlayerUI.this).xMj);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((p)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new ta();
              paramAnonymousView.dyD.isStart = true;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            }
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            label752:
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).DNa;
            break label208;
            label766:
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).dvK;
            break label291;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).DNb;
            break label402;
            paramAnonymousView = com.tencent.mm.modelsns.d.oF(747);
            break label485;
          }
        }
      });
      break label689;
      label1317:
      this.qhu.setVisibility(8);
      break label703;
      label1329:
      af.dtp().a(this.dyS, 6, null, bc.FzF);
      this.xEo.setVisibility(0);
      this.xEo.feJ();
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
      if (this.wwP != null) {
        break label496;
      }
      localObject = "";
      if (this.wwP != null)
      {
        String str2 = this.xvr.drv();
        if (this.wwP != null) {
          break label508;
        }
        i = 0;
        long l2 = this.xvr.wyp - this.xvr.htc;
        long l1 = l2;
        if (l2 < 0L)
        {
          ad.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.xvr.wyp), Long.valueOf(this.xvr.htc) });
          l1 = this.xvr.wyp;
        }
        int k = (int)l1;
        if (this.xEp != null) {
          break label519;
        }
        str1 = "";
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.afA().gcy;
        if (this.dep != 0) {
          break label531;
        }
        j = 1;
        int m = this.xvr.wyp;
        if (this.dep != 2) {
          break label536;
        }
        localb1 = this.wwP.dyh().dxC();
        if (this.dep != 2) {
          break label551;
        }
        localb2 = this.wwP.dyh().dxD();
        label219:
        localq.a(new com.tencent.mm.plugin.sns.a.b.f((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    ad.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.wwP != null) && (this.wwP.Nb(32))) {
      com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyW, this.wwP, this.dep);
    }
    af.dtp().b(this);
    Object localObject = com.tencent.mm.modelsns.d.w(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label572;
      }
      if (bt.isNullOrNil(this.dyS.DMX)) {
        break label566;
      }
      label342:
      ((com.tencent.mm.modelsns.d)localObject).ew(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.d)localObject).update();
      ((com.tencent.mm.modelsns.d)localObject).aBj();
      if (com.tencent.mm.r.a.Lv() != null) {
        com.tencent.mm.r.a.Lv().Tj();
      }
      if (this.nAZ != null)
      {
        this.nAZ.setVideoCallback(null);
        this.nAZ.stop();
        this.nAZ.onDetach();
      }
      if (!this.wsJ)
      {
        localObject = new vy();
        ((vy)localObject).dBv.type = 0;
        ((vy)localObject).dBv.dBw = this.wsd;
        ((vy)localObject).dBv.dBx = this.qeb;
        ((vy)localObject).dBv.dBy = this.dBy;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      this.nnt.ea(false);
      AppMethodBeat.o(99105);
      return;
      label496:
      localObject = this.xEp.dAM;
      break;
      label508:
      i = this.wwP.dyi();
      break label56;
      label519:
      str1 = this.xEp.wSu;
      break label149;
      label531:
      j = 2;
      break label170;
      label536:
      localb1 = this.wwP.dyh().dxA();
      break label199;
      label551:
      localb2 = this.wwP.dyh().dxB();
      break label219;
      label566:
      bool = false;
      break label342;
      label572:
      ((com.tencent.mm.modelsns.d)localObject).ew(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ad.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    NA(i);
    if (!this.xCz)
    {
      ckd();
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
      if (this.xvr != null) {
        this.xvr.htb = bt.GC();
      }
      AppMethodBeat.o(99108);
      return;
      ckd();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.csX)
    {
      ad.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        aw(getResources().getConfiguration().orientation, true);
      }
      this.csX = true;
    }
    if ((this.wta == 0) || (this.wsZ == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.wta = localDisplayMetrics.heightPixels;
      this.wsZ = localDisplayMetrics.widthPixels;
    }
    if ((this.xCz) && (i.eK(this.gjt)))
    {
      pB(false);
      this.xCz = false;
    }
    if (this.xvr != null) {
      this.xvr.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.nzU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.nzW = getIntent().getIntExtra("img_gallery_top", 0);
        this.nzX = getIntent().getIntExtra("img_gallery_left", 0);
        this.nzY = getIntent().getIntExtra("img_gallery_width", 0);
        this.nzZ = getIntent().getIntExtra("img_gallery_height", 0);
        this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
        if (localBundle == null) {
          this.wsS.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.wsS.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.nzV.a(SnsSightPlayerUI.this.wsS, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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