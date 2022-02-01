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
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.a;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private float Aal;
  private int Aam;
  private int Aan;
  private OnlineVideoView AgI;
  private boolean AgJ;
  private boolean AgK;
  private boolean AgL;
  private boolean AgM;
  private boolean AgN;
  private boolean AgO;
  private boolean AgP;
  private boolean AgQ;
  n.d AgR;
  private float aZk;
  private float aZl;
  private String dFK;
  private byn dIQ;
  private String drH;
  private boolean fMP;
  private String hdP;
  private ImageView iUP;
  private boolean isAnimated;
  private GestureDetector lsn;
  private VelocityTracker mVelocityTracker;
  private com.tencent.mm.ui.widget.a.e nHu;
  private Bundle oGn;
  private com.tencent.mm.ui.tools.e oGo;
  private int oGp;
  private int oGq;
  private int oGr;
  private int oGs;
  n.e obh;
  private FrameLayout opT;
  private boolean rAV;
  private RelativeLayout rBo;
  private int scene;
  private String sessionId;
  private String thumbPath;
  private boolean vMm;
  private boolean vsW;
  private com.tencent.mm.plugin.sns.storage.p yXF;
  private boolean zTj;
  private long zUa;
  private int zWD;
  private boolean zZU;
  private Button zZX;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.rAV = true;
    this.scene = 0;
    this.AgJ = false;
    this.isAnimated = false;
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    this.AgL = false;
    this.zZU = true;
    this.zTj = false;
    this.AgM = false;
    this.dFK = "";
    this.sessionId = "";
    this.zUa = 0L;
    this.zWD = 2;
    this.AgN = false;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.AgO = false;
    this.AgP = false;
    this.AgQ = false;
    this.Aal = 1.0F;
    this.Aam = 0;
    this.Aan = 0;
    this.AgR = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        int i = 1;
        AppMethodBeat.i(98944);
        if (bt.aRe(com.tencent.mm.n.g.acA().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = com.tencent.mm.vfs.i.fv(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          boolean bool2 = com.tencent.mm.vfs.i.fv(SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
          ad.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousl.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(2131763770));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (com.tencent.mm.bs.d.aIu("favorite")) {
            paramAnonymousl.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(2131761941));
          }
          paramAnonymousl.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(2131762784));
          if (i != 0)
          {
            eb localeb = new eb();
            localeb.dpg.doX = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
            com.tencent.mm.sdk.b.a.IbL.l(localeb);
            if (localeb.dph.doF) {
              paramAnonymousl.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(2131755836));
            }
          }
          AppMethodBeat.o(98944);
          return;
          i = 0;
        }
      }
    };
    this.obh = new n.e()
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
          paramAnonymousMenuItem = new vj();
          paramAnonymousMenuItem.dJv.dsi = 2;
          paramAnonymousMenuItem.dJv.dJw = 17;
          Object localObject = paramAnonymousMenuItem.dJv;
          if (SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((vj.a)localObject).dJx = bool;
          paramAnonymousMenuItem.dJv.drH = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          localObject = new Intent();
          com.tencent.mm.plugin.sns.storage.p localp = ag.dUe().aAa(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
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
          paramAnonymousMenuItem = new vj();
          paramAnonymousMenuItem.dJv.dsi = 1;
          paramAnonymousMenuItem.dJv.dJy = 4097;
          paramAnonymousMenuItem.dJv.drH = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = ag.dUe().aAa(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(98945);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dYl().HAT.GaP == 15) && ((byn)paramAnonymousMenuItem.dYl().HAT.GaQ.get(0) == null))
          {
            ad.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(98945);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.bs.d.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = new vj();
          paramAnonymousMenuItem.dJv.dsi = 3;
          paramAnonymousMenuItem.dJv.drH = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void bWR()
  {
    AppMethodBeat.i(98962);
    if (this.vsW)
    {
      ad.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.opT.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98956);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).KJy = SnsOnlineVideoActivity.this.AgR;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).KJz = SnsOnlineVideoActivity.this.obh;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).JXC = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(98955);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(98955);
          }
        };
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).cMW();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(98956);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private void ecs()
  {
    AppMethodBeat.i(98961);
    boolean bool = com.tencent.mm.ui.al.jR(this);
    int i = com.tencent.mm.ui.al.ej(this);
    if ((this.vMm) && (bool) && (this.zZX != null) && (this.zZX.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.zZX.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.zZX.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void bWL()
  {
    AppMethodBeat.i(98967);
    if ((this.zZX != null) && (this.zZX.getVisibility() == 0)) {
      this.zZX.setVisibility(8);
    }
    int k = this.rBo.getWidth();
    int j = this.rBo.getHeight();
    int i = j;
    if (this.oGr != 0)
    {
      i = j;
      if (this.oGs != 0) {
        i = (int)(k / this.oGr * this.oGs);
      }
    }
    if (this.oGo != null)
    {
      this.oGo.jZ(k, i);
      this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
      if (this.Aal != 1.0D)
      {
        this.oGo.KIl = (1.0F / this.Aal);
        if ((this.Aam != 0) || (this.Aan != 0))
        {
          j = (int)(this.rBo.getWidth() / 2 * (1.0F - this.Aal));
          k = this.Aam;
          i = (int)(this.rBo.getHeight() / 2 + this.Aan - i / 2 * this.Aal);
          this.oGo.kb(j + k, i);
        }
      }
      this.oGo.a(this.opT, this.iUP, new e.c()
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
      bWL();
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
      Iterator localIterator = bt.U(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = ag.dUe().aAa(this.drH);
          if (localObject1 != null)
          {
            if (!w.vF(str2)) {
              break label350;
            }
            localObject2 = new ul();
            ((ul)localObject2).dIJ.dzb = com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject1);
            ((ul)localObject2).dIJ.doX = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dYK();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label178:
        Object localObject2 = this.yXF.dYl();
        int i = com.tencent.mm.plugin.sns.data.q.ayj(this.hdP);
        byn localbyn;
        if (bt.isNullOrNil(this.thumbPath))
        {
          localbyn = this.dIQ;
          if (localbyn == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          ad.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.hdP, this.thumbPath, this.dIQ.GSP, Integer.valueOf(this.dIQ.AqM), Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.dlD().a(this, str2, this.hdP, this.thumbPath, 43, i, ((TimeLineObject)localObject2).zRz, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.dlD().hP(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          break;
          label350:
          localObject2 = new um();
          ((um)localObject2).dIK.dzb = com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject1);
          ((um)localObject2).dIK.doX = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dYK();
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          break label178;
          String str3 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
          localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.d(localbyn);
          boolean bool = com.tencent.mm.vfs.i.fv((String)localObject1);
          ad.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m(localbyn);
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
    this.AgN = true;
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
      ecs();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.zZX != null) && (this.zZX.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.zZX.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131166829))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131166829);
          this.zZX.setLayoutParams(paramConfiguration);
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
    this.oGn = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.drH = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.vsW = getIntent().getBooleanExtra("intent_ispreview", false);
    this.fMP = getIntent().getBooleanExtra("intent_ismute", false);
    this.AgM = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.dFK = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.zUa = getIntent().getLongExtra("intent_session_timestamp", bt.flT());
    this.zWD = getIntent().getIntExtra("sns_video_scene", 2);
    this.zTj = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    ad.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.drH, Integer.valueOf(this.scene), Boolean.valueOf(this.vsW), Boolean.valueOf(this.fMP), paramBundle });
    if (!this.vsW) {}
    for (;;)
    {
      try
      {
        this.yXF = ag.dUe().aAa(this.drH);
        this.dIQ = ((byn)this.yXF.dYl().HAT.GaQ.get(0));
        this.hdP = (ao.jo(ag.getAccSnsPath(), this.dIQ.Id) + com.tencent.mm.plugin.sns.data.q.i(this.dIQ));
        ad.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.yXF.dYK() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.ly(19)) {
            break label969;
          }
          if (!this.vsW) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.vMm = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          ad.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.AgI.setVideoScaleType(i.e.ESM);
          continue;
          this.AgI = ((OnlineVideoView)findViewById(2131306410));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          this.sessionId = (new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bt.flT());
          this.zUa = bt.flT();
          this.AgI.setSessionId(this.sessionId);
          this.AgI.setSessionTimestamp(this.zUa);
          if (this.yXF == null) {
            break label1219;
          }
          this.AgI.setSnsId(com.tencent.mm.plugin.sns.data.q.zw(this.yXF.field_snsId));
          if ((this.yXF.dYl().HAT == null) || (this.yXF.dYl().HAT.GaQ == null) || (this.yXF.dYl().HAT.GaQ.isEmpty())) {
            break label1219;
          }
          this.AgI.setFilePath(av.D((byn)this.yXF.dYl().HAT.GaQ.get(0)));
          if (!com.tencent.mm.ui.al.fxN()) {
            break label1238;
          }
          this.AgI.setVideoScaleType(i.e.ESO);
          continue;
          this.AgI.setVideoScaleType(i.e.ESM);
          continue;
          paramBundle = this.AgI;
          Object localObject1 = this.hdP;
          Object localObject2 = this.thumbPath;
          paramBundle.zTP = ((String)localObject1);
          paramBundle.vsW = true;
          paramBundle.rAT.setImageBitmap(BackwardSupportUtil.b.o((String)localObject2, 1.0F));
          ad.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.vsW) });
          continue;
          hideTitleView();
          this.rBo.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
              SnsOnlineVideoActivity.this.bWL();
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.zZX = ((Button)findViewById(2131300511));
          localObject1 = paramBundle.dYl();
          if (localObject1 == null) {
            break label1452;
          }
          for (paramBundle = ((TimeLineObject)localObject1).znQ;; paramBundle = null)
          {
            localObject2 = new bi();
            al.a(this, (bi)localObject2, ((TimeLineObject)localObject1).znQ);
            if (!((bi)localObject2).Anq) {
              break label1457;
            }
            this.zZX.setVisibility(0);
            this.zZX.setText(((bi)localObject2).Ans);
            this.zZX.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98954);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                if (paramBundle.Fsy == null)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                }
                SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iRH.fw(paramBundle.Fsy.iht);
                int i = 0;
                if (this.Aaq.HAT.GaP == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.Aaq, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.c.a.iRH.a(SnsOnlineVideoActivity.this, paramBundle.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 19, 9, paramBundle.Fsy.Fss, this.Aaq.Id);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  if (this.Aaq.HAT.GaP == 3) {
                    i = 5;
                  } else if (this.Aaq.HAT.GaP == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.nEf)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.c.a.iRH.a(SnsOnlineVideoActivity.this, paramBundle.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 19, 1, paramBundle.Fsy.Fss, this.Aaq.Id);
                  continue;
                  if (paramBundle.Scene == 1)
                  {
                    localObject = new ic();
                    ((ic)localObject).duF.actionCode = 2;
                    ((ic)localObject).duF.scene = 3;
                    ((ic)localObject).duF.appId = paramBundle.Fsy.iht;
                    ((ic)localObject).duF.context = SnsOnlineVideoActivity.this;
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                    com.tencent.mm.plugin.sns.c.a.iRH.a(SnsOnlineVideoActivity.this, paramBundle.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 19, 6, paramBundle.Fsy.Fss, this.Aaq.Id);
                    continue;
                    int j = al.a(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new ic();
                      ((ic)localObject).duF.context = SnsOnlineVideoActivity.this;
                      ((ic)localObject).duF.actionCode = 2;
                      ((ic)localObject).duF.appId = paramBundle.Fsy.iht;
                      ((ic)localObject).duF.messageAction = paramBundle.Fsy.Fsu;
                      ((ic)localObject).duF.messageExt = paramBundle.Fsy.Fst;
                      ((ic)localObject).duF.scene = 3;
                      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iRH.a(SnsOnlineVideoActivity.this, paramBundle.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 19, 6, paramBundle.Fsy.Fss, this.Aaq.Id);
                    }
                    else if (j == 2)
                    {
                      localObject = new ic();
                      ((ic)localObject).duF.context = SnsOnlineVideoActivity.this;
                      ((ic)localObject).duF.actionCode = 1;
                      ((ic)localObject).duF.appId = paramBundle.Fsy.iht;
                      ((ic)localObject).duF.messageAction = paramBundle.Fsy.Fsu;
                      ((ic)localObject).duF.messageExt = paramBundle.Fsy.Fst;
                      ((ic)localObject).duF.scene = 3;
                      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iRH.a(SnsOnlineVideoActivity.this, paramBundle.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 19, 3, paramBundle.Fsy.Fss, this.Aaq.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            ecs();
            break;
          }
          this.zZX.setVisibility(8);
          continue;
        }
        this.oGo = new com.tencent.mm.ui.tools.e(getContext());
        this.rBo = ((RelativeLayout)findViewById(2131306409));
        this.opT = ((FrameLayout)findViewById(2131306411));
        this.AgI = com.tencent.mm.plugin.sns.ui.video.d.eeK().aBj(this.dFK);
        if (this.AgI == null)
        {
          this.AgM = false;
          ad.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.AgM) {
          break label1026;
        }
        com.tencent.mm.plugin.sns.ui.video.d.eeK().eeL();
        paramBundle = (OnlineVideoView)findViewById(2131306410);
        if (this.AgI.getParent() != null) {
          ((ViewGroup)this.AgI.getParent()).removeView(this.AgI);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.opT.addView(this.AgI, (ViewGroup.LayoutParams)localObject1);
        if (!com.tencent.mm.ui.al.fxN()) {
          break;
        }
        this.AgI.setVideoScaleType(i.e.ESO);
        localObject1 = this.AgI;
        if (((OnlineVideoView)localObject1).ota == null) {
          ((OnlineVideoView)localObject1).ota = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).ota.a((d.a)localObject1);
        ad.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.AgI.getCurrentPosition()), Integer.valueOf(this.AgI.getDuration()) });
        if (this.AgI.getCurrentPosition() + 500 >= this.AgI.getDuration()) {
          this.AgI.aB(0, true);
        }
        paramBundle.setVisibility(8);
        this.AgI.aH(this);
        this.AgI.setScene(this.zWD);
        if (this.vsW) {
          break label1251;
        }
        if ((!this.AgM) && (this.yXF != null)) {
          this.AgI.a(this.dIQ, this.yXF.dYK(), this.yXF.field_createTime);
        }
        this.AgI.setMute(this.fMP);
        this.iUP = ((ImageView)findViewById(2131300336));
        if (!this.vsW) {
          break label1328;
        }
        this.AgI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(98938);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        this.lsn = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198379);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198379);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(198378);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(198378);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98948);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
              SnsOnlineVideoActivity.this.bWL();
            }
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(98949);
            return bool;
          }
        });
        this.opT.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98950);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                    SnsOnlineVideoActivity.this.bWL();
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
            ad.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f1), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
            if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              float f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
              f1 = f2;
              if (f2 > 1.0F) {
                f1 = 1.0F;
              }
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
        paramBundle = this.yXF;
        if (paramBundle != null) {
          break label1350;
        }
        ad.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.vsW)
        {
          if (!this.zTj) {
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
                    SnsOnlineVideoActivity.this.bWL();
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
              SnsOnlineVideoActivity.this.bWL();
              AppMethodBeat.o(98953);
              return true;
            }
          });
        }
        bWR();
        paramBundle = new xc();
        paramBundle.dLv.type = 1;
        com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
        AppMethodBeat.o(98959);
        return;
      }
      catch (Exception paramBundle)
      {
        ad.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.hdP = paramBundle;
      continue;
      label969:
      if (!this.vsW) {
        getWindow().setFlags(1024, 1024);
      }
      this.vMm = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    ad.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.AgM) });
    if (this.AgM)
    {
      com.tencent.mm.plugin.sns.ui.video.d.eeK().aI(this);
      this.AgI.onDestroy();
      this.AgI.ean();
      if (!this.AgN) {
        com.tencent.mm.plugin.sns.ui.video.d.eeK().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.yXF != null) && (this.yXF.dYl().HAT.GaQ.size() > 0))
        {
          String str = ((byn)this.yXF.dYl().HAT.GaQ.get(0)).Url;
          int i = this.yXF.dYl().HBa;
          PInt localPInt = new PInt();
          u.a(av.D((byn)this.yXF.dYl().HAT.GaQ.get(0)), localPInt, new PInt());
          int j = this.AgI.getPlayVideoDuration();
          com.tencent.mm.plugin.report.service.g.yhR.f(15534, new Object[] { str, this.yXF.dYl().Id, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
        }
        AppMethodBeat.o(98966);
        return;
        this.AgI.onDestroy();
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
    if (this.AgM)
    {
      ((SnsTimelineVideoView)this.AgI).eeF();
      if (!this.AgJ)
      {
        ad.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.AgK) {
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
      f.e(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.AgI.onPause();
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
    if (this.AgM) {
      this.AgI.eaq();
    }
    for (;;)
    {
      this.rAV = false;
      if (this.AgJ) {
        this.AgJ = false;
      }
      super.onResume();
      f.e(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.rAV) {
        this.AgI.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
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
        if (this.oGo != null) {
          this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
        }
        if (localBundle == null) {
          this.opT.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
                        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).eaq();
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