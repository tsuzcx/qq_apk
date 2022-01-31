package com.tencent.mm.plugin.v;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Map;

public final class a
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    y.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new m(paramMap, paramString1, paramString2, paramInt, parama);
    g.DQ();
    g.DO().dJT.a(paramMap, 0);
  }
  
  public final bdd bkn()
  {
    return i.bkn();
  }
  
  public final Typeface dO(Context paramContext)
  {
    return e.dO(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a
 * JD-Core Version:    0.7.0.1
 */