package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.h;

final class l$1
  extends c<hf>
{
  l$1(l paraml)
  {
    AppMethodBeat.i(48195);
    this.__eventId = hf.class.getName().hashCode();
    AppMethodBeat.o(48195);
  }
  
  private boolean a(hf paramhf)
  {
    int i = 0;
    AppMethodBeat.i(48196);
    this.uAp.uAl = paramhf;
    Object localObject1 = this.uAp.uAl.cwn.result;
    if (this.uAp.uAl.cwn.cwp != null) {
      this.uAp.uAk = this.uAp.uAl.cwn.cwp.getInt("pay_channel", 0);
    }
    Object localObject2;
    switch (this.uAp.uAl.cwn.actionCode)
    {
    default: 
      AppMethodBeat.o(48196);
      return false;
    case 12: 
      l locall = this.uAp;
      ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = ".concat(String.valueOf(localObject1)));
      String[] arrayOfString = ((String)localObject1).replace("http://p.weixin.qq.com?", "").split("&");
      int j = arrayOfString.length;
      localObject2 = null;
      paramhf = null;
      localObject1 = null;
      if (i < j)
      {
        String str = arrayOfString[i];
        Object localObject4;
        Object localObject3;
        if (str.startsWith("errcode="))
        {
          localObject4 = str.replace("errcode=", "");
          localObject3 = paramhf;
        }
        for (;;)
        {
          i += 1;
          paramhf = (hf)localObject3;
          localObject1 = localObject4;
          break;
          if (str.startsWith("errmsg="))
          {
            localObject3 = str.replace("errmsg=", "");
            localObject4 = localObject1;
          }
          else
          {
            localObject3 = paramhf;
            localObject4 = localObject1;
            if (str.startsWith("importkey="))
            {
              localObject2 = str.replace("importkey=", "");
              localObject3 = paramhf;
              localObject4 = localObject1;
            }
          }
        }
      }
      if (("0".equals(localObject1)) && (!bo.isNullOrNil((String)localObject2)))
      {
        paramhf = locall.uAl.cwn.context;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
        ((Intent)localObject1).putExtra("key_bind_scene", 2);
        ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
        d.b(paramhf, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
        if (locall.uAl.callback != null)
        {
          locall.uAl.cwo.ret = 1;
          locall.uAl.callback.run();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48196);
        return true;
        localObject1 = paramhf;
        if (bo.isNullOrNil(paramhf)) {
          localObject1 = locall.uAl.cwn.context.getString(2131305682);
        }
        h.a(locall.uAl.cwn.context, (String)localObject1, "", new l.7(locall));
      }
    }
    a.ymk.c(this.uAp);
    ab.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = ".concat(String.valueOf(localObject1)));
    if (localObject1 != null)
    {
      if (((String)localObject1).startsWith("weixin://wxpay")) {
        if (bp.dud())
        {
          ab.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
          localObject2 = new mk();
          ((mk)localObject2).cCw.url = ((String)localObject1);
          ((mk)localObject2).cCw.scene = 4;
          ((mk)localObject2).cCw.cCy = 12;
          ((mk)localObject2).cCw.cpG = 0;
          ((mk)localObject2).cCw.source = "";
          ((mk)localObject2).cCw.context = paramhf.cwn.context;
          l.a(this.uAp, (mk)localObject2);
          Toast.makeText(paramhf.cwn.context, "click to do pay test", 1).show();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48196);
        return true;
        this.uAp.uAj = 4;
        g.RM();
        g.RK().eHt.a(233, this.uAp);
        paramhf = new j((String)localObject1, this.uAp.uAl.cwn.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
        g.RM();
        g.RK().eHt.a(paramhf, 0);
        this.uAp.mRequestTime = System.currentTimeMillis();
        continue;
        this.uAp.uAj = 1;
        l.a(this.uAp, (String)localObject1, this.uAp.uAk);
      }
    }
    AppMethodBeat.o(48196);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.l.1
 * JD-Core Version:    0.7.0.1
 */