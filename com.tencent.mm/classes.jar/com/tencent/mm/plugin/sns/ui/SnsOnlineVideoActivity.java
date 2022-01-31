package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private float atq;
  private float atr;
  private String cFo;
  private bcs cIc;
  private String cpW;
  private String ctV;
  private String eNO;
  private boolean efg;
  private GestureDetector idY;
  private boolean isAnimated;
  n.d jWw;
  private FrameLayout kgX;
  private com.tencent.mm.ui.tools.e kip;
  private Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private boolean mAO;
  private RelativeLayout mBh;
  private ImageView mBi;
  private VelocityTracker mVelocityTracker;
  private boolean ndT;
  private boolean oFA;
  private com.tencent.mm.ui.widget.b.d rGv;
  private boolean rIK;
  private long rJq;
  private int rLH;
  private n rMD;
  private boolean rNR;
  private Button rNU;
  private float rOd;
  private int rOe;
  private int rOf;
  private OnlineVideoView rTW;
  private boolean rTX;
  private boolean rTY;
  private boolean rTZ;
  private boolean rUa;
  private boolean rUb;
  private boolean rUc;
  private boolean rUd;
  n.c rUe;
  private int scene;
  private String thumbPath;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(39162);
    this.mAO = true;
    this.scene = 0;
    this.rTX = false;
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.rTZ = false;
    this.rNR = true;
    this.rIK = false;
    this.rUa = false;
    this.cFo = "";
    this.cpW = "";
    this.rJq = 0L;
    this.rLH = 2;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.rOd = 1.0F;
    this.rOe = 0;
    this.rOf = 0;
    this.rUe = new SnsOnlineVideoActivity.5(this);
    this.jWw = new SnsOnlineVideoActivity.6(this);
    AppMethodBeat.o(39162);
  }
  
  private void bec()
  {
    AppMethodBeat.i(39166);
    if (this.ndT)
    {
      ab.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(39166);
      return;
    }
    this.kgX.setOnLongClickListener(new SnsOnlineVideoActivity.13(this));
    AppMethodBeat.o(39166);
  }
  
  private void cvH()
  {
    AppMethodBeat.i(39165);
    boolean bool = com.tencent.mm.ui.af.hO(this);
    int i = com.tencent.mm.ui.af.fx(this);
    if ((this.oFA) && (bool) && (this.rNU != null) && (this.rNU.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.rNU.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.rNU.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(39165);
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(39171);
    if ((this.rNU != null) && (this.rNU.getVisibility() == 0)) {
      this.rNU.setVisibility(8);
    }
    int k = this.mBh.getWidth();
    int j = this.mBh.getHeight();
    int i = j;
    if (this.kuI != 0)
    {
      i = j;
      if (this.kuJ != 0) {
        i = (int)(k / this.kuI * this.kuJ);
      }
    }
    if (this.kip != null)
    {
      this.kip.hO(k, i);
      this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
      if (this.rOd != 1.0D)
      {
        this.kip.AuR = (1.0F / this.rOd);
        if ((this.rOe != 0) || (this.rOf != 0))
        {
          j = (int)(this.mBh.getWidth() / 2 * (1.0F - this.rOd));
          k = this.rOe;
          i = (int)(this.mBh.getHeight() / 2 + this.rOf - i / 2 * this.rOd);
          this.kip.hQ(j + k, i);
        }
      }
      this.kip.a(this.kgX, this.mBi, new SnsOnlineVideoActivity.4(this), null);
    }
    AppMethodBeat.o(39171);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39172);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      bdV();
      AppMethodBeat.o(39172);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39172);
    return bool;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2130970896;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39173);
    ab.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = bo.P(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = ag.cpf().abv(this.ctV);
          if (localObject1 != null)
          {
            if (!t.lA(str2)) {
              break label349;
            }
            localObject2 = new rp();
            ((rp)localObject2).cHV.czw = i.j((n)localObject1);
            ((rp)localObject2).cHV.crk = ((n)localObject1).csH();
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        label178:
        Object localObject2 = this.rMD.csh();
        int i = i.ZO(this.eNO);
        bcs localbcs;
        if (bo.isNullOrNil(this.thumbPath))
        {
          localbcs = this.cIc;
          if (localbcs == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          ab.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.eNO, this.thumbPath, this.cIc.xrZ, Integer.valueOf(this.cIc.sdf), Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this, str2, this.eNO, this.thumbPath, 43, i, ((TimeLineObject)localObject2).rHA);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
          break;
          label349:
          localObject2 = new rq();
          ((rq)localObject2).cHW.czw = i.j((n)localObject1);
          ((rq)localObject2).cHW.crk = ((n)localObject1).csH();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          break label178;
          String str3 = ao.gl(ag.getAccSnsPath(), localbcs.Id);
          localObject1 = str3 + i.e(localbcs);
          boolean bool = com.tencent.mm.vfs.e.cN((String)localObject1);
          ab.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + i.n(localbcs);
            ab.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
            continue;
            localObject1 = this.thumbPath;
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(39173);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39164);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ab.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      cvH();
      AppMethodBeat.o(39164);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ab.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.rNU != null) && (this.rNU.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.rNU.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131428702))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131428702);
          this.rNU.setLayoutParams(paramConfiguration);
        }
      }
      AppMethodBeat.o(39164);
      return;
    }
    AppMethodBeat.o(39164);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39163);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    super.onCreate(paramBundle);
    this.kuF = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.ctV = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.ndT = getIntent().getBooleanExtra("intent_ispreview", false);
    this.efg = getIntent().getBooleanExtra("intent_ismute", false);
    this.rUa = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.cFo = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.cpW = getIntent().getStringExtra("intent_session_id");
    this.rJq = getIntent().getLongExtra("intent_session_timestamp", bo.aoy());
    this.rLH = getIntent().getIntExtra("sns_video_scene", 2);
    this.rIK = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    ab.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.ctV, Integer.valueOf(this.scene), Boolean.valueOf(this.ndT), Boolean.valueOf(this.efg), paramBundle });
    if (!this.ndT) {}
    for (;;)
    {
      try
      {
        this.rMD = ag.cpf().abv(this.ctV);
        this.cIc = ((bcs)this.rMD.csh().xTS.wOa.get(0));
        this.eNO = (ao.gl(ag.getAccSnsPath(), this.cIc.Id) + i.j(this.cIc));
        ab.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.rMD.csH() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.fv(19)) {
            break label971;
          }
          if (!this.ndT) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.oFA = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          ab.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.rTW = ((OnlineVideoView)findViewById(2131821436));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.RJ();
          this.cpW = (new p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bo.aoy());
          this.rJq = bo.aoy();
          this.rTW.setSessionId(this.cpW);
          this.rTW.setSessionTimestamp(this.rJq);
          if (this.rMD == null) {
            continue;
          }
          this.rTW.setSnsId(i.lq(this.rMD.field_snsId));
          if ((this.rMD.csh().xTS == null) || (this.rMD.csh().xTS.wOa == null) || (this.rMD.csh().xTS.wOa.isEmpty())) {
            continue;
          }
          this.rTW.setFilePath(ar.D((bcs)this.rMD.csh().xTS.wOa.get(0)));
          continue;
          paramBundle = this.rTW;
          Object localObject1 = this.eNO;
          Object localObject2 = this.thumbPath;
          paramBundle.rJe = ((String)localObject1);
          paramBundle.ndT = true;
          paramBundle.mAM.setImageBitmap(BackwardSupportUtil.b.k((String)localObject2, 1.0F));
          ab.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.ndT) });
          continue;
          hideTitleView();
          this.mBh.setOnTouchListener(new SnsOnlineVideoActivity.7(this));
          continue;
          this.rNU = ((Button)findViewById(2131827918));
          localObject1 = paramBundle.csh();
          if (localObject1 == null) {
            break label1412;
          }
          for (paramBundle = ((TimeLineObject)localObject1).rjv;; paramBundle = null)
          {
            localObject2 = new aw();
            af.a(this, (aw)localObject2, ((TimeLineObject)localObject1).rjv);
            if (!((aw)localObject2).sak) {
              break label1417;
            }
            this.rNU.setVisibility(0);
            this.rNU.setText(((aw)localObject2).sal);
            this.rNU.setOnClickListener(new SnsOnlineVideoActivity.12(this, paramBundle, (TimeLineObject)localObject1));
            if (getRequestedOrientation() == 0) {
              break;
            }
            cvH();
            break;
          }
          this.rNU.setVisibility(8);
          continue;
        }
        this.kip = new com.tencent.mm.ui.tools.e(getContext());
        this.mBh = ((RelativeLayout)findViewById(2131822188));
        this.kgX = ((FrameLayout)findViewById(2131828187));
        this.rTW = c.cxv().act(this.cFo);
        if (this.rTW == null)
        {
          this.rUa = false;
          ab.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.rUa) {
          break;
        }
        c.cxv().cxw();
        paramBundle = (OnlineVideoView)findViewById(2131821436);
        if (this.rTW.getParent() != null) {
          ((ViewGroup)this.rTW.getParent()).removeView(this.rTW);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.kgX.addView(this.rTW, (ViewGroup.LayoutParams)localObject1);
        this.rTW.setVideoScaleType(h.d.vQI);
        localObject1 = this.rTW;
        if (((OnlineVideoView)localObject1).idF == null) {
          ((OnlineVideoView)localObject1).idF = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).idF.a((d.a)localObject1);
        ab.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.rTW.getCurrentPosition()), Integer.valueOf(this.rTW.getDuration()) });
        if (this.rTW.getCurrentPosition() + 500 >= this.rTW.getDuration()) {
          this.rTW.zi(0);
        }
        paramBundle.setVisibility(8);
        this.rTW.aj(this);
        this.rTW.setScene(this.rLH);
        if (this.ndT) {
          break label1211;
        }
        if (!this.rUa) {
          this.rTW.a(this.cIc, this.rMD.csH(), this.rMD.field_createTime);
        }
        this.rTW.setMute(this.efg);
        this.mBi = ((ImageView)findViewById(2131822135));
        this.mBi.setLayerType(2, null);
        if (!this.ndT) {
          break label1288;
        }
        setMMTitle(2131296546);
        this.rTW.setOnClickListener(new SnsOnlineVideoActivity.1(this));
        this.idY = new GestureDetector(getContext(), new SnsOnlineVideoActivity.8(this));
        this.kgX.setOnTouchListener(new SnsOnlineVideoActivity.9(this));
        paramBundle = this.rMD;
        if (paramBundle != null) {
          break label1310;
        }
        ab.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.ndT)
        {
          if (!this.rIK) {
            addIconOptionMenu(0, 2131296901, 2131231500, new SnsOnlineVideoActivity.10(this));
          }
          setBackBtn(new SnsOnlineVideoActivity.11(this));
        }
        bec();
        paramBundle = new ua();
        paramBundle.cKz.type = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
        AppMethodBeat.o(39163);
        return;
      }
      catch (Exception paramBundle)
      {
        ab.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.eNO = paramBundle;
      continue;
      label971:
      if (!this.ndT) {
        getWindow().setFlags(1024, 1024);
      }
      this.oFA = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39170);
    ab.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.rUa) });
    if (this.rUa)
    {
      c.cxv().aEM();
      this.rTW.onDestroy();
      this.rTW.ctU();
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label65:
        super.onDestroy();
        if ((this.rMD != null) && (this.rMD.csh().xTS.wOa.size() > 0))
        {
          String str = ((bcs)this.rMD.csh().xTS.wOa.get(0)).Url;
          int i = this.rMD.csh().xTZ;
          PInt localPInt = new PInt();
          u.a(ar.D((bcs)this.rMD.csh().xTS.wOa.get(0)), localPInt, new PInt());
          int j = this.rTW.getPlayVideoDuration();
          h.qsU.e(15534, new Object[] { str, this.rMD.csh().Id, Integer.valueOf(i), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(j * 1000) });
        }
        AppMethodBeat.o(39170);
        return;
        this.rTW.onDestroy();
      }
    }
    catch (Exception localException)
    {
      break label65;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39169);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if (this.rUa)
    {
      ((SnsTimelineVideoView)this.rTW).cxr();
      if (!this.rTX)
      {
        ab.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.rTY) {
          break label113;
        }
        new ak().postDelayed(new SnsOnlineVideoActivity.14(this), 500L);
      }
    }
    for (;;)
    {
      super.onPause();
      com.tencent.mm.plugin.webview.ui.tools.widget.o.La(2);
      AppMethodBeat.o(39169);
      return;
      this.rTW.onPause();
      break;
      label113:
      new ak().post(new SnsOnlineVideoActivity.2(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39168);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if (this.rUa) {
      this.rTW.ctY();
    }
    for (;;)
    {
      this.mAO = false;
      if (this.rTX) {
        this.rTX = false;
      }
      super.onResume();
      com.tencent.mm.plugin.webview.ui.tools.widget.o.La(1);
      AppMethodBeat.o(39168);
      return;
      if (!this.mAO) {
        this.rTW.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(39167);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
        this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
        this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
        this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
        if (this.kip != null) {
          this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
        }
        if (localBundle == null) {
          this.kgX.getViewTreeObserver().addOnPreDrawListener(new SnsOnlineVideoActivity.3(this));
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(39167);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity
 * JD-Core Version:    0.7.0.1
 */