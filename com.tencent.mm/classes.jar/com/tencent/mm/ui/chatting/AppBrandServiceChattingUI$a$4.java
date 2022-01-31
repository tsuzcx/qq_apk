package com.tencent.mm.ui.chatting;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandServiceChattingUI$a$4
  implements w.a
{
  AppBrandServiceChattingUI$a$4(AppBrandServiceChattingUI.a parama) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.AppBrandServiceChattingUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (agw)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.ter != null))
    {
      paramb = new StringBuilder();
      paramm = paramString.ter.iterator();
      while (paramm.hasNext())
      {
        String str = (String)paramm.next();
        paramb.append(str + "|");
      }
      y.d("MicroMsg.AppBrandServiceChattingUI", "block_qr_prefix:%s, size:%d", new Object[] { paramb.toString(), Integer.valueOf(paramString.ter.size()) });
      g.DP().Dz().c(ac.a.utn, paramb.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.4
 * JD-Core Version:    0.7.0.1
 */