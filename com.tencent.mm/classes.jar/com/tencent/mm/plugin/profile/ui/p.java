package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class p
{
  public static com.tencent.mm.pluginsdk.ui.preference.b[] a(Context paramContext, ai paramai, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = bs.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.n.b.ln(paramai.field_type))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    ac.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aJf().aOh(paramai.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (bi.nX(paramInt))
      {
        ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aJg().aOG(paramai.field_username));
      }
      else
      {
        ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = com.tencent.mm.pluginsdk.ui.preference.b.a(paramContext, d.aJd().aOe(paramai.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, ai paramai, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = bs.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.n.b.ln(paramai.field_type))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    if (bs.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    paramContext = "";
    ac.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramai = d.aJf().aOh(paramai.field_username);
      if (paramai.length > 0) {
        paramContext = paramai[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (bi.nX(paramInt))
      {
        ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramai = d.aJg().aOG(paramai.field_username);
        if (paramai.length > 0) {
          paramContext = paramai[0].field_svrid;
        }
      }
      else
      {
        ac.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramai = d.aJd().aOe(paramai.field_username);
        if (paramai.length > 0) {
          paramContext = paramai[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */