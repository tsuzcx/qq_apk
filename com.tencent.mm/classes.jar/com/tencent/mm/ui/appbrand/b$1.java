package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class b$1
  implements f
{
  b$1(Context paramContext, String paramString, boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    au.Dk().b(1176, this);
    y.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(true) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.makeText(this.val$context, R.l.notify_message_settings_operation_failed, 0).show();
      paramString = new su();
      paramString.ccq.bFn = this.dol;
      paramm = paramString.ccq;
      paramInt1 = i;
      if (!this.uRL) {
        paramInt1 = 2;
      }
      paramm.action = paramInt1;
      paramString.ccq.ccs = 2;
      a.udP.m(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b.1
 * JD-Core Version:    0.7.0.1
 */