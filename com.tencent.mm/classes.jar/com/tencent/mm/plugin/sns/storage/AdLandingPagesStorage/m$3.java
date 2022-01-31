package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.ahq;
import java.util.Map;

final class m$3
  implements w.a
{
  m$3(m paramm, String paramString, int paramInt, x paramx) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.y.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { this.oLh, Integer.valueOf(this.oLf), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    do
    {
      return 0;
      paramString = ((ahq)paramb.ecF.ecN).tff.coM();
      com.tencent.mm.sdk.platformtools.y.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { this.oLh, paramString });
    } while (TextUtils.isEmpty(paramString));
    m.d(this.oLd).put(this.oLh, paramString);
    this.oLi.field_canvasXml = paramString;
    m.e(this.oLd).a(this.oLi);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.3
 * JD-Core Version:    0.7.0.1
 */