package com.tencent.mm.ui.chatting.d.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d.a;
import com.tencent.mm.f.a.pm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class a
  extends c
{
  private WxaExposedParams WQi;
  private boolean WQj;
  private IListener<pm> WQk;
  private String WQl;
  private d appBrandServiceActionSheet;
  private String appId;
  private int jaR;
  private String mSceneId;
  private String oOZ;
  private String oPa;
  private String oPb;
  private String oPc;
  private String oPd;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.WQk = new a.1(this);
    this.WQl = "";
    AppMethodBeat.o(35797);
  }
  
  private void aS(final Runnable paramRunnable)
  {
    AppMethodBeat.i(292349);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289630);
        String str2 = e.byw(a.this.fgR.getTalkerUserName());
        String str1;
        if (Util.isNullOrNil(str2))
        {
          str2 = a.this.fgR.getTalkerUserName();
          if (Util.isNullOrNil(a.this.fgR.hOp())) {
            str1 = e.byx(a.this.fgR.getTalkerUserName());
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
            locala.appId = e.afi(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.bLN());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(289630);
          return;
          str1 = a.this.fgR.hOp();
          continue;
          str1 = e.byx(str2);
        }
      }
    });
    AppMethodBeat.o(292349);
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!Util.isNullOrNil(this.oOZ)) {
      this.appId = this.oOZ;
    }
    if (Util.isNullOrNil(this.appId))
    {
      localObject = ((q)h.ae(q.class)).aeW(this.fgR.getTalkerUserName());
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
  
  public final void hGU()
  {
    AppMethodBeat.i(35798);
    this.jaR = this.fgR.WQv.getIntExtra("app_brand_chatting_from_scene", 1);
    this.WQi = ((WxaExposedParams)this.fgR.WQv.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = Util.nullAsNil(this.fgR.WQv.getStringExtra("key_scene_id"));
    Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.jaR), this.WQi, this.mSceneId });
    this.oOZ = this.fgR.WQv.getStringExtra("keyPrivateAppId");
    if (!Util.isNullOrNil(this.oOZ))
    {
      this.oPa = this.fgR.WQv.getStringExtra("keyPrivateUserName");
      this.oPb = this.fgR.WQv.getStringExtra("keyPrivateTitle");
      this.oPc = this.fgR.WQv.getStringExtra("keyPrivateSubTitle");
      this.oPd = this.fgR.WQv.getStringExtra("keyPrivateHeadImage");
      Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.oOZ, this.oPa, this.oPb, this.oPc, this.oPd });
    }
    this.appBrandServiceActionSheet = new d(this.fgR.WQv.getContext());
    Object localObject = ((q)h.ae(q.class)).aeW(this.fgR.getTalkerUserName());
    boolean bool;
    String str;
    d.a locala;
    bwp localbwp;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.WQj = bool;
      str = this.fgR.getTalkerUserName();
      localObject = getAppId();
      locala = new d.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.lBW = 0;
      locala.respCmdId = 0;
      localbwp = new bwp();
      str = e.byw(str);
      if (!Util.isNullOrNil(str)) {
        break label419;
      }
      localbwp.appid = ((String)localObject);
    }
    for (localbwp.Tgs = "";; localbwp.Tgs = ((String)localObject))
    {
      locala.lBU = localbwp;
      locala.lBV = new bwq();
      com.tencent.mm.an.aa.a(locala.bgN(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label419:
      localbwp.appid = e.afi(str);
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35799);
    this.WQk.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35800);
    this.WQk.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void hOL()
  {
    AppMethodBeat.i(35801);
    Log.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.WQl = e.byx(e.byw(this.fgR.getTalkerUserName()));
    boolean bool;
    if (!Util.isNullOrNil(this.oPb))
    {
      this.fgR.WQv.setMMTitle(this.oPb);
      if (Util.isNullOrNil(this.oPc)) {
        break label180;
      }
      this.fgR.WQv.setMMSubTitle(this.oPc);
      if (!this.oPc.equals(this.WQl)) {
        break label285;
      }
      bool = true;
    }
    for (;;)
    {
      aS(null);
      ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(281843);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this.fgR.WQv.getContext(), a.b(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(281843);
        }
      });
      if (this.WQj)
      {
        ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).avC(0);
        AppMethodBeat.o(35801);
        return;
        this.fgR.WQv.setMMTitle(this.fgR.hOp());
        break;
        label180:
        if (Util.isNullOrNil(this.WQl))
        {
          this.fgR.WQv.setMMSubTitle(R.l.eoA);
          bool = false;
          continue;
        }
        this.fgR.WQv.setMMSubTitle(MMApplicationContext.getContext().getString(R.l.eoA) + "-" + this.WQl);
        bool = true;
        continue;
      }
      ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).avC(8);
      AppMethodBeat.o(35801);
      return;
      label285:
      bool = false;
    }
  }
  
  public final void hRd()
  {
    AppMethodBeat.i(35802);
    this.fgR.WQv.addIconOptionMenu(0, R.l.eos, R.k.icons_outlined_more, new ab()
    {
      public final void atf()
      {
        AppMethodBeat.i(271693);
        a.this.fgR.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(273287);
            a.c(a.this).username = a.this.fgR.getTalkerUserName();
            a.c(a.this).rFe = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).UJN = a.e(a.this);
            a.c(a.this).qXo = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).CR(1);
                AppMethodBeat.o(273287);
                return;
              }
              a.c(a.this).CR(2);
              AppMethodBeat.o(273287);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).CR(5);
              AppMethodBeat.o(273287);
              return;
            }
            a.c(a.this).CR(6);
            AppMethodBeat.o(273287);
          }
        });
        AppMethodBeat.o(271693);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String hRe()
  {
    return this.oPd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.a
 * JD-Core Version:    0.7.0.1
 */