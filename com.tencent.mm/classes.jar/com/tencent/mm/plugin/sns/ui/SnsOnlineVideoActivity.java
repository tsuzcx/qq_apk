package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.ws;
import com.tencent.mm.f.a.wt;
import com.tencent.mm.f.a.xt;
import com.tencent.mm.f.a.xt.a;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private boolean EXT;
  private SnsInfo Jzk;
  private boolean KGA;
  private long KHs;
  private int KKq;
  private boolean KNU;
  private Button KNX;
  private float KOu;
  private int KOv;
  private int KOw;
  private OnlineVideoView KVf;
  private FrameLayout KVg;
  private boolean KVh;
  private boolean KVi;
  private boolean KVj;
  private boolean KVk;
  private boolean KVl;
  private String KVm;
  private LinearLayout KVn;
  private String KVo;
  private int KVp;
  private boolean KVq;
  private boolean KVr;
  private boolean KVs;
  q.f KVt;
  private float aIC;
  private float aID;
  private String fCM;
  private String fSp;
  private cvt fVT;
  private String fullPath;
  private boolean iYs;
  private boolean isAnimated;
  private boolean isPreview;
  private ImageView mLT;
  private VelocityTracker mVelocityTracker;
  private GestureDetector pCU;
  private com.tencent.mm.ui.widget.a.e rZT;
  q.g sBv;
  private int scene;
  private String sessionId;
  private String thumbPath;
  private Bundle twA;
  private com.tencent.mm.ui.tools.f twB;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  private RelativeLayout wPB;
  private boolean wPj;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.wPj = true;
    this.scene = 0;
    this.KVh = false;
    this.isAnimated = false;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.KVj = false;
    this.KNU = true;
    this.KGA = false;
    this.KVk = false;
    this.fSp = "";
    this.sessionId = "";
    this.KHs = 0L;
    this.KKq = 2;
    this.KVl = false;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.KOu = 1.0F;
    this.KOv = 0;
    this.KOw = 0;
    this.KVt = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        int i = 1;
        AppMethodBeat.i(204551);
        if (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = u.agG(SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this));
          boolean bool2 = u.agG(SnsOnlineVideoActivity.y(SnsOnlineVideoActivity.this));
          Log.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramAnonymouso.add(0, 3, 0, SnsOnlineVideoActivity.this.getString(i.j.sns_ad_video_right_menu_send_friend));
          if ((!bool1) || (!bool2)) {}
        }
        for (;;)
        {
          if (com.tencent.mm.by.c.blP("favorite")) {
            paramAnonymouso.add(0, 2, 0, SnsOnlineVideoActivity.this.getString(i.j.plugin_favorite_opt));
          }
          paramAnonymouso.add(0, 5, 0, SnsOnlineVideoActivity.this.getString(i.j.save_video_to_local));
          if (i != 0)
          {
            em localem = new em();
            localem.fAp.fAg = SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
            EventCenter.instance.publish(localem);
            if (localem.fAq.fzO) {
              paramAnonymouso.add(0, 4, 0, SnsOnlineVideoActivity.this.getString(i.j.app_open));
            }
          }
          AppMethodBeat.o(204551);
          return;
          i = 0;
        }
      }
    };
    this.sBv = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        boolean bool = false;
        AppMethodBeat.i(266081);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(266081);
          return;
          paramAnonymousMenuItem = new xt();
          paramAnonymousMenuItem.fWC.fDn = 2;
          paramAnonymousMenuItem.fWC.fWD = 17;
          Object localObject = paramAnonymousMenuItem.fWC;
          if (SnsOnlineVideoActivity.A(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((xt.a)localObject).fWE = bool;
          paramAnonymousMenuItem.fWC.fCM = SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
          AppMethodBeat.o(266081);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = aj.fOI().bbl(SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this));
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
            ((Intent)localObject).putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.by.c.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(266081);
            return;
            paramAnonymousMenuItem = localSnsInfo.getSnsId();
            break;
          }
          SnsOnlineVideoActivity.B(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem = new xt();
          paramAnonymousMenuItem.fWC.fDn = 1;
          paramAnonymousMenuItem.fWC.fWF = 4097;
          paramAnonymousMenuItem.fWC.fCM = SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
          AppMethodBeat.o(266081);
          return;
          paramAnonymousMenuItem = aj.fOI().bbl(SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(266081);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.Sqq == 15) && ((cvt)paramAnonymousMenuItem.getTimeLine().ContentObj.Sqr.get(0) == null))
          {
            Log.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(266081);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.by.c.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(266081);
          return;
          paramAnonymousMenuItem = new xt();
          paramAnonymousMenuItem.fWC.fDn = 3;
          paramAnonymousMenuItem.fWC.fCM = SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
          EventCenter.instance.publish(paramAnonymousMenuItem);
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void cJy()
  {
    AppMethodBeat.i(98962);
    if (this.isPreview)
    {
      Log.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.KVg.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.ui.widget.a.e(SnsOnlineVideoActivity.this.getContext(), 1, false));
        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).ODT = SnsOnlineVideoActivity.this.KVt;
        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).ODU = SnsOnlineVideoActivity.this.sBv;
        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).XbB = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(270510);
            SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
            AppMethodBeat.o(270510);
          }
        };
        SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).eik();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(264772);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private String fWM()
  {
    AppMethodBeat.i(228810);
    if ((this.isPreview) || (TextUtils.isEmpty(this.KVm)))
    {
      AppMethodBeat.o(228810);
      return "";
    }
    Object localObject;
    try
    {
      localObject = new com.tencent.mm.ad.i(this.KVm);
      String str = ((com.tencent.mm.ad.i)localObject).optString("APP_TYPE");
      localObject = ((com.tencent.mm.ad.i)localObject).optString("MSG_EXT");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        AppMethodBeat.o(228810);
        return "";
      }
    }
    catch (com.tencent.mm.ad.g localg)
    {
      Log.e("MicroMsg.SnsOnlineVideoActivity", "parse third msgJson error");
      AppMethodBeat.o(228810);
      return "";
    }
    int i = -1;
    switch (localg.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(228810);
        return "";
        if (localg.equals("APP_TYPE_SECOND_CUP")) {
          i = 0;
        }
        break;
      }
    }
    com.tencent.mm.plugin.recordvideo.e.h localh = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
    if (!com.tencent.mm.plugin.recordvideo.e.h.fzG())
    {
      AppMethodBeat.o(228810);
      return "";
    }
    this.KVf.bf(com.tencent.mm.ci.a.fromDPToPix(getContext(), 56), false);
    this.KVn.setOnClickListener(new SnsOnlineVideoActivity.14(this, (String)localObject));
    AppMethodBeat.o(228810);
    return localg;
  }
  
  private void fWN()
  {
    AppMethodBeat.i(98961);
    boolean bool = ar.av(this);
    int i = ar.aB(this);
    if ((this.EXT) && (bool) && (this.KNX != null) && (this.KNX.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.KNX.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.KNX.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public final void cJs()
  {
    AppMethodBeat.i(98967);
    if ((this.KNX != null) && (this.KNX.getVisibility() == 0)) {
      this.KNX.setVisibility(8);
    }
    if ((this.KVn != null) && (this.KVn.getVisibility() == 0)) {
      this.KVn.setVisibility(8);
    }
    int k = this.wPB.getWidth();
    int j = this.wPB.getHeight();
    if (this.KOu == 1.0F)
    {
      i = this.KVf.getVideoVideoMoveMargin();
      this.twB.XRW = (-(i * 2));
    }
    int i = j;
    if (this.twE != 0)
    {
      i = j;
      if (this.twF != 0) {
        i = (int)(k / this.twE * this.twF);
      }
    }
    if (this.twB != null)
    {
      this.twB.mJ(k, i);
      this.twB.V(this.twD, this.twC, this.twE, this.twF);
      if (this.KOu != 1.0D)
      {
        int m = this.KVf.getVideoVideoMoveMargin();
        this.twB.XRS = (1.0F / this.KOu);
        if ((this.KOv != 0) || (this.KOw != 0))
        {
          j = (int)(this.wPB.getWidth() / 2 * (1.0F - this.KOu));
          k = this.KOv;
          i = (int)(this.wPB.getHeight() / 2 + this.KOw - (i / 2 + m) * this.KOu);
          this.twB.mL(j + k, i);
        }
      }
      this.twB.a(this.KVg, this.mLT, new f.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(203567);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202579);
              Intent localIntent = new Intent();
              localIntent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this));
              SnsOnlineVideoActivity.this.setResult(-1, localIntent);
              SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this);
              SnsOnlineVideoActivity.this.finish();
              SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(202579);
            }
          });
          AppMethodBeat.o(203567);
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
      cJs();
      AppMethodBeat.o(98969);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98969);
    return bool;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_video_ui;
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
          localObject1 = aj.fOI().bbl(this.fCM);
          if (localObject1 != null)
          {
            if (!ab.Lj(str2)) {
              break label350;
            }
            localObject2 = new ws();
            ((ws)localObject2).fVM.fLp = t.w((SnsInfo)localObject1);
            ((ws)localObject2).fVM.fAg = ((SnsInfo)localObject1).getLocalid();
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
        label178:
        Object localObject2 = this.Jzk.getTimeLine();
        int i = t.aZt(this.fullPath);
        cvt localcvt;
        if (Util.isNullOrNil(this.thumbPath))
        {
          localcvt = this.fVT;
          if (localcvt == null) {
            localObject1 = "";
          }
        }
        for (;;)
        {
          this.thumbPath = ((String)localObject1);
          Log.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str2, this.fullPath, this.thumbPath, this.fVT.TDL, Integer.valueOf(this.fVT.Lgc), Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.eRW().a(this, str2, this.fullPath, this.thumbPath, 43, i, ((TimeLineObject)localObject2).statExtStr, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.eRW().iQ(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i.j.has_send));
          break;
          label350:
          localObject2 = new wt();
          ((wt)localObject2).fVN.fLp = t.w((SnsInfo)localObject1);
          ((wt)localObject2).fVN.fAg = ((SnsInfo)localObject1).getLocalid();
          EventCenter.instance.publish((IEvent)localObject2);
          break label178;
          String str3 = com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), localcvt.Id);
          localObject1 = str3 + t.d(localcvt);
          boolean bool = u.agG((String)localObject1);
          Log.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
          if (!bool)
          {
            localObject1 = str3 + t.m(localcvt);
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
    this.KVl = true;
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
      fWN();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.KNX != null) && (this.KNX.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.KNX.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(i.d.sns_game_more_button_bottom_margin))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(i.d.sns_game_more_button_bottom_margin);
          this.KNX.setLayoutParams(paramConfiguration);
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
    this.twA = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.fCM = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.isPreview = getIntent().getBooleanExtra("intent_ispreview", false);
    this.iYs = getIntent().getBooleanExtra("intent_ismute", false);
    this.KVk = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.fSp = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.KHs = getIntent().getLongExtra("intent_session_timestamp", Util.nowMilliSecond());
    this.KKq = getIntent().getIntExtra("sns_video_scene", 2);
    this.KGA = getIntent().getBooleanExtra("KBlockAdd", false);
    this.KVm = getIntent().getStringExtra("intent_third_sdk_msg");
    this.KVo = getIntent().getStringExtra("intent_publish_id");
    this.KVp = getIntent().getIntExtra("intent_bottom_height", 0);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    Log.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.fCM, Integer.valueOf(this.scene), Boolean.valueOf(this.isPreview), Boolean.valueOf(this.iYs), paramBundle });
    if (com.tencent.mm.q.a.aAo()) {
      this.iYs = true;
    }
    if (!this.isPreview) {}
    for (;;)
    {
      try
      {
        this.Jzk = aj.fOI().bbl(this.fCM);
        this.fVT = ((cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(0));
        this.fullPath = (com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), this.fVT.Id) + t.i(this.fVT));
        Log.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.Jzk.getLocalid() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.qV(19)) {
            break label1189;
          }
          if (!this.isPreview) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.EXT = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          Log.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.KVf.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcE);
          continue;
          this.KVf = ((OnlineVideoView)findViewById(i.f.video_view));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          this.sessionId = (new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.KHs = Util.nowMilliSecond();
          this.KVf.setSessionId(this.sessionId);
          this.KVf.setSessionTimestamp(this.KHs);
          if (this.Jzk == null) {
            break label1439;
          }
          this.KVf.setSnsId(t.Qu(this.Jzk.field_snsId));
          if ((this.Jzk.getTimeLine().ContentObj == null) || (this.Jzk.getTimeLine().ContentObj.Sqr == null) || (this.Jzk.getTimeLine().ContentObj.Sqr.isEmpty())) {
            break label1439;
          }
          this.KVf.setFilePath(ax.E((cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(0)));
          if ((!ar.hIH()) && (!ar.hIM())) {
            break label1464;
          }
          this.KVf.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcG);
          continue;
          this.KVf.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcE);
          continue;
          if (!paramBundle.equals("APP_TYPE_SECOND_CUP")) {
            continue;
          }
          int i = 0;
          continue;
          this.KVn.setVisibility(0);
          paramBundle = com.tencent.mm.plugin.sns.k.g.Kia;
          com.tencent.mm.plugin.sns.k.g.gk(this.KVo, 1);
          paramBundle = com.tencent.mm.plugin.recordvideo.model.a.HLt;
          i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
          int j = this.KVf.getBottomSafeHeight();
          int k = this.KVf.getVideoViewBottom();
          int m = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
          paramBundle = (FrameLayout.LayoutParams)this.KVn.getLayoutParams();
          if ((i - k <= j) || (k <= 0)) {
            break label1841;
          }
          paramBundle.setMargins(0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 16) + k, m, 0);
          paramBundle.gravity = 8388613;
          for (;;)
          {
            this.KVn.setLayoutParams(paramBundle);
            localObject2 = (TextView)findViewById(i.f.tv_jump_wording);
            paramBundle = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
            localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vND, "");
            Log.i("MicroMsg.SecondCutConfig", "SecondCutSimpleStyleLeftWording: ".concat(String.valueOf(localObject1)));
            paramBundle = (Bundle)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              kotlin.g.b.p.j(localObject1, "result");
              paramBundle = com.tencent.mm.plugin.recordvideo.e.h.aWv((String)localObject1);
              Log.i("MicroMsg.SecondCutConfig", "PopupSecondCutSimpleStyleLeftWording: ".concat(String.valueOf(paramBundle)));
            }
            kotlin.g.b.p.j(paramBundle, "result");
            localObject1 = paramBundle;
            if (TextUtils.isEmpty(paramBundle)) {
              localObject1 = com.tencent.mm.ci.a.ba(getContext(), i.j.sns_second_cut_simple_style);
            }
            if (!((String)localObject1).contains("X")) {
              break label1863;
            }
            paramBundle = new SpannableString((CharSequence)localObject1);
            Object localObject3 = com.tencent.mm.ci.a.m(getContext(), com.tencent.mm.plugin.sns.i.e.second_cut_simple_style_icon);
            i = com.tencent.mm.ci.a.aY(getContext(), i.d.Edge_1_5_A);
            ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getIntrinsicWidth() * i / ((Drawable)localObject3).getIntrinsicHeight(), i);
            localObject3 = new ImageSpan((Drawable)localObject3, 2);
            i = ((String)localObject1).indexOf("X");
            paramBundle.setSpan(localObject3, i, i + 1, 33);
            ((TextView)localObject2).setText(paramBundle);
            break;
            paramBundle.setMargins(0, 0, m, j - com.tencent.mm.ci.a.fromDPToPix(getContext(), 40));
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          continue;
          paramBundle = this.KVf;
          Object localObject1 = this.fullPath;
          Object localObject2 = this.thumbPath;
          paramBundle.KHf = ((String)localObject1);
          paramBundle.isPreview = true;
          paramBundle.wPh.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile((String)localObject2, 1.0F));
          Log.i(paramBundle.TAG, "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.isPreview) });
          continue;
          hideTitleView();
          this.wPB.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(98946);
              SnsOnlineVideoActivity.this.cJs();
              AppMethodBeat.o(98946);
              return true;
            }
          });
          continue;
          this.KNX = ((Button)findViewById(i.f.game_more_button));
          localObject1 = paramBundle.getTimeLine();
          if (localObject1 == null) {
            break label2089;
          }
          for (paramBundle = ((TimeLineObject)localObject1).actionInfo;; paramBundle = null)
          {
            localObject2 = new bn();
            aq.a(this, (bn)localObject2, ((TimeLineObject)localObject1).actionInfo);
            if (!((bn)localObject2).Lcb) {
              break label2094;
            }
            this.KNX.setVisibility(0);
            this.KNX.setText(((bn)localObject2).Lcc);
            this.KNX.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(257142);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                if (paramBundle.RFO == null)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(257142);
                  return;
                }
                SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.c.a.mIH.gY(paramBundle.RFO.lVG);
                int i = 0;
                if (this.KOz.ContentObj.Sqq == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KOz, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.c.a.mIH.a(SnsOnlineVideoActivity.this, paramBundle.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 19, 9, paramBundle.RFO.RFI, this.KOz.Id);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(257142);
                  return;
                  if (this.KOz.ContentObj.Sqq == 3) {
                    i = 5;
                  } else if (this.KOz.ContentObj.Sqq == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.rWu)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(257142);
                  return;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.c.a.mIH.a(SnsOnlineVideoActivity.this, paramBundle.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 19, 1, paramBundle.RFO.RFI, this.KOz.Id);
                  continue;
                  if (paramBundle.CPw == 1)
                  {
                    localObject = new ji();
                    ((ji)localObject).fGD.actionCode = 2;
                    ((ji)localObject).fGD.scene = 3;
                    ((ji)localObject).fGD.appId = paramBundle.RFO.lVG;
                    ((ji)localObject).fGD.context = SnsOnlineVideoActivity.this;
                    EventCenter.instance.publish((IEvent)localObject);
                    com.tencent.mm.plugin.sns.c.a.mIH.a(SnsOnlineVideoActivity.this, paramBundle.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 19, 6, paramBundle.RFO.RFI, this.KOz.Id);
                    continue;
                    int j = aq.b(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new ji();
                      ((ji)localObject).fGD.context = SnsOnlineVideoActivity.this;
                      ((ji)localObject).fGD.actionCode = 2;
                      ((ji)localObject).fGD.appId = paramBundle.RFO.lVG;
                      ((ji)localObject).fGD.messageAction = paramBundle.RFO.RFK;
                      ((ji)localObject).fGD.messageExt = paramBundle.RFO.RFJ;
                      ((ji)localObject).fGD.scene = 3;
                      EventCenter.instance.publish((IEvent)localObject);
                      com.tencent.mm.plugin.sns.c.a.mIH.a(SnsOnlineVideoActivity.this, paramBundle.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 19, 6, paramBundle.RFO.RFI, this.KOz.Id);
                    }
                    else if (j == 2)
                    {
                      localObject = new ji();
                      ((ji)localObject).fGD.context = SnsOnlineVideoActivity.this;
                      ((ji)localObject).fGD.actionCode = 1;
                      ((ji)localObject).fGD.appId = paramBundle.RFO.lVG;
                      ((ji)localObject).fGD.messageAction = paramBundle.RFO.RFK;
                      ((ji)localObject).fGD.messageExt = paramBundle.RFO.RFJ;
                      ((ji)localObject).fGD.scene = 3;
                      EventCenter.instance.publish((IEvent)localObject);
                      com.tencent.mm.plugin.sns.c.a.mIH.a(SnsOnlineVideoActivity.this, paramBundle.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 19, 3, paramBundle.RFO.RFI, this.KOz.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            fWN();
            break;
          }
          this.KNX.setVisibility(8);
          continue;
        }
        this.twB = new com.tencent.mm.ui.tools.f(getContext());
        this.wPB = ((RelativeLayout)findViewById(i.f.video_ui_root));
        this.KVg = ((FrameLayout)findViewById(i.f.video_view_container));
        this.KVf = com.tencent.mm.plugin.sns.ui.video.e.fZg().bcB(this.fSp);
        this.KVn = ((LinearLayout)findViewById(i.f.sns_ll_jump));
        if (this.KVf == null)
        {
          this.KVk = false;
          Log.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.KVk) {
          break label1246;
        }
        com.tencent.mm.plugin.sns.ui.video.e.fZg().fZh();
        paramBundle = (OnlineVideoView)findViewById(i.f.video_view);
        if (this.KVf.getParent() != null) {
          ((ViewGroup)this.KVf.getParent()).removeView(this.KVf);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.KVg.addView(this.KVf, (ViewGroup.LayoutParams)localObject1);
        if ((!ar.hIH()) && (!ar.hIM())) {
          break;
        }
        this.KVf.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcG);
        localObject1 = this.KVf;
        if (((OnlineVideoView)localObject1).sUi == null) {
          ((OnlineVideoView)localObject1).sUi = com.tencent.mm.model.d.bcs();
        }
        ((OnlineVideoView)localObject1).sUi.a((d.a)localObject1);
        Log.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.KVf.getCurrentPosition()), Integer.valueOf(this.KVf.getDuration()) });
        if (this.KVf.getCurrentPosition() + 500 >= this.KVf.getDuration()) {
          this.KVf.bc(0, true);
        }
        paramBundle.setVisibility(8);
        this.KVf.aS(this);
        this.KVf.setScene(this.KKq);
        if (this.Jzk == null)
        {
          this.Jzk = aj.fOI().bbl(this.fCM);
          if (this.Jzk != null) {
            this.fVT = ((cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(0));
          }
        }
        else
        {
          i = Math.round(this.fVT.TDZ);
          paramBundle = bp.LeB;
          j = bp.getSnsVideoShowSeekBarDurationMs();
          this.KVf.bf(this.KVp, true);
          paramBundle = fWM();
          this.KVf.jS(i * 1000, j);
        }
        switch (paramBundle.hashCode())
        {
        default: 
          i = -1;
          switch (i)
          {
          default: 
            if (this.isPreview) {
              break label1873;
            }
            if ((!this.KVk) && (this.Jzk != null)) {
              this.KVf.a(this.fVT, this.Jzk.getLocalid(), this.Jzk.getCreateTime());
            }
            this.KVf.setMute(this.iYs);
            this.mLT = ((ImageView)findViewById(i.f.gallery_bg));
            if (!this.isPreview) {
              break label1956;
            }
            this.KVf.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                boolean bool = false;
                AppMethodBeat.i(98938);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
            this.pCU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
            {
              public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(258188);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
                boolean bool = super.onContextClick(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(258188);
                return bool;
              }
              
              public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(258187);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
                boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(258187);
                return bool;
              }
              
              public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(98948);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
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
                localb.bn(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
                if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
                  SnsOnlineVideoActivity.this.cJs();
                }
                boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(98949);
                return bool;
              }
            });
            this.KVg.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(98950);
                paramAnonymousView = SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this);
                com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aFh(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                        SnsOnlineVideoActivity.this.cJs();
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
            paramBundle = this.Jzk;
            if (paramBundle != null) {
              break label1978;
            }
            Log.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
            if (this.isPreview)
            {
              if (!this.KGA) {
                addIconOptionMenu(0, i.j.app_delete, i.i.icons_outlined_delete, new MenuItem.OnMenuItemClickListener()
                {
                  public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                  {
                    AppMethodBeat.i(98952);
                    com.tencent.mm.ui.base.h.a(SnsOnlineVideoActivity.this, i.j.sns_upload_browse_del, i.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(98951);
                        SnsOnlineVideoActivity.m(SnsOnlineVideoActivity.this);
                        SnsOnlineVideoActivity.this.cJs();
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
                  SnsOnlineVideoActivity.this.cJs();
                  AppMethodBeat.o(98953);
                  return true;
                }
              });
            }
            cJy();
            paramBundle = new zo();
            paramBundle.fYR.type = 1;
            EventCenter.instance.publish(paramBundle);
            AppMethodBeat.o(98959);
            return;
          }
          break;
        }
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.fullPath = paramBundle;
      continue;
      label1189:
      if (!this.isPreview) {
        getWindow().setFlags(1024, 1024);
      }
      this.EXT = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    Log.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.KVk) });
    if (this.KVk)
    {
      com.tencent.mm.plugin.sns.ui.video.e.fZg().aT(this);
      this.KVf.onDestroy();
      this.KVf.fUj();
      if (!this.KVl) {
        com.tencent.mm.plugin.sns.ui.video.e.fZg().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label79:
        super.onDestroy();
        if ((this.Jzk != null) && (this.Jzk.getTimeLine().ContentObj.Sqr.size() > 0))
        {
          final int i = this.KVf.getPlayVideoDuration();
          final String str = ((cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(0)).Url;
          final int j = this.Jzk.getTimeLine().sightFolded;
          com.tencent.e.h.ZvG.bf(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98939);
              PInt localPInt = new PInt();
              y.a(ax.E((cvt)SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this).getTimeLine().ContentObj.Sqr.get(0)), localPInt, new PInt());
              com.tencent.mm.plugin.report.service.h.IzE.a(15534, new Object[] { str, SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this).getTimeLine().Id, Integer.valueOf(j), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(i * 1000) });
              AppMethodBeat.o(98939);
            }
          });
        }
        AppMethodBeat.o(98966);
        return;
        this.KVf.onDestroy();
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
    if (this.KVk)
    {
      ((SnsTimelineVideoView)this.KVf).fYZ();
      if (!this.KVh)
      {
        Log.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.KVi) {
          break label115;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(256881);
            SnsOnlineVideoActivity.this.finish();
            AppMethodBeat.o(256881);
          }
        }, 500L);
      }
    }
    for (;;)
    {
      super.onPause();
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.KVf.onPause();
      break;
      label115:
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265197);
          SnsOnlineVideoActivity.this.finish();
          AppMethodBeat.o(265197);
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
    if (this.KVk) {
      this.KVf.fLJ();
    }
    for (;;)
    {
      this.wPj = false;
      if (this.KVh) {
        this.KVh = false;
      }
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.wPj) {
        this.KVf.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
    Bundle localBundle = this.twA;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.twC = getIntent().getIntExtra("img_gallery_top", 0);
        this.twD = getIntent().getIntExtra("img_gallery_left", 0);
        this.twE = getIntent().getIntExtra("img_gallery_width", 0);
        this.twF = getIntent().getIntExtra("img_gallery_height", 0);
        if (this.twB != null) {
          this.twB.V(this.twD, this.twC, this.twE, this.twF);
        }
        if (localBundle == null) {
          this.KVg.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(203871);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getViewTreeObserver().removeOnPreDrawListener(this);
              if (SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this) != null)
              {
                SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).setThumbViewScaleType(ImageView.ScaleType.FIT_CENTER);
                SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).a(SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this), SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this), new f.c()
                {
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(200473);
                    SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).KHj.setImageBitmap(null);
                    SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).KHj.setVisibility(8);
                    if (SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this) != null)
                    {
                      if (SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this))
                      {
                        SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).fLJ();
                        AppMethodBeat.o(200473);
                        return;
                      }
                      SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).onResume();
                    }
                    AppMethodBeat.o(200473);
                  }
                  
                  public final void onAnimationStart()
                  {
                    AppMethodBeat.i(200468);
                    SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this).KHj.setVisibility(0);
                    AppMethodBeat.o(200468);
                  }
                });
              }
              AppMethodBeat.o(203871);
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