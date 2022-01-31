package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  implements f
{
  Context context;
  com.tencent.mm.ui.base.p ksE;
  am mZu = new am(new am.a()
  {
    public final boolean tC()
    {
      r localr = r.this;
      Context localContext = r.this.context;
      r.this.context.getString(R.l.app_tip);
      localr.ksE = com.tencent.mm.ui.base.h.b(localContext, r.this.context.getString(R.l.app_waiting), true, new r.1.1(this));
      return false;
    }
  }, false);
  com.tencent.mm.modelsimple.h nOj;
  String url;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
  }
  
  final void c(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("geta8key_session_id", paramInt);
    localIntent.putExtra("geta8key_cookie", paramArrayOfByte);
    b.eUR.j(localIntent, this.context);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    this.mZu.stopTimer();
    if (this.ksE != null) {
      this.ksE.dismiss();
    }
    au.Dk().b(233, this);
    paramString = (com.tencent.mm.modelsimple.h)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = paramString.Qf();
      if ((paramm == null) || (paramm.length() == 0))
      {
        c(this.url, paramString.Qn(), paramString.Qo());
        return;
      }
      c(paramm, paramString.Qn(), paramString.Qo());
      return;
    }
    y.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    c(this.url, paramString.Qn(), paramString.Qo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.r
 * JD-Core Version:    0.7.0.1
 */