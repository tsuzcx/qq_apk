package com.tencent.mm.ui.chatting.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.appbrand.e.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class a
  extends c
{
  private WxaExposedParams Gzw;
  private boolean Gzx;
  private com.tencent.mm.sdk.b.c<nf> Gzy;
  private String Gzz;
  private d appBrandServiceActionSheet;
  private String appId;
  private int fsv;
  private String jON;
  private String jOO;
  private String jOP;
  private String jOQ;
  private String jOR;
  private String mSceneId;
  
  public a()
  {
    AppMethodBeat.i(35797);
    this.Gzy = new com.tencent.mm.sdk.b.c() {};
    this.Gzz = "";
    AppMethodBeat.o(35797);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35798);
    this.fsv = this.cOd.GzJ.getIntExtra("app_brand_chatting_from_scene", 1);
    this.Gzw = ((WxaExposedParams)this.cOd.GzJ.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bt.nullAsNil(this.cOd.GzJ.getStringExtra("key_scene_id"));
    ad.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.fsv), this.Gzw, this.mSceneId });
    this.jON = this.cOd.GzJ.getStringExtra("keyPrivateAppId");
    if (!bt.isNullOrNil(this.jON))
    {
      this.jOO = this.cOd.GzJ.getStringExtra("keyPrivateUserName");
      this.jOP = this.cOd.GzJ.getStringExtra("keyPrivateTitle");
      this.jOQ = this.cOd.GzJ.getStringExtra("keyPrivateSubTitle");
      this.jOR = this.cOd.GzJ.getStringExtra("keyPrivateHeadImage");
      ad.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.jON, this.jOO, this.jOP, this.jOQ, this.jOR });
    }
    this.appBrandServiceActionSheet = new d(this.cOd.GzJ.getContext());
    Object localObject = ((m)g.ab(m.class)).FW(this.cOd.getTalkerUserName());
    boolean bool;
    String str;
    b.a locala;
    avg localavg;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.Gzx = bool;
      str = this.cOd.getTalkerUserName();
      localObject = getAppId();
      locala = new b.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      localavg = new avg();
      str = e.aKe(str);
      if (!bt.isNullOrNil(str)) {
        break label418;
      }
      localavg.dlB = ((String)localObject);
    }
    for (localavg.DuI = "";; localavg.DuI = ((String)localObject))
    {
      locala.gUU = localavg;
      locala.gUV = new avh();
      x.a(locala.atI(), new e.2());
      AppMethodBeat.o(35798);
      return;
      bool = false;
      break;
      label418:
      localavg.dlB = e.Gh(str);
    }
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35799);
    this.Gzy.alive();
    AppMethodBeat.o(35799);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35800);
    this.Gzy.dead();
    AppMethodBeat.o(35800);
  }
  
  public final void eXQ()
  {
    AppMethodBeat.i(35801);
    ad.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    if (!bt.isNullOrNil(this.jOP))
    {
      this.cOd.GzJ.setMMTitle(this.jOP);
      if (bt.isNullOrNil(this.jOQ)) {
        break label115;
      }
      this.cOd.GzJ.setMMSubTitle(this.jOQ);
    }
    for (;;)
    {
      if (!this.Gzx) {
        break label206;
      }
      ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).YM(0);
      AppMethodBeat.o(35801);
      return;
      this.cOd.GzJ.setMMTitle(this.cOd.eWM());
      break;
      label115:
      this.Gzz = e.aKf(e.aKe(this.cOd.getTalkerUserName()));
      if (bt.isNullOrNil(this.Gzz)) {
        this.cOd.GzJ.setMMSubTitle(2131755654);
      } else {
        this.cOd.GzJ.setMMSubTitle(aj.getContext().getString(2131755654) + "-" + this.Gzz);
      }
    }
    label206:
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).YM(8);
    AppMethodBeat.o(35801);
  }
  
  public final void eYU()
  {
    AppMethodBeat.i(35802);
    this.cOd.GzJ.addIconOptionMenu(0, 2131755533, 2131690603, new com.tencent.mm.ui.w()
    {
      public final void VR()
      {
        AppMethodBeat.i(35796);
        a.this.cOd.hideVKB();
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35795);
            String str2 = e.aKe(a.this.cOd.getTalkerUserName());
            String str1;
            if (bt.isNullOrNil(str2))
            {
              str2 = a.this.cOd.getTalkerUserName();
              if (bt.isNullOrNil(a.this.cOd.eWM())) {
                str1 = e.aKf(a.this.cOd.getTalkerUserName());
              }
            }
            for (;;)
            {
              a.b(a.this).username = a.this.cOd.getTalkerUserName();
              a.b(a.this).mlE = false;
              a.b(a.this).scene = a.c(a.this);
              a.b(a.this).FTO = a.d(a.this);
              if ((a.c(a.this) == 3) && (TextUtils.isEmpty(a.e(a.this).nickname))) {
                a.e(a.this).nickname = str1;
              }
              if ((a.c(a.this) != 2) && (a.c(a.this) != 3)) {
                break label341;
              }
              a.b(a.this).lBG = a.e(a.this);
              if (!a.a(a.this)) {
                break;
              }
              a.b(a.this).show(1);
              AppMethodBeat.o(35795);
              return;
              str1 = a.this.cOd.eWM();
              continue;
              str1 = e.aKf(str2);
            }
            a.b(a.this).show(2);
            AppMethodBeat.o(35795);
            return;
            label341:
            WxaExposedParams.a locala = new WxaExposedParams.a();
            locala.appId = e.Gh(str2);
            locala.from = 4;
            locala.username = str2;
            locala.nickname = str1;
            a.b(a.this).lBG = locala.aTV();
            a.b(a.this).appId = a.this.getAppId();
            if (a.a(a.this))
            {
              a.b(a.this).show(5);
              AppMethodBeat.o(35795);
              return;
            }
            a.b(a.this).show(6);
            AppMethodBeat.o(35795);
          }
        });
        AppMethodBeat.o(35796);
      }
    });
    AppMethodBeat.o(35802);
  }
  
  public final String eYV()
  {
    return this.jOR;
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(35803);
    if (!bt.isNullOrNil(this.jON)) {
      this.appId = this.jON;
    }
    if (bt.isNullOrNil(this.appId))
    {
      localObject = ((m)g.ab(m.class)).FW(this.cOd.getTalkerUserName());
      if (localObject != null) {
        break label97;
      }
    }
    label97:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.a
 * JD-Core Version:    0.7.0.1
 */