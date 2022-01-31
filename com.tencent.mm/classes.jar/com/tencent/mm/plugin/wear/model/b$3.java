package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements m.b
{
  b$3(b paramb) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      do
      {
        return;
        paramm = (String)paramObject;
      } while ((paramm == null) || (!paramm.equals("gh_43f2581f6fd6")));
      if ((!b.bYM()) && (this.qRH.qRE))
      {
        this.qRH.qRE = false;
        return;
      }
    } while ((!b.bYM()) || (this.qRH.qRE));
    this.qRH.connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.3
 * JD-Core Version:    0.7.0.1
 */