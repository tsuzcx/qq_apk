package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;

public final class p
{
  public static b[] a(Context paramContext, an paraman, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = bu.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (c.lO(paraman.field_type))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    ae.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = b.a(paramContext, d.aMN().aVz(paraman.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (bl.oA(paramInt))
      {
        ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = b.a(paramContext, d.aMO().aVY(paraman.field_username));
      }
      else
      {
        ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = b.a(paramContext, d.aML().aVw(paraman.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, an paraman, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = bu.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (c.lO(paraman.field_type))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    if (bu.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    paramContext = "";
    ae.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paraman = d.aMN().aVz(paraman.field_username);
      if (paraman.length > 0) {
        paramContext = paraman[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (bl.oA(paramInt))
      {
        ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paraman = d.aMO().aVY(paraman.field_username);
        if (paraman.length > 0) {
          paramContext = paraman[0].field_svrid;
        }
      }
      else
      {
        ae.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paraman = d.aML().aVw(paraman.field_username);
        if (paraman.length > 0) {
          paramContext = paraman[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */