package com.tencent.mm.ui.chatting.c.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.appbrand.b.2;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;

public final class a
  extends c
{
  private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
  private String appId;
  private int ejF;
  private String hKL;
  private String hKM;
  private String hKN;
  private String hKO;
  private String hKP;
  private String mSceneId;
  private WxaExposedParams zJn;
  private boolean zJo;
  private com.tencent.mm.sdk.b.c<lt> zJp;
  private String zJq;
  
  public a()
  {
    AppMethodBeat.i(31891);
    this.zJp = new a.1(this);
    this.zJq = "";
    AppMethodBeat.o(31891);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31892);
    this.ejF = this.caz.zJz.getIntExtra("app_brand_chatting_from_scene", 1);
    this.zJn = ((WxaExposedParams)this.caz.zJz.getParcelableExtra("app_brand_chatting_expose_params"));
    this.mSceneId = bo.nullAsNil(this.caz.zJz.getStringExtra("key_scene_id"));
    ab.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", new Object[] { Integer.valueOf(this.ejF), this.zJn, this.mSceneId });
    this.hKL = this.caz.zJz.getStringExtra("keyPrivateAppId");
    if (!bo.isNullOrNil(this.hKL))
    {
      this.hKM = this.caz.zJz.getStringExtra("keyPrivateUserName");
      this.hKN = this.caz.zJz.getStringExtra("keyPrivateTitle");
      this.hKO = this.caz.zJz.getStringExtra("keyPrivateSubTitle");
      this.hKP = this.caz.zJz.getStringExtra("keyPrivateHeadImage");
      ab.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", new Object[] { this.hKL, this.hKM, this.hKN, this.hKO, this.hKP });
    }
    this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(this.caz.zJz.getContext());
    Object localObject = ((i)g.E(i.class)).Ae(this.caz.getTalkerUserName());
    boolean bool;
    String str;
    b.a locala;
    alq localalq;
    if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
    {
      bool = true;
      this.zJo = bool;
      str = this.caz.getTalkerUserName();
      localObject = getAppId();
      locala = new b.a();
      locala.funcId = 2912;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      localalq = new alq();
      str = b.ats(str);
      if (!bo.isNullOrNil(str)) {
        break label420;
      }
      localalq.cwc = ((String)localObject);
    }
    for (localalq.xcp = "";; localalq.xcp = ((String)localObject))
    {
      locala.fsX = localalq;
      locala.fsY = new alr();
      w.a(locala.ado(), new b.2());
      AppMethodBeat.o(31892);
      return;
      bool = false;
      break;
      label420:
      localalq.cwc = b.Aq(str);
    }
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31893);
    this.zJp.alive();
    AppMethodBeat.o(31893);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31894);
    this.zJp.dead();
    AppMethodBeat.o(31894);
  }
  
  public final void dIv()
  {
    AppMethodBeat.i(31895);
    ab.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
    if (!bo.isNullOrNil(this.hKN))
    {
      this.caz.zJz.setMMTitle(this.hKN);
      if (bo.isNullOrNil(this.hKO)) {
        break label115;
      }
      this.caz.zJz.setMMSubTitle(this.hKO);
    }
    for (;;)
    {
      if (!this.zJo) {
        break label206;
      }
      ((r)this.caz.ay(r.class)).PF(0);
      AppMethodBeat.o(31895);
      return;
      this.caz.zJz.setMMTitle(this.caz.dHF());
      break;
      label115:
      this.zJq = b.att(b.ats(this.caz.getTalkerUserName()));
      if (bo.isNullOrNil(this.zJq)) {
        this.caz.zJz.setMMSubTitle(2131296854);
      } else {
        this.caz.zJz.setMMSubTitle(ah.getContext().getString(2131296854) + "-" + this.zJq);
      }
    }
    label206:
    ((r)this.caz.ay(r.class)).PF(8);
    AppMethodBeat.o(31895);
  }
  
  public final String dJA()
  {
    return this.hKP;
  }
  
  public final void dJz()
  {
    AppMethodBeat.i(31896);
    this.caz.zJz.addIconOptionMenu(0, 2131296748, 2130839668, new a.2(this));
    AppMethodBeat.o(31896);
  }
  
  protected final String getAppId()
  {
    AppMethodBeat.i(31897);
    if (!bo.isNullOrNil(this.hKL)) {
      this.appId = this.hKL;
    }
    if (bo.isNullOrNil(this.appId))
    {
      localObject = ((i)g.E(i.class)).Ae(this.caz.getTalkerUserName());
      if (localObject != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = ((WxaAttributes)localObject).field_appId)
    {
      this.appId = ((String)localObject);
      if (bo.isNullOrNil(this.appId)) {
        ab.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
      }
      localObject = this.appId;
      AppMethodBeat.o(31897);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.a
 * JD-Core Version:    0.7.0.1
 */