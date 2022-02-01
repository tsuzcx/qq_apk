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
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.a.wn.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private SnsInfo DsC;
  private float EAC;
  private int EAD;
  private int EAE;
  private boolean EAg;
  private Button EAj;
  private OnlineVideoView EHk;
  private boolean EHl;
  private boolean EHm;
  private boolean EHn;
  private boolean EHo;
  private boolean EHp;
  private boolean EHq;
  private boolean EHr;
  private boolean EHs;
  o.f EHt;
  private long EtT;
  private boolean Etd;
  private int Ewx;
  private float aZg;
  private float aZh;
  private String dJX;
  private String dYy;
  private cnb ebR;
  private String fullPath;
  private boolean guh;
  private boolean isAnimated;
  private boolean isPreview;
  private ImageView jUG;
  private GestureDetector mDJ;
  private VelocityTracker mVelocityTracker;
  private com.tencent.mm.ui.widget.a.e oXS;
  private FrameLayout pJg;
  o.g pso;
  private Bundle qaD;
  private com.tencent.mm.ui.tools.e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  private int scene;
  private String sessionId;
  private String thumbPath;
  private boolean tiS;
  private RelativeLayout tjk;
  private boolean zss;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.tiS = true;
    this.scene = 0;
    this.EHl = false;
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.EHn = false;
    this.EAg = true;
    this.Etd = false;
    this.EHo = false;
    this.dYy = "";
    this.sessionId = "";
    this.EtT = 0L;
    this.Ewx = 2;
    this.EHp = false;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.EAC = 1.0F;
    this.EAD = 0;
    this.EAE = 0;
    this.EHt = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        int i = 1;
        AppMethodBeat.i(203624);
        if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = s.YS(SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
          boolean bool2 = s.YS(SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this));
          Log.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymousm.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(2131765992));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (c.aZU("favorite")) {
            paramAnonymousm.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(2131763947));
          }
          paramAnonymousm.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(2131764871));
          if (i != 0)
          {
            ef localef = new ef();
            localef.dHy.dHp = SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this);
            EventCenter.instance.publish(localef);
            if (localef.dHz.dGX) {
              paramAnonymousm.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(2131755922));
            }
          }
          AppMethodBeat.o(203624);
          return;
          i = 0;
        }
      }
    };
    this.pso = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        boolean bool = false;
        AppMethodBeat.i(203625);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(203625);
          return;
          paramAnonymousMenuItem = new wn();
          paramAnonymousMenuItem.ecy.dKy = 2;
          paramAnonymousMenuItem.ecy.ecz = 17;
          Object localObject = paramAnonymousMenuItem.ecy;
          if (SnsOnlineVideoActivity.y(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((wn.a)localObject).ecA = bool;
          paramAnonymousMenuItem.ecy.dJX = SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
          AppMethodBeat.o(203625);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = aj.faO().aQm(SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this));
          if (localSnsInfo != null) {
            Log.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localSnsInfo.getSnsId());
          }
          if (localSnsInfo == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localSnsInfo != null) {
              break label284;
            }
          }
          label284:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localSnsInfo.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
            c.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(203625);
            return;
            paramAnonymousMenuItem = localSnsInfo.getSnsId();
            break;
          }
          SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem = new wn();
          paramAnonymousMenuItem.ecy.dKy = 1;
          paramAnonymousMenuItem.ecy.ecB = 4097;
          paramAnonymousMenuItem.ecy.dJX = SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
          AppMethodBeat.o(203625);
          return;
          paramAnonymousMenuItem = aj.faO().aQm(SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(203625);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.LoU == 15) && ((cnb)paramAnonymousMenuItem.getTimeLine().ContentObj.LoV.get(0) == null))
          {
            Log.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(203625);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          c.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(203625);
          return;
          paramAnonymousMenuItem = new wn();
          paramAnonymousMenuItem.ecy.dKy = 3;
          paramAnonymousMenuItem.ecy.dJX = SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void cvW()
  {
    AppMethodBeat.i(98962);
    if (this.isPreview)
    {
      Log.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.pJg.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98956);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).HLX = SnsOnlineVideoActivity.this.EHt;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).HLY = SnsOnlineVideoActivity.this.pso;
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(98955);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(98955);
          }
        };
        SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this).dGm();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(98956);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private void fiz()
  {
    AppMethodBeat.i(98961);
    boolean bool = com.tencent.mm.ui.ao.aA(this);
    int i = com.tencent.mm.ui.ao.aD(this);
    if ((this.zss) && (bool) && (this.EAj != null) && (this.EAj.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.EAj.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.EAj.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(98967);
    if ((this.EAj != null) && (this.EAj.getVisibility() == 0)) {
      this.EAj.setVisibility(8);
    }
    int k = this.tjk.getWidth();
    int j = this.tjk.getHeight();
    int i = j;
    if (this.qaH != 0)
    {
      i = j;
      if (this.qaI != 0) {
        i = (int)(k / this.qaH * this.qaI);
      }
    }
    if (this.qaE != null)
    {
      this.qaE.ls(k, i);
      this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
      if (this.EAC != 1.0D)
      {
        this.qaE.QtG = (1.0F / this.EAC);
        if ((this.EAD != 0) || (this.EAE != 0))
        {
          j = (int)(this.tjk.getWidth() / 2 * (1.0F - this.EAC));
          k = this.EAD;
          i = (int)(this.tjk.getHeight() / 2 + this.EAE - i / 2 * this.EAC);
          this.qaE.lu(j + k, i);
        }
      }
      this.qaE.a(this.pJg, this.jUG, new e.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(203623);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203622);
              Intent localIntent = new Intent();
              localIntent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this));
              SnsOnlineVideoActivity.this.setResult(-1, localIntent);
              SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this);
              SnsOnlineVideoActivity.this.finish();
              SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(203622);
            }
          });
          AppMethodBeat.o(203623);
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
      Log.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      cvQ();
      AppMethodBeat.o(98969);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98969);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496522;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98970);
    Log.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((4097 == paramInt1) && (-1 == paramInt2))
    {
      Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      String str1 = paramIntent.getStringExtra("custom_send_text");
      Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (this.scene == 0)
        {
          localObject1 = aj.faO().aQm(this.dJX);
          if (localObject1 != null)
          {
            if (!ab.Eq(str2)) {
              break label350;
            }
            localObject2 = new vn();
            ((vn)localObject2).ebK.dRS = r.v((SnsInfo)localObject1);
            ((vn)localObject2).ebK.dHp = ((SnsInfo)localObject1).getLocalid();
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
        label178:
        Object localObject2 = this.DsC.getTimeLine();
        int i = r.aOx(this.fullPath);
        cnb localcnb;
        if (Util.isNullOrNil(this.thumbPath))
        {
          localcnb = this.ebR;
          if (localcnb == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          Log.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.fullPath, this.thumbPath, this.ebR.MsF, Integer.valueOf(this.ebR.ERX), Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.thumbPath, 43, i, ((TimeLineObject)localObject2).statExtStr, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.eir().iF(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
          break;
          label350:
          localObject2 = new vo();
          ((vo)localObject2).ebL.dRS = r.v((SnsInfo)localObject1);
          ((vo)localObject2).ebL.dHp = ((SnsInfo)localObject1).getLocalid();
          EventCenter.instance.publish((IEvent)localObject2);
          break label178;
          String str3 = ar.ki(aj.getAccSnsPath(), localcnb.Id);
          localObject1 = str3 + r.e(localcnb);
          boolean bool = s.YS((String)localObject1);
          Log.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + r.n(localcnb);
            Log.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
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
    this.EHp = true;
    super.onBackPressed();
    AppMethodBeat.o(98968);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98960);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      fiz();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.EAj != null) && (this.EAj.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.EAj.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(2131166956))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(2131166956);
          this.EAj.setLayoutParams(paramConfiguration);
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
    this.qaD = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.dJX = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.isPreview = getIntent().getBooleanExtra("intent_ispreview", false);
    this.guh = getIntent().getBooleanExtra("intent_ismute", false);
    this.EHo = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.dYy = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.EtT = getIntent().getLongExtra("intent_session_timestamp", Util.nowMilliSecond());
    this.Ewx = getIntent().getIntExtra("sns_video_scene", 2);
    this.Etd = getIntent().getBooleanExtra("KBlockAdd", false);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    Log.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.dJX, Integer.valueOf(this.scene), Boolean.valueOf(this.isPreview), Boolean.valueOf(this.guh), paramBundle });
    if (com.tencent.mm.q.a.aty()) {
      this.guh = true;
    }
    if (!this.isPreview) {}
    for (;;)
    {
      try
      {
        this.DsC = aj.faO().aQm(this.dJX);
        this.ebR = ((cnb)this.DsC.getTimeLine().ContentObj.LoV.get(0));
        this.fullPath = (ar.ki(aj.getAccSnsPath(), this.ebR.Id) + r.j(this.ebR));
        Log.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.DsC.getLocalid() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.oD(19)) {
            break label980;
          }
          if (!this.isPreview) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.zss = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          Log.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.EHk.setVideoScaleType(i.e.KbZ);
          continue;
          this.EHk = ((OnlineVideoView)findViewById(2131309841));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.g.aAf();
          this.sessionId = (new p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.EtT = Util.nowMilliSecond();
          this.EHk.setSessionId(this.sessionId);
          this.EHk.setSessionTimestamp(this.EtT);
          if (this.DsC == null) {
            break label1230;
          }
          this.EHk.setSnsId(r.Jb(this.DsC.field_snsId));
          if ((this.DsC.getTimeLine().ContentObj == null) || (this.DsC.getTimeLine().ContentObj.LoV == null) || (this.DsC.getTimeLine().ContentObj.LoV.isEmpty())) {
            break label1230;
          }
          this.EHk.setFilePath(ay.E((cnb)this.DsC.getTimeLine().ContentObj.LoV.get(0)));
          if (!com.tencent.mm.ui.ao.gJK()) {
            break label1249;
          }
          this.EHk.setVideoScaleType(i.e.Kcb);
          continue;
          this.EHk.setVideoScaleType(i.e.KbZ);
          continue;
          paramBundle = this.EHk;
          Object localObject1 = this.fullPath;
          Object localObject2 = this.thumbPath;
          paramBundle.EtI = ((String)localObject1);
          paramBundle.isPreview = true;
          paramBundle.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile((String)localObject2, 1.0F));
          Log.i(paramBundle.TAG, "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.isPreview) });
          continue;
          hideTitleView();
          this.tjk.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              SnsOnlineVideoActivity.this.cvQ();
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.EAj = ((Button)findViewById(2131302038));
          localObject1 = paramBundle.getTimeLine();
          if (localObject1 == null) {
            break label1464;
          }
          for (paramBundle = ((TimeLineObject)localObject1).actionInfo;; paramBundle = null)
          {
            localObject2 = new bl();
            ao.a(this, (bl)localObject2, ((TimeLineObject)localObject1).actionInfo);
            if (!((bl)localObject2).EOf) {
              break label1469;
            }
            this.EAj.setVisibility(0);
            this.EAj.setText(((bl)localObject2).EOg);
            this.EAj.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98954);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                if (paramBundle.KEw == null)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                }
                SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.c.a.jRu.go(paramBundle.KEw.jfi);
                int i = 0;
                if (this.EAH.ContentObj.LoU == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.EAH, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, paramBundle.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 19, 9, paramBundle.KEw.KEq, this.EAH.Id);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  if (this.EAH.ContentObj.LoU == 3) {
                    i = 5;
                  } else if (this.EAH.ContentObj.LoU == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.oUv)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(98954);
                  return;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, paramBundle.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 19, 1, paramBundle.KEw.KEq, this.EAH.Id);
                  continue;
                  if (paramBundle.Scene == 1)
                  {
                    localObject = new is();
                    ((is)localObject).dNr.actionCode = 2;
                    ((is)localObject).dNr.scene = 3;
                    ((is)localObject).dNr.appId = paramBundle.KEw.jfi;
                    ((is)localObject).dNr.context = SnsOnlineVideoActivity.this;
                    EventCenter.instance.publish((IEvent)localObject);
                    com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, paramBundle.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 19, 6, paramBundle.KEw.KEq, this.EAH.Id);
                    continue;
                    int j = ao.b(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new is();
                      ((is)localObject).dNr.context = SnsOnlineVideoActivity.this;
                      ((is)localObject).dNr.actionCode = 2;
                      ((is)localObject).dNr.appId = paramBundle.KEw.jfi;
                      ((is)localObject).dNr.messageAction = paramBundle.KEw.KEs;
                      ((is)localObject).dNr.messageExt = paramBundle.KEw.KEr;
                      ((is)localObject).dNr.scene = 3;
                      EventCenter.instance.publish((IEvent)localObject);
                      com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, paramBundle.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 19, 6, paramBundle.KEw.KEq, this.EAH.Id);
                    }
                    else if (j == 2)
                    {
                      localObject = new is();
                      ((is)localObject).dNr.context = SnsOnlineVideoActivity.this;
                      ((is)localObject).dNr.actionCode = 1;
                      ((is)localObject).dNr.appId = paramBundle.KEw.jfi;
                      ((is)localObject).dNr.messageAction = paramBundle.KEw.KEs;
                      ((is)localObject).dNr.messageExt = paramBundle.KEw.KEr;
                      ((is)localObject).dNr.scene = 3;
                      EventCenter.instance.publish((IEvent)localObject);
                      com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, paramBundle.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 19, 3, paramBundle.KEw.KEq, this.EAH.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            fiz();
            break;
          }
          this.EAj.setVisibility(8);
          continue;
        }
        this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        this.tjk = ((RelativeLayout)findViewById(2131309840));
        this.pJg = ((FrameLayout)findViewById(2131309842));
        this.EHk = com.tencent.mm.plugin.sns.ui.video.d.fkS().aRw(this.dYy);
        if (this.EHk == null)
        {
          this.EHo = false;
          Log.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.EHo) {
          break label1037;
        }
        com.tencent.mm.plugin.sns.ui.video.d.fkS().fkT();
        paramBundle = (OnlineVideoView)findViewById(2131309841);
        if (this.EHk.getParent() != null) {
          ((ViewGroup)this.EHk.getParent()).removeView(this.EHk);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.pJg.addView(this.EHk, (ViewGroup.LayoutParams)localObject1);
        if (!com.tencent.mm.ui.ao.gJK()) {
          break;
        }
        this.EHk.setVideoScaleType(i.e.Kcb);
        localObject1 = this.EHk;
        if (((OnlineVideoView)localObject1).pNk == null) {
          ((OnlineVideoView)localObject1).pNk = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).pNk.a((d.a)localObject1);
        Log.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.EHk.getCurrentPosition()), Integer.valueOf(this.EHk.getDuration()) });
        if (this.EHk.getCurrentPosition() + 500 >= this.EHk.getDuration()) {
          this.EHk.aT(0, true);
        }
        paramBundle.setVisibility(8);
        this.EHk.aM(this);
        this.EHk.setScene(this.Ewx);
        if (this.isPreview) {
          break label1262;
        }
        if ((!this.EHo) && (this.DsC != null)) {
          this.EHk.a(this.ebR, this.DsC.getLocalid(), this.DsC.getCreateTime());
        }
        this.EHk.setMute(this.guh);
        this.jUG = ((ImageView)findViewById(2131301854));
        if (!this.isPreview) {
          break label1340;
        }
        this.EHk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(98938);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(203627);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(203627);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(203626);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(203626);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98948);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
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
            localb.bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
            if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
              SnsOnlineVideoActivity.this.cvQ();
            }
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(98949);
            return bool;
          }
        });
        this.pJg.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(98950);
            paramAnonymousView = SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this);
            com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, locala.axQ(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                    SnsOnlineVideoActivity.this.cvQ();
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
            float f1 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationX();
            float f3 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationY();
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, (int)f1);
            SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, (int)f3);
            Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f1), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
            if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
            {
              float f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
              f1 = f2;
              if (f2 > 1.0F) {
                f1 = 1.0F;
              }
              if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(SnsOnlineVideoActivity.this))) || ((j < 0) && (f1 >= 0.5D)))
              {
                Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(f1);
                SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(f3);
                SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(f1);
              }
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, true);
              label776:
              if (f3 <= 200.0F) {
                break label870;
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
              AppMethodBeat.o(98950);
              return true;
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
              break label776;
              label870:
              if (f3 > 10.0F) {
                SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, true);
              }
            }
          }
        });
        paramBundle = this.DsC;
        if (paramBundle != null) {
          break label1362;
        }
        Log.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        if (this.isPreview)
        {
          if (!this.Etd) {
            addIconOptionMenu(0, 2131755778, 2131690780, new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(98952);
                com.tencent.mm.ui.base.h.a(SnsOnlineVideoActivity.this, 2131766291, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(98951);
                    SnsOnlineVideoActivity.m(SnsOnlineVideoActivity.this);
                    SnsOnlineVideoActivity.this.cvQ();
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
              SnsOnlineVideoActivity.this.cvQ();
              AppMethodBeat.o(98953);
              return true;
            }
          });
        }
        cvW();
        paramBundle = new yh();
        paramBundle.eeC.type = 1;
        EventCenter.instance.publish(paramBundle);
        AppMethodBeat.o(98959);
        return;
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.fullPath = paramBundle;
      continue;
      label980:
      if (!this.isPreview) {
        getWindow().setFlags(1024, 1024);
      }
      this.zss = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    Log.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.EHo) });
    if (this.EHo)
    {
      com.tencent.mm.plugin.sns.ui.video.d.fkS().aN(this);
      this.EHk.onDestroy();
      this.EHk.fgl();
      if (!this.EHp) {
        com.tencent.mm.plugin.sns.ui.video.d.fkS().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.DsC != null) && (this.DsC.getTimeLine().ContentObj.LoV.size() > 0))
        {
          final int i = this.EHk.getPlayVideoDuration();
          final String str = ((cnb)this.DsC.getTimeLine().ContentObj.LoV.get(0)).Url;
          final int j = this.DsC.getTimeLine().sightFolded;
          com.tencent.f.h.RTc.aY(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98957);
              PInt localPInt = new PInt();
              u.a(ay.E((cnb)SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this).getTimeLine().ContentObj.LoV.get(0)), localPInt, new PInt());
              com.tencent.mm.plugin.report.service.h.CyF.a(15534, new Object[] { str, SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this).getTimeLine().Id, Integer.valueOf(j), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(i * 1000) });
              AppMethodBeat.o(98957);
            }
          });
        }
        AppMethodBeat.o(98966);
        return;
        this.EHk.onDestroy();
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
    if (this.EHo)
    {
      ((SnsTimelineVideoView)this.EHk).fkO();
      if (!this.EHl)
      {
        Log.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.EHm) {
          break label115;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98939);
            SnsOnlineVideoActivity.this.finish();
            AppMethodBeat.o(98939);
          }
        }, 500L);
      }
    }
    for (;;)
    {
      super.onPause();
      com.tencent.mm.plugin.ball.f.f.e(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.EHk.onPause();
      break;
      label115:
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203619);
          SnsOnlineVideoActivity.this.finish();
          AppMethodBeat.o(203619);
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
    if (this.EHo) {
      this.EHk.eYd();
    }
    for (;;)
    {
      this.tiS = false;
      if (this.EHl) {
        this.EHl = false;
      }
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.e(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.tiS) {
        this.EHk.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
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
        if (this.qaE != null) {
          this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        }
        if (localBundle == null) {
          this.pJg.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(203621);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getViewTreeObserver().removeOnPreDrawListener(this);
              if (SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this) != null) {
                SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).a(SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this), SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this), new e.c()
                {
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(203620);
                    if (SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this) != null)
                    {
                      if (SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this))
                      {
                        SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this).eYd();
                        AppMethodBeat.o(203620);
                        return;
                      }
                      SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this).onResume();
                    }
                    AppMethodBeat.o(203620);
                  }
                  
                  public final void onAnimationStart() {}
                });
              }
              AppMethodBeat.o(203621);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity
 * JD-Core Version:    0.7.0.1
 */