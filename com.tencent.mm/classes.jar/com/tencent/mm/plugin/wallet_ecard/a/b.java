package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, c.a parama)
  {
    y.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bk.bl(paramString1)), paramString2, paramString3 });
    Bundle localBundle = new Bundle();
    localBundle.putInt(a.qJR, paramInt);
    localBundle.putString(a.qJS, paramString1);
    localBundle.putString(a.qJW, paramString2);
    localBundle.putString(a.qJX, paramString3);
    com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_ecard.b.b.class, localBundle, parama);
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, m paramm, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      y.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 });
      return com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramm, 1000, paramInt1, paramString1);
      paramInt1 = paramInt2;
      paramString1 = paramString2;
    }
  }
  
  public static boolean a(final WalletBaseUI paramWalletBaseUI, bez parambez)
  {
    if (parambez == null) {
      y.i("MicroMsg.ECardUtil", "no popItem");
    }
    do
    {
      do
      {
        return false;
      } while (bk.bl(parambez.tzM));
      if ((!bk.bl(parambez.qlZ)) && (!bk.bl(parambez.tzN)))
      {
        y.i("MicroMsg.ECardUtil", "show guide info 1");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, parambez.tzM, "", parambez.qlZ, parambez.tzN, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            WalletBaseUI localWalletBaseUI;
            String str;
            Object localObject;
            if (!bk.bl(this.qKo.sQT))
            {
              localWalletBaseUI = paramWalletBaseUI;
              str = this.qKo.sQT;
              localObject = this.qKq;
              y.i("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
              if (!bk.bl(str))
              {
                if (!str.startsWith("native.")) {
                  break label136;
                }
                y.i("MicroMsg.ECardUtil", "goto native");
                if (((localObject != null) && (((b.a)localObject).bXv())) || (str.equals("native.qryacctdesc")) || (str.equals("native.openecardauth")) || (str.equals("native.cancloseecard")) || (!str.equals("native.withdraw"))) {}
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              return;
              label136:
              y.d("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("showShare", false);
              d.b(localWalletBaseUI, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            c localc;
            if (this.qKo.tjw == a.qJN)
            {
              y.i("MicroMsg.ECardUtil", "do end process");
              localc = paramWalletBaseUI.cNj();
              if (localc != null) {
                localc.b(paramWalletBaseUI, new Bundle());
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              return;
              paramWalletBaseUI.finish();
              continue;
              if (this.qKo.tjw == a.qJQ)
              {
                y.i("MicroMsg.ECardUtil", "back bank list");
                localc = paramWalletBaseUI.cNj();
                if (localc != null) {
                  localc.b(paramWalletBaseUI, 100);
                } else {
                  paramWalletBaseUI.finish();
                }
              }
            }
          }
        });
        return true;
      }
    } while (bk.bl(parambez.tzN));
    y.i("MicroMsg.ECardUtil", "show guide info 2");
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, parambez.tzM, "", parambez.tzN, false, new b.3(parambez, paramWalletBaseUI));
    return true;
  }
  
  public static String d(Context paramContext, String... paramVarArgs)
  {
    paramContext = paramContext.getString(a.i.wallet_unknown_err);
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (!bk.bl(str)) {
          return str;
        }
        i += 1;
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b
 * JD-Core Version:    0.7.0.1
 */