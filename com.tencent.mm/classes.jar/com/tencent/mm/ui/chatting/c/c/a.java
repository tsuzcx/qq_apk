package com.tencent.mm.ui.chatting.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.a.no;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.w;

public final class a
  extends c
{
  private WxaExposedParams HZr;
  private boolean HZs;
  private com.tencent.mm.sdk.b.c<no> HZt;
  private String HZu;
  private d appBrandServiceActionSheet;
  private String appId;
  private int fwc;
  private String kpo;
  private String kpp;
  private String kpq;
  private String kpr;
  private String kps;
  private String mSceneId;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.HZt = new com.tencent.mm.sdk.b.c() {};
    this.HZu = "";
    AppMethodBeat.o(35797);
  }
  
  private void aJ(final Runnable paramRunnable)
  {
    AppMethodBeat.i(196530);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196529);
        String str2 = e.aPG(a.this.cLy.getTalkerUserName());
        String str1;
        if (bs.isNullOrNil(str2))
        {
          str2 = a.this.cLy.getTalkerUserName();
          if (bs.isNullOrNil(a.this.cLy.fmy())) {
            str1 = e.aPH(a.this.cLy.getTalkerUserName());
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
            locala.appId = e.Kl(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.baT());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(196529);
          return;
          str1 = a.this.cLy.fmy();
          continue;
          str1 = e.aPH(str2);
        }
      }
    });
    AppMethodBeat.o(196530);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35798);
    this.fwc = this.cLy.HZF.getIntExtra("app_brand_chatting_from_scene", 1);
    this.HZr = ((WxaExposedParams)this.cLy.HZF.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bs.nullAsNil(this.cLy.HZF.getStringExtra("key_scene_id"));
    ac.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.fwc), this.HZr, this.mSceneId });
    this.kpo = this.cLy.HZF.getStringExtra("keyPrivateAppId");
    if (!bs.isNullOrNil(this.kpo))
    {
      this.kpp = this.cLy.HZF.getStringExtra("keyPrivateUserName");
      this.kpq = this.cLy.HZF.getStringExtra("keyPrivateTitle");
      this.kpr = this.cLy.HZF.getStringExtra("keyPrivateSubTitle");
      this.kps = this.cLy.HZF.getStringExtra("keyPrivateHeadImage");
      ac.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.kpo, this.kpp, this.kpq, this.kpr, this.kps });
    }
    this.appBrandServiceActionSheet = new d(this.cLy.HZF.getContext());
    Object localObject = ((m)g.ab(m.class)).Ka(this.cLy.getTalkerUserName());
    boolean bool;
    String str;
    b.a locala;
    aym localaym;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.HZs = bool;
      str = this.cLy.getTalkerUserName();
      localObject = getAppId();
      locala = new b.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      localaym = new aym();
      str = e.aPG(str);
      if (!bs.isNullOrNil(str)) {
        break label419;
      }
      localaym.djj = ((String)localObject);
    }
    for (localaym.EPR = "";; localaym.EPR = ((String)localObject))
    {
      locala.hvt = localaym;
      locala.hvu = new ayn();
      com.tencent.mm.ak.x.a(locala.aAz(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label419:
      localaym.djj = e.Kl(str);
    }
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35799);
    this.HZt.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35800);
    this.HZt.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void fnC()
  {
    AppMethodBeat.i(35801);
    ac.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.HZu = e.aPH(e.aPG(this.cLy.getTalkerUserName()));
    boolean bool;
    if (!bs.isNullOrNil(this.kpq))
    {
      this.cLy.HZF.setMMTitle(this.kpq);
      if (bs.isNullOrNil(this.kpr)) {
        break label180;
      }
      this.cLy.HZF.setMMSubTitle(this.kpr);
      if (!this.kpr.equals(this.HZu)) {
        break label285;
      }
      bool = true;
    }
    for (;;)
    {
      aJ(null);
      ((w)this.cLy.bf(w.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196526);
          ac.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this.cLy.HZF.getContext(), a.b(a.this));
          AppMethodBeat.o(196526);
        }
      });
      if (this.HZs)
      {
        ((w)this.cLy.bf(w.class)).aaX(0);
        AppMethodBeat.o(35801);
        return;
        this.cLy.HZF.setMMTitle(this.cLy.fmy());
        break;
        label180:
        if (bs.isNullOrNil(this.HZu))
        {
          this.cLy.HZF.setMMSubTitle(2131755654);
          bool = false;
          continue;
        }
        this.cLy.HZF.setMMSubTitle(ai.getContext().getString(2131755654) + "-" + this.HZu);
        bool = true;
        continue;
      }
      ((w)this.cLy.bf(w.class)).aaX(8);
      AppMethodBeat.o(35801);
      return;
      label285:
      bool = false;
    }
  }
  
  public final void foK()
  {
    AppMethodBeat.i(35802);
    this.cLy.HZF.addIconOptionMenu(0, 2131755533, 2131690603, new com.tencent.mm.ui.x()
    {
      public final void WP()
      {
        AppMethodBeat.i(196528);
        a.this.cLy.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196527);
            a.c(a.this).username = a.this.cLy.getTalkerUserName();
            a.c(a.this).mNF = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).HtD = a.e(a.this);
            a.c(a.this).mdC = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).show(1);
                AppMethodBeat.o(196527);
                return;
              }
              a.c(a.this).show(2);
              AppMethodBeat.o(196527);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).show(5);
              AppMethodBeat.o(196527);
              return;
            }
            a.c(a.this).show(6);
            AppMethodBeat.o(196527);
          }
        });
        AppMethodBeat.o(196528);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String foL()
  {
    return this.kps;
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!bs.isNullOrNil(this.kpo)) {
      this.appId = this.kpo;
    }
    if (bs.isNullOrNil(this.appId))
    {
      localObject = ((m)g.ab(m.class)).Ka(this.cLy.getTalkerUserName());
      if (localObject != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bs.isNullOrNil(this.appId)) {
        ac.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
      }
      localObject = this.appId;
      AppMethodBeat.o(35803);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.a
 * JD-Core Version:    0.7.0.1
 */