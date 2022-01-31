package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.hc.a;
import com.tencent.mm.h.a.lu;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  extends c<hc>
{
  k$1(k paramk)
  {
    this.udX = hc.class.getName().hashCode();
  }
  
  private boolean a(hc paramhc)
  {
    int i = 0;
    this.qLt.qLo = paramhc;
    Object localObject1 = this.qLt.qLo.bOW.result;
    if (this.qLt.qLo.bOW.bOY != null) {
      this.qLt.qLn = this.qLt.qLo.bOW.bOY.getInt("pay_channel", 0);
    }
    Object localObject2;
    switch (this.qLt.qLo.bOW.actionCode)
    {
    default: 
      return false;
    case 12: 
      k localk = this.qLt;
      y.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + (String)localObject1);
      String[] arrayOfString = ((String)localObject1).replace("http://p.weixin.qq.com?", "").split("&");
      int j = arrayOfString.length;
      localObject2 = null;
      paramhc = null;
      localObject1 = null;
      if (i < j)
      {
        String str = arrayOfString[i];
        Object localObject4;
        Object localObject3;
        if (str.startsWith("errcode="))
        {
          localObject4 = str.replace("errcode=", "");
          localObject3 = paramhc;
        }
        for (;;)
        {
          i += 1;
          paramhc = (hc)localObject3;
          localObject1 = localObject4;
          break;
          if (str.startsWith("errmsg="))
          {
            localObject3 = str.replace("errmsg=", "");
            localObject4 = localObject1;
          }
          else
          {
            localObject3 = paramhc;
            localObject4 = localObject1;
            if (str.startsWith("importkey="))
            {
              localObject2 = str.replace("importkey=", "");
              localObject3 = paramhc;
              localObject4 = localObject1;
            }
          }
        }
      }
      if (("0".equals(localObject1)) && (!bk.bl((String)localObject2)))
      {
        paramhc = localk.qLo.bOW.context;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_import_key", (String)localObject2);
        ((Intent)localObject1).putExtra("key_bind_scene", 2);
        ((Intent)localObject1).putExtra("key_custom_bind_tips", null);
        d.b(paramhc, "wallet", ".bind.ui.WalletBindUI", (Intent)localObject1);
        if (localk.qLo.bFJ != null)
        {
          localk.qLo.bOX.ret = 1;
          localk.qLo.bFJ.run();
        }
      }
      for (;;)
      {
        return true;
        localObject1 = paramhc;
        if (bk.bl(paramhc)) {
          localObject1 = localk.qLo.bOW.context.getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(localk.qLo.bOW.context, (String)localObject1, "", new k.6(localk));
      }
    }
    a.udP.c(this.qLt);
    y.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + (String)localObject1);
    if (localObject1 != null)
    {
      if (((String)localObject1).startsWith("weixin://wxpay")) {
        if (bl.csf())
        {
          y.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
          localObject2 = new lu();
          ((lu)localObject2).bUP.url = ((String)localObject1);
          ((lu)localObject2).bUP.scene = 4;
          ((lu)localObject2).bUP.bUR = 12;
          ((lu)localObject2).bUP.bIl = 0;
          ((lu)localObject2).bUP.aWf = "";
          ((lu)localObject2).bUP.context = paramhc.bOW.context;
          k.a(this.qLt, (lu)localObject2);
          Toast.makeText(paramhc.bOW.context, "click to do pay test", 1).show();
        }
      }
      for (;;)
      {
        return true;
        this.qLt.qLm = 4;
        g.DQ();
        g.DO().dJT.a(233, this.qLt);
        paramhc = new com.tencent.mm.modelsimple.h((String)localObject1, this.qLt.qLo.bOW.username, 4, 0, (int)System.currentTimeMillis(), new byte[0]);
        g.DQ();
        g.DO().dJT.a(paramhc, 0);
        this.qLt.qLq = System.currentTimeMillis();
        continue;
        this.qLt.qLm = 1;
        k.a(this.qLt, (String)localObject1, this.qLt.qLn);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.k.1
 * JD-Core Version:    0.7.0.1
 */