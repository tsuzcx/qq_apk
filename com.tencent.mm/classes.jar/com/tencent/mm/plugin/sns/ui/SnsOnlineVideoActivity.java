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
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.uq.a;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
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
  private float aOQ;
  private float aOR;
  private String dgl;
  private String dtK;
  private btz dwE;
  private boolean ftN;
  private String gKe;
  private ImageView iBF;
  private boolean isAnimated;
  private GestureDetector kVo;
  private VelocityTracker mVelocityTracker;
  n.d nAc;
  private FrameLayout nNn;
  private com.tencent.mm.ui.widget.a.e ngY;
  private Bundle ocU;
  private com.tencent.mm.ui.tools.e ocV;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  private boolean qQV;
  private RelativeLayout qRo;
  private int scene;
  private String sessionId;
  private String thumbPath;
  private boolean uJg;
  private boolean uqr;
  private com.tencent.mm.plugin.sns.storage.p xIq;
  private boolean yBP;
  private long yCF;
  private int yFi;
  private boolean yIA;
  private Button yID;
  private float yIR;
  private int yIS;
  private int yIT;
  private OnlineVideoView yPm;
  private boolean yPn;
  private boolean yPo;
  private boolean yPp;
  private boolean yPq;
  private boolean yPr;
  private boolean yPs;
  private boolean yPt;
  private boolean yPu;
  n.c yPv;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.qQV = true;
    this.scene = 0;
    this.yPn = false;
    this.isAnimated = false;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.yPp = false;
    this.yIA = true;
    this.yBP = false;
    this.yPq = false;
    this.dtK = "";
    this.sessionId = "";
    this.yCF = 0L;
    this.yFi = 2;
    this.yPr = false;
    this.aOQ = 0.0F;
    this.aOR = 0.0F;
    this.yPs = false;
    this.yPt = false;
    this.yPu = false;
    this.yIR = 1.0F;
    this.yIS = 0;
    this.yIT = 0;
    this.yPv = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        int i = 1;
        AppMethodBeat.i(98944);
        if (bs.aLy(com.tencent.mm.m.g.ZY().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = com.tencent.mm.vfs.i.eA(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          boolean bool2 = com.tencent.mm.vfs.i.eA(SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
          ac.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousl.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(2131763770));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (com.tencent.mm.br.d.aCT("favorite")) {
            paramAnonymousl.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(2131761941));
          }
          paramAnonymousl.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(2131762784));
          if (i != 0)
          {
            dy localdy = new dy();
            localdy.ddK.ddB = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
            com.tencent.mm.sdk.b.a.GpY.l(localdy);
            if (localdy.ddL.ddj) {
              paramAnonymousl.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(2131755836));
            }
          }
          AppMethodBeat.o(98944);
          return;
          i = 0;
        }
      }
    };
    this.nAc = new n.d()
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
          paramAnonymousMenuItem = new uq();
          paramAnonymousMenuItem.dxj.dgL = 2;
          paramAnonymousMenuItem.dxj.dxk = 17;
          Object localObject = paramAnonymousMenuItem.dxj;
          if (SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((uq.a)localObject).dxl = bool;
          paramAnonymousMenuItem.dxj.dgl = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          localObject = new Intent();
          com.tencent.mm.plugin.sns.storage.p localp = af.dHR().auT(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (localp != null) {
            ac.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localp.getSnsId());
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
          paramAnonymousMenuItem = new uq();
          paramAnonymousMenuItem.dxj.dgL = 1;
          paramAnonymousMenuItem.dxj.dxm = 4097;
          paramAnonymousMenuItem.dxj.dgl = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = af.dHR().auT(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(98945);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.dLV().FQo.Ety == 15) && ((btz)paramAnonymousMenuItem.dLV().FQo.Etz.get(0) == null))
          {
            ac.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(98945);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.d.e(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(98945);
          return;
          paramAnonymousMenuItem = new uq();
          paramAnonymousMenuItem.dxj.dgL = 3;
          paramAnonymousMenuItem.dxj.dgl = SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void bSm()
  {
    AppMethodBeat.i(98962);
    if (this.uqr)
    {
      ac.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.nNn.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98956);
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).ISu = SnsOnlineVideoActivity.this.yPv;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).ISv = SnsOnlineVideoActivity.this.nAc;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).Ihj = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(98955);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(98955);
          }
        };
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).cED();
        AppMethodBeat.o(98956);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private void dQc()
  {
    AppMethodBeat.i(98961);
    boolean bool = aj.jF(this);
    int i = aj.ej(this);
    if ((this.uJg) && (bool) && (this.yID != null) && (this.yID.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.yID.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.yID.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void bSg()
  {
    AppMethodBeat.i(98967);
    if ((this.yID != null) && (this.yID.getVisibility() == 0)) {
      this.yID.setVisibility(8);
    }
    int k = this.qRo.getWidth();
    int j = this.qRo.getHeight();
    int i = j;
    if (this.ocY != 0)
    {
      i = j;
      if (this.ocZ != 0) {
        i = (int)(k / this.ocY * this.ocZ);
      }
    }
    if (this.ocV != null)
    {
      this.ocV.jN(k, i);
      this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
      if (this.yIR != 1.0D)
      {
        this.ocV.IRh = (1.0F / this.yIR);
        if ((this.yIS != 0) || (this.yIT != 0))
        {
          j = (int)(this.qRo.getWidth() / 2 * (1.0F - this.yIR));
          k = this.yIS;
          i = (int)(this.qRo.getHeight() / 2 + this.yIT - i / 2 * this.yIR);
          this.ocV.jP(j + k, i);
        }
      }
      this.ocV.a(this.nNn, this.iBF, new e.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(98943);
          new ao().post(new Runnable()
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
      ac.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      bSg();
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
    ac.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = bs.S(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = af.dHR().auT(this.dgl);
          if (localObject1 != null)
          {
            if (!w.sQ(str2)) {
              break label350;
            }
            localObject2 = new ts();
            ((ts)localObject2).dwx.dnn = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
            ((ts)localObject2).dwx.ddB = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dMu();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label178:
        Object localObject2 = this.xIq.dLV();
        int i = com.tencent.mm.plugin.sns.data.q.ate(this.gKe);
        btz localbtz;
        if (bs.isNullOrNil(this.thumbPath))
        {
          localbtz = this.dwE;
          if (localbtz == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          ac.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.gKe, this.thumbPath, this.dwE.Fjo, Integer.valueOf(this.dwE.yYY), Integer.valueOf(i) });
          j.dck().a(this, str2, this.gKe, this.thumbPath, 43, i, ((TimeLineObject)localObject2).yAj, null);
          if (str1 != null) {
            j.dck().hF(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          break;
          label350:
          localObject2 = new tt();
          ((tt)localObject2).dwy.dnn = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject1);
          ((tt)localObject2).dwy.ddB = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dMu();
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          break label178;
          String str3 = an.jc(af.getAccSnsPath(), localbtz.Id);
          localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.d(localbtz);
          boolean bool = com.tencent.mm.vfs.i.eA((String)localObject1);
          ac.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + com.tencent.mm.plugin.sns.data.q.m(localbtz);
            ac.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
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
    this.yPr = true;
    super.onBackPressed();
    AppMethodBeat.o(98968);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98960);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ac.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      dQc();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ac.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.yID != null) && (this.yID.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.yID.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131166829))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131166829);
          this.yID.setLayoutParams(paramConfiguration);
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
    this.ocU = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.dgl = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.uqr = getIntent().getBooleanExtra("intent_ispreview", false);
    this.ftN = getIntent().getBooleanExtra("intent_ismute", false);
    this.yPq = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.dtK = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.yCF = getIntent().getLongExtra("intent_session_timestamp", bs.eWj());
    this.yFi = getIntent().getIntExtra("sns_video_scene", 2);
    this.yBP = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    ac.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.dgl, Integer.valueOf(this.scene), Boolean.valueOf(this.uqr), Boolean.valueOf(this.ftN), paramBundle });
    if (!this.uqr) {}
    for (;;)
    {
      try
      {
        this.xIq = af.dHR().auT(this.dgl);
        this.dwE = ((btz)this.xIq.dLV().FQo.Etz.get(0));
        this.gKe = (an.jc(af.getAccSnsPath(), this.dwE.Id) + com.tencent.mm.plugin.sns.data.q.i(this.dwE));
        ac.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.xIq.dMu() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.kZ(19)) {
            break label968;
          }
          if (!this.uqr) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.uJg = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          ac.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.yPm.setVideoScaleType(h.e.DnH);
          continue;
          this.yPm = ((OnlineVideoView)findViewById(2131306410));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          this.sessionId = (new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bs.eWj());
          this.yCF = bs.eWj();
          this.yPm.setSessionId(this.sessionId);
          this.yPm.setSessionTimestamp(this.yCF);
          if (this.xIq == null) {
            break label1218;
          }
          this.yPm.setSnsId(com.tencent.mm.plugin.sns.data.q.wW(this.xIq.field_snsId));
          if ((this.xIq.dLV().FQo == null) || (this.xIq.dLV().FQo.Etz == null) || (this.xIq.dLV().FQo.Etz.isEmpty())) {
            break label1218;
          }
          this.yPm.setFilePath(au.D((btz)this.xIq.dLV().FQo.Etz.get(0)));
          if (!aj.fhA()) {
            break label1237;
          }
          this.yPm.setVideoScaleType(h.e.DnJ);
          continue;
          this.yPm.setVideoScaleType(h.e.DnH);
          continue;
          paramBundle = this.yPm;
          Object localObject1 = this.gKe;
          Object localObject2 = this.thumbPath;
          paramBundle.yCu = ((String)localObject1);
          paramBundle.uqr = true;
          paramBundle.qQT.setImageBitmap(BackwardSupportUtil.b.n((String)localObject2, 1.0F));
          ac.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.uqr) });
          continue;
          hideTitleView();
          this.qRo.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              SnsOnlineVideoActivity.this.bSg();
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.yID = ((Button)findViewById(2131300511));
          localObject1 = paramBundle.dLV();
          if (localObject1 == null) {
            break label1451;
          }
          for (paramBundle = ((TimeLineObject)localObject1).xXR;; paramBundle = null)
          {
            localObject2 = new bf();
            ai.a(this, (bf)localObject2, ((TimeLineObject)localObject1).xXR);
            if (!((bf)localObject2).yVH) {
              break label1456;
            }
            this.yID.setVisibility(0);
            this.yID.setText(((bf)localObject2).yVI);
            this.yID.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98954);
                if (paramBundle.DNt == null)
                {
                  AppMethodBeat.o(98954);
                  return;
                }
                SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iyy.eB(paramBundle.DNt.hOf);
                int i = 0;
                if (this.yIW.FQo.Ety == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.yIW, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.c.a.iyy.a(SnsOnlineVideoActivity.this, paramBundle.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 19, 9, paramBundle.DNt.DNn, this.yIW.Id);
                  AppMethodBeat.o(98954);
                  return;
                  if (this.yIW.FQo.Ety == 3) {
                    i = 5;
                  } else if (this.yIW.FQo.Ety == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.ndI)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(98954);
                  return;
                  Object localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.c.a.iyy.a(SnsOnlineVideoActivity.this, paramBundle.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 19, 1, paramBundle.DNt.DNn, this.yIW.Id);
                  AppMethodBeat.o(98954);
                  return;
                  if (paramBundle.Scene == 1)
                  {
                    localObject = new hv();
                    ((hv)localObject).diT.actionCode = 2;
                    ((hv)localObject).diT.scene = 3;
                    ((hv)localObject).diT.appId = paramBundle.DNt.hOf;
                    ((hv)localObject).diT.context = SnsOnlineVideoActivity.this;
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                    com.tencent.mm.plugin.sns.c.a.iyy.a(SnsOnlineVideoActivity.this, paramBundle.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 19, 6, paramBundle.DNt.DNn, this.yIW.Id);
                    AppMethodBeat.o(98954);
                    return;
                    int j = ai.a(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new hv();
                      ((hv)localObject).diT.context = SnsOnlineVideoActivity.this;
                      ((hv)localObject).diT.actionCode = 2;
                      ((hv)localObject).diT.appId = paramBundle.DNt.hOf;
                      ((hv)localObject).diT.messageAction = paramBundle.DNt.DNp;
                      ((hv)localObject).diT.messageExt = paramBundle.DNt.DNo;
                      ((hv)localObject).diT.scene = 3;
                      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iyy.a(SnsOnlineVideoActivity.this, paramBundle.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 19, 6, paramBundle.DNt.DNn, this.yIW.Id);
                      AppMethodBeat.o(98954);
                      return;
                    }
                    if (j == 2)
                    {
                      localObject = new hv();
                      ((hv)localObject).diT.context = SnsOnlineVideoActivity.this;
                      ((hv)localObject).diT.actionCode = 1;
                      ((hv)localObject).diT.appId = paramBundle.DNt.hOf;
                      ((hv)localObject).diT.messageAction = paramBundle.DNt.DNp;
                      ((hv)localObject).diT.messageExt = paramBundle.DNt.DNo;
                      ((hv)localObject).diT.scene = 3;
                      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                      com.tencent.mm.plugin.sns.c.a.iyy.a(SnsOnlineVideoActivity.this, paramBundle.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 19, 3, paramBundle.DNt.DNn, this.yIW.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            dQc();
            break;
          }
          this.yID.setVisibility(8);
          continue;
        }
        this.ocV = new com.tencent.mm.ui.tools.e(getContext());
        this.qRo = ((RelativeLayout)findViewById(2131306409));
        this.nNn = ((FrameLayout)findViewById(2131306411));
        this.yPm = com.tencent.mm.plugin.sns.ui.video.d.dSq().awb(this.dtK);
        if (this.yPm == null)
        {
          this.yPq = false;
          ac.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.yPq) {
          break label1025;
        }
        com.tencent.mm.plugin.sns.ui.video.d.dSq().dSr();
        paramBundle = (OnlineVideoView)findViewById(2131306410);
        if (this.yPm.getParent() != null) {
          ((ViewGroup)this.yPm.getParent()).removeView(this.yPm);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.nNn.addView(this.yPm, (ViewGroup.LayoutParams)localObject1);
        if (!aj.fhA()) {
          break;
        }
        this.yPm.setVideoScaleType(h.e.DnJ);
        localObject1 = this.yPm;
        if (((OnlineVideoView)localObject1).nQt == null) {
          ((OnlineVideoView)localObject1).nQt = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).nQt.a((d.a)localObject1);
        ac.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.yPm.getCurrentPosition()), Integer.valueOf(this.yPm.getDuration()) });
        if (this.yPm.getCurrentPosition() + 500 >= this.yPm.getDuration()) {
          this.yPm.IE(0);
        }
        paramBundle.setVisibility(8);
        this.yPm.aH(this);
        this.yPm.setScene(this.yFi);
        if (this.uqr) {
          break label1250;
        }
        if ((!this.yPq) && (this.xIq != null)) {
          this.yPm.a(this.dwE, this.xIq.dMu(), this.xIq.field_createTime);
        }
        this.yPm.setMute(this.ftN);
        this.iBF = ((ImageView)findViewById(2131300336));
        if (!this.uqr) {
          break label1327;
        }
        this.yPm.setOnClickListener(new View.OnClickListener()
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
        this.kVo = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
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
              SnsOnlineVideoActivity.this.bSg();
            }
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            AppMethodBeat.o(98949);
            return bool;
          }
        });
        this.nNn.setOnTouchListener(new View.OnTouchListener()
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
                    SnsOnlineVideoActivity.this.bSg();
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
            ac.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
            if (((Math.abs(f2) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
              if (f2 > 1.0F)
              {
                label561:
                if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(SnsOnlineVideoActivity.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  ac.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
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
        paramBundle = this.xIq;
        if (paramBundle != null) {
          break label1349;
        }
        ac.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.uqr)
        {
          if (!this.yBP) {
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
                    SnsOnlineVideoActivity.this.bSg();
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
              SnsOnlineVideoActivity.this.bSg();
              AppMethodBeat.o(98953);
              return true;
            }
          });
        }
        bSm();
        paramBundle = new wj();
        paramBundle.dzj.type = 1;
        com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
        AppMethodBeat.o(98959);
        return;
      }
      catch (Exception paramBundle)
      {
        ac.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.gKe = paramBundle;
      continue;
      label968:
      if (!this.uqr) {
        getWindow().setFlags(1024, 1024);
      }
      this.uJg = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    ac.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.yPq) });
    if (this.yPq)
    {
      com.tencent.mm.plugin.sns.ui.video.d.dSq().aI(this);
      this.yPm.onDestroy();
      this.yPm.dNZ();
      if (!this.yPr) {
        com.tencent.mm.plugin.sns.ui.video.d.dSq().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.xIq != null) && (this.xIq.dLV().FQo.Etz.size() > 0))
        {
          String str = ((btz)this.xIq.dLV().FQo.Etz.get(0)).Url;
          int i = this.xIq.dLV().FQv;
          PInt localPInt = new PInt();
          u.a(au.D((btz)this.xIq.dLV().FQo.Etz.get(0)), localPInt, new PInt());
          int j = this.yPm.getPlayVideoDuration();
          com.tencent.mm.plugin.report.service.h.wUl.f(15534, new Object[] { str, this.xIq.dLV().Id, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
        }
        AppMethodBeat.o(98966);
        return;
        this.yPm.onDestroy();
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
    if (this.yPq)
    {
      ((SnsTimelineVideoView)this.yPm).dSl();
      if (!this.yPn)
      {
        ac.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.yPo) {
          break label115;
        }
        new ao().postDelayed(new Runnable()
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
      this.yPm.onPause();
      break;
      label115:
      new ao().post(new Runnable()
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
    if (this.yPq) {
      this.yPm.dOc();
    }
    for (;;)
    {
      this.qQV = false;
      if (this.yPn) {
        this.yPn = false;
      }
      super.onResume();
      f.e(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.qQV) {
        this.yPm.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
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
        if (this.ocV != null) {
          this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
        }
        if (localBundle == null) {
          this.nNn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
                        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).dOc();
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