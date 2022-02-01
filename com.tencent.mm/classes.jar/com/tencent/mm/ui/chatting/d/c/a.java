package com.tencent.mm.ui.chatting.d.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.g.a.op;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
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
import com.tencent.mm.ui.y;

public final class a
  extends c
{
  private WxaExposedParams PvP;
  private boolean PvQ;
  private IListener<op> PvR;
  private String PvS;
  private d appBrandServiceActionSheet;
  private String appId;
  private int gwE;
  private String lSu;
  private String lSv;
  private String lSw;
  private String lSx;
  private String lSy;
  private String mSceneId;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.PvR = new IListener() {};
    this.PvS = "";
    AppMethodBeat.o(35797);
  }
  
  private void aM(final Runnable paramRunnable)
  {
    AppMethodBeat.i(233265);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233264);
        String str2 = e.blX(a.this.dom.getTalkerUserName());
        String str1;
        if (Util.isNullOrNil(str2))
        {
          str2 = a.this.dom.getTalkerUserName();
          if (Util.isNullOrNil(a.this.dom.gOZ())) {
            str1 = e.blY(a.this.dom.getTalkerUserName());
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
            locala.appId = e.Xw(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.a(a.this, locala.bAv());
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(233264);
          return;
          str1 = a.this.dom.gOZ();
          continue;
          str1 = e.blY(str2);
        }
      }
    });
    AppMethodBeat.o(233265);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35799);
    this.PvR.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35800);
    this.PvR.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35798);
    this.gwE = this.dom.Pwc.getIntExtra("app_brand_chatting_from_scene", 1);
    this.PvP = ((WxaExposedParams)this.dom.Pwc.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = Util.nullAsNil(this.dom.Pwc.getStringExtra("key_scene_id"));
    Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.gwE), this.PvP, this.mSceneId });
    this.lSu = this.dom.Pwc.getStringExtra("keyPrivateAppId");
    if (!Util.isNullOrNil(this.lSu))
    {
      this.lSv = this.dom.Pwc.getStringExtra("keyPrivateUserName");
      this.lSw = this.dom.Pwc.getStringExtra("keyPrivateTitle");
      this.lSx = this.dom.Pwc.getStringExtra("keyPrivateSubTitle");
      this.lSy = this.dom.Pwc.getStringExtra("keyPrivateHeadImage");
      Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.lSu, this.lSv, this.lSw, this.lSx, this.lSy });
    }
    this.appBrandServiceActionSheet = new d(this.dom.Pwc.getContext());
    Object localObject = ((q)g.af(q.class)).Xk(this.dom.getTalkerUserName());
    boolean bool;
    String str;
    d.a locala;
    bou localbou;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.PvQ = bool;
      str = this.dom.getTalkerUserName();
      localObject = getAppId();
      locala = new d.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.iLP = 0;
      locala.respCmdId = 0;
      localbou = new bou();
      str = e.blX(str);
      if (!Util.isNullOrNil(str)) {
        break label419;
      }
      localbou.dNI = ((String)localObject);
    }
    for (localbou.LWU = "";; localbou.LWU = ((String)localObject))
    {
      locala.iLN = localbou;
      locala.iLO = new bov();
      com.tencent.mm.ak.aa.a(locala.aXF(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label419:
      localbou.dNI = e.Xw(str);
    }
  }
  
  public final void gPx()
  {
    AppMethodBeat.i(35801);
    Log.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    this.PvS = e.blY(e.blX(this.dom.getTalkerUserName()));
    boolean bool;
    if (!Util.isNullOrNil(this.lSw))
    {
      this.dom.Pwc.setMMTitle(this.lSw);
      if (Util.isNullOrNil(this.lSx)) {
        break label180;
      }
      this.dom.Pwc.setMMSubTitle(this.lSx);
      if (!this.lSx.equals(this.PvS)) {
        break label285;
      }
      bool = true;
    }
    for (;;)
    {
      aM(null);
      ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).a(bool, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233261);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
          a.a(a.this.dom.Pwc.getContext(), a.b(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233261);
        }
      });
      if (this.PvQ)
      {
        ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).amB(0);
        AppMethodBeat.o(35801);
        return;
        this.dom.Pwc.setMMTitle(this.dom.gOZ());
        break;
        label180:
        if (Util.isNullOrNil(this.PvS))
        {
          this.dom.Pwc.setMMSubTitle(2131755701);
          bool = false;
          continue;
        }
        this.dom.Pwc.setMMSubTitle(MMApplicationContext.getContext().getString(2131755701) + "-" + this.PvS);
        bool = true;
        continue;
      }
      ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).amB(8);
      AppMethodBeat.o(35801);
      return;
      label285:
      bool = false;
    }
  }
  
  public final void gRG()
  {
    AppMethodBeat.i(35802);
    this.dom.Pwc.addIconOptionMenu(0, 2131755571, 2131690843, new y()
    {
      public final void ane()
      {
        AppMethodBeat.i(233263);
        a.this.dom.hideVKB();
        a.a(a.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233262);
            a.c(a.this).username = a.this.dom.getTalkerUserName();
            a.c(a.this).oDm = false;
            a.c(a.this).scene = a.d(a.this);
            a.c(a.this).OMW = a.e(a.this);
            a.c(a.this).nVO = a.b(a.this);
            if ((a.d(a.this) == 2) || (a.d(a.this) == 3))
            {
              if (a.a(a.this))
              {
                a.c(a.this).show(1);
                AppMethodBeat.o(233262);
                return;
              }
              a.c(a.this).show(2);
              AppMethodBeat.o(233262);
              return;
            }
            a.c(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.c(a.this).show(5);
              AppMethodBeat.o(233262);
              return;
            }
            a.c(a.this).show(6);
            AppMethodBeat.o(233262);
          }
        });
        AppMethodBeat.o(233263);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String gRH()
  {
    return this.lSy;
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!Util.isNullOrNil(this.lSu)) {
      this.appId = this.lSu;
    }
    if (Util.isNullOrNil(this.appId))
    {
      localObject = ((q)g.af(q.class)).Xk(this.dom.getTalkerUserName());
      if (localObject != null) {
        break label97;
      }
    }
    label97:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.a
 * JD-Core Version:    0.7.0.1
 */