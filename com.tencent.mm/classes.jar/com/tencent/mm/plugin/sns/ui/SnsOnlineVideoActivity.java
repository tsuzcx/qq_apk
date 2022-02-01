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
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vn.a;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private boolean Akq;
  private long Alh;
  private int AnM;
  private int ArA;
  private boolean Arh;
  private Button Ark;
  private float Ary;
  private int Arz;
  private OnlineVideoView AxU;
  private boolean AxV;
  private boolean AxW;
  private boolean AxX;
  private boolean AxY;
  private boolean AxZ;
  private boolean Aya;
  private boolean Ayb;
  private boolean Ayc;
  n.d Ayd;
  private float aZk;
  private float aZl;
  private String dGP;
  private bzh dKe;
  private String dsN;
  private boolean fOX;
  private String hgD;
  private ImageView iXI;
  private boolean isAnimated;
  private GestureDetector lwM;
  private VelocityTracker mVelocityTracker;
  private com.tencent.mm.ui.widget.a.e nMW;
  private Bundle oMP;
  private com.tencent.mm.ui.tools.e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  n.e ogY;
  private FrameLayout ovL;
  private boolean rJg;
  private RelativeLayout rJz;
  private int scene;
  private String sessionId;
  private String thumbPath;
  private boolean vFb;
  private boolean vYq;
  private com.tencent.mm.plugin.sns.storage.p znm;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.rJg = true;
    this.scene = 0;
    this.AxV = false;
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.AxX = false;
    this.Arh = true;
    this.Akq = false;
    this.AxY = false;
    this.dGP = "";
    this.sessionId = "";
    this.Alh = 0L;
    this.AnM = 2;
    this.AxZ = false;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.Aya = false;
    this.Ayb = false;
    this.Ayc = false;
    this.Ary = 1.0F;
    this.Arz = 0;
    this.ArA = 0;
    this.Ayd = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        int i = 1;
        AppMethodBeat.i(98944);
        if (bu.aSB(com.tencent.mm.n.g.acL().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = o.fB(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          boolean bool2 = o.fB(SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
          ae.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousl.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(2131763770));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (com.tencent.mm.br.d.aJN("favorite")) {
            paramAnonymousl.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(2131761941));
          }
          paramAnonymousl.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(2131762784));
          if (i != 0)
          {
            ec localec = new ec();
            localec.dql.dqc = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
            com.tencent.mm.sdk.b.a.IvT.l(localec);
            if (localec.dqm.dpK) {
              paramAnonymousl.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(2131755836));
            }
          }
          AppMethodBeat.o(98944);
          return;
          i = 0;
        }
      }
    };
    this.ogY = new n.e()
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
          paramAnonymousMenuItem = new vn();
          paramAnonymousMenuItem.dKJ.dto = 2;
          paramAnonymousMenuItem.dKJ.dKK = 17;
          Object localObject = paramAnonymousMenuItem.dKJ;
          if (SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((vn.a)localObject).dKL = bool;
          paramAnonymousMenuItem.dKJ.dsN = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          localObject = new Intent();
          com.tencent.mm.plugin.sns.storage.p localp = ah.dXE().aBr(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (localp != null) {
            ae.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localp.getSnsId());
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
            com.tencent.mm.br.d.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(98945);
            return;
            paramAnonymousMenuItem = localp.getSnsId();
            break;
          }
          SnsOnlineVideoActivity.y(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem = new vn();
          paramAnonymousMenuItem.dKJ.dto = 1;
          paramAnonymousMenuItem.dKJ.dKM = 4097;
          paramAnonymousMenuItem.dKJ.dsN = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = ah.dXE().aBr(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(98945);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.ebP().HUG.Gtw == 15) && ((bzh)paramAnonymousMenuItem.ebP().HUG.Gtx.get(0) == null))
          {
            ae.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(98945);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.d.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = new vn();
          paramAnonymousMenuItem.dKJ.dto = 3;
          paramAnonymousMenuItem.dKJ.dsN = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void bYg()
  {
    AppMethodBeat.i(98962);
    if (this.vFb)
    {
      ae.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.ovL.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98956);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).LfS = SnsOnlineVideoActivity.this.Ayd;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).LfT = SnsOnlineVideoActivity.this.ogY;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).KtV = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(98955);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(98955);
          }
        };
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).cPF();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(98956);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private void efZ()
  {
    AppMethodBeat.i(98961);
    boolean bool = com.tencent.mm.ui.al.jY(this);
    int i = com.tencent.mm.ui.al.en(this);
    if ((this.vYq) && (bool) && (this.Ark != null) && (this.Ark.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Ark.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.Ark.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(98967);
    if ((this.Ark != null) && (this.Ark.getVisibility() == 0)) {
      this.Ark.setVisibility(8);
    }
    int k = this.rJz.getWidth();
    int j = this.rJz.getHeight();
    int i = j;
    if (this.oMT != 0)
    {
      i = j;
      if (this.oMU != 0) {
        i = (int)(k / this.oMT * this.oMU);
      }
    }
    if (this.oMQ != null)
    {
      this.oMQ.kg(k, i);
      this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
      if (this.Ary != 1.0D)
      {
        this.oMQ.LeF = (1.0F / this.Ary);
        if ((this.Arz != 0) || (this.ArA != 0))
        {
          j = (int)(this.rJz.getWidth() / 2 * (1.0F - this.Ary));
          k = this.Arz;
          i = (int)(this.rJz.getHeight() / 2 + this.ArA - i / 2 * this.Ary);
          this.oMQ.ki(j + k, i);
        }
      }
      this.oMQ.a(this.ovL, this.iXI, new e.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(98943);
          new aq().post(new Runnable()
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
      ae.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      bYa();
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
    ae.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = bu.U(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = ah.dXE().aBr(this.dsN);
          if (localObject1 != null)
          {
            if (!x.wb(str2)) {
              break label350;
            }
            localObject2 = new up();
            ((up)localObject2).dJX.dAg = r.o((com.tencent.mm.plugin.sns.storage.p)localObject1);
            ((up)localObject2).dJX.dqc = ((com.tencent.mm.plugin.sns.storage.p)localObject1).eco();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label178:
        Object localObject2 = this.znm.ebP();
        int i = r.azA(this.hgD);
        bzh localbzh;
        if (bu.isNullOrNil(this.thumbPath))
        {
          localbzh = this.dKe;
          if (localbzh == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          ae.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.hgD, this.thumbPath, this.dKe.Hmq, Integer.valueOf(this.dKe.AIa), Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.doC().a(this, str2, this.hgD, this.thumbPath, 43, i, ((TimeLineObject)localObject2).AiG, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.doC().hW(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          break;
          label350:
          localObject2 = new uq();
          ((uq)localObject2).dJY.dAg = r.o((com.tencent.mm.plugin.sns.storage.p)localObject1);
          ((uq)localObject2).dJY.dqc = ((com.tencent.mm.plugin.sns.storage.p)localObject1).eco();
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          break label178;
          String str3 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
          localObject1 = str3 + r.d(localbzh);
          boolean bool = o.fB((String)localObject1);
          ae.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + r.m(localbzh);
            ae.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
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
    this.AxZ = true;
    super.onBackPressed();
    AppMethodBeat.o(98968);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98960);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ae.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      efZ();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ae.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.Ark != null) && (this.Ark.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.Ark.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131166829))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131166829);
          this.Ark.setLayoutParams(paramConfiguration);
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
    this.oMP = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.dsN = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.vFb = getIntent().getBooleanExtra("intent_ispreview", false);
    this.fOX = getIntent().getBooleanExtra("intent_ismute", false);
    this.AxY = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.dGP = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.Alh = getIntent().getLongExtra("intent_session_timestamp", bu.fpO());
    this.AnM = getIntent().getIntExtra("sns_video_scene", 2);
    this.Akq = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    ae.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.dsN, Integer.valueOf(this.scene), Boolean.valueOf(this.vFb), Boolean.valueOf(this.fOX), paramBundle });
    if (!this.vFb) {}
    for (;;)
    {
      try
      {
        this.znm = ah.dXE().aBr(this.dsN);
        this.dKe = ((bzh)this.znm.ebP().HUG.Gtx.get(0));
        this.hgD = (ap.jv(ah.getAccSnsPath(), this.dKe.Id) + r.i(this.dKe));
        ae.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.znm.eco() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.lA(19)) {
            break label969;
          }
          if (!this.vFb) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.vYq = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          ae.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.AxU.setVideoScaleType(i.e.Flh);
          continue;
          this.AxU = ((OnlineVideoView)findViewById(2131306410));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          this.sessionId = (new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bu.fpO());
          this.Alh = bu.fpO();
          this.AxU.setSessionId(this.sessionId);
          this.AxU.setSessionTimestamp(this.Alh);
          if (this.znm == null) {
            break label1219;
          }
          this.AxU.setSnsId(r.zV(this.znm.field_snsId));
          if ((this.znm.ebP().HUG == null) || (this.znm.ebP().HUG.Gtx == null) || (this.znm.ebP().HUG.Gtx.isEmpty())) {
            break label1219;
          }
          this.AxU.setFilePath(aw.D((bzh)this.znm.ebP().HUG.Gtx.get(0)));
          if (!com.tencent.mm.ui.al.fBP()) {
            break label1238;
          }
          this.AxU.setVideoScaleType(i.e.Flj);
          continue;
          this.AxU.setVideoScaleType(i.e.Flh);
          continue;
          paramBundle = this.AxU;
          Object localObject1 = this.hgD;
          Object localObject2 = this.thumbPath;
          paramBundle.AkW = ((String)localObject1);
          paramBundle.vFb = true;
          paramBundle.rJe.setImageBitmap(BackwardSupportUtil.b.p((String)localObject2, 1.0F));
          ae.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.vFb) });
          continue;
          hideTitleView();
          this.rJz.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
              SnsOnlineVideoActivity.this.bYa();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.Ark = ((Button)findViewById(2131300511));
          localObject1 = paramBundle.ebP();
          if (localObject1 == null) {
            break label1452;
          }
          for (paramBundle = ((TimeLineObject)localObject1).zFf;; paramBundle = null)
          {
            localObject2 = new bi();
            al.a(this, (bi)localObject2, ((TimeLineObject)localObject1).zFf);
            if (!((bi)localObject2).AEE) {
              break label1457;
            }
            this.Ark.setVisibility(0);
            this.Ark.setText(((bi)localObject2).AEF);
            this.Ark.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98954);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                if (paramBundle.FKW == null)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                }
                SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iUA.fC(paramBundle.FKW.ikm);
                int i = 0;
                if (this.ArD.HUG.Gtw == 1) {
                  i = 2;
                }
                while (i.a(this.ArD, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.c.a.iUA.a(SnsOnlineVideoActivity.this, paramBundle.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 19, 9, paramBundle.FKW.FKQ, this.ArD.Id);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  if (this.ArD.HUG.Gtw == 3) {
                    i = 5;
                  } else if (this.ArD.HUG.Gtw == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.nJA)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.c.a.iUA.a(SnsOnlineVideoActivity.this, paramBundle.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 19, 1, paramBundle.FKW.FKQ, this.ArD.Id);
                  continue;
                  if (paramBundle.Scene == 1)
                  {
                    localObject = new id();
                    ((id)localObject).dvK.actionCode = 2;
                    ((id)localObject).dvK.scene = 3;
                    ((id)localObject).dvK.appId = paramBundle.FKW.ikm;
                    ((id)localObject).dvK.context = SnsOnlineVideoActivity.this;
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                    com.tencent.mm.plugin.sns.c.a.iUA.a(SnsOnlineVideoActivity.this, paramBundle.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 19, 6, paramBundle.FKW.FKQ, this.ArD.Id);
                    continue;
                    int j = al.a(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new id();
                      ((id)localObject).dvK.context = SnsOnlineVideoActivity.this;
                      ((id)localObject).dvK.actionCode = 2;
                      ((id)localObject).dvK.appId = paramBundle.FKW.ikm;
                      ((id)localObject).dvK.messageAction = paramBundle.FKW.FKS;
                      ((id)localObject).dvK.messageExt = paramBundle.FKW.FKR;
                      ((id)localObject).dvK.scene = 3;
                      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iUA.a(SnsOnlineVideoActivity.this, paramBundle.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 19, 6, paramBundle.FKW.FKQ, this.ArD.Id);
                    }
                    else if (j == 2)
                    {
                      localObject = new id();
                      ((id)localObject).dvK.context = SnsOnlineVideoActivity.this;
                      ((id)localObject).dvK.actionCode = 1;
                      ((id)localObject).dvK.appId = paramBundle.FKW.ikm;
                      ((id)localObject).dvK.messageAction = paramBundle.FKW.FKS;
                      ((id)localObject).dvK.messageExt = paramBundle.FKW.FKR;
                      ((id)localObject).dvK.scene = 3;
                      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iUA.a(SnsOnlineVideoActivity.this, paramBundle.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 19, 3, paramBundle.FKW.FKQ, this.ArD.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            efZ();
            break;
          }
          this.Ark.setVisibility(8);
          continue;
        }
        this.oMQ = new com.tencent.mm.ui.tools.e(getContext());
        this.rJz = ((RelativeLayout)findViewById(2131306409));
        this.ovL = ((FrameLayout)findViewById(2131306411));
        this.AxU = com.tencent.mm.plugin.sns.ui.video.d.eir().aCA(this.dGP);
        if (this.AxU == null)
        {
          this.AxY = false;
          ae.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.AxY) {
          break label1026;
        }
        com.tencent.mm.plugin.sns.ui.video.d.eir().eis();
        paramBundle = (OnlineVideoView)findViewById(2131306410);
        if (this.AxU.getParent() != null) {
          ((ViewGroup)this.AxU.getParent()).removeView(this.AxU);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.ovL.addView(this.AxU, (ViewGroup.LayoutParams)localObject1);
        if (!com.tencent.mm.ui.al.fBP()) {
          break;
        }
        this.AxU.setVideoScaleType(i.e.Flj);
        localObject1 = this.AxU;
        if (((OnlineVideoView)localObject1).ozB == null) {
          ((OnlineVideoView)localObject1).ozB = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).ozB.a((d.a)localObject1);
        ae.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.AxU.getCurrentPosition()), Integer.valueOf(this.AxU.getDuration()) });
        if (this.AxU.getCurrentPosition() + 500 >= this.AxU.getDuration()) {
          this.AxU.aE(0, true);
        }
        paramBundle.setVisibility(8);
        this.AxU.aI(this);
        this.AxU.setScene(this.AnM);
        if (this.vFb) {
          break label1251;
        }
        if ((!this.AxY) && (this.znm != null)) {
          this.AxU.a(this.dKe, this.znm.eco(), this.znm.field_createTime);
        }
        this.AxU.setMute(this.fOX);
        this.iXI = ((ImageView)findViewById(2131300336));
        if (!this.vFb) {
          break label1328;
        }
        this.AxU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(98938);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98938);
              return;
            }
          }
        });
        this.lwM = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(219920);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219920);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(219919);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219919);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98948);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, true);
            super.onLongPress(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
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
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
              SnsOnlineVideoActivity.this.bYa();
            }
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(98949);
            return bool;
          }
        });
        this.ovL.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98950);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(98950);
                    return true;
                  }
                  if ((SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this)))
                  {
                    SnsOnlineVideoActivity.this.bYa();
                    SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
            float f1 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationX();
            float f3 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationY();
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, (int)f1);
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, (int)f3);
            ae.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f1), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
            if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              float f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
              f1 = f2;
              if (f2 > 1.0F) {
                f1 = 1.0F;
              }
              if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(SnsOnlineVideoActivity.this))) || ((j < 0) && (f1 >= 0.5D)))
              {
                ae.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(f3);
                SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(f1);
              }
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, true);
              label856:
              if (f3 <= 200.0F) {
                break label965;
              }
              SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, false);
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
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(98950);
              return true;
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
              break label856;
              label965:
              if (f3 > 10.0F) {
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, true);
              }
            }
          }
        });
        paramBundle = this.znm;
        if (paramBundle != null) {
          break label1350;
        }
        ae.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.vFb)
        {
          if (!this.Akq) {
            addIconOptionMenu(0, 2131755707, 2131690551, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(98952);
                h.a(SnsOnlineVideoActivity.this, 2131764052, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(98951);
                    SnsOnlineVideoActivity.m(SnsOnlineVideoActivity.this);
                    SnsOnlineVideoActivity.this.bYa();
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
              SnsOnlineVideoActivity.this.bYa();
              AppMethodBeat.o(98953);
              return true;
            }
          });
        }
        bYg();
        paramBundle = new xg();
        paramBundle.dMK.type = 1;
        com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
        AppMethodBeat.o(98959);
        return;
      }
      catch (Exception paramBundle)
      {
        ae.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.hgD = paramBundle;
      continue;
      label969:
      if (!this.vFb) {
        getWindow().setFlags(1024, 1024);
      }
      this.vYq = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    ae.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.AxY) });
    if (this.AxY)
    {
      com.tencent.mm.plugin.sns.ui.video.d.eir().aJ(this);
      this.AxU.onDestroy();
      this.AxU.edT();
      if (!this.AxZ) {
        com.tencent.mm.plugin.sns.ui.video.d.eir().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.znm != null) && (this.znm.ebP().HUG.Gtx.size() > 0))
        {
          String str = ((bzh)this.znm.ebP().HUG.Gtx.get(0)).Url;
          int i = this.znm.ebP().HUN;
          PInt localPInt = new PInt();
          u.a(aw.D((bzh)this.znm.ebP().HUG.Gtx.get(0)), localPInt, new PInt());
          int j = this.AxU.getPlayVideoDuration();
          com.tencent.mm.plugin.report.service.g.yxI.f(15534, new Object[] { str, this.znm.ebP().Id, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
        }
        AppMethodBeat.o(98966);
        return;
        this.AxU.onDestroy();
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
    if (this.AxY)
    {
      ((SnsTimelineVideoView)this.AxU).ein();
      if (!this.AxV)
      {
        ae.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.AxW) {
          break label115;
        }
        new aq().postDelayed(new Runnable()
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
      f.e(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.AxU.onPause();
      break;
      label115:
      new aq().post(new Runnable()
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
    if (this.AxY) {
      this.AxU.edW();
    }
    for (;;)
    {
      this.rJg = false;
      if (this.AxV) {
        this.AxV = false;
      }
      super.onResume();
      f.e(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.rJg) {
        this.AxU.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
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
        if (this.oMQ != null) {
          this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
        }
        if (localBundle == null) {
          this.ovL.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
                        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).edW();
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