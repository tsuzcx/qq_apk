package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.ad.g.p.a;
import com.tencent.mm.plugin.sns.ad.g.p.c;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements i.a, i.b, i.c
{
  private TextView AkH;
  private SnsInfo PNI;
  private String QKG;
  private int Qbs;
  private FrameLayout Rnh;
  private SnsAdStreamVideoView Rni;
  private boolean Rnj;
  private boolean Rnk;
  private String Rnl;
  private com.tencent.mm.plugin.sns.ad.g.m Rnm;
  private String Rnn;
  private String Rno;
  private int Rnp;
  private int Rnq;
  private String Rnr;
  private String Rns;
  private String Rnt;
  private long Rnu;
  private int Rnv;
  private int Rnw;
  private boolean Rnx;
  private String iah;
  private String mIE;
  private String mediaId;
  private String nTx;
  private String nTy;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String viewId;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.Rnm = new com.tencent.mm.plugin.sns.ad.g.m("SnsAdStreamVideoPlayUI");
    this.QKG = "";
    AppMethodBeat.o(98458);
  }
  
  private void alW(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.Rni != null) {
      this.Rni.b(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void Du(String paramString) {}
  
  public final void bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.Rnm.PWn = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void el(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.Rni.getVideoDurationSec()) });
    this.Rni.hsP();
    if (this.Qbs == 0) {
      this.Qbs = this.Rni.getVideoDurationSec();
    }
    paramString1 = this.Rnm.PWv;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.PXI = i;
    this.Rnm.PWv.PXJ = Util.currentTicks();
    this.Rnm.PWv.PXH = 2;
    this.Rnm.PWv.PXF = 0;
    paramString1 = this.Rnm.PWv;
    paramString1.PXD += 1;
    this.Rnm.PWv.PXJ = Util.currentTicks();
    AppMethodBeat.o(98466);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.Rnm.PWv;
    paramString1.PXE += 1;
    this.Rni.stop();
    this.Rni.hsM();
    this.Rni.RWH.stopTimer();
    this.Rni.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    Log.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.Rnm.PWv;
    paramString1.PXF += (int)Util.ticksToNow(this.Rnm.PWv.PXJ);
    AppMethodBeat.o(98468);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.Rni.hsN();
    AppMethodBeat.o(98469);
  }
  
  public final void ep(String paramString1, String paramString2) {}
  
  public final void eq(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.Rni.onUIDestroy();
    this.Rni.hsP();
    al.hgw().aXU(this.mediaId);
    if ((this.Rnm != null) && (this.QKG != null) && (this.QKG.length() > 0))
    {
      this.Rnm.hbk();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.QKG);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.Rnm.PWr);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.Rnm.PWs);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.Rnm.PWt);
      setResult(-1, (Intent)localObject);
    }
    if (this.Rnq != 0) {
      com.tencent.mm.plugin.sns.ad.g.p.a(p.a.PWZ, this.Rno, this.Rnn, this.Rnp, this.Rnq, this.Rnr, this.Rns, this.Rnt, this.Rnu, this.Rnv, this.Rnw);
    }
    int i;
    String str;
    int j;
    if (this.Rnx)
    {
      if (this.PNI != null) {
        break label402;
      }
      i = 0;
      if (this.PNI != null)
      {
        str = this.Rnm.hbj();
        long l2 = this.Rnm.PWo - this.Rnm.oTU;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.Rnm.PWo), Long.valueOf(this.Rnm.oTU) });
          l1 = this.Rnm.PWo;
        }
        j = (int)l1;
        localObject = this.PNI.getAdInfo();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      h.baF();
      h.baD().mCm.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.Rnm.PWo, str, i, j, j, this.PNI.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.PNI.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.PNI.getAdRecSrc();
      break;
    }
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  public int getForceOrientation()
  {
    if (this.Rnj) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_ad_stream_play_ui;
  }
  
  public final void hp(long paramLong) {}
  
  public void initView()
  {
    AppMethodBeat.i(98460);
    this.Rnh = ((FrameLayout)findViewById(b.f.root_container));
    this.Rni = ((SnsAdStreamVideoView)findViewById(b.f.video_view));
    this.Rnh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).RWH.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).hsP();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98455);
      }
    });
    this.Rnh.setPadding(0, 0, 0, aw.bk(this));
    this.AkH = ((TextView)findViewById(b.f.show_ad_sight));
    Object localObject;
    if (!Util.isNullOrNil(new String[] { this.nTx, this.nTy }))
    {
      this.AkH.setVisibility(0);
      this.AkH.setText(this.nTx);
      this.AkH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            com.tencent.mm.plugin.sns.ad.g.p.a(p.a.PWX, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
          }
          Intent localIntent = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("key_snsad_statextstr", SnsAdStreamVideoPlayUI.q(SnsAdStreamVideoPlayUI.this));
          localObject = SnsAdStreamVideoPlayUI.r(SnsAdStreamVideoPlayUI.this);
          paramAnonymousView = (View)localObject;
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this))
          {
            paramAnonymousView = (View)localObject;
            if (!TextUtils.isEmpty(SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this))) {
              paramAnonymousView = t.lY((String)localObject, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            t.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.d.a.pFn.h(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98456);
        }
      });
      this.Rni.setReporter(this);
      this.Rni.setIMMVideoViewCallback(this);
      this.Rni.setIMMDownloadFinish(this);
      this.Rni.setRootPath(al.getSnsAdPath());
      this.Rni.b(false, this.mIE, 0);
      this.Rni.setScaleType(i.e.XYM);
      this.Rni.setIOnlineVideoProxy(new ah());
      if ((Util.isNullOrNil(this.thumbPath)) || (!y.ZC(this.thumbPath))) {
        break label314;
      }
      localObject = BitmapUtil.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.Rni.setCover((Bitmap)localObject);
      label247:
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.Rni.isPlaying())
      {
        if (this.Rni.getCurrPosSec() != this.Rni.getVideoDurationSec()) {
          break label502;
        }
        alW(0);
      }
    }
    for (;;)
    {
      this.Rni.start();
      AppMethodBeat.o(98460);
      return;
      this.AkH.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = as.mg(al.getSnsAdPath(), str);
      str = t.aXm(str);
      this.thumbPath = ((String)localObject + str);
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      dmz localdmz = o.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.p localp = new com.tencent.mm.plugin.sns.data.p(localdmz);
      localp.QnY = 3;
      localp.hOG = localdmz.Id;
      al.hgw().a(new a(localdmz.Id));
      com.tencent.mm.plugin.sns.model.c localc = al.hgw();
      br localbr = br.jbh();
      localbr.time = ((int)(System.currentTimeMillis() / 1000L));
      localc.a(localdmz, 8, localp, localbr, (String)localObject, str);
      break label247;
      label502:
      alW(this.Rni.getCurrPosSec());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98471);
    if (999 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", new Object[] { str2 });
          localObject1 = new k.b();
          ((k.b)localObject1).title = this.Rnl;
          ((k.b)localObject1).type = 4;
          label137:
          Object localObject2;
          label246:
          String str3;
          label360:
          int j;
          int k;
          String str4;
          String str5;
          String str6;
          long l;
          int m;
          int n;
          if (!Util.isNullOrNil(this.url))
          {
            ((k.b)localObject1).url = this.url;
            ((k.b)localObject1).thumburl = this.thumbUrl;
            ((k.b)localObject1).nTu = this.mIE;
            ((k.b)localObject1).nTv = this.Qbs;
            ((k.b)localObject1).nTw = this.Rnl;
            ((k.b)localObject1).nTy = this.nTy;
            ((k.b)localObject1).nTx = this.nTx;
            ((k.b)localObject1).nTz = this.thumbUrl;
            ((k.b)localObject1).nTA = this.Rnn;
            ((k.b)localObject1).nTB = this.Rno;
            ((k.b)localObject1).iah = this.iah;
            localObject2 = y.bi(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.bwq() != null) {
              w.a.bwq().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.gaI().ke(str1, str2);
            if (this.Rnx) {
              t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 12, 0));
            }
            if (this.Rnq == 0) {
              continue;
            }
            boolean bool = au.bwE(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = p.c.PXl;
            localObject2 = this.Rno;
            str3 = this.Rnn;
            j = this.Rnp;
            k = this.Rnq;
            str4 = this.Rnr;
            str5 = this.Rns;
            str6 = this.Rnt;
            l = this.Rnu;
            m = this.Rnv;
            n = this.Rnw;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = v.getMembersCountByChatRoomName(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.g.p.a((p.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.mIE;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = p.c.PXk;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.u(this, getString(b.j.has_send));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.Rnq != 0) {
        com.tencent.mm.plugin.sns.ad.g.p.a(p.c.PXm, this.Rno, this.Rnn, this.Rnp, this.Rnq, this.Rnr, this.Rns, this.Rnt, this.Rnu, this.Rnv, this.Rnw, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.Rnx) {
        t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.Rnx) {
        break;
      }
      t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 13, 0));
      break;
      label650:
      if (this.Rnx) {
        t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.mIE = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.Rnj = getIntent().getBooleanExtra("ForceLandscape", false);
    this.Rnk = getIntent().getBooleanExtra("KBlockFav", false);
    this.Rnl = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.Qbs = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.PNI = al.hgB().aZK(t.aXD(paramBundle));
    this.Rnx = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.Rnm.PWp = Util.currentTicks();
    this.QKG = getIntent().getStringExtra("KComponentCid");
    this.Rnn = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.Rno = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.Rnp = getIntent().getIntExtra("KSta_SourceType", 0);
    this.Rnq = getIntent().getIntExtra("KSta_Scene", 0);
    this.Rnr = getIntent().getStringExtra("KSta_FromUserName");
    this.Rns = getIntent().getStringExtra("KSta_ChatName");
    this.Rnt = getIntent().getStringExtra("KSta_SnSId");
    this.Rnu = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.Rnv = getIntent().getIntExtra("KSta_FavID", 0);
    this.Rnw = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.iah = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.nTx = getIntent().getStringExtra("StreamWording");
    this.nTy = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new f(this, 1, false);
    paramBundle.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymouss.jmw())
        {
          paramAnonymouss.oh(1002, b.j.sns_ad_video_right_menu_send_friend);
          paramAnonymouss.oh(1003, b.j.sns_ad_video_right_menu_share_sns);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymouss.oh(1004, b.j.sns_ad_video_right_menu_fav);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(98452);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.d(SnsAdStreamVideoPlayUI.this);
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.e(SnsAdStreamVideoPlayUI.this);
          AppMethodBeat.o(98452);
          return;
          SnsAdStreamVideoPlayUI.f(SnsAdStreamVideoPlayUI.this);
        }
      }
    };
    paramBundle.aeLi = new f.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, b.e.actionbar_icon_light_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.dDn();
        AppMethodBeat.o(98453);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98454);
        SnsAdStreamVideoPlayUI.this.finish();
        AppMethodBeat.o(98454);
        return true;
      }
    }, b.e.actionbar_icon_light_close);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    setActionbarColor(getResources().getColor(b.c.transparent));
    setNavigationbarColor(getResources().getColor(b.c.transparent));
    initView();
    AppMethodBeat.o(98459);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98461);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(98461);
      return true;
    }
    AppMethodBeat.o(98461);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98463);
    super.onResume();
    if (this.Rnm != null) {
      this.Rnm.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.Rni.pause();
    com.tencent.mm.plugin.sns.ad.g.a.b localb;
    if (this.Rnx)
    {
      i = getResources().getConfiguration().orientation;
      this.Rnm.ajw(this.Rni.getCurrPosSec());
      this.Rnm.PWv.PXJ = Util.currentTicks();
      localb = this.Rnm.PWv;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      localb.PXI = i;
      this.Rnm.PWv.PXH = 2;
      if (this.Rnm != null) {
        this.Rnm.oTT = Util.currentTicks();
      }
      AppMethodBeat.o(98464);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements c.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void EE(String paramString) {}
    
    public final void aXr() {}
    
    public final void w(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(98457);
      if ((!Util.isNullOrNil(new String[] { paramString, this.mediaId })) && (paramString.equals(this.mediaId)))
      {
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", new Object[] { paramString });
        paramString = BitmapUtil.decodeFile(SnsAdStreamVideoPlayUI.a(SnsAdStreamVideoPlayUI.this), null);
        if (paramString != null) {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setCover(paramString);
        }
      }
      AppMethodBeat.o(98457);
    }
    
    public final void x(String paramString, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */