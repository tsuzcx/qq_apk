package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

public final class b
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, e.a parama)
  {
    AppMethodBeat.i(71687);
    Log.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(Util.isNullOrNil(paramString1)), paramString2, paramString3 });
    Bundle localBundle = new Bundle();
    localBundle.putInt(a.VYM, paramInt);
    localBundle.putString(a.VYN, paramString1);
    localBundle.putString(a.VYR, paramString2);
    localBundle.putString(a.VYS, paramString3);
    com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_ecard.b.b.class, localBundle, parama);
    AppMethodBeat.o(71687);
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, p paramp, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(71686);
    if (paramInt2 == 0) {
      paramString2 = paramString1;
    }
    for (;;)
    {
      Log.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramString2 });
      if (paramInt1 == 269293577)
      {
        k.a(paramWalletBaseUI, paramString1, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71686);
        return true;
      }
      boolean bool = h.a(paramWalletBaseUI, paramp, 1000, paramInt1, paramString2);
      AppMethodBeat.o(71686);
      return bool;
      paramInt1 = paramInt2;
    }
  }
  
  public static boolean a(final WalletBaseUI paramWalletBaseUI, eff parameff)
  {
    AppMethodBeat.i(71684);
    if (parameff == null) {
      Log.i("MicroMsg.ECardUtil", "no popItem");
    }
    do
    {
      do
      {
        AppMethodBeat.o(71684);
        return false;
      } while (Util.isNullOrNil(parameff.aawp));
      if ((!Util.isNullOrNil(parameff.VmH)) && (!Util.isNullOrNil(parameff.abkC)))
      {
        Log.i("MicroMsg.ECardUtil", "show guide info 1");
        k.a(paramWalletBaseUI, parameff.aawp, "", parameff.VmH, parameff.abkC, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71681);
            WalletBaseUI localWalletBaseUI;
            String str;
            Object localObject;
            if (!Util.isNullOrNil(b.this.Krl))
            {
              localWalletBaseUI = paramWalletBaseUI;
              str = b.this.Krl;
              localObject = this.VZm;
              Log.i("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
              if (!Util.isNullOrNil(str))
              {
                if (!str.startsWith("native.")) {
                  break label146;
                }
                Log.i("MicroMsg.ECardUtil", "goto native");
                if (((localObject != null) && (((b.a)localObject).imf())) || (str.equals("native.qryacctdesc")) || (str.equals("native.openecardauth")) || (str.equals("native.cancloseecard")) || (!str.equals("native.withdraw"))) {}
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(71681);
              return;
              label146:
              Log.d("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", str);
              ((Intent)localObject).putExtra("showShare", false);
              i.aS(localWalletBaseUI, (Intent)localObject);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71682);
            e locale;
            if (b.this.aaCD == a.VYI)
            {
              Log.i("MicroMsg.ECardUtil", "do end process");
              locale = paramWalletBaseUI.getProcess();
              if (locale != null) {
                locale.b(paramWalletBaseUI, new Bundle());
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(71682);
              return;
              paramWalletBaseUI.finish();
              continue;
              if (b.this.aaCD == a.VYL)
              {
                Log.i("MicroMsg.ECardUtil", "back bank list");
                locale = paramWalletBaseUI.getProcess();
                if (locale != null) {
                  locale.i(paramWalletBaseUI, 100);
                } else {
                  paramWalletBaseUI.finish();
                }
              }
            }
          }
        });
        AppMethodBeat.o(71684);
        return true;
      }
    } while (Util.isNullOrNil(parameff.abkC));
    Log.i("MicroMsg.ECardUtil", "show guide info 2");
    k.a(paramWalletBaseUI, parameff.aawp, "", parameff.abkC, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71683);
        e locale;
        if (b.this.aaCD == a.VYI)
        {
          Log.i("MicroMsg.ECardUtil", "do end process");
          locale = paramWalletBaseUI.getProcess();
          if (locale != null) {
            locale.b(paramWalletBaseUI, new Bundle());
          }
        }
        for (;;)
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(71683);
          return;
          paramWalletBaseUI.finish();
          continue;
          if (b.this.aaCD == a.VYL)
          {
            Log.i("MicroMsg.ECardUtil", "back bank list");
            locale = paramWalletBaseUI.getProcess();
            if (locale != null) {
              locale.i(paramWalletBaseUI, 100);
            } else {
              paramWalletBaseUI.finish();
            }
          }
        }
      }
    });
    AppMethodBeat.o(71684);
    return true;
  }
  
  public static String e(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(71685);
    paramContext = paramContext.getString(a.i.wallet_unknown_err);
    int i;
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      i = 0;
      if (i < j)
      {
        String str = paramVarArgs[i];
        if (!Util.isNullOrNil(str)) {
          paramContext = str;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71685);
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean imf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b
 * JD-Core Version:    0.7.0.1
 */