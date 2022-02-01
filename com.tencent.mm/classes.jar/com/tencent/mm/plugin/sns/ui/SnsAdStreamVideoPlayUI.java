package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.g.o.a;
import com.tencent.mm.plugin.sns.ad.g.o.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI
  extends MMActivity
  implements i.a, i.b, i.c
{
  private String DZi;
  private SnsInfo DsC;
  private int Dzs;
  private FrameLayout EzH;
  private SnsAdStreamVideoView EzI;
  private String EzJ;
  private boolean EzK;
  private boolean EzL;
  private String EzM;
  private l EzN;
  private String EzO;
  private String EzP;
  private int EzQ;
  private int EzR;
  private String EzS;
  private String EzT;
  private String EzU;
  private long EzV;
  private int EzW;
  private int EzX;
  private boolean EzY;
  private String ean;
  private String izc;
  private String izd;
  private String mediaId;
  private TextView thO;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String viewId;
  
  public SnsAdStreamVideoPlayUI()
  {
    AppMethodBeat.i(98458);
    this.EzN = new l("SnsAdStreamVideoPlayUI");
    this.DZi = "";
    AppMethodBeat.o(98458);
  }
  
  private void YX(int paramInt)
  {
    AppMethodBeat.i(98465);
    if (this.EzI != null) {
      this.EzI.c(paramInt, true);
    }
    AppMethodBeat.o(98465);
  }
  
  public final void DX(String paramString) {}
  
  public final void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98470);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", new Object[] { paramString });
    this.EzN.DvO = 1;
    AppMethodBeat.o(98470);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dH(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(98466);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", new Object[] { paramString2, Integer.valueOf(this.EzI.getVideoDurationSec()) });
    this.EzI.flg();
    if (this.Dzs == 0) {
      this.Dzs = this.EzI.getVideoDurationSec();
    }
    paramString1 = this.EzN.DvW;
    if (getResources().getConfiguration().orientation == 2) {
      i = 2;
    }
    paramString1.Dxb = i;
    this.EzN.DvW.Dxc = Util.currentTicks();
    this.EzN.DvW.Dxa = 2;
    this.EzN.DvW.DwY = 0;
    paramString1 = this.EzN.DvW;
    paramString1.DwW += 1;
    this.EzN.DvW.Dxc = Util.currentTicks();
    AppMethodBeat.o(98466);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98467);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", new Object[] { paramString2 });
    paramString1 = this.EzN.DvW;
    paramString1.DwX += 1;
    this.EzI.stop();
    this.EzI.fld();
    this.EzI.FeB.stopTimer();
    this.EzI.setIsShowBasicControls(true);
    AppMethodBeat.o(98467);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98468);
    Log.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", new Object[] { paramString2 });
    paramString1 = this.EzN.DvW;
    paramString1.DwY += (int)Util.ticksToNow(this.EzN.DvW.Dxc);
    AppMethodBeat.o(98468);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98469);
    this.EzI.fle();
    AppMethodBeat.o(98469);
  }
  
  public final void dL(String paramString1, String paramString2) {}
  
  public final void dM(String paramString1, String paramString2) {}
  
  public void finish()
  {
    AppMethodBeat.i(98462);
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
    this.EzI.onUIDestroy();
    this.EzI.flg();
    aj.faJ().aOM(this.mediaId);
    if ((this.EzN != null) && (this.DZi != null) && (this.DZi.length() > 0))
    {
      this.EzN.eXs();
      localObject = new Intent();
      ((Intent)localObject).putExtra("KComponentCid", this.DZi);
      ((Intent)localObject).putExtra("KStreamVideoPlayCount", this.EzN.DvS);
      ((Intent)localObject).putExtra("KStreamVideoPlayCompleteCount", this.EzN.DvT);
      ((Intent)localObject).putExtra("KStreamVideoTotalPlayTimeInMs", this.EzN.DvU);
      setResult(-1, (Intent)localObject);
    }
    if (this.EzR != 0) {
      o.a(o.a.Dwx, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX);
    }
    int i;
    String str;
    int j;
    if (this.EzY)
    {
      if (this.DsC != null) {
        break label402;
      }
      i = 0;
      if (this.DsC != null)
      {
        str = this.EzN.eXr();
        long l2 = this.EzN.DvP - this.EzN.jkZ;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ) });
          l1 = this.EzN.DvP;
        }
        j = (int)l1;
        localObject = this.DsC.getAdInfo();
        if (localObject != null) {
          break label413;
        }
      }
    }
    label402:
    label413:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.EzN.DvP, str, i, j, j, this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      super.finish();
      AppMethodBeat.o(98462);
      return;
      i = this.DsC.getAdRecSrc();
      break;
    }
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  public int getForceOrientation()
  {
    if (this.EzK) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131496404;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98460);
    this.EzH = ((FrameLayout)findViewById(2131307160));
    this.EzI = ((SnsAdStreamVideoView)findViewById(2131309841));
    this.EzH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98455);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).setIsShowBasicControls(true);
        if (SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).isPlaying())
        {
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).FeB.stopTimer();
          SnsAdStreamVideoPlayUI.b(SnsAdStreamVideoPlayUI.this).flg();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98455);
      }
    });
    this.EzH.setPadding(0, 0, 0, ao.aD(this));
    this.thO = ((TextView)findViewById(2131307859));
    Object localObject;
    if (!Util.isNullOrNil(new String[] { this.izc, this.izd }))
    {
      this.thO.setVisibility(0);
      this.thO.setText(this.izc);
      this.thO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98456);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this) != 0) {
            o.a(o.a.Dwv, SnsAdStreamVideoPlayUI.h(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.j(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.g(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.k(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.l(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.m(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.n(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.o(SnsAdStreamVideoPlayUI.this), SnsAdStreamVideoPlayUI.p(SnsAdStreamVideoPlayUI.this));
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
              paramAnonymousView = r.kb((String)localObject, SnsAdStreamVideoPlayUI.i(SnsAdStreamVideoPlayUI.this));
            }
          }
          localIntent.putExtra("jsapiargs", localBundle);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("useJs", true);
          if (SnsAdStreamVideoPlayUI.s(SnsAdStreamVideoPlayUI.this)) {
            r.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.t(SnsAdStreamVideoPlayUI.this).field_snsId, 18, 0));
          }
          com.tencent.mm.plugin.sns.c.a.jRt.i(localIntent, SnsAdStreamVideoPlayUI.this);
          SnsAdStreamVideoPlayUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98456);
        }
      });
      this.EzI.setReporter(this);
      this.EzI.setIMMVideoViewCallback(this);
      this.EzI.setIMMDownloadFinish(this);
      this.EzI.setRootPath(aj.getSnsAdPath());
      this.EzI.c(false, this.EzJ, 0);
      this.EzI.setScaleType(i.e.Kcb);
      this.EzI.setIOnlineVideoProxy(new af());
      if ((Util.isNullOrNil(this.thumbPath)) || (!s.YS(this.thumbPath))) {
        break label314;
      }
      localObject = BitmapUtil.decodeFile(this.thumbPath, null);
      if (localObject == null) {
        break label314;
      }
      this.EzI.setCover((Bitmap)localObject);
      label247:
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
      if (!this.EzI.isPlaying())
      {
        if (this.EzI.getCurrPosSec() != this.EzI.getVideoDurationSec()) {
          break label502;
        }
        YX(0);
      }
    }
    for (;;)
    {
      this.EzI.start();
      AppMethodBeat.o(98460);
      return;
      this.thO.setVisibility(8);
      break;
      label314:
      String str = "attach" + this.mediaId;
      localObject = ar.ki(aj.getSnsAdPath(), str);
      str = r.aOf(str);
      this.thumbPath = ((String)localObject + str);
      Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", new Object[] { this.mediaId, this.thumbPath });
      cnb localcnb = com.tencent.mm.modelsns.n.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
      com.tencent.mm.plugin.sns.data.n localn = new com.tencent.mm.plugin.sns.data.n(localcnb);
      localn.DEs = 3;
      localn.dPI = localcnb.Id;
      aj.faJ().a(new a(localcnb.Id));
      c localc = aj.faJ();
      bp localbp = bp.gCU();
      localbp.hXs = ((int)(System.currentTimeMillis() / 1000L));
      localc.a(localcnb, 8, localn, localbp, (String)localObject, str);
      break label247;
      label502:
      YX(this.EzI.getCurrPosSec());
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
          ((k.b)localObject1).title = this.EzM;
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
            ((k.b)localObject1).iyZ = this.EzJ;
            ((k.b)localObject1).iza = this.Dzs;
            ((k.b)localObject1).izb = this.EzM;
            ((k.b)localObject1).izd = this.izd;
            ((k.b)localObject1).izc = this.izc;
            ((k.b)localObject1).ize = this.thumbUrl;
            ((k.b)localObject1).izf = this.EzO;
            ((k.b)localObject1).izg = this.EzP;
            ((k.b)localObject1).ean = this.ean;
            localObject2 = s.aW(this.thumbPath, 0, -1);
            if (localObject2 != null) {
              break label474;
            }
            i = 0;
            Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.aSz() != null) {
              w.a.aSz().a((k.b)localObject1, "", "", str2, "", (byte[])localObject2);
            }
            com.tencent.mm.plugin.messenger.a.g.eir().iF(str1, str2);
            if (this.EzY) {
              r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 12, 0));
            }
            if (this.EzR == 0) {
              continue;
            }
            boolean bool = ab.Eq(str2);
            if (!bool) {
              break label482;
            }
            localObject1 = o.c.DwJ;
            localObject2 = this.EzP;
            str3 = this.EzO;
            j = this.EzQ;
            k = this.EzR;
            str4 = this.EzS;
            str5 = this.EzT;
            str6 = this.EzU;
            l = this.EzV;
            m = this.EzW;
            n = this.EzX;
            if (!bool) {
              break label490;
            }
          }
          label474:
          label482:
          label490:
          for (int i = v.Ie(str2);; i = 0)
          {
            o.a((o.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject1).url = this.EzJ;
            break label137;
            i = localObject2.length;
            break label246;
            localObject1 = o.c.DwI;
            break label360;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
      }
    }
    else if (998 == paramInt1)
    {
      if (this.EzR != 0) {
        o.a(o.c.DwK, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX, 0);
      }
      if (-1 != paramInt2) {
        break label650;
      }
      if (this.EzY) {
        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98471);
      return;
      if (!this.EzY) {
        break;
      }
      r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 13, 0));
      break;
      label650:
      if (this.EzY) {
        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 16, 0));
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98459);
    super.onCreate(paramBundle);
    this.url = getIntent().getStringExtra("KUrl");
    this.EzJ = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.thumbPath = getIntent().getStringExtra("KThumbPath");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.EzK = getIntent().getBooleanExtra("ForceLandscape", false);
    this.EzL = getIntent().getBooleanExtra("KBlockFav", false);
    this.EzM = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.Dzs = getIntent().getIntExtra("KMediaVideoTime", 0);
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.DsC = aj.faO().aQl(r.aOw(paramBundle));
    this.EzY = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.EzN.DvQ = Util.currentTicks();
    this.DZi = getIntent().getStringExtra("KComponentCid");
    this.EzO = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.EzP = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.EzQ = getIntent().getIntExtra("KSta_SourceType", 0);
    this.EzR = getIntent().getIntExtra("KSta_Scene", 0);
    this.EzS = getIntent().getStringExtra("KSta_FromUserName");
    this.EzT = getIntent().getStringExtra("KSta_ChatName");
    this.EzU = getIntent().getStringExtra("KSta_SnSId");
    this.EzV = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.EzW = getIntent().getIntExtra("KSta_FavID", 0);
    this.EzX = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.ean = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.izc = getIntent().getStringExtra("StreamWording");
    this.izd = getIntent().getStringExtra("StremWebUrl");
    setMMTitle("");
    paramBundle = new e(this, 1, false);
    paramBundle.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(98451);
        if (paramAnonymousm.gKQ())
        {
          paramAnonymousm.kV(1002, 2131765992);
          paramAnonymousm.kV(1003, 2131765993);
          if (!SnsAdStreamVideoPlayUI.c(SnsAdStreamVideoPlayUI.this)) {
            paramAnonymousm.kV(1004, 2131765990);
          }
        }
        AppMethodBeat.o(98451);
      }
    };
    paramBundle.HLY = new o.g()
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
    paramBundle.PGl = new e.b()
    {
      public final void onDismiss() {}
    };
    addIconOptionMenu(1001, 2131230866, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98453);
        paramBundle.dGm();
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
    }, 2131230864);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    setActionbarColor(getResources().getColor(2131101287));
    setNavigationbarColor(getResources().getColor(2131101287));
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
    if (this.EzN != null) {
      this.EzN.onResume();
    }
    AppMethodBeat.o(98463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(98464);
    super.onStop();
    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
    this.EzI.pause();
    com.tencent.mm.plugin.sns.ad.g.a.a locala;
    if (this.EzY)
    {
      i = getResources().getConfiguration().orientation;
      this.EzN.XK(this.EzI.getCurrPosSec());
      this.EzN.DvW.Dxc = Util.currentTicks();
      locala = this.EzN.DvW;
      if (i != 2) {
        break label127;
      }
    }
    label127:
    for (int i = 2;; i = 1)
    {
      locala.Dxb = i;
      this.EzN.DvW.Dxa = 2;
      if (this.EzN != null) {
        this.EzN.jkY = Util.currentTicks();
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
  
  public final void yU(long paramLong) {}
  
  final class a
    implements c.b
  {
    private String mediaId;
    
    public a(String paramString)
    {
      this.mediaId = paramString;
    }
    
    public final void aOG(String paramString) {}
    
    public final void ci(String paramString, boolean paramBoolean)
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
    
    public final void cj(String paramString, boolean paramBoolean) {}
    
    public final void eZJ() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */