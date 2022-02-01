package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;

public final class p
{
  public static com.tencent.mm.pluginsdk.ui.preference.b[] a(Context paramContext, am paramam, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.o.b.lM(paramam.field_type))
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
      paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aMp().aTY(paramam.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (bj.ox(paramInt))
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aMq().aUx(paramam.field_username));
      }
      else
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aMn().aTV(paramam.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, am paramam, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.o.b.lM(paramam.field_type))
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
      paramam = d.aMp().aTY(paramam.field_username);
      if (paramam.length > 0) {
        paramContext = paramam[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (bj.ox(paramInt))
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramam = d.aMq().aUx(paramam.field_username);
        if (paramam.length > 0) {
          paramContext = paramam[0].field_svrid;
        }
      }
      else
      {
        ad.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramam = d.aMn().aTV(paramam.field_username);
        if (paramam.length > 0) {
          paramContext = paramam[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */