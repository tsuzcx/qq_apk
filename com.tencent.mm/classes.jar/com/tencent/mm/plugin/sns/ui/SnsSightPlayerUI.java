package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.xy;
import com.tencent.mm.autogen.a.yh;
import com.tencent.mm.autogen.a.yl;
import com.tencent.mm.autogen.a.ym;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.g.p;
import com.tencent.mm.plugin.sns.ad.g.p.a;
import com.tencent.mm.plugin.sns.ad.g.p.b;
import com.tencent.mm.plugin.sns.ad.g.p.c;
import com.tencent.mm.plugin.sns.ad.g.p.d;
import com.tencent.mm.plugin.sns.ad.g.p.e;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SnsSightPlayerUI
  extends MMActivity
  implements d.a, c.b
{
  private int Ahg;
  private TextView AkH;
  private boolean AkK;
  private boolean PGO;
  ViewGroup PGX;
  private int PGl;
  private int PHe;
  private int PHf;
  public int PHm;
  private SnsInfo PNI;
  private TextView PtY;
  private ADInfo Qam;
  private com.tencent.mm.plugin.sns.ad.g.m Rnm;
  private float Roh;
  private int Roi;
  private int Roj;
  private boolean Rvf;
  private boolean Rvo;
  private boolean Rvp;
  private boolean Rvq;
  private String Rxk;
  private TextView Rxl;
  private MMPinProgressBtn Rxm;
  private String Rxn;
  private RelativeLayout Rxo;
  View.OnCreateContextMenuListener Rxp;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  private int duration;
  private String fullPath;
  private String hHB;
  private dmz ibT;
  private int ieW;
  private String imagePath;
  private boolean isAd;
  private boolean isAnimated;
  private boolean isInit;
  private GestureDetector mQj;
  private VelocityTracker mVelocityTracker;
  private boolean ooe;
  private ImageView pIB;
  private int source;
  private String thumbPath;
  u.i vGU;
  private com.tencent.mm.model.d vZw;
  Bundle wAX;
  com.tencent.mm.ui.tools.f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  com.tencent.mm.pluginsdk.ui.tools.i wCd;
  private float x_down;
  private float y_down;
  
  public SnsSightPlayerUI()
  {
    AppMethodBeat.i(99100);
    this.Rnm = new com.tencent.mm.plugin.sns.ad.g.m("SnsSightPlayerUI");
    this.fullPath = "";
    this.imagePath = "";
    this.hHB = "";
    this.Rxk = "";
    this.isAd = false;
    this.wCd = null;
    this.PtY = null;
    this.Rxl = null;
    this.Rxm = null;
    this.source = 0;
    this.duration = 0;
    this.ieW = 0;
    this.PGl = 0;
    this.Ahg = 0;
    this.PGO = false;
    this.Rvf = false;
    this.PHe = 0;
    this.PHf = 0;
    this.isInit = false;
    this.AkK = false;
    this.PNI = null;
    this.Qam = null;
    this.ibT = null;
    this.thumbPath = "";
    this.Rxn = "";
    this.AkH = null;
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.Roh = 1.0F;
    this.Roi = 0;
    this.Roj = 0;
    this.ooe = false;
    this.Rxp = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(99084);
        if (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SIGHTCannotTransmitForFav")) == 0)
        {
          boolean bool1 = y.ZC(SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          boolean bool2 = y.ZC(SnsSightPlayerUI.u(SnsSightPlayerUI.this));
          Log.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((bool1) && (bool2)) {
            paramAnonymousContextMenu.add(0, 3, 0, SnsSightPlayerUI.this.getString(b.j.sns_ad_video_right_menu_send_friend));
          }
        }
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.c.blq("favorite")) {
            paramAnonymousContextMenu.add(0, 2, 0, SnsSightPlayerUI.this.getString(b.j.plugin_favorite_opt));
          }
          if (i != 0)
          {
            paramAnonymousView = new ex();
            paramAnonymousView.hFc.hES = SnsSightPlayerUI.f(SnsSightPlayerUI.this);
            paramAnonymousView.publish();
            if (paramAnonymousView.hFd.hEn) {
              paramAnonymousContextMenu.add(0, 4, 0, SnsSightPlayerUI.this.getString(b.j.app_open));
            }
          }
          if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
            paramAnonymousContextMenu.add(0, 1, 0, SnsSightPlayerUI.this.getContext().getString(b.j.sns_timeline_expose));
          }
          AppMethodBeat.o(99084);
          return;
        }
      }
    };
    this.vGU = new u.i()
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
          paramAnonymousMenuItem = al.hgB().aZL(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          Object localObject = new dn();
          com.tencent.mm.plugin.sns.n.a.a((dn)localObject, paramAnonymousMenuItem);
          ((dn)localObject).hDr.activity = SnsSightPlayerUI.this;
          ((dn)localObject).hDr.hDy = 17;
          ((dn)localObject).publish();
          if (SnsSightPlayerUI.j(SnsSightPlayerUI.this))
          {
            t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, paramAnonymousMenuItem.field_snsId, 11, 0));
            p.a(p.d.PXo, p.c.PXj, p.e.PXv, 0, paramAnonymousMenuItem, SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
          {
            localObject = new yh();
            ((yh)localObject).ibI.hES = paramAnonymousMenuItem.getLocalid();
            ((yh)localObject).ibI.hQX = t.x(paramAnonymousMenuItem);
            ((yh)localObject).publish();
          }
          AppMethodBeat.o(99085);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = al.hgB().aZL(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (localSnsInfo != null) {
            Log.i("MicroMsg.SnsSightPlayerUI", "expose id " + localSnsInfo.getSnsId());
          }
          if (localSnsInfo == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localSnsInfo != null) {
              break label363;
            }
          }
          label363:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localSnsInfo.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.br.c.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(99085);
            return;
            paramAnonymousMenuItem = localSnsInfo.getSnsId();
            break;
          }
          SnsSightPlayerUI.v(SnsSightPlayerUI.this);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
          paramAnonymousMenuItem.putExtra("select_is_ret", true);
          paramAnonymousMenuItem.putExtra("mutil_select_is_ret", true);
          paramAnonymousMenuItem.putExtra("image_path", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
          paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.br.c.d(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 4097);
          AppMethodBeat.o(99085);
          return;
          paramAnonymousMenuItem = al.hgB().aZL(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(99085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.Zpq == 15) && ((dmz)paramAnonymousMenuItem.getTimeLine().ContentObj.Zpr.get(0) == null))
          {
            Log.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
            AppMethodBeat.o(99085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsSightPlayerUI.f(SnsSightPlayerUI.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.c.g(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
        }
      }
    };
    this.PHm = 0;
    AppMethodBeat.o(99100);
  }
  
  private void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(99103);
    this.wCd.start();
    this.duration = this.wCd.getDuration();
    Log.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
    this.vZw.a(this);
    com.tencent.mm.plugin.sns.ad.g.a.b localb;
    if (paramBoolean)
    {
      localb = this.Rnm.PWv;
      if (getResources().getConfiguration().orientation != 2) {
        break label125;
      }
    }
    label125:
    for (int i = 2;; i = 1)
    {
      localb.PXI = i;
      this.Rnm.PWv.PXJ = Util.currentTicks();
      this.Rnm.PWv.PXH = 2;
      AppMethodBeat.o(99103);
      return;
    }
  }
  
  private void amh(int paramInt)
  {
    AppMethodBeat.i(99115);
    if (!this.isAd)
    {
      AppMethodBeat.o(99115);
      return;
    }
    com.tencent.mm.plugin.sns.ad.g.a.b localb;
    if (this.wCd.isPlaying())
    {
      if (this.duration == 0) {
        this.duration = this.wCd.getDuration();
      }
      this.Rnm.ajw(this.duration);
      this.Rnm.PWv.PXJ = Util.currentTicks();
      localb = this.Rnm.PWv;
      if (paramInt != 2) {
        break label158;
      }
    }
    label158:
    for (paramInt = 2;; paramInt = 1)
    {
      localb.PXI = paramInt;
      this.Rnm.PWv.PXH = 2;
      Log.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.Rnm.PWv.PXI);
      AppMethodBeat.o(99115);
      return;
    }
  }
  
  private void bP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(99114);
    if ((this.PHf == 0) || (this.PHe == 0))
    {
      localObject = getResources().getDisplayMetrics();
      this.PHf = ((DisplayMetrics)localObject).heightPixels;
      this.PHe = ((DisplayMetrics)localObject).widthPixels;
    }
    Object localObject = this.PGX.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Rxl.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt == 1)
    {
      localLayoutParams1.width = this.PHe;
      localLayoutParams1.height = ((int)(this.PHe * 1.0D * 240.0D / 320.0D));
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(1, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(3, this.PGX.getId());
      findViewById(b.f.tips_tv).setVisibility(0);
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsSightPlayerUI", "orientation " + paramInt + " " + localLayoutParams1.width + " " + localLayoutParams1.height);
      ((View)this.wCd).setLayoutParams(localLayoutParams1);
      if ((this.wCd instanceof com.tencent.mm.plugin.sight.decode.model.a)) {
        ((com.tencent.mm.plugin.sight.decode.model.a)this.wCd).ld(localLayoutParams1.width, localLayoutParams1.height);
      }
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams1.height;
      ((ViewGroup.LayoutParams)localObject).width = localLayoutParams1.width;
      this.PtY.setLayoutParams(localLayoutParams);
      this.PGX.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((View)this.wCd).requestLayout();
      if (!paramBoolean) {
        amh(paramInt);
      }
      AppMethodBeat.o(99114);
      return;
      localLayoutParams1.height = this.PHe;
      localLayoutParams1.width = ((int)(this.PHe * 1.0D * 320.0D / 240.0D));
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(3, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(1, this.PGX.getId());
      findViewById(b.f.tips_tv).setVisibility(8);
    }
  }
  
  private void bck()
  {
    AppMethodBeat.i(99104);
    Log.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
    this.wCd.pause();
    this.wCd.onDetach();
    this.vZw.gR(false);
    AppMethodBeat.o(99104);
  }
  
  public final void EE(String paramString) {}
  
  public final void aXr() {}
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void dmJ()
  {
    AppMethodBeat.i(99109);
    int k = this.PGX.getWidth();
    int j = this.PGX.getHeight();
    int i = j;
    if (this.wBb != 0)
    {
      i = j;
      if (this.wBc != 0) {
        i = (int)(k / this.wBb * this.wBc);
      }
    }
    this.wAY.oC(k, i);
    this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
    if (this.Roh != 1.0D)
    {
      int m = aw.bk(getContext());
      this.wAY.afIg = (1.0F / this.Roh);
      if ((this.Roi != 0) || (this.Roj != 0))
      {
        j = (int)(this.PGX.getWidth() / 2 * (1.0F - this.Roh));
        k = this.Roi;
        i = (int)((m + this.PGX.getHeight()) / 2 - i / 2 * this.Roh + this.Roj);
        this.wAY.oE(j + k, i);
      }
    }
    this.wAY.a(this.PGX, this.pIB, new f.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(99083);
        new MMHandler().post(new Runnable()
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
  
  public void finish()
  {
    AppMethodBeat.i(99102);
    if (!this.ooe)
    {
      super.finish();
      this.ooe = true;
    }
    AppMethodBeat.o(99102);
  }
  
  public int getForceOrientation()
  {
    return 7;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_sight_player_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99111);
    label149:
    label664:
    if (4097 == paramInt1)
    {
      label291:
      label676:
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
        String str2;
        Object localObject3;
        fjp localfjp;
        label242:
        do
        {
          if (!localIterator.hasNext()) {
            break label802;
          }
          str2 = (String)localIterator.next();
          if (this.source == 0)
          {
            localObject1 = al.hgB().aZL(this.hHB);
            if (localObject1 != null)
            {
              if (!au.bwE(str2)) {
                break;
              }
              localObject2 = new yl();
              ((yl)localObject2).ibM.hQX = t.x((SnsInfo)localObject1);
              ((yl)localObject2).ibM.hES = ((SnsInfo)localObject1).getLocalid();
              ((yl)localObject2).publish();
            }
          }
          localObject2 = this.PNI.getTimeLine();
          if (!this.isAd) {
            break label676;
          }
          localObject3 = this.PNI.getAdXml();
          localfjp = new fjp();
          localfjp.ZBc = this.ibT.RGm;
          localfjp.nTu = this.ibT.aaTr;
          if (((TimeLineObject)localObject2).ContentObj.Zpq != 15) {
            break label623;
          }
          localfjp.nTA = this.Qam.uxInfo;
          localfjp.nTB = ((TimeLineObject)localObject2).Id;
          if (!Util.isNullOrNil(this.ibT.aaTv)) {
            break label652;
          }
          localObject1 = ((TimeLineObject)localObject2).ContentDesc;
          localfjp.nTw = ((String)localObject1);
          if (!Util.isNullOrNil(this.ibT.aaTu)) {
            break label664;
          }
          localObject1 = this.ibT.aaTl;
          localfjp.nTz = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            localfjp.nTy = ((ADXml)localObject3).attachShareLinkUrl;
            localfjp.nTx = ((ADXml)localObject3).attachShareLinkWording;
          }
          if (localObject3 != null) {
            localfjp.nTy = ((ADXml)localObject3).adActionLink;
          }
          i = t.aXE(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, this.ibT.aaTr, Integer.valueOf(this.ibT.RGm), localfjp.nTz, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.gaI().a(this, str2, this.fullPath, this.imagePath, 43, i, localfjp, ((TimeLineObject)localObject2).statExtStr, null);
          if (str1 != null) {
            com.tencent.mm.plugin.messenger.a.g.gaI().ke(str1, str2);
          }
          com.tencent.mm.ui.widget.snackbar.b.u(this, getString(b.j.has_send));
        } while (!this.isAd);
        label458:
        t.a(new SnsAdClick(this.source, 5, this.PNI.field_snsId, 12, 0));
        boolean bool = au.bwE(str2);
        Object localObject2 = p.d.PXo;
        if (bool)
        {
          localObject1 = p.c.PXl;
          localObject3 = p.e.PXv;
          if (!bool) {
            break label764;
          }
        }
        label623:
        label764:
        for (int i = com.tencent.mm.model.v.getMembersCountByChatRoomName(str2);; i = 0)
        {
          p.a((p.d)localObject2, (p.c)localObject1, (p.e)localObject3, i, this.PNI, this.source);
          break;
          localObject2 = new ym();
          ((ym)localObject2).ibN.hQX = t.x((SnsInfo)localObject1);
          ((ym)localObject2).ibN.hES = ((SnsInfo)localObject1).getLocalid();
          ((ym)localObject2).publish();
          break label149;
          localfjp.nTA = ((TimeLineObject)localObject2).streamvideo.nTA;
          localfjp.nTB = ((TimeLineObject)localObject2).streamvideo.nTB;
          break label242;
          localObject1 = this.ibT.aaTv;
          break label262;
          localObject1 = this.ibT.aaTu;
          break label291;
          i = t.aXE(this.fullPath);
          Log.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[] { str2, this.fullPath, this.imagePath, Integer.valueOf(i) });
          com.tencent.mm.plugin.messenger.a.g.gaI().a(this, str2, this.fullPath, this.imagePath, 43, i, ((TimeLineObject)localObject2).statExtStr, null);
          break label458;
          localObject1 = p.c.PXk;
          break label540;
        }
      }
      label540:
      if (this.isAd) {
        t.a(new SnsAdClick(this.source, 5, this.PNI.field_snsId, 13, 0));
      }
    }
    label262:
    label652:
    label802:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(99111);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99110);
    dmJ();
    AppMethodBeat.o(99110);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99113);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + paramConfiguration.orientation + " " + this.PHm);
    if (this.PHm == paramConfiguration.orientation)
    {
      AppMethodBeat.o(99113);
      return;
    }
    int i = paramConfiguration.orientation;
    bP(paramConfiguration.orientation, false);
    this.PHm = paramConfiguration.orientation;
    AppMethodBeat.o(99113);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99101);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    this.source = getIntent().getIntExtra("intent_from_scene", -1);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    hideTitleView();
    al.hgw().a(this);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(b.c.black));
    }
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.wAX = paramBundle;
      this.vZw = new com.tencent.mm.model.d();
      this.fullPath = getIntent().getStringExtra("intent_videopath");
      this.imagePath = getIntent().getStringExtra("intent_thumbpath");
      this.hHB = getIntent().getStringExtra("intent_localid");
      this.isAd = getIntent().getBooleanExtra("intent_isad", false);
      this.PNI = al.hgB().aZL(this.hHB);
      if (!this.isAd) {
        break label338;
      }
      if (this.PNI != null) {
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
      this.ibT = ((dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(0));
      paramBundle = as.mg(al.getAccSnsPath(), this.ibT.Id);
      localObject1 = t.j(this.ibT);
      this.Rxn = (paramBundle + (String)localObject1);
      this.thumbPath = (paramBundle + t.d(this.ibT));
    }
    label338:
    if (com.tencent.mm.n.a.aDI() != null) {
      com.tencent.mm.n.a.aDI().aKl();
    }
    if (this.PNI != null) {
      if (this.source == 2)
      {
        paramBundle = this.PNI.getAtAdInfo();
        this.Qam = paramBundle;
        this.Rnm.PWp = Util.currentTicks();
        this.Rxo = ((RelativeLayout)findViewById(b.f.content_root));
        this.Rxo.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99078);
            SnsSightPlayerUI.this.dmJ();
            AppMethodBeat.o(99078);
            return true;
          }
        });
        Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.aPW() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
        this.wAY = new com.tencent.mm.ui.tools.f(getContext());
        this.pIB = ((ImageView)findViewById(b.f.gallery_bg));
        this.PtY = ((TextView)findViewById(b.f.tips_tv));
        this.Rxm = ((MMPinProgressBtn)findViewById(b.f.sight_downloading_pb));
        this.PGX = ((ViewGroup)findViewById(b.f.video_container));
        this.wCd = com.tencent.mm.pluginsdk.ui.tools.w.lG(getContext());
        if ((this.wCd instanceof VideoSightView)) {
          ((VideoSightView)this.wCd).setIsAdVideo(this.isAd);
        }
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        this.AkH = ((TextView)findViewById(b.f.show_ad_sight));
        this.AkH.setTextColor(Color.parseColor("#888888"));
        this.PGX.addView((View)this.wCd, 0, paramBundle);
        this.Rxl = ((TextView)findViewById(b.f.time_counter_tv));
        this.Rxl.setText("");
        if (!this.isAd) {
          this.Rxl.setVisibility(8);
        }
        if (!this.isAd) {
          break label1311;
        }
        if (this.ibT != null) {
          break label988;
        }
        this.AkH.setVisibility(8);
        label688:
        com.tencent.mm.pluginsdk.ui.tools.v.a(this.AkH, (VideoSightView)this.wCd);
        label702:
        this.wCd.setVideoCallback(new i.a()
        {
          public final void Qz()
          {
            AppMethodBeat.i(99091);
            Log.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.f.aPW() + " onPrepared");
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
            AppMethodBeat.o(99091);
          }
          
          public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            return 0;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(99093);
            Log.d("MicroMsg.SnsSightPlayerUI", "on completion");
            if (!SnsSightPlayerUI.j(SnsSightPlayerUI.this)) {
              SnsSightPlayerUI.k(SnsSightPlayerUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(99090);
                  if (SnsSightPlayerUI.k(SnsSightPlayerUI.this).getVisibility() != 0)
                  {
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).setVisibility(0);
                    SnsSightPlayerUI.k(SnsSightPlayerUI.this).startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.getContext(), b.a.fast_faded_in));
                  }
                  AppMethodBeat.o(99090);
                }
              });
            }
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).setLoop(true);
            com.tencent.mm.plugin.sns.ad.g.a.b localb = SnsSightPlayerUI.l(SnsSightPlayerUI.this).PWv;
            localb.PXE += 1;
            SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
            AppMethodBeat.o(99093);
          }
          
          public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(99092);
            Log.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            SnsSightPlayerUI.g(SnsSightPlayerUI.this).stop();
            if (SnsSightPlayerUI.h(SnsSightPlayerUI.this))
            {
              AppMethodBeat.o(99092);
              return;
            }
            SnsSightPlayerUI.i(SnsSightPlayerUI.this);
            CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.gYr() + "[SnsSightPlayerUI] on play video error, what " + paramAnonymousInt1 + " extra " + paramAnonymousInt2 + ", path=" + Util.nullAs(SnsSightPlayerUI.e(SnsSightPlayerUI.this), "")).getBytes(), 2), "FullScreenPlaySight");
            final String str = SnsSightPlayerUI.e(SnsSightPlayerUI.this);
            j localj = r.bKa();
            float f = com.tencent.mm.cd.a.getDensity(SnsSightPlayerUI.this.getContext());
            SnsSightPlayerUI.this.getContext();
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99089);
                Object localObject1 = (ImageView)SnsSightPlayerUI.this.findViewById(b.f.videoplayer_maskview);
                if (localObject1 != null)
                {
                  ((ImageView)localObject1).setImageBitmap(this.NCc);
                  ((ImageView)localObject1).setVisibility(0);
                }
                Object localObject2 = new Intent();
                ((Intent)localObject2).setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(SnsSightPlayerUI.this.getContext(), (Intent)localObject2, new u(str), "video/*", false);
                try
                {
                  localObject1 = SnsSightPlayerUI.this.getContext();
                  localObject2 = Intent.createChooser((Intent)localObject2, SnsSightPlayerUI.this.getContext().getString(b.j.favorite_video));
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(99089);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                  k.s(SnsSightPlayerUI.this.getContext(), b.j.favorite_no_match_msg, b.j.favorite_no_match_title);
                  AppMethodBeat.o(99089);
                }
              }
            });
            AppMethodBeat.o(99092);
          }
        });
        findViewById(b.f.video_container).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99094);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SnsSightPlayerUI.this.dmJ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99094);
          }
        });
        ((View)this.wCd).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99095);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SnsSightPlayerUI.this.dmJ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99095);
          }
        });
        this.mQj = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
        {
          public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(308400);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            boolean bool = super.onContextClick(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(308400);
            return bool;
          }
          
          public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(308399);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(308399);
            return bool;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99097);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
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
            AppMethodBeat.i(308396);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
            boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(308396);
            return bool;
          }
        });
        ((View)this.wCd).setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(99098);
            paramAnonymousView = SnsSightPlayerUI.n(SnsSightPlayerUI.this);
            com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aYi(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.PGX.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.PGX.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(1.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationX(0.0F);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setTranslationY(0.0F);
                  paramAnonymousView = SnsSightPlayerUI.this;
                  if (paramAnonymousView.contextMenuHelper == null) {
                    paramAnonymousView.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramAnonymousView.getContext());
                  }
                  paramAnonymousView.contextMenuHelper.a((View)paramAnonymousView.wCd, paramAnonymousView.Rxp, paramAnonymousView.vGU);
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
                    SnsSightPlayerUI.this.dmJ();
                    SnsSightPlayerUI.b(SnsSightPlayerUI.this, false);
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
              float f1 = 1.0F - f3 / SnsSightPlayerUI.this.PGX.getHeight();
              if (f1 > 1.0F)
              {
                f1 = 1.0F;
                label575:
                if (((j > 0) && (f1 < SnsSightPlayerUI.s(SnsSightPlayerUI.this))) || ((j < 0) && (f1 >= 0.5D)))
                {
                  SnsSightPlayerUI.a(SnsSightPlayerUI.this, (int)f2);
                  SnsSightPlayerUI.b(SnsSightPlayerUI.this, (int)f3);
                  SnsSightPlayerUI.c(SnsSightPlayerUI.this, f1);
                  if (SnsSightPlayerUI.q(SnsSightPlayerUI.this) != null) {
                    SnsSightPlayerUI.q(SnsSightPlayerUI.this).setVisibility(8);
                  }
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotX(SnsSightPlayerUI.this.PGX.getWidth() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setPivotY(SnsSightPlayerUI.this.PGX.getHeight() / 2);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleX(f1);
                  ((View)SnsSightPlayerUI.g(SnsSightPlayerUI.this)).setScaleY(f1);
                  SnsSightPlayerUI.t(SnsSightPlayerUI.this).setAlpha(f1);
                }
                SnsSightPlayerUI.c(SnsSightPlayerUI.this, true);
                label759:
                if (f3 <= 200.0F) {
                  break label859;
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
              AppMethodBeat.o(99098);
              return true;
              break label575;
              SnsSightPlayerUI.c(SnsSightPlayerUI.this, false);
              break label759;
              label859:
              if (f3 > 10.0F) {
                SnsSightPlayerUI.d(SnsSightPlayerUI.this, true);
              }
            }
          }
        });
        if (!y.ZC(this.fullPath)) {
          break label1323;
        }
        if (this.fullPath != null)
        {
          this.wCd.stop();
          this.wCd.setVideoPath(this.fullPath);
        }
        this.Rxm.setVisibility(8);
      }
    }
    for (this.Rnm.PWn = 1;; this.Rnm.PWn = 0)
    {
      Log.d("MicroMsg.SnsSightPlayerUI", System.currentTimeMillis() - l + " initView end");
      paramBundle = new abi();
      paramBundle.ieT.type = 1;
      paramBundle.publish();
      if (this.contextMenuHelper == null) {
        this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
      }
      this.contextMenuHelper.a((View)this.wCd, this.Rxp, this.vGU);
      ((View)this.wCd).post(new Runnable()
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
      paramBundle = this.PNI.getAdInfo();
      break;
      paramBundle = null;
      break;
      label988:
      if (Util.isNullOrNil(this.ibT.aaTr))
      {
        Log.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
        paramBundle = this.PNI.getTimeLine();
        Object localObject2 = this.PNI.getAdXml();
        localObject1 = ((ADXml)localObject2).attachShareLinkWording;
        localObject2 = ((ADXml)localObject2).attachShareLinkUrl;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          this.AkH.setVisibility(0);
          this.AkH.setText((CharSequence)localObject1);
          this.AkH.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(99087);
              Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
              Object localObject2;
              if (p.b.PXd.value != 0)
              {
                localObject1 = p.a.PWX;
                localObject2 = paramBundle.Id;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  break label259;
                }
              }
              label259:
              for (paramAnonymousView = "";; paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo)
              {
                p.a((p.a)localObject1, (String)localObject2, paramAnonymousView, 1, p.b.PXd.value, paramBundle.UserName, null, paramBundle.Id, 0L, 0, 0);
                localObject2 = new Intent();
                Bundle localBundle = new Bundle();
                localBundle.putString("key_snsad_statextstr", paramBundle.statExtStr);
                localObject1 = this.AkW;
                paramAnonymousView = (View)localObject1;
                if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
                  paramAnonymousView = t.lY((String)localObject1, SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo);
                }
                ((Intent)localObject2).putExtra("jsapiargs", localBundle);
                ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject2).putExtra("useJs", true);
                t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, SnsSightPlayerUI.c(SnsSightPlayerUI.this).field_snsId, 18, 0));
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(99086);
                    com.tencent.mm.plugin.sns.d.a.pFn.h(this.val$intent, SnsSightPlayerUI.this);
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
          break label688;
        }
        this.AkH.setVisibility(8);
        break label688;
      }
      localObject1 = getResources().getString(b.j.sns_ad_sight_full);
      paramBundle = (Bundle)localObject1;
      if (this.ibT.RGm / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(b.j.sns_ad_sight_full_m, new Object[] { Integer.valueOf(this.ibT.RGm / 60) });
      }
      localObject1 = paramBundle;
      if (this.ibT.RGm % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(b.j.sns_ad_sight_full_s, new Object[] { Integer.valueOf(this.ibT.RGm % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(b.j.sns_ad_sight_full_end);
      this.AkH.setText(paramBundle);
      this.AkH.setVisibility(0);
      this.AkH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99088);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          if (SnsSightPlayerUI.c(SnsSightPlayerUI.this).isAd()) {
            p.a(p.b.PXd, p.a.PWW, SnsSightPlayerUI.c(SnsSightPlayerUI.this), SnsSightPlayerUI.b(SnsSightPlayerUI.this));
          }
          localObject1 = new Intent();
          paramAnonymousView = as.mg(al.getAccSnsPath(), SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
          Object localObject2 = t.j(SnsSightPlayerUI.d(SnsSightPlayerUI.this));
          if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) > 0)
          {
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
            Log.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
            ((Intent)localObject1).putExtra("KFullVideoPath", paramAnonymousView + (String)localObject2);
            ((Intent)localObject1).putExtra("KThumbPath", SnsSightPlayerUI.e(SnsSightPlayerUI.this));
            ((Intent)localObject1).putExtra("KFromTimeLine", true);
            ((Intent)localObject1).putExtra("KStremVideoUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTr);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTu)) {
              break label785;
            }
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTl;
            label235:
            ((Intent)localObject1).putExtra("KThumUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("KMediaId", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Id);
            ((Intent)localObject1).putExtra("KUrl", SnsSightPlayerUI.d(SnsSightPlayerUI.this).Url);
            ((Intent)localObject1).putExtra("KViewId", SnsSightPlayerUI.a(SnsSightPlayerUI.this).viewId);
            localObject2 = SnsSightPlayerUI.c(SnsSightPlayerUI.this).getTimeLine();
            if (SnsSightPlayerUI.a(SnsSightPlayerUI.this) != null) {
              break label799;
            }
            paramAnonymousView = "";
            label318:
            ((Intent)localObject1).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView);
            ((Intent)localObject1).putExtra("KSta_StremVideoPublishId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SourceType", 1);
            ((Intent)localObject1).putExtra("KSta_Scene", p.b.PXd.value);
            ((Intent)localObject1).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).UserName);
            ((Intent)localObject1).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
            ((Intent)localObject1).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).statExtStr);
            ((Intent)localObject1).putExtra("KMediaVideoTime", SnsSightPlayerUI.d(SnsSightPlayerUI.this).RGm);
            if (!Util.isNullOrNil(SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTv)) {
              break label813;
            }
            paramAnonymousView = ((TimeLineObject)localObject2).ContentDesc;
            label429:
            ((Intent)localObject1).putExtra("KMediaTitle", paramAnonymousView);
            paramAnonymousView = SnsSightPlayerUI.c(SnsSightPlayerUI.this).getAdXml();
            if ((paramAnonymousView != null) && (paramAnonymousView.attachShareLinkIsHidden == 0))
            {
              ((Intent)localObject1).putExtra("StreamWording", paramAnonymousView.attachShareLinkWording);
              ((Intent)localObject1).putExtra("StremWebUrl", paramAnonymousView.attachShareLinkUrl);
            }
            localObject2 = al.hgB().aZL(SnsSightPlayerUI.f(SnsSightPlayerUI.this));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label827;
            }
            paramAnonymousView = com.tencent.mm.modelsns.l.wO(747);
            label515:
            paramAnonymousView.Ph(t.x((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).hm(true).Ph(((SnsInfo)localObject2).getUxinfo()).wR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).RGm);
            paramAnonymousView.bMH();
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) != 0) {
              break label837;
            }
          }
          label785:
          label799:
          label813:
          label827:
          label837:
          for (paramAnonymousView = com.tencent.mm.modelsns.l.wO(748);; paramAnonymousView = com.tencent.mm.modelsns.l.wP(748))
          {
            paramAnonymousView.Ph(t.x((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).hm(true).Ph(((SnsInfo)localObject2).getUxinfo()).wR(SnsSightPlayerUI.d(SnsSightPlayerUI.this).RGm);
            paramAnonymousView.b((Intent)localObject1, "intent_key_StatisticsOplog");
            paramAnonymousView = SnsSightPlayerUI.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            t.a(new SnsAdClick(SnsSightPlayerUI.b(SnsSightPlayerUI.this), 5, ((SnsInfo)localObject2).field_snsId, 14, 0));
            if (SnsSightPlayerUI.b(SnsSightPlayerUI.this) == 0)
            {
              paramAnonymousView = new xy();
              paramAnonymousView.ibs.isStart = true;
              paramAnonymousView.publish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99088);
            return;
            ((Intent)localObject1).setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
            break;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTu;
            break label235;
            paramAnonymousView = SnsSightPlayerUI.a(SnsSightPlayerUI.this).uxInfo;
            break label318;
            paramAnonymousView = SnsSightPlayerUI.d(SnsSightPlayerUI.this).aaTv;
            break label429;
            paramAnonymousView = com.tencent.mm.modelsns.l.wP(747);
            break label515;
          }
        }
      });
      break label688;
      label1311:
      this.AkH.setVisibility(8);
      break label702;
      label1323:
      al.hgw().a(this.ibT, 6, null, br.adkd);
      this.Rxm.setVisibility(0);
      this.Rxm.jEN();
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
    label148:
    int j;
    label169:
    com.tencent.mm.bx.b localb1;
    label198:
    com.tencent.mm.bx.b localb2;
    if (this.isAd)
    {
      if (this.PNI != null) {
        break label489;
      }
      localObject = "";
      if (this.PNI != null)
      {
        String str2 = this.Rnm.hbj();
        if (this.PNI != null) {
          break label501;
        }
        i = 0;
        long l2 = this.Rnm.PWo - this.Rnm.oTU;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.Rnm.PWo), Long.valueOf(this.Rnm.oTU) });
          l1 = this.Rnm.PWo;
        }
        int k = (int)l1;
        if (this.Qam != null) {
          break label512;
        }
        str1 = "";
        h.baF();
        s locals = h.baD().mCm;
        if (this.source != 0) {
          break label524;
        }
        j = 1;
        int m = this.Rnm.PWo;
        if (this.source != 2) {
          break label529;
        }
        localb1 = this.PNI.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
        if (this.source != 2) {
          break label544;
        }
        localb2 = this.PNI.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
        label218:
        locals.a(new com.tencent.mm.plugin.sns.ad.g.g((String)localObject, j, m, str2, i, k, k, localb1, localb2, str1), 0);
      }
    }
    Log.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
    if ((this.isAd) && (this.PNI != null) && (this.PNI.isAd())) {
      p.a(p.b.PXd, p.a.PWY, this.PNI, this.source);
    }
    al.hgw().b(this);
    Object localObject = com.tencent.mm.modelsns.l.y(getIntent());
    if (localObject != null)
    {
      if (!this.isAd) {
        break label565;
      }
      if (Util.isNullOrNil(this.ibT.aaTr)) {
        break label559;
      }
      label338:
      ((com.tencent.mm.modelsns.l)localObject).hm(bool);
    }
    for (;;)
    {
      ((com.tencent.mm.modelsns.l)localObject).update();
      ((com.tencent.mm.modelsns.l)localObject).bMH();
      if (com.tencent.mm.n.a.aDI() != null) {
        com.tencent.mm.n.a.aDI().aKk();
      }
      if (this.wCd != null)
      {
        this.wCd.setVideoCallback(null);
        this.wCd.stop();
        this.wCd.onDetach();
      }
      if (!this.PGO)
      {
        localObject = new abi();
        ((abi)localObject).ieT.type = 0;
        ((abi)localObject).ieT.ieU = this.PGl;
        ((abi)localObject).ieT.ieV = this.Ahg;
        ((abi)localObject).ieT.ieW = this.ieW;
        ((abi)localObject).publish();
      }
      this.vZw.gR(false);
      AppMethodBeat.o(99105);
      return;
      label489:
      localObject = this.Qam.viewId;
      break;
      label501:
      i = this.PNI.getAdRecSrc();
      break label56;
      label512:
      str1 = this.Qam.waidPkg;
      break label148;
      label524:
      j = 2;
      break label169;
      label529:
      localb1 = this.PNI.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
      break label198;
      label544:
      localb2 = this.PNI.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
      break label218;
      label559:
      bool = false;
      break label338;
      label565:
      ((com.tencent.mm.modelsns.l)localObject).hm(false);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99108);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i)));
    amh(i);
    if (!this.Rvf)
    {
      bck();
      Log.v("check", "onclick");
      new MMHandler().post(new Runnable()
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
      if (this.Rnm != null) {
        this.Rnm.oTT = Util.currentTicks();
      }
      AppMethodBeat.o(99108);
      return;
      bck();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99107);
    super.onResume();
    if (!this.isInit)
    {
      Log.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
      if (getResources().getConfiguration().orientation == 2) {
        bP(getResources().getConfiguration().orientation, true);
      }
      this.isInit = true;
    }
    if ((this.PHf == 0) || (this.PHe == 0))
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.PHf = localDisplayMetrics.heightPixels;
      this.PHe = localDisplayMetrics.widthPixels;
    }
    if ((this.Rvf) && (y.ZC(this.fullPath)))
    {
      Dh(false);
      this.Rvf = false;
    }
    if (this.Rnm != null) {
      this.Rnm.onResume();
    }
    AppMethodBeat.o(99107);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99106);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.wAZ = getIntent().getIntExtra("img_gallery_top", 0);
        this.wBa = getIntent().getIntExtra("img_gallery_left", 0);
        this.wBb = getIntent().getIntExtra("img_gallery_width", 0);
        this.wBc = getIntent().getIntExtra("img_gallery_height", 0);
        this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
        if (localBundle == null) {
          this.PGX.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(99080);
              SnsSightPlayerUI.this.PGX.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsSightPlayerUI.this.wAY.a(SnsSightPlayerUI.this.PGX, SnsSightPlayerUI.t(SnsSightPlayerUI.this), null);
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
  
  public final void w(String paramString, boolean paramBoolean) {}
  
  public final void x(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99112);
    Log.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.ibT != null) && (paramString.equals(this.ibT.Id)) && (y.ZC(this.fullPath)))
    {
      this.Rnm.PWn = 1;
      this.wCd.setVideoPath(this.fullPath);
      Dh(true);
      if (this.Rxm != null) {
        this.Rxm.setVisibility(8);
      }
    }
    AppMethodBeat.o(99112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI
 * JD-Core Version:    0.7.0.1
 */