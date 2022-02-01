package com.tencent.mm.ui.chatting.d.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.y;

public final class a
  extends c
{
  private WxaExposedParams KjP;
  private boolean KjQ;
  private com.tencent.mm.sdk.b.c<nx> KjR;
  private String KjS;
  private d appBrandServiceActionSheet;
  private String appId;
  private int fRv;
  private String kND;
  private String kNE;
  private String kNF;
  private String kNG;
  private String kNH;
  private String mSceneId;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.KjR = new com.tencent.mm.sdk.b.c() {};
    this.KjS = "";
    AppMethodBeat.o(35797);
  }
  
  private void aF(final Runnable paramRunnable)
  {
    AppMethodBeat.i(187460);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187459);
        String str2 = e.aWX(a.this.cXJ.getTalkerUserName());
        String str1;
        if (bu.isNullOrNil(str2))
        {
          str2 = a.this.cXJ.getTalkerUserName();
          if (bu.isNullOrNil(a.this.cXJ.fGT())) {
            str1 = e.aWY(a.this.cXJ.getTalkerUserName());
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
            locala.appId = e.Om(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.bfb());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(187459);
          return;
          str1 = a.this.cXJ.fGT();
          continue;
          str1 = e.aWY(str2);
        }
      }
    });
    AppMethodBeat.o(187460);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35798);
    this.fRv = this.cXJ.Kkd.getIntExtra("app_brand_chatting_from_scene", 1);
    this.KjP = ((WxaExposedParams)this.cXJ.Kkd.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bu.nullAsNil(this.cXJ.Kkd.getStringExtra("key_scene_id"));
    ae.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.fRv), this.KjP, this.mSceneId });
    this.kND = this.cXJ.Kkd.getStringExtra("keyPrivateAppId");
    if (!bu.isNullOrNil(this.kND))
    {
      this.kNE = this.cXJ.Kkd.getStringExtra("keyPrivateUserName");
      this.kNF = this.cXJ.Kkd.getStringExtra("keyPrivateTitle");
      this.kNG = this.cXJ.Kkd.getStringExtra("keyPrivateSubTitle");
      this.kNH = this.cXJ.Kkd.getStringExtra("keyPrivateHeadImage");
      ae.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.kND, this.kNE, this.kNF, this.kNG, this.kNH });
    }
    this.appBrandServiceActionSheet = new d(this.cXJ.Kkd.getContext());
    Object localObject = ((o)g.ab(o.class)).Ob(this.cXJ.getTalkerUserName());
    boolean bool;
    String str;
    b.a locala;
    bdg localbdg;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.KjQ = bool;
      str = this.cXJ.getTalkerUserName();
      localObject = getAppId();
      locala = new b.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.hQH = 0;
      locala.respCmdId = 0;
      localbdg = new bdg();
      str = e.aWX(str);
      if (!bu.isNullOrNil(str)) {
        break label419;
      }
      localbdg.dwb = ((String)localObject);
    }
    for (localbdg.GSI = "";; localbdg.GSI = ((String)localObject))
    {
      locala.hQF = localbdg;
      locala.hQG = new bdh();
      com.tencent.mm.ak.x.a(locala.aDS(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label419:
      localbdg.dwb = e.Om(str);
    }
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35799);
    this.KjR.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35800);
    this.KjR.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void fHr()
  {
    AppMethodBeat.i(35801);
    ae.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.KjS = e.aWY(e.aWX(this.cXJ.getTalkerUserName()));
    boolean bool;
    if (!bu.isNullOrNil(this.kNF))
    {
      this.cXJ.Kkd.setMMTitle(this.kNF);
      if (bu.isNullOrNil(this.kNG)) {
        break label180;
      }
      this.cXJ.Kkd.setMMSubTitle(this.kNG);
      if (!this.kNG.equals(this.KjS)) {
        break label285;
      }
      bool = true;
    }
    for (;;)
    {
      aF(null);
      ((y)this.cXJ.bh(y.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187456);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this.cXJ.Kkd.getContext(), a.b(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187456);
        }
      });
      if (this.KjQ)
      {
        ((y)this.cXJ.bh(y.class)).adQ(0);
        AppMethodBeat.o(35801);
        return;
        this.cXJ.Kkd.setMMTitle(this.cXJ.fGT());
        break;
        label180:
        if (bu.isNullOrNil(this.KjS))
        {
          this.cXJ.Kkd.setMMSubTitle(2131755654);
          bool = false;
          continue;
        }
        this.cXJ.Kkd.setMMSubTitle(ak.getContext().getString(2131755654) + "-" + this.KjS);
        bool = true;
        continue;
      }
      ((y)this.cXJ.bh(y.class)).adQ(8);
      AppMethodBeat.o(35801);
      return;
      label285:
      bool = false;
    }
  }
  
  public final void fJw()
  {
    AppMethodBeat.i(35802);
    this.cXJ.Kkd.addIconOptionMenu(0, 2131755533, 2131690603, new com.tencent.mm.ui.x()
    {
      public final void Zr()
      {
        AppMethodBeat.i(187458);
        a.this.cXJ.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187457);
            a.c(a.this).username = a.this.cXJ.getTalkerUserName();
            a.c(a.this).ntl = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).JCe = a.e(a.this);
            a.c(a.this).mIR = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).show(1);
                AppMethodBeat.o(187457);
                return;
              }
              a.c(a.this).show(2);
              AppMethodBeat.o(187457);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).show(5);
              AppMethodBeat.o(187457);
              return;
            }
            a.c(a.this).show(6);
            AppMethodBeat.o(187457);
          }
        });
        AppMethodBeat.o(187458);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String fJx()
  {
    return this.kNH;
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!bu.isNullOrNil(this.kND)) {
      this.appId = this.kND;
    }
    if (bu.isNullOrNil(this.appId))
    {
      localObject = ((o)g.ab(o.class)).Ob(this.cXJ.getTalkerUserName());
      if (localObject != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bu.isNullOrNil(this.appId)) {
        ae.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
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