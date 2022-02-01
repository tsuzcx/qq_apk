package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;

public final class p
{
  public static com.tencent.mm.pluginsdk.ui.preference.b[] a(Context paramContext, af paramaf, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.n.b.ls(paramaf.field_type))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    ad.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aCp().aIL(paramaf.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (com.tencent.mm.model.bi.nj(paramInt))
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aCq().aJk(paramaf.field_username));
      }
      else
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aCn().aII(paramaf.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, af paramaf, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.n.b.ls(paramaf.field_type))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    if (bt.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    paramContext = "";
    ad.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramaf = d.aCp().aIL(paramaf.field_username);
      if (paramaf.length > 0) {
        paramContext = paramaf[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (com.tencent.mm.model.bi.nj(paramInt))
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramaf = d.aCq().aJk(paramaf.field_username);
        if (paramaf.length > 0) {
          paramContext = paramaf[0].field_svrid;
        }
      }
      else
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramaf = d.aCn().aII(paramaf.field_username);
        if (paramaf.length > 0) {
          paramContext = paramaf[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */