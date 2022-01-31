package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cjn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.IOException;

public final class g
  extends b
{
  private bi bWO;
  
  public g(bi parambi)
  {
    this.bWO = parambi;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    cjn localcjn = new cjn();
    Object localObject = this.bWO.field_content;
    if (localObject != null)
    {
      localObject = g.a.M((String)localObject, this.bWO.field_reserved);
      if ((localObject == null) || (!((g.a)localObject).dSi.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label219;
      }
      localcjn.tXq = this.bWO.field_msgId;
      localcjn.tXp = this.bWO.field_talker;
      if (this.bWO.field_isSend != 1) {
        break label203;
      }
      localObject = ((g.a)localObject).dSc;
      localcjn.bGw = h.Rj(this.bWO.field_talker);
      if (!s.fn(this.bWO.field_talker)) {
        break label211;
      }
      String str = c(this.bWO.field_talker, this.bWO);
      localcjn.kVs = String.format(ae.getContext().getString(R.l.notification_msg_chatroom_template), new Object[] { h.Rj(str), Character.valueOf('​'), localObject });
    }
    for (;;)
    {
      label203:
      label211:
      label219:
      try
      {
        com.tencent.mm.plugin.wear.model.a.bYL();
        r.b(20014, localcjn.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.ez(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.Bf(10);
        return;
      }
      catch (IOException localIOException) {}
      y.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      return;
      localObject = ((g.a)localObject).dSb;
      break;
      localcjn.kVs = ((String)localObject);
      continue;
      y.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */