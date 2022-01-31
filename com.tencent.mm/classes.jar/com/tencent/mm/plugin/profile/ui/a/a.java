package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  implements f
{
  Activity cup;
  com.tencent.mm.ui.base.p mOt;
  b pCZ;
  private ap pDa;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(23797);
    this.pDa = new ap(new a.1(this), false);
    this.cup = paramActivity;
    AppMethodBeat.o(23797);
  }
  
  private void Xi(String paramString)
  {
    AppMethodBeat.i(23800);
    this.pDa.stopTimer();
    if (this.mOt != null) {
      this.mOt.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.cup.getString(2131298834));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    d.b(this.cup, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(23800);
  }
  
  public final void fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23798);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(23798);
      return;
    }
    aw.Rc().a(205, this);
    this.pCZ = new b(bo.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    aw.Rc().a(this.pCZ, 0);
    this.pDa.ag(3000L, 3000L);
    AppMethodBeat.o(23798);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(23799);
    aw.Rc().b(205, this);
    paramString = (b)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Xi(paramString.getURL());
      AppMethodBeat.o(23799);
      return;
    }
    if (paramInt1 != 4) {
      ab.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    Xi("http://t.qq.com/" + paramString.pxO);
    AppMethodBeat.o(23799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */