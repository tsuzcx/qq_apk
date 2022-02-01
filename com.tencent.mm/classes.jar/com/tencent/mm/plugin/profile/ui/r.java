package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;

public final class r
{
  public static b[] a(Context paramContext, au paramau, int paramInt)
  {
    AppMethodBeat.i(27228);
    String str = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.contact.d.rs(paramau.field_type))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(27228);
      return null;
    }
    Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramContext = b.a(paramContext, com.tencent.mm.modelverify.d.bNJ().byp(paramau.field_username));
    }
    while ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(27228);
      return null;
      if (br.vj(paramInt))
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramContext = b.a(paramContext, com.tencent.mm.modelverify.d.bNK().byO(paramau.field_username));
      }
      else
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramContext = b.a(paramContext, com.tencent.mm.modelverify.d.bNH().bym(paramau.field_username));
      }
    }
    AppMethodBeat.o(27228);
    return paramContext;
  }
  
  public static String b(Context paramContext, au paramau, int paramInt)
  {
    AppMethodBeat.i(27229);
    paramContext = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    if (com.tencent.mm.contact.d.rs(paramau.field_type))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    if (Util.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(27229);
      return null;
    }
    paramContext = "";
    Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(paramInt)));
    if (paramInt == 18)
    {
      Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
      paramau = com.tencent.mm.modelverify.d.bNJ().byp(paramau.field_username);
      if (paramau.length > 0) {
        paramContext = paramau[0].field_svrid;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27229);
      return paramContext;
      if (br.vj(paramInt))
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
        paramau = com.tencent.mm.modelverify.d.bNK().byO(paramau.field_username);
        if (paramau.length > 0) {
          paramContext = paramau[0].field_svrid;
        }
      }
      else
      {
        Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
        paramau = com.tencent.mm.modelverify.d.bNH().bym(paramau.field_username);
        if (paramau.length > 0) {
          paramContext = paramau[0].field_svrId;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.r
 * JD-Core Version:    0.7.0.1
 */