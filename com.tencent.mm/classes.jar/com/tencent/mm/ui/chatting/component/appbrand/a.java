package com.tencent.mm.ui.chatting.component.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.z;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.qz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class a
  extends c
{
  private int aeeA;
  private WxaExposedParams aezB;
  private boolean aezC;
  private IListener<qz> aezD;
  private String aezE;
  private d appBrandServiceActionSheet;
  private String appId;
  private int lCR;
  private String mSceneId;
  private String rSN;
  private String rSO;
  private String rSP;
  private String rSQ;
  private String rSR;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.aezD = new AppBrandServiceComponent.1(this, f.hfK);
    this.aezE = "";
    AppMethodBeat.o(35797);
  }
  
  private void bb(final Runnable paramRunnable)
  {
    AppMethodBeat.i(256350);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256347);
        String str2 = e.bzU(a.this.hlc.getTalkerUserName());
        String str1;
        if (Util.isNullOrNil(str2))
        {
          str2 = a.this.hlc.getTalkerUserName();
          if (Util.isNullOrNil(a.this.hlc.jrh())) {
            str1 = e.bzV(a.this.hlc.getTalkerUserName());
          }
        }
        for (;;)
        {
          if ((a.d(a.this) == 3) && (TextUtils.isEmpty(a.b(a.this).nickname))) {
            a.b(a.this).nickname = str1;
          }
          if ((a.d(a.this) != 2) && (a.d(a.this) != 3))
          {
            WxaExposedParams.a locala = new WxaExposedParams.a();
            locala.appId = e.XJ(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.cll());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(256347);
          return;
          str1 = a.this.hlc.jrh();
          continue;
          str1 = e.bzV(str2);
        }
      }
    });
    AppMethodBeat.o(256350);
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!Util.isNullOrNil(this.rSN)) {
      this.appId = this.rSN;
    }
    if (Util.isNullOrNil(this.appId))
    {
      localObject = ((s)h.ax(s.class)).Xy(this.hlc.getTalkerUserName());
      if (localObject != null) {
        break label94;
      }
    }
    label94:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (Util.isNullOrNil(this.appId)) {
        Log.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
      }
      localObject = this.appId;
      AppMethodBeat.o(35803);
      return localObject;
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35798);
    this.lCR = this.hlc.aezO.getIntExtra("app_brand_chatting_from_scene", 1);
    this.aeeA = this.hlc.aezO.getIntExtra("app_brand_chatting_from_scene_new", 3);
    this.aezB = ((WxaExposedParams)this.hlc.aezO.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = Util.nullAsNil(this.hlc.aezO.getStringExtra("key_scene_id"));
    Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d newScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.lCR), Integer.valueOf(this.aeeA), this.aezB, this.mSceneId });
    this.rSN = this.hlc.aezO.getStringExtra("keyPrivateAppId");
    if (!Util.isNullOrNil(this.rSN))
    {
      this.rSO = this.hlc.aezO.getStringExtra("keyPrivateUserName");
      this.rSP = this.hlc.aezO.getStringExtra("keyPrivateTitle");
      this.rSQ = this.hlc.aezO.getStringExtra("keyPrivateSubTitle");
      this.rSR = this.hlc.aezO.getStringExtra("keyPrivateHeadImage");
      Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.rSN, this.rSO, this.rSP, this.rSQ, this.rSR });
    }
    this.appBrandServiceActionSheet = new d(this.hlc.aezO.getContext());
    Object localObject = ((s)h.ax(s.class)).Xy(this.hlc.getTalkerUserName());
    boolean bool;
    String str;
    c.a locala;
    cls localcls;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.aezC = bool;
      str = this.hlc.getTalkerUserName();
      localObject = getAppId();
      locala = new c.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.otG = 0;
      locala.respCmdId = 0;
      localcls = new cls();
      str = e.bzU(str);
      if (!Util.isNullOrNil(str)) {
        break label450;
      }
      localcls.appid = ((String)localObject);
    }
    for (localcls.ZnO = "";; localcls.ZnO = ((String)localObject))
    {
      locala.otE = localcls;
      locala.otF = new clt();
      z.a(locala.bEF(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label450:
      localcls.appid = e.XJ(str);
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35799);
    this.aezD.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35800);
    this.aezD.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void jrB()
  {
    AppMethodBeat.i(35801);
    Log.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.aezE = e.bzV(e.bzU(this.hlc.getTalkerUserName()));
    boolean bool;
    if (!Util.isNullOrNil(this.rSP))
    {
      this.hlc.aezO.setMMTitle(this.rSP);
      if (Util.isNullOrNil(this.rSQ)) {
        break label189;
      }
      this.hlc.aezO.setMMSubTitle(this.rSQ);
      if (!this.rSQ.equals(this.aezE)) {
        break label294;
      }
      bool = true;
    }
    for (;;)
    {
      bb(null);
      ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(256343);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this, a.this.hlc.aezO.getContext(), a.b(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256343);
        }
      }, MMApplicationContext.getContext().getString(R.l.grt));
      if (this.aezC)
      {
        ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).aCe(0);
        AppMethodBeat.o(35801);
        return;
        this.hlc.aezO.setMMTitle(this.hlc.jrh());
        break;
        label189:
        if (Util.isNullOrNil(this.aezE))
        {
          this.hlc.aezO.setMMSubTitle(R.l.grz);
          bool = false;
          continue;
        }
        this.hlc.aezO.setMMSubTitle(MMApplicationContext.getContext().getString(R.l.grz) + "-" + this.aezE);
        bool = true;
        continue;
      }
      ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).aCe(8);
      AppMethodBeat.o(35801);
      return;
      label294:
      bool = false;
    }
  }
  
  public final void juC()
  {
    AppMethodBeat.i(35802);
    this.hlc.aezO.addIconOptionMenu(0, R.l.grq, R.k.icons_outlined_more, new com.tencent.mm.ui.ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256345);
        a.this.hlc.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(256344);
            a.c(a.this).username = a.this.hlc.getTalkerUserName();
            a.c(a.this).uQq = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).xIc = a.e(a.this);
            a.c(a.this).ucN = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).Dk(1);
                AppMethodBeat.o(256344);
                return;
              }
              a.c(a.this).Dk(2);
              AppMethodBeat.o(256344);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).Dk(5);
              AppMethodBeat.o(256344);
              return;
            }
            a.c(a.this).Dk(6);
            AppMethodBeat.o(256344);
          }
        });
        AppMethodBeat.o(256345);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String juD()
  {
    return this.rSR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.appbrand.a
 * JD-Core Version:    0.7.0.1
 */