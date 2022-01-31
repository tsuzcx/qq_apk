package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;

public final class p
{
  public static b[] a(Context paramContext, ad paramad, int paramInt)
  {
    AppMethodBeat.i(23613);
    String str = bo.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (a.je(paramad.field_type))
    {
      AppMethodBeat.o(23613);
      return null;
    }
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(23613);
      return null;
    }
    ab.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = b.a(paramContext, d.alj().asg(paramad.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(23613);
      return null;
      if (com.tencent.mm.model.bf.kD(paramInt))
      {
        ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = b.a(paramContext, d.alk().asF(paramad.field_username));
      }
      else
      {
        ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = b.a(paramContext, d.alh().asc(paramad.field_username));
      }
    }
    AppMethodBeat.o(23613);
    return paramContext;
  }
  
  public static String b(Context paramContext, ad paramad, int paramInt)
  {
    AppMethodBeat.i(23614);
    paramContext = bo.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (a.je(paramad.field_type))
    {
      AppMethodBeat.o(23614);
      return null;
    }
    if (bo.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(23614);
      return null;
    }
    paramContext = "";
    ab.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramad = d.alj().asg(paramad.field_username);
      if (paramad.length > 0) {
        paramContext = paramad[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23614);
      return paramContext;
      if (com.tencent.mm.model.bf.kD(paramInt))
      {
        ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramad = d.alk().asF(paramad.field_username);
        if (paramad.length > 0) {
          paramContext = paramad[0].field_svrid;
        }
      }
      else
      {
        ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramad = d.alh().asc(paramad.field_username);
        if (paramad.length > 0) {
          paramContext = paramad[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */