package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class u
  implements f
{
  Context context;
  com.tencent.mm.ui.base.p mOt;
  private ap pDa;
  j qBT;
  private String vUA;
  
  public u(Context paramContext)
  {
    AppMethodBeat.i(27723);
    this.pDa = new ap(new u.1(this), false);
    this.context = paramContext;
    AppMethodBeat.o(27723);
  }
  
  private void amr(String paramString)
  {
    AppMethodBeat.i(27725);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(2131298715, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    AppMethodBeat.o(27725);
  }
  
  public final void amq(String paramString)
  {
    AppMethodBeat.i(27724);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(27724);
      return;
    }
    this.vUA = paramString;
    aw.aaz();
    String str1 = (String)c.Ru().get(46, null);
    aw.aaz();
    String str2 = bo.nullAsNil((String)c.Ru().get(72, null));
    ab.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)))
    {
      amr(paramString);
      AppMethodBeat.o(27724);
      return;
    }
    aw.Rc().a(233, this);
    this.qBT = new j(com.tencent.mm.a.p.cU(paramString), (int)System.currentTimeMillis());
    aw.Rc().a(this.qBT, 0);
    this.pDa.ag(3000L, 3000L);
    AppMethodBeat.o(27724);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(27726);
    this.pDa.stopTimer();
    if (this.mOt != null) {
      this.mOt.dismiss();
    }
    aw.Rc().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (j)paramm;
      paramm = paramString.ajl();
      if ((paramm == null) || (paramm.length() == 0))
      {
        amr(this.vUA);
        AppMethodBeat.o(27726);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramm);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.ajt());
      d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(27726);
      return;
    }
    ab.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    amr(this.vUA);
    AppMethodBeat.o(27726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u
 * JD-Core Version:    0.7.0.1
 */