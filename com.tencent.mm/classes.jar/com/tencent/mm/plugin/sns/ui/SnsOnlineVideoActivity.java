package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.g.a.ug.a;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private float aOa;
  private float aOb;
  private String diQ;
  private String dvX;
  private bpi dyS;
  private boolean fqj;
  private String gjt;
  private boolean isAnimated;
  private GestureDetector ktZ;
  private com.tencent.mm.ui.widget.a.e mET;
  private VelocityTracker mVelocityTracker;
  n.d mXD;
  private FrameLayout nku;
  private Bundle nzU;
  private com.tencent.mm.ui.tools.e nzV;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  private ImageView qdk;
  private RelativeLayout qiM;
  private boolean qit;
  private int scene;
  private String sessionId;
  private boolean tAJ;
  private String thumbPath;
  private boolean tib;
  private com.tencent.mm.plugin.sns.storage.p wwP;
  private boolean xCA;
  private boolean xCB;
  private boolean xCC;
  private boolean xCD;
  private boolean xCE;
  private boolean xCF;
  private boolean xCG;
  n.c xCH;
  private OnlineVideoView xCy;
  private boolean xCz;
  private boolean xoY;
  private long xpP;
  private int xss;
  private boolean xvK;
  private Button xvN;
  private float xwb;
  private int xwc;
  private int xwd;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.qit = true;
    this.scene = 0;
    this.xCz = false;
    this.isAnimated = false;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.xCB = false;
    this.xvK = true;
    this.xoY = false;
    this.xCC = false;
    this.dvX = "";
    this.sessionId = "";
    this.xpP = 0L;
    this.xss = 2;
    this.xCD = false;
    this.aOa = 0.0F;
    this.aOb = 0.0F;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.xwb = 1.0F;
    this.xwc = 0;
    this.xwd = 0;
    this.xCH = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        int i = 1;
        AppMethodBeat.i(98944);
        if (bt.aGh(com.tencent.mm.m.g.Zd().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = com.tencent.mm.vfs.i.eK(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          boolean bool2 = com.tencent.mm.vfs.i.eK(SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
          ad.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousl.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(2131763770));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (com.tencent.mm.bs.d.axB("favorite")) {
            paramAnonymousl.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(2131761941));
          }
          paramAnonymousl.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(2131762784));
          if (i != 0)
          {
            dx localdx = new dx();
            localdx.dgp.dgg = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
            com.tencent.mm.sdk.b.a.ESL.l(localdx);
            if (localdx.dgq.dfO) {
              paramAnonymousl.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(2131755836));
            }
          }
          AppMethodBeat.o(98944);
          return;
          i = 0;
        }
      }
    };
    this.mXD = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        boolean bool = false;
        AppMethodBeat.i(98945);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = new ug();
          paramAnonymousMenuItem.dzx.djq = 2;
          paramAnonymousMenuItem.dzx.dzy = 17;
          Object localObject = paramAnonymousMenuItem.dzx;
          if (SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((ug.a)localObject).dzz = bool;
          paramAnonymousMenuItem.dzx.diQ = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          localObject = new Intent();
          com.tencent.mm.plugin.sns.storage.p localp = af.dtu().apK(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (localp != null) {
            ad.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localp.getSnsId());
          }
          if (localp == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localp != null) {
              break label283;
            }
          }
          label283:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localp.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.bs.d.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(98945);
            return;
            paramAnonymousMenuItem = localp.getSnsId();
            break;
          }
          SnsOnlineVideoActivity.y(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem = new ug();
          paramAnonymousMenuItem.dzx.djq = 1;
          paramAnonymousMenuItem.dzx.dzA = 4097;
          paramAnonymousMenuItem.dzx.diQ = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = af.dtu().apK(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(98945);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dxy().Etm.DaB == 15) && ((bpi)paramAnonymousMenuItem.dxy().Etm.DaC.get(0) == null))
          {
            ad.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(98945);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.bs.d.e(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = new ug();
          paramAnonymousMenuItem.dzx.djq = 3;
          paramAnonymousMenuItem.dzx.diQ = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void bKZ()
  {
    AppMethodBeat.i(98962);
    if (this.tib)
    {
      ad.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.nku.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98956);
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).HrX = SnsOnlineVideoActivity.this.xCH;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).HrY = SnsOnlineVideoActivity.this.mXD;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).GHn = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(98955);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(98955);
          }
        };
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).csG();
        AppMethodBeat.o(98956);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private void dBF()
  {
    AppMethodBeat.i(98961);
    boolean bool = com.tencent.mm.ui.ai.ju(this);
    int i = com.tencent.mm.ui.ai.eb(this);
    if ((this.tAJ) && (bool) && (this.xvN != null) && (this.xvN.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.xvN.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.xvN.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(98967);
    if ((this.xvN != null) && (this.xvN.getVisibility() == 0)) {
      this.xvN.setVisibility(8);
    }
    int k = this.qiM.getWidth();
    int j = this.qiM.getHeight();
    int i = j;
    if (this.nzY != 0)
    {
      i = j;
      if (this.nzZ != 0) {
        i = (int)(k / this.nzY * this.nzZ);
      }
    }
    if (this.nzV != null)
    {
      this.nzV.jB(k, i);
      this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
      if (this.xwb != 1.0D)
      {
        this.nzV.HqK = (1.0F / this.xwb);
        if ((this.xwc != 0) || (this.xwd != 0))
        {
          j = (int)(this.qiM.getWidth() / 2 * (1.0F - this.xwb));
          k = this.xwc;
          i = (int)(this.qiM.getHeight() / 2 + this.xwd - i / 2 * this.xwb);
          this.nzV.jD(j + k, i);
        }
      }
      this.nzV.a(this.nku, this.qdk, new e.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(98943);
          new ap().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98942);
              Intent localIntent = new Intent();
              localIntent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this));
              SnsOnlineVideoActivity.this.setResult(-1, localIntent);
              SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this);
              SnsOnlineVideoActivity.this.finish();
              SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(98942);
            }
          });
          AppMethodBeat.o(98943);
        }
        
        public final void onAnimationStart() {}
      }, null);
    }
    AppMethodBeat.o(98967);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98969);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      bKT();
      AppMethodBeat.o(98969);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98969);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131495623;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98970);
    ad.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = bt.S(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = af.dtu().apK(this.diQ);
          if (localObject1 != null)
          {
            if (!w.pF(str2)) {
              break label350;
            }
            localObject2 = new tj();
            ((tj)localObject2).dyL.dpC = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
            ((tj)localObject2).dyL.dgg = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dxX();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label178:
        Object localObject2 = this.wwP.dxy();
        int i = com.tencent.mm.plugin.sns.data.q.anS(this.gjt);
        bpi localbpi;
        if (bt.isNullOrNil(this.thumbPath))
        {
          localbpi = this.dyS;
          if (localbpi == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          ad.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.gjt, this.thumbPath, this.dyS.DMX, Integer.valueOf(this.dyS.xMj), Integer.valueOf(i) });
          j.cOB().a(this, str2, this.gjt, this.thumbPath, 43, i, ((TimeLineObject)localObject2).xns, null);
          if (str1 != null) {
            j.cOB().hm(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          break;
          label350:
          localObject2 = new tk();
          ((tk)localObject2).dyM.dpC = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
          ((tk)localObject2).dyM.dgg = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dxX();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          break label178;
          String str3 = an.iF(af.getAccSnsPath(), localbpi.Id);
          localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.d(localbpi);
          boolean bool = com.tencent.mm.vfs.i.eK((String)localObject1);
          ad.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m(localbpi);
            ad.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
            continue;
            localObject1 = this.thumbPath;
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(98970);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98968);
    this.xCD = true;
    super.onBackPressed();
    AppMethodBeat.o(98968);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98960);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ad.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      dBF();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.xvN != null) && (this.xvN.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.xvN.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131166829))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131166829);
          this.xvN.setLayoutParams(paramConfiguration);
        }
      }
      AppMethodBeat.o(98960);
      return;
    }
    AppMethodBeat.o(98960);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98959);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    super.onCreate(paramBundle);
    this.nzU = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.diQ = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.tib = getIntent().getBooleanExtra("intent_ispreview", false);
    this.fqj = getIntent().getBooleanExtra("intent_ismute", false);
    this.xCC = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.dvX = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.xpP = getIntent().getLongExtra("intent_session_timestamp", bt.eGO());
    this.xss = getIntent().getIntExtra("sns_video_scene", 2);
    this.xoY = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    ad.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.diQ, Integer.valueOf(this.scene), Boolean.valueOf(this.tib), Boolean.valueOf(this.fqj), paramBundle });
    if (!this.tib) {}
    for (;;)
    {
      try
      {
        this.wwP = af.dtu().apK(this.diQ);
        this.dyS = ((bpi)this.wwP.dxy().Etm.DaC.get(0));
        this.gjt = (an.iF(af.getAccSnsPath(), this.dyS.Id) + com.tencent.mm.plugin.sns.data.q.i(this.dyS));
        ad.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.wwP.dxX() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.lf(19)) {
            break label968;
          }
          if (!this.tib) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.tAJ = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          ad.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.xCy.setVideoScaleType(h.e.BVq);
          continue;
          this.xCy = ((OnlineVideoView)findViewById(2131306410));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          this.sessionId = (new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bt.eGO());
          this.xpP = bt.eGO();
          this.xCy.setSessionId(this.sessionId);
          this.xCy.setSessionTimestamp(this.xpP);
          if (this.wwP == null) {
            break label1218;
          }
          this.xCy.setSnsId(com.tencent.mm.plugin.sns.data.q.st(this.wwP.field_snsId));
          if ((this.wwP.dxy().Etm == null) || (this.wwP.dxy().Etm.DaC == null) || (this.wwP.dxy().Etm.DaC.isEmpty())) {
            break label1218;
          }
          this.xCy.setFilePath(at.D((bpi)this.wwP.dxy().Etm.DaC.get(0)));
          if (!com.tencent.mm.ui.ai.eRQ()) {
            break label1237;
          }
          this.xCy.setVideoScaleType(h.e.BVs);
          continue;
          this.xCy.setVideoScaleType(h.e.BVq);
          continue;
          paramBundle = this.xCy;
          Object localObject1 = this.gjt;
          Object localObject2 = this.thumbPath;
          paramBundle.xpE = ((String)localObject1);
          paramBundle.tib = true;
          paramBundle.qir.setImageBitmap(BackwardSupportUtil.b.n((String)localObject2, 1.0F));
          ad.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.tib) });
          continue;
          hideTitleView();
          this.qiM.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              SnsOnlineVideoActivity.this.bKT();
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.xvN = ((Button)findViewById(2131300511));
          localObject1 = paramBundle.dxy();
          if (localObject1 == null) {
            break label1451;
          }
          for (paramBundle = ((TimeLineObject)localObject1).wLl;; paramBundle = null)
          {
            localObject2 = new bf();
            ai.a(this, (bf)localObject2, ((TimeLineObject)localObject1).wLl);
            if (!((bf)localObject2).xIR) {
              break label1456;
            }
            this.xvN.setVisibility(0);
            this.xvN.setText(((bf)localObject2).xIS);
            this.xvN.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98954);
                if (paramBundle.CuY == null)
                {
                  AppMethodBeat.o(98954);
                  return;
                }
                SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.d.a.hYu.eL(paramBundle.CuY.hnC);
                int i = 0;
                if (this.xwg.Etm.DaB == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.xwg, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.d.a.hYu.a(SnsOnlineVideoActivity.this, paramBundle.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 19, 9, paramBundle.CuY.CuS, this.xwg.Id);
                  AppMethodBeat.o(98954);
                  return;
                  if (this.xwg.Etm.DaB == 3) {
                    i = 5;
                  } else if (this.xwg.Etm.DaB == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.mBH)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(98954);
                  return;
                  Object localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.d.a.hYu.a(SnsOnlineVideoActivity.this, paramBundle.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 19, 1, paramBundle.CuY.CuS, this.xwg.Id);
                  AppMethodBeat.o(98954);
                  return;
                  if (paramBundle.Scene == 1)
                  {
                    localObject = new ho();
                    ((ho)localObject).dlk.actionCode = 2;
                    ((ho)localObject).dlk.scene = 3;
                    ((ho)localObject).dlk.appId = paramBundle.CuY.hnC;
                    ((ho)localObject).dlk.context = SnsOnlineVideoActivity.this;
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                    com.tencent.mm.plugin.sns.d.a.hYu.a(SnsOnlineVideoActivity.this, paramBundle.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 19, 6, paramBundle.CuY.CuS, this.xwg.Id);
                    AppMethodBeat.o(98954);
                    return;
                    int j = ai.a(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new ho();
                      ((ho)localObject).dlk.context = SnsOnlineVideoActivity.this;
                      ((ho)localObject).dlk.actionCode = 2;
                      ((ho)localObject).dlk.appId = paramBundle.CuY.hnC;
                      ((ho)localObject).dlk.messageAction = paramBundle.CuY.CuU;
                      ((ho)localObject).dlk.messageExt = paramBundle.CuY.CuT;
                      ((ho)localObject).dlk.scene = 3;
                      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.d.a.hYu.a(SnsOnlineVideoActivity.this, paramBundle.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 19, 6, paramBundle.CuY.CuS, this.xwg.Id);
                      AppMethodBeat.o(98954);
                      return;
                    }
                    if (j == 2)
                    {
                      localObject = new ho();
                      ((ho)localObject).dlk.context = SnsOnlineVideoActivity.this;
                      ((ho)localObject).dlk.actionCode = 1;
                      ((ho)localObject).dlk.appId = paramBundle.CuY.hnC;
                      ((ho)localObject).dlk.messageAction = paramBundle.CuY.CuU;
                      ((ho)localObject).dlk.messageExt = paramBundle.CuY.CuT;
                      ((ho)localObject).dlk.scene = 3;
                      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.d.a.hYu.a(SnsOnlineVideoActivity.this, paramBundle.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 19, 3, paramBundle.CuY.CuS, this.xwg.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            dBF();
            break;
          }
          this.xvN.setVisibility(8);
          continue;
        }
        this.nzV = new com.tencent.mm.ui.tools.e(getContext());
        this.qiM = ((RelativeLayout)findViewById(2131306409));
        this.nku = ((FrameLayout)findViewById(2131306411));
        this.xCy = com.tencent.mm.plugin.sns.ui.video.d.dDS().aqS(this.dvX);
        if (this.xCy == null)
        {
          this.xCC = false;
          ad.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.xCC) {
          break label1025;
        }
        com.tencent.mm.plugin.sns.ui.video.d.dDS().dDT();
        paramBundle = (OnlineVideoView)findViewById(2131306410);
        if (this.xCy.getParent() != null) {
          ((ViewGroup)this.xCy.getParent()).removeView(this.xCy);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.nku.addView(this.xCy, (ViewGroup.LayoutParams)localObject1);
        if (!com.tencent.mm.ui.ai.eRQ()) {
          break;
        }
        this.xCy.setVideoScaleType(h.e.BVs);
        localObject1 = this.xCy;
        if (((OnlineVideoView)localObject1).nnt == null) {
          ((OnlineVideoView)localObject1).nnt = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).nnt.a((d.a)localObject1);
        ad.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.xCy.getCurrentPosition()), Integer.valueOf(this.xCy.getDuration()) });
        if (this.xCy.getCurrentPosition() + 500 >= this.xCy.getDuration()) {
          this.xCy.GI(0);
        }
        paramBundle.setVisibility(8);
        this.xCy.aD(this);
        this.xCy.setScene(this.xss);
        if (this.tib) {
          break label1250;
        }
        if ((!this.xCC) && (this.wwP != null)) {
          this.xCy.a(this.dyS, this.wwP.dxX(), this.wwP.field_createTime);
        }
        this.xCy.setMute(this.fqj);
        this.qdk = ((ImageView)findViewById(2131300336));
        if (!this.tib) {
          break label1327;
        }
        this.xCy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(98938);
            paramAnonymousView = SnsOnlineVideoActivity.this;
            if (SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this)) {}
            for (int i = 8;; i = 0)
            {
              paramAnonymousView.setTitleVisibility(i);
              paramAnonymousView = SnsOnlineVideoActivity.this;
              if (!SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this)) {
                bool = true;
              }
              SnsOnlineVideoActivity.a(paramAnonymousView, bool);
              AppMethodBeat.o(98938);
              return;
            }
          }
        });
        this.ktZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98948);
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, true);
            super.onLongPress(paramAnonymousMotionEvent);
            AppMethodBeat.o(98948);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(98947);
            paramAnonymousFloat1 = paramAnonymousMotionEvent2.getRawX() - paramAnonymousMotionEvent1.getRawX();
            paramAnonymousFloat2 = paramAnonymousMotionEvent2.getRawY() - paramAnonymousMotionEvent1.getRawY();
            if ((Math.abs(paramAnonymousFloat1) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth()) && (Math.abs(paramAnonymousFloat2) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight()) && (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationX(paramAnonymousFloat1);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(paramAnonymousFloat2);
            }
            AppMethodBeat.o(98947);
            return true;
          }
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98949);
            if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
              SnsOnlineVideoActivity.this.bKT();
            }
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            AppMethodBeat.o(98949);
            return bool;
          }
        });
        this.nku.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            float f1 = 1.0F;
            AppMethodBeat.i(98950);
            SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this).onTouchEvent(paramAnonymousMotionEvent);
            if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) == null) {
              SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, VelocityTracker.obtain());
            }
            if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) != null) {
              SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this).addMovement(paramAnonymousMotionEvent);
            }
            switch (paramAnonymousMotionEvent.getAction() & 0xFF)
            {
            default: 
            case 0: 
            case 1: 
              for (;;)
              {
                AppMethodBeat.o(98950);
                return false;
                SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, paramAnonymousMotionEvent.getX());
                SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, paramAnonymousMotionEvent.getY());
                if (SnsOnlineVideoActivity.h(SnsOnlineVideoActivity.this))
                {
                  SnsOnlineVideoActivity.i(SnsOnlineVideoActivity.this);
                  SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, false);
                  continue;
                  if (SnsOnlineVideoActivity.h(SnsOnlineVideoActivity.this))
                  {
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(1.0F);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(1.0F);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationX(0.0F);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(0.0F);
                    SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(1.0F);
                    SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, 1.0F);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
                    SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                    AppMethodBeat.o(98950);
                    return true;
                  }
                  if ((SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this)))
                  {
                    SnsOnlineVideoActivity.this.bKT();
                    SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                    AppMethodBeat.o(98950);
                    return true;
                  }
                  SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                }
              }
            }
            paramAnonymousView = SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            float f2 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationX();
            float f3 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationY();
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, (int)f2);
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, (int)f3);
            ad.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
            if (((Math.abs(f2) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
              if (f2 > 1.0F)
              {
                label561:
                if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(SnsOnlineVideoActivity.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  ad.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
                  SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, f1);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(f1);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(f1);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(f3);
                  SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(f1);
                }
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, true);
                label719:
                if (f3 <= 200.0F) {
                  break label819;
                }
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, false);
              }
            }
            for (;;)
            {
              if (f3 > 50.0F) {
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setOnLongClickListener(null);
              }
              if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) != null)
              {
                SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this).recycle();
                SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
              }
              if (!SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)) {
                break;
              }
              AppMethodBeat.o(98950);
              return true;
              f1 = f2;
              break label561;
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
              break label719;
              label819:
              if (f3 > 10.0F) {
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, true);
              }
            }
          }
        });
        paramBundle = this.wwP;
        if (paramBundle != null) {
          break label1349;
        }
        ad.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.tib)
        {
          if (!this.xoY) {
            addIconOptionMenu(0, 2131755707, 2131690551, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(98952);
                com.tencent.mm.ui.base.h.a(SnsOnlineVideoActivity.this, 2131764052, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(98951);
                    SnsOnlineVideoActivity.m(SnsOnlineVideoActivity.this);
                    SnsOnlineVideoActivity.this.bKT();
                    AppMethodBeat.o(98951);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(98952);
                return true;
              }
            });
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(98953);
              SnsOnlineVideoActivity.this.bKT();
              AppMethodBeat.o(98953);
              return true;
            }
          });
        }
        bKZ();
        paramBundle = new vy();
        paramBundle.dBv.type = 1;
        com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
        AppMethodBeat.o(98959);
        return;
      }
      catch (Exception paramBundle)
      {
        ad.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.gjt = paramBundle;
      continue;
      label968:
      if (!this.tib) {
        getWindow().setFlags(1024, 1024);
      }
      this.tAJ = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    ad.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.xCC) });
    if (this.xCC)
    {
      com.tencent.mm.plugin.sns.ui.video.d.dDS().aE(this);
      this.xCy.onDestroy();
      this.xCy.dzC();
      if (!this.xCD) {
        com.tencent.mm.plugin.sns.ui.video.d.dDS().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.wwP != null) && (this.wwP.dxy().Etm.DaC.size() > 0))
        {
          String str = ((bpi)this.wwP.dxy().Etm.DaC.get(0)).Url;
          int i = this.wwP.dxy().Ett;
          PInt localPInt = new PInt();
          u.a(at.D((bpi)this.wwP.dxy().Etm.DaC.get(0)), localPInt, new PInt());
          int j = this.xCy.getPlayVideoDuration();
          com.tencent.mm.plugin.report.service.h.vKh.f(15534, new Object[] { str, this.wwP.dxy().Id, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
        }
        AppMethodBeat.o(98966);
        return;
        this.xCy.onDestroy();
      }
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98965);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if (this.xCC)
    {
      ((SnsTimelineVideoView)this.xCy).dDN();
      if (!this.xCz)
      {
        ad.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.xCA) {
          break label115;
        }
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98957);
            SnsOnlineVideoActivity.this.finish();
            AppMethodBeat.o(98957);
          }
        }, 500L);
      }
    }
    for (;;)
    {
      super.onPause();
      f.d(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.xCy.onPause();
      break;
      label115:
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98939);
          SnsOnlineVideoActivity.this.finish();
          AppMethodBeat.o(98939);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98964);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if (this.xCC) {
      this.xCy.dzF();
    }
    for (;;)
    {
      this.qit = false;
      if (this.xCz) {
        this.xCz = false;
      }
      super.onResume();
      f.d(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.qit) {
        this.xCy.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
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
        if (this.nzV != null) {
          this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
        }
        if (localBundle == null) {
          this.nku.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98941);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getViewTreeObserver().removeOnPreDrawListener(this);
              if (SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this) != null) {
                SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this).a(SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this), SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this), new e.c()
                {
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(98940);
                    if (SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this) != null)
                    {
                      if (SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this))
                      {
                        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).dzF();
                        AppMethodBeat.o(98940);
                        return;
                      }
                      SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).onResume();
                    }
                    AppMethodBeat.o(98940);
                  }
                  
                  public final void onAnimationStart() {}
                });
              }
              AppMethodBeat.o(98941);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(98963);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity
 * JD-Core Version:    0.7.0.1
 */