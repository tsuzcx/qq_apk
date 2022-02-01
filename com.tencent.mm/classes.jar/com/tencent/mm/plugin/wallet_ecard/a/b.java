package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public final class b
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, d.a parama)
  {
    AppMethodBeat.i(71687);
    Log.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(Util.isNullOrNil(paramString1)), paramString2, paramString3 });
    Bundle localBundle = new Bundle();
    localBundle.putInt(a.Ipq, paramInt);
    localBundle.putString(a.Ipr, paramString1);
    localBundle.putString(a.Ipv, paramString2);
    localBundle.putString(a.Ipw, paramString3);
    com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_ecard.b.b.class, localBundle, parama);
    AppMethodBeat.o(71687);
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, q paramq, int paramInt1, String paramString1, int paramInt2, String paramString2)
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
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString1, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71686);
        return true;
      }
      boolean bool = com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramq, 1000, paramInt1, paramString2);
      AppMethodBeat.o(71686);
      return bool;
      paramInt1 = paramInt2;
    }
  }
  
  public static boolean a(final WalletBaseUI paramWalletBaseUI, ddb paramddb)
  {
    AppMethodBeat.i(71684);
    if (paramddb == null) {
      Log.i("MicroMsg.ECardUtil", "no popItem");
    }
    do
    {
      do
      {
        AppMethodBeat.o(71684);
        return false;
      } while (Util.isNullOrNil(paramddb.LZw));
      if ((!Util.isNullOrNil(paramddb.HFD)) && (!Util.isNullOrNil(paramddb.MIh)))
      {
        Log.i("MicroMsg.ECardUtil", "show guide info 1");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramddb.LZw, "", paramddb.HFD, paramddb.MIh, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71681);
            WalletBaseUI localWalletBaseUI;
            String str;
            Object localObject;
            if (!Util.isNullOrNil(this.IpO.yUB))
            {
              localWalletBaseUI = paramWalletBaseUI;
              str = this.IpO.yUB;
              localObject = this.IpQ;
              Log.i("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
              if (!Util.isNullOrNil(str))
              {
                if (!str.startsWith("native.")) {
                  break label146;
                }
                Log.i("MicroMsg.ECardUtil", "goto native");
                if (((localObject != null) && (((b.a)localObject).fUk())) || (str.equals("native.qryacctdesc")) || (str.equals("native.openecardauth")) || (str.equals("native.cancloseecard")) || (!str.equals("native.withdraw"))) {}
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
              f.aA(localWalletBaseUI, (Intent)localObject);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71682);
            d locald;
            if (this.IpO.MeU == a.Ipm)
            {
              Log.i("MicroMsg.ECardUtil", "do end process");
              locald = paramWalletBaseUI.getProcess();
              if (locald != null) {
                locald.b(paramWalletBaseUI, new Bundle());
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(71682);
              return;
              paramWalletBaseUI.finish();
              continue;
              if (this.IpO.MeU == a.Ipp)
              {
                Log.i("MicroMsg.ECardUtil", "back bank list");
                locald = paramWalletBaseUI.getProcess();
                if (locald != null) {
                  locald.g(paramWalletBaseUI, 100);
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
    } while (Util.isNullOrNil(paramddb.MIh));
    Log.i("MicroMsg.ECardUtil", "show guide info 2");
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramddb.LZw, "", paramddb.MIh, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71683);
        d locald;
        if (this.IpO.MeU == a.Ipm)
        {
          Log.i("MicroMsg.ECardUtil", "do end process");
          locald = paramWalletBaseUI.getProcess();
          if (locald != null) {
            locald.b(paramWalletBaseUI, new Bundle());
          }
        }
        for (;;)
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(71683);
          return;
          paramWalletBaseUI.finish();
          continue;
          if (this.IpO.MeU == a.Ipp)
          {
            Log.i("MicroMsg.ECardUtil", "back bank list");
            locald = paramWalletBaseUI.getProcess();
            if (locald != null) {
              locald.g(paramWalletBaseUI, 100);
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
  
  public static String d(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(71685);
    paramContext = paramContext.getString(2131768354);
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
    public abstract boolean fUk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b
 * JD-Core Version:    0.7.0.1
 */