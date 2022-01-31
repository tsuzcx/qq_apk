package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class d$4
  implements d.a
{
  d$4(ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    y.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((this.rSB != null) && (this.rSB.isShowing())) {
      this.rSB.dismiss();
    }
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof aa)))
    {
      paramString = ((aa)paramm).QR();
      if ((paramString != null) && (this.val$context != null)) {
        s.makeText(this.val$context, this.val$context.getString(R.l.app_tip) + " : " + bk.pm(paramString.tOY), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.4
 * JD-Core Version:    0.7.0.1
 */