package com.tencent.mm.ui.chatting.d.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.y;

public final class a
  extends c
{
  private WxaExposedParams JOD;
  private boolean JOE;
  private com.tencent.mm.sdk.b.c<nw> JOF;
  private String JOG;
  private d appBrandServiceActionSheet;
  private String appId;
  private int fPp;
  private String kKo;
  private String kKp;
  private String kKq;
  private String kKr;
  private String kKs;
  private String mSceneId;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.JOF = new a.1(this);
    this.JOG = "";
    AppMethodBeat.o(35797);
  }
  
  private void aH(final Runnable paramRunnable)
  {
    AppMethodBeat.i(194123);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194122);
        String str2 = e.aVw(a.this.cWM.getTalkerUserName());
        String str1;
        if (bt.isNullOrNil(str2))
        {
          str2 = a.this.cWM.getTalkerUserName();
          if (bt.isNullOrNil(a.this.cWM.fCR())) {
            str1 = e.aVx(a.this.cWM.getTalkerUserName());
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
            locala.appId = e.NE(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.bet());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(194122);
          return;
          str1 = a.this.cWM.fCR();
          continue;
          str1 = e.aVx(str2);
        }
      }
    });
    AppMethodBeat.o(194123);
  }
  
  public final void fDo()
  {
    AppMethodBeat.i(35801);
    ad.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.JOG = e.aVx(e.aVw(this.cWM.getTalkerUserName()));
    boolean bool;
    if (!bt.isNullOrNil(this.kKq))
    {
      this.cWM.JOR.setMMTitle(this.kKq);
      if (bt.isNullOrNil(this.kKr)) {
        break label175;
      }
      this.cWM.JOR.setMMSubTitle(this.kKr);
      if (!this.kKr.equals(this.JOG)) {
        break label275;
      }
      bool = true;
    }
    for (;;)
    {
      aH(null);
      ((y)this.cWM.bh(y.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194119);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this.cWM.JOR.getContext(), a.b(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194119);
        }
      });
      if (this.JOE)
      {
        ((y)this.cWM.bh(y.class)).adj(0);
        AppMethodBeat.o(35801);
        return;
        this.cWM.JOR.setMMTitle(this.cWM.fCR());
        break;
        label175:
        if (bt.isNullOrNil(this.JOG))
        {
          this.cWM.JOR.setMMSubTitle(2131755654);
          bool = false;
          continue;
        }
        this.cWM.JOR.setMMSubTitle(aj.getContext().getString(2131755654) + "-" + this.JOG);
        bool = true;
        continue;
      }
      ((y)this.cWM.bh(y.class)).adj(8);
      AppMethodBeat.o(35801);
      return;
      label275:
      bool = false;
    }
  }
  
  public final void fFp()
  {
    AppMethodBeat.i(35802);
    this.cWM.JOR.addIconOptionMenu(0, 2131755533, 2131690603, new com.tencent.mm.ui.x()
    {
      public final void Zi()
      {
        AppMethodBeat.i(194121);
        a.this.cWM.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194120);
            a.c(a.this).username = a.this.cWM.getTalkerUserName();
            a.c(a.this).nob = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).Jht = a.e(a.this);
            a.c(a.this).mDM = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).show(1);
                AppMethodBeat.o(194120);
                return;
              }
              a.c(a.this).show(2);
              AppMethodBeat.o(194120);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).show(5);
              AppMethodBeat.o(194120);
              return;
            }
            a.c(a.this).show(6);
            AppMethodBeat.o(194120);
          }
        });
        AppMethodBeat.o(194121);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String fFq()
  {
    return this.kKs;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35798);
    this.fPp = this.cWM.JOR.getIntExtra("app_brand_chatting_from_scene", 1);
    this.JOD = ((WxaExposedParams)this.cWM.JOR.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bt.nullAsNil(this.cWM.JOR.getStringExtra("key_scene_id"));
    ad.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.fPp), this.JOD, this.mSceneId });
    this.kKo = this.cWM.JOR.getStringExtra("keyPrivateAppId");
    if (!bt.isNullOrNil(this.kKo))
    {
      this.kKp = this.cWM.JOR.getStringExtra("keyPrivateUserName");
      this.kKq = this.cWM.JOR.getStringExtra("keyPrivateTitle");
      this.kKr = this.cWM.JOR.getStringExtra("keyPrivateSubTitle");
      this.kKs = this.cWM.JOR.getStringExtra("keyPrivateHeadImage");
      ad.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.kKo, this.kKp, this.kKq, this.kKr, this.kKs });
    }
    this.appBrandServiceActionSheet = new d(this.cWM.JOR.getContext());
    Object localObject = ((n)g.ab(n.class)).Nt(this.cWM.getTalkerUserName());
    boolean bool;
    String str;
    b.a locala;
    bcq localbcq;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.JOE = bool;
      str = this.cWM.getTalkerUserName();
      localObject = getAppId();
      locala = new b.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.hNO = 0;
      locala.respCmdId = 0;
      localbcq = new bcq();
      str = e.aVw(str);
      if (!bt.isNullOrNil(str)) {
        break label432;
      }
      localbcq.duW = ((String)localObject);
    }
    for (localbcq.Gzi = "";; localbcq.Gzi = ((String)localObject))
    {
      locala.hNM = localbcq;
      locala.hNN = new bcr();
      com.tencent.mm.al.x.a(locala.aDC(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label432:
      localbcq.duW = e.NE(str);
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35799);
    this.JOF.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35800);
    this.JOF.dead();
    AppMethodBeat.o(35800);
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!bt.isNullOrNil(this.kKo)) {
      this.appId = this.kKo;
    }
    if (bt.isNullOrNil(this.appId))
    {
      localObject = ((n)g.ab(n.class)).Nt(this.cWM.getTalkerUserName());
      if (localObject != null) {
        break label98;
      }
    }
    label98:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bt.isNullOrNil(this.appId)) {
        ad.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
      }
      localObject = this.appId;
      AppMethodBeat.o(35803);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.a
 * JD-Core Version:    0.7.0.1
 */